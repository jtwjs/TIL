## Create(테이블 생성)

```
CREATE TABLE EX_TABLE
(
    COMPANY VARCHAR(7) NOT NULL,
    DEPT VARCHAR(20) DEFAULT '미정' NOT NULL,
    TP VARCHAR(20),
    USER_ID VARCHAR(20) NOT NULL,
    TODAY DATE DEFAULT SYSDATE NOT NULL
);
```

- VARCHAR | NUMBER | DATE
    - 각 칼럼의 속성
    - VARCHAR 문자형
    - NUMBER 숫자형
    - DATE 날짜형
    - 괄호안의 숫자는 컬럼의 SIZE
- DEFULAT
    - ROW를 생성할 시 컬럼에 기본으로 들어가는 값을 지정
- NOT NULL
    - ROW에 데이터가 없을시 추가가 되지 않도록 설정
- SYSDATE
    - 현재 날짜를 뜻함