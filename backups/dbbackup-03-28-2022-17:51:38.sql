-- MariaDB dump 10.19  Distrib 10.7.3-MariaDB, for Linux (x86_64)
--
-- Host: 192.168.0.10    Database: t18database
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activejoblist`
--

DROP TABLE IF EXISTS `activejoblist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activejoblist` (
  `jobID` int DEFAULT NULL,
  `CustomerID` int DEFAULT NULL,
  `duration` int DEFAULT NULL,
  `mechanic` varchar(50) DEFAULT NULL,
  `details` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activejoblist`
--

LOCK TABLES `activejoblist` WRITE;
/*!40000 ALTER TABLE `activejoblist` DISABLE KEYS */;
/*!40000 ALTER TABLE `activejoblist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customermemberlist`
--

DROP TABLE IF EXISTS `customermemberlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customermemberlist` (
  `ID` int DEFAULT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `discountplan` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customermemberlist`
--

LOCK TABLES `customermemberlist` WRITE;
/*!40000 ALTER TABLE `customermemberlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `customermemberlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `joblist`
--

DROP TABLE IF EXISTS `joblist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `joblist` (
  `jobID` int NOT NULL,
  `jobStatus` varchar(255) NOT NULL,
  `timeTaken` int DEFAULT NULL,
  `vehicleID` int NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `bookingID` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `joblist`
--

LOCK TABLES `joblist` WRITE;
/*!40000 ALTER TABLE `joblist` DISABLE KEYS */;
/*!40000 ALTER TABLE `joblist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pendingjoblist`
--

DROP TABLE IF EXISTS `pendingjoblist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pendingjoblist` (
  `jobID` int DEFAULT NULL,
  `CustomerID` int DEFAULT NULL,
  `details` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pendingjoblist`
--

LOCK TABLES `pendingjoblist` WRITE;
/*!40000 ALTER TABLE `pendingjoblist` DISABLE KEYS */;
/*!40000 ALTER TABLE `pendingjoblist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useraccounts`
--

DROP TABLE IF EXISTS `useraccounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useraccounts` (
  `username` varchar(50) DEFAULT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `user_password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `user_role` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraccounts`
--

LOCK TABLES `useraccounts` WRITE;
/*!40000 ALTER TABLE `useraccounts` DISABLE KEYS */;
INSERT INTO `useraccounts` VALUES
('Jade1','Jade','Rice','password','JadeRice@gmail.com','Admin'),
('Mia1','Mia','Kemp','password','MiaKemp@gmail.com','Admin'),
('Patrick1','Patrick','Booth','password','PatrickBooth@gmail.com','Admin'),
('Charles1','Charles','Simmons','password','CharlesSimmons@gmail.com','Admin'),
('Taylor1','Taylor','Stone','password','TaylorStone@gmail.com','Admin'),
('Ryan1','Ryan','Bibi','password','RyanBibi@gmail.com','Admin'),
('Ewan1','Ewan','Chandler','password','EwanChandler@gmail.com','Admin'),
('fasdf',NULL,NULL,'[C@6e6bb270',NULL,'Foreperson'),
('',NULL,NULL,'[C@280f4e99',NULL,'Admin'),
('',NULL,NULL,'[C@798d087f',NULL,'Admin');
/*!40000 ALTER TABLE `useraccounts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-28 17:51:40
