# JavaScript
>**JavaScript(자바스크립트)** 는 브라우저에서 실행되는 프로그램 언어이다. <br>사용자의 행동에 화면이 반응하는 것과 같은 동적인 기능을 웹페이지나 애플리케이션에 넣기 위해 사용된다.

>Node.js를 통해 서버상에서도 JavaScript를 구동할 수 있다.


## Data(데이터) 

### Dynamic Typing(동적 타이핑)
>객체의 타입을 명시적으로 지정하지 않고, 런타임에서 객체의 타입을 설정하도록 하는것을 동적타이핑이라고 한다.

>자바스크립트는 **느슨한 타입(loosely typed)언어**,혹은 **동적(dynamic)언어**이다. 변수의 타입을 미리 선언할 필요가 없다는 뜻.<br>프로그램이 처리되는 과정에서 자동으로 파악됨(같은 변수에 여러타입의 값을 넣을수 있다.)

```javascript
var foo = 42;   //foo는 이제 Number
var foo = "bar";//foo는 이제 String
var foo = true; //foo 는이제 Boolean
```

### Data Type(데이터 타입)
- 기본 자료형(Primitive) 데이터 타입
    - Boolean
    - Null
    - Undefined
    - Number
    - String
    - Symbol
- 별도로 Object도 있음
#### 기본 타입(Primitive values)
>오브젝트를 제외한 모든 값은 변경 불가능한 값(immutable value)이다.<br>예를 들어,특히 C언어와는 다르게도,문자열은 불변값(immutable)이다.

|Type|Content|
|:----:|:-------------|
|Boolean|Boolean은 논리적인 요소를 나타내고<br>true와 false의 두가지 값을 갖음|
|Null|딱 한가지 값, null을 가진다.|
|Undefined|값을 할당하지 않은 변수는 <br>undefined 값을 갖는다.|
|Number|숫자 값(정수,실수)|
|String|텍스트 데이터|
|Symbol|유일하고 변경불가능한 기본값<br>객체 속성의 key값으로도 사용가능|

### Wrapper클래스
- var 
- let
- c
## 연산자
## 제어구조
## 함수
## Document Object
## Browser Object
## OOP