# Map (y =f(x) 수학 함수)
> Map 인터페이스는 Collection 인터페이스와는 다른 저장 방식을 가짐<br>Map 인터페이스를 구현한 Map 컬렉션 클래스들은 키와 값을 하나의 쌍으로 지정하는 방식 **key-value 방식을 사용** <br> key란 실질적인 값(value)를 찾기 위한 이름의 역할

>**요소의 저장 순서를 유지하지 않는다. <br> 키는 중복을 허용하지 않지만, 값의 중복은 허용**

- HashMap<K,V>
- TreeMap<K,V>
- LinkedHashMap<K,V>

### Map 인터페이스의 주요 메소드
|Method|Content|
|:----:|:------|
|put()|키(key)와 값으로 구성된 새로운 데이터를 추가|
|get()|지정한 키(key)에 해당하는 데이터를 반환|
|remove()|지정한 키(key)에 해당하는 데이터를 삭제|
|containKey()|지정한 키(key)가 존재하는지 여부를 반환|
|containsValue()|지정한 값이 존재하는지 여부를 반환|
|size()|Map의 요소 개수를 반환|
|isEmpty()|Map이 비어있는지의 여부를 반환|


## HashMap<K,V>
>Map 인터페이스의 한종류로써 key와 value값으로 데이터를 저장하는 형태를 가짐<br>해시 알고리즘을 사용하여 검색속도 매우빠름

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