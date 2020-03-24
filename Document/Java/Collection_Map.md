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
>Map 인터페이스의 한종류로써 key와 value값으로 데이터를 저장하는 형태를 가짐<br>해시 알고리즘을 사용하여 검색속도 매우빠름

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
>hashtable은 hashmap과 동일한 내부구조를 가지고 있다. <br>Hashtable도 키로 사용할 객체는 hashCode()와 equals()메소드를 재정의해서 동등 객체가 될 조건을 정해야한다.<br>hashMap과의 차이점은 hashtable은 동기화(synchronized)메소드로 구성되어 있기 때문에 <br>멀티 스레드가 동시에 이메 소드들을 실행할 수는 없고, 하나의 스레드가 실행을 완료해야만 다른 스레드를 실행할 수 있다.