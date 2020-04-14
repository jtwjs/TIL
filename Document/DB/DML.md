## DML (Data Manipulation Language) 데이터조작어

### INSERT(데이터 추가)
>테이블에 데이터(행)을 추가할 때 사용
- 가장 기본적인 형태의 INSERT문
    ```

    INSERT INTO 테이블명 (컬럼1,컬럼2,컬럼3....)
    VALEUS (값1,값2,값3,.....)
    -- 나열된 컬럼과 값의 타입 갯수가 일치하여야한다.

    -- 모든 데이터를 입력할 경우
    INSERT INTO 테이블명 --테이블명만써두된다.
    VALUES(값1,값2,값3....)
    -- 테이블 생성할때 등록했던 컬럼 순서대로..!

    ```
### NULL 값 삽입하는 다양한방법
>데이터를 입력하는 시점에서 해당 칼럼 값을 모르거나 확정되지 않았을 경우 NULL값 입력
- NULL 값 삽입은 암시적인 방법과 명시적인 방법이있다.
    - 암시적 방법 : 칼럼명 리스트에 칼럼을 생략
        - 즉 다른 칼럼은 값을 입력하지만,생략한 칼럼에서는 암시적으로 NULL값 할당
    - 명시적 방법 : VALUES 리스트에 명시적으로 NULL 또는 ''(빈문자열) 입력

### Sub Query로 데이터 삽입하기
> INSERT INTO 다음에 VLAUES 절 대신 SubQuery 사용할수 있다.

    ```
    ```

### INSERT ALL (다중 테이블에 다중 행 입력)
>INSERT ALL 명령문은 서브 쿼리의 결과 집합을 조건 없이 여러 테이블에 동시에 입력하기 위한 명령문 <br> 하나의 insert 문으로 여러개의 테이블에 동시에 하나의 행을 입력하는것.

1. 
2.
3.
4.

---
### UPDATE(데이터 수정)
>테이블에 저장된 데이터를 수정하기 위해서 사용

    ```
    UPDATE 테이블명
    SET 컬럼1 = '값1', 컬럼2 = '값2',...
    WHERE  조건

    --EX)사번이 '10006'인 사원의 부서를 '인사부'로 수정
    UPDATE EMP_INFO
       SET EMP_DEPT = '인사부'
     WHERE EMP_ID = '10006' 
     
    ```
### DELTE (데이터 삭제)
>모든 데이터를 지워도 테이블은 삭제되지 않는다. <br> ※※ROLLBACK; 으로 복구가능
    ```
    DELETE FROM 테이블명
    WHERE 조건
    ```
### MERGE (테이블 합병)
>조건에 따라서 데이터의 삽입,갱신,삭제 작업을 한번에 할수 있다.<br>
>구조가 같은 두개의 테이블을 하나의 테이블로 합치는 기능을 한다
- 테이블에 기존에 존재하는 행이 있는 경우 UPDATE(DELETE포함가능)을 수행
- 존재하지 않는 행일경우 새로운 행으로 추가(INSERT를 수행)
- 대상 테이블에 대한 UPDATE/INSERT 조건은 ON절에 의해 결정

    ```
    MERGE INTO [스키마.]테이블명
    USING (합병할 테이블명)
    ON(Update될 조건)
    WHEN MATCHED THEN 
        UPDATE SET 컬럼1= 값1, 컬럼2= 값2,...
    WHERE UPDATE 조건
        DELTE WEHER update_delete 조건
    WHEN NOT MATCHED THEN
        INSERT (컬럼1,컬럼2,...)
        VALUES (값1,값2,...)
        WHERE insert 조건;
    ```
- **INTO** : DATA가 UPDATE되거나 INSERT될 테이블 또는 뷰를 지정
- **USING** : 비교할 SOURCE 테이블 또는 뷰나 서브쿼리를 지정, 
    - INTO절의 테이블과 동일하거나 다를수 있다.
- **ON** : UPDATE나 INSERT를 하게될 조건
    - 해당 조건을 만족하는 DATA가 있으면 **WHEN MATCHED** 절을 실행
    - 해당 조건을 만족하는 DATA가 없으면 **WHEN NOT MATCHED** 절을 실행
- **WHEN MATCHED** : ON 조건절이 TRUE인 ROW에 수행할 내용 (UPDATE,DELETE 포함할수있음)
- **WHEN NOT MATCHED** : ON 조건절에 맞는 ROW가 없을 때 수행할 내용 (INSERT)
