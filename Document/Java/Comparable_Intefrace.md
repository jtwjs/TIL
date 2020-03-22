# Comparable<T> 인터페이스
- 정렬 수행시 **기본적으로 적용되는** 정렬 기준이 되는 메소드를 정의하는 인터페이스 
- package: java.lang.Comparable
    - java에서 제공되는 정렬이 가능한 클래스들은 모두 Comparable 인터페이스를 구현하고 있으며<br>정렬 시에 이에 맞게 정렬이 수행된다.
        1. Intger,Double 클래스  : 오름차순 정렬
        2. String 클래스 : 사전순 정렬
>객체를 정렬하는 데 사용되는 메소드인 compareTo()메소드를 정의하고 있다.<br>자바와 같은 타입의 인스턴스를 서로 비교해야만 하는 클래스들은 모두 Comparable 인터페이스를 구현하고 있다.<br> 따라서 Boolean을 제외한 Wrapper 클래스나 String, Time, Date와 같은 클래스의 인스턴스는 모두 정렬 가능하다. 

### 구현 방법
- 정렬할 객체에 Comparable interface를 implements 후, compareTo() 메소드를 오버라이드하여 구현
- compareTo() 메소드 작성법
    - 현재 객체 < 파라미터로 넘어온 객체 : 음수 return
    - 현재 객체 == 파라미터로 넘어온 객체 : 0 return
    - 현재 객체 > 파라미터로 넘어온 객체 : 양수 return
    - 음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 바뀐다.

## 사용 방법
- Array.sort(array)
- Collection.sort(list)

>자바에서는 원시형(primitive) 타입의 Wrapper 클래스들은 모두 compareTo() 메소드를 이미 오버라이드 해있다.<br> 따라서 쉽게 객체간의 비교들을 할수 있다. <Br> (compareTo() 메소드가 구현된 객체는 **Arrays.sort() 메소드를 통해 자동 정렬 가능**)

```java
int arr = {5,2,6,8,9};
Arrays.sort(arr); //정말 쉽게 오름차순 정렬 가능
```


```java
class Car implements Comparable<Car>{
    private String modelName;
    private int modelYear;
    private String color;

    Car(String min,int my,Strint c){
        this.modelName = min;
        this.modelYear = my;
        this.color = c;
    }
    public String getModel(){
        return this.modelYear+"식"+this.modelName+" "+this.color;
    }

    @Override  //Comparable 인터페이스 추상메소드
    public int compareTo(Car obj){
        if(this.modelYear == obj.modelYear){
            return 0;
        }else if(this.modelYear < obj.modelYear){
            return -1;
        }else return 1;
    }

public class Comparable01{
    public static void main(String[] args){
        Car car01 = new Car("아반떼",2016,"노란색");
        Car car02 = new Car("소나타",2010,"흰색");

        System.out.println(car1.compareTo(car2));
    }

}
}
```

|**Method**|**Explain**|
|:----:|:-----|
|int compareTo(T o)|해당 객체와 전달된 객체의 순서를 비교함|

