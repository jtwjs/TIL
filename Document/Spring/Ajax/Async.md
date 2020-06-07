## Async(비동기 처리)
- 스프링에서 비동기 처리를 하는 경우 @RequestBody와 @ResponseBody를 사용한다.

### 클라이언트와 서버의 비동기 통신 처리
> 웹에서 이루어지는 데이터를 가져오고, 전송하는 이러한 동작들은 클라이언트와 서버간의 통신이 이루어지기 때문에 가능하다.
- 보통 웹에서 화면 전환(refresh, F5)이 없이 이루어지는 동작들은 대부분 비동기 통신으로 이루어진다.
- 요청(request)
    - 클라이언트에서 서버로 통신하는 메시지
- 응답(response)
    - 서버에서 클라이언트로 통신하는 메시지
- 비동기 통신을 하기 위해서 클라이언트가 서버로 요청메세지의 본문에 데이터를 담아서 보내야하며<br> 서버도 클라이언트로 응답을 보내기 위해서는 응답 메시지의 본문에 데이터를 담아서 보내야한다.
- 여기서 중요한 포인트가 바로 **본문(body)** 
- 요청본문(RequestBody), 응답 본문(ResponseBody)
- **JSON**(JavaScript Object Nation)
    - 본문에 담겨야 하는 데이터의 형식
- 비동기 클라이언트 서버 통신을 위해서 데이터를 전송하는데 JSON이라는 형식의 데이터를 서버와 클라이언트 서로서로에게 전송하는 것
### 요청 본문에 담긴 값을 자바 객체로 Conversion
- @RequestBody를 통해서 자바 객체로 Conversion을 할때 그냥 변환되는것이 아니라 HttpMessageConverter를 사용하는데<br> 아래의 메소드에 각종 메시지 컨버터가 설정되어있다.
    - ```WebMvcConfigurationSupport.addDefaultHttpMessageConverters ```
> 만약 요청이 JSON으로 들어온 경우 요청 헤더에 (request header)에 컨텐츠 타입(Content-Type)을 알려줘야 한다.<br>
그러면 헤더에 있는 컨텐츠 타입을 보고 JSON을 컨버팅할 수 있는 컨버터(Jackson2ObjectMapperBuilder)를 사용해야겠다고 <br>JSON을 자바 객체로 변환하는 메시지 컨버터를 사용하여 요청 본문에 담긴 데이터를 자바 객체로 변환하게 되는 것
- ```java
    @RestController
    @RequestMapping("/api")
    public class HttpMessageController {
        /*
        @RequestBody를 통해 자바 객체로 변환할 때 HttpmessageConverter를 사용하여 
        헤더에 담긴 컨텐츠 타입을 보고  어떤메시지 컨버터를 사용할 것인지 판단하여 
        요청 본문에 담긴 값을 자바 객체로 변환
        */
        @GetMapping
        public String create(@RequestBody Evnet evnet){
            ...
            return "redirect:/api/list";
        }
    
    }
  ```
### 정리
- **@RequestBody**
    - 클라이언트에서 서버로 필요한 데이터를 전송하기 위해서 JSON이라는 데이터를 요청 본문에 담아서 서버로 보내면,<br>서버에서는 @RequestBody 어노테이션을 사용하여 HTTP 요청 본문에 담긴 값들을 자바 객체로 변환 시켜, 객체에 저장시킴
- **@ResponseBody**
    - 서버에서 클라이언트로 응답 데이터를 전송하기 위해서 @ResponseBody를 사용하여 <br> 자바 객체를 HTTP 응답 본문의 객체로 변환하여 클라이언트로 전송시키는 역할을 한다.