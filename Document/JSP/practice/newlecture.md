### request.parameter("파라미터_명");
- String 데이터타입
- 파라미터 value 값을 받아온다.
#### request.parameterValues("파라미터_명");
- 같은 name의 파라미터를 배열로 받는다. (inedx 0 부터 )

### 한글 인코딩
- request.setCharacterEncoding("utf-8");
    - POST방식의 한글 처리를 해주는 메소드 
    - (HttpServletRequest)의 상위  객체인 ServletRequest에서 제공하는 메소드
    - 클라이언트가 전달한 요청 정보 몸체에 있는 문자열들을 메소드 인자값으로 지정한 문자코드로 인코딩해줌
- response.setCharacterEncoding("utf-8");
    - 사용자에게 보낼 때 utf-8로 인코딩되서 사용자에게 전달하는 코드
- respone.setContentType("text/html; charset=utf-8");
    - 클라이언트에게 UTF-8로 읽으라고 전달하는 코드
### 상태 유지를 위한 5가지 방법
- application
- session
- cookie
- hidden input
- querystring

---
### WAS(Web Application Server) 저장소
-**Application**
    - 사용범위: 전역범위에 사용하는 저장 공간
    - 생명주기: WAS가 시작해서 종료될 떄 까지
    - 저장위치: WAS 서버의 메모리
- Session
    - 사용범위: 세션범위에서 사용하는 저장 공간
    - 생명주기: 세션이 시작해서 종료될 떄 까지
    - 저장위치: WAS 서버의 메모리
- Cookie
    - 사용범위: Web Browser별 지정한 Path 범주공간
    - 생명주기: Browser에 전달한 시간부터 만료시간까지 
    - 저장위치: Web Browser의 메모리 또는 파일

#### Application 저장소: 서블릿 컨텍스트(Context)
- 서블릿들이 서로 문맥을 이어갈수있도록 하는 저장소
    - =자원공유
- ```ServletContext application = request.getServletContext(); ```
- setAttribute("속성_명",값);
- getAttribute("속성_명)
#### Session 객체 
- ```HttpSession session = request.getSession(); ```
- 사용자마다 개인공간
- Session 메소드
    - void setAttribute(String name, Object value)
        - 지정된 이름으로 객체를 설정
    - Object getAttribute(String name)
        - 지정한 이름의 객체를 반환
    - void invalidate()
        - 세션에서 사용되는 객체들을 바로 해제
    - void setMaxInactiveInterval(int interval)
        - 세션 타임아웃을 정수(초)로 설정 (defualt 30분)
#### Cookie 객체
- 클라이언트에 저장함
- 쿠키값은 반드시 문자열로 (URL에 쓸수있는 형태로)
- 쿠키 저장하기
    - ```java
        Cookie cookie = new Cookie(key,value);//쿠키생성
        response.addCookie(cookie);//브라우저에 전달하는 값
        
        ```
- 쿠키 읽기
    - ```java
        Cookie[] cookies = request.getCookies();//쿠키가 꺼내는데 배열로온다.
        String _c = "";

        if(cookies != null)
            for(Cookie cookie : cookies)
                if(키.equals(cookie.getName()))
                   _c = cookie.getValue();
        ```

- path(경로) 설정: 쿠키 사용범위 제한
    - ``` 쿠키객체_명.setPath("경로")```
        - 경로("/") : 모든페이지를 요청할대마다 항상 이 쿠키를(value) 가져와라
        - 경로("/notice/"): notice가 포함된 하위 url을 요청할때 쿠키를 가져옴
- maxAge(만료날짜)옵션
    - maxAge 옵션을 지정안하면 생존주기는 브라우저와 같아진다.(닫히면 날라감)
    - ```쿠키객체_명.setMaxAge(24*60*60);//하루```
- 쿠키삭제
    - 쿠키_명.setMaxAge(0);
---
### redirect
- ``` response.sendRedirect("주소"); ```
- 사용자에게 주소를 이동시킨다.

### Servlet

- get요청과 post요청 한번에 처리할 필요가 있을 때 
    -  단 super.service(request.response);는 지워줘야함
    
- ```java
    public class Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        if(request.getMethod().equals("GET")){//반드시 대문자

        }
        else if(request.getMethod().equals("POST")){//반드시 대문자

        }
    // 요청방식을 나눠서 처리도 가능하다
    
    }
    ```

- get, post 요청을 따로 처리할 필요가 있을 때
    ```java
    public class Servlet extends HttpServlet {
        @Override
        doGet(HttpServletRequest request, HttpServletResponse response)throws servletException, IOException {

        }

        @Override
        doPost(HttpServletRequest request, HttpServletResponse response)throws servletException, IOException {
            
        }
    }
    ```


}
### jsp 
- jsp가 알아서 servlet 코드 만들어줌 

#### 표현식 태그

- <% %>
    - 서블릿에 Service함수에 지역변수로 들어감
    - 자바코드 형태로 들어감
- <%= %>
    - 서블릿에 Service함수에 지역변수로 들어감
    - 프린트로 출력
    - 변수를 출력할때
    - 서블릿으로 변환시 out.print(출력내용);으로 변환됨
    
