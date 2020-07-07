## SecurityContextHolder 와 Authentication

- SecurityContextHolder
  - SecurityContext 제공
  - 기본적으로 ThreadLocal을 사용한다.
- SecurityContext
  - Authentication 제공

<img width="405" alt="SecurityContextHolder" src="https://user-images.githubusercontent.com/60641307/86771073-97071680-c08c-11ea-90e7-316d8293ada8.png">

#### Authentication

- **Principal과 GrantAutority** 제공

#### Principal

- "누구"에 해당하는 정보
- **UserDetailsService에서 리턴한 그 객체**
- 그 객체는 UserDetails 타입

#### GrandAuthority

- "ROLE_USER", "ROLE_ADMIN"등 Principal이 가지고 있는 "권한"을 나타낸다.
- 인증 이후, 인가 및 권한 확인할 떄 이 정보를 참조한다.

#### UserDetails

- 애플리케이션이 가지고 있는 유저 정보와 스프링 시큐리티가 사용하는 Authentication 객체 사이의 어댑터

#### UserDetailsService

- 유저 정보를 UserDetails 타입으로 가져오는 DAO (Data Access Object) 인터페이스
- 구현은 마음대로!
