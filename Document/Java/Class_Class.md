# Class 클래스
>자바 클래스와 인터페이스의 메타 데이터를 java.lang 패키지에 소속된 Class 클래스로 관리한다. <br>여기서 메타 데이터란 클래스의 이름,생성자 정보,필드 정보,메소드 정보를 말한다.
- Class 클래스는 클래스에 대한 정보를 얻기 좋은 클래스
- Class는 생성자가 따로 없다.
- Object 클래스에 있는 getClass()메소드를 이용하는것이 일반적

### Class 객체 얻기 (getClass(), forNomal())
>프로그램에서 class 객체를 얻기 위해서는 Object 클래스가 가지고 있는 getClass() 메소드를 이용하면 된다.<br>Object는 모든 클래스의 최상위 클래스이므로 모든 클래스에서 getClass() 메소드를 호출할수 있다.

```java
Class clazz = obj.getClass(); 
```

- getClass() : 해당클래스로 객체를 생성했을 때만 사용할 수 있는데, 객체를 생성하기 전에 직접 Class 객체를 얻을 수도 있다.<br>Class는 생성자를 감추고 있기 때문에 new 연산자로 객체를 만들수 없고, **정적 메소드인 forName**()을 이용해야한다.

```java
try{
    Class clazz =Class.forName(String className);
}catch(ClassNotFoundException e){}
```

- Class.forName() : 매개값으로 주어진 클래스를 찾지 못하면 ClassNotFoundException 예외를 발생시키기 때문에 **예외처리가 필요**하다.

```java
public class ClassExample{
    public static void main(String[] args){
        Car car = new Car();
        Class clazz1 = car.getClass();
        System.out.println(clazz1.getName());
        System.out.println(clazz1.getSimpleName());
        System.out.println(clazz1.getPackage().getName());
        System.out.println();

        try{
            Class clazz2 = Class.forName("패키지.클래스명"); //클래스 파일 경로
            System.out.println(clazz2.getName());
            System.out.println(clazz2.getSimpleName());
            System.out.println(clazz2.getPackage().getName());
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
```

### 리플렉션(getDeclaredConstructors(), getDeclaredFields(), getDeclaredMethods())
>Class 객체를 이용하면 클래스의 생성자,필드,메소드 정보를 알아낼수 있다. <br>이것을 리플렉션(Reflection)이라 한다.
- java.lang.reflect

```java
Constructor[] constructors = clazz.getDeclaredConstructors();
Field[] fields = clazz.getDeclaredFields();
Method[] methods = clazz.getDeclaredMethods();
```
- getDeclaredConstructos() : Constructor 배열 반환
- getDeclareFields() : Field 배열 반환
    - 클래스에 선언된 멤버만 가져오고 상속된 멤버는 가져오지 않는다.
    - 상속된 멤버도 얻고 싶다면 getFields(); public만 
- getDeclaredMethod() : Method 배열 반환
    - 클래스에 선언된 멤버만 가져오고 상속된 멤버는 가져오지 않는다.
    - 상속된 멤버도 얻고 싶다면 getMethods(); public만

|Method|Explain|
|:----------|:-----------|
|String getName()|클래스의 이름을 리턴한다.|
|Package getPackage()|클래스의 패키지 정보를 패키지 클래스 타입으로 리턴|
|Field[] getFields()|public으로 선언된 변수 목록을 Field클래스배열 타입으로 리턴|
|Field getField(String name)|public으로 선언된 변수를 Field 클래스타입으로 리턴한다.|
|Field[] getDeclaredFields()|해당 클래스에서 정의된 변수목록(상속X)을 field 클래스 배열 타입으로 리턴|
|Field getDeclaredField(String name)|name과 동일한 이름으로 정의된 변수를 Field 클래스 타입으로 리턴한다.|
|Method[] getMethods()|public으로 선언된 모든 메소드 목록을 Method클래스배열 타입으로 리턴<br>해당 클래스에서 사용가능한 상속받은 메소드도 포함|
|Method getMethod(String name,<br>Class..parameterTypes)|지정된 이름과 매개변수 타입을 갖는 메소드를 Method 클래스타입으로 리턴|
|Method[] getDeclaredmethods()|해당 클래스에서 선언된 모든 메소드(상속X) 정보를 리턴|
|Method getDeclaredmethod(String name,<br>Class...parameterTypes)|지정된 이름과 매개변수 타입을 갖는 해당 클래스에서<br> 선언된 메소드를 Method 클래스 타입으로 리턴|
|Constructor[] getConstructors()|해당 클래스에서 선언된 모든 public 생성자의 정보를 Constructor배열타입으로 리턴|
|Constructor[] getDeclaredConstructors()|해당 클래스에서 선언된 모든 생성자의 정보를 Constrcutor배열타입으로 리턴|
|int getModifiers()|해당 클래스의 접근자(modifier)정보를 int타입으로 리턴|
|String toSting()|해당 클래스 객체를 문자열로 리턴|



