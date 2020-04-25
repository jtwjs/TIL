## CallableStatement (Stored Procedure)
> SQL의 스토어드 프로시저(Stored Procedure)를 실행시키기 위해 사용되는 인터페이스
- 스토어드 프로시저로 값을 받아오려면 호출하기 앞서 반드시 CallableStatement 인터페이스의 <br>registerOutParameter() 메소드를 호출해야 한다.
- PreparedStatement 인터페이스로부터 상속받았기 때문에 **setXXX()메소드 사용 가능**
- **CallableStatement** 객체는 모든 DBMS들에 대한 표준방법으로 저장 프로시저를 호출하는 방법을 제공
- **?는 매개변수의 의한 저장위치로 취급된다.**
### JDBC에서 저장 프로시저를 호출하기 위한 문법
- ```{call procedure_name[(?,?,...)]} ```
- ```{? = call procedure_name[(?,?,...)]} ```
    - 결과 매개변수를 리턴하는 프로시저를 위한 문법
- ```{call procedure_name}```
    - 매개변수가 없는 저장 프로시저를 위한 문법
### CallableStatement 객체 생성
>CallableStatement 객체는 Connection의 prepareCall() 메소드에 의해 생성됨
-   ```java
    CallableStatement cstmt = conn.prepareCall("{call 프로시저_명(?,?)}");
    ```
- ? 위치가 IN, OUT, 또는 INOUT 매개 변수인지는 호출되는 저장 프로시저에 의존한다.
### IN / OUT 매개변수
- **IN 매개변수**
    - CallableStatement객체로 **IN 매개변수를 넘겨주는 것**은  PreparedStatement로부터 상속받은 **setXXX()메소드**이다
    - 넘겨질 값의 데이터형은 사용할 setXXX()메소드를 결정한다

- **OUT 매개변수**
    - 각 OUT 매개변수의 SQL형(Type)은 CallableStatement 객체를 실행할 수 있기전에 등록되어져야 한다
    - **SQL형을 등록하는 것은 registerOutParameter() 메소드를 사용**
    - SQL문이 실행되어진 다음에 CallableStatement의 getXXX() 메소드는 매개변수 값을 사용한다.
    - getXXX()메소드는 그 매개변수를 위해 등록되어진 SQL데이터타입에 상응하는 자바의 데이터타입이다.
    - registerOutParameter는 SQL형을 사용하고(DB가 리턴할 SQL형과 매칭하기위해)<br>getXXX()메소드는 이것을 자바데이터타입으로 캐스트(cast)한다.
    ```java
    CallableStatement cstmt = conn.prepareCall("{call 프로시저_명(?,?)}");
    cstmt.registerOutparameter(1,java.sql.Types.TINYINT);
    cstmt.registerOutparameter(2,java.sql.Types.DECIMAL,3);
    cstmt.executeQuery();
    byte x = cstmt.getByte(1);//첫번째 OUT 매개변수로부터 자바 byte 검색
    java.math.BigDecimal n = cstmt.getBigDecimal(2,3);
    //두번쨰 OUT매개변수로부터 (소수점 뒤에 세개의 숫자를 가진)BigDecimal 객체를 검색
    ```
>ResultSet와는 달리, CallableStatement는 점진적으로 큰 OUT값들을 검색하기 위한 특별한 메커니즘을 제공하지 않음

### INOUT 매개변수
>출력을 받아들이고 입력도 공급하는 매개변수(**INTO 매개변수**)는 PreparedStatement로부터 상속받은 적당한 **setXXX()** 메소드의 호출외에 **registerOutParameter()** 메소드의 **호출을 요구한다**.
- **setXXX()** : 매개변수의 값을 입력 매개변수로 설정
    - 드라이버가 SQL 값으로 변환된 후 DB로 전송할 자바값을 제공
    - 이 IN값의 SQL형과 registerOutParameter()메소드에 공급되어지는 값은 같아야한다.
- **registerOutParameter()** : SQL형을 출력 매개변수로 등록