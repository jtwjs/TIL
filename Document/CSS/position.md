# CSS Position
## 1.static
- CSS에는 position값으로 아무것도 할당하지 않는다.
- 각 element들은 **position:static**을 기본값으로 가진다.
- **static**이면 offset 값을 무시함 정적인위치를 가짐


## 2.relative
- 원래 기본적인 포지션 위치(static)에서 상대적인 포지션을 가질수 있다.
- 다른 컨텐츠가 이 엘리먼트에 의해 생긴 **빈공간**에 위치할수 없다.
    **빈공간**이란 원래 위치해야 할곳을 의미
- 다른 요소들에 영향을 안준다.
- 오프셋 속성을 이용해서 원래의 위치에서 상대적인 위치를 지정가능

## 3.absolute
- 가장 가까운 containing block에 상대적인 위치를 설정할수 있다.
    1. 조상 요소가 position이 static 이 아닌 경우 
        - 만만한 relative 를 사용  (주변요소의 영향 안끼치는 relative)
- containing block이 없다면 html을 기준으로 하며 위치값에 따라 스크롤이 생길수도 있음

```
집을나간다 부모가 인식을못한다. 
display가 block으로 변함
길막을 못함 -> float과 동일 (margin auto가 발생안함)
+ 혼자 붕떠서 다른요소들이 감지를 못함
```
## 4.fixed
- fixed엘리먼트는 뷰포트에 상대적으로 위치가 지정된다.<br>페이지가 스크롤되더라도 늘 같은 곳에 위치한다는 뜻
    - viewport : i.e, 화면 Display상의 표시 영역
- 모바일 브라우저의 경우 fixed 엘리먼트 지원이 굉장히 불안함

```
집을나간다 부모가 인식을못한다. 
display가 block으로 변함
길막을 못함 -> float과 동일 (margin auto가 발생안함)

```
---
## position 요소를 옮겨야 할 위치를 지정해주는 property
- **offset** :
    - **top | bottom | left | right** : px;
    - 가까운 기준점을 사용하는것이 정신건강에 좋다!
- **z-index** : 정수; 
    - z축을 지정해준다. 

---
## Position-1 실습
- TRY 	&#128531;

