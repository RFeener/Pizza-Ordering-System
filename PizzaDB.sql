CREATE DATABASE  IF NOT EXISTS `pizzadb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `pizzadb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: pizzadb
-- ------------------------------------------------------
-- Server version	5.7.21

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
-- Table structure for table `crusttypes`
--

DROP TABLE IF EXISTS `crusttypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crusttypes` (
  `crustTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`crustTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crusttypes`
--

LOCK TABLES `crusttypes` WRITE;
/*!40000 ALTER TABLE `crusttypes` DISABLE KEYS */;
INSERT INTO `crusttypes` VALUES (1,'Thin Crust',0),(2,'Handmade Pan',2.5),(3,'Original',0),(4,'Gluten-Infused',4.5),(5,'Mozza Stuffed Crust',3);
/*!40000 ALTER TABLE `crusttypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customerid` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `phoneNumber` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `province` varchar(2) DEFAULT NULL,
  `postalCode` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (164,'Ryan M','Feener','5062610134','ryanfeener@gmail.com','205 york street','NF','E3B 3N9'),(165,'Colson','Baker','5556667777','Baker@MGK.com','Trump Tower','NB','E3B 3N9');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `employeeid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`employeeid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'admin','12345');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `totalPrice` float NOT NULL DEFAULT '0',
  `deliveryDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `placedDateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `customerId` int(11) NOT NULL,
  `orderStatus` varchar(45) NOT NULL DEFAULT 'PENDING',
  PRIMARY KEY (`orderId`),
  KEY `customeridFK_idx` (`customerId`),
  CONSTRAINT `customeridFK` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (130,172.78,'2018-12-12 09:27:54','2018-12-12 09:27:28',164,'Complete'),(131,30.19,'2018-12-12 09:31:20','2018-12-12 09:29:16',165,'Pickup');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizza`
--

DROP TABLE IF EXISTS `pizza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizza` (
  `pizzaId` int(11) NOT NULL AUTO_INCREMENT,
  `sizeId` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL DEFAULT '0',
  `crustTypeId` int(11) NOT NULL,
  `price` float NOT NULL,
  `orderId` int(11) NOT NULL,
  PRIMARY KEY (`pizzaId`),
  KEY `crusttypeFK_idx` (`crustTypeId`),
  KEY `sizeidFK_idx` (`sizeId`),
  KEY `orderidFK_idx` (`orderId`),
  CONSTRAINT `crusttypeFK` FOREIGN KEY (`crustTypeId`) REFERENCES `crusttypes` (`crustTypeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `orderidFK` FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sizeidFK` FOREIGN KEY (`sizeId`) REFERENCES `sizes` (`sizeid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=209 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza`
--

LOCK TABLES `pizza` WRITE;
/*!40000 ALTER TABLE `pizza` DISABLE KEYS */;
INSERT INTO `pizza` VALUES (206,16,5,5,77.5,130),(207,16,1,5,15.5,131),(208,10,1,5,8,131);
/*!40000 ALTER TABLE `pizza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizza_toppings_map`
--

DROP TABLE IF EXISTS `pizza_toppings_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizza_toppings_map` (
  `toppingId` int(11) NOT NULL,
  `pizzaId` int(11) NOT NULL,
  `pizza_toppings_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pizza_toppings_id`),
  KEY `pizzaidFK_idx` (`pizzaId`),
  KEY `toppingidFK` (`toppingId`),
  CONSTRAINT `pizzaidFK` FOREIGN KEY (`pizzaId`) REFERENCES `pizza` (`pizzaId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `toppingidFK` FOREIGN KEY (`toppingId`) REFERENCES `toppings` (`toppingId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=306 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza_toppings_map`
--

LOCK TABLES `pizza_toppings_map` WRITE;
/*!40000 ALTER TABLE `pizza_toppings_map` DISABLE KEYS */;
INSERT INTO `pizza_toppings_map` VALUES (22,206,297),(23,206,298),(26,206,299),(27,206,300),(28,206,301),(29,206,302),(23,207,303),(26,207,304),(28,208,305);
/*!40000 ALTER TABLE `pizza_toppings_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sizes`
--

DROP TABLE IF EXISTS `sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sizes` (
  `sizeid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`sizeid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sizes`
--

LOCK TABLES `sizes` WRITE;
/*!40000 ALTER TABLE `sizes` DISABLE KEYS */;
INSERT INTO `sizes` VALUES (8,'Personal Size',2.5),(10,'Small',5),(12,'Medium',7.5),(14,'Large',10),(16,'Extra Large',12.5);
/*!40000 ALTER TABLE `sizes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `toppings`
--

DROP TABLE IF EXISTS `toppings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `toppings` (
  `toppingId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` float NOT NULL DEFAULT '0',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `empAddedBy` int(11) NOT NULL,
  `isActive` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`toppingId`),
  KEY `employeeidFK_idx` (`empAddedBy`),
  CONSTRAINT `employeeidFK` FOREIGN KEY (`empAddedBy`) REFERENCES `employee` (`employeeid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toppings`
--

LOCK TABLES `toppings` WRITE;
/*!40000 ALTER TABLE `toppings` DISABLE KEYS */;
INSERT INTO `toppings` VALUES (22,'Bacon',2.99,'2018-12-12 13:24:42',1,1),(23,'Onions',0.75,'2018-12-12 13:24:42',1,1),(26,'Green Peppers',0.75,'2018-12-12 13:25:43',1,1),(27,'Pepperoni',0.55,'2018-12-12 13:25:52',1,1),(28,'Extra Cheese',1.25,'2018-12-12 13:26:08',1,1),(29,'BBQ Chicken',3.25,'2018-12-12 13:26:22',1,1),(30,'Chefs Spit',0.55,'2018-12-12 13:27:17',1,0);
/*!40000 ALTER TABLE `toppings` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-12  9:38:39
