## DDL (Data Definition Language) 데이터정의어

### Create(테이블 생성)
```
CREATETABLE 테이블명(
    컬럼명 데이터타입 [DEFAULT 형식]
    ...
    [CONSTRAINT PK명 PRIMARY KEY(컬럼명)]
);
--컬럼에 대한 제약조건이 있으면 CONSTRAINT를 이용하여 추가
--EX)
CREATE TABLE EX_TABLE
(
    COMPANY VARCHAR(7) NOT NULL,
    DEPT VARCHAR(20) DEFAULT '미정' NOT NULL,
    TP VARCHAR(20),
    USER_ID VARCHAR(20) NOT NULL,
    TODAY DATE DEFAULT SYSDATE NOT NULL
);
```
- **테이블명,컬럼명 명명규칙**
    - 반드시 문자로 시작해야한다.
    - 1~30자 까지 가능
    - A~Z까지 대소문자 0~9까지의 숫자
    - 특수기호는 (_,$,#)만 포함할수 있다.
    - 오라클에서 사용되는 예약어나 다른 객체명과 중복불가
    - 공백은 허용X
- VARCHAR | NUMBER | DATE
    - 각 칼럼의 속성
    - VARCHAR 문자형
    - NUMBER 숫자형
    - DATE 날짜형
    - 괄호안의 숫자는 컬럼의 SIZE
- DEFULAT
    - ROW를 생성할 시 컬럼에 기본으로 들어가는 값을 지정
- NOT NULL
    - ROW에 데이터가 없을시 추가가 되지 않도록 설정
- SYSDATE
    - 현재 날짜를 뜻함

---
### 서브 쿼리로 테이블 생성하기
- 원하는 컬럼으로 구성된 복제 테이블 생성
    ```
    CREATE TABLE 테이블명
    AS
    SELECT 복사할 컬럼 FROM 복사할테이블명
    -- 테이블을 복사해서 새로운테이블을 만듬
    -- 제약조건은 복사하지 않는다. 
    ```
- 테이블의 구조만 복사하기

    ```
    CREATE TABLE 테이블명
    AS
    SELECT * FROM 복사할테이블명 WHERE 1=0;
    --WHERE 1=0; 조건은 항상 거짓, 이를이용하여 
     테이블의 데이터는 가져오지 않고 구조만 복사
    ```
    

---


### DROP(테이블 삭제)
1. **DROP TABLE : 테이블의 모든 데이터 및 구조를 삭제한다.**

    ```
    DROP TABLE 테이블명 [CASCADE CONSTRAINT];
    --[CASCADE CONSTRAINT] : 해당 테이블과 관계가 있었던 참조되는 
        제약조건에 대해서도 삭제한다는 것을 의미

    --EX)
    DROP TABLE PLAYER; 
    -- PLAYER 테이블 삭제
    ```
2. RENAME : 테이블의 이름을 변경한다.

    ```
    RENAME 변경전 테이블명 TO 변경후 테이블명

    --EX)
    RENAME TEAM_BACKUP TO TEAM;
    -- TEAM_BACKUP테이블 이름을 TEAM 으로 변경한다.
    ```
---
### ALTER(테이블 수정)

1. **ADD : 테이블에 컬럼을 추가한다.**

    ```
    ALTER TABLE 테이블명 ADD (컬럼명 데이터타입(데이터크기));

    --EX)
    ALTER TABLE EMP ADD(EMP_ADDR VARCHAR(10)); 
    -- EMP 테이블에 EMP_ADDR이라는 컬럼을 VARCHAR2 데이터타입으로 추가

    ALTER TABLE EMP ADD(EMP_NUM NUMBER(8,2));
    -- EMP 테이블에 EMP_NUM이라는 컬럼을 NUMBER 데이터타입으로 추가
    ```
2. **MODIFY : 테이블에 컬럼을 수정한다.**

    ```
    ALTER TABLE 테이블명 MODIFY(칼럼명 데이터타입(데이터크기));
    -- 데이터크기가 더작게는 수정이 불가능

    --EX)
    ALTER TABLE EMP MODIFY(EMP_ADDR VARCHAR2(20));
    -- EMP 테이블에 EMP_ADDR이라는 컬럼의 데이터크기를 20으로수정

    ALTER TABLE EMP MODIFY(EMP_NUM NUMBER(10,2));
    --EMP 테이블에 EMP_NUM이라는 컬럼의 데이터 크기를 10으로 수정
    ```
3. **DROP : 테이블에 컬럼을 삭제한다.**

    ```
    ALTER TABLE 테이블명 DROP COLUMN 컬럼명;

    --EX)
    ALTER TABLE EMP DROP COLUMN EMP_ADDR;
    --EMP 테이블에 EMP_ADDR이라는 컬럼을 삭제
    ```
4. **RENAME : 테이블에 컬럼이름을 변경한다.**

    ```
    ALTER TABLE 테이블명 RENAME COLUMN 이전컬럼명 TO 바꿀컬럼명;

    --EX)
    ALTER TABLE EMP RENAME COLUMN EMP_ADDR TO EMP_ADDR1;
    --EMP 테이블에 EMP_ADDR이라는 컬럼명을 EMP_ADDR1으로 변경
    ```
---
### TRUNCATE(테이블에 있는 모든 데이터 삭제)