```java
public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("패키지.클래스명");

        System.out.println("[클래스 이름]");
        System.out.println(clazz.getName());
        System.out.println();

        System.out.println("[생성자 정보]");
        Constructor[] constructors = clazz.getDeclaredConstructors();  //생성자 배열
        for(Constructor constructor : constructors){
            System.out.println(constructor.getName() +"(");
            Class[] parameters = constructor.getParameterTypes(); //생성자 매개변수 배열
            printParameters(parametrs);
            System.out.println(")");
        }
        System.out.println();

        System.out.println("[필드 정보]");
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getType().getSimpleName()+
            " " +field.getName());
        }
        System.out.println();

        System.out.println("[메소드 정보]");
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            System.out.print(method.getName()+"(");
            Class[] parameters = method.getParameterTypes();
            printParameters(parameters);
            System.out.println(")");
        }

        private static void printParameters(Class[] parameters){
            for(int i=0; i<parameters.length;i++){
                System.out.print(parameters[i].getName());
                if(i<parameters.length-1){
                    System.out.print(",");
                }
        }
    }
}
//클래스가 자체적으로 가지고 있는 전체 멤버들이 모두 출력된다.
```

### 동적 객체 생성(newInstance())
>Class 객체를 이용하면 new 연산자를 사용하지 않아도 동적으로 객체를 생성할수 있다.
- 클래스 이름을 결정할수 없다.
- 런타임 시에 클래스 이름이 결정되는 경우에 매우 유용하게 사용.

```java
try{
    Class clazz = Class.forName("런타임 시 결정되는 클래스 이름"); // 클래스 객체를 얻음
    Object obj = clazz.newInstance(); //new연산자 사용하지않고 동적으로 Object타입의 객체를 얻음
}catch(ClassNotFoundException e){ //클래스파일을 찾지 못햇을 때 
}catch(InstantiationException e){ //객체를 생성하려는 대상이 추상클래스&인터페이스일 때
}catch(IllegalAccessException e){ //클래스나 생성자에 접근이 허용되지않을 때 (public 설정헀는지 확인)
}
```
- Constructor 객체를 얻어 newInstance() 메소드를 호출하면 된다.
- newInstance() 메소드의 리턴타입은 Object이므로 원래 클래스타입으로 강제형변환해야한다.
    - 클래스타입을 모르는 상태이므로 변환을 할수가 없다.
    - 이 문제를 해결하려면 인터페이스의 사용필요

```java
Class clazz = Class.forName("SendAction"또는"ReceiveAction");//인터페이스 상속받는 클래스
Action action = (Action) clazz.newInstance(); //Action의 인터페이스이므로 강제형변환가능
action.execute();//개별 클래스의 실체 메소드인 execute() 실행
```


```java
//Action 인터페이스
public interface Action{
    public void excute();
}

//SendAction 발신클래스
public class SendAction implements Action{
    @Override
    public void execute(){
        System.out.println("데이터를 보낸다.");
    }
}

//ReceiveAction 수신클래스
public class ReceiveAction implements Action {
    @Override
    public void execute(){
        System.out.println("데이터를 받는다.");
    }
}

//동적 객체 생성 및 실행
public class NewInstanceExample{
    public static void main(String[] args){
        try{
            Class clazz = Class.forName("패키지명.클래스명");
            Action action = (Action)clazz.newInstance(); //newInstance() 반환값이 Object이기때문
            action.execute();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(InstantiationException e){
            e.printStackTrace();
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }
        
    }
    }
```