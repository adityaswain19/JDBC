CREATE DATABASE  IF NOT EXISTS `java_clg_app` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `java_clg_app`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: java_clg_app
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `admission`
--

DROP TABLE IF EXISTS `admission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admission` (
  `admission_id` int NOT NULL AUTO_INCREMENT,
  `candidate_name` varchar(45) NOT NULL,
  `date_of_admission` date NOT NULL,
  `college_id` int NOT NULL,
  PRIMARY KEY (`admission_id`),
  KEY `fk_college_id_idx` (`college_id`),
  CONSTRAINT `fk_college_id` FOREIGN KEY (`college_id`) REFERENCES `college` (`college_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admission`
--

LOCK TABLES `admission` WRITE;
/*!40000 ALTER TABLE `admission` DISABLE KEYS */;
INSERT INTO `admission` VALUES (1,'Aditya','2025-11-05',100);
/*!40000 ALTER TABLE `admission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `college`
--

DROP TABLE IF EXISTS `college`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `college` (
  `college_id` int NOT NULL AUTO_INCREMENT,
  `college_name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `no_of_seats` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`college_id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `college`
--

LOCK TABLES `college` WRITE;
/*!40000 ALTER TABLE `college` DISABLE KEYS */;
INSERT INTO `college` VALUES (100,'ITER','BBSR','1200'),(101,'KIIT','CUTTACK','2000'),(102,'CV Raman','Jatni','1000'),(103,'BJB','BBSR','800'),(104,'VSSUT','Burla','500'),(105,'TRIDENT','BBSR','100');
/*!40000 ALTER TABLE `college` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departments` (
  `DepartmentId` int NOT NULL AUTO_INCREMENT,
  `DepartmentCode` varchar(20) NOT NULL,
  `DepartmentName` varchar(100) NOT NULL,
  `Status` varchar(10) NOT NULL,
  `CreatedAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UpdatedAt` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`DepartmentId`),
  UNIQUE KEY `DepartmentCode` (`DepartmentCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state` (
  `state_id` int NOT NULL AUTO_INCREMENT,
  `state_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'Odisha'),(2,'TN');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_course`
--

DROP TABLE IF EXISTS `t_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_course` (
  `course_id` int NOT NULL,
  `course_name` varchar(45) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `Credit_score` int DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_course`
--

LOCK TABLES `t_course` WRITE;
/*!40000 ALTER TABLE `t_course` DISABLE KEYS */;
INSERT INTO `t_course` VALUES (1,'JAVA','REGULAR',4),(2,'C','DISTANCE',3),(3,'C++','REGULAR',5);
/*!40000 ALTER TABLE `t_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_student`
--

DROP TABLE IF EXISTS `t_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_student` (
  `roll_no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `enrollment_date` date NOT NULL,
  `course_id` int NOT NULL,
  PRIMARY KEY (`roll_no`),
  KEY `course_id_fk_idx` (`course_id`),
  CONSTRAINT `course_id_fk` FOREIGN KEY (`course_id`) REFERENCES `t_course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_student`
--

LOCK TABLES `t_student` WRITE;
/*!40000 ALTER TABLE `t_student` DISABLE KEYS */;
INSERT INTO `t_student` VALUES (1,'Aditya','aditya@swain','2025-11-17',1),(2,'Kishor','kishor@bkl','2024-04-11',2),(3,'Ayash','king@ayash','2027-01-02',1),(4,'Kuldeep','kul@deep','2024-11-04',3);
/*!40000 ALTER TABLE `t_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'java_clg_app'
--

--
-- Dumping routines for database 'java_clg_app'
--
/*!50003 DROP PROCEDURE IF EXISTS `course_proc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `course_proc`(
in p_status varchar(16),
out o_msg varchar(64),
in p_course_id int
)
BEGIN
	if p_status='course' then
       select * from course;
	elseif p_status ='course_by_id' then
       select * from course where course_id=p_course_id;
	end if;
	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-08 12:34:01
