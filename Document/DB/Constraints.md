## Constraints(제약조건)

### 무결성 제약조건(Data Integrity Constraint Rule)
>데이터 테이블에 부적절한 자료가 입력되는 것을 방지하기 위해서 테이블을 생성할때<br> 각 컬럼에 대해서 정의하는 여러가지 규칙을 말함 <br> DBMS에서 자동으로 수행한다.

- **NOT NULL**
    - NULL을 허용하지 않는다.
    - column Level만 가능
        - 컬럼명 데이터타입 NOT NULL <-이형식으로만 지정가능하다는 뜻
- **UNIQUE**
    - 중복된 값을 허용하지 않는다.
    - NULL값에 대한 중복 검사를 하지 않는다.
    - 항상 유일값을 갖는다.
- **PRIMARY KEY**
    - NULL을 허용하지않고 중복된 값을 허용하지 않는다.
    - NOT NULL 조건과 UNIQUE 조건을 결합한 형태
- **FOREIGN KEY**
    - 참조되는 테이블의 칼럼의 값이 존재하면 허용한다.
- **CHECK**
    - 저장 가능한 데이터 값의 범위나 조건을 지정하여 설정한 값만을 허용한다.

### 개체 무결성(Entity Integrity)
- 테이블의 레코드(ROW)는 유일한 값을 가져야 한다.
- 모든 테이블의 각각의 row를 유일하게 식별할 수 있는 column의 집합을 가지는데 <br> 이러한 column의 집합 중에서 주요한 것을 PK로 정의한다.
- PK의 값은 항상 유일하며 NULL을 허용해선 안된다.

### 참조 무결성(Referential Integrity)
- 테이블은 FK를 통하여 서로 관계를 맺고 있는데, 다른 테이블 또는 자신 Table 의 <br> Primary Key값을 참조하는 칼럼을 말한다.
- 참조 무결성이 지켜지기 위해서는 FK 칼럼의 값은 참조하는 테이블의 <br> PK 칼럼 값중 하나이거나 NULL을 허용 하는 경우 NULL이어야 한다.


---
### 제약조건 확인하기
- 오라클은 USER_CONSTRAINTS 데이터 딕셔너리 뷰로 제약조건에 관한 정보를 알려준다.
- **USER_CONSTRAINTS**
    - 데이터 딕셔너리 뷰로 조회 하면 내가 만든 제약조건의 정보를 조회할수 있다. 
    - ``` SELECT * FROM USER_CONSTRAINTS;```

- **USER_CONS_COLUMNS**
    - 데이터 딕셔너리 뷰에는 어떤 칼럼의 제약 조건이 정의되었는지 칼럼명이 보이지않는다.
    - USER_CONS_COLUMNS 데이터딕서너리뷰는 제약조건이 지정된 컬럼명도알려준다.
    - ``` SELECT * FROM USER_CONS_COLUMNS; ```
- **USER_TAB_COLUMBS**
    - Column 정보 조회하기


### 제약조건 작성하기
>제약조건은 CREATE TABLE 명령으로 테이블을 생성할 때 테이블에 대해서 제약을 걸 수도 있고, 컬럼에 제약을 걸 수도 있다.
- NOT NULL 제약조건은 칼럼 레벨에서만 정의할 수 있다.
- **Column 레벨방식**
    
    ```
    --EX:)
    CREATE TABLE 테이블명(
        칼럼명 칼럼타입 [CONSTRAINT 제약조건명] 제약조건
        aa     NUMBER  NOT NULL UNIQUE,
        bb     VARCHAR(10)
    );
    ```
- **Table 레벨방식**
    - Table 레벨의 지정방식을 사용해야하는 이유
        - 복합키로 기본키를 지정할 경우
        - ALTER TABLE로 제약 조건을 추가할때

    ```
    CREATE TABLE 테이블명(
        칼럼명  칼럼타입,
        칼럼명2 칼럼타입2,
        칼럼명3 칼럼타입3,
    [CONSTRAINT 제약조건명] 제약조건타입 (column_name)
    );
    column_name을 반드시 작성 해야한다.
    ```
### 제약조건 추가하기 
>테이블 생성이 끝난 후에 제약조건을 추가하려면 ATLER TABLE문에 ADD절을 사용
- 별도로 제약조건 추가하는방식은 TABLE 레벨로 실행
- DEFUALT 는 테이블을 생성 할때만 작성할수 있다.
```
ALTER TABLE 테이블명
ADD [CONSTRAINT 제약조건명]
제약조건타입 (컬럼명)
```

