## Form 태그
>사용자의 데이터를 서버에 전송하기위해 사용
><br> 사용자로부터  Input을 받기 위한 태그
- **form**
    - ``` <form action="" method=""></form> ```
### Syntax Alert 문법주의
- 반드시 **action**, **method** (attribute) 명시
- action="API 주소"
    - API 주소 : form을 처리할 로직이 있는 URL
    - 사용자가 입력한 데이터를 전송할 서버의 URL
    - Back-End 개발자가 form을 처리하는 로직을 담은 서버쪽 코드에 접근할수있는 경로를 넣는다
    - 없을때는 임시방편으로 #을 넣어주자
- method="GET | POST"
    - 사용자가 입력한 데이터를 **전송하는 방법**으로 GET, POST가 있다.
    - GET : 사용자의 입력 데이터를 url에 표시하며, 데이터 크기에 제한이있고 쿼리형식
    - POST : 데이터의 크기의 제한이 없어 많은 양의 데이터를 전달 가능
### **GET과 POST의 차이점**
1. **GET**
    - URL에 정보가 담겨서 전송된다.
        - URL 상에 파라미터를 표현할 때에는 "?" 앞뒤로 구분하여 앞에 것은 'URL' 뒤의 것은 '파라미터'이다.
        - 각각의 파라미터는 '&'로 구분
        - '='을 이용하여 파라미터와 파라미터의 값을 구분한다.
    - 전송할 수 있는 정보의 길이가 제한되어 있다.
    - 퍼머링크로 사용될 수 있다.
        - 정보를 식별하는 고유한 식별자(고유한 주소체계)
2. **POST**
    - **header의 내용을 body에 담겨서 전송된다.**
    - URL 상에 전달한 정보가 표시되지 않는다.
    - GET에 비해서 보안상 약간의 우위에 있다.(사실상 동일)
    - 전송할 수 있는 데이터의 길이 제한이 없다.
    - 퍼머링크로 사용할 수 없다.
    - 서버쪽에 어떤 작업을 명령할 때 사용한다.
        - 데이터의 기록, 삭제, 수정 등
    - (attribute) **enctype** 
        - ```form enctype="속성 값" ```
        - 파일첨부할때 사용 ('POST'인 경우에만 사용가능)
        - 속성값 : multipart/form-data
            - 모든 문자를 인코딩하지 않음을 명시
            - 파일 또는 이미지를 서버로 전송할때 주로 사용
>퍼머링크(permalink)는 인터넷에서 특정 페이지에 영구적으로 할당된 URL 주소를 뜻한다. 
### 사용 용도
1. 로그인을 위해서 아이디/비밀번호를 입력할 때
2. 회원가입을 하기 위해서 개인정보를 입력할 때
3. 블로그나 게시판에 글을 작성하거나, 파일을 전송할 때

### Input(인풋)
>입력창, 인풋 필드 Input field
- **Syntax Alert 문법주의**
    - ```type="?" ```반드시 명시
    - ``` <input type="text" /> ```
- ``` type="text"``` 
    - 한줄정도의 분량의 모든 text는 다 받을수 있다. 
- ```type="email" ```
    - 서버에 보내기전 이메일 주소양식의 유효성검사를 한다.
    - @가 있는지 여부 판단
- ```type="password" ```
    - 기입할때 별표(*)로 표시 
- ```type="url"```
    - 서버에 보내기전 url 주소양식의 유효성검사를 한다.
- ```type="number"```
    - 숫자값만 입력가능..
    - (attribute) max="" min=""
        - ``` <input type="number" max="5" min="3"```
        - 입력할 숫자의 max(최대값), min(최소값) 지정하는 속성 사용 가능 
- ```type="file"```
    - 파일첨부UI를 만들기위해 사용
    - (atrribute) accept=""
        - ```<input type="file" accept=".png,.jpg.." /> ```
        - 파일의 확장자를 한정할때 사용
#### 사용가능한 속성
- placeholder
    - ``` <input type="" placeholder=""/> ```
    - 인풋창에 아무값도 없을때 보여질 기본 문구 작성
- maxlength
    - ```<input type="" maxlength=""/> ```
    - 인풋창에 입력할수 있는 문자의 갯수를 제한할때 사용
- minlenght
    - ```<input type="" minlength=""/> ```
    - 인풋창에 입력값의 최소갯수를 지정할때 사용
- required
    - ```<input type="" required /> ```
    - 무조건 입력 해야하는 태그로 지정
- disabled
    - ```<input type="" disabled /> ```
    - 사용자가 특정 인풋값을 사용하지 못하게 막아둘때 사용
- value
    - ```<input type="" value="" /> ```
    - 아무값이 없을때 미리 데이터값을 집어넣을때 사용
        - placeholder랑 비슷하지만 다름 
### Label(레이블)
> 폼 양식에 이름을 붙이는 태그
- ```<label> </label> ```
- **Syntax Alert 문법주의**
    - **for**(attribute) 반드시 명시
        - ```<label for="누구">라벨</label> ```
        - 연결시키고자 하는 input 필드의 id값을 적는다.
        - **#을 쓰지않고 id값만 적는다...**
- 사용성 개선에 중요한 역할!!
    - 센스있게 input form 태그에 라벨을 달아주자
### radio & checkbox
- ``` <input type="radio" /> ```
    - 여러항목중 하나만 선택
- ``` <input type="checkbox" /> ```
    - 여러항목 선택 가능
    - label과 연결시켜 사용

- **Syntax Alert 문법주의**
     - **name**(attribute) 반드시 명시
        - ```<input type="radio & checkbox" name="" />```
        - name이 동일하게 설정되어야 **그룹핑** 
    - **value**(attribute) 반드시 명시
        - ```<input type="radio & checkbox" value="" />```
        - 서버에 보낼 값을 구분하기 위해 **서로 다른값으로 명시**해줘야함
### Select & Option
> full down 메뉴 만들때 사용
- ```HTML
    <select>
        <option>.</option>
        <option>.</option>
        <option>.</option>
    </select>
    ```
- multiple(attribute)
    - 여러 항목 선택 
    - ```<select multiple name="" ></select> ```
- **Syntax Alert 문법주의**
     - **name**(attribute) 반드시 명시
        - ```<select name=""> </select>```
        - select한테 반드시 name 값 주자..
    - **value**(attribute) 반드시 명시
        - ```<option value="" > </option>```
        - 서로를 구분할수 있게 value값 주자..
        
