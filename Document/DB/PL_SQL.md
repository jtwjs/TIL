## PL/SQL 명령문
>SQL을 확장한 절차적 언어 PL/SQL(Procedural Language/SQL)의 약어
- 오라클 DB 환경에서 실행되는 절차적인 데이터베이스 프로그래밍 언어
- 표준 SQL과 3세대 언어의 강력한 일부 기능을 포함한 SQL의 확장 언어
- PL/SQL에서는 프로그램 단위를 블록(block)이라 부르며, 애플리케이션 로직들을 작성
- 오라클에서 지원하는 프로그래밍 언어의 특성을 수용하여 SQL에서는 사용할수 없는<br> 절차적 프로그래밍 기능을 가지고 있어 SQL의 단점을 보완하였다.

### 장점
- 프로시저 생성자와 SQL의 통합
- 성능 향상: 잘 만들어진 PL/SQL 명령문이라는 가정하에
- 모듈식 프로그램 개발 가능 : 논리적인 작업을 진행하는 여러 명령어들을 하나의 블록으로 만들수있다.
- 이식성이 좋다.
- 예외처리 가능
- SQL의 다음 단점을 해결
    1. 변수가 없다.
    2. 한번에 하나의 명령문만 사용가능해서 트래픽증가
    3. 제어문 사용불가
    4. 예외처리가 없다.

### 오라클 환경에서 PL/SQL을 학습하는 이유
- 오라클 개발 도구를 수행하는 모든 프로그래밍의 기초
- 클라이언트가 아닌 서버 상에서 프로세스를 수행하는데 PL/SQL을 사용함
- PL/SQL을 사용하면 업무 규칙이나 복잡한 로직을 캡슐화할 수 있어, 모듈화와 추상화가 가능
- DB 트리거를 통하여 DB 무결성을 제약하는 복잡한 규칙의 코딩과 변경 내역,데이터를 복사
- PL/SQL은 독립적인 플랫폼 수준을 제공
### 기본 특징
- 블록 단위의 실행을 제공 
    - BEGIN , END;를 사용
    - 마지막 라인에 /를 입력하면 해당블록이 실행
- 변수, 상수 등을 선언하여 SQL과 절차형 언어에서 사용
- 변수의 선언은 DECLARE절에서만 가능, BEGIIN섹션에서 새로운 값이 할당될 수 있다.
- IF문을 사용하여 조건에 따라 문장들을 분기 가능
- LOOP문을 사용하여 일련의 문장을 반복 가능
- 커서를 사용하여 여러 행을 검색 및 처리
- **PL/SQL에서 사용가능한 SQL은 Query,DML,TCL이다.**
    - DDL(CREATE,DROP,ALTER,TURNCATE...),DCL(GRANT,REVOKE)명령어는 동적 SQL을 이용할때만 사용 가능
- **PL/SQL의 SELECT문은 해당 SELECT의 결과를 PL/SQL Engine으로 보낸다**

### PL/SQL에서 제공하는 명령문
- 모든 SQL문
- 변수 및 상수 등의 선언문
- 대입문
- 조건 판단문
- 제어 흐름문
- 반복 처리문

### PL/SQL로 작성할수 있는것은?
- SQL Plus 스크립트(Script)
- 프로시저(Procedure),함수(Function) 서브프로그램
- 패키지(Package)
- 데이터베이스 트리거(Database Trigger)
- 애플리케이션 로직(Application Logic)

```
// PL/SQL의 기본 블록 구조 (프로그램 단위 -> block)

DECLARE [선택] //변수와 상수, 프로시저와 함수 서브프로그램, 커서 등을 선언
    선언문
    ....

------------------------
BEGIN [필수] //처리할 명령문들을 절차적으로 기술
             //- 모든 SQL문, 대입문, 반복 처리문, 조건 판단문, 제어 흐름문, 커서 처리문
    실행문
    ....
------------------------
EXCEPTION [선택] //오류 처리에 관한 예외처리 명령문을 기술

    예외처리문
    ....
------------------------
END; [필수]

```