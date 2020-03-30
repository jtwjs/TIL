# Thread(스레드)
- **CPU가 실행하기 위한 최소한의 실행단위**
- **Thread** : 프로그램의 실행 흐름
    - 사전적 의미: 한가닥 실 (한가지 작업을 실행하기 위해 순차적으로 실행할 코드를 실처럼 이어놓았다해서 유래됨)
    - 한 프로세스 내의 스레드가 두개라면 두개의 코드 실행흐름이 생긴다는 의미
- 멀티 프로세스가 애플리케이션 단위의 멀티 태스킹이라면 멀티 스레드는 애플리케이션 내부에서의 멀티 태스킹이다.
- **process**(**프로세스**) :  실행중인 하나의 애플리케이션
    - 사용자가 애플리케이션을 실행하면 운영체제로부터 실행에 필요한 메모리를 할당받아 애플리케이션의 코드를 실행하는 것
    - 하나의 애플리케이션은 다중 프로세스를 만들기도함
    - 멀티 프로세스들은 서로 독립적이다.
        - 운영체제에서 할당받은 자신의 메모리를 가지고 실행하기 떄문.
        - 하나의 프로세스에서 오류가 발생해도 다른 프로세스에게 영향을 미치지 않는다.
- **Multi tasking**(**멀티 태스킹**) : 두가지 이상의 작업을 동시에 처리 하는것
    - 운영체제는 멀티태스킹을 할수 있도록 CPU 및 메모리 자원을 프로세스 마다 적절히 할당해주고 병렬로 실행시킨다.
    - 멀티 태스킹은 꼭 멀티 프로세스를 뜻하는 것은아니다.
        - 한 프로세스 내에서 멀티 태스킹을 할수있도록 만들어진 애플리케이션도 있다.
            - **Multi Thread**(**멀티 스레드**)를 이용한 것!
- **Multi Thread**(**멀티 스레드**)
    - 멀티스레드는 하나의 프로세스 내부에 생성되기 때문에 하나의 스레드가 예외를 발생시키면<br> 프로세스 자체가 종료될 수 있어 다른 스레드에게 영향을 미치게 된다.
        - 그렇기 떄문에 **예외처리가 중요함!!**
## Main Thread(메인 스레드)
---
- 모든 자바 애플리케이션은 메인 스레드가 main() 메소드를 실행하면서 시작된다.
- 메인 스레드는 main() 메소드의 첫 코드부터 아래로 순차적으로 실행하고,<br> mian() 메소드의 마지막 코드를 실행하거나 return문을 만나면 실행이 종료된다.
- 메인 스레드는 필요에 따라 작업 스레드들을 만들어서 병렬로 코드를 실행할 수 있다.
    - 즉, 멀티 스레드를 생성해서 멀티 태스킹을 수행한다.


