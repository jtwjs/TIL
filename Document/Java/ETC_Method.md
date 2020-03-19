# 알쓸잡 Method
- **String 클래스**
    - [String class](#String-class)
    - [StringBuilder class](#StringBuilder-class)
    - [StringTokeniszer class](#StringTokenizer-class)
- **Calender 클래스**
    - [Calendar class](#Calendar-class)
- **Math 클래스**
    - [Math class](#Math-class)
- **Rnadom 클래스**
    - [Random class](#Random-class)




## String class
>같은 프로그램에서 사용된 똑같은 문자열 리터럴은 하나의 String 객체만 만들어서 공유한다.
### String class Method
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

### 2. trim()
>대상 문자열의 앞/뒤 공백문자를 모두 제거하여 리턴해준다.

```java
String str4 = "  공 백 제거  ";
System.out.println("["+str4+"]");
//[  공 백 제거  ]출력
System.out.println("["+str4+"]");
//[공 백 제거]출력 
//문자열 중간에 있는 공백 문자는 제거되지 않는다.
```

### 3. concat(String str)
>문자열 뒤에 파라매터 문자열을 **연결**

### 4. replace(char oldChar, char newChar)
>문자열에 포함된 oldChar을 모두 newChar로 교체

### 5. substring()
>부분 문자열(substring)을 추출 
- (int parameter) : parameter 1개인 경우 parameter value부터 시작해서 마지막 인덱스까지 추출
- (int parameter,int parameter) : parameter 2개인 경우 두번째 paramete의 앞에 인덱스 까지 추출

## StringBuilder class
>String객체와 String객체를 더하는(+)행위는 메모리 할당과 메모리 해제를 발생시키며<br> 더하는 연산이 많아진다면 성능적으로 좋지 않다.그래서 나온 것이 StringBuilder이다. <br>String과 문자열을 더할 때 새로운 객체를 생성하는 것이 아니라 기존의 데이터에 더하는 방식을 <br>사용하기 떄문에 속도도 빠르고 상대적으로 부하가 적다.
1. String클래스의 생성자의 사용 방법이 같다.
2. String클래스의 메소드의 기능과 사용 방법도 같다.

### append(String str)
>문자열 뒤에 파라매터 문자열을 **덧붙임**

### insert(int offset, String str)
>문자열의 offset 위치에 str을 삽입

### delete(int start, int end)
>start부터 end -1까지의 부분 문자열을 삭제

### deleteCharAt(int index)
>index 위치에 있는 하나의 문자를 삭제


## StringTokenizer class
>문자열로부터 **token**을 추출하는 기능이 있는 클래스
- **token** : 문자열을 구성하는 단위

```java
//토큰을 추출할 문자열을 가지고 StringTokenizer 객체를 생성한다.
StringTokenizer stok = new StringTokenizer("사과 배 복숭아");

str1 = stok.nextToken(); //첫 번째 토큰인 "사과"를 리턴
str2 = stok.nextToken(); //두 번째 토큰인 "배"를 리턴
str3 = stok.nextToken(); //세 번째 토큰인 "복숭아"를 리턴
```

- NoSuchElementException이 발생하지 않게 하려면
>hasMoreTokens() 메소드 사용

```java
while(stok.hasMoreTokens()) { //토큰이 있는 동안만 while문 안에서
    str = stok.nextToken();    //토큰을 추출하여
    System.out.println(str);    // 처리합니다.
}
```
- 구획 문자(delimeter) 지정하기

```java
stok = new StringTokenizer("사과,배,복숭아",",");//token 4개
//이문자열에 있는 콤마(,)를 가지고 토큰을 추출하는
// StringTokenizer객체를 생성한다.
```

- 여러 개의 구획 문자(delimeter) 지정하기

```java
stok = new StringTokenizer("사과,배|복숭아",",|"):
//이 문자열에 있는 콤마(,)와 수직선(|)을 가지고 토큰을 추출하는 
//StringTokenizer 객체를 생성한다.
```

- 구획 문자(delimeter)도 토큰으로 추출하기

```java
stok = new StringTokenizer("사과=10|초콜렛=3|샴페인=1","=|",true);
//토큰을 추출할 문자열,
//구획문자,
//구획문자도 토큰으로 추출하도록 만드는 true 파라미터
```

## Calender class
- 시스템 시계(System.clock)
    - 컴퓨터에 내장되어 있는 현재 시각을 가리키는 시계
    - 배터리로 작동: 항상 현재 시각을 가리킴
    - '1970년 1월 1일 00:00:00 GMT'를 기점으로 하는 밀리세컨드 단위로 시각표시
- Calendar 클래스와 GregorianCalendar 클래스
    - 시스템 시계로부터 현재 시각을 읽어오는 기능으 ㅣ클래스
### Calendar 클래스
>날짜와 시간 계산에 필요한 **일반적인 기능만을 제공**
### GregorianCalendar 클래스
>널리 사용되는 양력을 계산하는 클래스
- 사용방법

```java
//시스템 시계로부터 현재 시각 읽어오기
GregorianCalendar calendar = new GregorianCalendar();

//GregorianCalendar 객체로부터 년월일시분초 얻어내기
int year = calendar.get(Calendar.YEAR);//연도 리턴
int month = calendar.get(Calendar.MONTH);//월 리턴
int date = calendar.get(Calendar.DATE);//일 리턴
int amPm = calendar.get(Calendar.AM_PM);//오전/오후 구분을 리턴
int hour = calendar.get(Calendar.HOUR);//시 리턴
int min = calendar.get(Calendar.MINUTE);//분 리턴
int sec = calendar.get(Calendar.SEC;//초 리턴
```

### 시간대(time zone)
- 시간대 : 동일 시각을 사용하는 지구상의 구역
- 컴퓨터가 사용하는 시간대는 운영체제에서 설정 가능

#### 시간대 설정하기
- GregorianCalendar 클래스의 setTimeZone 메소드 호출
    - setTimeZone() 메소드
```java
//▼ GregorianCalendar 객체
calendar.setTimeZone(timeZone);
                    //▲ TimeZone 객체
```
- TimeZone 객체를 얻는 방법
    - getTimeZone() 메소드

```java
                                           //▼ 이 문자열에 해당하는
TimeZone timeZone = TimeZone.getTimeZone("Europe/London");
                            // ▲ TimeZone 객체를 찾아서 리턴하는 메소드
```
### 특정 날짜와 시간 표현햐기
> GregorianCalendar 클래스의 생성자 파라미터를 이용

```java
calendar1 = new GregorianCalendar(2007,7,1);
calendar2 = new GregorianCalendar(2007,7,1,14,30);
calendar3 = new GregorianCalendar(2007,7,1,14,30,15);
                                //년도,월,일,시,분,초
```
### 날짜와 시간을 포맷하는 클래스
- **DateFormat 클래스**
    - 날짜와 시각의 포맷 기능을 제공하는 클래스
    - **추상 클래스**이므로 직접 사용은 불가능
- **SimpleDateFormat 클래스**
    - DateFormat 클래스의 서브클래스
    - 추상 클래스가 아니므로 직접 사용 가능

- **사용 방법**

```java
//1. 생성자 파라미터로 날짜와 시간의 포맷을 넘겨준다.
dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 aa hh시 mm분 ss초");
                                    // ▲ 날짜와 시간의 포맷에 사용되는 문자열 패턴
                                    // a => 오전/오후                    

//2. format 메소드를 호출한다.
            // ▼이 객체가 가지고있는 시각정보와
Date date = calendar.getTime();
                     // ▲똑같은 날짜와 시간을 갖는
                    // Date 객체를 만들어서 리턴하는 메소드
            // ▼ SimpleDateFormat 객체
String str = dateFormat.format(date);
                             // ▲ 날짜와 시간 정보를 담고있는 객체

// 날짜&시간을 특정 시간대로 포맷하는 방법                        
//format메소드를 호출하기 전에 setTimeZone 메소드를 호출하면 된다.
dateFormat.setTimeZone(timeZone);
                      // ▲ TimeZone 클래스의 객체
```

>**Ex:)**
```java
public class DateFormatExample2 {
public static void main(String[] args) {
	GregorianCalendar calendar = new GregorianCalendar();
	SimpleDateFormat dateFormat =
			new SimpleDateFormat("yyyy년 MM월 dd일 aa hh시 mm분 ss");
	dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
	String str = dateFormat.format(calendar.getTime());
	System.out.print(str);
}
}

```
## Math class
>수학에서 많이 사용되는 함수를 제공하는 클래스

## Random class
>난수 발생 기능만을 제공하는 클래스

```java
//파라미터를 받지 않는 생성자
Random random = new Random();
//현재의 시간을 초기값으로 하는 난수발생


//long타입의 파라미터를 받는 생성자
Random random = new Random(5109091L);
//seed값을 초기값으로 난수 발생 = 매번 동일한 난수 발생
```
1. Random 클래스의 객체를 생성한다.
2. 생성된 객체에 대해 난수 발생 메소드를 호출한다.

### Method of Random class

|Method|Explain|
|:-----|:-----|
|int nextInt()|int 타입 난수를 리턴|
|long nextLong()|long 타입 난수를 리턴|
|float nextFloat()|0 이상 1 미만의 float 타입 난수를 리턴|
|double nextDouble()|0 이상 1 미만의 double 타입 난수를 리턴|
|boolean nextBoolean()|true와 false중 한 값을 랜덤하게 리턴|
|int nextInt(int n)|0 이상 n 미만의 int 타입 난수를 리턴|
|void nextBytes(byte[] arr)|파라미터로 주어진 배열을 난수로 채움|
|double nextGuaussian()|평균 0.0, 표준편차 1.0으로 정규분포된 난수를 리턴|