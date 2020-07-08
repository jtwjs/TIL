## FilterChainProxy

### 스프링 시큐리티가 제공하는 필터들

1. WebAsyncManagerIntergrationFilter
2. SecurityContextPersistenceFilter
   - SecurityContextRepository를 사용해서 기존의 SecurityContext를 읽어오거나 초기화 한다.
   - 기본으로 사용하는 전략은 HTTP Session을 사용한다.
   - Spring-Session과 연동하여 세션 클러스터를 구현할 수 있다.
3. HeaderWriterFilter
4. CsrfFilter
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
9. BasicAuthenticationFilter
   - Basic 인증이란?
     - https://tooles.ielf.org/html/rfc7617
   - 요청 헤더에 username와 password를 실어 보내면 브라우저 또는 서버가 그 값을 읽어서 인증하는 방식
   - 보통, 브라우저 기반 요청이 클라이언트의 요청을 처리할 때 자주 사용
   - 보안에 취약하기 때문에 반드시 HTTPS 사용할 것을 권장
10. RequestCacheAwareFilter
11. SecurityContextHolderAwareRequestFilter
12. AnonymouseAuthenticationFilter
13. SessionManagermentFilter
14. ExeptionTranslationFilter
15. FilterSecurityInterceptor

> 이 모든 필터는 FilterChainProxy가 호출한다.

![다운로드](https://user-images.githubusercontent.com/60641307/86862602-7b3f5700-c104-11ea-80ed-fdb3487ce834.png)

- SecurityFilterChain은 SecurityConfig 에서 만들어진다.
