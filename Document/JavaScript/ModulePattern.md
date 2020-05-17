## [디자인 패턴 for javascript] Module Pattern

### Modules
>모듈은 탄탄한 어플리케이션 구조를 만들기 위한 필수적인 요소이다. <br> 모듈을 통해 프로젝트의 코드를 깔끔하고 잘 구조된 형태로 구조화 시킬수 있다.
- **The Module Pattern**
- **Object Literal notaion**
- **ADM modules**
- **CommonJS modules**
- **ECMAScript Harmony modules**


### Object Literals
> 객체 리터럴 표현에서 객체는 콤마로 구분되는 키/값 형태로 {} 안에 위치하게 된다.
- ex:)
    ```js
    var myObjectLiteral = {

        variableKey: variableValue,

        functionKey: function() {
            //...ㄹ
        }
        
    };
    ```
- 객체의 경우에는 new를 사용한 초기화가 필요없다.
- 객체의 밖에서는 Dot 표현으로 새로운 멤버를 추가하는것이 가능
    - ```myModule.property = "someValue"; ```
---
## The Module Pattern
>일반적으로 Module Pattern은 원래 기존의 소프트웨어 엔지니어링에서 클래스에 대한 private 와 public한 캡슈로하를 제공하는 방법으로 정의되었다.
- 자바스크립트에서 Module Pattern은 클래스의 컨셉을 모방해서 (ES6 부터는 클래스 지원) private, public 메소드<br> 모두를 포함시킬 수 있고 단일 객체 내의 변수를 포함할수 있다.
     - 이렇게 하면 특정부분의 전역스코프 로부터 보호하는것이 가능
     - 이런 특성의 결과로 우리는 동일 페이지 내에서도 함수이름이나 변수가 출동하는 것을 예방가능
     - 동일한 메소드 이름을 사용하지만 전혀 다른 스코프상에 존재해서 문제없다.
        ``` 
        first.imMethod()
        second.imMethod()
        ```
