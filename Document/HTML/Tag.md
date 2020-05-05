## MarkUp Tag
- attribute : 태그에 좀 더 부가적인 정보를 주는것
### Heading(제목) 태그
>제목에 해당하는 내용.. 어떤 내용의 핵심 컨텐츠는 헤딩 태그를 써서 마크업!!
- ```<h1>,<h2>,<h3>,<h4>,<h5>,<h6>```
>h1을 주로 쓰고 나머지는 그다지..
### Paragraph(문단) 태그
- ```<p> </p>```
### Emphasis(강조) 태그
>둘다 똑같으니 아무거나 쓰자~
- ```<em> </em> //(emphasis 힘)```
- ```<strong> </strong>```
### Anchor(링크) 태그
- ```<a>  </a>```
- 반드시 명시해야할 속성
    - **href(hypertext reference): 주소값**
    - ``` <a href="주소"> </a> ```
- ```target="_blank" ```
    - 새탭을 열어서 이동
- 사용 용도
1. 웹URL
    - ``` <a href="http://"> </a> ```
2. 페이지 내 이동
    - ``` <a href="#ID_"명> </a> ```
3. 메일쓰기
    - ``` <a href="mailto:메일주소"> </a> ```
4. 전화걸기(모바일)
    - ```<a href="tel:전화번호"> </a>```
### Image(이미지) 태그
- ```<img src="#" alt="" /> ```
- 반드시 명시해야할 속성
    - **src** (**s**ou**rc**e) 
        - 이미지 파일의 상대 경로
        - 이미지의 주소값
    - **alt** (**al**ternative **t**ext 대체 텍스트) 
        - 이미지가 안뜰경우 어떤이미지인지 명시해줄 Text
        - 시각 장애인들을 위한 screen reader(스크린 리더)에서 이미지 대신 읽어줄 Text
### <br/; break> 태그