## Request (사용자 요청 객체)
> 사용자의 요청에 관련된 정보를 얻기 위해 사용하는 객체
- JSP 기본 내장 객체 중 **request 객체**는 JSP 페이지에서 가장 많이 사용되는 객체
- 웹 브라우저와 같은 클라이언트로부터의 요청 정보를 담아 제공하는 객체
- request 객체는 javax.servlet.http.HttpServletRequest 객체
- jspService()메소드의 첫번째 파라미터로 넘어오게된다.
    - 이는 서블릿 클래스를 작성할 때 service()메소드나 혹은 doGet(), doPost()등의<br> 첫번째 파라미터로 HttpServletRequest를 받는것과 똑같다.
    - jspService() : JSP가 서블릿으로 변환되었을 때 요청을 처리하기 위해 실행되는 메소드
- 때문에 jsp 페이지의 스크립트릿에 따로 선언하지 않아도 기본적으로 사용가능


### request.parameter("파라미터_명");
- String 데이터타입
- 파라미터 value 값을 받아온다.
#### request.parameterValues("파라미터_명");
- 같은 name의 파라미터를 배열로 받는다. (inedx 0 부터 )


### request 내장객체(javax.servlet.http.HttpServletRequest) 의 메소드
|메소드|리턴 타입|설명|
|:---|:---|:---|
|getRemoteAddr()|String|서버에 연결할 클라이언트의 IP를 구한다.<br>보안이 필요한 웹어플리케이션의 경우 IP를 검사하거나 <br>접근기록을 남기는데 사용가능하다.|
|getProtocol()|String|클라이언트가 요청한 프로토콜을 구한다.|
|getCharacterEncoding()|String|클라이언트가 전송한 http 요청 정보 인코딩에 사용된 캐릭터 set을 구한다.|
|getContentType()|String|클라이언트가 전송한 http 요청 정보 콘텐츠타입을 구한다.<br>이는 클라이언트가 전송한 http요청 메시지의 Content-Type 헤더값이다.|
|getContentLength()|long|클라이언트가 전송한 http 요청 정보의 길이를 구한다.<br>정보의 길이를 구할수 없는 경우에는 -1을 리턴|
|getMethod()|String|클라이언트가 요청한 HTTP Method를 구한다.|
|getServerName()|String|클라이언트가 연결할 때 사용한 서버 이름을 구한다.|
|getRequestURL()|String|클라이언트가 요청한 URL에서 경로를 구한다.|
|getServerPort()|int|서버가 사용중인 포트 번호를 구한다.|
|getContextPath()|String|JSP 페이지가 속한 웹어플리케이션의 컨텍스트 경로를 구한다.|
|getParameter(String paramName)|String[]|http 요청 파라미터의 값을 구한다.<br>요청 파라미터명을 매개변수로 넘긴다.|
|getParameterValues(String<br> ParamName)|String[]|http요청 파라미터의 값을 배열로 구한다.<br> 요청 파라미터명을 매개변수로 넘긴다. <br>getParameter()와 다른점은 paramName에 해당하는 파라미터 값이 여러개인 경우 사용하는것|
|getParameterMap()|java.util.Map|클라이언트가 전송한 http 요청 파라미터들을 <br>Map 객체에 <파라미터명,파라미터값>형식으로 담아 리턴|
|getParameterName()|java.util.Enumeration|클라이언트가 전송한 http 요청 파라미터의<br> 파라미터명들을 담은 Enumeration 객체를 구한다.|
|setCharacterEncoding(String charset)|void|클라이언트의 요청 정보를 디코딩할때 사용할 캐릭터셋을 설정함<br>getParameter()와 같은 파라미터 정보를 얻어오는 메소드 사용전에 설정해야 적용됨<br><br>주의할점은 HTTP메세지 body 영역만 인코딩하는 메소드이므로 <br>GET방식의 경우 서버 설정을 통해 인코딩 설정을 변경해주어야 함<br> 톰캣기준으로 server.xml에서 변경가능|

#### 클라이언트 정보 출력

```html
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request 객체</title>
</head>
<body>
<!-- ex:) URL :  http://localhost:8080/Web/practice/tutorial00.jsp 
브라우저에서 GET방식으로 http://localhost:8080/Web/practice/tutorial00.jsp 요청했다-->
클라이언트 IP = <%= request.getRemoteAddr() %> <br/>
<!--클라이언트 IP = 0:0:0:0:0:0:0:1
IP의 경우 IPv6주소를 리턴했는데 이는 Ipv4에서 127.0.0.1(localhost)와 같은 의미-->
서버포트 = <%= request.getServerPort() %> <br/>
<!--서버포트 = 8080 -->
컨텍스트 경로 = <%= request.getContextPath() %> <br/>
<!--컨텍스트 경로 = /Web
웹어플리케이션의 루트경로 -->
요청 URI = <%= request.getRequestURI() %> <br/>
<!--요청 URI = /Web/practice/tutorial00.jsp
URI주소에서 포트 뒤의 주소 -->
요청 HTTP 메소드 = <%= request.getMethod() %> <br/>
<!--요청 HTTP 메소드 = GET -->
HTTP 요청 정보 길이 = <%= request.getContentLength() %> <br/>
<!--HTTP 요청 정보 길이 = -1
GET 방식의 경우 데이터를 URL에 포함시켜 보내므로 -1 -->
요청정보 인코딩 = <%= request.getCharacterEncoding() %> <br/>
<!--요청정보 인코딩 = null
요청정보 인코딩은 따로하지 않았으므로 null -->
요청정보 콘텐츠타입 = <%= request.getContentType() %> <br/>
<!--요청정보 콘텐츠타입 = null -->
요청정보 프로토콜 = <%= request.getProtocol() %> <br/>
<!--요청정보 프로토콜 = HTTP/1.1
http를 사용하였고 http1.1버전을 사용중 -->
서버이름 = <%= request.getServerName() %> <br/>
<!--서버이름 = localhost
서버 이름 또한 현재 컴퓨터에서 띄운것이므로 locallhost -->
</body>
</html>
```

### 요청 파라미터 정보 출력
> 요청 파라미터 정보를 출력하기 위해 다음과 같이 정보를 입력하여 서버로 전송하는 페이지와 요청 정보를 출력하는 페이지 두개 필요

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 입력 폼</title>
</head>
<body>    
     <form action="paramTest.jsp">
           이름 : <input type="text" name="userName"><br>
           나이 : <input type="text" name="age"><br><br>
           취미 선택 <br>
           <input type="checkbox" name="hobby" value="운동">운동
           <input type="checkbox" name="hobby" value="독서">독서
           <input type="checkbox" name="hobby" value="요리">요리 <br><br>
           <input type="submit" value="프로필전송">          
           
     </form>
</body>
</html>
```
- input에 값 입력후 submit을 하게되면 &#60;form&#62; 태그의 action 속성값인 paramTest.jsp 경로로 데이터를 전송하게 된다.
- action 속성값에는 폼에 입력한 데이터를 전송할 경로를 넣는데 /로시작하는 절대 경로로 적지않고, <br>parmTest.jsp같이 넣게되면 상대경로로 판단하여 전송한다.<br>(여기선 같은 경로에있다고 가정한 경우라 전송가능)
- &#60;form&#62;태그에 method 속성을 통해 GET, POST 등의 행동을 정해줄수 있는데 특별히 명시해주지 않는 경우 GET방식을 사용하게됨
