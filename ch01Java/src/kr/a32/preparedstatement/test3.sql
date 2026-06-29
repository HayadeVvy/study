create table test3(
 num number primary key,
 title varchar2(60) not null,
 name varchar2(30) not null,
 memo varchar2(4000) not null,
 email varchar2(30),
 reg_date date not null
);

create sequence test3_seq;