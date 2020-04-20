## 람다식(Lamdba Expressions)
>수학자 알론조(Alonzo Chruch)가 발표한 람다 계산법에서 사용된 식,이를 제자 존 매카시(John Macarthy)가 프로그래밍 언어에 도입함
- 익명함수(anonymous function)을 생성하기 위한 식으로 객체 지향 언어보다 함수 지향 언어에 가깝다. 
- 람다 형태는 매개변수를 가진 코드 블록이지만, 런타임 시에는 익명 구현 객체(추상메소드를 한개 포함한)를 생성한다.
    - ``` 람다식 -> 매개변수를 가진 코드블록 -> 익명 구현 객체```
- 람다식은 기존의 자바 문법보다 쉽게 함수를 표현할수 있다.
- **목적**
    - 인터페이스가 가지고 있는 메소드를 간편하게 즉흥적으로 구현해서 사용하는 것

### 람다식 기본문법
- ``` (타입 매개변수, ···) -> {실행문; ···} ```
- (타입 매개변수,···)
    - 오른쪽 중괄호{} 블록을 실행하기 위해 필요한 값을 제공하는 역할을 한다. 
- -> 
    - 매개 변수를 이용해서 중괄호{}를 실행한다는 뜻으로 해석

    ```java
    //int 매개변수 a의 값을 콘솔에 출력을 람다식을 이용한 식 
    (int a) -> { System.out.println(a); }

    //매개변수 타입은 런타임 시에 대입되는 값에 따라 자동으로 인식되서 일반적으로 언급 X
    (a) -> { System.out.println(a); }

    //하나의 매개 변수만 있다면 괄호()를 생략,하나의 실행문만 있다면 중괄호{}도 생략
    a -> System.opt.println(a);

    //만약 매개변수가 없다면 람다식에서 매개변수자리가 없어지므로 빈괄호()를 반드시 사용
    () -> {실행문; ···} 

    //중괄호 {}를 실행하고 결과값을 리턴해야 한다면 
    (x,y) -> {return x+y; };

    //중괄호 {}에 return문만 있을 경우, 람다식에서는 return문을 키워드 사용 X
    (x,y) -> x+y
    ```
### 타겟 타입과 함수적 인터페이스
``` 인터페이스 변수 = 람다식; ```
- 람다식은 인터페이스 변수에 대입된다. -> 인터페이스의 익명 구현객체를 생성
- 인터페이스는 직접 객체화할 수 없기에 구현 클래스 필요
    - 람다식은 익명 구현 클래스를 생성하고 객체화함!
- **타겟 타입(target type)**
    - 람다식은 대입될 인터페이스의 종류에 따라 작성방법이 달라지기 땜에 람다식이 대입될 인터페이스를 타겟타입이라 한다.


#### 함수적 인터페이스(@FunctionalInterface)
>두개 이상의 추상메소드가 선언된 인터페이스는 람다식을 이용해서 구현객체를 생성할 수 없다.
- **함수적 인터페이스(Functional Interface)**
    - 하나의 추상 메소드가 선언된 인터페이스
- **@FunctionalInterface** [선택사항]
    - 함수적 인터페이스 작성시 두개 이상의 추상메소드가 선언되지 않도록 **컴파일러가 체킹**해주는 기능
    ```
    @FunctionalInterface
    public interface MyFunctionalInerface { 
        public void method();
        public void othermethod(); // 컴파일오류 
    }
    ```
#### 매개 변수와 리턴값이 없는 람다식
```java
@FunctionalInterface
public interface MyFunctionalInerface {
    public void method();
}
//람다식에 매개변수가 없는이유 -> method()가 매개변수를 가지지않아서
MyFunctionalInterface fi = () -> { ··· }

//람다식이 대입된 인터페이스의 참조 변수는 다음 과같이 호출 가능
fi.method(); 
//method() 호출은 람다식의 중괄호 {}를 실행 
```

#### 매개 변수가 있는 람다식
```java
@FunctionalInterface
public interface MyFunctionalInterface {
    public void method(int x);
}
//람다식에서 매개변수가 한개인 이유는 method()가 매개변수를 하나만 가져서
MyFunctionalInterface fi = (x) -> {···} 또는 x ->{ ··· }

//매개변수가 있는 람다식이 대입된 인터페이스 참조 변수는 다음과 같이 호출
fi.method(5);

```

