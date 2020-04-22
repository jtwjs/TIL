## PL/SQL 명령문
>SQL을 확장한 절차적 언어 PL/SQL(Procedural Language/SQL)의 약어
- 오라클 DB 환경에서 실행되는 절차적인 데이터베이스 프로그래밍 언어
- 표준 SQL과 3세대 언어의 강력한 일부 기능을 포함한 SQL의 확장 언어
- PL/SQL에서는 프로그램 단위를 블록(block)이라 부르며, 애플리케이션 로직들을 작성
- 오라클에서 지원하는 프로그래밍 언어의 특성을 수용하여 SQL에서는 사용할수 없는<br> 절차적 프로그래밍 기능을 가지고 있어 SQL의 단점을 보완하였다.

### 장점
- 프로시저 생성자와 SQL의 통합
- 성능 향상: 잘 만들어진 PL/SQL 명령문이라는 가정하에
- 모듈식 프로그램 개발 가능 : 논리적인 작업을 진행하는 여러 명령어들을 하나의 블록으로 만들수있다.
- 이식성이 좋다.
- 예외처리 가능
- SQL의 다음 단점을 해결
    1. 변수가 없다.
    2. 한번에 하나의 명령문만 사용가능해서 트래픽증가
    3. 제어문 사용불가
    4. 예외처리가 없다.

### 오라클 환경에서 PL/SQL을 학습하는 이유
- 오라클 개발 도구를 수행하는 모든 프로그래밍의 기초
- 클라이언트가 아닌 서버 상에서 프로세스를 수행하는데 PL/SQL을 사용함
- PL/SQL을 사용하면 업무 규칙이나 복잡한 로직을 캡슐화할 수 있어, 모듈화와 추상화가 가능
- DB 트리거를 통하여 DB 무결성을 제약하는 복잡한 규칙의 코딩과 변경 내역,데이터를 복사
- PL/SQL은 독립적인 플랫폼 수준을 제공
### 기본 특징
- 블록 단위의 실행을 제공 
    - BEGIN , END;를 사용
    - **마지막 라인에 /를 입력하면 해당블록이 실행**
- 변수, 상수 등을 선언하여 SQL과 절차형 언어에서 사용
- 변수의 선언은 DECLARE절에서만 가능, BEGIN 섹션에서 새로운 값이 할당될 수 있다.
- IF문을 사용하여 조건에 따라 문장들을 분기 가능
- LOOP문을 사용하여 일련의 문장을 반복 가능
- 커서를 사용하여 여러 행을 검색 및 처리
- **PL/SQL에서 사용가능한 SQL은 Query,DML,TCL이다.**
    - DDL(CREATE,DROP,ALTER,TURNCATE...),DCL(GRANT,REVOKE)명령어는 동적 SQL을 이용할때만 사용 가능
- **PL/SQL의 SELECT문은 해당 SELECT의 결과를 PL/SQL Engine으로 보낸다**

### PL/SQL에서 제공하는 명령문
- 모든 SQL문
- 변수 및 상수 등의 선언문
- 대입문
- 조건 판단문
- 제어 흐름문
- 반복 처리문

### PL/SQL로 작성할수 있는것은?
- SQL Plus 스크립트(Script)
- 프로시저(Procedure),함수(Function) 서브프로그램
- 패키지(Package)
- 데이터베이스 트리거(Database Trigger)
- 애플리케이션 로직(Application Logic)

### 스칼라 변수/레퍼런스 변수
>PL/SQL에서 변수를 선언하기 위해 사용할 수 있는 데이터형은 크게 스칼라와 레퍼런스로 나눌수 있다.
- **스칼라(Scalar)**
    - PL/SQL에서 변수를 선언 자료형은 SQL에서 사용하던 자료형과 거의 유사
    - NUMBER : 숫자를 저장
    - VARCHAR2 : 문자를 저장
    ```SQL
    변수_명 NUMBER(4);
    변수_명 VARCHAR2(10);
    ```
