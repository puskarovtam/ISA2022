-- Blood center administrators

INSERT INTO blood_center_administrators (user_id, user_address, user_city, user_country, user_email, user_enabled, user_name, user_password, user_phone_number, user_surname, center_pass_changed, transfusion_center_transfusion_id) VALUES 
(6,'Bulevar Nikole Pašića 64','Subotica','Srbija','center_admin1@mail.com',_binary '','Aleksandar','$2a$10$3G3Tp9A.BU3tdcZ5LMdDueZnjSPT.MbOQ8xnwz0AomjyfnTOPk9ay','0612018080','Đorđević',NULL,6);
INSERT INTO blood_center_administrators (user_id, user_address, user_city, user_country, user_email, user_enabled, user_name, user_password, user_phone_number, user_surname, center_pass_changed, transfusion_center_transfusion_id) VALUES 
(7,'Cara Dušana 21','Sremska Mitrovica','Srbija','center_admin2@mail.com',_binary '','Zoran','$2a$10$lBOd2ENyJO7z9MqDjPhzz.k8SQOzBow3Nhxp252VMJb3pmuvFlpAS','0616907440','Pavlović',NULL,2);
INSERT INTO blood_center_administrators (user_id, user_address, user_city, user_country, user_email, user_enabled, user_name, user_password, user_phone_number, user_surname, center_pass_changed, transfusion_center_transfusion_id) VALUES 
(8,'Mihajla Pupina 36','Sombor','Srbija','center_admin3@mail.com',_binary '','Mirjana','$2a$10$BwxXktboKGtn7XMw0H7OdeuleMyd21dNGoykhzkvxY/OjTGltPebW','0611334846','Jovanović',NULL,9);
INSERT INTO blood_center_administrators (user_id, user_address, user_city, user_country, user_email, user_enabled, user_name, user_password, user_phone_number, user_surname, center_pass_changed, transfusion_center_transfusion_id) VALUES 
(9,'Bulevar Cara Dušana 53','Novi Sad','Srbija','center_admin4@mail.com',_binary '','Dragana','$2a$10$AcchVfpkGqOHF3Lzh16DFuLxj2KyKyQ8oe/QamKhB1D0yaWwy2aPO','0616676697','Ilić',NULL,1);
INSERT INTO blood_center_administrators (user_id, user_address, user_city, user_country, user_email, user_enabled, user_name, user_password, user_phone_number, user_surname, center_pass_changed, transfusion_center_transfusion_id) VALUES 
(10,'Bulevar Kralja Milana 96','Novi Sad','Srbija','center_admin5@mail.com',_binary '','Ana','$2a$10$qddgu8XmJX4OV1GwZBhm0OREMTPNeOrvj5AjIbLAXKtNrhBNR.xkm','0612249305','Marinković',NULL,8);

-- Blood transfusion centers
INSERT INTO blood_transfusion_centers (transfusion_id, transfusion_address, transfusion_city, transfusion_country, transfusion_description, transfusion_name, transfusion_rating) VALUES
(1,'Hajduk Veljkova 9a','Novi Sad','Srbija','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Zavod za transfuziju krvi Vojvodine',0);
INSERT INTO blood_transfusion_centers (transfusion_id, transfusion_address, transfusion_city, transfusion_country, transfusion_description, transfusion_name, transfusion_rating) VALUES
(2,'Svetog Save 39','Beograd','Srbija','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Institut za transfuziju krvi Srbije',0);
INSERT INTO blood_transfusion_centers (transfusion_id, transfusion_address, transfusion_city, transfusion_country, transfusion_description, transfusion_name, transfusion_rating) VALUES
(3,'Bulevar dr Zorana Đinđića 48','Niš','Srbija','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Zavod za transfuziju krvi Niš',0);
INSERT INTO blood_transfusion_centers (transfusion_id, transfusion_address, transfusion_city, transfusion_country, transfusion_description, transfusion_name, transfusion_rating) VALUES
(4,'Svetozara Markovića 7','Kragujevac','Srbija','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Crveni krst Kragujevac',0);
INSERT INTO blood_transfusion_centers (transfusion_id, transfusion_address, transfusion_city, transfusion_country, transfusion_description, transfusion_name, transfusion_rating) VALUES
(5,'Mačvanska 76','Šabac','Srbija','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Crveni krst Šabac',0);
INSERT INTO blood_transfusion_centers (transfusion_id, transfusion_address, transfusion_city, transfusion_country, transfusion_description, transfusion_name, transfusion_rating) VALUES
(6,'Trg žrtvama fašizma 3','Subotica','Srbija','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Crveni krst Subotica',0);
INSERT INTO blood_transfusion_centers (transfusion_id, transfusion_address, transfusion_city, transfusion_country, transfusion_description, transfusion_name, transfusion_rating) VALUES
(7,'Simina 19','Beograd','Srbija','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Crveni krst Srbije',0);
INSERT INTO blood_transfusion_centers (transfusion_id, transfusion_address, transfusion_city, transfusion_country, transfusion_description, transfusion_name, transfusion_rating) VALUES
(8,'Zmaj Jovina 9','Zrenjanin','Srbija','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Crveni krst Zrenjanin',0);
INSERT INTO blood_transfusion_centers (transfusion_id, transfusion_address, transfusion_city, transfusion_country, transfusion_description, transfusion_name, transfusion_rating) VALUES
(9,'Apatinski put 19','Sombor','Srbija','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Crveni krst Sombor',0);
INSERT INTO blood_transfusion_centers (transfusion_id, transfusion_address, transfusion_city, transfusion_country, transfusion_description, transfusion_name, transfusion_rating) VALUES
(10,'Cara Lazara 19','Kraljevo','Srbija','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Crveni krst Kraljevo',0);

