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
-- Table structure for table `Show`
--

DROP TABLE IF EXISTS `Show`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Show` (
  `sid` varchar(100) NOT NULL,
  `timings` varchar(100) DEFAULT NULL,
  `no_of_balcony_seats` int(11) DEFAULT NULL,
  `no_of_ordinary_seats` int(11) DEFAULT NULL,
  `sm_id` varchar(100) DEFAULT NULL,
  `date` varchar(100) DEFAULT '122',
  `balcony_rate` double DEFAULT '12.3',
  `ordinary_rate` double DEFAULT '12.3',
  `ShowName` varchar(50) DEFAULT NULL,
  `number` int(11) DEFAULT '0',
  PRIMARY KEY (`sid`),
  KEY `fk_show3` (`sm_id`),
  CONSTRAINT `fk_show3` FOREIGN KEY (`sm_id`) REFERENCES `ShowManger` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Show`
--

LOCK TABLES `Show` WRITE;
/*!40000 ALTER TABLE `Show` DISABLE KEYS */;
INSERT INTO `Show` VALUES ('Bharath','01:12:33',20,20,'r141076','01/07/2018',20,20,'Bharath ane Nenu',1),('brundavam','01:23:23',400,400,'r141076','18/04/2018',500,450,'Brundavam Jr NTR',0),('cd','01:23:23',40,40,'r141076','01/07/2018',30,30,'udbu',1),('cema','01:02:33',50,50,'r141076','21/04/2018',200,150,'Seema tapakai',0),('CinemaChupistamama','01:02:20',100,100,'r141076','20/04/2018',50,50,'Cinema Chupista Mama',0),('kota','01:22:12',2,0,'r141076','01/03/2018',500,500,'kota sreenu',-1),('mana','01:23:23',30,30,'r141076','01/07/2018',30,30,'i am a man',1),('nar','01:12:33',40,40,'r141076','18/04/2018',50,50,'Narasimha Movie',0),('nkan','01:00:00',2,3,'r141076','12/03/2018',20,30,'mjdj',-1),('RaceGurram','01:12:33',300,250,'r141076','18/04/2018',300,250,'Race Gurram Allu Arjun',0),('ranaNrt','01:23:23',30,30,'r141076','11/04/2018',200,150,'naa peru surya naa illu india',-1),('RandyOrten','01:23:23',30,30,'r141076','01/07/2018',30,30,'Randy Orten Guide',1),('rrr','01:23:23',30,30,'r141076','01/06/2018',300,250,'rajmouli ramarao ram',1);
/*!40000 ALTER TABLE `Show` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-12 17:26:24
