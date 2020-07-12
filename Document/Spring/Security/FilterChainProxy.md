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

## FilterChainProxy

- 보통 "springSecurityFilterChain"이라는 이름의 빈으로 등록된다.

![다운로드 (1)](https://user-images.githubusercontent.com/60641307/86863571-6cf23a80-c106-11ea-8c32-abea0de0efec.png)


### 스프링 시큐리티가 제공하는 필터들

1. **WebAsyncManagerIntergrationFilter**
   - 스프링 MVC의 Async기능(핸들러에서 Callable을 리턴할 수 있는 기능)을 사용할 때에도 SecurityContext를 공유하도록 도와주는 필터
      - PreProcess: SecurityContext를 설정한다.
      - Callable: 비록 다른 쓰레드지만 그 안에서는 동일한 SecurityContext를 참조할 수 있다.
      - PostProcess: SecurityContext를 정리(celan up)한다.
   - 사용자가 따로 설정할것은 없다.
2. **SecurityContextPersistenceFilter**
   - SecurityContextRepository를 사용해서 기존의 SecurityContext를 읽어오거나 초기화 한다.
   - 기본으로 사용하는 전략은 HTTP Session을 사용한다.
   - Spring-Session과 연동하여 세션 클러스터를 구현할 수 있다.
3. HeaderWriterFilter
   - **XContentTypeOptionsHeaderWrite**: 마임 타입 스니핑 방어.
   - **XXssProtectionHeaderWriter**: 브라우저에 내장된 XSS 필터 적용.
   - **CacheControlHeadersWriter**: 캐시 히스토리 취약점 방어
   - HstsHeaderWriter: HTTPS로만 소통하도록 강제
   - **XFrameOptionsHeaderWriter**: clickjacking 방어.
   - Header 정보
      ```
      **Cache-Control: no-cache, no-store, max-age=0, must-revalidate**
         - 캐시를 설정하지 않도록 설정(동적인 리소스)
      Content-Language:en-US
      Content-Type:text/html;charset=UTF-8
      Date:Sun,04 Aug 2019 16:25:10 GMT
      **Expiress: 0**
      **Pragma: no-cache**
      Transfer-Encoding: chunked
      **X-Contet-Type-Opttions: nosniff**
         - 반드시 Content-Type에 명시된 마임타입으로만 실행(ex:다운로드)
         - 보안상 좀 더 안전
      **X-Frame-Options: DENY**
         - clickjacking을 방어할수있는 헤더정보를 넣어줌
      **X-XSS-Protection: 1; mode=block**
         - 1: 기능활성화 mode=block: 막아주는 것
      ```
   
4. **CsrfFilter**
   - CSRF(Cross Site Request Forgery: 사이트 간 요청 위조) 어택 방지 필터
      - 인증된 유저의 계정을 사용해 악의적인 변경 요청을 만들어 보내는 기법
      - http://www.owasp.org/index.php/Cross-Site_Request_Forgery_(CSRF)
      - http://namu.wiki/w/CSRF)
      - CORS를 사용할 떄 특히 주의 해야 함
         - 타 도메인에서 보내오는 요청을 허용하기 때문에..
         - https://en.wikipedia.org/wiki/Cross-origin_resource_sharing
      - 의도한 사용자만 리소스를 변경할 수 있도록 사용하는 필터
         - **CSRF 토큰**을 사용하여 방지
5. LogoutFilter
   - 여러 LogoutHandler를 사용하여 로그아웃시 필요한 처리를 하며 <br>이후에는 LogoutSuccessHandler를 사용하여 로그아웃 후처리를 한다.
   - LogoutHandler
     - CsrfLogoutHandler
     - SecurityContextLogoutHandler
   - LogoutSuccessHandler
     - SimpleUrlLogoutSuccesshandler
   - 로그아웃 필터 설정
     ```java
         http.logout()
             .logoutUrl("/logout")
             .logoutSuccessUrl("/")
             .logoutRequestMatcher()
             .invalidateHttpSession(true)
             .deleteCookies()
             .addLogoutHandler()
             .logoutSuccessHandler();
     ```
6. UsernamePasswordAuthenticationFilter
   - 폼 로그인을 처리하는 인증필터
   - 사용자가 폼에 입력한 username과 password로 Authentication을 만들고<br>AuthenticationManger를 사용하여 인증을 시도한다.
   - AuthenticationManager(ProviderManager)는 여러 AuthenticationProvider를 사용하여 인증을 시도하는데, <br>그 중에 DaoAuthenticationProvider는 UserDetailsService를 사용하여 UserDetails 정보를 가져와<br> 사용자가 입력한 password와 비교한다.
7. DefaultLoginPageGeneratingFilter
   - 기본 로그인 폼 페이지를 생성해주는 필터
   - GET /login 요청을 처리하는 필터
8. DefaultLogoutPageGeneratingFilter
   - 기본 로그아웃 폼 페이지를 생성해주는 필터
9. BasicAuthenticationFilter
   - Basic 인증이란?
     - https://tooles.ielf.org/html/rfc7617
   - 요청 헤더에 username와 password를 실어 보내면 브라우저 또는 서버가 그 값을 읽어서 인증하는 방식
   - 보통, 브라우저 기반 요청이 클라이언트의 요청을 처리할 때 자주 사용
   - 보안에 취약하기 때문에 반드시 HTTPS 사용할 것을 권장
10. RequestCacheAwareFilter
   - 현재 요청과 관련있는 캐시된 요청이 있는지 찾아서 적용하는 필터
      - 캐시된 요청이 없다면, 현재 요청 처리
      - 캐시된 요청이 있다면, 해당 캐시된 요청 처리
11. SecurityContextHolderAwareRequestFilter
   - 시큐리티 관련 서블릿 API를 구현해주는 필터
      - HttpServletRequest#authenticate(HttpServletResponse)
      - HttpServletRequest#login(String, String)
      - HttpServletRequest#logout()
      - AsyncContext#start(Runnable)
12. AnonymouseAuthenticationFilter
   - 현재 SecurityContext에 Authentication이 nuull이면 "익명 Authentiaction"을 만들어주고<Br>null이 아니면 아무것도 하지 않는다.
   - 기본으로 만들어 사용할 "익명 Authentication" 객체를 설정할 수 있다.
      - ```java
            http.anonymouse()
               .principal()
               .authorities()
               .key()
        ```
13. SessionManagermentFilter
   - 세션 변조 방지 전략 설정: sessionFixation
      - 세션 변조: https://www.owasp.org/index.php/Session_fixation
      - none
      - newSession
      - migrateSession(서블릿 3.0-컨테이너 사용시 기본값)
      - changeSessionId(서블릿 3.1+컨테이너 사용시 기본값)
   - 유효하지 않은 세션을 리다이렉트 시킬 URL설정
      - invalidSEssionUrl
   - 동시성 제어: maximumSession
      - 추가 로그인을 막을지 여부 설정 (기본값: false)
   - 세션 생성 전략: sessionCreationPolicy
      - IF_REQUIRED
      - NEVER
      - STATELESS
      - ALWAYS
14. ExeptionTranslationFilter
   - 필터 체인에서 발생하는 AccessDeniedException 과 AuthenticationException을 처리하는필터 
   - AccessDeniedException 발생 시
      - 익명 사용자라면 AuthenticationEntryPoint 발생<br>(로그인 페이지로 이동해서 로그인시킴)
      - 익명 사용자가 아니라면 AccessDeniedHandler에게 위임
   - AuthenticationException(인증예외) 발생 시
      - AuthenticationEntryPoint 실행
      - AbstractSecurityInterceptor 하위 클래스(예, FilterSecurityInterceptor)에서 발생하는 예외만 처리 
      - 그렇다면 UsernamePasswordAuthenticationFilter에서 발생한 인증에러는 ?
15. FilterSecurityInterceptor
   - HTTP 리소스 시큐리티 처리를 담당하는 필터, AccessDecisionManager를 사용하여 인가를 처리한다.
   - AccessDecisionManager를 사용하여 Access Control 또는 예외 처리하는 필터
   - 대부분의 경우 FilterChainProxy에 제일 마지막 필터로 들어있다.
   - HTTP 리소스 시큐리티 설정
      - ```java
               http.authorizeRequests()
            
            		.mvcMatchers("/Buyer**").hasRole("BUYER")
            		.mvcMatchers("/Seller**e").hasRole("SELLER")
            		.mvcMatchers("/**").permitAll()
            		.anyRequest().authenticated()
                    .accessDecisionManager(accessDecisionManager())
        ```
16. RememberMeAuthenticationFilter
   - 추가적인 필터 (토큰 기반 인증 필터)
   - 세션이 사라지거나 만료가 되더라도 쿠키 또는 DB를 사용하여 저장된 토큰 기반으로 인증을 지원하는 필터
   - RemeberMe 설정
      ```java
            http.rememberMe()
               .userDetailsService(accountService)
               .key("remember-me-sample");
      ```
   - 쿠키 플러그인
      - https://chrome.google.com/webstore/detail/editthiscookie/fngmhnnpilhplaeedithccceomclgfbg?hl=en
> 이 모든 필터는 FilterChainProxy가 호출한다.

![다운로드](https://user-images.githubusercontent.com/60641307/86862602-7b3f5700-c104-11ea-80ed-fdb3487ce834.png)

- SecurityFilterChain은 SecurityConfig 에서 만들어진다.
