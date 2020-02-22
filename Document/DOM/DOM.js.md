# dom.js 만들기
>jQuery 유사 DOM 라이브러리(DOM노드를 선택하고 무엇인가를 수행하기 위한 라이브러리의 기반)
```javascript
//문서 내의첫번째 ul에서 모든 li를 선택하고 첫번째 li의 innerHTML을 가져옴
dom('li','ul').html();

//document fragment를 사용하여 html 구조를 생성하고 ul의 innerHTML을 가져옴
dom('<ul><li>hi</li></ul>').html()
```
## 1.고유 범위 만들기
>전역 범위로부터 dom.js코드를 보호하기 위해 고유 범위 만들기
```javascript
(function(win){

    var global = win;
    var doc = this.document;
})(window);
//즉시실행함수가 호출될때, global의 값은 현재 전역범위(window)로 설정됨
```
>IIFE 내부에서는 window와 document개체를 보다 빨리 접근할수 있도록 이 개체들의 대한 참조를 설정한다.

## 2.dom()과 getOrMakeDom()을 생성하고 dom()과 getOrMakeDom.prototype을 전역을 노출시키기

### 1.dom()과 getOrMakeDom()을 생성
>함수로 전달되는 매개변수를 기반으로 DOM노드에 대해 체인화되고 래핑된 집합을 반환하는 함수를 만듦
```javascript
(function(win){
    var global = win;
    var doc =global.document;

    var dom= function(params,context){
        return new GetOrMakeDom(params,context);
    };
    var GetOrMakeDom = function(params,context){

    };
})(window);
```

### 2.dom() 전역범위에 노출
>IIFE에 의해 구성되는 private 범위 외부에서 dom() 함수가 접근/호출될 수 있게 하려면, 전역범위에 해당 함수를 노출(즉 참조를 생성)해야한다.
```javascript
(function(win){
    var global = win;
    var doc =global.document;

    var dom= function(params,context){
        return new GetOrMakeDom(params,context);
    };
    var GetOrMakeDom = function(params,context){

    };
    //dom을 전역 범위로 노출.
    global.dom = dom;
})(window);
```
### 3.getOrMakeDom.prototype을 전역범위로 노출
>jQuery와 마찬가지로(ex: jQuery.fn), dom.fn으로부터 getOrMakeDom.prototype으로의 단축 경로를 제공
```javascript
(function(win){
    var global = win;
    var doc =global.document;

    var dom= function(params,context){
        return new GetOrMakeDom(params,context);
    };
    var GetOrMakeDom = function(params,context){
    };
    //dom을 전역 범위로 노출.
    global.dom = dom;
    //prototype에 대한 단축 경로.
    dom.fn = GetOrMakeDom.prototype;
    /*dom.fn에 연결되는 것은 실제로 getOrMakeDom.prototype 개체의 속성이되고
    GetOrMakeDom 생성자 함수로부터 만들어지는 모든 개체 인스턴스에 대해 속성 찾아보기를 통해 상속된다.*/
})(window);
```
>GetOrMakeDom 함수는 new 연산자로 호출된다. 

## 3.dom()에 전달되는 선택적인 Contexet 매개변수 생성하기
>dom()이 호출될 때 GetOrMakeDom 함수도 호출되며, dom()에 전달된 매개변수가 그대로 전달된다.<br>GetOrMakeDom 생성자가 호출될 때, 가장 먼저해야할것은 Context를 결정하는 것<br>dom()함수에 Context를 전달하면,DOM트리의 특정 브랜치에서 element노드를 탐색하도록 제한할수 있게된다. 이 Context는 jQuery나 $함수에 전달되는 두번째 매개변수와 거의 동일

```javascript
(function(win){
    var global = win;
    var doc =global.document;
    var dom= function(params,context){
        return new GetOrMakeDom(params,context);
    };
    var GetOrMakeDom = function(params,context){

        var currentContext = doc;
            if(context){
                if(context.nodeType){//문서 노드 혹은 element 노드 중 하나.
                    currentContext = context;
                }else{//문자열 선택자인경우, 노드를 선택하는데 사용
                    currentContext = doc.querySelector(context);
                }
            }
    };
    //dom을 전역 범위로 노출.
    global.dom = dom;
    //prototype에 대한 단축 경로.
    dom.fn = GetOrMakeDom.prototype;
})(window);
```

## 4.params를 기반으로 DOM 노드 참조를 가진 개체를 채워 반환
>dom()에 전달된 후 getOrMakeDom()에 전달되는 params 매개변수의 형식은 다양하다.<br>jQuery와 유사하게, 전달되는 값 형식은 다음 중 하나가 될수있다.
- CSS 선택자 문자열 : ex) dom('body')
- HTML 문자열 : ex) dom(' p>Hello /p> p> World! /p>' )
- Element 노드 : ex) dom(document.body)
- ELement 노드의 배열 : ex) dom[document.body]
- NodeList : ex) dom(document.body.children)
- HTMLcollection : ex) dom(document.all)
- dom() 개체 자신 : ex) dom(dom())
> params를 전달하면 결과적으로 DOM이나 document fragment 내의 노드에 대한 참조를 가진 체인화된 개체를 생성하게 된다.

> GetOrMakeDom() 생성자 함수에서 노드에 대한 참조를 포함하고 있는 개체가 생성되고 이 개체가 dom()으로 반환된다


## 5. each() 메서드를 생성하고 체인화된 메서드로 만들기
>dom()을 호출하면, prototype 상속을 사용하여 dom.fn에 연결된것에 접근할수있다.ex: dom().each() <br>dom.fn에 연결된 메서드는 GetOrMakeDom생성자 함수에서 생성된 개체상에서 동작한다.
- each() : 매개변수로 콜백 함수를 받아 GetOrMakeDom 개체 인스턴스의 각 노드 element에 대해 해당 함수를 호출한다.
```javascript
dom.fn.each = function (callback) {
    var len = this.length; /*dom() 호출 시 getOrMakeDom()에서 생성되어 반환되는
                            특정 인스턴스 */
    for(var i=0;i<len;i++){
        //this 값을 element 노드로 설정한 후 매개 변수로 전달해서 콜백 함수 호출.
        callback.call(this[i],i,this[i]);    
    }
}
```
>each()메서드를 체인화해서 each()를 호출한 후 다른 메서드를 더 호출할 수 있도록 this를 반환한다.
```javascript
 dom.fn.each = function (callback) {
    var len = this.length; 
    for(var i=0;i<len;i++){
        callback.call(this[i],i,this[i]);    
    }
    return this; 
};
```
## 6.html(),append(),text() 메서드 만들기
- html() / html('html 문자열')
- text() / text('텍스트 문자열')
> html()과 text() 매개변수 값을 가지고 메서드가 호출된경우: dom.fn.each()를 사용하여 GetOrMakeDom 개체 인스턴스 내의 각 element노드에 대해 루프를 돌면서 innerHTML 값이나 textContent 값을 설정한다.<br>매개변수가 전달되지 않은경우 : GetOrMakeDom개채 인스턴스 내의 첫번쨰 element 노드의 innerHTML또는 textContent 값을 반환한다. 
- append('html|텍스트|dom()|노드리스트/HTML 컬렉션|노드|배열')
>append() 메서드는 HTML문자열,텍스트 문자열,dom()개체,노드리스트/HTML컬렉션,단일노드,노드배열을 받아 insertAdjacentHTML을 활용하여 선택된 노드에 추가한다.

