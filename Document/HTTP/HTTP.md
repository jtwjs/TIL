## HTTP(Hyper Text Transfer Protocol)
- 인터넷에서 데이터를 주고 받을 수 있는 프로토콜
    - 프로토콜 규칙
    - 규칙을 정해두었기에 모든 프로그램이 이 규칙에 맞춰 개발해서 서로 정보교환 할수있게됨
- 암기:  **서버의 역할은 요청에 대한 응답을 보내준다는 것**

### 요청
- 요청을 보낼때는 요청에 대한 정보를 담아 서버로 보낸다.
    - 식당에서 주문서를 작성하는 것과 같다.
    - 서버가 주문서를 받아 클라이언트가 어떤 것을 원하는지 파악 하는 것
- 서버도 응답할 때 응답에 대한 정보를 담아 클라이언트로 보낸다.
    - 이런 정보가 담긴 메시지를 **HTTP 메시지**라고 한다.
    - HTTP 메시지는 시작줄, 헤더, 본문으로 구성됨
-   ```
     GET https://www.zerocho.com HTTP/1.1
     User-Agent:Mozila/5.0 (Window NT 10.0; Win64; x64)..
     Upgrade-Insecure-Request: 1
     
     (본문)
     
    ```
- 첫 줄(시작줄: 메소드 주소 버전으로 구성)
    - GET: HTTP 메소드
    - ```https://www.zerocho.com```: 주소
    - ```HTTP/1.1: HTTP 버전
- 두번째 줄~(헤더: 요청에 대한 정보가 담김)
- 본문(요청을할때 함께 보낼 데이터를 담는 부분)
    - 헤더에서 한줄 띄고 본문이 시작됨
### 응답
- ```
    HTTP/1.1 200 OK
    Connection:keep-alive
    Content-Encoding: gzip
    Content-Length: 356353
    Content-Type: text/html

    <!DOCTYPE html><html lang="ko" data-reactroot=""><head><title..
  ```
- 요청과 마찬가지로 시작줄, 헤더, 본문으로 구성됨
- 첫 줄(버전 상태코드 상태메시지로 구성)
    - HTTP/1.1: HTTP 버전
    - 200: 상태코드
    - OK: 상태메시지
- 두번째 줄~(헤더: 응답에 대한 정보가 담김)
- 본문(요청한 데이터가 담김)
    - HTML 이 담겨 있다.
    - 이 HTML을 받아 브라우저가 화면에 렌더링됨