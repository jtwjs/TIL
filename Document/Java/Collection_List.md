# List (배열)
>List는 배열과 비슷한 자바의 자료형으로 배열보다 편리한 기능을 많이 갖고 있다.<br> **List 컬렉션은 객체를 일렬로 늘어놓은 구조**로 이루어져 있다.<br>객체를 인덱스로 관리하기 때문에 List컬렉션에 객체를 추가하면 자동 인덱스가 부여된다.<br>인덱스는 객체를 검색,삭제할 때 사용한다.  List컬렉션은 객체 자체를 저장하는것이아닌 객체의 번지를 참조한다.

- ArrayList
- Vector
- LinkedList

### List 주요 메소드

|Function|Method|
|:----:|:----|
|추가|add()|
|검색|contain()<br>get()<br>size()|
|삭제|remove()<br>clear()|

```java
//String 객체를 관리하는 ArrayList 생성
List<String> list = new ArrayList(); 

//String 객체 저장
list.add("Hello World");
//null 저장
list.add(null);
//동일한 String 객체를 갖고 있는지 검색
boolean isFindValue = list.contains("Hello World");
//인덱스 값을 이용하여 객체 삭제
list.remove(0);
//List에 저장된 모든 객체를 얻어서 콘솔 창에 출력
for(String value : list){
    System.out.println(value);
}
```


## ArrayList 클래스
>**ArrayList는 List컬렉션 인터페이스를 구현한 클래스이다. <br> 일반 배열과 ArrayList는 인덱스로 객체를 관리한다는 점에서 동일하지만<br> 크기를 동적으로 늘릴수 있다는 점에서 차이점**이 있다.

>ArrayList는 내부에서 처음 설정한 저장 용량이 있다.<br> 설정한 저장 용량 크기를 넘어서 더많은 객체가 들어오게 되면, 자동적으로 저장 용량이 늘어난다.

```java
//기본 저장 용량은 10
List<String> list = new ArrayList<>();

//저장 용량을 100을오 설정해서 String 객체를 관리하는 ArrayList 생성
List<String> list = new ArrayList<>(100);

/*java 4 이전에서 ArrayList 생성방법
타입 파라미터를 지정하지 않았으므로 IDE에서 경고를 표시*/
List list = new ArrayList();
/*이렇게 선언하게되면 어느 객체든 저장할수있는 ArrayList가 되어버림 
객체가 저장될 때 Object타입으로 변환되어 저장되기 때문
다만 ArrayList 내부에 있는 객체(Object)를 꺼내서 사용할 때 실제 타입으로 변환해야한다.*/
```

> ArrayList가에서 특정 인덱스의 객체를 제거하게 되면, 제거한 객체의 인덱스부터 마지막 인덱스까지 모두 앞으로 1칸씩 앞으로 이동한다. 객체를 추가하게 되면 1칸씩 뒤로 이동, 인덱스 값을 유지하기 위해서 전체 객체가 위치가 이동한다.

>**객체 삭제와 삽입이 빈번하게 일어나는곳에서 ArrayList를 사용하지 않는 것이 좋다**. 이러한 경우에는 LinkedList를 사용하는것이 알맞음. **ArrayList는 인덱스가 있으므로 객체 검색, 맨 마지막에 객체 추가 등에서 좋은 성능을 발휘**

```java
//ArrayList 객체 생성
List<String> list = new ArrayList<>();

//객체 추가
list.add("Hello");
list.add("gglee");
//객체 총 개수
int size = list.size();
//동일한 객체 있는지 검색
boolean isFindValue =list.contains("gglee");
//인덱스에 위치하는 객체 값 얻기
String str = list.get(0);
//인덱스를 이용하여 객체 삭제
list.remove(0);
```

#### 고정된 객체들로 구성된 List를 생성하기
>Arrays 클래스의 정적메소드 asList(), 이 정적메소드를 이용하여 생성된 ArrayList는 앞에서 설명한 ArrayList와는 다른 클래스이다. 이 ArrayList는 추가(add),삭제(remove) 기능을 제공하지 않는다.

```java
//String 객체를 관리하는 정적ArrayList 생성
List<String> list = Array.asList("hello","gglee","java");

list.add("why");// UnsupportedOperationException 에러발생
list.remove(1);//// UnsupportedOperationException 에러발생
```

## Vector 클래스
>**Vector는 ArrayList와 동일한 내부구조**를 가지고 있다. Vector 객체를 생성하기 위해서는 저장할 타입을 지정해야 한다. **ArrayList와 차이점으로 Vector 클래스는 동기화된(synchronized) 메소드로 구성**되어 있다. 그렇기 때문에 **멀티 스레드 환경에서 안전하게 객체를 추가,삭제**할수 있다. 즉, 스레드에 안전한다(Thread Safe)라고 말한다.<br> 다만 동기화되어 있기 때문에 ArrayList보다는 객체를 추가,삭제하는 과정은 느리다. <br>안전성을 추구하는데 있어서 속도를 포기한 트레이드 오프(trade off)이다.


## LinkedList 클래스
> **LinkedList는 List 구현 클래스**이다. 내부 구조는 ArrayList와 다르다. **ArrayList에는 내부 배열에 객체를 저장해서 인덱스로 관리하지만, LinkedList는 인접 참조를 링크해서 체인처럼 관리**한다. 그렇기 때문에 **LinkedList에서 특정 인덱스의 객체를 제거하게되면, 제거되는 인덱스의 앞 뒤 링크만 변경되고 나머지 링크는 변겨되지 않는다.**

>**ArrayList는 제거되는 인덱스를 기준으로 뒤에 있는 객체가 한칸씩 이동 했었던 점과 차이**가 있다. 이러한 차이로 인해 객체를 삽입,삭제하는 로직에 있어서 ArrayList보다 LinkedList를 사용할 때 좋은 성능이 나온다.