![thread](https://user-images.githubusercontent.com/60641307/77727037-be395b00-703c-11ea-8a8c-05e499533421.png)

- 멀티스레드의 작동방식
    - 처음 자동으로 시작되는 메인 스레드 외에 다른 스레드는 생성 위치에 시작하여 끝이난다.
        - 메인스레드가 작업스레드보다 먼저 종료되더라도 작업 스레드가 계속 실행중이라면 프로세스는 종료되지 않는다.

### 종류 
- Single Thread (싱글 스레드) : 스레드가 하나뿐인 프로그램
- Multi Thread (멀티 스레드) : 스레드가 둘 이상인 프로그램

### 특징
- 모든 Thread는 단독으로 실행 (FIFO)
- 자바는 멀티 쓰레드를 지원한다.
    - Multi Thread : 말 그대로 하나의 프로그램에서 **여러개의 실행흐름**을 만들고 실행할수 있다는 것
    - **사용하는 이유** : 외부와의 연계같이 대기 시간이 발생했을 떄 기다리는 동안 다른 일을 처리할수 있계 해서 **처리 속도를 빠르게 하기 위함**
    - 단,CPU코어 수가 적으면 쓰레드를 그 만큼 만들수 없기 때문에 드라마틱하게 빨라지지 않고, 처리하는 데이터 양이 적을 때에도 속도가 많이 빨라지지 않기 때문에 쓰레드를 적절한 경우에 사용하는 것이 좋다.

## 작업 스레드 생성과 실행
---
- 멀티 스레드로 실행하는 애플리케이션을 개발하려면 몇개의 작업을 병렬로 실행할지 결정하고 각 작업별로 스레드를 생성해야 한다.
- 모든 자바 애플리케이션은 메인스레드가 반드시 존재! 
    - 메인작업 이외에 추가적인 병렬 작업의 수만큼 스레드를 생성하면 된다.
- 자바에서는 작업 스레드도 객체로 생성되기 때문에 클래스가 필요하다.
    1. java.lang.Thread 클래스를 직접 객체화해서 생성
    2. Thread를 상속해서 하위 클래스로 만들어 생성

### 1. Thread 클래스로부터 직접 생성
>java.lang.Thread 클래스로부터 작업 스래드 객체를 직접 생성하려면 Runnalbe을 매개값으로 갖는 생성자를 호출해야한다.

```java
Thread thread = new Thread(Runnable target);
```
- Runnable : 작업 스레드가 실행할 수 있는 코드를 가지고 있는 객체
    - 인터페이스 타입이기 때문에 구현 객체를 만들어 대입해야 한다.
    - Runnable에는 run() 메소드 하나가 정의되어 있다.
        - 구현 클래스는 run() 재정의해서 작업 스레드가 실행할 코드를 작성해야 한다.

```java
class Task implements Runnable{
    public void run(){
        스레드가 실행할 코드;
    }
}
```
- Runnable은 작업 내용을 가지고 있는 객체이지 실제 스레드는 아니다.
    1. Runnable 구현 객체를 생성
    2. 이것을 매개값으로 해서 Thread 생성자 호출
    3. 작업 스레드 생성!~

```java
Runnable task = new Task(); //Runnable 구현 객체 생성
Thread thread = new Thread(task); // Thread 클래스 매개값으로 대입

//코드를 절약하기 위해 Thread 생성자를 호출할 때 Runnable 익명 객체를 매개값으로 사용 가능
Thread thread = new Thread(new Runnable(){
    public void run(){
        스레드가 실행할 코드;
    }
});

//Runnable 인터페이스는 run() 메소드 하나만 정의되어 있기 떄문에 함수적 인터페이스이다.
//따라서 람다식을 매개값으로 사용가능하다. [가장 간단한 방법 자바8부터 가능]
Thread thread = new Thread( () ->{ //람다식
    스레드가 실행할 코드;
});

thread.start(); //작업스레드는 start()메소드를 호출해야만 실행
```
- start() 메소드가 호출되면, 작업 스레드는 매개값으로 받은 Runnable의 run() 메소드를 실행하면서 자신의 작업을 처리


### sleep() 메소드
- Thread class에 있는 메소드로 그냥 시간이 경과되기만을 기다리는 메소드
    - 정적 메소드이기 때문에 Thread.sleep();으로 호출할수 있다. 
    - 단, 이 메소드는 InterruptedException(checked)이 발생하므로 Try-Catch로 체크를 해주어야한다.
    - 매개변수의 정수는  1000은 1초를 뜻함 ex:) sleep(1000); -> 1초

### 2. Thread 하위 클래스로부터 생성
>작업 스레드가 실행할 작업을 Runnable로 만들지 않고, Thread의 하위 클래스로 작업 스레드를 정의하면서 작업내용을 포함시킬수 있다.
- 작업 스레드 클래스를 정의하는 방법
    1. Thread 클래스를 상속 시킨다.
    2. run()메소드를 재정의(overriding)해서 스레드가 실행할 코드 작성
- 작업 스레드 클래스로부터 작업 스레드 객체를 생성하는 방법은 일반적인 객체 생성하는 방법과 동일

```java
public class WorkerThread extends Thread{
    @Override
    public void run(){
        //스레드가 실행할 코드;
    }
}
Thread thread = new WorkerThread();

//Thread 익명 객체로 작업 스레드 객체 생성
Thread thread = new Thread(){
    public void run(){
     // 스레드가 실행할 코드;
    }
};

thread.start(); // 작업 스레드 객체에서 start()메소드를 호출하면 작업 스레드는 자신의 run() 메소드를 실행한다.
```

