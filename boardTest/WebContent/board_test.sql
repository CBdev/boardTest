create table board_test(
	idx int not null auto_increment primary key,
	title varchar(200) not null,
	writer varchar(20) not null,
	regdate varchar(20) not null,
	count int not null,
	content text not null,
	regip varchar(30) not null,
	filename varchar(200)
);

desc board_test;
select * from board_test;

alter table board_test modify regdate DATETIME DEFAULT CURRENT_TIMESTAMP;

insert into board_test values (default,'테스트1','우희재','2018-08-20',5,'내용내용내용','121212','filename1.jpg');


--Cannot create PoolableConnectionFactory (null, message from server: "Host 'sjh-PC' is not allowed to connect to this MySQL server")

--해결

grant all privileges on *.* to root@'본인 아이피' identified by '패스워드' with grant option;

flush privileges;	--grant테이블을 reload함으로 변경사항을 바로 적용해주는 명령어


create table board_member(
	idx int auto_increment not null primary key,
	id varchar(20) not null,
	pwd varchar(50) not null,
	name varchar(20) not null,
	regdate datetime default current_timestamp
);

--drop table board_member;

insert into board_member values(default,'test1','test1234','가가가',default);

select * from board_member;