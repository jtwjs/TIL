## GUI (Graphic User Interface) 
>사용자가 그래픽을 통해 컴퓨터와 정보를 교환하는 작업 환경

![GUI](https://user-images.githubusercontent.com/60641307/78314802-048b3e80-7596-11ea-9f8c-92605ba7680e.png)

---
- java.awt 패키지의 클래스 이용
    - heavy weight Component
    - OS의 리소스를 많이 소모하여 부담을 많이 줌
    - OS환경에 따라 다르게 구현될수 있음
    - 느리고 무거움
- javax.swing 패키지의 클래스 이용
    - AWT기술을 기반으로 작성된 라이브러리, 순수 자바언어로 작성됨
    - light weight Component
    - OS에 상관없이 작동
    - 빠르고 가벼움
    - AWT Component와 구분하기 위해 앞에 'J'를 붙인다.

- MVC 패턴 (Model-View-Controller)
    - Model : 데이터를 가져와 어떤 작업을 처리하거나 처리한 작업을 저장
    - View : 데이터를 보여주는 역할
    - Controller : 뷰와 모델 사이의 흐름제어

- Component : 화면을 구성하는 부품
    - Container에 포함되어야 비로소 화면에 출력될수 있는 GUI 객체
    - 모든 GUI 컴포넌트의 최상위 클래스 : java.awt.Component
    - 스윙 컴포넌트의 최상위 클래스 : javax.swing.JComponent

- Container : Component로부터 상속받은 하나의 윈도우 영역을 의미
    - 다른 Component를 포함할 수 있는 GUI Component
    - java.awt.Container를 상속받음
    - 다른 Container에 포함될 수 있음
    - AWT Container : Panel,Frame,Applet,Dialog,Window
    - Swing Container : JPanel,JFrame,JApplet,JDialog,JWindow
    - 최상위 Container : 다른 컨테이너에 속하지 않고 독립적으로 존재 가능
        - JFrame, JApplet, JDialog

---
## Swing GUI 

```
0. import javax.swing.*; (Swing package 이용)
1. Frame 만들기 (최상위 컨테이너 만들기)
2. Frame에 Swing Component 붙이기
3. main() 메소드 작성
```

### Swing Frame
- 모든 Swing Component를 담는 최상위 Container
- Frame이 있어야 GUI 화면 출력이 가능하고 Frame 내에 부착된 모든 Component들이 화면에 출력됨
- Swing 의 Frame 클래스 -> JFrame 클래스 
    - Frame(java.awt.Frame), Menu Bar, Content Pane - 세 공간으로 구성됨
- JFrame을 만드는 방법
    - JFrame 객체를 직접 생성하는 방법
        - 단순하지만 Frame에 Swing Component를 추가하는 과정이 불편하며 확장성,융통성이 결여된다.
        - **권장 X**
    - JFrame 클래스를 상속받는 방법
        - JFrame을 상속받아 새로운 프레임 클래스를 작성하는 방법
        - **권장 O**

        ```java
        public class MyFrame extends JFrame{
        // 확장성, 융통성이 뛰어남 
        }
        myFrame mf = new MyFrame();
        ```
    1. 타이틀 달기
        - JFrame 클래스의 생성자를 이용
        - JFrame 클래스의 setTitle() 메소드 이용
    2. 메뉴바 붙이기
        - Menu Bar, Menu, Menu-item 를 만든뒤 JFrame의 메뉴바 영역에 붙인다.
    3. ContentPane에 Component 달기
        - Swing 에서는 ContentPane에만 Component를 부착할수 있다.
        - ContentPane은 JFrame 객체가 처음 생길 때 자동으로 생성된다.

        ```java
        JFrame frame = new JFrame();
        //Frame에 연결된 ContentPane을 알아낸다. 
        Container contentPane = frame.getContentPane();

        //ContentPane은 Container이기 때문에 간단히 add()메소드로 component 부착가능
        Jbutton b1 = new JButton("click");
        contentPane.add(b1);//버튼을 ContentPane에 부착
        
        ```
    4. Swing 응용프로그램의 종료
        - System.exit(0) : 자바 프로그램을 종료
        - frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); : 프레임이 닫힐때 프로그램도 종료
