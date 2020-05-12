## Package (패키지)
>논리적 연관성이 있는 PL/SQL타입, 변수, 상수, 서브 프로그램, 커서, 예외등의 항목을 묶어 놓은 객체<BR>패키지는 컴파일 과정을 거쳐 DB에 저장되며, 다른 프로그램에서 패키지의 항목을 참조,공유,실행할 수 있다.
### 패키지의 장점
1. **모듈화 기능**
>업무적으로 연관성이 있거나 비슷한 기능을 수행하는 서브 프로그램이나 <BR>변수,상수,커서,사용자 정의 타입들을 하나의 패키지에 담아두면 이해하기도, 관리하기도 쉽다
2. **프로그램 설계의 용이성**
>패키지는 선언부(명세부)과 본문(몸체부)로 구성되는데, 선언부만 있어도 컴파일한 뒤 저장이 가능하다
3. **캡슐화**
>패키지 선언부는 외부에 공개되지만,패키지에 본문은 외부에서 볼 수 없다.<BR>즉, 정보 은닉 기능이 지원되는것이며, 외부 모듈에 영향을 주지않고도 패키지 본문 내용은 언제든지 수정할 수 있다.
4. **보다 나은 성능**
>패키지에 있는 서브프로그램을 호출하면 일단 해당 패키지 전체를 메모리에 올려놓는데<BR> 이후 계속 호출하더라도 메모리에 올라가있는 상태이므로 더 나은 성능을 보인다.

### 패키지 구조
- **선언부**
    - **표기형식**
    ```SQL
    CREATE [OR REPLACE] PACKAGE 패키지_명
    IS
    TYPE 구문;
    상수명 CONSTANT 상수타입;
    예외명 EXCEPTION;
    변수명 변수타입;
    커서구문;

    FUNCTION 함수_명 (매개변수1 IN 매개변수1타입, 매개변수2 IN 매개변수2타입,...)
    RETURN 반환타입;
    PROCEDURE 프로시저_명 (매개변수1 [IN | OUT | INOUT] 매개변수1타입,...);

    END 패키지_명;
    ```
- **몸체부**
    - **표기형식**
    ```SQL
    CREATE [OR REPLACE] PACKAGE BODY 패키지_명
    IS
    상수명 CONSTANT 상수타입;
    변수명 변수타입;
    커서 정의 구문;

    FUNCTION 함수명 (매개변수1 IN 매개변수1타입, 매개변수2 IN 매개변수2타입,...)
    RETURN 변환타입
    IS
    ...
    BEGIN
    ...
    END 함수명;

    PROCEDURE 프로시저_명 (매개변수1 [IN | OUT | INOUT] 매개변수1타입,...)
    IS
    ...
    BEGIN
    ...
    END 프로시저_명;
    ...
    END 패키지_명;

    ```
### DBMS OUTPUT 패키지 - 화면에 출력기능
>SQL*Plus 또는 SQL *DBA 에서 디버깅 또는 출력 메시지 그리고 reports를 출력하기 위한 패키지이다.
- PL/SQL은 화면에 출력하는 기능이 없으며, 오라클에서 화면에 출력하기 위해 DBMS_OUTPUT 패키지를 제공