## PasswordEncoder

> 스프링 시큐리티에는 기본적으로 제공하는 암호화가 있고 KISA에서 표준으로 제시하는 방식도 있다.
> <br>이와 같은 다양한 암호화 방식을 사용하기에 불편하지 않고 확장성을 고려한 PasswordEncoder 인터페이스를 사용해보자.

- 패스워드는 무조건 단방향 암호화/해싱을 사용해야한다.
  - 한번 encode된 패스워드는 다시 복호화를 할 수 없도록 해야한다. <br>(AES,RSA,DES..등의 양방향 암호화를 사용하면 안된다는 뜻)

### 스프링 시큐리티 암호화 클래스 종류

> 3.1버전부터 PasswordEncoder 방식이 바뀌었다.<br>암호화할때 salt를 따로 입력받지 않고 암호화되는 과정에서 랜덤된 키 값을 이용해 암호화하여 매번 새로운 값을 만들어준다.
> <br>그래서 보다 안전한 암호화값을 사용할 수 있다.

- **BCryptPasswordEncoder**

  - 스프링 시큐리티에서 기본적으로 사용하는 암호화 방식
  - 암호화가 될때마다 새로운 값을 생성한다.
  - 임의적인 값을 추가해서 암호화하지 않아도 된다.

- **StandardPasswordEncoder**
  - SHA-256 암호화를 사용
- **NoOpPasswordEncoder**
  - 암호화를 사용하지 않을 때 사용

### 구현

- Bean 생성
  ```java
  @Bean
      public PasswordEncoder passwordEncoder() {
          return PasswordEncoderFactories.createDelegatingPasswordEncoder();
      }
  ```
- Service

  ```java
    @Autowired //
    PasswordEncoder passwordEncoder;

    @Override
    public void RegisterBuyerAccount(BuyerVO buyer) {
    	buyer.setPassword(passwordEncoder.encode(buyer.getPassword())); //암호화
    	 mapper.InsertBuyerAccount(buyer);

    }
  ```