---
## Container Layout
- Component의 위치와 크기의 결정을 Container 내부의 **Layout manager**(배치관리자)가 한다.
    - 하나의 Container는 반드시 하나의 배치관리자를 갖는다.
    - 배치관리자는 Container에 Component가 들어오는 시점에 Component의 위치와 크기를 결정한다.
    - 배치관리자는 Container의 크기가 변경되면 Container 내부의 모든 Component의 위치와 크기를 재조정한다.
- 배치관리자의 유형
    - FlowLayout : 들어오는 순서대로 왼쪽에서 오른쪽으로 배치 공간없으면 아래로 내려와서 반복
    - BorderLayout : 공간을 동,서,남,북,중앙의 5개 영역으로 나누고 지정한 영역에 배치
    - GridLayout : Container 공간의 크기를 설정한 동일 크기의 2차원 그리드로 나누고 들어오는 순서대로 배치
    - CardLayout : 카드를 쌓아 놓은 듯이 컴포넌트를 쪼개어 배치 (겹침 가능)

---
## JLabel
>문자열이나 이미지를 화면에 출력하기 위한 목적
- Text Label 생성
    - JLabel label = new JLabel("문자열");
- Image Label 생성
    - 이미지 파일로부터 이미지를 읽기 위해 ImageIcon 클래스 사용
    - 다룰 수 있는 이미지 : jpg,gif,png

    ```
    ImageIcon image = new ImageIcon("이미지 경로");
    JLabel label = new JLabel(image);
    ```
- 문자열과 이미지 모두 가진 label
    - Jlabel label = new JLabel("문자열","image");    
---
## JButton
>버튼 모양의 Component, 사용자로부터 명령을 입력 받기 위한 목적<br> 버튼이 클릭될 때 Action 이벤트 발생

```
JButton() //빈 버튼
JButton(Icon image)//이미지 버튼
JButton(String text)//문자열 버튼
JButton(String text, Icon image)//문자열과 이미지 모두 가진 버튼
```
- Image Button 
    - normalIcon
        - 버튼의 보통 상태(default)의 출력되는 이미지
    - rolloverIcon
        - 버튼의 커서가 올라갈때 출력되는 이미지
        - setRolloverIcon();
    - pressedIcon
        - 버튼을 누를떄 출력되는 이미지
        - setPressedIcon();
---
## JTextField
>한줄의 문자열을 입력받는 입력창<br>입력 도중 < ENTER >키가 입력되면 Action 이벤트 발생<br>입력 가능한 문자 개수와 입력창의 크기는 서로 다름

```
JTextField() //빈 텍스트필드
JTextField(int cols) // 입력 창의 열의 개수가 cols개인 텍스트 필드
JTextField(String text) //text문자열로 초기화된 텍스트필드
JTextField(String text, int cols)//입력창의 열의 개수는 cols,text 문자열로 초기화된 텍스트필드
```
---
## JTextArea
>여러줄의 문자열을 입력받을수 있는 입력창<br>스크롤바를 지원하지 않는다.<br>JScrollPane 객체를 삽입하여 스크롤바 지원

```
JTextArea() //빈 텍스트 영역
JTextArea(int rows, int cols) //입력창이 rows * cols 개의 문자크기인 텍스트 영역
JTextArea(String text)//text문자열로 초기화된 텍스트영역
JTextArea(String text,int rows,int cols)//입력창이 rows * cols 개의 문자크기이며 text문자열로 초기화된 텍스트필드
```

## 자주쓰는 Method
- Container cp = getContentPane(); //JFRame을 상속받은클래스에서나 씀 
- setTitle(String s) : 타이틀 설정
- setSize(int width,int height) : 프레임 크기 설정
    - setSize(): 크기를 결정하는 메소드지만 layout에따라 사용못하기도 한다.
    - setPreferredSize(new Dimension(int width,intheight));
        - Dimesion객체를 인자로 받으면서 해당 컴포넌트의 기본크기를 결정
        - BorderLayout을 사용중이면 영향을 줄수 없다.
        - Dimesion 객체: 컴포넌트의 경우에는 ContantPnae 에서의 컴포넌트에서 폭과 높이를 지정하기 위해서 쓰이는 클래스