### Thread Name(스레드 이름)
- 스레드는 자신의 이름을 가지고 있다.
- 스레드의 이름이 큰역할을 하는것은 아니다.
    - 디버깅할때 어떤 스레드가 어떤 작업을 하는지 조사할 목적으로 가끔 사용
- 메인 스레드는 'main'이라는 이름을 가지고 있다.
    - 우리가 직접 생성한 스레드는 자동적으로 'Thread-n'이라는 이름으로 설정된다.
        - n은 스레드의 번호를 말한다. 
- Thread-n 대신 다른 이름으로 설정하고 싶다면 Thread 클래스의 setName() 메소드로 변경 가능
- setName()과 getName()은 Thread의 인스턴스 메소드이므로 스레드 객체의 참조가 필요
    - 만약 스레드 객체의 참조를 가지고 있지 않다면
        - Thread의 정적 메소드인 currentThread()로 코드를 실행하는 현재 스레드의 참조를 얻을수 있다.

```java
Thread thread = Thread.currentThread(); // 코드를 실행하는 현재 스레드의 참조를 얻음
```

|Method|Explain|
|:-------|:-------|
|currentThread()|[정적 메소드] 코드를 실행하는 <br>현재의 스레드의 참조를 얻을 수 있다.|
|setName(String s)|이름을 변경|
|getName()|스레드 이름을 반환|

## Thread Priority(스레드 우선순위)
---
- 멀티스레드는 동시성(Concurrency) 또는 병렬성(Parallelism)으로 실행됨
    - Concurrency(동시성) : 멀티 작업을 위해 하나의 코어에서 멀티 스레드가 번갈아가며 실행하는 성질
    - Parallelism(병렬성) : 멀티 작업을 위해 멀티 코어에서 개별 스레드를 동시에 실행하는 성질
- 싱글 코어 CPU를 이용한 멀티 스레드 작업은 병렬적으로 실행되는 것처럼 보이지만,<br> 사실은 번갈아가며 실행하는 동시성 작업이다.
    - 번갈아 실행하는 것이 워낙 빠르다보니 병렬성으로 보일 뿐이다.
> 스레드의 개수가 코어의 수보다 많을 경우, 스레드를 어떤 순서에 의해 동시성으로 실행할 것인가 결정해야 하는데 이것이 스레드 스케줄링<br> 스레드 스케줄링에 의해 스레드들은 아주 짧은 시간에 번갈아가며 그들의 run() 메소드를 조금씩 실행한다.
- Thread scheduling : 우선순위(Priority)방식 , 순환 할당(Round-Robin) 방식을 사용한다.
- 우선순위방식 : 우선순위가 높은 스레드가 실행 상태를 더많이 가지도록 스케줄링하는 것
    - 스레드 객체에서 우선순위 번호를 부여할수 있기 때문에 개발자가 코드를 제어 가능
    - 1(우선순위 낮음) ~ 10(높음) 까지 부여, 우선순위를 부여하지 않으면 모든 스레드들은 기본적으로 5의 우선순위를 갖음
    - **setPriority()** 메소드를 이용해서 **우선순위 변경** 가능
    - 코드의 가독성(이해도)를 위해 Thread 클래스의 상수를 사용할수도 있다.
        - MAX_PRIORITY = 10
        - NORM_PRIORITY = 5
        - MIN_PRIORITY = 1
    - 다른 스레드에 비해 실행 기회를 더많이 가지려면 MAX_PRIORITY로 우선순위를 높게 설정하면 된다.
    - 우선순위가 높은 스레드가 실행 기회를 더많이 가지기 떄문에 우선순위가 낮은 스레드보다 계산 작업을 빨리끝낸다.
- 순환할당방식 : 시간 할당량(Time Slice)을 정해서 하나의 스레드를 정해진 시간만큼 실행하고 다시 다른 스레드를 실행하는 방식
    - 순환할당방식은 JVM에 의해서 정해지기 떄문에 코드로 제어할수 없다.
