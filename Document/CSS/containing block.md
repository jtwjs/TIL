# 컨테이닝 블록(containing block)
>요소의 크기와 위치는 **containing block**의 영향을 받는다.  

>브라우저는 문서를 그릴때 모든 요소에 대한 박스를 생성합니다.<br>각각의 상자는 아래의 네가지 영역으로 나눠진다..
1. Content area
2. padding area
3. border area
4. margin area

![box-model](https://user-images.githubusercontent.com/60641307/74604505-08f0ba80-5102-11ea-908c-f5de44dd1756.png)

## 컨테이닝 블록의 효과
요소의 크기와 위치는 컨테이닝 블록의 영향을 자주 받는다.<br>
백분율 값을 사용한 width,height,padding,margin 속성의 값과 <br>
절대적 위치(absolute,fixed)로 설정된 요소의 오프셋 속성값은 자신의 컨테이닝 블로으로부터 계산이된다.

## 컨테이닝 블록 식별
> 컨테이닝 블록의 식별 과정은 position 속성에 따라 완전히 달라짐 (기본속성 static)

1. position 속성이 [static,relaitve,sticky]중 하나이면, 컨테이닝 블록은 가장 가까운 <br>조상 블록컨테이너, 또는 가장 가까우면서 서식맥락을 형성하는 조상요소,<br> 아니면 블록컨테이너 자기자신의 콘텐츠 영역 경계를 따라 형성
2. position[ **relative**]인경우 자신의 static 위치를 기반으로해서 위치를 잡음
3. position[ **absolute**]인경우 자기의 containing block을 기반으로 위치를 잡음
4. position[ **fixed**]인 경우 컨테이닝 블록은 뷰포트나 페이지영역이다.
5. position[ **absolute,fixed**]인 경우 다음 조건중<br> 하나를 만족하는 조상의 내부 영역이 컨테이닝 블록이 된다.
    1. <span style="color:#2E9AFE">transform</span>이나 <span style="color:#B40404">perspective</span> 속성이 **none**이 아님
    2. <span style="color:#2E9AFE">will-change</span> 속성이 **transform**이나 **perspectiv**임
    3.  <span style="color:#2E9AFE">filter</span> 속성이 **none**임.
    4. <span style="color:#B40404">contain</span>속성이 **paint**임.

    >html태그가 초기 컨테이닝 블록이다.

## 컨테이닝 블록으로부터 백분율 계산
><span style="color:#2E9AFE">박스 모델 속성 : width,height,padding,margin</span> <br><span style="color:#B40404"> 오프셋 속성 : top,bottom,left,right</span>

1. <span style="color:#2E9AFE">height</span>, <span style="color:#B40404">top</span>,<span style="color:#B40404">bottom</span> 속성은 컨테이닝 블록의 <br> **height**을 사용해 백분율 계산
2. <span style="color:#2E9AFE">width</span>, <span style="color:#B40404">left</span>,<span style="color:#B40404">top</span>,<span style="color:#2E9AFE">padding</span>,<span style="color:#2E9AFE">margin</span>속성은 컨테이닝 블록의 width를 사용해 백분율 계산
