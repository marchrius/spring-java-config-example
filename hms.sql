-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: hms
-- ------------------------------------------------------
-- Server version	5.7.9-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `building` (
  `building_id` int(11) NOT NULL,
  `building_name` varchar(45) DEFAULT NULL,
  `incharge` varchar(45) DEFAULT NULL,
  `building_contact_no` varchar(45) DEFAULT NULL,
  `building_address` varchar(150) DEFAULT NULL,
  `hostal` int(11) DEFAULT NULL,
  `isActive` int(11) DEFAULT NULL,
  PRIMARY KEY (`building_id`),
  KEY `hostal_fk_idx` (`hostal`),
  CONSTRAINT `FKfr943dh4kxh2avt0euc4eahj` FOREIGN KEY (`hostal`) REFERENCES `hostal` (`registration_id`),
  CONSTRAINT `hostal_fk` FOREIGN KEY (`hostal`) REFERENCES `hostal` (`registration_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

LOCK TABLES `building` WRITE;
/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` VALUES (1,'Lucky_Hostal','Incharge1','0891244569','Uppal',1,1);
/*!40000 ALTER TABLE `building` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidate`
--

DROP TABLE IF EXISTS `candidate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidate` (
  `candidate_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `mobile_no` varchar(45) DEFAULT NULL,
  `emergency_contact_no` varchar(45) DEFAULT NULL,
  `occupation` varchar(45) DEFAULT NULL,
  `work_place` varchar(45) DEFAULT NULL,
  `id_type` varchar(45) DEFAULT NULL,
  `id_no` varchar(45) DEFAULT NULL,
  `photo` varchar(200) DEFAULT NULL,
  `id_proof` varchar(200) DEFAULT NULL,
  `room` int(11) DEFAULT NULL,
  `join_date` date NOT NULL,
  `can_payment_date` date DEFAULT NULL,
  `candidate_fee` int(11) DEFAULT NULL,
  `due_amount` int(11) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `payment_status` varchar(45) DEFAULT NULL COMMENT 'complete/pending',
  `isActive` int(11) NOT NULL,
  `vacatin_Date` date DEFAULT NULL,
  `vaction_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`candidate_id`),
  KEY `room_fk_idx` (`room`),
  CONSTRAINT `FKe115sy31dvva2buotahjgfs4g` FOREIGN KEY (`room`) REFERENCES `room` (`room_id`),
  CONSTRAINT `room_fk` FOREIGN KEY (`room`) REFERENCES `room` (`room_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate`
--

LOCK TABLES `candidate` WRITE;
/*!40000 ALTER TABLE `candidate` DISABLE KEYS */;
INSERT INTO `candidate` VALUES (10,'Srinivas Nalla','gwk','9441469449','9845698771','adsfadf','asdf','Adhar','123456',NULL,NULL,19,'2016-07-06','2016-07-07',5000,1500,'2016-07-15','Pending',1,NULL,NULL),(11,'Sudharshan','vskp','8977424231','9845698771','Employee','Genpact','Adhar','123654',NULL,NULL,2,'2016-07-06','2016-07-07',5000,1500,'2016-07-08','Pending',1,NULL,NULL),(12,'Pradeep raju','vskp','8977424231','9845698771','Employee','Genpact','Adhar','123654',NULL,NULL,15,'2016-07-06','2016-07-07',5000,5000,'2016-08-06','DONE',1,NULL,NULL);
/*!40000 ALTER TABLE `candidate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `floor`
--

DROP TABLE IF EXISTS `floor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `floor` (
  `floor_id` int(11) NOT NULL AUTO_INCREMENT,
  `floor_name` varchar(45) DEFAULT NULL,
  `building` int(11) NOT NULL,
  `isActive` int(11) DEFAULT NULL,
  PRIMARY KEY (`floor_id`),
  KEY `building_fk_idx` (`building`),
  CONSTRAINT `FKrpbrepxfxyjjhkd53ui7w1saf` FOREIGN KEY (`building`) REFERENCES `building` (`building_id`),
  CONSTRAINT `building_fk` FOREIGN KEY (`building`) REFERENCES `building` (`building_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `floor`
--

LOCK TABLES `floor` WRITE;
/*!40000 ALTER TABLE `floor` DISABLE KEYS */;
INSERT INTO `floor` VALUES (1,'1ST Floor',1,1),(2,'2ND Floor',1,1),(3,'3RD Floor',1,1);
/*!40000 ALTER TABLE `floor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hostal`
--

DROP TABLE IF EXISTS `hostal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hostal` (
  `registration_id` int(11) NOT NULL,
  `hostal_name` varchar(60) DEFAULT NULL,
  `createdOn` timestamp NULL DEFAULT NULL,
  `owner_name` varchar(90) DEFAULT NULL,
  `contact_no` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`registration_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hostal`
--

LOCK TABLES `hostal` WRITE;
/*!40000 ALTER TABLE `hostal` DISABLE KEYS */;
INSERT INTO `hostal` VALUES (1,'Lucky',NULL,'Test User','9441469449','9441469449','Uppal');
/*!40000 ALTER TABLE `hostal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `paid_amount` int(11) DEFAULT NULL,
  `paid_date` date DEFAULT NULL,
  `candidate` int(11) DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `candidate_fk_idx` (`candidate`),
  CONSTRAINT `FKpgdx2bdllt1prjjo8lmhennbd` FOREIGN KEY (`candidate`) REFERENCES `candidate` (`candidate_id`),
  CONSTRAINT `candidate_fk` FOREIGN KEY (`candidate`) REFERENCES `candidate` (`candidate_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `room_id` int(11) NOT NULL,
  `room_name` varchar(45) DEFAULT NULL,
  `floor` int(11) DEFAULT NULL,
  `room_type` int(11) DEFAULT NULL,
  `building` int(11) DEFAULT NULL,
  `isActive` int(11) DEFAULT NULL,
  PRIMARY KEY (`room_id`),
  KEY `floor_fk_idx` (`floor`),
  KEY `room_type_fk_idx` (`room_type`),
  KEY `FKnk8x6t7wwcp6vj7rgc4corgg4` (`building`),
  CONSTRAINT `FKcqumi2d897rcl5bi4ec6bu44e` FOREIGN KEY (`floor`) REFERENCES `floor` (`floor_id`),
  CONSTRAINT `FKjqba0xr3uunct3qvjovj8bs9n` FOREIGN KEY (`room_type`) REFERENCES `room_type` (`room_type_id`),
  CONSTRAINT `FKnk8x6t7wwcp6vj7rgc4corgg4` FOREIGN KEY (`building`) REFERENCES `building` (`building_id`),
  CONSTRAINT `floor_fk` FOREIGN KEY (`floor`) REFERENCES `floor` (`floor_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `room_type_fk` FOREIGN KEY (`room_type`) REFERENCES `room_type` (`room_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'101',1,1,1,1),(2,'102',1,2,1,1),(3,'103',1,3,1,1),(4,'104',1,4,1,1),(5,'105',1,5,1,1),(6,'106',1,6,1,1),(7,'201',2,1,1,1),(8,'202',2,2,1,1),(9,'203',2,3,1,1),(10,'204',2,4,1,1),(11,'205',2,5,1,1),(12,'206',2,6,1,1),(13,'301',3,1,1,1),(14,'302',3,2,1,1),(15,'303',3,3,1,1),(16,'304',3,4,1,1),(17,'305',3,5,1,1),(18,'306',3,6,1,1),(19,'107',1,2,1,1);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_type`
--

DROP TABLE IF EXISTS `room_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room_type` (
  `room_type_id` int(11) NOT NULL,
  `room_category` varchar(45) DEFAULT NULL,
  `cost` varchar(45) DEFAULT NULL,
  `isActive` int(11) DEFAULT '1' COMMENT '1 for active',
  `capacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`room_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_type`
--

LOCK TABLES `room_type` WRITE;
/*!40000 ALTER TABLE `room_type` DISABLE KEYS */;
INSERT INTO `room_type` VALUES (1,'1-Share','7000',1,1),(2,'2-Share','5500',1,2),(3,'3-Share','4500',1,3),(4,'4-Share','4000',1,4),(5,'5-Share','3500',1,5),(6,'6-Share','3000',1,6);
/*!40000 ALTER TABLE `room_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-06 21:04:58
