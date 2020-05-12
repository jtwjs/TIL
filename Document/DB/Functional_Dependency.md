## Functional Dependency (함수적 종속)
>**데이터의 의미를 표현**하는 것으로, **현실 세계를 포현하는 제약 조건이 되는 동시에 데이터베이스에서 항상 유지되어야 할 조건**이다.
```
어떤 테이블 R에서 X와 Y를 각각 R의 속성 집합의 부분 집합이라 하자. 
속성 X의 값 각각에 대해 시간에 관계없이 항상 속성 Y의 값이 오직 하나만 연관되어 있을 때
Y는 X에 함수적 종속 또는 X가 Y를 함수적으로 결정한다고 하고 X→Y로 표기한다.
```
- **X→Y의 관계**를 갖는 X와 Y에서 **X를 결정자(Determinant)**라 하고 **Y를 종속자(Dependent)**라고 한다.
### 함수적 종속 다이어그램
>한 테이블에 존재하는 속성들 간의 **복잡한 함수적 종속 관계를 그림으로 쉽게 표현**할 수 있는데, <br>이것을 **함수적 종속 다이어그램**이라고 한다.
- **완전 함수적 종속** 
    - 어떤 속성이 기본키에 대해 완전히 종속적일 때를 말한다.
- **부분 함수적 종속**
    - 기본키(복합키)의 일부인 속성에 의해서 값이 결정되는 것