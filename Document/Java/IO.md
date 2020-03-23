# IO (Input Output)
- [Stream](#Stream(스트림))
- [Byte_Stream](#Byte-Stream(바이트-스트림))
- [Character_Stream](#Character-Stream(문자열-스트림))
- [보조 스트림](#보조-스트림)
- [Decoration_Pattern](#Decoration-Pattern(데코레이션-패턴))
- [Serializable](#Serializable(직렬화))
- [close() 쓰는이유](#close()를-쓰는-이유)
- [IOException](#자바-입출력-예외처리-Java-throws-IOException)
## Stream(스트림)
>스트림이란 **프로그램과 I/O 객체를 연결하여 데이터를 송수신 하는길**을말한다.

![img_c_stream](https://user-images.githubusercontent.com/60641307/77220552-b7b26b80-6b84-11ea-869f-272577d5ee58.png)

>자바에서는 파일이나 콘솔의 입출력을 직접 다루지 않고, 스트림(Stream)이라는 흐름을 다룬다.

>스트림(Stream)이란 실제의 입력이나 출력이 표현된 데이터의 이상화된 흐름을 의미한다. <br>즉,스트림은 운영체제에 의해 생성되는 가상의 연결 고리를 의미하며,중간 매개자 역할을 한다.

>Java SE 8 버전부터 추가된 스트림 API는  전혀 다른 개념입니다

### 입출력 스트림
>스트림은 한방향으로 통신할 수 있으므로, 입력과 출력을 동시에 처리할 수 없다.<br>따라서 스트림은 사용 목적에 따라 입력 스트림과 출력 스트림으로 구분된다.

>자바에서는 java.io 패키지를 통해 InputStream과 OutputStream 클래스를 별도로 제공하고 있다. <br>즉 , 자바에서의 스트림 생성이란 이러한 스트림 클래스 타입의 인스턴스를 생성한다는 의미이다.

|CLASS|METHOD|EXPLAIN|
|:------:|:------|:-------|
|**InputStream**|**abstract** int read()|해당 입력 스트림으로부터 다음 바이트를 읽어들임.|
||int read(byte[] b)|해당 입력 스트림으로부터 특정 바이트를 읽어들인 후, 배열 b에 저장|
||int read(byte[]b,int off,int len)|해당 입력 스트림으로부터 len 바이트를 읽어들인 후, 배열b[ off ]부터 저장함|
|**OutputStream**|**abstract** void write(int b)|해당 출력 스트림에 특정 바이트를 저장함.|
||void write(byte[] b)|배열 b의 특정 바이트를 배열 b의 길이만큼 해당 출력 스트림에 저장|
||void write(byte[] b, int off,int len)|배열 b[ off ]부터 len 바이트를 해당 출력 스트림에 저장 |
>read() 메소드는 해당 입력 스트림에서 더 이상 읽어들일 바이트가 없으면 -1을 반환해야 한다.<br>그런데 반환 타입을 byte 타입으로 하면, 0부터 255까지의 바이트 정보는 표현할 수 있지만 -1은 표현할수 없게 된다.<br>따라서 InputStream의 read() 메소드는 반환 타입을 int형으로 선언하고 있다.

### PrintStream과 PrintWriter 클래스 
- 다른 싱크 스트림을 감싸서 사용해야하는 처리 스트림이다.
- 다양한 출력형식을 제공하는 'format(String format, Object...args)' 메소드를 제공한다.
- 객체를 생성할때 autoFlush속성을 true로 하면 버퍼가 차거나 필요한 경우 버퍼를 flush한다.

### File 클래스
>(파일의 내용이 아니라)파일 자체를 관리하는 클래스
- 다음과 같은 메소드 제공
    - 파일 정보를 가져오는 메소드
    - 파일 정보를 수정하는 메소드
    - 파일을 생성/삭제하는 메소드
- 디렉토리 관리에도 사용됨
#### 사용방법
1. File 객체 생성
```java
File file = new File("poem.txt"); 
                    //▲현재 디렉토리에 있는 poem.txt
                    //에 대한 File 객체를 생성한다.
File file = new File("C:\\work\\chap10");
                    //▲C드라이브의 work디렉토리 아래에있는
                    //chap10에 대한 File 객체를 생성한다.
```
2. 파일/디렉토리 정보를 가져오는 메소드를 호출한다.

```java
Boolean isThere = file.exists();
                    //▲ 파일 또는 디렉토라기 있으면 true
                    //없으면 false를 리턴
Boolean isFile = file.isFile();
                    //▲ 파일이면 true
                    //아니면 false를 리턴
Booelan isDir = file.isDirectory();
                    //▲ 디렉토리이면 true
                    //아니면 false를 리턴
```

3. 파일/디렉토리 정보를 가져오는 메소드를 호출한다.(계속)

```java
String name = file.getName();//이름 리턴
long size = file.length();   //크기 리턴
long time = file.lastModified();//최종 수정일시를 리턴
boolean readMode = file.canWrite(); //쓰기 가능여부를 리턴
boolean hiddenmode = file.isHidden();//숨김 여부를 리턴
String parent = file.getParent(); //부모 디렉토리 경로명을 리턴

Files childs[] = file.listFiles();
                    //▲ 서브디렉토리와 파일들의 목록을
                    // 리턴하는 메소드
public class FileExample {

    public static void main(String args[]) {
        File file = new File(".");
        File arr[] = file.listFiles();
        for (int cnt = 0; cnt < arr.length; cnt++) {
            String name = arr[cnt].getName();    
            if (arr[cnt].isFile())
                System.out.printf("%-25s %7d ", name, arr[cnt].length());
            else
                System.out.printf("%-25s   <DIR> ", name);
            long time = arr[cnt].lastModified();     
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTimeInMillis(time);
            System.out.printf("%1$tF %1$tT %n", calendar);
        }
}
	}
```

#### 파일/디렉토리 생성/삭제하기
- 파일을 생성하고 삭제하는 메소드
- 디렉토리를 생성하고 삭제하는 메소드

```java
//파일|디렉토리 생성/삭제
File file1 = new File("poem.txt");
file1.createNewFile();  //파일생성
file1.mkdir();//디렉토리 생성

File file2 = new File("C:\\doc\\회의록.hwp");
file.delete(); //삭제는 메소드 동일
```

- 임시 파일 생성하기

```java                                 
                                         //▼ .txt로 끝나는 
File tmpFile = file.createTempFile("tmp",".txt",tmpDir);//임시파일을 tmpDir에 생성
                                  //▲ tmp로 시작하고
                                  
public class FileExample2 {
    public static void main(String args[]) {
        FileWriter writer = null;
        try {
            File file = File.createTempFile("tmp", ".txt", new File("C:\\temp"));
            writer = new FileWriter(file);
            writer.write('자');
            writer.write('바');
        }
        catch (IOException ioe) {
            System.out.println("임시 파일에 쓸 수 없습니다.");
        }
        finally {
            try {
                writer.close();
            }          
            catch (Exception e) {
            }
        }
    }
	}

```
## Byte Stream(바이트 스트림)
>자바에서 스트림은 기본적으로 바이트 단위로 데이터를 전송한다.

![IOStream](https://user-images.githubusercontent.com/60641307/77221534-bfc2d900-6b8d-11ea-9151-bb7fa07f69dc.gif)

|**InputStream**|**OutputStream**|**IO target**|
|:------:|:------:|:------:|
|FileInputStream|FileOutputStream|파일|
|ByteArrayInputStream|ByteArrayOutputStream|메모리|
|pipedInputStream|PipedOutputStream|프로세스|
|AudioInputStream|AudioOutputStream|오디오 장치|

## Character Stream(문자열 스트림)
>자바에서 스트림은 기본적으로 바이트 단위로 데이터를 전송한다.<br>하지만 자바에서 가장 작은 타입인 char 형이 2바이트이므로, 1바이트씩 전송되는 바이트 기반 스트림으로는 원할한 처리가 힘든 경우가 있다.

>따라서 자바에서는 바이트 기반 스트림뿐만 아니라 문자 기반 스트림도 별도로 제공한다.<br>이러한 문자 기반 스트림은 기존의 바이트 기반 스트림에서 **InputStream -> Reader, OutputStream -> Writer** 로 변경하면 사용할수 있다.

![chracter](https://user-images.githubusercontent.com/60641307/77221528-b46fad80-6b8d-11ea-88ea-c952c26ba2b0.gif)

|**Reader(입력)**|**Writer(출력)**|**IO target**|
|:-----:|:-----:|:-----:|
|FileReader|FileWriter|파일|
|CharArrayReader|CharArrayWriter|메모리|
|PipeReader|PipeWriter|프로세스|
|StringReader|StringWriter|문자열|

## 보조 스트림
>자바에서 제공하는 보조 스트림은 실제로 데이터를 주고받을 수는 없다.<br>다른 스트림의 기능을 향상시키거나 새로운 기능을 추가해주는 스트림이다.

### Bufferd
>버퍼는 데이터를 한 곳에서 다른 한 곳으로 전송하는 동안 일시적으로 그 데이터를 보관하는 메모리의 영역이다

>운영체제는 유저의 어플리케이션 버퍼와 같은 사이즈인 Non페이지한 시스템 버퍼를 할당한다. <br> 쓰기 작업이 발생할 때는 드라이버 스택을 호출하기 전에 I/O관리자는 유저의 데이터를 시스템 버퍼에 복사한다.<br>읽기 작업이 발생할 때는 드라이버 스택의 요청 작업이 완료된 후 시스템 버퍼를 유저 영역에 복사한다.

- 즉, 유저 영역의 데이터를 드라이버의 버퍼로 가져올 떄, **드라이버 스택 전에 복사를 마친후 호출**한다.
    - [유저 -> 시스템 버퍼(IRP)]

- 반면에 시스템 드라이버의 버퍼에서 유저 영역의 버퍼로 데이터를 복사할 때는 **드라이버에서의 활동이 모두 마친후, 유저 영역의 데이터로 복사**
    - [시스템 버퍼 -> 유저]

>서비스와 **상호 동작**하거나 **느린 디바이스** 또는 한번에 상대적으로 **적은 양의 데이터**를 주고받는 드라이버의 경우에 **buffered I/O 전송 방식**을 사용한다.

>적은양의 buffered I/O방식을 사용하면 상호 동작하는 전송에 있어서 적은 양의 물리 메모리를 소비해도 가능하다. 그 이유는 메모리 관리자는 이 buffred I/O방식을 위해서 **매번 통신 할 때 마다 할당된 메모리를 lock**할 필요가 없다.

>일반적으로 비디오,키보드,마우스,가상드라이버들이 buffred I/O 방식을 사용

> **데이터를 전달 할 때마다 페이지를 할당하고 lock(해당 데이터 전달을 위해서 메모리를 묵어 놓는 방식)하지 않고 적은양의 데이터 송/수신에 사용한다.**



##### Byte Stream

|**InputStream**|**OutputStream**|**Explain**|
|:-----:|:-----:|:-----|
|FilterInputStream|FilterOutputStream|필터를 이용한 입출력|
|BufferedInputStream|BufferedOutputStream|버퍼를 이용한 입출력|
|DataInputStream|DataOutputStream|입출력 스트림으로부터 자바의 기본 타입으로 데이터를 읽어올수 있게함|
|ObjectInputStream|ObjectOutputStream|데이터를 객체 단위로 읽거나,읽어 들인 객체를 역직렬화시킴|
|SequencInputStream|X|두 개의 입력 스트림을 논리적으로 연결함|
|PushbackInputStream|X|다른 입력 스트림에 버퍼를 이용하여 push back이나 unread와 같은 기능을 추가함|
|X|PrintStream|다른 출력 스트림에 버퍼를 이용하여 다양한 데이터를 출력하기 위한 기능을 추가함|

##### Character Stream

|**Reader(입력)**|**Writer(출력)**|**Explain**|
|:-----:|:-----:|:-----|
|FilterReader|FilterWriter|필터를 이용한 입출력|
|BufferedReader|BufferedWriter|버퍼를 이용한 입출력|
|PushbackReader|X|다른 입력 스트림에 버퍼를 이용하여 pushb back이나 unread와 같은 기능을 추가|
|X|PrintWriter|다른 출력 스트림에 버퍼를 이용하여 다양한 데이터를 출력하기 위한 기능을 추가|

#### I/O 클래스의 이름과 의미
- **Stream**으로 끝나는 클래스 : 바이트 단위로 입출력을 수행하는 클래스
- **Reader** / **Writer**로 끝나는 클래스 : Character 단위로 입출력을 수행하는 클래스
- **File**로 시작하는 클래스 : 하드디스크의 파일을 사용하는 클래스
- **Data**로 시작하는 클래스 : 자바의 원시 자료형을 출력하기 위한 클래스
- **Buffered**로 시작하는 클래스 : 시스템의 버퍼를 사용하는 클래스


## Decorator Pattern (데코레이터 패턴)
>하나의 클래스를 장식하는 것처럼 생성자에 감싸서 새로운 기능을 계속 추가 할 수 있도록 클래스를 만드는 방식
- 자바의 입출력 스트림은 데코레이터 패턴을 사용
- 실제 입출력 기능을 가진 객체(컴포넌트)와 그 외 다양한 기능을 제공하는 데코레이터(보조스트림)을 사용하여 다양한 입출력 기능을 구현
- 상속보다 유연한 확장성을 가짐
- 지속적인 서비스의 증가와 제거가 용이함




## Serializable(직렬화)
>자바 직렬화란 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부의 자바 시스템에서도 사용할 수 있도록 바이트(byte)형태로 데이터 변환하는 기술과 바이트로 변환된 데이터를 다시 객체로 변환하는 기술(역직렬화)를 아울러서 이야기한다.

>시스템적으로 이야기하면 JVM의 메모리에 상주(힙 또는 스택)되어있는 객체 데이터를 바이트 형태로 변환하는 기술과 직렬화된 바이트 형태의 데이터를 객체로 변환해서 JVM으로 상주시키는 형태를 같이 이야기한다.
- 인스턴스의 상태를 그대로 저장하거나 네트워크로 전송하고 이를 다시 복원(Deserializtion)하는 방식
- **ObjectInputStream**과 **ObjectOutputStream** 사용해서 사용
- 보조 스트림
### Serializable 인터페이스
- 직렬화는 인스턴스의 내용이 외부(파일,네트워크)로 유출되는 것이므로 프로그래머가 객체의 직렬화 가능 여부를 명시,
- 구현 코드가 없는 mark interface
- implements Serializable [직렬화표시]
>Ex:)

```java
class Person implements Serializble{
    String name;
    //transient 직렬화 하지 않을 경우 transient를 사용 소켓은 직렬화 X
    transient String job;

    public Person(String name,String job){
        this.name = name;
        this.job = job;
    }
    public String toString(){
        return name+","+job;

    }
}

public class SerializationTest{
    public static void main(String[] args){
        Person personLee = new Person("이순신","엔지니어");
        Person personKim = new Person("김유신","선생님");

        try{
            FileOutputStream fos = new FileOutputStream("serial.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos)){
                    oos.WriteObject(personLee);
                    oos.WriteObject(personKim);
                }catch(IOException e){
                    System.out.println(e);
                }finally{
                    try{
                        fos.close();
                        oos.close();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
    }
    try{
        FileInputStream fis = new FileInputStream("serial.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Person p1 = (Person)ois.readObject();
            Person p2 = (Person)ois.readObject();

            System.out.println(p1);
            System.out.println(p2);
    }catch(IOException e){
        System.out.println(e);
    }catch(ClassNotFoundException e){
        System.out.println(e);
    }finally{
        try{
            ois.close();
            fis.close();
        }catch(Excpetion e){}
    }
}
}
```


### 자바 직렬화 조건
>자바 기본(primitive)타입과 java.io.Serializable 인터페이스를 상속받은 객체는 직렬화 할 수 있는 기본 조건을 가진다.

```java
//직렬화 할 회원 클래스
public class Member implements Serializable{
    private String name;
    private String email;
    private int age;

    public Member(String name, String email, int age){
        this.name = name;
        this.email = email;
        this.age = age;
    }
    //Getter 생략
    @Override
    public String toString(){
        return String.format("Member{name='%s',email='%s',age='%s'}",name,email,age);
    }
}
```
### 직렬화 방법
>java.io.ObjectOutputStream 객체를 이용한다.

```java
Member member = newMember("김배민","deliverykim@beamin.com",25);
byte[] serializedMember;
try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
    try(ObjectOutputStream oos = new ObjectOutputStream(baos)){
        oos.writeObject(member);
        // serializedMember -> 직렬화된 member 객체
        serializedMember = baos.toByteArray();
    }
}
//바이트 배열로 생성된 직렬화 데이터를 base64로 변환
System.out.println(Base64.getEncoder().encodeToString(serializedMember));
}//객체를 직렬화 하여 바이트 배열 (byte[])형태로 변환하였다.
```
## close()를 쓰는 이유
>finally 에서 독립적으로 close()메소드를 써야한다. 그 이유는??

```java
try{

}catch{

}finally{
    try{

    }catch{

    }
}
```
0. close는 기본 원칙이다.
1. 메모리가 낭비되는걸 막기위해.(gc를 너무 믿지마라..)
2. 다른 프로그램이나 쓰레드가 접근을 못한다.
3. close 내부에는 flush가 존재
    - 그래서 close()시에 남은 내용을 모두 flush 하면서 파일이 써진다.
    - close() 안해도 내부적으로 flush 호출하면 파일은 생성된다.
        - 물론 close()를 안해도 된다는 얘기는 아니다.

### try-with-resources 블럭선언 
- java.io 객체는 인스턴스를 만들고, 모두 사용하면 close() 메소드를 호출해야 한다.
- close() 메소드를 사용자가 호출하지 않더라도, Exception이 발생하지 않았다면 자동으로 close()가 되게 할수있는 방법이다.

```java
try(
    // io객체 선언
){
    // io객체 사용
}catch(Exception e){
    e.printStackTrace();
}
```


## 자바 입출력 예외처리 Java throws IOException
>**자바 입출력 예외처리**컴퓨터 프로그램이 실행될 때 언제 어떤 문제가 발생할지 모르는 일이기 때문에 프로그램을 만들 때는 예외로 발생하는 상황에 대처해야 하는데 자바는 입력과 출력을 할 때 발생할 수 있는 예외에 대해서 까다롭게 규정하고 있다. 그래서 입력과 출력을 다루는 메소드에 예외처리가 없다면 컴파일 에러가 발생하게 된다.

- print(),println(),printf() 메소드에만 자체적으로 예외처리를 해놨기 때문에 이 메소드들은 따로 예외처리할 필요가없다.

### FileNotFoundException
>디스크에 없는 파일에 대한 액세스 시도가 실패할 때 예외가 throw 된다.<br>== 지정된 파일을 찾을 수 없습니다.

### EOFException
>입력의 도중에 예상외의 파일의 종료, 또는 예상외의 스트림의 종료가 있던 것을 나타내는 시그널<br>주로 데이터 입력 스트림의 종료를 알리기 위해서 사용됨<br>다만, 다른 많은 입력 조작에서는 스트림이 종료했을 때에 예외를 Throw하지 않고 특정의 값을 리턴한다.

### ClassNotFoundException
>지정된 이름의 클래스의 정의가 발견되지 않은 경우에 예외를 발생시킨다.

