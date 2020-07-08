## Authentication

```java
Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

UserDetails userDetails = (UserDetails) authentication.getPrincipal();
```

> AuthenticationManager가 인증을 마친 뒤 리턴 받은 Authentication 객체의 행방은?

#### UsernamePasswordAuthenticationFilter

- 폼 인증을 처리하는 시큐리티 필터
- 인증된 Authentication 객체를 SecurityContextHolder에 넣어주는 필터
- SecurityContextHolder.getContext().setAuthentication(authentication)

#### SecurityContextPersistenceFilter

- SecurityContext를 HTTP session에 캐시(기본 전략)하여 여러 요청에서 Authentication을 공유할 수 있는 공유하는 필터.
- SecurityContextRepository를 교체하여 세션을 HTTP session이 아닌 다른 곳에 저장하는 것도 가능
