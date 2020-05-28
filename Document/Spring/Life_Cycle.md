## 생명주기(Life Cycle)

### 스프링 컨테이너 생명주기
1. 생성
    - GenericXmlApplicationContext를 이용한 스프링 컨테이너 초기화(생성)
2. 이용
    - getBean()를 이용한 빈(Bean)객체 이용
3. 소멸
    - close()를 이용한 스프링 컨테이너 종료
### 빈(Bean)객체 생명주기
- 빈(Bean)객체의 생명주기는 스프링 컨테이너의 생명주기와 같다.
- 스프링 컨테이너 초기화
    - 빈(Bean)객체 생성 및 주입
- 스프링 컨테이너 종료
    - 빈(Bean)객체 소멸
#### InitializingBean, DsiposableBean 인터페이스
> 빈이 생성 & 소멸 되는 시점에 특정한 작업을 할수 있는 인터페이스
- **InitializingBean **
    - afterPropertiesSet()
    - 빈(Bean)객체 생성시점에 호출
- **DisposableBean**
    - destroy()
    - 빈(Bean)객체 소멸시점에 호출
#### init-method, destroy-method 속성
>빈이 생성 & 소멸 되는 시점에 특정한 작업을 할수 있는 메소드 구현
1. 스프링 설정파일에서 빈생성 태그에 속성을 이용
    - ```<bean id="" calss="" init-method="메소드명" destroy-method="메소드명" /> ```
2. 메소드 구현
    - init-method 속성에 값과 같은 이름의 메소드 구현
        - 객체가 생성될 때 메소드 호출
    - destory-method 속성에 값과 같은 이름의 메소드 구현
        - 객체가 소멸될 때 메소드 호출