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