# 노드 컬렉션(NodeList와 HTMLCollection)에 대한 이해
- 컬렉션은 라이브 상태 혹은 정적(static)일수 있다. <br>이는 컬렉션 내에 포함된 노드들이 현재 문서 혹은 현재 문서에 대한 스냅샷의 일부라는 것을 의미
- 기본적으로 노드는 트리 순서에 따라 컬렉션 내에서 정렬된다.
- 컬렉션은 리스트 내의 요소 개수를 나타내는 length 속성을 가진다.
## 1.직계 자식 노드 전부에 대한 리스트/컬렉션 얻기
- childNodes : 직계 자식 노드에 대한 배열 형태의 리스트(ex:NodeList)가 나온다. 
>childNodes에서 반환되는 NodeList는 직계 자식 노드만을 가진다.
<br> Element 노드뿐만 아니라 다른 노드 유형(ex:Text및 Comment 노드)도 포함된다.

## 2.NodeList나 HTMLCollection을 JavaSCript 배열로 변환
>NodeList나 HTMLCollection은 배열 형태이지만, array의 메서드를 상속하는 진정한 JavaSCript 배열은 아니다.
<br>JavaScript 배열로 변환시 얻는 이점 
<br>1. DOM에 국한되지 않은 리스트 스냅샷을 만들수 있음
<br>2. Array 개체가 제공하는 메서드들(ex: forEach,pop,map,reduce 등)에 접근할수 있음

- isArray() : 메서드 인자가 Array인지 판별 
- Array.prototype.slice.call() : 매게변수의 유사배열리스트틀 JavaScript 배열로 변환 

