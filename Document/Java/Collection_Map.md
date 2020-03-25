# Map (y =f(x) 수학 함수)
> Map 인터페이스는 Collection 인터페이스와는 다른 저장 방식을 가짐<br>Map 인터페이스를 구현한 Map 컬렉션 클래스들은 키와 값을 하나의 쌍으로 지정하는 방식 **key-value 방식을 사용** <br> key란 실질적인 값(value)를 찾기 위한 이름의 역할

>**요소의 저장 순서를 유지하지 않는다. <br> 키는 중복을 허용하지 않지만, 값의 중복은 허용**

- HashMap<K,V>
- TreeMap<K,V>
- LinkedHashMap<K,V>

### Map 인터페이스의 주요 메소드

||Method|Content|
|:-----|:----:|:------|
|객체 추가|V put(K key,V value)|키(key)와 값(value)으로 구성된 새로운 데이터를 추가|
|객체 삭제|V remove(Object key)|주어진 키와 일치하는 Map.Entry를 삭제하고 값을 리턴|
|객체 삭제|void clear()|모든 Map.Entry(키와 값)을 삭제|
|객체 검색|V get(Object key)|지정한 키(key)에 해당하는 데이터를 반환|
|객체 검색|boolean containKey(Object key)|지정한 키(key)가 존재하는지 여부를 반환|
|객체 검색|boolean containsValue(Object key)|지정한 값이 존재하는지 여부를 반환|
|객체 검색|int size()|저장된 key의 총 수를 반환|
|객체 검색|boolean isEmpty()|Map이 비어있는지의 여부를 반환|
|객체 검색|Set<Map.Entry<K,V>> entrySet()|키와 값의 쌍으로 구성된 모든 map.Entry 객체를 Set에 담아서 리턴|
|객체 검색|Set<K> keySet()|모든 키를 Set 객체에 담아서 리턴|
|객체 검색|Collection<V> values()|저장된 모든 값을 Collection에 담아서 리턴|

## HashMap<K,V>
>Map 인터페이스의 한종류로써 key와 value값으로 데이터를 저장하는 형태를 가짐
- 해시 알고리즘을 사용하여 검색속도 매우빠름
    - HashMap은 내부적으로 배열을 사용하여 데이터를 저장하기 때문에 빠른 검색 속도를 갖는다.
    - Searching 하는데 데이터 **고유의 인덱스**로 접근하게 되므로 Time Complexity가 O(1)이 되는 것이다.
    - 데이터의 삽입과 삭제시 기존 데이터를 밀어내거나 다시 채우는 작업이 필요없도 **Hash Algorithm**을 이용
        - 데이터와 연관된 고유한 숫자를 만들어 낸 뒤 이를 인덱스로 사용
        - 인덱스는 그 데이터만의 고유한 위치이기 때문에 추가적인 데이터의 이동이 없다.
### Hash Algorithm
>Hash Method(해시 메소드)또는 Hash Function(해시 함수)라고 한다.<br> 이 메소드에 의해 반환된 데이터의 **고유한 숫자값을 hashcode**라고 한다.<br> Java에서는 Object 클래스의 hashCode()라는 메소드를 이용하여 모든 객체의 hashcode 값을 쉽게 구할수 있다.

- hash 메소드의 간단한 구현방법(1) : **나머지 연산자 이용**
    - 저장할 데이터의 값을 저장할 hashtable의 크기로 나누고 나머지 연산 결과를 해당 데이터의 인덱스로 사용
    - 문제점: 같은 index로 접근하게 되는 value가 많아져 데이터를 저장할수 없게 되는 충돌현상(**Collision**)이 발생한다. 
    - **(Collision)** 최소화 하는 방법 : 테이블의 크기를 **소수**(**prime number**)로 만드는것..
    - 데이터를 추가적으로 저장할시 다시 중복 발생 (충돌을 줄이지만 원천적으로 해결하지는 못한다.)
> 충돌이 많아질 수록 Searching에 필요한 Time Complexity가 O(1)에서 O(n)에 가까워진다.<br> 좋은 해쉬 함수를 선택하는 것은 해쉬 테이블의 성능 향상에 필수적이다.

