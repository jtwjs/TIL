## Cookie (쿠키)
> 쿠키란 클라이언트 측에서 관리되는 정보를 의미
- 세션은 서버 측에서 관리되지만 쿠키는 클라이언트에 정보 저장
- 쿠키의 정보는 세션과 달리 브라우저를 종료한다고 해도 생존기간이 지정되면 생존기간동안 데이터가 사라지지 않는다.
- 쿠키는 하드디스크에 파일로 저장되기에 그 파일이 남아있는 한 항상 유지
    - chrome: C:\Users\bitcamp\AppData\Local\Google\Chrome\User Data\Default\Cache
- 쿠키는 클라이언트에서 관리되기 때문에 보안적으로 매우 취약

### Cookie(쿠키)의 개요 
- HTTP 프로토콜은 상태가 없다. <br>즉 이전에 무엇을 했고, 지금 무엇을 했는지에 대한 정보를 갖고 있지 않는 특성을 가지고 있다.
    - 즉, 웹 브라우저(클라)의 요청에 대한 응답을 하고나면 클라이언트와의 연결을 지속하지 않는다.(Connectionless)
- HTTP 프로토콜은 상태에 대한 지속적인 연결이 없다. <br>따라서 이런부분을 해결하기 위해 웹서버 측에 웹 브라우저의 정보를 저장한 후 계속되는 웹브라우저의 요청 속에 포함되어 있는<br> 웹 브라우저의 정보와 비교해서 동일한 웹 브라우저로부터 온 요청을 판단할수 있다.
- 쿠키(Cookie)는 상태가 없는 프로토콜을 위해 상태를 지속시키기 위한 방법<br>웹 브라우저의 정보를 웹 브라우저에 저장하므로, 이후에 서버로 전송되는 요청에는 쿠키가 가지고 있는 정보가 같이 포함돼 전송된다.<br>이 때 웹서버는 웹 브라우저의 요청 속에 포함되어 있을 쿠키를 읽어서 새로운 웹 브라우저인지 이전에 요청을 했던 웹 브라우저인지를 판단할수있다.

- 이러한 방법으로 웹 브라우저를 통해서 특정 사이트에 접속하면 웹브라우저에 쿠키가 저장되어 접속한 사용자의 정보가 유지되는것

