## home.jsp 구동과정
> 스프링 프로젝트를 생성하고 바로 실행하면 브라우저에 home.jsp가 실행된다.
### home.jsp가 구동되는 과정
1. 클라이언트 요청(/, root 페이지 요청)
2. web.xml에서 dispatcherServlet가 클라이언트 요청을 핸들링
3. servlet-context.xml에서 해당 클래스의 웹요청을 처리하는 컨트롤러를 사용<br>(HandlerMapping으로 Controller를 검색)
4. 해당 Controller가 요청을 처리후, home을 리턴
5. View에 출력

#### DispatcherServlet
> Model 파트와 Controller 파트 View 파트를 조합하여 브라우저로 출력해주는 역할을 수행하는 클래스

![스프링](https://user-images.githubusercontent.com/60641307/82783721-fec91f80-9e99-11ea-98ba-08631d58ef61.jpg)

####  작업 흐름
1. 클라이언트가 해당 어플리케이션에 접근하면 접근한 URL 요청을 DispatcherServlet이 가로챈다.<br>이렇게 요청을 가로챌 수 있는 이유는 web.xml에 등록된 DispatcherServlet의 &#60;url-pattern&#62; '/'와 같이 해당 어플리케이션의 모든 URL로 등록되었기 때문이다.<br> 만약 특정 URL만 적용하고 싶다면 &#60;url-pattern&#62;의 내용을 바꿔주어 범위를 변경시켜주면 된다.

2. 가로챈 정보를 HandlerMapping 에게 보내 해당 요청을 처리할 수 있는 Controller를 찾아 낸다.<br>(스프링은 기본적으로 5가지의 핸들러 매핑을 제공) 이 부분은 스프링의 디폴트 전략에 의해 <br>BeanNameUrlHandlerMapping과 DefaultAnnotaionHandlerMapping이 기본적으로 스프링 MVC에 탑재되었기 때문에 특별한 경우가 아니면 따로 설정할 필요 X

3. 핸들러매핑이 해당 요청을 처리할 컨트롤러를 찾아냈다면 요청을 컨트롤러에게 보내줌<br> 컨트롤러는 사용자가 직접 구현해주는 부분이다. @MVC는 매우 다양한 코딩방식과 직관적이고 편리한 컨트롤러 작성방법을 제공하므로 <br>이 부분에 대해서는 차후 심층적인 분석하여 자신에게 알맞는 전략을 선정해야 한다.

4. 컨트롤러를 해당 요청을 처리한 후에 보통 컨트롤러는 요청을 응답받을 View의 이름을 리턴하게 된다.(핸들러 매핑 전략에 따라 다를수 있음)<br> 그 때 이 이름을 ViewResolver가 먼저 받아 해당하는 View가 존재하는지 검색

5. 해당 View가 있다면 처리결과를 View에 보낸 후 이 결과를 다시 DispatcherServlet에 보낸 후 <br> DispatcherServlet은 최종 결과를 클라이언트에 전송한다.

- 이런 DispatcherServlet 전략에서 사용자가 직접 구현해야할 부분은 컨트롤러와 뷰 뿐<br> 나머지 핸들러 매핑이나 리졸버는 대략적인 흐름만 알고 있다가 나중에 필요할 때 필요한 클래스를 컨텍스트에 등록시키면 됨

#### 01) /WEB-INF/web.xml
>웹 프로젝트의 배치 기술서(deploy descriptor, 웹프로젝트의 환경설정파일)
- 스프링 프로젝트가 실행되면서 가장 먼저 web.xml을 읽어들이게 되고 위에서부터 차례로 태그를 해석하기 시작

#### 02) /WEB-INF/spring/root-context.xml
>스프링의 환경설정 파일
- 현재는 별다른 내용을 작성하지 않았기 때문에 web.xml에서는 root-context.xml을 건너뜀

#### 03) servlet-context.xml
- web.xml에서 DispatcherServlet(스프링에 내장된 컨트롤러)로 이동하게 되고,<br> /WEB-INF/spring/appServlet/servlet-context.xml을 참조하게 된다.