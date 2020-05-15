## Session (세션)
>세션은 HTTP 프로토콜을 이용하는 웹 환경에서 상태를 유지하기 위한 기술
- HTTP 요청과 응답으로 이루어짐
- 새로고침이나 특정 URL을 요청할때마다 새로운 HTTP 요청이 생성되기 때문에 이들간의 상태를 유지할수있는 방법이없다.
- DB를 통해서 관리해도 되지 않나???<br>(로그인시에 login이라는 상태를 저장후 logout시에 logout이라고 update하는 방식으로..)
    - 대규모 어플리케이션일수록 DB는 부하를 가장 많이 받는 대상
    - DB연산이 늘어날수록 병목이 되는 대상이 됨
    - 최대한 부담은 어플리케이션쪽으로 몰아주는것이 좋다.

    ![session](https://user-images.githubusercontent.com/60641307/81896134-d6fecf80-95ee-11ea-9e5f-b681e3188389.png)
- 따라서 HTTP의 무상태(Stateless)한 특성을 극복하고자 나온 기술이 **쿠키**와 **세션**
### 쿠키와 세션
- 특정 데이터를 저장해두고 페이지를 이동하거나 새로고침 하는 등 HTTP 요청이 매번 발생해도 특정 상태(데이터)를 유지할 수 있는 기술
- 차이점
    - 쿠키: 브라우저(클라이언트측)에 저장됨
    - 세션: 서버측에 생성되어 저장됨
- 세션을 식별하기 위한 세션ID값은 쿠키를 이용하여 보관한다.

### JSP에서 세션 생성하기
> 세션은 브라우저 단위로 생성되어진다. <br>즉, 하나의 컴퓨터에서 Explorer와 Chrome을 각각 실행하고 서버에 접속했다면 WAS에는 각각 두개의 세션이 생성됨
- JSP를 기준으로 세션을 page 디렉티브의 session 속성을 true로 지정해주면 해당 페이지를 요청시에 최초 한번 세션이 생성되어지는데<br> 기본값이 true이기 때문에 명시적으로 false로 지정해주지만 않는다면 세션이 생성된다.
- JSP 페이지에서는 request, application 등의 기본객체처럼 session이라는 기본객체를 제공하여 세션객체를 조작할 수 있다.

```jsp
<%@ page contentType="text/html; charset=utf-8" session="true"%>

<html>
<head>
</head>
<body>
<h1>세션 생성 성공</h1>
<%= session %>
</body>
</html>
```

- 최초 요청시 서버측에 생성되어 이후 브라우저가 종료 될때 사라진다.

#### 두번째 방법 HttpServletRequest 객체를 통해 생성하기
>Servlet을 통해서 생성하거나 JSP의 request 기본객체를 통해 세션을 생성할 수 있다.
- HttpServletRequest 객체를 통해 생성하는 방법
    - service() 메소드나 doGet(), doPost() 등의 첫번째 매개변수로 넘어오는 <br>HttpServletRequest 객체의 getSession() 메소드를 사용한다.
- getSession() 메소드는 세션이 이미 존재하는 경우 해당 세션을 리턴하고,<br> 세션이 존재하지 않으면 새로 생성하여 리턴한다.
- 만약 세션이 존재하지 않는 경우 생성하지 않고 null을 반환하고 싶은 경우
    - getSession(boolean create)를 사용
    - ```HttpSession session = request.getSession(false);```

### 세션이 생성되는 과정
> 세션은 브라우저 단위로 생성되어지고 최초 요청시 생성되어진다.<br> 또한 서버측에 생성되어진 세션은 브라우저별로 생성된 세션을 구분할 수 있는 세션ID를 갖게되는데<br>세션이 생성되어질때 세션ID를 브라우저측에 응답하고 브라우저는 이것을 쿠키로 저장한다.

![세션 생성과정](https://user-images.githubusercontent.com/60641307/81899515-fea56600-95f5-11ea-903b-8ddb95432cf4.png)


### 세션객체의 메소드
> JSP/Servlet 환경에서 세션객체는 javax.servlet.http.HttpSession 타입의 객체이다.

|메소드|리턴타입|설명|
|:---|:--:|:---|
|setAttribute(String name, Object value)|void|세션에 데이터를 저장한다.<br>name이 저장할 데이터의 이름이되고, value에 저장할 값을 지정한다<br>Object형이므로 모든 객체를 저장 가능|
|getAttribute(String name)|Object|세션에 저장할 데이터중 name에 해당하는 값을 리턴<br>Obejct형이므로 저장 이전의 원래 타입으로 형변환 사용가능|
|getId()|String|브라우저별로 생성되어진 세션을 구분하기 위한 ID를 리턴|
|getCreationTime()|long|세션이 생성된 시간을 구함<br>1970.01.01을 기준으로 몇ms(1/1000초)가 흘럿는지를 정수값으로 리턴|
|getLastAccessedTime()|long|웹브라우저가 가장 최근에 세션에 접근한 시간을 구함|
|invalidate()|void|세션을 종료한다.<br>종료된 세션객체는 곧 제거되며, 이후에 요청시 새로운 세션 생성|
|setMaxInactiveInterval(int interval)|void|세션의 유효시간을 초단위로 지정<br>유효시간은 가장최근에 세션에 접근한 이후 유효한 시간.<br>즉,getLastAccessedTime()메소드를 호출했을때의 시간과 현재시간 사이의 간격을 의미<br>0또는 음수로 지정하는 경우 invaldate() 메소드를 호출하기전까지는 세션이 제거되지않는다.<br>세션 또한 객체이므로 서버의 메모리를차지하므로 주의|
|getmaxInactiveInterval()|int|세션의 유효시간을 초단위로 구함|

### 세션에 데이터 저장 및 가져오기
> 세션의 가장 큰 목적은 상태유지에 있다.<br> 즉, HTTP의 상태가 없는 특성을 극복하고자 한 기술이기에 여러가지 데이터를 저장하여 유지할수 있다.
- login페이지에서 로그인에 성공하면 해당 사용자의 정보 및 로그인 여부를 세션을 생성하여 저장하고<br> 이후 서버의 다른 웹페이지 호출시마다 로그인 여부를 판단하거나 사용자 정보를 얻어올 때 해당 세션을 사용할 수 있다.


- login.jsp

    ```jsp
    <!-- 세션에 데이터를 저장할때는 setAttribute(String name,Object value) 메서드를 사용-->
    <%@ page contentType="text/html; charset=utf-8" session="true" %>
    <html>
    <head>
    </head>
    <body>
    <h1>로그인 페이지</h1>
    <%
        session.setAttribute("islogin",true);
    %>
    </body>
    </html>
    ```

- loginCheck.jsp

    ```jsp
    <!-- 세션에 저장된 값을 가져올때는 Object getAttribute(String name)메서드를 사용
    Object 타입의 객체를 리턴하므로 원래 타입으로 형변환하여 사용 -->
    <%@ page contentType="text/html; charset=utf-8" session="true"%>

    <html>
    <head>
    </head>
    <body>
    <%
        Boolean isLogin = (Boolean)Session.getAttribute("islogin");
        
        if(isLogin != null && isLogin){
                out.println("<h1>로그인 성공!</h1>");
        }else{
                out.println("<h1>로그인 실패</h1>");
        }
        %>
    </body>
    </html>
    ```