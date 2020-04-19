## DDL (Data Definition Language) 데이터정의어
>스키마(Schema),도메인(Domain),테이블(Table),뷰(View),인덱스(Index)를 정의하거나 변경 또는 제거할 때 사용하는 언어
<br>DDL로 정의된 내용은 메타데이터(Metadata)가 되며, 시스템 카탈로그(System Catalog)에 저장된다.
- DDL의 모든 삭제하는 명령어는 복구불가능..
- **테이블명,컬럼명 명명규칙**
    - 반드시 문자로 시작해야한다.
    - 1~30자 까지 가능
    - A~Z까지 대소문자 0~9까지의 숫자
    - 특수기호는 (_,$,#)만 포함할수 있다.
    - 오라클에서 사용되는 예약어나 다른 객체명과 중복불가
    - 공백은 허용X

#### SQL에서 지원하는 기본 데이터 타입
- 정수(Integer): INT(4Byte 정수),SMALLINT(2Byte 정수)
- 실수(Float): FLOAT,REAL,DOUBLE PRECISION
- 형식화된 숫자: DEC(i,j)  i:전체 자릿수, j:소수부 자릿수
- 고정길이 문자: CHAR(n)  n:문자 수
- 가변길이 문자: VARCHAR(n)  n:최대 문자 수
- 고정길이 비트 열(Bit String): BIT(n)
- 가변길이 비트 열: VARBIT(n)
- 날짜: DATE
- 시간: TIME

### Create
>스키마,도메인,테이블,뷰,인덱스를 정의한다.

#### Create Table (테이블 생성)
>테이블을 정의하는 명령문
- **표기형식**
```
CREATE TABLE 테이블명(
    (속성명 데이터_타입 [NOT NULL], ···
    [, PRIMARY KEY (기본키_속성명,···)]
    [, UNIQUE (대체키_속성명,···)]
    [, FOREIGN KEY (외래키_속성명,···)
        REFERENCES 참조테이블(기본키_속성명,···)]
        [ON DELETE 옵션]
        [ON UPDATE 옵션]
    [, CONSTRAINT 제약조건명][CHECK (조건식)]);
```
- ON DELETE 옵션 : 참조 테이블의 튜플이 삭제되었을 때 기본 테이블에 취해야 할 사항을 지정
- ON UPDATE 옵션 : 참조 테이블의 참조 속성 값이 변경되었을 때 기본 테이블에 취해야 할 사항을 지정
    - NO ACTION : 참조 테이블에 변화가 있어도 기본 테이블에는 아무런 조치를 취하지 않는다.
    - CASCADE : 참조 테이블의 튜플이 삭제&변경되면 연쇄적으로 기본 테이블의 관련 튜플들을 모두 삭제&변경 된다.
    - SET NULL : 참조 테이블에 변화가 있으면 기본 테이블의 관련 튜플의 속성 값을 NULL로 변경
    - SET DEFAULT : 참조 테이블에 변화가 있으면 기본 테이블의 관련 튜플의 속성값을 기본값으로 변경

- **서브 쿼리로 테이블 생성하기**
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
#### CREATE SCHEMA
>스키마를 정의하는 명령문
- 스키마는 하나의 응용(사용자)에 속하는 테이블과 기타 구성 요소등을 그룹짓기 위한 것
- 스키마의 식별을 위한 스키마 이름과 해당 스키마의 소유권자나 허가권자를 정의한다.
- **표기형식** : ``` CREATE SCHEMA 스키마명 AUTHORIZATION 사용자_ID; ```
    - EX:) ID가 홍길동인 사용자의 스키마 '대학교'를 정의 하는 SQL문
    - ``` CREATE SCHEMA 대학교 AUTHORIZATION 홍길동; ```
#### CREATE DOMAIN
>도메인을 정의하는 명령문
- 도메인이란 하나의 속성이 취할 수 있는 동일한 타입의 원자값들의 집합
- 정의된 도메인 명은 일반적인 데이터 타입처럼 사용한다
- **표기형식** : ``` CREATE DOMAIN 도메인명 데이터_타입 [DEFAULT 기본값] [CONSTRAINT 제약조건명 CHECK(범위 값)]; ```
    - 데이터_타입 : SQL에서 지원하는 데이터타입
    - 기본값 : 데이터를 입력하지 않았을 때 자동으로 입력되는 값
    - EX:) 성별을 "남" 또는 "여"와 같은 정해진 1개의 문자로 표현되는 도메인 SEX를 정의하는 SQL문
    - ```CREATE DOMAIN SEX CHAR(1) DEFAULT '남' CONSTRAINT VALID-SEX CHECK(VALUE IN("남","여")); ```
#### CREATE VIEW
>뷰는 하나 이상의 기본 테이블로부터 유도되는 이름을 갖는 가상 테이블로 CREATE VIEW는 뷰를 정의하는 명령문
- **표기형식** : ``` CREATE VIEW 뷰명[(속성명[,속성명, ···])] AS SELECT문; ```
    - SELECT문을 서브 쿼리로 사용하여 SELECT문의 결과로서 뷰를 생성한다.
    - 서브쿼리인 SELECT문에는 UNION이나 ORDER BY절을 사용할수 없다.
    - 속성명을 기술하지 않으면 SELECT문의 속성명이 자동으로 사용된다.
    - EX:) <고객>테이블에서 주소가 '안산시'인 고객들의 성명과 전화번호를 '안산고객'이라는 뷰로 정의
    - ```CREATE VIEW 안산고객(성명,전화번호) AS SELECT 성명,전화번호 FROM 고객 WHERE 주소='안산시'; ```
