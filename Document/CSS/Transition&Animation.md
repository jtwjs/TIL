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
### name (@keyframes) 
