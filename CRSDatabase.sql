-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema CRSDatabase
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `CRSDatabase` ;

-- -----------------------------------------------------
-- Schema CRSDatabase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CRSDatabase` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
SHOW WARNINGS;
USE `CRSDatabase` ;

-- -----------------------------------------------------
-- Table `admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `admin` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `admin` (
  `admin_id` VARCHAR(25) NOT NULL,
  `admin_name` VARCHAR(45) NULL DEFAULT NULL,
  `data_of_joining` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `professor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `professor` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `professor` (
  `professor_id` VARCHAR(25) NOT NULL,
  `professor_name` VARCHAR(50) NULL DEFAULT NULL,
  `department` VARCHAR(50) NULL DEFAULT NULL,
  `designation` VARCHAR(45) NULL DEFAULT NULL,
  `Gender` VARCHAR(45) NULL DEFAULT NULL,
  `date_of_joining` DATETIME NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`professor_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `course` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `course` (
  `course_code` VARCHAR(25) NOT NULL,
  `course_name` VARCHAR(100) NULL DEFAULT NULL,
  `instructor_id` VARCHAR(45) NULL DEFAULT NULL,
  `prerequisite` VARCHAR(100) NULL DEFAULT NULL,
  `seats` INT NULL DEFAULT NULL,
  PRIMARY KEY (`course_code`),
  INDEX `fk_course_professor_idx` (`instructor_id` ASC) VISIBLE,
  CONSTRAINT `fk_course_professor`
    FOREIGN KEY (`instructor_id`)
    REFERENCES `professor` (`professor_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `student`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `student` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `student` (
  `student_id` VARCHAR(25) NOT NULL,
  `student_name` VARCHAR(45) NOT NULL,
  `branch` VARCHAR(45) NULL DEFAULT NULL,
  `batch` INT NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `is_approved` TINYINT NULL DEFAULT NULL,
  `has_registered` TINYINT NULL DEFAULT NULL,
  `done_payment` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `grade_card`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `grade_card` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `grade_card` (
  `student_id` VARCHAR(25) NOT NULL,
  `course_id` VARCHAR(45) NOT NULL,
  `grade` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`, `course_id`),
  INDEX `fk_grade_course_idx` (`course_id` ASC) VISIBLE,
  CONSTRAINT `fk_grade_course`
    FOREIGN KEY (`course_id`)
    REFERENCES `course` (`course_code`),
  CONSTRAINT `fk_grade_student`
    FOREIGN KEY (`student_id`)
    REFERENCES `student` (`student_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `notification`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `notification` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `notification` (
  `notification_id` INT NOT NULL AUTO_INCREMENT,
  `student_id` VARCHAR(45) NULL DEFAULT NULL,
  `message` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`notification_id`),
  INDEX `fk_notification_student_idx` (`student_id` ASC) VISIBLE,
  CONSTRAINT `fk_notification_student`
    FOREIGN KEY (`student_id`)
    REFERENCES `student` (`student_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `payment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `payment` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `payment` (
  `transaction_id` VARCHAR(100) NOT NULL,
  `student_id` VARCHAR(45) NULL DEFAULT NULL,
  `payment_method` VARCHAR(45) NULL DEFAULT NULL,
  `amount` INT NULL DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  INDEX `fk_payment_student_idx` (`student_id` ASC) VISIBLE,
  CONSTRAINT `fk_payment_student`
    FOREIGN KEY (`student_id`)
    REFERENCES `student` (`student_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `student_enrolled_course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `student_enrolled_course` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `student_enrolled_course` (
  `student_id` VARCHAR(25) NOT NULL,
  `course_id` VARCHAR(45) NOT NULL,
  `primary` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`, `course_id`),
  INDEX `fk_enrolled_course_idx` (`course_id` ASC) VISIBLE,
  CONSTRAINT `fk_enrolled_course`
    FOREIGN KEY (`course_id`)
    REFERENCES `course` (`course_code`),
  CONSTRAINT `fk_enrolled_student`
    FOREIGN KEY (`student_id`)
    REFERENCES `student` (`student_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` VARCHAR(25) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