## Synchronization method & Synchronization Block (동기화 메소드와 동기화 블록)
---
- **주의할점**
    - 멀티 스레드 프로그램에서는 스레드들이 객체를 공유해서 작업해야 하는 경우
        - 스레드 A를 사용하던 객체가 스레드 B에 의해 상태가 변경될 수 있기 때문에 스레드 A가 의도했던 결과와 다를수 있다.
- 스레드가 사용중인 객체를 다른 스레드가 변경할 수 없도록 하려면 스레드 작업이 끝날 때까지 객체에 잠금을 걸어야한다.
- **임계 영역**(**critical section**) 
    - 멀티 스레드 프로그램에서 단 **하나의 스레드만 실행할 수 있는 코드 영역**
    - 자바는 임계영역을 지정하기 위해 동기화(synchronized)메소드와 동기화 블록을 제공한다.
    - 스레드 객체 내부의 동기화 메소드&블록에 들어가면 즉시 객체에 잠금을 걸어 다른스레드가 임계영역에 코드를 실행하지 못하도록 함
    - 동기화 메소드를 만드는 방법은 **메소드 선언에 synchronized 키워드를 붙이면 된다.**
        - synchronized 키워드는 인스턴스와 정적메소드 어디든 가능

- **동기화 메소드** 
    - 메소드 전체 내용이 임계영역
    - 스레드가 동기화 메소드를 실행하는 즉시 객체에는 잠금이 일어남
    - 스레드가 동기화 메소드를 실행 종료하면 잠금이 풀림
    - 메소드 전체 내용이 아니라, 일부 내용만 임계영역으로 만들고 싶다면 동기화(synchronized)블록을 생성

```java
public synchronized void method(){
    임계 영역; //단 하나의 스레드만 실행
}
```
- **동기화 블록**
    - 동기화 블록의 외부 코드들은 여러 스레드가 동시에 실행할수 있다.
    - 동기화 블록의 내부 코드는 임계 영역이므로 한번에 한 스레드만 실행가능
    - 만약 동기화 메소드와 동기화 블록이 여러개 있을 경우 스레드가 이들 중 하나를 실행할 때
        - 다른 스레드는 해당 메소드는 물론이고 다른 동기화 메소드 및 블록도 실행할수 없다.
        - 하지만 일반 메소드는 실행이 가능하다.

```java
public void method(){
    //여러 스래드가 실행 가능 영역

    synchronized(공유 객체){//동기화 블록
        임계 영역//단 하나의 스레드만 실행
    }
    //여러 스래드가 실행 가능 영역
}
```
## Thread Status (스레드 상태)
---
1. (**NEW**) 스레드 객체 생성
2. start() 메소드 호출
3. (**RUNNABLE**) 실행 대기 
    - 스케줄링이 되지 않아서 실행을 기다리고 있는 상태
    - 스레드 스케줄링으로 선택된 스레드가 비로소 CPU를 점유하고 run()메소드 실행
4. run() 메소드 실행
    - 실행 상태의 스레드는 run() 메소드를 모두 실행하기 전에 스레드 스케줄링에의해 다시 실행대기상태로 돌아갈수있다.
    - 실행 대기 상태에 있는 다른 스레드가 선택되어 실행 상태가 된다.
    - 스레드는 실행 대기 상태와 실행 상태를 번갈아 가면서 자신의 run() 메소드를 조금씩 실행한다.
    - 경우에 따라서 실행 대기상태로 가지않고 일시정지 상태로 가기도 한다. 
        - 다시 실행상태로 가기위해서는 일시 정지상태에서 실행대기 상태로 가야한다.
5. (**TERMINATED**) 종료
    - 더이상 실행할 코드가 없기 때문에 스레드의 실행은 멈춘다.

### getState() 메소드 : 스레드의 상태에 따라 Thread.State 열거 상수 리턴

|Status|Enum Constatnt|Explain|
|:-----:|:---------|:------------|
|객체 생성|NEW|스레드 객체가 생성, 아직 start() 메소드가 호출되지 않은 상태|
|실행 대기|RUNNABLE|실행 상태로 언제든지 갈 수 있는 상태|
|일시 정지|WAITING|다른 스레드가 통지할 떄까지 기다리는 상태|
||TIMED_WAITING|주어진 시간동안 기다리는 상태|
||BLOCKED|사용하고자 하는 객체의 락이 풀릴 때까지 기다리는 상태|
|종료|TERMINATED|실행을 마친 상태|

