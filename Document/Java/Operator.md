# 연산자(Operator)
>피연산자(상수나 상수를 저장하고 있는 변수)들 사이의 계산방식을 특정한 기호로 표시

- 연산(operation) : 정해진 규칙에 따라 데이터를 처리하여 결과를 출력
- 연산자(operator) : 연산에 사용되는 표시나 기호
- 피연산자(operand) : 연산자가 처리하는 데이터
- 식(expression) : 연산자와 피연산자를 이용하여 연산의 과정을 기술한 것

- 단항연산자: 피 연산자가 1개인 연산자
- 이항연산자: 피 연산자가 2개인 연산자
- 삼항연산자: 피 연산자가 3개인 연산자
**피연산자 : 연산에 참여하는 변수나 상수**
## 연산자 우선순위
|우선순위|명칭|연산자|
|:---:|:---:|:---:|
|1|최우선 연산자|(),[],->,.|
|2|단항 연산자|++/--,+/-,!,~|
|4|산술 연산자|+,-,*,/,%|
|5|Shift 연산자|<<,>>,>>>|
|6|비교 연산자|<,>,<=,>=,==,!=|
|7|비트 연산자|&,|,^|
|8|논리 연산자|&&,|| |
|9|삼항 연산자|(조건항)?참 항:거짓 항|
|10|배정 대입 연산자|=,*=,-=등|
|11|증감 후위 연산자|i++/i--|
|12|순차 연산자|,(콤마)|


## 1.증감 연산자 
1. --i,++i(전위 증감 연산자):변수의 값을 먼저 증감시킨 후에 변수가 참조된다.
2. i--,i++(후위 증감 연산자):변수의 값이 먼저 참조된 후에 값이 증감한다.

## 2. 논리 연산자(&,|,^)
>비트연산자는 숫자(정수)에만 적용되는것;<br>이진 비트연산을 수행한다. 자동으로 int타입변환
1. & : 피연산자 양 쪽 모두 1이면 1이다.
2. | : 피연산자 중 어느 한쪽이 1이면 1이다.
3. ^ : 피연산자가 서로 다를 때 1이다.

## 3.논리 연산자(AND,OR,NOT)
1. && : **AND연산** 두 조건 모두 참일경우에 참
2. || : **OR연산** 두 조건 중 한 조건이라도 참인경우 참 
3. !  : **NOT연산** 참을 거짓, 거짓을 참으로 바꿈
### |와 ||의 작동방식 차이
> ||는 앞의 조건이 참이면 뒤의 조건을건너뜀<br> |는 두조건 모두 검사
```java

public class Tutorial03 {

	public static void main(String[] args) {
		int num1 = 0, num2 = 0;
		if(++num1>0||++num2>0)//앞의조건이 참이여서 뒤의식은 건너뜀
			System.out.println("num1이 0보다 크거나 num2가 0보다 크다.");
		System.out.println("num1 = "+num1);
		System.out.println("num2 = "+num2);
	}

}
```
## 4.비트 연산자
>데이터 구성 비트를 가지고 AND,OR,XOR,NOT연산을 수행<br>
>비트: 0과 1로 구성된 수
- 피연산자1 **&** 피연산자2 : 두 데이터의 같은 위치 비트들을 AND 연산
- 피연산자1 **|** 피연산자2 : 두 데이터의 같은 위치 비트들을 OR 연산
- 피연산자1 **^** 피연산자2 : 두 데이터의 같은 위치 비트들을 XOR 연산
- ~피연산자 **:** 데이터의 각 비트들을 NOT연산
>비트 연산자는 피연산자의 타입이 서로 다르면 넓은 타입 쪽으로 자동 변환수행<br>단, 두 피연산자가 모두 int보다 좁은 타입이면 둘다 int타입으로 자동변환수행
## 5.비교 연산자
>두개의 변수 또는 리터럴을 비교하는데 사용되는 연산자<br>(주로 조건문,반복문의 조건식에 쓰임)
### 대소비교 연산자(<,>,<=,>=)
>두 피연산자의 크기를 비교하는 연산자,bollean을 제외한 데이터형에 사용가능
### 등가비교 연산자(==,!=)
>두 피연산자에 저장되어있는 값이 같은지 다른지를 비교하는 연산자.<br>모든 자료형에 사용 가능

## 6.Shift 연산자
>두 개의 수를 가지고 노는 연산, 즉 바이너리(2진수)연산=논리연산<br>데이터 구성 비트를 오른쪽/왼쪽으로 밀어서 이동시키는 연산자

### 좌측(왼) 시프트 연산[n**<<**i , n*2^(i)](산술 시프트)
> ex: n<< i 즉, n숫자의 비트를 좌측으로 i만큼 이동<br>좌측으로 한번씩 이동될 때마다 비트 특성상 2의 i승만큼 증가<br>주어진 비트수만큼 왼쪽으로 이동하고 빈 공간은 0으로 채운다.
### 우측(오) 시프트 연산[n**>>**i , n/2^(i)](산술 시프트)
> ex: n<< i 즉, n숫자의 비트를 우측으로 i만큼 이동<br>실제 산술 자리이동으로 동작하여 범위를 벗어난 비트공간은 모두 무시된다.<br>주어진 비트수만큼 오른쪽으로 이동하고 빈 공간은 **MSB**와 똑같은 비트로 채운다.
### 우측(오) 시프트 연산[n**>>>**i n n/2^(i)](논리 시프트)
> 주어진 비트수만큼 오른쪽으로 이동하고 빈 공간은 0으로 채운다.<br>부호가 바뀔수 있다.
#### MSB(Most Significant Bit)
>비트로 표현되는 숫자의 최대값의 위치<br> 즉 수를 나타내는 비트 열에서 가장 왼쪽의 비트가 **MSB**가 된다.<br> 반대되는 개념은 LSB로써 가장 오른쪽의 비트를 뜻한다.

## 7.삼항 연산자

1. 삼항연산자를 사용하여 코드의 라인이 줄어들었다고 컴파일 속도가 빨라지는 것은 아니다.
2. 삼항연산자를 중복해서 처리할 경우, 가독성이 떨어질 수 있으므로 중복처리는 피하는것이 좋다.

```java
// (조건 boolean)?*(조건이 참일때 수행):(조건이 거짓일 때 수행)
//ex:)
int a a=20, b= 30, max;
max = a < b ? a : b;
System.out.println(max); //조건이 참이여서 a출력 -> 20
//변수 = (boolean 조건식) ? true일 때 값 : false일 때 값
```

#### 캐스트연산자
- 데이터 타입 변환만 전문으로 수행하는 연산자
- 큰 범위 타입의 데이터를 작은 범위 타입으로 바꿀 수도 있다.
```java
(타입)피연산자
피연산자의 값을 이 타입으로 강제 형 변환시킨다.
 
//불가능한 캐스트 연산
int num5 = (int) true; // X
boolean truth = (boolean) 8; //X
```