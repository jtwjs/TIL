## myBatis
>객체 지향 언어의 자바 **JDBC를 이용한 퍼시스턴스 프레임워크** 이다.
- JDBC를 이용한 커넥션 코드 및 변수 등 중복작업을 대체해줌
- SQL, 동적 쿼리, 저장 프로시저 그리고 고급매핑을 지원하는 SQL Mapper이다.
- SQL 쿼리들을 따로 XML파일로 작성하여 프로그램 코드와 SQL문을 코드관리 용이


### myBatis 특징
- myBatis-Spring은 myBatis에서 myBatis3와 Spring 연동 라이브러리로 제공됨
- 싱글톤 패턴으로 스프링 빈(bean)으로 등록하여 주입(DI)하여 쉽게 사용 가능
- Mybatis Mappoer Interface를 통해 DB에 접근 
- 객체 프로퍼티로 파라미터와 결과를 객체(DTO, Map 등)로 자동 매핑을 지원
- 스프링 연동 모듈을 제공해주기 때문에 스프링 설정이 간단
- 트랜잭션을 관리해주기 쉽게 설정이 가능

### myBatis 장점
- 자동으로 Connection close() 가능
- mybatis 내부적으로 PreparedStatement 처리
- #{prop}와 같이 속성을 지정하면 내부적으로 자동 처리
- 리턴 타입을 지정하는 경우 자동으로 객체 생성 및 ResultSet 처리

### myBatis 구조

