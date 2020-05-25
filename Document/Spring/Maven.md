## maven
> 자바 프로젝트의 빌드(build)를 자동화 해주는 빌드 툴(build tool) 이다.
- 즉, 자바 소스를 compile 하고 package해서 deploy하는 일을 자동화 해주는 것

### maven이 참조하는 설정 파일
>maven 전체를 보기보다 프로그래밍에 직접적인 연관이 있는 두 개의 설정파일을 알아보면 된다.
#### 1. **setting.xml**
>settings.xml은 maven tool 자체에 관련된 설정을 담당한다.
- MAVEN_HOME/conf/아래에 있다.(*MAVEN_HOME은 환경변수에 설정한 경로)
- Maven 자체에 설정 값을 바꾸는 일은 거의 없다
#### 2. **pom.xml**
>하나의 자바 프로젝트에 빌드 툴로 maven을 설정했다면, 프로젝트 최상위 디렉토리에 "pom.xml"이라는 파일이 생성되었을 것
- pom.xml은 POM(Project Object Model)을 설정하는 부분으로 **프로젝트 내 빌드 옵션을 설정하는 부분**이다.
- pom.xml은 &#60;project&#62;..&#60;/project&#62;로 둘러싸여서 section별로 여러 정보를 나타내며 설정 가능

-