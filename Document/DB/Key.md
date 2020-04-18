## KEY
>데이터베이스에서 조건을 만족하는 튜플을 찾거나 순서대로 정렬할 때 기준이 되는 속성을 말함

### PK(Primary Key) 기본키
> 주키,기본키,식별자 등으로 불린다.
- 후보키 중에서 특별히 선정된 키로 중복된 값을 가질수 없다.
- 후보키의 성지을 갖고, 튜플을 식별하기 위해 반드시 필요한 키이다.
- NULL값을 가질수 업삳. 즉, 튜플에서 기본키로 설정된 속성에는 NULL값이 있어선 안된다.
- 기본키 역시 기본적으로 제약조건들은 테이블을 생성할때 같의 정의한다.
- 테이블당 하나만 정의 가능하다(두개 이상의 PK는 조합키/복합키 라고 불림 묶어서하나)
- PK는 NOT NULL + UNIQUE의 기능을 가지고 있다.
    - NOT NULL : **null(아무런 값이 없는 상태)값을 가질수 없다**.
    - UNIQUE : 중복되어 나타날 수 없는 **단일 값(unique)**를 가진다.
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

---
### FK(Foreign Key) 외래키
> 외부키,외래키,참조키,외부 식별자 등으로 불린다.
- 다른 릴레이션의 기본키를 참조하는 속성 또는 속성들의 집합을 의미
- FK가 정의된 테이블을 자식 테이블이라 칭한다.
- 참조되는 테이블 즉 PK가 있는 테이블을 부모 테이블이라 한다.
- 부모테이블의 PK 컬럼에 존재하는 데이터만 자식테이블에 입력할 수 있다.
- 부모테이브은 자식의 데이터나 테이블이 삭제된다고 영향을 받지 않는다.
- 참조하는 데이터 컬럼과 데이터 타입이 반드시 일치해야한다.
- 참조할수 있는 컬럼은 **기본키(PK)** 이거나 UNIQUE 만 가능(보통PK)

```
CREATE TABLE parentTable(
    parentPk nummber primary key
);

CREATE TABLE consTest(
    parentPk NUMBER,
    pkCol1 CHAR(8),

    CONSTRAINT fk_code FOREIGN KEY(parentPk)
        REFERENCES parentTable(parentPk) ON DELETE CASCADE
);
```

```
CONSTRAINT[제약조건명] FOREIGN KEY([컬럼명])
    REFERENCES [참조할 테이블 이름]([참조할 컬럼])
    [ON DELETE CASCADE | ON DELETE SET NULL]
```
- 참조할 컬럼과 같은 컬럼이 자식 테이블에 존재 해야한다.
    - **같은 이름을 쓸필요는없지만 관계를 알아보기 쉽게 같은 컬럼명 사용**
- 자식테이블에 값을 먼저 넣을수 없다.
    - 참조되는 칼럼에 데이터가 있어야 값을 넣을 수 있다.
- **ON DELETE CASCADE**
    - 참조되는 부모 테이블의 행에 대한 DELETE를 허용
    - 즉, 참조되는 부모테이블 값이 삭제되면 연쇄적으로 자식테이블 값 역시 삭제
- **ON DELETE SET NULL**
    - 참조되는 부모 테이블의 행에 대한 DELETE를 허용한다
    - 부모테이블의 값이 삭제되면 해당 참조하는 자식 테이블의 값들은 NULL값으로 설정됨
---

### 복합키 
> 기본키를 구성하는 컬럼이 복수일수는 있어도,기본키가 복수일 수는없다!
- 컬럼 두개 이상을 묶어서 UNIQUE,PRIMARY KEY 제약 지정하는 것.
- 하나의 컬럼에 있는 데이터로는 유일성을 지정할 수 없을 때 사용함
- 최대 32개 컬럼까지 하나로 묶어서 지정 가능
- 복합 외래키 설정은 참조하는 테이블에도 복합키가 설정된 경우에 지정하며, 컬럼의 구성이 동일해야 한다.
```
CREATE TABLE 테이블명(
    컬럼1 데이터타입,
    컬럼2 데이터타입,

    CONSTRAINT 제약조건명 PRIMARY KEY(칼럼1,칼럼2)
);
```
--- 
### 슈퍼키(Spuer Key)
>한 릴레이션 내에 있는 속성들의 집합으로 구성된 키
- 릴레이션을 구성하는 모든 튜플 중 슈퍼키로 구성된 속성의 집합과 동일한 값은 나타나지 않는다.
- 슈퍼키는 릴레이션을 구성하는 모든 튜플에 대해 **유일성(Unique)** 은 만족하지만 **최소성(Minimality)** 은 만족하지 못한다.
    - 유일성(Unique): 하나의 키값으로 하나의 튜플만을 유일하게 식별할 수 있어야한다.
    - 최소성(Minimality): 키를 구성하는 속성 하나를 제거하면 유일하게 식별할 수 없도록 꼭 필요한 최소의 속성으로 구성되어야 한다.
- 슈퍼키 중에서 유일성과 최소성을 모두 만족시키는 것들이 **후보키**가 된다.

### 후보키(Candidate Key)
>릴레이션을 구성하는 속성들 중에서 튜플을 유일하게 식별하기 위해 사용되는 속성들의 부분집합
- 후보키는 유일성과 최소성을 모두 만족한다.

### 대체키(Alternate Key)
>후보키 중에서 선정된 기본키를 제외한 나머지 후보키를 의미한다.