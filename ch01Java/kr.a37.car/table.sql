create table car(
 num number primary key,		--번호
 name varchar2(30) not null,	--이름
 color varchar2(30) not null,	--색상
 maker varchar2(30) not null,	--제조사
 price number(9) not null,		--가격
 reg_date date not null			--등록일
);
create sequence car_seq;