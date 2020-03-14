# Package(패키지)
>서로 관련이 있는 클래스 또는 인터페이스들을 묶어 놓은 묶음.<br>패키지를 사용함으로써 클래스들이 필요할때만 사용될수 있도록 하고, 클래스를 패키지 이름과 함께 <br>계층적인 형태로 사용함으로써 다른 그룹에 속한 클래스와 발생할 수 있는 클래스 이름간의 충돌을 막아줌으로 클래스의 관리를 편하게 해준다.

>패키지의 물리적인 형태는 파일 시스템의 폴더이다.<br> 패키지는 단순히 파일 시스템의 폴더 기능만 하는 것이 아니라 클래스의 일부분이다.<br>패키지는 클래스를 유일하게 만들어주는 식별자 역할을 한다.<br>클래스 이름이 동일하더라도 패키지가 다르면 다른 클래스로 인식한다.<br>클래스의 전체 이름은 "패키지명+클래스명"인데 패키지가 상·하위로 구분되어 있다면 도트(.)를 사용해 (상위패키지.하위패키지.클래스)로 표현한다.

## 패키지 정의방법
- **package**이름은 보통 도메인 이름을 거꾸로 적은 후,그 뒤에 프로젝트 이름을 붙여서 만든다.
- **package**이름은 폴더명 점 폴더명 점 폴더명 과 같은 형식으로 만들어진다.
    - 각각의 폴더명은 숫자로 시작할 수 없다.
- 도메인 이름이 8curz.com이고 프로젝트 이름이 javastudy라면 <br>com.eightcruz.javastudy.Hello로 패키지를 정의할수 있다.
    - 도메인이 숫자로 시작되는데 패키지명은 첫글자에 숫자를 사용할 수없으므로 적절하게 수정한다.
    - 도메인으로 사용하는 이유는 패키지가 중복되는것을 방지하기 위함이므로 반드시 존재하는 도메인이 아니여도 상관없다.
## 패키지에 생성된 클래스 사용하기
- java.lang패키지를 제외하고는 다른 패키지에 있는 클래스를 사용하려면 import라는 구문을 적어줘야한다.
- ex:) import com.eightcruz.javastudy.Hello;
    - com.eightcruz.javastudy패키지 아래의 Hello클래스를 사용하겠다는 것을 컴파일러와 JVM에게 알리는 것
- 클래스 이름대신에 *를 적어도 된다. ex:) import com.eightcruz.javastudy.*;
## import문
1. 패키지와 클래스를 모두 기술하는 방법
>패키지 이름이 짧을 경우 불편함이 없지만 이름이 길어지면 전체코드가 난잡해짐<br>
>서로 다른 패키지에 동일한 클래스 이름이 존재하고 두 패키지 모두 import되어 있을 경우에 사용
```java
package com.mycompany;

public class Car{
    com.hankook.Tire tire = new com.hankook.Tire();
}
```
2. **import문**
>사용하고자 하는 패키지를 import문으로 선언하고, 클래스를 사용할 때에는 패키지를 생략하는것<br>
>import문이 작성되는 위치는 패키지 선언과 클래스 선언 사이다.<br>
>import문으로 짖어된 패키지의 하위 패키지는 import 대상이 아니다. 추가로 더 작성해야한다.
```java
pacakge com.mycompany;

import com.hankook.Tire; //또는 import com.hankook.*;

public Class Car{
    Tire tire = new Tire();
}
```
## import 하지 않고 사용하는 방법
- 각기 다른 패키지에 존재하는 같은 이름의 클래스 파일을 사용할 때
    - ex:) com.eightcruz.javastudy.Hello hello = new com.eightcruz.javastudy.Hello();