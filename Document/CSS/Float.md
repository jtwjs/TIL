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
        - 순전히 CSS로 처리하는 기법 
        - 각 요소당 2개씩 만들수 있다. (::before, ::after)
        - **content**: 반드시 적어야하는 property


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

        
- Answer	&#128526;

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
  .menu-bar{
      background-color:white;
      padding-left:0;
      width:540px;
      border-bottom:1px solid #E5EAEF;
  }
  .menu-bar::after{
      content:" ";
      display:block;
      clear:left;
  }
  .menu-bar-item{
      float:left;
      list-style-type:none;
      margin-right:16px;
  }
  
  .menu-bar-item a{
      display:block;
      padding:16px 20px;
    
  }

  .menu-bar-item.selected a{
      color: #2860E1;
      border-bottom:2px solid #2860E1;
      font-weight:500;
  }
  
  .menu-bar-item:last-child{
      margin-right:0;
  }
```

![결과](https://user-images.githubusercontent.com/60641307/78091388-9c0e5700-7407-11ea-929f-1303980b7cc0.png)

---
## Float-2 실습
- TRY 	&#128531;

```CSS
* {
    box-sizing: border-box;
    margin: 0;
  }
  
  body {
    font-family: "Noto Sans KR", sans-serif;
    letter-spacing: -0.02em;
    background-color:black;
    height:100vh;

  }
  
  h1 {
    font-size: 16px;
    font-weight: 400;
    color: #1f2d3d;
    line-height: 1.25;
  }
  
  strong {
    font-size: 14px;
    font-weight: 400;
    color: #afb3b9;
    line-height: 1.4285714286;
  }
  
  p {
    font-size: 16px;
    color: #79818b;
    line-height: 1.5;
  }
  .card{
      background-color:white;
      width:531px;
   

  }
  .card::after{
      display:block;
      content:" ";
      clear:left;
  }
  .card-user{
      width:44px;
      height:44px;
      border-radius:50%;
      float:left;
     display:block;
     margin:20px 20px 56px 20px
     
    
  }
  .card-content{
      
      float:left;
      padding-top:20px;
      padding-bottom:20px;
  }
  .card-content-strong{
      padding-top:4px;
      padding-bottom:12px;
      display:block;
  }
```

![float2-mine](https://user-images.githubusercontent.com/60641307/78126268-3e9cf900-744d-11ea-87be-7c41e8129eea.png)

- Answer	&#128526;

```CSS
* {
  box-sizing: border-box;
  margin: 0;
}

body {
  font-family: "Noto Sans KR", sans-serif;
  letter-spacing: -0.02em;
}

h1 {
  font-size: 16px;
  font-weight: 400;
  color: #1f2d3d;
  line-height: 1.25;
}

strong {
  font-size: 14px;
  font-weight: 400;
  color: #afb3b9;
  line-height: 1.4285714286;
}

p {
  font-size: 16px;
  color: #79818b;
  line-height: 1.5;
}

/* ▼ WHERE YOUR CODE BEGINS */

.card {
  padding: 20px;
  background-color: #fff;
}

.card::after {
  content: "";
  display: block;
  clear: left;
}

.card-user {
  float: left;
  width: 44px;
  height: 44px;
  border-radius: 50%;
  margin-right: 20px;
}

.card-content {
  float: left;
}

.card-content h1 {
  margin-bottom: 4px;
}

.card-content strong {
  display: block;
  margin-bottom: 12px;
}
```
---
- Tip
  1. < li > 와 < a > padding을 줄 때
     - 무조건 anchor 태그에게 padding을 줄것
     - list_item 에게 패딩을 주면 anchor 영역은 딱 content 부분으로 한정됨
        - target 영역이 좁아서 클릭하기 힘듬
     - 사용성까지 고려한다면 target 영역을 넓힐수 있는 < a >태그에게 padding을 먹이자 !
  2. margin-top & bottom 둘 중 하나만 일관적으로 사용하자
      - 나도 bottom 파!
      - top,bottom을 둘다쓰면 나중에 보기에 헷갈린다 ~
  3. image 는 기본적으로 inline 이라고 적힌 요소지만 inline-block 같은 요소
      - float 할 경우 display가 block으로 변경됨
  4. 자주쓰는 코드를 클래스로 따로 만들어 놓는다.

    ```CSS
    - ex:) .clearfix::after{/*자주쓰는 코드*/
      content:'';
      display:block;
      clear:both;//범용적이라 both씀
    }
    ```

- Point
  1. 가로배치 할 녀석을 파악 후 float 줄 것!
  2. 그 요소를 감싸는 부모요소에게 clearfix 할것~
    