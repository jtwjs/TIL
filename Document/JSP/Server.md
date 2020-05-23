## Server

### Web Server
- 웹 서비스는 HTTP 프로토콜을 이용하여 클라이언트와 서버의 통신을 의미한다. 
- 클라이언트가 서버에 요청을하면 서버는 응답을 한다.
- 웹 서버는 HTTP request를 받고 HTML, CSS, JavaScript, Image 등의 정적인 정보를 반환하는 역할을 한다.
- 대표적인 웹서버는 IIS, **Apache**, Nginx, gWS 등이 있다.
#### Forward Proxy
>클라이언트가 특정 웹서비스에 직접 요청하고 응답을 받는것이 아니라, 프록시 서버가 대신 요청하고 응답을 클라이언트에게 전달(Forward)을 해준다.
- 포워프 프록시는 캐쉬기능이 있기 때문에 자주 사용하는 컨텐츠에 대해서는 빠르게 응답 가능
- 내부 연결사이트를 제한하는 기업환경 또는 군대에서 많이 사용
#### Reverse Proxy
>HTTP 요청을 특정 네트워크 또는 서버로 전달하는 역할을 수행하는 서버
- 외부로 오픈되지 않은 내부서버에 접근할수있도록 요청과 응답을 전달하는 역할
- 보안을 위해 내부 네트워크를 분리한 경우 사용

![프록시](https://user-images.githubusercontent.com/60641307/82314836-5a605c80-9a05-11ea-9581-49e0c35b3439.gif)

### WAS (Web Application Server)
- WAS와 앱서버는 동의어 
- 앱서버는 웹서버와 앱 사이의 동적인 정보를 생성하는 역할을 담당하는 **미들웨어**
- 웹서버는 앱을 알지 못하고, 반대로 앱은 웹서버에 대하여 알지 못한다.
    - 따라서 앱서버가 가운데에서 중간다리 역할을 한다고 생각하면됨
- **Tomcat**, uwsgi, WebLogic, Jboss등이 해당

### Server App
- 앱은 DB를 질의하고 데이터를 가공하여 제공하는 역할을 담당
- Django, Flask, PHP, JSP, ASP등이 해당
- 비즈니스로직이 앱에서 구현됨

![클라-웹서버-was 구조](https://user-images.githubusercontent.com/60641307/82315151-dd81b280-9a05-11ea-9665-2e5a7671212f.png)
