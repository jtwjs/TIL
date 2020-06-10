## Action Tag(액션태그)
>JSP 페이지에서 자바 코드 등의 스크립트 언어를 사용하지 않고도 (즉, HTML 태그 형태로)<br>다른 페이지의 서블릿이나 자바빈의 객체에 접근할수 있돌독 태그를 이용해 구현된 기능
- 액션 태그를 통해서 개발자는 페이지의 흐름을 제어
- 자바빈의 속성을 읽고 쓰며 애플릿을 사용하는 등의 다양한 기능을 활용 가능
- 사용자에게 보여지는 프레젠테이션 부분과 사용자의 요청을 처리하는 비즈니스 로직부분(프로그램 부분)을 분리하는것이 가능

- **즉, jsp에서 자바코드를 줄이기 위해 만들어진 태그**
    - 가독성 UP!!

### JSP에서 제공하는 액션태그
- 페이지 흐름 제어 액션(forward/include 액션)
- 자바빈 사용 액션(useBean 액션)
- 애플릿 사용 액션(plugin 액션) 

|액션태그|설명|
|:--|:--|
|&#60;jsp:include&#62;|페이지 모듈화 페이지를 태그처럼 사용할 수 있다.|
|&#60;jsp:forward&#62;|다른 페이지로 이동할 때 사용|
|&#60;jsp:param&#62;|다른 페이지에 값을 전달할 때 사용|
|&#60;jsp:useBean&#62;|자바 Bean을 jsp에서 참조|
|&#60;jsp:setProperty&#62;|자바 bean의 property의 저장|
|&#60;jsp:getProperty&#62;|자바 bean의 property값을 얻는다|

### 액션 태그 사용법
- **<;jsp:include&#62;**
    - ```<jsp:include page="main.jsp"/> ```
    - jsp:include 태그속성인 page 속성에 모듈화 시킬 jsp.파일 명이나 jsp파일 경로를 입력
    - 해당 태그가 jsp파일에 있는 내용으로 대채된다.
- **&#60;jsp:forward&#62;**
    - ```<jsp:forward page="/main.do" /> ```
    - page 속성에 이동할 주소를 입력
    - 해당 태그 내용이 처리되면 입력한 주소로 이동
- **&#60;jsp:param&#62;**
    ```jsp
    <jsp:include page="main.jsp">
        <jsp:param name="number" value="10" />
    <jsp:include />

    <jsp:forward page="/main.do" />
        <jsp:param name="number" value="10" />
    <jsp:forward />
    ```
    - jsp:param 태그는 jsp:include 태그와 jsp:forward 태그의 하위 태그로 사용됨
    - jsp:param 태그에서 name 속성은 전달할 키의 이름 vlaue 속성은 키와 함께 전달될 값
    - 해당 페이지와 주소로 키와 값을 전달 