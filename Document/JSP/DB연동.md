### 이클립스 프로젝트의 WebContent\WEB-INF\lib 폴더에 복사하는 방법
1. 새 프로젝트를 만든다. 프로젝트는 **Dynamic Web Project**로 만듦
2. next->next 를 누른후 **web.xml**을 자동으로 만들어 주는 설정에 Check 후 finish
    - **web.xml** : 웹 매핑 및 오라클 db 정보를 불러오는 context.xml을 불러와주는 용도
3. web.xml을 생성하면 WEB-INF 안에 저절로 생성됨<br>**ojdbc6.jar** 문서를 lib 폴더 안에 복사해서 넣어준다.
4. **연결할 db 경로를 지정**해준다.
    - window - show view - Data Source Exploer 에 가서 경로를 확인 가능<br>Data Source Exploer 가 안나타나면 other..에서 직접 검색후 사용
5. Data Source Exploer 에선 Database의 경로와 데이터 정보들을 확인 가능
    - Data Source Exploer 창을 킨 후 Database Connections에 우클릭 후 new 클릭
6. 쓰고있는 DB를 골라준 후 next -><br> 내가 사용하는 db경로를 더상세히 설정해주어야함 (노란색 동그라미 아이콘 클릭) -><br> Db Dirver 버전 선택
7. 다음 어떤 jar문서를 사용할 것인지 설정  
    - 먼저 지정된 ojdbc14.jar을 remove 
    - ojdbc6.jar를 추가 (lib 폴더 안에 복사한 ojdbc6.jar 파일클릭 후 경로설정)
8. Properties 탭에서 db의 어떤 사용자에 접근할 것인지 설정
    - DB url, sid, id, pw, 접속계정이름을 기입
    - DB url은 SQLDeveloper에서 계정추가를 눌러 확인가능
9. Data Source Explorer 창에 내가 설정한 DB경로가 뜨는걸 확인
10. 연동이 되었다면 실제 기능이 작동하는지 확인해봐야함
    - web.xml에 들어가 내가 어떤 db를 참조할 것인지 설정해줘야함
    - 아래처럼 코드 작성

    ![99C1E13A5AE73E181C](https://user-images.githubusercontent.com/60641307/80171235-c1683c80-8624-11ea-8a48-203f69a61590.png)

11. 실제 db가 잘 작동하는지 jsp 파일을 만들어 아래코드 기입
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%
    //내 db 접속에 사용할 conn 변수
    Connection conn = null;
    //오라클 드라이버 경로 설정
    String driver = "oracle.jdbc.driver.OracleDriver";
    //내 db의 계정 경로 설정
    String url = "jdbc:oracle:thin:@localhost:1521:TestDB";
    //접속 성공,실패 여부 사용시 쓰는 변수
    Boolean connect = false;
    
    //db 접속 코드는 반드시 try~catch문 안에 써줘야함
    try {
        //오라클 드라이버 접속
        Class.forName(driver);
        //내 db 접속
        conn = DriverManager.getConnection(url, "jerry", "1111");
        //접속성공시 true 설정
        connect = true;
        //접속 끊기, 끊는 이유 : 항상 db가 연결되어 있으면 접속 오류 및 데이터 충돌이 일어나기 때문 
        conn.close();
    } catch (Exception e) {
        //접속 실패시 false 잡고 예외처리해줌
        connect = false;
        e.printStackTrace();
    }
%>
<%
if(connect==true){%>
    연결되었습니다.
<%}else{ %>
    연결에 실패하였습니다.
<%}%>
```
12. 톰캣 서버를 Start 시킨후 jsp 파일을 실행 (연결성공 텍스트가 뜨면 db와 연동 성공!)

