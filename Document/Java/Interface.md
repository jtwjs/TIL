# Interface (인터페이스)
1. 추상메소드와 상수만을 멤버로 가질 수 있다.
    - 추상클래스보다 추상화 정도가 높다.
    - 추상클래스는 추상메소드 외에 멤버 변수나 일반 메소드를 가질수 있지만 인터페이스는 반드시 사전에 정의된 추상 메소드나 상수만을 가질수 있다.
2. 인스턴스를 생성할 수 없고, 클래스 작성에 도움을 줄 목적으로 사용된다.
3. 미리 정해진 규칙에 맞게 구현하도록 표준을 제시하는데 사용
4. 유연한 설계가 가능하고 유지보수가 쉽다.
5. 다중상속을 구현하게 해주는 고급기술

## 인터페이스 선언

```java
interface 인터페이스명 {
    //상수
    타입 상수명 = 값;

    //추상 메소드
    타입 메소드명(매개변수,···);

    //디폴트 메소드
    default 타입 메소드명(매개변수,···){···}

    //정적 메소드
    static 타입 메소드명(매개변수){···}
}
```
1. **Constant Field(상수 필드)**
>인터페이스는 필드 선언하면 자동으로 상수 선언(public static final)이된다.<br>상수 선언할 때에는 반드시 초기값을 대입해야 한다.
2. **Abstract Method(추상 메소드)**
>객체가 가지고 있는 메소드를 설명한 것으로 호출할 때 어떤 매개값이 필요하고,리턴타입이 무엇인지만 알려준다.(메소드 시그니쳐만 기록)<br>실제 실행부는 객체(구현 객체)가 가지고 있다.<br>인터페이스에 선언된 추상 메소드는 모두 public abstract의 특성을 갖는다.(생략 가능)
3. **Default Method(디폴트 메소드)**
>디폴트 메소드는 인터페이스에 선언되지만 사실은 객체(구현 객체)가 가지고 있는 인스턴스 메소드라고 생각해야한다.<br>자바 8에서 디폴트 메소드를 허용한 이유는 기존 인터페이스를 확장해서 새로운 기능을 추가하기 위해서이다.<br>디폴트 메소드는 자동으로 public특성을 갖기 때문에 public을 생략가능
### need for a Default Method
>기존 인터페이스의 이름과 추상 메소드의 변경 없이 디폴트 메소드만 추가할 수 있기 때문에 이전에 개발한 구현 클래스를 그대로 사용할 수 있으면서 새롭게 개발하는 클래스는 디폴트 메소드를 활용할수 있다.
### inheritnace of interface with default method
- 디폴트 메소드를 단순히 상속만 받는다.
- 디폴트 메소드를 재정의(Override)해서 실행 내용을 변경한다.
- 디폴트 메소드를 추상 메소드로 재선언한다.

```java
public interface Parentinterface {
    public default void method2(){/*실행문*/}
}

public interface ChildInterface1 extends parentInterface {
    @Override
    public void method2(); // 추상 메소드 재선언
}
    
```


4. **Static Method(정적 메소드)**
>디폴트 메소드와는 달리 객체가 없어도 인터페이스만으로 호출이 가능하다. 자바 8부터 작성 가능<br>정적 메소드는 자동으로 public특성을 갖기 때문에 public을 생략가능

## 인터페이스 구현(implements)
>개발 코드가 인터페이스 메소드를 호출하면 인터페이스는 객체의 메소드를 호출한다.<br>객체는 인터페이스에서 정의된 추상 메소드와 동일한 메소드 이름,매개 타입,리턴 타입을 가진 실체 메소드를 가지고 있어야한다.<br> 이러한 객체를 인터페이스의 구현(implement)객체라고 하고, 구현 객체를 생성하는 클래스를 구현 클래스라고 한다.
- 인터페이스에 정의된 추상메서드를 완성해야한다.
- 클래스는 다중상속이 안되지만 인터페이스는 다중구현 가능
- 문법: 
    
```java
public interface X{
    int total(); //추상메서드 (구현부 X)
    //교체 할수있는 필수 조건  
}

public class B implements X{//교체 가능한 부품
    public int total(){
        return 26;
    }
}

public class A{
    private X x ;
    public void setX(X x){
        this.x = x;
    }
    public void print(){
        int total = x.total();
        System.out.prinf("Total is %d \n",total);
    }
}

public class main{}
public static void main(String[] args){
    A a = new A();
    B b = new B();
    a.setX(b); //A와B 결합 
    a.print();//출력 값 Total is 26
}
}
```
### 인터페이스 구현 시 주의할 점
> 1. 인터페이스의 메소드는 **모두 추상 메소드** 이기 때문에 abstract이여야한다.(생략가능)

> 2. 인터페이스 메소드의 접근제한자는 모두 **public**이어야한다. 단 생략가능(인터페이스의 기본 접근제한자는 public이기 때문)

> 3. 인터페이스를 구현하는 클래스의 메소드는 **public 키워드를 명시적**으로 써주어야한다.(클래스의 접근 제한자는 안쓰면 default이기 때문이다.)
        - 오버라이딩하는 자식 클래스의 메소드는 부모 클래스 메소드의 접근제한자보다 제한적일수 없다. (같거나 더넓은 범위는 O)