## Thread Status Control (스레드 상태 제어)
- 실행 중인 스레드의 상태를 변경하는 것

![thread-states](https://user-images.githubusercontent.com/60641307/77843137-0d19f880-71d5-11ea-8cce-7249b5511c38.png)

- stop(), suspend(), resume() 메소드들은 스레드의 안정성을 해친다 하여 더이상 사용하지 않도록 권장된 Deprecated 메소드들이다.

|Method|Explain|
|:------|:-------|
|Interrupt()|**일시 정지 상태의 스레드에서 InterruptedException 예외를 발생**시켜, 예외처리<BR>코드(catch)에서 실행 대기 상태로 가거나 종료 상태로 갈수 있도록 한다.|
|notify()<br>notifyAll()|동기화 블록 내에서 wait() 메소드에 의해 일시 정지 상태에 있는 스레드를<br>실행 대기 상태로 만든다.|
|~~resume()~~|suspend() 메소드에 의해 일시 정지 상태에 있는 스레드를 실행 대기 상태로 만든다.<br> - Deprected (대신 notify(),notifyAll()사용)|
|sleep(long millis)<br>sleep(long millis,int nanos)|주어진 시간 동안 스레드를 일시 정지 상태로 만든다. 주어진 시간이 지나면 자동적으로<br>실행 대기 상태가 된다.|
|join()<br>join(long millis)<br>join(long millis,int nanos)|join() 메소드를 호출한 스레드는 일시 정지 상태가 된다. 실행 대기 상태로 가려면<br>join() 메소드를 멤버로 가지는 스레드가 종료되거나, 매개값으로 주어진 시간이 지나야 한다.|
|wait()<br>wait(long millis)<br>wait(long millis,int nanos)|동기화(synchronized)블록 내에서 스레드를 일시 정지 상태로 만든다.<br> 매개값으로 주어진 시간이 지나면 자동적으로 실행 대기 상태가 된다. <br>시간이 주어지지 않으면 notify(),notifyAll()메소드에 의해 실행 대기 상태로 갈수 있다.|
|~~suspend()~~|스레드를 일시 정지 상태로 만든다. resume() 메소드를 호출하면 다시 실행 대기 상태가 된다.<br> - Deprecated(대신 wait() 사용)|
|yield()|실행 중에 우선순위가 동일한 다른 스레드에게 실행을 양보하고 실행 대기 상태가 된다.|
|~~stop()~~|스레드를 즉시 종료시킨다. -Deprecated|

- wait(), notify(), notifyAll() 은 Object 클래스의 메소드
- 그 이외에는 모두 Thread 클래스의 메소드들이다.

### sleep() 메소드 : 주어진 시간동안 일시정지
- 실행 중인 스레드를 일정 시간 멈추게 하고 싶다면 Thread 클래스의 정적 메소드인 sleep()을 사용하면 된다.
- Thread.sleep() 메소드를 호출한 스레드는 주어진 시간동안 일시정지가 되고, 다시 실행 대기 상태로 돌아간다.

```java
try{
    Thread.sleep(1000);
}catch(InterruptedException e){
    //interrupt()메소드가 호출되면 실행
}
```
- 매개값에는 밀리세컨드 (1/1000) 단위로 시간을 주면 된다.  
    - 1초 -> 1000
- 일시정지 상태에서 주어진 시간이 되기 전에 interrupt() 메소드가 호출되면 InterruptedException이 발생

### yield() 메소드 : 다른 스레드에게 실행 양보
- 스레드가 처리하는 작업은 반복적인 실행을 위해 for문, while문을 포함하는 경우가 많다.
    - 이 반복문들이 무의미한 반복을 하는 경우가 있다. 
- **다른 스레드에게 실행을 양보**하고 자신은 실행 대기 상태로 가는것이 전체 프로그램 성능에 도움이 된다.
- 이런 기능을 위해서 **yield() 메소드를 호출한 스레드는 실행 대기상태**로 돌아가고 <br>동일한 우선순위 또는 높은 우선순위를 갖는 다른 스레드가 실행 기회를 가질수 있도록 해준다.

```java
public void run(){
    while(true){
        if(work){
            System.out.println("ThreadA 작업 내용");
        }else{
            Thread.yield(); //조건문에 만족못할시 양보
        }
    }
}
```

### join() 메소드 : 다른 스레드의 종료를 기다림
- 스레드는 다른 스레드와 독립적으로 실행하는 것이 기본이다.
    - 다른 스레드가 종료될 때까지 **기다렸다가 실행**해야 하는 경우도 발생할수 있다.
    - ex:)계산작업을 하는 스레드가 모든 계산 작업을 마쳤을 때, 계산 결과 값을 받아 이용하는 경우
    - 이런경우를 위해서 **join()** 메소드를 사용한다.

