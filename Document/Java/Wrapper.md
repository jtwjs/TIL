# Wrapper class(래퍼 클래스)
> Primitive(기본형)타입을 Wrap해서 쓰는 **Primitive Wrapper Class**를 지칭<br>뿐만 아니라 어떤 Class를 Wrap(포장)해서 사용하는 Class를 가르키는 것.
- 기본형 타입이라고 하는 Primitive Type이 객체형 으로 사용되어야 하는 경우 사용
    1. ex:) HashMap,Generic
    2. 매개변수로 객체가 요구 될때.
    3. 기본형의 값이 아닌 객체로 저장해야 할 때.
    3. 객체간의 비교가 필요 할 때. 등등
- 기본형 타입의 데이터를 인자로 받아들여서, 객체를 생성하여 <br>해당 Wrapper Class가 가진 메소드들을 사용할 수 있도록 해준다.




|**기본형**|**래퍼클래스**|**생성자**|
|:-----:|:-----:|:------|
|booelan|Boolean|Boolean(boolean value)<br>Boolean(String s)|
|char|Character|Character(char value)|
|byte|Byte|Byte(byte value)<br>Byte(String s)|
|short|Short|Short(short value)<br>Short(String s)|
|int|Integer|Integer(int value)<br>Integer(String s)|
|long|Long|Long|Long(long value)<br>Long(String s)|
|float|Float|Float(double value)<br>Float(float value)<br>Float(String s)|
|double|Double|Double(double value)<br>Double(String s)|

>Boolean, Character, Number 모두 Object의 자손이며 모든 숫자와 관련된 wrapper 클래스(Byte,Short,Integer,Long,Float,Double,BigInteger,BicDecimal)들은 모두 Number 클래스의 자손이다.

|타입|문자열 -> 기본형|문자열 -> 객체형|
|:----:|:--------|:----------|
|byte|Byte.**parse**Byte("");|Byte.**valueOf**("");|
|short|Short.**parse**Short("");|Short.**valueOf**("");|
|int|Integer.**parse**Int("");|Integer.**valueOf**("");|
|long|Long.**parse**Long("");|Long.**valueOf**("");|
|float|Float.**parse**Float("");|Float.**valueOf**("");|
|double|Double.**parse**Double("");|Double.**valueOf**("");|

## AutoBoxing / UnBoxing
>자바 SDK1.5부터, Autoboxing / Unboxing 개념이 생김<br>Wrapper Class와 primitive data type 사이에 이루어 지고 있는 자동 변환 기능을 Autoboxing / Unboxing이라 부름

### AutoBoxing
>자바 컴파일러가 primitive data type 을 그에 상응하는 Wrapper class로 자동 변환 시켜주는 것을 의미 

```java
public static void main(String[] args){
        char ch = 'j';
        autoBoxing(ch);
}

public static void autoBoxing(Character chr){
    System.out.println("autoboxing test result : chr = ["+chr+"]");
//결과 값: autoboxing test result : chr = [j]
/*입력된 primitive data type 인 char 를 java compiler 가 
자동으로 wrapper class 인 Character 형으로 변환시킴*/
}
```

### UnBoxing
>자바 컴파일러가 wrapper class를 primitive data type으로 자동 변환 시켜주는 것을 말함.

```java
public static void main(String[] args){
    Character chr = new Character('c');
    UnBoxing(chr);
}

public static void UnBoxing(char ch){
    System.out.println("unboxing test result : chr = ["+ch+"]");
//결과 값: unboxing test result : ch = [c]
/*java compiler가 wrapper class 인 Character 를 primitive data type 인 char 형으로 변환 시킨 것*/
}
```

```java 
Integer i = new Integer(10); -> Integer i = 10; //autoboxing
int i1 = i.intValue();       -> int i1 = i;     //unboxing
```

**반환값이 기본형일 때와 wrapper class 일때의 차이가 없어짐.** <br>그래서 구별없이 valueOf()를 쓰는것도 상관없음(성능은 valueOf()가 조금 더 느림)
