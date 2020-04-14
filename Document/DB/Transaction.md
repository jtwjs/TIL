## Transaction(트랜잭션)
>데이터베이스의 트랜잭션은 데이터처리 단위<br>COMMIT이 일어난 시점부터 다음의 COMMIT전까지의 작업이 하나의 트랜잭션
- 하나의 논리적 작업 단위를 구성하는 하나 이상의 sql문
- 트랜젝션단위에서 발생한 작업을 데이터베이스에 저장(확정)  -> **commit**
- 트랜젝션단위에서 발생한 작업을 데이터베이스에 되돌리기(취소) -> **rollback**
- 하나의 트랜젝션은  All-or-nothing 방식
- DML은 이들이 실행됨과 동시에 트랙잭션이 진행됨
### Transaction의 사용 이유
- 데이터의 일관성을 유지하면서 안정적으로 데이터를 복구시키기 위해서
### ※주의할점※

>실제로 developer 같은것을 써서 insert,update,delete를 commit을 안해줫는데도 select가 되어 적용된 결과를 볼수 있다.<br>
하지만 이것은 *현재 세션에만 볼수 있는 내용*이고 *최종적으로 DB에 반영된 상태가 아니다*
---
### COMMIT
>TRansaction(INSERT,UPDATE,DELETE) 작업 내용을 실제 DB에 저장
- ※ DDL,DCL 명령문이 실행되는 순간 자동으로 **commit** 발생 

    ```
    --EX:)
    INSERT INTO TestOracle VALUES(1,'TEST');
    COMMIT;
    SELECT * FROM TestOracle; --1, TEST
    
    --이런식으로 COMMIT을 하여 저장하면서 트랜잭션이 종료되고 결과가 반영되는것
    --INSERT말고도 UPDATE,DELETE 같은 경우도 적용

    ```
### ROLLBACK
>트랙잭션 작업단위가 시작한 지점으로 복귀 (이전 COMMIT상태로만 복귀)
- 비정상적인 종료, SYSTEM FAILURE 일어나면 자동 ROLLBACK;

    ```
    --EX:)
    DELETE INTO TestOracle WHERE oracleNo = 3;
    SELECT * FROM TestOracle; --1, TEST

    --실수로 삭제했을 경우 ROLLBACK을 사용
    ROLLBACK;
    --INSERT말고도 UPDATE,DELETE 같은 경우도 적용

    ```
### SAVEPOINT
>SAVEPOINT 명령을 써서 현재의 트랜잭션을 작게 분할할수 있다.
- 저장된 SAVEPOINT는 ROLLBACK TO SAVEPOINT 문을 사용하여 표시한곳 까지 ROLLBACK할수있다.
- 여러 개의 SQL 문의 실행을 수반하는 트랜잭션의 경우, 사용자가 트랜잭션 중간 단계에서 세이브포인트를 지정할수 있다.
- 롤백과 함께 사용해서 현재 트랜잭션 내의 특정 세이브포인트까지 롤백 가능

    ```
    SAVEPOINT 세이브포인트명; --세이브포인트지정
    SAVEPOINT TO 세이브포인트명; --세이브포인트로 rollback
    ```
### COMMIT ROLLBACK 장점
- **데이터 무결성** 보장
- 영구적으로 데이터를 변경하기 전에 **데이터의 변경사항을 확인** 가능
- 논리적으로 연결된 작업을 **그룹화**할수 있다.