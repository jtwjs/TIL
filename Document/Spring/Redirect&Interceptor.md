## 리다이렉트, 인터셉트
- Redircet
    - 컨트롤러에서 뷰를 분기하는 방법
- Intercepter
    - 컨트롤러 실행 전/후에 특정 작업을 가능하게 하는 방법

### Redirect
- return "redirect:/";
- 지금의 페이지에서 특정 페이지로 전환하는 기능
- ```java
    @RequestMapping(value="/modifyForm")
    public String modifyForm(Model model, HttpSession session){
        Member member = (Member) session.getAttribute("member");
        if(null == member){
            return "redirect:/";
        } else {
            model.addAttribute("member",service.memberSearch(member));
        }
        return "/member/modifyForm";

    ```

### Intercepter
- Redirect 사용해야 하는 경우가 많은 경우 HandlerInterceptor를 이용할 수 있다.(통합관리)
- HandlerInterceptor(인터페이스)
    - preHandle() (자주 사용됨)
        - 컨트롤러가 작동하기 전단계에 작업
    - postHandle()
        - 컨트롤러 작업한 후에 작업
    - aftercomplection()
        - 컨트롤러와 뷰 모두 작업 끝난 후에 작업
    - HandlerInterceptor 인터페이스는 세 개의 메소드 모두 구현해야하므로 스프링에선 HandlerIntercepterAdapter 클래스를 제공함
![인터셉터](https://user-images.githubusercontent.com/60641307/83213000-f9225100-a19b-11ea-8d49-d8bc2e29bdba.jpg)

- 컨트롤러가 시작하기전 특정한 작업을 하기위해서는 HandlerInterceptorAdaptr 클래스를 상속받아 별도의 클래스 생성
    - ```java
        public class MemberLoginInterceptor extends HandlerInterceptorAdapter {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                HttpSession session = request.getSession(false);
                if(session != null){
                    Object obj = session.getAttribute("member");
                    if(obj != null)
                        return true;
                }
                response.sendRedirect(request.getContextPath() + "/");
                return false;
            }
        }
      ```

- servlet-context(스프링설정파일)
    - ```xml
        <interceptors>
            <interceptor>
                <mapping path="/member/modifyForm"/>
                <mapping path="/member/removerForm"/>
                <!--
                <mapping path="/member/**" /> member 하위 모든 경로를 추가
                <exclude-mapping path="/member/join"/> 제외 경로추가
                <exclude-mapping path="/member/joinForm"/>
                <exclude-mapping path="/member/login"/>
                 -->
                <beans:bean class="com.bs.lec21.member.MemberLoginInterceptor" />
            </interceptor>
        </interceptors>
      ```

