## 스프링 MVC프레임워크 설계 구조


![프레임워크 구조](https://user-images.githubusercontent.com/60641307/83101872-46e08000-a0ee-11ea-9233-b2fd496723e6.jpg)

### 처리순서
0. 클라이언트의 요청을 DispatcherServlet이 받는다.
1. HandlerMapping 요청
    - 가장 적합한 Controller를 선택해준다.
2. HandlerAdapter 요청
    - 해당 Controller의 요청을 처리할수있는 가장 적합한 메소드를 찾아줌
    - model이라는 데이터를 가져옴
3. viewResolver에게 보냄
    - Controller에서 가공된 데이터(model, view) 정보를 받는다.
    - 받은 View에 해당하는 가장 적합한 jsp문서(view)를 찾아준다.
4. view를 선택후 응답생성 
5. 브라우저(클라이언트)에게 응답(JSP)처리

### DispatcherServlet 설정
- web.xml에 서블릿을 매핑
    - WEB-INF폴더의 web.xml파일 만들고, &#60;servlet&#62;태그와 &#60;servlet-mapping&#62;태그를 이용한다.
- ```xml
    <servlet>
     <servlet-name>서블릿 별칭</servlet-name>
     <servlet-class>서블릿명(패키지 이름포함 전체서블릿명)</servlet-class>
    </servlet>
    <servlet-mapping>
     <servlet-name>서블릿별칭</servlet-name>
     <url-pattern>/맵핑명</url-pattern>
    </servlet-mapping>
  ```

  - ```xml
    <servlet>
     <servlet-name>appServlet</servlet-name>       <!-- DispatcherServlet를 Servlet으로  등록 -->
     <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
     <init-param> <!-- 초기화파라미터 -->
     <!-- 초기화 파라미터에 servlet-context.xml 명시 -->
      <param-name>contextConfigLocation</param-name>
                                           <!--스프링 설정 파일(스프링 컨테이너 생성) -->
      <param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
     </init-param> 
     <load-on-startup>1</load-op-startup>
    </servlet>

    <servlet-mapping>
     <servlet-name>appServlet</servlet-name>
     <!--클라이언트에서 들어오는 모든 요청(/;루트)에 대해서 DispatcherServlet이 받겠다 설정 -->
     <url-pattern>/</url-pattern>
    </servlet-mapping>
    ```
- 스프링 컨테이너 생성 시 컨테이너 안에 HandlerMapping, HanlderAdapter, ViewResolver 자동생성
    - 모두 Framework에 있는 것들
    - 개발자가 실제로 작업할건 Controller와 View 뿐..
- 초기화 파라미터에서 스프링 설정 파일을 지정하지 않은 경우 서블릿별칭을 이용해서 스프링 컨테이너가 자동으로 생성됨

### Controll 객체
#### @Controller
- 스프링 설정 파일(servlet-context.xml)에 **&#60;annotation-driven /&#62;** 태그를 넣어주면 됨
    - 컨테이너를 만들기위한,사용하기위한 여러 도와주는 클래스들이 빈 객체로 스프링 설정파일에 존재하게됨
- Controller 객체로 사용할 클래스 정의
    - 일반적인 클래스를 만들고 앞에 **@Controller** 어노테이션 붙여주면됨

![@controller](https://user-images.githubusercontent.com/60641307/83105390-8f4f6c00-a0f5-11ea-8b80-b27c1720e491.jpg)

#### @RequestMapping
- Controller 안에 메소드에 @RequestMapping("요청한 값") 붙여줌
    - ```java
        @RequestMapping("/success/")
        public String success(Model model) {
            return "success";
        }
      ```

![@RequestMapping](https://user-images.githubusercontent.com/60641307/83105422-9bd3c480-a0f5-11ea-8fa8-3ff5ccc7493c.jpg)


#### Model 타입의 파라미터
- 개발자는 Model 객체에 데이터를 담아서 DispatcherServlet에 전달할수 있다.
- DispatcherServlet에 전달된 Model데이터는 View에서 가공되어 클라이언트한테 응답처리된다.

-  ```java
    @RequestMapping("/success")
    public String success(Model model) {//파라미터로 model 객체 넣어줌
                        //속성이름, 속성값
      model.setAttribute("tempData", "model has data!!");
    }
   ```
![Model](https://user-images.githubusercontent.com/60641307/83105678-10a6fe80-a0f6-11ea-9742-43af2a81f00e.jpg)

#### View 객체

- 스프링 설정파일(servlet-context.xml)에 InternalResourceViewResolver 빈객체 생성
    - 해당하는 적합한 view를 찾아주는 녀석
    - 찾는법
        - controller 안에 매핑되는 메소드에 리턴값과 InternalResourceViewResolver가 만들어준 prefix, suffix값을 합친 이름으로 파일을 찾아준다. 
        - prefix + 리턴값(String) + suffix로 실제 사용자에게 응답해줄 뷰를 만듦

![ViewResolver](https://user-images.githubusercontent.com/60641307/83106063-c4a88980-a0f6-11ea-94c1-6fad6b70ad06.jpg)


### 전체적인 웹프로그래밍 구조

![전체적인 웹프로그래밍 구조](https://user-images.githubusercontent.com/60641307/83106642-c6bf1800-a0f7-11ea-9107-db501e324cd6.jpg)


