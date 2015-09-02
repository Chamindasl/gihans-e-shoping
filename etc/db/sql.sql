/*
SQLyog Community v12.11 (64 bit)
MySQL - 5.6.24-log : Database - gs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gs` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `gs`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(200) DEFAULT NULL,
  `contact_person` varchar(200) DEFAULT NULL,
  `address_1` varchar(200) DEFAULT NULL,
  `address_2` varchar(200) DEFAULT NULL,
  `district` int(11) DEFAULT NULL,
  `city` int(11) DEFAULT NULL,
  `company_address` tinyint(1) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `district` (`district`),
  KEY `city` (`city`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`district`) REFERENCES `district` (`id`),
  CONSTRAINT `address_ibfk_2` FOREIGN KEY (`city`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `address` */

insert  into `address`(`id`,`email`,`contact_person`,`address_1`,`address_2`,`district`,`city`,`company_address`,`phone`) values (1,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',NULL,NULL,1,'+372247051'),(2,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',NULL,NULL,1,'+372247051'),(3,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',NULL,NULL,1,'+372247051'),(4,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',NULL,NULL,1,'+372247051'),(5,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',NULL,NULL,1,'+372247051'),(6,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',NULL,NULL,1,'+372247051'),(7,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',NULL,NULL,1,'+372247051'),(8,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',NULL,NULL,1,'+372247051'),(9,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',NULL,NULL,1,'+372247051'),(10,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',NULL,NULL,1,'+372247051'),(11,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',NULL,NULL,1,'+372247051'),(12,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',NULL,NULL,1,'+372247051'),(13,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',1,1,1,'+372247051'),(14,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',1,1,1,'+372247051'),(15,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',1,1,1,'+372247051'),(16,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',1,1,1,'+372247051'),(17,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',1,1,1,'+372247051'),(18,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',1,1,1,'+372247051'),(19,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',1,1,1,'+372247051'),(20,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',1,1,1,'+372247051'),(21,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',3,3,1,'+372247051'),(22,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',3,3,1,'+372247051'),(23,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',1,1,1,'+372247051'),(24,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',1,1,1,'+372247051'),(25,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',1,1,1,'+372247051'),(26,'chaminda.sl@gmail.com','Mahinda Amarasinghe','34, Karangamuwa','Katupotha',1,1,1,'+372247051');

/*Table structure for table `brand` */

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `brand` */

insert  into `brand`(`id`,`name`) values (4,'Nike'),(5,'Puma'),(8,'Adidas');

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `parent` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category_parent_category_id` (`parent`),
  CONSTRAINT `fk_category_parent_category_id` FOREIGN KEY (`parent`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`name`,`parent`) values (1,'Women',NULL),(2,'Men',NULL),(3,'Nightware',1),(4,'Children',NULL),(5,'Toy',4),(6,'Shirts',2),(7,'T-Shirts',4),(8,'a',1),(9,'a',NULL),(10,'b',9),(11,'c',9);

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `district` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `district` (`district`),
  CONSTRAINT `city_ibfk_1` FOREIGN KEY (`district`) REFERENCES `district` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `city` */

insert  into `city`(`id`,`name`,`district`) values (1,'Colombo 1',1),(2,'Colombo 2',1),(3,'Katupotha',3);

/*Table structure for table `client_order` */

DROP TABLE IF EXISTS `client_order`;

CREATE TABLE `client_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user` bigint(11) DEFAULT NULL,
  `ordered_date` date DEFAULT NULL,
  `payment_status` int(11) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `shipping_address` bigint(11) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `payment_received_date` date DEFAULT NULL,
  `delivered_data` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user` (`user`),
  KEY `shipping_address` (`shipping_address`),
  CONSTRAINT `client_order_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`id`),
  CONSTRAINT `client_order_ibfk_2` FOREIGN KEY (`shipping_address`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `client_order` */

insert  into `client_order`(`id`,`user`,`ordered_date`,`payment_status`,`order_status`,`shipping_address`,`amount`,`payment_received_date`,`delivered_data`) values (1,3,NULL,1,1,NULL,51727,'2014-01-01',NULL),(2,3,NULL,1,1,NULL,76043,'2014-02-01',NULL),(3,3,NULL,3,4,NULL,15035,'2014-03-01','2015-08-30'),(4,3,NULL,1,1,NULL,37048,'2014-04-01',NULL),(5,3,NULL,1,1,NULL,30134,'2014-05-01',NULL),(6,3,NULL,1,1,NULL,29528,'2014-06-01',NULL),(8,3,NULL,1,1,NULL,47239,'2014-08-01',NULL),(9,3,NULL,1,1,NULL,37612,'2014-09-01',NULL),(10,3,NULL,1,1,NULL,36343,'2014-10-01',NULL),(11,3,NULL,1,1,NULL,58877,'2014-11-01',NULL),(12,3,NULL,1,1,NULL,75359,'2014-12-01',NULL),(13,3,NULL,1,1,NULL,90164,'2015-01-01',NULL),(14,3,NULL,1,1,NULL,14742,'2015-02-01',NULL),(15,3,NULL,1,1,NULL,93221,'2015-03-01',NULL),(16,3,NULL,1,1,NULL,11879,'2015-04-01',NULL),(17,3,NULL,1,1,NULL,69731,'2015-05-01',NULL),(18,3,NULL,1,1,NULL,103019,'2015-06-01',NULL),(19,3,NULL,1,1,NULL,95901,'2015-07-01',NULL),(24,9,'2015-08-23',1,1,NULL,60448,'2015-08-01',NULL),(25,9,'2015-08-23',1,1,NULL,104539,'2013-01-01',NULL),(26,9,'2015-08-24',1,1,NULL,31350,'2013-02-01',NULL),(27,9,'2015-08-24',1,1,NULL,33133,'2013-03-01',NULL),(28,9,'2015-08-24',1,1,NULL,61618,'2013-04-01',NULL),(29,9,'2015-08-25',1,1,NULL,98691,'2013-05-01','2015-08-30'),(30,9,'2015-08-30',1,1,NULL,98602,'2013-06-01',NULL);

/*Table structure for table `district` */

DROP TABLE IF EXISTS `district`;

CREATE TABLE `district` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `province` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `province` (`province`),
  CONSTRAINT `district_ibfk_1` FOREIGN KEY (`province`) REFERENCES `province` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `district` */

insert  into `district`(`id`,`name`,`province`) values (1,'Colombo',1),(2,'Kaluthara',1),(3,'Kurunegala',2),(4,'Puthlam',2);

/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `fresh` tinyint(1) DEFAULT NULL,
  `onSale` tinyint(1) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `brand` int(11) DEFAULT NULL,
  `mainImage` varchar(300) DEFAULT NULL,
  `indexImage` varchar(300) DEFAULT NULL,
  `cartImage` varchar(300) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `startFrom` date DEFAULT NULL,
  `featured` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category` (`category`),
  KEY `brand` (`brand`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`category`) REFERENCES `category` (`id`),
  CONSTRAINT `item_ibfk_2` FOREIGN KEY (`brand`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

/*Data for the table `item` */

insert  into `item`(`id`,`name`,`price`,`fresh`,`onSale`,`stock`,`active`,`category`,`brand`,`mainImage`,`indexImage`,`cartImage`,`description`,`startFrom`,`featured`) values (1,'chaminda','0.00',0,0,0,1,NULL,NULL,'/ges/uploaded/1_mainImage.jpg','/ges/uploaded/1_indexImage.jpg','/ges/uploaded/1_cartImage.jpg','','2015-08-03',0),(2,'chaminda','1234.00',0,0,21,1,3,NULL,'/ges/uploaded/2_mainImage.jpg','/ges/uploaded/2_indexImage.jpg','/ges/uploaded/2_cartImage.jpg','','2015-08-30',0),(3,'chaminda','1550.00',0,0,1,1,1,5,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','','2015-08-03',0),(4,'chaminda','1499.99',1,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(5,'chaminda','1499.99',1,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(6,'chaminda','1499.99',1,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(7,'chaminda','1499.99',1,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(8,'chaminda','1499.99',1,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(9,'chaminda','1499.99',1,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(10,'chaminda','1499.99',1,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(11,'chaminda','1499.99',1,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(12,'chaminda','1499.99',1,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(13,'chaminda','1499.99',1,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(14,'chaminda','1499.99',1,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(15,'chaminda','1499.99',1,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(16,'chaminda','1499.99',1,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(17,'chaminda','1499.99',1,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(18,'chaminda','1499.99',1,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(19,'chaminda','1499.99',1,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(20,'chaminda','1499.99',1,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(21,'aa','0.00',0,1,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(22,'Suminda','0.00',0,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(23,'asdfasdf','0.00',0,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','',NULL,0),(24,'First','0.00',0,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','','2015-07-23',0),(25,'Chaminda','0.00',0,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','','2015-07-23',1),(26,'Chaminda','0.00',0,0,0,1,4,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','','2015-07-23',0),(27,'a','0.00',0,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','','2015-07-23',0),(28,'12','0.00',0,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','','2015-07-23',0),(29,'aa','0.00',0,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','','2011-10-05',0),(30,'Chaminda','0.00',0,0,0,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','','2010-10-15',0),(31,'Name','1.00',1,0,20,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','','2010-01-02',1),(32,'12','3.00',1,0,4,1,NULL,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','','0620-04-05',1),(33,'12','1.00',0,0,1,1,1,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','','2010-01-01',0),(34,'1','1.00',0,0,1,1,3,NULL,'/ges/uploaded/34_mainImage.jpg','/ges/uploaded/34_indexImage.jpg','/ges/uploaded/34_cartImage.jpg','','0021-01-01',0),(35,'Final','3000.00',1,1,50,1,3,4,'/ges/uploaded/35_mainImage.jpg','/ges/uploaded/35_indexImage.jpg','/ges/uploaded/35_cartImage.jpg','','2015-10-15',1),(36,'My Item','2500.00',1,0,50,1,3,NULL,'/ges/uploaded/36_mainImage.jpg','/ges/uploaded/36_indexImage.jpg','/ges/uploaded/36_cartImage.jpg','','2015-05-19',1),(37,'chaminda','1550.00',0,0,1,1,1,NULL,'/ges/uploaded/37_mainImage.jpg','/ges/uploaded/37_indexImage.jpg','/ges/uploaded/37_cartImage.jpg','','2015-08-03',0),(38,'chaminda','1550.00',0,0,1,1,1,NULL,'/ges/uploaded/38_mainImage.jpg','/ges/uploaded/38_indexImage.jpg','/ges/uploaded/38_cartImage.jpg','','2015-08-03',0),(39,'IItem','2500.00',0,0,12,1,3,NULL,'/ges/uploaded/39_mainImage.jpg','/ges/uploaded/39_indexImage.jpg','/ges/uploaded/39_cartImage.jpg','','2015-08-23',0);

/*Table structure for table `item_imgs` */

DROP TABLE IF EXISTS `item_imgs`;

CREATE TABLE `item_imgs` (
  `item` bigint(20) DEFAULT NULL,
  `path` varchar(500) DEFAULT NULL,
  KEY `item_id` (`item`),
  CONSTRAINT `item_imgs_ibfk_1` FOREIGN KEY (`item`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `item_imgs` */

/*Table structure for table `order_item` */

DROP TABLE IF EXISTS `order_item`;

CREATE TABLE `order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client_order` bigint(20) DEFAULT NULL,
  `item` bigint(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `item` (`item`),
  KEY `order` (`client_order`),
  CONSTRAINT `order_item_ibfk_1` FOREIGN KEY (`item`) REFERENCES `item` (`id`),
  CONSTRAINT `order_item_ibfk_2` FOREIGN KEY (`client_order`) REFERENCES `client_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

/*Data for the table `order_item` */

insert  into `order_item`(`id`,`client_order`,`item`,`price`,`quantity`) values (45,26,25,0,1),(46,26,31,1,1),(47,27,25,0,1),(48,27,31,1,1),(49,28,25,0,1),(50,28,31,1,1),(51,28,32,3,1),(52,29,31,1,1),(53,29,32,3,3),(54,29,36,2500,2),(55,29,35,3000,1),(56,30,33,1,1);

/*Table structure for table `province` */

DROP TABLE IF EXISTS `province`;

CREATE TABLE `province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `province` */

insert  into `province`(`id`,`name`) values (1,'Western'),(2,'North Western');

/*Table structure for table `related_item` */

DROP TABLE IF EXISTS `related_item`;

CREATE TABLE `related_item` (
  `item` bigint(20) DEFAULT NULL,
  `related_item` bigint(20) DEFAULT NULL,
  KEY `item` (`item`),
  KEY `related_item` (`related_item`),
  CONSTRAINT `related_item_ibfk_1` FOREIGN KEY (`item`) REFERENCES `item` (`id`),
  CONSTRAINT `related_item_ibfk_2` FOREIGN KEY (`related_item`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `related_item` */

insert  into `related_item`(`item`,`related_item`) values (35,34),(35,33),(35,32),(35,31);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`name`) values (1,'Admin'),(2,'User'),(3,'Customer');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(200) DEFAULT NULL,
  `display_name` varchar(200) NOT NULL,
  `first_name` varchar(200) DEFAULT NULL,
  `last_name` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `billing_address` bigint(20) DEFAULT NULL,
  `shipping_address` bigint(20) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `uuid` varchar(200) DEFAULT NULL,
  `active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `billing_address` (`billing_address`),
  KEY `shipping_address` (`shipping_address`),
  KEY `role` (`role`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`billing_address`) REFERENCES `address` (`id`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`shipping_address`) REFERENCES `address` (`id`),
  CONSTRAINT `user_ibfk_3` FOREIGN KEY (`role`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`email`,`display_name`,`first_name`,`last_name`,`password`,`billing_address`,`shipping_address`,`phone`,`role`,`uuid`,`active`) values (3,'chaminda.sl@gmail.com','Chaminda','Chaminda','Amarasinghe','King1!',1,2,'+94718602815',3,NULL,NULL),(7,'a','AA','Chaminda1','Amarasinghe','a',9,10,'+94718602815',1,NULL,NULL),(8,'b','BB','Chaminda2','Amarasinghe','b',11,12,'+94718602815',2,NULL,NULL),(9,'c','CC','Chaminda3','Amarasinghe','c',13,14,'+94718602815',3,NULL,NULL),(10,'D','DD','Chaminda4','Amarasinghe','King1!',15,16,'+94718602815',2,NULL,NULL),(11,'chaminda.sl@gmail.com','Chaminda','Chaminda','Amarasinghe','King1!',17,18,'+94718602815',1,NULL,NULL),(12,'su@gmail.com','suminda','Suminda','Amarasinghe','King1!',19,20,'+94718602815',2,NULL,NULL),(13,'chaminda.sl@gmail.com','Chaminda','Chaminda','Amarasinghe','King1!',21,22,'+94718602815',3,'e1419d48-47fc-495e-a30c-2bb3d8a45d9c',0),(14,'chaminda.sl@gmail.com','Chaminda','Chaminda','Amarasinghe','King1!',23,24,'+94718602815',3,'1df82792-18db-4124-8e63-d9c6461b9ad2',0),(15,'chaminda.sl@gmail.com','Chaminda','Chaminda','Amarasinghe','King1!',25,26,'+94718602815',2,'2d48062b-3cee-4400-b2e1-10c43c3d9536',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
