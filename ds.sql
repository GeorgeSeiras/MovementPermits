CREATE SCHEMA `ds` ;

CREATE TABLE `ds`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NULL,
  `lname` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `phone_num` VARCHAR(45) NULL,
  `dep_id` INT NULL,
  `username` VARCHAR(45) NULL UNIQUE,
  `password` VARCHAR(45) NULL UNIQUE,
  PRIMARY KEY (`user_id`));

CREATE TABLE `ds`.`departments` (
  `dept_id` INT NOT NULL AUTO_INCREMENT,
  `dept_name` VARCHAR(45) NULL,
  `super_id` INT NULL,
  PRIMARY KEY (`dept_id`));

CREATE TABLE `ds`.`roles` (
  `authority` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`authority`));

CREATE TABLE `ds`.`permits` (
  `permit_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `status` VARCHAR(45) NULL,
CONSTRAINT check_status CHECK (status IN ('PENDING', 'APPROVED', 'DENIED')),
  `start_date` DATETIME NULL,
  `end_date` DATETIME NULL,
  `type` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  PRIMARY KEY (`permit_id`));

CREATE TABLE `ds`.`authorities` (
  `authority` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`authority`, `username`));
  
ALTER TABLE `ds`.`users` 
ADD CONSTRAINT `user_fk_dept`
  FOREIGN KEY (`dep_id`)
  REFERENCES `ds`.`departments` (`dept_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `ds`.`departments` 
ADD CONSTRAINT `dept_fk_user`
  FOREIGN KEY (`super_id`)
  REFERENCES `ds`.`users` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `ds`.`permits` 
ADD CONSTRAINT `permit_fk_user`
  FOREIGN KEY (`user_id`)
  REFERENCES `ds`.`users` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `ds`.`authorities` 
ADD CONSTRAINT `auth_fk_users`
  FOREIGN KEY (`username`)
  REFERENCES `ds`.`users` (`username`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `auth_fk_roles`
  FOREIGN KEY (`authority`)
  REFERENCES `ds`.`roles` (`authority`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;