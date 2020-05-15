## 자바빈(JavaBean)
>자바빈이란 특정한 기능을 가진 컴포넌트를 말하는 것이 아니다.<br> 간단히 말하자면 자바빈 규약 또는 자바빈 관례에 따라 만들어진 클래스를 의미

### 자바빈 사용배경
>자바빈은 원래 비주얼 툴에서 조작하는 컴포넌트를 의미했지만 자바가 웹기반 엔터프라이즈 플랫폼이 주력이 되면서 비주얼 툴은 인기를 잃었다.<br>그러나 비주얼 툴에서의 자바빈의 몇가지 코딩관례(패턴)는 Java EE의 JSP 빈, EJB등의 표준기술과 자바빈을 이용하는 오픈소스 기술들을 통해 사용되어져 왔다.<br>자바빈 관례를 이용하여 어플리케이션 개발 생산성을 늘릴수 있는 기술들이 많이 등장했기 때문<br>자바빈의 코딩 관례는 대표적으로  jsp나 스프링에서도 흔히 볼수 있다.
- ex:)
    - Spring : &#60;bean&#62;, &#60;property&#62; 태그
    - JSP : &#60;jsp:useBean&#62;, &#60;jsp:setProperty&#62; 태그 등
### 자바빈을 사용하는 이유
- 디자인 부분과 로직 부분을 분리하기 위함
- JSP 페이지의 디자인 부분과 로직 부분을 나눔으로써 복잡한 JSP 코드들을 줄이고, 프로그램의 재사용성 증가시킴



### 자바빈의 설계 규약
> 자바빈은 자바빈 규약(관례,규칙)을 따르는 클래스 
1. 패키지-자바빈은 기본(default)패키지 이외의 특정 패키지에 속해있어야 함
2. 기본생성자가 존재해야한다.
    - 즉, 매개변수값이 없는 기본 생성자가 존재해야함
3. 멤버변수의 접근제어자는 private로 선언되있어야함
    - 직접 접근할 수 없도록 private로 선언되어야함
4. 멤버변수에 접근 가능한 getter 와 setter 메소드 존재해야함
5. getter 와 setter 접근자가 public으로 선언되있어야함
    - 어느 패키지에서나 접근 가능하도록 public
- 멤버 변수가 배열인 경우 
    - 매개변수 없는 getter 와 seeter
        - 
            ```java
            public class BeanSample {
                private String[] beanProperty;
                public BeanSample(){}
                public String[] getBeanproperty() {
                    return beanProperty;
                }
                public void setBeanProperty(String[] beanProperty) {
                    this.beanProperty = beanProperty;
                }
            }
            ```

    - 매개변수가 있는 getter 와 setter
        - 배열의 일부 값을 가져오거나 일부 값을 설정
            ```java
                public String getBeanProperty(int index){
                    return beanProperty[index];
                }
                public void setBeanProperty(String beanProperty, int index) {
                    this.beanProperty[index] = beanProperty;
                }
            ```
6. 직렬화 되어 있어야 한다.(선택사항)
> 객체 직렬화란 객체를 입출력에 사용할 수 있도록 객체의 멤버들을 바이트 형태로 변환시키는 것
- java.io.Serializable 인터페이스를 상속하여 직렬화 가능
- 객체를 바이트 스트림으로 변환하는 것을 마샬링(Marshalling)이라고 하며, 반대로 객체화 하는 것을 언마샬링이라한다.

    ```java 
    import java.io.Serializable;
    public class BeanSample implements Serializable {
     private static final long serialVersionUID = 1679166037496682065L;
     private String beanProperty;
     public BeanSample(){}
     public String getBeanProperty() {
           return beanProperty;
     }
     public void setBeanProperty(String beanProperty) {
           this.beanProperty = beanProperty;
     }
    }

    ```
### 사용하기
#### **&#60;jsp:useBean/&#62;**
- 자바빈 객체를 생성하기 위한 태그
    ```jsp
    <jsp:useBean id="빈_이름" class="자바빈 패키지.클래스_명" scope="사용 범위" />
    ```
- id : 자바빈 객체의 변수명
- class: 클래스명. 클래스가 패키지 안에 작성되어 있다면 패키지 경로까지 적어줘야한다.
- scope: 사용범위
    - request
    - page (기본값)
    - session
    - applicat
#### **&#60;jsp:setProperty/&#62;**
- 자바빈 클래스의 **속성 값을 설정**하기 위한 태그
    ```jsp
    <jsp:setProperty name="빈_이름" property="속성_명" value="설정할 속성 값" />

    ```
- 클라이언트에서 전송되어 오는 **파라미터 값**을 속성 값으로 할당할 경우 vlalue 대신 parmam 이용
    ```jsp
    <jsp:setProperty name="빈_이름" property="속성_명" param="파라미터_명" />
    ```
- 클라이언트에서 전송되어 오는 파라미터 이름이 빈객체의 속성명과 모두 같다면 다음과같이 한번에 할당할 속성명을 지정 가능
    ```jsp
    <jsp:setProperty name="빈_이름" property="*" />
    ```

#### **&#60;jsp:getProperty/&#62;**
- 자바빈 클래스의 속성 값을 가져오기 위한 태그
    ```jsp
    <jsp:getProperty name="빈_이름" property="속성_명" />
    ```

#### 자바빈의 영역
- 자바빈 scope는 page, request, session, application 이렇게 4가지로 나누어지며<br> scope를 지정하지않을 경우 기본값은 page가 된다.

|영역|설명|
|:--|:--|
|page|현재 페이지의 범위에만 한정된다. 페이지가 변경되면 유지되지 않는 scope|
|request|request요청을 받고 처리를 완료할 때 까지 생존|
|session|클라이언트 당 하나씩 할당되는 영역, 클라이언트가 브라우저를 종료하기전까지 유지|
|application|사이트 전체의 범위를 가지며, 서버가 종료되기 전에는 게속 유지|