- setResizable(false) : 크기 조절 불가능
- setLocationRelativeTo(null) : 프레임 위치 중앙
- setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) :  프레임이 닫히면 프로그램 종료
- setVisible(true) : 프레임을 화면에 보이게함
- setLayout(null) : 레이아웃설정을 없애서 위치조절 설정할수 있음
- pack() : 컴포넌트들을알맞은사이즈로 자동변경

---
## JPanel
> 컴포넌트들을 그룹 별로 묶어서 처리할 때 사용하는 컨테이너 <br> 일반적으로 Frame에 컴포넌트들을 직접 붙이지 않고 Panel 사용 <br> 생성자

- JPanel() : 디폴트의 레이아웃 사용해 새로운 Panel 생성
- JPanel(LayoutManager layout) : 지정된 배치관리자를 이용하여 새로운 Panel 생성
- JPanel(boolean isDoubleBuffered) : 지정된 버퍼를 이용해 새로운 Panel 생성

## JScrollPane
> 스크롤을 이용해서 컴포넌트들을 보여주는 컴포넌트<br> 스크롤을 이용해서 보여주는 화면을 상하좌우로 이동하여 포함된 컴포넌트의 원래크기 유지<br> JList,JTextArea,JTextPane 이용

---
## JTable

```Java
// 테이블 생성 ex:)
String[] colNames = {"이름","나이","성별"};
Object[][] data = {{"김철순",25,'남'},{"홍언택",26,'남'}};
                                // ▼칼럼 이름이 있는 1차원배열
JTable table = new JTable(data,colNames);
                        // ▲데이터 항목이 있는 2차원배열

JScrollPane scrollPane = new JScrollPane(table); //테이블이 올려진 스크롤판 생성
contentPane.add(scrollPane);//등록 ㅋ
```
- 테이블의 데이터는 JTable 객체가 아닌 별도의 객체(Model)에 저장됨

    ```java
    TableModel model = table.getModel(); //테이블의 모델을 가져오는 메소드
    Object obj = model.getValueAt(int row, int col); //(row,col)위치에 있는 데이터를 가져옴
    model.setValueAt(Obejct aValue,int row,int col);
    //(row,col)위치에 있는 데이터를 aValue로 바꾼다.

    ```
- DefaultTabelModel
    - 디폴틑 테이블 모델을 생성 후에 JTable에 넣어줄 수 있다.
    - JTable은 GUI 요소이고 여기에 들어갈 데이터는  2차원 배열로 표현해주는데
    - 2차원배열을 다루기 불편한점을 DefaultTableModel이라는 객체로 쉽게 다룰수 있음

    ```java
    String[] colNames = {"이름","나이","성별"};             //▼ 행의 수
    DefaultTableModel model = new DefaultTableModel(colNames,0);
                                                    // ▲컬럼 이름이 있는 1차원 배열 
    JTable table = new JTable(model); //이 모델을 데이터를 저장하는 테이블에 생성

    model.addRow(data);//테이블 마지막행에 추가
    model.insertRow(int row,data);// 지정한 행 위치에 추가
    model.removeRow(int row); //지정한 위치에 있는 행을 삭제
    ```
---
## JOptionPane
---
## Graphics
>Graphic 클래스는 선이나 원, 사각형 등의 도형을 그려주는 클래스이다. <br>그런데 JPanel,JLabel,JButton등의 GUI 객체들이 자기자신을 그리기 위해서 이 Graphics 클래스를 사용한다.<br>ex:) 버튼의 모양등이 Grpahics 클래스를이용해서 만드는것

Graphics 객체를 이용해서 우리가 원하는 그림을 그리기 위해서는 이 방법을 역으로 이용한다. <br> GUI객체가 자기자신을 그리는 메소드(paintComponent)를 오버라이드하여, 다른 그림을 그리도록 바꾸어버린다.


