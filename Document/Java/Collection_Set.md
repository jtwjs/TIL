# Set (집합)
>List와 다르게 **객체(데이터)를 중복해서 저장할 수 없다.**<br> 또한 저장된 객체(데이터)를 인덱스로 관리하지 않기 때문에 **저장 순서가 보장되지 않는다.**<br> 수학의 집합과 비슷한 내용.
- HasheSet
- TreeSet
- LinkedHashSet

|Return type|Method|Content|
|:-----|:-----|:-----|
|boolean|add(E e)|객체(데이터)추가|
|Iterator< E >|iterator()|검색을 위한 반복자 생성|
|int|size()|저장된 객체의 수 리턴|
|void|clear()|저장된 객체 모두 삭제|
|boolean|remove(Object o)|해당 객체 삭제|

>Set은 인덱스로 객체를 관리하지 않기 때문에<br> **데이터를 검색하기 위해서는 iterator()메소드로 Iterator(반복자)를 생성하고 데이터를 가져와야 한다.**

## HashSet
>Set 컬렉션을 구현하는 대표적인 클래스. <br> **데이터를 중복 저장할 수 없고 순서를 보장하지 않는다.**

### Set< E > 객체명 = new HashSet< E >();

```java
public class HashSetEx{
    public static void main(String[] args){
        Set<String> set = new HashSet<String>();
        set.add("one");
        set.add("two");
        set.add("one");
        set.add("two");
        set.add("3");
        set.add("4");

        System.out.println("저장된 데이터 수: "+set.size());//데이터 수 출력

        Iterator<String> it = set.iterator();//Iterator(반복자) 생성

        while(it.hasNext()){//hasNext() : 데이터가 있으면 true 없으면 false
            System.out.println(it.next()); // next() : 다음 데이터 리턴
        }

        set.remove("3");// 데이터 제거
        System.out.println("저장된 데이터 수: "+set.size());//데이터 수 출력

        it = set.iterator();
        //반복자 재생성(위의 반복문에서 next메소드로 데이터를 다 가져왔기 때문에 재생성 필수)
        
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}

/*결과 값 
저장된 데이터 수 : 4
3
4
one
two
저장된 데이터 수 : 3
4
one
two*/
```

- containsAll() : 부분집합
- addAll()      : 합집합
- retainAll()   : 교집합
- removeAll()   : 차집합

```java
public class HashSetEx{
    public static void main(String[] args){
        Set<Integer> setA = new HashSet<Integer>();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        
        Set<Integer> setB = new HashSet<Integer>();
        setB.add(3);
        setB.add(4);

        Set<Integer> setC = new HashSet<Integer>();
        setC.add(1);
        setC.add(2);

        System.out.println(setA.containsAll(setB)); //setB는 setA의 부분집합인가?false
        System.out.println(setA.containsAll(setC)); //setC는 setA의 부분집합인가?true

        setA.addAll(setB);//setA 와 setB 를 합쳐 setA 에 저장 ->  합집합
        setA.retainAll(setB);//setA와 setB에 공통값을 setA에저장 -> 교집합
        setA.removeAll(setB);//setA 에서 setB에 있는값을 뺀값을 setA에 저장-> 차집합 

    }

}
```

>데이터를 키보드로 입력받아 객체를 HashSet에 저장하고 Iterator를 통해 저장된 객체를 출력하는 예제 

