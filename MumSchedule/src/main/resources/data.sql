

insert into role values(1,'ROLE_ADMIN');
insert into role values (2,'ROLE_FACULTY');
insert into role values (3,'ROLE_STUDENT');

-- All Users in our DataBase

SET foreign_key_checks = 0;
-- values(id,email,fname,lname,credentialid,roleid)
insert into user values(1,'sam@miu.edu','sam','tes',1,1);
insert into user values(2,'meda@miu.com','meda','teklom',2,2);
insert into user values(3,'mike@miu.edu','miki','desta',3,1);
insert into user values(4,'hiwi@miu.edu','hiwi','manaye',4,3);
insert into user values(5,'eyuel@miu.edu','eyuel','tafesse',5,3);

-- ---Essey Products as Seller
-- insert into product values(1,1,400,'Essey Product','2020-12-13',600,0,'2021-12-18','Phone',0,'Yes',0,1,40000.00,'2020-10-12',2);
-- insert into product values(2,0,400,'Essey Product','2021-03-20',0.00,0,'2021-12-14','Toyota',0,'Yes',0,0,40000.00,'2020-12-12',2);
-- insert into product values(3,0,400,'Essey Product','2021-03-20',0.00,0,'2021-12-14','Table',0,'Yes',0,0,40000.00,'2020-12-12',2);

SET foreign_key_checks = 0;


-- insert into credentials values ( 1,'eyob' ,'eyob');
-- id,password,username
insert into credentials values ( 1,'$2a$10$t3DnFV7cbLPQI8oXwSnlRuPsc/H86OVl97t5EJuT0pY.o3956VcBO' ,'sam');
insert into credentials values ( 2,'$2a$10$//Kj2zhKL1cqQ/hQ4AwQ1eDnYlhdwoijCnTOAp700zxJqVLjmB9tq' ,'meda');
insert into credentials values ( 3,'$2a$10$bzvEb5YMyBK0sBSO8.XzeujvrloBkRFHoIdnU.ZmdU3AJjMToOhRG' ,'mike');
insert into credentials values ( 4,'$2a$10$YojEhB86z8rzZlXzK2xLx.GoAx1MQW9nOQim2fYNymSrrzvRyx3z.' ,'hiwi');
insert into credentials values ( 5,'$2a$10$qJqXfSzNusPrzSMGIEBhjuHW6g5URj9h0wpcUO.uBgjU5eNWVfrBS' ,'eyuel');
-- insert student id ,email, fname, lname, studentid,userid
-- insert into student values ( 1,'hiwi@miu.edu','hiwi','manaye',111178,4);
-- insert into student values ( 2,'eyuel@miu.edu','eyuel','tafesse',111179,5);
-- -- insert faculty id, email,name,userid
-- insert into faculty values ( 1,'meda@miu.com','meda_teklom',2);
-- insert into faculty values ( 2,'mike@miu.edu','miki_desta',3);
--
-- -- insert in to entry id,month,year
-- insert into entry values ( 1,'february','2020');
-- insert into entry values ( 2,'august','2020');
--
--
-- -- insert in to block id,name,enddate,startdate,entryid
-- insert into block values ( 1,'block1','2020-02-28 00:00:00.000000','2020-02-05 00:00:00.000000',1);
-- insert into block values ( 2,'block2','2020-03-28 00:00:00.000000','2020-03-05 00:00:00.000000',1);
-- insert into block values ( 3,'block3','2020-04-28 00:00:00.000000','2020-04-05 00:00:00.000000',1);
-- insert into block values ( 4,'block4','2020-05-28 00:00:00.000000','2020-05-05 00:00:00.000000',1);
--
-- insert into block values ( 5,'block1','2020-02-28 00:00:00.000000','2020-02-05 00:00:00.000000',2);
-- insert into block values ( 6,'block2','2020-03-28 00:00:00.000000','2020-03-05 00:00:00.000000',2);
-- insert into block values ( 7,'block3','2020-04-28 00:00:00.000000','2020-04-05 00:00:00.000000',2);
-- insert into block values ( 8,'block4','2020-05-28 00:00:00.000000','2020-05-05 00:00:00.000000',2);
--
-- -- insert in to section id,name,blockid
-- insert into section values ( 1,'section1',1);
-- insert into section values ( 2,'section2',1);
-- insert into section values ( 3,'section1',2);
-- insert into section values ( 4,'section2',2);
--
-- -- insert in to course, id,name, coursecode, enddate,startdate,sectionid,blockid
-- insert into course values ( 1,'fpp','cs390','2020-02-28 00:00:00.000000','2020-02-05 00:00:00.000000',1,1);
-- insert into course values ( 2,'fpp','cs390','2020-02-28 00:00:00.000000','2020-02-05 00:00:00.000000',1,1);
-- insert into course values ( 3,'mpp','cs390','2020-02-28 00:00:00.000000','2020-02-05 00:00:00.000000',2,2);
-- insert into course values ( 4,'mpp','cs390','2020-02-28 00:00:00.000000','2020-02-05 00:00:00.000000',2,2);
--
-- -- insert in to course_faculty courseid,facultyid
-- insert into course_faculty values ( 1,1);
-- insert into course_faculty values ( 2,2);
-- insert into course_faculty values ( 3,1);
-- insert into course_faculty values ( 4,2);
--
-- -- insert in to course_student courseid,studentid
-- insert into course_student values ( 1,1);
-- insert into course_student values ( 2,2);
-- insert into course_student values ( 3,1);
-- insert into course_student values ( 4,2);
