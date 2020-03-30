## Box
---
## Box Model

![boxmodel](https://user-images.githubusercontent.com/60641307/77846453-1f099480-71f1-11ea-802c-2b3f7ce81706.png)


## Content
- 텍스트와 이미지 등의 컨테츠 내용이 표시되는 영역
- 가로는 width, 세로는 height
- backgorund 속성 지정시 content영역과 padding 영역에 배경이 표시된다.
## Padding
- 안쪽 여백, 즉 content와 border 사이의 공간을 나타내는 **padding**

## Border
- padding과 margin의 경계에 있는 테두리 선
- Box의 외각이 되는 부분, 테두리를 나타내는 **border**
- ex:) border: 1px solid #000 (border: 굵기 스타일 색상)
    - 위 3개의 스타일을 모두 지정해줘야한다. 순서는 상관없다.
- 배경이 표시되는 영역이지만, 보더가 지정되어 있는경우 우선 표시된다.
- border: none 
    - border을 없앤다
- border-radius: 4px
    - border의 테두리를 타원으로 만든다.
    - 50%로 지정할시 원으로 만듬
-

## Margin
- 바깥 여백, 즉 요소와 요소 사이의 간격을 나타내는 **margin**
- 여기에 배경은 표시되지 않는다.

### 속기형 Shorthand
- top right bottom left (순서 시계방향)
    - ex:) padding: 10px 20px 30px 40px;
        - 각각 지정
- top : bottom , right : left 는 세트로 묶여있다.
    - ex:) padding: 10px 20px;
        - 명시되는 부분이 없으면 같은 세트인 값과 동일


## Box Sizing
- content-box
    - box-sizing: content-box;
    - box-sizing defualt value
    - content-box만의 size 
- border-box
    - box-sizing: border-box;
    - border까지의 width, height로 본다. 
    - 우리의 상식에 맞게 동작하는 박스

```CSS
//대다수의 프론트엔드 개발자들의 CSS 작성방법
*{// 모든요소 선택
    box-sizing: border-box;
}
```

## Box Type
- Display
    - Block -> 길막?
        - 따로 width를 선언하지 않은 경우, **width = 부모의 content-box의 100%**
        - 따로 width를 선언한 경우, **남은 공간은 margin으로 자동으로 채움**
        - margin:0 auto;
            - top:bottom -> 0; 
            - right:left -> auto, 자동으로 생기는 margin을 왼쪽 오른쪽에 배치
            - 가운데 배치 
        - width,height,padding,border,marign 모두 적용 가능
        - 따로 부모의 height를 선언하지 않을 경우, **자식 요소의 height의 합 = 부모의 height**
    - inline -> 흐름
        - **width**,**height**,padding-**top**,padding-**bottom**,border-**top**,border-**bottom**,margin-**top**,margin-**bottom** **사용불가!!**
            - 인라인의 줄간격 흐름을 박살내는 녀석들..
    - inline-block -> block + inline
    
|BLOCK|INLINE|
|:----|:-----|
|면(영역)|선(흐름)|

