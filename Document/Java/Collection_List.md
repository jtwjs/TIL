# List (배열)
>List는 배열과 비슷한 자바의 자료형으로 배열보다 편리한 기능을 많이 갖고 있다.<br> **List 컬렉션은 객체를 일렬로 늘어놓은 구조**로 이루어져 있다.<br>객체를 인덱스로 관리하기 때문에 List컬렉션에 객체를 추가하면 자동 인덱스가 부여된다.<br>인덱스는 객체를 검색,삭제할 때 사용한다.  List컬렉션은 객체 자체를 저장하는것이아닌 객체의 번지를 참조한다.
- [ArrayList](#ArrayList-클래스)
- [Vector](#Vector-클래스)
- [LinkedList](#LinkedList-클래스)

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

![DLL1](https://user-images.githubusercontent.com/60641307/77399244-5e4c7580-6dec-11ea-8e5d-4a67f6ab6110.png)

- **자바는 "더블리 링크드리스트(Doubly LinkedList)"를 기반**으로 하고있다.
    - 자바 LinkedList는 처음 들어가는 값이 "Header"부분에 들어가도록 되어있다.
>》연결리스트는 각 노드가 데이터와 포인터를 가지고 한 줄로 연결되어 있는 방식의 자료구조이다.

>연결될 다음 원소에 대한 주소를 저장해야하므로 <원소,주소>의 단위로 저장한다.<br>이러한 단위 구조를 노드(node)라 함 < data+link >

> **LinkedList는 List 구현 클래스**이다. 내부 구조는 ArrayList와 다르다. **ArrayList에는 내부 배열에 객체를 저장해서 인덱스로 관리하지만, LinkedList는 인접 참조를 링크해서 체인처럼 관리**한다. 그렇기 때문에 **LinkedList에서 특정 인덱스의 객체를 제거하게되면, 제거되는 인덱스의 앞 뒤 링크만 변경되고 나머지 링크는 변경되지 않는다.**

>**ArrayList는 제거되는 인덱스를 기준으로 뒤에 있는 객체가 한칸씩 이동 했었던 점과 차이**가 있다. 이러한 차이로 인해 객체를 삽입,삭제하는 로직에 있어서 ArrayList보다 LinkedList를 사용할 때 좋은 성능이 나온다.

### 연결 리스트 종류
- **단일 연결 리스트(Singly Linked List)**
>각 노드가 다음 노드에 대해서만 참조하는 가장 단순한 형태의 연결 리스트 (일반적인 큐 구현)<br>Head 노드를 잃어버려 참조하지 못하는 경우 데이터 전체를 사용 못하게 되는 단점이 있다.
- **이중 연결 리스트(Doubly Linked List)**
>각 노드가 이전 노드,다음 노드에 대해서 참조하는 형태의 연결 리스트<br>삭제가 간편하며 단일 연결리스트에 비해 데이터 손상에 강하지만, 관리할 참조가 2개라 삽입,정렬의경우 작업량이 더 많아진다.
- **원형 연결 리스트(Circular Linked List)**
>연결 리스트에서 마지막 요소가 첫번째 요소를 참조한다.<br>스트림 버퍼의 구현에 많이 사용된다.

- **장점** 
    1. 삽입 삭제가 빠르다.
        - 맨앞에 있는요소를 삽입,삭제하는 경우 O(1)
        - 중간요소를 삽입,삭제하는 경우 O(n)의 시간 복잡도를 가진다.
    2. 리스트 내에서 자료의 이동이 필요하지 않다.
    3. 사용 후 기억 장소의 재사용이 가능하다.
    4. 연속적인 기억 장소의 할당이 필요하지 않다.
- **단점** 
    1. 탐색이 느리다.
        - 순차접근방식 단방향성을 갖고 있어 자료 검색에는 부적합하다.(단일 연결리스트)
    2. 포인터의 사용으로 인해 저장 공간의 낭비가 있다.
    3. 알고리즘이 복잡하다.
### LinkedList의 삽입 과정

![삽입link](https://user-images.githubusercontent.com/60641307/76951203-a08a3880-694e-11ea-8311-5a8f7aa79267.png)

### LinkedList의 삭제 과정

![삭제link](https://user-images.githubusercontent.com/60641307/76951245-b3047200-694e-11ea-8a0b-a9910b2fd15e.png)

### LinkedList에 필요한 사항
1. 데이터가 없는 시작 노드를 가진다. 이 노드는 처음 노드가 추가 될 때 다음의 노드를 가리키기만 한다.
2. 각 노드는 재귀적으로 다음의 노드를 가지고 있다.
3. 각 노드는 데이터를 가지고 있다.
4. 추가,삭제 등 기능이 있다.
5. 구현하게될 노드의 구조는 다음의 그림과 같다.


![link 구조](https://user-images.githubusercontent.com/60641307/76951862-a46a8a80-694f-11ea-9425-763cf0638914.png)

```java
class ListNode{
    private String data;//데이터 저장 변수
    public ListNode link;;//다른 노드를 참조할 링크 노드

    public ListNode(){
        this.data = null;
        this.link = null;
    }
    public ListNode(String data){
        this.data = data;
        this.link = null;
    }
    public ListNode(String data,ListNode link){
        this.data = data;
        this.link = link;
    }
    public String getData(){
        return this.data;
    }
}
public class LinkedList{
    private ListNode head; //ListNode 타입의 head 노드 인스턴스 변수

    //LinkedList 생성자
    public LinkedList(){
        head = null;    //head노드 초기화
    }
    //Node 삽입(중간에 삽입)
    public void insertNode(ListNode preNode,String data){
        ListNode newNode = new ListNode(data); //새로운 노드 생성

        //preNode.link는 preNode의 다음 노드이므로,
        //newNode.link = preNode.link는 새로운 노드의 link가 preNode의 다음 노드를 참조하도록 함.
        newNode.link = preNode.link;

        //preNode의 link가 새로운 노드를 참조하도록 함.
        //최종적으로 'preNode -> newNode ->기존 preNode의 다음 노드' 이렇게 구성됨
        preNode.link = newNode;
    }
    //Node 삽입(마지막에 삽입)
    public void insertNode(String data){
        ListNode newNode = new Listnode(data);// 새로운 노드 생성
        if(head == null){
            // head 노드가 null이 아닌 경우 temp 노드가 head를 참조
            //tempNode는 마지막 노드를 찾아서 참조하기 위해 사용.
            ListNode tempNode = head;

            //temp 노드의 link가 null이 아닐 때까지 다음 노드를 참조.
            //tempNode.link는 다음 노드를 참조하고 있으므로,
            //tempNode = tempNode.link는 tempNode에 다음 노드를 참조하도록 하는것.
            //while문이 모두 실행되면 tempNode는 가장 마지막 노드를 참조하게 됨.
            while(tempNode.link != null){
                tempNode = tempNode.link; //다음 노드를 참조
            }
            //tempNode(마지막 노드)의 link가 다음 노드를 참조하도록 함.
            tempNode.link = newNode;
        }
    }

    //Node 삭제 (중간 노드 삭제)
    public void deleteNode(String data){
        //preNode는 head가 가리키는 노드를 할당
        ListNode preNode = head;
        //tempNode는 head가 가리키는 노드의 다음 노드, 즉 preNode의 다음 노드를 할당
        ListNode tempNode = head.link;

        //주어진 데이터가 preNode의 데이터와 일치하는 경우
        //즉,첫번째 노드의 데이터와 일치하는 경우
        if(data.equals(preNode.getData() )){
            //head는 preNode의 다음 노드를 참조하도록 함
            head = preNode.link;
            //preNode의 link는 null을 할당하여 연결을 끊음.
            preNode.link = null;
        }else{
            //tempNode가 null일 때까지 반복하여 탐색
            while(tempNode != null){
                //주어진 데이터와 temp노드의 데이터가 일치하는 경우.
                if(data.equals(tempNode.getData() )){
                    //tempNode가 마지막 노드인 경우
                    if(tempNode.link == null){
                        preNode.link = null;
                    }else{
                        //tempNode가 마지막 노드가 아닌 경우
                        //preNode의 link는 tempNode의 다음 노드를 참조
                        //tempNode의 link는 null을 할당하여 다음 노드로의 연결을 끊음
                        preNode.link = tempNode.link;
                        tempNode.link = null;
                    }
                    break;
                }else{
                    //데이터가 일치하지 않을 경우
                    //preNode에 tempNode를 할당하고,tempNode에 다음 노드 할당
                    preNode = tempNode;
                    tempNode = tempNode.link;
                }
            }
        }
    }

    //Node 삭제(마지막 노드 삭제)
    public void deleteNode){
        ListNode preNode;
        ListNode tempNode;

        //head 노드가 null인 경우 모든 노드가 삭제되었으므로 return
        if(head == null){
            return;
        }

        //head 노드의 link가 null인 경우
        //노드가 1개 남았을 경우
        if(head.link == null){
            //head에 null을 할당하여 남은 노드와의 연결을 끊음.
            head = null;
        }else{
            //preNode는 head가 가리키는 노드를 할당
            preNode = head;
            //tempNode는 head가 가리키는 노드의 다음 노드. 즉, preNode의 다음 노드를 할당
            tempNode = head.link;
            // tempNode의 link가 null이 아닐 때까지 한 노드씩 다음 노드로 이동.
            // preNode는 tempNode를 할당하고
            // tempNode는 tempNode의 다음 노드를 할당.
            // 이렇게 하면 preNode는 마지막 노드의 이전 노드가 되고, tempNode는 마지막 노드가 됨.
            while(tempNode.link != null){
                preNode = tempNode;
                tempNode = tempNode.link;
            }
            //preNode의 link를 null로 만들어서 가장 마지막 노드를 삭제
            //즉,preNode의 다음 노드인 tempNode로의 연결을 끊음.
            preNode.link = null;
        }
    }
    //Node 탐색
    public ListNode searchNode(String data{
        ListNode tempNode = this.head; //temp노드에 head가 가리키는 첫 번째 할당

        //temp노드가 null이 아닐 때까지 반복하여 탐색
        while(tempNode != null){
            //주어진 데이터와 temp노드의 데이터가 일치할 경우 해당 temp노드를 return
            if(data.equals(tempNode.getData() )){
                return tempNode;
            }else{
                //데이터가 일치하지 않을 경우 temp 노드에 다음 노드 할당
                tempNode =tempNode.link;
            }
        }
        return tempNode;
    }
    //리스트의 노드를 역순으로 구성
    public void reverseList(){
        ListNode nextNode = head; //head가 참조하는 첫번째 노드를 할당
        ListNode currentNode = null;
        ListNode preNode = null;

        // nextNode가 순차적으로 이동하며 currentNode의 link가 preNode를 참조하도록 함.
        // 1) preNode를 currentNode 위치로 이동
        // 2) currentNode는 nextNode 위치로 이동
        // 3) nextNode는 다음 노드 위치로 이동
        // 4) currentNode의 link는 preNode를 참조하도록 함
        while(nextNode != null){
            preNode = currentNode;
            currentNode = nextNode;
            nextnode = nextNode.link;
            currentNode.link = preNode; //cureentNode의 link에 preNode를 할당하여 역순으로 설정
        }
        head = currentNode; //currentNode가 마지막 노드를 가리킬 때 ,head는 currentNode를 참조하도록
    }
    //연결 리스트에 저장된 모든 데이터를 출력
    public void printList(){
        ListNode tempNode = this.head; //tempNode에 head가 가리키는 첫번째 노드를 할당
        
        //tempNode가 null이 아닐 때까지 반복하여 출력
        while(tempNode != null){
            System.out.print(tempNode.getData() + " ");
            tempNode = tempNode.link; //temp 노드에 다음 노드(tempNode.link)할당
        }
        System.out.println();
    }
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList(); //연결리스트 생성
        String str = "wed";

        linkedList.insertNode("sun");
        linkedList.insertNode("mon");
        linkedList.insertNode("tue");
        linkedList.insertNode("wed");
        linkedList.insertNode("thu");
        linkedList.insertNode("fri");
        linkedList.insertNode("sat");
        linkedList.printList();

    System.out.println(linkedList.searchNode(str).getData());

    linkedList.deleteNode(linkedList.searchNode(str).getData());
    linkedList.printList();

    str = "sun";

    linkedList.deleteNode(linkedList.searchNode(str).getData());
    linkedList.printList();

    linkedList.reverseList();
    linkedList.printList();
    }
    //출력값
    sun mon tue wed thu fri sat
    wed
    sun mon tue thu fri sat
    mon tue thu fri sat
    sat fri thu tue mon
}

```
