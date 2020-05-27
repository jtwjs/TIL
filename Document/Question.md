## Question List
1. 스프링 Bean 객체는 싱글톤(한 객체가 데이터 공유)
    - 같은 데이터타입 객체(bean)를 왜 여러개 생성하는지.
        - 동일한 객체가 2개이상인 경우 스프링컨테이너는 자동 주입 대상 객체를 판단하지 못해서 Exception을 발생시킴
        - &#60;qulifiler vlaue=""&#62;
        - @Qualifier("")