- **레퍼런스(Reference)**
    - **%TYPE**
        - 이전에 선언된 다른 변수 또는 데이터베이스 컬럼에 맞추어 변수를 선언하기 위해 %TYPE속성을 사용
        - 컬럼의 자료형이 변경되더라도 컬럼의 자료형과 크기를 그대로 참조 (수정필요X)
        - **유지보수에 용이**
        - **표기형식**
        ```PL
        변수_명 테이블.컬럼%TYPE;
        변수_명 테이블.컬럼%TYPE;
        ```

    - **%ROWTYPE**
        - 로우(행) 단위로 참조
        - DB의 테이블 또는 VIEW의 일련의 컬럼을 **RECORD로 선언하기위해** 사용
        - 특정 테이블의 컬럼의 개수와 데이터형식을 모르더라도 지정 가능 
        - SELECT 문장으로 로우를 검색할 때 유리
        - **표기형식**
        ```PL
        변수_명 테이블%ROWTYPE;
        ```
        - **레코드(RECORD)**
            - PL/SQL에서 제공하는 데이터타입 중 하나인 복합형구조
            - 변수를 선언하면 여러개의 값을 가질 수 있음
            - 테이블과 달리 레코드가 가질 수 잇는 로우의 수는 단 한개
            - 커서와 동일한 방식으로 선언(구조적으로 커서도 레코드에 속함)
### PL/SQL 구조
 - **선언부**(DECLARE SECTION)
    - PL/SQL에서 사용하는 모든 변수나 상수를 선언하는 부분으로서 **DECLARE**로 시작
- **실행부**(EXECUTABLE SECTION)
    - 절차적 형식으로 SQL문을 실행할 수 있도록 절차적 언어의 요소인 로직을 기술 **BEGIN**으로 시작
- 예외처리(EXCEPTION SECTION)
    - PL/SQL 문이 실행되는중 예외사항이 발생했을때 이를 해결하기 위한 문장을 기술

```sql
-- PL/SQL의 기본 블록 구조 (프로그램 단위 -> block)

DECLARE [선택] --변수와 상수, 프로시저와 함수 서브프로그램, 커서 등을 선언
    선언문
    ....

------------------------
BEGIN [필수] --처리할 명령문들을 절차적으로 기술
             -- 모든 SQL문, 대입문, 반복 처리문, 조건 판단문, 제어 흐름문, 커서 처리문
    실행문
    ....
------------------------
EXCEPTION [선택] --오류 처리에 관한 예외처리 명령문을 기술

    예외처리문
    ....
------------------------
END; [필수]

```
- **DBMS_OUTPUT.PUT_LINE()**
    - PL/SQL은 기본적으로 처리된 PL/SQL 문장의 결과를 화면에 출력하지 않는다.
    - 따라서 결과를 화면에 출력하고 싶으면 사전에 **SET SERVEROUTPUT ON;** 작성하자
        - SET SERVEROUTPUT ON; : 화면 출력기능을 활성화
- **SET verify OFF**
    - SQL 명령어나 PL/SQL 에서 &를 이용한 치환 변수 등을 사용할 때 <BR>치환되기 전 후의 자세한 값을 보일 건지의 여부를 결정 (기본값은 ON)

- **작성요령**
    1. 블록내에서는 한 문장이 종료될때마다 세미콜론(;) 사용
    2. END 뒤에 ;를 사용하여 하나의 블록이 끝났다는 것을 명시
    3. 단일행 주석은 --이고 여러행 주석은 /**/이다.
    4. 쿼리문을 수행하기 위해서 /가 반드시 입력되어야 PL/SQL블록은 행에 /가 있으면 종결된것으로 간주
### PL/SQL Block의 종류
1. 익명 블록 : 이름이 없는 PL/SQL Block
2. 이름 있는 블록 : DB의 객체로 저장되는 블록
    - 프로시저 : 리턴 값을 하나 이상 가질 수 있는 프로그램
    - 함수 : 리턴 값을 반드시 반환해야 하는 프로그램
    - 패키지 : 하나 이상의 프로시저,함수,변수,예외 등의 묶음
    - 트리거 : 지정된 이벤트가 발생하면 자동으로 실행되는 PL/SQL 블록

### PL/SQL - SELECT문
> DB에서 정보를 추출할 필요가 있을 때 또는 DB로 변경된 내용을 적용할 때 SQL을 사용
- PL/SQL은 SQL에 있는 DML 명령을 지원
- **테이블의 행에서 질의된 값을 변수에 할당**시키기 위해 SELECT문장 사용
- PL/SQL의 SELECT문은 INTO절 필요
    - INTO절에는 데이터를 저장할 변수를 기술
    - SELECT 절에 컬럼과 INTO절에 변수와 1:1 대응하기에 개수,데이터타입 길이가 일치해야함
- SELECT문은 INTO절에 의해 **하나의 행**만을 저장할 수 있다.
- **표기형식**
    ```SQL
    SELECT 열의 목록(행 함수 | 그룹 함수 | 표현식)
    INTO 저장할 변수
    FROM 테이블_명
    WHERE 조건;
    ```
