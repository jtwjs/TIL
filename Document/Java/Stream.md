# Stream(스트림)
>스트림이란 **프로그램과 I/O 객체를 연결하여 데이터를 송수신 하는길**을말한다.

## I/O 클래스의 이름과 의미
- **Stream**으로 끝나는 클래스 : 바이트 단위로 입출력을 수행하는 클래스
- **Reader** / **Writer**로 끝나는 클래스 : Character 단위로 입출력을 수행하는 클래스
- **File**로 시작하는 클래스 : 하드디스크의 파일을 사용하는 클래스
- **Data**로 시작하는 클래스 : 자바의 원시 자료형을 출력하기 위한 클래스
- **Buffered**로 시작하는 클래스 : 시스템의 버퍼를 사용하는 클래스

- 1차 Stream : 입/출력 통로를 직접 만드는 클래스
- 2차 Stream : 기존의 통로를 이용하여 새로운 기능을 더하는 클래스


## 보조 스트림
>**보조 스트림이란 "프로그램에서"파일을 읽기/쓰기** 할 수 있도록 해주며, 위에서 소개한 클래스들은 주 스트림으로써 "외부에서" 파일 읽기/쓰기를 수행한다.

- FilterInputStream / FilterOutputStream
    - byte 기반 보조 스트림의 최고 조상
- BufferedInputStream / BufferedOutputStream
    - 입출력 효율을 높이기 위해 버퍼(byte[])를 사용하는 보조스트림
- BufferedReader / BufferedWriter
    - 입출력 효율을 높이기 위해 버퍼(char[])을 사용하는 보조스트림
    - 라인 단위의 입출력에 용이
- InputStreamReader / OutputStreamReader
    - byte기반 스트림을 character 기반 스트림처럼 쓸수 있도록 함
    - 인코딩 변환 가능

## InputStream / OutputStream (바이트 입출력)

![스트림 전체](https://user-images.githubusercontent.com/60641307/77149510-18826b00-6ad5-11ea-942c-a02acfea9ef7.jpg)



## Serializable(직렬화)
- 자바 직렬화란 자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부의 자바 시스템에서도 사용할 수 있도록 바이트(byte)형태로 데이터 변환하는 기술과 바이트로 변환된 데이터를 다시 객체로 변환하는 기술(역직렬화)를 아울러서 이야기한다.
- 시스템적으로 이야기하면 JVM의 메모리에 상수(힙 또는 스택)되어있는 객체 데이터를 바이트 형태로 변환하는 기술과 직렬화된 바이트 형태의 데이터를 객체로 변환해서 JVM으로 상주시키는 형태를 같이 이야기한다.

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