## Typography (타이포그래피)
>[활자 서체의 배열] Text를 예쁘게 디자인 ㅎㅎ

### font-size
>글씨의 크기 
- 폰트사이즈의 **기본값** 
    - 12pt
    - 16px
    - 1em
    - 100% 

```CSS
font-size: px | em | rem;
```
- **절대 단위** : 출력장치(모니터)의 물리적 속성을 아는 경우 효율적
    - **pt (point)**
        - 일반 문서(워드 등)에서 많이 사용하는 단위
- **상대 단위** : 기종간, 플랫폼 간의 호환성을 유지하는데 유리
    - **px (PiXel)**  
        - 표시장치(모니터)에 따라서 상대적인 크기를 가짐
    - **% (percent)**
        - 브라우저 기본글꼴의 크기를 100% 하고 상대적 크기를 나타냄
    - **em (Equal to capital M)**
        - 해당 폰트의 대문자 M의 너비를 기준으로 함
    - **rem (Root EM)**
        - root = html 
        - html에 적용된 폰트 사이즈 = 1rem

### line-height
>줄 간격
- 사용하는 font-size : px | **em** | rem
- font-size : **em** 을 많이 사용
- **em 생략하는것이 관례**

    ```CSS
    font-size:20px;
    line-height:1.5; /* 30px */
    ```
### letter-spacing
>글자의 간격(자간)
- 사용하는 font-size : px | **em** 
- em 생략 불가능

    ```CSS
    letter-spacing:-0.05em;
    ```
### font-family
>글자의 서체


```CSS
/*Poppins 폰트를 적용해라*/
font-family: "Poppins";

/*PoPins 폰트를 적용해라 그것이 없으면 아무런 sans-serif 서체중 아무거나 적용*/
font-family: "Poppins", sans-serif;

/* Poppins 폰트 적용 그것이 없으면 Roboto폰트 적용 그것이 없으면 sane-serife 서체 적용*/
font-family: "Poppins", "Roboto", sans-serif;
```
- **serif** 
    - = 명조체 (삐침이 있는 체)
- **sans-serif** 
    - = 돋음,고딕 (삐침이 없고 굵기가 일정)
### font-weight
>폰트의 굵기


|폰트의 굵기|굵기 정도|
|:----:|:------|
|100|Thin|
|300|Light|
|**400**|**Regular**|
|500|Medium|
|**700**|**Bold**|
|900|Black|

### color
> 폰트의 색상
- **color를 작성할떄 사용하는 방식**
    - hex 
        - 16진수 HEXA 코드 값 
        - #RR(red)GG(green)BB(blue)로 두자리 씩 정수로 구성
        - 16진수 값인 00 ~ FF 사이에 값을 지정
        - ex:) #FF0000; // 빨간색
    - rgb
        - RGB생상 값은 대부분의 브라우저에서 지원
        - 함수 형태로 되어있으며 인수로 red,green,blue 값을 넘김
        - 10진수로 0 ~ 255 사이 값을 지정
        - 인수를 숫자 뿐만아니라 %값도 넘길수 있음
        - ex:) rgb(100%,0,0); // 빨간색
    - rgba
        - RGB에 alpha 채널을 하나 더 추가한 것
        - 알파 값은 색의 투명도,즉 배경색과 혼합되는 정도를 의미
        - 0(완전투명) ~ 1(불투명) 사이의 값을 가짐
        - rgba(0,102,255,1)
---
### text-align (글자 정렬)
>글자 정렬 
- ```text-align : left | center | right ```

### text-indent (글자 들여쓰기)
>글자 들여쓰기
- ``` text-indent : px ```

### text-transform (텍스트 변형)
- none
    - 기본상태
- capitalize
    - 앞 알파벳은 대문자가됨
- uppercase
    - 모든 문자가 대문자
- lowercase
    - 모든 문자가 소문자

### text-decoration (텍스트 꾸미기)
- none
    - 텍스트 기본값
- underline
    - 밑줄 생성
- line-through
    - 취소선 생성
