## Flexbox
#### How to use it
- **나,플렉스박스 쓸거임(단호)**
    
    ```CSS
        display: flex;
        /* flex | inline-flex*/
    ```
    - 정렬하고자 하는 요소를 감싸는 **부모에게 display:flex** 지정
- **가로정렬? 세로정렬?**
    
    ```CSS
    flex-direction: row;
    /* row(가로) | row-reverse | column(세로) | column-reverse */
    ```
    - **Axis** : flex를 사용하면 보이지않는 두개의 축이 생김
        - flex-direction이 어떤값으로 설정되있는지에 따라 축의 방향이 달라짐
        - Main axis: flex-direction의 값의 방향 (↓,→)
        - Cross axis: Main aixs 와 수직을 이루는 방향 (↓,→)
- **무조건 한줄 안에 다정렬?**
    >어떻게든 한줄안에 모든 요소를 정렬할것인지, 여러줄을만들어서 정렬할것인지 정하는것
    ```CSS
    flex-wrap: nowrap;
    /* nowrap | wrap */
    ```
    - **nowrap**: 감싸지 않고 자식의 사이즈를 줄여서라도 한줄로 정렬해버린다.
    - **wrap**: 한 줄에 모두 정렬하기에 공간이 넉넉하지 않으면 여러 줄을 만들어 버림
- **씬나는 플렉스박스 파티 타임!**

    ```CSS
     /* Main axis의 방향을 기준으로 정렬할때 사용*/
    justify-content: center;

    /* Cross axis의 방향을 기준으로 정렬할때 사용*/
    align-items: 
    /* felx-wrap: wrap 일 때  */
    align-content: 

    /* flex-start(시작부분) | center | flex-end(끝부분) */
    /* space-between(요소들 사이의 간격을 같게 해줌) |
    /* space-around(요소 양옆간격이 같아진다)
        ```

- **order** : 요소의 순서를 지정해준다.
#### flex-grow
>주축에서 남는 공간을 항목들에게 분배하는 방법 결정
- 값을 양수로 지정하면 flex 항목 별로 주축 방향 크기가 felx-basis 값 이상으로 늘어날수 있다.

#### flex-shrink
>주축의 공간이 부족할 때 각 항목의 사이즈를 줄이는 방법을 정의
- ```flex-shrink : 0 ``` -> 값이 줄어들지 않음 




---
## flex-3 실습
- TRY 	&#128531;

```CSS

  
* {
    box-sizing: border-box;
    margin: 0;
  }
  
  body {
    font-family: "Muli", sans-serif;
    color: #273444;
    background-color:#273444;
  }
  
  .profile-name {
    font-size: 18px;
    font-weight: 600;
    line-height: 1.3333333333;
  }
  
  .profile-location {
    font-size: 14px;
    line-height: 1.4285714286;
    color: #8492a6;
  }
  
  .profile-detail dt {
    font-size: 12px;
    font-weight: 600;
    line-height: 1.6666666667;
    color: #8492a6;
  }
  
  .profile-detail dd {
    font-size: 32px;
    font-weight: 300;
    line-height: 1.25;
    color: #0066ff;
  }
  
  /* ▼ WHERE YOUR CODE BEGINS */
  .profile{
      background-color:white;
      border-radius:16px;
      display:flex;
      flex-direction:column;
      justify-content:center;
      align-items:center;
      width:386px;
      height:304px;
  }
  .profile img{
      width:80px;
      border-radius:80px;
      display:block;
      margin-bottom:16px;
  }
  .profile h1{
      width:118px;
      margin-bottom:4px;
  }
  .profile p{
      margin-bottom:32px;
  }
  .profile-detail{
      display:flex;
      justify-content:space-around;
      width:306px;
      height:64px;
      margin-bottom:32px;
  }
```
![flex3](https://user-images.githubusercontent.com/60641307/79044018-c4832600-7c3d-11ea-859b-fb7fd8c59d29.png)


- Answer	&#128526;

```CSS
* {
  box-sizing: border-box;
  margin: 0;
}

body {
  font-family: "Muli", sans-serif;
  color: #273444;
}

.profile-name {
  font-size: 18px;
  font-weight: 600;
  line-height: 1.3333333333;
}

.profile-location {
  font-size: 14px;
  line-height: 1.4285714286;
  color: #8492a6;
}

.profile-detail dt {
  font-size: 12px;
  font-weight: 600;
  line-height: 1.6666666667;
  color: #8492a6;
}

.profile-detail dd {
  font-size: 32px;
  font-weight: 300;
  line-height: 1.25;
  color: #0066ff;
}

/* ▼ WHERE YOUR CODE BEGINS */

body {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100vh;
  background-color: #000;
}

.profile {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 386px;
  padding: 32px 40px;
  border-radius: 16px;
  text-align: center;
  background-color: #fff;
}

.profile-image {
  display: block;
  width: 80px;
  height: 80px;
  border-radius: 50%;
  margin-bottom: 16px;
}

.profile-name {
  margin-bottom: 4px;
}

.profile-location {
  margin-bottom: 32px;
}

.profile-detail {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  justify-content: space-between;
  align-items: center;
  width: 100%;
}

.profile-detail dt {
  margin-bottom: 4px;
}
```

![flex3-1](https://user-images.githubusercontent.com/60641307/79045028-f0a1a580-7c43-11ea-867d-041339313dff.png)


---
- TIP 
    1. 선 align-itmes 후 align-content
    2. 글자 정렬은 text-align: left|center|right
    3. body width :100%; height: 100vh; (뷰포트 100%)