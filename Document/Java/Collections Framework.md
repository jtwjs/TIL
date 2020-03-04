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
|void **clar()**|해당 collection의 **모든 요소를 제거**함.(선택적 기능)|
|boolean **contains(Object o)**|해당 collection이 전달된 객체를 **포함하고 있는지를 확인함**.|
|boolean **equals(Object o)**|해당 collection과 전달된 객체가 **같은지를 확인**함.|
|boolean **isEmpty()**|해당 collection이 **비어있는지를 확인**함.|
|Iterator< E >**iterator()**|해당 collection의 반복자(iterator)를 반환함.|
|boolean **remove(Object o)**|해당 collection에서 **전달된 객체를 제거**함.(선택적 기능)|
|int **size()**|해당 collection의 요소의 **총 개수**를 반환함.|
|Object[] **toArray()**|해당 collection의 모든 요소를 Object타입의 배열로 반환함.|
