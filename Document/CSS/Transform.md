## Transform(변형)
>모양을 변형시키는 property (함수사용)
- 진정한 CSS 장인들의 세계;
### 가장 많이 쓰이는 함수
- **translate(x,y)**
    - 어떤 요소를 원하는 방향으로 위치시킬때 사용
    - 요소의 위치를 이동해도 원래 위치를 기억
        - 다른 요소들에게 영향을 끼치지 않음
    - translateX(), translateY()
        - X축, Y축 따로 지정 가능
    - 값으로 % 사용시 자기자신의 Size를 기준으로 이동
    - ```transform:translate(-50% -50%)```
        - **position : absolue;  가운데 배치할때 사용**
- **scale(N)**
    - N의값의 **배율**로 사이즈 조정
    - 본래 요소의 위치를 기억
    - scale(x,y)
        - x축 y축 배율 따로 지정
- **rotate(Ndeg)**
    - 어떤 요소의 각도를 돌려줄때 사용
    - 본래 요소의 위치를 기억
    - **deg**를 반드시 써주어야함