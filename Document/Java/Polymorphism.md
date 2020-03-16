# Polymorphism (다형성)
>같은 자료형에 여러가지 객체를 대입하여 다양한 결과를 얻어내는 성질<br>동일한 조작방법으로 메소드를 동작시키지만 실제 동작은 다른것을 의미
- 하나의 타입으로 다양한 실행 결과를 얻음
- 객체를 부품화하여 유지 보수를 용이

## 클래스와 다형성
**하나의 클래스가 다양한 동작 방법을 가지고 있는 것**
```java
class A{
    public String x(){return "x";}
}
class B extends A{
    public String x(){return "B.x()";}//Override
    public String y(){return "B.y()";}
}
class B2 extends A{
    public String x(){return "B2.x()";}
}
public class PolymorphismDemo1{
    public static void main(STring[] args){
        A obj = new B();//다형성
        A obj2 = new B2();//다형성
        obj.x();
        obj.y();//에러

        System.out.println(obj.x());
        System.out.println(obj2.x());
        
    }
}
}
```
>클래스 B는 메소드y를 가지고 있다. 그럼에도 불구하고 메소드 y가 마치 존재하지 않는 것처럼 실행되지 않고 있다. 즉 클래스 B의 데이터 형을 클래스 A로 하면 클래스 B는 **마치 클래스 A인것처럼 동작**하게 된다.

>**A처럼 동작은 하지만, 실제 실행은 B의 메소드(부모 메소드를 오버라이딩한 메소드)가 실행된다.**

1. **A에 존재하는 멤버만이 클래스 B의 멤버가 된다.**
2. **동시에 클래스 B에서 오버라이딩한 멤버의 동작방식은 그대로 유지한다.**

>서로 다른 클래스 B와 B2가 동일한 데이터 타입 A로 인스턴스화 되었다. 하지만 **두 인스턴스의 메소드 x를 호출한 결과는 서로 다르다. 이것이 상속과 오버라이딩 그리고 형변환을 이용한 다형성이다.**

## 인터페이스와 다형성
>**다형성의 세계에서는 인터페이스도 중요한 수단이다.** 특정한 인터페이스를 구현하고 있는 클래스가 있을 때 이 클래스의 데이터 타입으로 인터페이스를 지정할 수 있다.

```java
interface I{}
class C implements I{}
public class PolymorphismDemo2{
    public static void main(String[] args){
        I obj = new C();
    }
}
```
> 클래스 C의 **데이터 타입으로 인터페이스 I가 될수 있다** <br> 이것은 다중 상속이 지원되는 인터페이스의 특징과 결합해서 상속과 다른 양상의 효과를 만들어낸다.

```java
interface I2{
    public String A();
}
interface I3{
    public String B();
}
class D implements I2,I3{
    public String A(){
        return "A";
    }
    public String B(){
        return "B";
    }
}
public class PolymorphismDemo3{
    public static void main(String[] args){
        D obj = new D();
        I2 obj2 = new D();
        I3 obj3 = new D();

        obj.A();
        obj.B();

        obj2.A();
        //obj2.B(); //오류
//obj2의 데이터 타입이 인터페이스 I이기 때문이다.
        //obj3.A();// 오류
        obj3.B();
    }
}
```
> **인스턴스 obj2의 데이터 타입을 I2로 한다는 것은 인스턴스를 외부에서 제어할 수 있는 조작 장치를 인스턴스 I2의 멤버로 제한한다는 의미**가된다. 인터페이스 I2와 I3으로 인해서 하나의 클래스가 다양한 형태를 띄게 되는것이다.

## 다형성 구현 방법
>클래스의 상속이나 인터페이스를 **구현하는 자식 클래스에서 메소드를 재정의 오버라이딩**하고 **자식 클래스를 부모 타입으로** 업캐스팅한다. 그리고 **부모 타입의 객체에서 자식 멤버를 참조하여 다형성을 구현**한다.

![polymorphism](https://user-images.githubusercontent.com/60641307/75655061-665d3d80-5ca4-11ea-9c8f-9d8979ae42ce.jpg)

## instanceof 연산자
>**instanceof는 객체타입을 확인**하는데 사용된다.<br> 참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아보기 위해 instanceof 연산자를 사용한다.<br> 주로 조건문에 사용되며, **instanceof의 왼쪽에는 참조변수를 오른쪽에는 타입(클래스명)이 피연산자**로 위치한다. <br>그리고 연산의 결과로 boolean값인 true,false 중의 하나를 반환한다.<br>
>값이 null인 참조변수에 대해 instanceof 연산을 수행하면 false를 결과로 얻는다.

>**어떤 타입의 대한 instanceof 연산의 결과가 true라는 것은 검사한 타입으로 형변환이 가능하다는 것을 뜻한다.**
1. 인스턴스 멤버보다 참조변수가 사용할 수 있는 멤버수가 더 많으면 사용할 수없다.
2. 인스턴스 멤버보다 참조변수가 사용할 수 있는 멤버수가 적으면 사용할 수 있다.(같아도 O)
- 조상 참조변수 instanceof 자손 인스턴스 (무조건 O)
- Object o instanceof 자손 인스턴스(무조건 O)
- 빈 자손 Class를 만든다면 자손 참조변수 instanceof 조상 인스턴스(가능 O)
## Binding(바인딩)
>각종 값들이 확정되어 더이상 변경할 수 없는 구속(Bind) 상태가 되는것,
## Dynamic Binding (동적바인딩)
>프로그램의 실행되는 과정에서 바인딩
- 실행시간(Runtime)즉, 파일이 실행하는 시점에서 성격이 결정

## Static Binding (정적바인딩)
>원시 프로그램의 컴파일링 또는 링크 시에 확정되는 바인딩
- 컴파일(Compile)시간에 성격이 결정