-- hibernate sequences

INSERT INTO hibernate_sequences (sequence_name, next_val) VALUES ('default',15);

-- Registered clients

INSERT INTO registered_clients (user_id, user_address, user_city, user_country, user_email, user_enabled, user_name, user_password, user_phone_number, user_surname, registered_blocked, registered_gender, registered_jmbg, registered_job_information, registered_occupation, registered_penalties) VALUES
(11,'Nikole Pašića 85','Kragujevac','Srbija','client1@mail.com',_binary '\0','Mirjana','$2a$10$UBqPkujcD/n9Gg0g08Hpku7PPNTmWFinOltgVbf9xmiwEQT8QuoQa','0612018080','Petrović',_binary '\0','FEMALE','1234567891011','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','student',0);
INSERT INTO registered_clients (user_id, user_address, user_city, user_country, user_email, user_enabled, user_name, user_password, user_phone_number, user_surname, registered_blocked, registered_gender, registered_jmbg, registered_job_information, registered_occupation, registered_penalties) VALUES
(12,'Bulevar Nikole Tesle 16','Novi Sad','Srbija','client2@mail.com',_binary '\0','Goran','$2a$10$HFKWXPP9kGUUHoLb61ANrelcYw0F39hFEI6zE8w8zPKjv3RG5XzwO','0617446682','Miletić',_binary '\0','MALE','1234567891011','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','doktor stomatologije',0);
INSERT INTO registered_clients (user_id, user_address, user_city, user_country, user_email, user_enabled, user_name, user_password, user_phone_number, user_surname, registered_blocked, registered_gender, registered_jmbg, registered_job_information, registered_occupation, registered_penalties) VALUES
(13,'Kralja Milana 18','Subotica','Srbija','client3@mail.com',_binary '\0','Dušan','$2a$10$9Rpc8zFq.lOsmspGJTVQte6ZE2Ks20kxPmLteZ2ctKAo0hHfANbh.','0630385232','Stepić',_binary '\0','MALE','1234567891011','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','sportski menadžer',0);
INSERT INTO registered_clients (user_id, user_address, user_city, user_country, user_email, user_enabled, user_name, user_password, user_phone_number, user_surname, registered_blocked, registered_gender, registered_jmbg, registered_job_information, registered_occupation, registered_penalties) VALUES
(14,'Bulevar Nikole Pašića 67','Šabac','Srbija','client4@mail.com',_binary '\0','Gordana','$2a$10$Q7WG5FWi31nNqsYnMURof.w1XRjCFrlM9z9xmqaTt/9rhnfh9UV3y','0636887527','Milošević',_binary '\0','FEMALE','1234567891011','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','medicinska sestra',0);
INSERT INTO registered_clients (user_id, user_address, user_city, user_country, user_email, user_enabled, user_name, user_password, user_phone_number, user_surname, registered_blocked, registered_gender, registered_jmbg, registered_job_information, registered_occupation, registered_penalties) VALUES
(15,'Mihajla Pupina 14','Niš','Srbija','client5@mail.com',_binary '\0','Ljiljana','$2a$10$uv/JYHFHBB./tu7WAuaD0e6aykejb3dMZTvrL9ipEH4cTSQ1NSyeC','0636029348','Tomić',_binary '\0','FEMALE','1234567891011','Lorem ipsum dolor sit amet, consectetur adipiscing elit.','nastavnica likovne kulture',0);

