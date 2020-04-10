## JOIN
> JOIN은 각 테이블간에 공통된 컬럼(조건)으로 데이터를 합쳐 표현하는것<br>JOIN은 크게 INNER JOIN,OUTER JOIN이 있다.

### JOIN의 기본사용방법
- 두개의 테이블에 하나라도 같은 컬럼이 있어야한다.
- 두 컬럼의 값은 공유 되어야한다.
- 보통 조인을 위해 기본키(Primary Key)와 외래키(Foreign Key)를 활용한다.


|종류|설명|
|:---|:---|
|Equi Join<br>(Inner Join),(Natural Join)|동일 칼럼을 기준으로 조인|
|Non-Equi Join|동일 칼럼이 없이 다른 조건을 사용하여 조인|
|Outer Join|조인 조건에 만족하지 않는 행도 나타낸다|
|Self Join|한 테이블 내에서 조인|
### SELECT FROM을 이용한 조인
- ex:) 회원 테이블과 부서 테이블 조인

```
-- DEPART_ID가 공통컬럼
-- MEM 테이블의 dEPART_ID와 DEPART테이블의 DEPART_ID를 연결하여 준다.
SELECT MEM.MEM_ID, MEM.NAME, MEM.DEPART_ID, DEPART.DEPART_NAME
FROM MEM, DEPART
WHERE MEM.DEPART_ID = DEPART.DEPART_ID;
```
- 이떄 테이블명이 긴 경우 별칭을 쓸수 있다.

```
SELECT A.MEM_ID, A.NAME, A.DEPART_ID, B.DEPART_NAME
FROM MEM A   --FROM이 젤 첫번째 시작부분이므로 별칭지정 
    ,DEPART B
WHERE A.DEPART_ID = B.DEPART_ID
-- 결과는 동일하다.
```


#### EQUL JOIN(등가 조인)
> 가장 많이 사용하는 JOIN 방법 <br>
**조인 조건이 정확히 일치하는 경우에사용** (PK(기본키)와 FK(외래키)를 사용하는 JOIN)<br>
**JOIN 조건에 '='를 이용하는 조인을 보통 등가 조인(Equi-join)**이라 한다.

```
SELECT *
FROM EMP.DEPT
where emp.deptno = dept.deptno;
```

- **주의할점**
    1. **각각 테이블에 대한 AS를 반드시 명시**
        - 가독성 좋게 명시해주는 것이 좋다.
        - (해당 칼럼역시 어느 테이블의 칼럼인지 명시해주어야한다)
    2. **양쪽 테이블에 모두 데이터가 존재해야함**
        - 매칭이 안되는 부분은 누락이 되고 나머지만 Join하게 된다.

### NON-EQUI JOIN(비등가 조인)
>비등가 조인(NON EQUI)는 등가 조인과는 반대로 '='연산자가 아닌 다른 조건으로 JOIN을 수행하는 방법<br>
- ex:) (부등호,between and,is null, is not null, in)등등
- 동등연산자가 아닌 경우에는 비등가 조인이라 부름

### SELF JOIN(셀프 조인)
>자기조인,자체조인,자기참조조인,셀프조인 등등 으로 불림
- JOIN 대상이 나와 또다른 나 이다.
- 자기자신과 조인하기 때문에 컬럼명이 같아서 꼭 별칭(ALIAS)를 명시해주어야 함

```
SELECT a.ename AS emp_name, b.eane AS 사원명
from emp a, emp b;
```

### OUTER JOIN(아우터 조인)
>INNER JOIN과 반대 개념
- **데이터가 양쪽에 없어도 보여줄 수있는 JOIN**<br>
    (Equi Join은 두개의 테이블중 한쪽 컬럼에 값이 없다면 <br>나머지 테이블의 값을 반환하지 못한다.)
- Outer join의 연산자는 "(+)" (Oracle 한정)
- "(+)"는 양쪽에 오지 못한다.
- 조인시 값이 없는 조인측에 "(+)"를 위치시킴

```
SELECT DISTINCT emp.deptno, dept.deptno AS 팀번호
FROM emp,dept
WHERE emp.deptno(+) = dept.deptno;

-- 추가 조건절에도 (+)를 붙여줘야 한다.
SELECT DISTINCT emp.deptno, dept.deptno AS 팀번호
FROM emp,dept
WHERE emp.deptno(+) = dept.deptno
    AND emp.name(+) LIKE '김%';
```

#### ANSI SQL 표준
- ANSI SQL 표준은 값이 더있는 쪽을 지목해야 한다.
    - LEFT OUTER JOIN (왼쪽값이 더 있다.)
    - RIGHT OUTER JOIN (오른값이 더 있다.)
    - FULL OUTER JOIN (양쪽 다 각기 다른값이 존재)

    ```
    SELECT emp.deptno, dept.deptno AS 팀번호
    FROM emp RIGHT OUTER JOIN dept
    ON emp.deptno = dept.deptno;

    SELECT emp.deptno, dept.deptno AS 팀번호
    FROM emp LEFT OUTER JOIN dept
    ON emp.deptno = dept.deptno;

    SELECT emp.deptno, dept.deptno AS 팀번호
    FROM emp FULL OUTER JOIN dept
    ON emp.deptno = dept.deptno;
    ```
- **되도록이면 ANSI 표준 SQL 방식을 이용하는 편이좋음**
    - 모든 DB에서 같은 문법으로 사용 가능

### ANSI JOIN

```
SELECT *
FROM EMP CROSS JOIN DEPT;
```

#### ANSI Iner Join (Oracle의 Equi Join)

```
SELECT ENAME, DNAME
FROM EMP INNER JOIN DEPT
ON EMP.DEPTNO=DEPT.DEPTNO
WHERE ENAME='SCOTT';
```

- USING을 이용한 조인 조건 지정하기
    - ON 대신 사용
    - 부등호 대신 하나로 묶어서 명시
    - ()괄호 안에 서브쿼리 사용가능

```
SELECT * 
FROM table1 JOIN table2
USING(공통컬럼)
```

### NATURAL JOIN(자연조인)
> 등가조인의 한종류
- 조건절 없이 양쪽에 해당하는 컬럼을 적어줌으로써 그 컬럼에 자동으로 등가조인이 실시
- 서로 동일한 컬럼앞에 ALIAS된 테이블의 별칭을 적어주면 에러발생<br>(동일한 컬럼이 두개 이상이여도 상관 X)
- 등가조인인 '='쓸때 동일한 컬럼과 두번 명시 해주어야해서 이중복을 제거하기 위해 사용

```
SELECT *
FROM EMP NATURAL JOIN DEPT;
```

### INNER JOIN(내부조인)
> 등가조인의 한종류
- 두개의 테이블 혹은 두개 이상의 테이블을 조인하는곳에 INNER JOIN을 붙임
- (INNER)은 생략 가능
- 조건절에 WHERE 대신 ON을 사용(등가조인용)한다.

```
SELECT d.deptname, e.ename
    FROM dept d INNER JOIN emp e
    ON e.deptno = d.deptno;

-- INNER 생략가능
SELECT d.deptname, e.ename
    FROM dept d JOIN emp e
    ON e.deptno = d.deptno;

```