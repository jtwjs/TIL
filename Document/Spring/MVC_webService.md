### 프로젝트 전체 구조
1. java 파일
    - java 파일들이 위치함
    - 주로 패키지로 묶어서 관리
    - 웹애플리케이션에서 사용되는 Controller,Service,Dao객체들이 위치함
2. webapp
    - 웹과 관련된 파일들(스프링 설정파일, JSP파일, HTML파일 등..)이 위치
3. resources
    - JSP파일을 제외한 html,css,js 파일등이 위치함
4. spring 폴더
    - 스프링 컨테이너를 생성하기 위한 스프링 설정파일이 위치함
5. views 폴더
    - View로 사용될 JSP파일이 위치
6. pom.xml 파일
    - 메인 레파지토리에서 프로젝트에 필요한 라이브러리를 내려받기 위한 메이븐 설정 파일

### web.xml
- 웹어플리케이션에서 최초 사용자의 요청이 발생하면 가장 먼저 DispatcherServlet이 사용자의 요청을 받는다.
- 개발자는 DispatcherServlet을 서블릿으로 등록해주는 과정을 설정해주어야한다.
- 사용자의 모든 요청을 받기 위해서 서블릿 맵핑 경로는 '/'로 설정한다.

### DispatcherServlet
1. 사용자의 모든 요청을 DispatcherServlet이 받은후 HandlerMapping 객체에 Controller 객체 검색을 요청
2. HandlerMapping 객체는 프로젝트에 존재하는 모든 Controller 객체를 검색
3. HadnlerMapping 객체가 Controller 객체를 검색해서 DispatcherServlet 객체에 알려줌
4. DispatcherServlet 객체는 다시 handlerAdapter 객체에 사용자의 요청에 부합하는 메소드 검색 요청
5. HandlerAdapter 객체는 사용자의 요청에 부합하는 메소드를 찾아 해당 Controller 객체의 메소드를 실행
6. Controller 객체의 메소드가 실행된 후 Controller 객체는 HandlerAdapter 객체에 ModelAndView 객체를 반환
7. ModelAndView 객체에는 사용자 응답에 필요한 데이터정보와 뷰정보(JSP파일)가 담겨있음
8. 다음으로 HandlerAdapter 객체는 ModelAndView 객체를 다시 DispatcherServlet 객체에 반환

### servlet-context.xml
- DispatcherServlet이 서블릿으로 등록 될 때 contextConfigLocation 이름으로 초기화 파라미터를 servlet-context.xml로 지정하고 있는데<br> 이때 지정된 servlet-context.xml파일이 스프링 설정의 역할을 하는 파일이다.
- &#60;annotation-driven /&#62;
    - 어노테이션을 사용하기위한 태그
- 스프링 설정 파일은 클래스로부터 객체(빈:bean)를 생성하고 조립하는 역할을 한다
- servlet-context.xml에서도 마찬가지로 프로젝트에 필요한 객체(빈:bean)을 생성하고 조립한다.
    - ```xml
        <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <beans:property name="prefix" value="/WEB-INF/views/" />
        <beans:property name="suffix" value=".jsp" />
        </beans:bean>
      ```
    - ViewResolver 역할을 하는 빈객체 생성
- &#60;resources mapping="/resources/**" location="/resources/" /&#62;
    - resources 안에 html, css, js 파일들을 매핑해준다.

### Controller(컨트롤러)
- Controller -> Service -> DAO
    - 사용자의 요청을 실제로 처리하는 객체들
    - 실제로 개발자의 공수가 많이 투입됨
    
- ```java
    /* ▼사용자로부터 '/success'요청이 발생하면 success() 메소드를 실행 */
    @RequestMapping("/success")
                   /* ▲사용자 요청에 대한 URL*/\
    public String success(Model model) {
                             /*▲ success()메소드 실행후 뷰에서 활용되는 데이터를 담고있는 객체*/
               /* ▼뷰로 사용되는 JSP파일 이름*/
        return "success";
    }
  ```