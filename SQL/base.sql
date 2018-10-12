-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: tpticketunla
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auditorio`
--

LOCK TABLES `auditorio` WRITE;
/*!40000 ALTER TABLE `auditorio` DISABLE KEYS */;
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
  `idNumerada` int(11) DEFAULT NULL,
  PRIMARY KEY (`idButaca`),
  KEY `butaca-numerada_idx` (`idNumerada`),
  CONSTRAINT `butaca-numerada` FOREIGN KEY (`idNumerada`) REFERENCES `numerada` (`idNumerada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `butaca`
--

LOCK TABLES `butaca` WRITE;
/*!40000 ALTER TABLE `butaca` DISABLE KEYS */;
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
  CONSTRAINT `cliente-tipo` FOREIGN KEY (`idTipoCliente`) REFERENCES `tipocliente` (`idTipoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cliente-usuario` FOREIGN KEY (`idCliente`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
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
INSERT INTO `codigo` VALUES (1,'codigo'),(2,'codigo'),(3,'codigo'),(4,'codigo'),(5,'codigo'),(6,'codigo'),(7,'codigo');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descuento`
--

LOCK TABLES `descuento` WRITE;
/*!40000 ALTER TABLE `descuento` DISABLE KEYS */;
INSERT INTO `descuento` VALUES (1,5,'\0',NULL,NULL),(2,5,'\0',NULL,NULL),(3,5,'\0',NULL,NULL),(4,5,'\0',NULL,NULL),(5,5,'\0',NULL,NULL),(6,5,'\0',NULL,NULL),(7,5,'\0',NULL,NULL);
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcion`
--

LOCK TABLES `funcion` WRITE;
/*!40000 ALTER TABLE `funcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `numerada`
--

DROP TABLE IF EXISTS `numerada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `numerada` (
  `idNumerada` int(11) NOT NULL,
  `idButaca` int(11) DEFAULT NULL,
  PRIMARY KEY (`idNumerada`),
  CONSTRAINT `numerada-sector` FOREIGN KEY (`idNumerada`) REFERENCES `sector` (`idSector`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `numerada`
--

LOCK TABLES `numerada` WRITE;
/*!40000 ALTER TABLE `numerada` DISABLE KEYS */;
/*!40000 ALTER TABLE `numerada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` int(11) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  KEY `persona usuario_idx` (`idUsuario`),
  CONSTRAINT `persona usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `popular`
--

DROP TABLE IF EXISTS `popular`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `popular` (
  `idPopular` int(11) NOT NULL,
  `cantidadMaxima` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPopular`),
  CONSTRAINT `popular-sector` FOREIGN KEY (`idPopular`) REFERENCES `sector` (`idSector`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `popular`
--

LOCK TABLES `popular` WRITE;
/*!40000 ALTER TABLE `popular` DISABLE KEYS */;
/*!40000 ALTER TABLE `popular` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `idreserva` int(11) NOT NULL AUTO_INCREMENT,
  `idTicket` int(11) DEFAULT NULL,
  PRIMARY KEY (`idreserva`),
  KEY `reserva-ticket_idx` (`idTicket`),
  CONSTRAINT `reserva-ticket` FOREIGN KEY (`idTicket`) REFERENCES `ticket` (`idTicket`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
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
  `idAuditorio` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSector`),
  KEY `sector-auditorio_idx` (`idAuditorio`),
  CONSTRAINT `sector-auditorio` FOREIGN KEY (`idAuditorio`) REFERENCES `auditorio` (`idAuditorio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sector`
--

LOCK TABLES `sector` WRITE;
/*!40000 ALTER TABLE `sector` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarifa`
--

LOCK TABLES `tarifa` WRITE;
/*!40000 ALTER TABLE `tarifa` DISABLE KEYS */;
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
  `idCliente` int(11) DEFAULT NULL,
  `idFuncion` int(11) DEFAULT NULL,
  `idSector` int(11) DEFAULT NULL,
  `idButaca` int(11) DEFAULT NULL,
  PRIMARY KEY (`idTicket`),
  KEY `ticket-cliente_idx` (`idCliente`),
  KEY `ticket-funcion_idx` (`idFuncion`),
  KEY `ticket-sector_idx` (`idSector`),
  KEY `ticket-butaca_idx` (`idButaca`),
  CONSTRAINT `ticket-butaca` FOREIGN KEY (`idButaca`) REFERENCES `butaca` (`idButaca`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ticket-cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ticket-funcion` FOREIGN KEY (`idFuncion`) REFERENCES `funcion` (`idFuncion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ticket-sector` FOREIGN KEY (`idSector`) REFERENCES `sector` (`idSector`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoadministrador`
--

LOCK TABLES `tipoadministrador` WRITE;
/*!40000 ALTER TABLE `tipoadministrador` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoauditorio`
--

LOCK TABLES `tipoauditorio` WRITE;
/*!40000 ALTER TABLE `tipoauditorio` DISABLE KEYS */;
INSERT INTO `tipoauditorio` VALUES (1,'Estadio'),(2,'Teatro'),(3,'Cine'),(4,'Estadio'),(5,'Teatro'),(6,'Cine'),(7,'Estadio'),(8,'Teatro'),(9,'Cine');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocliente`
--

LOCK TABLES `tipocliente` WRITE;
/*!40000 ALTER TABLE `tipocliente` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoevento`
--

LOCK TABLES `tipoevento` WRITE;
/*!40000 ALTER TABLE `tipoevento` DISABLE KEYS */;
INSERT INTO `tipoevento` VALUES (1,'Pelicula'),(2,'Obra de teatro'),(3,'Concierto'),(4,'Pelicula'),(5,'Obra de teatro'),(6,'Concierto'),(7,'Pelicula'),(8,'Obra de teatro'),(9,'Concierto');
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
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
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

-- Dump completed on 2018-10-12 12:13:51
