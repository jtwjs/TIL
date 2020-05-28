## Spring Container(IOC)
>Spring Framework의 핵심 컴포넌트
- Container는 DI를 사용하여 응용 프로그램을 구성하는 bean 객체를 관리한다.
### 역할
> bean을 포함하고 관리하는 책임이 있다.
1. 객체(bean)를 생성하고
2. 객체들을 함께 묶고
3. 객체들을 구성하고
4. 객체들의 전체 수명주기(lifecycle)를 관리

### 설정 방법
> Spring Container metadata 설정 방법
1. XML
    - 1) 빈 객체 정의 (Bean Definition)
    - 2) 의존성 주입 (Dependency Injection)
2. Java Annotations
3. Java Code

### 유형
- Spring Container의 2가지 유형
1. BeanFactory
    - 주로 단순한 DI에서만 사용
    - ```XMLBeanFactory```
2. ApplicationContext
    - Resources가 제한되어 있지 않은 모든 곳에 사용한다.
    - ```ClassPathXmlApplicationContext```
    - ```java
      /* main함수에서 Container를 생성 */
      //설정 파일은 인자로 넣고, 해당 설정 파일에 맞게 bean들을 만듦
      ApplicationContext context = 
        new ClassPathXmlApplicationContext("spring/di/beans/bean.xml");
        // getBean()을 통해 bean의 주소값을 가져온다.
        HellowWorld obj = (HellowWorld) context.getBean("helloWorld");
      ```

![DI 예시](https://user-images.githubusercontent.com/60641307/82870635-453a7f00-9f6b-11ea-864a-3f216de2d270.png)


### @Annotation으로 IOC 설정
>프로그램이 거대해짐에 따라 XML을 이용하여 IOC Container를 설정하는 것이 점점 어려워졌고 때문에 Annotation(@)이 등장함
<br> 어노테이션 코드에 메타데이터를 작성하여 직관적인 코딩이 가능하게 만들어주며 이에따라 생산성이 증대되는 장점을 가짐

- ```java
    AnnotationConfigApplicationContext ctx = 
    AnnotationConfigApplicationContext(Container클래스.class);
  ```

#### java 파일분리
- 개발자 기호에따라 나눠주자(되도록이면 기능별로..)
- ```java
    AnnotationConfigApplicationContext ctx = 
    AnnotationConfigApplicationContext(Container클래스).class,클래스명1.class,..);
  ```
- 나눠진 IOC Container 자바파일에 의존성 주입은 프로퍼티 생성후  @Autowired(자동주입) 설정해주면 된다.

#### @Import 어노테이션
- @import한 파일만 명시해줌으로서 코드를 간결하게 만들수 있다.
- ```java
    @import({Container클래스2.class,Container클래스3.class})
  ```

#### 1. @Configuration
- Configuration 어노테이션은 스프링 IOC Container에게 해당 클래스를 Bean 구성 Class임을 알려주는 것

#### 2. @Beans vs @Component
- @Bean 어노테이션과 @Component 어노테이션 모두 Spring(IOC) Container에 Bean을 등록하도록 하는 메타데이터를 기입하는 어노테이션이다. <br> ※둘의 용도는 다르다

- **@Bean**
  - 개발자가 직접 제어가 불가능한 외부 라이브러리등을 Bean으로 만들려할떄 사용
  - @Bean(name="") 
    - 자신이 원하는 id로 Bean을 등록 가능<br> 어노테이션 안에 값을 입력하지 않을경우 메소드 이름이 Bean의 id가된다.
    - ```java
      // bean으로 생성된(의존성을 주입할) 객체를 파라미터로 호출하면된다
      //== XML-> constructor-arg: 생성 시 생성자에 전달할 인수
      @Bean 
      public StudentRegisterService registerService() {
        return new StudentRegisetrService(studentDao());
      }
      
      //== XML-> property: 생성 시 bean setter에 전달할 인수
      @Bean
      public DatabaseConnectionInfo dataBaseConnectionInfoDev(){
        DataBaseConnectionInfo infoDev = new DataBaseConnectionInfo();
        infoDev.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");

        return infoDev;
      }

      //List Property
      @Bean
      public EMSInformationService informationService() {
      EMSInformationService info = new EMSInformationService();
      ArrayList<String> developers = new ArrayList<String>();
      developers.add("Cherry.");
      developers.add("Eloy.");
      developers.add("Jasper.");
      info.setDevelopers(developers);

      }

      
      ```


- **@Component**
  - 개발자가 직접 작성한 Class를 Bean으로 등록하기 위한 어노테이션
  - @Component(value="") 
    - @Component 역시 아무런 추가 정보가 없다면 Class의 이름을 Camelcase로 변경한것이 Bean id로 사용된다.
    - ```java
      @Component(value="")
      public class Student {
        public Student() {
          System.out.println("hi");
        }
      }
      ```