## Stored_Function (저장함수)
>실행(함수 호출)후 결과를 되돌려 받을 수 있는 return 데이터;
- 반환값이 하나일때 편리함
- **표기형식**
    ```sql
    CREATE [OR REPLACE] FUNCTION 함수_명( 매개변수 선언)
    RETURN 데이터타입
    IS
        지역변수 선언;
    BEGIN
        실행한 SQL문
        RETURN DTAE
    END;
    /

    VARIABLE 변수_명 데이터타입;
    EXECUTE  변수_명 : = 함수_명();
    ```
    - VARIABLE : 바인드변수 자료형;
    - EXECUTE : 바인드변수 := 함수명();

### Bind(Host) 변수
- Bind변수는 실행계획이 세워진 후 그 값이 결정되는 변수이며<br> 값이 바뀌더라도 실행계획에는 영향을 주지않는다.
- SQL, PL/SQL에서 사용가능하며 SQL에서 사용하는 경우 **Variable**로 선언해줘야 하며 <br>PL/SQL Code에서 사용될 때 **콜론(:)을 앞에 붙여 사용**한다.
- 호스트환경에서 선언되므로 Host변수 라고도 하며 PL/SQL블록이 실행된 후에도 접근가능
- PRINT 명령으로 값을 확인할 수 있다.
    - **SET AUTOPRINT ON** : 바인드 변수 자동출력 