
use koreaitdb;

-- 기본 정렬은 id
CREATE TABLE temp(
id int not null auto_increment,
subject varchar(255),
grp int, -- 게시물 그룹화
seq int, -- 그룹화한 자료를 2차 정렬
depth int, -- 들여쓰기
primary key(id)
);

INSERT INTO temp VALUES(NULL, '1번째 게시물', 1, 1, 1);
INSERT INTO temp VALUES(NULL, '2번째 게시물', 2, 1, 1);
INSERT INTO temp VALUES(NULL, '3번째 게시물', 3, 1, 1);

INSERT INTO temp VALUES(NULL, '[철수의-2번답글] 2번째 게시물', 2, 1, 2);
INSERT INTO temp VALUES(NULL, '[영희의-2번답글] 2번째 게시물', 2, 2, 2);

INSERT INTO temp VALUES(NULL, '[철수의 답글에 대한 답글] 2번째 게시물', 2, 1, 3);

INSERT INTO temp VALUES(NULL, '[홍길동의-1번답글] 1번째 게시물', 1, 1, 2);
INSERT INTO temp VALUES(NULL, '[코리아의-1번답글] 1번째 게시물', 1, 2, 2);

SELECT * FROM temp ORDER BY grp DESC, seq ASC;

use koreaitdb;

create table board(
id int not null auto_increment,
subject varchar(255) not null,
writer varchar(10) not null,
content text,
visit int,
regdate date,
orgName varchar(255),
savedFileName varchar(255),
savedFilePathName varchar(255),
savedFileSize bigint,
folderName varchar(10),
ext varchar(20),
grp int,
seq int,
depth int,
primary key(id)
);

-- 검색 : 조건(where)
-- subject
SELECT count(*) FROM board WHERE subject = '코리아아이티 게시판'
ORDER BY id DESC;

-- writer
SELECT count(*) FROM board WHERE writer = '관리자'
ORDER BY id DESC;

-- content 유사어 검색
SELECT count(*) FROM board WHERE content LIKE '%비서실%'
ORDER BY id DESC;


SELECT writer FROM board WHERE writer = '관리자';

WHERE content LIKE '%서비스%'

SELECT content FROM board WHERE content LIKE '%비서실%';



SELECT * FROM board WHERE content LIKE '%서비스%'
