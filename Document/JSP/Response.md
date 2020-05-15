## Response (서버 응답 객체)
> response 객체는 JSP페이지의 실행결과를 웹 브라우저로 되돌려 줄떄 사용되는 객체이다.
- 서버에서 클라이언트의 요청에 대한 HTTP 응답을 response 객체를 통하여 처리한다.
- 응답의 정보를 가지고 있는 객체
- 서버측에서 클라이언트측으로 데이터를 전달하기 위한 객체

### JSP response() 메소드
> response 객체는 응답 정보에 헤더라는 정보를 넣어서 웹 브라우저에 응답하게 된다.
- 아래 메소드들은 헤더 설정을 할 수 있는 메소드들이지만 직접 헤더 설정을 하는 경우는 별로없다.

    |메소드명|설명|
    |:---|:---|
    |addHeader(String name,String value)|name 헤더에 value 값을 추가한다.|
    |addIntHeader(String name, int value)|name 헤더에 정수 값을 추가한다.|
    |setIntHeader(String,name,int value)|name 헤더의 값을 value로 지정한다.|

- response 객체에서 가장 많이 쓰는 **sendRedireect** 메소드<br> 웹 서버가 웹 브라우저에게 다른 페이지로 이동하라는 응답정보를 보낸다.
    
    |메소드명|리턴타입|설명
    |:---|:---|:---|
    |sendRedirect(String url)|String|메소드를 호출한 jsp 페이지에서 해당 url을 가진 페이지로 이동|


