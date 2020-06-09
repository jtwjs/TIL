## WebSoket
- Transport Protocol로써 웹에서 사용하는 Socket이다.
    - HTTP 환경에서 전이중 통신(Full duplex, 2-way communication)을 지원하기 위한 프로토콜 
- Socket은 클라이언트와 서버가 연결을 유지하는 특성을 갖는다.
    - HTTP에서 클라이언트와 서버는 연결을 유지하지 않는 ConnectionLess특징이 있다.
- HTTP 프로토콜에서 Handshaking을 완료한 후, HTTP로 동작을 하지만, HTTP와는 다른 방식으로 통신을 한다.
- WebSocket을 사용함으로써 웹에서 양방향 실시간 통신이 가능해짐
- **즉, 소켓으로 연결되어있다면 클라이언트가 서버로 뭔가 요청하지 않더라도<br> 서버가 보내고 싶을때 클라이언트에게 데이터를 보낼 수 있다.**
### 
- **웹소켓은 RFC6445 표준이며, 프로토콜은 ws를 사용한다.**
- **WebSocket HandShake**
    - HTTP에서 WebSocket(ws)으로 프로토콜 전환 하는 것
- 브라우저는 프로토콜을 HTTP에서 WebSocket으로 전환하려는 요청을 Header에 Upgrade 속성을 추가하여 서버로 보낸다.<br> 이 요청을 받은 서버가 WebSocket 프로토콜을 이해하면 Upgrade 속성을 통해 프로토콜 전환을 동의하게 되고,<br> 브라우저와 서버는 ws프로토콜을 사용하게 된다.
- ws 프로토콜로 전환이 되면, HTTP 연결은 중단되고 동일한 TCP/IP연결을 통해 WebSocket연결로 대체된다.
- WebSocket연결은 기본적으로 HTTP(80), HTTPS(443)와 동일한 포트 사용
- **즉 CORS 적용이나 인증등의 과정을 기존 HTTP방식으로 사용할수 있다는 장점**
### 주의할점
- WebSocket은 HTTP와 달리 상태를 유지(Stateful)하기 때문에 서버와 클라이언트는 연결을 항상 유지해야 한다.
- 부하가 발생할수 있고 비정상적으로 연결이 끊어졌을 경우 적절하게 대응해야 한다.

### 1. WebSocket 라이브러리 추가 (pom.xml)
```xml
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-websocket</artifactId>
        <version>5.0.6.RELEASE</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
    <dependency>
        <groupId>com.fasterxml.jackson.core</gorupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.9.5</version>
    </dependency>
```
- 웹소켓을 사용하기 위한 websocket과 데이터 전송에 사용될 JSON을 위해 2개의 라이브러리를 추가한다.
### 2. websocket-confing.xml 추가하기
- servlet-context.xml에 네임스페이스tab에서 websocket을 추가
```xml
<!-- 웹 소켓 핸들러 -->
<websocket:handlers>
    <websocket:mapping handler="echoHandler" path="/echo" />
    <!-- WebSocket Handshake: 웹소켓 핸들러 클래스(echoHandler)가 호출되기 전에 
    HttpSession에 '이용자 아이디를 추가하는 기능' 등을 인터셉터가 수행하도록 설정 -->
    <websocket:hanshake-interceptors>
        <beans:bean class="org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor" />
    </websocket:hanshake-interceptors>
    <!-- <websocket:sockjs /> -->
</websocket:handlers>
<!-- WebSocket에 사용할 핸들러 객체 생성 -->
<beans:bean id="echoHandler" class="com.spring.util.EchoHandler" />
```
- 매핑값을 설정하여 그 경로로 들어오는 요청은 아래 com.spring.util.EchoHandler에서 처리를 하겠다는 의미

- **web.xml**
    - ```xml
        <servlet>
            <servlet-name>appServlet</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
            <init-param>
                <param-name>contextConfigLocation</param-name>
                <param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
            </init-param>
            <load-on-startup>1</load-on-startup>
            <!-- async-supported는 1대 다 통신을 할때 필요한 비동기 설정 -->
            <async-supported>true</async-supported>
        </servlet>
        
      ```
### 3. Handler 객체
```java
public class EchoHandler extends TextWebSocketHandler {
    private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
    //클라이언트와 연결 이후에 실행되는 메소드
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionList.add(session);
        System.out.println("{} 연결됨"+session.getId());
    }

    //클라이언트가 서버로 메시지를 전송했을 때 싫애되는 메소드
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) thorws Exception{
        System.out.println(("{}로 부터 {} 받음"+session.getId()+message.getPayload()));
        for (WebSocketSEssion sess : sessionList) {
            sess.sendMessage(new TextMessage(session.getId() +" : "+message.getPayload()));
        }
    }

    //클라이언트와 연결을 끊었을때 실행되는 메소드
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionList.remove(session);
        System.out.println("{} 연결 끊김" +session.getId());
    }
}
```

- sessionList에는 들어오는 사람들의 세션들을 관리할 객체
- 처음 /echo 매핑값으로 들어오면 처음 메소드가 실행되어 세션이 생성되고 List에 그걸 넣어줌
- 그 이후에 생성된 객체로 send 메소드를 호출하게 되면 2번째 객체가 실행됨
- 여기서 원하는 방향으로 메세지를 뿌려줄 수 있고 마지막 close 메소드를 호출하면 연결이 끊김
### 4. 요청해줄 JSP
```jsp
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>웹 소켓 통신 </title>
</head>
<body>
    <div>
        <input type="text" id="messageinput">
    </div>

    <div>
        <button onclick="openSocket();">Open</button>
        <button onclick="send();">Send</button>
        <button onclick="closeSocket();">Close</button>
    </div>

    <div id="message"></div>
    <script>
        var ws;
        var messages = document.getElementById("message");

        function openSocket(){
            if(ws!==undefined && ws.readyState!==WebSocket.CLOSED){
                writeResponse("WebSocket is already opend.");
                return;
            }

            //웹소켓 객체 만드는 코드
            ws = new WebSocket('ws://localhost:8080/ws/echo');

            ws.onopen=function(event){
                writeResponse(event.data);
            };
            ws.onmessage=function(event){
                writeResponse(event.data);
            };
            ws.onclose=function(event){
                writeResponse("Connection closed");
            }
        }
        function send(){
            var text = document.getElementById("messageinput").value;
            ws.send(text);
            text="";
        }

        function closeSocket(){
            ws.close();
        }

        function writeResponse(text){
            message.innerHTML+="<br/>"+text;
        }
    </script>

</body>
```