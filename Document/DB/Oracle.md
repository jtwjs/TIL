## Oracle

### 오라클 계정
>오라클을 설치하면 한 개 이상의 데이터베이스 권한을 갖는 디폴트 사용자가 존재한다.

- SYS : 오라클 Super 사용자 계정
    - 데이터베이스에서 발생하는 모든 문제들을 처리할수있는 권한을 갖음
- SYSTEM : 오라클 데이터베이스를 유지보수 관리할 때 사용하는 사용자 계정
    - SYS사용자와 차이점은 데이터베이스를 생성할 수 있는 권한이 없으면 불완전 복구를 할수 없다.
- SCOTT : 처음 오라클을 사용하는 사용자의 실습을 위해 만들어 놓은 연습용 계정
- HR : 오라클에 접근할 수 있도록 샘플로 만들어 놓은 사용자 계정

### account unlock 

```
alter user 계정명 account unlock;  -- 계정 unlock
alter user identified by 설정할패스워드  -- 비번설정
conn 계정명/패스워드  -- 연결
```

---
## SQL
> DBMS에게 질의하는 명령어 
### SQL 작성규칙
- SQL문은 특별히 표시하지 않는 한 대소문자를 구분하지 않는다.
- SQL문은 여러 라인에 걸쳐서 작성이 가능하고 가독성을 위해 들여쓰기를 하는것이 좋다.
- 키워드는 여러 행에 나누어 쓰거나 약어로 쓸 수 없다.
- 여러 컬럼을 검색할 때 쉼표로 컬럼을 구분한다.
- SELECT절에서 출력 결과에 표시할 순서대로 컬럼을 지정한다.
- SELECT결과 열 머리글(Heading)은 기본적으로 대문자로 표시된다.
- SQL명령어는 하나의 문장으로 구성되어야 하는데 여러개의 절이 모여서 문장이 되는것이고<br> 이러한 문장들은 반드시 세미콜론(;)으로 마쳐야 한다
### Data Type of Oracle

