# 자바 API Document
- API(Application Programming Interface)
>API는 라이브러리(library)라고 부르기도 한다.<br>프로그래밍 개발에 자주 사용되는 클래스 및 인터페이스의 모음을 말한다.<br>
>이 API들은 <JDK 설치 경로> \jre\lib\rt.jar 라는 압축 파일에 저장되어 있다.

>API Document는 쉽게 API를 찾아 이용할 수 있도록 문서화한 것을 말한다.<br>API Document는 HTML페이지로 작성되어 있기 때문에 웹 브라우저를 열고 오라클에서 제공되는 다음 URL을 방문하면 볼 수 있다.
- [API Document](http://docs.oracle.com/javase/8/docs/api/)

>IDE (이클립스)에서 API Document를 볼수도 있다.
1. 자바 에디터에서 클래스를 마우스로 선택
2. [F1]키를 누르면 자동으로 API Document를 보여주는 Help 뷰가 실행됨

## java.lang과 java.util 패키지
>자바 애플리케이션을 개발할 때 공통적으로 가장 많이 사용하는 패키지는 **java.lang** 패키지와 **java.util** , **java.time** 패키지이다.

### java.lang 패키지
>자바 프로그램의 기본적인 클래스를 담고 있는 패키지<br>java.lang 패키지에 있는 클래스와 인터페이스는 import 없이 사용 가능

|**CLASS**|**PURPOSE**|
|:----------|:---------|
|**Object**|자바 클래스의 최상위 클래스로 사용|
|**System**|표준 입력 장치(키보드)로부터 데이터를 입력받을 때 사용<br>표준 출력 장치(모니터)로 출력하기 위해 사용<br>자바 가상 기계를 종료시킬 때 사용<br>쓰레기 수집기를 실행 요청할 때 사용|
|**Class**|클래스를 메모리로 로딩할 때 사용|
|**String**|문자열을 저장하고 여러가지 정보를 얻을 때 사용|
|**StringBuffer,StringBuilder**|문자열을 저장하고 내부 문자열을 조작할 때 사용|
|**Math**|수학 함수를 이용할 때 사용|
|**Wrapper**|기본 타입의 데이터를 갖는 객체를 만들 때 사용<br>문자열을 기본 타입으로 변환할 때 사용<br>입력값 검사에 사용|

#### Wrrapper class 
- Byte
- Shortf
- Character
- Integer
- Float
- Double
- Boolean
- Long


### java.util 패키지
>자바 프로그램 개발에 조미료 같은 역할을 하는 클래스를 담고 있다.<br>java.util 패키지는 컬렉션 클래스들이 대부분 차지하고 있다.

|**CLASS**|**PURPOSE**|
|:----------|:---------|
|**Arrays**|배열을 조작(비교,복사,정렬,찾기)할 떄 사용|
|**Calendar**|운영체제의 날짜와 시간을 얻을 때 사용|
|**Date**|날짜와 시간 정보를 저장하는 클래스|
|**Objects**|객체 비교, 널(null) 여부 등을 조사할 떄 사용|
|**StringTokenizer**|특정 문자로 구분된 문자열을 뽑아낼 때 사용|
|**Random**|난수를 얻을 때 사용|