# firstDuplicate [Easy]

>Given an array a that contains only numbers in the range from 1 to a.length, find the first duplicate number for which the second occurrence has the minimal index. In other words, if there are more than 1 duplicated numbers, return the number for which the second occurrence has a smaller index than the second occurrence of the other number does. If there are no such elements, return -1


## 1차
```java
int firstDuplicate(int[] a) {
    int[] b= new int[a.length];
    for(int i=0;i<a.length;i++){
        for(int j=0;j<b.length;j++){
            if(a[i]==b[j]){ 
                return a[i];
                   } 
       }
         b[i]=a[i];   
} 
return -1;
}
```

## 2차
```java
int firstDuplicate(int[] a) {
Set<Integer> search = new HashSet<>();
for(int i=0;i<a.length;i++){
    if(search.contains(a[i])){
        return a[i];
    }
    else search.add(a[i]);
}
return -1;
}
```

