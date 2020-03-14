# this란?
- 현재 클래스의 인스턴스를 의미
- 즉, 현재 클래스의 멤버(변수,메소드)를 지정할때 사용
- 부분적으로 생략가능
```java
public class People{
    private int age;

    public void setInt(int age){
        this.age = age;
    //this.age=클래스의 멤버변수 age를 가리킴
    // age는 매개변수(지역변수) age를 가르킴 
    }
}
```
## this()란?
- 현재 클래스에 정의된 생성자를 부를때 사용
```java
public class Parent{
    private String moter;
    private String father;

    public Parent(){
        this("motther","father");
        //생성자가 2개 이상있을 경우 ,
        //this()메소드를 사용해 두번쨰 생성자를 불러 초기화 가능
    }
    public Parent(String mother ,String father){
        this.mother = mother;
        this.father = father;

    }
}
```

# super란?
- 자식 클래스에서 상속받은 부모 클래스의 멤버(변수,메소드)를 참조할때 사용
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
        return super.total()+com;
        //부모클래스의 메소드를 지정
    }
 ```

 ## super()란?
 - 자식 클래스가 자신을 생성할때 부모 클래스의 생성자를 불러 초기화 할때 사용

 >기본적으로 자식클래스의 생성자에 추가된다.

 ```java
public class Parent{
    private String moter;
    private String father;

    public Parent(){
        this("motther","father");
    }
    public Parent(String mother ,String father){
        this.mother = mother;
        this.father = father;
    }
}
public class Child extends Parent{
    public String daugther;
    public String son;

    public Child(){
        this("daugther","son");
    }
    public Child(String daugther,String son){
        //super();부모생성자를 가져와 초기화
        super("child.mother","child.father");
        this.daugther = daugther;
        this.son = son;
    }
}
}

 ```