## @Annotation
> @ 사인 하나로 많은 컨텍스트들을 제공 받을 수 있게 한다.

### @Controller
- Spring의 Controller를 의미
- Spring MVC에서 Controller 클래스에 쓰인다.
### @RequestMapping
> URL을 컨트롤러의 메소드와 맵핑할 때 사용하는 스프링 프레임워크의 어노테이션<br> (View <==> Controller)
- "컨트롤러 구현" = 클라이언트의 요청을 처리할 메소드를 구현
    - 클라이언트는 URL로 요청을전송
    - 요청 URL을 어떤 메소드가 처리할지 여부를 결정하는 것이 @RequestMapping
- URL과 Controller 메소드의 **매핑을 설정**하는 어노테이션
- URL 이외에도 다양한 속성 지정 가능
- URI 템플릿 기능을 이용하면 URL속의 값을 쉽게 얻어 올 수 있다.

- 요청을 받는 형식인 GET, POST, PATCH, PUT, DELETE를 정의하기도 한다.
- 요청 받는 형식을 정의하지 않는다면, 자동적으로 GET으로 설정
#### @RequestMapping이 사용하는 속성
|이름|타입|설명|
|:---:|:--|:---|
|value|String[]|URL값으로 매핑조건을 부여함(default)|
|method|RequestMethod[]|HTTP Request 메소드 값을 매핑 조건으로 부여<br>사용 가능한 메소드는  GET, POST, HEAD, OPTIONS, PUT, DELETE, TRACE|
|params|String[]|HTTP Request 파라미터를 매핑조건으로 부여|
|consumes|String[]|설정과 Content-Type request 헤더가 일치할 경우에만 URL이 호출됨|
|produces|String[]|설정과 Accept request 헤더가 일치할 경우에만 URL이 호출됨|

### @RequestParam
> HTTP Request 파라미터를 받을 수 있는 어노테이션<br> HttpServletRequest 객체와 같은 역할을 한다.
- ```@RequestParam("가져올 데이터의 이름")[데이터타입][가져온데이터를 담을 변수] ```
- ```(@RequestParam("board_id") String board_id) {} ```
    - 파라메터와 변수 명을 일치 시킨다면 자동값으로 1:1 매핑 된다.
- ```(@RequestParam(value="board_id", required=false) String board-id) {}```
    - 기본값으로 RequestParam은 반드시 값이 존재해야 하도록 설정되어 있지만 required 설정으로 필수 값에서 제외시킬수 있다.
- ```(@RequestParam(value="board_id", defaultValue="100") String board_id) {} ```
    - 또한 defaultvalue로 기본값을 지정할 수 있다.
