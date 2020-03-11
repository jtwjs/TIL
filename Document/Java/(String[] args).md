# public static void main(String[] args){} 
## JAVA의 main() 메소드
>**자바 프로그램의 시작지점(Entry point)는 main() 메소드**이다.<br>main()메소드는 프로그램의 시작점이기 때문에 반드시 main()메소드를 구현한 public class가 하나는 있어야한다. main()메소드는 프로그램의 흐름을 최초로 시작하는 메인 스레드이기도 하다.
## (String[] args)명령행 매개변수
>main 메소드가 받는 인자값으로 String 배열을 받고있다. 이 String 배열은 콘솔 명령행을 통해 프로그램이 시작될 때 추가적으로 넘겨받는 값들을 저장하는 배열이다. 프로그램 시작과 동시에 값을 넘겨주어야 하는 프로그램을 작성할때 유용하다.

## 명령행으로 받은 인자값 출력하기
>main 메소드에서 받은 인자값은 args 배열을 통해 들어온다.
```java
public class Ex{
    public static void main(String[] args){
        for(int i=0; i<args.length; i++)
            System.out.println("args["+i+"] = "+args[i]);
            }
}
```

>콘솔을 통해 자바 프로그램을 실행할때는 다음과 같이 실행한다.(컴파일되어있어야함)

```
//아무런 값도 넘겨주지 않았으므로  아무런 결과도 출력되지 않는다.
>java Ex 

//명령행을 통해 넘겨줄 인자가 있는경우 스페이스바(공백)단위로 값을 넘겨줄수 있다.
>java Ex Hello World
args[0] = Hello
args[1] = World

//띄어쓰기를 포함하여 하나의 인자로서 넘겨주고 싶은 경우 ""로 묶음
>java Ex "Hello World"
args[0] = Hello World

//"(쌍따옴표) 그대로 넘겨주고 싶은경우 역슬래시로 이스케이프처리하여 넘김
>java Ex "Hello \"World\""
args[0] = Hello "World"


```
