create table pl( 
id varchar2(7) primary key not null,
name varchar2(7) not null,
birth date default sysdate
)

create table people( 
id varchar2(7) primary key not null,
name varchar2(7) not null,
birth date default sysdate
)

drop table pl

insert into people(id, name, birth) values('a', 'kim', '1980-01-09')
insert into people values('b', 'lee', '1990-02-15')
select * from people
delete from people where id = j
delete from people where id = j;
delete from people where id = r
delete from people where id=a