### TABLE(테이블) TYPE
>PL/SQL 테이블은 오라클 **SQL에서의 테이블과는 다르다**. <BR>**PL/SQL에서의 테이블은 일종의 일차원배열**
- 테이블은 크기에 제한이없다.
- BINARY_INTEGER 타입의 인덱스 번호로 순서가 정해짐
- 하나의 테이블은 한개의 컬럼데이터를 저장
- **표기형식**
    ```PL
    TYPE 테이블타입_명 IS TABLE OF 데이터타입
    INDEX BY BINARY_INTEGER;
    IDENTIFIER(변수명) 테이블타입_명;
    ```
    - IDENTIFIER: 전체 PL/SQL 테이블을 나타내는 식별자 이름(**변수명**)
- EX:)
    ```SQL
    DECLARE 
        --테이블 타입을 정의
        TYPE EMP_TABLE_TYPE IS TABLE OF EMP%ROWTYPE
            INDEX BY BINARY_INTEGER;
        --테이블 타입으로 변수 선언
        EMP_TABLE EMP_TABLE_TYPE;
        
        I BINARY_INTEGER := 0;
        
    BEGIN
        -- EMP 테이블에서 사원이름과 직급을 얻어옴
        FOR K IN (SELECT * FROM EMP) LOOP
        I := I +1; --인덱스증가
        EMP_TABLE(I).EMPNO := K.EMPNO;
        EMP_TABLE(I).ENAME := K.ENAME;
        EMP_TABLE(I).JOB := K.JOB;
        EMP_TABLE(I).MGR := K.MGR;
        EMP_TABLE(I).HIREDATE := K.HIREDATE;
        EMP_TABLE(I).SAL := K.SAL;
        EMP_TABLE(I).COMM := K.COMM;
        EMP_TABLE(I).DEPTNO :=K.DEPTNO;
        END LOOP;

        --테이블에 저장된 내용을 출력
        FOR J IN 1..I LOOP
        DBMS_OUTPUT.PUT_LINE(LPAD(EMP_TABLE(J).EMPNO,6)
            || '/' || LPAD(EMP_TABLE(J).ENAME,6)
            || '/' || LPAD(EMP_TABLE(J).JOB,10)
            || '/' || LPAD(EMP_TABLE(J).MGR,6)
            || '/' || LPAD(EMP_TABLE(J).HIREDATE,10)
            || '/' || LPAD(EMP_TABLE(J).SAL,6)
            || '/' || LPAD(EMP_TABLE(J).COMM,6)
            || '/' || LPAD(EMP_TABLE(J).DEPTNO,4));
        END LOOP;
    END;
    /
    ```

### RECORD(레코드) TYPE
>PL/SQL 레코드는 **여러개의 데이터 타입을 갖는 변수들의 집합**이다.
- 스칼라, RECORD, 또는 PL/SQL TABLE datatype 중 하나 이상의 요소로 구성됨
- 논리적 단위로서 필드 집합을 처리 할수 있도록 해준다.
- 변수 선언시 여러개의 값을 가질수 있다.
- 테이블과 달리 레코드가 가질 수 있는 로우의 수는 단 한 개뿐이다
- PL/SQL 테이블과 다르게 개별 필드의 **이름을 부여**할 수 있고 **선언시 초기화** 가능
- **표기형식**
    ```PL
    TYPE 레코드_명 IS RECORD
    (필드이름1 필드유형1 [NOT NULL {:= | DEFAULT} 식],
     필드이름2 필드유형2 [NOT NULL {:= | DEFAULT} 식],
     필드이름3 필드유형3 [NOT NULL {:= | DEFAULT} 식]);

     IDENTIFIER(변수명) 레코드_명;
     ```
- EX:)
    ```SQL
    DECLARE 
        --레코드 타입을 지정
        TYPE EMP_RECORD_TYPE  IS RECORD(
        V_EMPNO EMP.EMPNO%TYPE,
        V_ENAME EMP.ENAME%TYPE,
        V_JOB EMP.JOB%TYPE,
        V_DEPTNO EMP.DEPTNO%TYPE);
        --레코드 변수선언
        EMP_RECORD EMP_RECORD_TYPE;
    BEGIN
        -- SCOTT 사원의; 정보를 레코드 변수에 저장
        SELECT EMPNO,ENAME,JOB,DEPTNO
            INTO EMP_RECORD
            FROM EMP
            WHERE ENAME = UPPER('SCOTT');
        --레코드 변수에 저장된 사원 정보를 출력
        DBMS_OUTPUT.PUT_LINE('사원번호 :' || TO_CHAR(EMP_RECORD.V_EMPNO));
        DBMS_OUTPUT.PUT_LINE('이   름 :' || EMP_RECORD.V_ENAME);
        DBMS_OUTPUT.PUT_LINE('담당업무 :' || EMP_RECORD.V_JOB);
        DBMS_OUTPUT.PUT_LINE('부서번호 :' || TO_CHAR(EMP_RECORD.V_DEPTNO));
    END;
    /

    ```
