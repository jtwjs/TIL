# Element Node Geometry 

## 1.offsetParent 기준으로 element의 offset 값 가져오기
>offsetParent의 값은 가장 가까운 부모 element 중에서 CSS position 값이 static이 아닌 element **[Containing block]**
<br> 아무 element도 발견되지 않으면 offsetParent의 값은 body태그 
<br> 위치 값이 td,th,table element가 발견되면 이 element가 offsetParnet 값이 된다.

- offsetTop
- offsetLeft
- offsetParent

## 2.getBoundingClientRect()를 사용하여 뷰포트를 기준으로 element 테두리 offset 값 & element 크기 얻기
>뷰포트의 좌상단 끝을 기준으로 element가 브라우저에서 그려질 때 element의 바깥쪽 테두리 위치를 얻는다.
- getBoundingClientRect()
- offsetHeight,offsetWidth : getBoundingClientRect()에서 제공되는 값과 동일한 높이와 너비를 얻음
```javascript
<script>
var divEdges = document.querySelector('div').getBoundingClientRect();

// element 테두리 offset 값 얻기
console.log(divEdges.top, divEdges.right, divEdges.bottom, divEdges.left);

// element의 크기(테두리+패딩+콘텐츠) 얻기 
console.log(divEdges.width, divEdges.height);
</script>
```

## 3.뷰포트에서 테두리를 제외한 element의 크기(패딩+내용)얻기
- clientWidth
- clientHeight

## 4.뷰포트의 특정 지점에서 최상단 element 얻기
- elementFromPoint(x,y) : HTML 문서의 특정지점에서 최상단 element에 대한 참조를 얻는다. 

