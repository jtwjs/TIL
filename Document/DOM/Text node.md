# TEXT NODE

> HTML 문서에서 텍스트는 text 노드를 만들어내는 text() 생성자 함수의 인스턴스로 표현된다.<br> HTML 문서가 해석될 때, HTML 페이지의 element 사이의 섞여있는 텍스트는 text 노드로 변환된다.<br>**※DOM에서 공백이나 줄바꿈도 text노드로 표현됨**
```HTML
<p>hi</p>
<script>
var textHi = document.querySelector('p').firstchild
console.log(textHi.constructor); //Text()가 출력됨
console.log(textHi);
//Text {textContent="hi", length=2, wholeText="hi", ...}가 출력됨
</script>
```
>※Text가 CharacterData, Node, Object로부터 상속받는다는 점을 명심

## 1.Text 개체 및 속성
- textContent : 모든 자식 텍스트 노드를 취합해서 반환/ [설정]모든 자식 텍스트 노드 제거후 단일 텍스트 노드로 바꿈   
    document나 doctype 노드에서 사용될 경우 null값 반환, script 및 style element의 경우 내용이 반환
- splitText() : 텍스트 노드 분할
- appendData() : 추가
- deleteData() : 삭제, 매개변수에 삭제할Text지점과 길이 값 넣음 ex) deleteData(7,5)->7지점에서 5길이만큼 삭제
- insertData() : 삽입, 매개변수에 삽입할Text지점과 '삽입할 text를 넣음' ex)insertData(7,'blue') ->7지점에서 blue 삽입
- replaceData() : 수정, 매개변수에 바꿀text시작지점과 길이 text를 넣음 ex)replaceData(7,5,'Bunny ') ->7지점5길이의'bunny'로수정
- subStringData() : 추출, ex)substringData(7,10) -> 7지점에서 10의길이 문자열 반환
- normalize() : 형제 텍스트 노드들을 결합 
    형제 Text 노드들은 통상적으로 텍스트를 DOM에 프로그래밍적으로 추가한 경우에만 나타남
    Element 노드를 포함하고 있지 않은 형제 Text 노드들을 제거하기 위해 사용
- data : text 노드값 가져옴 
- document.createTextNode() : Text노드 생성

## 2.Text 노드 값 가져오기
- data 
- nodeValue
>Text 노드에 포함된 문자의 길이를 가져오려면 length 속성에 접근하면됨  ex) data.length

## 3.TextContent와 innerText 간의 차이
>FIrefox를 제외한 대부분의 최근 브라우저들은 textContent와 유사해 보이는 innerText라는 속성을 지원

1. innerText에는 CSS가 반영됨
2. innerText는 reflow가 발생
3. innerText는 script와 style element내에 포함된 text 노드를 무시한다.
4. textContent와 달리 innerText는 텍스트를 정규화해서 반환한다. 
    textContent는 문서 내에 있는것을 마크업만 제거후 그대로 반환 ex) 공백,줄 바꿈, 개행문자 모두 포함
5. innerText는 비표준이고 브라우저에 국한된 것으로 간주, textContent는 DOM 사양으로 간주