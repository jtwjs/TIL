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
- **Syntax Alert 문법주의**
    - href 속성 반드시 작성
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
- **Syntax Alert 문법주의**
    - src, alt 속성을 반드시 작성
    - **src** (**s**ou**rc**e) 
        - 이미지 파일의 상대 경로
        - 이미지의 주소값
    - **alt** (**al**ternative **t**ext 대체 텍스트) 
        - 이미지가 안뜰경우 어떤이미지인지 명시해줄 Text
        - 시각 장애인들을 위한 screen reader(스크린 리더)에서 이미지 대신 읽어줄 Text
### List(목록) 태그
- **ul**(**u**noredered **l**ist)
    - ```<ul> </ul>```
- **ol**(**o**rderd **l**ist)
    - ```<ol> </ol>```
- **li**(**l**ist **i**tem)
    - ```<li> </li>```
- **Syntax Alert 문법주의**
    - ul과 ol의 자식요소는 무조건 **li만 가능**
### Description List(정의 목록)

- **dl**(**d**escription **l**ist)
    - ```<dl> </dl> ```
    - 정의 목록 리스트를 만들겠다 선언
- **dt**(**d**escription **t**erm)
    - ```<dt> </dt> ```
    - key(용어)값에 해당
- **dd**(**d**escription **d**ata)
    - ```<dd> </dd> ```
    - key(용어)값에 대한 설명
- **dfn**(**d**e**f**i**n**ition) 
    - ```<dfn> </dfn> ```
    - key(용어)의 정의를 나타낼때 사용 
- **Syntax Alert 문법주의**
    - dl 태그에는 반드시 dt, dd 태그가 함께 따라와야한다.
    - dl의 직계 자식 태그로 쓸수있는 태그 (div, dt, dd)
    - dt와 dd는 단독적으로 dl태그 없이 사용할수 없다.
- 사용 용도
1. 용어를 **정의**할때 
2. **key-value**로 정보를 제공할 때
    - ```{key:value} ```
### Quotations(인용) 태그
- blockquote (문단이나 내용전체가 인용문일때 사용)
    - ```<blockquote> 인용내용 </blcokquote> ```
    - cite (attribute)
        - ``` <blockquote cite="https://..."> ```
        - 출처의 URL을 적음
- q(quote 문장내의 살짝 들어간 인용문)
    - ```<q> </q> ```
    - 따옴표("") 생성효과 발생
- cite (인용문의 출처가 Text로 되어있을때 사용)
    - ```<cite> </cite> ```
### div, span 태그
> 아무런 의미가 없는 태그
- CSS스타일링 할때 요소를 묶을때 유용함
- div(division; 다양하게 아무때나 사용가능)
    -```<div> </div>```
- span(Text level)
    - ```<span> </span> ```
    - Text의 일부분을 그룹핑하고싶을때 사용

### <br/; line break> 태그