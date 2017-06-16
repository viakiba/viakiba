/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : xypj_hibernate

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2016-07-20 10:27:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_commoncode
-- ----------------------------
DROP TABLE IF EXISTS `t_commoncode`;
CREATE TABLE `t_commoncode` (
  `ID` varchar(32) NOT NULL,
  `CODE` varchar(32) DEFAULT NULL,
  `NAME` varchar(64) DEFAULT NULL,
  `NOTE` varchar(64) DEFAULT NULL,
  `order_field` bigint(20) NOT NULL,
  `TYPE` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK2AB36F23544F2095` (`TYPE`),
  CONSTRAINT `FK2AB36F23544F2095` FOREIGN KEY (`TYPE`) REFERENCES `t_commoncode` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_commoncode
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` varchar(32) NOT NULL,
  `password` varchar(32) DEFAULT NULL,
  `username` varchar(32) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `dept` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'e10adc3949ba59abbe56e057f20f883e', 'admin', null, null, null, null);
INSERT INTO `t_user` VALUES ('40288e815602c373015602c821170000', '6364d3f0f495b6ab9dcf8d3b5c6e0b01', '1221', '0', '321321', '32321', '2016-07-19 18:51:25');
INSERT INTO `t_user` VALUES ('40288e815602d05f015602d0efbd0000', '6512bd43d9caa6e02c990b0a82652dca', '是多少', '0', '11', '1111', '2016-07-19 19:01:02');
INSERT INTO `t_user` VALUES ('40288e815602d05f015602d1208d0001', '6512bd43d9caa6e02c990b0a82652dca', '是多少', '0', '11', '1111', '2016-07-19 19:01:15');
