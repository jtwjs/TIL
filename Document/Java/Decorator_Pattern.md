# Decorator Pattern(데코레이터 패턴)
>**객체의 결합**을 통해 **기능을 동적으로 유연하게 확장** 할수 있게 해주는 패턴<br> 즉, 기본 기능에 추가할 수 있는 기능의 종류가 많은 경우에 **각 추가 기능을 Decorator 클래스로 정의** 한 후<Br> 필요한 Decorator 객체를 조합함으로써 **추가 기능의 조합을 설계**하는 방식이다.
- Ex:)기본 도로 표시 기능에 차선표시,교통량표시,교차로표시,단속카메라표시의 4가지 추가 기능이 있을 때 추가 기능의 모든 조합은 15가지가 된다.
- -> 데코레이션 패턴을 이용하여 필요 추가 기능의 조합을 동적으로 생성할 수 있다.

![decorator-pattern](https://user-images.githubusercontent.com/60641307/77215279-95a1f480-6b56-11ea-93f0-127c0d6fb139.png)

>'구조(Structural )패턴'의 하나 
- 기본 기능에 추가할 수 있는 많은 종류의 부가 기능에서 파생되는 다양한 조합을 동적으로 구현할 수 있는 패턴이다.
- 역할이 수행하는 작업
    - Component
        - 기본 기능을 뜻하는 ConcreteComponent와 추가 기능을 뜻하는 Decorator의 공통 기능을 정의
        - 즉,클라이언트는 Component를 통해 실체 객체를 사용함 
    - Concrete Component
        - 기본 기능을 구현하는 클래스
    - Decorator
        - 많은 수가 존재하는 구체적인 Decorator의 공통 기능을 제공
    - ConcreteDecoratorA, ConcreteDecoratorB
        - Decorator의 하위 클래스로 기본 기능에 추가되는 개별적인 기능을 뜻함
        - ConcreteDecorator 클래스는 ConcreteComponent 객체에 대한 참조가 필요한데<br>이는 Decorator 클래스에서 Component 클래스로의 '합성(Composition)관계'를 통해 표현됨

### Ex:) 도로 표시 방법 조합하기
- 내비게이션 SW에서 도로를 표시하는 기능
    - 도로를 간단한 선으로 표시하는 기능(기본 기능)
     -내비게이션 SW에 따라 도로의 차선을 표시하는 기능(추가 기능)

```java
//기본 도로 표시 클래스
public class RoadDisplay{
    public void draw() { System.out.println("기본 도로 표시");}
}

//기본 도로 표시 + 차선 표시 클래스
public class RoadDisplaywithLine extends RoadDisplay{
    public void draw(){
        super.draw();//상위 클래스, 즉 RoadDisplay 클래스의
                     // draw 메서드를 호출
        drawLane(); //추가적으로 차선 표시
    }
    private void drawLane(){System.out.println("차선표시") }
}

public class Client{
    public static void main(String[] args){
        RoadDisplay = new RoadDisplay();
        road.draw(); //기본 도로만 표시
    
        RoadDisplay roadWithLane = new RoadDisplayWithLane();
        roadWithLane.draw(); // 기본 도로 표시 + 차선표시
    }
}
```
- RoadDisplay 클래스에는 기본 도로 표시 기능을 실행하기 위한 draw 메소드를 구현한다.
- RoadDisplayWitLane 클래스 에는 차선 표시 기능을 추가하기 위해 상속받은 draw 메소드를 오버라이드한다.
    - 기본 도로 표시 기능: 상위클래스(RoadDisplay)의 draw 메소드 호출
    - 차선 표시 기능: 자신의 drawLane 메소드 호출

### 문제점
1. 또 다른 도로 표시 기능을 추가로 구현하는 경우
>ex:) 기본 도로 표시에 교통량을 표시하고 싶다면?<br>-새로운 클래스를 만들어 상속받고 오버라이딩하는 작업 반복
2. 여러 가지 추가 기능을 조합해야 하는 경우
>ex:) 기본 도로 표시에 차선 표시 기능과 교통량 표시 기능을 함꼐 제공하고 싶다면?<br>-각 조합별로 여러개의 하위 클래스를 구현해야한다. <br>즉, 다양한 기능의 조합을 고려해야 하는 경우 **상속을 통한 기능의 확장은 각 기능별로 클래스를 추가 해야 한다**는 단점이 있다.

### 해결책
>문제를 해결하기 위해서는 **각 추가 기능별로 개별적인 클래스를 설계하고 기능을 조합할 때 각 클래스의 객체 조합을 이용**하면 된다.

