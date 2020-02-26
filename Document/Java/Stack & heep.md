# Stack & Heap
> JVM(자바가상기계)에서 사용되는 메모리 영역중 일부

![2458A349592E1C420F](https://user-images.githubusercontent.com/60641307/75226778-433c1500-57f0-11ea-840b-e4d0a2925d68.gif)

## Stack (정적 메모리 스택 영역)
- JVM : 각각의 스레드는 1개의 스택을 가지고 모든 메소드들을 트랙킹한다.
- 스택 영역은 변수값을 저장하게됨, 기본타입인 변수를 실제값으로 저장한다.
- 크기가 정해져 있다.
- 메모리 할당시 컴파일할때 이미 계산이 이루어진다.
- 메소드 작업이 종료되면 할당되었던 메모리 공간은 반환되어 비워진다.
- LIFO(Last IN Frist Out)구조 :후입선출
- 순차적으로 저장하는 직선형 자료 구조 
### 기본타입
- 정수 타입 : byte/char/short/int
- 실수 타입 : float/double
- 논리 타입 : boolean
### 장점
- 해체하지 않음으로 인한 메모리 누수와 같은 문제를 신경쓰지 않아도된다.
- 정적 할당된 메모리는 실행 도중에 해체되지 않고,프로그램이 종료할 때 알아서 운영체제가 회수한다.
### 단점
- 메모리의 크기가 하드 코딩 되어있어 나중에 조절 할수 없다.
- 스택에 할당된 메모리이므로 동적 할당에 비해 할당 받을수 있는 최대 메모리에 제약을 받는다.

## Heap (동적 메모리 힙 영역)
- 힙 영역은 객체와 배열이 생성되는 공간이고 참조타입들을 힙 영역에 주소형식으로 저장한다.
- 크기가 정해져 있지 않는 타입이다.
- 메모리 할당시 프로그램을 실행할때 메모리를 빌려 동적으로 할당한다.
- 참조하는 변수가 없다면 자동으로 힙 영역에서 제거된다.
- 동적 메모리 할당은 컴퓨터 프로그래밍에서 실행 시간 동안 사용할 메모리 공간을 할당하는것을 말한다.
- 프로그램이 실행하는 순간 프로그램이 사용할 메모리 크기를 고려하여 메모리의 할당이 이루어진다.
- 동적으로 할당된 메모리 공간은 사용자가 명시적으로 해제하거나 쓰레기 수집이 일어나기전까지 그대로 유지됨

### 참조타입
- 배열타입
- 열거타입
- 클래스(Class)
- 인터페이스

### 장점
- 상황에 따라 원하는 크기만큼의 메모리가 할당되어 경제적
- 이미 할당된 메모리도 크기 조정가능

### 단점
- ~~더이상 사용하지 않을 때 명시적으로 메모리를 해제해 주어야한다.~~
- 자바는 Garbege Collector가 해결 해준다~
