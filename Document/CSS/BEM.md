## CSS 방법론 (BEM)
> (BEM; Block, Element, Modifier)
- Block, Element, Modifer 를 --와 __로 구분해서 작명한다.
- ex:) ``` .header__navigation--navi-text {
    color: red;
        }
        ```
    - header : Block
    - navigation : Element
    - navi-text : Modifier

    
### Block / Element / Modifier 작명규칙(Naming Conevetion)
- 개발, 디버깅,유지 보수를 위하여 CSS 선택자의 이름을 가능한 한 명확하게 만드는 것이 목표
- 소문자,숫자 만을 이용해서 작명
- 여러단어의 조합은 하이픈(-)으로 연결하여 작명한다.

### Blcok(블록)
![BEM_BLOCK](https://user-images.githubusercontent.com/60641307/81374811-1767d480-913b-11ea-8dfc-1970129f18e3.png)

- 재사용 할 수 있는 기능적으로 독립적인 페이지 구성 요소, HTML에서 블록은 class 속성으로 표시된다.
- 형태(red, big)가 아닌 목적(menu, button)에 맞게 결정해야한다.
- 블록은 환경에 영향을 받지 않아야 한다. 즉, 여백이나 위치를 설정하면 안된다.
- 태그, id 선택자를 사용하면 안된다.
- 블록은 서로 중첩해서 작성 할 수 있다.
- ex:) header, menu, search-form ...

### Element(요소)
![BEM_ELEMENT](https://user-images.githubusercontent.com/60641307/81374975-6b72b900-913b-11ea-90c9-429f74450f62.png)

- 블럭안에서 특정 기능을 담당하는 부분
- block__element 형태로 사용 (언더바*2)
- 형태(red,big)가 아닌 목적(item,text title)에 맞게 결정해야 한다.
- 요소는 중첩해서 작성 가능
- 요소는 블록의 부분으로만 사용가능 다른요소의 부분으로 사용X
- 모든 블록에서 요소는 필수가 아닌 **선택적으로 사용** 
- ex:) menu__item, header__title...


### Modifier(수식어)
![BEM_MODIFIER](https://user-images.githubusercontent.com/60641307/81375034-8cd3a500-913b-11ea-999d-4b4d7ceef186.png)

- 블록이나 요소의 모양(color.size..), 상태(disabled,chekced..)를 정의한다.
- block__element--modifier, block--modifier 형태로 사용(하이픈*2)
- 수식어의 Boolean 타입과 key-value 타입이 있다.
    - boolean type : 수식어가 있으면 값이 true라고 가정한다.(form__button--disabled)
    - key-value type : 키, 벨류를 하이픈으로 연결하여 표시(color-red, theme-ocean)
- 수식어는 단독으로 사용할 수 없다.
    - 기본 블록과 요소에 추가하여 사용해야 한다.
    - ```(class="block__element block__element--modifier")```
- 블럭이나 엘리먼트의 속성 
- 기존과 비슷하지만 동작이나 생긴게 조금 다른 블럭이나 엘리먼트를 마들 때 사용

