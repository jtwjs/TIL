# Character Stream (문자 스트림)
![문자스트림](https://user-images.githubusercontent.com/60641307/77131106-cc680400-6a9d-11ea-8fc1-a1c9b36c5779.jpg)

- [FileReader / FileWriter](#FileReader-/-FileWriter)

>말 그대로 text 데이터를 입출력하는데 사용하는 스트림이다.<br>HTML 문서,텍스트 파일을 송수신할 때 주로 사용한다.

- Reader / Writer
    - Character 기반 input / output stream의 최고 조상
- FileReader / FileWriter
    - 문자 기반의 파일을 입출력 하는 클래스

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