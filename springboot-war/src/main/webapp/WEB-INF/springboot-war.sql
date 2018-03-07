/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50632
Source Host           : localhost:3306
Source Database       : springboot-war

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2017-05-29 22:24:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `score` varchar(255) DEFAULT NULL,
  `sum` varchar(255) DEFAULT NULL,
  `avg` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', 'wwh', '60', '60', '30', '2');
INSERT INTO `t_student` VALUES ('2', 'wwh1', '80', '80', '40', '2');
INSERT INTO `t_student` VALUES ('3', 'wwh2', '180', '180', '60', '3');
INSERT INTO `t_student` VALUES ('4', 'wwh3', '160', '160', '80', '2');
