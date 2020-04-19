## DCL(Data Control Language) 데이터 제어어
>데이터의 보안, 무결성, 회복, 병행 제어 등을 정의하는데 사용하는 언어
- DCL은 데이터베이스 관리자(DBA)가 데이터관리를 목적으로 사용한다.

### COMMIT / ROLLBACK
> 하나의 트랜잭션은 COMMIT 되거나 ROLLBACK 되어야 한다.
    - 트랜잭션: DB에서 하나의 논리적 기능을 수행하기위한 일련의 연산집합으로서 작업의 단위
- **COMMIT**
    - 트랜잭션의 모든 변경 내용들을 영구적으로 데이터베이스에 반영하는 명령어
    - 트랜잭션이 성공적으로 끝나면 데이터베이스가 새로운 일관성(Consistency) 상태를 가지기 위해 <br>수행된 모든 변경을 데이터베이스에 반영하여 완료(Commit)하여야 한다.
- **ROLLBACK**
    - 변경된 모든 내용을 취소하고 데이터베이스를 이전 상태로 되돌리는 명령어이다.
    - 트랜잭션의 일부를 성공적으로 끝내지 못하면 데이터베이스가 비일관성(Inconsistency)인 상태를 가질수 있기 때문에 <br>일부분만 완료된 트랜잭션은 롤백(Rollback)되어야 한다.
### GRANT / REVOKE
>데이터베이스 관리자가 데이터베이스 사용자에게 권한을 부여하고 취소하기 위한 명령어
- **GRANT** : 권한 부여를 위한 명령어
- **REVOKE** : 구너한 취소를 위한 명령어
- 사용자등급 지정 및 해제
    - ```GRANT 사용자등급 TO 사용자_ID_리스트[IDENTIFIED BY 암호];```
    - ```REVOKE 사용자등급 FROM 사용자_ID_리스트;```
- 테이블 및 속성에 대한 권한 부여 및 취소
    - ```GRANT 권한_리스트 ON 개체 TO 사용자 [WITH GRANT OPTION];```
    - ```REVOKE [GRANT OPTION FOR] 권한_리스트 ON 개체 FROM 사용자 [CASCADE];
    - 권한종류: ALL,SELECT,INSERT,DELETE,UPDATE,ALTER 등
    - WITH GRANT OPTION: 부여받은 권한을 다른 사용자에게 다시 부여할 수 있는 권한을 부여
    - GRANT OPTION FOR: 다른 사용자에게 권한을 부여 할 수 있는 권한을 취소한다.
    - CASCADE: 권한 취소 시 권한을 부여받았던 사용자가 다른 사용자에게 부여한 권한도 연쇄적으로 취소한다. 