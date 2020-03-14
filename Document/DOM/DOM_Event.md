# DOM 이벤트
>DOM 내의 element, document 개체,window 개체와 관련되어 발생하는 사전 정의된 시점이나 사용자 정의 시점을 말한다.
- 인라인 attribute 이벤트 핸들러 
- 속성 이벤트 핸들러 : 한번의 한개의 값만 이벤트 속성에 할당
- addEventListener() : 견고하고 조직화된 솔루션 제공
```html
<!-- 인라인 attribute 이벤트 핸들러 패턴 -->
<body onclick= "console.log('fire/trigger attribute event handler')">

<div>click me</div>

<script>ㅑ
var elementDiv = document.querySelector('div');
//속성 이벤트 핸들러 패턴
elementDiv.onclick = function()
    {console.log('fire/trigger property event handler')};

//addEventListener 메서드 패턴
elementDiv.addEventListener('click',function()
    {console.log('fire/trigger addEventListener')}, false);
</script>
```

## 1. 이벤트 흐름
>이벤트가 발생되면 DOM을 따라 흘러가거나 전파되면서 다른 노드와 JavaSCript 개체들에서 동일한 이벤트를 발생시킨다. 캡처 단계(DOM 트리줄기 -> 가지)이나 버블링 단계(DOM트리 가지-> 줄기), 혹은 양쪽 모두로 발생하도록 프로그래밍 할수있다.

>~~캡처 단계는 이를 지원하지않는 브라우저가 있기 떄문에 널리 사용되지 않는다.~~<br> 최신 브라우저들에서는 캡처 단계 사용을 지원하고 있으므로, 예전에 신뢰 할수없다고 간주된 것도 요즘에는 가치가 있을수 있다.<br>통상적으로 이벤트는 버블링 단계 도중에 호출되는 것으로 가정된다.

1. Event Bublling : 특정 화면 오소에서 이벤트가 발생 했을때 해당 이벤트가 더 상위의 화면 요소들로 전달되어가는 특성
<img width="457" alt="event-bubble" src="https://user-images.githubusercontent.com/60641307/75015118-360ae780-54cb-11ea-82fa-d6c6c6872b97.png">

2. Event Capture : 버블링과 반대 방향으로 진행되는 이벤트 전파 방식
    addEventListener()의 boolean계수를 true 설정
<img width="459" alt="event-capture" src="https://user-images.githubusercontent.com/60641307/75015213-6bafd080-54cb-11ea-83e0-0a40a5694b5a.png">


## 2.이벤트 수신기
>이벤트 수신기 함수에 전달되는 이벤트 개체는 이벤트가 어느 단계에서 호출되었는지를 가리키는 숫자를 가지고 있는 eventPhase속성을 가진다.<br>1 : 캡처단계 <br>2 : 대상 단계 <br>3 : 버블링 단계

addEventListener() 메서드는 세 개의 인수를 받는다. 
1. 첫번째 인수 : 수신할 이벤트 형식
2. 두번째 인수 : 이벤트가 발생했을 때 호출될 함수
3. 세번째 인수 : 이벤트가 이벤트 흐름을 정하는 Boolean값<br>(true:캡처/false:버블링)기본 값은 false(버블링)

### 2-1 이벤트 수신기 제거
- removeEventListener() : 함수 참조로 추가된 수신기만 제거가능
    addEventListener()메서드를 사용하여 추가된 **익명 함수는 제거가 불가능**
```javascript
var sayHi = function(){console.log('hi')};
//(함수 참조)를 사용하여 이벤트 수신기 추가
document.querySelector('div').addEventListener('click',sayHi,false);
//제거
document.querySelector('div'.removeEventListener('click',sayHi,false);
```
### 2-2 addEventListener()사용시 this의 값
>addEventListener() 메서드에 전달되는 이벤트 수신기 함수 내부에서 this의 값은 이벤트가 연결된 노드나 개체에 대한 참조가 된다.
- event.currentTarget : this 속성이 제공하는 것과 동일

### 2-3 이벤트가 호출된 노드나 개체가 아닌 이벤트의 대상을 참조
- event.target : 이벤트 대상에 대한 참조 
```javascript
document.body.addEventListener('click',function(event){
    //div가 클릭되면 div가 이벤트흐름에서 대상이므로 div가 출력됨
    console.log(event.target); 
},false);
```

