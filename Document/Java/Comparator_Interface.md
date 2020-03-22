# Comparator<T> 인터페이스
- 정렬 가능한 클래스(Comparable 인터페이스를 구현한 클래스)들의 **기본 정렬 기준과 다르게 정렬**하고 싶을 때 사용하는 인터페이스
- package:java.util.Comparator
    - 주로 익명 클래스로 사용된다.
    - 기본적인 정렬 방법인 오름차순 정렬을 **내림차순으로 정렬할 때** 많이 사용한다.

>Comparable 인터페이스와 같이 객체를 정렬하는데 사용되는 인터페이스이다.<br>
>Comparator 인터페이스를 구현하면 오름차순 이외의 기준으로도 정렬할 수 있게 된다. <br>
>이때 Comparator 인터페이스를 구현한 클래스에서는 compare() 메소드를 재정의하여 사용하게 된다

### 구현 방법
- Comparator interface를 implements 후 compare() 메소드를 오버라이드하여 구현
- compare() 메소드 작성법
    - 첫 번째 파라미터로 넘어온 객체 < 두 번째 파라미터로 넘어온 객체 : 음수 return
    - 첫 번째 파라미터로 넘어온 객체 == 두 번째 파라미터로 넘어온 객체 : 0 return
    - 첫 번째 파라미터로 넘어온 객체 > 두 번째 파라미터로 넘어온 객체 : 양수 return
- 음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 변경된다.
    - 즉, Integer.compare(x,y)(오름차순 정렬)와 동일한 개념
        - return (x < y>) ? -1 :((x == y)) ? 0 : 1);
    - 내림차순 정렬의 경우 두 파라미터의 위치를 바꿔준다.
        - Integer.compare(y,x)(내림차순 정렬)

### 사용 방법
- Arrays.sort(array,Comparator interface를 구현한클래스)
- Collections.sort(array,Comparator interface를 구현한클래스)
- Arrays.sort(),Collections.sort() 메소드는 두 번째 인자로 Comparator interface를 받을 수 있디.

```java
class ComparatorExample1 implements Comparator<Point>{
    @Override
    public int compare(Point p1, Point p2){
        if (p1.x > p2.x){
            return 1; //x에 대해서는 오름차순
        }
        else if (p1.x == p2.x) {
            if (p1.y < p2.y) { //y에 대해서는 내림차순
                return 1;
            }
        }
        return -1;
    }
}

//main
List<Point> pointList = new ArrayList<>();
pointList.add(new Point(x,y); );
ComparatorExample1 Comparator = new ComparatorExample1();
Collections.sort(pointList, Comparator);
```


- Comparator 익명 클래스 이용

```java
Comparator<Point> myComparator = new Comparator<Point>() {
    @Override
    public int compare(Point p1, Point p2) {
        if (p1.x > p2.x){
            return 1; //x에 대해서는 오름차순
        }
        else if (p1.x == p2.x) {
            if (p1.y < p2.y) { //y에 대해서는 내림차순
                return 1;
            }
        }
        return -1;
    }
    }; //익명클래스는 중괄호({}) 끝에 세미콜론(;)필수

    List<Point> pointList = new ArrayList<>();
    pointList.add(new Point(x,y) );
    Collection.sort(pointList,myComparator);
}
}
```

|Method|Explain|
|:-----|:-----|
|int compare(T o1, T o2)|전달된 두 객체의 순서를 비교함|
|boolean equals(Object obj)|해당 comparator와 전달된 객체가 같은지 확인|
|defualt Comparator< T > reversed()|해당 comparator의 역순인 comparator를 반환함|