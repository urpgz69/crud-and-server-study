create table review_test(
    r_no number(3) primary key,
    r_title varchar2(50 char) not null,
    r_txt varchar2(500 char) not null,
    r_date date not null
);


create sequence review_test_seq;


insert into review_test values(review_test_seq.nextval, 'test title 1', 'test content 1', sysdate);
insert into review_test values(review_test_seq.nextval, 'test title 2', 'test content 2', sysdate);
insert into review_test values(review_test_seq.nextval, 'test title 3', 'test content 3', sysdate);


select * from review_test;