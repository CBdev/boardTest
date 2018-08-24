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

insert into board_test values (default,'�׽�Ʈ1','������','2018-08-20',5,'���볻�볻��','121212','filename1.jpg');


--Cannot create PoolableConnectionFactory (null, message from server: "Host 'sjh-PC' is not allowed to connect to this MySQL server")

--�ذ�

grant all privileges on *.* to root@'���� ������' identified by '�н�����' with grant option;

flush privileges;	--grant���̺��� reload������ ��������� �ٷ� �������ִ� ��ɾ�


create table board_member(
	idx int auto_increment not null primary key,
	id varchar(20) not null,
	pwd varchar(50) not null,
	name varchar(20) not null,
	regdate datetime default current_timestamp
);

--drop table board_member;

insert into board_member values(default,'test1','test1234','������',default);

select * from board_member;