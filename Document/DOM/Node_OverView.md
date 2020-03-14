# 노드 개요

## 1.노드 개체 유형
 - DOCUMENT_NODE (ex: window.document)
 - ELEMENT_NODE (ex: HTML 태그)
 - ATTRIBUTE_NODE (ex: class="fun" 태그의 속성)
 - TEXT_NODE (ex : 줄바꿈과 공백을 포함한 HTML 문서 내의 텍스트 문자)
 - DOCUMENT_FRAGMENT_NODE (ex: 마크업에 표현되지 않는 유일한 노드타입,<br>
 노드를 생성해서 사용하면 라이브 DOM트리 외부에 경랑화된 문서 DOM을 만들수 있다.)
 - DOCUMENT_TYPE_NODE (ex:!DOCTYPE html )

 ## 2.노드 개체로부터 상속받은 하위 노드 개체
 - Object < Node < Element < HTMLElement < (ex: HTML*Element)
 - Object < Node < Attr (DOM4에서 사용 금지됨)
 - Object < Node < CharacterData < Text
 - Object < Node < Document < HTMLDocument
 - Object < Node < DocumentFragement
 >통상적인 DOM트리의 각 노드 개체는 Node로부터 속성과 메서드를 상속받는다.<br>
 >javascript의 노드 타입은 모두 Node를 상속하므로 모든 노드타입에서 같은 기본프로퍼티와 메서드를 공유한다. 

 ## 3. 노드에 대한 정보
노드에 대한 정보는 다음과 같은 프로퍼티를 통해 접근 가능<br>
1.nodeName<br>
2.nodeValue<br>
3.nodeType<br>
이 프로퍼티들은 다른 인터페이스를 이용하지않고도, 해당 노드의 정보에 직접 접근할수있는 방법을 제공한다.<br>

 ### nodeName : 노드 고유의 이름을 저장하므로, 수정할수 없는 읽기 전용 프로퍼티<br>

|Node|Property value|
|------|-------|
|<center>DOCUMENT_NODE </center>|<center>#document</center>|
|<center>ELEMENT_NODE</center>|<center>태그 이름(대문자)</center>|
|<center>ATTRIBUTE_NODE</center>|<center>속성 이름</center>|
|<center>TEXT_NODE</center>|<center>#text</center>|


 ### nodeValue : 노드의 값을 저장합니다.<br>
 
 |<center>Node</center>|<center>Property value</center>|
 |----------|----------|
 |<center>ELEMENT_NODE</center>|<center>undefined</center>|
 |<center>ATTRIBUTE_NODE</center>|<center>해당 속성의 속성값</center>|
 |<center>TEXT_NODE</center>|<center>해당 텍스트 문자열</center>|

 ### nodeType : 노드의 타입을 나타내는 정수 <br>
 
|<center>Node</center> |<center>Property Value</center>|
|----------|----------|
|<center>ELEMENT_NDOE</center>|<center>1</center>|
|<center>ATTRIBUTE_NODE</center>|<center>2</center>|
|<center>TEXT_NODE</center>|<center>3</center>|
|<center>CDATA_SECTION_NODE</center>|<center>4</center>|
|<center>ENTITY_REFERENCE_NOD</center>|<center>5</center>|
|<center>ENTITY_NODE</center>|<center>6</center>|
|<center>PROCESSING_INSTRUCTION_NODE</center>|<center>7</center>|
|<center>COMMENT_NODE</center>|<center>8</center>|
|<center>DOCUMENT_NODE</center>|<center>9</center>|
|<center>DOCUMENT_TYPE_NODE</center>|<center>10</center>|
|<center>DOCUMENT_FRAGMENT_NODE</center>|<center>11</center>|
|<center>NOTATION_NODE</center>|<center>12</center>|




