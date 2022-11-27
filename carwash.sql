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
    `role_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
	FOREIGN KEY (`role_id`) REFERENCES `role`(`id`)
);

CREATE TABLE `carwash` (
   `id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
   `address` varchar(256) DEFAULT NULL,
   `name`varchar(256) DEFAULT NULL,
   `owner_id` int(11) DEFAULT NULL,
   FOREIGN KEY (`owner_id`) REFERENCES `user`(`id`)
);


CREATE TABLE `services` (
    `id` INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `price` INT(50) DEFAULT NULL,
    `description` VARCHAR(256) DEFAULT NULL
);

CREATE TABLE `carwashservices` (
	`carwash_id` int(15) NOT NULL,
    `services_id` int(15) NOT NULL,
    FOREIGN KEY (`carwash_id`) REFERENCES `carwash`(`id`),
    FOREIGN KEY (`services_id`) REFERENCES `services`(`id`),
    UNIQUE (`carwash_id`,`services_id`)
);

CREATE TABLE `appointments` (
	`id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `start_time` datetime DEFAULT NULL,
    `end_time` datetime DEFAULT NULL,
    `customer_id` int(11) DEFAULT NULL,
    `carwash_id` int(11) DEFAULT NULL,
    `service_id` int(11) DEFAULT NULL,
    FOREIGN KEY (`customer_id`) REFERENCES `user`(`id`),
    FOREIGN KEY (`carwash_id`) REFERENCES `carwash`(`id`),
    FOREIGN KEY (`service_id`) REFERENCES `services`(`id`)
);