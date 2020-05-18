## Connection Pool (커넥션 풀)

### **커넥션 풀 (DBCP)**
> 데이터베이스와 연결된 커넥션을 미리 만들어서 풀(pool) 속에 저장해두고 있다가 필요할 때 커넥션을 풀에서 쓰고 다시 풀에 반환하는 기법을 말한다.
- 웹 프로그램에서는 데이터 베이스 환경설정과 연결관리등을 따로 XML파일이나 속성 파일을 사용해서 관리<br> 이렇게 설정된 정보를 이름을 사용하여 획득하는 방법을 사용
- 웹 컨테이너가 실행되면서 커넥션(Connection)객체를 미리 풀(pool)에 생성해 둔다.
- DB와 연결된 커넥션(Connection)을 미리 생성해서 풀(pool)속에 저장해 두고 있다가 필요할 때에 가져다 쓰고 반환한다.
- 미리 생성해두기 때문에 데이터베이스에 부하를 줄이고 유동적으로 연결을 관리 할 수 있다.

![커넥션풀](https://user-images.githubusercontent.com/60641307/82187327-329ac700-9927-11ea-91e4-3975412da908.jpg)


### 커넥션풀(DBCP) 사용 이유
> 만약 한명의 접속자가 웹 사이트에 접속했다고 가정한다.<br> 해당 웹사이트에서 접속자는 게시판을 확인하고 자신이 쓴 게시물을 수정하고<br> 또 새로운 게시글을 등록한다고 가정해보자 <br> 그럼 이 한명의 접속자로 인해 DB접속은 아래와 같이 발생
1. 데이터 취득
2. 검색 후 데이터 취득
3. 데이터 갱신
4. 데이터 새 등록
> 즉 한명의 접속자로 인해 단 시간에 4번의 DB접속이 일어난다. <br> 사용자가 많아질경우 ... 과부화
- 즉 커넥션 풀이란 미리 커넥션 객체를 생성하고 해당 커넥션 객체를 관리하는것을 의미
    - '커넥션 풀에 DB와 연결해 놓은 객체를 두고 필요할 때마다 커넥션 풀에서 빌려온다'.
- 커넥션 풀을 너무 크게 하면 메모리 소모가 크고, 적게 해놓으면 커넥션이 많이 발생할 경우 대기시간이 발생
    - 즉 웹사이트 동시 접속자수 등 서버 부하에 따라 크기를 조정

>서버는 동시에 사용할수 있는 사람의 수라는 개념이 존재, 일반적인 커넥션을 이용하면 동시 접속자 수를 벗어나게될 경우 에러가 발생<br>예외가 발생하면 그 접속자는 더이상 처리를 하지못하므로, 사이트 이용자는 다시 접속을 시도해야하는 불편함 초래<br> 이를 해결하기 위해 탄생한것이 **커넥션풀**
- 동시 접속자가 가질수 있는 커넥션을 하나로 모아놓고 관리하는 개념 
- JDBC를 통하여 DB에 연결하기 위해서는 드라이버(Driver)를 로드하고 커넥션(Connection)객체를 받아와야 한다.
- JDBC를 사용하면 사용자가 요청을 할 때 마다 매번 드라이버를 로드하고 커넥션 객체를 생성하여 연결하고 종료하기 때문에 매우 비효율적
    - 이래서 커넥션풀(DBCP) 사용

### 커넥션풀(DBCP) 특징
- 커넥션을 생성하는데 드는 연결 시간이 소비되지 않는다.
    - 커넥션 풀을 사용하면 커넥션을 생성하고 닫는 시간이 소모되지않아 그만큼 어플리케이션 실행 속도가 빨라진다.
- 커넥션을 계속해서 재사용하기 때문에 생성되는 커넥션 수가 많지 않다.
    - 한번에 생성될수 있는 커넥션 수를 제어하기 때문에 동시 접속자 수가 몰려도 웹 어플리케이션이 쉽게 다운되지 않는다.

- **동시접속자 처리**
    - 누군가가 접속하면 커넥션 풀에 남아있는 커넥션을 제공하는 식
    - 남아있는 커넥션이 없을 경우 해당 클라는 대기상태로 전환
    - 커넥션이 반환되면 대기하고있는 순서대로 커넥션 제공

### 커넥션풀 설정
1. DBCP 라이브러리 추가 
    - 이전버전 commons-dbcp-1.4jar, commons-pool-1.6.jar, commons-collections-3.2.1-bin.zip 3개의 라이브러리는<br> 톰캣 6.0 부터 tomcat-dbcp.jar 파일로 하나로 통합
    - 톰캣설치폴더 lib 폴더에 있는 tomcat-dbcp.jar 파일을 WebContent\WEB-INF\lib 경로에 복사
2. DB라이브러리 추가 (오라클 - ojdbc6.jar)
3. META-INF\context.xml파일 추가 (Resource 태그)

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <Context>
    <!-- Resource를 등록하여 웹에서 JNDI로 호출할 이름과 정보를 설정 -->
	<Resource name="jdbc/OracleDB" //name: JNDI로 호출될 이름을 설정(접근->java:comp/env/jdbc/OracleDB)
		auth="Container"            //auth: DBCP를 관리할 관리자(Container or Application)
		type="javax.sql.DataSource" //type: 해당 resource의 return type(DataSource는 Connection 객체를 반환할수 있다.)
        factory="org.apache.tomcat.dbcp.dbcp2.BasicDataSourceFactory" //factory: dbcp를 이용하는 관리클래스(Tomcat 5.x에 기본으로 존재하는 클래스)
        driverClassName="oracle.jdbc.driver.OracleDriver"   //driverClassName: JDBC를 이용하기 위한 드라이버 클래스
		username="scott"           // DB의 계정명
		password="123456"           // 계정 비번
		url="jdbc:oracle:thin:@127.0.0.1:1521:ORCL?autoReconnect=true"" //DB의 접속 URL(속성으로 자동 재접속을 선택했다.)
		maxActive="500"  //커넥션 풀이 제공할 최대 커넥션 갯수
		maxIdle="100" /> <!--사용되지 않고 풀에 저장될수있는 최대 커넥션 갯수 (음수->제한X)-->
    </Context>
    ```
4. WEB-INF\web.xml 파일 추가 (resource-ref 태그)
    - &#60;res-ref-name&#62; 태그의 이름은 context.xml 파일 &#60;resource&#62; 태그의 name 속성의 이름과 같아야함 
        - 이 작업은 톰캣 6.0 이상부터는 생략 가능
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <web-app id="WebApp_ID" version="2.4" xmlns="http://java.sun.com/xml/ns" >
	<display-name>JDBC</display-name>
	<resource-ref>
		<description>Connection</description><!--리소스 설명 -->
		<res-ref-name>jdbc/OracleDB</res-ref-name><!--리소스 이름(JNDI명) -->
		<res-type>javax.sql.DataSource</res-type><!--리턴 타입 -->
		<res-auth>Container</res-auth><!--관리 계층-->
	</resource-ref>
    </web-app>
    ```

5. JAVA 코드로 연결 
    - 서블릿에서 작성한다. (MVC 구조로 구현할 경우)
    - 예외를 가지고 있으므로 예외처리를 해준다.
    ```jsp
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="javax.sql.*" %> //DataSource 클래스를 위해 사용
    <%@ page import="javax.naming.*" %>//JNDI를 위해 사용
    <%
	Connection conn = null;

	try{
		Context init = new InitialContext(); //JNDI를 이용하기 위한 객체 생성
		DataSource ds =             // lookup(): 등록된 naming 서비스로부터 자원을 찾고자할때 사용하는 메소드
                (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
                //context 객체를 통해 이름으로 Resource를 획득한다.
                    //(java:comp/env): 톰캣에서 리소스를 관리하는 가상의 디렉토리
                    //(jdbc/OracleDB): JNDI 서비스에 접근하기 위한 기본이름(이 자원을 찾겠다.-->web.xml의 <res-ref-name>)
                        //JNDI의 모든 이름은 기본적으로 java:comp/env에 등록되어있다. (해당 영역에서 설정된 이름을 획득)
		//	Context env = (Context)init.lookup("java:comp/env");
		//	DataSource ds = (DataSource)env.lookup("jdbc/OracleDB");
		conn = ds.getConnection();
            // source 로부터 Connection 객체를 획득한다.
            // 이 객체는 이제 Container의 DBCP에 의해 관리된다.
		out.println("<h3>연결되엇습니다.</h3>");
	}catch(Exception e){
		out.println("<h3>연결에 실패하였습니다. </h3>");
		e.printStackTrace();
	}
	%>

    ```

### JNDI(Java naming and Direcotry Interface)
> 설정된 정보를 이름으로 획득하려면 자바의 네이밍 API를 사용해야 한다.<br> 네이밍 패키지의 클래스를 가지고 이름으로 객체를 획득하는 것을 **JNDI**라고 한다.
- 서비스가 다른 서비스를 탐색할 때 유용하게 사용됨 (분산된 자원)
- 분산된 자원 끼리의 탐색을 원할하게 하기 위한 type casting 임 (DNS도 이에 속함)
- JNDI에 설정해 놓았다는 것은 context.xml에 리소스를 생성해 놓은것을 말함
- 이름을 이용해서 원하는 정보 혹은 자원(Connection)을 찾을 수 있는 서비스
    - javax.naming 서비스
    - initialContext 클래스