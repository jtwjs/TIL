## Typography (타이포그래피)
>[활자 서체의 배열] Text를 예쁘게 디자인 ㅎㅎ

### font-size
>글씨의 크기


```CSS
font-size: px | em | rem;
```
- **절대 단위**
    - **px (PiXel)** 
- **상대 단위**
    - **em (Equal to capital M)**
        - 실제로 적용된 폰트 사이즈 
    - **rem (Root EM)**
        - root = html 
        - html에 적용된 폰트 사이즈 = 1rem

### line-height
>줄 간격
- 사용하는 font-size : px | **em** | rem
- font-size : **em** 을 많이 사용
- **em 생략하는것이 관례**

    ```CSS
    font-size:20px;
    line-height:1.5; /* 30px */
    ```
### letter-spacing
>글자의 간격(자간)
- 사용하는 font-size : px | **em** 
- em 생략 불가능

    ```CSS
    letter-spacing:-0.05em;
    ```
### font-family
>글자의 서체


```CSS
/*Poppins 폰트를 적용해라*/
font-family: "Poppins";

/*PoPins 폰트를 적용해라 그것이 없으면 아무런 sans-serif 서체중 아무거나 적용*/
font-family: "Poppins", sans-serif;

/* Poppins 폰트 적용 그것이 없으면 Roboto폰트 적용 그것이 없으면 sane-serife 서체 적용*/
font-family: "Poppins", "Roboto", sans-serif;
```
- **serif** 
    - = 명조체 (삐침이 있는 체)
- **sans-serif** 
    - = 돋음,고딕 (삐침이 없고 굵기가 일정)
### font-weight
>폰트의 굵기


|폰트의 굵기|굵기 정도|
|:----:|:------|
|100|Thin|
|300|Light|
|**400**|**Regular**|
|500|Medium|
|**700**|**Bold**|
|900|Black|

### color
> 폰트의 색상
- **color를 작성할떄 사용하는 방식**
    - hex 
        - 16진수 HEXA 코드 값 
        - #RR(red)GG(green)BB(blue)로 두자리 씩 정수로 구성
        - 16진수 값인 00 ~ FF 사이에 값을 지정
        - ex:) #FF0000; // 빨간색
    - rgb
        - RGB생상 값은 대부분의 브라우저에서 지원
        - 함수 형태로 되어있으며 인수로 red,green,blue 값을 넘김
        - 10진수로 0 ~ 255 사이 값을 지정
        - 인수를 숫자 뿐만아니라 %값도 넘길수 있음
        - ex:) rgb(100%,0,0); // 빨간색
    - rgba
        - RGB에 alpha 채널을 하나 더 추가한 것
        - 알파 값은 색의 투명도,즉 배경색과 혼합되는 정도를 의미
        - 0(완전투명) ~ 1(불투명) 사이의 값을 가짐
        - rgba(0,102,255,1)

 ---

- Tip
    1. line-height를 사용했을 때에는 글자는 그  줄간격에 가장 가운데에 배치된다.
        - 수직으로 무언가 정렬할 때 line-height를 자주사용한다.

