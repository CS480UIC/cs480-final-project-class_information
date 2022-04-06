-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: class_information
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assignment`
--

DROP TABLE IF EXISTS `assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignment` (
  `classid` int NOT NULL,
  `assignmentid` int NOT NULL,
  `title` varchar(20) DEFAULT NULL,
  `descriptions` varchar(20) DEFAULT NULL,
  `files` varchar(20) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `atype` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`assignmentid`),
  UNIQUE KEY `assignmentid` (`assignmentid`),
  KEY `classid` (`classid`),
  CONSTRAINT `assignment_ibfk_1` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignment`
--

LOCK TABLES `assignment` WRITE;
/*!40000 ALTER TABLE `assignment` DISABLE KEYS */;
INSERT INTO `assignment` VALUES (11,1,'PD 1','Indiivudally think a','Assignment1.pdf','0000-00-00','Homework'),(11,2,'PD 2','As a group think abo','Assignment2.pdf','0000-00-00','Homework'),(11,3,'PD 3','Run base java code','Assignment3.pdf','0000-00-00','Homework'),(11,4,'PD 4','Run template Tomcat ','Assignment4.pdf','0000-00-00','Homework'),(11,5,'PD 5','This assignment','Assignment5.pdf','0000-00-00','Project');
/*!40000 ALTER TABLE `assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `classid` int NOT NULL,
  `class_name` varchar(20) NOT NULL,
  `instructoruid` int NOT NULL,
  `semester` varchar(20) NOT NULL,
  PRIMARY KEY (`classid`),
  UNIQUE KEY `classid` (`classid`),
  KEY `instructoruid` (`instructoruid`),
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`instructoruid`) REFERENCES `instructor` (`instructoruid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (11,'CS480',2,'Fall 2021'),(13,'CS411',3,'Fall 2021'),(15,'CS412',5,'Sping 2021'),(17,'CS421',8,'Summer 2021'),(19,'CS499',9,'Summer 2021');
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_content`
--

DROP TABLE IF EXISTS `course_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_content` (
  `fileid` int NOT NULL,
  `files` varchar(20) DEFAULT NULL,
  `descriptions` varchar(100) DEFAULT NULL,
  `lectureDate` date DEFAULT NULL,
  `lectureid` int DEFAULT NULL,
  `content_type` varchar(10) DEFAULT NULL,
  `classid` int NOT NULL,
  PRIMARY KEY (`fileid`),
  UNIQUE KEY `fileid` (`fileid`),
  KEY `classid` (`classid`),
  CONSTRAINT `course_content_ibfk_1` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_content`
--

LOCK TABLES `course_content` WRITE;
/*!40000 ALTER TABLE `course_content` DISABLE KEYS */;
INSERT INTO `course_content` VALUES (1,'Lecture1.pdf','what is data','0000-00-00',1,'PDF',11),(2,'Lecture1.mp4','data lecture','0000-00-00',1,'MP4',11),(3,'Lecture2.pdf','what is table','0000-00-00',2,'PDF',11),(4,'Lecture3.doc','example sql','0000-00-00',3,'DOC',11),(5,'Leture4.pdf','build sql','0000-00-00',4,'PDF',11);
/*!40000 ALTER TABLE `course_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grade` (
  `gradeid` int NOT NULL,
  `studentuid` int NOT NULL,
  `assignmentid` int NOT NULL,
  `total_points` int DEFAULT NULL,
  `points_earned` int DEFAULT NULL,
  PRIMARY KEY (`gradeid`),
  UNIQUE KEY `gradeid` (`gradeid`),
  KEY `studentuid` (`studentuid`),
  KEY `assignmentid` (`assignmentid`),
  CONSTRAINT `grade_ibfk_1` FOREIGN KEY (`studentuid`) REFERENCES `student` (`studentid`),
  CONSTRAINT `grade_ibfk_2` FOREIGN KEY (`assignmentid`) REFERENCES `assignment` (`assignmentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (1,6,1,95,100),(2,6,2,32,100),(3,6,3,16,100),(4,6,4,64,100),(5,6,5,100,100);
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructor`
--

DROP TABLE IF EXISTS `instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructor` (
  `instructoruid` int NOT NULL,
  `instructorname` varchar(20) NOT NULL,
  `classid` int NOT NULL,
  PRIMARY KEY (`instructoruid`),
  UNIQUE KEY `instructoruid` (`instructoruid`),
  KEY `classid` (`classid`),
  CONSTRAINT `instructor_ibfk_1` FOREIGN KEY (`instructoruid`) REFERENCES `roles` (`useruid`),
  CONSTRAINT `instructor_ibfk_2` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES (2,'Samuel',11),(3,'Anthony',13),(5,'Veronica',15),(8,'Ashley',17),(9,'Luna',19),(10,'Bob',2);
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `useruid` int NOT NULL,
  `roles` varchar(20) DEFAULT NULL,
  `admins` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`useruid`),
  UNIQUE KEY `useruid` (`useruid`),
  CONSTRAINT `roles_ibfk_1` FOREIGN KEY (`useruid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Student',0),(2,'Teacher',0),(3,'Teacher',0),(4,'Student',0),(5,'Teacher',0),(6,'Student',0),(7,'Student ',0),(8,'Teacher',0),(9,'Teacher',0),(10,'Teacher',0),(11,'Student ',0);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `studentid` int NOT NULL,
  `classID` int NOT NULL,
  `enrolled` tinyint(1) NOT NULL,
  `degree_type` varchar(10) DEFAULT NULL,
  `studentname` varchar(20) NOT NULL,
  PRIMARY KEY (`studentid`),
  UNIQUE KEY `studentid` (`studentid`),
  KEY `classID` (`classID`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`studentid`) REFERENCES `roles` (`useruid`),
  CONSTRAINT `student_ibfk_2` FOREIGN KEY (`classID`) REFERENCES `class` (`classid`),
  CONSTRAINT `CHK_degree` CHECK (((`degree_type` = _utf8mb3'undergrad') or (`degree_type` = _utf8mb3'masters') or (`degree_type` = _utf8mb3'phd')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,15,0,'undergrad','Joshua'),(4,13,0,'masters','Jibreel'),(6,11,0,'phd','Sophie'),(7,0,0,'phd','Albedo');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `uid` int NOT NULL,
  `name` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Josh ','jdudle4','not1234'),(2,'Jibreel ','notjibreel','1234goodpass'),(3,'John ','johnisgreat','!!!john!!!'),(4,' turtle','iliketurtles','turtles'),(5,'bob','bob123','1234abcd'),(6,'haily','haily5','iamhaily5'),(7,'lucas','lucas33','defnotlucas'),(8,'james','2james','jamesisjames'),(9,'noah','2nOah','nameboat'),(10,'henry','henry2nd','iamking'),(11,'william','Wiliam3rd','williamthethird'),(44,'jay','genshin123','i<3genshin');
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

-- Dump completed on 2022-04-01 22:33:11
