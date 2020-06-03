CREATE TABLE members(
    name varchar2(15),
    account varchar2(10),
    password varchar2(10),
    constraint member_PK PRIMARY KEY (account)
    );
    
    
    select * from members;