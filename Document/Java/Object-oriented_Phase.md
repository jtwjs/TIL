# Object-Oriented Phase(객체지향 개발 단계)
>일반적으로 널리 사용되고 있는 분석,설계,구현 단계로 분리한다.

## 1. Object-Oriented Analysis: OOA(객체지향 분석)
>문제를 정의하고 이 정의로부터 모형(Model)들을 제작하여 실세계(real-world)의 중요한 특성들을 보여주는 단계이다.
1. **Object model(객체 모형)**: 객체들과 그 특성을 식별하여 객체들의 정적 구조(static structure)와 그들간의 관계(interface)를 보여주는 **객체 다이어그램(object diagram)**을 작성한다.
2. **Dynamic model(동적 모형)**: 시간 흐름에 따라 시스템의 변화를 보여주는 **상태 다이아그램(state diagram)**을 작성한다. 실시간(real-time)시스템에서는 반드시 필요
3. **Function model(기능 모형)**: 시스템 내에서 데이터 값이 변하는 과정을 보여주는 것으로 잘 알려진 자료 흐름도 (DFD)가 사용된다.

## 2. Object-Oriented Design: OOD(객체지향 설계)
- **System design(시스템 설계)**: 시스템의 구조를 서브시스템으로 분해한다. 이 과정중에서 성능 최적 방안,문제 해결 전략, 자원 분배 등이 확정된다.
- **Object design(객체 설계)**: 구현에 필요한 상세한 내역을 설계 모형으로 제작하고 상세화된다. 구체적인 자료구조와 알고리즘들이 정의된다.

## 3. Object-Oriented Programming: OOP(객체지향 구현)
> 설계 모형을 특정 프로그램 언어로 번역하는 작업이다. 객체,클래스,상속의 개념을 다 포용하는 객체지향 언어(object-oriented programming language)가 가장 좋지만 객체의 개념만 인정하고 클래스,상속 등은 고려하지 않은 객체기반 언어(object-oriented based programming language)도 좋다. 또한, 일반적인 구조적 프로그래밍 언어(structured programming language)도 객체지향 개발에 활용될 수 있는가 하면 객체 지향 데이터베이스 관리시스템(OODBMS)이 개발의 도구로 이용될 수도 있다. 객체지향의 초기개념은 프로그래밍 언어로부터 시작됬으나 이젠 실세계를 바라보는 새로운 시각으로 그 중요성이 변화되고 있으며 개발언어에 너무 종속될 필요없다.