### 선택문 (IF-THEN-END IF)
>**IF절 다음에는 비교 대상과 조건을 기술한다**. 조건을 만족할 경우 THEN 이후의 문장이 수행됨
- PL/SQL 에서는 변수에 값을 할당하기 위해서는 := 를 사용한다.<BR>변수를 선언할 때도 := 연산자를 이용해서 변수에 기본값을 정의할수 있다.
- **표기형식**
    ```SQL
    IF 조건식 THEN --조건문
    STATEMENTS  -- 조건에 만족할 경우 실행되는 문장
    END IF;

    -- IF-THEN-ELSE IF-END IF
    IF 조건식 THEN
    STATEMENTS
    ELSIF 조건식 THEN
    STATEMENTS
    END IF;

    -- IF-THEN-ELSE-END IF
    IF 조건식 THEN
    STATEMENTS
    ELSE
    STATEMENTS
    END IF;
    ```
- EX:)
    ```sql
    SET SERVEROUTPUT ON;

    DECLARE 
        VEMPNO NUMBER(4);
        VENAME VARCHAR2(20);
        VDEPTNO EMP.DEPTNO%TYPE;
        VDNAME VARCHAR2(20):=NULL;
    BEGIN
        SELECT EMPNO,ENAME,DEPTNO 
        INTO VEMPNO,VENAME,VDEPTNO
        FROM EMP
        WHERE EMPNO=7788;
        
        IF(VDEPTNO = 10) THEN
            VDNAME := 'ACCOUNTING';
        END IF;
        IF(VDEPTNO = 20) THEN
            VDNAME := 'RESERACH';
        END IF;
        IF(VDEPTNO = 30) THEN
            VDNAME := 'SALES';
        END IF;
        IF(VDEPTNO = 40) THEN
            VDNAME := 'OPERATIONS';
        END IF;
        
        DBMS_OUTPUT.PUT_LINE('사번    이름  부서명');
        DBMS_OUTPUT.PUT_LINE(VEMPNO||'  '||VENAME||'    '||VDNAME);
    END;
    /
    ```

### 반복문 (LOOP | WHILE | FOR)

- **BASIC LOOP**문
    - EXIT를 누락하면 해당 LOOP는 무한루프에 빠지게되니 주의
    - **표기형식**
    ```SQL
    LOOP
    처리문
    EXIT[조건식];
    END LOOP
    ```
    - EX:)
    ```SQL
    DECLARE 
    N NUMBER := 1;
    BEGIN
        LOOP
            DBMS_OUTPUT.PUT_LINE( N ); --출력
            N := N +1;      --N = N + 1
            EXIT WHEN N >5; --N이 5보다 크면 LOOP 종료
        END LOOP;
    END;
    /
    ```
- **WHILE**문
    - WHILE에 조건식을 쓰므로 EXIT 생략가능
    - **표기형식**
    ```SQL
    WHILE 조건
    LOOP
    처리문;
    END LOOP;
    ```
    - EX:)
    ```SQL
    DECLARE 
        NUM1 NUMBER := 1;
    BEGIN
        WHILE(NUM<10) -- NUM이 10보다 작을때까지 LOOP발생
        LOOP
        DBMS_OUTPUT.PUT_LINE(NUM1); --출력
        NUM1 := NUM1+1; --NUM = NUM + 1
        END LOOP;
    END;
    /
    ```
- **FOR**문
    - 증가치는 따로 없다. 무조건 1
    - FOR문의 증감변수는 정수타입이나 레코드타입이 올수 있다.
    - **표기형식**
    ```SQL
    FOR 증감변수 IN [REVERSE] 초기값..최종값 LOOP
    처리문;
    END LOOP;
    ```
    - EX:)
    ```SQL
    BEGIN
        FOR I IN 1..9 LOOP
        DBMS_OUTPUT.PUT_LINE('안녕!?'); --출력
        END LOOP
    END;
    / 
    ```