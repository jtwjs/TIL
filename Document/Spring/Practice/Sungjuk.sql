CREATE TABLE SUNGJUK (
    hakbun varchar2(10),
    irum varchar2(15) not null,
    kor number(3) not null,
    eng number(3) not null,
    math number(3) not null,
    tot number(3),
    avg number(5,2),
    grade varchar2(4),
    constraint SUNGJUK_PK primary key(hakbun)
);

