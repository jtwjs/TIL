## $(document).ready(function(){..}
- **window.onload와 동일한 기능**
- body태그의 모든 태그들이 출력이 된다음에 호출이 되는 코드

- 더 간결한 표현식
- ```javascript
        $(function(){
            //code insert
        });
    ```
- body 태그내의 모든 코드를 읽은 후에 호출되는 onload 기능들이어도 순수 window.onload 코드가 가장 나중에 호출된다.