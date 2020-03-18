# 알쓸잡 Method

## String관련 Method

### 1. toUpperCase() , toLowerCase()
>영문자를 전부 대문자 또는 소문자로 변환
1. toUpperCase(): 대상 문자열을 모두 **대문자로 변환**한다.

```java
String str1 = "hello java";

System.out.println(str1.toUpperCase());
//"HELLO JAVA" 출력
```
2. toLowerCase(): 대상 문자열을 모두 **소문자로 변환**한다.

```java
String str2 = "UPPER CASE TO LOWER CASE";

System.out.println(str2.toLowerCase());
//"upper case to lower case" 출력
```

## 2. trim()
>대상 문자열의 앞/뒤 공백문자를 모두 제거하여 리턴해준다.

```java
String str4 = "  공 백 제거  ";
System.out.println("["+str4+"]");
//[  공 백 제거  ]출력
System.out.println("["+str4+"]");
//[공 백 제거]출력 
//문자열 중간에 있는 공백 문자는 제거되지 않는다.
```
