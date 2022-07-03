use furama_resort_module4;
INSERT INTO furama_resort_module4.position () 
VALUES 	('1', 'Quản Lý'),
		('2', 'Nhân Viên');
   
INSERT INTO furama_resort_module4.division () 
VALUES	('1', 'Sale-Marketing'),
		('2', 'Hành Chính'),
		('3', 'Phục Vụ'),
		('4', 'Quản Lý');
        
INSERT INTO furama_resort_module4.education_degree () 
VALUES 	('1', 'Trung Cấp'),
		('2', 'Cao Đẳng '),
		('3', 'Đại Học'),
		('4', 'Sau Đại Học');
        
        
INSERT INTO furama_resort_module4.employee (employee_id,`name`, birth_day, id_card, salary, phone, email, address, position_id, education_degree_id, division_id,flag) 
values	(1, "Nguyễn Văn An", "1970-11-07","456231786", 10000000, "0123456789", "annguyen@gmail.com", "295 Nguyễn Tất Thành, Đà Nẵng", 1, 3, 1,'1'),
		(2, "Lê Văn Bình", "1997-04-09", "654231234", 7000000, "0984534758", "binhlv@gmail.com", "22 Yên Bái, Đà Nẵng", 1, 2, 2,'1'),
		(3, "Hồ Thị Yến", "1995-12-12", "999231723", 14000000, "0456764542", "thiyen@gmail.com", "K234/11 Điện Biên Phủ, Gia Lai", 1, 3, 2,'1'),
		(4, "Võ Công Toản", "1980-04-04", "123231365", 17000000, "0379853432", "toan0404@gmail.com", "77 Hoàng Diệu, Quảng Trị", 1, 4, 4,'1'),
		(5, "Nguyễn Bỉnh Phát", "1999-12-09", "454363232", 6000000, "0902433454", "phatphat@gmail.com", "43 Yên Bái, Đà Nẵng", 2, 1, 1,'1'),
		(6, "Khúc Nguyễn An Nghi", "2000-11-08", "964542311", 7000000, "0978650000", "annghi20@gmail.com", "294 Nguyễn Tất Thành, Đà Nẵng", 2, 2, 3,'1'),
		(7, "Nguyễn Hữu Hà", "1993-01-01", "534323231", 8000000, "0941234553", "nhh0101@gmail.com", "4 Nguyễn Chí Thanh, Huế", 2, 3, 2,'1'),
		(8, "Nguyễn Hà Đông", "1989-09-03", "234414123", 9000000, "0642123111", "donghanguyen@gmail.com", "11 Hùng Vương, Hà Nội", 2, 4, 4,'1'),
		(9, "Tòng Hoang", "1982-09-03", "256781231", 6000000, "0245144444", "hoangtong@gmail.com", "213 Hàm Nghi, Đà Nẵng", 2, 4, 4,'1'),
		(10, "Nguyễn Công Đạo", "1994-01-08", "755434343", 8000000, "0988767111", "nguỹenongdao12@gmail.com", "6 Hoà Khánh, Đồng Nai", 2, 3, 2,'1');
        
INSERT INTO `furama_resort_module4`.`customer_type` () 
VALUES 	('1', 'Diamond'),
		('2', 'Platinium'),
		('3', 'Gold'),
		('4', 'Silver'),
		('5', 'Member');    
        
INSERT INTO `furama_resort_module4`.`customer` (`customer_code`,`name`, `birth_day`, `gender`, `id_card`, `phone`, `email`, `address`, `customer_type_id`) 
values 	("KH-0001","Nguyễn Thị Hào","1970-11-07",b'0',"643431213","0945423362","thihao07@gmail.com","23 Nguyễn Hoàng,Hải Châu,Đà Nẵng",5),
		("KH-0002","Phạm Xuân Diệu","1992-08-08",b'1',"865342123","0954333333","xuandieu92@gmail.com","K77/22 Thái Phiên, Quảng Trị",3),
		("KH-0003","Trương Đình Nghệ","1990-02-27",b'1',"488645199","0373213122","nghenhan2702@gmail.com","K323/12 Ông Ích Khiêm, Vinh",1),
		("KH-0004","Dương Văn Quan","1981-07-08",b'1',"543432111","0490039241","duongquan@gmail.com","K453/12 Lê Lợi,Hải Châu, Đà Nẵng",1),
		("KH-0005","Hoàng Trần Nhi Nhi","1995-12-09",b'0',"795453345","0312345678","nhinhi123@gmail.com","224 Lý Thái Tổ, Gia Lai",4),
		("KH-0006","Tôn Nữ Mộc Châu","2005-12-06",b'0',"732434215","0988888844","tonnuchau@gmail.com","37 Yên Thế,Liên Chiểu, Đà Nẵng",4),
		("KH-0007","Nguyễn Mỹ Kim","1984-04-08",b'0',"856453123","0912345698","kimcuong84@gmail.com","K123/45 Lê Lợi, Hồ Chí Minh",1),
		("KH-0008","Nguyễn Thị Hào","1999-04-08",b'0',"965656433","0763212345","haohao99@gmail.com","55 Nguyễn Văn Linh, Kon Tum",3),
		("KH-0009","Trần Đại Danh","1994-07-01",b'1',"432341235","0643343433","danhhai99@gmail.com","24 Lý Thường Kiệt, Quảng Ngãi",1),
		("KH-0010","Nguyễn Tâm Đắc","1989-07-01",b'1',"344343432","0987654321","tdactam@gmail.com","22 Ngô Quyền, Ngũ Hành Sơn,Đà Nẵng",2);

