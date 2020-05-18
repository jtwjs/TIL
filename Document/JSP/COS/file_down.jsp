<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<%@ page import="java.io.*" %>
<%
	String fileName = request.getParameter("file_name");

	String savePath = "upload";
	ServletContext context = getServletContext();
	String sDownloadPath = context.getRealPath(savePath);
	String sFilePath = sDownloadPath + "\\" + fileName;
	
	byte b[] = new byte[4096];
	File oFile = new File(sFilePath);
	
	FileInputStream in = new FileInputStream(sFilePath);
	
	String sMimeType = getServletContext().getMimeType(sFilePath);
	System.out.println("sMimeType>>>"+sMimeType);
	
	//octet-stream은 8비트로 된 일련의 데이터를 뜻함, 지정되지않은 파일 형식을 의미
	if(sMimeType == null)sMimeType = "application/octet-stream";
	response.setContentType(sMimeType);
	
	//한글 업로드(이 부분이 핞글 파일명이 깨지는 것을 방지)
	String sEncoding = new String(fileName.getBytes("utf-8"),"8859_1");
	//이 부분이 모든 파일 링크를 클릭했을때 당누로드 화면이 출력되게 처리하는 부분
	response.setHeader("Content-Disposition","attachment;filename="+sEncoding);
	
	// 서버에 발생하는 예외문제 해결 : response.getOutputStream()로 인해발생
	out.clear(); //jsp에서 servlet으로 변환할때 내부적으로 out 객체가 생성되기 때문에 기존 out객체 초기화함
	out = pageContext.pushBody(); //초기화후 이 문장까지 수행할 것
	
	ServletOutputStream out2 = response.getOutputStream();
	int numRead;
	
	//바이트 배열 b의 0번부터 numRead번까지 브라우저로 출력
	while((numRead = in.read(b,0,b.length))!= -1){
		out2.write(b,0,numRead);
	}
	


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>