## Background (배경)

### background-color (배경의 색상)
> hex | rgb | rgba
### background-image (배경 이미지)
- **url()** : 사용할 이미지 경로를 기입
### background-repeat (배경이미지 반복)
- **repeat** : 기본값 
- **no-repeat** 
### backgorund-size (배경이미지 크기)
- **contain** : 요소안에 이미지 전체가 들어갈수 있는 정도로 배경이미지 사이즈 조정
- **cover** : 요소에 빈공간을 남기지 않고 꽉 채워지도록 배경이미지 사이즈 조정
- **custom** : 이미지사이즈를 자체적으로 설정(px,%)
### backround-position(배경이미지 위치)
> x 와 y축의 위치를 명시해주어야함  
```CSS
background-position : x축   y축 ;
```
---
## background-1 실습
- TRY 	&#128531;

```CSS
.like-button {
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}

/* ▼ WHERE YOUR CODE BEGINS */
*{box-sizing:border-box;
  margin:0;
}
body{
  background-color:black;
}
.card{
  display:flex;
  width:840px;
  height:248px;
  background-color:white;
 padding:24px;
  justify-content:center;
 
}
.card-image{
  
  position:relative;
  width:300px;
  height:200px;
  background-image:url(./assets/img-house.jpg);
  background-size:111% 100%;
  border-radius:6px;
  background-repeat:no-repeat;
  margin-right:24px;
  
}
.like-button{
  position:absolute;
  left:12px;
  top:12px;
  background-image:url(./assets/icon-favorite.svg);
  width:36px;
  height:36px;
  border-radius:100px;
  background-repeat:no-repeat;
  background-size: cover;
  
}
.property-type{
  color: #7D858F;
}
.plus-badge{
  background-color:#92174D;
  border-radius:4px;
  color:white;
  width:48px;
  height:22px;
}
.card-header{
  display:flex;
  justify-content: space-between;
  height:32px;
  align-items:flex-end;
  margin-bottom:9px;
}
.icon-star{
  background-image:url(./assets/icon-star.svg);
  background-repeat:no-repeat;
  width:13px;
  height:13px;
  background-size:cover;
  position:relative;
  top:17px;
  left:-18px;
}
.card-title{
  font-size:20px;
  color:#151B26;
  line-height:1.6;
  margin-bottom:16px;
}
dd{
  color:#7D858F;
  margin-bottom:8px;
}

```

![백그라운드](https://user-images.githubusercontent.com/60641307/80912361-6696b980-8d77-11ea-9667-496da4ab35ae.png)

- Answer	&#128526;



---
- Tip
    1. 이미지태그보다는 background-image CSS를 사용하자 
    2. 가상요소를 활용하자
    3. overflow:hidden, background-position:center center; 애용하자
    4. dl태그 (definition list) : 용어를 정리할때 사용하는 태그
      - 반드시 그안에 dt(정의하고자 하는 용어), dd(설명) 태그가 있어야함 
      ```HTML
      <dt>Rooms and beds</dt>
      <dd>
          <span>설명1</span>
          <span>설명2</span>
          <span>설명3</span>
          <span>설명4</span>
      </dd>
      ```
    5. sr-only(screen-only)라는 범용 클래스(부트스트랩에서 제공하는 유틸리티클래스)
      - 시맨틱하게 마크업하기 위해..
      ```HTML
      <dt class="sr-only">Rooms and beds</dt>
      ```
      - 화면에 안보이게하는 방법 
      ``` CSS
      .sr-only{
      /*display: none; */ <- 스크린리더도 인식을 못함 
      position: absolute  
      z-index: -100;
      width: 1px;
       height: 1px; 
       overflow:hidden; 
       opacity:0; }
      ```
    6. cursor :pointer;  누르는 타격감 생기게함
      
