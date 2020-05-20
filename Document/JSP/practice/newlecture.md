### request.parameter("파라미터_명");
- String 데이터타입
- 파라미터 value 값을 받아온다.
#### request.parameterValues("파라미터_명");
- 같은 name의 파라미터를 배열로 받는다. (inedx 0 부터 )

### 한글 인코딩
- request.setCharacterEncoding("utf-8");
    - POST방식의 한글 처리를 해주는 메소드 
    - (HttpServletRequest)의 상위  객체인 ServletRequest에서 제공하는 메소드
    - 클라이언트가 전달한 요청 정보 몸체에 있는 문자열들을 메소드 인자값으로 지정한 문자코드로 인코딩해줌
- response.setCharacterEncoding("utf-8");
    - 사용자에게 보낼 때 utf-8로 인코딩되서 사용자에게 전달하는 코드
- respone.setContentType("text/html; charset=utf-8");
    - 클라이언트에게 UTF-8로 읽으라고 전달하는 코드
### 상태 유지를 위한 5가지 방법
- application
- session
- cookie
- hidden input
- querystring

---
### WAS(Web Application Server) 저장소
-**Application**
    - 사용범위: 전역범위에 사용하는 저장 공간
    - 생명주기: WAS가 시작해서 종료될 떄 까지
    - 저장위치: WAS 서버의 메모리
- Session
    - 사용범위: 세션범위에서 사용하는 저장 공간
    - 생명주기: 세션이 시작해서 종료될 떄 까지
    - 저장위치: WAS 서버의 메모리
- Cookie
    - 사용범위: Web Browser별 지정한 Path 범주공간
    - 생명주기: Browser에 전달한 시간부터 만료시간까지 
    - 저장위치: Web Browser의 메모리 또는 파일

#### Application 저장소: 서블릿 컨텍스트(Context)
- 서블릿들이 서로 문맥을 이어갈수있도록 하는 저장소
    - =자원공유
- ```ServletContext application = request.getServletContext(); ```
- setAttribute("속성_명",값);
- getAttribute("속성_명)
#### Session 객체 
- ```HttpSession session = request.getSession(); ```
- 사용자마다 개인공간
- Session 메소드
    - void setAttribute(String name, Object value)
        - 지정된 이름으로 객체를 설정
    - Object getAttribute(String name)
        - 지정한 이름의 객체를 반환
    - void invalidate()
        - 세션에서 사용되는 객체들을 바로 해제
    - void setMaxInactiveInterval(int interval)
        - 세션 타임아웃을 정수(초)로 설정 (defualt 30분)
#### Cookie 객체
- 클라이언트에 저장함
- 쿠키값은 반드시 문자열로 (URL에 쓸수있는 형태로)
- 쿠키 저장하기
    - ```java
        Cookie cookie = new Cookie(key,value);//쿠키생성
        response.addCookie(cookie);//브라우저에 전달하는 값
        
        ```
- 쿠키 읽기
    - ```java
        Cookie[] cookies = request.getCookies();//쿠키가 꺼내는데 배열로온다.
        String _c = "";

        if(cookies != null)
            for(Cookie cookie : cookies)
                if(키.equals(cookie.getName()))
                   _c = cookie.getValue();
        ```

- path(경로) 설정: 쿠키 사용범위 제한
    - ``` 쿠키객체_명.setPath("경로")```
        - 경로("/") : 모든페이지를 요청할대마다 항상 이 쿠키를(value) 가져와라
        - 경로("/notice/"): notice가 포함된 하위 url을 요청할때 쿠키를 가져옴
- maxAge(만료날짜)옵션
    - maxAge 옵션을 지정안하면 생존주기는 브라우저와 같아진다.(닫히면 날라감)
    - ```쿠키객체_명.setMaxAge(24*60*60);//하루```

---
### redirect
- ``` response.sendRedirect("주소"); ```
- 사용자에게 주소를 이동시킨다.

