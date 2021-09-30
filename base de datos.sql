-- MySQL dump 10.13  Distrib 8.0.26, for Linux (x86_64)
--
-- Host: localhost    Database: control_de_libros
-- ------------------------------------------------------
-- Server version	8.0.26-0ubuntu0.20.04.2

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Juan','Guatemala','+502 55555555','juan@gmail.com'),(2,'Pedro','Peten','+502 55556666','pedro@email.com'),(3,'Marta','Huehuetenango','+502 66665555','marta@mail.com'),(4,'Pablo','Peten','5555555','pablo@peten.com'),(5,'Maria','Huehuetenango','+502 66665555','marta@mail.com'),(6,'bbb','bbbb','bbb','bbb@bb');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ejemplares`
--

DROP TABLE IF EXISTS `ejemplares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ejemplares` (
  `numero` int NOT NULL,
  `referencia_libro` int NOT NULL,
  PRIMARY KEY (`numero`,`referencia_libro`),
  KEY `referencia_libro` (`referencia_libro`),
  CONSTRAINT `ejemplares_ibfk_1` FOREIGN KEY (`referencia_libro`) REFERENCES `libros` (`codigo_libro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejemplares`
--

LOCK TABLES `ejemplares` WRITE;
/*!40000 ALTER TABLE `ejemplares` DISABLE KEYS */;
INSERT INTO `ejemplares` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(77777,1);
/*!40000 ALTER TABLE `ejemplares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libros`
--

DROP TABLE IF EXISTS `libros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libros` (
  `codigo_libro` int NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `genero_literario` varchar(45) NOT NULL,
  `editorial` varchar(45) NOT NULL,
  `autor` varchar(45) NOT NULL,
  `anio_edicion` int DEFAULT NULL,
  `numero_edicion` int NOT NULL,
  `pais_origen` varchar(45) NOT NULL,
  `numero_paginas` int NOT NULL,
  `cantidad_ejemplares` int NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  PRIMARY KEY (`codigo_libro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libros`
--

LOCK TABLES `libros` WRITE;
/*!40000 ALTER TABLE `libros` DISABLE KEYS */;
INSERT INTO `libros` VALUES (1,'El PRincipito','Fantasia','Richmond','David Arreaga',2000,0,'Guatemala',100,1000,0.00),(2,'2','2','2','2',NULL,2,'2',2,2,2.00),(3,'3','3','3','3',NULL,3,'3',3,3,3.00),(4,'4','4','4','4',NULL,4,'4',4,4,4.00),(5,'5','5','5','5',NULL,5,'5',5,5,5.00),(6,'6','6','6','6',2021,6,'6',6,6,6.00),(123,'123','123','123','123',NULL,123,'123',123,123,123.00),(234,'sdfsd','sdfsd','sdfsd','sdfsd',NULL,234,'sdfsd',234,456,234.00),(345,'sdf','sdf','sdf','sdf',2021,234,'dfg',234,23423,324.00);
/*!40000 ALTER TABLE `libros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `numero_pedido` int NOT NULL,
  `fecha_pedido` date DEFAULT NULL,
  `referencia_libro` int NOT NULL,
  `referencia_cliente` int NOT NULL,
  `cantidad_compra` int NOT NULL,
  `monto_total` decimal(8,2) NOT NULL,
  PRIMARY KEY (`numero_pedido`),
  KEY `referencia_libro` (`referencia_libro`),
  KEY `referencia_cliente` (`referencia_cliente`),
  CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`referencia_libro`) REFERENCES `libros` (`codigo_libro`),
  CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`referencia_cliente`) REFERENCES `clientes` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (1,'2021-09-01',1,1,111,1111.00),(2,'2021-09-08',1,1,1000,10000.00),(5,'2021-09-24',1,1,5555,555555.00),(6,'2021-09-08',1,1,7,7.00);
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-29 19:45:22