#### 리턴값이 있는 람다식
```java
@FunctionalInterface
public interface MyFunctionalInterface {
    public int method(int x, int y);
}
//람다식에서 매개변수가 두개인 이유는 method()가 매개변수를 두개 가지고있어서다.
//그리고 method()가 리턴 타입이 있기에 중괄호 {}에는 return문이 있어야함
MyFunctionalInterface fi = (x,y) -> {···; return 값;}

// 중괄호{} 에 return문만 있는경우
MyFunctionalInterface fi = (x,y) -> { return x+y; }
-> MyFunctionalInterface fi = (x,y) -> x+y;

// return문만 있고 return문 뒤에 연산식이나 메소드 호출이 오는경우
MyFunctionalInterface fi = (x,y) -> { return sum(x,y); }
-> MyFunctionalInterface fi = (x,y) -> sum(x,y);

//매개값으로 2와5를 주면 람다식의 x변수에 2,y변수에 5가 대입되고 x와y는 중괄호{}에 사용됨
int result = fi.method(2,5); 
```
---
### 클래스 멤버와 로컬 변수 사용
- 람다식의 실행 블록에는 클래스의 멤버(필드,메소드)및 로컬 변수를 사용할 수 있다.
- 클래스의 멤버는 제약 사항 없이 사용 가능하지만,로컬 변수는 제약사항이 따른다.
#### 클래스의 멤버 사용
>람다식 실행 블록에는 클래스의 멤버인 필드와 메소드를 제약 사항 없이 사용할 수 있다.
- **람다식에서 this는 람다식을 실행한 객체의 참조이다**.
#### 로컬 변수 사용
>메소드의 매개변수 또는 로컬 변수를 사용하면 이 두 변수는 final 특성을 가져야 한다.
#### 표준 API의 함수적 인터페이스
>자바에서 제공되는 표준 API에서 한 개의 추상 메소드를 가지는 인터페이스들은 <br>모두 람다식을 이용해서 익명 구현 객체로 표현이 가능하다.
- EX:) Runnable 인터페이스
    ```java
    /*Runnable 인터페이스는 매개 변수와 리턴값이 없는 run()메소드만 존재하기에 
    다음과 같이 람다식을 이용해서 Runnable 인스턴스를 생성시킬수 있다.*/
    Runnable runnable = () -> {
        for(int i=0; i<10; i++){
            System.out.println(i);
        }
    };
    Thread thread = new Thread(runnable);
    thread.strat();

    //Thread 생성자를 호출할 때 다음과 같이 람다식을 매개값으로 대입해도 된다.
    Thread thread = new Thread( () -> {
        for(int i=0; i<10; i++){
            System.out.println(i);
        }
    });
    ```
- 자바 8부터 빈번히 사용되는 함수적 인터페이스는 java.util.function 표준 API 패키지로 제공한다.
    - 목적은 메소드 또는 생성자의 매개 타입으로 사용되어 람다식을 대입할 수 있도록 하기 위해서이다.
    - 구분 기준은 인터페이스에 선언된 추상 메소드의 매개값과 리턴값의 유무이다.
- **java.util.function 패키지**의 함수적 인터페이스
    - **Consumer**
        - 매개값은 있고, 리턴값은 없음
    - **Supplier**
        - 매개값은 없고, 리턴값은 있음
    - **Function**
        - 매개값도 있고, 리턴값도 있음
        - 주로 매개값을 리턴값으로 매핑(타입변환)
    - **Operator**
        - 매개값도 있고, 리턴값도 있음
        - 주로 매개값을 연산하고 결과를 리턴
    - **Predicate**
        - 매개값은 있고, 리턴타입은 boolean
        - 매개값을 조사해서 true/false를 리턴

- **Consumer 함수적 인터페이스**
    - 리턴값이 없는 **accept()** 메소드를 가지고 있다.
    - **accept() 메소드는 단지 매개값을 소비하는 역할**만 한다.

    |인터페이스명|추상메소드|설명|
    |:----------|:----------|:------------|
    |Consumer< T>|void accept(T t)|객체 T를 받아 소비|
    |BiConsumer<T,U>|void accept(T,U)|객체 T와 U를 받아 소비|
    |DoubleConsumer|void accept(double value)|double 값을 받아 소비|
    |IntConsumer|void accept(int value)|int 값을 받아 소비|
    |LongConsumer|void accept(long value)|long 값을 받아 소비|
    |ObjDoubleConsumer< T>|void accept<T t, double value>|객체 T와 double 값을 받아 소비|
    |ObjIntConsumer< T>|void accept<T t, int value>|객체 T와 int 값을 받아 소비|
    |ObjLongConsumer< T>|void accept<T t, long value>|객체 T와 long 값을 받아 소비|

    -   ```java
        Consumer<String> consumer = t -> {t를 소비하는 실행문; };    
        ```
