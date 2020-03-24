# Collections Framework(컬렉션 프레임웍)
>다수의 데이터를 쉽고 효과적으로 처리할 수 있는 표준화된 방법을 제공하는 클래스의 집합을 의미 즉,데이터를 저장하는 자료구조와 데이터를 처리하는 알고리즘을 구조화하여 클래스로 구현해 놓은 것이다.

>이러한 컬렉션 프레임워크는 자바의 인터페이스를 사용하여 구현된다.



## 주요 인터페이스
1. List
    - 순서 있는 데이터 집합
    - 데이터 중복 허용
    - ex:) 대기자 명단
2. Set
    - 순서 없는 데이터 집합
    - 데이터 중복 불허
    - ex:) 양의 정수집합,소수의 집합
3. Map
    - 키와 값의 쌍으로 이루어진 데이터 집합
    - 순서 없고,키 중복 불허,값 중복 허용
    - 어떤 두 값을 연결한다는 의미에서 Map이라 지음
    - ex:) 우편번호,지역번호

## 주요 인터페이스 간의 상속 관계

![Collection](https://user-images.githubusercontent.com/60641307/75860938-f8e61400-5e3f-11ea-87e9-12f3a0c2b3af.png)

>위의 그림에서 <E>나 <K,V>라는 것은 컬렉션 프레임워크를 구성하는 모든 클래스가 제네릭으로 표현되어 있음을 나타냄

## 주요 인터페이스의 간략한 특징
|**인터페이스**|**설명**|**구현 클래스**|
|:------:|:------:|:------:|
|**List< E >**|순서가 있는 데이터의 집합으로,데이터의 중복을 허용함|Vector,ArrayList,LinkedList,Queue|
|**Set< E >**|순서가 없는 데이터의 집합으로,데이터의 중복을 허용하지 않음|HashSet,TreeSet|
|**Map<K,V>**|키와 값의 한 쌍으로 이루어지는 데이터의 집합으로,순서가 없음<br>이때 키는 중복을 허용하지 않지만,값은 중복될 수 있음|HashMap,TreeMap,Hashtable,Properties|

## Collection class(컬렉션 클래스)
>컬렉션 프레임워크에 속하는 인터페이스를 구현한 클래스를 컬렉션 클래스라고 한다. 

>컬렉션 프레임워크의 모든 컬렉션 클래스는 List와 Set,Map 인터페이스 중 하나의 인터페이스를 구현하고 있다. 또한,클래스 이름에도 구현한 인터페이스의 이름이 포함되므로 바로 구분할 수 있다.

>Vector나 Hashtable과 같은 컬렉션 클래스는 예전부터 사용해 왔으므로, 기존 코드와의 호환을 위해 아직도 남아 있다. 하지만 기존에 사용하던 컬렉션 클래스를 사용하는 것보다는 새로 추가된 ArrayList나 HashMap 클래스를 사용하는 것이 성능 면에서도 더 나은 결과를 얻을 수 있다.

```java

public class Collection{
    public static void main(String[] args){
        //리스트 생성
        ArrayList<String> arrList = new ArrayList<String>();

        //리스트에 요소의 저장
        arrList.add("하나");
        arrList.add("둘");
        arrList.add("셋");
        
        //리스트 요소의 출력
        for(int i=0; i< arrList.size();i++){
            System.out.println(arrList.get(i));
        }
    }
}
```

## Collection 인터페이스
>List와 Set 인터페이스의 많은 공통된 부분을 Collection 인터페이스에서 정의하고, 두 인터페이스는 그것을 상속받는다. 따라서 Collection 인터페이스는 컬렉션을 다루는데 가장 기본적인 동작들을 정의하고, 그것을 메소드로 제공하고 있다.

|**메소드**|**설명**|
|:------|:------|
|boolean **add(E e)**|해당 collection에 전달된 요소를 **추가**함.(선택적 기능)|
|void **clear()**|해당 collection의 **모든 요소를 제거**함.(선택적 기능)|
|boolean **contains(Object o)**|해당 collection이 전달된 객체를 **포함하고 있는지를 확인함**.|
|boolean **equals(Object o)**|해당 collection과 전달된 객체가 **같은지를 확인**함.|
|boolean **isEmpty()**|해당 collection이 **비어있는지를 확인**함.|
|Iterator< E >**iterator()**|해당 collection의 반복자(iterator)를 반환함.|
|boolean **remove(Object o)**|해당 collection에서 **전달된 객체를 제거**함.(선택적 기능)|
|int **size()**|해당 collection의 요소의 **총 개수**를 반환함.|
|Object[] **toArray()**|해당 collection의 모든 요소를 Object타입의 배열로 반환함.|

### Iterator 
>컬렉션 프레임웍에서 컬렉션에 저장되어있는 요소들을 읽어오는 방법을 표준화한 것

- booelan hasNext() : 일어 올 요소가 남아있는지 확인하는 메소드
- Object next() : 다음에 읽어 올 데이터를 반환하는 메소드
- void remove() : next()로 읽어 온 요소를 삭제 (선택적 기능)

```java
public class Ex{
    public static void main(String[] args){
        List<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);

        Iterator hi = A.iterator();// 가상의 A와 똑같은 공간을만듦 
        while(hi.hasNext()){//가상공간에 값이 남아있는지 확인
            System.out.println(hi.next());//들어있는 값을 리턴후 가상공간에서 사라짐
        }
    }
}

```


### Collections 클래스 
>여러가지 데이터와 관련된 작업들을 처리할수있게 도와주는 class<br>속해있는 메소드들은 모두 static (인스턴스로 만들필요없음)

- Collections.sort() : 특정 타입의 객체는 기본형 데이터와 달리 정렬 기준이 없으면 정렬을 할 수 가 없으며, 따라서 정렬 기준을 정의해야함

### Comparator 와 Comparable 인터페이스
> 객체를 정렬하는데 필요한 메서드를 정의한 인터페이스

- Comparable : 기본 정렬기준을 구현
    - 정렬 대상 클래스를 자바에서 기본적으로 제공하고 있는 Comparable 인터페이스를 구현하도록 변경하는 것

```java
public class Ex implements Comparable{
    int serial;
    String owner;
    Ex(int serail,String owner){
        this.serial = serial;
        this.owner = owner;
    }
    public int compareTo(Ex o){
        return this.serial - ((Ex)o).serial;
//compareTo()메소드를 통해 인자로 넘어온 같은 타입의 다른 객체와 대소비교 가능
//두객체를 비교해서 같으면 0,작으면 음수,크면 양수를반환 
//이 반환값을 통해 두객체의 정렬순서가 결정
    }
}
```
- Comparator  
    1. 기본 정렬기준 외에 다른 기준으로 정렬하고자 하는 경우
    2. 정렬 대상 클래스의 코드를 직접 수정할수 없는경우
>Comparator 인터페이스의 구현체를 Array.sort() 나 Collection.sort()와 같은 정렬 메소드의 추가 인자로 넘기면 정렬 기준을 누락된 클래스의 객체나 기존 정렬 기준을 무시하고 새로운 정렬 기준으로 객체를 정렬할 수 있다.

```java
Comparator<Player> comparator = new Comparator<Player>() {
    @Override
    public int compare(Player a, Player b) {
        return b.getScore() - a.getScore();
    }
};

Collections.sort(players, comparator);
/*Comparator 객체를 Collections.sort() 메소드의 두번째 인자로 넘김
Comparator객체를 인자로 넘기면 정렬 대상 객체가 Comparable 인터페이스를 구현 여부와 
상관없이, 넘어온 Comparator 구현체의 compare() 메소드 기준으로 정렬을 수행
compare() 메소드는 비교대상 2개의 객체를 차례로 인자로 받고
첫번째 인자가 두번째 인자보다 작으면 음수,같으면 0,크다면 양수를 리턴*/
System.out.println(players);
```
