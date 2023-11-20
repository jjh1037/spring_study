use koreaitdb;

create table dept(
dept_code char(3) not null,
dept_name varchar(20) not null,
primary key(dept_code)
);

INSERT INTO dept VALUES('100', '인사과');
INSERT INTO dept VALUES('200', '자재과');

SELECT * FROM dept ORDER BY dept_code ASC;