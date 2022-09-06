drop table playerInfo

create table playerInfo(
d_name varchar2(20),
d_ability number(5),
d_score number(5),
id varchar2(20),
constraint d_name_pk primary key(d_name),
constraint memberInfo_id_fk foreign key(id) REFERENCES memberInfo(id)
);

INSERT INTO PLAYERINFO(d_name, d_ability)
VALUES ('아구몬', DBMS_RANDOM.value(1, 100));
INSERT INTO PLAYERINFO(d_name)
VALUES ('에테몬');
INSERT INTO PLAYERINFO(d_name)
VALUES ('데블드라몬');
INSERT INTO PLAYERINFO(d_name)
VALUES ('엔젤몬');
INSERT INTO PLAYERINFO(d_name)
VALUES ('키위몬');
INSERT INTO PLAYERINFO(d_name)
VALUES ('가트몬');
INSERT INTO PLAYERINFO(d_name)
VALUES ('파닥몬');
INSERT INTO PLAYERINFO(d_name)
VALUES ('파피몬');
INSERT INTO PLAYERINFO(d_name)
VALUES ('릴리몬');
INSERT INTO PLAYERINFO(d_name)
VALUES ('올챙몬');


UPDATE playerinfo
SET
d_ability = ROUND(DBMS_RANDOM.VALUE(0, 100))
WHERE
d_name = '아구몬';

UPDATE playerinfo
SET
d_ability = ROUND(DBMS_RANDOM.VALUE(0, 100))
WHERE
d_name = '에테몬';

UPDATE playerinfo
SET
d_ability = ROUND(DBMS_RANDOM.VALUE(0, 100))
WHERE
d_name = '데블드라몬';

UPDATE playerinfo
SET
d_ability = ROUND(DBMS_RANDOM.VALUE(0, 100))
WHERE
d_name = '엔젤몬';

UPDATE playerinfo
SET
d_ability = ROUND(DBMS_RANDOM.VALUE(0, 100))
WHERE
d_name = '키위몬';

UPDATE playerinfo
SET
d_ability = ROUND(DBMS_RANDOM.VALUE(0, 100))
WHERE
d_name = '가트몬';

UPDATE playerinfo
SET
d_ability = ROUND(DBMS_RANDOM.VALUE(0, 100))
WHERE
d_name = '파닥몬';

UPDATE playerinfo
SET
d_ability = ROUND(DBMS_RANDOM.VALUE(0, 100))
WHERE
d_name = '파피몬';

UPDATE playerinfo
SET
d_ability = ROUND(DBMS_RANDOM.VALUE(0, 100))
WHERE
d_name = '릴리몬';

UPDATE playerinfo
SET
d_ability = ROUND(DBMS_RANDOM.VALUE(0, 100))
WHERE
d_name = '올챙몬';





select * from playerinfo;