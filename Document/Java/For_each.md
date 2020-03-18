# for each (향상된 for문)

```java
/*for(변수타입 변수이름:배열이름)
        실행부분;
 변수 타입 : 배열 항목과 동일한 타입*/
public class ForTest{
    public static void main(String[] args){
        int array[] = {10,20,30,40,50};
        for(int number : array){
            System.out.println(array[number]);
        }
    }
}
```
> for each 에서는 배열의 항목 수만큼 실행부분을 반복하는데 반복이 이루어질 때마다 배열의 항목을 순서대로 꺼내어 변수(number)에 자동으로 대입해준다.

>따로 반복 변수(int i)를 선언하거나 배열의 값을 가져오는 부분(array[ i ])없이 실행부분에서는 하고자 하는 작업에 집중할 수 있다.

>**오직 배열의 값을 가져다 사용할수만 있고 수정할 수는 없다.** <br> for문과 for each문의 구현 방식에 대한 성능 차이는 없다 