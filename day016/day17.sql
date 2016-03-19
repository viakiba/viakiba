/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.40 : Database - day17
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`day17` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `day17`;

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `id` int(11) NOT NULL,
  `deptNname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dept` */

insert  into `dept`(`id`,`deptNname`) values (2,'软件开发部'),(3,'秘书部'),(4,'秘书部'),(5,'总经办');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `empName` varchar(20) DEFAULT NULL,
  `deptId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employee_dept_fk` (`deptId`),
  CONSTRAINT `employee_dept_fk` FOREIGN KEY (`deptId`) REFERENCES `dept` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`id`,`empName`,`deptId`) values (1,'张三',2),(2,'李四',2),(3,'王五',2),(6,'哈哈哈',2),(7,'哈哈哈',2);

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `id` int(11) DEFAULT NULL,
  `sname` varchar(20) DEFAULT NULL,
  `sgender` varchar(2) DEFAULT '男'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `test` */

insert  into `test`(`id`,`sname`,`sgender`) values (1,'张三','男'),(1,'张三',NULL);

/*Table structure for table `test1` */

DROP TABLE IF EXISTS `test1`;

CREATE TABLE `test1` (
  `id` int(11) DEFAULT NULL,
  `sname` varchar(20) DEFAULT NULL,
  `sgender` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `test1` */

insert  into `test1`(`id`,`sname`,`sgender`) values (15,'张三',''),(15,'张三','na');

/*Table structure for table `test2` */

DROP TABLE IF EXISTS `test2`;

CREATE TABLE `test2` (
  `id` int(11) DEFAULT NULL,
  `sname` varchar(20) DEFAULT NULL,
  `sgender` varchar(2) DEFAULT NULL,
  UNIQUE KEY `sgender` (`sgender`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `test2` */

insert  into `test2`(`id`,`sname`,`sgender`) values (15,'张三','na');

/*Table structure for table `test3` */

DROP TABLE IF EXISTS `test3`;

CREATE TABLE `test3` (
  `id` int(11) NOT NULL,
  `sname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `test3` */

insert  into `test3`(`id`,`sname`) values (1,'haha');

/*Table structure for table `test4` */

DROP TABLE IF EXISTS `test4`;

CREATE TABLE `test4` (
  `age` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`age`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `test4` */

insert  into `test4`(`age`,`name`) values (1,'张三');

/*Table structure for table `test_log` */

DROP TABLE IF EXISTS `test_log`;

CREATE TABLE `test_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `test_log` */

insert  into `test_log`(`id`,`content`) values (1,'员工表插入了一条记录'),(2,'员工更新了一条数据'),(3,'员工删除了一条数据');

/* Trigger structure for table `employee` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `tri_empAdd` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `tri_empAdd` AFTER INSERT ON `employee` FOR EACH ROW -- 当往员工表插入一条记录时
     INSERT INTO test_log(content) VALUES('员工表插入了一条记录') */$$


DELIMITER ;

/* Trigger structure for table `employee` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `tri_empUp` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `tri_empUp` AFTER UPDATE ON `employee` FOR EACH ROW insert into test_log(content) values ('员工更新了一条数据') */$$


DELIMITER ;

/* Trigger structure for table `employee` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `test_empDel` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `test_empDel` AFTER DELETE ON `employee` FOR EACH ROW insert into test_log(content) values('员工删除了一条数据') */$$


DELIMITER ;

/* Procedure structure for procedure `porte` */

/*!50003 DROP PROCEDURE IF EXISTS  `porte` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `porte`(inout ide int)
begin
 -- 查看变量
	select ide;
	set ide=30;
end */$$
DELIMITER ;

/* Procedure structure for procedure `proji` */

/*!50003 DROP PROCEDURE IF EXISTS  `proji` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `proji`(IN num INT,OUT str VARCHAR(20))
begin
	if num=1 then
	set str='星期一';
	elseif num=2 THEN
	SET str='星期二';
	ELSEIF num=3 THEN
		SET str='星期三';
	ELSE
		SET str='输入错误';
	END IF;
end */$$
DELIMITER ;

/* Procedure structure for procedure `prot` */

/*!50003 DROP PROCEDURE IF EXISTS  `prot` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `prot`(out str varchar(20))
begin
 set str='hello';
end */$$
DELIMITER ;

/* Procedure structure for procedure `pro_test` */

/*!50003 DROP PROCEDURE IF EXISTS  `pro_test` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_test`()
BEGIN
	-- 可以写多个sql语句;
	SELECT * FROM employee;
END */$$
DELIMITER ;

/* Procedure structure for procedure `pro_testWhile` */

/*!50003 DROP PROCEDURE IF EXISTS  `pro_testWhile` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `pro_testWhile`(IN num INT,OUT result INT)
BEGIN
	-- 定义一个局部变量
	DECLARE i INT DEFAULT 1;
	DECLARE vsum INT DEFAULT 0;
	WHILE i<=num DO
	      SET vsum = vsum+i;
	      SET i=i+1;
	END WHILE;
	SET result=vsum;
END */$$
DELIMITER ;

/* Procedure structure for procedure `stu` */

/*!50003 DROP PROCEDURE IF EXISTS  `stu` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `stu`(in avgs int,out str varchar(20))
begin
	if avgs<=70 then
		set str='一般';
	elseif avgs>70 and avgs<=90 then
		SET str='良好';
	else
		SET str='优秀';
	end if;
end */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
