## Spring Security
>스프링 시큐리티는 스프링 기반의 어플리케이션의 보안(인증과 권한)을 담당하는 프레임워크
- 만약 스프링 시큐리티를 사용하지 않는다면, 자체적으로 세션을 체크하고 redirect 등을 해야 할 것이다.
- 스프링 시큐리티는 보안과 관련해서 체계적으로 많은 옵션들로 이를 지원해준다.
- Filter 기반으로 동작하기 때문에 spring MVC와 분리되어 관리 및 동작한다.
- 참고로 security 3.2 부터는 XML로 설정하지 않고도 자바 bean 설정으로 간단하게 설정할 수 있도록 지원한다.

### 보안관련 용어
- **접근 주체(Principal)**
    - 보호된 대상에 접근하는 유저
- **인증(Authenticate)**
    - 현재 유저가 누구인지 확인(EX. 로그인)
    - 애플리케이션의 작업을 수행할 수 있는 주체임을 증명
- **인가(Autorize)**   
    - 현재 유저가 어떤 서비스, 페이지에 접근할 수 있는 권한이 있는지 검사
- **권한(Authority)**
    - 인증된 주체가 애플리케이션의 동작을 수행할 수 있도록 허락되어있는지를 결정
    - 권한 승인이 필요한 부분으로 접근하려면 인증 과정을 통해 주체가 증명 되어야만 한다.
    - 권한 부여에도 두가지 영역이 존재하는데 웹 요청 권한, 메소드 호출 및 도메인 인스턴스에 대한 접근 권한 부여

### Spring Security 아키텍쳐

