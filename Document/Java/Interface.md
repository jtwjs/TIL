# Interface (인터페이스)
1. 추상메소드와 상수만을 멤버로 가질 수 있다.
    - 추상클래스보다 추상화 정도가 높다.
    - 추상클래스는 추상메소드 외에 멤버 변수나 일반 메소드를 가질수 있지만 인터페이스는 반드시 사전에 정의된 추상 메소드나 상수만을 가질수 있다.
2. 인스턴스를 생성할 수 없고, 클래스 작성에 도움을 줄 목적으로 사용된다.
3. 미리 정해진 규칙에 맞게 구현하도록 표준을 제시하는데 사용
4. 유연한 설계가 가능하고 유지보수가 쉽다.
5. 다중상속을 구현하게 해주는 고급기술
6. 인터페이스 구현(implements)
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
7. 인터페이스 구현 시 주의할 점
    1. 인터페이스의 메소드는 **모두 추상 메소드** 이기 때문에 abstract이여야한다.(생략가능)
    2. 인터페이스 메소드의 접근제한자는 모두 **public**이어야한다. 단 생략가능(인터페이스의 기본 접근제한자는 public이기 때문)
    3. 인터페이스를 구현하는 클래스의 메소드는 **public 키워드를 명시적**으로 써주어야한다.(클래스의 접근 제한자는 안쓰면 default이기 때문이다.)
    4. 인터페이스의 레퍼런스는 인터페이스를 구현한 클래스의 인스턴스를 참조할 수 있다.
    5. **인터페이스의 필드는 모두 상수**
    6. 클래스의 다중 상속은 허가하지 않지만, **클래스가 여러 인터페이스를 구현(implements)할 수 있으며 인터페이스는 다른 인터페이스의 다중 상속(extends)는 허가**한다.(복잡도가 그리 증가하지 않기때문)
8. 인터페이스의 장점 :유연한 개발이 가능
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
