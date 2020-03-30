## Float
---
Block 요소들을 가로배치 하기위해 쓰인다.
- **What happens**
1. 집 나간 내 새끼, 찾을 길 없네.
    - 공간을 차지하지 않는다.
2. Block으로 신분상승
    - Block 박스로 변환
3. Block인데 길막을 하지못한다.
    1. 별도의 width값을 주지않으면 부모 width값을 얻는다. -> X
        - 실제 content 길이만큼 너비를 가진다.
    2. width값을 준 경우, 남은 공간을 margin으로 자동으로 채운다. -> X
        - 자동으로 생기는 margin:auto가 생기지 않는다
        - 빈공간이 생긴다는 뜻. (옆으로 나란히 배치 가능)
4. Float, 나만 볼 수 있어요(feat.인라인)
    - Block 박스들은 float된 요소를 없는 박스로 취급 (감지를 못함)
    - inline 박스들은 감지함(e.g: image,text)
- LayOut이 박살난다.

- **How to fix it**

