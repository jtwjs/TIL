## Application Context
>xml 파일은 모두 객체(Bean)을 정의한다.;
![dispatcherServlet2](https://user-images.githubusercontent.com/60641307/82780384-f10f9c00-9e91-11ea-9b1f-321e1f543ede.png)

- Web Application 최상단에 위치하고 있는 Context
- Spring에서 ApplicationContext란 BeanFactory를 상속받고 있는 Context
- Spring에서 root-context.xml, applicationContext.xml 파일은 ApplicationContext 생성 시 필요한 설정정보를 담은 파일 (Bean 선언 등..)
- 특정 Servlet설정과 관계없는 설정을 한다.(@Service, @Repository, @Configuration, @Component)
- 서로 다른 여러 Servlet에서 공통적으로 공유해서 사용할 수 있는 Bean을 선언
- Application Context에 정의된 Bean은 Servlet Context에 정의된 Bean을 사용할 수 없다.
### servlet-context.xml
> Servlet 단위로 생성되는 context<br>
· JSP와 관련있는 객체(bean) 설정 <br>
· WEB Application에서 client 요청을 받기 위한 설정<br>
· 어노테이션 &#60;annotation-driven/&#62;<br>
· URL 관련 설정<br>
- Spring에서 servlet-context.xml 파일은 DispatcherServlet 생성 시에 필요한 설정 정보를 담은 파일(Interceptor, Bean 생성, ViewResolver 등..)
- URL 설정이 있는 Bean을 생성(@Controller, Interceptor)
- Application Context를 자신의 부모 Context로 사용한다.
- Application Context와 Servlet Context에 같은 id로 된 Bean이 등록 되는 경우, Servlet Context에 선언된 Bean을 사용
- Bean을 찾는 순서
    - Servlet Context에서 먼저 찾는다.
    - 만약 Servlet Context에서 bean을 못찾는 경우 Application Context에 정의된 bean을 찾는다.

### Application Context와 Servlet Context를 나누는 기준
- Application Context
    - 공통 기능을 할 수 있는 Bean 설정(Datasource,Service 등)
    - 각 Servlet에서 공유할 수 있는 Bean
- Servlet Context
    - Servlet 구성에 필요한 Bean 설정 (Controller, Interceptor, MappingHandler등..)


