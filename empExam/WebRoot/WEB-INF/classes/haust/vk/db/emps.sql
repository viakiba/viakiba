--oracle

create table emps(
	id varchar2(40) primary key,
	username varchar2(10) not null,
	salary number(10,2) not null,
	hiredate date not null
);

desc emps;

select * from emps;

insert into emps(id,username,salary,hiredate) 
values('e37dae83-105b-4e27-9254-b208b0ae3cc8','¹þ¹þ',7000,to_date(sysdate));

