## Bootstrap(부트스트랩)
> Grid System을 쉽게 CSS로 구현할수 있게 도와주는 프레임워크

### BootStrap으로 Grid System  이용 방법
1. **CSS 링크코드를 HTML head태그 안에 복붙!**
``` HTML
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
```
2. **container 생성 - > row 생성 -> col 생성**
    - ``` HTML
         <div class="container"> 
           <div class="row">
             <div class="col-1">
               <!--요소 작성!! -->
             </div>
           </div>
         </div>
         ```
    - row는 한줄을 의미 
    - Bootstrap의 경우 column이 총 12column으로 구성됨
        - 한줄에 총 12칸이 들어간다.
    - col 생성시 몇칸을 차지하는지 명시
        - ```<div class="col-n"> </div> ```
        - n칸을 차지하는 만큼 명시
    - **반드시 container 자식은 row, row 자식은 col만 와야한다.**
3. **비로소 그안에 만들 요소를 작성**

### break point를 지정가능
- 반응형 웹 작성시 사이즈가 바껴야하는  max-size 지정
    - ``` div class="col-n col-sm-n col-md-n col-lg-n col-xl-n"> </div> ```

||**Extra small**<br><576px|**Small**<br>≥576px|**Medium**<br>≥768px|**Large**<br>≥992px|**Extra large**<br>≥1200px|
|:---|:---|:---|:---|:---|:---|
|**Max container width**|None(auto)|540px|720px|960px|1140px|
|**Class prefix**|```.col-```|```.col-sm-```|```.col-md-```|```.col-lg-```|```.col-xl-```|

- .# of columns : 12
- Gutter width : 30px (15px on each side of a column)


