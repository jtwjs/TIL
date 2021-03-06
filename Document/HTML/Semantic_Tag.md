## 시맨틱(Semantic) 태그
>시맨틱(Semantic)은 "의미의, 의미론적인"이라는 뜻<br>즉, HTML5에 도입된 시맨틱 태그는 개발자와 브라우저에게 의미있는 태그를 제공
- **시맨틱 웹**
    - 특정 태그에 의미를 부여한 웹
    - 프로그램이 코드를 읽고 의미를 인식할 수 있는 지능형 웹

- **시맨틱 태그**

    ![시맨틱태그](https://user-images.githubusercontent.com/60641307/81243726-9d0c5700-904b-11ea-9849-4daaddf829cb.png)

- ```<header>```(헤더)
    - 문서나 섹션의 머릿글을 지정
    - 사이트 맨 위쪽이나 왼쪽에 사용하며 헤더 안에 ```<form>``` 태그를 이용, <br>검색창을 넣거나 ```<nav>```태그를 이용해 사이트 메뉴를 넣는다.
- ```<nav>```(네비게이션)
    - HTML5에서 새롭게 생긴 시맨틱 태그
    - 콘텐츠를 담고 있는 문서를 사이트간에 서로 연결하는 링크의 역할을 담당
    - ```<nav>```는 주로 메뉴에 사용되고 위치에 영향을 받지 않아 어디에서든 사용 가능
- ```<section>```(섹션)
    - ```<body>```영역은 콘텐츠를 ```<header>,<section>,<footer>```의 3가지 공간에 콘텐츠를 저장
    - 그 중 ```<section>```은 본문 컨텐츠를 담는다.
    - ```<section>```안에 ```<section>```을 넣는 것도 가능
- ```<article>```(아티클)
    - ```<section>```이 콘텐츠를 분류한다면 이 ```<article>```태그안에는 실질적인 내용을 넣는다.
- ```<aside>```(사이드바)
    - 본문 이외의 내용을 담고 있는 시맨틱 태그
    - 주로 본문옆에 광고를 달거나 링크들을 이공 간에 넣어 표현
- ```<foter>```(푸터)
    - 화면의 구조 중 제일 아래에 위치
    - ex:) 회사소개/저작권/약관/제작정보 등이 등러감
    - 연락처는 ```<address>```태그를 사용해서 표기