- 도화지 역할 : Pannel 클래스 (JPanel의 서브클래스)
- 필기구 역할 : java.awt.Graphics 클래스
- 그림그리는 순서
    1. 그림이 그려질 패널을 만든다

        ```java
        //1) JPanel의 서브클래스를 선언
        class CarDrawingPanel extends JPanel{
            public void paint(Graphics g){
                /*그림을 그리는 명령문을 이곳에씀*/
            }//이렇게 선언된 paint 메소드는 패널이 디스플레이될때 JDK라이브러리 모듈에 의해 자동으로 호출됨
        
        }
        //2) paint 메소드 안에 다음과 같은 메소드 호출문을 써서 그림을 그린다.
        //매개변수(X좌표,Y좌표,Width,Height)
        g.drawRect(100,110,200,40); //직사각형
        g.drawOval(125,150,30,30); //원
        g.drawLine(50,180,350,180); //직선
        ```
    2. 그 패널을 contentPane 위에 올려놓는다.

    ## Graphic을 처리하는 paint() 메소드
    - 그래픽 출력 이벤트 : 애플릿에 그림을 그리려 할때 발생하는 이벤트
    - paint()메소드 : 그래픽 이벤트가 발생하였을 때 호출하는 메소드
        - 실제 그림을 그리는것은 **paint()** 메소드의 매개변수를 통해 전달되는 **Graphics 객체**
    - 그래픽 출력을 위한 메소드로 **update()**와 **repaint()**가 있다.
    - **update() 메소드** : 이미지 출력 작업(화면)을 갱신하고 싶을 때 사용
        - 시스템에 의해 자동으로 호출되는 메소드이기때문에 주로 화면의 깜빡거림을 막기 위해 사용
    - **repaint() 메소드** : 강제로 paint() 메소드를 한번 더 호출하고 싶을 때 사용
        - 방금 처리한 작업을 화면에 바로 보여주고 싶으면 repaint()메소드를 호출하여 paint()메소드 호출
## 이미지 디스플레이
1. **Toolkit(툴킷)**
> Toolkit을 이용한 이미지 생성<br>Frame을 만들면 자동으로 생성, 프레임으로부터 툴킷을 넘겨 받아 사용

```java
//1) JPanel의 서브클래스 선언
class ImagePanel extends Jpanel{
    public void paint(Graphics g){
        /*이미지를 디스플레이하는 명령문을 이부분엔씀*/
    }
}
//2) Image 객체를 만드는데 필요한 Toolkit 객체를 얻는다.
Toolkit toolkit = panel.getToolkit(); //Toolkit 객체를 리턴하는 메소드

//3) Toolkit 객체를 이용해서 Image 객체를 만든다.
Image image = toolkit.getImage("이미지파일경로");
                        // ▲이미지파일을 읽어서 Image객체로 만들어 리턴

//4)Image객체를 가지고 drawImage 메소드를 호출하면 이미지가 디스플레이된다.
g.drawImage(image,0,0,this);
 // ▲ 패널의 (0.0) 위치에 image를 디스플레이한다.
```
> 프로그램의 성능에 문제를 일으키는 방법<Br> draaImage 메소드 호출문을 제외한 나머지를 paint 메소드 밖으로 빼내는것이 좋음
2. **ImageIcon**
> 아주 작은 이미지 즉, 아이콘을 이미지객체로 만든 것<br>이 객체는 javax.swing.ImageIcon 클래스를 이용해 만든다.<br>  Image 클래스와 별로 관계가 없지만, 이 클래스를 이용해서 이미지를 만들수 있다.

```java
//생성자로 경로를 넘겨주면 저절로 ImageIcon 클래스의 객체가 생성이된다. 
ImageIcon imageIcon = new ImageIcon("파일경로");

// 이 클래스는 Image 클래스와는 상관이없다.
//Image클래스의 객체로 만들어 반환하는 메소드인 getImage() 메소드를 호출하면 된다.
Image image = imageIcon.getImage():
```
---
## 오디오파일