# Inheritance(상속)


## Has A 관계 (포함 관계)
> 캡슐(class)이 다른 캡슐을 이용하는 관계가 있다. 그것을 이용하기 위해 자기의 부품(멤버)로 가지고 있다.

- 다른 객체를 받아들여서 그 객체의 기능을 사용하는 것이다.
- 받아들인 객체의 자원(메소드/변수)를 사용할 수 있다.
```java
class Gun
{
    public int power; //총은 파괴력이나
    public int shot;  // 탄약의 갯수등이 존재한다.
};
class police{
    Gun gun = new Gun();//경찰이 총을 소유한다.
    //이제 경찰이 총이 가진 기능을 사용할수 있게된것이다.
}
```
### Composition
>전체와 부분이 강력한 연관 관계를 맺으며, 전체와 부분이 같은 생명 주기를 갖는다.
### Aggregation 
>전체와 부분의 연관 관계를 맺지만, 그러나 동일한 생명 주기를 갖지 않는다.
![제목_없음](https://user-images.githubusercontent.com/60641307/75621716-34cc6f80-5bdb-11ea-8d8b-e6c47e4a1811.png)

## Is A 관계 (상속관계)
>속성과 메소드가 약간 다른 객체를 필요로 할때,기존의 클래스를 이용하여 새로운 클래스를 작성<br> 이미존재하는 클래스를 바탕으로 필요한 변수와 메서드를 추가로 정의한것이 상속
- 코드를 간결하게 하여 코드의 재사용성을 높임(**OOP의핵심개념**)
- 자바는 상속을 통해 객체들 사이의 게층 구조를 이룰수있음
- 상위 클래스일수록 일반화,보편화 특징을 갖음
- 하위 클래스일수록 특수화,개별화 특징
- 상속시 '**extends**' 관계 예약어 사용
- 자식클래스는 부모클래스의 private 멤버를 제외한 모든 메소드를 상속받음
## 상속의 종류
- 단일 상속 : 하나의 하위클래스가 하나의 상위클래스를 갖도록 하는 구조
- 다중 상속 : 하나의 클래스가 두개 이상의 상위클래스를 갖도록 계층구조를 생성

```java 
class Person
{
    public int age; //사람이라면 나이가 있고,
    public char name;//이름이 있다.
};
class Student extends Person
{
    public char schoolAdress;//그 사람을 상속하면서, 학교의주소나,
    public char major;        //전공들을 학생은 추가로 가지고 있을것이다.
};
```

## @Override(메소드 오버라이딩)
>상속받은 부모클래스의 메소드를 재정의하여 사용하는것
### 오버라이딩 **조건**
1. 오버라이딩이란 메소드의 동작만을 재정의 하는것이므로, 메소드의 선언부는 기존 메소드와 완전히 같아야한다.
>But 메소드의 반환타입은 부모클래스의 반환타입으로 타입 변환할수있는 타입이면 변경이 가능!
2. 부모클래스의 메소드보다 접근 제어자를 더 좁은 범위로 변경할수 없다.
3. 부모클래스의 메소드보다 더큰 범위의 예외를 선언할수 없다.
```java
class Exam{
    int kor=50;
    int math=70;
    public int total(){
        return kor+math;
    }
class SecondExam extends Exam{
    int com=80;

    @Override
    public int total(){
        return super.total()+com;//super.total():부모클래스.total()
    }
}
}
```
## 참조 형식과 호출되는 메소드의 관계
>부모클래스 객체명 = new 자식클래스()<br>(부모클래스 = 참조 형식, 자식클래스 = 객체 형식)
- 부모클래스로 데이터형을 선언하고 자식클래스를 생성해서 할당
- 부모클래스의 변수와 메소드만 호출 할 수 있다.
- 원칙적으로 자식클래스의 변수와 메소드는 호출 할 수 없다.
- 자식클래스에 **부모클래스에게서 Override한 메소드**가 있다면 그 메소드는 호출가능
- class뿐아니라 interface등도 부모로 받을수 있다.
- 참조형식(부모클래스)의 함수보다 오버라이드된 **객체형식(자식클래스)의 함수 호출을 우선**으로 한다.


## Overloading (오버로딩)
>새로운 메소드를 추가로 정의하는 것

## final 키워드 (상속금지)
- final class{} : 상속 금지
>final 클래스는 부모 클래스가 될 수 없어 자식 클래스를 만들수 없다.
- final method(){} : 오버라이딩 금지 
>부모 클래스에 선언된 final 메소드는 자식 클래스에서 재정의할 수 없다는 것이다.

## protected 접근 제한자
>public과 default 접근 제한의 중간쯤에 해당한다. 같은 패키지에서는 default와 같이 접근 제한이 없지만 다른 패키지에서는 자식클래스만 접근을 허용한다.

![img_java_access_protected](https://user-images.githubusercontent.com/60641307/76756899-f71a3a00-67c9-11ea-8e0c-c6736e10ed1a.png)
>protected는 **필드와 생성자, 메소드** 선언에 사용될 수 있다. 

```java
package package1;

public class A{
    protected String field; //protected로 선언된 필드

    protected A(){          //protected로 선언된 생성자
    }

    protected void method(){//protected로 선언된 메소드
    }
}

package package2;       //부모클래스인 A와 다른패키지
import package1.A;      //부모클래스가있는 패키지 import
                        
public class D extends A{//자식클래스이기때문에 protected 필드,생성자,메소드 접근가능    
    public D(){          //단 new연산자를 사용해서 생성자를 직접호출할 수 없다.
        super();        //자식 생성자에서 super()로 A생성자를 호출 가능
        this.field="value";
        this.method();
    }
}
```

