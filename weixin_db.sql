-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`weixin_tbl`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`weixin_tbl` (
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `openid` VARCHAR(100) NOT NULL,
  `message` VARCHAR(333) NULL,
  `id_weixin_tb` INT(9) UNSIGNED NOT NULL AUTO_INCREMENT,
  UNIQUE INDEX `weixin_id_UNIQUE` (`openid` ASC),
  PRIMARY KEY (`id_weixin_tb`),
  UNIQUE INDEX `id_weixin_tb_UNIQUE` (`id_weixin_tb` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
