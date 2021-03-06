## 의미있는 이름
### 1. 의도를 분명히 밝혀라
- 의도가 드러나는 이름을 사용하면 코드 이해와 변경이 쉬워진다.
- 코드 맥락이 코드 자체에 명시적으로 드러나야 한다.
### 2. 그릇된 정보를 피하라
- 나름대로 널리 쓰이는 의미가 있는 단어를 다른 의미로 사용해선 안된다.
- 여러 계정을 그룹으로 묶을 때, 실제 List가 아니라면 `accountList`라 명명하지 않는다.
- 서로 흡사한 이름을 사용하지 않도록 주의한다.
- 유사한 개념은 유사한 표기법을 사용한다.
    - 일관성이 떨어지는 표기법은 그릇된 정보다.
- 소문자 l이나 대문자 O 변수를 사용하지 않는다. 
    - 소문자 l은 1처럼 보이고 대문자 O는 0처럼 보인다.
### 3. 의미있게 구분하라*
- 컴파일러나 인터프리터만 통과하려는 생각으로 코드를 구현하는 프로그래머는 스스로 문제를 일으킨다.
- 연속된 숫자를 덧붙이거나 불용어(noise word)를 추가하는 방식은 적절하지 못하다.
    - 이름이 달라야한다면 의미도 달라져야 한다.
    - 불용어: 의미가 불분명한 용어
        - 개념을 구분하지 않은 채 이름만 달리 한 경우<br>ex: ProductData 혹은 ProductInfo 
    - 의미가 분명히 다르면 사용해도 무방
        - 모든 지역 변수는 a를 사용하고 모든 함수 인수는 the를 사용해도 된다.
        - 요지는 zork라는 변수가 있다는 이유만으로 theZork라는 이름 지어서는 안된다.
- **읽는 사람이 차이를 알도록 이름을 지어라**
### 4. 발음하기 쉬운 이름을 사용하라
### 5. 검색하기 쉬운 이름을 사용하라
- 문자 하나를 사용하는 이름과 상수는 텍스트 코드에서 쉽게 눈에 띄지 않는다는 문제점이 있다.
        - MAX_CLASSES_PER_STUDENT는 grep으로 찾기가 쉽지만, 상수 숫자 7은 7이 들어가는 파일 이름과 수식이 모두 검색되기 떄문에 찾기 어렵다.
        - 마찬가지로 e라는 문자도 변수 이름으로 적합하지 못하다.
        - e는 영어에서 가장 많이 쓰이는 문자.
- 이런 관점에서 긴 이름이 짧은 이름보다 좋다.<br> 검색하기 쉬운 이름이 상수보다 좋다.
- **이름 길이는 범위 크기에 비례해야 한다.**
    - 간단한 메소드에서 로컬 변수만 한문자를 사용하라..
### 6. 인코딩을 피하라
- 굳이 부담을 더하지 않아도 이름에 인코딩할 정보는 아주 많다.
- 유형이나 범위정보까지 인코딩에 넣으면 그만큼 이름을 해독하기 어려워진다.
- 인코딩한 이름은 거의가 발음하기 어려우며 오타가 생기기도 쉽다.
- 자바 프로그래머는 변수 이름에 타입을 인코딩할 필요가 없다~
- **인터페이스 클래스와 구현 클래스**
    - 인터페이스 이름은 접두어를 붙이지 않는 편이 좋다.
    - 옛날 코드에서 많이 사용하는 접두어 I는 주의를 흐르리고 과도한 정보를 제공한다.
    - 인터페이스 클래스 이름과 구현 클래스 이름 중 하나를 인코딩해야 한다면 구현 클래스 이름을 인코딩
        - ShafeFactoryImp나 심지어 CShapeFactory가 IShapeFactory보다 좋다.
### 7. 자신의 기억력을 자랑하지 마라
- 코드를 읽으면서 변수 이름을 자신이 아는 이름으로 변환해야 한다면 그 변수 이름은 바람직하지 못하다.
    - 이는 일반적으로 문제 영역이나 해법 영역에서 사용하지 않는 이름을 선택했기 때문에 생기는 문제다
- 문자 하나만 사용하는 변수 이름은 문제가 있다.
    - 루프에서 반복 횟수를 세는 변수 i,j,k는 괜찮다.(l은 절대 안된다.)
        - 단, 루프 범위가 아주 작고 다른 이름과 충돌하지 않을 때만 괜찮다.
        - 루프에서 반복 횟수 변수는 전통적으로 한 글자를 사용하기 때문
