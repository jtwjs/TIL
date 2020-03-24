# Character Stream (문자 스트림)

![문자 전체](https://user-images.githubusercontent.com/60641307/77149533-22a46980-6ad5-11ea-8a6a-b042e592d560.jpg)
- [FileReader / FileWriter](#FileReader-/-FileWriter)



>말 그대로 text 데이터를 입출력하는데 사용하는 스트림이다.<br>HTML 문서,텍스트 파일을 송수신할 때 주로 사용한다.

- Reader / Writer
    - Character 기반 input / output stream의 최고 조상
- FileReader / FileWriter
    - 문자 기반의 파일을 입출력 하는 클래스

## Char 단위 입출력(Console)
>char단위 입출력 클래스를 이용해서 키보드로부터 한줄 입력 받아 콘솔 출력
- System.in : 키보드를 의미(InputStream)
- BufferedReader : 한줄씩 입력받기 위한 클래스
- BufferedReader 클래스의 생성자는 InputStream을 입력받는 생성자가 없다.
- System.in은 InputStream 타입이므로 BufferedReader의 생성자에 바로 들어갈수 없으므로 InputStreamReader 클래스를 이용한다.

```java
public class CharIOExample1{
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        //키보드로 입력받을 문자열을 저장하기 위해 line 변수 선언
        try{
            line = br.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(line); //콘솔출력
    }
}
```
## Char 단위 입출력(File)
>파일에서 한 줄씩 입력 받아서 파일에 출력
- 파일에서 읽기위해서 FileReader 클래스 이용
- 한 줄 읽어 들이기 위해서 BufferedReader 클래스 이용
    - BufferedReader 클래스가 가지고 있는 readLine() 메소드가 한줄씩 읽게 한다.
    - readline() 메소드는 읽어낼 때 더이상 읽어 들일 내용이 없을 때 null값 반환
- 파일에 쓰게하기 위해서 FileWriter 클래스 이용
- 편리하게 출력하기 위해서 PrintWriter 클래스 이용

```java
public static void main(String[] args){
    BufferedReader br =null;
    PrintWrtier pw = null;
    try{
        br = new BufferedReader(new FileReader("읽을 파일 경로"));
        pw = new PrintWriter(new FileWriter("test.txt"));
        String line = null;
        While((line = br.readLine())!= null){
            pw.println(line);
        }
    }catch(Exception e){
        e.printStackTrace();
    }finally{
        pw.close();
        // PrintWrite 클래스가 정의하고 있는 close() 메소드는 
        // excpetion을 trhows하고 있지 않기 떄문에
        // 사용하는 쪽에서 처리할 필요가 없는것!
        try{
            br.close();//BufferedReader 클래스의 close() 메소드는
            //throws IOException 정의 되있어서 사용하는 쪽에서 예외처리해주어야함
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
```
>[!]Exception
- checked Exception은 반드시 예외처리를 해야한다.
1. try-catch 블럭을 이용해서 직접 처리하는 방법
2. throws 해서 해당 메소드를 사용하는 쪽에서 처리하는 방법
    - throws 했다는것은 직접 excpetion 처리를 안했다는말임 

## FileReader / FileWriter 

- **FileReader** : 파일로부터 입력을 위한 스트림을 생성하는 클래스로 데이터가 입력될 파일의 정보를 인자로 받는다.
- **FileWriter** : 파일로 데이터를 출력하기 위한 출력 스트림을 제공한다.

- boolean append : True면 파일의 끝에 출력 데이터를 삽입, False면 파일에 덮어쓴다.

>FileReader/FileWriter의 메소드는 상위 클래스 (java.lang.Object,java.io.Writer,java.io.OutputStreamWriter)를 상속받는다.
### 사용 방법
1. 파일 OPEN

```java
FileReader reader = new FileReader("파일경로"); 
```
2. 파일 READ

```java
data= reader.read();
            //▲이 메소드는 파일에 있는 문자 하나를 읽어서 리턴한다.
            //문자열을 읽었지만 return type은 int
            //(자바는 int보다 작은타입은 모두 int로 변환하기때문)
while(true){
int data =reader.read();  //데이터를 읽어서
if (data<0)                //마이너스 값이면 반복을 중단하고
    break;
char ch = (char)data;      //아니면 char 타입으로 캐스트한다.

데이터 처리 로직이 들어가는 부분 //데이터 처리 로직이 들어가는 부분
}

```
3. 파일 CLOSE

```java
reader.close();
        //▲ 파일을 닫는 메소드
```
- EoF : -1 로 정의된 상수

### FileReader / FileWriter와 FileInputStream / FileOutputStream의 차이
- 공통점 : 두 종류의 객체 모두 데이터를 입력하고 출력하는 객체이다.
>FileInputStream / FileOutputStream과 FileReader /FileWriter 모두 File에 데이터를 입력하고 출력하는 객체이다.
- 차이점 : 상속받는 객체가 다르다.
    - :FileInputStream/FileOutputStream 는 Byte단위의 입출력 처리
        - :1byte 이상의 문자인 한글 등을 처리하기 위해 **버퍼를 사용해서 처리**
    - :FileReader/FileWriter 는 바이트를 문자(Char)로 변환하여 입출력처리
        - :버퍼를 사용하지않고도 한글처리 가능
>FileInputStream / FileOutputStream은 InputStream / OutputStream을 상속 받고 있으며, FileReader / FileWriter는 Reader와 Writer을 상속받고 있다.

## PrintWriter
>File(String), OutputStream, Writer 등의 객체를 인수로 받아 더 간편하게 스트림을 연결할 수 있다.

|Method|Explain|
|:-----|:------|
|print()|boolean,int,char,float,double 등등의 데이터형을<br>String으로 변환해서 쓰지 않고 직접 입력해줍니다.|
|println()|print할 데이터 뒤에 /n을 추가하여<br>데이터와 함께 개행을 출력한다.|

