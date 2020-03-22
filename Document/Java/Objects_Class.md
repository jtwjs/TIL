# Objects Class
>Object 와 유사한 이름을 가진 java.util.Objects 클래스는 **객체비교**, **해시코드 생성**, **null 여부**, **객체 문자열 리턴** 등의 연산을 수행하는 정적 메소드들로 구성된 Object의 유틸리티 클래스이다.

>java.util 패키지

|**Return type**|**Method(parameter)**|**Explain**|
|:-----|:-----|:------|
|int|compareTo(T a,T b,Compparator< T > c)|두 객체 a와 b를 Comparator를 사용해서 비교|
|boolean|deepEquals(Object a,Object b)|두 객체의 깊은 비교(배열의 항목까지 비교)|
|boolean|equals(Object a,Object b)|두 객체의 얕은 비교(번지만 비교)|
|int|hash(Object... values)|매개값이 저장된 배열의 해시코드 생성|
|int|hashCode(Object o)|객체의 해시코드 생성|
|boolean|isNull(Object obj)|객체가 null인지 조사|
|boolean|nonNull(Object obj)|객체가 null이 아닌지 조사|
|T|requireNonNull(T obj)|객체가 null인 경우 예외 발생|
|T|requireNonNull(T obj,<br>String message)|객체가 null인 경우 예외 발생(주어진 예외메세지 포함)|
|T|requireNonNull(T obj,<br>Supplier< String > messageSupplier)|객체가 null인 경우 예외발생(람다식이 만든 예외 메세지 포함)|
|String|toString(Object o)|객체의 toString() 리턴값 리턴|
|String|toString(Object o,String nullDefault)|객체의 toString() 리턴값 리턴<br> 첫 번째 매개값이 null일 경우 두 번째 매개값 리턴|

## 객체 비교(compare(T a,T b,Comparator<T>c))
>두 객체를 비교자(Comparator)로 비교해서 int 값을 리턴한다.<br> java.util.Comparator< T >는 제네릭 인터페이스 타입으로 두 객체를 비교하는 compare(T a,T b)메소드가 정의되어 있다.

```java
public interface Comparator<T>{
    int compare(T a,T b); m
}
```

>compare() 메소드의 리턴 타입은 int인데 a가 b보다 작으면 음수, 같으면 0, 크면 양수를 리턴하도록 구현 클래스를 만들어야한다.

```java
class StudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student a,Student b){
        if (a.sno<b.sno) return -1; //a의 sno가 작으면 -1
        else if (a.sno == b.sno) return 0;//같으면 0
        else return 1; //크면 1 리턴
    }
}
```

```java
public class CompareExample{
    public static void main(String[] args){
        Student s1 = new Student(1);
        Student s2 = new Student(1);
        Student s3 = new Student(2);

        int result = Objects.compare(s1, s2, new StudentComparator() );
        System.out.println(result);
        result = Objects.compare(s1, s3, new StudentComparator() );
        System.out.println(result);
    }

    static class Student {
        int sno;
        Student(int sno) {
            this.sno = sno;
        }
    }

    static class StudentComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2){
            /*if(o1.sno<o2.sno) return -1;
            else if(o1.sno == o2.sno) return 0;
            else return 1;*/
            return Integer.compare(o1.sno, o2.sno);
            
        }
    }
}
```