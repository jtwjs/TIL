## Java Config

> 스프링 IoC 컨테이너 설정을 pure-Java 기술을 사용하도록 지원하는 스프링의 기술이다.

- pure-Java를 사용함으로써, Java 5.0 어노테이션이나 제네릭을 사용 할 수 있는 장점을 가지고 있다.
- 복잡한 XML설정이 아닌 직접적인 코드에 메타데이터나 설정을 할 수 있도록 한다.
- 의존성 주입에 대해 objected-oriented 메커니즘을 제공한다.(다형성, 상속 등 사용가능)
- 인스턴스와 의존성 주입을 충분히 컨트롤 할 수 있다.
- IDE에 의존적이지 않다.

### Pom.xml (플러그인 추가)

```xml
 <!-- web.xml이 없어도 문제삼지않겠다는 설정 -->
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-war-plugin</artifactId>
        <version>3.2.3</version>
        <configuration>
            <failOnMissingWebXml>false</failOnMissingWebXml>
        </configuration>
    </plugin>
```

### Web.xml

#### 기존 Web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee https://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">

    <!-- The definition of the Root Spring Container shared by all Servlets and Filters -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/spring/root-context.xml</param-value>
    </context-param>

    <!-- Creates the Spring Container shared by all Servlets and Filters -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <!-- Processes application requests -->
    <servlet>
        <servlet-name>appServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>appServlet</servlet-name>
        <url-pattern>/</url-pattern>
        <url-pattern>*.in</url-pattern>
        <url-pattern>*.sc</url-pattern>
        <url-pattern>*.by</url-pattern>
        <url-pattern>*.se</url-pattern>
        <url-pattern>*.or</url-pattern>
        <url-pattern>*.ad</url-pattern>
    </servlet-mapping>

    <welcome-file-list>
        <welcome-file>/</welcome-file>
    </welcome-file-list>

      <!-- Korean Filter -->
      <filter>
          <filter-name>CharacterEncodingFilter</filter-name>
          <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
          <init-param>
              <param-name>encoding</param-name>
              <param-value>utf-8</param-value>
          </init-param>

          <init-param>
              <param-name>forceEncoding</param-name>
              <param-value>true</param-value>
          </init-param>
      </filter>
      <filter-mapping>
          <filter-name>CharacterEncodingFilter</filter-name>
          <url-pattern>/*</url-pattern>
      </filter-mapping>

  </web-app>
```

#### (Java Config) Web.xml

```java
    package com.spring.config.javaConfig;

    import javax.servlet.Filter;

    import org.springframework.web.filter.CharacterEncodingFilter;
    import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

    public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/", "*.in", "*.sc",
                "*.by", "*.se", "*.or", "*.ad" };
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {
            characterEncodingFilter
        };

        }

    }

```

### servlet-context.xml

#### 기존 servlet-context.xml

```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans:beans xmlns="http://www.springframework.org/schema/mvc"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:beans="http://www.springframework.org/schema/beans"
        xmlns:context="http://www.springframework.org/schema/context"
        xsi:schemaLocation="http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd
            http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

        <!-- DispatcherServlet Context: defines this servlet's request-processing infrastructure -->

        <!-- Enables the Spring MVC @Controller programming model -->
        <annotation-driven />

        <!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
        <resources mapping="/resources/**" location="/resources/" />

        <!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
        <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            <beans:property name="prefix" value="/" />
            <beans:property name="suffix" value=".jsp" />
        </beans:bean>

        <context:component-scan base-package="com.spring" />

    </beans:beans>
```

#### (Java Config)server-context.xml

```java
        package com.spring.config.javaConfig;

        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
        import org.springframework.web.servlet.config.annotation.EnableWebMvc;
        import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
        import org.springframework.web.servlet.view.InternalResourceViewResolver;


        @Configuration
        @EnableWebMvc
        @ComponentScan(basePackages = {"com.spring"})
        public class ServletConfig  extends WebMvcConfigurerAdapter{

            @Override
            public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
                configurer.enable();
            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
            }

            @Bean
            public InternalResourceViewResolver internalResourceViewResolver() {
                InternalResourceViewResolver resolver = new InternalResourceViewResolver();
                resolver.setPrefix("/");
                resolver.setSuffix(".jsp");
                return resolver;
            }
        }

```

### root-context

#### 기존 root-context.xml

```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:mybatis-spring="http://mybatis.org/schema/mybatis-spring"
        xsi:schemaLocation="http://mybatis.org/schema/mybatis-spring http://mybatis.org/schema/mybatis-spring-1.2.xsd
            http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd">

        <!-- Root Context: defines shared resources visible to all other web components -->
        <!-- Root Context: defines shared resources visible to all other web components -->
        <bean id="dataSource" class="org.springframework.jdbc.datasource.SimpleDriverDataSource">
            <property name="driverClass" value="oracle.jdbc.OracleDriver" />
            <property name="url" value="jdbc:oracle:thin:@localhost:1521:orcl" />
            <property name="username" value="scott" />
            <property name="password" value="123456" />
        </bean>

        <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
            <property name="dataSource" ref="dataSource"/>
            <!-- name="typeAliasesPackage"
                mybatis에서 resultType과 parameterType 사용시 bean 객체를 사용할려면 패키지 경로 및 bean 클래스명까지 입력해야 한다.
                하지만 alias 처리를 해주면 bean 클래스명만 입력하면 된다.
            -->
            <!-- <property name="typeAliasesPackage" value="com.spring.project" /> -->

            <!--
            <property name="mapperLocations"
                value="classpath*:/com/spring/mapper/MemberMapper.xml"></property>
            -->
            <!-- mapper관련 xml문서(ex:MemberMapper.xml)의 위치 지정 -->
            <property name="mapperLocations"
                value="classpath*:/com/spring/mapper/**/*.xml"></property>

        </bean>

        <bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate">
            <constructor-arg ref="sqlSessionFactory"/>
        </bean>

        <!-- mybatis mapper 설정 관련(사용시 Namespace 탭에서 mybatis-spring추가하기) -->
        <!-- mapper 관련 인터페이스(ex:MamberMapper.java)를 찾기 위한 패키지 경로 설정함 -->
        <mybatis-spring:scan base-package="com.spring.mapper" />

    </beans>