> 4. 인터페이스의 레퍼런스는 인터페이스를 구현한 클래스의 인스턴스를 참조할 수 있다.
  
> 5. **인터페이스의 필드는 모두 상수**

> 6. 클래스의 다중 상속은 허가하지 않지만, **클래스가 여러 인터페이스를 구현(implements)할 수 있으며 인터페이스는 다른 인터페이스의 다중 상속(extends)는 허가**한다.(복잡도가 그리 증가하지 않기때문)

> 7. 인터페이스를 구현하는 클래스의 메서드에서 **Checked Exception**에 대해 **throws Exception**하는 경우, 메소드의 시그니처는 인터페이스와 같아야 하므로 **인터페이스의 해당 메소드에 throws Exception 추가**해주어야한다.
   
> 8. 인터페이스에 선언된 추상 메소드에 대응하는 **실체 메소드를 구현 클래스가 작성하지 않으면 구현 클래스는 자동적으로 추상 클래스**가 된다. 그렇기 때문에 **클래스 선언부에 abstract 키워드를 추가**해야한다.
### 익명 구현 객체
>구현 클래스를 만들어 사용하는 것이 일반적이고, 클래스를 재사용할 수 있기 때문에 편리하지만.<br> 일회성의 구현 객체를 만들기 위해 소스 파일을 만들고 클래스를 선언하는 것은 비효율 적이다.<br>자바는 UI 프로그래밍에서 이벤트를 처리하기 위해, 그리고 임시 작업 스레드를 만들기 위해 익명 구현 객체를 많이 활용한다. 자바 8에서 지원하는 람다식은 인터페이스의 익명 구현 객체를 만들기 때문에 익명 구현 객체의 코드 패턴을 잘익혀두자

```java
interface var = new interface() {
        //인터페이스에 선언된 추상 메소드의 실체 메소드 선언
}; //하나의 실행문이므로 끝에는 세미콜론(;)를 반드시 붙여야한다.
```
>new 연산자 뒤에는 클래스 이름이 와야 하는데, 이름이 없다.<br> 인터페이스(){}는 인터페이스를 구현해서 중괄호 {}와 같이 클래스를 선언하라는 뜻이고<br> new 연산자는 이렇게 선언된 클래스를 객체로 생성한다.<br>중괄호{}에는 인터페이스에 선언된 모든 추상 메소드들의 실체 메소드를 작성해야 한다.<br>추가적으로 필드와 메소드를 선언할 수 있지만, 익명 객체 안에서만 사용할수 있고 인터페이스 변수로 접근할 수 없다.

```java
public class RemoteControlExample{
    public static void main(String[] args){
        remoteControl rc = new RemoteContro(){  //인터페이스에 선언된 모든 추상 메소드들의 실체 메소드를 작성
            public void turnOn() { /*실행문*/}
            public void turnOff(){ /*실행문*/}
            public void setVolume(int volume) { /*실행문*/}
        };
    }
}
```

## 인터페이스의 장점 :유연한 개발이 가능
    - A는 B의 method만 호출하면 된다.
    - A는 C의 존재와 내용을 몰라도 B를 통해 기능을 사용할수 있다.
    - C의 변경이 A에 영향을 미치지 않는다.
    - C의 핵심적인 기능을 자유롭게 변경할 수 있다.
>A(class)->B(interface)->C(interface를 구현한 클래스)

## [번외] 문자열을 읽어서 새로운 객체 만들기 
```java
public class main{
    public static void main(String[] args){
        FileinputStream fis = new FileInputStream("파일 경로");
        //ex:) 파일: setting.txt 파일경로: 루트에서부터 상태적인경로 
        //ex:) src/패키이름/파일이름
        //ex:) 파일 내용: 패키지명 포함해서 클래스 이름
        //ex:) 파일 내용: 패키지명.클래스이름
        Scanner sc = new Scanner(fis);
        String className = sc.nextLine();
        sc.close();
        fis.close();

        Class clazz = Class.forName(className);
        A a =new A();
        X x = (X)clazz.newInstance();
        a.setX(x);
        
        a.print();
    }
}
```
## 인터페이스의 상속
- 인터페이스도 다른 인터페이스를 상속할 수 있다.
- 인터페이스 상속은 클래스와는 달리 다중 상속을 허용
- 인터페이스 상속도 extends 키워드를 쓴다.
- 하위 인터페이스를 구현하는 클래스는 하위 인터페이스의 메소드뿐만 아니라 <br>상위 인터페이스의 모든 추상 메소드에 대한 실체 메소드를 가지고있어야한다.
-
```java
public interface 하위인터페이스 extends 상위인터페이스1, 상위인터페이스2{···}

public class Ex{
    public static void main(String[] args){
    하위인터페이스 변수 = new 구현클래스(···);
    상위인터페이스1 변수 = new 구현클래스(···);
    상위인터페이스2 변수 = new 구현클래스(···);
    }
    /*구현 클래스로부터 객체를 생성하고나서  하위 및 상위 인터페이스 타입으로 변환이 가능하다.*/
}

```

