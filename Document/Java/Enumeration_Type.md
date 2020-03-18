# enumeration type(열거 타입)
>**한정된 값만을 갖는 데이터 타입** [ex:) 요일:월,화,수,목,금 계절:봄,여름,가을,겨울]<br>**열거 상수중에서 하나의 상수를 저장하는 데이터 타입**이다.

## 열거 타입 선언
>열거 타입을 선언하기 위해서는 **먼저 열거 타입의 이름을 정하고 열거 타입의 이름으로 소스 파일(java)을 생성**해야 한다.
- **열거 타입**:public enum 키워드는 열거 타입을 선언하기 위한 키워드이다.

```java
Week.java
public enum Week {...}// 열거 타입이름은 소스 파일명과 대소문자가 모두 일치해야한다.
```
- **열거 상수**: 열거 타입의 값으로 사용되며, 관례적으로 모두 대문자로 작성
- 열거 타입을 이클립스에서 생성하는 방법  
    1. [File -> New -> Enum]을 선택
    2. [New Enum Type]대화상자의 [Package]입력란에 열거 타입이 속할 패키지명 입력
    3. [Name]입력란에는 열거 타입 이름 입력 후 [Finish]버튼 클릭

```java
public enum Week { MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY} //

//열거 상수가 여러 단어로 구성될 경우 언더바(_)로 처리한다.
public enum Week { LOGIN_SUCCESS,LOGIN_FAILED}
```

## 열거 타입 변수
>열거 타입도 하나의 데이터 타입이므로 변수를 선언하고 사용해야 한다.

```java
Week today;
Week reservationDay;
```
>열거 타입 변수를 선언했다면 열거 상수를 저장할 수 있다.<br>열거 상수는 단독으로 사용할 수 없고 반드시 열거타입 변수 = 열거타입.열거상수;로 사용된다.<br>**Week today=Week.SUNDAY;**

>위에서 생성되는 열거 상수도 열거 객체로 생성된다. 즉 참조 타입인 것이다.(null값 저장 가능)

