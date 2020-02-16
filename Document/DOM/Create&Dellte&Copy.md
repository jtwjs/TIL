# JavaScript DOM트리 활용

## 1. JavaScript 활용하여 노드 생성하기
### JavaScript 메서드를 사용해서 직접 노드를 생성 (프로그래밍적으로 생성)
- createElement()
- createTextNode()
```javascript
<script>
var elementNode = document.createElement('div');
var textNode = document.createTextNode('Hi');
</script>
```
>createElement() 메서드는 생설될 element를 지정하는 문자열을 매개변수로 받는다.
<br>이 문자열은 Element 개체의 tagName 속성에서 반환되는 문자열과 동일하다.

### JavaScript 문자열을 사용하여 DOM에 노드를 생성 및 추가
- innerHTML : innerHTML에서 지정한 요소 태그를 제외한 안쪽 태그만 값을 가져옴 <i>보안에 취약</i>
- outerHTML : outerHTML에서 지정한 요소 태그 값도 포함하여 값을 가져옴
- textContext : 단순히 텍스트 콘텐츠에만 접근가능
- insertAdjacentHTML() : 보다 세밀하게 시작&종료 태그의 앞,뒤 노드삽입 가능 
 >ex: node.insertAdjacentHTML('위치','추가할 노드');
 >위치 : beforebegin,afterbegin,beforend,afterend

### JavaScript 노드 개체를 DOM트리에 삽입
- appendChild() : 하나의 노드를 메서드가 호출된 노드의 **자식 노드 끝에 삽입**
- insertBefore() : 2개의 매개변수 필요(삽입될노드,참조노드) **참조노드로 위치조정**

## 2.노드를 제거하거나 바꾸기
>DOM에서 노드를 제거하는것은 여러 단계의 과정으로 이루어진다.
<br>1.삭제하고자 하는 노드를 선택. 
<br>2.부모 노드에 대한 접근을 얻어야함(parentNode 속성 사용)
<br>3.부모 노드에서 삭제할 노드에 대한 참조를 전달하여 removeChild() 메서드를 호출
- removeChild() : 노드 삭제, 매개변수(삭제할 노드)
- replaceChild() : 노드 변경, 매개변수(A,B); B를 A로 바꿈 

## 3.노드 복제하기
- cloneNode() : 단일 노드 복제  <i>※문서 내에서 요소ID가 중복될수도 있다.</i>
- cloneNode(true) : 노드와 그 자식 노드를 모두 복제 