## 3.기본 브라우저 이벤트 취소하기
>ex:)a태그(연결된 URL로 이동),check box(박스 체크),텍스트 피드(텍스트 입력)등 이벤트 막음(취소)
- preventDefault() : 이벤트가 전파되는것(버블링,캡처단계)흐름은 막지않음

## 4.이벤트 흐름을 중지시키기

- stopPropagation() : 이벤트 흐름단계는 중지되지만 노드나 개체에 직접 연결된 이벤트는 호출,<br> +기본 이벤트는 막지 않음
- case : event bubbling (클릭한 요소의 이벤트만 발생)
- case : event capture (클릭한 요소의 최상위 요소의 이벤트만 동작)

### 4-1.동일한 대상의 이벤트 흐름뿐 아니라 다른 유사 이벤트도 중지
- stopImmediatePropagation() : 이후에 나오는 유사이벤트 모두 중지 +기본 이벤트는 막지 않는다.

## 5.사용자 정의 이벤트
>addEventListener()메서드를 document.createEvent(),initCustomEvent(),dispatchEvent()와 조합해서 사용하면 사용자 정의 이벤트를 연결해서 호출할수 있다.

- createEvent('CustomEvent) :이벤트 생성
- initCustomEvent() : 사용자 정의 이벤트 상세히 설정
    - 매개변수 (event,bubbles,cancelable,event.detail)
    - event : 이벤트
    - bubbles : 이벤트 버블링인지?
    - cancelabe : 이벤트 취소가 가능한지?
    - event.detail : IE9는 4번쨰 매개변수를 필요로함
- dispatchEvent() : 이벤트 발생(호출)
```javascript
var divElement = document.querySelector('div');
//사용자 정의 이벤트 생성. CustomEvent 매개변수 필요
var cheer = document.createEvent('CustomEvent');

//사용자 정의 이벤트에 대한 이벤트 수신기 생성
 divElement.addEventListener('goBigBLue',function(event){
     console.log(event.detail.goBigBlueIs)
 },false);
 //initCustomEvent 메서드를 사용하여 사용자 정의 이벤트를 상세히 설정
 cheer.initCustomEvent('goBigBlue',true,false,{goBigBlueIs:'its gone!'});

 //dispatchEvent를 사용하여 사용자 정의 이벤트 호출
 divElement.dispatchEvent(cheer);
 ```

 ### 5-1. 커스텀 데이터 추가(CustomEvent())
 > 사용자 정의 이벤트의 주기를 단순화시켜주는 생성자, **IE9에서는 지원되지않음**
 ```javascript
 var event = new CustomEvnet('build',{detail: elem.dataset.time });
 //이벤트 리스너의 부가적인 데이터의 접근
 function eventHandler(e){
     console.log('The time is : '+e.detail);
 }
 ```
 ## 6.이벤트 위임 -Event Delegation
 >이벤트 흐름을 활용하여 단일 이벤트 수신기가 여러개의 이벤트 대상을 처리할수 있게하는 프로그래밍 행위
>하위 요소에 각각 이벤트를 붙이지 않고 상위 요소에서 하위 요소의 이벤트들을 제어하는 방식
```html
<ul id="menu">
    <li><button id="file">파일</button></li>
    <li><button id="edit">편집</button></li>
    <li><button id="view">보기</button></li>
</ul>
<script>
    //각각 기능 클릭시 특정 동작을 하게하려면 보통 다음과 같이 한다
document.getElementByid("file").addEventListener("click",function(e){//파일메뉴동작
});
document.getElementByid("edit").addEventListener("click",function(e){//편집메뉴동작
});
document.getElementByid("view").addEventListener("click",function(e){//보기메뉴동작
});
/*메뉴가 추가될때마다 이벤트 핸들러가 하나씩 늘어나게될것이다.
하지만 이벤트 위임을 사용하면 상위 엘리먼트인 <ul id="menu">에만 리스너를 추가하면된다.*/
document.getElementById("menu").addEventListener("click",function(e){
    var target = e.target;
    if(target.id === "file"){
        //파일메뉴동작
    }else if (target.id === "edit"){
        //편집메뉴동작
    }else if (target.id ==="view"){
        //보기메뉴동작
    }
});
```
### 6-1 이벤트 위임의 이점
1. 동적인 엘리먼트에 대한 이벤트처리가 수월
2. 상위 엘리먼트에서만 이벤트리스너를 관리하기 때문에 하위 엘리먼트 추가삭제 용이
3. 이벤트 핸들러 관리가 쉽다
4. 메모리 사용량이 줄어든다.
5. 메모리 누수가능성도 줄어든다.
