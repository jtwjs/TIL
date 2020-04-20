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
- **REVOKE** : 권한 취소를 위한 명령어
    - **표기형식**
    ```SQL
    REVOKE {권한명 | all}
    ON 테이블명
    FROM {사용자명 | role_name | public};
    ```
- 사용자등급 지정 및 해제
    - ```GRANT 사용자등급 TO 사용자_ID_리스트[IDENTIFIED BY 암호];```
    - ```REVOKE 사용자등급 FROM 사용자_ID_리스트;```
- 테이블 및 속성에 대한 권한 부여 및 취소
    - ```GRANT 권한_리스트 ON 개체 TO 사용자 [WITH GRANT OPTION];```
    - ```REVOKE [GRANT OPTION FOR] 권한_리스트 ON 개체 FROM 사용자 [CASCADE];
    - 권한종류: ALL,SELECT,INSERT,DELETE,UPDATE,ALTER 등
    - WITH GRANT OPTION: (객체권한)부여받은 권한을 다른 사용자에게 다시 부여할 수 있는 권한을 부여
    - WITH ADMIN OPTION: (시스템권한)WITH GRANT OPTION과 동일하지만 권한 취소시 특정 사용자의 권한만 취소된다.
    - GRANT OPTION FOR: 다른 사용자에게 권한을 부여 할 수 있는 권한을 취소한다.
    - CASCADE: 권한 취소 시 권한을 부여받았던 사용자가 다른 사용자에게 부여한 권한도 연쇄적으로 취소한다. 

### 권한의 역할과 종류

#### 시스템 권한 (System Privileges)
>시스템 권한은 사용자의 생성과 제거, DB 접근 및 각종 객체를 생성할 수 있는 권한 <br> 주로 DBA에 의해 부여되며 그 권한의 수가 80가지가 넘는다.
- CREATE USER -새롭게 사용자를 생성하는 권한
- DROP USER - 사용자를 삭제하는 권한
- DROP ANY TABLE 임의의 테이블을삭제
- QUERY REWRITE 함수기반 인덱스 스생성
- BACKUP ANY TABLE 임의의 테이블을 백업할수 있는 작업
- CREATE SESSION 데이터베이스에 접속할 수 있는 권한
- CREATE TABLE - 사용자 스키마에서 테이블을 생성할 수 있는 권한
- CREATE VIEW - 사용자 스키마에서 뷰를 생성할 수 있는 권한
- CREATE SEQUENCE - 사용자 스키마에서 시퀸스을 생성할 수 있는 권한
- CREATE PROCEDURE -사용자 스키마에서 함수를 생성할 수 있는 권한

#### 객체 권한 (Obejct Privileges)
> 객체권한은 테이블,뷰,시퀸스나 함수등과 같은 객체별로 DML문을 사용할 수 있는 권한을 설정하는 것.<BR> 객체의 소유자는 객체에 대한 모든 권한을 가진다.


### 사용자 생성하고 권한부여하기 & 삭제

1. SQLPLUS를 실행 후 SYSTEM 게정으로 접속
2. 사용자 생성
    ```SQL
    CREATE USER [유저명] IDENTIFIED BY[비밀번호]
    DEFAULT tablespace USERS
    QUOTA UNLIMITED ON USERS;
    ```
3. 권한부여하기 
    ```SQL
    GRANT 권한 [,권한] TO [유저명];
    ```
    - 권한
    - RESOURCE: 개체를 생성, 변경,제거 할 수 있는 권한(DDL,DML 사용가능)
    - CONNECT: 데이터베이스에 연결할 수 있는 권한
    - DBA: 데이터베이스 관리자 권한 등등
4. 사용자계정 삭제 (SYSTEM 계정)
    ```SQL
    DROP USER [유저명] CASCADE;  
    --CASCADE 를 적어줌으로써 삭제할 계정에 관련된 모든 스키마가 삭제된다.
    ```