- **Supplier 함수적 인터페이스**
    - 매개변수가 없고 리턴값이 있는 **getXXX()** 메소드를 가지고 있다.
    - 이 **메소드들은 실행 후 호출한 곳으로 데이터를 리턴(공급)하는 역할**을 한다.

     |인터페이스명|추상메소드|설명|
    |:----------|:----------|:------------|
    |Supplier< T>|T get()|T 객체를 리턴|
    |BooleanSupplier|boolean getAsBoolean()|boolean 값을 리턴|
    |DoubleSupplier|double getAsDouble()|double 값을 리턴|
    |IntSupplier|int getAsInt()|int 값을 리턴|
    |LongSupplier|long getAsLong()|long 값을 리턴|

    -   ```java 
        Supplier<String> supplier = () -> {···; return "문자열";}```

- **Function 함수적 인터페이스**
    - 매개값과 리턴값이 있는 **applyXXX()** 메소드를 가지고 있다. 
    - 이 메소드들은 **매개값을 리턴값으로 매핑(타입변환)하는 역할**을 한다.
    
     |인터페이스명|추상메소드|설명|
    |:----------|:----------|:------------|
    |Function<T,R>|R apply(T t)|객체 T를 객체 R로 매핑|
    |BiFunction<T,U,R>|R apply(T t,U u)|객체 T 와 U를 객체 R로 매핑|
    |DoubleFunction< R>|R apply(double value)|double를 객체 R로 매핑|
    |IntFunction< R>|R apply(int value)|int를 객체 R로 매핑|
    |IntToDoubleFunction|double applyAsDouble(int vlaue)|int를 double로 매핑|
    |IntToLongFunction|long applyAsLong(int value)|int를 long으로 매핑|
    |LongToDoubleFunction|double applyAsDouble(long value)|long을 double로 매핑|
    |LongToIntFunction|Int applyAsInt(long value)|long을 int로 매핑|
    |ToDoubleFunction<T,U>|double applyAsDouble(T t, U u)|객체 T와 U를 double로 매핑|
    |ToDoubleFunction< T>|double applyAsDouble(T t)|객체 T를 double로 매핑|
    |ToIntBiFunction<T,U>|int applyAsInt(T t, U u)|객체 T와 U를 int로 매핑|
    |ToIntFunction< T>|int applyAsInt(T t)|객체 T를 int로 매핑|
    |ToLongBiFunction<T,U>|long applyAsLong(T t, U u)|객체 T와 U를 long으로 매핑|
    |ToLongFunction< T>|long applyAsLong(T t)|객체 T를 long으로 매핑|


    - ```java
        Function<Student,String> function = t -> {return t.getName();}
        또는
        Function<Student,String> function = t -> t.getName(); ```

- **Operator 함수적 인터페이스**
    - Function과 동일하게 매개변수와 리턴값이 있는 **applyXXX()** 메소드를 가지고 있다.
    - 이 메소드들은 **매개값을 이용해서 연산을 수행한 후 동일한 타입으로 리턴값을 제공**하는 역할

     |인터페이스명|추상메소드|설명|
    |:----------|:----------|:------------|
    |BinaryOperator< T>|T apply(Tt,Tt)|T와 T를 연산한 후 T리턴|
    |UnaryOperator< T>|T appl(Tt)|T를 연산한후 T 리턴|
    |DoubleBinaryOperator|double applyAsDouble(double,double)|두 개의 double 연산|
    |DoubleUnaryOperator|double applyAsDouble(double)|한 개의 double 연산|
    |IntBinaryOperator|int applyAsInt(int,int)|두 개의 int 연산|
    |IntUnaryOperator|int applyAsInt(int)|한 개의 int 연산|
    |LongBinaryOperator|long applyAsLong(long,long)|두 개의 long 연산|
    |LongUnaryOperator|long applyAsLong(long)|한 개의 long 연산|

    - ```
        IntBinaryOperator operator = (a,b)->{···,return int값;}```

- **Predicate 함수적 인터페이스**
    - 매개변수와 boolean 리턴값이 있는 **testXXX()** 메소드를 가지고 있다.
    - **이 메소드들은 매개값을 조사해서 true 또는 false를 리턴**하는 역할을 한다.

     |인터페이스명|추상메소드|설명|
    |:----------|:----------|:------------|
    |Predicate< T>|boolean test(T t)|객체 T를 조사|
    |BiPredicate<T,U>|boolean test(T t,U u)|객체 T와 U를 비교조사|
    |DoublePredicate|boolean test(double value)|double 값을 조사|
    |IntPredicate|boolean test(int value)|int 값을 조사|
    |LongPredicate|boolean test(long value)|long 값을 조사|

    - ```java
        Predicate<Student> predicate = t ->{return t.getSex().equals("남자"); }
        또는
        Predicate<Student> predicate = t ->t.getSex().equals("남자"); ```