- overline
    - 텍스트 위에 줄 생성
### font-style
> 문자에 기울기를 주고싶을 때!
- normal
    - 기본값
- italic
    - 문자 기울임
- oblique
    - 문자 기울임2
---
### Webfont
- **웹폰트를 쓰는방법**
- 갖다 쓴다
    - [무료 웹폰트 사이트](fonts.google.com)
    1. [HTML] head 태그에 'Embed font' link 태그 추가하기
        - EX:)
         ``` HTML
        <link href="https://fonts.googleapis.com/css?family=Libre+Baskerville&display=swap" rel="stylesheet"> 
        ```
    2. [CSS] 원하는 태그에 font-family로 아래와 같이 추가 <br> Body 태그에 추가하면 전체에 적용됨 
        - EX:)
        ```CSS      
        font-family: 'Libre Baskerville', serif;
        ```

- 직접 제공한다
    1. 원하는 Font를 다운 받는다.
    2. Project 파일에 'assets'폴더 추가 
    3. Font 디렉토리 생성 후 폰트 파일들을 붙여놓기
    4. CSS 작성(fonts.css 파일 만들기)
    ```CSS
    @font-face{
        font-family: '폰트명'; /*폰트명을 원하는 이름으로 짓는다.*/
        font-style: normal | italic /*폰트파일에 맞는 스타일로*/
        font-weight: /*폰트 굵기 설정 300:PLAIN, 700:BOLD */
        src: url('webfont.eot'); /* IE9 Compat Modes */
        src: url('webfont.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
             url('webfont.woff2') format('woff2'), /* Super Modern Browsers */
             url('webfont.woff') format('woff'), /* Pretty Modern Browsers */
             url('webfont.ttf')  format('truetype'), /* Safari, Android, iOS */
             url('webfont.svg#svgFontName') format('svg'); /* Legacy iOS */
            /*url(웹폰트_경로.확장자) */
             /*내가 갖고있는 폰트의 해당하는 부분만 수정해서 쓰자*/
    } 
    ```
    5. fonts.css파일 연동시키기
        - [HTML] head 태그에 link 태그 추가하는방법
        ```HTML
        <link rel="stylesheet" href="./fonts.css"> //fonts.css파일에 상대적인 경로 적기
        ```
        - [CSS] 직접 CSS파일에 추가하는 방법
        ```CSS
        @import url("./fonts.css");/*fonts.css파일에 상대적인 경로*/
        ```
    6. 원하는 태그에 font-family로 아래와 같이 추가 <br> Body 태그에 추가하면 전체에 적용됨 
        - EX:)
        ```CSS      
        font-family: '지정한 웹폰트명', serif;
        ```
---
- Tip
    1. line-height를 사용했을 때에는 글자는 그  줄간격에 가장 가운데에 배치된다.
        - 수직으로 무언가 정렬할 때 line-height를 자주사용한다.
    2. lorem[글자수] (HTML)
        - 글자수 만큼 더미 텍스트를 생성해준다.
    3. 웹페이지가 로드될 때 이왕이면 폰트와 관련된것들은 더 빨리 로딩되면 좋으니 제일먼저 적어주자(센스있게..)
        - EX:)
        ```CSS
        /* css 파일 링크 태그 위에 적어주자*/
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="./fonts.css">
        ```
    4. libray 만들때 tip 
        - 항상 이름을 일관적으로 정해주자
        - ex:) font와 관련된 라이브러리 작성 
         ```CSS
         /*Font Size*/
         .fs-large
         .fs-medium
         /*Font Weight*/
         .fw-medium
         .fw-bold
         /*Font Colors*/
         .text-dark
         .text-info
         .text-error
         ```

    5. line-height 작성은 px보단 em형식으로~!! (단 em표기는 생략)
        ```CSS
         /*ex:) font-size : 12px, line-height: 16px일 때 16을 12로 나눈 값을 적용*/
         font-size: 12px;
         line-height: 1.3333; /*16px*/
        ```
    6. emmet을 배워서 써먹자