## JSTL (JSP Standard Tag Library; 자바서버 페이지 표준 태그 라이브러리)
> JSTL + EL의 조합
- HTML 코드 내에 java 코드인 스크립틀릿 <%=student %>를 ${student}로,<br><%=if %>문을 &#60;c:if&#62;, &#60;%=for %&#62;문을 &#60;c:forEach&#62;로 대체하여 사용
- 예전에는 스크립트릿을 많이 사용했지만 가독성이 떨어지고, 뷰와 비즈니스로직의 분리로 인해 현재는 JSTL을 많이 사용하는 추세다.

- JSTL은 JSP 페이지 내에서 자바 코드를 바로 사용하지 않고 로직을 내장하는 효율적인 방법을 제공

### JSP 문서에서 JSTL을 사용하기 위한 선언 방법
- JSTL은 라이브러리이기 떄문에 사용하기 전 core를 header에 추가
    ```java
    <%@ taglib uri="http://java.sun.com/sjp/jstl/core" prefix="c"%> 
    ```
- c라는 프리픽스로 시작하는 태그는 위의 URI에서 가져오는 태그라고 설정

#### JSTL core의 태그들
|기능분류|태그명|설명|
|:--|:---|:----|
|변수 지원|&#60;c:set&#62;|변수명에 값을 할당|
|변수 지원|&#60;c:remove&#62;|설정된 속성을 제거|
|흐름 제어|&#60;c:if&#62;|조건식에 해당하는 블럭과 사용될 scope 설정|
|흐름 제어|&#60;c:forEach&#62;|다른 언어의 loop문 items 속성에 배열을 할당할수 있음|
|흐름 제어|&#60;c:choose&#62;|다른 언어 switch와 비슷|
|흐름 제어||&#60;c:when&#62;|switch문의 case에 해당|
|흐름 제어||&#60;c:otherwise&#62;|switch문의 default에 해당|
|흐름 제어|&#60;c:forTokens&#62;|구분자로 분리된 각각의 토큰을 처리할때 사용|
|기타 태그|&#60;c:catch&#62;|예외처리를 위한 태그|
|기타 태그|&#60;c:out&#62;|값을 출력|
|URL 처리|&#60;c:import&#62;|URL을 사용하여 다른 자원의 결과를 삽입|
|URL 처리|&#60;c:redirect&#62;|지정한 경로로 리다이렉트 한다.|
|URL 처리|&#60;c:url&#62;|URL을 재작성한다.|

### 흐름 제어 태그
#### &#60;c:forEach&#62; 태그
- 자바의 for, do-while 형태
- Array, Collection, Map 에 저장되어있는 값들을 순차적으로 처리할 때 사용
- ```jsp
    <c:forEach var="변수" items="아이템" begin="시작값" end="끝값",step="증가값">
        ${변수}
    </c:forEach>
   ```
- item: array, Collection, Map 등
- begin: 초기값, end: 끝값, step: 증가값
    - 단, Iterator, Enumeration, Map의 경우 삽입한 순서와 읽어오는 순서가 일치하지 않을수 있어 사용하지않는다.
- **varstatus:** 루프 정보를 담는 LoopTagStatus 객체를 저장할 변수명을 값으로 갖는다.
    - index: 루프 실행에서 현재 인덱스
    - count: 루프 실행 횟수
    - begin: begin 속성 값
    - end: end 속성 값
    - step: step 속성 값
    - first: 현재 실행이 첫번쨰 실행인 경우 true
    - last: 현재 실행이 루프의 마지막 실행인 경우 true
    - current: 컬렉션 중 현재 루프에서 사용할 객체

### URL 처리 태그
#### &#60;c:import&#62; 태그
- 좀더 일반적이고 강력한 기능을 가진 &#60;jsp:include&#62;로서<br>이것이 컴파일되고 동작하는 방식 또한 &#60;jsp:include&#62;와 같다.
- 특정 URL의 결과를 읽어와 현재 위치에 삽입하거나 EL변수에 저장할때 사용
- 외부서버에 있는 url 형식의 페이지까지 포함 가능하다
    - 외부 웹사이트나 웹 애플리케이션 콘텐프를 가져올수 있다.
- ```<c:import url="URL" var="변수명" scope="영역" charEncoding="캐릭터셋"><c:import> ```
- var 속성을 명시하면 해당 URL에서 읽어온 데이터를 scope에 지정된 영역의 var 속성에 명시한 EL변수에 저장한다.
    - **var 속성을 지정하지 않으면 태그의 위치에 URL로부터 읽어온 데이터 결과를 출력**
- url 속성은 절대URL(완전한 URL) 또는 상대 URL(웹 어플리케이션 내에서의 절대 경로 또는 현재 JSP에 대한 상대경로)을 입력할 수 있다.
    - 절대 URL
        - java.net.URL 그리고 java.net.URLConnection을 이용해서 데이터를 읽어온다.
        - charsEncoding 속성 값을 지정했다면 명시된 캐릭터 인코딩 이용
    - 상대 URL
        - &#60;jsp:include&#62; 액션 태그와 동일한 방식으로 동작
        - &#60;jsp:include&#62; 액션 태그와는 달리 웹 어플리케이션에 속한 자원의 결과를 변수에 보관한 뒤 필요에 따라 처리 가능
- 요청 파라미터는 URL에 직접 입력 또는 &#60;c:param&#62;태그를 이용하는 방식이 있다.


### EL(Expression Language)
>EL은 자바스크립트에서 확장된 Xpath에서 힌트를 얻어 만들어진 언어로 값이 없는 변수(null)에 대해 좀더 관대하고 데이터 형 변환을 자동으로 해준다.<br> EL을 사용하면 값이 없거나 형 변환 등에 전혀 신경 쓸 필요 없이 서버로 전송해서 형변환 없이 사용할 수 있다.

- 표현 언어를 의미
- jsp 스크립트를 대신하여 속성 값들을 좀더 편리하게 출력하기 위해 제공되는 언어

- ``` <%=name %> -> ${name} ```

### EL 내장 객체
|객체명|설명|
|:---|:---|
|${pageScope}|page Scope에 접근하기 위한 객체|
|${requestScope}|request Scope에 접근하기 위한 객체|
|${sessionScope}|session Scope에 접근하기 위한 객체|
|${applicationScope}|application Scope에 접근하기 위한 객체|
|${param}|파라미터 값을 가져오기 위한 객체|
|${header}|헤더 값을 가져오기 위한 객체|
|${cookie}|쿠키 값을 가져오기 위한 객체|
|${initParam}|JSP 초기 파라미터를 가져오기 위한 객체|
|${pageContext}|pageContext 객체에 접근하기 위한 객체|

### EL 연산자
|연산자|설명|
|:--|:--|
|.|빈 또는 앱에 접근하기 위한 연산자|
|

### 알아두면 좋은 JSTL 표현들
- javascript에서 model parameter 가져오는 방법
    - ``` var key = '<c:out value='${key}' />```

- javascript에서 context path를 가져오는 방법
    - ```var G_CONTEXT_PATH = "${pageContext.request.contextPath}"; ```
- jsp에서 url의 get parameter 가져오는 방법
    - 
    ```
        <c:if test="${param.loginFail eq 'true'}">
        <div class="login-fail">아이디 혹은 비번이 일치하지 않는다.</div>
        </c:if>
    ```

- jsp에서 현재 년도 구하기
    - ```
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <jsp:useBean id="now" class="java.util.Date" />
    <fmt:formatDate var="year" value="${now}" pattern="yyyy" />
    <p>Current year: ${year}</p>
    <p>Previous year: ${year - 1}</p>
    ```
--- 
