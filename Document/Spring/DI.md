## 의존성 주입(DI; Dependency Injection)
> 객체 자체가 아니라 Framework에 의해 객체의 의존성이 주입되는 설계 패턴
- Framework에 의해 동적으로 주입되므로 여러 객체 간의 결합이 줄어든다.
- Dependency Injection은 Spring Framework에서 지원하는 IoC의 형태

![DI](https://user-images.githubusercontent.com/60641307/82868373-7ca72c80-9f67-11ea-8518-fe0814684a45.png)

- 설정에 명시된대로 Container가 
    - 1) bean 객체를 생성하고
    - 2) 종속성 주입을 수행한다.
- Dependency Injection(의존성 주입)과 Inversion Of Control(제어의 역전)은 같은 의미로 사용
    - IoC는 DI를 통해 달성된다.
- IoC(제어의 역전): 프로그램 제어권을 framework가 가져가는 것
    - 개발자가 모든 제어의 중심이지만 코드 전체에 대한 제어는 framework가 한다.
    - 개발자는 설정(xml, annotaion 등)만 하면 Container 가 알아서 처리
    - 즉, 우리는 Framework 속에서 프로그래밍을 하는 것

### 의존성 주입 방법(스프링 DI설정 방법)
1. Contructor Injection
    - 생성자를 통한 전달
        - ```public StduentRegisterService(StudentDao studentDao) { this.studentDao = studentDao; }```
            - ```xml
                <bean id="registerService" class="ems.member.service.StudentRegisterService">
                    <constructor-arg ref="studentDao"></constructor-arg>
                </bean>
             ```
    - ```<constructor-arg ref="주입할클래스_명"></constructor-arg> ```
2. Method(Setter) Injection
    - setter()를 통한 전달
        - ```public void setJdbcUrl(String jdbcUrl) { this.jdbcUrl = jdbcUrl } ```
            - name에 set빼고 첫시작 단어를 소문자로 바꾸어서 넣음 
            - value에 값 전달
            - ```xml
              <property name="jdbcUrl" value="jdbc:oracle:thin:@127.0.0.1:1521:orcl" />
            ```
    - List
        - ```public void setDevleopers(List<String> developers) {this.developers = developers; } ```
            - ```xml
                <property name="developers"> 
                    <list>
                        <value>Cheery.</value>
                        <value>Eloy.</value>
                        <value>Jasper.</value>
                    </list>
                </property>
            ```
    - Map
        - ```public void setAdministrators(Map<String, String> administrators) {this.administrators = administrators;} ```
            - ```xml
                <property name="administrators">
                    <map>
                        <entry>
                            <key>
                                <value>Cherry</value>
                            </key>
                            <value>cherry@springPjt.org</value>
                        </entry>
                        <entry>
                            <key>
                                <value>Jsper</value>
                            </key>
                            <value>jasper@springPjt.org</value>
                        </entry>
                    </map>
              ```
3. Field Injection
    - 멤버 변수를 통한 전달

### 의존객체 자동 주입
- 스프링 설정 파일에서 의존 객체를 주입할 때 &#60;constructor-org&#62; 또는 &#60;property&#62; 태그로 의존 대상 객체를 명시하지 않아도 스프링 컨테이너가<br> 자동으로 필요한 의존 대상 객체를 찾아서 의존 대상 객체가 필요한 객체에 주입해 주는 기능이다.
- 구현 방법
    - @Autowired
    - @Resource 
- ```xml
    <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd 
        http://www.springframework.org/schema/context 
        http://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config />
    ```
#### @Autowired
- 주입하려고 하는 **객체의 타입이 일치**하는 객체를 자동으로 주입한다.
- 주의할점
    - 생성자에 @Autowired 쓸때는 그냥써도됨
    - property나 method 에 쓸떄는 default 생성자를 명시해줘야함
    
#### @Resource
- 주입하려고 하는 **객체의 이름이 일치**하는 객체를 자동으로 주입한다.
- 주의할점
    - 생성자에는 쓰이지 못함
    - property 또는 method에 사용
    - Default 생성자를 꼭 명시해주어야함

### 의존객체 선택
- ```xml
    <bean id="wordDao" class="com.word.dao.WordDao" >
		 <qualifier value="usedDao"/>
	</bean>
   ``` 
- @Qualifier("useDao")

#### 의존객체 자동 주입 체크
- ```xml
    <!-- <bean id="wordDao" class="com.word.dao.WordDao"> -->
    <bean id="registerService" class="com.word.service.WordRegisterServiceUseAutowird" />
  ```
- exception
  ```JAVA
    @Autowired
    private WordDao wordDao;
  ```
- no-exception (의존 객체가 있으면 주입하고 없으면 하지마라; 거의 쓸일없음)
    ```java
    @Autowired(required = false)
    private WordDao wordDao;
    ```
#### @Inject 
- @Autowired와 거의 비슷하게 @Inject 어노테이션을 이용해서 의존 객체를 자동으로 주입할 수 있다.
- @Autowired와 차이점이라면 @Autowired의 경우 required 속성을 이용해서 의존 대상 객체가 없어도 익셉션을 피할수 있지만,<br> @Inject의 경우 required 속성을 지원하지 않는다.
- @Named(value="") 
    - @Autowired의 @Qulifier("")와 같다.
    - 스프링컨테이너에 &#60;qualifier value="usedDao"/&#62;을 안써줘도 된다.
### 장점
1. Reduced Dependencies
    - 종속성이 감소
    - components의 종속성이 감소하면 변경에 민감하지 않다.
2. More Reusable Code
    - 재사용성이 증가
    - 일부 인터페이스의 다른 구현이 필요한 경우, 코드를 변경할 필요없이 해당 구현을 사용하도록 components를 구성할 수 있다.
3. More Testable Code
    - 더 많은 테스트 코드를 만들 수 있다.
    - Mock 객체는 실제 구현의 테스트로 사용되는 객체
        - 종속성을 components에 주입할 수 있는 경우 이러한 조속성의 Mock 구현을 주입할 수 있다.
        - 예를 들어, Mock 객체가 올바른 객체를 반환할 때, null을 반환할때, 예외가 발생할 떄 모두 처리
4. More Readable Code
    - 코드를 읽기 쉬워진다.
    - components의 종속성을 보다 쉽게 파악 할 수 있으므로 코드를 쉽게 읽음

