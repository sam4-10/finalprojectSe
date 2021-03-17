

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
--

--Dawit As a Seller Products

-- insert into product values(4,0,400,'Dawit Product','2021-03-20',0.00,0,'2021-12-14','Laptop',0,'Yes',0,0,40000.00,'2020-12-12',3);
-- insert into product values(5,0,400,'Dawit Product','2021-03-20',0.00,0,'2021-12-14','Hyundai',0,'Yes',0,0,40000.00,'2020-12-12',3);
-- insert into product values(6,0,400,'Dawit Product','2021-03-20',0.00,0,'2021-12-14','Sofa',0,'Yes',0,0,40000.00,'2020-12-12',3);
--
-- insert into deposit_payment values (1,'2021-01-02','5678908765378965','565','400',0,'essey',null,1,3);
--
-- insert into bid values ( 1,2 );
-- insert into bid_user values ( 1,600,3 );
-- insert into USER_WON_PRODUCTS values(3,1);
-- insert into bid_history values ( 1,600,'2020-12-14',1,3);
-- insert into bid values(1,1);
-- -- insert into product values(2,'perfect product','322868_1100-1100x628.jpg','car',0,0,20000,'2020-03-02',1);
-- -- insert into product values(3,'perfect product','322868_1100-1100x628.jpg','car',0,0,20000,'2020-03-02',1);
SET foreign_key_checks = 0;


-- insert into credentials values ( 1,'eyob' ,'eyob');
-- id,password,username
insert into credentials values ( 1,'$2a$10$t3DnFV7cbLPQI8oXwSnlRuPsc/H86OVl97t5EJuT0pY.o3956VcBO' ,'sam');
insert into credentials values ( 2,'$2a$10$//Kj2zhKL1cqQ/hQ4AwQ1eDnYlhdwoijCnTOAp700zxJqVLjmB9tq' ,'meda');
insert into credentials values ( 3,'$2a$10$bzvEb5YMyBK0sBSO8.XzeujvrloBkRFHoIdnU.ZmdU3AJjMToOhRG' ,'mike');
insert into credentials values ( 4,'$2a$10$YojEhB86z8rzZlXzK2xLx.GoAx1MQW9nOQim2fYNymSrrzvRyx3z.' ,'hiwi');
insert into credentials values ( 5,'$2a$10$qJqXfSzNusPrzSMGIEBhjuHW6g5URj9h0wpcUO.uBgjU5eNWVfrBS' ,'eyuel');
-- insert student id ,email, fname, lname, studentid,userid
insert into student values ( 1,'hiwi@miu.edu','hiwi','manaye',111178,4);
insert into student values ( 2,'eyuel@miu.edu','eyuel','tafesse',111179,5);
-- insert faculty id, email,name,userid
insert into faculty values ( 1,'meda@miu.com','meda_teklom',2);
insert into faculty values ( 2,'mike@miu.edu','miki_desta',3);
-- --- Inserted Photos for products on Essey
-- insert into product_photos values ( 1,'/images/product-photos/2/phone.jpg');
-- insert into product_photos values ( 2,'/images/product-photos/2/toyota.jpg');
-- insert into product_photos values ( 3,'/images/product-photos/2/Table.jpg');
--
--
-- ---Inserted Photos for Seller Dawit
-- insert into product_photos values ( 4,'/images/product-photos/3/laptop.jpg');
-- insert into product_photos values ( 4,'/images/product-photos/3/laptop2.jpg');
-- insert into product_photos values ( 5,'/images/product-photos/3/hyudai.jpeg');
-- insert into product_photos values ( 6,'/images/product-photos/3/sofa.jpg');
--
--
-- ------------------ Poducts Catagory----------
-- insert into product_categories values(3,3);
-- insert into product_categories values(2,2);
-- insert into product_categories values(1,1);
-- insert into product_categories values(4,1);
-- insert into product_categories values(5,2);
-- insert into product_categories values(6,3);