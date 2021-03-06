# 알고리즘 (Algorithm)
> 알고리즘이란 문제를 해결하는 방법이다.
- ex:) 오렌지주스 만들기
    - 오렌지를 손으로 쥐어짠다.
    - 오렌지를 양파망에 넣고 발로밟는다.
    - 녹즙기를 사용한다.
>위의 예 중,방법을 선택해보고 그 이유를 설명해봐라, 아마도 보다 쉽고 합리적이다 생각되는 방법을 선택할것이다.<br>
>컴퓨터를 통한 문제 해결 또한 마찬가지.. 어떤 문제를 보다 효율적,합리적으로 풀 수록 좋은 알고리즘이다.

## 자료구조와 알고리즘간의 관계
> 좋은 알고리즘을 만들기 위해 필요한것이 자료구조이다.

## 알고리즘의 선택기준
> 하나의 문제를 두고 다양한 알고리즘이 존재할 수 있다.<br> 선택의 기준은 크게 **실험적분석**과 **이론적분석**이다.

## 실험적 분석과 한계
> 실험적 분석은 실제 실행시간(running time)을 측정하는 방법이다.

```java
long startTime = System.currentTimeMillis();// 시작 시간
doAlgorithm();
long endTime = System.currentTimeMillis();// 종료 시간
long elapse = endTime - startTime;// 소요시간 = 종료시간 -시작시간
```
>실험적 분석방법은 알고리즘 외적 요인들로 인한 한계점이 있다.
- 하드웨어의 성능에 따른 영향
- 구현 언어에 따른 영향
- 현재 실행 중인 다른 프로세스들의 영향
### 시간복잡도(time complexity)
- 실행시간은 실행환경에 따라 달라짐(하드웨어,운영체제,컴파일러 등)
- 실행 시간을 측정하는 대신 **연산의 실행 횟수를 카운트** => 어떠한 환경에서 실행하더라도 동일
- 연산의 실행 횟수는 **입력 데이터의 크기에 관한 함수로 표현 => n에 관한 함수로**
- 데이터의 크기가 같더라도 실제 데이터에 따라서 달라짐
    - ex:) 배열에서 원하는 값을 찾는 경우 찾는 값이 배열 어디에 위치하는 지에 따라 달라진다.
    - **최악**의 경우 시간복잡도(worst-case analysis)
        - 평균 시간복잡도가 구하기 더 어렵기 때문에 최악을 더 많이 사용
        - 데이터가 없는 경우, 모든 데이터를 다 비교하는 경우
    - **평균** 시간복잡도(average-case analysis)

## 이론적 분석

> 성장률(Growth Rate)

![8nXvk](https://user-images.githubusercontent.com/60641307/77392532-846b1900-6dde-11ea-89d8-4c13d253b128.jpg)

- O(1) : 상수시간 내 처리 가능
- O(n) : 선형시간 내 처리 가능
- O(n^2) : 이차시간 내 처리 가능

## 점근적(Asymptotic) 분석
- 점근적 표기법을 사용
    - 데이터의 개수 n->∞ 일때 수행시간이 증가하는 growth rate로 시간복잡도를 표현하는 기법
    - Θ-표기, Ο-표기(빅오) 등을 사용
        - (+) 빅오는  upper bound를 표현
   - 최고차항만 남기고 모두 버리는 것
   - 유일한 분석법도 아니고 가장 좋은 분석법도 아님
        - 다만 상대적으로 가장 간단하며 알고리즘의 실행환경에 비의존적
        - 가장 광범위하게 사용됨

### 빅오 표기법
- 빅오 표기법 또한 이론적 분석의 핵심이다.
- 빅오 표기법은 최악의 경우 알고리즘의 복잡도(이론적 수행시간)을 나타낸다.
- O(1)은 데이터 크기에 상관없이 일정한 복잡도를 갖는다.
- O(n)은 데이터 크기에 정비례한 복잡도를 의미한다.
- O(n^2)은 데이터 크기의 제곱에 비례한 복잡도를 갖는다.
- 일반적으로 빅오 표기법은 n의 가장 큰 지수만 고려한다.
    - ex:) 총 연산결과가 3n^2 + 100n + 12345  -> O(n^2)로 표현 
#### 상수 시간복잡도
> 입력으로 n개의 데이터가 저장된 배열 data가 주어지고, 그 중 n/2번째 데이터를 반환한다.

```java
int sample( int data[], int n){
    int k = n/2;
    return data[k]; 
}
```
- n에 관계없이 상수 시간이 소요된다. 이 경우 알고리즘의 시간복잡도는 O(1)이다.
#### 선형 시간복잡도
>입력으로 n개의 데이터가 저장된 배열 data가 주어지고, 그 합을 구하여 반환한다.

```java
int sum(int data[], int n){
    int sum = 0;
    for (int i = 0; i< n; i++)
        sum = sum+data[i];
        //이 알고리즘에서 가장 자주 실행되는 문장이며, 실행 횟수는 항상 n번
        //가장 자주 실행되는 문장의 실행횟수가 n번이라면
        //모든 문장의 실행 횟수의 합은 n에 선형적으로 비례하며, 모든 연산들의
        //실행횟수의 합도 역시 n에 선형적이다.
        return sum;
}
```
- 선형 시간복잡도를 가진다고 말하고 O(n)이라고 표기한다.
- 최악,평균을 구분할수 없음

#### 순차탐색

```java
int search(int n,int data[],int target){
    for(int i=0; i<n; i++){
        if(data[i] == target)//이 알고리즘에서 가장 자주실행되는 문장,
                                //실행 횟수는 최악의 경우 n번
        return i;
    }
    return -1;
}
```
> 최악의 경우 (데이터가 배열에 없는 경우)시간복잡도는 O(n)이다.

#### Quadratic(2차)

```java
boolean is_distinct(int n, int x[]){
    for(int i=0; i<n-1; i++){
        for(int j=i+1; j<n; j++){
            if(x[i]==x[j]) //이 알고리즘에서 가장 자주 실행되는 문장이며,
                            //최악의 경우 실행 횟수는 n(n-1)/2번이다.
                return false}
    freturn true;
    }
}
```
- 최악의 경우 배열에 저장된 모든 원소 쌍을 비교하므로 비교 연산의 횟수는 n(n-1)/2이다.
- 최악의 경우 시간복잡도는 O(n^2)로 나타낸다.

<img width="566" alt="Big-O" src="https://user-images.githubusercontent.com/60641307/77396481-327ac100-6de7-11ea-92df-494c77b179b5.png">

>n^3(다항함수) 과 2^n(지수함수)는 굉장히 큰차이가 있다.