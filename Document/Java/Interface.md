# Interface (인터페이스)
1. 추상메소드와 상수만을 멤버로 가질 수 있다.
    - 추상클래스보다 추상화 정도가 높다.
    - 추상클래스는 추상메소드 외에 멤버 변수나 일반 메소드를 가질수 있지만 인터페이스는 반드시 사전에 정의된 추상 메소드나 상수만을 가질수 있다.
2. 인스턴스를 생성할 수 없고, 클래스 작성에 도움을 줄 목적으로 사용된다.
3. 미리 정해진 규칙에 맞게 구현하도록 표준을 제시하는데 사용
4. 유연한 설계가 가능하고 유지보수가 쉽다.
5. 다중상속을 구현하게 해주는 고급기술
6. default또는static으로 선언되지 않은 모든 메소드는 암묵적으로 abstract 이기 때문에 abstract제어자가 필요없다(붙여도 상관없음)
7. 인터페이스 구현(implements)
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
6. 인터페이스의 장점 :유연한 개발이 가능
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
