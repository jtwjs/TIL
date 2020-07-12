## 스프링 시큐리티 적용 여부 설정
> WebSecurity의 ignoring()을 사용해서 시큐리티 필터 적용을 제외할 요청을 설정할 수 있다.
```java
@Override
public void configure(WebSecurity web) throws Exception{
    web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocation();
//스프링부트가 제공하는 PathRequest를 사용해서 정적 자원요청을 스프링 시큐리티 필터를 적용하지 않도록 설정
}
```


```java
@Override
        public void configure(WebSecurity web) throws Exception {
         web.ignoring().antMatchers("/resources/**", "/css/**", "/js/**","/Images/**"); 
        }
//스프링부트사용안할시에 정적자원요청(css,js,image)등을 시큐리티 핕러 적용하지 않도록 설정

```