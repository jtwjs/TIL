## MetaData(메타데이터) Tag
> head 태그 안에 html에 중요한 메타데이터를 표현하는 태그
### title (문서의 대제목)
>HTML head 태그에 반드시 적어줘야 하는 태그
- ``` <title>대제목</title>```
- **검색 최적화**에 매우 중요
#### title 잘쓰는 방법
1. 키워드 단순 나열 비추
2. 페이지마다 그에 맞게 변경
    - 검색 최적화에 지대한 영향을끼치므로 신경써서 잘작성하기!!
    - 한두단어말고 함축적으로 잘 작성하기
    - 무엇에 관한 내용인지 센스있게 작성
### link (첨부)
> CSS파일 첨부할때 사용
- ```<link> </link> ```
1. CSS 스타일 시트를 첨부
    - link:css (tab) : 자동완성
    - ```<link rel="stylesheet" href="./style.css"> ```
2. 폰트를 사용할때 
    - 웹폰트가 들어있는 CSS 첨부
3. 파비콘

### style (스타일)
> HTML 문서 내에서 CSS 작성할때 사용
- ``` <style>CSS</style> ```
- link 태그로 첨부된 CSS파일을 덮어버리게된다.

### script (JS 파일 첨부)
>HTML 문서 내에 JavaScript 코드를 작성할 때 사용
- script:src (tab) : 자동완성
- ```<script src=""> </script> ```
- body 태그에서 사용
- head 태그에서 안쓰는 이유
    - 렌더하는 과정에서 시간이 오래걸림 (완료될떄까지 다음으로 안넘어감)
    - body 내에서 가장 마지막에 작성하는것이 좋음
### meta (메타태그)
- ``` <meta /> ```
#### 반드시 작성해야할 attribute
- ```name="메타데이터 종류"```
- ```content="메타데이터 값" ```
#### meta 태그에서 가장 중요한 것
- ```<meta name="viewport" content="width=device-width, initial-scale=1.0"> ```
    - content 
        - width=device-width : 화면사이즈는 디바이스 사이즈로 맞춤
        - initial-scale=1.0 : 처음에 보여줄 화면 배율
    - 반응형 웹의 필수 
#### 그외 meta tag
- ``` <meta name="author" content="작성자"> ```
    - 작성자 명시 
- ``` <meta name="keywords" content="키워드" ```
    - 웹페에지에 맞는 키워드를 작성
    - 검색 최적화
- ``` <meta name="description" content="페이지설명" ```
    - 웹페이지에 설명을 적는다.