![오라클데이터타입](https://user-images.githubusercontent.com/60641307/79107822-0df38280-7db0-11ea-8c47-a9b14b10fa21.png)


- NUMBER : 숫자 데이터를 저장하기 위한 자료형
    - NUMBER(precision, scale)
    - precision: 소수점을 포함한 전체 자리수
    - scale: 소수점 이하 자리수, 생략시 반올림 후 정수값
    - 모두 생략하면 입력한 데이터 값만큼 공간 할당
- DATE : 세기,년,월,일,시간,분,초의 날짜 및 시간 데이터를 저장하기 위한 데이터형
    - 별다른 설정이 없으면 년,월,일만 제공

- CHAR : 고정 길이 문자 데이터를 저장하기 위한 자료형
    - 입력된 자료의 길이와 상관없이 정해진 길이만큼 저장영역 차지 최소 (1)
    - 편차가 심한 데이터를 입력할 경우 저장공간의 낭비를 초래
- VARCHAR2 : 가변적인 길이의 문자열을 저장하기 위해 제공
    - 저장되는 데이터에 의해 저장공간이 할당되므로 메모리 낭비를 막음
- ROWID : 테이블에서 행의 위치를 지정하는 논리적인 주소값이다.
    - ROWID는 DB에 저장되어 있지 않으며,DB데이터도 아니다
    - Tree-piece Format을 갖음
    - 테이블의 특정 레코드를 랜덤하게 접근하기 위해서 주로 사용
    - DB 전체에서 중복되지 않는 **유일값**으로 **테이블에 새로운 행이 삽입**되면<br>테이블 내부에서 의사컬럼 형태로 **자동적으로 생성**됨
- LOB : 2GB까지의 가변길이 바이너리 데이터를 저장시킬수있다.
    - IMG,EXE 파일을 저장할수 있다.
    - 테이블에서 행의 위치를 지정하는 논리적인 주소값이다.
    



- **DESC[RIBE] 테이블명** : 테이블 구조를 확인하는 명령어
    - DESC명령어는 테이블의 칼럼 이름, 데이터 형, 길이와 NULL 허용 유무<br> 등과 같은 특정 테이블의 정보를 알려줌
    - []: 대괄호는 생략가능

### 오라클 내장함수 [문자열함수]
|함수명|인자(입력값|리턴값|
|:------:|:------:|:-------------|
|LOWER|문자열|입력값을 소문자로 반환|
|UPPER|문자열|입력값을 대문자로 반환|
|INITCAP|문자열|입력값의 첫문자를 대문자로<br>나머지는 소문자로|
|LPAD|문자열1,n[문자열2]|문자열1의 좌측에 문자열2의 문자를 채워 <br>n자리로 만들어서 리턴|
|RPAD|문자열1,n[문자열2]|문자열1의 우측에 문자열2의 문자를 채워<br>n자리를 만들어서 리턴|
|SUBSTR|문자열,n[,m]|문자열의 n번째 문자부터 m개의 문자를 리턴|
|INSTR|문자열1,문자2|문자열1에서 문자2가 나오는 최초의 위치를 리턴|
|LTRIM|문자열[.SET]|문자열의 좌측부터 시작해서 SET문자열이 <br>안나올떄까지 문자를 삭제|
|RTRIM|문자열[.SET]|문자열의 우측부터 시작해서 SET문자열이 <Br>안나올떄까찌 문자를 삭제|
|SOUNDEX|문자열|지정한 단어와 발음이 동일한 문자열을 리턴|
|TRANSLATE|문자열,S1,S2|모든 S1을 S2로 치환 한 후 리턴|
|CHR|문자열|지정된수치와 일치하는 ASCII 코드를 리턴|
|ASCII|문자열|지정된 문자의 ASCII 코드값을 리턴|
|REPLACE|문자열,STR1,STR2|문자열에서 STR1을 모두 STR2로 치환후 리턴,<br>STR2를 입력하지 않으면 문자열에서 STR1을 모두삭제|
|CONTCAT|문자열1,문자열2|문자열1과 문자열2를 합쳐서 리턴|
|TRIM|LEADING/TRAINING/BOTH 혹은<br>트림할 문자열 + FROM 원문자열|trim(LEADING 트림할문자열 FROM 원본문자열)<br>:문장의 앞에서 트림할 문자열 제거<br>trim(TRAINING 트림할문자열 FROM원본문자열)<br>:문장의 위에서 트림<br>trim(BOTH 트림할문자열 FROM 원본문자열)<br>:양쪽에서 다 트림<br>TRIM(원본문자열):앞 뒤 공백을 제거<br>TRIM():null을 반환
|LENGTH|문자열|입력한 캐릭터셋으로 계싼한 문자열의 길이를 반환<br>바이트를 반환하고 싶으면 LENGTHB를 사용|

### 오라클 내장함수 [날짜함수]
- **SYSDATE**
    - 현재 날짜와 시간을 시스템 기준으로 얻어온다.(최소단위 1초)
    - 얻어온 숫자에 연산이 가능하다.
    - **TO_CHAR**: 숫자나 날씨를 문자형식으로 변환 해주는 것
        - 그 날짜를 조회할때 to char 형식으로 출력
    - **TO_DATE**: 숫자나 문자형식을 날짜형식으로 변환 해주는 것
        - 날짜를 넣어줄때 to date 형식 사용

- **사용법**
    - 기본 사용법 : 
        - SELECT SYSDATE <Br>FROM dual; (dual은 가상테이블)

    ```
    SELECT TO_DATE(SYSDATE, 'yyyy n dd') AS "현재시간" FROM DUAL;
    SELECT TO_CHAR(SYSDATE, 'RRRR-MM-DD HH24:MI:SS') AS "현재시간" From DUAL;
    SELECT TO_CHAR(SYSDATE-1, 'RRR-MM-DD HH24:MI:SS') AS "현재시간" FROM DUAL; --1일 전
    SELECT TO_CHAR(SYSDATE-1/24, 'RRRR-MM-DD HH24:MI:SS') AS "현재시간"  FROM DUAL; -- 1시간 전
    SELECT To_CHAR(SYSDATE-1/24/60, 'RRRR-MM-DD HH24:MI:SS') AS "현재시간" FROM DUAL; -- 1분 전

    -- 일(day) 구하기 ★★★
    SELECT TO_DATE('2017-11-10','YYYY-MM-DD') - TO_DATE('2017-09-12','YYYY-MM-DD') AS "day" FROM DUAL;

    ```
- YYYY와 RRRR의 차이점
    - TO_CHAR을 이용하여 뽑아오는것은 동일하나
    - TO_DATE를 이용해 DATE로 변형할떄는 다르다.

    - yy(00~99): 2000년대(21세기,현재세기)
    - yy(00~49): 2000년대(21세기,현재세기)
    - yy(50~99): 1900년대(20세기,직전세기)



### 오라클 내장함수 [숫자함수]
- ROUND
    - ROUND(n,m)함수는 반올림값을 반환한다.
    - n값을 반올림하고, m은 끊어줄 즉 보여줄 소수점
    
    ```
    SELECT ROUND(192.153) as BANOLIM from dual; //192;
    SELECT ROUND(192.153,1) as BANOLIM from dual; //192.2
    SELECT ROUND(192.153,-1) as BANOLIM from dual; //190
    SELECT ROUND(192.153,-2) as BANOLIM from dual; //200
    ```
- TRUNC
    - TRUNC(n,m)함수는 절사하여 값을 반환한다.
    - n값을 절사하고 m은 보여줄 소수점 자릿수
    - 절사란 반올림 내림 올림 이런거 없이 무조건 잘라내는것

    ```
    SELECT TRUNC(7.55992,2) AS "TRUNC" FROM DUAL; //7.55
    SELECT TRUNC(7.55992,-2) AS "TRUNC" FROM DUAL; //700
    ```

### 오라클 데이터타입 변환
> TO_[데이터타입]

![오라클형변환](https://user-images.githubusercontent.com/60641307/78874082-c6ef4f80-7a86-11ea-99c5-cae8c2d98450.png)

- TO_CHAR
    - 날짜형 혹은 숫자형을 문자형으로 변환
    
    |구분|설명|
    |:---|:---|
    |0|자릿수를 나타내며 자릿수가 맞지 않을 경우 0으로 채움|
    |9|자릿수를 나타내며 자릿수가 맞지 않아도 채우지 않음|
    |L|각 지역별 통화 기호를 앞에 표시|
    |.|소수점|
    |,|천 단위 자리 구분|
    - ex:) to_char(숫자데이터,'L999,999') 
- TO_DATE
    - 문자형을 날짜형으로 변환
- TO_NUMBER 
    - 문자형을 숫자형으로 변환


### 선택을 위한 DECODE 함수
> switch case 문과 같은 기능을 갖음

```
-- DECODE 함수의 기본 형식
DECODE (표현식,조건1,결과1,
              조건2,결과2,
              조건3,결과3,
              기본결과n
              )
```

### 조건에 따라 서로 다른 처리가 가능한 CASE 함수
> if else 구문과 같은 기능

```
CASE 표현식  WHEN=조건 THEN 결과
            WHEN=조건2 THEN 결과2
            WHEN=조건3 THEN 결과3
            WHEN=조건4 THEN 결과4
            ELSE 결과  --나머지 결과 
        END as 별칭
```