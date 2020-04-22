create table project(
	no int auto_increment primary key,
	name varchar(30),
	content text,
	startDate date,
	endDate date,
	status char(1) #r- ready, e - execute, f - finish, p - pending
);

drop table project;

desc project;
select * from project;

select * from project;
delete from project where no  = 3;
