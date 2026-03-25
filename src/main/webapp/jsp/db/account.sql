create table account_test(
  a_id varchar2(20 char) primary key,
  a_pw  varchar2(15 char) not null,
  a_name  varchar2(20 char) not null
);

insert into account_test values ('admin', '1234', 'Administrator');
insert into account_test values ('user01', 'user01', 'John Doe');
insert into account_test values ('user02', 'user02', 'Jane Smith');
insert into account_test values ('test', 'test', 'Tester');
insert into account_test values ('sj', 'sj1004', 'SJ');
insert into account_test values ('aaa','aaa','aaaa');
select * from account_test;
