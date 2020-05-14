## 어노테이션(Annotation)
> 본래 주석이란 뜻으로, 인터페이스를 기반으로 한 문법이다.<br> 그역할이 다르지만 주석처럼 코드에 달아 클래스에 특별한 의미를 부여하거나 기능을 주입할 수 있다. <br>또한 해석되는 시점을 정할수도 있다.(Rentetion Policy)
- JEE5(Java Platform, Enterprise Edition 5)부터 새롭게 추가된 요소이다.
- 문장이나 문서에 추가적인 정보를 기입하는것을 뜻함
- 컴파일시 환경설정 변경사항을 기입
- 어노테이션에는 크게 3가지 종류가 존재한다.
    1. buit-in annotaion (JDK에 내장)
        - ex:) @Override
    2. Meta annotaion (정보를 나타내기위함)
    3. Custom Annotation (개발자가 직접 만듬)

### Servlet에서 Annotation을 이용한 설정
- Servlet 3.0 (tomcat 7지원) 부터 web.xml 이외에 Annotation을 이용한 웹 컴포넌트 설정 지원
- Servlet, Filter, Listener를 Annotation을 통해 클래스에 직접 설정가능
- web.xml과 동시에 설정시 web.xml 설정이 우선시 된다.(override 개념)
- Annotation 패키지
    - java.servlet.annotation
- 주요 Annotation
    - @WebServlet - 서블릿 관련 설정 처리
    - @WebListener - 리스너 관련 설정 처리
    - @WebFilter - Filter 관련 설정 처리
    - @WebInitParam - 서블릿이나 Filter 객체가 사용할 초기파라미터 설정 처리
#### @WebServlet("/서블릿명")
> web.xml에서 url매핑을 직접할수도있지만 번거로우므로 어노테이션을 사용
- 어노테이션 지원으로 **간편하게 URL을 매핑**할수 있음
- URL매핑을 사용하는 이유
    -  실제 서블릿 클래스를 공개하지 않기 위해(보안)

#### @WebServlet("/hw")
> public class HelloWorld extends HttpServlet ~
- 위 서블릿을 호출할때 locallhost:포트번호/프로젝트명(context path)/hw
- **hw**로 요청하게되면 **HelloWorld**클래스가 요청받아서 처리함