- **andThen()과 compose() 디폴트 메소드**
    - 디폴트 및 정적 메소드는 추상 메소드가 아니기 때문에 함수적 인터페이스에 선언되어도<br> 여전히 함수적 인터페이스의 성질을 잃지 않는다.
        - **함수적 인터페이스의 성질** 
        - 하나의 추상 메소드를 가지고 있고, 람다식으로 익명 구현 객체를 생성할 수 있는 것을 말함
    - java.util.function 패키지의 함수적 인터페이스는 **하나 이상의 디폴트 및 정적 메소드를 가지고 있다**.
    - Consumer, Function, Operator 함수적 인터페이스는 **andThen()** 과 **compose() 디폴트메소드**를 가지고 있다.
    - 두 개의 함수적 인터페이스를 순차적으로 연결
    - 첫 번째 처리 결과를 두 번째 매개값으로 제공해서 최종 결과값을 얻을 때 사용
    - **andThen() 과 compose() 차이는 어떤 함수적 인터페이스부터 먼저 처리하느냐**이다.

    - **andThen()**
        - 인터페이스AB의 method()를 호출하면 우선 인터페이스A부터 처리하고<br>결과를 인터페이스B의 매개값으로 제공
        ```java
        인터페이스AB = 인터페이스A.andThen(인터페이스B);
        최종결과 = 인터페이스AB.method();
        ```
    - **compose()**
        - 인터페이스AB의 method()를 호출하면 우선 인터페이스B부터 처리하고<br> 결과를 인터페이스A의 매개값으로 제공
        ```java
        인터페이스AB = 인터페이스A.compose(인터페이스B);
        최종결과 = 인터페이스AB.method();
        ```
    - **Consumer의 순차적 연결**
    >**Consumer** 종류의 함수적 인터페이스는 andThen() 디폴트 메소드는 함수적 인터페이스의 **호출 순서**만 정한다.
    - **Function의 순차적 연결**
    >**Function과 Operator** 종류의 함수적 인터페이스는 먼저 실행한 함수적 인터페이스의 **결과를 <br>다음 함수적 인터페이스의 매개값으로 넘겨주고, 최종 처리 결과를 리턴**
- **and(), or(), negate() 디폴트 메소드와 isEqual() 정적 메소드**
    >Predicate 종류의 함수적 인터페이스는 and(),or(),negate() 디폴트 메소드를 가지고 있다.<br> 이 메소드들은 각각 논리 연산자인 &&,||,!과 대응된다.
    - **and() 메소드**
        - 두 Predicate가 **모두 true를 리턴**하면 최종적으로 **true를 리턴**하는 Predicate 생성
    - **or() 메소드**
        - 두 Predicate 중 **하나만 true를 리턴하더라도** 최종적으로 **true를 리턴**하는 predicate 생성
    - **negate() 메소드**
        - Predicate의 결과가 **true 이면 false**로, **false 이면 true**로 리턴하는 새로운 Predicate 생성
    >Predicate< T> 함수적 인터페이스는 isEqual() 정적메소드를 추가로 제공한다.
    - **isEqual() 메소드**
    ```java
    Predicate<Object> predicate = Predicate.isEqual(targetObject);
    boolean result = predicate.test(sourceObject);      
                                    //   ▲   동등 비교    ▲    
    ```

    |sourceObject|targetObject|리턴값|
    |:-------|:-------|:-------|
    |null|null|true|
    |not null|null|false|
    |null|not null|false|
    |not null|not null| sourceObject.equals(targetObject)의 리턴값|

- **minBy(), maxBy() 정적 메소드**
>BinaryOperator< T> 함수적 인터페이스 minBy() 와 maxBy() 정적 메소드를 제공한다. <br> 매개값으로 제공되는 Comparator 을 이용해 최대 T와 최소 T를 얻는 BinaryOperator< T>를 리턴한다.

|리턴 타입|정적 메소드|
|:-------|:---------|
|BinaryOperator< T>|minBy(Comparator<? super T>comparator)|
|BinaryOperator< T>|maxBy(Comparator<? super T>comparator)|

- **Comparator< T>**
    ```java
    @FunctionalInterface
    public interface Comparator<T> {
        public int compare(T o1, T o2); //compare() 메소드가 선언되어있다.
    }
    //o1과 o2를 비교해서 o1이 작으면 음수, 동일하면 0, o1이크면 양수를 리턴
    ```
- Comparator< T>를 타겟 타입으로 하는 람다식
    - ```java 
        (o1,o2) -> {...; return int값; }
        (o1,o2) -> Integer.compare(o1,o2);// o1과 o2가 int 타입일시
        ```