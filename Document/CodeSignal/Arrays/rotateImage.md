# rotateImage [Easy]
>Note: Try to solve this task in-place (with O(1) additional memory), <br>since this is what you'll be asked to do during an interview. <br>You are given an n x n 2D matrix that represents an image.<br> Rotate the image by 90 degrees (clockwise).


```java
int[][] rotateImage(int[][] a) {
    int SIZE = a.length;
    
			int[][] b = new int[SIZE][SIZE];
			for(int i = 0 ; i < SIZE ; i++) {
				for (int j = 0; j < SIZE; j++) {
					b[i][j] = a[SIZE - 1 - j][i];
				}
			}
					
			return b;
}
```