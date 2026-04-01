create  table human_test2(
                            h_no number(2) primary key,
                            h_name varchar2(30 char) not null,
                            h_age number(2) not null
);

create sequence human_test2_seq;
insert into human_test2 values (human_test2_seq.nextval, 'mz1', 10);
insert into human_test2 values (human_test2_seq.nextval, 'mz2', 20);
insert into human_test2 values (human_test2_seq.nextval, 'mz3', 30);

select * from human_test;