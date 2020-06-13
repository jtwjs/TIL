## REST API (REpresentational State Transfer API)
- REST를 통해 서비스 API를 구현한 것
### REST
- HTTP 기반으로 필요한 자원에 접근하는 방식을 정해놓은 아키텍쳐
    - 자원: 저장된 데이터(DBMS), 이미지/동영상/문서(PDF)와 같은 파일, 서비스(이메일전송,푸쉬메시지)를 모두 포함
#### REST 속성
1. 서버에 있는 모든 resource는 각 resource 당 클라이언트가 바로 접근할 수 있는 고유 URI가 존재
2. 모든 요청은 클라이언트가 요청할 때 마다 필요한 정보를 주기 때문에 서버에서는 세션 정보를 보관할 필요가 없다.
3. HTTP 메소드를 사용함
    - 모든 resource는 일반적으로 http 인터페이스인 GET,POST,PUT,DELETE 4개의 메소드로 접근되어야 함
4. 서비스 내에 하나의 resource가 주변에 연관된 리소스들과 연결되어 표현이 되어야 한다는 점
#### REST의 구성요소
1. 자원(resource)
2. method
3. message
#### Resource
- REST에서는 자원에 접근할 때 URI(Uniform Resource Identifier)로 하게된다.
- URI는 자원의 위치를 나타내는 일종의 식별자
#### URI 설계규칙
- **'/'의 쓰임새**
    - 슬래시 구분자('/')는 계층 관계를 나타내는데 사용
    - 그렇기에 URI 마지막 문자로 슬래시('/')를 포함하지 않는다.
- **URI를 이루는 resource들은 동사보다는 명사로 이루어져야 한다.**
    - 자원의 정보로 표현해야하는 URI는 동사보다는 명사로 구성
- **URI에서는 언더바('_')보다는 하이픈('-')을 권장**
    - 가독성이 중요한데 '_'은 resource 해석에 혼란을 줄수있음
- **URI 경로에는 소문자가 적합**
    - URI 경로에서는 대문자 사용은 피하도록 권장
    - 대소문자에 따라 다른 리소스로 인식하게 됨
    - RFC 3986(URI문법형식)은 URI스키마와 호스트를 제외하고는 대소문자를 구별하도록 규정함
- **파일 확장자는 URI에 포함시키지 않는다.**
    - REST API에서는 메시지 바디 내용의 포맷을 나타내기 위한 파일 확장자를 URI 안에 포함시키지 않는다.
    - Accept header를 사용하도록 함
#### HTTP 메소드
- 자원에 접근할 때 어떤 성격의 요청인지 HTTP 메소드가 알려줌

|METHOD|역할|
|:---|:---|
|POST|POST를 통해 해당 URI를 요청하면 리소스 생성|
|GET|GET을 통해 해당 리소스를 조회. 리소스를 조회하고 해당 도큐먼트에 대한 자세한 정보를 가져옴|
|PUT<br>PATCH|PUT을 통해 해당 리소스를 통째로 수정<br>PATCH를 통해 해당 리소스중 일부를 특정방식으로 변경|
|DELETE|DELETE를 통해 리소스를 삭제|

#### Endpoint
![endpoint](https://user-images.githubusercontent.com/60641307/
83988947-c5a3ab80-a97f-11ea-997c-ed5d2e4670c1.png)

- 같은 URI들에 대해서도 다른 요청을 하게끔 구별해주는 HTTP 메소드 항목

#### 메시지
- **HTTP header와 body, 응답상태코드로 구성**됨
     - header와 body에 포함된 메시지는 메시지를 처리하기 위한 충분한 정보를 포함함
- **Body**
    - 자원에 대한 정보를 전달(데이터 포맷: JSON/XML/사용자정의포맷)
- **Header**
    - HTTP 바디에 어떤 포맷으로 데이터가 담겼는지 정의
    - 요청 HTTP 헤더는 'Accept' 항목으로 응답
    - 응답 HTTP 헤더는 'Content-type'으로 컨텐츠 타입 설명
- **응답상태코드**
    - 응답상태코드를 통해 리소스 요청에 대한 응답을 확인

### 장점
1. 언어와 플랫폼에 독립적
2. SOAP(다른 통신방식)보다 개발이 쉽고 단순
3. REST가 지원하는 프레임워크나 언어등 도구들이 없어도 구현가능
4. 기존 웹 인프라를 사용가능
    - HTTP를 그대로 사용하기 때문
### 단점
1. HTTP프로토콜만 사용가능
2. p2p 통신모델을 가정했기에 둘 이상을 대상으로 하는 분산환경에는 유용하지 않다
3. 보안,정책등에 대한 표준이 없기 떄문에 관리가 어렵고 이러한 경우까지 고려할경우에 설계&구현이 좀더 어려워진다.

### REST가 API로써 쓰이는 방법
- **API:** 웹서비스와 특정 기술을 연결해주는 징검다리 역할
- 웹서비스에서 필요한 부분들을 REST방식 (URI형식으로 request)으로  카카오 데이터 베이스에 요청하는식으로 작동