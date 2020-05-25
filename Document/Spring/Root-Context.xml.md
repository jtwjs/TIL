### root-context.xml
> servlet-context.xml 과는 반대로 **view(JSP)와 관련되지 않은 객체(bean)를 정의**한다.
- Service, Repository(DAO), DB등 비즈니스 로직과 관련된 설정을 해준다.
- 외부 jar 파일 등으로 사용하는 클래스는 &#60;bean&#62;태그를 이용하여 작성
- 공통 bean을 설정한다.
