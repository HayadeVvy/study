create table test4(
 num number primary key,
 subject varchar2(60) not null,
 name varchar2(30) not null,
 content varchar2(4000) not null,
 email varchar2(30),
 reg_date date default sysdate not null
);

create sequence test4_seq;