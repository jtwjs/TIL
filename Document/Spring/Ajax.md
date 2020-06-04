## Ajax (Asynchronous Javascript And Xml(비동기식 자바스크립트))
>JavaScript의 라이브러리중 하나<br>브라우저가 가지고있는 XMLHttpRequest 객체를 이용해서 전체 페이지를 <br>새로 고치지 않고도 페이지의 일부만을 위한 데이터를 로드하는 기법
- Javascript를 사용한 비동기 통신
- 클라이언트와 서버간에 XML 데이터를 주고받는 기술
- **자바스크립트를 통해서 서버에 데이터를 요청하는 것**
#### 비동기(async)방식
> Ajax를 통해서 서버에 요청을 한 후 멈추어 있는것이 아니라 그 프로그램은 계속 돌아간다는 의미를 내포하고 있다.
![동기 비동기차이](https://user-images.githubusercontent.com/60641307/83753736-c994ac80-a6a5-11ea-8acb-4045e585b7c5.png)


- 비동기 방식은 웹페이지를 리로드하지 않고 데이터를 불러오는 방식
- 장점
    - 페이지 리로드의 경우 전체 리소스를 다시 불러와야하는데 이미지, 스크립트, 기타 코드등을 모두 재요청할 경우 불필요한 리소스 낭비가 발생되지만 <br>비동기식 방식을 이용한 경우 필요한 부분만 불러와 사용할수 있으므로 매우 큰 장점
### Ajax
- html 페이지 전체가 아닌 일부분만 갱신할수 있도록 XML HttpRequest객체를 통해 서버에 request를 함
    - 이 경우 **json이나 xml 형태로 필요한 데이터만 받아 갱신**하기 때문에 자원과 시간을 아낌
#### 장점
- **필요한 부분만 불러와 사용할 수 있다.**
1. 웹페이지의 속도향상
2. 서버의 처리가 완료 될떄까지 기다리지 않고 처리 가능
3. 서버에서 Data만 전송하면 되므로 전체적인 코딩의 양이 줄어듬
4. 기존 웹에서 불가능했던 다양한 UI를 가능하게 해줌
    - 사진공유 사이트 Flicker의 경우 사진이나 제목 태그를 페이지 리로드없이 수정가능
#### 단점
1. History 관리가 안된다(보안에 신경을 더써주어야함)
2. 연속으로 데이터를 요청하면 서버 부하가 증가할 수 있다.
3. XMLHttpRequest를 통해 통신을 하는 경우 사용자에게 아무런 진행정보가 주어지지 않는다.    
    - 그래서 아직 요청이 완료되지 않았는데 사용자가 페이지를 떠나거나 오작동할 우려가 발생하게 됨
### Ajax를 사용 가능하게 만드는 것들
>Ajax라는 기술은 여러가지 기술이 혼합적으로 사용되어 이루어진다.
- HTML
- DOM
- JavaScript
- XMLHttpRequest
- Etc
### Ajax로 할 수 있는 것
- Ajax라는 네트워크 기술을 이용하여 클라이언트에서 서버로 데이터를 요청하고 그에 대한 결과를 돌려받을수 있다.
### JQuery와의 시너지
- 일반 Javscript만으로 Ajax를 하게되면 코딩량도 많아지고 브라우저별로 구현방법이 다른단점이 있다.
- jQuery를 이용하면 더 적은 코딩량과 동일한 코딩방법으로 대부분의 브라우저에서 같은 동작을 할 수 있다.
- jquerty ajax를 사용하면, HTTP GET 방식과 HTTP POST 방식 모두를 사용하여 원격 서버로부터 데이터 요청 가능

### jQuery 코드
```javascript
    $.ajax({
        url: '주소',
        type: 'get 또는 post',
        data: {
            //보낼 데이터
        },
        dataType: 'json, xml, script, text 또는 thml',
        done: function(response) {
            //성공 시 동작
        },
        fail: function(error) {
            //실패 시 동작
        },
        always: function(response) {
            //성공하든 실패하든 항상 할 동작
        }
    })
```
#### get 이나 post만을 전문적으로 하는 메소드
- 데이터와 데이터타입은 입력하지 않아도 된다.
 ```javascript
    $.get('주소','데이터',function(res) {
        //성공 시 동작
    }, '데이터타입');
    $.post('주소','데이터',function(res){
        //성공 시 동작
    }, '데이터타입')
  ```
#### 스크립트와 JSON만을 전문적으로 가져오는 메소드
```javascript
$.getScript('스크립트 주소', function(script){
    //성공 시 동작
});
$.getJSON('JSON 주소',{데이터}, function(data){
    //성공 시 동작
});
```
#### 선택한 태그 안에 다른 html 파일로부터 가져온 태그를 넣는 메소드
```javascript
    $('#zero').load('다른 html 주소');
```
---
### @RequestMapping의 produces 속성
> @RequestMapping의 produces 속성을 이용해 Response의 Content-Type을 제어할 수 있다. 

#### Produces, Headers 속성
|Element|요청 조건|지원버전|
|:--|:---|:--|
|headrs|HTTP 헤더|3.0.3.1|
|produces|Accept 헤더|3.1|
- Accept 헤더는 headrs 대신 produces 엘리먼트를 이용해 조건을 지정할수 있다.
    - headers와 같은 동작
- **produces**
    - ```java
        @RequestMapping(value="/prod", produces ={"application/JSON"})
        @ResponseBody
        String getProduces(){
            return "Produces attribute";
        }
      ```
- headers
    - ```java
        @RequestMapping(value="/head", headrs= {"content-type=text/plain"})
        String post(){
            return "Mapping applied along with headers";
        }
      ```
- 위와 같이 content-type을 적느냐 안적느냐 차이가 있다.
    - 공통헤더와 요청헤더의 차이
    - headrs는 공통헤더이기 때문에 그중에 content-type="text/plain"인걸 찾으려하는 것
    - producs는 accept헤더를 찾기 때문에 content-type등을 안적어도 된다