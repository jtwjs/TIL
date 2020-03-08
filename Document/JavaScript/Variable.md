# Variable(변수)
>데이터를 담기 위한 메모리 공간을 의미<br>**var**키워드로 변수를 선언하며, **선언함과 동시에 값을 할당**할 수 있습니다.<br> 쉼표(,)를 통해 여러 개를 한 문장으로 선언할 수 있다.<br> 지정된 초깃값 없이 선언된 변수는 undefined 값을 갖는다.


- var
- let
- const

```javascript
var sum; //변수 sum을 선언. undifined
var a= 3; //변수 a를 선언함과 동시에 3을 a에 할당
var b,c,d;
var e=1,f=2,g=3;// 여러 변수를 한번에 선언 및 초기화 가능
```
## 변수 선언 방식
- 변수 선언 방식 **var**의 단점

```javascript
var name = 'bathingape'
console.log(name) // bathingape

var name = 'javascript'
console.log(name) // javascript
```
>변수를 한번 더 선언했음에도 불구하고, 에러가 나오지 않고 각기 다른값이 출력된다.<br>이는 유연한 변수 선언으로 간단한 테스트에는 편리 할 수 있겠으나, 코드량이 많아진다면 어디에서 어떻게 사용될지도 파악하기 힘들뿐더러 값이 바뀔 우려가 있다. <br>그래서 ES6 이후 , 이를 보완하기 위해 추가 된 변수 선언 방식이 **let**과 **const** 이다.<br>이 둘의 차이점은 **immutable** 여부이다.

```javascript
let name = 'bathingape'
console.log(name) // bathingape

let name = 'javascript'
console.log(name) 
//Uncaught SyntaxError: Identifier 'name' has already been declared
```
>name이 이미 선언되었따는 에러 메세지가 나온다.(**const**도 마찬가지)<br>변수 재선언이 되지 않는다.

- **let**은 변수에 재할당이 가능하다.

```javascript
let name = 'bathingape'
console.log(name)//bathingape

let name = 'javascript'
console.log(name);
//Uncaught SyntaxError: Identifier 'name' has already been declared

name = 'react'
console.log(name):
```

- **const**는 변수 재선언,변수 재할당 모두 불가능하다.

```javascript
let name = 'bathingape'
console.log(name) //bathingape

let name = 'javascript'
console.log(name)
//Uncaught SyntaxError: Identifier 'name' has already been declared

name = 'react'
console.log(name)
//Uncaught TypeError: Assignment to constant variable.
```

### 정리
>변수 선언에는 기본적으로 **const**를 사용하고, 재할당이 필요한 경우에 한정해 **let**을 사용하는것이 좋다.

>그리고 객체를 재할당하는 경우는 생각보다 흔하지 않다. **const**를 사용하면 의도치 않은 재할당을 방지해 주기 때무에 보다 안전하다.

1. 재할당이 필요한 경우에 한정해 **let**을 사용한다. <br>이때 변수의 스코프는 최대한 좁게 만든다.
2. 재할당이 필요 없는 상수와 객체에는 **const**를 사용한다.

## 변수 선언 방식의 차이 : var name / $name
>예약어인 var은 variable의 약자로 선언하는 위치에 따라 global scope, function scope로 사용된다.
### 유효범위
>지역변수와 전역변수의 이름이 같을 경우 지역변수가 우선수위가 높음
### 전역변수(Global Variable)
>함수 외부에서 선언된 변수로, 프로그램 전체에서 접근할수 있는 변수
### 지역변수(Local Variable)
>함수 내부에서 선언된 변수로, 함수가 실행되면 만들어지고 함수가 종료되면 소멸하는 변수, 함수 외부에서는 접근할수 없다.

>함수 내부에서 선언하는 변수인 경우라도, 선언 명령어 var을 생략하고 변수를 선언하는 경우, 전역변수로 사용되어 진다. 지역변수를 선언하는 경우는 반드시 변수를 선언하는 명령어를 써서 전역변수와 구분해주는 것이 좋다.
 
>함수 매개변수도 지역변수로 간주하며 해당 함수의 본문 내에서 접근할수 있다.


## 변수 선언 생략
>선언되지 않은 변수를 읽으려고 하면 **참조 오류**가 발생<br> 변수를 선언하지 않고 사용하는 행위는 버그의 원인이 될수 있으니, 반드시 사용하자

#### 선언되지 않은 변수에 값을 대입하면?
>var문으로 선언되지 않은 변수에 값을 대입하면 오류가 발생하지 않는다.<br>자바스크립트 엔진이 해당 변수를 자동으로 **전역 변수로 선언**하기 때문, 이는 변수의 유효범위와 관련있다.

```javascript
//선언되지 않은 변수를 읽으려고 할 때
console.log(x); // ReferenceError: x is not defined(오류 메시지)

//var문으로 선언되지 않은 변수에 값을 대입할 때
y = 2;
console.log(y); // -> 2
```

## Hoisting(호이스팅/변수 끌어올림)
>**hoist**의 사전적 정의를 살펴보면, 들어올리다/끌어올리다 라는 뜻을 갖는다.<br>프로그램은 작성 순서에 따라 차례대로 실행되지만, 변수 선언은 이 원칙을 따르지 않고 범위에 따라 선언과 할당을 **분리**시켜 **위로 끌어올린다.**

>Javascript는 ES6에서 도입된 let,const를 포함하여 모든 선언(var,let,const,function,function*,class)을 호스팅한다.