### 8. 클래스 이름
- 클래스 이름과 객체 이름은 **명사나 명사구가 적합**하다.
- Manager, Processor, Data, Info 등과 같은 단어는 피하고, 동사는 사용하지 않는다.
### 9. 메소드 이름
- 메소드 이름은 **동사나 동사구가 적합**하다.
- 접근자(Accessor), 변경자(Mutator), 조건자(Predicate)는 javabean 표준에 따라 값 앞에 **get**, **set**, **is**를 붙인다.
- 생성자(Constructor)를 중복정의(overload)할 때는 정적 팩토리 메소드를 사용한다.
    - 메소드는 인수를 설명하는 이름을 사용한다.
    - ex:) Complex fulcrumPoint = Complex.FromRealNumber(23,0); (O)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Complex fulcrumPoint = new Complex(23,0); (X)
- 생성자 사용을 제한하려면 해당 생성자를 private로 선언한다.
### 10. 기발한 이름은 피하라
- 이름이 너무 기발하면 농담을 기억하는 동안만, 이름을 기억한다.
- 재미난 이름보다 명료한 이름을 선택하라
- 특정 문화에서만 사용하는 농담은 피하는 편이 좋다.
- **의도를 분명하고 솔직하게 표현하라**
### 11. 한 개념에 한 단어를 사용하라
- 추상적인 개념 하나에 단어 하나를 선택해 이를 고수한다.
- 똑같은 메소드를 클래스마다 fetch, retrieve, get으로 제각각 부르면 혼란스럽다.
    - 어느 클래스에서 어느 이름을 썻는지 기억하기 어렵다.
- 메소드 이름은 독자적이고 일관적이어야 한다.
    - 그래야 주석을 뒤져보지 않고 프로그래머가 올바른 메소드를 선택한다.
- 마찬가지로 동일 코드 기반에 Controller, Manager, Driver를 섞어 쓰면 혼란스럽다.
    - DeviceManager와 ProtocolController는 근본적으로 어떻게 다른가?
    - 이름이 다르면 독자는 당연히 클래스도 다르고 타입도 다르리라 생각한다.
- **일관성 있는 어휘는 코드를 사용할 프로그래머가 반갑게 여길 선물이다.**
### 12. 말장난을 하지마라
- 한 단어를 두가지 목적으로 사용하지 마라
- 다른 개념에 같은 단어를 사용한다면 그것은 말장난에 불과하다.
- 같은 맥락이 아닌데도 '일관성'을 고려해 단어를 선택하는것은 문제가 된다.
- 프로그래머는 코드를 최대한 이해하기 쉽게 짜야 한다.
    - 집중적인 탐구가 필요한 코드가 아니라 대충 훑어봐도 이해할 코드 작성이 목표다.
    - 의도를 밝힐 책임이 저자에게 있는 잡지 모델이 바람직하다.
### 13. 해법 영역에서 가져온 이름을 사용하라
- **코드를 읽을 사람도 프로그래머라는 사실을 명심한다.**
    - 전산 용어, 알고리즘 이름, 패턴 이름, 수학 용어 등을 사용해도 괜찮다.
- 모든 이름을 문제 영역에서 가져오는 정책은 현명하지 못하다.
    - 같은 개념을 다른 이름으로 이해하던 동료들이 매번 고객에게 의미를 물어야하기 떄문이다.
- 프로그래머에게 익숙한 기술개념은 아주 많다.
    - 기술개념에는 기술 이름이 가장 적합한 선택이다.
### 14. 문제 영역에서 가져온 이름을 사용하라
- 적절한 '프로그래머 용어' 가 없다면 문제 영역에서 이름을 가져온다.
    - 그러면 코드를 보수하는 프로그래머가 분야 전문가에게 의미를 물어 파악할 수 있다.
- 우수한 프로그래머와 설계자라면 해법 영역과 문제 영역을 구분할 줄 알아야 한다.
- 문제 영역 개념과 관련이 깊은 코드라면 문제 영역에서 이름을 가져와야 한다.
### 15. 의미 있는 맥락을 추가하라.
- 스스로 의미가 분명한 이름이 없지 않다.<br>하지만 대다수 이름은 그렇지 못하다.
    - 그래서 클래스, 함수, 이름 공간에 넣어 맥락을 부여한다.
- 모든 방법이 실패하면 마지막 수단으로 접두어를 붙인다.
- 맥락을 개선하면 함수를 쪼개기가 쉬워지므로 알고리즘도 좀더 명확해진다.
### 16. 불필요한 맥락을 없애라
- Gas Station Deluxe라는 애플리케이션을 짠다고 가정하자<br>모든 클래스 이름을 GSD로 시작하겠다는 생각은 전혀바람직하지 못하다.
- 일반적으로 짧은 이름이 긴 이름보다 좋다. 
    - 단, 의미가 분명한 경우에 한해서다.
- 이름에 불필요한 맥락을 추가하지 않도록 주의한다.
