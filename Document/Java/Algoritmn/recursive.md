# Recursive Algorithmn(재귀 알고리즘)

## 1.재귀란?
>어떤 사건이 자기 자신을 포함하고 다시 자기 자신을 사용하여 정의될 때 재귀적(recursive)라고 한다.<br>
>재귀 알고리즘에 알맞은 경우는 '풀어야 할 문제','계산할 메서드','처리할 데이터구조'가 재귀로 정의되는 경우이다.
### 1-1.재귀의 개념을 사용한 자연수의 정의
1. 1은 자연수입니다.
2. 자연수n의 바로 다음 수도 자연수입니다.

## 2.Factorial(팩토리얼) 구하기
>n이 하나의 자연수일 때에, 1에서 n까지의 모든 자연수의 곱이 n의 팩토리얼
- 음이 아닌 정수n의 팩토리얼(n!) 
    1. 0! =1
    2. n>0이면 n!=n*(n-1)!

```java
class Factorial{
    static int factorial(int n){
        if(n>0)
            return n * factorial(n-1);
        else 
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("정수를 입력하세요");
        int x =sc.nextInt();

        System.out.println(x + "의 팩토리얼은 "+factorial(x)+"입니다.");
    }
}
```
## 3.재귀 호출
>'자기 자신과 똑같은 메서드'를 호출하는 것
### 3-1.직접 재귀
>자기 자신과 같은 메서드를 호출하는 것
### 3-2.간접 재귀
>메서드 a가 메서드 b를 호출하고, 다시 메서드 b가 메서드 a를 호출하는 구조

## 4.유클리드 호제법
>두 정수의 최대공약수를 재귀적으로 구하는 방법
## 4-1. 최대공약수 (greatest common divisor)
> 큰 값에서 작은 값으로 나누었을 때 나누어떨어지는 가장 작은 값 <br>나누어지지 않으면 작은값(얻은 나머지)에 대해 나누어 떨어질 떄까지 같은 과정을 재귀적으로 반복.

```java
static int gcd(int x,int y){
    if(y==0)
        return x;
    else
        return gcd(y,x%y);
}
```
## 5.재귀 알고리즘 분석

```java
static void recur(int n){
    if(n>0){
        recur(n-1);
        System.out.print(n);
        recur(n-2);
    }
}//출력 결과물 (n이 4인경우):1231412 
```
>재귀호출을 여러회 실행하는 메서드를 순수하게 재귀적이라 하며 매우 복잡하다.

### 5-1.하향식 분석
>가장 위쪽에 위치한 메서드 호출부터 시작해 계단식으로 자세히 조사하는 분석 기법(같은 호출이 여러번 발 생 가능)
- recur(4)인경우
1. recur(3)을 실행한다.
2. 4를 출력한다.
3. recur(2)를 실행한다.

### 5-2.상향식 분석
>아래쪽부터 쌓아 올리며 분석하는 방법.
- recur 메서드는 n이 양수일 때만 실행하므로 먼저 recur(1)을 생각
1. recur(0)을 실행한다. //출력내용없음
2. 1을 출력한다.
3. recur(-1)을 실행한다. //출력내용없음

1. recur(1)을 실행한다.// recur(1)실행
2. 2를 출력한다.
3. recur(0)을 실행한다. //출력내용없음 이과정을 recur(4)까지 함 

## 6.재귀 알고리즘의 비재귀적 표현
### 6-1.꼬리 재귀의 제거
>메서드의 꼬리에서 재귀 호출하는 recur(n-2)라는 말은 인자로 n-2를 전달하는 recur메서드를 호출한다'라는 의미는 n의 값을 n-2로 업데이트하고 메서드의 시작 지점으로 돌아간다.로 바꿀수 있다.
```java
static void recur(int n){
    while(n>0){
        recur(n-1);
        System.out.println(n);
        n=n-2;  //메서드 끝에서 실행하는 꼬리재귀를 제거한 모습
    }
}
```
### 6-2.재귀의 제거
>꼬리 재귀와 다르게 앞에서 호출한 재귀 메서드이 제거는 쉽지 않다. 변수 n의 값을 출력하기 전에 recur(n-1)을 먼저 수행해야 하기 때문
1. n의 값을 n-1로 업데이트하고 메서드의 시작지점으로 돌아간다.
2. 현재 n의 값을 '잠시' 저장한다. //스택 활용
3. 저장했던 n을 다시 꺼내 그 값을 출력한다. 
```java 
static void recur(int n){
IntStack s = new IntStack(n);

while(true){
    if(n>0){
    s.push(n);
    n=n-1;
    continue;
}
if)(s.isEmpty() !=true) { //스택이 비어있지 않다면
     n=s.pop();           //저장하고 있던 스택의 값을 pop
     System.out.println(n);
     n = n-2;
     continue;
}
break;
}
}
````