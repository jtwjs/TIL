# CSS 스타일시트와 CSS규칙
## 1.스타일시트 
>스타일시트가 HTML 문서에 추가되면 CSSStylesheet 개체로 표현되며,<br> 스타일시트 내부의 각CSS규칙은 CSSStyleRule 개체로 표현된다. 
- HTMLLinkElement : 외부 스타일시트 
    ex:) link href="stylesheet.css" rel="stylesheet" type="text/css"
- HTMLStyleElement : 인라인 스타일시트 정의
    ex:) style /style태그
>스타일시트를 포함하고 있는 element를 선택(ex:link,style)하는 것은 스타일시트 자체를<br> 표현하는 실제 개체(CSSStylesheet)에 접근하는것과 동일하지않다.

## 2.DOM내의 모든 스타일시트(CSSStylesheet 개체)에 접근하기
- document.styleSheets : HTML 문서 내에 명시적으로 연결(link)되거나 내장(style)된 <br>모든 스타일시트 개쳬(CSSStylesheet 개체)리스트에 접근할수있게 해줌
>styleSheet은 다른 노드리스트와 마찬가지로 라이브상태
- sheet : sheet속성을 사용하여 CSSStylesheet개체에 접근할 수 있다.
```javascript
document.querySelector('#linkElement').sheet;//document.styleSheets[0]와 동일
document.querySelector('#styleElement').sheet;//document.styleSheets[1]와 동일
```
### 2-1.styleSheets리스트나 .sheet 속성을 통해 접근 가능한 CSSStylesheet 개체는 다음과 같은 속성과 메서드를 가짐
- disabled : 스타일시트를 사용 가능/불가능하게 함 (사양상 link,style element에는 존재하지 않는 attribute)
- href : 읽기전용
- media : 읽기전용
- ownerNode : 읽기전용
- parentStylesheet : 읽기전용
- title : 읽기전용
- type : 읽기전용
- cssRules : 스타일시트 내에 포함되는 규칙을 스크립트로 작성가능
- ownerRule
- deleteRule
- insertRule

## 3.CSSStyleRule 개요
>CSSStyleRule 개체는 스타일시트에 포함된 각CSS 규칙을 표현 (CSS속성과 값에 대한 인터페이스)
>cssRules 리스트는 특정 스타일시트 내에 있는 모든 CSS규칙(CSSStyleRue 개체)들의 리스트(CSSRuleList)를 제공
- cssText 
- parentRule
- parentStylesheet
- selectorText
- style
- type

## 4.스타일시트에 CSS규칙 삽입&삭제
>스타일시트 내의 CSS규칙은 0부터 시작하는 인덱스를 가짐
- insertRule() : 2개 매개변수 ('CSS규칙',인덱스 Index번호에 CSS규칙 추가
- deleteRule() : 매게변수에 Index번호 전달
### 4-1.style 속성 사용하여 CSSStyleRule의 값 편집
```javascript
var styleSheet = document.querySelector('#styleElement').sheet;
//스타일시트 내의 CSS 규칙을 설정
styleSheet.cssRules[0].style.color = 'red';
styleSheet.cssRules[1].style.color = 'purple';
```
### 4-2새로운 CSS스타일시트 생성하기
```javascript
//스타일 노드 생성
var styleElm = document.createElement('style');
//innerHTML을 사용하여 style노드에 CSS규칙 추가
styleElm.innerHTML = 'body{color:red}';
//style노드를 HTML 문서에 추가
document.querySelector('head').appendChild(styleElm);
```
### 4-3 HTML문서에 외부 스타일시트를 프로그래밍적으로 추가
>적절한 attribute로 link element 노드를 생성해서 DOM에 추가한다.
```javascript
var linkElm = document.createElement('link'); //link 생성
linkElm.setAttribute('rel','stylesheet'); // attribute추가
linkElm.setAttribute('type','text/css');
linkElm.setAttribute('href','주소');
document.head.appednChild(linkElm); //DOM에 추가
```