## Controller 객체 구현

### @RequestMapping을 이용한 URL 맵핑
#### 메소드에 @RequestMapping 적용
- ```http://localhost:8090/lec18/memjoin -> memjoin() 실행```   
#### 클래스에 @ReuqestMapping 적용
- 기능에 따른 컨트롤러 클래스 제작  
- ```java
    @RequestMapping("/member")
    public class MemberController { 

    @RequestMapping("/board")
    public class BoardController {
    ```
- 컨트롤러안의 세부 기능
- ```java
    @RequestMapping("/memJoin")
    public String memJoin(){

    }

    @RequestMapping("/baordWrite")
    public String boardWrite(){

    }
    ```
    

#### 데이터 전송방식에 따른 method 속성 설정
- ```java
    @RequestMapping(value="/memJoin", method=RequestMethod.POST)
    public String memJoinByGet(Model model, HttpServletRequest request){

        return "memJoinOk";
    }
    ```
### 요청파라미터
#### HttpServletRequest 객체를 이용한 HTTP 전송 정보 얻기
- html
```html
    <form action="Pjt17/memLogin" method="POST">
    ID: <input type="text" name="memId">
    PW: <input type="password" name="memPw">
    </form>
  ```

- Controller
```java
    @RequestMapping(value="/memLogin",method=RequestMethod.POST)
    public String memLogin(Model model, HttpServletRequest request){

        String memId = request.getParameter("memId");
        String memPw = request.getParameter("memPw");

        return view;
    }
   ```

#### @RequestParam 어노테이션을 이용한 HTTP 전송 정보 얻기
- html
```html
    <form action="Pjt17/memLogin" method="POST">
    ID: <input type="text" name="memId">
    PW: <input type="password" name="memPw">
    </form>
  ```

- Controller
```java
    @RequestMapping(value="/memLogin",method=RequestMethod.POST)
    public String memLogin(Model model,
            @RequestParam("memId") String memId,
            @RequestParam("memPw") String memPw){

        Member member = service.memberSearch(memId, memPw);

        return view;
    }
   ```
#### 커맨드 객체를 이용한 HTTP 전송 정보 얻기 (★★★★★)
- html
```html
    <form action="Pjt17/memLogin" method="POST">
    ID: <input type="text" name="memId">
    PW: <input type="password" name="memPw">
    </form>
  ```
- java
```java
    public Class member{
        private String memId; // 전송받는 값의 name과 같아야함
        private String memPw;

        public void setMemId(String memId){
            this.memId = memId;
        }
        public String getMemId(){
            return memId;
        }
        public void setMemPw(String memPw){
            this.memPw = memPw;
        }
        public String getMemPw(){
            return memPw;
        }
    }

```


- Controller
```java
    @RequestMapping(value="/memLogin",method=RequestMethod.POST)
    public String memLogin(Member member){// Model 객체 구현안해도됨
        ...
        return view;
    }
         
    
   ```

### @ModelAttribute
1. 커맨드 객체의 이름 변경 가능
    - 변경된 이름은 뷰에서 커맨드 객체를 참조할 때 사용됨
    - Controller ``` public String memJoin(@ModelAttribute("mem") Member member) ```
    - View ``` ID: ${mem.memId} ```
2. @ModelAttribute가 적용되어있는 메소드는 다른어떤 메소드가 호출되면 같이 호출됨
    - ``` @ModelAttribute("serverTime") ```
    - 속성 이름을 View에서 그대로 사용 가능