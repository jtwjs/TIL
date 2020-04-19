## DML (Data Manipulation Language) 데이터조작어
>데이터베이스 사용자가 응용 프로그램이나 질의어를 통해 저장된 데이터를 실질적으로 관리하는데 사용되는 언어이다.
- 데이터베이스 사용자와 데이터베이스 관리 시스템 간의 인터페이스를 제공한다.
### INSERT(데이터 추가)
>테이블에 새로운 튜플을 삽입할 때 사용하는 명령문
- **표기형식**
    ```
    INSERT INTO 테이블명[(속성명1,속성명2,···)]
    VALUES (데이터1,데이터2,···)
    ```
    - 대응하는 속성과 데이터는 개수와 데이터 타입이 일치해야한다.
    - 테이블의 모든 속성을 삽입할 때는 속성명을 생략할 수 있다.
        - CREATE TABLE문에서 기술된 속성 순으로 속성 값들을 지정해야 한다.
    - SELECT문을 사용하여 다른 테이블의 검색 결과를 삽입할 수 있다.
        ```
        INSERT INTO 테이블명[(속성명1,속성명2,···)]
        SELECT 속성명1,속성명2,··· FROM 테이블명 WHERE 조건;
        ```

### NULL 값 삽입하는 다양한방법
>데이터를 입력하는 시점에서 해당 칼럼 값을 모르거나 확정되지 않았을 경우 NULL값 입력
- NULL 값 삽입은 암시적인 방법과 명시적인 방법이있다.
    - 암시적 방법 : 칼럼명 리스트에 칼럼을 생략
        - 즉 다른 칼럼은 값을 입력하지만,생략한 칼럼에서는 암시적으로 NULL값 할당
    - 명시적 방법 : VALUES 리스트에 명시적으로 NULL 또는 ''(빈문자열) 입력

### UPDATE(데이터 수정)
>테이블에 있는 튜플들 중에서 특정 튜플의 내용을 갱신할 때 사용하는 명령문
- **표기형식**
    ```
    UPDATE 테이블명
    SET 속성명=데이터[,속성명=데이터,···]
    WHERE 조건;
    ```
    - EX:) <사원>테이블에서 황진이의 부서를 "기획"으로 변경하고 기본급을 5 인상하는 SQL문
    - ``` UPDATE 사원 SET 부서='기획',기본급=기본급+5 WHERE 이름='황진이';```
### DELTE (데이터 삭제)
>테이블에 있는 튜플들 중에서 특정 튜플을 삭제할때 사용
- 모든 데이터를 지워도 테이블은 삭제되지 않는다.
    - ※ROLLBACK; 으로 복구가능
- **표기형식**
    ```
    DELETE FROM 테이블명
    WHERE 조건;
    ```
    - 모든 튜플을 삭제할 때는 WHERE절을 생략한다.
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
