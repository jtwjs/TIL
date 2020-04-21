## ROLE (롤)
> 사용자에게 허가 할 수 있는 권한들의 집합
- ROLE을 이용하면 권한 부여와 회수를 쉽게 할 수 있다.
- ROLE은 CREATE ROLE 권한을 가진 USER에 의해 생성된다.
- 한 사용자가 여러개의 ROLL을 ACCESS할 수 있고, 여러 사용자에게 같은 ROLE을 부여 할수 있다.
- 시스템 권한을 부여하고, 취소할 때와 동일한 명령을 사용하여 사용자에게 부여하고, 취소한다.
- 사용자는 ROLE에 ROLE을 부여할 수 있다.
- 오라클 DB를 설치하면 기본적으로 CONNECT, RESOURCE, DBA ROLE이 제공된다.

![ROLE](https://user-images.githubusercontent.com/60641307/79813561-f40cfd80-83b6-11ea-88ba-c28deb6be680.jpg)


### 사전 정의된 롤의 종류
- CONNECT 롤
> 사용자가 데이터베이스에 접속 가능하도록 하기 위해 가장 기본적인 시스템 권한 8가지를 묶어놓음
- RESOURCE 롤
> 사용자가 객체(테이블,뷰,인덱스)를 생성할 수 있도록 하기 위해서 시스템 권한을 묶어놓음
- DBA 롤
> 시스템자원을 무제한적으로 사용하며 시스템관리에 필요한 모든 권한을 부여할 수있는 강력한 권한을 보유한 롤

### ROLE 생성
- **표기형식** : ```CREATE ROLE 롤_명 ```
- ROLE의 부여순서
    1. ROLE의 생성 :```CREATE ROLE 롤_명 ```
    2. ROLE에 권한 부여 : ```GRANT create ssesion, create table TO 롤_명```
    3. ROLE을 사용자 또는 ROLE에게 부여 : ```GRANT 롤_명 TO 사용자_명[, ROLE] ```

### ROLE 회수
- **표기형식** : ``` REVOKE 롤_명 FROM 사용자_명; ```
    - 데이터베이스 관리자로 수행 가능
### ROLE 삭제
- **표기형식** : ``` DROP 롤_명 ; ```
### ROLE 조회
> 사용자에게 부여된 롤 확인하는 방법
1. ``` SELECT * FROM DICT WHERE TABLE_NAME LIKE '%ROLE%'; ```
    - 위 조회 결과로 얻어진 데이터 딕셔너리를 통해서 부여된 권한에 대한 정보를 확인
2.  ``` SELECT * FROM USER_ROLE_PRIVS; ```
    - 롤관련 데이터 딕셔너리 중에서 현재 사용자에게 부여된 롤 확인하는 방법

### ROLE 관련 데이터 사전

|데이터사전|설명|
|:--------|:----------|
|ROLE_SYS_PRIVS|ROLE에 부여된 시스템 권한|
|ROLE_TAB_PRIVS|ROLE에 부여된 테이블 권한|
|USER_ROLE_PRIVS|현재 사용자가 ACESS할 수 있는 ROLE|
|USER_TAB_PRIVS_MADE|현재 사용자가 소유한 객체에 부여된 객체 권한|
|USER_TAB_PRIVS_RECD|현재 사용자에게 부여된 객체 권한|
|USER_COL_PRIVS_MADE|현재 사용자 소유의 객체 중 칼럼에 부여된 오브젝트 권한|
|USER_COL_PRIVS_RECD|현재 사용자 부여된 특정 컬럼에 대한 객체 권한|