### wait(), notify(), notifyAll() : 스레드 간 협업
- 경우에 따라서는 두 개의 스레드를 교대로 번갈아가며 실행해야 할 경우가 있다.
- 정확한 교대 작업이 필요할 경우 : 
    - 자신의 작업이 끝나면 상대방 스레드를 일시 정지상태에서 풀어주고, 자신은 일시정지상태로 만드는 것
- 이 방법의 **핵심은 공유 객체**에 있다.
    - 공유 객체는 두 스레드가 작업할 내용을 각각 동기화 메소드로 구분해 놓는다.
    - 한 스레드가 작업을 완료하면 notify() 메소드를 호출
        - 일시정지 상태에있는 다른 스레드를 실행 대기 상태로 만듦
    - 자신은 두 번 작업을 하지 않도록 wait() 메소드를 호출하여 일시 정지 상태로 돌아간다.
##### Thread 클래스가 아닌 Object 클래스에 선언된 메소드이므로 모든 공유 객체에서 호출이 가능하다.
- 동기화 메소드 또는 동기화 블록내에서만 사용이 가능하다.
- wait() : 다른 스레드로부터 신호(notify())가 올때까지 일시정지 상태로 만든다.
- wait(long timeout), wait(long timeout, int nanos)
    - notify()를 호출하지 않아도 지정된 시간이 지나면 스레드가 자동적으로 실행 대기상태가 된다.
- notify() : wait() 메소드에 의해 일시정지상태에있는 스레드중 하나를 실행 대기상태로 만듦
- notifyAll() : wait()에 의해 일시정지 상태에있는 모든 스레드를 실행 대기상태로 만듦

### stop 플래그, interrupt() 메소드 (스레드의 안전한 종료)
- 스레드는 자신의 run() 메소드가 모두 실행되면 자동적으로 종료된다.
- 경우에 따라서는 실행 중인 스레드를 즉시 종료할 필요가 있다.
    - ex:) 동영상을 끝까지 보지않고 사용자의 멈춤요구
- Thread의 stop()메소드는 deprecated 되었다. 
    - stop() 메소드로 갑자기 종료하게 되면 스레드가 사용중이던 자원들이 불안전한 상태로 남겨지기 때문
        - 자원이란: 파일, 네트워크 연결등을 말한다.
#### stop 플래그를 이용하는 방법
- 스레드는 run() 메소드가 끝나면 자동적으로 종료되므로, run() 메소드가 정상적으로 종료되도록 유도하는 것이 최선의 방법

```java
public class XXXThred extends Thread{
    private boolean stop;

    public void run(){
        while(!stop){ //stop이 true가 되면 run()이 종료된다.
            스레드가 반복 실행하는 코드;
        }
        //스레드가 사용한 자원 정리
    }
}
```

#### interrupt() 메소드를 이용하는 방법
- interrupt() 메소드는 스레드가 일시 정지 상태에 있을때 InterruptedException 예외를 발생시키는 역할을 한다.

