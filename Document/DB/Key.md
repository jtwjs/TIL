## KEY


### PK(Primary Key) 기본키
- 기본키 역시 기본적으로 제약조건들은 테이블을 생성할때 같의 정의한다.
- 테이블당 하나만 정의 가능하다(두개 이상의 PK는 조합키/복합키 라고 불림 묶어서하나)
- PK는 NOT NULL + UNIQUE의 기능을 가지고 있다.
    - NOT NULL : **null(아무런 값이 없는 상태)값을 가질수 없다**.
    - UNIQUE : 중복되어 나타날 수 없는 **단일 값(unique)**를 가진다.
- 주키 | 기본키 | 식별자 등으로 자주 불린다.
- 자동 INDEX가 생성되는데 이는 검색 키로서 검색 속도를 향상시킨다.


#### PK를 선언하는 방법

- 테이블을 생성할때 선언

    ```
    CREATE TABLE consTest(
        pkCol1 CHAR(8) PRIMERY KEY, --(1)
        pkCol2 CHAR(8),
        pkCol3 NUMBER CONSTRAINT consTest_pk3 PRIMARY KEY,--(2)
        CONSTRAINT pk_code PRIMARY KEY(pkCol2)--(3)
    );
    ```
    - 1) 컬럼명 옆에 바로 주키를 선언
    - 2) [해당 컬럼][타입] CONSTRAINT [제약조건 명] PRIMARY KEY
    - 3) **CONSTRAINT [제약조건 명] PRIMARY KEY([컬럼명1],[컬럼명2],...)**
        - 보통 PK나 FK는 컬럼명 옆에 바로 명시하지않고, 아랫단에 CONSTRAINT를 사용

- ALTER문으로 선언

    ```
    ALTER TABLE [테이블명]
    ADD CONSTRAINT [제약조건명] PRIMARY KEY(컬럼명)
    ```
