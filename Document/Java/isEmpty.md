# isEmpty()함수
>size() = 0,
- 인스턴스는 생성되었으나, List안에는 아무것도 없는 상태(값이 존재하지 않는상태)
- 객체에 ""이란 값으로 들어가 있는상태(공백도 값 처리가 되기때문)
```java
public boolean isEmpty(){
    return value.length == 0;
}
```
## NULL
>인스턴스가 생성되지 않은 상태,List 변수가 메모리에 아무런 주소값도 창조되지 않은 상태<br>(List에 값이 없을 경우 null로 체크하면 안된다)
