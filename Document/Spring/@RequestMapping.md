## @RequestMapping, @GetMapping, @PostMapping


### @RequestMapping
- Class 레벨에서 사용
- 이 annotation은 클래스와 메소드 수준에서 모두 사용할 수 있다.
- 대부분의 경우 메소드 레벨에서 애플리케이션은 HTTP 메소드 특정변형 <br>@GetMapping, @PostMapping, @PutMapping @DeleteMapping 또는 @PatchMapping 중 하나를 사용하는 것을 선호

### @GetMapping
- Method 레벨에서만 적용
- HTTP GET 요청을 특정 핸들러 메소드에 맵핑하기 위한 annotation
- 주소에 파라미터가 노출 됨
- @RequestMapping(method = RequestMethod.GET, value = "")와 같은 형태

### @PostMapping
- method 레벨에서만 적용
- 주소창에 파라미터가 노출되지 않는다.
- @RequestMapping(method = RequestMethod.POST, value = "")와 같은 형태
- 메소드에 대해 똒같은 주소 매칭은 에러 발생.
- @RequestMapping은 초기에 설정되고 클래스에 대한 주소 매칭이므로 겹쳐도 상관 X