```java
public class ThreadA{
    ThreadB threadB = new ThreadB();
    threadB.start();
    ...
    threadB.interrupt();// ThreadB가 sleep() 메소드로 일시 정지 상태가 될 때 ThreadB에서 
}                       //InterruptedException이 발생하여 예외처리(catch) 블록으로 이동한다.
                        //결국 ThreadB는 while문을 빠져나와 run()메소드를 정상종료하게 된다.
public class ThreadB extends Thread{
    @Override
    public void run(){
        try{
            while(true){
                Thread.sleep(1);//일시정지 
            }
        }catch(InterruptedException e){
        }
    //스레드가 사용한 자원 정리
    }
}
```
- 스레드가 일시 정지 상태가 되지않으면 interrupt() 메소드 호출은 아무 의미 없다.
    - 그래서 짧은 시간이나마 일시 정지시키기 위해 Thread.sleep(1)을 사용한 것
- **일시 정지를 만들지 않고도 interrupt() 호출 여부를 알수 있는 방법**
    - interrupt() 메소드가 호출되었다면 스레드의 interrupted()와 isInterrupted() 메소드는 true를 리턴한다.
    - boolean status = Thread.interrupted();
        - 정적 메소드로 현재 스레드가 interrupted 되었는지 확인
    - boolean status = objThread.isInterrupted();
        - 인스턴스 메소드로 현재스레드가 interrupted 되었는지 확인할때 사용

```java
public class ThreadEx extends Thread{
    public void run(){
        while(true){
            System.out.println("실행 중");
            if(Thread.interrupted()){ //interrupt() 메소드 호출되었으면 반복문 빠져나감-> run() 정상 종료
                break;
            }
        }
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}
```

## Daemon Thread (데몬 스레드)
---
- 데몬(daemon) 스레드는 주 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드이다.
- 주 스레드가 종료되면 데몬 스레드는 강제적으로 자동 종료된다.
    - 주 스레드의 보조 역할을 수행하므로 주 스레드가 종료되면 존재 의미가 없어지기 때문!
    - 이 점을 제외하면 데몬 스레드는 일반 스레드와 크게 차이가 없다.
- 데몬 스레드의 적용 ex:) 
    - 워드프로세서의 자동저장
    - 미디어 플레이어의 동영상 및 음악 재생
    - 가비지 컬렉터
    - 이 기능들은 주 스레드(워드프로세서,미디어플레이어,JVM)가 종료되면 같이 종료한다.
- 스레드를 데몬으로 만들기 위해서는 주 스레드가 데몬이 될 스레드의 setDaemon(true)를 호출해주면 된다.

```java
public static void main(String[] args){
    AutoSaveThread thread = new AutoSaveThread();
    thread.setDaemon(true); //데몬(보조 스레드)으로 만듬
    thread.start(); //start() 호출 전에 setDaemon(true) 호출해야함
}
```
- start() 메소드가 호출되고 나서 setDaemon(true)를 호출하면 IllegalThreadStateException이 발생!
    - start() 메소드 호출 전에 setDaemon(true)를 호출해야 한다.
- isDaemon() : 현재 실행중인 스레드가 데몬 스레드인지 구별하는 메소드
    - 리턴값이 true 일경우 데몬 스레드이다.


## ThreadGroup (스레드 그룹)
---
- **목적** : 관련된 스레드를 묶어서 관리하기 위함
- 스레드는 반드시 하나의 스레드 그룹에 포함된다.
    - 기본적으로 자신을 생성한 스레드와 같은 스레드 그룹에 속한다.
    - 작업 스레드의 대부분은 main 스레드가 생성하므로 기본적으로 main 스레드에 속한다.
### 스레드 그룹 이름 얻기

```java
ThreadGroup group = Thread.currentThread().getThreadGroup();
String groupName = group.getName();

//Thread의 정적 메소드인 getAllStackTraces()
// 프로세스 내에서 실행하는 모든 스레드의 대한 정보를 얻음
Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces(); 
```

### 스레드 그룹 생성

```java
ThreadGroup tg = new ThreadGroup(String name); //현재 스레드가 속한 그룹의 하위그룹으로 생성 & 이름 지정
ThreadGroup tg = new ThreadGroup(ThreadGroup parent, String name);//부모 그룹을 지정, & 이름 지정

//Thread 객체 생성시 생성자 매개값으로 스레드 그룹을 지정해주면된다. 
Thread t = new Thread(ThreadGroup group, Runnable target);
Thread t = new Thread(ThreadGroup group, Runnable target, String name);
Thread t = new Thread(Threadgroup group, Runnable target, String name, long stackSize);
Thread t = new THread(Thraedgroup group, String name);
//Runnable 타입의 target은 Runnable 구현 객체
//long 타입의 stackSize는 JVM이 이 스레드에 할당한 stack 크기이다.
```

