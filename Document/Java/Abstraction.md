# Abstraction (추상화)
>객체에서 공통된 속성과 행위를 추출하는것

## Abstract class (추상클래스)
1. abstract method(미완성 메소드)를 포함하고 있는 클래스
     - 선언부만 있고 구현부가 없는 메소드
2. 추상클래스는 인스턴스를 생성할 수 없다.
3. 추상클래스를 상속받는 자식클래스에서 abstrac method를 완성해야한다.
4. 코드의 공통적인 부분을 제시하고 표준화하기 위한 용도로 활용된다.

## 용도
1. 실체 클래스들의 공통된 필드와 메소드의 이름을 통일할 목적
2. 실체 클래스를 작성할 때 시간을 절약

## 추상 메소드와 오버라이딩
>추상 메소드는 추상 클래스에서만 선언할 수 있는데, 메소드의 선언부만 있고 메소드 실행 내용인 중괄호{}가 없는 메소드를 말한다.

>자식 클래스는 반드시 추상메소드를 Overriding(재정의)해서 실행 내용을 작성해야 한다. 
## 추상 클래스와 인터페이스의 차이

 ||Abstract Class|Interface|
 |:-----:|:-------:|:-------:|
 |**비유**|유전자<br>DNA 물려받는것|사교적인 관계|
 |**목적**|상속을강제|설계도/약속|
 |**키워드**|abstract class/extends|interface/implement|
 |**인스턴스화**|X|X|
 |**상속**|단일상속|다중상속|