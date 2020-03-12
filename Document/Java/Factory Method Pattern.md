# Factory Method Pattern (팩토리 메소드 패턴)
>객체를 만들어내는 부분을 자식클래스에 위임하는 패턴<br>즉,**new**키워드를 호출하는 부분을 자식 클래스에 위임하는 것<br>팩토리 메소드 패턴은 **객체를 만들어 내는 공장(Factory 객체)를 만드는 패턴**이라 이해하면 된다.

![패토리](https://user-images.githubusercontent.com/60641307/75757077-097d8800-5d75-11ea-9ce0-7a99ec83ca3a.png)

## 장점
- 생설 할 클래스를 미리 알지 못해도 팩토리 클래스가 객체 생성 담당
- 객체의 자료형이 하위클래스에 의해서 결정->확장 용이성
- 동일한 형태로 프로그래밍 가능
- 확장성 있는 전체 프로젝트 구성 가능
- 객체가 늘어날 때 마다 하위클래스 재정의로 인한 불필요한 많은 클래스 생성 가능성

# Ex
- Robot

```java
public abstract class Robot{
    public abstract String getName();
}
public class SuperRobot extends Robot{
    @Override
    public String getName(){
        return "SuperRobot";
    }
}
public class PowerRobot extends Robot{
    @Override
    public String getName(){
        return "PowerRobot";
    }
}
```

- RobotFactory
```java
public abstract class RobotFactory{
    abstract Robot createRobot(String name);
}

public class SuperRobotFactory extends RobotFactory {
//1. 기본 팩토리 클래스를 상속 받아 실제 로직을 구현한 팩토리 방법
    @Override
    Robot createRobot(String name){
        switch(name){
            case "super" : return new SuperRobot();
            case "power" : return new PowerRObot();
        }
    }
}
public class ModifiedSuperRobotFactory extends RobotFactory{
    //2. 로봇 클래스의 이름을 String 인자로 받아서 직접 인스턴스를 만드는방법
    @Override
    Robot createRobot(String name){
        try{
            Class<?> cls = Class.forName(name);
            Object obj = cls.newInstance();
            return (Robot)obj;
        }catch (Exception e){
            return null;
        }
    }
}
```
- main
```java
public class FactoryMain{
    public static void main(String[] args){

        RobotFactory rf = new SuperRobotFactory();
        Robot r = rf.createRobot("super");
        Robot r2= rf.createRobot("power");

        System.out.println(r.getName());
        System.out.println(r2.getName());

        RobotFactory mrf = new ModifiedSuperRobotFactory();
        Robot r3 = mrf.createRobot("pattern.factory.SuperRobot");
        Robot r4 = mrf.createRobot("pattern.factory.PowerRobot");

        System.out.println(r3.getName());
        System.out.println(r4.getName());
    }
}
```
>Main클래스에 new 키워드가 없다. ->객체 생성을 팩토리 클래스에 위임한 결과