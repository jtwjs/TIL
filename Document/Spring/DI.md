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

### 의존성 주입 방법
1. Contructor Injection
    - 생성자를 통한 전달
    - ```<constructor-arg ref="cat"></constructor-arg> ```
2. Method(Setter) Injection
    - setter()를 통한 전달
    - ```<property name="myName" value="poodle"></property> ```
3. Field Injection
    - 멤버 변수를 통한 전달

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