## [디자인 패턴 for javascript] Module Pattern
- **네임스페이스**
    - 수많은 함수, 객체, 변수들로 이루어진 코드가 전역 유효범위를 어지럽히지 않고, 애플리케이션이나 라이브러리를 위한 <br>하나의 전역 객체를 만들고 모든 기능을 이 객체에 추가하는 것을 
    - 코드 내의 이름 충돌뿐만 아니라 이코드와 같은 페이지에 존재하는 또다른 자바스크립트 라이브러리나 위젯 등 서드파티 코드와의<br> 이름충돌도 미연에 방지 해주는 것 
    - ex:) jQuery와 같은 라이브러리에서 jQuery가 네임스페이스를 가지며 jQuery 이름 내에 모든 기능을 추가하는 것
- 이러한 네임스페이스 패턴을 작은 기능들만을 모아놓은 패턴을 사용한것이 모듈패턴
### Modules
>모듈은 탄탄한 어플리케이션 구조를 만들기 위한 필수적인 요소이다. <br> 모듈을 통해 프로젝트의 코드를 깔끔하고 잘 구조된 형태로 구조화 시킬수 있다.
- **The Module Pattern**
- **Object Literal notaion**
- **ADM modules**
- **CommonJS modules**
- **ECMAScript Harmony modules**


### Object Literals (객체 리터럴 [싱글톤]) 
> 객체 리터럴 표현에서 객체는 콤마로 구분되는 키/값 형태로 {} 안에 위치하게 된다.
- 객체 리터럴이 하나의 객체라는 점(싱글톤), 독립된 모듈이라는 점(모듈 패턴)이라고 정의 가능
- 독립된 모듈은 자체적으로 필요한 내부 변수 및 내부 함수를 모두 갖고 있어야 한다.
    - 이와같이 내부 변수와 내부 함수를 가지고 있는 객체를 생성한다고 했을때 클로저를 이용
- ex:) 클로저를 이용한 모듈 패턴(즉시실행)
    ```js
    var module = (function () {
        //은닉될 멤버 정의
        var privateKey = 0;
        function privateMethod() {
            return ++privateKey;
        }
        //공개될 멤버(특권 메소드) 정의
        return{
            publickey : privateKey,
            publicMethod : function () {
                return privateMethod();
            }
        }
    })();

    console.log(module.publicMethod());//1
    console.log(module.publicmethod());//2 (클로저로 인한 결과)
    ```

- 모듈 패턴은 반환값이 함수가아니라 객체이며, 자동 호출된다는 점만 제외하면 클로저와 유사
- 인스턴스를 여러개 만들어낼수 있는 구조라는 점에서 싱글톤 패턴과 차이가 있다.
- 코드를 실행하면 익명함수가 자동으로 호출되어 익명함수가 반환하는 객체가 Module 변수에 할당되게 된다.
- 객체의 경우에는 new를 사용한 초기화가 필요없다.
- ex:) 자동호출 구조를 없앤 코드
    ```js
    var Module = function () {

        //은닉될 멤버 정의
        var privateKey = 0;

        function privateMethod() {
            return ++privateKey;
        }
        //공개될 멤버(특권 메소드) 정의
        return {
            publicKey : privateKey,
            publicMethod : function() {
                return privateMethod();
            }
        }
    };

    //두개의 인스턴스 생성
    var obj1 = Module();
    obj1.publicMethod(); //1출력
    obj1.publicMethod(); //2출력

    var obj2 = Module();
    obj2.publicMethod(); //1출력
    obj2.publicMethod(); //2출력
    ```
- 위와 같이 Module 함수를 정의(즉시실행X)하여 함수를 호출하면 여러개의 인스턴스인 객체를 생성하여 사용가능
- 클로저 인스턴스와 유사하지만 1가지 차이점은 내부에 익명함수에서 반환값이 함수가아니라 객체를 반환
---
## The Module Pattern
>일반적으로 Module Pattern은 원래 기존의 소프트웨어 엔지니어링에서 클래스에 대한 private 와 public한 캡슐화를 제공하는 방법으로 정의되었다.
- 자바스크립트에서 Module Pattern은 클래스의 컨셉을 모방해서 (ES6 부터는 클래스 지원) private, public 메소드<br> 모두를 포함시킬 수 있고 단일 객체 내의 변수를 포함할수 있다.
     - 이렇게 하면 특정부분의 전역스코프 로부터 보호하는것이 가능
     - 이런 특성의 결과로 우리는 동일 페이지 내에서도 함수이름이나 변수가 출동하는 것을 예방가능
     - 동일한 메소드 이름을 사용하지만 전혀 다른 스코프상에 존재해서 문제없다.
        ``` 
        first.imMethod()
        second.imMethod()
        ```
