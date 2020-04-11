## Oracle SubQuery
> 추가정보를 제공할 목적으로 하나의 SQL 문장 내부에 존재하는 SELECT 문장을 말함
- DML에 속하는 모든 문장에서 서브쿼리를 사용할 수 있다.
- 서브쿼리는 SELECT문장에서 리스트로 올 수 있다(일반 서브쿼리)
    - FROM절에 올수 있다. (인라인 뷰)
    - WHERE절 (중첩 쿼리)에 올수 있다.
- 연산자의 오른쪽에 와야 한다.
- Order by를 사용할 수 없다.

### 서브쿼리 종류
- 연관성 없는 서브쿼리(NonCorrelated SubqQery)
    - 메인쿼리와 서브쿼리 사이에 데이터의 연관성이 없는 서브쿼리를 의미
    - 서브쿼리의 결과들은 메인쿼리와 독립적이다.
- 연관성 있는 서브쿼리(Correlated SubQuery) 
    - 서브쿼리가 위치하는 곳에 따라 달라진다.
    - 일반 서브쿼리 : **리스트**에 위치
    - 인라인 뷰 : **FROM**절에 위치
    - 중첩 쿼리 : **WHERE**절에 위치

### 연산자
- 단일행 연산자
    - =, >, <, >=, <=, <>, !=
- 다중행 연산자
    - IN : 메인쿼리의 비교 조건 ('=' 연산자로 비교할 경우)<br>이 서브쿼리의 결과 중에서 하나라도 일치하면 참 
    - ANY,SOME : 메인쿼리의 비교 조건이 서브쿼리의 검색결과와 <br>하나이상이 일치하면 참
    - ALL : 메인쿼리의 비교 조건이 서브쿼리의 검색 결과와 모든 값이 일치하면 참
    - EXIST : 메인쿼리의 비교조건이 서브쿼리의 결과 중에서 만족하는 값이<br> 하나라도 존재하면 참
    - NOT

    - ex:) 기본문법...<any(10 or 40 or 30 or 90)

### 단행 서브쿼리
> 오직 한개의 행(값)을 반환한다. 
- 단일 행연산자(=, >, <, >=, <=, <>, !=)만 사용 가능
### 다중행 서브쿼리
> 두개 이상의 행(값)을 반환한다.
- 다중행 연산자( in, > any, > all,...)사용
---
### SubQuery를 쓰면 안되는 경우
>SubQuery와 Join의 성능은 차이 없다. <br> 하지만 SubQuery를 쓰면 안되는 경우가 존재한다.

- SubQuery와 Join의 성능 차이가 없는 이유
    - SubQuery를 쓰든 Join으로 풀어서 짜든 어떤것이 유리한지<br>
     옵티마이저가 알아서 판단 후 실행기억을 작성해줌 (성능과 무관)
     - 실행기억을 확인하는 방법
        - SELECT * FROM TABLE(DBMS_XPLAN.DISPLAY_CURSOR(null,null,'ALLSTATS LAST'));
      
- SubQuery를 쓰면 안되는 경우 
    
    ```
    -- 1) SubQuery에 같은 테이블을 덧쓴 경우
    SELECT A.EMPLOYEE_ID,
           A.FIRST_NAME,
           A.LAST_NAME,
           A.SALARY
        FROM EMPLOYEES A
    WHERE A.SALARY = (SELECT MIN(SALARY) FROM EMPLOYEES)
        OR A.SALARY = (SELECT MAX(SALARY) FROM EMPLOYEES);

    --2) 테이블을 한번만 access한 경우
    SELECT B.EMPLOYEE_ID,
        B.FIRST_NAME,
        B.LAST_NAME,
        B.SALARY
    FROM(
            SELECT A.EMPLOYEE_ID,
                A.FIRST_NAME,
                A.LAST_NAME,
                A.SALARY
                ROW_NUMBER() OVER(ORDER BY SALARY) MINSEL.
                ROW_NUMBER() OVER(ORDER BY SALARY DESC) MAXSAL,
                FROM EMPLOYEES A
            ) B
    WHERE B.MINSAL = 1 OR B.MAXSAL = 1;
    --minsel은 오름차순 maxsel은 내림차순이라 1이 최소값 최대값이 됨
    ```

1)의 경우 테이블에 3번 ACCESS해서 18번의 BUFFER을 읽었다.<br>
2)의 경우 테아블에 1번 ACCESS하고 6번의 BUFFER을 읽었다. <br>
데이터수가 별로 없는경우에는 시간의 차가 별로 안나보이지만 <br>
대량의 데이터 테이블이였을 경우 엄청난 성능의 차이가 발생!!<br>
이런 경우에 SubQuery를 쓰면 안된다!