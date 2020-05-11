# 즉시 실행 함수<br>(Immediately-Invoked Function Expression, IIFE)
>함수를 정의하자마자 바로 호출하는 것
## 1.기본 형태
```javascript
(function () {
        //statements
})()
```
>함수 표현(Function expression)은 함수를 정의하고, 변수에 함수를 저장하고 실행하는 과정을 거친다.<br>하지만 즉시 실행 함수는 함수를 정의하고 바로실행하여 이러한 과정을 거치지 않는 특징이 있다.

## 2.즉시 실행 함수 사용법

1. 기명 즉시 실행 함수
```javascript
(function square(x) {
    console.log(x*x);
})(2);

(function square(x) {
    console.log(x*x);
}(2));

//위의 두가지 예는 괄호의 위치가 조금다를뿐 같은기능의 즉시 실행함수이다.
```
2. 익명 즉시 실행 함수
```javascript
(function (x){
    console.log(x*x);
})(2);

(function (x) {
    console.log(x*x);
}(2));
```
3. 변수에 즉시 실행 함수 저장
>즉시 실행 함수도 함수이기 때문에,**변수에 즉시 실행함수 저장이 가능**
```javascript
(mySquare = function (x) {
    console.log(x*x);
})(2);
mySquare(3);
//mySquare는 즉시 실행함수를 저장하고있어 재호출이 가능
```
>**변수에 즉시 실행 함수의 리턴 값 저장 가능**
```javascript
var mySqure =(function (x){
    return x*x;
})(2);
console.log(mySqure)
//변수에 즉시실행함수 리턴값 저장
```
## 3.즉시 실행 함수를 사용하는 이유
### 3-1. 초기화
>즉시 실행 함수는 한번의 실행만 필요로 하는 초기화 코드 부분에 많이 사용<br>**(변수를 전역(global scope)으로 선언하는 것을 피하기 위해서)** <br> 전역에 변수를 추가하지 않아도 되기 때문에 코드충돌없이 구현할수 있다.<br>(플러그인이나 라이브러리 등을 만들때 많이 사용)
```javascript
//즉시 실행 함수 이용한 초기화
var initText;
(function (number){
    var textList = ["is Odd Text","is Even Text"];
    if(number % 2 == 0){
        initText = textList[1];
    }else {
        initText = textLIst[0];
    }
})(5);

console.log(initText);//초기화됨
console.log(textList);//전역에 textList가 저장되지 않음
//또한 textList는 지역변수로, 전역 변수와 충돌없이 초기화 할 수 있게됨
```

## 4.라이브러리 전역 변수의 충돌
>JQuery나 Prototype 라이브러리는 동일한 $라는 전역 변수를 사용한다.<br>만약, 이두개의 라이브러리를 같이 사용한다면 $변수 충돌이 생김<br>**즉시 실행 함수를 사용하여 $전역 변수의 충돌을 피할 수 있다.**
```javascript 
(function ($){
    //$는 jQuery object
})(jQuery);
```
>즉시 실행 함수 안에서 $는 전역변수가 아닌 jQuery object의 지역변수가 되어,<br>Prototype 라이브러리의 $와 충돌없이 사용 할수있다.
