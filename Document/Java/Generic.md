# Generic Programming(제네릭 프로그래밍)
>작성한 **코드를 다양한 타입의 객체에 대해 재사용**하는 객체지향 기법이다.

## Generic(제네릭)
- 클래스를 **정의**할 때, 구체적인 타입(type)을 적지 않고 **변수 형태**로 적어 놓는 것이다.
- 클래스를 선언하여 **객체를 생성**할 때, **구체적인 타입을 기재**한다.
    - 즉,타입을 어떤 클래스 종류의 매개변수로 보는 것이다.

- 기존의 방법 : Object타입으로 객체를 받아서 다형성을 이용
    - 모든 객체가 Object클래스를 상속하므로 다양한 형태의 데이터를 담을 수 있기 때문이다.
```java
public class PreBox{
    private Object data;

    public void set(Object data){
        this.data = data;
    }
    
    public Object get(){
        return data;
/*단, get()메소드로 저장한 객체를 반환받을 때 
원하는 타입으로 캐스팅(Casting)해야 하는 번거로움이 있었다.*/
    }
}
```
- 제네릭 기법
```java
public class Box<T>{ //T는 타입을 의미
    private T data;

    public void set(T data){
        this.data = data;
    }

    public T get(){
        return data;
    }
}
//위의 클래스를 선언할 때, 아래와 같이 구체적인 타입을 기재하여 제네릭 클래스를 사용한다.
Box<String> strBox = new Box<String>();// String 타입만 저장한다.
Box<Integer> intBox =  new Box<Integer>();// Integer 타입만 저장한다.
```
## 장점
- **컴파일시 강한 타입 체크를 할 수 있다**.
    - 컴파일 시에 미리 타입을 강하게 체크해서 타입 에러를 사전에 방지
- **타입 변환(casting)을 제거한다.**
    - 불필요한 타입변환을 하게되면 프로그램 성능에 악영향을 미친다.

## 제네릭 타입(class<T>, interface<T>)
>제네릭 타입은을 파라미터로 가지는 클래스와 인터페이스를 말한다.<br>제네릭 타입은 클래스 또는 인터페이스 이름뒤에 "<>" 부호가 붙고, 사이에 타입 파라미터가 위치한다.<br>타입 파라미터는 객체 생성시에 프로그래머에 의하여 결정된다.

- 다이아몬드(<>) : 자바 SE 7버전부터는 제네릭 클래스의 생성자를 호출할 때, 타입 인수를 구체적으로 주지 않아도 된다.
- 컴파일러가 문맥에서 타입을 추축하기 때문이다.

## 타입 파라미터의 표기
>제네릭 클래스는 여러개의 타입 매개변수를 가질 수 있으나 타입의 이름은 클래스 인터페이스 안에서 유일하여야 한다.
- 관레에 의하여 타입의 이름은 "**하나의 대문자**"로 한다.
    - 대문자로 하는 이유는 변수의 이름과 타입의 이름을 구별할 수 있게 하기 위함


|Type Name| Type |
|:-----:|:-----|
|E|Element|
|K|Key|
|N|Number|
|T|Type|
|V|Value|
|S,U,V등|2,3,4번째 타입|


## 멀티 타입 파라미터(class<K,V,..>, interface<K,V,...>)
> 제네릭 타입은 두 개 이상의 멀티 타입 파라미터를 사용 할 수 있는데, 이 경우 각 각 타입 파라미터를 콤마로 구분한다.
- 자바7부터 타입 파라미터를 유추해서 자동으로 설정해줌 -> 간단히 작성 가능

```java
Box< String > Box = new Box<>(); 
//Box<String> strBox = new Box<String>();와같다.
```
- Raw 타입 : 타입 매개변수가 없는 제네릭 클래스의 이름

