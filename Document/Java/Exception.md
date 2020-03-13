# Exception(예외)
> Exception은 프로그램 실행 중에 발생할 수 있는 예기치 않은 사건으로 프로그래머의 노력으로 처리할 수 있다.<br>자바 가상 머신은 프로그램 실행중에 예외가 발생하면 관련된 예외 클래스로부터 예외 객체를 생성하여 프로그램에서 지정된 예외 처리 구문으로 넘긴다. 프로그램에 지정된 예외 처리 구문은 예외가 발생하면 자바 가상 머신에 의해 호출되고 예외 객체를 자바 가상 머신으로부터 넘겨받아 적절한 처리를 수행한다.

> Exception(예외)은 일종의 오류로 두 가지로 나눌수 있다.
1. 문법 오류 : 오타와 같이 자바 구문에 어긋난 코드 때문에 발생,컴파일시 발생하는 오류
2. 실행 오류 : 프로그램 실행시 상황에 따라 발생하는 오류

## Exception Class
![217C6B4552AF12B432](https://user-images.githubusercontent.com/60641307/76583136-c2815680-651b-11ea-806e-2b37b50b5b57.jpg)
>자바의 예외는 java.lang.Throwable 클래스의 하위 클래스인 java.lang.Exception 클래스에서 취급한다.

- ArithmeticException : 산술 연산 오류(정수를 0으로 나누는 경우)
- IndexOutOfBoundsException : 배열의 인덱스가 배열의 길이를 넘을 때
- IllegalArgumentException : 메소드의 매개변수 유형을 잘못 사용할 때
- IOException : 입출력시에 지정한 파일이 시스템에 존재하지 않을 때

## 예외의 종류와 특징
1. Error
>java.lang.Error 클래스의 서브클래스들이다.<br>에러는 시스템에 뭔가 비정상적인 상황이 발생했을 경우에 사용된다.<br>그래서 주로 JVM에서 발생시키는 것이고 어플리케이션 코드에서 잡으려고 하면 안된다.<br>OutoMemoryEroor나 ThreadDeath같은 에러는 catch 블록으로 잡아도 대응방법이 없다. <br>따라서 시스템 레벨이나 특별한 작업을 하는게 아니라면 어플리케이션에서는 이런 에러에 대한 처리는 신경쓰지 않아도된다.
2. Exception과 체크 예외
>에러가 아닌 Exception 클래스는 체크 예외와 언체크 예외로 구분된다.
- 체크예외 : Exception 클래스의 서브클래스이면서 RuntimeException 클래스를 상속하지 않은 것들
- 언체크예외 : RuntimeException을 상속한 클래스
3. RuntimeException과 언체크/런타임 예외(RuntimeException)
>java.lang.RuntimeException 클래스를 상속한 예외들은 명시적인 예외처리를 강제하지 않기 때문에 언체크 예외라고 불린다.<br> 또는 대표 클래스 이름을 따서 런타임예외(RuntimeException)라고도 한다<br>에러와 마찬가지로 이 **런타임예외는 catch문으로 잡거나 throws로 선언하지 않아도 된다.**<br> 이런예외는 코드에서 미리 조건을 체크하도록 주의 깊게 만든다면 피할수있다.<br> 피할수 있지만 개발자가 부주의해서 발생할 수 있는 경우에 발생하도록 만든 것이 런타임에외이다.
## try문
>익셉션 처리에 사용되는 명령문

```java
//기본형식
try{
    try블록
}catch(익셉션타입 익셉션변수){  //catch절(catch clause).반복가능
    catch블록
}finally{                    //finally절(finally clause).생략가능
    finally블록
}

//Ex1
class TryExample{
    public static void main(String args[]){
        int a = 3, b = 0;
        int result;
        try{                   //이 부분 실행하다가 익셉션이 발생하면
            result = a/b;
            System.out.println(result);
        }
        catch(java.lang.ArithmeticException e){//이 부분을 실행한다.
            System.out.println("잘못된 연산입니다.");
            System.out.println(e.getMessage()); // 익셉션 메세지를 출력
        }
        finally{        //이 부분은 익셉션 발생 유무와 상관없이 실행
            System.out.println("Done");
        }
    }
}

//Ex2
int divisor[] = {5,4,3,2,1,0};
for(int cnt = 0; cnt<10; cnt++){
    try{
        int share= 100/divisor[cnt];
        System.out.println(share);
    }
    catch(java.lang.ArithmeticException e){//catch블록 중복가능
        System.out.println("잘못된 연산입니다.");
    }
    catch(java.lang.ArrayIndexOutOfBoundsException e){
        System.out.println("잘못된 인덱스입니다.");
    }
    catch(java.lang.Exception e){ //Exception:모든 예외처리의 부모클래스(모든 예외처리)
                    //예외처리 기술을할때 부모예외처리는 자식예외처리보다 아래에 있어야한다.
        System.out.println("잘못된 인덱스입니다.");
    }
    System.out.println("Done"); 

/*결과값
20
25
33
50
100
잘못된 연산입니다.
잘못된 인덱스입니다.
잘못된 인덱스입니다.
잘못된 인덱스입니다.
잘못된 인덱스입니다.
Done.
*/
}
```
## throws (예외 떠넘기기)
>메서드 내부에서 예외가 발생했을 때 예외를 try -catch문으로 잡아서 처리할 수 있지만 경우에 따라서 현재 메소드를 호출한 메소드로 예외를 떠넘길수 있다.
```java
// throws 키워드를 메서드 뒤에 붙여주면 된다.
public sattic void generateException() throws NullpointerException{
    //NullPointerException 발생
}

//떠넘겨야할 예외 종류가 여러개라면 쉼표(,)를 기준으로 나열하여 선언  
public static void generateException() throws NullPointerException,ArithmeticException{
    //예외 발생
}
```
>예외가 발생하는 경우 try -catch 문을 통해 처리하지 않고 throws를 이용해 떠넘기면 현재 메소드를 호출한 곳으로 던져지게된다. 만약 모든 메소드에서 throws를 이용해 예외를 떠넘기다보면 최초 호출 지점인 main() 메소드 내부로 예외가 던저지게 되며 main()메소드에서 마저 예외를 떠넘기게 된다면 JVM 예외처리기 까지 도달하여 프로그램은 그대로 종료하게된다.(매우 무의미한 행동)

![992CED395A44C6F410](https://user-images.githubusercontent.com/60641307/76582972-3cfda680-651b-11ea-9c64-4034d73570d1.png)

### 예외를 떠넘기는 이유
>예외가 발생한 경우 굳이 메서드 내에서 try-catch문으로 예외를 처리하지않고 throws문으로 떠넘기는 이유
1. 메소드 선언부에 선언된 thorws 문을 통해 해당 API를 사용했을 때 어떤 예외가 발생할수 있는지를 예측할수 있다.
2. 현재 메소드 내에서 예외를 처리할 필요가 없다고 판단했을 경우

### thorw와 thorws의 차이점
> thorw가 예외를 발생시키는 것, throw와throws도 예외를 던지는 것.
- throw : 메소드내에서 상위블록으로 예외를 던짐
- throws : 현재 메소드에서 상위 메소드로 예외를 던짐
>throw는 억지로 에러를 발생시킬때도 사용되지만 현재 메소드의 에러를 처리한 후에 상위 메소드에 에러정보를 줌으로써 상위 메소드에서도 에러가 발생한 것을 감지할수 있다.

>**throws는 책임전가**이고 **throw는 프로그래머의 판단에 따른 처리**이다.

```java
public void doSomething() throws Exception{
    //....
    if(....){
        throw new Excpetion();
    }
    //....
}
```
#### throws 
>메소드나 생성자를 수행할 때 발생하는 exception을 선언할 때 사용하는 keyword
- trhows는 예외를 전가시키는 것
    - 예외를 자신이 처리하지 않고,자신을 호출하는 메소드에게 책임을 전가
>메소드를 정의할 때 throws 예약어를 시그내처에 추가하면 그 메소드를 호출하는 곳에서 예외 처리를 해야한다.