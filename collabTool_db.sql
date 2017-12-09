-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: collabTool_db
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `ct_tasks`
--

DROP TABLE IF EXISTS `ct_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ct_tasks` (
  `taskId` int(20) NOT NULL AUTO_INCREMENT,
  `taskName` varchar(100) NOT NULL,
  `taskdescription` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`taskId`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ct_tasks`
--

LOCK TABLES `ct_tasks` WRITE;
/*!40000 ALTER TABLE `ct_tasks` DISABLE KEYS */;
INSERT INTO `ct_tasks` VALUES (30,'Shopping','Diwali Shopping'),(31,'Studying','For interview'),(32,'Doctor','Vitamin D Injection'),(33,'Yoga','yoga classes'),(34,'Painting','craft project');
/*!40000 ALTER TABLE `ct_tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ct_users`
--

DROP TABLE IF EXISTS `ct_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ct_users` (
  `userid` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ct_users`
--

LOCK TABLES `ct_users` WRITE;
/*!40000 ALTER TABLE `ct_users` DISABLE KEYS */;
INSERT INTO `ct_users` VALUES (1,'Aastha','aasthasinghal1@gmail.com','Harry13#'),(2,'123user','123@dom.com','password');
/*!40000 ALTER TABLE `ct_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ct_users_tasks`
--

DROP TABLE IF EXISTS `ct_users_tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ct_users_tasks` (
  `relationId` int(20) NOT NULL AUTO_INCREMENT,
  `userid` int(20) NOT NULL,
  `taskId` int(20) NOT NULL,
  PRIMARY KEY (`relationId`),
  KEY `fk_user_id` (`userid`),
  KEY `fk_task_id` (`taskId`),
  CONSTRAINT `fk_task_id` FOREIGN KEY (`taskId`) REFERENCES `ct_tasks` (`taskId`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`userid`) REFERENCES `ct_users` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ct_users_tasks`
--

LOCK TABLES `ct_users_tasks` WRITE;
/*!40000 ALTER TABLE `ct_users_tasks` DISABLE KEYS */;
INSERT INTO `ct_users_tasks` VALUES (28,1,31),(29,1,32),(30,1,33),(31,2,34);
/*!40000 ALTER TABLE `ct_users_tasks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-28  0:06:37