### 해시 충돌을 해결하기 위한 대표적인 두가지 방법..
### 1. Open Address 방식(개방주소법)
> 해시 충돌이 발생하면, 즉 삽입하려는 해시 버킷이 이미 사용 중인 경우 **'다른'**해시 버킷에 해당 자료를 삽입하는 방식<br>
>버킷(bucket)이란 바구니와 같은 개념으로 데이터를 저장하기 위한 공간이다. 

>공개 주소 방식이라고 불리는 이 알고리즘은 Collision이 발생하면 데이터를 저장할 장소, 즉 다들ㄴ 해시 버킷을 찾아 해맨다.
1. **Linear Probing**
    - 순차적으로 탐색하며 비어있는 버킷을 찾을 때 까지 계속 진행된다. 
    - Worst Case의 경우 비어있는 버킷을 찾지 못하고 탐색을 시작한 위치까지 되돌아 올 수있다.
2. **Quadratic probing**
    - 2차 함수를 이용해 탐색할 위치를 찾는다.
3. **Double hashing probing**
    - 하나의 해쉬 함수에서 충돌이 발생하면 2차 해쉬 함수를 이용해 새로운 주소를 할당한다.
    - 위 두가지 방법에 비해 많은 연산량을 요구한다.
### 2. Separate Chaining 방식 (분리연결법)
- java 7에서는 Seprate Chaining 방식을 사용하여 HashMap을 구현하고있다.
    - HashMap의 특징상 remove()메소드가 빈번하게 일어날 수 있다.
        - **데이터를 삭제할 때 Open Addreess방식은 처리가 비효율적**이다.
    - 또한 저장된 Key-Value 쌍의 개수가 일정 개수 이상 많아지면, open Addreess방식이 더 느리다.
1. (Linked List)연결리스트를 사용하는 방식
    - 각각의 버킷들을 Linked List로 만들어 Collision이 발생하면 해당 버킷의 list에 추가하는 방식이다.
    - Linked List의 특징을 그대로 이어받아 삭제 또는 삽입이 간단하다.
    - 장점:Open Address방싱게 비해 테이블의 확장을 늦출수 있다.
    - 단점:단점도 그대로 물려받아 작은데이터를 저장할때 Linked List 자체의 오버헤드가 부담됨

>Separate Chaining방식의 경우 해시 충돌이 잘 발생하지 않도록 **보조 해시 함수**를 통해 조정 가능
2. (Red-Black Tree)Tree를 사용하는 방식
    - 기본적인 알고리즘은 Separate Chaining 방식과 동일 
    - Linked List 대신 Tree를 사용하는 방식
        - 고르는 기준은 하나의 해시 버킷에 할당된 key-value 쌍의 개수이다.
    - Tree는 기본적으로 메모리 사용량이 많고 데이터의 개수가 적을때 위 두개는 성능상 차이가 거의없다 
        - 따라서 메모리 측면을 봣을 때 데이터의 개수가 적을 때는 Linked List를 사용
### 해시 버킷 동적 확장(Resize)
- 해시 버킷의 개수가 적다면 메모리 사용을 아낄 수 있지만 해시 충돌로 인해 성능 상 손실이 발생
     - Key-value 쌍 데이터 개수가 **일정 개수 이상**이되면 해시 버킷의 갯수를 두배로 늘린다.
        - 일정 개수는 현재 데이터 개수가 해시 버킷의 개수의 75%(HashMap의 생성자에서 지정가능)가 될때를 말한다.

         
#### 컬렉션 프레임워크에서 HashSet,HashMap,HashTable의 객체비교
>우선 hashCode()메소드를 실행해서 리턴된 해시코드 값이 같은지를 본다.<br>해시 코드값이 다르면 다른 객체로 판단하고, 해시 코드값이 같으면 equals()메소드로 다시 비교한다.<br> 이 두개가 모두 맞아야 동등 객체로 판단한다.

