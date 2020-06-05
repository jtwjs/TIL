## @Annotation
> @ 사인 하나로 많은 컨텍스트들을 제공 받을 수 있게 한다.

|이름|설명|
|:--|:--|
|@Controller|해당 클래스가 Controller임을 나타내기 위한 어노테이션|
|@RequestMapping|요청에 대해 어떤 Controller, 어떤 메소드가 처리할지를 맵핑하기 위한 어노테이션|
|@RequestParam|Controller 메소드의 파라미터와 웹요청 파라미터와 맵핑하기 위한 어노테이션|
|@ModelAttribute|Controller 메소드의 파라미터나 리턴값을 Model 객체와 바인딩하기 위한 어노테이션|
|@SessionAttributes|Model 객체를 세션에 저장하고 사용하기 위한 어노테이션|
|@RequestPart|Multipart 요청의 경우, 웹요청 파라미터와 맵핑 가능한 어노테이션|
|@CommandMap|Controller메소드의 파라미터를 Map형태로 받을 때 웹 요청 파라미터와 맵핑하기 위한 어노테이션|
|@ControllerAvice|Controller를 보조하는 어노테이션으로 Controller에서 쓰이는 공통기능들을 모듈화하여 전역으로 쓰기 위한 어노테이션|

### @Controller
- Spring의 Controller를 의미
- Spring MVC에서 Controller 클래스에 쓰인다.
### @ModelAttribute
- 클라이언트가 전송하는 **여러 파라미터들을 1대1로 객체에 바인딩**하여 다시 View로 넘겨서 출력하기 위해 사용되는 오브젝트
- 매핑시키는 파라미터의 타입이 객체의 타입과 일치하는지를 포함한 다양한 검증 작업이 추가적으로 진행됨
    - int형 index변수에 "1번"이라는 String 형을 넣으려고 한다면 BindException 발생
- 여러 개의 파라미터를 바로 자바빈 객체로 매핑시킴
- **JSP에서 Form 태그를 통해 전달받은 파라미터들을 객체로 바인딩시키는 경우에 사용**
- 바인딩시키는 어떤 데이터를 set해주는 setter함수가 없다면 매핑이 되지 않는다.
### @RequestParam
> HTTP Request 파라미터를 받을 수 있는 어노테이션<br> HttpServletRequest 객체와 같은 역할을 한다.
- **요청 파라미터를 메소드에서 1:1로 받기위해 사용**
- **기본적으로 반드시 해당 파라미터가 전송되어야한다.**
    - 즉, 반드시 필요한 파라미터인가?를 나타내는 required 값이 defualt로 true로 되어있어<br>해당 파라미터가 전송되지않으면 400 Error를 유발하게 된다.
- ```@RequestParam("가져올 데이터의 이름")[데이터타입][가져온데이터를 담을 변수] ```
- ```(@RequestParam("board_id") String board_id) {} ```
    - 파라메터와 변수 명을 일치 시킨다면 자동값으로 1:1 매핑 된다.
- ```(@RequestParam(value="board_id", required=false) String board-id) {}```
    - 기본값으로 RequestParam은 반드시 값이 존재해야 하도록 설정되어 있지만 required 설정으로 필수 값에서 제외시킬수 있다.
- ```(@RequestParam(value="board_id", defaultValue="100") String board_id) {} ```
    - 또한 defaultvalue로 기본값을 지정할 수 있다.

### @RequestMapping
>**URL을 컨트롤러의 메소드와 맵핑할 때 사용**하는 스프링 프레임워크의 어노테이션<br> (View <==> Controller)
- "컨트롤러 구현" = 클라이언트의 요청을 처리할 메소드를 구현
    - 클라이언트는 URL로 요청을전송
    - 요청 URL을 어떤 메소드가 처리할지 여부를 결정하는 것이 @RequestMapping
- URL과 Controller 메소드의 **매핑을 설정**하는 어노테이션
- URL 이외에도 다양한 속성 지정 가능
- URI 템플릿 기능을 이용하면 URL속의 값을 쉽게 얻어 올 수 있다.

- 요청을 받는 형식인 GET, POST, PATCH, PUT, DELETE를 정의하기도 한다.
- 요청 받는 형식을 정의하지 않는다면, 자동적으로 GET으로 설정
- 메소드 내에서 viewName을 별도로 설정하지 않으면 @RequestMapping의 path로 설정한 URL이 그대로 viewName 됨
- **클라이언트는 URL로 요청을 전송하고, 요청 URL을 어떤 메소드가 처리할지 여부를 결정하는 것**
#### @RequestMapping이 사용하는 속성
|이름|타입|설명|
|:---:|:--|:---|
|value|String[]|URL값으로 매핑조건을 부여함(default)|
|method|RequestMethod[]|HTTP Request 메소드 값을 매핑 조건으로 부여<br>사용 가능한 메소드는  GET, POST, HEAD, OPTIONS, PUT, DELETE, TRACE|
|params|String[]|HTTP Request 파라미터를 매핑조건으로 부여|
|consumes|String[]|설정과 Content-Type request 헤더가 일치할 경우에만 URL이 호출됨|
|produces|String[]|설정과 Accept request 헤더가 일치할 경우에만 URL이 호출됨|