![마이바티스 구조](https://user-images.githubusercontent.com/60641307/83370553-bca06080-a3fa-11ea-9a63-3e9559465184.png)

- mybatis-config 는 mybatis의 메인 환경설정 파일이다. <br> 어떤 DBMS와 커넥션을 맺을지, 어떤 맵퍼파일들이 있는지 알수 있다.
- mybatis는 맵퍼 파일에 있는 각 SQL명령어들을 Map에 담아서 저장하고 관리한다.

### MyBatis Data Access Layer


![MyBatis를 사용하는 데이터 액세스 계층](https://user-images.githubusercontent.com/60641307/83387150-32babc80-a427-11ea-9b75-086485b88d54.png)

### MtBatis 주요 컴포넌트
- **설정파일(SqlMapConfig.xml)**
    - myBatis 동작설정을 지정
    - 데이터베이스의 접속 주소 정보
    - Mapping 파일의 경로등의 고정된 환경정보
- **SqlSession FactoryBuilder**
    - MyBatis 설정 파일을 바탕으로 SqlSessionFactory를 생성
- **SqlSessionFactory**
    - SqlSession을 생성
- **SqlSession**
    - 핵심적인 역할을 하는 클래스로써 SQL 실행이나 트랜잭션 관리를 실행
    - SqlSession 오브젝트는 Thread-Safe 하지 않으므로 thread마다 필요에 따라 생성
- **mapping 파일(user.xml)**
    - SQL문과 OR Mapping을 설정
    - 객체의 매핑 정의를 기술하는 XML 파일
    
![mybatis db 엑새스](https://user-images.githubusercontent.com/60641307/83375217-1d369a00-a409-11ea-97a8-738cd4b23401.png)

### MyBatis 흐름
1. Application 에서 SqlSessionFactoryBuilder 호출
2. MyBatis ConfigFile 정보를 읽음
3. SqlSession Factory 생성
4. 개발자가 Application 에서 작성한 DB Access 메소드 호출
5. Sql Session Factory를  Application에서 호출
6. Sql Session Factory가 SqlSession 컴포넌트 생성
7. Sql Session을 개발자가 작성한 application code에 리턴
8. return 받아서 SqlSession에 있는 method 호출

### MyBatis-Spring 주요 컴포넌트
> 스프링과 myBatis 연동을 쉽게 할수 있도록 제공하는 오픈 소스

![mybatis-spring의 주요컴포넌트](https://user-images.githubusercontent.com/60641307/83388624-b7a6d580-a429-11ea-8a03-9d56a1ef92af.png)

- **MyBatis 설정파일(SqlMapConfig.xml)**
    - VO 객체의 정보를 설정
- **SqlSessionFactory**
    - MyBatis 설정파일을 바탕으로 SqlSessionFactory를 생성
    - **Spring Bean으로 등록해야함**
- **SqlSessionTemplate**
    - 핵심적인 역할을 하는 클래스
    - SQL 실행이나 트랜잭션 관리를 실행
    - SqlSession 인터페이스를 구현
    - **Thread-safe** (멀티 쓰레드 환경에서도 편리하게 사용 가능)
    - **Spring Bean으로 등록해야함**
- **Mapping 파일(user.xml)**
    - SQL문과 OR Mapping을 설정
- **Spring Bean 설정 파일 (myBatisBeans.xml)**
    - SqlSessionFactoryBean을 Bean 등록할 때 DataSource 정보와 MyBatisConfig 파일정보, Maaping 파일의 정보를 함께 설정, 
    - SqlSessionTemplate을 Bean으로 등록한다.



### myBatis의 주요 구성 요소가 데이터베이스에 엑세스하는 흐름



#### 응용 프로그램 시작시 수행되는 프로세스 흐름
### SQLSessionFactory
- myBatis에서 가장핵심적인 객체 
    - SQLSession
        - SQLSession을 통해 Connection을 생성하거나 원하는 SQL을 전달, 결과를 리턴받는 구조로 작성하게됨  
    - SQLSesionFactory
        - 내부적으로 SQlSession을 만들어 내는 존재
        - 개발자가 작성한 SQL문을 호출

>mybatis에서 SqlSession을 생성하기 위해 sqlSessionFactory를 사용한다. <br>세션을 한번 생성하면 매핑구문을 실행하거나 커밋 또는 롤백을 하기 위해 세션을 사용할 수 있다.<br>더이상 필요하지 않은상태가 되면 세션을 닫는다. **mybatis 스프링 연동모듈을 사용하면 SqlSessionFactory를 직접 사용할 필요가 없다.** <br>스프링 트랜잭션 설정에따라 자동으로 커밋 혹은 롤백을 수행하고 닫혀지는, 쓰레드에 안전한 SqlSession 개체가 스프링 빈에 주입될수 있기때문

### SqlSessionTemplate
- mybatis 스프링 연동모듈의 핵심
- SqlSession을 구현하고 코드에서 SqlSession를 대체하는 역할
- 쓰레드에 안전하고 여러개의 DAO나 mapper에서 공유 가능
- getMapper()에 의해 리턴된 mapper가 가진 메소드를 포함해서 SQL을 처리하는 mybatis매소드를 호출할 때<br>SqlSessionTemplate은 SqlSession이 현재의 스프링 트랜잭션에서 사용될수 있도록 보장한다.
- 필요한 시점에 세션을 닫고, 커밋하거나 롤백하는 것을 포함한 **세션의 생명주기를 관리**
- mybatis예외를 DataAccessException로 변환하는 작업 처리


### #{}, ${} 차이
- #{}
    - 파라메터가 String 형태로 들어와 자동적으로 '파라매터'형태가 된다.<br>ex:) #{user_id}의 user_id의 값이 abc라면 쿼리문에는 USER_ID ='abc'의 형태가 된다.
    - 쿼리 주입을 예방할 수 있어 보안측면에서 유리하다.
- ${}
    - 파라매터가 바로 출력된다.
    - 해당 컬럼의 자료형에 맞추어 파라매터의 자료형이 변경된다.
    - 쿼리 주입을 예방할수 없어 보안측면에서 불리, 사용자의 입력을 전달할때는 사용하지 않는편이 좋다.
    - 테이블이나 컬럼명을 파라메터로 전달하고싶을 때 사용<br> #{}은 자동으로 ""가 붙어서 이경우 사용불가


---

### Mapper 인터페이스 
- Mapping 파일에 기재된 SQL을 호출하기 위한 인터페이스
- Mapping 파일에 있는 SQL을 인터페이스로 호출한다.
#### Mapper 인터페이스를 사용하지 않을 경우
- session.selectOne("userNs.selectUserById",id)형식
- 네임스페이스 +"."+SQL ID로 지정해야만 한다.
- 문자열로 작성하기 때문에 버그 생길수 있음
- IDE에서 제공하는 code assist를 사용할 수 없다.
#### Mapper 사용했을 때
- Mapper 인터페이스 개발자가 직접 작성
- 패키지_명 + "." + 인터페이스_명 + "." + 메소드_명이 네임스페이스+"."+SQL_ID가 되도록 설정해야 함
- 네임스페이스 속성에는 패키지를 포함한 Mapper 인터페이스 이름 
- SQL ID 에는 매핑하는 메소드 이름을 지정하는 것

#### Mapper 인터페이스 작성
- 반드시 인터페이스로 선언
- 네임스페이스_명 은 패키지+인터페이스_명 으로 작성
- 메소드_명은 SQL_ID와 동일하게 작성

### 사용법
- **bean 추가**
    - ```xml
        <!-- Bean에 Mapper 인터페이스를 사용하기 위해 -->
        <bean id="userMapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
            <property name = "mapperInterface" value="myspring.user.dao.UserMapper" />
            <property name = "sqlSessionTemplate" ref="sqlSession" />
        </bean>
      ```
    - MapperFactoryBean은 UserMapper를 구현하는 프록시 클래스를 생성하고, 그것을 어플리케이션에 injection 한다.
    - 프록시는 런타임 시에 생성되므로, 지정된 Mapper는 실제 구현클래스가 아닌 인터페이스여야만 한다.
    - MapperFactoryBean은 sqlSessionFactory나 sqlSessionTemplate를 필요로 한다.
- **xml네임스페이스 설정**
    - ```xml
        <?xml version="1.0" encoding="UTF-8"?>
        <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
            "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
        <mapper namespace="myspring.user.dao.UserMapper">
        </mapper>
      ```
- **DAO에 autowired**
    - ```java
        @Autowired
        private UserMapper userMapper;
      ```

#### Mapper인터페이스 메소드명은 네임스페이스 ID랑 맞출것
- **인터페이스**
    - ```java
        public interface UserMapper {
            UserVO selectUserById(String id);
        }
      ```
- **XML**
    - ```xml
         <select id="selectUserById" parameterType="string" resultType="User" >
            select * from users where userid=#{id}
         </select>
      ```
- **여러개의 Mapper 설정방법**
    - MapperScannerConfigurer 사용
    - 위에 org.mybatis.spring.mapper.MapperFactoryBean 을 이용시 Mapper 등록시 갯수가 많아지면 일일이 정의해야 하는 단점이있다.
    - DI 컨테이너에 등록된다.
    - MapperScannerConfigurer 이용하면 지정한 패키지 아래 모든 인터페이스가  Mapper인터페이스로 간주 된다.
    - dao 등 인터페이스도 등록되어 에러가 발생할수있음
- **다른 인터페이스는 등록안되게 하는법**
    - 빈에 등록하기
        - ```xml
            <!-- MapperScannerConfigurer 여러개 Mapper 인터페이스 사용시-->
            <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer" >
                <property name="basePackage" value="myspring.user.dao" />
                <property name="annotationClass" value="myspring.user.dao.MyMapper" />
                <!-- Mapper 지정 다른 인터페이스 등록안되게 -->
            </bean>
          ```
    - annotation 파일 생성
        - ```java
            package myspring.user.dao;

            public @interface MyMapper {

            }
          ```

    - 기존 Mapper에 어노테이션 등록
        - ```java
            @MyMapper
            public interface UserMapper {

            }
          ```
### resultType, resultMap 차이점
- **resultType**
    - ibatis(resultClass) -> mybatis(resultType)
    - 클래스_명 전체 또는 alias를 입력<br> 즉 매핑하려는 자바 클래스의 전체 경로를 입력함
    - ex:) 
         ```xml
                <!-- com.test.Student 객체로 쿼리 실행 결과값을 받고자 할때-->
                <select id="selectTest" resultType="com.test.Student">
                ...
                </select>

                <!-- int형 객체로 쿼리 실행 결과값을 받을 때 -->
                <select id ="selectTest" resultType="int">
                ...
                </select>
            ```
- **resultMap**
    - resultMap 선언 당시 참조로 사용한 이름을 입력
    - resultType을 이용하면 자동 매핑되기 때문에 편리하지만 제한이 있음<br>resultMap을 사용하면 개발자가 직접 원하는 POJO 클래스에 매핑가능
    - ex:)
        ```xml
            <resultMap id="test" type="com.test.Student">
                <result property="name" column="name">
                ...
            </resultMap>

            <select id="selectTest" resultMap="test">
                ...
            </select>
        ```
