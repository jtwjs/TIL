## 세션(Session)과 쿠키(Cookie)
- Connectionless Protocol
    - 웹서비스는 HTTP 프로토콜을 기반으로 하는데, HTTP 프로토콜은 클라이언트와 서버의 관계를 유지하지 않는 특징이 있다.
    - 1. [클라 -> 서버] 요청(Request): 서버 연결 
    - 2. [서버 -> 클라] 응답(Response): 서버 연결 해제
- 이러한 Connectionless Protocol의 불편함을 해결하기 위해서 세션과 쿠키를 이용
- 세션과 쿠키는 클라이언트와 서버의 연결상태를 유지해주는 방법으로, <br>세션은 서버에서 연결 정보를 관리하는 반면 쿠키는 클라이언트에서 연결 정보를 관리하는데 차이가 있다.

### HttpServletRequest를 이용한 세션 사용(생성)
- 스프링 MVC에서 HttpServletRequest를 이용해서 세션을 이용하려면 컨트롤러의 메소드에서 파라미터로 HttpServletRequest를 받으면된다.
- ```java
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String memLogin(Member member, HttpServletRequest request) {
        Member mem = service.memberSearch(member);

        HttpSession session = request.getSession();
        session.setAttribute("member",mem);

        return "/member/loginOk";
    }
  ```
### HttpSession을 이용한 세션 사용(생성)
- HttpServletRequest와 HttpSession의 차이점은 거의 없으며, 단지 세션객체를 얻는방법에 차이가 있을뿐..
- **HttpServletRequest**
    - 파라미터로 HttpServletRequest를 받은 후 getSession()으로 세션 얻음,
    - ```public String memLogin(Member member, HttpServletRequest request) {..} ```
- **HttpSession**
    - 파라미터로 HttpSession을 받아 세션 사용 
    - ```public String memLogin(Member member, HttpSession session) {..} ```

### 세션 삭제
- 세션을 삭제하는 방법은 세션에 저장된 속성이 더 이상 필요 없을 때 이루어지는 과정으로 주로 로그아웃 또는 회원 탈퇴 등에 사용됨
- 로그아웃
    - ```java
        @RequestMapping("/logout")
        public String memLogout(Member member, HttpSession session) {
            session.invalidate();//세션삭제

            retrun "/member/logoutOk";
        }
      ```
- 회원탈퇴
    - ```java
        @RequestMapping(value="/remove",method=RequestMethod.POST)
        public String memRemove(Member member,HttpServletRequest request) {
            service.memberRemove(member);
            HttpSession = request.getSession();
            session.invalidate();//세션삭제

            return "/member/removeOk";
        }
      ```

---
### 쿠키(Cookie)
- 쿠키를 생성할 때는 생성자에 두 개의 파라미터를 넣어주는데 첫번째는 쿠키이름을 넣어주고 두 번째는 쿠키값을 넣어준다.
- ```java
    @RequestMapping("/main")
    public String mallMain(Mall mall, HttpServletResponse response) {
        Cookie genderCookie = new Cookie("gender",mall.getGender());

        if(mall.isCookieDel()){
            genderCookie.setMaxAge(0);//쿠키삭제
            mall.setGender(null);
        }else {
            genderCookie.setMaxAge(60*60*24*30);//쿠키유효시간 지정
        }
        response.addCookie(genderCookie);//쿠키생성

        return "/mall/main";
    }
  ```

### 쿠키사용
- 쿠키를 사용할 때는 @CookieValue 를 사용한다.
- @CookieValue(value="gender",required=false)
    - value 속성은 쿠키 이름을 나타내는데, 만약 value에 명시한 쿠키가 없을 경우 익셉션 발생
    - 익셉션을 막는방법은 required = false 설정..
- ```java
    @RequestMapping("/index")
    public String mallIndex(Mall mall,
    @CookieValue(value="gender",required=false)Cookie genderCookie,HttpServletRequest request) {
        if(genderCookie != null)
            mall.setGender(genderCookie.getValue());
            
        return "/mall/index";
    }
  ```