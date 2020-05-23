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
|태그명|설명|
|:---|:----|
|&#60;c:set&#62;|변수명에 값을 할당|
|&#60;c:out&#62;|값을 출력|
|&#60;c:if&#62;|조건식에 해당하는 블럭과 사용될 scope 설정|
|&#60;c:remove&#62;|설정된 속성을 제거|
|&#60;c:catch&#62;|예외처리를 위한 태그|
|&#60;c:choose&#62;|다른 언어 switch와 비슷|
|&#60;c:when&#62;|switch문의 case에 해당|
|&#60;c:otherwise&#62;|switch문의 default에 해당|
|&#60;c:forEach&#62;|다른 언어의 loop문 items 속성에 배열을 할당할수 있음|

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

 