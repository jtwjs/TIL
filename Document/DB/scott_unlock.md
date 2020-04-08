## Oracle scott 계정 락해제 방법

/**
* 문서번호: nabiro_201107262355
* 검색어: nabiro, oracle, 오라클, scott, 락해제, 계정, 해제
* 출처: http://sangu12.egloos.com/2791692
* 참조:
 
**/

sqlplus를 실행하여 sys 계정으로 sysdba 권한으로 접속합니다.

SQL>connect sys/비밀번호 as sysdba

SQL> SELECT username, account_status FROM dba_users WHERE username='SCOTT';

결과를 확인합니다. (아마 락이 걸려있겠지요) - EXPIRED & LOCKED 

이후에

SQL> ALTER user scott account unlock;
락을 해제합니다. 

SQL> ALTER user scott IDENTIFIED BY tiger;
scott 계정의 비밀번호를 tiger로 하겠다는 의미입니다. 
(이렇게는 하지마세요. 너무 잘 알려져있는 비밀번호라)

다시 아래의 쿼리문으로 락 상태가 해제되어 있는지 확인합니다. 

SQL> SELECT username, account_status FROM dba_users WHERE username='SCOTT';

이후 scott 계정으로 로그인해봅니다.

SQL> CONN scott/tiger
SQL> DESC emp;
SQL> SELECT * FROM emp;
 

*** 참고로 11g 에서는 sqlplus 실행할 때 "사용자명 입력: " 이라는 프롬프트가 바로 표시됩니다. 
이때 아래와 같이 입력하면 됩니다.

사용자명 입력: sys/비밀번호 as sysdba