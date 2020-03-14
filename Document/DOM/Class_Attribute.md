# Class Attribute 

## 1.Class attribute 값 리스트 얻기
- classList : 유사 배열 컬렉션 ,읽기 전용인 length 속성을 가짐 
<br> 읽기 전용이지만 add(), remove(), contains(), toggle() 메서드를 사용해서 변경가능

## 2.Class attribute에 하위 값 추가 및 제거
- classList.add() : 클래스 속성 추가
- classList.remove() : 클래스 속성 제거 

## 3.Class attribute 값 토글
- classList.toggle() : 값이 누락된 경우 추가, 값이 이미 있는 경우 제거 

## 4.Class attribute 값이 특정 값을 가지고 있는지 판별
- classList.contains() : 특정 하위 값을 가지고 있는지 판별 (true/false) 