```java
Box< Integer > intBox = new Box<>();//기존 방식
Box rawBox = new Box(); //Raw 방식
```
>주의할 점은 처음부터 제네릭 클래스가 아니면 Raw 타입이라고 하지 않는다.<br>Raw 타입은 JDK5.0이전에는 제네릭이 없었기 떄문에 이전 코드와 호환성을 유지하기 위해 등장.<br>즉,타입을 주지 않으면 무조건 Object타입으로 간주하는 것이다.

## 제네릭 메소드
- 일반 클래스의 메소드에서도 타입 매개변수를 사용하여 "**제네릭 메소드**"를 정의할 수 있다.
- 제네릭 메소드에서의 타입 매개변수의 범위는 메소드 내부로 제한된다.

```java
public class Array{
...
    public static <T> T getLast(T[] a){ // 타입 파라미터(<T>)는 반드시
        return a[a.length-1];            //메소드의 수식자(public,static)와 
    }                                   // 반환형(T)사이에 위치되어야한다.
    ...
}
//제네릭 메소드는 두가지 방식으로 호출할수 있다.
리턴타입 변수 = <구체적인타입> 메소드명(매개값); //명시적으로 구체적 타입을 지정
Box<Integer> box = <Integer>boxing(100);    // 타입 파라미터를 명시적으로 Integer로 지정

리턴타입 변수 = 메소드명(매개값);               // 매개값을 보고 구체적 타입을 추정
Box<Integer> box = boxing(100);             //타입 파라미터를 Integer로 추정
```

## 제한된 타입 파라미터(<T extends 최상위타입>)
> 타입 파라미터에 지정되는 구체적인 타입을 제한할 필요가 종종 있다.<br> ex:) 숫자를 연산하는 제네릭 메소드는 매개값으로 Number 타입 또는 하위 클래스타입의 인스턴스만 가져야한다.

```java
//제한된 파라미터 선언 방법
public <T extends 상위타입> 리턴타입 메소드(매개변수,...){...}
//상위타입은 클래스뿐만 아니라 인터페이스도 가능.(인터페이스라고해서 implements를 사용하지않음)
//타입 파라미터에 지정되는 구체적인 타입은 상위타입이거나 상위 타입의 하위 또는 구현클래스만 가능
// 메소드의 중괄호{}안에서 타입 파라미터 변수로 사용 가능한것은 상위 타입의 멤버로 제한됨
```


## 와일드카드 타입(<?>,<? extends ...>,<? super ...>)
>코드에서 ?를 일반적으로 와일드카드(wildcard)라고 부른다.
제네릭 타입을 매개값이나 리턴타입으로 사용할 때 구체적인 타입 대신에 와일드 카드를 쓴다.
- 제네릭타입<?> : Unbounded Wildcards (제한없음)
    - 모든 클래스나 인터페이스 타입이 올수있음
- 제네릭타입<? extends 상위타입> : Upper Bounded Wildcards(상위클래스 제한)
    - 상위 타입이나 하위타입만 올수 있다.
- 제네릭타입<? super 하위타입> : Lower Bounded Wildcards(하위클래스 제한)
    - 하위 타입이나 상위타입이 올수 있다.
## 제네릭과 상속
>제네릭에서는 **타입 매개변수에 상속관계가 성립**한다.<br>ex:) Number를 타입 매개변수로 주어 객체를 생성했다면,Number의 자식 클래스인 Integer,Double,Float 객체도 모두 처리 할수 있다.

```java
public class Box<T>{
    private T data;

    public void set(T data){
        this.data = data;
    }

    public T get(){
        return data;
    }
}
Box<Number> box = new Box<Number>();//객체 생성시 구체적인 타입을 기재
box.add(new Integer(10));           //타입의 하위 클래스들도 모두 처리됨.
box.add(new Double(10.1));
box.add(new Float(0.0));
```

>타입 매개변수에서 상속관계가 성립하는 것과 어떤 타입 매개변수를 가진 제네릭 클래스에서 상속관계까 성립하는 것은 서로 다르다는 것이다.

