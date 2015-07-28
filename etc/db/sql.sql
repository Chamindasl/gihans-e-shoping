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

/*Table structure for table `brand` */

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `brand` */

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
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `item` */

insert  into `item`(`id`,`name`,`price`,`fresh`,`onSale`,`stock`,`active`,`category`,`brand`,`mainImage`,`indexImage`,`cartImage`,`description`,`startFrom`,`featured`) values (1,'chaminda','0.00',0,0,0,1,NULL,NULL,NULL,NULL,NULL,'',NULL,0),(2,'chaminda','0.00',1,0,0,1,NULL,NULL,NULL,NULL,NULL,'',NULL,0),(3,'chaminda','1499.99',1,0,0,1,NULL,NULL,NULL,NULL,NULL,'',NULL,0),(4,'chaminda','1499.99',1,0,0,1,NULL,NULL,NULL,NULL,NULL,'',NULL,0),(5,'chaminda','1499.99',1,0,0,1,NULL,NULL,NULL,NULL,NULL,'',NULL,0),(6,'chaminda','1499.99',1,0,0,1,NULL,NULL,NULL,NULL,NULL,'',NULL,0),(7,'chaminda','1499.99',1,0,0,1,NULL,NULL,NULL,NULL,NULL,'',NULL,0),(8,'chaminda','1499.99',1,0,0,1,NULL,NULL,'C:\\Users\\echamam\\Desktop\\Del\\imgs\\8_mainImage','C:\\Users\\echamam\\Desktop\\Del\\imgs\\8_indexImage','C:\\Users\\echamam\\Desktop\\Del\\imgs\\8_cartImage','',NULL,0),(9,'chaminda','1499.99',1,0,0,1,NULL,NULL,'C:\\Users\\echamam\\Desktop\\Del\\imgs\\9_mainImage','C:\\Users\\echamam\\Desktop\\Del\\imgs\\9_indexImage','C:\\Users\\echamam\\Desktop\\Del\\imgs\\9_cartImage','',NULL,0),(10,'chaminda','1499.99',1,0,0,1,NULL,NULL,'C:\\Users\\echamam\\Desktop\\Del\\imgs\\10_mainImage','C:\\Users\\echamam\\Desktop\\Del\\imgs\\10_indexImage','C:\\Users\\echamam\\Desktop\\Del\\imgs\\10_cartImage','',NULL,0),(11,'chaminda','1499.99',1,0,0,1,NULL,NULL,'C:\\Users\\echamam\\Desktop\\Del\\imgs\\11_mainImage','C:\\Users\\echamam\\Desktop\\Del\\imgs\\11_indexImage','C:\\Users\\echamam\\Desktop\\Del\\imgs\\11_cartImage','',NULL,0),(12,'chaminda','1499.99',1,0,0,1,NULL,NULL,'C:\\Users\\echamam\\Desktop\\Del\\imgs\\12_mainImage','C:\\Users\\echamam\\Desktop\\Del\\imgs\\12_indexImage','C:\\Users\\echamam\\Desktop\\Del\\imgs\\12_cartImage','',NULL,0),(13,'chaminda','1499.99',1,0,0,1,NULL,NULL,NULL,NULL,NULL,'',NULL,0),(14,'chaminda','1499.99',1,0,0,1,NULL,NULL,NULL,NULL,NULL,'',NULL,0),(15,'chaminda','1499.99',1,0,0,1,NULL,NULL,NULL,NULL,NULL,'',NULL,0),(16,'chaminda','1499.99',1,0,0,1,NULL,NULL,NULL,NULL,NULL,'',NULL,0),(17,'chaminda','1499.99',1,0,0,1,NULL,NULL,NULL,NULL,NULL,'',NULL,0),(18,'chaminda','1499.99',1,0,0,1,NULL,NULL,NULL,NULL,NULL,'',NULL,0),(19,'chaminda','1499.99',1,0,0,1,NULL,NULL,NULL,NULL,NULL,'',NULL,0),(20,'chaminda','1499.99',1,0,0,1,NULL,NULL,'C:\\Users\\echamam\\Desktop\\Del\\imgs\\20_mainImage','C:\\Users\\echamam\\Desktop\\Del\\imgs\\20_indexImage','C:\\Users\\echamam\\Desktop\\Del\\imgs\\20_cartImage','',NULL,0),(21,'aa','0.00',0,0,0,1,NULL,NULL,'C:\\Users\\echamam\\Desktop\\Del\\imgs\\21_mainImage','C:\\Users\\echamam\\Desktop\\Del\\imgs\\21_indexImage','C:\\Users\\echamam\\Desktop\\Del\\imgs\\21_cartImage','',NULL,0),(22,'Suminda','0.00',0,0,0,1,NULL,NULL,'C:\\Users\\echamam\\Desktop\\Del\\imgs\\22_mainImage','C:\\Users\\echamam\\Desktop\\Del\\imgs\\22_indexImage','C:\\Users\\echamam\\Desktop\\Del\\imgs\\22_cartImage','',NULL,0),(23,'asdfasdf','0.00',0,0,0,1,NULL,NULL,'C:\\Users\\echamam\\Desktop\\Del\\imgs\\23_mainImage.jpg','C:\\Users\\echamam\\Desktop\\Del\\imgs\\23_indexImage.jpg','C:\\Users\\echamam\\Desktop\\Del\\imgs\\23_cartImage.jpg','',NULL,0),(24,'First','0.00',0,0,0,1,NULL,NULL,'app/assets/img/uploaded24_mainImage.jpg','app/assets/img/uploaded24_indexImage.jpg','app/assets/img/uploaded24_cartImage.jpg','','2015-07-23',0),(25,'Chaminda','0.00',0,0,0,1,NULL,NULL,'app/assets/img/uploaded25_mainImage.jpg','app/assets/img/uploaded25_indexImage.jpg','app/assets/img/uploaded25_cartImage.jpg','','2015-07-23',0),(26,'Chaminda','0.00',0,0,0,1,4,NULL,'app/assets/img/uploaded/26_mainImage.jpg','app/assets/img/uploaded/26_indexImage.jpg','app/assets/img/uploaded/26_cartImage.jpg','','2015-07-23',0),(27,'a','0.00',0,0,0,1,NULL,NULL,'app/assets/img/uploaded/27_mainImage.jpg','app/assets/img/uploaded/27_indexImage.jpg','app/assets/img/uploaded/27_cartImage.jpg','','2015-07-23',0),(28,'12','0.00',0,0,0,1,NULL,NULL,'app/assets/img/uploaded/28_mainImage.jpg','app/assets/img/uploaded/28_indexImage.jpg','app/assets/img/uploaded/28_cartImage.jpg','','2015-07-23',0),(29,'aa','0.00',0,0,0,1,NULL,NULL,'app/assets/img/uploaded/29_mainImage.jpg','app/assets/img/uploaded/29_indexImage.jpg','app/assets/img/uploaded/29_cartImage.jpg','','2011-10-05',0),(30,'Chaminda','0.00',0,0,0,1,NULL,NULL,'app/assets/img/uploaded/30_mainImage.jpg','app/assets/img/uploaded/30_indexImage.jpg','app/assets/img/uploaded/30_cartImage.jpg','','2010-10-15',0),(31,'Name','1.00',1,0,20,1,NULL,NULL,'app/assets/img/uploaded/31_mainImage.jpg','app/assets/img/uploaded/31_indexImage.jpg','app/assets/img/uploaded/31_cartImage.jpg','','2010-01-02',1),(32,'12','3.00',1,0,4,1,NULL,NULL,'app/assets/img/uploaded/32_mainImage.jpg','app/assets/img/uploaded/32_indexImage.jpg','app/assets/img/uploaded/32_cartImage.jpg','','0620-04-05',1),(33,'12','1.00',0,0,1,1,1,NULL,'app/assets/img/uploaded/33_mainImage.jpg','app/assets/img/uploaded/33_indexImage.jpg','app/assets/img/uploaded/33_cartImage.jpg','','2010-01-01',0),(34,'1','1.00',0,0,1,1,3,NULL,'app/assets/img/uploaded/34_mainImage.jpg','app/assets/img/uploaded/34_indexImage.jpg','app/assets/img/uploaded/34_cartImage.jpg','','0021-01-01',0),(35,'Final','3000.00',1,1,50,1,3,NULL,'app/assets/img/uploaded/35_mainImage.jpg','app/assets/img/uploaded/35_indexImage.jpg','app/assets/img/uploaded/35_cartImage.jpg','','2015-10-15',1);

/*Table structure for table `item_imgs` */

DROP TABLE IF EXISTS `item_imgs`;

CREATE TABLE `item_imgs` (
  `item` bigint(20) DEFAULT NULL,
  `path` varchar(500) DEFAULT NULL,
  KEY `item_id` (`item`),
  CONSTRAINT `item_imgs_ibfk_1` FOREIGN KEY (`item`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `item_imgs` */

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

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