```java
class MemberInfo {
    private String name;
    private String id;

    public String getName() {return name;} //저장된 name값 리턴
    public void setName(String name) {this.name = name;}//name값 설정
    public String getId() {return id;} //저장된 id값 리턴
    public void setId(String id) { this.id = id;}// id값 설정 
}

public class HashSetEx{
    public class void main(String[] args){
        MemberInfo mm; //MemberInfo 객체 선언
        Set<MemberInfo> set = new HashSet<MemberInfo>(); //HashSet 생성
        Scanner sc = new Scanner(System.in); //스캐너 객체 생성
        do{
            mm = new MemberInfO();//반복될 때마다 인스턴스 생성
                                //(반복문 외부에서 new 연산자 사용시 1개의 객체만 저장됨)
            System.out.println("이름 입력: ");
            String name = sc.next();
            System.out.println("아이디 입력: ");
            String id = sc.next();

            mm.setName(name);
            mm.setId(id);

            set.add(mm)://set에 mm객체 저장

        }while(true);

        Iterator<MemberInfo> it = set.iterator();//Iterator 생성
        while(it.hasNext()){
            mm = it.next();
            System.out.println("이름 : " +mm.getName()); //getName메소드호출
            System.out.println("아이디 : "+mm.getId());//getId메소드호출
        }
    }
}
```

## TreeSet
- TreeSet은 이진 트리(binary tree)를 기반으로 한 Set 컬렉션이다.
- 하나의 노드는 노드값인 value와 왼쪽과 오른쪽 자식 노드를 참조하기 위한 두개의 변수로 구성된다.
- TreeSet에 객체를 저장하면 자동으로 정렬되는데 부모값과 비교해서 낮은것이 왼쪽 높은것이 오른쪽 자식노드에 저장된다.

```java
TreeSet<E> treeSet = new TreeSet<E>();
```
>Set 인터페이스 타입 변수에 대입해도 되지만 TreeSet 클래스 타입으로 대입한 이유는 객체를 찾거나 범위 검색과 관련된 메소드를 사용하기 위해서이다.

|Return Type|Method|Explain|
|:----:|:----|:-----|
|E|first()|제일 낮은 객체를 리턴|
|E|last()|제일 높은 객체를 리턴|
|E|lower(E e)|주어진 객체보다 바로 아래 객체를 리턴|
|E|higher(E e)|주어진 객체보다 바로 위 객체를 리턴|
|E|floor(E e)|주어진 객체와 동등한 객체가 있으면 리턴,만약<br>없다면 주어진 객체의 바로 아래의 객체를 리턴|
|E|ceiling(E e)|주어진 객체와 동등한 객체가 있으면 리턴,만약<br>없다면 주어진 객체의 바로 위의 객체를 리턴|
|E|pollFirst()|제일 낮은 객체를 꺼내오고 컬렉션에서 제거함|
|E|pollLast()|제일 높은 객체를 꺼내오고 컬렉션에서 제거함|

- TreeSet이 가지고 있는 정렬과 관련된 메소드

|Return type|Method|Explain|
|:-----|:-----|:-----|
|Iterator< E>|descendingIterator()|내림차순으로 Iterator를 리턴|
|NavigableSet< E>|descendingSet()|내림차순으로 정렬된 NavigableSet을 반환|

- descendingSet() 메소드는 내림차순으로 정렬된 NavigableSet 객체를 리턴
    - TreeSet과 마찬가지로 first,last,lower,higher,floor,ceiling 메소드 제공
    - 정렬 순서를 바꾸는 descendingSet() 메소드도 제공한다.
    - 오름차순으로 정렬하려면 descendingSet() 메소드를 두번 호출하면된다.

- TreeSet이 가지고 있는 범위 검색과 관련된 메소드

|Return Type|Method|Explain|
|:-----|:-----|:----------|
|NavigableSet< E>|headSet(<br>E toElement,<br>boolean inclusive<br>)|주어진 객체보다 낮은 객체들을 NavigableSet으로 리턴,<br>주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐|
|NavigableSet< E>|tailSet(<br>E fromElement,<br>boolean inclusive<br>)|주어진 객체보다 높은 객체들을 NavigableSet으로 리턴,<br>주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐|
|NavigableSet< E>|subSet(<br>E fromElement,<br>boolean fromInclusive,<br>E toElement,<br>boolean toInclusvie<br>)|시작과 끝으로 주어진 객체 사이의 객체들을 NavigableSet으로 리턴,<br> 시작과 끝 객체의 포함 여부는 두 번째,네 번째 매개값에 따라 달라짐|