### 스레드 그룹의 일괄 interrupt()
- Thread의 Group 이점
    - 그룹 내에 포함된 모든 스레드를 일괄 interrupt 할수 있다.
        - 스레드 그룹의 interrupt() 메소드는 포함된 모든 스레드의 interrupt() 메소드를 내부적으로 호출한다.
        - 개별 스레드에서 발생하는 InterruptedException에 대한 예외처리를 하지 않는다. -> 개별스레드로 예외처리 추천


## 작성 방법
- java.lang.Thread : 클래스를 이용하는 방법
- java.lang.Runnable : 인터페이스를 이용하는 방법 

1. Runnable 인터페이스를 상속(확장)한 클래스를 만든다.
    - Runnable 인터페이스를 상속받으면 run()메소드를 구현해야 한다.
2. 1에서 상속한 클래스 객체를 만든다. (Runnable 객체/ 실행가능한 객체)
3. 2에서 만든 객체를 가진 실행흐름(Thread) 객체를 만든다.
4. 쓰레드 실행 (start()메소드 사용)

### Thread 클래스 확장하기
- java.lang.Thread 클래스를 확장하는 방법
- Thread 클래스의 run() 메소드만 오버라이드해주면 된다.

```java
public class MyThread extends Thread{

    @Override
    public void run(){
        
        try{
                Thread.sleep(delay);
        }catch(InterruptedException e){

        }
    }
}
```
- Thread.sleep() : 
- Thread.currentThread().getName();

### Runnable 인터페이스 구현하기
- Runnable 인터페이스는 구현할 메소드가 run() 하나뿐인 함수형 인터페이스이다.
    - 따라서 람다식을 이용해 깔금하게 구현 가능

```java
public class MyRunnable implements Runnable{

    @Override
    public void run(){

    }try{
        Thread.sleep(delay);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}
}
```

### 실행
- 공통점 : 
    - Thread 클래스의 start() 메소드를 통해 실행
    - run() 메소드 구현
- 차이점 : 
    - Thread를 상속받은 클래스의 경우
        - 해당 객체에 start() 메소드를 직접 호출가능
    - Runnalbe 인터페이스를 구현한 클래스의 경우
        - Runnable형 인자를 받는 생성자를 통해 별도의 Thread 객체를 생성후 start() 메소드를 호출해야 한다.
        - Thread thread = new Thread(Runnable 구현 객체);
- **자바에서는 다중상속을 허용하지 않기 때문에, Thread 클래스를 확장하는 클래스는다른 클래스를 상속받을수 없다.**

## Critical Section(임계 구역)
- **critical section**
    - 스레드 실행 중에 다른 스레드로 제어가 넘어가면 문제를 일으킬수 있는 부분
    - 주로 공유 데이터를 사용하는 부분
### critical section의 **동기화**(**synchronization**)
> critical section이 실행되는 동안 다른 스레드가 공유 데이터를 사용할 수 없도록 만드는 것
- critical section의 동기화 방법

```java
synchronized (공유_객체) { //synchronized block
    //critical section//
}

// 메소드를 동기화 시키는 방법 


synchronized void transfer(int mount){}  //메소드 선언 제일 앞에 synchronized 키워드를 쓰면 됩니다.

```

## Thread의 상태를 나타내는 메소드
- 열거 타입 Thread.State의 열거값

|열거 상수|의미하는 스레드의 상태|
|:------|:---------|
|NEW|실행되기 전 상태|
|RUNNABLE|실행 가능 상태|
|WAITING|wait 메소드를 호출하고 있는 상태|
|TIMED_WAITING|sleep 메소드를 호출하고 있는상태|
|BLOCKED|다른 스레드의 동기화 블록이나 동기화 메소드가<br>끝나기를 기다리고 있는 상태|
|TERMINATED|실행을 마친 상태|

### busy_waiting

##### 은행원 알고리즘 & 세마포어 알고리즘 

