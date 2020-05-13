## HTML 페이지에 자바스크립트 사용방법
> HTML과 자바스크립트는 서로 다른 언어이다. 그렇기 때문에 자바스크립트를 실행하기 위해서는 다음 4가지 방법이 있다.

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 1) Head Tag 안에서 외부 자바스크립트 파일 Loading 방식-->
    <script tpye="text/javascript" src="./1-2.js"></script>
    <title>Document</title>
</head>
<body>
    
    <!-- 2) HTML Tag 안에 Inline 방식 -->
    <input type="button" onclick="alert('hello world JavaScript from HTML')" value="Hello world" />

    <!-- 3) script Tag 안에 삽입 방식 -->
    <script type="text/javascript"> 
        alert('Hello world Javascript from HTML');
    </script>

    <!-- 4) Body Tag 안에서 외부 자바스크립트 파일 Loading 방식 -->
    <script type="text/javascript" src="./1-3.js"></script>
</body>
</html>
```

### HTML Tag 안에 Inline 방식
``` <input type="button" onclick="alert('hello world JavaScript from HTML')" value="Hello world" /> ```
- HTML tag 에는 각각의 이벤트가 있는데 그 이벤트에 연결되어 있는 자바스크립트가 동작하게 됨<br> 보통 이런 구현은 JavaScript Function을 만들어 이벤트에 연결한다.
- inliine 방식을 사용할 경우에는 해당 이벤트에 자바스크립트 코드가 직접 들어가기 때문에 바로 분석이 가능
    - 해당 tag에서 어떤 자바스크립트가 적용되어 동작하는지 바로 알 수 있는 것이 **큰 장점**
- 화면을 표현하는 HTML 소스와 제어하는 자바스크립트 소스가 분리되지 못하기 떄문에 서로 **의존관계가 높아져서 향후 유지보수성이 안좋을 수 있다.**
- 보통 이런 **inline 방식은 anti-pattern** 이라고 한다.    
    - **개발 시 피해야 하는 개발 방법**

### Script Tag 안에 삽입 방식
``` 
<script type="text/javascript"> 
    alert('Hello world Javascript from HTML');
</script>
```
- html 소스 안에 script tag를 사용하여 tag 안에 자바스크립트 소스를 직접 작성하는 방법으로<br> 이것 또한 **inline 방식과 동일한 이유로 anti-pattern** 이다.

### 외부의 자바스크립트 파일 로딩(Loading)방식
```html
<head>
    <!-- 1) Head Tag 안에서 외부 자바스크립트 파일 Loading 방식-->
    <script tpye="text/javascript" src="./1-2.js"></script>
</head>

<body>
    <!-- 4) Body Tag 안에서 외부 자바스크립트 파일 Loading 방식 -->
    <script type="text/javascript" src="./1-3.js"></script>
</body>
```

- html 파일과 별도로 개발한 자바스크립트 소스를 저장한 js 파일을 로딩하여 사용하는 방식으로<br> html 소스와 자바스크립트 소스를 파일로 엄격하게 분리한 방식이다.
- **장점**
    - 재사용 가능하고 중복 코드 개발을 줄일수 있다.
    - 웹 브라우저의 캐쉬 기능을 통해 속도 향상 효과 및 리소스 사용을 최소화 할 수 있다.
- 외부 js 파일을 로딩하는 시점에 따라 자바스크립트 오류 및 html을 렌더링하는데 영향을 미칠수 있다.
- 많은 자바스크립트 전문가들이 **body Tag의 가장 하단에서 js 파일을 로딩**하라고 조언하고있다.!

#### 자바스크립트 소스가 head에 있을 경우 
- 해당 자바스크립트가 메모리에 로딩될 떄까지 사용자는 웹 페이지의 어떤 구조도, 이미지도 볼수가 없다. 
- 그 이유는 웹 브라우저가 html을 위에서부터 아래로 하나씩 해석해서 렌더링 하기 때문이다.
- 웹사이트의 성능 향상을 위해서는 가능하면 body의 가장 밑에서 로드하도록 권장한다.
- HTML5의 표준으로 정의되어 있는 async 또는 defer 속성을 이용하여 렌더링을 저하기시키는 문제를 해결할 수 있다.
    ```
    <script async src="async.js" onload="init()"></script>
    ```
    ```
    <script defer src="defer.js" onload="init()"></script>
    ```
- async와 defer의 차이는 스크립트 실행 시점이다. 
    - **async script** : window의 onload event가 발생하기 전에 js파일이 내려받아지는 즉시 실행
    - **defer script** : html의 parsing 작업이 모두 끝난 후 DOMContentLoaded 이벤트가 발생하기 전에 js 파일을 실행
    