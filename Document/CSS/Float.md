## Float
---
Block 요소들을 가로배치 하기위해 쓰인다.
- **What happens**
>> LayOut이 박살난다.
1. 집 나간 내 새끼, 찾을 길 없네.
    - 공간을 차지하지 않는다.
2. Block으로 신분상승
    - Block 박스로 변환
3. Block인데 길막을 하지못한다.
    1. 별도의 width값을 주지않으면 부모 width값을 얻는다. -> X
        - 실제 content 길이만큼 너비를 가진다.
    2. width값을 준 경우, 남은 공간을 margin으로 자동으로 채운다. -> X
        - 자동으로 생기는 margin:auto가 생기지 않는다
        - 빈공간이 생긴다는 뜻. (옆으로 나란히 배치 가능)
4. Float, 나만 볼 수 있어요(feat.인라인)
    - Block 박스들은 float된 요소를 없는 박스로 취급 (감지를 못함)
    - inline 박스들은 감지함(e.g: image,text)


- **How to fix it**
1. Honeyful Trick
    - overflow: hidden;
        - 집나간 자식을 찾는다.
        - float된 자식을 갖고있는 부모한테 위 옵션을 주면 float된 자식요소를 감지한다.
2.  &#128150;Clearfix
    - clear: left | right | both
        - float된 요소를 감지하겠다는 선언
        - display가 block인 요소에만 쓸수 있다.
        - pseudo Element[::befor, ::after] + clear: left|right|both
    - Pseudo Element
        - HTML에는 존재하지 않는 **가상 요소**
        - ::before, ::after
        - 순전히 CSS로 처리하는 기법 
        - 각 요소당 2개씩 만들수 있다.
        - **conent**: 반드시 적어야하는 property


---
## Float-1 실습
- TRY 	&#128531;

```CSS
* {
    box-sizing: border-box;
    margin: 0;
  }
  
  body {
    font-family: "Roboto", sans-serif;
    letter-spacing: -0.02em;
    height:100vh;
    background-color:black;

  }
  
  a {
    font-size: 18px;
    line-height: 20px;
    color: #8492a6;
    text-decoration: none;
  }
  ul{
    list-style-type:none;
    display:inline-block;
    height:52px;
    width:540px;
    padding-left:0;
    background-color:white;
  }
  li{display:inline-block;
    padding:16px 20px 18px;
    margin-right:16px;
  }
  li:nth-child(2) {
    border-bottom: 2px solid #2860E1;
  }
  li:nth-child(5){
    margin-right:94px;
  }
  li:nth-child(2) a{
    color: #2860E1;
  }
  /* ▼ WHERE YOUR CODE BEGINS */
```

![float1-내가한거](https://user-images.githubusercontent.com/60641307/78023038-e6a0bc80-7390-11ea-8b77-fbc62d22757c.png)

        
- Result	&#128526;
