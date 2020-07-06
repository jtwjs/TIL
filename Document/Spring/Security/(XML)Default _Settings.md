## 스프링 시큐리티란?
- 로그인 기능, 관리자 권한 등과 같은 기술을 좀 더 간편하게 구현할 수 있는 도구이다.
- 기존에는 세션과 인터셉터를 이용하여 개발자가 수동으로 관련 로직을 만들어야 했지만 스프링 시큐리티 기능을 이용하여 몇 가지 설정으로 기능을 구현할 수 있다.

### 1.라이브러리 추가
- Spring Security는 SPring 버전에 의존도가 있기 떄문에, 의존성(dependency)관련 버전을 **반드시 확인**하고 사용해야한다.
    - [의존성에 맞는 버전 찾기](https://mvnrepository.com/artifact/org.springframework.security/spring-security-core)
    - 자신이 쓸 스프링 시큐리티의 버전에 들어간 후, Complie Dependencies에서 스프링 버전을 확인하여 사용
- pom.xml
    ```xml
    <properties>
        <java-version>1.8</java-version>
        <org.springframework-version>5.0.7.RELEASE</org.springframework-version>
        <org.aspectj-version>1.8.4</org.aspectj-version>
        <org.slf4j-version>1.6.6</org.slf4j-version>
        <spring.security.version>5.0.6.RELEASE</spring.security.version>
    </properties>
 
    <!-- Spring Security 사용을 위한 dependency -->
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-core</artifactId>
        <version>${spring.security.version}</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-web</artifactId>
        <version>${spring.security.version}</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-config</artifactId>
        <version>${spring.security.version}</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-taglibs</artifactId>
        <version>${spring.security.version}</version>
    </dependency>
    <!-- Spring Security 사용을 위한 dependency -->
    ```
- **spring-security-core**
    - 인증과 인가 기능을 구현하기 위한 핵심적인 컴포넌트로 구성됨
- **spring-security-web**
    - 웹 애플리케이션 보안 기능을 구현하기 위한 컴포넌트로 구성됨
- **spring-security-config**
    - 각 모듈에서 제공하는 컴포넌트의 설정을 지원하기 위한 컴포넌트로 구성됨
- **spring-security-taglibs**
    - 인증 정보나 인가 정보를 사용하기 위한 JSP 태그 라이브러리로 구성됨
### 2. Spring Security Filter 추가 (XML 기반설정)
- spring security를 적용하기 위한 필터를 추가한다.
- 필터이름을 임의로 변경 X
    - 스프링 시큐리티 내에서 클래스를 찾기위해 지정한 이름이여서 변경하거나 오타가 발생하면 안됨
- web.xml
    - **스프링 시큐리티 설정파일 추가**
        ```xml
        <context-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>
                /WEB-INF/spring/root-context.xml
                /WEB-INF/spring/security/security-context.xml
            </param-value>
        </context-param>
        ```
    - **리스너**
        ```xml
        <!-- 세션이벤트 처리 관련 리스너(로그인중복방지를위한) -->
        <listener>
            <listener-class>org.springframework.security.web.session.HttpSessionEventPublisher</listener-class>
        </listener>
        ```

    - ***필터***
        ```xml
        <!-- Spring Security Filter -->
        <filter>
            <filter-name>springSecurityFilterChain</filter-name>
            <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
        </filter>
        
            <filter-mapping>
                <filter-name>springSecurityFilterChain</filter-name>
                <url-pattern>/*</url-pattern>
            </filter-mapping>
        ```
- 스프링 프레임워크가 제공하는 DelegatingFilterProxy를 이용해서 DI 컨테이너에서 관리되는 빈을 서블릿 컨테이너에 등록한다.
- 서블릿 필터의 이름으로 DI 컨테이너에서 관리되는 빈의 이름을 지정한다.
- 모든 요청에 대해 스프링 시큐리티를 적용한다.
- 필터의 이름은 반드시 springSecurityFilterChain 이여야 한다.
- 해당 필터가 적용될 URL 패턴을 모든 패턴을 의미하는 '/'를 반드시 써줘야 한다.
    - 주소 호출할 때 쓰던 *.do등으로 쓰면안된다.

### 3. Security-context.xml (XML 기반설정)
- web.xml에서 시큐리티 주요 설정 파일의 경로를 /WEB-INF/spring/security/security-context.xml 로 했으므로<br>security 폴더를 만들어서 securiy-context.xml 파일을 만들어 아래 코드를 작성

- **기능 설정**
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:sec="http://www.springframework.org/schema/security"
        xsi:schemaLocation="http://www.springframework.org/schema/beans 
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/security
            http://www.springframework.org/schema/security/spring-security.xsd">
        
        <!-- 정적 리소스 파일 -->
        <sec:http pattern="/css/**" security="none" />
        <sec:http pattern="/img/**" security="none" />
        <sec:http pattern="/js/**" security="none" />
        
        <!-- 인터셉터, 권한, 로그인 기능 설정 -->
        <sec:http auto-config='true' use-expressions="true">
            <!-- 인터셉터 경로 설정 -->
            <sec:intercept-url pattern="/login" access="permitAll" />
            <sec:intercept-url pattern="/**" access="isAuthenticated()" />
            <!-- 폼 로그인 설정 -->
            <sec:form-login login-page="/login"
                            login-processing-url="/login/check"
                            default-target-url="/success"
                            username-parameter="userId" 
                            password-parameter="password"
                            authentication-failure-url="/login?error" 
                            always-use-default-target='true' />
            <!-- 로그아웃 설정 -->
            <sec:logout invalidate-session="true"
                        logout-url="/logout"   
                        logout-success-url="/login?logout" />
            <!-- 세션 관련 설정 -->
            <sec:session-management>
                <sec:concurrency-control max-sessions="1"
                                        expired-url="/login"
                                        error-if-maximum-exceeded="true"/>
            </sec:session-management>
            
            <!-- 보안 관련 설정 -->
            <sec:csrf/>
        </sec:http>
        
        <!-- 권한 관리 -->
        <sec:authentication-manager>
            <sec:authentication-provider>
                <sec:user-service>
                    <sec:user name="user" password="1234" authorities="ROLE_USER"/>
                </sec:user-service>
            </sec:authentication-provider>
        </sec:authentication-manager>
        </beans>
    ```
- 이 xml파일 하나로 인터셉터, 관리자 권한, 로그인 등의 기본 설정이 가능하다는 점 <br>좀더 간편하게 기능을 구현할수있는 것이 스프링시큐리티의 장점
- &#60;sec:http&#62;요소를 정의하면 스프링 시큐리티를 이용할 때 필요한 컴포넌트의 빈이 자동으로 정의된다.
- &#60;sec:authentication-manager&#62;요소는 인증용 컴포넌트를 빈으로 정의하는 부분
    - 이 요소를 정의하지 않으면 서버를 가동할 떄 오류가 발생