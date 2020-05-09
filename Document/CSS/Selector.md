## Selectors
- **CSS 선택자 우선순위**
    - 금메달 > 은메달 > 동메달 (메달 점수 합산방식)
    - 금메달(ex:1000p)
        - ID(신분증)
    - 은메달(ex:100p)
        - class, Pesudo-class(클래스 선택자)
    - 동메달(ex:1p)
        - Type(요소선택자)
    - Rule Braker (우선순위 파괴하는 악당들)
        - Inline Style
        - !important;
            - Inline style도 이겨버림
            - ex:) ```p{
                color:#ff4949; !important;
            }```
- 여러개의 지칭셀렉터가 공백없이 붙어있으면 하나로 인식
    - ex:) div#id.red.blue{} : div태그이면서 ID가id이면서 red클래스이면서 blue클래스인 녀석 지칭
### TypeSelector
> HTML 태그를 지칭
- ```태그_명{}```
### ClassSelector
> html의 class attribute 값을 지칭
- ``` .클래스_명{} ```
- 단 한번에 스타일 선언으로 여러개의 요소를 동시에 스타일 가능
- 한 요소에 여러개의 클래스값을 가질수 있음
### IDSelector
> = 신분증
- ``` #ID_명{} ```
- 단 한개만 존재가능

### Pseudo-classes(가상 클래스 선택자)

### Structural Pseudo-classes
##### 일반 구조 선택자
- **:first-child**
    - 첫번째 위치하는 자손을 선택
- **:last-child**
    - 마지막에 위치하는 자손을 선택
- **:nth-child(수열)**
    - 앞에서 수열 번째에 있는 자손을 선택
    - ex:) nth-child(2n), nth-child(2n+1)
- **:nth-last-child(수열)**
    - 뒤에서 수열 번째에 있는 자손을 선택
##### 형태 구조 선택자
- **:first-of-type**
    - 자손 중에 첫번째로 등장하는 특정 태그
- **:last-of-type**
    - 자손 중에 마지막으로 등장하는 특정 태그
- **:nth-of-type(수열)**
    - 자손 중에 앞에서 수열 번째로 등장하는 특정 태그 선택
- **:nth-last-of-type(수열)**
    - 자손 중에 뒤에서 수열 번쨰로 등장하는 특정 태그 선택
#### User Action Pseudo-classes
>어떤 상태나 조건에 부합햇을때 특별한 스타일을 주기 위해 사용
><br>anchor button form 유저의 인터렉션이 가장많은 요소들에 많이 쓰인다.
- element:**hover**
    - 요소에 마우스를 갖다댔을때 
- element:**active**
    - 요소를 눌럿을 때 
- element:**focus**
    - 요소에 포커스가 되었을 때
- a:**link**
    - 클릭하기 전 상태 
- a:**visited**
    - 클릭했거나 방문했던 페이지에 있는 앵커 태그 스타일

### 자손 선택자와 자식 선택자
>자식태그: 특정 태그에 종속되면서 바로 한 단계 아래에 해당하는 요소들을 의미<br>
- **자손 선택자(descendant selector)**
    - 문서 구조에서 특정 요소의 자손을 선택
    - 자손은 자식, 손자, 그리고 그 이후에 후손을 모두 포함
    - **A B{}**
        - A와 B 사이를 **공백(space)으로 분리**하여 표시
- **자식 선택자(child selector)**
    - 특정 요소의 직계 자식만 선택 (자식 이후 손자,후손들 포함하지 않음)
    - **A > B{}**
        - A와 B 사이에 **>(꺽쇠)로 분리**하여 표시
### 등위 선택자 (Sibling Combinators)
> 동등한 위치에 있는 태그를 선택하여 CSS속성 지정
- **A ~ B{}**
    - **다음에 따라오는 모든 형제요소**만 해당 
    - A에 해당하는 태그와 동등한 위치에 있는 B 선택
- **A + B{}**
    - **다음에 따라오는 하나의 형제요소**만 해당
    - A에 해당하는 태그와 동등한 위치에 있는 인접한 태그(하나선택)


