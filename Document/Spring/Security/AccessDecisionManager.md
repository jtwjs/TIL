## AccessDecisionManager(인가)

- Access Control 결정을 내리는 인터페이스로, 구현체 3가지를 기본으로 제공한다.

  - **AffirmativeBased**: 여러 Voter중 한명이라도 허용하면 허용, 기본 전략
  - ConsensusBased: 다수결
  - UnanimouseBased: 만장일치

- AccessDecisionVoter
  - 해당 Authentication이 특정한 Object에 접근할 때 필요한 ConfigAttributes를 만족하는지 확인
  - **WebExpressionVoter**: 웹 시큐리티에서 사용하는 기본 구현체, ROLE_Xxxx가 매치하는지 확인
  - RoleHierarchyVoter: 계층형 ROLE 지원, ADMIN > MANAGER > USER
  - ...

#### Admin 권한에게 다른 권한도 부여

- SecurityConfig.java

  - ```java

         public AccessDecisionManager accessDecisionManager() {
         RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
         roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_BUYER");

         DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
         handler.setRoleHierarchy(roleHierarchy);

         WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
         webExpressionVoter.setExpressionHandler(handler);

         List<AccessDecisionVoter<? extends Object>> voters = Arrays.asList(webExpressionVoter);

                     return new AffirmativeBased(voters);
         }

         @Override
         protected void configure(HttpSecurity http) throws Exception {
             http.authorizeRequests()
                     .mvcMatchers("/","/Index.in").permitAll()
                     .mvcMatchers("/buyer").hasRole("Buyer")
                     .anyRequest().authenticated()
                     .accessDecisionManager(accessDecisionManager())
                     ;
                 http.formLogin();
                 http.httpBasic();
                 http.csrf().disable();
         }
    ```
