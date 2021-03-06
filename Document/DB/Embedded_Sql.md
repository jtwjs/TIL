## 내장(Embedded) SQL
>내장 SQL은 데이터베이스 내의 데이터를 정의하거나 접근하는 SQL문을 응용프로그램 내에 내포하여<br> 프로그램이 실행될 때 함꼐 실행되도록 호스트 프로그램 언어 에 삽입한 SQL이다.
### 내장 SQL 특징
- 내장 SQL문은 호스트 프로그램 언어에서 실행문이 나타날 수 있는 곳이면 프로그램의 어느 곳에서나 사용할 수 있다.
- 일반 SQL문은 실행 결과로 여러 개의 튜플을 반환하는 반면<br> 내장 SQL문은 실행 결과가 여러 개의 튜플이어도 맨 처음의 튜플 하나만을 반환함
- 내장 SQL문에 의해 반환되는 튜플은 일반 변수를 사용하여 저장할 수 있다.
- 내장 SQL문은 호스트 프로그램을 컴파일할 때 선행 처리기에 의해 분리되어 컴파일 된다.
- 호스트 프로그램 변수와 데이터베이스 필드의 이름은 같아도 된다
- 내장 SQL문의 호스트 프로그램 변수의 데이터 타입은 이에 대응하는 데이터베이스 필드의 SQL 데이터 타입과 일치하여야 한다.
- 내장 SQL문이 실행되면 SQL 실행 상태가 SQL 상태 변수에 전달된다.
### 내장 SQL과 호스트 언어의 실행문 구별
- **명령문의 구분**
    - C/C++에서 내장 SQL문은 "EXEC SQL"과 세미콜론(;) 문자 사이에 기술
    - 자바에서는 ```#SQL{<내장 SQL문>}; ```형식을 이용
- **변수의 구분**
    - 내장 SQL문에서 사용하는 호스트 변수는 변수 앞에 콜론(:) 문자를 붙인다.
    - 호스트 언어 내에서 호스트 변수는 콜론(:)없이 그대로 사용한다.
- **SQL 상태변수** 
    - 내장 SQL문이 실행된 후 SQLSTATE라는 묵시적 변수에 성공,실패,오류 등의 SQL문 결과를 문자열 값으로 전달함
    - SQLSTATE 값 = '00000' : 내장 SQL이 성공적으로 실행된것을 의미
    - SQLSTATE 값 = '02000' : 검색된 결과가 없다는 것을 의미
### 커서(Cursor)
>커서는 내장 SQL문의 실행 결과로 반환된 복수 개의 튜플들을 접근할 수 있도록 해주는 개념이다.
- 커서는 질의 실행 결과로 반환된 테이블의 튜플들을 순서대로 가리키는 튜플에 대한 포인터로 생각할수 있음
- 커서를 사용하여 질의 결과로 반환된 튜플들을 한 번에 하나씩 차례로 처리할 수 있다.
- **커서 관련 명령어**
    - DECLARE : 커서를 정의하는 등 커서에 관련된 선언을 하는 명령어
    - OPEN : 커서가 질의 결과의 첫 번째 튜플을 가리키도록 설정하는 명령어
    - FETCH : 질의 결과에 대한 튜플들 중 현재의 다음 튜플로 커서를 이동시키는 명령어
    - CLOSE : 질의 실행 결과에 대한 처리 종료시 커서를 닫기 위해 사용하는 명령어 
    