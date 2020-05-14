## 자바 서블릿(Java Servlet)
> 웹페이지를 동적으로 생성하기 위한 서버측 프로그램을 말한다.
- 자바 언어를 기반으로 만들어지며 웹 어플리케이션 서버(Web Application Server)위에서 컴파일되고 동작한다.

### JSP와 서블릿
- JSP와 서블릿의 차이점
    - JSP : HTML 내부에 JAVA 소스코드가 들어감으로 인해 HTML 코드를 작성하기 간편하다는 장점이 있음
    - Servlet : 자바코드내에 HTML 코드가 있어서 읽고 쓰기가 굉장히 불편하기 때문에 작업의 효율성이 떨어짐
- JSP로 작성된 프로그램은 서버로 요청시 서블릿(Servlet) 파일로 변환되어 JSP 태그를 분해하고 추출하여 다시 순수한 HTML로 변환한다.

![JSP](https://user-images.githubusercontent.com/60641307/81882961-fd147780-95ce-11ea-816b-614c5efd9de9.jpg)

1. 클라이언트가 어떤 동작을 함으로써 hello.jsp를 요청
2. JSP 컨테이너가 JSP파일을 읽는다.
3. JSP 컨테이너가 Generate(변환) 작업을 통해 Servlet(.java) 파일을 생성
4. .java 파일은 다시 .class 파일로 컴파일된다.
5. Execute(실행)을 통해 HTML파일을 생성하여 JSP 컨테이너에게 전달한다.
6. JSP는 HTTP 프로토콜을 통해 HTML 페이지를 클라이언트에게 전달한다.

### 서블릿에서 한글 처리하기
- 전송방식이 get일 경우
    - server.xml을 수정해서 GET 방식으로 전송되어 오는 파라미터들의 캐릭터 셋을 한번에 수정하는 방법
        - server.xml (63번 line) Connector 태그에 URIEncoding="utf-8" 추가후 서버재시작
- 전송방식이 post일 경우 
    1. doPost 메소드에 'request.setCharacterEncoding("utf-8");' 추가해주자
    2. **jsp 스크립트릿 첫줄에 'request.setCharacterEncoding("utf-8");' 추가해주자**

### 하나의 파라미터 이름으로 여러개의 파라미터 값 처리하기
- HttpServletRequest 인터페이스 이용
    - 하나의 파라미터 값이 전송되는 경우
        - String getParameter(String paramName) 메소드 사용
    - 하나의 파라미터 이름으로 여러개의 값이 전송되어 올경우
        - String[] getParameterValues(String paramName) 메소드를 사용

