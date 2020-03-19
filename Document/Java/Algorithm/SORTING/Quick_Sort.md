# Quick Sorting Algoritm (퀵 정렬 알고리즘)[시간 복잡도 O(Nlog2N)](stable)
> 퀵 정렬(Quick Sort)은 정렬할 **전체 값들을 정렬을 수행하지 않고 기준값을 중심으로 왼쪽 부분집합과 오른쪽 부분집합으로 분할**한다.
- 분할 정복(Devide and Conquer)기법과 재귀알고리즘을 이용한 정렬 알고리즘
- 왼쪽 부분 집합에는 기준값보다 작은 원소들을, 오른쪽 부분집합에는 기준값보다 큰 원소들을 이동.
- 이 때 사용하는 **기준값 = Pivot**이라고 칭한다.
- [예제 그림 보기](#Ex:)

## Core of Quick Sort Algorihm
1. **분할** : 정렬할 자료들을 기준값을 중심으로 2개의 부분집합으로 분할한다.
2. **정복** : 기준보다 작은 값은 왼쪽, 기준보다 큰 값은 오른쪽 부분집합으로 정렬<br>부분집합의 크기가 1 이하가 아니면 순환 호출을 이용해 다시 분할.
3. **결합** : 정렬된 부분 배열들을 하나의 배열에 합병한다.
- 순환 호출이 한번 진행될 때 마다 최소한 하나의 원소(피벗)는 최종적으로 위치가 정해지므로,이 알고리즘은 반드시 끝난다는 것을 보장할 수 있다.

## Way of Quick Sort Algorithm
>Pivot을 중심으로 L과 R 값을 지정해준다.<br> L은 Pivot보다 작은값, R은 Pivot보다 큰 값을 지정한다.<br>두 개 모두 선택됬다면 자리교환을 해주면 된다.<br>만약 한쪽이 선택된 L이나 R이 없다면 선택된 값과 Pivot을 교환한다.


```java
public void quickSort(int[] data,int l,int r){
    int left = l;
    int right = r;
    int pivot = data[(l+r)/2];

    do{
        while(data[left] < pivot) left++;
        while(data[right] > pivot) right--;
        if(left <= right) {
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;
            left++;
            right--;
        }
    }while(left <= right);
    if(l < right) quickSort(data,l,right);
    if(r > left) quickSort(data,left,r);
}

```



## Ex:

![quick-sort2](https://user-images.githubusercontent.com/60641307/77064157-4d81b580-6a22-11ea-935f-095295d5d724.png)
