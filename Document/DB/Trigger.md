## Triger(트리거)
> 테이블에 어떤 **이벤트**가 발생했을 떄 , **자동으로** 사용자가 정의한 **PL/SQL 명령을 실행 할 수 있는** 구문

- **Row-Level Triggers(행 트리거)** 
    - 트랜잭션내의 **각 행에 대해 한번씩 수행**
    - 컬럼의 각각의 행의 데이터 행변화가 생길때마다 실행되며 데이터 행의 값을 제어할 수 있다.
    - 칼럼의 데이터 행이 변화가 오면 실행된다.
    - 변경 후의 행은 **OLD**, *NEW* 사용하여 가져 올수 있다.
- **Statement-Levl Triggers(문장 트리거)** [DEFAULT]
    - 트리거 이벤트가 발생하면 많은 행에 대해 변경작업이 발생하더라도 **오직 한번만 트리거를 발생시킴**
    - 컬럼의 각 데이터 행을 제어 할 수 없다.
### Trigger 생성

```sql
CREATE [OR REPLACE] TRIGGER 트리거명 
-- 트리거가 실행되는 시점이 EVENT의 전 또는 후 지정
[BEFORE | AFTER] 
-- 이벤트가 일어나는 대상 지정
[INSERT | DELETE | UPDATE] ON 테이블명|뷰명|SCHEMA|DATABASE
[Referencing OLD AS{변경전 값을 참조하는 변수명} NEW AS {변경 후 값을 참조하는 변수명}]
[FOR EACH ROW] --이옵션을 사용하면 행 트리거 가됨 
[WHEN (condition)] --필요한 경우 조건절 부여
DECLARE    -- triger문
-- 변수선언
BEGIN
-- 트리거 PL/SQL 명령 작성
EXCEPTION 
-- 예외처리
END;
/
```
- **FOR EACH ROW**
    - 행 트리거(SQL 문장의 각 ROW에 대해 한번 씩 실행)임을 알림
- **BEFOR | AFTER**
    - BEFORE : SQL 문장이 실행되기 전 트리거가 먼저 실행됨
    - AFTER : SQL 문장이 실행된 후 트리거가 실행됨
- **WHEN 조건**
    - 사용자의 트리거 이벤트 중에 조건을 만족하는 데이터만 트리거 한다.
- **REFERENCING**  : 영향 받는 행의 값을 참조
    - **:OLD** : 참조 전 열의 값, :OLD.컬럼명
        - INSERT : 입력 전 자료
        - UPDATE : 수정 전 자료
        - DELETE : 삭제할 자료
    - **:NEW** : 참조 후 열의 값, :NEW.컬럼명
        - INSERT : 입력할 자료
        - UPDATE : 수정할 자료
### Trigger 생성시 고려사항
1. 트리거는 각 테이블에 최대 3개까지 가능
2. 트리거 내에서는 COMMIT,ROLLBACK 문을 사용할 수 없다.
3. 이미 트리거가 정의된 작업에 대해 다른 트리거를 정의하면 기존의 것을 대체함
4. 뷰나 임시 테이블을 참조할 수 있으나 생성 할 수 없다.
5. 트리거 동작은 이를 삭제하기 전까지 계속된다.

### Trigger 활성/비활성화

```sql
ALTER TRIGGER 트리거명 {DISABLE | ENABLE}

ALTER TABLE 테이블명 {DISABLE | ENABLE} ALL TRIGGER;
--테이블에 속한 트리거 활성화/비활성화
```
### 트리거 수정 후 재컴파일

```sql
ALTER TRIGGER 트리거명 COMPILE;
```
### Trigger 상태 확인

```sql
SELECT 테이블명, STATUS
FROM USER_TRIGGERS; 
--테이블명과 트리거 활성 상태를 확인할 수 있다.
```
### Trigger 삭제 구문

```sql
DROP TRIGGER [schema.]trigger
```

- EX:)
```SQL
-- 상품테이블 생성
CREATE TABLE PRODUCT(
PRODUCT_CODE CHAR(6) PRIMARY KEY,
PRODUCT_NAME VARCHAR2(12) NOT NULL,
MANUFACTURER VARCHAR(12),
RETAIL_PRICE NUMBER(8),
INVENTORY_QUANTITY NUMBER DEFAULT 0
);

-- 입고테이블 생성
CREATE TABLE WAREHOUSING(
WH_NO NUMBER(6) PRIMARY KEY,
PRODUCT_CODE CHAR(6) REFERENCES PRODUCT(PRODUCT_CODE),
WH_DATE DATE DEFAULT SYSDATE,
WH_COUNT NUMBER(6),
WH_PRICE NUMBER(8),
WH_AMOUNT NUMBER(8)
);

-- 상품테이블 샘플데이터 입력
INSERT INTO PRODUCT(PRODUCT_CODE,PRODUCT_NAME,manufacturer,retail_price)
VALUES('A00001','세탁기','LG',500);
INSERT INTO PRODUCT(PRODUCT_CODE,PRODUCT_NAME,manufacturer,retail_price)
VALUES('A00002','컴퓨터','LG',700);
INSERT INTO PRODUCT(PRODUCT_CODE,PRODUCT_NAME,manufacturer,retail_price)
VALUES('A00003','냉장고','샘숭',600);

-- 입고 트리거 생성
CREATE OR REPLACE TRIGGER TRG_01
AFTER INSERT ON WAREHOUSING
FOR EACH ROW
BEGIN
    UPDATE PRODUCT
    SET INVENTORY_QUANTITY = INVENTORY_QUANTITY + :NEW.WH_COUNT
    WHERE PRODUCT_CODE = :NEW.PRODUCT_CODE;
END;
/

-- 갱신 트리거 생성
CREATE OR REPLACE TRIGGER TRG02
AFTER UPDATE ON WAREHOUSING
FOR EACH ROW
BEGIN
    UPDATE PRODUCT
    SET INVENTORY_QUANTITY = INVENTORY_QUANTITY + (-:OLD.WH_COUNT+:NEW.WH_COUNT)
    WHERE PRODUCT_CODE = :NEW.PRODUCT_CODE;
END;
/

-- 삭제 트리거 생성
CREATE OR REPLACE TRIGGER TRG03
AFTER DELETE ON WAREHOUSING
FOR EACH ROW
BEGIN
    UPDATE PRODUCT
    SET INVENTORY_QUANTITY = INVENTORY_QUANTITY -:OLD.WH_COUNT
    WHERE PRODUCT_CODE = :OLD.PRODUCT_CODE;
END;
/

```