INSERT INTO `furama_resort_module4`.`service_type` ()
VALUES 	('1', 'Villa'),
		('2', 'House'),
		('3', 'Room');

-- set sql_safe_updates = 0;
-- DELETE FROM   `furama_resort_module4`.`rent_type`;
-- set sql_safe_updates = 1;
INSERT INTO `furama_resort_module4`.`rent_type` (`rent_type_name`,`rent_type_cost`) 
VALUES 	( 'year',50000),
		( 'month',100000),
		( 'day',150000),
		('hour',200000);

INSERT INTO furama_resort_module4.service ( `name`, `area`, `cost`, `max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floor`, `rent_type_id`, `service_type_id`,`service_code`) 
values	("Villa Beach Front","25000",10000000,10,"vip","Có hồ bơi",500,4,3,1,"DV-1222"),
		("House Princess 01","14000",5000000,7,"vip","Có thêm bếp nướng",null,3,2,2,"DV-1223"),
		("Room Twin 01","5000",1000000,2,"vip","Có tivi",null,null,4,3,"DV-1224"),
		("Villa No Beach Front","22000",9000000,8,"normal","Có hồ bơi",300,3,3,1,"DV-1225"),
		("House Princess 02","10000",4000000,5,"normal","Có thêm bếp nướng",null,2,3,2,"DV-1226"),
		("Room Twin 02","3000",900000,2,"normal","Có tivi",null,null,4,3,"DV-1227");
        
        
INSERT INTO furama_resort_module4.contract ( `date_start`, `date_end`, `deposit`, `employee_id`, `customer_id`, `service_id`) 
values 	("2020-12-08","2020-12-08",0,3,1,3),
		("2020-07-21","2020-07-21",200000,7,3,1),
		("2021-03-15","2021-03-17",50000,3,4,2),
		("2021-01-14","2021-01-18",100000,7,5,5),
		("2021-07-14","2021-07-15",0,7,2,6),
		("2021-06-01","2021-06-03",0,7,7,6),
		("2021-09-02","2021-09-05",100000,7,4,4),
		("2021-06-17","2021-06-18",150000,3,4,1),
		("2020-11-19","2020-11-19",0,3,4,3),
		("2021-04-12","2021-04-14",0,10,3,5),
		("2021-04-25","2021-04-25",0,2,2,1),
		("2021-05-25","2021-05-27",0,7,10,1);
        
INSERT INTO `furama_resort_module4`.`attach_service` (`attact_service_id`, `name`, `cost`, `unit`, `status`) 
VALUES ('1', 'karaoke ', '10000', 'giờ', 'tiện nghi, tốt'),
		('2', 'thuê xe máy', '10000', 'chiếc', 'hỏng 1 xe'),
		('3', 'thuê xe đạp', '20000', 'chiếc', 'tốt'),
		('4', 'buffe sáng', '15000', 'suất', 'đầy đủ đồ ăn'),
		('5', 'buffe trưa', '90000', 'suất', 'đầy đủ đồ ăn'),
		('6', 'buffe tối', '16000', 'suất', 'đầy đủ đồ ăn');
        
INSERT INTO `furama_resort_module4`.`contract_detail` (`quantity`,`contract_id`, `attact_service_id`) 
value	(5, 2, 4),(8, 2, 5),
		(15, 2, 6),(1, 3, 1),
		(11, 3, 2),(1, 1, 3),
        (2, 1, 2),(2, 12, 2);
        
       
-- select customer.name, contract.contract_id, contract_detail_id,
--        GROUP_CONCAT(attach_service.name) nameAtt,contract_detail.quantity,
--        sum(COALESCE(contract_detail.quantity*attach_service.cost,0)+service.cost)
--          from customer
--          join contract on customer.id = contract.customer_id
--         join service  on contract.service_id = service.id
--         left join contract_detail on contract.contract_id = contract_detail.contract_id
--         left join attach_service  on contract_detail.attact_service_id =  attach_service.attact_service_id
--         group by  contract.contract_id;


insert into user ( username,encryted_password) values ( 'user123', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu');
insert into user ( username,encryted_password) values ( 'user124', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu');



insert into `role` (role_id, role_name) values (1, 'ROLE_ADMIN');
insert into `role` (role_id, role_name) values (2, 'ROLE_USER');


insert into user_role (id, role_id, user_id) values (1, 1, 1);
insert into user_role (id, role_id, user_id) values (2, 1, 2);
insert into user_role (id, role_id, user_id) values (3, 2, 2);

        
