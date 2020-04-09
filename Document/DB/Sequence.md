## Sequence
>시퀸스란 자동으로 순차적으로 증가하는 순번을 반환하는 데이터베이스 객체이다.

- PK 값에 중복값을 방지하기 위해 사용

```
ex:) 게시판에 글이 하나 추가될때마다 글번호(PK)가 생기는 경우 만약 100번까지 글 번호가 생성되어있다면 그 다음 글이 추가 되었을 경우 글번호가 101으로 하나의 ROW를 생성해주어야 한다. 이때 101이라는 숫자를 얻으려면 기존 글번호중 가장 큰 값에 +1을 하는 로직을 어딘가 넣어야 하는데 시퀸스는 이러한 로직없이 데이터베이스에 ROW가 추가될때마다 자동으로 +1 시켜준다.
```

### 시퀸스 생성
- 문법

```
CREATE SEQUENCE [시퀸스명]
INCREMENT BY [증감숫자] // 증감숫자가 양수면 증가, 음수면 감소, 디폴트는 1
START WITH [시작숫자] //시작숫자의 디폴트값은 증가일때 MINVALUE 감소일떄 MAXVALUE
NOMINAVALUE OR MINVALUE [최솟값] // 
-- NOMINVALUE : 디폴트값 설정. 증가일때 1, 감소일때 -1028
-- MINVALUE : 최소값 설정, 시작숫자와 작거나 같아야하고 MAXVALUE보다 작아야함
NOMAXVALUE OR MAXVALUE [최대값] //
-- NOMAXVALUE : 디폴트값 설정, 증가일때 1027, 감소일때 -1
-- MAXVALUE : 최대값 설정, 시작숫자와 같거나 커야하고 MINVALUE보다 커야함

CYCLE OR NOCYCLE // CYCLE 설정시 최대값에 도달하면 최소값부터 다시시작 
                 // NOCYCLE 설정시 최대값 생성 시 시퀸스 생성중지
CACHE OR NOCACHE // CACHE 설정시 메모리에 시퀸스 값을 미리 할당
                 // NOCACHE 설정시 시퀸스값을 메모리에 할당하지않음
```
- 예제

```
CREATE SEQUENCE EX_SEQ // 시퀸스이름 EX_SEQ
INCREMENT BY 1 //증감숫자 1
START WITH 1 //시작숫자 1
MINVALUE 1 //최소값 1
MAXVALUE 1000 //최대값 1000
NOCYCLE //순환하지않음
CACHE; //메모리에 시퀸스값 미리할당

//EX_SEQ라는 시퀸스 1부터시작해서 1000까지 1씩증가하는 시퀸스
//Cache를 사용하여 시퀸스값의 액세스 효율이 Cache를 사용하지않을때보다 증가
```

### 시퀸스 사용예시

```
//TEST 테이블 생성
CREATE TABLE EX_TABLE (BOARD_NUM NUMBER(19,16) NOT NULL);

//EX_SEQ 시퀸스로 TEST테이블에 데이터를 넣는다.
INSERT INTO EX_TABLE(BOARD_NUM) VALUES(EX_SEQ.NEXTVAL);
INSERT INTO EX_TABLE(BOARD_NUM) VALUES(EX_SEQ.NEXTVAL);
INSERT INTO EX_TABLE(BOARD_NUM) VALUES(EX_SEQ.NEXTVAL);

//시퀸스명.NEXTVAL을 사용하면 해당 시퀸스에 다음 순번 값을 자동으로 져옴

```

### 시퀸스 조회

```
SELECT EX_SEQ.CURRVAL FROM DAUL //해당 시킨스 값 조회
SELECT * FROM USER_SEQUENCES //전체 시퀸스 조회
```

### 시퀸스 수정
시퀸스는 DDL문이므로 ALTER문을 사용하여 수정이 가능하다.<br>
시작값은 수정이 불가능, 현재들어있는 값보다 높은 최소값(감소 시퀸스일경우 그 반대)으로도 설정불가

- 문법
    
```
ALTER SEQUENCE [시퀸스명]
INCREMENT BY [증가값]
NOMINVALUE OR MINVALUE [최소값]
NOMAXVALUE OR MAXVALUE [최대값]
CYCLE OR NOCYCLE [사이클 설정 여부]
CACHE OR NOCACHE [캐시 설정 여부]    
```

- 예제

```
ALTER SEQUENCE EX_SEQ
INCREMENT BY 2
MINVALUE 2
MAXVALUE 10000
CYCLE
NOCACHE;
```

### 시퀸스 삭제

```
DROP SEQUENCE [시퀸스명] //삭제 

DROP SEQUENCE EX_SEQ
```

