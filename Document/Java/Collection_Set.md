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

>Set은 인덱스로 객체를 관리하지 않기 때문에 **데이터를 검색하기 위해서는 iterator()메소드로 Iterator(반복자)를 생성하고 데이터를 가져와야 한다.**

## HastSet
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
