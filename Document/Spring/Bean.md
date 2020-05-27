## Spring Bean
![spring-bean](https://user-images.githubusercontent.com/60641307/83010531-5959ab80-a053-11ea-9ed9-7afb179130b4.png)

- Spring에서 POJO(plain, old java object)를 'Beans'라고 부른다.
- Beans는 애플리케이션의 핵심을 이루는 객체이며, Spring IoC(Inversion of Control) 컨테이너에 의해 인스턴스화, 관리, 생성된다.
- Beans는 우리가 컨테이너에 공급하는 설정 메타 데이터(XML 파일)에 의해 생성된다.
    - 컨테이너는 이 메타 데이터를 통해 Bean의 생성, Bean Life Cycle, Bean Dependency(종속성)등을 알 수 있다.
- 애플리케이션의 객체가 지정되면, 해당 객체는 getBean() 메소드를 통해 가져올 수 있다.
### Spring Bean 정의
- 일반적으로 XML 파일에 정의한다.
#### 주요 속성
- class(필수): 정규화된 자바 클래스 이름
- id: bean의 고유 식별자
- scope: 객체의 범위(singleton, prototype)
- constructor-arg: 생성 시 생성자에 전달할 인수
- property: 생성 시 bean setter에 전달할 인수
- int method와 destroy method

### 빈(Bean)의 범위
- 싱글톤(Singleton)
    - 스프링 컨테이너에서 생성된 빈(Bean)객체의 경우 동일한 타입에 대해서는 기본적으로 한 개만 생성이 되며,<br> getBean() 메소드로 호출될 떄 동일한 객체가 반환된다.
- 프로토타입(Prototype)
    - 싱글톤 범위와 반대의 개념도 있는데 이를 프로토타입(Prototype)범위라고 한다.<br>프로토타입의 경우 개발자는 별도로 설정을 해줘야 하는데, 스프링 설정파일에서 빈(Bean)객체를 정의할 때 scope속성을 명시해주면 된다.
    - ```xml
        <bean id="dependencyBean" class="scope.ex.DependencyBean" scope="prototype">
            <constructor-arg ref="injectionBean" />   
            <property name="injectionBean" ref="injectionBean" />
        </bean>
     ```

### Bean 의존관계 설정
1. 명시적으로 구체적인 빈을 지정.
2. 일정한 규칙에따라 자동으로 지정(Autowiring)
- 메타정보 작성방법에 따른 분류
    1. XML &#60;bean&#62;태그
    2. 전용태그
    3. 애노테이션
    4. 자바코드에 의한 직접적인 DI

#### XML: &#60;property&#62;, &#60;constructor-arg&#62;
- &#60;bean&#62;을 이용해 빈을 등록했으면, 프로퍼티, 생성자 2가지를 이용하여 DI를 지정할 수 있다.

- &#60;property&#62; 수정자 주입
    - ```xml
        <bean id="hello" class="pojo.Hello">
        <!-- 빈이 아닌 단순 오브젝트 값을 입력할때 value를 사용 -->
            <property name="name" value="Spring" />
        <!-- property를 이용해서 DI를 한다. -->
            <property name="printer" ref="printer" />
        </bean>
      ```        
- &#60;constructor-arg&#62; 생성자 주입
    - ```xml
        <bean id="hello" class="pojo.Hello">
            <constructor-arg index="0" value="Spring" />
            <!-- 생성자 파라미터를 이용해서 DI를 한다. index 대신 name="name"처럼 파라미터이름도 가능 -->
            <constructor-arg index="1" ref="printer" />
        </bean>
      ```

#### XML: 자동와이어링
- 자동와이어링은 명시적으로 프로퍼티나 생성자 파라미터를 지정하지 않고, 정해진 규칙을 이용해 자동으로 DI 설정을 컨테이너가 추가하도록 한다.
    - 그 규칙에 따라 "이름"과 "타입"을 이용한 자동와이어링 방식이 있다.
- 프로퍼티의 이름과 프로퍼티에 DI할 이름이 비슷하거나 같은 경우가 많다.
    - 보통 Bean 이름은 클래스 이름이나 구현한 인터페이스의 이름을 따름
    - 프로퍼티 이름도 프로퍼티 타입의 이름을 사용함 
- **이름을 이용한 자동와이어링** 방식 Ex:)
    - ```xml
        <!-- 이름을 이용한 자동와이어링 옵션 추가 -->
        <bean id="hello" class="pojo.Hello" autowire="byName">
            <property name="name" value="Spring" />
        </bean>

        <bean id="printer" class="pojo.SpringPrinter" />
      ```
    - 이와 같이 autowire="byName"옵션을 주면 Hello 클래스의 프로퍼티 이름과 동일한 빈을 찾아서 자동으로 프로퍼티로 등록해줌
    - Hello클래스에는 setPrinter()메소드가 있고, 아래 printer라는 빈이 정의되어 있으므로, printer 프로퍼티는 printer빈을 DI 한다.
    - 루트 태그인 &#60;beans&#62;에 default-autowire="byName"을 통해 하위 모든 빈에 적용가능
- **타입을 이용한 자동와이어링** 방식 Ex:)
    - ```xml
        <bean id="hello" class="pojo.Hello" autowire="byType">
            <property name="name" value="Spring" />
        </bean>

        <bean id="myPrinter" class="pojo.StringPrinter" />
      ```
      - 위와 같이, hello는 setPrinter(Printer printer)처럼 Printer 타입의 파라미터를 받는 수정자 메소드가 있고,<br>MyPrinter는 Printer 인터페이스를 구현한 빈이다.
      - byType을 통하여, 같은 인터페이스의 빈을 DI한다.
      - 그러나 이방식은, 동일한 인터페이스 구현체 빈이 여러개가 존재할 경우 사용하기 어렵고, <br>**내부적으로 이름에 의한 자동와이어링 보다 속도가 느리다.**