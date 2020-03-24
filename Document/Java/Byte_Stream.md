# Byte Stream (바이트 스트림)
![스트림 전체](https://user-images.githubusercontent.com/60641307/77149510-18826b00-6ad5-11ea-942c-a02acfea9ef7.jpg)

- [FileInputStream / FileOutputStream](#FileInputStream-/-FileOutputStream)
- [DataInputStream / DataOutputStream](#DataInPutStream-/-DataOutputStream)

>binary 데이터를 출력하는 스트림이다.<br>이미지,동영상 등을 송수신할 때 주로 사용한다.
- InputStream / OutputStream
    - **InputStream** : 데이터를 읽어 들이는 객체
    - **OutputStream** : 데이터를 써서 보내는 객체
    - byte 기반 input / ouput stream의 최고 조상
- ByteArrayInputStream / ByteArrayOutputStream
    - byte array(byte[])에 대한 데이터를 입출력하는 클래스
- FileInputStream / FileOutputSream
    - 파일(File)에 대한 데이터를 입출력 하는 클래스
- FilterInputStream / FilterOutputStream
    - 기본 Stream에 필터를 적용하여 입/출력시에 새로운 기능을 제공
- BufferInputStream / BufferOutputStream
    - Buffer(버퍼) : 어떤(입출력) 장치에서 다른(주기억) 장치로 데이터를 송신할 때 일어나는 시간의 차이나 데이터 흐름의 속도 차이를 조정하기 위해 일시적으로 데이터를 기억시키는 장치
    - 준비된 시스템 버퍼를 이용하여 파일 입/출력 속도 향상 
    
- DataInputStream / BufferOutputStream
    - 자바의 기본 자료형 데이터를 바이트 스트림으로 입출력하는 기능을 제공

## Byte 단위 입출력
>Byte 단위 입출력 클래스는 클래스의 이름이 InputStream이나 OutputStream으로 끝난다. 
- 파일로부터 1byte씩 읽어들여 파일에 1byte씩 저장하는 프로그램을 작성
    - 파일로부터 읽어오기 위한 객체 - FileInputStream
    - 파일에 쓸 수 있게 해주는 객체 - FileOutputStream
- read() 메소드
    - byte를 리턴한다면 끝을 나타내는 값을 표현할 수가 없기 때문에, byte가 아닌 int를 리턴한다. 
    - 음수의 경우 맨 좌측 비트가 1이 된다. 읽어들일 것이 있다면 항상 양수를 리턴한다고 보면 된다.
- FileInputStream 과 FileOutputStream을 이용하여, 1바이트씩 읽어들여 1바이트씩 저장
    - read()메소드가 리턴하는 타입은 정수인데, 정수 4바이트중 마지막 바이트에 읽어들인 1바이트를 저장한다. 
    - read()메소드는 더이상 읽어들일 것이 없을 때 -1을 리턴한다.

- 파일로부터 512byte씩 읽어들여 파일에 512byte씩 저장 가능
    - byte[] buffer = new byte[512];
    - 512byte만큼 읽어들이기 위해 byte배열을 사용

>System.currentTimeMillis(); : 현재 시간을 롱타임으로 변환한다.
## FileInputStream / FileOutputStream
>직접 키보드를 통하여 입력하는 데이터는 대게 임시 자료인 경우가 많다. 중요한 자료는 대부분 데이터베이스에 저장되어 있거나 파일 시스템에 저장된다. **FileInputStream과 FileOutputStream은 바이트 단위로 파일을 통한 입출력을 처리**한다.

### FileInputStream
>FileinputStream 클래스는 InputStream클래스를 상속받은 후손 클래스로 하드 디스크상에 존재하는 파일로부터 바이트단위의 입력을 받는 클래스이다. 이 클래스는 출발 지점과 도착 지점을 연결하는 통로, 즉 **스트림을 생성하는 클래스**이다.

>생성자의 인자로는 File 객체를 주거나 파일의 이름을 직접 String 형태로 줄 수 있다.<br>일반적으로 파일의 이름을 String형태로 주는 경우가 많은데 파일이 존재하지 않을 가능성도 있으므로 Exception처리를 해야한다.

### FileOutputStream
>FileOutputStream 클래스도 OutputStream 클래스의 후손 클래스로 파일로 바이트 단위의 출력을 내보내는 클래스이다. 

>FileInputStream의 생성자와 거의 같은 형태인데 하나 더있는 생성자의 형식은 **append 처리**를위한 논리 변수를 인자로 가지고 있다. **이 값은 true로 설정되면 기존에 존재하고 있는 파일의 가장 뒷부분에 연결하여 출력한다.**
## DataInputStream / DataOutputStream

![DateStream](https://user-images.githubusercontent.com/60641307/77133378-3c7a8800-6aa6-11ea-9de9-bd4aac7da5d5.jpg)

>자바의 기본 자료형 데이터를 바이트 스트림으로 입출력하는 기능을 제공하는 ByteStream 클래스이다.

>DataInputStream과 DataOutputStream 은 FilterInputStream과 FilterOutputStrema을 상속하고 있어, 객체 생성시에 InputStream과 OutputStream을 매개변수 인자로 가진다.

>이 클래스와 입출력 장치를 대상으로 하는 입출력 클래스를 같이 이용하면 자바의 기본 자료형 데이터를 파일 등 입출력 장치로 직접 입력할 수 있다.
### DataOutputStream
- writeInt() : 정수값으로 저장
- writeBoolean() : boolean 값으로 저장
- writeDouble() : double 값으로 저장

### DataInputStream
- readInt() - 정수를 읽어들이는 메소드
- readBoolean() - boolean 값을 일어들이는 메소드
- readDouble() - double 값을 읽어들이는 메소드

>파일에 저장된 순서대로 읽어들여야 한다.
```java
FileOutputStream out1 = new FileOutputStream("파일");
//FileOutputStream 객체를 생성해서
//DataOutputStream 생성자의 파라미터로 사용한다.
DataOutputStream out2 = new DataOutputStream(out1);

Ex:2)
FileOutputStream out = null;
out = new DataOutputStream(new FileOutputStream("파일"));
```

### FileInputStream / FileOutputStream 과의 차이점
- 자바 기본 자료형 데이터를 입/출력 할 수 있다.
> FileInputStream / FileOutputStream은 byte[]단위의 데이터만 입/출력 할수 있고 DataStream Filter를 적용하면, 자바 기본 자료형(char,int,long ..)으로 데이터를 입력하고 출력할 수 있다.



