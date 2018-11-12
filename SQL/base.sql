-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: localhost    Database: tpticketunla
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.18.04.1

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
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrador` (
  `idAdministrador` int(11) NOT NULL,
  `idTipoAdministrador` int(11) DEFAULT NULL,
  `idAuditorio` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAdministrador`),
  KEY `administrador-auditorio_idx` (`idAuditorio`),
  KEY `administrador-tipo_idx` (`idTipoAdministrador`),
  CONSTRAINT `administrador-auditorio` FOREIGN KEY (`idAuditorio`) REFERENCES `auditorio` (`idAuditorio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `administrador-tipo` FOREIGN KEY (`idTipoAdministrador`) REFERENCES `tipoadministrador` (`idTipoAdministrador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `administrador-usuario` FOREIGN KEY (`idAdministrador`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auditorio`
--

DROP TABLE IF EXISTS `auditorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auditorio` (
  `idAuditorio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `idTipoAuditorio` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAuditorio`),
  KEY `auditorio-tipo_idx` (`idTipoAuditorio`),
  CONSTRAINT `auditorio-tipo` FOREIGN KEY (`idTipoAuditorio`) REFERENCES `tipoauditorio` (`idTipoAuditorio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditorio`
--

LOCK TABLES `auditorio` WRITE;
/*!40000 ALTER TABLE `auditorio` DISABLE KEYS */;
INSERT INTO `auditorio` VALUES (1,'River Plate',1),(2,'Maipo',2),(3,'Village Avellaneda',3),(4,'VIIage Recoleta',3),(6,'Estadio Unico LP',1),(7,'Luna Park',2);
/*!40000 ALTER TABLE `auditorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `butaca`
--

DROP TABLE IF EXISTS `butaca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `butaca` (
  `idButaca` int(11) NOT NULL AUTO_INCREMENT,
  `fila` int(11) DEFAULT NULL,
  `columna` int(11) DEFAULT NULL,
  `idSector` int(11) DEFAULT NULL,
  PRIMARY KEY (`idButaca`)
) ENGINE=InnoDB AUTO_INCREMENT=277 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `butaca`
--

LOCK TABLES `butaca` WRITE;
/*!40000 ALTER TABLE `butaca` DISABLE KEYS */;
INSERT INTO `butaca` VALUES (1,1,1,2),(2,1,2,2),(3,1,3,2),(4,1,4,2),(5,1,5,2),(6,2,1,2),(7,2,2,2),(8,2,3,2),(9,2,4,2),(10,2,5,2),(11,1,1,4),(12,1,2,4),(13,1,3,4),(14,1,4,4),(15,1,5,4),(16,2,1,4),(17,2,2,4),(18,2,3,4),(19,2,4,4),(20,2,5,4),(21,1,1,6),(22,1,2,6),(23,1,3,6),(24,1,4,6),(25,1,5,6),(26,2,1,6),(27,2,2,6),(28,2,3,6),(29,2,4,6),(30,2,5,6),(31,1,1,10),(32,1,2,10),(33,1,3,10),(34,1,4,10),(35,1,5,10),(36,1,6,10),(37,1,7,10),(38,2,1,10),(39,2,2,10),(40,2,3,10),(41,2,4,10),(42,2,5,10),(43,2,6,10),(44,2,7,10),(45,3,1,10),(46,3,2,10),(47,3,3,10),(48,3,4,10),(49,3,5,10),(50,3,6,10),(51,3,7,10),(52,4,1,10),(53,4,2,10),(54,4,3,10),(55,4,4,10),(56,4,5,10),(57,4,6,10),(58,4,7,10),(59,5,1,10),(60,5,2,10),(61,5,3,10),(62,5,4,10),(63,5,5,10),(64,5,6,10),(65,5,7,10),(66,6,1,10),(67,6,2,10),(68,6,3,10),(69,6,4,10),(70,6,5,10),(71,6,6,10),(72,6,7,10),(73,7,1,10),(74,7,2,10),(75,7,3,10),(76,7,4,10),(77,7,5,10),(78,7,6,10),(79,7,7,10),(129,1,1,12),(130,1,2,12),(131,1,3,12),(132,1,4,12),(133,1,5,12),(134,1,6,12),(135,1,7,12),(136,2,1,12),(137,2,2,12),(138,2,3,12),(139,2,4,12),(140,2,5,12),(141,2,6,12),(142,2,7,12),(143,3,1,12),(144,3,2,12),(145,3,3,12),(146,3,4,12),(147,3,5,12),(148,3,6,12),(149,3,7,12),(150,4,1,12),(151,4,2,12),(152,4,3,12),(153,4,4,12),(154,4,5,12),(155,4,6,12),(156,4,7,12),(157,5,1,12),(158,5,2,12),(159,5,3,12),(160,5,4,12),(161,5,5,12),(162,5,6,12),(163,5,7,12),(164,1,1,13),(165,1,2,13),(166,1,3,13),(167,1,4,13),(168,1,5,13),(169,2,1,13),(170,2,2,13),(171,2,3,13),(172,2,4,13),(173,2,5,13),(174,3,1,13),(175,3,2,13),(176,3,3,13),(177,3,4,13),(178,3,5,13),(179,4,1,13),(180,4,2,13),(181,4,3,13),(182,4,4,13),(183,4,5,13),(184,5,1,13),(185,5,2,13),(186,5,3,13),(187,5,4,13),(188,5,5,13),(189,1,1,14),(190,1,2,14),(191,1,3,14),(192,1,4,14),(193,1,5,14),(194,1,6,14),(195,2,1,14),(196,2,2,14),(197,2,3,14),(198,2,4,14),(199,2,5,14),(200,2,6,14),(201,3,1,14),(202,3,2,14),(203,3,3,14),(204,3,4,14),(205,3,5,14),(206,3,6,14),(207,4,1,14),(208,4,2,14),(209,4,3,14),(210,4,4,14),(211,4,5,14),(212,4,6,14),(213,5,1,14),(214,5,2,14),(215,5,3,14),(216,5,4,14),(217,5,5,14),(218,5,6,14),(219,6,1,14),(220,6,2,14),(221,6,3,14),(222,6,4,14),(223,6,5,14),(224,6,6,14),(225,1,1,15),(226,1,2,15),(227,1,3,15),(228,1,4,15),(229,1,5,15),(230,1,6,15),(231,2,1,15),(232,2,2,15),(233,2,3,15),(234,2,4,15),(235,2,5,15),(236,2,6,15),(237,3,1,15),(238,3,2,15),(239,3,3,15),(240,3,4,15),(241,3,5,15),(242,3,6,15),(243,4,1,15),(244,4,2,15),(245,4,3,15),(246,4,4,15),(247,4,5,15),(248,4,6,15),(249,5,1,15),(250,5,2,15),(251,5,3,15),(252,5,4,15),(253,5,5,15),(254,5,6,15),(255,6,1,15),(256,6,2,15),(257,6,3,15),(258,6,4,15),(259,6,5,15),(260,6,6,15),(261,1,1,16),(262,1,2,16),(263,1,3,16),(264,1,4,16),(265,2,1,16),(266,2,2,16),(267,2,3,16),(268,2,4,16),(269,3,1,16),(270,3,2,16),(271,3,3,16),(272,3,4,16),(273,4,1,16),(274,4,2,16),(275,4,3,16),(276,4,4,16);
/*!40000 ALTER TABLE `butaca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `idTipoCliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `cliente-tipo_idx` (`idTipoCliente`),
  CONSTRAINT `cliente-tipo` FOREIGN KEY (`idTipoCliente`) REFERENCES `tipocliente` (`idTipoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,NULL,1),(2,NULL,2),(4,NULL,1),(6,NULL,1),(7,NULL,3);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `codigo`
--

DROP TABLE IF EXISTS `codigo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `codigo` (
  `idCodigo` int(11) NOT NULL,
  `codigo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idCodigo`),
  CONSTRAINT `codigo-descuento` FOREIGN KEY (`idCodigo`) REFERENCES `descuento` (`idDescuento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codigo`
--

LOCK TABLES `codigo` WRITE;
/*!40000 ALTER TABLE `codigo` DISABLE KEYS */;
/*!40000 ALTER TABLE `codigo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descuento`
--

DROP TABLE IF EXISTS `descuento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `descuento` (
  `idDescuento` int(11) NOT NULL AUTO_INCREMENT,
  `porcentaje` int(11) DEFAULT NULL,
  `usado` bit(1) DEFAULT NULL,
  `idFuncion` int(11) DEFAULT NULL,
  `idSector` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDescuento`),
  KEY `descuento-funcion_idx` (`idFuncion`),
  KEY `descuento-sector_idx` (`idSector`),
  CONSTRAINT `descuento-funcion` FOREIGN KEY (`idFuncion`) REFERENCES `funcion` (`idFuncion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `descuento-sector` FOREIGN KEY (`idSector`) REFERENCES `sector` (`idSector`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descuento`
--

LOCK TABLES `descuento` WRITE;
/*!40000 ALTER TABLE `descuento` DISABLE KEYS */;
/*!40000 ALTER TABLE `descuento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dia`
--

DROP TABLE IF EXISTS `dia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dia` (
  `idDia` int(11) NOT NULL,
  `dia` date DEFAULT NULL,
  PRIMARY KEY (`idDia`),
  CONSTRAINT `dia-descuento` FOREIGN KEY (`idDia`) REFERENCES `descuento` (`idDescuento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dia`
--

LOCK TABLES `dia` WRITE;
/*!40000 ALTER TABLE `dia` DISABLE KEYS */;
/*!40000 ALTER TABLE `dia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `idEvento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `idTipoEvento` int(11) DEFAULT NULL,
  `idAuditorio` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEvento`),
  KEY `evento-auditorio_idx` (`idAuditorio`),
  KEY `evento-tipo_idx` (`idTipoEvento`),
  CONSTRAINT `evento-auditorio` FOREIGN KEY (`idAuditorio`) REFERENCES `auditorio` (`idAuditorio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `evento-tipo` FOREIGN KEY (`idTipoEvento`) REFERENCES `tipoevento` (`idTipoevento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (1,'Fito Paez',1,1),(2,'Gordofobia',2,2),(3,'El potro',3,3),(4,'Harry Potter 9',3,4),(5,'Duro de matar 15',3,4),(6,'Esperando la carroza',3,3),(7,'El otro lado de la cama',2,7),(8,'Wos',1,6);
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcion`
--

DROP TABLE IF EXISTS `funcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcion` (
  `idFuncion` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `fechaHora` varchar(45) DEFAULT NULL,
  `idEvento` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFuncion`),
  KEY `funcion-evento_idx` (`idEvento`),
  CONSTRAINT `funcion-evento` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`idEvento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcion`
--

LOCK TABLES `funcion` WRITE;
/*!40000 ALTER TABLE `funcion` DISABLE KEYS */;
INSERT INTO `funcion` VALUES (1,'19/11 21:00',NULL,1),(2,'20/11 21:00',NULL,1),(3,'19/11 14:00',NULL,2),(4,'19/11 18:00',NULL,2),(5,'19/11 14:00',NULL,3),(6,'19/11 18:00',NULL,3),(7,'19/11 14:00',NULL,4),(8,'19/11 18:00',NULL,4),(9,'19/11 14:00',NULL,5),(10,'19/11 1800',NULL,5),(11,'19/11 14:00',NULL,6),(12,'19/11 18:00',NULL,6),(13,'19/11 14:00',NULL,7),(14,'19/11 18:00',NULL,7),(15,'19/11 14:00',NULL,8),(16,'19/11 18:00',NULL,8);
/*!40000 ALTER TABLE `funcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Juan','Perez',11111111),(2,'Roberto','Gomez',11111112),(3,'Maria','Ramirez',11111113);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `idreserva` int(11) NOT NULL AUTO_INCREMENT,
  `total` int(11) DEFAULT NULL,
  `idCliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idreserva`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (7,100,1),(8,100,4),(9,100,4),(10,0,4),(11,0,4),(12,120,4),(13,150,4);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sector`
--

DROP TABLE IF EXISTS `sector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sector` (
  `idSector` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `popularCantidadMaxima` int(11) DEFAULT NULL,
  `idAuditorio` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSector`),
  KEY `sector-auditorio_idx` (`idAuditorio`),
  CONSTRAINT `sector-auditorio` FOREIGN KEY (`idAuditorio`) REFERENCES `auditorio` (`idAuditorio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sector`
--

LOCK TABLES `sector` WRITE;
/*!40000 ALTER TABLE `sector` DISABLE KEYS */;
INSERT INTO `sector` VALUES (6,'SALA 1',0,3),(10,'SALA 1',0,4),(12,'SALA 2',0,4),(13,'SALA A',0,2),(14,'Sala principal',0,7),(15,'PLATEA',0,1),(16,'PLATEA',0,6),(17,'Popular',70,6),(18,'Popular',100,1);
/*!40000 ALTER TABLE `sector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarifa`
--

DROP TABLE IF EXISTS `tarifa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarifa` (
  `idTarifa` int(11) NOT NULL AUTO_INCREMENT,
  `precio` float DEFAULT NULL,
  `idSector` int(11) DEFAULT NULL,
  `idFuncion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTarifa`),
  KEY `tarifa-funcion_idx` (`idTarifa`,`idFuncion`),
  KEY `tarifa-sector_idx` (`idSector`),
  KEY `tarifa-funcion_idx1` (`idFuncion`),
  CONSTRAINT `tarifa-funcion` FOREIGN KEY (`idFuncion`) REFERENCES `funcion` (`idFuncion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tarifa-sector` FOREIGN KEY (`idSector`) REFERENCES `sector` (`idSector`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarifa`
--

LOCK TABLES `tarifa` WRITE;
/*!40000 ALTER TABLE `tarifa` DISABLE KEYS */;
INSERT INTO `tarifa` VALUES (1,100,6,5),(2,100,6,6),(3,100,6,11),(4,100,6,12),(5,120,10,7),(6,120,12,7),(7,120,10,8),(8,120,12,8),(9,120,10,9),(10,120,12,9),(11,120,10,10),(12,120,12,10),(13,150,13,3),(14,150,13,4),(15,150,13,13),(16,150,13,14),(17,200,18,1),(18,300,15,1),(19,200,18,2),(20,300,15,2),(21,200,17,15),(22,250,16,15),(23,200,17,16),(24,250,16,16);
/*!40000 ALTER TABLE `tarifa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `idTicket` int(11) NOT NULL AUTO_INCREMENT,
  `idFuncion` int(11) DEFAULT NULL,
  `idSector` int(11) DEFAULT NULL,
  `idButaca` int(11) DEFAULT NULL,
  `idReserva` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTicket`),
  KEY `ticket-funcion_idx` (`idFuncion`),
  KEY `ticket-sector_idx` (`idSector`),
  KEY `ticket-butaca_idx` (`idButaca`),
  KEY `ticket-reserva_idx` (`idReserva`),
  CONSTRAINT `ticket-butaca` FOREIGN KEY (`idButaca`) REFERENCES `butaca` (`idButaca`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ticket-funcion` FOREIGN KEY (`idFuncion`) REFERENCES `funcion` (`idFuncion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ticket-reserva` FOREIGN KEY (`idReserva`) REFERENCES `reserva` (`idreserva`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ticket-sector` FOREIGN KEY (`idSector`) REFERENCES `sector` (`idSector`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,1,6,NULL,7),(2,5,6,21,8),(3,1,18,NULL,9),(4,5,6,29,10),(5,5,6,25,10),(6,5,6,30,11),(7,9,10,39,12),(8,3,13,188,13);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoadministrador`
--

DROP TABLE IF EXISTS `tipoadministrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoadministrador` (
  `idTipoAdministrador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipoAdministrador`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoadministrador`
--

LOCK TABLES `tipoadministrador` WRITE;
/*!40000 ALTER TABLE `tipoadministrador` DISABLE KEYS */;
INSERT INTO `tipoadministrador` VALUES (1,'administrador general'),(2,'administrador auditorio'),(3,'boletero');
/*!40000 ALTER TABLE `tipoadministrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoauditorio`
--

DROP TABLE IF EXISTS `tipoauditorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoauditorio` (
  `idTipoAuditorio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipoAuditorio`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoauditorio`
--

LOCK TABLES `tipoauditorio` WRITE;
/*!40000 ALTER TABLE `tipoauditorio` DISABLE KEYS */;
INSERT INTO `tipoauditorio` VALUES (1,'Estadio'),(2,'Teatro'),(3,'Cine');
/*!40000 ALTER TABLE `tipoauditorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipocliente`
--

DROP TABLE IF EXISTS `tipocliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipocliente` (
  `idTipoCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipoCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocliente`
--

LOCK TABLES `tipocliente` WRITE;
/*!40000 ALTER TABLE `tipocliente` DISABLE KEYS */;
INSERT INTO `tipocliente` VALUES (1,'normal'),(2,'estudiante'),(3,'jubilado');
/*!40000 ALTER TABLE `tipocliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoevento`
--

DROP TABLE IF EXISTS `tipoevento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoevento` (
  `idTipoevento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTipoevento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoevento`
--

LOCK TABLES `tipoevento` WRITE;
/*!40000 ALTER TABLE `tipoevento` DISABLE KEYS */;
INSERT INTO `tipoevento` VALUES (1,'Concierto'),(2,'Obra de teatro'),(3,'cine');
/*!40000 ALTER TABLE `tipoevento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(45) DEFAULT NULL,
  `clave` varchar(45) DEFAULT NULL,
  `idPersona` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'juan','juan1',1),(2,'roberto','roberto2',2),(3,'maria','maria3',3),(4,'gonza','gonza',NULL),(6,'gonzax96','gonza',NULL),(7,'jubilado','gonza',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-12  1:02:26
