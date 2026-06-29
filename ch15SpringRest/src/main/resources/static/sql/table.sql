create table todo(
 id number not null,
 todo varchar2(3000) not null,
 completed number(1) default 0 not null,
 created date default sysdate not null,
 constraint todo_pk primary key (id)
);
create sequence todo_seq;