CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;

CREATE TABLE `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `clientes`
--

INSERT INTO `clientes` VALUES 
	(1,'Leslie','Andrews',20,'leslie@luv2code.com'),
	(2,'Emma','Baumgarten',25,'emma@luv2code.com'),
	(3,'Avani','Gupta',19,'avani@luv2code.com'),
	(4,'Yuri','Petrov',22,'yuri@luv2code.com'),
	(5,'Juan','Vega',20,'juan@luv2code.com');

