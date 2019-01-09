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
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat` (
  `Sale` varchar(100) DEFAULT NULL,
  `User` varchar(100) DEFAULT NULL,
  `current` varchar(100) DEFAULT NULL,
  `msg` varchar(1000) DEFAULT NULL,
  `number` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES ('u2','fun','fun','hi sir !!',0),('u2','fun','u2','hi what is your name',1),('u2','fun','u2','I AM FINE',1),('u1','u5','u5','Hellow sir i had registerd under you sir plase approve me sir !!!.',1),('u2','manam','manam','hi',1),('u2','nar','nar','Hellow sir i had registerd under you sir plase approve me sir !!!.',0),('u2','nar','u2','ok i will approve you',0),('u2','Tirupal','Tirupal','hi sir i want to register sir please.',0),('u2','Tirupal','Tirupal','hi sir',0),('u2','Tirupal','u2','ok i will approve you',0),('u2','Tirupal','Tirupal','Hellow sir i had registerd under you sir plase approve me sir !!!.',1),('vidyaSagar','jbj','jbj','g',1),('vidyaSagar','jbj','jbj','c',1),('u2','Ashok','Ashok','i want account',1),('u2','Ashok','Ashok','Hellow sir i had registerd under you sir plase approve me sir !!!.',1),('u2','Kanam','Kanam','hi sir how r u?',0),('u2','Kanam','u2','fine u?',1),('u2','Kanam','Kanam','me too',0),('u2','reddy','reddy','hi sir',0),('u2','reddy','reddy','i want to chat',0),('u2','reddy','u2','ok',0),('u2','reddy','reddy','hi u2 how are you?',1);
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-12 17:27:06