- 참조 타입 변수는 객체를 참조하는 변수 == 열거 상수는 객체
 >열거 타입 Week의 경우 MONDAY부터 SUNDAY까지 열거 상수는 총 7개의 Week 객체로 생성된다. <br>그리고 메소드 영역에 생성된 열거 상수가 해당 Week 객체를 각각 참조하게 된다.
 
 ![enum](https://user-images.githubusercontent.com/60641307/76695096-4bd08e80-66be-11ea-8cbb-5a9a4da2a98a.png)

 >열거 타입 변수 today는 스택 영역에 생성된다. today에 저장되는 값은 Week.SUNDAY 열거 상수가 참조하는 객체의 번지이다. <br>따라서 열거 상수 Week.SUNDAY와 today변수는 서로 같은 Week 객체를 참조하게 된다.

 ![emum2](https://user-images.githubusercontent.com/60641307/76695103-73bff200-66be-11ea-80f1-cc6d043f2aa5.png)

>그렇기 때문에 today 변수와 Week.SUNDAY 상수의 == 연산 결과는 true가 된다. 

```java
import java.util.Calendar;

public class EnumWEekExample {
public static void main(String[] args) {
//Calendar now =Calendar.getInstance();
//int year = now.get(Calendar.YEAR); //년
//int month = now.get(Calendar.MONTH)+1; //월 (1~12)
//int day = now.get(Calendar.DAY_OF_MONTH);//일
//int week = now.get(Calendar.DAY_OF_WEEK);//요일 (1~7)
//int hour = now.get(Calendar.HOUR);//시간
//int minute = now.get(Calendar.MINUTE);//분
//int second = now.get(Calendar.SECOND);//초

	Week today = null;//열거 타입 변수 선언
	
	Calendar cal = Calendar.getInstance();
	int week = cal.get(Calendar.DAY_OF_WEEK);//일(1)~토(7)까지의 숫자리턴
	
	switch(week) {
	case 1:
		today = Week.SUNDAY; break;
	case 2:
		today = Week.MONDAY; break;
	case 3: 
		today = Week.TUESDAY; break;
	case 4: 
		today = Week.WEDNESDAY; break;
	case 5: 
		today = Week.THURSDAY; break;
	case 6:
		today = Week.FRIDAY; break;
	case 7: 
		today = Week.SATURDAY; break;
	}
	
	System.out.println("오늘 요일: " +today);
	if(today == Week.SUNDAY) {
		System.out.println("일요일에는 축구를 합니다.");
	}
	else {
		System.out.println("열심히 자바 공부 합니다.");
	}
}
}
```

## 열거 객체의 메소드
>열거 객체는 열거 상수의 문자열을 내부 데이터로 가지고 있다.<br>메소드는 java.lang.Enum 클래스에 선언된 메소드인데, 열거 객체에서 사용할 수 있는 이유는 모든 열거 타입은 컴파일 시에 Enum 클래스에 상속하게 되어 있기 떄문이다.

|리턴 타입|메소드(매개 변수)|설명|
|:-----|:--------|:-----------|
|String|name()|열거 객체의 문자열을 리턴|
|int|ordinal()|열거 객체의 순번(0부터 시작)을 리턴|
|int|compareTo()|열거 객체를 비교해서 순번 차이를 리턴|
|열거 타입|valueOf(String name)|주어진 문자열의 열거 객체를 리턴|
|열거 배열|values()|모든 열거 객체들을 배열로 리턴|

- **name()** 메소드
>열거 객체가 가지고 있는 문자열을 리턴<br>리턴되는 문자열은 열거 타입을 정의할 때 사용한 상수 이름과 동일하다.

```java
Week today = Week.SUNDAY;
String name = today.name();
//name() 메소드는 열거 객체 내부의 문자열인 "SUNDAY"를 리턴하고 name 변수에 저장한다.
```

- **ordinal()** 메소드
>전체 열거 객체 중 몇 번째 열거 객체인지 알려준다. <br>열거 객체의 순번은 열거타입을 정의할 때 주어진 순번을 말하는데, 0부터 시작한다.

```java
WEek today = Week.SUNDAY;
int ordinal = today.ordinal();
```
- **compareTo()** 메소드
>매개값으로 주어진 열거 객체를 기준으로 전후로 몇 번쨰째 위치하는지를 비교한다.<br>만약 열거 객체가 매개값의열거 객체보다 순번이 빠르다면 음수, 순번이 늦다면 양수가 리턴된다.

```java
Week day1 = Week.MONDAY;
Week day2 = Week.WEDNESDAY;
int result1 = day1.compareTo(day2); // MONDAY는 열거위치가 1,WEDNESDAY는 3; 결과 = 1-3 = -2
int result2 = day2.compareTo(day1);// WEDNESDAY 3, MONDAY 1 결과 3-1 =2
```

- **valueOf()** 메소드
>매개값으로 주어지는 문자열과 동일한 문자열을 가지는 열거 객체를 리턴한다. <br>이 메소드는 외부로부터 문자열을 입력받아 열거 객체로 변환할떄 유용하게 사용한다.

```java
Week weekDay = Week.valueOf("SATURDAY");
```

- **values()** 메소드
>열거 타입의 모든 열거 객체들을 배열로 만들어 리턴한다.

```java
Week[] days = Week.values();
for(Week day : days){
    System.out.println(day);
}
```
>Week 배열의 인덱스는 열거 객체의 순번과 같고 각 인덱스 값은 해당 순번의 열거 객체 번지이다.


```java
public class EnumMethodExample{
    public static void main(String[] args){
        //name() 메소드
        Week today = Week.SUNDAY;
        String name = today.name();//객체의 문자열을 리턴
        System.out.println(name); 

        //ordinal() 메소드
        int ordinal = today.ordinal();//객체의 순번(인덱스)을 리턴 (0부터 시작)
        System.out.println(ordinal);

        //compareTo() 메소드
        Week day1 = Week.MONDAY;
        Week day2 = Week.WEDNESDAY;
        int result1 = day1.compareTo(day2);//객체의 순번을 비교 
        int result2 = day2.compareTo(day1);
        System.out.println(result1);
        System.out.println(result2);

        //valueOf() 메소드
        if(args.length == 1){
            String strDay = args[0];
            Week weekDay = Week.valueOf(strDay);//매개값으로 주어지는 문자열과 동일한 문자열 가지는 열거객체를 리턴
            if(weekDay == Week.SATURDAY || weekDay == Week.SUNDAY){
                System.out.println("주말 입니다.");
            }else{
                System.out.println("평일 입니다.");
            }ㅏ;
        }

        //values() 메소드
        Week[] days = Week.values();//열거 타입의 모든 열거 객체들을 배열로 리턴
        for(Week day : days){
            System.out.println(day);
        }
    }
}
```
## 열거형 상수를 다른 값과 연결하기
>열거형 상수와 관련된 값을 생성자를 통해 연결시킨 경우 세미콜론(;)을 붙여야함

1. 각각의 열거 상수 뒤에 연관 값을 기술
    - 열거 상수와 다른 구성요소를 구분하는 세미콜론 붙임
2. 연관 값을 저장할 필드 선언
    - **final private** :반드시 써야하는 키워드
3. 생성자의 선언
4. 메소드의 선언

```java
enum Season{
    //1단계 열거 상수 뒤에 연관 값을 기술
    SPRING("봄"),SUMMER("여름"),FALL("가을"),WINTER("겨울"); //;반드시 붙임
    final private String name; //2단계 연관 값을 저장할 필드 선언
    Season(String name){//3단계 생성자 선언
        this.name=name;
    }
    String value(){ //4단계 메소드선언
        return name;
    }
}
```