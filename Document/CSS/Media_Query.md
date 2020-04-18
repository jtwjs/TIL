## Media Query
>Responsive Web(반응형 웹)을 만들기 위해 반드시 알아야하는 CSS 선언
### Responsive Webb(반응형 웹)
> 브라우저를 접속했을 때 사용한 디바이스의 사이즈에 따라서 그에 딱 맞게 화면을 보여주기위해서 CSS스타일이 적용을 해놓은 웹사이트
- 반응형 웹 기술이 필요한 이유
    - 반응형 웹이 등장하면서 웹사이트를 이용한 사람들에게 모든 기기에서 최적화된 웹사이트를 제공할수있게됨
    - pc ,mobile 버전 웹사이트 두가지 모두를 만들지 않아도 됨에 따라 비용,시간,인력 절감
    - 모바일웹 접속률이 많이 늘어난 지금 모바일 버전또한 신경써주어야한다.!!
- 반응형 웹의 장점
    1. 간편한 유지보수
        - 모바일,태블릿,데스크톱 등 모든 디자인을 하나의 HTML 파일과 CSS파일에서 <br>작업하기 때문에 유지 보수가 훨씬 쉽고 간편!
    2. 유리한 마케팅
        - 마케팅 활동중 최적의 활동은 당연 '웹'!!
        - 언제,어디서,어떻게든 접근이 용이해야 하는 중요한 웹 마케팅에서 가장 효과적인 방법
    3. 최적화된 검색엔진
        - 검색시 노출을 최대화시키는것 
            - 검색사이트에서 사용자가 특정 키워드로 검색했을 때 나오는 <br>웹사이트 검색 결과에서 상위권이 나타나도록 하는 관리 작업
        - 모바일,데스크톱 버전 두개 사이트를 가지고 있는 경우 (반응형 웹이 아닌 경우)
            - 검색엔진에서는 어떠한 주소의 정보가 정확한 정보이지 확인하기 힘들어<br>검색 결과에서 제외하거나,검색결과 상위권에 배치하는것이 상대적으로 불리해진다.
        - 반응형 홈페이지는 하나의 주소로 검색 결과에 좀더 노출이 잘될수 있고, 광고효과도 톡톡히볼수있다.
    4. 미래지향적 기술
        - 반응형 웹은 구조를 환경에 따라 최적화되도록 바뀌어서 보인다. 
        - 앞으로 어떤 크기의 기기가 나올지 모르는 상황에서 반응형 웹은 웹 기술중 가장 미래지향적
---
### 반응형 웹을 만들기위해 반드시 충족되어야할 조건
1. HTML : viewport meta 태그

    ```H
    <!DOCTYPE html>
    <html>
        <head>
            <meta name="viewport" content="width=device-width" />
            ...
        </head>
    </html>

    ```
2. CSS : midea query 문 선언
    
    ```CSS
    /* @media : midea query 선언
       screen : screen에 관해
       min-width : 최소 가로사이즈가 768px 
                  768px 이상에서는 아래 화면을 적용*/
    @media screen  and (min-width:768px) {
         /*where all the magic happnes...*/
    }
    ```
    1. @media screen and 선언
    2. 내가 적용시키고자 하는 가로 길이의 조건을 명시해줌
    3. 새로운 CSS공간에 변화해야할 값들을 쓴다.

---
## MediaQuery-1 실습
- TRY 	&#128531;

```CSS
    * {
    box-sizing: border-box;
    margin: 0;
  }
  
  body {
    font-family: "Noto Sans KR", sans-serif;
    letter-spacing: -0.01em;
  }
  
  a {
    text-decoration: none;
  }
  
  .landing {
    background-image: url("./assets/img-bg.jpg");
    background-size: cover;
    background-position: center center;
    background-repeat: no-repeat;
  }
  
  .landing-title {
    line-height: 1.25;
    letter-spacing: -0.03em;
    color: #fff;
  }
  
  .landing-title strong {
    display: block;
    font-family: "Poppins", sans-serif;
    letter-spacing: -0.01em;
  }
  
  .landing-link {
    line-height: 1;
    color: #fff;
  }
  
  .banner-title a {
    color: #1f2d3d;
  }
  
  /* ▼ WHERE YOUR CODE BEGINS */

  .banner{
      background-color: #FFC82C;
      text-align:center;
      height:64px;
      padding:20px 102px;
      position:absolute;
      bottom:0;
      width:100%;
  }
  .baaner-title{
    min-width:171px;
    height:24px;
  }
  .banner-title a{
        display:block;
      
      font-size:17px;
      line-height:24px;
  }
  .landing-link{
      border-radius:16px;
      border:2px solid #FFF;
      background:rgba(0,0,0,0.5);
      width:160px;
      height:52px;
      padding:14px 37px;
      font-size:14px;
  }
  .landing{
    height:100vh;
    text-align:right;
    padding: 196px 20px;
  }
  .landing-title{
    margin-bottom:38px;
  }

  @media screen and (min-width:1440px){
      .banner{ top:0;}
      .landing{
          text-align:center;
          padding:242px 536px;
      }
      .landing-link{
          width:180px;
      }
      .landing-title{
          font-size:49px;
        
      }
  }
```

