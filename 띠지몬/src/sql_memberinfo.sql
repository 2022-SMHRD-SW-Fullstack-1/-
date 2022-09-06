select * from MEMBERINFO;

create table memberInfo(
id varchar2(20),
pw varchar2(20) not null,
nick varchar2(10) not null,
constraint memberinfo_id_pk primary key(id)
);