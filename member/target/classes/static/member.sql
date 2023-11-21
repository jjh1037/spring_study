use koreaitdb;

create table member(
id int not null auto_increment,
userid varchar(20) not null,
passwd varchar(20) not null,
username varchar(10) not null,
regdate date,
primary key(id)
);