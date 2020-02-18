# Margin Collapsing(마진 상쇄)
>어떤 두개 이상 블록 요소의 상하 마진이 겹칠 때 어느 한 쪽의 값(더 큰값) 만 적용하는 현상
- 마진 상쇄는 인접한 두 박스가 온전한 block-level 요소일 경우만 적용
- 마진 값이 0이더라도 상쇄 규칙은 적용
- 좌우 마진은 겹치더라도 상쇄돼지 않는다.

## 1 margin collaption이 일어나는 3가지 경우
1. 인접 형제 박스 간 상하 마진이 겹칠 때
2. 빈 요소의 상하 마진이 겹칠 때
3. 부모 박스와 첫 번째(마지막) 자식 박스의 상단(하단) 마진이 겹칠 때
### 1-1.인접 형제 박스 간 상하 마진이 겹칠 때
>겹쳐진 두 마진 값을 비교해, 더큰 마진 값으로 상쇄해 렌더링 한다.
![01-margin-collapsing-sibling-case](https://user-images.githubusercontent.com/60641307/74709756-49b41500-5263-11ea-86bd-64be0e2736ea.png)


### 1-2.빈 요소의 상하 마진이 겹칠 때
- height / min-height /padding /border 등 상하로 늘어나는 <Br>property value 를 명시적으로 주지않앗을 때
- 내부에 Inline 콘테츠가 존재하지 않는 요소
>특히 빈요소와 인접 박스들 간에 마진 겹침이 일어나는 구조는 <br>상쇄가 여러번 발생함
![02-margin-collapsing-emptybox-case](https://user-images.githubusercontent.com/60641307/74709838-7c5e0d80-5263-11ea-948f-b61f047a7814.png)

### 1-3.부모 박스와 첫 번째(마지막) 자식 박스의 상단(하단) 마진이 겹칠 때
> 마진이란 콘텐츠 간의 간격이고, 간격을 벌리기 위해서는 경계를 필요로 합니다. 브라우저는 부모박스와 첫 번쨰(마지막) 자식 박스 간의 경계를 그 사이에 있는 border / padding / inline 콘텐츠 유무로 판단합니다.앞에 설명했던 빈 박스의 마진 상쇄 현상과는 조금 다르게, 이미 명시적으로 height / min-height 값을 줬더라도 이번 경우에선 신경 쓰지 않습니다.

>따라서 부모와 첫 번째(마지막) 자식 사이에 inline 콘텐츠(텍스트 등)가 없거나, 상단(하단)에 명시적으로 padding 또는 border 값을 주지 않았다면 마진이 겹치게 됩니다. <br>**이때, 자식 요소의 마진이 더 크든 작든 상관없이 상쇄된 마진은 부모 박스의 바깥으로만 렌더링이 됩니다.**

1. 부모 박스와 첫 번째 자식 박스의 상단 마진이 나란이 겹칠 때

![03-margin-collapsing-firstchild-case1](https://user-images.githubusercontent.com/60641307/74710402-e925d780-5264-11ea-9b01-86b52d75f3d4.png)

![04-margin-collapsing-firstchild-case2](https://user-images.githubusercontent.com/60641307/74710435-00fd5b80-5265-11ea-80d7-a09483b6eea0.png)

![05-margin-collapsing-firstchild-case3](https://user-images.githubusercontent.com/60641307/74710463-11add180-5265-11ea-8f79-b5488d7e8526.png)

2. 부모 박스와 마지막 자식 박스의 하단 마진이 나란이 겹칠 때

![06-margin-collapsing-lastchild-case](https://user-images.githubusercontent.com/60641307/74710537-3b66f880-5265-11ea-8fc4-988d5a016229.png)

**그래서**
> 다음과 같이 부모 박스 상단(하단)에 apdding 또는 border값을 주어 벽을 만들어주는 것이 안전합니다.

![07-margin-collapsing-recomm-case](https://user-images.githubusercontent.com/60641307/74710607-64878900-5265-11ea-91a0-acabbe221f8a.png)

## 2.해결방안
### 다음과 같은 상황에서는 인접요소 간 마진 상쇄가 일어나지않습니다. 
#### **부모가 block format context**인경우
- 박스가 position : absolute 된 상태
- 박스가 float : left/right 된 상태(단 clear되지않은 상태)
- 박스가 display : flex일 때 내부 flex item
- 박스가 display: grid일 때 내부 gird item
