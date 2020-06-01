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