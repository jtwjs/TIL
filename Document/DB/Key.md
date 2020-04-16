## KEY


### PK(Primary Key) 기본키
> 주키,기본키,식별자 등으로 불린다.
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
### FK(Foreign Key) 외부키
> 외부키,외래키,참조키,외부 식별자 등으로 불린다.
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