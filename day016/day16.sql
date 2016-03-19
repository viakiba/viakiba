/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.40 : Database - day16
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`day16` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `day16`;

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `sid` int(11) DEFAULT NULL,
  `sname` varchar(20) DEFAULT NULL,
  `math` int(11) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`sid`,`sname`,`math`,`gender`,`age`) values (10,'张三',88,'男',56),(1,'李四',32,'男',56),(2,'王五',45,'女',21),(3,'罗六',78,'男',43),(4,'小七',98,'女',43),(5,'王八',97,'女',32),(6,'小九',54,'男',36),(7,'龙九',78,'女',65),(8,'二保',89,'女',65),(9,'三杀',80,'男',43);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