### Privacy
>Module Pattern은 클로저를 사용해서 상태와 구조를 캡슐화 시켜 prviate하게 만들수 있다.
<br>이는 private와 public한 메소드나 변수를 함께 사용하도록 Wrapping 할 수 있으며 이를 통해 글로벌 스코프로 빠져나가는 것을 막을 수 있다.
<br> 또 다른 개발자의 인터페이스와 충돌하는 것을 예방할수 있다.
- 이 패턴에서는 오직 public API의 경우에만 리턴이되고 나머지는 모두 클로저 안에서 private하게 위치하게 된다.
    - 우리의 로직을 보호할수 있고 오직 필요한 부분만 외부로 노출시켜 다른 부분에서 사용할수 있게 만듦
    - 이는 IIFEimmediately-invoked functional expression과 유사하다.
- 자바스크립트는 private에 대한개념이없다. 
    - 그러므로 함수의 스코프 개념을 통해 이러한 특징을 흉내낸다.

### History
- Module Pattern은 2003년 Richard Cornford 등이 포함된 개발자들에의해 개발되어짐
- Douglas Crockford의 강의를 통해서 유명해지기 시작

### Example
-    ``` js
    var testModule = (function () { // 내부의 모든 리소스는 해당 모듈 이름 testModule 통해서만 접근 가능
        var counter = 0;    // 글로벌 스코프로부터 완벽하게 보호
        return {
            incrementcounter: function() { //직접 접근 불가
                return counter++;
            },
            
            restCounter: function() {   //직접 접근 불가
                console.log("counter value prior to reset: " +counter );
                counter = 0;
            }
        };
    }) ();

    testModule.incrementCounter();
    testModule.resetCounter();
    ```
-   ```js
    var myNamespace = (function() {
        var myPrivateVar, myPrivateMethod;

        //private 변수
        myPrivateVar = 0;

        //private 함수
        myPrivateMethod = function ( foo ){
            console.log( foo );
        };

        return { 
            //public 변수
            myPublicVar: "foo",

            //public 함수
            myPublicFunction: function( bar ) {
                myPrivateVar++;
                myPrivateMethod( bar );
            }
        };
    }) ();

    ```
- 쇼핑카트 (module pattern)
    - ```js
      var basketModule = (function () {
          //private
          var basket = [];

          function doSomethingPrivate() {
              //...
          }

          function doSomethingElsePrivate() {
              //...
          }

          return {
              additem: function(values) {
                  basket.push(values);
              },

              getItemCount: function() {
                  return basket.length;
              },

              doSomething: doSomethingPrivate,

              getTotal: function(){
                  var q = this.getItemCount(),
                      p = 0;

                    while( q--) {
                        p += basket[q].price;
                    }
                    return p;
              }
          };
      }) ();
      ```

      ```js
      basketModule.addItem({
          item: "bread",
          price: 0.5
      });

      basketModule.additem({
          item: "butter",
          price: 0.3
      });

      //Outputs: 2
      console.log(basketModule.getItemCount() );

      //Outputs: 0.8
      console.log(basketModule.getTotal() );

      //Outputs: undefined
      //모듈에서 return 되지 않은 대상은 접근이 불가능
      console.log( basketModule.basket):

      console.log(basket);
      ```

#### 즉시실행함수로 감싸게되면 얻는 이점
    ```js
    var basketModule = (function(){
        ...
    })()
    ```
- 혹시 모르게 변수의 스코프가 외부로 흘러나가게 되어 전역상태의 변수의 상태를 어지럽히게 됨을 완전히 차단
    - 완벽한 private한 상태
- 보통 함수를 선언하고 이름이 붙여진 상태라면 함수가 에러를 발생하면 쉽게 어떤 함수에서 에러가발생했는지 확인가능

### 모듈 패턴의 장.단점
#### 단점
- 전체적으로 코드량이 약간 더 많이 증가 / 다운로드 해야할 파일크기가 늘어남
- 전역 인스턴스가 단 하나뿐이기에 코드의 어느 한 부분이 수정되어도 전역 인스턴스를 수정하게 됨
- 즉, 나머지 기능들도 갱신된 상태를 물려받게 됨

#### 장점
- 점점 더 늘어만 가는 코드를 정리할때 널리 사용되며 자바스크립트 코딩패턴에서 널리 권장되는 방법이기도 함 

## 모듈 기본패턴 정의
1. 네임스페이스를 설정하고 모듈을 정의
```js
var MyApp = {} //전역객체 
MyApp.modules = {}
```
2. 공개범위(특권메소드 등..)와 비공개 유효범위를 만든다.
    - 즉시 실행함수로 모듈이 될 객체를 반환하고<br> 모듈 사용자에게 제공할 공개 인터페이스가 담기게 된다.
```js
MyApp.modules.libs = (function() {

    //비공개 프로퍼티
    //var 선언 및 비공개 메소드등의 유효범위 (private 멤버)

    //공개 API (public , previlege 멤버)
    return {

    };
})();
```
