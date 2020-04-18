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