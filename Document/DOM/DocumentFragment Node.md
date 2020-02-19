# DocumnetFragment 노드
- 라이브 DOM트리 외부에 경량화된 문서 DOM 생성 
- 라이브 DOM트리처럼 동작하되, 메모리상에서만 존재하는 빈 문서 템플릿이다.
- 자식노드를 메모리상에서 손쉽게 조작후 라이브DOM에 추가하는것도 가능

## 1.생성 
- createDocumentFragment() 
>DocumentFragment를 사용하여 메모리상에서 노드 구조를 만들고 이를<Br>라이브 노드 구조에 삽입하면 매우 효울적이다.

## 2.DocumentFragment를 사용하는것의 이점
- DocumentFragment는 어떤 종류의 노드(body,html은 제외)도 가질수 있다.
    - element는 그렇지않다.
- DOM에 추가하더라도 DocumentFragment 자체는 추가되지 않고 노드의 내용만 추가
    - element를 추가할 경우에는 element 자체도 추가동작에 속함
- DOM에 추가할 때, DocumentFragment는 추가되는 위치로 이전되며<br>생성한 메모리상의 위치에 더이상 존재하지 않는다.
    - element는 노드를 포함하기 위해 일시적으로 사용된 후 라이브 DOM으로 이동

## 3.DocumentFragment를 라이브 DOM에 추가하기
>1.노드 메서드의 인수로 DocumentFragment를 전달하면 DocumentFragment의 <br>자식 노드는 메서드가 호출되는 DOM 노드의 자식노드로 옮겨진다.
>2.노드를 삽입하는 메서드에 DocumentFragment를 인수로 전달하면,<br> 자식 노드 구조 전체가 삽입되며 DocumentFragment노드 자체는 무시된다.
- appendChild() 
- insertBefore() 

## 4.DocumentFragment에서 innerHTML 사용하기
1. DocumentFragment 생성
2. div생성후 DocumentFragment에추가 (appendChild 이용)
3. innerHTML을 사용해 문자열로부터 DOM구조 생성

## 5.복제를 사용하여 Fragment의 노드를 메모리상에서 유지하기
- cloneNode()를 사용하여 추가할 DocumentFragment를 복제하면 된다.