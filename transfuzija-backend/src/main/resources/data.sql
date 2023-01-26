-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: transfuzija-db
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `blood_center_administrators`
--

LOCK TABLES `blood_center_administrators` WRITE;
/*!40000 ALTER TABLE `blood_center_administrators` DISABLE KEYS */;
INSERT INTO `blood_center_administrators` VALUES (2,'Nikole Pašića 50','Smederevo','Srbija','center_admin@mail.com',_binary '','Jelena','$2a$10$IJQqWcUe6Ybpggb.53jTpeKqWkVmjbFKWLwLV.2FkgxWksKq6.hCG','0653701441','Nikolić',NULL,NULL,1),(3,'Kralja Milana 71','Užice','Srbija','center_admin2@mail.com',_binary '','Milan','$2a$10$B2RE9YhdwSPhBueXQ.otfO2xisy8/8fEvaGiBzvlJbIdDQwf2FTK.','0610534336','Marković',NULL,NULL,1),(4,'Kralja Milana 32','Zrenjanin','Srbija','center_admin3@mail.com',_binary '','Ivana','$2a$10$3NUPeShIFgOoL1Y7CjuKfuF5dX1RM9nypfiAJsgfMmfCx22mxk6E6','0622249305','Pavlović',NULL,NULL,2),(5,'Bulevar cara Dušana 89','Novi Sad','Srbija','center_admin4@mail.com',_binary '','Nikola','$2a$10$/f7fZgIZnmDb./a.U5R/S.iGSJslGV4UubXqbREn1qYSrpdBSPB2W','0640385232','Stanković',NULL,NULL,2),(6,'Bulevar Nikole Pašića 64','Subotica','Srbija','center_admin5@mail.com',_binary '','Aleksandar','$2a$10$U9gTjU7hFIup6NHi.Bqn0e7210BcNZdIuAOuqG8Tp/1FZS.3XbHHi','0612018080','Đorđević',NULL,NULL,3),(7,'Cara Lazara 21','Sremska Mitrovica','Srbija','center_admin6@mail.com',_binary '','Zoran','$2a$10$ONCKyDhVWpzeVQlvs4zXhuVoQ8Z8MFZkMLXrrOS/CrMcwNrKSSki2','0616907440','Pavlović',NULL,NULL,3),(8,'Mihajla Pupina 36','Sombor','Srbija','center_admin7@mail.com',_binary '','Mirjana','$2a$10$RtOe25EnQtjasPxER1wNue1/1aLJjGJMDr0TaeuwlTjW4b8jpsn3C','0616907440','Jovanović',NULL,NULL,4),(9,'Bulevar Mihajla Pupina 53','Novi Sad','Srbija','center_admin8@mail.com',_binary '','Dragana','$2a$10$02jq5azAnMg9eC6URl0sdOXarFVA35tsW167G.1jPsnQ455j9ZReO','0616676697','Ilić',NULL,NULL,4),(10,'Bulevar kralja Milana 96','Kragujevac','Srbija','center_admin9@mail.com',_binary '','Ana','$2a$10$7/gyZVfspV0/d6iv9L80G.ZPcnax1AjUgt56cexS5SrngTqYgsSGW','0612249305','Marinković',NULL,NULL,5),(11,'Njegoševa 85','Kragujevac','Srbija','center_admin10@mail.com',_binary '','Mirjana','$2a$10$108gD0Q7r2/Rpi8pjkJGZ.MrjW3z.hBS7ubV8ekZfu1.ZKmlb1ZDO','0612018081','Petrović',NULL,NULL,5),(12,'Bulevar Nikole Tesle 45','Niš','Srbija','center_admin11@mail.com',_binary '','Goran','$2a$10$ddKJRguw8kcKT2Fwbnp/Z.pCEHiN2ahxOlNtPVBRqD61bCEbjFD0y','0617446682','Miletić',NULL,NULL,6),(13,'Svetozara Miletića 18','Subotica','Srbija','center_admin12@mail.com',_binary '','Dušan','$2a$10$i2xD7aRtKhJ.2cMNSynPcuLM2yJ33KqTkiAdhWyEIcHwcvbA8MpMS','0630385232','Stepić',NULL,NULL,6),(14,'Isidore Sekulić 67','Šabac','Srbija','center_admin13@mail.com',_binary '','Gordana','$2a$10$epKO9FW8wTpRaI7xoF2TZeQMt7Pw8kYYQm.S3hV9ZbHhFG1hRnEDS','0636887527','Milošević',NULL,NULL,7),(15,'Isidore Sekulić 17','Niš','Srbija','center_admin14@mail.com',_binary '','Ljiljana','$2a$10$TlRHEYFXYT.ML0klwpLIL.PvZF4xLg85wPOnS6FMlUnAjp9A8y7s2','0636029348','Tomić',NULL,NULL,7),(16,'Zmajevački put 32','Novi Sad','Srbija','center_admin15@mail.com',_binary '','Ana','$2a$10$4.U3f2kgbBI/5yPZxLLBaOqFYxVcZFL2CSk.noAAAxNCfgP6EngAm','064556689','Stojkić',NULL,NULL,8),(17,'Nikole Tesle 23','Sombor','Srbija','center_admin16@mail.com',_binary '','Nikola','$2a$10$zB2p03haYxG2G5NN7VoNmuQenYJ0jirKgOrtJdKcYMVwHhWNifUIm','0623252678','Nikolić',NULL,NULL,8);
/*!40000 ALTER TABLE `blood_center_administrators` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `blood_center_appointments`
--

LOCK TABLES `blood_center_appointments` WRITE;
/*!40000 ALTER TABLE `blood_center_appointments` DISABLE KEYS */;
INSERT INTO `blood_center_appointments` VALUES (1,'2023-01-30 08:00:00.000000',20,_binary '\0',_binary '\0',_binary '\0',_binary '',1,18,3),(2,'2023-01-30 08:30:00.000000',20,_binary '\0',_binary '\0',_binary '\0',_binary '\0',1,NULL,3),(3,'2023-01-31 08:00:00.000000',20,_binary '\0',_binary '\0',_binary '\0',_binary '\0',1,NULL,2),(4,'2023-01-31 08:30:00.000000',30,_binary '\0',_binary '\0',_binary '\0',_binary '\0',1,NULL,2),(5,'2023-01-30 09:00:00.000000',40,_binary '\0',_binary '\0',_binary '\0',_binary '\0',1,NULL,3),(6,'2023-01-30 08:00:00.000000',20,_binary '\0',_binary '\0',_binary '\0',_binary '\0',2,NULL,4),(7,'2023-01-31 08:00:00.000000',30,_binary '\0',_binary '\0',_binary '\0',_binary '\0',2,NULL,5),(8,'2023-01-31 08:40:00.000000',20,_binary '\0',_binary '\0',_binary '\0',_binary '\0',2,NULL,5);
/*!40000 ALTER TABLE `blood_center_appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `blood_transfusion_centers`
--

LOCK TABLES `blood_transfusion_centers` WRITE;
/*!40000 ALTER TABLE `blood_transfusion_centers` DISABLE KEYS */;
INSERT INTO `blood_transfusion_centers` VALUES (1,'Hajduk Veljkova 9a','Novi Sad','Srbija','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Zavod za transfuziju krvi Vojvodine',4),(2,'Svetog Save 39','Beograd','Srbija','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Institut za transfuziju krvi Srbije',3),(3,'Bulevar dr Zorana Đinđića 48','Niš','Srbija','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Zavod za transfuziju krvi Niš',4),(4,'Svetozara Markovića 7','Kragujevac','Srbija','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Crveni krst Kragujevac',5),(5,'Mačvanska 76','Šabac','Srbija','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Crveni krst Šabac',5),(6,'Trg žrtvama fašizma 3','Subotica','Srbija','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Crveni krst Subotica',4),(7,'Simina 19','Beograd','Srbija','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Crveni krst Srbije',3),(8,'Zmaj Jovina 9','Zrenjanin','Srbija','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','Crveni krst Zrenjanin',5);
/*!40000 ALTER TABLE `blood_transfusion_centers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hibernate_sequences`
--

LOCK TABLES `hibernate_sequences` WRITE;
/*!40000 ALTER TABLE `hibernate_sequences` DISABLE KEYS */;
INSERT INTO `hibernate_sequences` VALUES ('default',18);
/*!40000 ALTER TABLE `hibernate_sequences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `questionnaire`
--

LOCK TABLES `questionnaire` WRITE;
/*!40000 ALTER TABLE `questionnaire` DISABLE KEYS */;
INSERT INTO `questionnaire` VALUES (1,_binary '\0',_binary '\0',_binary '\0',_binary '\0',_binary '\0',_binary '\0',_binary '\0',_binary '',_binary '\0',_binary '\0',_binary '\0',_binary '\0',_binary '\0',_binary '\0');
/*!40000 ALTER TABLE `questionnaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `registered_clients`
--

LOCK TABLES `registered_clients` WRITE;
/*!40000 ALTER TABLE `registered_clients` DISABLE KEYS */;
INSERT INTO `registered_clients` VALUES (18,'Trg kralja Petra I 39/1','Žabalj','Srbija','tia203@live.com',_binary '','Tamara','$2a$10$SlaqWCu5gSvkwAHIX.1HJOZub95FHrhLtIhIPg2jCNrih5d.ul8Ea','0643377995','Puškarov',NULL,_binary '\0','FEMALE','1234567891011','Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit','student',0,_binary '',1);
/*!40000 ALTER TABLE `registered_clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'SYSTEM_ADMINISTRATOR'),(2,'CENTER_ADMINISTRATOR'),(3,'REGISTERED_CLIENT');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `system_administrators`
--

LOCK TABLES `system_administrators` WRITE;
/*!40000 ALTER TABLE `system_administrators` DISABLE KEYS */;
INSERT INTO `system_administrators` VALUES (1,'Trg kralja Petra I 39','Žabalj','Srbija','system_admin@mail.com',_binary '','Tamara','$2a$10$A1ObYoAdi4FQsH2PdRYTeeGEjwRuXeh3rSaJUY.fQWGQS9O8Q1daq','0643377995','Puškarov',NULL,NULL);
/*!40000 ALTER TABLE `system_administrators` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,1),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,3);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-26 21:11:06
