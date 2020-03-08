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

### Array 객체
>선형으로써 순서를 기반으로 데이터를 뽑아내고싶다 = Array
- push/pop 메소드를 이용한 데이터 관리 : Stack

```javascript
var nums = new Array();

nums.push(5); // 스택형식으로 쌓음(LIFO)
nums.push(10);
nums.push(21);
var n1 = nums.pop(); //최근에 들어온 데이터순으로 방출
var n2 = nums/pop(); //방출된 데이터를 변수에 저장
var n3 = nums/pop(); //값을 꺼내면 사라짐
```
- push/pop 메소드를 이용한 데이터 관리 : List

```javascript
var nums = new Array();
nums[0] = 5;  //인덱스를 부여해 저장하는 방식
nums[1] = 10; 
nums[2] = 21;

var nums2 = new Array();
nums2[3] = 5; // 배열 길이가 4인 배열을 만듦
//앞쪽은 비어있는 형태의 공간을 만듦
```
- 배열 객체 초기화

```javascript
var nums = new Array(); 
//숫자가 하나일 경우 배열의 길이를 정함
var nums = new Array(5); 
//숫자가 두개 이상일 경우 초깃값으로 인식;
var nums = new Array(5,10,21);
//다른 형식의 데이터를 목록에 넣을수 있다.
var nums = new Array(5,10,21,"hello");
alert(typeof nums[3]);//typeof : 어떤형식의 데이터인지 알려줌
//배열 목록에 배열을 넣을수 있다.
var nums =new Array(5,10,21,"hello",new Array(2,3,4));
//nums[4][0] = 2 ,nums[4][1] = 3, nums[4][2] = 4 
```

- splice()메소드를 이용한 데이터 관리 : List

```javascript
var nums = new Arrays(5,10,21,"hello");//생성과동시에 초기화

nums.splice(1); //1번째 위치부터 다 삭제
nums.splice(1,1);//1번쨰 위치부터 1개를 삭제
nums.splice(1,2);//1번째 위치부터 2개를 삭제
nums.splice(2,1,"hoho"); //2번째 위치에서 1개를 지우고 "hoho"를 삽입
nums.splice(2,0,"hoho");// 2번째 위치에 "hoho"를 삽입
```

- new 연산자 없이 배열 생성
> []구문 안에 해당 배열 객체에 초기화할 값들을 넣음
```javascript
//var 참조변수이름 = [값1,값2,값3...값n];
var numbers = [1,2,3,4,5];
var Strings = ['나무','산','바다'];
```

### Object
>JavaScript는 객체를 만든후에 정의를한다. (동적인 객체정의)<br> 그러므로 오타에 주의..(버그의 주요인)

>key값 hash(식별자)값을 이용해서 값을 저장하는 공간이 필요하다 = Object

```javascript
var exam = new Object();
exam.kor = 30;
exam.eng = 70;
exam.math = 80;
```

- 키를 이용한 데이터 관리 : Map


```javascript
var exam = new Object();
//변수에 담겨진 문자열을 객체의 속성을 꺼내야될때&대입하여야될때
exam["kor"] = 30;
exam["eng"] = 70;
exam["math"] = 80;
//기본값
exam.kor = 30;
exam.eng = 70;
exam.math = 80;
```
#### prototype
#### class
## 연산자
## 제어구조
## 함수
## Document Object
## Browser Object
## OOP