## @AuthenticationPrincipal

```java
@RequestMapping
public String test(Model model, @AuthenticationPrincipal(expression = "#this == 'anonymouseUser' ? null : account") Account account)
    if(account == null) {
        model.addAttribute("key","value");
    } else {|
        model.addAttribute("key","value");
    }
    return "";
```

- 어노테이션 등록

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@AuthenticationPrincipal(expression = "#this == 'anonymouseUser' ? null : account")
public @interface CurrentUser {

}

```
