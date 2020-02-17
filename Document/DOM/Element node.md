# Element Node

## 1.Element 생성
- createElement('tag name') : 메서드에 전달되는 값은 생성할 Element의 형식(**태그이름**)을 지정하는 문자열이다 
> createElement에 전달되는 값은 element가 생성되기 전에 소문자 문자열로 변경된다.

## 2.Element 태그 이름 얻기
- tagName : element의 이름에 접근, nodeName이 반환하는 것과 동일한 값을 반환
> 원본 HTML 문서에서의 대소문자 여부에 관계없이 값을 대문자로 반환

## 3.Element의 Attribute 및 값에 대한 리스트/컬렉션 얻기
- attributes : 현재 element에 정의된 Attr 노드의 컬렉션을 얻는다. 반환된 리스트는 NamedNodeMap이다.
> NamedNodeMap은 getNamedItem(),setNamedItem(),removeNamedItem() 배열을 조작하기 위한 메서드 제공 

## 4.Element의 Attribute 값 획득 설정 제거
- getAttribute() : ex: node.getAttribute('속성') , 속성 값 획득
- setAttribute() : ex: node.setAttribute('속성','값') , 속성 값 설정
- removeAttribute() :  ex: node.removeAttribute('속성') , 속성 값 제거 
>일부 element attribute는 element 노드에서 개체 속성으로 존재(ex: document.body.id , document.body.className)

## 5.Element가 특정 attribute를 가지고 있는지 확인
- hasAttribute() : element가 attribute를 포함하고 있으면(값을 가지지 않더라도) true를 반환

## 6.특정 Element 노드 선택
- querySelector() : 문서 내에서 발견되는 첫번째 노드 element를 반환
- getElementById() : 주어진 문자열과 일치하는 id 속성을 가진요소 element 반환

## 7.Element 노드 리스트 선택 및 생성
- querySelectorAll() : querySelector()와 동일하게 작동하되 해당하는 모든 요소를 노드리스트로 반환
- getElementsByTagName() : 주어진 문자열과 일치하는 element를 가진 모든 자식 element 노드들을 노드리스트로 반환 
- getElementsByClassName() : 주어진 문자열과 일치하는 클래스를 가진 모든 자식 element 노드들을 노드리스트로 반환 
> 특정 element 하나를 선택하는 것이 아닌 선택한 element들의 리스트(NodeList)를 생성한다.

## 8.직계 자식 Element 노드 모두 선택
- children : 직계 element 노드만을 제공, element가 아닌 노드(ex: text노드)는 제외된다.

## 9.사전에 구성된 Element 노드 선택/리스트
- document.all : HTML 문서 내의 모든 element
- document.forms : HTML 문서 내의 모든 form태그 element
- document.images : HTML 문서 내의 모든 img태그 element
- document.links : HTML 문서 내의 모든 a 태그 element
- document.scripts : HTML 문서 내의 모든 script 태그 element
- document.styleSheets : HTML 문서 내의 모든 link 또는 style 태그 element 