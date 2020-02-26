# Math.

## 1.Math.pow()  [멱급수]
>자바에서는 ^라는 기호를 제곱을 구할때 쓰지 않는다.<br>그래서 제곱함수인 Math.pow를 사용한다.
```java 
int a = Math.pow(밑,지수)
```
## 2.Math.round() [반올림]
>소수점 첫째자리에서 반올림하여 정수로 반환하는 함수
- 소수점 n번째 자리까지 남기기
```java
double n2= Math.pow(10.0,n);//10의n승
double e = 2.71828;
System.out.println(Math.round(e*n2)/n2);
//10의 n승 곱하고 Math.round()함수 실행 후 다시 n승으로 나눈다.
```

## 3.Math.random() [난수]
>0.xxxx~0.9xxxx까지의 값을 난수로 반환
```java
Math.random() //0.2327996...
//(int)강제 형변환으로 정수값으로 변환
(int)Math.random()*n //n은 범위값
(int)Math.random()*n+a //a는 시작값(초기값은0)
```