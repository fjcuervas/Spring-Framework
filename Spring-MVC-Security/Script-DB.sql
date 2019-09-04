-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema springdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `springdb` ;

-- -----------------------------------------------------
-- Schema springdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `springdb` DEFAULT CHARACTER SET utf8 ;
USE `springdb` ;

-- -----------------------------------------------------
-- Table `springdb`.`Admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springdb`.`Admin` ;

CREATE TABLE IF NOT EXISTS `springdb`.`Admin` (
  `idAd` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(80) NULL,
  `cargo` VARCHAR(45) NULL,
  `fechaCreacion` DATETIME NULL,
  PRIMARY KEY (`idAd`))
ENGINE = InnoDB
COMMENT = '			';


-- -----------------------------------------------------
-- Table `springdb`.`Direccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springdb`.`Direccion` ;

CREATE TABLE IF NOT EXISTS `springdb`.`Direccion` (
  `idDir` INT NOT NULL AUTO_INCREMENT,
  `calle` VARCHAR(45) NULL,
  `cp` VARCHAR(45) NULL,
  `idAd` INT NOT NULL,
  PRIMARY KEY (`idDir`),
  INDEX `fk_Direccion_Admin1_idx` (`idAd` ASC),
  CONSTRAINT `fk_Direccion_Admin1`
    FOREIGN KEY (`idAd`)
    REFERENCES `springdb`.`Admin` (`idAd`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springdb`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springdb`.`users` ;

CREATE TABLE IF NOT EXISTS `springdb`.`users` (
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(45) NULL,
  `enabled` TINYINT(1) NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB
COMMENT = '		';


-- -----------------------------------------------------
-- Table `springdb`.`authorities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springdb`.`authorities` ;

CREATE TABLE IF NOT EXISTS `springdb`.`authorities` (
  `username` VARCHAR(50) NOT NULL,
  `authority` VARCHAR(45) NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springdb`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springdb`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `springdb`.`Usuario` (
  `idUsr` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NULL,
  `clave` VARCHAR(100) NULL,
  `permiso` VARCHAR(45) NULL,
  `fechaCreacion` VARCHAR(45) NULL,
  PRIMARY KEY (`idUsr`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

/*
-- Query: SELECT * FROM springdb.usuario
LIMIT 0, 1000

-- Date: 2019-08-30 15:03
*/
INSERT INTO `springdb`.`Usuario` (`idUsr`,`usuario`,`clave`,`permiso`,`fechaCreacion`) VALUES (1,'javi','7fd42a59c013cf29e63d1ad1b10a16945fe121f4cd56c48abef3f58964d065affa2b669373c995eb','ROLE_ADMIN','1999-09-09 12:00:00');
INSERT INTO `springdb`.`Usuario` (`idUsr`,`usuario`,`clave`,`permiso`,`fechaCreacion`) VALUES (2,'pepe','7fd42a59c013cf29e63d1ad1b10a16945fe121f4cd56c48abef3f58964d065affa2b669373c995eb','ROL_ADMIN','2019-08-30 12:53:13.777');
INSERT INTO `springdb`.`Usuario` (`idUsr`,`usuario`,`clave`,`permiso`,`fechaCreacion`) VALUES (3,'julio','fc0d3fe9dad0c76650972cc1f80e344875baa60eb30395b47af7c099de3b1d5b33c0fb87c9c1455c','ROLE_ROOT','2019-08-30 12:55:26.191');
INSERT INTO `springdb`.`Usuario` (`idUsr`,`usuario`,`clave`,`permiso`,`fechaCreacion`) VALUES (4,'jose','b6de1fa9e676984f130cadd7543022408c8c510668d46b050ab3e2ba14b1e9390c46d79d8df56479','ROL_JOSE','2019-08-30 13:49:25.551');


