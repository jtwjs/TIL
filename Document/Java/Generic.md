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

>제네릭 클래스(Generic class)에서는 타입을 변수로 표시한다. <br> **타입 매개변수(type parameter)** 라고 하며,타입 매개변수는 객체 생성시에 프로그래머에 의하여 결정된다.

## 타입 매개변수의 표기
- 제네릭 클래스는 여러개의 타입 매개변수를 가질 수 있으나 타입의 이름은 클래스 인터페이스 안에서 유일하여야 한다.
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

- 다이아몬드(<>) : 자바 SE 7버전부터는 제네릭 클래스의 생성자를 호출할 때, 타입 인수를 구체적으로 주지 않아도 된다. 컴파일러가 문맥에서 타입을 추축하기 때문이다.

```java
Box< String > Box = new Box<>(); 
//Box<String> strBox = new Box<String>();와같다.
```

- Raw 타입 : 타입 매개변수가 없는 제네릭 클래스의 이름

```java
Box< Integer > intBox = new Box<>();//기존 방식
Box rawBox = new Box();; //Raw 방식
```
>주의할 점은 처음부터 제네릭 클래스가 아니면 Raw 타입이라고 하지 않는다.<br>Raw 타입은 JDK5.0이전에는 제네릭이 없었기 떄문에 이전 코드와 호환성을 유지하기 위해 등장.<br>즉,타입을 주지 않으면 무조건 Object타입으로 간주하는 것이다.

## 제네릭 메소드
- 일반 클래스의 메소드에서도 타입 매개변수를 사용하여 "**제네릭 메소드**"를 정의할 수 있다.
- 제네릭 메소드에서의 타입 매개변수의 범위는 메소드 내부로 제한된다.

```java
public class Array{
...
    public static <T> T getLast(T[] a){ // 타입 매개변수(<T>)는 반드시
        return a[a.length-1];            //메소드의 수식자(public,static)와 
    }                                   // 반환형(T)사이에 위치되어야한다.
...
}
```

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