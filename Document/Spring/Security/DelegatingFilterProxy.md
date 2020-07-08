## DelegatingFilterProxy

- 일반적인 서블릿 필터
- 서블릿 필터 처리를 스프링에 들어있는 빈으로 위임하고 싶을 때 사용하는 서블릿 필터
- 타겟 빈 이름을 설정
- 스프링 부트 없이 스프링 시큐리티 설정할 때는 AbstractSecurityWebApplicationInitializer를 사용해서 등록

  - ```java
      // AbstractSecurityWebApplicationInitializer를 상속받는 클래스를 만들어주면 자동으로 등록된다.
      package com.spring.config.Security;

      import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

      public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {

      }
    ```

- 스프링 부트를 사용할 때는 자동으로 등록 된다.
  (SecurityFilterAutoConfiguration)

### FilterChainProxy

- 보통 "springSecurityFilterChain"이라는 이름의 빈으로 등록된다.

![다운로드 (1)](https://user-images.githubusercontent.com/60641307/86863571-6cf23a80-c106-11ea-8c32-abea0de0efec.png)