![Generic ](https://user-images.githubusercontent.com/60641307/75867454-fee0f280-5e49-11ea-9d48-1091324fbbe2.png)

- 제네릭 클래스의 상속: 제네릭 클래스들 간의 상속도 일반 클래스처럼 extends와 implements 키워드를 사용하여 표시할 수 있다. 

```java
//컬렉션 클래스의 일부..
ArrayList<E> implements List<E>{...}
List<E> extends Collection<E>{...}
//즉, Collection <-List<String> <-ArrayList<String>
//순서로 부모<-자식 상속관계가 생긴다.
```

```java
abstract class info{
    public abstract int getLevel();
}
class EmployeeInfo extends Info{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank;}
    public int getLevel(){
        return this.rank;
    }
}
class Person<T extends Info>{//Info의 자식들만 T로 올수있다.
                            //class뿐아니라 interface도 가능
                            //info부분은 부모가 누구냐를 의미하는것
    public T info;
    Person(T info){ this.info = info; }
}
public class Main{
    public static void main(String[] args){
            Person p1 = new Person(new EmployeeInfO(1));//O
            Person<String> p2 = new Person<String>("부정");//X
    }
}
```
## 와일드 카드
- Wild card(와일드 카드) : 제네릭을 사용하는 코드에서 타입 매개변수를 기재하는 꺽쇠괄호 속 **물음표(?)로 표현**되며, 카드 게임에서 조커와 유사한 역할, **즉, 어떤 타입이던지 나타낼 수 있다.**
- 와일드 카드는 매개변수,필드,지역 변수의 타입을 나타내는 등 다양하게 사용
- **상한이 있는 와일드 카드** : 전체 타입이 아닌 일정한 상한이 있는 타입을 표시하는데 사용

```java
/*ex:)List<Integer>,List<Double>,List<Number>에만 적용되는 메소드를 작성하고 싶다면,
Intger,Double클래스 모두 Number클래스를 상속 받기 떄문에 아래와 같이 작성하면됨
List<Number>보다도 적용 대상을 넓힌 것. List<Number>는 타입 매개변수로 Number에
대해서만 매치되지만 아래는 Number의 자식클래스까지도 타입 매개변수로 매치되기 때문*/
public static void exMethod(List<? extends Number> list){...}
```

- **하한이 있는 와일드카드** : 특정한 타입을 가진 모든 객체에 대해 작동할 때 사용되는 카드

```java
/*ex:)Integer 객체를 가질 수 있는 모든 객체를 리스트에 추가하는 메소드를 작성 한다면.
List<Integer>,List<Number>,List<Object>와 같은 integer값을 가지고 있는 
모든 객체에 대하여 해당 메소드를 적용시킬 수 있다.*/
public static void addNumber(List<? super Integer> list){
    for(int i = 1;i<=10;i++){
        list.add(i);
    }
}
```

- **한도가 없는 와일드 카드** : 모든 타입에 매치되는 와일드 카드로, 단순히 <?>로 표현된다.<br>즉,List<?>라고 코드를 작성하면 모든 타입의 리스트를 사용하게 되는것<br>List<?>와 List<Object>는 혼동할 수 있으나 차이가 있다.

```java
public static void printList(List<Object> list){
    for(Object element : list){
        System.out.println(element + ",");
    }
    System.out.println();
//위의 경우 printlIst()메소드는 Obejct객체의 리스트(List<Object>)만 출력할 수 있다.
//그 이유는 List<Integer>,List<String>,List<Double>와 같은 클래스들은
//List<Object>의 자식이 아니기 떄문...
//타입 매개변수간의 상속 관계가 성립한 것이지 클래스간의 상속관계는 성립되지 않았다.
}
//모든 타입에 매치되는 리스트를 매개변수로 받을 수 있는 코드
public static void printList(List<?> list){
    for(Object element : list){
        System.out.println(element + ",");
    }
    System.out.println();
}
```