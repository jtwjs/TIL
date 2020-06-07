## Connection Pool(커넥션 풀)
- 미리 커넥션을 만들어놓고 사용 

### c3p0 모듈의 ComboPooledDataSource
- com.mchange.v2.c3p0,ComboPooledDataSource
    - ```java
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(userid);
        dataSource.setPassword(userpw);
      ```
### 스프링 설정파일을 이용한 DataSource 설정
- ```xml
    <beans:bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <beans:property name="driverClass" value="oracle.jdbc.driver.OracleDriver" />
        <beans:property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:orcl" />
        <beans:property name="user" value="scott" />
        <beans:property name="password" value="123456" />
        <beans:property name="maxPoolSize" value="200" />
        <beans:property name="checkoutTimeout" value="60000" />
        <beans:property name="maxIdleTime" value="1800" />
        <beans:property name="idleConnectionTestPeriod" value="600" />
    </beans:bean>
  ```