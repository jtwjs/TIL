## Service, DAO
- 웹 어플리케이션의 일반적인 프로그램 구조
![웹 프로그램 구조](https://user-images.githubusercontent.com/60641307/83125577-afd9ef00-a112-11ea-95a4-e7bd2f074d57.png)

### 한글처리

- web.xml 추가
- ```xml
    <filter>
     <filter-name>encodingFilter</filter-name>
     <filter-class>
        org.springframework.web.filter.CharacterEncodingFilter
     </filter-class>
     <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
     </init-param>
     <init-parma>
      <param-name>forceEncoding</param-name>
      <param-value>true</param-value>
     </init-parma>
    </filter>

    <filter-mapping>
     <filter-name>encodingFilter</filter-name>
     <url-pattern>/*</url-pattern>
    </filter-mapping>
  ```
### Service 객체 구현
- 방법1: new 연산자를 이용한 service 객체 생성 및 참조 (X)
    - ```MemberService service = new MemberService();```
- 방법2: 스프링 설정파일을 이용한 서비스 객체 생성 및 의존 객체 자동 주입 (X)
    - ```xml
        <beans:bean id="service" class="com.bs.lec17.member.service.MemberService"></beans:bean> 
      ```
    - ```java
        @Autowired
        MemberService service;
      ```
- 방법3: 어노테이션을 이용해서 서비스 객체 생성 및 의존 객체 자동 주입 (O)
    - ```java
        @Service("memService")
        public class MemberSErvice implements IMemberService {
                ↓ 의존성 주입
        @Resource(name="memService")
        MemberService service;
        }
      ```

### DAO 객체 구현
- 방법: 어노테이션을 이용해 DAO 객체 생성 및 의존 객체 자동 주입
    - ```java
        @Repository
        public class MemberDao implements IMemberDao {
                  ↓ 의존성 주입
        @Autowired
        MemberDao dao;   
        }
      ```
