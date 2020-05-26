## Spring Container
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
