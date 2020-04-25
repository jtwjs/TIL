## JDBC

### 자바(이클립스) - 오라클 연동
- **JDK설치디렉토리\jre\lib\ext\에 복사하는 방법**
    1. app\bitcamp\product\11.2.0\dbhome_1\jdbc\lib\ 경로에 **ojdbc6.jar**파일을 복사
    2. 이클립스 jdk 경로("C:\Program Files\Java\jdk1.8.0_152\jre\lib\ext)에 붙여넣기


### JDBC를 이용한 프로그램 작성방법

![그림1](https://user-images.githubusercontent.com/60641307/80165946-aa6f1d80-8617-11ea-9edf-ea423138858c.png)

1. JDBC 드라이버 **로드**
    - 어떤 DB를 사용할지를 선택 | 주로 생성자에서 구현
    - **Class.forName**("연결하려는 드라이버명")
    - **Oracle** : **oracle.jdbc.driver.OracleDriver**
    - MsSQL : sun.jdbc.odbc.jdbcOdbcDriver
    - MySQL : org.git.mm.mysql.Driver

2. 데이터베이스 **연결**
    - 내가 사용하고자하는 DB에 ID/PW로 접속|주로 생성자에서 구현 혹은 필요시마다 연결
    - **Connection** conn = **DriverManager.getConnection**(URL,ID,PW);
    - **Oracle** : **jdbc:oracle:thin:@localhost:1521:ORCL**
    - MsSQL : jdbc:odbc:odbc설정을통해만든db원본명
    - MySQL : jdbc:mysql://localhost:3306/db명
3. 데이터베이스 **실행**
    - CRUD 작업 | 각 SQL 문장마다 메소드를 만드는것을 권장
    ```JAVA
    //Statement 선언
    Statement statement = connection.createStaemet();
    //int형으로 return값을 받는다. insert, update, delete, create를 수행
    statement.executeupdate(쿼리String);
    //결과를 ResultSet으로 받는다.
    ResultSet resultSet = statement.executeQuery(쿼리 String);
    ```
    - Statement는 일종의 쿼리를 보내기 위해 필요한 권한을 얻는 과정정도로 생각
    - resultSet.next()는 boolean을 리턴하는데 true면, 다음 레코드가 존재한다는 의미
    ```java
    while(resultSet.next())
    {                           //getString(컬럼명)
        String string = resultSet.getString(1)// 0이 아닌 1부터 시작! 반드시 순차적 접근만 가능!!
        String string = resultSet.getString("name")// 0이 아닌 1부터 시작! 반드시 순차적 접근만 가능!!
    }
    ```
4. 데이터베이스 **닫기**
    - finally 블럭에서 수행하며, 닫기에 해당하는 메소드를 생성하여 사용하는것이 일반적
    - connection.**close()**;<br>resultSet.**close()**;<br>statement.**close()**;
### JDBC 관련 클래스
> java.sql 패키지

![jdbc](https://user-images.githubusercontent.com/60641307/80168211-3e8fb380-861d-11ea-9c92-f77d74b8a5c2.png)

- **DriverManager** 
    - JVM에서 JDBC 전체를 관리하는 클래스
    - Driver 등록,Connection 연결작업 등
- **Driver**
    - DB를 만드는 Vender(Oracle 등)을 implements하여 자신들의 DB를 연결할 수 있는 class를 만드는 인터페이스
- **Connection**
    - **DB와 연결성**을 갖는 인터페이스
- **Statement**
    - **SQL문을 실행**하는 인터페이스
- **ResultSet**
    - 조회된 **결과 데이터**를 갖는 인터페이스
1. 드라이버 로딩 Driver loading( DB제품군 선택)
    ```java
    Class.forName("oracle.jdbc.driver.OracleDriver");
    //Class.forName("클래스명");
    //Class.forName("패키지명.드라이버클래스명");
    ```
    - ClassNotFoundException 오류 발생 **try-catch문** 혹은 **예외처리 필요**
2. 연결객체 생성 **Connection**( 특정 DB서버연결 )
    ```Java
    Connection conn = DriverManager.getConnection(url,id,pw);

    String url = "jdbc:oracle:thin:@localhost:1521:orcl";//"locahost"==127.0.0.1==내 pc
    String id = "scott";
    String pw = "123456";
    // conn = DriverManager.getconnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","scott","123456");

    System.out.println("DB연결 성공");
    ```
    - **url** : 접속DB ip, port번호, sid
    - **id** : 접속계정
    - **pw** : 접속계정에 대한 비밀번호
3. 실행객체 생성 **Statement**
    - SQL문 (DML,SELECT 실행가능)
    ```java
    Statemnet stmt = conn.createStatement();

    //실행요청
    int t = stmt.executeUpdate(sql); // DML 실행
    int t = stmt.executeQuery(sql); // SELECT 실행
    ```
    - DML 작업
    ```java
    //테이블에 dept_copy에서 10번부서를 삭제
        String sql = "DELETE FROM dept_copy WHERE deptno=10";

    // --SQL문 실행 요청
        int t = stmt.executeUpdate(sql); //삭제시점
        System.out.println("T=" + t);//t: 수정 또는 삭제된 행의 갯수
        it (t>0) {
            System.out.println("삭제성공"); // t==> 삭제(또는 수정)된 행의 갯수
        }

        --테이블 dept_copy에서 20번, 30번 부서를 삭제하시오~(삭제성공메시지 출력)
        sql = "DELETE FROM dept_copy WHERE deptno IN(20,30)";
        t = stmt.executeUpdate(sql);
        System.out.println("T=" + t);

        if(t > 0){
            System.out.println("삭제성공");
        } else{ 
            System.out.println("삭제실패");
        }
    ```
4. 결과객체 생성
    - **ResultSet** : 조회된 결과(행열데이터)를 저장
    - DQL(SELECT) 작업
        - 조회요청,조회된 결과값(행열데이터)리턴
### execute, executeQuery, executeUpdate 메소드()
>JDBC type4 드라이버는 쿼리를 실행할 수 있도록 3개의 메소드를 제공
1. **execute**
    - 모든 유형의 SQL 문장과 함께 사용가능
    - boolean 값을 반환 
        - true 일 경우: getResultSet 메소드를 사용함으로써 결과 집합을 얻을 수 있다.
        - false 일 경우: 업데이트 개수 또는 결과가 없는 경우
    - **Select, Insert, Update, Delete, DDL 문을 모두 실행 가능**
    - **표기형식**
    ```java
     public boolean exectue(String sql) throws SQLException;
     //반환값 : true -> result, false -> update count or no reuslt
     ```
2. **executeQuery** 
    - 데이터베이스에서 데이터를 가져와서 **결과 집합을 반환**
    - **ResultSet** 타입 사용
    - **Select문에서만 실행한다.**
    - **표기형식**
    ```java
    public ResultSet executeQuery(String sql) throws SQLException;
    //반환값 : ResultSet -> object that contains the data produced by the given query
    ```
3. **executeUpdate**
    - INSERT(추가), DELETE(삭제), UPDATE(수정) SQL문 실행
    - 메소드의 반환 값은 **SQL문 실행에 영향을 받는 행 수를 반환**
    - **표기형식**
    ```java
    public int executeUpdate(String sql) throws SQLException;
    //반환값 : int -> row count
    ```

### Auto Commit
```java
Connection con =null;
con.setAutoCommit(false);// 오토커밋 해제
con.commit(); //수동으로 커밋을  해주면된다. 
```