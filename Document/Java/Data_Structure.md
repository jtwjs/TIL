# Data Structure (자료 구조)
- 데이터를 효율적으로 사용할 수 있도록 구조를 만들어서 저장해온 것
- 이러한 효율성은 시간 복잡도(time complexity)와 공간 복잡도(space complexity)기준으로 평가된다.

## 시간 복잡도
>해당 자료구조의 시간 효율석의 척도이다.
- 시간 복잡도가 작을 수록 좋은 자료구조 
    - ex:) 책장에 책을 정렬해서 꽂아두면 나중에 원하는책을 빠르게 찾을수 있다.
## 공간 복잡도 
>해당 자료구조의 공간 효율성의 척도이다.
- 공간 복잡도 또한 적을 수록 좋은 자료구조
    - ex:) 물건을 차곡차곡 박스에 쌓아 담으면 같은 공간에 더 많이 담을수 있다.

>자료구조는 공간과 시간에 대한 효율성을 향상시키기 위한 데이터 저장방법!
##### 종류
- 리스트(list) 
    - 배열 리스트(array list)
    - 연결 리스트(linked list)
- 스택(stack)
- 큐(queue)
- 해쉬 테이블(hashtable)
- 집합(set) : 엄밀히 말하면 자료구조 X

### 자료구조 클래스의 Method
|Method|Explain|
|:------|:-------|
|add()|데이터를 추가|
|get(int index)|데이터를 가져온다.|
|size()|데이터의수를 리턴|
|set()|데이터를 바꾼다.|
|remove()|데이터를 삭제한다.|
|indexOf()|처음인덱스부터 데이터의 위치를 찾아 리턴|
|lastIndexOf()|마지막인덱스부터 데이터의 위치를 찾아 리턴|

### Stack & Queue
>Stack과 Queue는 자료구조이다.

![stack queue](https://user-images.githubusercontent.com/60641307/77402275-c18cd680-6df1-11ea-882d-5cd8f01036bf.png)


- Stack : LIFO(Last In First Out)구조 
    - 마지막에 저장한 데이터를 먼저 꺼낸다.
    - 수식계산, undo/redo, 웹 뒤로가기/앞으로가기 기능 구현
- Queue : FIFO(First In First Out)구조
    - 먼저 들어간 데이터를 먼저 꺼낸다.
    - 최근 사용문서,인쇄 작업대기목록, 버퍼 기능 구현

|Structure|Method|Explain|
|:----|:-----|:-------|
|Stack|boolean empty()|stack이 비어있는지 알려줌|
|Stack|Object peek()|Stack의 맨 위에 저장된 객체를 반환<br>pop()과 달리 stack에서 객체를 꺼내지 않음<br>비었을 때는 EmptyStackException 발생|
|Stack|pop()|Stack의 맨 위에 저장된 객체를 꺼냄<br>비었을 때는 EmptyStackException 발생|
|Stack|Object push(Object item)|Stack에 객체(item)을 저장|
|Stack|int search(Object o)|stack에서 주어진 객체(o)를 찾아서 그 위치를 반환<br>못 찾으면 -1을 반환(배열과 달리 위치가 1부터 시작)|
|Queue|offer()|데이터를 넣는다.|
|Queue|poll()|데이터를 **앞에서 꺼낸다.**|