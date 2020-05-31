create table nike_member (
    firstName varchar2(10) not null,
    lastName varchar2(10) not null,
    account varchar2(10),
    password varchar2(10) not null,
    constraint nike_member_PK primary key(account)
);

desc nike_member;

create table member (
    memId varchar2(10),
    memPw varchar2(10),
    memMail varchar2(10),
    memPurcNum number(10),
    
    primary key(memId)
    );