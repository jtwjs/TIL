CREATE Table people(
    id varchar2(10),
    name varchar2(20),
    job varchar2(20),
    address varchar2(40),
    bloodtype varchar2(2),
    constraint people_PK primary key(id)
    );
    
    
    update people set name='ȫ����', job='���ػ�', address='����',bloodtype='AB'
    where id='zkfna123';
    update people set name=,job=#{job},address=#{address},bloodtype=#{bloodtype} where id=#{id}