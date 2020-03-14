# DOM내의 노드 탐색
>DOM을 탐색함으로써 다른 노드에 대한 참조를 얻을 수 있다. 
## 1.DOM내의 노드탐색(text노드 & comment노드 포함) 
>element노드 뿐만아니라 text노드 comment 노드도 포함 

- parentNode : 부모노드 참조
- firstChild : 첫번째 자식노드 참조
- lastCHild : 마지막 자식노드 참조
- nextSibling : 다음 형제노드 참조 ※지정된 노드가 마지막이면 null값 반환 
- previousSibling : 이전 형제노드 참조 ※지정된 노드가 첫번째면 null값 반환

## 2.DOM내의 노드탐색(texts노드 & comment노드 무시)
- firstElementChild : 첫번째 자식노드 참조
- lastElementChild :  마지막 자식노드 참조
- nextElementSibling : 다음의 형제노드 참조
- previousElementSibling : 이전의 형제노드 참조
- children : [실시간] 노드의 자식 DOM 요소들의 정렬된 컬렉션인 HTMLCollection
- parentElement : 부모 Element 노드 참조 
- childElementCount : 노드가 가지고 있는 자식 element의 개수를 반환 

## 3. DOM 트리 내의 Node 위치 확인
- contains() : 특정 노드가 다른 노드 내에 포함되어있는지를 확인
- compareDocumentPosition() :  각노드의 관계 비교 <br> ex: node.compareDocumentPosition(otherNode)

|반환되는 숫자코드|숫자 코드 정보|
|----------|----------|
|0|동일한 Element|
|1|동일한 문서에 존재하지않음|
|2|node가 otherNode 보다 앞에있음|
|4|node가 otherNode 보다 뒤에있음|
|8|node가 otherNode의 조상임|
|16,10|node가 otherNode의 자손임|

>contains()는 선택된 노드와 전달된 노드가 동일한경우 ture를 반환
<br>compareDocumentPosition()은 노드의관계가 하나 이상관계를 가지면 값+해서 반환

## 4.두 노드가 동일한지 판단.
- isEqualNode() :  완전히 동일한지(자식노드 포함) 판단 
- === 연산자 : 두 노드가 완전히 동일한지 아니라,두 노드 참조가 동일한 노드를 참조 하고 있는지를 알고싶을때 사용