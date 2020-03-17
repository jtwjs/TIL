# Select Sort(선택 정렬)[시간 복잡도 O(n^2)](stable)
>배열중에 가장 작은 원소들을 왼쪽부터 채워나가면서 숫자를 정렬하는 방법<br>목록의 각 위치에 대해서 이 알고리즘은 그 위치에 배치되어야 하는 값을 선택하고, 그 값을 그 곳에 배치한다.

1. 목록 전체를 조사하여 가장 작은 값을 찾는다.
2. 이 값과 목록의 첫 번째 위치에 있는 값을 교환한다.
3. 목록의 나머지 값들(첫 번째 값을 제외한 모든 값)을 조사하여
가장 작은 값을 찾고,이 값과 목록의 두 번째 위치에 있는 값을 교환한다.
4. 목록의 각 위치에 대해서 이러한 과정을 계속한다.

![1](https://user-images.githubusercontent.com/60641307/76816673-2a99aa80-6844-11ea-814a-3fd5cff7563b.jpg)

![246C904C534962792D](https://user-images.githubusercontent.com/60641307/76816681-308f8b80-6844-11ea-98aa-03d8dd5b9199.jpg)

```java
public class Select_Sort{

    public void swap(int[] list,int i,int min){
        int temp;
        temp = list[min];
        list[min] = list[i];
        list[i] = list[min];
    }
    public void selectionSort(int[] list){
        int min,temp;
        for(int i=0;i<list.length-1;i++){//마지막 배열은 굳이 검사할 필요X
            min=i;
            for(int j=i+1;j<list.length;j++){//제일 작은수 찾기
                if(list[j]<list[min]){
                    min=j;//제일 작은수 저장
                }
            }
            swap(list,i,min);//스왑메소드 활용
        }
    }
}
```