

## 콜백(CallBack)
>함수 안에서 어떤 특정한 시점에 호출되는 함수를 의미
- 보통 콜백함수는 함수의 매개변수로 전달하여 특정 시점에서 콜백 함수를 호출한다.

- **함수 정의**
    ```js
    // 콜백 함수가 될 매개변수 설정
    function plus(a, b, callback) {
        let sum = a + b;
        callback(sum);
    }
    //callback 매개변수를 넣어주고 plus함수 내부에서 callback 매개변수를 함수 형태로 실행..
    ```
- **정의한 함수 호출**
    ```js
    // plus 함수에 익명 함수를 인자로 전달
    plus(1, 2, function(result) {
        console.log(result);
    });
    //익명 함수를 전달하고 plus 함수를 호출中..
    //콜백 함수가 맨 뒤에 있기 때문에 모든 로직이 처리되고 난 시점에서 콜백함수가 호출됨
    결과 / =3
    ```
- **정의된 함수를 인자로 전달**
    ```js
    function plus(a, b, callback) {
        let sum = a + b;
        callback(sum);
    }

    function print(result) { //콜백 함수로 사용될 함수 정의
    console.log(result);
    }

    plus(1,2,print)
    //익명 함수를 전달하는것 대신 미리 정의된 함수 print를 전달中..
    //print 함수 역시 callback 매개변수가 호출되고 있는 시점에 호출되고 있다.
    ```
### 이벤트와 콜백 함수
> 특정 이벤트가 발생할 때마다 함수를 실행하고 싶을때 콜백함수를 사용

- exx:) 
    ```js
    $("button").click(function() {
        alert(1);
    });
    click 이벤트가 발생할 때마다 콜백 함수가 실행되어 버튼을 누를때마다 경고창이 뜨게 가능
    ```

### 콜백 함수를 사용하는 이유
> 어떤 동작이 끝나고 함수를 호출하는거라면 그냥 순차적으로 함수를 호출 하면되지않을까 생각도 가능 

- **일반적인 경우**
    ```js
    function plus(a,b) {
        let sum = a + b;
        return sum;
    }

    function print(result) {
        console.log(result);
    }

    print(plus(1,2));
    // print함수가 실행되기 위해서는 plus 함수의 실행이 전부 완료가 되야한다. 
    //즉, print함수는 plus함수의 동작이 끝날때까지 계속 기다린다.
    ```
    - 웹의 경우일때 위코드가 웹사이트의 동작에 해당하는 코드이고 plus함수가 로직이 복잡해서<br>
    처리속도가 늦어지게 되면 실행이 계속 지연되기 때문에 js로 이루어진 웹사이트의 모든 동작이 멈추게된다.
- **콜백 함수를 사용한 경우** 
    ```js
    function plus(a, b, callback) {// plus함수 정의
        let sum = a + b;
        callback(sum);
    }
    ```
    - 반면 콜백함수를 이용하여 동작을 구현하면 처리가 끝날때까지 기다리는 것이 아닌<br>처리가 끝나는 시점에서 함수를 호출한다. 
    - 즉, 정말로 필요할 때만 함수를 호출해서 효율이 좋고 웹사이트에서도 여러가지 동작을 할수 있다.

    > 위와 같은 방법을 비동기식 처리방법이라한다. <br> 현재 웹사이트들은 비동기식 처리방법인 ajax를 활용하여 더 활발하게 동작할수 있게 되었다.<br> 따라서 콜백 함수는 비동기식 처리방법에 있어서 정말 중요한 개념이다.
