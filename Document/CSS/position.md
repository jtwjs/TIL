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
## Float-1 실습
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
- Tip
    1. image tag 에는 명시적으로 display:block 주는 습관 들일것!
        - 이미지 태그는 display:inline 이지만 파일크기를 지정해줄수있음!
        - inlin이지만 inline 같지않은 녀석, 그러므로 꼭 block처리 해주자
    2. float, position 쓰는 용도 차이
        - float : 나란히 배치하고싶을때
        - position : 지정한 위치에 고정시키고싶을 때 