```javascript
//ex:) 호이스팅 전
console.log(x);
var x;

//ex:) 호이스팅 후
var x;
console.log(x);
```
>하지만,**var**로 선언된 변수와 달리 **let**으로 선언된 변수를 선언문 이전에 참조하면 에러(ReferenceError)가 발생한다.

```javascript
console.log(foo); //undefined
var foo;

console.log(bar);//Error: Uncaught ReferenceError: bar is not defined
let bar;
```
>이는 **let**으로 선언된 변수는 스코프의 시작에서 변수의 선언까지 일시적 사각지대(Temporal Dead Zone :TDZ)에 빠지기 때문이다.<br>참고로 변수는 **선언 단계 > 초기화 단계 > 할당 단계** 에 걸쳐 생성되는데 <br> **var**로 선언된 변수는 선언 단계와 초기화 단계가 한번에 이루어진다.

```javascript
//스코프의 선두에서 선언 단계와 초기화 단계가 실행된다.
//따라서 변수 선언문 이전에 변수를 참조할 수 있다.
console.log(foo); //undefined

var foo;
console.log(foo); //undefined

foo = 1; //할당문에서 할당 단계가 실행된다.
console.log(foo);//1
```
>**let**으로 선언된 변수는 선언단계와 초기화 단계가 분리되어 진행된다.

```javascript
//스코프의 선두에서 선언단계가 실행된다.
//아직 변수가 초기화(메모리 공간 확보와 undefined로 초기화)되지 않았다.
//따라서 변수 선언문 이전에 변수를 참조할 수 없다.

console.log(foo);//ReferenceError: foo is not defined

let foo; // 변수 선언문에서 초기화 단계가 실행된다.
console.log(foo); //undefined

foo = 1;//할당문에서 할당 단계가 실행된다.
console.log(foo);//1
```



#### 선언과 동시에 대입하면?
>선언과 동시에 대입하는 코드는 끌어올리지 않는다.<br>정확히는 선언부 var x는 끌어올려지지만, 대입부 x=5 는 끌어 올려지지 않는다고 설명할 수 있다.

```javascript
//ex:)
console.log(x); // undefined
var x = 5;
console.log(x); // 5

//ex:)
var x;
console.log(x); // undefined
x= 5;
console.log(x); // 5
```
>호이스팅은 다른 언어에는 없는 자바스크립트만의 **고유한 특징**이나, 이해하기 쉬운 코드 작성을 위해서는 **반드시 시작부에 변수를 선언**하는 것이 좋다.

## 변수의 이름
### 식별자
>변수,함수,라벨 이름 등 사용자가 정의하는 이름을 **식별자(identifier)**라고 한다.<br>식별자는 다음과 같은 규칙을 따라야 한다.
- 알파벳(A~Z, a~z), 숫자(0~9), 언더바(_), 달러 기호($) 사용 가능
- 첫 글자는 숫자를 사용할 수 없음, 숫자를 제외한 위의 나머지 중 하나를 사용
- 예약어를 식별자로 사용할 수 없음

### 변수 이름 짓기
>변수의 이름은 식별자 규칙에 어긋나지 않는다면 자유롭게 지정 할 수 있다.<br>그러나 일반적으로 다른 사람도 **변수의 의미를 알 수 있도록**일정한 표기법을 사용 
- camelCase(캐멀 표기법)
- PascalCase(파스칼 표기법)
- snake_case(스네이크 표기법)

##### camelCase(캐멀 표기법)
>두번째 이후 단어의 대문자 부분이 낙타의 혹처럼 보인다고 해서 지어진 이름<br>두번째 이후 단어의 첫글자를 대문자로 하며 나머지는 소문자로 표기<br> **ex:) newName createLifeGame**

##### PascalCase(파스칼 표기법)
>프로그래밍 언어의 파스칼(pascal)에서 사용된 표기법<br>각 단어의 첫글자를 모두 대문자로 표기<br> **ex:) NewName CreateLifeGame**

##### snake_case(스네이크 표기법)
>모든 단어를 소문자로 표기하며, 단어 사이사이에 언더바(_)를 넣어 표기<br> **ex:) new_name create_life_game**

- 캐멀 표기법이나 스네이크 표기법을 사용하여 변수의 의미를 파악할 수 있게 함
- 기본적으로 영어 단어 사용
- 루프 카운터 변수 이름으로 i,j,k 등을 사용
- 상수는 대문자로 표현 ex)MAX_SIZE
- 논리값 표현 시에는 이름 앞에 is를 붙임 ex) isMoseDown
- 생성자 이름을 붙일 때는 파스칼 표기법을 사용

## 예약어
>자바스크립트 문법을 규정짓기 위한 특수 키워드를 말함 <br>예약어로 지정된 키워드들은 **식별자**나 **프로퍼티 이름**으로 사용하지 않으며, 미리 정의된 전역 변수와 전역 함수 역시 사용하지 않는 편이 좋다. 사용하더라도 오류는 발생하지 않지만 **본래의 기능을 사용할 수 없게 된다.** 또한 Window 객체의 이름과 DOM에서 사용하는 객체 이름도 사용하지 않는다.


## 1.유효범위
>지역변수와 전역변수의 이름이 같을 경우 지역변수가 우선수위가 높음
### 1-1. 전역변수(Global Variable)
> 함수 외부에서 선언된 변수로, 프로그램 전체에서 접근할수 있는 변수
### 1-2. 지역변수(Local Variable)
> 함수 내부에서 선언된 변수로, 함수가 실행되면 만들어지고 함수가 종료되면 소멸하는 변수, 함수 외부에서는 접근할수 없다.
- 함수 매개변수도 지역변수로 간주하며 해당 함수의 본문 내에서 접근할수 있다.