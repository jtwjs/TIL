## Triger(트리거)
> 테이블에 어떤 **이벤트**가 발생했을 떄 , **자동으로** 사용자가 정의한 **PL/SQL 명령을 실행 할 수 있는** 구문

- Row-Level Triggers : 트랜잭션내의 각 행에 대해 한번만 수행
    - 컬럼의 각각의 행의 데이터 행변화가 생길때마다 실행되며 데이터 행의 값을 제어할 수 있다.
- Statement-Levl Triggers : 트랜잭션내에서 한번만 수행
    - 컬럼의 각 데이터 행을 제어 할 수 없다.
### Trigger 생성

```
CREATE [OR REPLACE] TRIGGER 트리거명 [BEFORE | AFTER]
// 트리거가 실행되는 시점이 EVENT의 전 또는 후 지정
triggering-event[Insert,delte,update] ON 테이블명|뷰명|SCHEMA|DATABASE
// 이벤트가 일어나는 대상 지정
[Referencing OLD AS{변경전 값을 참조하는 변수명} New AS {변경 후 값을 참조하는 변수명}]
[FOR EACH ROW]// 이옵션을 사용하면 행 트리거 가됨 
[WHEN (condition)] //필요한 경우 조건절 부여

DECLARE    // triger문
// 변수선언
BEGIN
// 트리거 PL/SQL 명령 작성
EXCEPTION 
//예외처리
END;

```

### Trigger 생성시 고려사항
1. 트리거는 각 테이블에 최대 3개까지 가능
2. 트리거 내에서는 COMMIT,ROLLBACK 문을 사용할 수 없다.
3. 이미 트리거가 정의된 작업에 대해 다른 트리거를 정의하면 기존의 것을 대체함
4. 뷰나 임시 테이블을 참조할 수 있으나 생성 할 수 없다.
5. 트리거 동작은 이를 삭제하기 전까지 계속된다.

### Trigger 활성/비활성화

```
ALTER TRIGGER 트리거명 {DISABLE | ENABLE}

ALTER TABLE 테이블명 {DISABLE | ENABLE} ALL TRIGGER;
//테이블에 속한 트리거 활성화/비활성화
```
### 트리거 수정 후 재컴파일

```
ALTER TRIGGER 트리거명 COMPILE;
```
### Trigger 상태 확인

```
SELECT 테이블명, STATUS
FROM USER_TRIGGERS; 
//테이블명과 트리거 활성 상태를 확인할 수 있다.
```
### Trigger 삭제 구문

```
DROP TRIGGER [schema.]trigger
```