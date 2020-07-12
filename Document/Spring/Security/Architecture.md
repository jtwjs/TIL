## Architecture

![다운로드2](https://user-images.githubusercontent.com/60641307/86870446-5d2d2300-c113-11ea-92c9-69acb31286a2.png)


1. 서블릿 컨테이너에 요청이 들어오면 서블릿 필터들 중에 DeligatingFilterProxy가 서블릿 필터가 등록이되면 특정한 빈 이름(FilterChainProxy "springSecurityFilterChain"이라는 이름의 빈으로 등록됨)으로 필터처리를 위임함
2. 시큐리티 필터 목록들은 내부적으로 체인형식으로 가지고있음
    - webSecurity라는걸로 만듦<br>(HttpSecurity)도 같이사용해서 만듦
3. 필터들이 사용하는 주요한객체가 있다.
    - 인증: **AuthenticationManager**
        - 구현체: ProviderManager
        - 다른 여러 AuthenticationProvider를 사용해서 인증처리를함
        <BR>(DaoAuthenticationProvider)가 그 중 하나
            - UserDetailsService라는 DAO인터페이스를 사용해서 데이터에서 읽어온 유저정보를 사용해서 인증을함
        - 인증 성공후 그 인증정보를 SecurityContextHolder에 넣어 놓고 application 전반에 걸쳐서 사용
    - 인가: **AccessDecisionManager**
        - FilterSecurityInterceptor (인가를처리하는필터)<br>AccessDecisionManager를 사용해서 인가처리를 함
        - 현재 인증된 Authentication이 접근하려는 리소스(특정 URL 특정 Method)에 접근할 적절할 ROLE을 가지고있는지 확인
        - AffirmativeBased를 기본전략으로 사용  
            - 여러 DecsionVoter중에 한명이라도 허용하면 허용
            - 사용하고있는 Voter중 WebExpressionVoter 하나만 사용하고있음
                - SecurityExpressionHandler를 사용해서 expression 처리