![쿠키](https://user-images.githubusercontent.com/60641307/82180190-05e0b280-991b-11ea-8ac3-d0f9934c24f8.png)

- 쿠키는 웹 사이트에 접속할 때 생성되는 정보를 담은 임시 파일<br> 일반적으로 4KB이하의 크기로 생성됨
<br>이러한 쿠키의 목적은 원래 사이트에 접속한 사용자의 정보를 유지하거나, 사이트에 접속하는 사람들이 해당 사이트에 쉽게 접속하기 위한 것 
- 어떤 웹 사이트에 처음 방문해서 로그인해 사용하고 나면, 아이디와 패스워드를 기록한 쿠키가 만들어진다.<br> 그 다음부터 해당 사이트에 접속하면 별도의 절차없이 사이트에 빠르게 연결할수 있게 된다.<br> 쿠키는 이러한 목적을 사용하기 위해 만들어진 것
- 그러나 쿠키는 개인의 사생활이나 정보를 침해할 소지가 있다는 문제점이 있다. 
    - 이러한 보안상의 문제를 조금이나마 해소하기위해 웹 브라우저 자체에 쿠키 거부기능이 있다.
    - 쿠키에 대한 거부가 웹브라우저에 설정되어있으면, 쿠키 본래 웹 브라우저와의 연결을 지속시키는 기능을 수행할수 없게됨(쿠키의 가장치명적인 단점)


### Cookie(쿠키)의 사용
- JSP에서 쿠키를 사용하려면 javax.servlet.http 패키지에 있는 Cookie 클래스의 객체를 생성해야 한다.
- 이렇게 생성된 쿠키에는 각각의 웹 브라우저를 판별할 수 있는 정보가 포함됨
- 쿠키는 웹 서버가 웹 브라우저의 요청에 응답할때 response 객체에 실려서 사용자의 웹 브라우저에 저장됨
- 웹 브라우저에 저장된 쿠키는 사용자가 다시 웹 서버에 요청을 할 때 request 객체에 실려서 다시 웹 서버에 전달됨
    - 전달된 쿠키값을 읽어서 같은 웹 브라우저로부터 온 요청인지 판별


### 서블릿 API를 이용한 쿠키 설정
- 쿠키 생성
    - ``` Cookie cookie = new Cookie(name, value); ```
- 쿠키 클라이언트로 전송
    - ``` response.addCookie(cookie); ```
- 쿠키 관련 메소드

    |메소드|설명|
    |:---|:---|
    |setValue(String value)|쿠키 값을 설정|
    |setmaxAge(int seconds)|쿠키 만료 기간을 지정|
    |getValue()|쿠키 값을 얻어 온다.|
    |getMaxAge()|쿠키 만료 기간을 얻어온다.|
    |getName()|쿠키 이름을 얻어온다.|


### 쿠키 생성 및 사용
> 쿠키는 이름, 값, 유효기간, 도메인, 경로등으로 이루어져 있다. <br> 이들 중 가장 중요한 구성 요소는 쿠키의 이름과 값이다.

#### (1) 쿠키 생성하기
    ```java
    <%
    //쿠키를 생성한다. 이름: testCookie, 값: Hello
        Cookie info = new Cookie("testCookie","Hello Cookie"); 

    //쿠키의 유효기간을 365일로 설정
        info.setMaxAge(365*24*60*60); 
    // 쿠키의 유효한 디렉토리를 "/"로 설정
        info.setPath("/");

    //클라이언트 응답에 쿠키를 추가
        response.addCookie(info);    
    %>
    ```
#### (2) 쿠키에 저장된 정보 읽어오기
    ```java
    <%
    // 요청정보로부터 쿠키를 가져온다.
        Cookie[] cookies = request.getCookies(); 
    
    // 쿠키가 저장된 배열의 길이를 가져온다
        out.println("현재 설정된 쿠키 갯수:" + cookies.length);

    // 쿠키 배열을 반복문으로 돌림
        for(int i = 0; i<cookies.length; i++) {

    // 쿠키 이름을 가져온다.  
        out.println(i+ "번째 쿠키 이름: "+cookies[i].getName());
    // 쿠키 값을 가져온다.
        out.println(i+"번째 쿠키 값:" +cookies[i].getValue());
        }

    %>
    ```

#### (3) 설정된 쿠키들 모두 삭제하기
    ```java
    <%
    // 요청정보로부터 쿠키를 가져온다.
        Cookies[] cookies = request.getCookies();
    // 쿠키 배열을 반복문으로 돌린다.
        for(int i=0; i<cookies.length;i++) {
    // 특정 쿠키를 더이상 사용하지 못하게 하기 위해서는 
    // 쿠키의 유효시간을 만료시킨다.
            cookies[i].setMaxAge(0);
    // 해당 쿠키를 응답에 추가(수정)한다.
        response.addCookie(cookies[i]);
        }
    %>
    ```

### 쿠키 사용 예제
1. 쿠키 읽어서 가져오기 (자동 로그인 처리)
   -     ```jsp
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <%
            String id = "";

            try{
                Cookie[] cookies = request.getCookies(); //요청에서 쿠키 가져온다.

                if(cookies!=null) {                     //쿠키가 null이 아닐떄

                    for(int i=0; i<cookies.length;i++) {//쿠키를 반복문으로 돌림
                        if(cookies[i].getName().equals("id")){//쿠키의 이름이 id일때
                            id=cookies[i].getValue();   //해당 쿠키의 값을 id 변수에 저장
                        }
                    }
                    if(id.equals("")){      //쿠키에서 이름 id를 찾지못할 때
                        response.sendRedirect("loginForm.jsp");//loginFrom으로 리다이렉트 한다.
                    }
                }
                else{       //요청에서 쿠키가 없을때
                    response.sendRedirect("loginForm.jsp"); //loginForm으로 리다이렉트
                }
            }catch(Exception e){}
        %>
        ```
2. 쿠키 저장하기 (로그인 정보 등록)
    -     ```jsp
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <%
            String id = request.getParameter("id"); //요청에서 id값을 가져온다.
            String passwd = request.getParameter("passwd"); //요청에서 passwd값을 가져온다.
            
            ...     //id와 passwd로 로그인을 확인

            if(check ==1) {     //로그인이 성공일 때

                Cookie cookie = new Cookie("id",id);   //id라는 이름과 request의 id값으로 쿠키 생성
                cookie.setMaxAge(20*60);    //쿠키의 유효시간을 20분으로 설정
                response.addCookie(cookie); //쿠키를 응답에 추가
                response.sendRedirect("cookieMain.jsp");    //cookieMain으로 리다이렉트
            }else {}
        %>
          ```

3. 쿠키 삭제하기 (로그아웃)
    -     ```jsp
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <%
            Cookie[] cookies = request.getCookies(); //요청에서 쿠키를 가져온다.
            if(cookies!=null){      //쿠키가 null이 아니라면? 

                for(int i=0; i<cookies.length; i++) { //쿠키를 반복문으로 돌림
                    if(cookies[i].getName().equals("id")){ //쿠키이름이 id일때
                        cookies[i].setMaxAge(0);    //쿠키의 유효시간을 0으로셋팅
                        response.addCookie(cookies[i]);
                    }
                }
            }
            %>
          ```