![시큐리티 아키텍쳐](https://user-images.githubusercontent.com/60641307/86529870-355d7580-beef-11ea-821b-2074640222b9.png)

1. 클라이언트가 웹 애플리케이션에 요청을 보냄
2. 스프링 시큐리티의 FilterChainProxy 클래스 (서블릿 필터)가 요청을 받은 다음 HttpFirewall 인터페이스의<br> 메소드를 호출해서 HttpServletRequest와 HttpServletResponse에 대한 방화벽 기능을 수행
3. FilterChainProxy 클래스는 SecurityFilterChain에 설정되있는 보안 필터 클래스에 처리를 위임.<br> 이 필터는 실제로 써블릿 필터 형태로 만들어져 있다.
4. SecurityFilterChain에는 여러 보안 필터가 연쇄적으로 연결된 형태로 설정돼 있으며<br> 앞의 보안 필터가 정상적으로 처리되면 뒤이은 보안필터가 뒤이어 호출되는 방식으로 동작함
5. 마지막 보안필터의 처리가 정상적으로 종료되면 뒤이어 남은 서블릿 필터나 서블릿이 실행되어<br> 웹 애플리케이션의 리소스에 접근할수 있게됨
6. FilterChainProxy 클래스는 웹 어플리케이션에서 반환된 리소스를 클라이언트에 전달.

#### 인증관련 아키텍처

![인증관련 아키텍처](https://user-images.githubusercontent.com/60641307/86530111-f6c8ba80-bef0-11ea-9907-6f84556279a5.png)

- **spring security는 세션-쿠키 방식으로 인증한다.**
    - JWT는 spring-security-oauth2를..
    1. 유저가 로그인을 시도(http request)
    2. AuthenticationFilter 에서부터 위와 같이 user DB까지 타고 들어감
    3. DB에 있는 유저라면 UserDetails 로 꺼내서 유저의 session 생성
    4. spring security의 인메모리 세션저장소인 SecurityContextHolder에 저장
    5. 유저에게 session ID와 함꼐 응답을 내려줌
    6. 이후 요청에서는 요청쿠키에서 JSESSIONID를 까봐서 검증 후 유효하면 Authentication을 쥐어준다.

#### security의 filter들

![시큐리티 필터](https://user-images.githubusercontent.com/60641307/86530190-95edb200-bef1-11ea-9e85-97ef29633138.png)

1. **SecurityContextPersistenceFilter**
    - SecurityContextRepository에서 SecurityContext를 가져오거나 저장하는 역할을 한다.
2. **LogoutFilter**
    - 설정된 로그아웃 URL로 오는 요청을 감시하며, 해당 유저를 로그아웃 처리
3. **(UsernamePassword)AuthenticationFilter**
    - (아이디와 비밀번호를 사용하는 form 기반 인증)설정된 로그인 URL로 오는 요청을 감시하며, 유저 인증처리
    1. AuthenticationManager를 통한 인증 실행
    2. 인증 성공 시, 얻은 Authentication 객체를 SecurityContext에 저장 후 AuthenticationSuccessHandler 실행
    3. 인증 실패 시, AuthenticationFailureHandler 실행
4. **DefaultLoginPageGeneratingFilter**
    - 인증을 위한 로그인폼 URL을 감시한다.
5. **BasicAuthenticationFilter**
    - HTTP 기본 인증 헤더를 감시하여 처리
6. **RequestCacheAwareFilter**
    - 로그인 성공 후, 원래 요청 정보를 재구성하기 위해 사용됨
7. **SecurityContextHolderAwareRequestFilter**
    - HttpServletRequestWrapper를 상속한 SecurityContextHolderAwareRequestWrapper클래스로 HttpServletRequest 정보를 감싼다.
    - SecurityContextHolderAwareRequestWrapper 클래스는 필터 체인상의 다음 필터들에게 부가정보를 제공한다.
8. **AnonymouseAuthenticationFilter**
    - 이 필터가 호출되는 시점까지 사용자 정보가 인증되지 않았다면 인증 토큰에 사용자가 익명사용자로 나타남
9. **SessionManagermentFilter**
    - 이 필터는 인증된 사용자와 관련된 모든 세션을 추적한다.
10. **ExceptionTranslationFilter**
    - 이 필터는 보호된 요청을 처리하는 중에 발생할 수 있는 예외를 위임하거나 전달하는 역할을 한다.
11. **FilterSecurityInterceptor**
    - 이 필터는 AccessDecisionManager 로 권한부여 처리를 위임함으로써 접근 제어 결정을 쉽게 해준다.

### Authentication
- 모든 접근 주체(=유저)는 Authentication을 생성한다.<br> 이것은 SecurityContext에 보관되고 사용된다.
    - 즉 security의 세션들은 내부 메모리(SecurityContextHolder)에 쌓고 꺼내쓰는 것이다.
    - 참고로 Authentication 인터페이스는 자주쓰이니 알아둬야함
    - ```java
        public interface Authentication extends Principal, Serializable { 
            Collection<? extends GrantedAuthority> getAuthorities(); 
            // Authentication 저장소에 의해 인증된 사용자의 권한 목록 Object getCredentials(); 
            // 주로 비밀번호 Object getDetails(); 
            // 사용자 상세정보 Object getPrincipal(); 
            // 주로 ID boolean isAuthenticated(); 
            //인증 여부 void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException; 
        }
      ```

### AuthenticationManager

![AuthenticationManager](https://user-images.githubusercontent.com/60641307/86530391-52944300-bef3-11ea-8fc8-d6bf1cc76b68.png)

- 유저의 요청 내에 담긴 Authentication를 AuthenticationManager 에 넘겨주고,<br> AuthenticationManager를 구현한 ProviderManager가 처리한다.
    - 정확히는 ProviderManager는 ```private List<AuthenticationProvider> providers;``` 로 여러 AuthenticationProvider를 가질 수 있는데,<br> 이 친구들이 처리를 해서 Authentication를 반환해 준다.(실패하면 예외던짐)
        - AuthenticationManager : 인증 요청을 받고 Authentication를 채운다.
        - AuthenticationProvider : 실제 인증이 일어나며, 성공하면 Authentication.isAuthenticated = true를 한다.

