## PreparedStatement 클래스
- Statement와 PreparedStatement의 차이는 **캐시 사용 유무** 이다.
- **PreparedStatement**는 **객체를 캐시에 담아 재사용**한다.
    - 1)쿼리 문장 분석<br>2)컴파일<br>3)실행<br>PreparedStatement는 처음 한번만 세 단계를 거친후 캐쉬에 담아 재사용을 한다는것
    - 동일한 쿼리를 반복적으로 수행한다면 DB에 훨씬 적은 부하를 주며 성능도좋다.
- **Statement는 취약점을 가지고 있기 때문에 사용하지 않는것이 권고**되고있다.

1. **Statement**
```java
String sqlstr = "SELECT name, memo FROM TABLE WHERE num = " +num;
Statement stmt = conn.createStatement();
ResultSet rst = stmt.executeQuery(sqlstr);
```
- **sqlstr을 실행 시 결과값을 생성**
>Statement executeQuery() 나 executeUpdate() 를 실행하는 시점에 파라미터로 SQL문을 전달하는데<br> 이 때 전달되는 SQL문은 완성된 형태로 한눈에 무슨 SQL문인지 파악하기 쉽다.<br> 하지만 이녀석은 sQL문을 수행하는 과정에서 매번 컴파일을 하기 때문에 성능상 이슈가 있다.

2. **PreparedStatement**
```java
String sqlstr = "SELECT name, memo FROM TABLE WHERE num = ? ";
PreparedStatement pstmt = conn.prepareStatement(sqlstr);
pstmt.setInt(1,num);
ResultSet rst = pstmt.executeQuery();
```
- **sqlstr은 생성시에 실행**