#### DeskTop

![mediaqueryMine](https://user-images.githubusercontent.com/60641307/79300250-2800a280-7f21-11ea-9518-d375687f4442.png)


#### Mobile

![mediaqueryMobileMine](https://user-images.githubusercontent.com/60641307/79300331-57171400-7f21-11ea-811b-12d018a46138.png)

- Answer	&#128526;

```CSS
* {
    box-sizing: border-box;
    margin: 0;
  }
  
  body {
    font-family: "Noto Sans KR", sans-serif;
    letter-spacing: -0.01em;
  }
  
  a {
    text-decoration: none;
  }
  
  .landing {
    background-image: url("./assets/img-bg.jpg");
    background-size: cover;
    background-position: center center;
    background-repeat: no-repeat;
  }
  
  .landing-title {
    line-height: 1.25;
    letter-spacing: -0.03em;
    color: #fff;
  }
  
  .landing-title strong {
    display: block;
    font-family: "Poppins", sans-serif;
    letter-spacing: -0.01em;
  }
  
  .landing-link {
    line-height: 1;
    color: #fff;
  }
  
  .banner-title a {
    color: #1f2d3d;
  }
  
  /* ▼ WHERE YOUR CODE BEGINS */

  .banner{
    background:#FFC82C;
    position:fixed;
    bottom:0;
    width:100%;
  }
  .banner-title a{
    height:64px;
    font-size:18px;
    width:100%;
    display:flex;
    justify-content: center;
    align-items:center;
  }
  .landing{
    width:100%;
    height:100vh;
    padding:0 20px;
    display:flex;
    flex-direction:column;
    justify-content: center;
    align-items:flex-end;
  }
  .landing-title{
    text-align:right;
    font-size:32px;
    margin-bottom:24px;
  }
  .landing-link{
    width:160px;
    height:52px;
    border-radius:16px;
    border:2px solid #FFF;
    background:rgba(0,0,0,0.5);
    display:flex;
    justify-content: center;
    align-items: center;
    font-size:15px;
  }
  
  @media screen and (min-width:768px){
    .banner{
      top:0;
      bottom:auto;
    }
    .banner-title a{
      height:80px;
    }
    .landing{
      align-items:center;
    }
    .landing-title{
      text-align:center;
      font-size:50px;
      margin-bottom:32px;
    }
    .landing-link{
      font-size:18px;
      width:180px;
      height:56px;
    }
  }

```
#### DeskTop
![mediaqueryMine2desk](https://user-images.githubusercontent.com/60641307/79304508-7e271300-7f2c-11ea-998c-4d39b0b5eac8.png)



#### Mobile
![mediaqueryMine2](https://user-images.githubusercontent.com/60641307/79304456-5a63cd00-7f2c-11ea-9e79-aa8c42c9ddd7.png)




---
- Tip
    1. 반응형 웹은 모바일 부터 만들자!
        - 확장공사가 편하다 ㅎㅎ
    2. 아이폰5/SE 기준으로 작업을 시작하자
        - 320px이 제일 작다. 이곳에서 스타일이 제데로되면 왠만하면 안깨진다.
    3. 정렬할때는 무조건 display:flex를 써보자!
      - text도 자식태그인것을 명심!
    4. fixed로 viewport 위치를 고정시킨 경우 변화를줄떄 auto로 효력없애자
    5. 보통 DeskTop min-width: 768px !!
    6. html head태그안에 meta태그 외우기 
    
      ```CSS 
      <meta name="viewport" content="width=device-width" />
      ```