drop table mms_member;

create table mms_member(
    id number(6) primary key,
    name varchar2(12) unique not null,
    Addr varchar2(50) not null,
    nation varchar2(12) not null,
    email varchar2(30) not null,
    age number(3)
);

create sequence mms_seq;

select * from mms_member;