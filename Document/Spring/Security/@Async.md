## @Async
- 특정 빈안에 어떤 메소드를 호출할때 별도의 쓰레드를 만들어서 비동기적으로 호출함
```java
@Asnyc
public void asnycService() {
    ...
}
```

- @enableAsnyc

- secroutyConfig
```java
SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
//현재쓰레드에서 하위쓰레드를 생성하는 그 쓰레드에도 SecurityContext 공유됨
```