- **NOT NULL 조건 추가하기**
    > 이미 존재하는 테이블에 NOT NULL 제약조건 추가는 MODIFY절 사용
    ```
    ALTER TABLE 테이블명
    MODIFY 컬럼명 CONSTRAINT 제약조건명 NOT NULL;
    ```

### CHECK 제약조건
>입력되는 값을 체크하여 설정된 값 이외에 값이 들어오면 오류 메시지와 함께 명령이 수행되지 못하게 하는것
- 조건으로 데이터의 값의 범위나 특정 패턴의 숫자나 문자 값을 설정할 수 있다.
- **이미 들어가있는 데이터가 조건에 위배되면 적용이 안된다.**
-``` ALTER TABLE [테이블명] ADD CONSTRAINT [제약조건명] [제약조건](범위)```

### DEFAULT 제약조건
>아무값도 입력하지 않아도 NULL 값이 아니라 설정한 값이 기본 값으로 자동 입력되도록 하는 제약 조건
- ```[컬럼명][타입] DEFAULT 기본값```

### 제약조건에 이름 붙이기
> 제약조건 설정시 **CONSTRAINT 키워드**를 사용해서 제약조건에 대한 이름을 지정해 줄 수 있다.
- 이름을 지정하지 않으면 자동으로 생성되는데 나중에 제약조건을 비활성하거나 삭제하는 등의 관리를 위해서 제약조건에 이름을 지정해주는것이 좋다.

### 제약조건 확인하기 
```
SELECT * FROM ALL_CONSTRAINTS
WHERE TABLE_NAME = '테이블명'; -- 테이블명 대문자로
```
- **USER_CONSTRAINTS : 제약조건 정보**
    - 어떤 컬럼에 제약조건이 부여되었는지 확인 불가
```
SELECT TALBE_NAME, CONSTRAINT_NAME,CONSTRAINT_TYPE,R_CONSTRAINT_NAME
FROM USER_CONSTRAINTS
WHERE TABLE_NAME IN('테이블명') -- 테이블명 대문자로
```
- **USER_CONS_COLUMNS : 현재 USER가 가지고 있는 COLUMN에 할당된 제약조건에 대한 정보**
    - 제약조건을 가진 컬럼에 대한 정보를 조회
    - 제약 조건의 종류는 확인 불가능
```
SELECT CONSTRAINT_NAME, TABLE_NAME, COLUMN_NAME
FROM USER_CONS_COLUMNS
WHERE TABLE_NAME IN('테이블명') -- 테이블명 대문자로
```

- **USER_TAB_COLUMNS : 컬럼에 대한 정보**
    - 테이블의 컬럼 정보를 알수 있다.
```
SELECT COLUMN_NAME, DATA_TYPE, DATA_DEFAULT
FROM USER_TAB_COLUMNS
WHERE TABLE_NAME IN('테이블명') -- 테이블명 대문자로
```

### 제약조건 제거하기
>제약조건 제거는 DROP CONSTRAINT 다음에 제거할 제약조건명 명시
- 제약조건을 제거하기 위해서는 **반드시 제약조건명을 제시**해야한다.
```
ALTER TABLE 테이블명
DROP [CONSTRAINT 제약조건명];
```

### 제약 조건의 비활성화와 CASCADE
- **제약 비활성화**
    - 제약 비활성은 제약조건을 삭제하지 않고도 제약조건을 비활성화하여 사용을 잠시 보류하는 기능
    - 제약조건이 설정되면 항상 그 규칙에 따라 데이터 무결성이 보장된다.
    - 특별한 업무를 수행하는 과정에서 이러한 제약조건때문에 작업이 진행되지 못하는경우 사용<BR>
    ``` 제약 비활성 ALTER TABLE 테이블명 DISABLE CONSTRAINT 제약조건; ```<BR>
    ``` 제약 활성 ALTER TABLE 테이블명 ENABLE CONSTRAINT 제약조건; ```
- **CASCADE CONSTRAINTS**
>부모 테이블과 자식테이블 간에 참조 설정이 되어 있을 때 부모 테이블의 제약조건을 비활성화<BR> 시키면서 이를 참조하고 있는 자식 테이블의 제약조건까지 함께 비활성화 시키기 위해 사용
- CASCADE를 쓰면 일시적으로 참조관계를 끊을수 있다.
- 강제로 참조관계를 끊고 부모 테이블을 삭제하는 법
    - ``` DROP TABLE 테이블명 CASCADE CONSTRAINTS; ```
- 강제로 참조관계를 끊고 부모 테이블의 제약조건을 삭제하는 법
    - ``` ALTER TABLE 테이블명 DROP CONSTRAINTS 제약조건명 CASCADE; ```