![decorator-solution](https://user-images.githubusercontent.com/60641307/77216095-5a55f480-6b5b-11ea-85be-e8d1f3751812.png)

- 도로를 표시하는 기본 기능만 필요한 경우 RoadDisplay 객체를 이용한다.
- 차선을 표시하는 추가 기능도 필요한 경우 RoadDisplay 객체와 OaneDecorator 객체를 이용한다.
    - LanDecorator에서는 차선 표시 기능만 직접 제공:drawLane()
    - 도로 표시 기능은 RoadDisplay 클래스의 draw 메소드를 호출(super.draw())
        - (DisplayDecorator 클래스에서 Display 클래스로의 합성(Composition)관계를 통해 RoadDisplay 객체에 대한 참조)

```java
//Display 클래스
public abstract class Display{public abstract void drow();}

//RoadDisplay 클래스 (기본도로 표시 클래스)
public class RoadDisplay extends Display{
    @Override
    public void draw() {System.out.println("기본 도로 표시")}
}

//DisplayDecorator 클래스
//(다양한 추가 기능에 대한 공통 클래스)
public abstract class DisplayDecorator extends Display{
    private Display decoratedDisplay{
    //합성관계를 통해 RoadDisplay 객체에 대한 참조
    public DisplayDecorator(Display decoratedDisplay){
        this.decoratedDisplay = decoratedDisplay;
    }
    @Override
    public void draw() { decoratedDisplay.draw();}
    }
}

//LandDecorator,TrafficDecorator 클래스
//1. 차선 표시를 추가하는 클래스
public class LaneDecorator extends DisplayDecorator{
    //기존 표시 클래스의 설정
    public LaneDecorator(Display decoratedDisplay){
        super(decoratedDisplay);
        }
    @Override
    public void draw(){
        super.draw();//설정된 기존 표시 기능을 수행
        drawLane();//추가적으로 차선을 표시
        }
    //차선 표시 기능만 직접 제공
    private void drawLane(){
        System.out.println("\t차선 표시");
        }
    }

//교통량 표시를 추가하는 클래스
public class TrafficDecorator extends DisplayDecorator{
    //기존 표시 클래스의 설정
    public TrafficDecorator(Display decoratedDisplay){
        super(decoratedDisplay);
    }
    @Override
    public void draw(){
        super.draw();//설정된 기존 표시 기능을 수행
        drawTraffic();//추가적으로 교통량을 표시
    }
    //교통량 표시 기능만 직접 제공
    private void drawTraffic(){
        System.out.println("\t교통량 표시");
    }
}

//Client 에서의 사용
public class Client{
    public static void main(String[] args){
        Display road = new RoadDisplay();
        road.draw();//기본 도로 표시
        Display roadWithLane = new LaneDecorator(new RoadDisplay()); //기본 도로 표시 + 차선 표시
        DIsplay roadWithTraffic = new TrafficDecorator(new RoadDisplay()); //기본 도로 표시 + 교통량 표시
    }
}
```
- 각 road,raodWithLane,roadWithTraffic 객체의 접근이 모두 Display 클래스를 통해 이루어진다.
- 즉, 어떤 기능을 추가하느냐에 관계없이 Client 클래스는 동일한 Display 클래스만을 통해 **일관성 있는 방식**으로 도로 정보를 표시할수 있다.
- 이렇게 Decorator 패턴을 이용하면 추가 기능 조합별로 별도의 클래스를 구현하는 대신 각 추가 기능에 해당하는 클래스의 객체를 조합해 추가 기능의 조합을 구현할수 있게 된다.

![decorator-solution2](https://user-images.githubusercontent.com/60641307/77216806-b1aa9380-6b60-11ea-9f0d-856efb929335.png)

### 추가 EX:)

```java
//기본도로 표시+차선 표시+교통량 표시
public class Client{
    public static void mian(String[] args){
    //기본도로 표시+차선 표시+교통량 표시 
    Display roadWithLaneAndTraffic = 
    new TrafficDecorator(//3
        new LaneDecorator(//2
            new RoadDisplay() ) );//1
    roadWithLaneAndTraffic.draw();
//1.가장먼저생성된 RoadDisplay 객체의 draw 메소드 실행
//2.첫번째 추가 기능인 LaneDecorator 클래스의 drawLane 메소드 실행
//3.두번째 추가 기능인 TrafficDecorator 클래스의 drawTraffic 메소드 실행
    }
}
```

```java
//교차로를 표시하는 추가기능을 지원하면서 기존의 다른 추가기능(차선 표시와 교통량 표시)과의 조합을 지원
//CrossingDecorator 클래스
public class CrossingDecorator extends DisplayDecorator{
public crossingDecorator(Display decoratedDisplay){
    super(decoratedDisplay);
    @Override
    public void draw(){
        super.draw();//설정된 기존 표시 기능을 수행
        drawCrossing(); 추가적으로 교차로를 표시
    }
//교차로 표시 기능만 직접 제공
private void drawCrossing(){ System.out.println("\t교차로 표시");}
}
}

public class client{
    public static void main(String[] args){
    //기본도로+차선+교통량+교차로 표시
    Display roadWithCrossingLaneAndTraffic =
    new LaneDecorator(//4
        new TrafficDecorator(//3
            new CrossingDecorator(//2
                new RoadDisplay() ) ) ) );//1

    roadWithCrossingLaneAndTraffic.draw();
} 
```
- CrossingDecorator를 DisplayDecorator의 하위클래스로 설계한다.
    - CrossingDecorator의 draw 메소드가 호출되면 우선 상위 클래스(DisplayDecorator)의 draw 메소드를 호출한 후 CrossingDecorator의 drawCrossing 메소드를 호출한다.
#### 구조(Structural) 패턴
- 클래스나 객체를 조합해 더 큰 구조를 만드는 패턴
- 예를 들어 서로 다른 인터페이스를 지닌 2개의 객체를 묶어 단일 인터페이스를 제공하거나 객체들을 서로 묶어 새로운 기능을 제공하는 패턴이다.
#### 합성(Composition) 관계
- 생성자에서 필드에 대한 객체를 생성하는 경우
- 전체 객체의 라이프타임과 부분 객체의 라이프타임은 의존적이다.
- 즉, 전체 객체가 없어지면 부분 객체도 없어진다.
