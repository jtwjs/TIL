# Transition & Animation
> 요소의 속성값이 변화하면 보통 즉각 그 효과가 나타나는데, 트랜지션과 애니메이션을 사용하면 변화가 일정 시간(duration)에 걸쳐 나타나게 할 수 있다. 
- 트랜지션 : 어떤 요소에 속성을 넣어놨는데 변화할때 스르륵 전환하면서 변화하게 하는것
- 애니메이션 : 애니메이션을 주고 싶을때 사용할수 있어 자유도가 높음

## Transition
>요소의 속성값의 변화가 스르륵 일어날수 있게 도와준다~ 
- 요소의 변화를 일정 기간(duration)동안 일어나게 함
- 자동으로 발동되지 않음 (hover나 onclick 같은 이벤트 트리거에 의해 동작)

```CSS
trainsition : property(CSS속성)  duration(지속시간)  [timing-function](변화속도)  [delay](지연시간) ;
```

### 주의점
- **layout에 영향을 주는 요소**의 크기나 위치가 변화하면 영향을 받는 모든 요소들의 <br>크기나 위치를 재계산 하게 되는데 영향을 받는 요소들이 많을수록 부하가 큼
    - layout에 영향을 주는 속성들
    ```
    width height padding margin border
    display position float overflow
    top left right bottom
    font-size font-family font-weight
    text-align vertical-align line-height
    clear white-space
    ```
- 가급적이면 가능한 낮은 계층의 요소에 트랜지션 효과를 주기 위한 노력을 해야함
### property (CSS 속성)
> 어떤 속성이 변화할건지 명시해주어야함
- all (모든 속성)
### duration (지속시간)
- transition의 변화가 얼마동안 일어나는지..
- 1,000ms === 1s
### timing-function (변화의 속도)
- ease-in
    - Slow to Fast
- ease-out
    - Fast to Slow
- ease-in-out
    - 짬뽕
- cubic-bezier()
    - 변화의 속도를 커스텀
### delay (변화의 지연)
> 몇초 후에 트랜지션을 일으킬 것인지 지정하는 속성
- ex:) ``` transition-delay : 1s;  ``` 
---
## Animation
> 각각의 property를 쪼개서 사용하자! 
- transition 보다 할 수 있는것이 많음
- trainsition은 시작하기 위해 이벤트가 필요하지만<br> animation은 시작,정지,반복까지 제어할수 있음
- 하나 또는 복수의 @keyframes으로 이루어짐
### name (@keyframes) 
- @keyframes 키워드는 애니메이션을 정의하는 키워드라고 할수있음
    ```CSS
    @keyframes name {
        from{

        }

        to{

        }
    }
    ```
- 동작 제어
    - from/to
    - a%/b%/c%
### animation-name(애니메이션 적용)
- 적용할 애니메이션 이름을 지정

### animation-duration(애닌메이션 지속시간)
- 애니메이션의 지속시간 (ms/s)

### animation-timing-function(애니메이션 변화속도)
- 트랜지션과 동일

### animation-delay(애니메이션 지연시간)
- 애니메이션 지연시간(ms/s)

### animation-iteration-count(반복횟수)
- 횟수 지정(정수)
- infinite(무한반복)
### animation-direction(애니메이션 진행방향)
- alternate( ↔ 번갈아 가면서 동작)
- alternate-reverse

### Transition-1
```CSS
/* ▼ WHERE YOUR CODE BEGINS */
*{
    box-sizing:border-box;
    margin:0;
}
body{
    font-family: 'Lato', sans-serif;
    background-color:#E5E5E5;
}
input,button,textarea{
    font-family: 'Lato', sans-serif;
}
.line-button{
    position:relative;
    width:110px;
    height:56px;
    padding:18px 30px;
    line-height:1.25;
    color:#151B26;
    background-color:#FFFFFF;
    border:none;   
}
.line-button::after{
    content:"";
    position:absolute;
    left:0;
    bottom:0;
    width:0;
    height:2px;
    background-color:#0066ff;
    transition:width 250ms ease-in;
}
.line-button:hover::after{
    width:100%;
}

```

### Animation-1
```CSS
/* ▼ WHERE YOUR CODE BEGINS */
*{
    box-sizing:border-box;
    margin:0;
}
body{
    font-family: 'Muli', sans-serif;
    background:#E5E5E5;
}
.loading{
    width:500px;
    height:216px;
    background:#fff;
}
.loading-title{
    position:absolute;
    left:210px;
    top:80px;
    width:80px;
    height:24px;
    font-size:18px;
    line-height:1.333333333333333‬;
    color: #151B26;
    border-radius:100px;
    animation-name:ani-title;
    animation-duration:2s;
    animation-timing-function:ease;
    animation-iteration-count:infinite;
    animation-direction:alternate-reverse;
}
.progress-bar{
    position:absolute;
    left:100px;
    top:124px;
    width:300px;
    height:12px;
    background: #E5EAEF;
    border-radius:100px;
}
.progress-bar-gauge{
    position:absolute;
    left:0;
    top:0;
    width:0;
    height:12px;
    background:#13CE66;
    animation-name:ani-bar;
    animation-duration:5s;
    animation-timing-function: ease-in;
    animation-iteration-count: infinite;
}
@keyframes ani-title{
    from{
        opacity:1;    
    }

    to{
        opacity:0;
    }
}

@keyframes ani-bar{
 from{
     width:0;
 }   
 to{
     width:100%;
 }
}
```
---
- Tip
    1. MDN을 활용하자
        - CSS의 정보를 검색할때 사용하자
    2. button, inpput, textarea 같은 from 요소들은 body에 폰트를 적용해도 적용 X 
        - 따로 선언해주자
        ```CSS
        button,input,textarea{
            font-family:;
        }
        ```
    3. 버튼의 구리구리한 기본옵션들을 해제!
        ```CSS
        boder:none;
        background:white;
        ```
    4. 작은 button 들의 interaction은 **250ms**를 자주쓴다.
    