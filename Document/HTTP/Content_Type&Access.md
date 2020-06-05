## Content-Type Header, Access Header 
#### Content-Type
- **HTTP 메시지 (요청과 응답 모두)에 담겨 보내는 데이터의 형식을 알려주는 헤더**
- HTTP 표준 스펙을 따르는 브라우저와 웹서버는 Content-Type 헤더를 기준으로 HTTP 메시지에 담긴 데이터를 분석과 파싱을 한다.
- Content-Type헤더가 없다면 데이터를 전송하는 쪽(브라우저나 웹서버)에서는 <br> 특정한 형식의 데이터일지라도 데이터를 받는 입장에서 단순히 텍스트 데이터로 받아들인다.
- 중요한점은 HTTP 요청의 경우 GET방식인 경우에는 무조건 URL 끝에 쿼리스트링으로 <br>value=text 형식으로 보내지기 떄문에 Content-Type은 필요가 없다.
    - 즉 GET방식으로 데이터를 전송 시 웹서버 입장에서는 value=text 형식 데이터라는 걸 알 수 있다.
- **Content-Type은 POST나 PUT처럼 메시지 BODY에 데이터를 보낼때 필요**로 한다.
    - **AJAX**를 통해 **JSON 형식의 데이터를 전송하는 경우** **COntent-Type 값을 application/json** 으로 지정하여 보낸다.
    - &#60;form&#62;태그를 통해 첨부파일 등을 전송하는 경우라면 브라우저가 자동으로 <br>Content-Type을 multipart/form-data로 설정하여 요청메시지를 보낸다.

#### Accept 헤더
- Accept 헤더의 경우 브라우저(클라이언트) 에서 웹서버로 요청시 **요청메시지에 담기는 헤더**이다.
- Accept헤더는 쉽게 말해 **자신에게 이러한 데이터 타입만 허용하겠다는 뜻**
    - 즉 브라우저가 요청 메시지의 Accept 헤더값을 application/json이라고 설정했다면 클라이언트는 웹서버에게<br> json 데이터만 처리할 수 있으니 json 데이터 형식으로 응답을 돌려줘라고 말하는것과 같다.
#### 차이점
- Content-Type 헤더와 Accept 헤더 둘 다 데이터 타입(MIME)을 다루는 헤더이다.
- **Contetnt-Type 헤더**
    - **현재 전송하는 데이터가 어떤 타입인지에 대한 설명을 하는 개념**
- **Accept 헤더**
    - **클라이언트가 서버에게 어떤 특정한 데이터 타입을 보낼 때 클라이언트가 보낸 특정 데이터 타입으로만 응답을 해야한다.**