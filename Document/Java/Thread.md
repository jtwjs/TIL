# Thread(스레드)
>**Thread** : 프로그램의 실행 흐름<br>
> **CPU가 실행하기 위한 최소한의 실행단위**

![thread](https://user-images.githubusercontent.com/60641307/77727037-be395b00-703c-11ea-8a8c-05e499533421.png)

- 멀티스레드의 작동방식
    - 처음 자동으로 시작되는 메인 스레드 외에 다른 스레드는 생성 위치에 시작하여 끝이난다.
        - 프로그램은 이 모든 스레드가 끝나야 끝이 난다.
### 종류 
- Single Thread (싱글 스레드) : 스레드가 하나뿐인 프로그램
- Multi Thread (멀티 스레드) : 스레드가 둘 이상인 프로그램

### 특징
- 모든 Thread는 단독으로 실행 (FIFO)
- 자바는 멀티 쓰레드를 지원한다.
    - Multi Thread : 말 그대로 하나의 프로그램에서 **여러개의 실행흐름**을 만들고 실행할수 있다는 것
    - **사용하는 이유** : 외부와의 연계같이 대기 시간이 발생했을 떄 기다리는 동안 다른 일을 처리할수 있계 해서 **처리 속도를 빠르게 하기 위함**
    - 단,CPU코어 수가 적으면 쓰레드를 그 만큼 만들수 없기 때문에 드라마틱하게 빨라지지 않고, 처리하는 데이터 양이 적을 때에도 속도가 많이 빨라지지 않기 때문에 쓰레드를 적절한 경우에 사용하는 것이 좋다.
### sleep() 메소드
- Thread class에 있는 메소드로 그냥 시간이 경과되기만을 기다리는 메소드
    - 정적 메소드이기 때문에 Thread.sleep();으로 호출할수 있다. 
    - 단, 이 메소드는 InterruptedException(checked)이 발생하므로 Try-Catch로 체크를 해주어야한다.
    - 매개변수의 정수는  1000은 1초를 뜻함 ex:) sleep(1000); -> 1초

```java
class ThreadEx extends Thread{
    public void run(){
        //......//

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e{}//sleep()메소드가 발생하는 InterruptedException
    }
}
```

### notify() 메소드
- 다른 스레드로 신호를 보내는 메소드
### notifyalll() 메소드 
- 대기하고 있는 모든 스레드로 신호를 보내는 notifyAll() 메소드
### wait() 메소드
- 다른 스레드로부터 신호가 오기를 기다리는 메소드
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

