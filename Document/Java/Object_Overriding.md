# Object Overriding Method
> Object 클래스는 모든 클래스의 **최상위** 클래스이다.<br>**자동으로 Object클래스를 상속**하고 있다.<br>Object가 가지고 있는 메소드들은 모든 클래스에서 사용할 수 있다는 것을 뜻한다.<br>Object가 가지고 있는 메소드 중에서 가장 많이 사용되는 메소드는 **equals** , **toString** ,**hashCode**가 있으며 이는 반드시 오버라이딩해서 사용해야 한다.

- [equals()](#equals-overriding-(이퀄즈-오버라이딩))
- [hashCode()](#hashCode-overriding-(해쉬코드-오버라이딩))
- [toString()](#toString-overriding-(투스트링-오버라이딩))


#### 가장 많이 사용되는 메소드
>사용자의 요구에 맞도록 오버라이딩을 해서 사용해야 한다.
- equals() : 객체가 가진 값을 비교할 때 사용
    - 두 객체의 **내용이 같은지** 확인
- hashCode() : 객체의 해시코드 값 반환
    - hashcode : 객체를 식별할 수 있는 정수값
    - 두 객체가 **같은 객체인지** 확인
- toString() : 객체가 가진 값을 문자열로 반환

#### IDE가 쉽게 만들어 준다.
- equlas() & hashCode() : Source -> Generate hashCode() and equals() 
- toString() : Source -> Generate toString() - click




## equals overriding (이퀄즈 오버라이딩)
- equals() : 객체가 가진 값을 비교할 때 사용
>오로지 참조값이 같은지, 다시말하면 동일 객체인지 확인하는 기능<br>자바에서는 두 객체를 동등 비교할 때 equals() 메소드를 흔히 사용한다.<br>equlas() 메소드는 두 객체를 비교해서 논리적으로 동등(둘의 참조값이 다르더라도 객체 내부 value는 같다는것을 의미)하면 true를 리턴,그렇지 않으면 false를 리턴한다.

>이 equals() 메소들을 재정의한 대표적인 예는 String Class이다.<br>String class는 equals() 메소드를 재정의해서 번지비교가 아닌 문자열을 비교한다.

```java
//String class의 equals() 부분
public boolean equals(Object anObject){
    if (this == anObject){
        return true;
    }
    if (anObject instanceof String){
        String anotherString = (String)anObject;
        int n = value.length;
        if (n == anotherString.value.length){
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = 0;
            while (n-- != 0){
                if (v1[i] != v2[i])
                    return false;
                i++;
            }
            return true;
        }
    }
    return false;
}
//Object로 객체를 받아 하나하나 문자열을 비교한다.
//cahr은 참조값이 아닌 기본값이기 떄문에 ==만으로 값비교가 된다.
```
>**String을 이용해 문자열 리터럴 방식으로 문자열을 정의하면 동일 객체를 생성하게 되어있다.**

>기본적으로 객체는 고유하기 떄문에 같을수가 없다.<br>equals() 메소드로 객체를 비교하면 무조건 false가 나온다.<br>그런데 객체안의 값이 같으면 같은 객체라고 인식하게 바꾸는 것을 **equals overriding** 이다.

### Overriding 전
```java
public class Practice{
    String name;
    String number;
    int birthYear;
    public static void main(String[] args){
        Practice p1 = new Practice();
        p1.name = "홍길동";
        p1.number= "1234";
        p1.birthYear = 1995;

        Practice p2 = new Practice();
        p2.name = "홍길동";
        p2.number = "1234";
        p2.birthYear = 1995;

        if(p1.equals(p2))
            System.out.println("same");
        else
            System.out.println("Not same");
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
    }
}
//결과는 Not same 출력된다.
//두 객체의 hashcode 값이 다르기 때문!
//그래서 equals 메소드와 hashCode 메소드를 우리가 사용하는 목적에 맞도록
//오버라이딩해서 재정의 해야한다.
```
### Overriding 후 
- 오버라이딩 하는 방법
    1. 상단의 Source 클릭
    2. Generate hashCode() and equals() 클릭
    3. 비교할 기준(객체의 필드) 선택

```java
@Override
public int hashCode(){
    final int prime = 31; //소수 값
    int result = 1;
    result = prime*result+((number == null)) ? 0 : number.hashCode());
    return result;

@Override
public boolean equals(Object obj){
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Practice other = (Practice) obj;//강제 형변환
    if (number == null){
        if (other.number != null)
            return false;
    }else if (!number.equals(other.number))
            return false;
    return true;
            }
}
//위와같이 equals()메소드를 재정의하게 되면 
//Practice 객체를 통해 객체를 비교할 때 
//number가 같다면 두 객체는 동등 객체가 될 것이다.
```
- 동일성 비교는 == 비교다. : 객체 인스턴스의 주소 값을 비교한다.
- 동등성 비교는 equals() 메소드를 사용해서 **객체 내부의 값을 비교**한다.

## hashCode overriding (해쉬코드 오버라이딩)
>객체 해시코드란 객체를 식별할 하나의 정수값을 말한다.<br>Object의 hashCode() 메소드는 객체의 메모리 번지를 이용해서 해시코드를 만들어 리턴하기 때문에 객체 마다 다른 값을 가지고 있다.<br> 객체의 값을 동등성 비교시 hashCode()를 오버라이딩할 필요성이 있다.


#### 해시코드 생성(hash(), hashCode())
>Object 중에 해시코드를 생성해주는 역할이 있다.<br>이 Object.hash(Object...values) 메소드는 매개값으로 주어진 값들을 이용해서<br> 해시 코드를 생성하는 역할을 하는데, 주어진 매개값들로 배열을 생성하고<br> Arrays.hashCode(Object[])를 호출해서 해시코드를 얻고 이값을 리턴한다.

>Object.hash(Object... values)메소드는 hashCode()를 재정의할 때 리턴값을 생성하기 위해 사용하면 좋다. 클래스 하나가 여러가지 필드를 가지고 있을 때 이 필드들로부터 해시코드를 생성하게 되면 동일한 필드값을 가지는 객체는 동일한 해시코드를 가질수 있다. 좀더 정밀한 동등 객체를 이용한다면 이방법을 사용

```java
@Override
public int hashCode() {
    return Objects.hash(field1,field2,filed3);
}
```
>IDE 또는 lombock등을 이용해 좀더 쉽게 equals,hashCode를 재정의할수도 있다.


## toString overriding (투스트링 오버라이딩)
>toString()메소드는 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메소드

>Object의 toString() 메소드는 현재 객채의 클래스 이름과 객체의 해시코드값을 리턴해준다.

```java
public String toString(){
    getClass().getName() + '@'+ Integer.toHexString(hashCode())
}
```
>이런 형태를 가지고 있으며 **객체이름@해시코드**의 형태로 보여준다.
#### toString() 메소드는 자동으로 호출된다 
>"toString()"메소드 없이 그냥 객체 자체로 변수에 담긴 내용을 가져와 사용함

```java
String str = "Morphs's house";

System.out.println(str);
//str은 String 클래스의 객체
//객체임에도 불구하고 "str" 독단적으로 사용될수있다. 
//바로 이것이 toString이 자동으로 호출되는것이다.
```

### Overriding 전

```java
package Object;
public class toStringEx1{
    public static void main(String[] args){

        Person pr = new Person();

        System.out.println(hu);//toString()생략가능
        System.out.println(hu.toString());//위와 동일
    }
}
//콘솔 출력값
//Object.Person@566776ad 
//Object.Person@566776ad
//Overriding을 하지않아 Object의 toString()이 사용된 것
```

### Overriding 후
- 오버라이딩 하는 방법
    1. 상단의 Source 클릭
    2. Generate toString() 클릭
    3. 입맞에 맞게 반환될 값(문자열) 입력

```java
//toString() 오버라이딩 
package Object;
public class Person {
	String name;
	int age;
	
	Person(){
		name="정태웅";
		age=26;
	}
	
	@Override
	public String toString(){
		return "이름 : "+name+" / "+"나이 : "+age;
	}
}
//위와같이 toString() 메소드를 재정의하게되면
//이름 : 정태웅 / 나이 : 26   출력된다.

```