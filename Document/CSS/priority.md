# CSS 우선순위
## 1.규칙
- 기본적으로 뒤에 나오는 css가 우선순위가 높습니다.
- 우선순위가 같다면 개수가 많은 css가 우선순위가 높습니다.
- 갯수마저 같다면 뒤에 나오는 것이 순위가 높습니다.

|css|priority|
|-------|----|
|!important|0|
|inline style<br>attribute|1|
|id|2|
|class|3|
|other attribute|3|
|pesudo-class|3|
|tag element|4|
|pesudo-element|4|

>**!important**와 **inline style attribute**는 실무에서 사용을 제한하는 경우가 많다.
><br> **!important**는 css 값뒤에 붙여진 키워드를 의미(치트키) **강제우선순위**
><br> **inline style attribute**은 태그에 주어진 style 속성
