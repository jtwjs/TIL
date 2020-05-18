## COS 라이브러리
> 현 자바에서 가장 널리 쓰여지는 업로드 컴포넌트
- [다운로드 링크](http://www.servlets.com)
- 압축파일을 풀고 lib 폴더에 cos.jar 파일을 WebContent/WEB-INF/lib 파일에 넣어주기 
### MultipartRequest
- COS 라이브러리에서 가장 핵심적인 역할을 하는 클래스
- 파일 업로드를 직접적으로 담당

    ```java
    MultipartRequest(javax.servlet.http.HttpServletRequest request,
    java.lang.String.saveDirectory,
    int maxPostSize,
    java.alng.String encoding,
    FileRenamePolicy policy)
    ```
- 첫번째 인자는 Request 객체
- 두번째 인자는 업로드된 파일이 저장될 파일폴더 경로
- 세번째 인자는 업로드할 파일의 최대 크기
- 네번째 인자는 인코딩 타입
- 다섯번째 인자는 업로드 될 파일명이 기존에 업로드된 파일명과 같은 경우 덮어쓰기 방지로 설정

- 이 객체가 생성되면서 폼에서 지정한 파일이 서버상의 폴더에 저장된다.
- 파일 업로드를 위한 파일 선택을 위해서 ```<input type="file">```를 사용
- 파일 전송을 위해서 ```<form method="post" enctype="multipart/form-data">``` 로 속성을 지정 
#### MultipartRequest의 생성자
```jsp
MultipartRequest(javax.servlet.http.HttpServletRequest request,
java.lnag.String saveDirectory,
int maxPostSize,
java.lang.String encoding,
FileRenamePolicy policy)
```

|인자|설명|
|:---|:---|
|request|MultipartRequest와 연결될 request 객체를 의미|
|saveDirectory|서버 측에 파일이 실질적으로 저장될 경로를 의미|
|maxPostSize|한번에 업로드 할 수 있는 최대 파일 크기를 의미|
|encoding|파일의 인코딩 방식을 의미|
|policy|파일 이름 중복처리를 위한 인자를 의미|


### MultipartRequest의 메소드
|메소드|설명|
|:---|:----|
|getParameterNames()|폼에서 전송된 파라미터의 타입이 file이 아닌 이름들은 Enumeration 타입으로 리턴|
|getParameterValues()|폼에서 전송된 파라미터 값들을 배열로 받아옴|
|getParamter()|Request 객체에 있는 해당 파라미터의 값을 가져옴|
|getFileNames()|파일을 여러개 업로드 할 경우 타입이 file인 파라미터 이름들을 Enumeration 타입으로 리턴|
|getFilesystemname()|서버에 실제로 업로드 된 파일의 이름을 의미|
|getOriginalFileName()|클라이언트가 업로드 한 파일의 원본 이름을 의미|
|getContentType()|업로드 된 파일의 컨텐트 타입을 얻을때 사용|
|getFile()|서버에 업로드된 파일 객체 자체를 반환하는 메소드|