#### CREATE INDEX
>인덱스는 검색을 빠르게 하기 위해 만든 보조적인 데이터 구조이며 CREATE INDEX는 인덱스를 정의하는 명령문
- **표기형식** : ``` CREATE [UNIQUE] INDEX <인덱스명> ON 테이블명({속성명 [ASC|DESC] [,속성명 [ASC|DESC]]}) [CLUSTER]; ```
    - UNIQUE : 중복값이 없는 속성으로 인덱스를 생성
    - 정렬 여부 지정 
        - ASC:  오름차순 정렬 (기본값)
        - DESC: 내림차순 정렬
    - CLUSTER : 지정된 키에 따라 튜플들을 그룹으로 지정하기 위해 사용
    - EX:) <고객>테이블에서 UNIQUE한 특성을 갖는 고객번호 속성에 대해 내림차순으로 정렬하여 고객번호_idx라는 이름으로 인덱스를 정의
    - ```CREATE UNIQUE INDEX 고객번호_idx ON 고객(고객번호 DESC); ```
#### CREATE TRIGGER
>트리거(Trigger)는 데이터베이스 시스템에서 데이터 입력,갱신,삭제등의 이벤트가 발생할때마다 자동적으로 수행되는 사용자 정의 프로시저이다.
- 트리거는 SQL의 제약조건 방법을 통해 명시할 수 없는 무결성 제약조건을 구현하고, 관련 테이블의 데이터를 일치시킬 때 주로 사용
- **표기형식** :
    ``` 
    CREATE TRIGGER 트리거명[동작시기 옵션][동작 옵션] ON 테이블명 
    REFERENCING [NEW | OLD] TABLE AS 테이블명
    FOR EACH ROW
    WHEN 조건식
    트리거 BODY
    ```
    - 동작시기 옵션: 트리거가 실행될 때를 지정 
        - AFTER: 테이블이 변경된 후에 트리거가 실행
        - BEFORE: 테이블이 변경되기 전에 트리거가 실행
    - 동작 옵션: 트리거가 실행되게 할 작업의 종류를 지정
        - INSERT: 테이블에 새로운 레코드를 삽입될때 트리거가 실행
        - DELETE: 테이블의 레코드를 삭제할 때 트리거가 실행
        - UPDATE: 테이블의 레코드를 수정할 때 트리거가 실행
    - 테이블 선택 옵션: 트리거가 적용될 테이블의 종류를 지정한다.
        - NEW: 새로 추가되거나 변경에 참여할 튜플들의 집합(테이블)에 트리거가 적용됨
        - OLD: 변경된 튜플들의 집합(테이블)에 트리거가 적용됨
    - WHEN: 트리거가 실행되면서 지켜야할 조건을 지정
    - 트리거 BODY: 트리거의 본문 코드를 입력하는 부분
        - BEGIN으로 시작해서 END로 끝나는데, 적어도 하나 이상의 SQL문이 있어야한다.
        - 변수에 값을 치환할 때는 예약어 SET를 사용한다.
    - EX:) <학생>테이블에 새로운 레코드가 삽입될 때 삽입되는 레코드에 학년 정보가 누락됐으면<br> 학년 필드에 '신입생'을 치환하는 트리거를 '학년정보_tri'라는 이름으로 정의
    ```
    CREATE TRIGGER 학년정보_tri BEFORE INSERT ON 학생
    REFERENCING NEW TABLE AS new_table
    FOR EACH ROW
    WHEN new_table.학년=''
    BEGIN
        SET new_table.학년='신입생';
    END;
    ```
---


### DROP(테이블 삭제)
>스키마,도메인,테이블,뷰,트리거,인덱스를 제거한다.
1. **DROP : 테이블의 모든 데이터 및 구조를 삭제한다.**

    ```
    DROP TABLE 테이블명 [CASCADE CONSTRAINT];
    --[CASCADE CONSTRAINT] : 해당 테이블과 관계가 있었던 참조되는 
        제약조건에 대해서도 삭제한다는 것을 의미

    --EX)
    DROP TABLE PLAYER; 
    -- PLAYER 테이블 삭제
    ```
- CASCADE: 제거할 개체를 참조하는 다른 모든 개체를 함께 제거한다.
- RESTRICT: 다른 개체가 제거할 개체를 참조중일 경우 제거가 취소된다.

2. RENAME : 테이블의 이름을 변경한다.

    ```
    RENAME 변경전 테이블명 TO 변경후 테이블명

    --EX)
    RENAME TEAM_BACKUP TO TEAM;
    -- TEAM_BACKUP테이블 이름을 TEAM 으로 변경한다.
    ```
---
### ALTER(테이블 수정)
> 테이블에 대한 정의를 변경한다.
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
5. **SET UNUSED : 컬럼의 사용을 논리적으로 제한함(삭제X)**
    >특정 테이블에서 칼럼을 삭제하는경우 다음과같이 무조건 삭제하는 것은 위험
    <br>테이블에 저장된된 내용이 많을경우(몇만건에 대한 자료)
    <br>칼럼을 삭제하는데 꽤 오랜시간이 걸리게됨 
    <br>(칼럼을 삭제하는 동안 다른사용자가 해당컬럼에 접근을 못함)

    ```
    --문법
    ALTER TABLE 테이블명
    SET UNUSED (컬럼명);

    ```
---
### TRUNCATE(테이블에 있는 모든 데이터 삭제)
> 기존에 사용하던 테이블의 모든 로우를 제거하기 위한 명령어

    ```
    TRUNCATE  테이블명
    ```