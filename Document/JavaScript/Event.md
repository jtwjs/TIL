## ## Event - 이벤트 흐름, 이벤트 핸들러

### 이벤트 흐름
> 페이지에 이벤트가 전달되는 순서
- 이벤트 버블링 [IE]
- 이벤트 캡처링 [넷스케이프]

#### 이벤트 버블링
> IE의 이벤트 흐름 <br> 특정화 면 요소에서 이벤트가 발생했을 때 이벤트가 더 상위의 화면 요소들로 전달되어 가는 특성을 의미

![buble-flow](https://user-images.githubusercontent.com/60641307/81632159-8b102700-9444-11ea-8413-cd04c8f10b20.png)

```HTML
<!DOCTYPE html>
<html>
    <head>
        <title>이벤트 버블링 예제</title>
    </head>
    <body>
        <div id="mydiv">Click Me</div>
    </body>
</html>

//Event 발생순서
1. div
2. body
3. html
4. document
```

#### 이벤트 캡처링
> 넷스케이프 커뮤니케이터 팀이 만든 이벤트 캡쳐링 이벤트 흐름 <br> 이벤트 버블링과 정반대로 최상위 노드에서 이벤트가 발생

![이벤트캡처](https://user-images.githubusercontent.com/60641307/81635570-73d53780-944c-11ea-8d07-ce5acae5ccec.png)

- Event 발생순서
1. document
2. html
3. body
4. div

- 이벤트 버블링을 주로 쓰며 오래된 브라우저에서는 이벤트 캡처링을 지원하지 않는다.

### DOM 이벤트 흐름
- DOM이벤트 흐름 3단계
    1. 이벤트 캡처링 단계
    2. 타깃 단계
    3. 이벤트 버블링 단계

    ![돔 이벤트흐름](https://user-images.githubusercontent.com/60641307/81635746-f3630680-944c-11ea-9d62-78addb437c13.png)

- Event 발생순서
1. document
2. html
3. body (1~3 이벤트 캡처링단계)
4. div  (타깃 단계)
5. body (5~7 이벤트 버블링단계)
6. html
7. document


### 이벤트 핸들러
> 이벤트 -> 사용자 또는 브라우저가 취하는 특정 동작
><br> 이벤트는 click, load, mouseover같은 이름이 있고 이벤트에 응답해서 호출되는 함수를 이벤트 핸들러(이벤트 리스너)라고 한다.

#### 이벤트 핸들러를 HTML 작성시 단점
- 이벤트 핸들러의 함수의 스코프 체인 확장 결과가 브라우저마다 다름
- 식별자 해석에 사용하는 규칙이 자바스크립 엔진에 따라 미묘하게 다름
- 결과 비적격 객체 멤버에 접근할때 에러 발생위험
- 이벤트 핸들러를 HTML에서 할당시 HTML과 자바스크립트가 단단하게 묶임
> 자바스크립트와 HTML 분리하자 

#### 자주쓰이는 이벤트 목록
- **onblur**
    - 객체가 focus를 잃었을 때
- **onchange**
    - 객체의 내용이 바뀌고 focus를 잃었을 때
- **onclick**
    - 객체를 클릭했을 때
- **ondblclick**
    - 객체를 더블클릭할 때
- **onerror**
    - 에러가 발생했을 때
- **onfocus**
    - 객체에 focus 되었을 때
- **onkeydown**
    - 키를 눌렀을 때
- **onkeypress**
    - 키를 누르고 있을 때
- **onkeyup**
    - 키를 눌렀다 땟을 때
- **onload**
    - 문서나 객체가 로딩되었을 때
- **onmouseover**
    - 마우스가 객체위에 올라왔을 때
- **onmouseout**
    - 마우스가 객체 바깥으로 나갔을 때
- **onreset**
    - Reset 버튼을 눌럿을 때
- **onresize**
    - 객체의 크기가 바뀌었을 때
- **onscroll**
    - 스크롤바를 조작할 때
- **onsubmit**
    - 폼이 전송될 때

### 이벤트 위임
> 하위 요소에 각각 이벤트를 붙이지 않고 상위 요소에서 하위 요소의 이벤트를 제어하는 방식


