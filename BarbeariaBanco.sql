CREATE DATABASE  IF NOT EXISTS `barberiajoao`;
USE `barberiajoao`;

CREATE TABLE `pessoa` (
  `ID_PESSOA` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(45) NOT NULL,
  `SOBRENOME` varchar(45) NOT NULL,
  `CPF` long NOT NULL,
  `SEXO` varchar(45) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `CELULAR` long NOT NULL,
  `NASCIMENTO` date NOT NULL,
  `SENHA` varchar(100) NOT NULL,
  PRIMARY KEY (`ID_PESSOA`));