![해시코드](https://user-images.githubusercontent.com/60641307/77223145-4f23b880-6b9d-11ea-96c0-2ec35045a2ab.png)

```java
//Key클래스 equals() 메소드를 재정의해서 number 필드값이 같으면 true를 리턴
//그러나 hashCode() 메소드는 재정의하지 않았기 때문에 Object hashCode()메소드가 사용됨
public class Key{
    public int number;

    public Key(int number);
    this.number = number;

@Override
public boolean equals(Object obj){
    if(obj instanceof key){
        key compareKey = (key) obj;
        if(this.number == compareKey.number){
            return true;
        }
    }
    return false;
}
}
//이런 경우 두개의 동등한 객체를 HashMap의 식별키로 Key 객체를 사용하면 
//저장된 값을 찾아 오지 못한다. number필드 값이 같더라도 hashCode()메소드에서 
//리턴하는 해시코드가 다르기 때문에 다른 식별키로 인식하기 떄문..
public class KeyExample{
    public static void main(String[] args){
        //Key 객체를 식별키로 사용해서 String 값을 저장하는 HashMap 객체생성
        HashMap<Key,String> hashMap = new HashMapM<Key,String>();

        //식별키 "new key(1)"로 "홍길동"을 저장함
        hashMap.put(new key(1),"홍길동");

        //식별키 "new key"로 "홍길동"을 읽어옴
        String value = hashMap.get(new Key(1));
        System.out.println(value);
    }
}
//위내용에서 HashCode를 정의하지 않았기 떄문에 null이 조회된다.
//만약 의도한대로 홍길동을 읽으려면 hashCode를 재정의 해야한다.
public class key{
    ...
    @Override
    public int hashCode(Object obj){
        return number;
    }
}
//저장할 때의 new Key(1)과 읽을때의 new Key(1)은 다른 참조값의 다른 객체자이지만
//HashMap은 hashCode()의 리턴값이 같고, equals() 리턴값이 true가 나오기 떄문에
//두 객체는 동등객체로 평가하여 하나의 키처럼 사용하게 된다. 즉,같은 식별키로 인식
```

>**이러한 이유로 객체의 동등비교를 위해서는 Object의 equals() 메소드만 재정의하지 말고** <br>**hashCode() 메소드도 재정의해서 논리적 동등 객체일경우 동일한 해시코드가 리턴되도록해야한다.**

>키를 기반으로 찾는 것이지 객체의 참조 값으로 찾는것은 아니다.<br> hash코드값이 같다고 해서 객체의 참조 값이 같은것은 아니다.


>Map 자체에는 Iterator 기능이 없다.!<br> 그러므로 Set을 활용한다!
### for-each문 활용

 ```java
 static void interatorUsingForEach(HashMap map){
     Set<Map.Entry<String,Integer>> entries = map entrySet();
     for(Map.Entry<String,Integer> entry : entries) {
         System.out.println(entry.getkey() + ": " + entry.getValue());
     }
 }
 ```

### Iterator 활용

```java
static void iteratorUsingIterator(HashMap map){
    Set<Map.Entry<String, Integer>> entrise = map.entrySet();
    Iterator<Map.Entry<String, Integer>> i = entries.iterator();
    while(i.hasNext()){
        Map.Entry<String, Integer> entry = i.next();
        System.out.println(entry.getKey()+ " : " + entry.getValue());
    }
}
```


## Hashtable
- HashTable은 HashMap과 동일한 내부구조를 가지고 있다.
- Hashtable도 키로 사용할 객체는 hashCode()와 equals()메소드를 재정의해서 동등 객체가 될 조건을 정해야한다.
- HashMap과의 차이점은 HashTable은 동기화(synchronized)메소드로 구성되어 있다. 
    - 멀티 스레드가 동시에 이 메소드들을 실행할 수는 없고, 하나의 스레드가 실행을 완료해야만 다른 스레드를 실행할 수 있다.
- HashMap은 보조 해시 함수(Additional Hash Function)을 사용하기 때문에 해시 충돌(hash collision)이 덜 발생한다.
- HashMap은 지속적으로 개선되고 있다.(Update)
- HashTable의 현재 가치는 하위 호환성을 제공하는 것이다. (JRE1.0, JRE1.1환경을 대상으로 군현한 Java applicationj)
    - 이 둘 사이의 성능과 기능을 비교하는것은 큰의미가 없다고 볼수 있다.
### Properties
- Hashtable의 하위 클래스 
- 키와 값을 String타입으로 제한한 컬렉션
- app의 옵션정보, DB연결 정보, 국제화(다국어)정보가 저장된 프로퍼티(~.properties)파일 읽을때 주로사용
- 프로퍼티 파일은 키와 값이 = 기호로 연결되어 있는 텍스트 파일로 ISO8859-1문자셋으로 저장된다.
    - 이문자셋으로 표현할수없는 한글은 유니코드(Unicode)로 변환되어 저장됨

## TreeMap
- 이진 트리를 기반으로 한 Map 컬레션이다.
- TreeSet과 차이점은 키와 값이 저장된 Map.Entry를 저장한다는 점이다.
- TreeMap에 객체를 저장하면 자동으로 정렬된다.
    - 부모 키값과 비교해서 키 값이 낮은 것은 왼쪽 자식 노드에, 키 값이 높은 것은 오른쪽 자식 노드에 Map.Entry 객체를 저장한다.

```java
TreeMap<String,Integer> treemap = new Treemap<String, Integer>();
```
- Map 인터페이스 타입 변수에 대입해도 되지만 TreeMap 클래스 타입으로 대입한 이유는 특정 객체를 찾거나 범위 검색과 관련된 메소드를 사용하기 위해서이다.

|Return Type|Method|Explain|
|:--------|:----|:---------|
|Map.Entry< K,V>|firstEntry()|제일 낮은 Map.Entry를 리턴|
|Map.Entry< K,V>|lastEntry()|제일 높은 Map.Entry를 리턴|
|Map.Entry< K,V>|lowerEntry(K key)|주어진 키보다 바로 아래 Map.Entry를 리턴|
|Map.Entry< K,V>|higherEntry(K Key)|주어진 키보다 바로 위 Map.Entry를 리턴|
|Map.Entry< K,V>|floorEntry(K key)|주어진 키와 동등한 키가 있으면 해당 Map.Entry를 리턴<br>없다면 주어진 키 바로 아래의 Map.Entry를 리턴|
|Map.Entry< K,V>|ceilingEntry(K key)|주어진 키와 동등한 키가 있으면 해당 Map.Entry를 리턴<br>없다면 주어진 키 바로 위 Map.Entry를 리턴|
|Map.Entry< K,V>|pollFirstEntry()|제일 낮은 Map.Entry를 꺼내오고 컬렉션에서 제거함|
|Map.Entry< K,V>|pollLastEntry()|제일 높은 Map.Entry를 꺼내오고 컬렉션에서 제거함|

- TreeMap이 가지고 있는 정렬과 관련된 메소드

|Return Type|Method|Explain|
|:-----|:------|:------|
|NavigableSet< K>|descendingKeySet()|내림차순으로 정렬된 키의 NavigableSet을 리턴|
|NavigableMap< K,V>|descendingMap()|내림차순으로 정렬된 Map.Entry의 NavigableMap을 리턴|

```java
NavigableMap<K,V> descendingMap = treeMap.descendingMap(); //내림차순
NavigableMap<K,V> ascendingMap = descendingMap.descendingMap();// 내림차순 X2 -> 오름차순
```

- TreeMap이 가지고 있는 범위 검색과 관련된 메소드

|Return Type|Method|Explain|
|:-----|:-----|:-----------|
|NavigableMap< k,V>|headMap(<br>K toKey,<br>boolean inclusive<br>)|주어진 키보다 낮은 Map.Entry들을 NavigableMap으로 리턴,<Br>주어진 키의 Map.Entry 포함여부는 두번째 매개값에 따라 달라짐|
|NavigableMap< K,V>|tailMap(<br>K formKey,<br>boolean inclusive<br>)|주어진 객체보다 높은 Map.Entry들을 NavigableMap으로 리턴,<br>주어진 키의 Map.Entry 포함여부는 두번째 매개값에 따라 달라짐|
|NavigableMap< K,V>|subMap(<br>K fromKey,<br>boolean fromInclusive,<Br>K toKey,<br>boolean toInclusiv<br>)|시작과 끝으로 주어진 키 사이의 Map.Entry들을 NavigableMap 컬렉션으로 반환<br>시작과 끝 키의 Map.Entry 포함여부는 두번쨰,네번째 매개값에따라 달라짐|
