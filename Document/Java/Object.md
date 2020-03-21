# Object 클래스 
> 클래스를 선언할 때 extends 키워드로 다른 클래스를 상속하지 않으면 암시적으로 java.lang.Object 클래스를 상속하게 된다.

>따라서 자바의 모든 Object 클래스의 자식이거나 자손 클래스이다.<br> Object는 자바의 최상위 부모 클래스에 해당한다.

>Object 클래스는 필드가 없고, 메소드들로 구성되어 있다.<br>이 메소드들은 모든 클래스가 Object를 상속하기 때문에 모든 클래스에서 사용이 가능하다.

1. 객체 비교 (equals())
2. 객체 해시코드(hashCode())
3. 객체 문자 정보(toString())
4. [객체 복제(clone())](#clone()-Method-(객체-복제))




## clone() Method (객체 복제)
>객체 복제는 원본 객체의 필드값과 동일한 값을 가지는 새로운 객체를 생성하는 것을 말한다.<br>객체를 복제하는 이유는 원본 객체를 안전하게 보호하기 위해서이다.<br>신뢰하지 않는 영역으로 원본 객체를 넘겨 작업할 경우 원본 객체의 데이터가 훼손될 수 있기 때문에 <br>복제된 객체를 만들어 신뢰하지 않는 영역으로 넘기는것이 좋다.<br>객체를 복제하는 방법에는 얕은 복제와 깊은 복제가 있다.

>이메소드로 객체를 복제하려면 원본 객체는 반드시 java.lang.Cloneable 인터페이스를 구현하고 있어야한다.<br>
>클래스 설계자가 복제를 허용한다는 의도적인 표시를 하기 위해서이다.<br>복제를 허용하지 않으면 Cloneable 인터페이스를 구현하지 않아도 된다.<br>구현하지 않으면 clone() 메소드를 호출할 때 CloneNotSupporteException 예외가 발생하여 복제가 실패된다.<br> 예외처리가 필요한 메소드이기 때문에 try-catch 구문이 필요하다.
### thin clone(얕은 복제)
>단순히 필드값을 복사해서 객체를 복제하는 것을 말한다.<br>필드값만 복제하기 때문에 필드가 기본 타입일 경우 값 복사가 일어나고<br>필드가 참조 타입일 경우에는 객체의 번지가 복사된다.<br>Object의 clone() 메소드는 자신과 동일한 필드값을 가진 얕은 복제된 객체를 리턴한다.

>**참조 타입 필드는 번지만 복제**되기 때문에 원본 객체의 필드와 복제 객체의 필드와 복제 객체의 필드는 같은 객체를 참조하게 된다.만약 복제 객체에서 참조 객체를 변경하면 원본 객체도 변경된 객체를 가지게 된다. 이것이 얕은 복제의 단점 

```java
public class Member implements Clonable {
    public String id;
    public String name;
    public String password;
    public int age;
    public boolean adult;

    public Member(String id,String name,String password,int age,boolean adult){
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.adult = adult;
    }

    public Member getMember() {
        Member cloned = null;
        try {
            //clone() 메소드의 리턴 타입은 Object이므로 Member 타입으로 캐스팅해야함
            cloned = (Member) clone();
        }catch (CloneNotSupportedException e){ }
        return cloned;
    }
}
```

```java
public class MemberExample{
    public static void main(String[] args){
        //원본 객체 생성
        Member original = new Member("blue","홍길동","12345",25,true);

        //복제 객체를 얻은 후에 패스워드 변경
        Member cloned = original.getMember();
        cloned.password = "67890"; //복제 객체에서 패스워드 변경

        System.out.println("[복제 객체의 필드값]");
        System.out.println("id:  " +cloned.id);
        System.out.println("name: " +cloned.name);
        System.out.println("password: "+cloned.password);
        System.out.println("age: " +cloned.age);
        System.out.println("adult: " +cloned.adult);

        System.out.println();

        System.out.println("[원본 객체의 필드값]");
        System.out.println("id:  " +original.id);
        System.out.println("name: " +original.name);
        System.out.println("password: "+original.password);
        System.out.println("age: " +original.age);
        System.out.println("adult: " +original.adult);
    }
}
//원본 Member의 password 필드값은 변경되지 않았다.
```

### deep clone (깊은 복제)[Overriding]
>참조하고 있는 객체도 복제하는 것을 말한다.<br>원본 객체를 깊은 복제했을 경우 참조하는 배열 객체도 복제된다

>깊은 복제를 하려면 Object의 clone() 메소드를 재정의해서 ㅊ마조 객체를 복제하는 코드를 직접 작성해야 한다.

```java
public class Member implements Clonable{
    public String name;
    public int age;
    public int[] scores; //참조 타입 필드 (깊은 복제 대상)
    public Car car;      //참조 타입 필드 (깊은 복제 대상)
    
    public Member(String name, int age, int[] scores, Car car){
        this.name = name;
        this.age = age;
        this.scores = scores;
        this.car = car;
    }

    @Override //clone() 메소드 재정의
    protected Object clone() throws CloneNotSupportedException{
        //먼저 얕은 복사를 해서 name, age를 복사한다.
        Member cloned = (Member)super.clone(); //Object의 clone() 호출
        //scores를 깊은 복제한다.
        cloned.scroes = Arrays.copyOf(this.scores, this.scores.length);
        //Car를 깊은 복제한다.
        cloned.car = new Car(this.car.model);
        //깊은 복제된 Member 객체를 리턴
        return cloned;
    }

    public Member getMember() {
        Member cloned = null;
        try{
            cloned = (Member) clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return cloned;
    }
}

public class Car{
    public String model;

    public Car(String model);{
        this.model = model;
    }
}
```
>Member 클래스의 getMember() 메소드를 호출해서 복제된 Member 객체를 얻은 후에 score 배열 항목값과 car 객체의 모델을 변경한다.

```java
public class MemberExample{
    public static void main(String[] args){
        //원본 객체 생성
        Member original = new Member("홍길동",25,new int[]{90, 90},new Car("소나타"));
        
        //복제 객체를 얻은 후에 참조 객체의 값을 변경
        Member cloned = original.getMember();
        cloned.scores[0] = 100;
        cloned.car.mdodel = "그랜저"; 

        System.out.println("[복제 객체의 필드값]");
        System.out.println("name: "+cloned.name);
        System.out.println("age: "+cloned.age);
        System.out.println("scores: {"});
        for(int i = 0; i<cloned.scores.length;i++){
            System.out.print(cloned.scores[i]);
            System.out.print(i==(cloned.scores.length-1))?"":","); //개꿀팁 ㅋ
        }
        System.out.println("}");
        System.out.println("car: " +cloned.car.model);

        System.out.println();

        System.out.println("[원본 객체의 필드값]");
        System.out.println("name: "+original.name);
        System.out.println("age: "+original.age);
        System.out.println("scores: {"});
        for(int i = 0; i<original.scores.length;i++){
            System.out.print(original.scores[i]);
            System.out.print(i==(original.scores.length-1))?"":","); //개꿀팁 ㅋ
        }
        System.out.println("}");
        System.out.println("car: " +original.car.model);
        }
    }
}
//원본 Member 객체의 scores배열 항목값과 car 객체의 모델 값이 바뀌지 않았다.
//원본과 복제본이 각각 참조하는 scores 배열과 car 객체는 서로 다르기 때문..
```