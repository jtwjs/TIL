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

>null은 사용자가 고의로 값을 할당하여 값이 없다는 것을 명확하게 한것 <br> undefined는 사용자가 아닌 프로그램이 실행을 하면서 값이 할당되지 않은 비어있는 변수를 호출하여 발생하는 오류를 나타낼 경우를 말함

### Array 객체
>선형으로써 순서를 기반으로 데이터를 뽑아내고싶다 = Array
- push/pop 메소드를 이용한 데이터 관리 : Stack

```javascript
var nums = new Array();

nums.push(5); // 스택형식으로 쌓음(LIFO)
nums.push(10);
nums.push(21);
var n1 = nums.pop(); //최근에 들어온 데이터순으로 방출
var n2 = nums.pop(); //방출된 데이터를 변수에 저장
var n3 = nums.pop(); //값을 꺼내면 사라짐
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

#### **push(), pop()**(LIFO)
> 배열에 원소를 추가하거나 삭제를 할때 사용 <br> 장점: 주어진 배열의 범위 내에서만 동작하기 때문에 예외처리나 에러 발생확률이 낮다. (잘 사용하지 않는 편)
- push() ```array.push(item1, item2, ..., itemX) ```
    - 배열의 끝에 원소를 추가할때 사용
- pop() ```array.pop() ```
    - 배열의 마지막 항목을 제거할때 사용

#### **shift(), unshift()**
- shift() : 배열의 첫번째 항목을 제거 후 그것을 반환
- ```array.shift() ```
- unshift() : 배열의 맨 앞에 원소를 추가한 후 배열의 길이 반환
- ```array.unshift(item1, item2, ..., itemX) ```
#### **join()**
> join() 메소드는 인자로 입력된 구분자를 이용하여 배열을 문자열로 변환하는 메소드
- ```array.join(separator) ```
    - 이 메소드는 보통 배열에 있는 원소를 모두 문자열로 변경해서 출력할때 사용
- ex:)
    ```js
    var furits = ["Banana", "Orange", "Apple", "Mango"];
    var energy = fruits.join(" and ");
    //배열의 과일 이름으로 and로 연결해서 하나의 문자열로 반환 ㅠㅅ
    -> Banana and Orange and Apple and Mango
    // 원소가 and로 연결되서 반환됨
    ```
#### slice()
> slice() 메소드는 배열의 특정 범위에 있는 원소를 가져올때 사용<br> 문법은 범위를 나타내는 시작과 끝 index가 입력됨
- ``` array.slice(start_index[, end_index]) ```
    ``` js
    var fruits = ["Banana","Orange","Lemon","Apple","Mango"];
    var citrus = fruits.slice(1,3); //index 1에서 index 3전까지의 원소를 반환
    -> Ornage,Lemon // index 1~2까지의 원소가 반환됨
    ```
#### reverse()
> reverse() 메소드는 배열의 원소 순서를 거꾸로 변경할때 사용
- ```array.reverse() ```
    ```js
    var fruits = ["Banana", "Orange", "Apple", "Mango"];
    fruits.reverse();   //fruits 배열의 원소 순서를 거꾸로 바꿈
    -> Mango,Apple,Orange,Banana // 원소의 index가 바뀜 
    ```

#### sort()
>sort() 메소드는 배열의 모든 원소를 문자열로 변환한 후 사전식으로 정렬하는 기능을 제공
- ```array.sort([compareFunction];``` compareFunction : 정렬을 위한 함수(선택)
    ```js
    var fruits = ["Banana", "Orange", "Apple", "Mango"];
    fruits.sort();  //fruits 배열의 원소를 정렬한 배열을 반환
    -> Apple,Banana, Mango, Ornage //fruits에서 사전식으로 정렬된 배열이 반환됨

    var points = [40,100,1,5,25,10];
    points.sort(function(a,b){return a-b});
    //숫자를 오름차순으로 정렬하는 비교 함수 사용
    -> 1,5,10,25,40,100 //오름차순으로 정렬된 배열이 반환됨
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
- 함수 정의(또는 함수 선언)는 다음과 같은 함수 키워드로 구성되어 있다.
    - 함수의 이름
    - 괄호 안에서 쉼표로 분리된 함수의 매개변수 목록
    - 중괄호 { } 안에서 함수를 정의하는 자바스크립트 표현

- ex:)
    ```js
    function squre(number) {
        return number * number;
    }
    //함수 squre은 number라는 하나의 매개변수를 가진다.
    // return문은 함수에 의해 반환된 값을 지정한다.
    ```
### 함수 표현식
>함수 표현식(function experssion)에 의해서 함수가 만들어 질수 있다.<br> = 익명함수(모든함수가 이름을 가질 필요가없다.)
    ```js
    const squre = function(number) { return number * number};
    let x = suqre(4);
    ```
- 함수 표현식에서 함수의 이름을 지정가능
- 함수 내에서 자신을 참조하는데 사용되거나, 디버거 내 스택 추적에서 함수를 식별하는데 사용될수 있다.

    ```js
    let factorial = function fac(n) { return n<2 ? 1 :n*fac(n-1) };

    console.log(factorial(3));
     ```



## Document Object
## Browser Object
## OOP