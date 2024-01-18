CREATE DATABASE  IF NOT EXISTS `employees-db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `employees-db`;


DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
                    `id` int(11) NOT NULL AUTO_INCREMENT,
                    `first_name` varchar(150) DEFAULT NULL,
                    `last_name` varchar(150) DEFAULT NULL,
                    `email` varchar(150) DEFAULT NULL,
                    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

insert into employee(id, first_name, last_name, email) values ('1', 'Ivan', 'Ivanov', 'ivan.ivanov@testapp.com');
insert into employee(id, first_name, last_name, email) values ('2', 'Maria', 'Popova', 'maria.popova@testapp.com');
insert into employee(id, first_name, last_name, email) values ('3', 'Petar', 'Petrov', 'petar.petrov@testapp.com');
insert into employee(id, first_name, last_name, email) values ('4', 'Kalina', 'Angelova', 'kalina.angelova@testapp.com');
