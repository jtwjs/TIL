## Application
>웹어플리케이션이 실행되는 서버의 설정 정보 및 자원에 대한 정보를 얻어내거나<br> 어플리케이션이 실행되고 있는동안 발생할수 있는 이벤트 로그 정보와 관련된 기능들을 제공

- 웹 어플리케이션의 설정 정보를 갖는 context와 관련이 있는 객체로, 웹 어플리케이션과 연관이있다.
- JSP 기본객체로 JSP 페이지에서 따로 선언하지않아도 사용가능
 
#### application 객체
- 각 웹 애플리케이션 당 오직 하나만의 객체만이 생성
- 웹 애플리케이션 전체 영역에서 자원을 공유해야 할때 주로 사용<br> ( 방문자 수 등의 통계를 다룰 때 사용)
### application 내장 객체의 메소드
|메소드|리턴타입|설명|
|:--|:---:||:--|
|getServerInfo()|String|웹 컨테이너의 이름과 버전을 리턴|
|getMimeType(fileName)|String|지정한 파일의 MIME타입을 리턴|
|RealPath(path)|String|지정한 경로를 웹 어플리케이션 시스템 상의 경로로 변경하여 리턴|
|log(message)|void|로그파일에 message를 기록한다.|
|getMajorVersion()|int|Servlet API 스펙의 Major 버전을 int로 리턴|
|getMinorVersion()|int|Servlet API 스펙의 Minor 버전을 int로 리턴|
|getResource(String file)|java.net.URL|path로 지정된 경로의 자원을 URL 객체로 리턴<br>자원이 존재하지 않으면 null리턴|
|getResourceAsStream(String path)|InputStream|path로 지정된 경로의 자원을 inputStream 객체로 리턴<br>자원이 존재하지 않으면 null 리턴|