- <%! %>
    - 선언자 태그
    - member 변수(Field)나 member 메소드를 선언할 때 사용
    - service 함수가 아닌 멤버함수 영역에 들어감
    - jspInit(), jspDestroy() 오버라이딩시 사용
    - _jspService() 는 오버라이딩해서는 안된다.(WC가 자동 오버라이딩)
    

- <%@ %>
    - 페이지 지시어
    - 문서 전체에 적용되어야할 내용
    - 어떤 코드보다도 앞서서 진행됨

### jsp 내장객체
> 서블릿 안에 미리 선언된 변수(코드블럭에서 사용할수 있다.)
1. request
    - javax.servlet.ServletRequest(javax.servlet.http.httpRequest)
    - Client의 http 요청정보를 저장하고 있는 객체
    - forward관계에있는 둘사이의 공유할수있는 저장소로 request가 사용됨
2. response
    - javax.servlet.ServletResponse(javax.servlet.http.httpResponse)
    - http 요청에 대한 응답정보를 저장하는 객체
3. session
    - javax.servlet.http.HttpSession
    - client가 서버에 접속했을 때 세션 정보를 저장한 객체
4. pageContext
    - javax.servlet.jsp.PageContext
    - 응답페이지 실행에 필요한 Context 정보를 저장한 객체
5. out
    - javax.servlet.jsp.jspWriter
    - 응답 페이지 전송을 위한 출력 stream
6. application
    - javax.servlet.ServletContext
    - 동일한 application의 Context 정보를 저장하고 있는 객체
7. page
    - java.lang.Object
    - 특정 페이지의 서블릿 객체(인스턴스화된 객체)
8. exception
    - java.lang.Throwable
    - 예외 처리를 위한 객체

#### JSP 단점 (스파게티 코드)
- 내가 관심있는 코드와 관심없는 코드가 섞여있다.
     - 찾기 힘들다
### MVC 
- Model1
    - jsp 하나의 파일에서 입력(controll) 코드와 출력(view)코드 를 분리
- model2
    - **컨트롤러와 뷰가 물리적으로 분리된 방식**
    - 따로 유지 관리가 가능

### 둘사이의 연결고리 역할의 저장소
- redirect
    - 새로운 요청
- forward
    - 현재 작업했던 내용을 이어감(공유)
    - ```java
        RequestDispatcher dispatcher
            = request.getRequestDispatcher(path);//2.기입한 경로로 보내줌
        dispatcher.forward(request,response); //1.현재작업했던 내용들을
        //forward관계에있는 둘사이의 공유할수있는 저장소로 request가 사용됨
      ```
    - dispatcher 
        - 컨트롤러와 뷰페이지를 연결해주는 포워딩을 도와주는 녀석

### EL(Expression Language)

- view에선 가능하면 자바코드를 사용하지않게하는 방식이 MVC 구현에 가장좋은 방법
    - 자바코드표기법을 대신하여 쓸수있는 표기법

#### EL 사용법
- 일반 객체
    - Controller: 
        - request.setAttribute("cnt",30);
    - View: 
        - request.getAttribute("cnt")
    - EL: 
        - ${cnt}
- 배열 & Array
    - Controller:
        - List list = new ArrayList(){"1","test"...}; <br>request.setAttribute("list",list);
    - View:
        - ((List)request.getAttribute("list")).get(0)
    - EL:
        - ${list[0]}
- Map
    - Controller:
        - Map n = new HashMap("title","제목");<br>request.setAttribute("n",n);
    - View:
        - ((Map)request.getAttribute("n")).get("title")
    - EL:
        - ${n.title}

#### EL 데이터 저장소
- EL의 데이터값을 꺼내는 기본 우선순위
    - page -> request -> session -> application
- 우선순위 무시하고 특정 저장소에서 꺼내는 방법
    - pageScope
    - requestScope
    - sessionScope
    - applicationScope
- 특정 저장소에서 꺼내는 방법
    - param 
        - 파라미터 값을 저장하고 있는 저장소
    - paramValues
        - 파라미터 값을 배열로 저장하고 있는 저장소
    - header
        - Header 정보를 저장하고 있는 저장소
    - headerValues
        - header 정보를 저장하고 있는 저장소
    - cookie
        - 쿠키 정보를 저장하고 있는 저장소
    - initParam
        - 컨텍스트의 초기화 파라미터를 저장하고 있는 저장소
    - pageContext
        - 페이지 범위의 컨텍스트 저장소
        - <%=pageContext.getRequest().getMethod() %>
        -               ↓
        - ${pageContext.request.method}
        - 자바를쓰는 느낌을 최대한빼고 객체를 쓰는느낌으로만
#### EL 연산자
- le,gt,le,ge를 쓰는이유
    - html 태그에서 꺽음쇠를 사용해서 겹치기 때문에 
    - < lt
    - > gt
    - <= le 
    - >= ge
- empty
    -a == null || a=='' (true)
- not empty
    - a != null || a !=''(true)