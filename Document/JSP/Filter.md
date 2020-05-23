## Filter (필터)
>클라이언트와 서버 사이에 필터가 존재해서 들어오는 request와 response를 필터가 먼저 받아 사전작업/사후 작업등 공통적으로 수행되는 부분을 작업 수행

![필터](https://user-images.githubusercontent.com/60641307/82392471-e793c780-9a7e-11ea-8411-3bd8751d663c.png)

- 한글 인코딩의 경우 필터에넣어두면 항상 인코딩 가능
    - request.setCharacterEncoding("utf-8");


### CharacterEncodingFilter.java 파일
```java
package net.member.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")

public class CharacterEncodingFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request,
			ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		chain.doFilter(request, response);
		

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
```

### Web.xml에 필터 설정방법
```xml
<web-app>
...
    <filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>net.member.filter.CharacterEncodingFilter</filter-class>
    </filter>

    <filter-mapping>
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-parttern>
    </filter-mapping>
...
</web-app>
```
### @어노테이션으로 필터 설정방법
- 필터 클래스에 어노테이션 추가
```java
@WebFilter("/*")
```