### 요청 Header
#### Host
- 서버의 도메인 네임이 나타나는 부분 (Port 포함)
    - Host: www.zerocho.com
- Host 헤더는 반드시 하나가 존재해야 한다.
#### User-Agent
- 현재 사용자가 어떤 클라이언트(운영체제와 브라우저 같은 것)을 이용해서 요청을 보냈는지 나온다.
    - User-Agent: Mozilla/5.0(Macintosh; Intel Mac OS X 10_13_5) AppleWebKit/537.36<br>(KHTML,like Gecko) Chrome/67.0.3396.99 Safari/537.36
- User-Agent 헤더를 활용해서 접속자 통계 등을 내곤한다.
- IE로 접속한 사람들을 찾아낸 후, IE는 지원하지 않으니 크롬으로 접속해주세요 같은 메세지를 표시하기도 함
#### Accept
- Accept 헤더는 요청을 보낼 때 서버에 이런 타입(MIME)의 데이터를 보내줬으면 좋겠다고 명시할 때 사용
    - Accept: text/html : HTML형식인 응답을 처리하겠다라
    - Accept: image/png, image/gif
    - Accept: text/* : *(와일드카드)로 "text이기만 하면된다."
- Accept-Encoding, Accept-Charset, Accept-Language 
    - 공통 header의 Content 시리즈와 대응된다.
    - Accept-Charset: utf-8 (문자 인코딩)
    - Accept-Language: ko, en-US (원하는 언어)
    - Accept-Encoding: br, gzip, deflate (원하는 컨텐츠 압축방식)
- Accept로 원하는 형식을 보내면, 서버가 그에 맞춰 보내주면서 응답 헤더의 Content를 알맞게 설정함
   
#### Authorization
- 인증 토큰(JWT든, Bearer 토큰 등)을 서버로 보낼때 사용하는 헤더
- API 요청같은 것을 할때 토큰이 없으면 거절당하기 떄문에 이때 Authorization을 사용
    - Authorization: Bearer XXXXXXXXXXXXX
- 보통 Basic이나 Bearer 같은 토큰의 종류를 먼저 알리고 그다음 실제 토큰 문자를 적어 보냄

#### Origin
- POST같은 요청을 보낼 때,  요청이 어느 주소에 시작되었는지를 나타냄
- 요청을 보낸 주소와 받는 주소가 다르면 CORS 문제가 발생하기도 함

#### Referer
- ```Referer: https://www.zerocho.com/category/javScript```
- 이 페이지 이전의 페이지 주소가 담겨있다.
- 이 헤더를 사용하면 어떤 페이지에서 지금 페이지로 들어왔는지 알수 있기 때문에 애널리틱스같은 데 많이 사용됨
- Referrer가 표준어인데 실수로 Referer로 만들어졌다고 한다.



