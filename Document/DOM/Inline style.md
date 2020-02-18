# INLINE STYLE NODE

## 1.style attribute
- node.style : CSSStyleDeclaration 개체를 반환 
- CSSStyleDeclaration : element의 인라인 스타일만이 포함됨
>1.style개체에 포함된 속성명에는 하이픈(-)을 사용하지않고 카멜케이스를 사용한다. ex: (font-size -> fontSize)
<br>2.CSS 속성명이 JavaScript 키워드인 경우, JavaScript CSS속성명에는 css라는접두어가 붙는다. ex: (float = cssFloat)
<br>3.측정단위가 필요한 CSS 속성의 경우, 적절한 단위를 포함시켜야 함 ex: (style.width = '300**px**')

### 1-1.Style개체는 CSSStyleDeclaration 개체로 개별 CSS속성에 대한 접근 및 조작 가능
1.  설정
    - node.style.propertyName = 'value';
2.  value 가져오기
    - node.style.propertyName;
3.  제거(값에 공백 넣기)
    - nod.style.propertyName = '';

### 1-2.style 개체는 element노드의 개별 CSS속성을 조작하는 메서드에 대한 접근도 제공 
1.  설정
    - node.style.setProperty(propertyName,value);
2.  value 가져오기
    - node.style.getPropertyValue(propertyName);
3.  제거
    - node.style.removeProperty();
> setProperty()와 getPropertyValue() 메서드에 전달되는 속성명은 **하이픈이 포함**된 **CSS 속성명**을 사용

### 1-3 모든 인라인 CSS 속성 가져오기 설정 제거
>CSSStyleDeclaration 개체의 cssText 속성과 getAttribute() 및 setAttribute() 메서드를 사용하면 
<br>JavaScript 문자열을 사용하여 style attribute의 전체 값(모든 인라인 CSS속성)을 가져오고 설정 및 제거 가능

1.  cssText를 사용하여 설정
    - node.style.cssText = 'propertyname:value;'
2.  setAttribute() 및 getAttribute()를 사용하는것과 결과가 완전히 동일
    - node.setAttribute('style','propertyName:value');
    - node.getAttribute('style');
    - node.removeAttribute('style');

## 2.element의 계산된 스타일(계층화된 것을 포함한 실제 스타일) 가져오기
- getComputedStyle() : 계층화된 CSS(인라인,외부,브라우저 스타일시트가 계층화된 것)을 가져온다.
```javascript
var div = document.querySelector('div');

console.log(window.getComputedStyle(div).backgroundColor);
```
> 1.getComputedSTyle()메서드는 CSS 특수계층을 준수한다. <br>ex)인라인 스타일이 특수 계층의 최상위에 있어 코드가 겹칠경우 인라인 스타일값을 가져옴 <br> 2.읽기 전용이므로 값을 설정할수 없다.<br>3.색상 값을 원래 지정된 방식에 상관없이 rgb(#,#,#)형식으로 반환<br>4.속성 접근시 비단축 속성명을 사용해야함 ex: (~~margin~~ marginTop 사용)

## 3.class 및 id attribute를 사용하여 element의 CSS 속성 적용 및제거
```javascript
var div= document.querySelector('idv');

//설정 
div.setAttribute('id','bar');
div.classList.add('foo');
//제거
div.removeAttribute('id');
div.classList.remove('foo');
```