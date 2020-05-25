## Model, ModelMap, ModelAndView 개념
>@Controller 클래스 안의 @RequestMapping 어노테이션이 부여된 method들은 사용자에게 응답할 View를 생성하는 역할을 하는 즉, Controller 메소드이다.<br> Controller는 Model을 이용해 데이터를 가져오고 View에 데이터를 넘겨 적절한 View를 생성하는 역할을 한다.

### View에 데이터 전달
1. Model 객체 사용
    ```java
    @Controller
    public class myController {
        @RequestMapping(value="/myview")
        public String contentView(Model model) {
            model.addAttribute("value","hi");
            return "myview";
        }
    }
    ```


### Model vs ModelMap
- model.addAttribute()와 modelmap.addAttribute() 함수를 사용하여 Model에 데이터를 저장 후<br> view에서 데이터에 접근이 가능
- 차이점으로 Model은 인터페이스이며 ModelMap은 구현체
- Spring에서 내부적으로 사용하는 객체의 타입은 동일하며 사용의 구분은 개발자의 취향
- Ex)
    ```java
    @RequestMapping("/home/joinProcess.do")
    public String joinProcess(HttpServletRequest request, 
    ModelMap model, UserVO user) trhows Excpetion {
        try{
            userService.userInsert(user);

            return "/home/main";
        }catch (Exception e) {
            log.error(e.toString());
            return "error";
        }
    }
    ```

### ModelAndView
- Model과 View를 동시에 설정이 가능하며 컨트롤러는 ModelAndView 객체만 리턴하지만 Model과 View가 모두 리턴 가능
- addObject("key",value)데이터 입력
- Ex)
    ```java
    @RequestMapping(method=RequestMethod.GET, value="/home/main.do")
    public ModelAndView Main(UserVo uservo){
    ModelAndView mav = new ModelAndView("/home/main");
    mav.addObject("main",uservo);

    return mav;
    }
    ```