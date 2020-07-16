## CSRF (Cross Site Request Forgery: 사이트간 요청 위조)

> Spring Security의 CSRF 프로텍션은 Http 세션과 동일한 생명주기(Life Cycle)을 가지는 토큰을 발행한 후 Http 요청(PATCH, POST, PUT, DELETE 메소드인 경우)마다 발행된 토큰이 요청에 포함되어 (Http헤더 혹은 파라미터 둘중 하나)있는지 검사하는 가장 일반적으로 알려진 방식의 구현이 설정되어 있다.

### 설정방법

- Spring Securty가 설정되면 기본적으로 CSRF 프로텍션은 활성화됨

### CSRF 토큰을 Http 요청에 포함시키는 방법

- CSRF토큰은 Http 세션과 동일한 생명주기를 가지기 떄문에 세션속성으로 저장되게 됨
- Spring Security는 해당 토큰을 Http요청마다 **'\_csrf'** 라는 간단한 이름의 Http Request 속성으로 바인딩시켜 사용성을 올려 준다.

#### Form의 파라미터

- HTTP Requset 속성에 바인딩 되어 있기 떄문에 EL 표션식을 사용할수 있다.

```html
<form action="" method="post">
  <input type="text" name="" value="" />
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  <button type="submit" value="submit"></button>
</form>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
```

- 위와 같이 **'\_csrf'** 라는 HTTP Request 속성을 통해서 파라미터명과 토큰을 취득하여 Form의 숨겨진 요소로 추가하면 간단하게 포함시킬수 있다.

- Spring MVC에서 제공하는 `<form:form>`태그를 사용하거나 Thymeleaf2.1이상이면서 `@enableWebSecurity`를 사용한 경우에는 `CsrfRequestDataValueProcessor`가 적용되어 필요한 form에 자동으로 CSRF 토큰이 포함하게 된다.

#### Ajax 요청시 헤더

- 사용자 경험을 향상시키기 위해서 화면이동을 제외한 처리는 대부분 Ajax를 통한 JSON 요청으로 처리하는 경우가 많다.
- 이경우 위와같이 파라미터로 토큰을 전송할 수 없으므로 HTTP 헤더를 통해서 전송할 수 있다.

```js
html
<head>
 <meta id="_csrf" name="_csrf" content="${_csrf.token}" />
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}" />
</head>

$.ajaxPrefilter(function(options) {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    beforeSend: function(xhr){
			  /*데이터를 전송하기 전에 헤더에 csrf값을 설정한다*/
			  xhr.setRequestHeader(header, token);
		  },

    error: function(xhr,status,error){
			  console.log('error:'+error);
		  }

```

- 위의 코드는 jQuery를 사용하는 경우 모든 Ajax Post 요청에 대해서 HTTP 헤더에 CSRF 토큰을 설정하는 코드이다.
- Ajax요청을 특정 라이브러리로 단일화 하여 구현하기를 추천
  - 단순한 설정만으로 모든 요청에 CSRF 토큰을 추가하는 것이 가능하기 때문

### 그 이외의 설정

#### 비활성화

- CSRF 프로텍션을 비활성화 시키고 싶은 경우에는(추천X) 아래와 같이 disabled()를 호출하면 된다.

```java
@Override
protected void configure(HttpSecurity http)throws Exception {
    http.csrf().disabled();
}
```

#### 특정 요청만 예외처리

- Ant Matcher 혹은 Request Matcher를 지정하여 특정 요청은 대상에서 제외할 수 있다.
  - 예를 들어 외부에서 오는 요청이나 콜백의 경우 제외해야할 필요가 있는 경우가 있다.

```java
@Override
protected void configure(HttpSecurity http)throws Exception {
    http.csrf()
        .ignoringAntMatchers()
        .ignoringRequestMatchers();
}
```

#### 특정 요청은 적용

```java
@Override
protected void configure(HttpSecurity http)throws Exception {
    http.csrf()
        .requireCsrfProtectionMatcher();

}
```

#### 예외처리

- 토큰검증에 실패 했을경우 403 HTTP 응답코드가 반환된다.
- 이때 이동할 페이지 혹은 예외처리를 아래와 같은 설정을 통해 할 수 있다.
- 세션이 만료되어 서버에서 토큰정보를 취득할 수 없는 경우 MissingCsrfTokenException 예외가 발생<br> 전송된 토큰이 다른경우에는 InvalidCsrfTokenException 예외가 발생하므로 필요에 따라 적절한 예외처리를 기술하면 된다.

```java
@Override
protected void configure(HttpSecurity http)throws Exception {
    http.exceptionHandling()
        .accessDeniedPage("")
        .accessDeniedHandler(new AccessDeniedHandler(){
            @Override
            public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception)throws IOException, ServletException{
                if(exception instanceof MissingCsrfTokenException){
                    //Some Exception Handling
                } else if (exception instanceof InvalidCsrfTokenException){
                    //Some Exception Handling
                }
            });
            //..Other Configuration
        }
```
