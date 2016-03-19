/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.40 : Database - day15
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`day15` /*!40100 DEFAULT CHARACTER SET gbk */;

USE `day15`;

/*Table structure for table `emplyee` */

DROP TABLE IF EXISTS `emplyee`;

CREATE TABLE `emplyee` (
  `sid` int(11) DEFAULT NULL,
  `sname` varchar(20) DEFAULT NULL,
  `sgender` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `emplyee` */

insert  into `emplyee`(`sid`,`sname`,`sgender`) values (10,'张三','男'),(23,'哈哈','工'),(32,'王八','女'),(4,'崔久','男'),(23,'哈哈','工'),(223,'华5','男');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `chinese` float DEFAULT NULL,
  `english` float DEFAULT NULL,
  `math` float DEFAULT NULL,
  `servlet` int(11) DEFAULT NULL,
  `jsp` int(11) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `student` */

insert  into `student`(`id`,`name`,`chinese`,`english`,`math`,`servlet`,`jsp`,`gender`) values (1,'张小明',89,78,90,12,45,'女'),(2,'李进',67,53,95,23,54,'男'),(3,'王五',87,78,77,32,54,'男'),(4,'李一',88,98,92,32,76,'男'),(5,'李来财',82,84,67,43,76,'男'),(6,'张进宝',55,85,45,43,87,'女'),(7,'黄蓉',75,65,30,54,10,'女'),(8,'',56,89,78,89,56,'男'),(9,'哈哈',NULL,89,78,89,56,'男');

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `teacher` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
