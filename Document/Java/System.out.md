# 출력문
- System.out.출력함수 

## 출력함수
1. print
2. println
3. printf

## printf(print format) 형식을 갖춘 출력

### 특수문자 출력가능
- \a : alert 경고음(비프음) 소리
- \b : 백스페이스 BackSpace
- \f : 폼 피드 FormFeed
- \n : 개행 newLine (줄바꿈)
- \r : 캐리지 리턴 (줄의 맨처음으로 이동)
- \t : 수평탭 (tab만큼 이동)
- \v : 수직탭 
- \\ : 백슬래시 \
- \' : 작은따옴표
- \" : 큰따옴표
### 서식지정 가능
>출력의 형태를 지정한다는것을 의미.(문자열 안의 숫자 삽입)
```java
int age = 26;
System.out.printf("나는 %d살이며 16진수로 %x살입니다.",age,age);
```
- %c : 단일문자(숫자가 들어오면 아스키코드값으로 인식)
- %d : 부호가 있는 10진 정수
- %s : 문자열
- %f : 부호 있는 실수
### 필드 폭을 지정하여 출력가능
- %@d : 필드 폭을 @칸확보 오른쪽정렬
- %-@d: 필드 폭을 @칸확보 왼쪽정렬
- %+@d: 필드 폭을 @칸확보 오른쪽정렬 양수는+,음수는- 붙여 출력


![printf](https://user-images.githubusercontent.com/60641307/75304860-af1d8c80-5887-11ea-94b7-724abad0fa52.jpg)

