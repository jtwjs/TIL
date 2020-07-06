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

### 2. Java Configuration
>스프링 시큐리티 레퍼런스에서는 자바 기반의 설정으로 설명하고 있다.
- 스프링 프레임워크 3.1에서부터 어노테이션을 통한 자바 설정을 지원
    - XML로 설정하지 않고도 간단하게 설정할 수 있도록 지원한다.
- 자바기반의 설정에서는 WebSecurityConfigurerAdapter를 상속받는 클래스에 **@EnableWebSecurity 어노테이션**을 명시하는 것 만으로도<br> **springSecurityFilterChain가 자동으로 포함되어진다.**
    - ```java
        @EnableWebSecurity
        public class WebSecurityConfig extends WebSecurityConfigurerAdapyer{

        }
      ```
    - XML기반의 설정에서는 web.xml에 org.springframework.web.filter.DelegatingFilterProxy라는 springSecurityFilterChain을 등록함
- 포함된 springSecurityFilterChain을 등록하기 위해서는 AbstractSecurityWebApllicationInitializer를 <br>상속받은 WebApplicationInitializer를 만들어두면 된다.
    - ```java
        public class SecurityWebApplicationInitializer
            extends AbstractSecurityWebApplicationInitializer {

            }
      ```
- 스프링 MVC를 이용해서 애플리케이션을 구성하기 때문에 ApplicationInitializer에<br> WebSecurityConfigurerAdapter를 상속받은 클래스를 getRootConfigClasses() 메소드에 <br>추가하는 것으로 스프링 시큐리티에 대한 기본적인 적용은 끝
    - ```java
        public class ApplicationInitializer extends 
            AbstractAnnotationConfigDispatcherServletInitializer {

                @Override
                protected Class<?>[] getRootConfigClasses() {
                    return new Class[] { WebSecurityConfig.class};
                }
                //..other overrides..
            }
      ```