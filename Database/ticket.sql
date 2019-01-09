-- MySQL dump 10.13  Distrib 5.6.25, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: SAMS
-- ------------------------------------------------------
-- Server version	5.6.25-0ubuntu0.15.04.1

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
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `tid` int(11) NOT NULL,
  `seat_id` varchar(100) DEFAULT NULL,
  `timing` varchar(100) DEFAULT NULL,
  `Type` varchar(100) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `userid` varchar(100) DEFAULT NULL,
  `showid` varchar(50) DEFAULT 'sagar',
  `ShowName` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (15,'b15','01:23:23','balcony','01/07/2018',30,'u2','cd','udbu'),(16,'b16','01:23:23','balcony','01/07/2018',30,'u2','cd','udbu'),(20,'b0','01:23:23','balcony','01/06/2018',0,'Show_Manager','rrr','rajmouli ramarao ram'),(21,'o0','01:23:23','ordinary','01/06/2018',0,'Show_Manager','rrr','rajmouli ramarao ram'),(26,'b9','01:12:33','balcony','01/07/2018',20,'fun','Bharath','Bharath ane Nenu'),(27,'b0','01:23:23','balcony','18/04/2018',500,'u1','brundavam','Brundavam Jr NTR'),(28,'b1','01:23:23','balcony','18/04/2018',500,'u1','brundavam','Brundavam Jr NTR'),(32,'b101','01:23:23','balcony','18/04/2018',500,'nar','brundavam','Brundavam Jr NTR'),(33,'b10','01:12:33','balcony','18/04/2018',300,'u2','RaceGurram','Race Gurram Allu Arjun'),(34,'b102','01:12:33','balcony','18/04/2018',300,'u2','RaceGurram','Race Gurram Allu Arjun'),(35,'b103','01:12:33','balcony','18/04/2018',300,'u2','RaceGurram','Race Gurram Allu Arjun'),(36,'o8','01:12:33','ordinary','01/07/2018',0,'Show_Manager','Bharath','Bharath ane Nenu'),(37,'o7','01:12:33','ordinary','01/07/2018',0,'Show_Manager','Bharath','Bharath ane Nenu'),(38,'o9','01:12:33','ordinary','01/07/2018',0,'Show_Manager','Bharath','Bharath ane Nenu'),(39,'b11','01:12:33','balcony','01/07/2018',20,'Tirupal','Bharath','Bharath ane Nenu'),(40,'o10','01:12:33','ordinary','01/07/2018',20,'Ashok','Bharath','Bharath ane Nenu'),(41,'b0','01:02:33','balcony','21/04/2018',200,'u2','cema','Seema tapakai'),(42,'b1','01:02:33','balcony','21/04/2018',200,'u2','cema','Seema tapakai'),(44,'o1','01:02:33','ordinary','21/04/2018',150,'u2','cema','Seema tapakai'),(45,'o3','01:12:33','ordinary','01/07/2018',20,'u1','Bharath','Bharath ane Nenu'),(46,'o28','01:23:23','ordinary','01/06/2018',250,'u1','rrr','rajmouli ramarao ram'),(47,'b12','01:23:23','balcony','01/07/2018',0,'Show_Manager','mana','i am a man');
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-12 17:28:06
