-- MySQL dump 10.13  Distrib 8.0.21, for macos10.15 (x86_64)
--
-- Host: localhost    Database: willSmithDatabase
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `Imovel`
--

DROP TABLE IF EXISTS `Imovel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Imovel` (
  `idImovel` int NOT NULL AUTO_INCREMENT,
  `disponibilidade` varchar(50) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `area` double DEFAULT NULL,
  `quartos` int DEFAULT NULL,
  `vagas` int DEFAULT NULL,
  `banheiros` int DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `Endereco_idEndereco` int NOT NULL,
  `Anunciante_idAnunciante` int NOT NULL,
  `imagePath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idImovel`),
  KEY `fk_Imovel_Endereco_idx` (`Endereco_idEndereco`),
  KEY `fk_Imovel_Anunciante1_idx` (`Anunciante_idAnunciante`),
  CONSTRAINT `fk_Imovel_Anunciante1` FOREIGN KEY (`Anunciante_idAnunciante`) REFERENCES `Anunciante` (`idAnunciante`),
  CONSTRAINT `fk_Imovel_Endereco` FOREIGN KEY (`Endereco_idEndereco`) REFERENCES `Endereco` (`idEndereco`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Imovel`
--

LOCK TABLES `Imovel` WRITE;
/*!40000 ALTER TABLE `Imovel` DISABLE KEYS */;
INSERT INTO `Imovel` VALUES (1,'Aluguel','Comercial',1202,2,0,1,'Loja em Sobrado',1,1,'Fotos/lojaSobrado.png'),(4,'Venda','Privado',234,1,2,2,'Lote de esquina',1,1,'Fotos/lojaEsquina.png'),(5,'Venda','Privado',800,5,2,4,'Casa de praia bem localizada',3,1,'Fotos/casaPraia.png'),(6,'Venda','Privado',500,1,2,2,'Casa no Lago',1,1,'Fotos/CasaLago.png');
/*!40000 ALTER TABLE `Imovel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-18 21:18:51
