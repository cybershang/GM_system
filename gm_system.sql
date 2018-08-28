/*
Navicat MySQL Data Transfer

Source Server         : first
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : gm_system

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-08-25 10:28:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gm_grade
-- ----------------------------
DROP TABLE IF EXISTS `gm_grade`;
CREATE TABLE `gm_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `score` varchar(255) DEFAULT NULL,
  `s_id` int(11) NOT NULL,
  `t_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gm_grade
-- ----------------------------
INSERT INTO `gm_grade` VALUES ('1', '99', '1', '1');
INSERT INTO `gm_grade` VALUES ('2', '97', '2', '1');
INSERT INTO `gm_grade` VALUES ('3', '96', '3', '1');

-- ----------------------------
-- Table structure for gm_role
-- ----------------------------
DROP TABLE IF EXISTS `gm_role`;
CREATE TABLE `gm_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gm_role
-- ----------------------------
INSERT INTO `gm_role` VALUES ('1', '老师');
INSERT INTO `gm_role` VALUES ('2', '学生');
INSERT INTO `gm_role` VALUES ('3', '管理员');

-- ----------------------------
-- Table structure for gm_student
-- ----------------------------
DROP TABLE IF EXISTS `gm_student`;
CREATE TABLE `gm_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentname` varchar(255) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gm_student
-- ----------------------------
INSERT INTO `gm_student` VALUES ('1', 'student1', 'haorenyige');
INSERT INTO `gm_student` VALUES ('2', 'student2', 'hhahah');
INSERT INTO `gm_student` VALUES ('3', 'student3', 'huairen');

-- ----------------------------
-- Table structure for gm_teacher
-- ----------------------------
DROP TABLE IF EXISTS `gm_teacher`;
CREATE TABLE `gm_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teachername` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gm_teacher
-- ----------------------------
INSERT INTO `gm_teacher` VALUES ('1', 'teacher1');

-- ----------------------------
-- Table structure for gm_user
-- ----------------------------
DROP TABLE IF EXISTS `gm_user`;
CREATE TABLE `gm_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gm_user
-- ----------------------------
INSERT INTO `gm_user` VALUES ('2', 'student1', '2', '2');
INSERT INTO `gm_user` VALUES ('3', 'admin1', '3', '3');
INSERT INTO `gm_user` VALUES ('11', 'teacher1', '1', '1');
