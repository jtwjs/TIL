## web.xml
> 서블릿 클래스는 JSP페이지와 달리 설치뿐만 아니라 등록을 하는 과정을 필요로한다.<br>여기서 서블릿 클래스를 등록하는 곳의 이름을 Web application **deployment descriptor**(DD)라고 한다.<br>DD 역할을 하는 것이 바로 web.xml, web.xml파일은 웹어플리케이션 디렉터리마다 딱하나씩만 존재가능<br>DD는 WAS 구동 시 /WEB-INF 디렉토리에 존재하는 web.xml을 읽어 웹 어플리케이션의 설정을 구성하기 위해 존재
- 최초로 WAS가 구동될 때, 각종 설정을 정의해줌
- 여러 xml파일을 인식하도록 각 파일을 가리켜줌
- 역할
    - Deploy할 때 Servlet의 정보를 설정해준다.
    - 브라우저가 Java Servlet에 접근하기 위해서는 WAS(tomcat)에 필요한 정보를 알려줘야 해당 Servlet을 호출할 수 있다.
        - 정보 1) 배포할 Servlet이 무엇인지
        - 정보 2) 해당 Servlet이 어떤 URL에 매핑되는지

### Ex
-
    ```xml
    <web-app>

    <!-- 1. aliases 설정 -->
    <servlet>
        <servlet-name>welcome</servlet-name>
        <servlet-class>servlets.WelcomeServlet<servlet-class>
    </servlet>

    <!-- 2. 매핑 -->
    <servlet-mapping>
        <servlet-name>welcome</servlet-name>
        <url-pattern>/welcome</url-pattern>
    </servlet-mapping>

    </web-app>
    ```
1. aliases 설정
    - **서블릿 이름을 실제 서블릿 클래스에 연결**
    -  ```<servlet-name>welcom</servlet-name>```과 아래 매핑설정에서의 servlet-name은 반드시 같아야한다.
    - ```<servlet-class>servlets.WelcomeServlet</servlet-class>```은 개발자에 의해 작성된 실제 클래스 이름으로 설정해야 한다.
    - Ex) 패키지_명.서블릿클래스_명
2. 매핑
    - **URL을 서블릿 이름에 연결**
    - ```<url-pattern>/welcome</url-pattern>```은 클라이언트(browser)의 요청 URL에서 앱(프로젝트)이름 뒤에 오는 부분으로, 슬래시('/')로 시작해야한다.
#### 클라이언트(browser)가 요청하는 URL 정보
- 요청을 보낼 서버의 IP 주소 : port 번호/ App 이름 / 달라고 요청하는 HTML
    - ex:) localhost:8080/FormHandlingServlet/LoginForm.html

---

## Spring MVC에서의 web.xml 구체적인 설정 내용
>   · DispatcherServlet<br>· ContextLoaderListener<br>· encodingFilter
### DispatcherServlet
- Spring Container를 생성한다.
    - Spring Container: Controller의 lifecycle 관리
- 클라이언트의 요청을 처음으로 받는 클래스(Spring에서 제공)
- 클라이언트의 요청을 Handler(Controller)에 보낸다.
- 그 외 필요한 것
    - **HandlerMapiing**
        - 어떤 url을 받을지 결정
    - **ViewResolver**
        - logical view name - prefix, suffix -> pysical view object
        
    ![dispatcherServlet](https://user-images.githubusercontent.com/60641307/82776720-d683f580-9e86-11ea-80b3-67cf3822ebd0.png)

- Ex:) 
    - 쇼핑몰의 경우 의류/가구 에 대한 요청을 별도로 처리 가능
    - 각 기능의 요청별로 DispatcherServlet을 할당
    - 아래와 같은 설정을 각 기능에 맞게 추가

    ```xml
    <servlet>
    <servlet-name>salesServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <!-- contextLoader가 해당 위치의 설정 파일을 읽어, 해당 파일을 dispatcher servlet으로 만든다. -->
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/salesServlet-servlet.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
    </servlet>

    <!-- /sales로 시작하는 url 요청을 받아 salesServlet에서 처리한다. -->
    <servlet-mapping>
    <servlet-name>salesServlet</servlet-name>
    <url-pattern>/sales</url-pattern>
    </servlet-mapping>

    ```
    - ```<init-param>``` 부분은 생략 가능
        - ```<servlet-name>```에 설정한 이름 +-servlet.xml형식으로 설정 파일 이름을 만들고<br> web.xml과 같은위치(/WEB-INF 하위)에 있어야 contextLoader가 해당 파일을 찾아서 읽을 수 있다.
        - 위와 같이 설정하면 init-param으로 dispatcher xml파일의 이름을 설정하지 않아도 자동 로드됨
        - Ex) salesServlet-servlet.xml

### ContextLoaderListener
- Controller가 공유하는 Bean들을 포함하는 Spring Container를 생성
    - 공유하는 Bean: Dao, DataSource, Service

    ![ContextLoaderListener](https://user-images.githubusercontent.com/60641307/82779308-d1c33f80-9e8e-11ea-9d37-9ad0475dfdde.png)

 - 각 Bean에 대한 설정 파일을 따로 생성
        - **service-context.xml**
            - service 관련
        - **dao-context.xml**
            - Dao 관련
        - **applicationContext.xml**
            - DataSource 관련, properties 등록, SessionFactory, TransactionManager 등
        - **security-context.xml**
            - Security 관련, BCryptPasswordEncoder 등
        - cf) **salesServlet-servlet.xml**
            - controller 관련, ViewResolver, mvc:annotation-driven 설정 등
- DispatcherServlet에 의해 생성된 Bean은 ContextLoaderListener에 의해 생성된 Bean을 참조 할 수 있다.
    ```xml
    <!-- 이렇게 등록된 설정 파일에 따라 등록된 Bean들은 모두 공유가 가능하다. -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>
            /WEB-INF/service-context.xml
            /WEB-INF/dao-context.xml
            /WEB-INF/applicationContext.xml
            /WEB-INF/security-context.xml
        </param-value>
    </context-param>

    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    ```

### encodingFilter
> 인코딩을 UTF-8로 설정하여 필터링하겠다는 설정
    ```xml
    <filter>
        <filter-name>encodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>

    <!-- /의 형식으로 시작하는 url에 대하여 UTF-8로 인코딩 -->
    <filter-mapping>
        <filter-name>encodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    ```

### saleServlet-servlet.xml 안의 설정 내용
- Annotation 활성화
    - ```<mvc:annotation-driven />```
- Component 패키지 설정
    - ``` <context:component-scan base-package="controller"/>```
    - 이 패키지를 스캔하며 annotation이 달린것을 bean으로 생성하여 Container에 담아둔다.
    - 이 내용은 service, dao 설정에도 필요하다
    - ```<context:component-scan base-package="service" />```
    - ```<context:component-scan base-package="dao" /> ```
- 정적인 data 위치 mapping
    - ```<mvc:resources mapping="/static/**" location="/static/" />```
    - ```<mvc:resources mapping="/resources/**" location="/resources/" />```
    - Controller 가 처리할 필요 없이 해당 위치의 디렉토리에서 바로 접근 가능
    - HTTP GET 요청에서의 정적인 data에 바로 매핑 가능
- View Resolver
    - ```xml
    <bean class="org.springframework.web.servlet.viewInternalResourceViewResolver">
    <property name="prefix" value="/WEB-INF/views/"/>
    <property name="suffix" value=".jsp"/>
    </bean>
      ```
