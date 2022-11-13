CREATE DATABASE IF NOT EXISTS `carwash`;
USE `carwash`;

CREATE TABLE `role` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `role` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `user` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`first_name` varchar(45) DEFAULT NULL,
	`last_name` varchar(45) DEFAULT NULL,
	`email` varchar(45) DEFAULT NULL,
	`telephone_nr` varchar(45) DEFAULT NULL,
	`password` varchar(256) DEFAULT NULL,
    `role` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
	FOREIGN KEY (`role`) REFERENCES `role`(`id`)
);

CREATE TABLE `carwash` (
   `id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
   `address` varchar(256) DEFAULT NULL,
   `name`varchar(256) DEFAULT NULL,
   `owner` int(11) DEFAULT NULL,
   FOREIGN KEY (`owner`) REFERENCES `user`(`id`)
);


CREATE TABLE `services` (
    `id` INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `price` INT(50) DEFAULT NULL,
    `description` VARCHAR(256) DEFAULT NULL
);

CREATE TABLE `carwashservices` (
	`carWashId` int(15) NOT NULL,
    `servicesId` int(15) NOT NULL,
    FOREIGN KEY (`carWashId`) REFERENCES `carwash`(`id`),
    FOREIGN KEY (`servicesId`) REFERENCES `services`(`id`),
    UNIQUE (`carWashId`,`servicesId`)
);

CREATE TABLE `appointments` (
	`id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `startTime` datetime DEFAULT NULL,
    `endTime` datetime DEFAULT NULL,
    `customer_id` int(11) DEFAULT NULL,
    `carWash_id` int(11) DEFAULT NULL,
    `service_id` int(11) DEFAULT NULL,
    FOREIGN KEY (`customer_id`) REFERENCES `user`(`id`),
    FOREIGN KEY (`carWash_id`) REFERENCES `carwash`(`id`),
    FOREIGN KEY (`service_id`) REFERENCES `services`(`id`)
);