### @RequestMapping의 produces 속성
> @RequestMapping의 produces 속성을 이용해 Response의 Content-Type을 제어할 수 있다. 
- ```@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json;charset=utf-8") ```
- Accept 요청헤더가 이러한 값 중 하나와 일치할때만 요청이 매칭됨
- produces 상태를 사용하면 produces 조건이 지정한 미디어 타입과 관련된 응답을 생성하는데 사용한 실제 컨텐트 타입을 보장함
- **produces는 Accept Header가 produces에 명시한 MediaType과 같을때에 해당 type으로 response를 보내준다.**
- **Accept: client가 Backend 서버에게 어떤 형식(MediaType)으로 달라고 하는 요청의 방식**
    - ex: json 방식으로 보내주세요 => Accept:application/json
### @RequestMapping 의 consumes 속성
- 소비가능한 미디어 타입의 목록을 지정해서 주요한 매핑을 제한할 수 있다.
- Content-Type 요청 헤더가 consumes에 지정한 미디어타입과 일치할때만 요청이 매칭
- **consumes는 Content-Type이 consumes에 명시한 media-type과 같아야한다.**
    - Content-Type : client가 보내는 contet의 타입
#### Produces, Headers 속성
|Element|요청 조건|지원버전|
|:--|:---|:--|
|headrs|HTTP 헤더|3.0.3.1|
|produces|Accept 헤더|3.1|
- Accept 헤더는 headrs 대신 produces 엘리먼트를 이용해 조건을 지정할수 있다.
    - headers와 같은 동작
- **produces**
    - ```java
        @RequestMapping(value="/prod", produces ={"application/JSON"})
        @ResponseBody
        String getProduces(){
            return "Produces attribute";
        }
      ```
- headers
    - ```java
        @RequestMapping(value="/head", headrs= {"content-type=text/plain"})
        String post(){
            return "Mapping applied along with headers";
        }
      ```
- 위와 같이 content-type을 적느냐 안적느냐 차이가 있다.
    - 공통헤더와 요청헤더의 차이
    - headrs는 공통헤더이기 때문에 그중에 content-type="text/plain"인걸 찾으려하는 것
    - producs는 accept헤더를 찾기 때문에 content-type등을 안적어도 된다

### @RequestBody, @ResoponseBody
#### @RequestBody
- 클라이언트가 전송하는 **HTTP 요청의 BODY(본문)내용을 JavaObject로 변환시켜주는 역할**
- 반드시 POST요청과 함께 사용
    - BODY가 존재하지 않는 GET방식의 메소드에 @RequestBody를 활용하는 것은 적합하지 않으므로 에러남
- JSON이나 XML과 같은 형태의 데이터를 Jackson 등의 **MessageConverter**를 활용하여 Java Object로 변환한다.
- @RequestBody가 붙은 파라미터가 있으면 HTTP요청의 미디어 타입과 파라미터의 타입을 먼저 확인한다.
    - 메시지 변환기 중에서 해당 미디어 타입과 파라미터 타입을 처리할 수 있다면<br>HTTP 요청의 본문 부분을 통째로 변환해서 지정된 메소드 파라미터로 전달해준다.
- Parameter로 받은 데이터들을 자바객체로 1대1로 매칭시켜주는 @ModelAttribute와 차이가있음
- **POST방식으로 JSON의 형태로 넘겨온 데이터를 객체로 바인딩하기 위해 사용**
#### @ResponseBody
- @ResponseBody는 @RequestBody와 비슷한 방식으로 동작한다.
- @ResponseBody가 메소드 레벨에서 부여되면 메소드가 리턴하는 오브젝트는 뷰를 통해 결과를 만들어내는 모델로 사용하는 대신, <br>메시지 컨버터를 통해 바로 HTTP 응답의 메시지 본문으로 변환된다.
- **요청한 형태에 맞춰서 메시지 변환기를 통해 결과값을 반환한다.**
- **@ResponseBody는 @RequestBody가 선택한 형식으로 결과값을 변환하여 반환한다.**
- **@ResponseBody를 이용하면 자바 객체를 HTTP 응답 Body로 전송할 수 있다.**

