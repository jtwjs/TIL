## out 기본객체
>JSP 페이지에 작성된 내용을 최종적으로 출력 결과를 생성하여 클라이언트(브라우저)측으로 전송(출력)하게 되는데, 이때 출력은 out 객체를 통해 함
- 표현식으로 작성한 출력문과 JSP페이지에서 보이는 단순HTML 태그 및 텍스트들도 <br>서블릿으로 변환되는 시점에서 out 객체의 출력메소드를 통해 출력되는 형태로 변환됨

    ```jsp
    out.println("<html>");
    out.println("<head>");
    ....
    out.println("</html>");
    ```
### out 기본 객체를 직접 사용하는 경우
- out 객체는 기본 객체이므로 특별히 선언하지 않고 JSP내부에서 사용가능

- ex:)
    ```jsp
    <% for(int cnt=1; cnt<=10; cnt++){
            if(cnt % 2 ==0){
    %>
        짝수 = <%= cnt %> <br/>
    <%  }else{ %>
        홀수 = <%= cnt %> <br/>
    <%  }
            
        }
    %>
    ```
- ->
    ```jsp
    <%
    for(int cnt=1; cnt <=10; cnt++){
        if(cnt %2 ==0){
            out.println("짝수 = "+cnt+"<br>");
        }else{
            out.println("홀수 = "+cnt+"<br>");
        }
    }
    %>
    
    ```