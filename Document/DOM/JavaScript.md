# DOM에서의 JavaScript
>외부 JavaScript 파일의 내용은 HTML 문서 내에 텍스트 노드로 들어간다.<BR>HTML문서 내에 JavaScript를 삽입하는 두 방법 모두 script element노드의 사용을 필요로 한다.
```HTML
<!-- 외부의 크로스 도메인 JavaScript 모듈을 포함-->
<script src=
    "http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.3.3/underscroe-min.js">
    </script>
<!-- 페이지 인라인 JavaScript-->
<script>
console.log('hi')
</script>
```
>페이지 인라인 JavaScript는 텍스트 노드를 생성하므로 script태그의 내용을 가져오기 위해 <br>innerHTML과 textContent를 사용할 수 있다.<br>하지만 브라우저가 이미 DOM을 해석한 이후에 JavaScript코드로 구성된 텍스트 노드를 DOM에 추가하더라도<br> 이 JavaScript 코드는 실행되지 않으며 단순히 텍스트만 바꾼다.

>JavaScript 코드가 /script라는 문자열을 가지는 경우, 파서가 이를 실제 /script element로 생각하지 않도록 <br> \/script로 이스케이프 처리를 해야한다.

## 1.기본적으로 javaScript는 동기 방식으로 해석됨
> DOM이 해석될 때 script element를 만나게되면 문서 해석을 중지하고. 렌더링 및 다운로드를 차단한 후,<br> Javscript를 실행한다. 이 동작은 블로킹을 발생시키며, DOM 해석이나 JavaScript 실행을 병렬적으로 수행할 수 없게 하므로,<br> 동기 방식이라고 생각하면 된다. JavaScript가 HTML문서 외부에 있는 경우 블로킹이 더 심해지는데,<br> JavaScript를 해석하기 전에 먼저 다운로드를 해야 하기 때문이다.

>script element의 기본 블로킥 특성은 성능 및 HTML 웹 페이지의 시각적인 렌더링 속도에 상당한 영향을 미칠 수 있다.<br> HTML 페이지의 시작 부분에 여러 script element가 있는 경우, 각 스크립트가 순차적으로 다운로드 되어 실행 될때 까지는 아무런 다른 동작이 발생하지 않는다.

## 2.외부 JavaScript의 다운로드 및 실행을 **지연**시키기 위해 **defer**를 사용하기도 한다.
>script element는 브라우저가 /html 노드를 해석할 때까지 외부 JavaScript파일의 블로킹,다운로드,실행을 지연시켜주는 <br>defer라는 attribute를 가진다. 웹브라우저가 script노드를 만나게 될때 발생하는 것들을 간단하게 지연시킨다.

## 3.**async**를 사용하여 외부 JavaScript 다운로드 및 실행을 **비동기**로 수행하기
>script element는 웹 브라우저가 DOM을 생성할 때 script element의 순차적인 블로킹 특성을<br> 재정의하기 위한 async라는 attribute를 가진다.<br>HTML페이지의 생성을 차단하지 않고 순차적 로딩 역시 하지않게 한다.

>주요 단점은 JavaScript파일이 DOM에 포함된 순서와 다르게 해석된다는 것이다.(종속성 관리문제 유발) <br>async와defer 둘다 사용된 경우 async가 우선

## 4.외부 Javascript의 **비동기 다운로드 및 해석을 강제화**하기 위한 동적 script element 사용하기
>**프로그래밍적**으로 외부 JavaScript파일을 포함하는 script element를 생성해서 DOM에 삽입하는 기법<br> DOM에 포함된 순서와 다르게 해석됨(종속성 관리문제 유발)
```javascript
//ex: 프로그래밍적으로 생성후 body element에 추가해 브라우저로 하여금 비동기로 처리하도로 강제
var underscoreScript = document.createElement('script');
underscoreScript.src = 
    "http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.3.3/underscore-min.js";
document.body.appendChild(underscoreScript);
```
## 5.비동기 script가 로드되는 시점을 알수 있도록 onload 콜백 사용하기
>onload 이벤트는 onload가 지원될 경우에만 동작한다. onerror, load, error를 사용할수도 있다.
```javascript
//1.프로그래밍적
var underscoreScript = document.createElement('script');
underscoreScript.src = 
    "http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.3.3/underscore-min.js";
underscoreScript.onload = function(){console.log('underscore is loaded and excuted');};
document.body.appendChild(underscoreScript);

//2.외부 javascript
<script async src= ""
onload="console.log('jQuery is loaded and executed');"> 
</script> 
```

## 6.DOM 조작 시 HTML에서 script의 위치에 주의
>scirpt element는 원래 동기방식이므로 HTML문서의 head element에 두게 되면<br> 실행되는 javascript가 script보다 뒤에있는 DOM의 요소에 의존적일 경우 타이밍 문제를 발생시킨다.<br>이 때문에 많은 개발자들은 모든 script element를 /body element 이전에 두려고 시도함.

## 7.DOM 내의 script 목록 가져오기
- document.scripts : 현재 DOM 내의 모든 script의 리시트를 제공