```

#### (Java Config)root-context.xml

```java
    package com.spring.config.javaConfig;

    import org.springframework.context.annotation.ComponentScan;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.context.annotation.Import;

    @Configuration
    @Import({
        ContextDataSource.class
        ,ContextSqlMapper.class
    })
    @ComponentScan(basePackages = {"com.spring"})
    public class RootConfig {
    }

```

#### (Java Config) My-batis 연동

- **ContextDataSource**

```java
    package com.spring.config.javaConfig;

  import javax.sql.DataSource;

  import org.apache.commons.dbcp.BasicDataSource;
  import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;
  import org.springframework.jdbc.datasource.DataSourceTransactionManager;
  import org.springframework.transaction.annotation.EnableTransactionManagement;

  @Configuration
  @EnableTransactionManagement
  public class ContextDataSource {

    @Bean(destroyMethod="close")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        dataSource.setUsername("soctt");
        dataSource.setPassword("123456");
        dataSource.setDefaultAutoCommit(false);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
```

}

- **ContextSqlMapper**

```java
    package com.spring.config.javaConfig;

    import java.io.IOException;

    import javax.sql.DataSource;

    import org.apache.ibatis.session.SqlSessionFactory;
    import org.mybatis.spring.SqlSessionFactoryBean;
    import org.mybatis.spring.SqlSessionTemplate;
    import org.mybatis.spring.annotation.MapperScan;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

    @Configuration
    @MapperScan(basePackages = {"com.spring.mapper"})
    public class ContextSqlMapper {

        @Autowired
        ApplicationContext applicationContext;

        @Bean
        public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource);
            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/com/spring/mapper/**/*.xml"));
            return factoryBean;
        }

        @Bean
        public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSEssionFactory) {
            return new SqlSessionTemplate(sqlSEssionFactory);
        }

    }

```
