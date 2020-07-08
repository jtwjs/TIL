## ExceptionTranslationFIlter

> 필터 체인에서 발생하는 AccessDeniedException 과 AuthenticationException을 처리하는 필터

- AuthenticationException(인증예외) 발생 시
  - AuthenticationEntryPoint 실행
  - AbstractSecurityInterceptor 하위 클래스 (예, FilterSecurityInterceptor)에서 발생하는 예외만 처리
  - 그렇다면 UsernamePasswordAuthenticationFilter에서 발생한 인증 에러는?
- AccessDeniedException 발생 시
  - 익명 사용자라면 AuthenticationEntryPoint 실행 (로그인페이지로 이동해서 로그인 시킴)
  - 익명 사용자가 아니라면 AccessDeniedHandler에게 위임
