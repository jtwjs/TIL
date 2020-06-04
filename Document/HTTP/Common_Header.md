## Header 
> 서버의 역할: 클라이언트로부터 요청을 받아서 응답을 보내는 것<br>요청과 응답은 메시지 형식(메세지 = 시작줄, 헤더, 본문으로 구성)
### 공통 Header
- 요청과 응답에 모두 사용되는 헤더 
    - Content 시리즈는 엔티티 헤더라고 불림
#### Date
- HTTP 메시지가 만들어진 시각 (자동생성)
    - Date: Thu, 12 Jul 2018 03:12:27 GMT
#### Connection(X)
- HTTP/2에서는 사라짐
#### Cache-Control(★★★)

#### Content-Length
- 요청과 응답 메시지의 본문 크기를 바이트 단위로 표시
    - Content-Length: 52
- 메시지 크기에 따라 자동생성
#### Content-Type
- Content-Type: text/html; charset=utf-8
    - 현재 메시지 내용이 text/html 타입, 문자열은 utf-8
- 컨텐츠의 타입(MIME)과 문자열 인코딩(UTF-8 등)을 명시할수 있다.
- Accept 헤더, Accept0Charset 헤더와 대응된다.
- 프론트엔드에서 서버로 데이터를 보낼 때는 text/html 이런것 대신 www-url-form-encoded나 multipart/form-data같은 게 Content-Type이 된다.

#### Content-Language
- 사용자의 언어를 뜻함
    - 요청이나 응답이 무슨 언어인지와는 관련 없다.
    - 한국 사람한테 일본어를 가르치는 사이트 같은 경우 ex:)
        - 페이지 언어는 일본어더라도 Content-Languge는 ko-KR일수 있다.
#### Content-Encoding
- Content-Encoding: gzip, deflate
- Content-Encoding은 컨텐츠 압축된 방식
- 응답 컨텐츠를 br,gzip,deflate 등의 알고리즘으로 압축해서 보내면, 브라우저가 알아서 해재헤서 사용함
- 컨텐츠 용량이 줄어들기 때문에 압축을 권장
    - 요청이나 응답 전송속도도 빨라지고, 데이터 소모량도 줄어들기 떄문에 가능하면 압축