```CSS
* {
    box-sizing: border-box;
    margin: 0;
  }
  
  body {
    font-family: "Lato", sans-serif;
    background-color:black;
  }
  
  h1 {
    font-size: 16px;
    font-weight: 400;
    line-height: 1.5;
    color: #273444;
  }
  .user-info{
      width:107px;
      height:40px;
      position:relative;
  }
  .user-card{
    background-color:white;
    width:240px;
    height:56px;
    padding:8px 12px;
    
  }
  .user-photo{
    position:reltaive;
    width:40px;
    height:40px;
    top:8px;
    left:12px;
        
}
  .user-image{
     width:40px;
     height:40px;
     border-radius:50%;
  }
  
  .user-status{
    position:absolute;
    box-sizing:content-box;
    width:8px;
    height:8px;
    border-radius:50%;
    background-color:#21D891;
    border:2px solid #FFFFFF;
    bottom:-2px;
    left:30px;
  }
  .user-name{
    position:absolute;
    top:8px;
    right:1px;
  }
  
```
![제목 없음](https://user-images.githubusercontent.com/60641307/78451212-259b7e80-76bf-11ea-9c74-ce84eeee59bf.png)


- Result	&#128526;

```CSS
* {
    box-sizing: border-box;
    margin: 0;
  }
  
  body {
    font-family: "Lato", sans-serif;
  }
  
  h1 {
    font-size: 16px;
    font-weight: 400;
    line-height: 1.5;
    color: #273444;
  }
  
  /* ▼ WHERE YOUR CODE BEGINS */
  
  .user-card {
    max-width: 240px;
    padding: 8px 12px;
    border: 1px solid #e5eaef;
    border-radius: 4px;
  }
  
  .user-card::after {
    content: "";
    display: block;
    clear: left;
  }
  
  .user-photo {
    float: left;
    position: relative;
    width: 40px;
    height: 40px;
    margin-right: 12px;
  }
  
  .user-photo img {
    width: 100%;
    height: auto;
    border-radius: 50%;
  }
  
  .user-photo .user-status {
    position: absolute;
    bottom: -2px;
    right: -2px;
    width: 12px;
    height: 12px;
    border: 2px solid #fff;
    border-radius: 50%;
    background-color: #21d891;
  }
  
  .user-name {
    float: left;
    padding: 8px 0;
  }
```
![제목 없음](https://user-images.githubusercontent.com/60641307/78452687-9777c600-76c7-11ea-8a96-bb3c47680456.png)
---
## Positino-2 실습

- TRY 	&#128531;

```CSS
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Position 2</title>
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700&display=swap" rel="stylesheet" />
    <link rel="stylesheet" href="./style.css" />
  </head>
  <body>
    <div class="card">
      <div class="card-carousel">
        <img src="./assets/img-card.jpg" alt="그랜드캐년" />
        <button type="button" aria-label="이전" id="prev"></button>
        <button type="button" aria-label="다음" id="next"></button>
      </div>
      <div class="card-content">
        <h1>
          그랜드캐년+앤텔롭+홀슈밴드 자유일정
        </h1>
        <span>
          김버그트래블
        </span>

        <strong>
          <span>
            1인
          </span>
          180,000원
        </strong>
      </div>
    </div>
  </body>
</html>
```
![position2](https://user-images.githubusercontent.com/60641307/78467461-144a8480-7748-11ea-9e12-a8b56fc48cd0.png)


- Result	&#128526;

```CSS
* {
    box-sizing: border-box;
    margin: 0;
  }
  
  body {
    font-family: "Noto Sans KR", sans-serif;
    letter-spacing: -0.02em;
    background-color:black;
  }
  
  h1 {
    font-size: 22px;
    font-weight: 500;
    color: #1f2d3d;
    line-height: 1.4545454545;
  }
  
  span {
    font-size: 14px;
    font-weight: 400;
    color: #7d858f;
    line-height: 1.5;
  }
  
  strong {
    font-size: 22px;
    color: #2860e1;
    line-height: 1.0909090909;
  }
  
  strong span {
    font-size: 16px;
    font-weight: 400;
    color: #525d69;
    line-height: 1.5;
  }
  
  button {
    display: block;
    width: 28px;
    height: 28px;
    border: none;
    background-size: contain;
    background-repeat: no-repeat;
    background-position: center center;
    background-color: transparent;
  }
  
  #prev {
    background-image: url(./assets/icon-backward.svg);
  }
  
  #next {
    background-image: url(./assets/icon-forward.svg);
  }
  
  /* ▼ WHERE YOUR CODE BEGINS */
  
  .card {
    width: 400px;
  }
  
  .card-carousel {
    position: relative;
  }
  
  .card-carousel img {
    display: block;
    width: 100%;
    height: auto; /*img태그는 width:100% height:auto */
  }
  
  .card-carousel button {
    position: absolute;
    top: 50%;                   /*%를이용하여 위치시킬때*/
    transform: translateY(-50%);/*transform 속성을 써먹자*/
  }
  
  .card-carousel #prev {
    left: 0;
  }
  
  .card-carousel #next {
    right: 0;
  }
  
  .card-content {
    padding: 12px 16px;
    background-color: #fff;
  }
  
  .card-content h1 {
    margin-bottom: 2px;
  }
  
  .card-content > span {/* >로 자식요소 지정해줄수있음*/
    display: block;
    margin-bottom: 8px;
  }
  
  .card-content strong {
    display: block;
    text-align: right;
  }

```


![bug_position2](https://user-images.githubusercontent.com/60641307/78467826-b6b83700-774b-11ea-8ea7-df178241e7f7.png)


---
## Position-3 실습
- TRY 	&#128531;

```CSS
* {
    box-sizing: border-box;
    margin: 0;
  }
  
  body {
    width: 100%;
    height: 100vh;
    font-family: "Nunito Sans", sans-serif;
    color: #273444;
    background-color: #000;
  }
  
  input:focus,
  input:active,
  button:focus,
  button:active {
    box-shadow: none;
    outline: none;
  }
  
  .modal {
    background-color: #fff;
    width:671px;
    position:relative;
    padding:32px 40px;
    border-radius:4px;
  }
  
  .modal-title {
    font-size: 24px;
    font-weight: 600;
    line-height: 1.6666666667;
    margin-bottom:4px;
    text-align:center;
  }
  
  .modal-desc {
    font-size: 16px;
    line-height: 1.5;
    margin-bottom:24px;
    color:#273444;
  }
  
  .input-group input,
  .input-group button {
    font-size: 14px;
    font-family: "Nunito Sans", sans-serif;
    line-height: 1.4285714286;
    height:36px;
  }
  
  .close-button {
    width: 20px;
    height: 20px;
    border: none;
    background-color: transparent;
    background-image: url(./assets/icon-close.svg);
    background-position: center center;
    background-size: contain;
    background-repeat: no-repeat;
    position:absolute;
    top:12.17px;
    right:12.17px;
    
    
  }
  
  /* ▼ WHERE YOUR CODE BEGINS */
    .input-group{
     width:298px;
     margin:0 auto;
      
    }

    .input-group input{
     border-radius:4px;
     border:none;
     background-color:#F6F8FA;
     margin-right:8px;
     padding:8px 16px;
    }

    .input-group button{
     background-color:#2860E1;
     border-radius:4px;
     border:none;
     color:#FFFFFF;
     padding:8px 14px;
    }
```

![position3](https://user-images.githubusercontent.com/60641307/78468421-f8001500-7752-11ea-8aac-6a85a8171fff.png)

- Result	&#128526;

```CSS
* {
    box-sizing: border-box;
    margin: 0;
  }
  
  body {
    width: 100%;
    height: 100vh;
    font-family: "Nunito Sans", sans-serif;
    color: #273444;
    background-color: #000;
  }
  
  input:focus,
  input:active,
  button:focus,
  button:active {
    box-shadow: none;
    outline: none;
  }
  
  .modal {
    background-color: #fff;
  }
  
  .modal-title,
  .modal-desc {
    text-align: center;
  }
  
  .modal-title {
    font-size: 24px;
    font-weight: 600;
    line-height: 1.6666666667;
  }
  
  .modal-desc {
    font-size: 16px;
    line-height: 1.5;
  }
  
  .input-group input,
  .input-group button {
    font-size: 14px;
    font-family: "Nunito Sans", sans-serif;
    line-height: 1.4285714286;
  }
  
  .close-button {
    width: 20px;
    height: 20px;
    border: none;
    background-color: transparent;
    background-image: url(./assets/icon-close.svg);
    background-position: center center;
    background-size: contain;
    background-repeat: no-repeat;
  }
  
  /* ▼ WHERE YOUR CODE BEGINS */
  
  .modal {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    padding: 32px 40px;
    border-radius: 4px;
  }
  
  .modal-title,
  .modal-desc {
    text-align: center;
  }
  
  .modal-title {
    margin-bottom: 4px;
  }
  
  .modal-desc {
    max-width: 590px;
    margin-bottom: 24px;
  }
  
  .close-button {
    position: absolute;
    top: 8px;
    right: 8px;
  }
  
  .input-group {
    text-align: center;
  }
  
  .input-group input {
    width: 200px;
    height: 36px;
    padding: 8px 16px;
    border: none;
    border-radius: 4px;
    background-color: #f6f8fa;
  }
  
  .input-group button {
    padding: 8px 13px;
    border: none;
    border-radius: 4px;
    color: #fff;
    background-color: #2860e1;
  }
```

![bug_position3](https://user-images.githubusercontent.com/60641307/78469031-10bef980-7758-11ea-879b-5758fcf5f598.png)


---
- Tip
    1. image tag 에는 명시적으로 display:block 주는 습관 들일것!
        - 이미지 태그는 display:inline 이지만 파일크기를 지정해줄수있음!
        - inlin이지만 inline 같지않은 녀석, 그러므로 꼭 block처리 해주자
    2. float, position 쓰는 용도 차이
        - float : 나란히 배치하고싶을때
        - position : 지정한 위치에 고정시키고싶을 때 
    3. img태그를 사용할때 자주 써먹는 조합
       1. width: 100%;
       2. height: auto;
    4. transform:translate(X,Y)
       - 위치를 이동시키는 property
       - 현재있는 위치에서 X,Y 위치 이동시킬수있음
       - translateX :X축만이동
       - translateY :Y축만이동
       - **transform: translate(-50%, -50%)** 
          - %를 이용해서 위치시킬경우 정가운데 위치시킬때 자주쓴다.
    5. Text의 위치를 이동시키고싶을때
       - text-align: left|right;
    6. inline-block 사용시 원하지 않는 오차 간격이 생길수있다.
       - inline-block 은 inline 성격을 가지고있다.
       - inline 요소의 가운데 정렬은 text-align:center; 로 설정가능!
    7. position:fixed 를 주게되면 
        - width 값을 선언하지 않으면 가지고 있는 content 사이즈만큼 줄어든다.(padding 포함)