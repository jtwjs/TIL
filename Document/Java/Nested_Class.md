# Nested Class (중첩 클래스)
>클래스 내부에 선언한 클래스를 말한다.

![중첩클래스](https://user-images.githubusercontent.com/60641307/77603940-a2f32080-6f54-11ea-92a3-c4394e08b445.jpg)

- 중첩되는 클래스는 하나 이상 가능
- Outer 클래스 멤버를 Inner 클래스에서 사용 가능
- Outer 클래스에서 inner 클래스 멤버 사용 불가능(사용하고 싶으면 객체를 직접 발생시켜야함)
- 일반 중첩 클래스 내부에서 static과 관련된 멤버를 선언할 수 없음 

### 중첩 클래스 쓰는 이유
- 소스의 가독성을 높이고, 유지보수를 용이하게 하기 위해 사용
- 향상된 캡슐화
- 클래스들의 논리적인 그룹을 나타낼때 사용 

#### 멤버클래스 
- 인스턴스 멤버클래스

```java
class A{
    class B{ㆍㆍㆍ}
}
```
>A 객체를 생성해야만 사용할 수 있는 B 중첩 클래스
- 정적 멤버클래스

```java
class A{
    static class B{ㆍㆍㆍ}
}
```
>A 클래스로 바로 접근할 수 있는 B  중첩클래스
#### 로컬클래스

```java
class A{
    void method(){
        class B{ㆍㆍㆍ}
    }
}
```
>method()가 실행할 때만 사용할 수 있는 B 중첩 클래스
## Inner class(내부 클래스)
- 내부클래스로서 일반클래스 내부에 생성된다. 
    - 클래스에 다른 클래스를 선언하는 이유는 두 클래스가 서로 긴민할 관계에 있기 때문이다.
    - Non-static Nested Class 라고도 불림
- 밖에 있는 클래스는 내부클래스를 멤버변수처럼 사용할 수 있다.
    - 사용할때 new로 인스턴스를 만들어야한다.
- 내부클래스는 자신의 밖에 있는 클래스의 자원을 직접 사용할 수 있다.
#### 장점
- 내부 클래스에서 외부 클래스의 멤버들을 쉽게 접근할 수 있다.
- 코드의 복잡성을 줄일 수 있다.
- 외부의 불필요한 관계 클래스를 감춤으로써 코드의 복잡성을 줄일수 있다.

```java
class outer{
   //인스턴스 멤버클래스//

    class B{ //중첩 클래스
    }
}
//객체 생성
Outer 객체1 = new Outer();
Outer.Inner 객체2 = 객체1.new Inner(); //내부클래스 객체 생성시 외부클래스 객체필요
```
> 클래스 파일은 각각 Outer.class, Outer$Inner.class로 파일이 생긴다.


## static nested class(정적 중첩 클래스)
- 내부클래스와 비슷하나, static으로 선언한다.
- 밖에 있는 클래스의 변수와 메소드 중에 stiatc이 붙은것들을 사용할수 있다.
- static의 특성상 객체를 독립적으로 만들수 있음
- static 멤버를 선언할 수도 있고 static 메소드도 만들어 사용할 수 있음

#### Inner class와의 차이
1. Inner Class는 밖에 있는 클래스의 자원을 마음대로 사용할 수 있지만,중첩클래스는 static만 사용가능
2. Outer 클래스의 객체가 없어도 Inner Class의 객체 생성이 가능하다

```java
class Outer{
    //정적 멤버 클래스//
    static class C{ //모든 종류의 필드와 메소드를 선언가능
    }
}
Outer.Inner 객체 = new Outer.Inner(); //외부 클래스 선언없이 객체 생성 가능
```

## local inner class(지역 중첩 클래스)
- 메소드 내부에 클래스를 정의하는 경우이다. 마치 메소드 내의 지역변수처럼 쓰인다.
- 메소드 내부에서 new 한 뒤 사용해야한다. 메소드밖에서 사용할 수 없다.(지역변수 룰)
- 접근제한자와 지정 예약어를 사용할 수 없는 형태
- 일반 중첩 클래스의 형태와 유사하기 때문에 static 멤버를 선언하지 못함.
- 주로 비동기 처리를 위해 스레드 객체를 만들 때 사용

```java
class Outer{
    //로컬클래스//

    Method(){
        class D{ //정적메소드 사용불가
        }
    D d = new D(); //메소드 내부에서 new로 객체 생성뒤 사용

    }
}
```
> 클래스 파일은 각각 Outer.class, Outer$숫자Inner.class로 파일이 생긴다.

## 중첩 클래스에서 바깥 클래스 참조 얻기 
- 클래스 내부에서 this는 객체 자신의 참조이다.
    - 중첩 클래스에서 this 키워드를 사용하면 바깥 클래스의 객체 참조가 아니라, 중첩클래스의 객체 참조가 된다.
    - 따라서 중첩클래스 내부에서 this.필드, this.메소드()로 호출하면 중첩 클래스의 필드와 메소드가 사용된다.

- 중첩 클래스 내부에서 바깥클래스의 객체 참조를 얻으려면 바깥 클래스의 이름을 this앞에 붙여주면 된다.

```java
바깥클래스.this.필드
바깥클래스.this.메소드();
```

## 중첩 인터페이스
> 중첩 인터페이스는 클래스의 멤버로 선언된 인터페이스를 말한다.<br>
> 인터페이스를 클래스 내부에 선언하는 이유는 해당 클래스와 긴밀한 관계를 맺는 구현 클래스를 만들기 위해서이다.<br>
> 특히 UI프로그래밍에서 이벤트를 처리할 목적으로 많이 사용된다.

```java
public class Button {
	OnClickListener listener; // 인터페이스 타입 필드

	void setOnClickListener(OnClickListener listener) {//매개변수의 다향성
		this.listener = listener;
	}

	void touch() { 			//구현 객체의 onClick()메소드 호출
		listener.onClick();
	}

	interface OnClickListener {//중첩 인터페이스
		void onClick();
	}

    // Button.OnClickListener 구현 클래스
    public class MessageListener implements Button.OnClickListener{
	@Override
	public void onClick() {
		System.out.println("메세지를 보냅니다.");
	}

    // Button.OnClickListsener 구현 클래스
    public class CallListener implements Button.OnClickListener{
	@Override
	public void onClick() {
	System.out.println("전화를 겁니다.");	
	}

    //버튼 이벤트처리 
    public class ButtonExample{
        public static void main(String[] args){
            Button btn = new Button();
            btn.setOnClickListener(new MessageListener);
            btn.touch();

            btn.setOnClickListener(new CallListener);
            btn.touch();
        }
    }
```

## anonymous inner class(익명 클래스)
- 지역 중첩 클래스의 변형된 형태
- 단독으로 생성할 수 없고 클래스를 상속하거나 인터페이스를 구현해야만 생성할 수 있다.
- 익명 객체는 필드의 초기값이나  지역변수의 초기값, 매개변수의 매개값으로 주로 대입된다.
- UI 이벤트 처리 객체나 스레드 객체를 간편하게 생성할 목적으로 익명객체가 많이 사용됨

- 기존 클래스의 특정 메소드를 오버라이딩하여 원하는 형태로 재정의하여 사용하는 방식
- class 예약어와 클래스명을 가지지 않고 단지 instance의 생성과 내용부의 정의만 가짐.
- 내부 클래스는 생성자를 작성할 수 없음(생성자를 작성하게 되면 컴파일 에러 발생)
- 여기에 사용되는 중첩 클래스는 이미 기존에 존재하는 클래스이어야함
- 외부 멤버 중 final만 포함
- 익명클래스는 인스턴스 이름이 없다.
    - new와 동시에 부모클래스를 상속받아 내부에서 오버라이딩해서 사용한다.
- 매개변수로 사용할수도 있다.
- 익명클래스 내부의 변수나 메소드는 익명클래스의 밖에서 사용이 불가하다.
- 주로 익명클래스는 이럴때 사용 : 상속은 받아야하지만, 한번만 사용할 것이라서 extends문법을 굳이 사용안함
- 익명클래스 내부에 생성자X
- 익명클래스 외부의 자원은 final 키워드가 붙은것만 사용가능
- Inner 클래스가 이미 선언되있어야한다. Inner클래스를 바로 상속받고 오버라이딩해서 쓰는 구조이다.

```java
Class Inner{
    var;
    method;
}

class Outer{
    var;
    method1;

    method2(){
        local_var;

        new Inner(){
            override된 내용들..
        }
    }
}
```
> 클래스 파일은 각각 Outer.class, Outer$숫자.class로 파일이 생긴다.
