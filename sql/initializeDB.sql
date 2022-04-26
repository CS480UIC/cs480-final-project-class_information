-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: initializedb.sql
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `assignment`
--
CREATE DATABASE class_information;
use class_information;

DROP TABLE IF EXISTS `assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
Create Table assignment(
    classid int not NULL,
    assignmentid int UNIQUE, 
    title VarChar(20),
    descriptions VarChar(20), 
    files VarChar(20), 
    due_date Date, 
    atype VarChar(20),
    Primary Key(assignmentid),
    Foreign Key(classid) references class(classid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignment`
--

LOCK TABLES `assignment` WRITE;
/*!40000 ALTER TABLE `assignment` DISABLE KEYS */;
INSERT INTO `assignment` VALUES (11,1,'PD 1','Indiivudally think about assignment','Assignment1.pdf','1/3/2022','Homework'),(11,2,'PD 2','As a group think about assignment','Assignment2.pdf','1/25/2022','Homework'),(11,3,'PD 3','Run base java code','Assignment3.pdf','2/15/2022','Homework'),(11,4,'PD 4','Run template Tomcat cope','Assignment4.pdf','2/22/2022','Homework'),(11,5,'PD 5','This assignment','Assignment5.pdf','3/32022','Project');
/*!40000 ALTER TABLE `assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
Create Table class(
    classid int unique,
    class_name VarChar(20) NOT NULL, 
    instructoruid int NOT NULL, 
    semester VarChar(20) NOT NULL , 
    Primary Key(classid),
    Foreign Key(instructoruid) references instructor(instructoruid)
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
Create Table course_content(
    fileid int unique, 
    files VarChar(20), 
    descriptions VarChar(100), 
    lectureDate Date, 
    lectureid int, 
    content_type VarChar(10),
	classid int not null, 
    Primary Key(fileid), 
    FOREIGN Key(classid) references class(classid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_content`
--

LOCK TABLES `course_content` WRITE;
/*!40000 ALTER TABLE `course_content` DISABLE KEYS */;
INSERT INTO `course_content` VALUES (1,'Lecture1.pdf','what is data','1/13/2022',1,'PDF',11),(2,'Lecture1.mp4','data lecture','1/13/2022',1,'MP4',11),(3,'Lecture2.pdf','what is table','1/15/2022',2,'PDF',11),(4,'Lecture3.doc','example sql','1/17/2022',3,'DOC',11),(5,'Leture4.pdf','build sql','1/18/2022',4,'PDF',11);
/*!40000 ALTER TABLE `course_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
Create Table grade(
	gradeid int unique,
    studentuid int NOT NULL, 
    assignmentid int not null, 
    total_points int, 
    points_earned int, 
    Primary Key(gradeid),
    foreign key(studentuid) references student(studentid),
    foreign key(assignmentid) references assignment(assignmentid)
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
Create Table instructor(
    instructoruid INT UNIQUE, 
    instructorname Varchar(20) NOT NULL, 
    classid INT NOT NULL,
    Primary Key(instructoruid),
    Foreign Key(instructoruid) references roles(useruid),
    Foreign Key(classid) references class(classid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructor`
--

LOCK TABLES `instructor` WRITE;
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` VALUES (2, 'Samuel', 11),(3, 'Anthony',13),(5, 'Veronica', 15),(8, 'Ashley', 17),(9, 'Luna', 19),(10, 'Bob', 2);
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
Create Table roles(
    useruid INT UNIQUE, 
    roles VARCHAR(20), 
    admins bool, 
    FOREIGN KEY(useruid) references user(uid),
    Primary Key(useruid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rolse`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Student','False '),(2,'Teacher','False '),(3,'Teacher','TRUE'),(4,'Student','TRUE'),(5,'Teacher','False '),(6,'Student','False '),(7,'Student ','False '),(8,'Teacher','False '),(9,'Teacher','False '),(10,'Teacher','False '),(11,'Student ','TRUE');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
Create Table student(
    studentid int unique, 
    classID int NOT NULL, 
    enrolled Bool NOT NULL, 
    degree_type VarChar(10),
    studentname VarChar(20) Not NULL, 
    Primary Key(studentid), 
    Foreign Key(studentid) references roles(useruid),
    Foreign Key(classid) references class(classid),
    CONSTRAINT CHK_degree CHECK (degree_type = 'undergrad' or degree_type = 'masters' or degree_type = 'phd')
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('1','15','TRUE','undergrad', 'Joshua'),('4','13','TRUE','masters', 'Jibreel'),('6','11','TRUE','phd', 'Sophie'),('7',NULL,'False ','phd', 'Albedo');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
Create Table user(
    uid INT UNIQUE, 
    name VARCHAR(20) NOT NULL, 
    username VarChar(20) NOT NULL, 
    password VarChar(20) NOT NULL, 
    Primary Key(uid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Josh ','jdudle4','not1234'),(2,'Jibreel ','notjibreel','1234goodpass'),(3,'John ','johnisgreat','!!!john!!!'),(44,'jay','genshin123','i<3genshin'),(4,' turtle','iliketurtles','turtles'),(5,'bob','bob123','1234abcd'),(6,'haily','haily5','iamhaily5'),(7,'lucas','lucas33','defnotlucas'),(8,'james','2james','jamesisjames'),(9,'noah','2nOah','nameboat'),(10,'henry','henry2nd','iamking'),(11,'william','Wiliam3rd','williamthethird');
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

-- Dump completed on 2022-03-31 14:07:26