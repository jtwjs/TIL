# Polymorphism (다형성)
>같은 자료형에 여러가지 객체를 대입하여 다양한 결과를 얻어내는 성질
- 하나의 타입으로 다양한 실행 결과를 얻음
- 객체를 부품화하여 유지 보수를 용이
## 다형성 구현 방법
>클래스의 상속이나 인터페이스를 **구현하는 자식 클래스에서 메소드를 재정의(오버라이딩)**하고 **자식 클래스를 부모 타입으로** 업캐스팅한다. 그리고 **부모 타입의 객체에서 자식 멤버를 참조하여 다형성을 구현**한다.

![polymorphism](https://user-images.githubusercontent.com/60641307/75655061-665d3d80-5ca4-11ea-9c8f-9d8979ae42ce.jpg)
## Binding(바인딩)
>각종 값들이 확정되어 더이상 변경할 수 없는 구속(Bind) 상태가 되는것,
## Dynamic Binding (동적바인딩)
>프로그램의 실행되는 과정에서 바인딩
- 실행시간(Runtime)즉, 파일이 실행하는 시점에서 성격이 결정

## Static Binding (정적바인딩)
>원시 프로그램의 컴파일링 또는 링크 시에 확정되는 바인딩
- 컴파일(Compile)시간에 성격이 결정