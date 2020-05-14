## RequestDispatcher
>RequestDispatcher는 클라이언트로부터 최초에 들어온 요청을 JSP/Servlet 내에서 원하는 자원으로<br> 요청을 넘기는(보내는)역할을 수행하거나, **특정 자원에서 처리를 요청**하고<br> **처리 결과를 얻어오는 기능**을 수행하는 클래스

- 즉, /a.jsp로 들어온 요청을 /a.jsp 내에서 RequestDispatcher를 사용하여 b.jsp로 요청을 보낼수 있다.
- 또는 a.jsp에서 b.jsp로 처리를 요청하고 b.jsp에서 처리한 결과 내용을 a.jsp의 결과에 포함시킬 수 있다.


### RequestDispatcher 가 있는 이유, HttpServletResponse#sendRedirect()와 차이점
> HttpServletResponse를 사용하면 sendRedirect() 메소드를 이용하여 지정한 경로로 제어를 이동시킬수 있다.<br> 그러나 sendRedirect()는 HTTP 리다이렉션을 이용하기 때문에 하나의 요청 범위 안에서 처리를 하는 것이 아니라 <br>브라우저에서 Response 후 브라우저측에서 지정받은 요청 경로로 다시 재요청하는 방식이기 때문에 두번의 HTTP 트랜잭션이 발생하며,<br> 서버측에서 최초에 받은 요청중에 처리한 내용을 리다이렉트 된 요청안에서 공유할 수없는 문제가 있다.

![RequestDispatcher](https://user-images.githubusercontent.com/60641307/81901820-15e65280-95fa-11ea-9e0c-ef78e837d53f.png)

- 물론 sendRedirect() 에서도 쿠키나 세션등을 이용해 특정 상태를 유지하여 공유할수는 있겠으나 <br>상황에따라 제한적이며 코드레벨에서의 알고리즘 등을 곧바로 이어가는데에도 한계가 있기에 좋은방법이아니다.

- **HttpServletResponse#sendRedirect() vs RequestDispatcher 차이점**
    - HttpServletResponse 
        - 현재 어플리케이션 이외에 다른 자원의 경로를 요청할 수 있다.
    - RequestDispatcher
        - 현재 처리중인 서블릿이 속해 있는 웹 어플리케이션 범위 내에서만 요청을 제어할수 있다.

### RequestDispatcher 생성(얻는) 방법
- **ServletContetxt** 
- **ServletRequest** 
    - ServletRequest클래스에서 제공하는 팩토리 메서드(Factory Method)를 통해 얻을수 있다.
#### ServletContext를 통해 얻는 방법
> 서블릿 클래스에서 ServletContext를 사용하여 RequestDispatcher를 얻을수 있다.
```
// 호출 대상을 web.xml에 지정한 서블릿 이름(<servlet-name>)으로 지정하는 방법
servletContext context = this.getServletContext();
RequestDispatcher dispatcher = context.getnamedDispatcher("helloServlet");
```

```
// 호출 대상을 URL 경로로 지정하는 방법
// 웹어플리케이션 루트경로를 기준으로 절대경로만 지정가능
ServletContext context = this.getServletContext();
RequestDispatcher dispatcher = context.getRequestDispatcher("/hello");
```
- JSP 페이지에서는 application 기본 객체를 이용
    ```jsp
    <%
        RequestDispatcher dispatcher = application.getRequestDispatcher("/hello");
    %>
    ```

### ServletRequest를 통해 얻는 방법
> 서블릿 클래스에서 Service() 메소드나 doGet() doPost()등에서 ServletRequest의 하위 클래스인 HttpServletRequest를 매개변수로 받기 때문에 이것을 이용하여 RequestDispatcher를 얻을수 있다.
- HttpServletRequest에서는 URL 경로를 통해서 대상을 지정하는 한가지 방법만 제공
    - But, ServletContext를 통해서 대상을 지정할때와는 다르게 절대경로 및 상대경로 모두 지정 가능
- JSP 페이지에서도 ServletRequest의 인스턴스인 request 기본객체가 있으므로 쉽게 얻을 수 있다.

```jsp
RequestDispatcher dispatcher = request.getRequestDispatcher("/hello");
```

### RequestDispatcher의 forward() 메소드
> forward() 메소드는 대상 자원으로 넘기는 역할을 한다.
- 브라우저에서 /a.jsp로 요청했을때 /a.jsp에서 forward()를 실행하여 /b.jsp로 제어를 넘길수 있다.
- 제어를 넘겨받은 /b.jsp는 처리결과를 최종적으로 브라우저에게 출력한다.
- 브라우저 입장에서는 /a.jsp를 요청했지만 받은 결과는 /b.jsp의 결과이다.
    - HTTP 리다이렉트방식과는 달리 하나의 HTTP요청(Request)범위 안에서 동작이 이루어짐
    
![forward](https://user-images.githubusercontent.com/60641307/81905359-90fe3780-95ff-11ea-80c0-739d59a8de26.png)

#### forward() 사용시 주의할점
- forward() 제어를 넘기기 이전에 출력 버퍼를 비우기 때문에 a.jsp-> b.jsp로 호출시 a.jsp에서<br>어떤 내용을 버퍼에 출력했더라도 무시되며 제어가 넘어간 b.jsp의 출력내용만 브라우저에게 전달된다.

#### JSP 페이지에서 사용시
> JSP 페이지에서도 전혀 다를게 없이 기본객체들을 이용하면 된다.

```jsp
    <%
        RequestDispatcher dispatcher = application.getRequestDispatcher("/hello");
        dispatcher.forward(rquest,response);
    %>
```