-- Roles

INSERT INTO roles (role_id, role_name) VALUES (1,'REGISTERED_CLIENT');
INSERT INTO roles (role_id, role_name) VALUES (2,'SYSTEM_ADMINISTRATOR');
INSERT INTO roles (role_id, role_name) VALUES (3,'CENTER_ADMINISTRATOR');

-- System administrators

INSERT INTO system_administrators (user_id, user_address, user_city, user_country, user_email, user_enabled, user_name, user_password, user_phone_number, user_surname, system_pass_changed) VALUES
(1,'Trg kralja Petra I 39/1','Zabalj','Srbija','tamara@mail.com',_binary '','Tamara','$2a$10$PehgS/HMm59tvDH2B3LRQOk8c6h4iMfHomtZdNv5bv4GeK9bjyRgq','0643377995','Puskarov',NULL);
INSERT INTO system_administrators (user_id, user_address, user_city, user_country, user_email, user_enabled, user_name, user_password, user_phone_number, user_surname, system_pass_changed) VALUES
(2,'Nikole Pašića 50','Smederevo','Srbija','system_admin1@mail.com',_binary '','Jelena','$2a$10$NRXFHzdFTSFSwnjeXs1JHeWQA8uZNESFV56WrfX9F5Zr9onmNfD5K','0653701441','Nikolić',NULL);
INSERT INTO system_administrators (user_id, user_address, user_city, user_country, user_email, user_enabled, user_name, user_password, user_phone_number, user_surname, system_pass_changed) VALUES
(3,'Kralja Milana 71','Užice','Srbija','system_admin2@mail.com',_binary '','Milan','$2a$10$FUPu9Q6G1hsDQ8TYvw1AfOsenQxesc8GWCteZaeo1OO8rqK1zptwW','0610534336','Marković',NULL);
INSERT INTO system_administrators (user_id, user_address, user_city, user_country, user_email, user_enabled, user_name, user_password, user_phone_number, user_surname, system_pass_changed) VALUES
(4,'Kralja Milana 32','Zrenjanin','Srbija','system_admin3@mail.com',_binary '','Ivana','$2a$10$0og.j5YUbaFlX9mSE0b5qeB1bThaMmkQUWd7VjcjDACXnxq5jfGeS','0622249305','Pavlović',NULL);
INSERT INTO system_administrators (user_id, user_address, user_city, user_country, user_email, user_enabled, user_name, user_password, user_phone_number, user_surname, system_pass_changed) VALUES
(5,'Bulevar Cara Dušana 89','Novi Sad','Srbija','system_admin4@mail.com',_binary '','Nikola','$2a$10$JiFuYQwBOCQUVf.Z67MK0OhmvDiAxVETroGlEPpxj3dLHQBx10026','0640385232','Stanković',NULL);

-- User_roles

INSERT INTO user_roles (user_id, role_id) VALUES (11,1);
INSERT INTO user_roles (user_id, role_id) VALUES (12,1);
INSERT INTO user_roles (user_id, role_id) VALUES (13,1);
INSERT INTO user_roles (user_id, role_id) VALUES (14,1);
INSERT INTO user_roles (user_id, role_id) VALUES (15,1);
INSERT INTO user_roles (user_id, role_id) VALUES (16,1);
INSERT INTO user_roles (user_id, role_id) VALUES (1,2);
INSERT INTO user_roles (user_id, role_id) VALUES (2,2);
INSERT INTO user_roles (user_id, role_id) VALUES (3,2);
INSERT INTO user_roles (user_id, role_id) VALUES (4,2);
INSERT INTO user_roles (user_id, role_id) VALUES (5,2);
INSERT INTO user_roles (user_id, role_id) VALUES (6,3);
INSERT INTO user_roles (user_id, role_id) VALUES (7,3);
INSERT INTO user_roles (user_id, role_id) VALUES (8,3);
INSERT INTO user_roles (user_id, role_id) VALUES (9,3);
INSERT INTO user_roles (user_id, role_id) VALUES (10,3);