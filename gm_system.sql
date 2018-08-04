/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : gm_system

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-08-04 22:39:52
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gm_grade
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gm_student
-- ----------------------------

-- ----------------------------
-- Table structure for gm_teacher
-- ----------------------------
DROP TABLE IF EXISTS `gm_teacher`;
CREATE TABLE `gm_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teachername` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gm_teacher
-- ----------------------------
INSERT INTO `gm_teacher` VALUES ('2', 'teacher2');
INSERT INTO `gm_teacher` VALUES ('6', 'teacher7');
INSERT INTO `gm_teacher` VALUES ('7', 'teacher8');
INSERT INTO `gm_teacher` VALUES ('8', 'teacher9');
INSERT INTO `gm_teacher` VALUES ('9', 'teacher10');

-- ----------------------------
-- Table structure for gm_user
-- ----------------------------
DROP TABLE IF EXISTS `gm_user`;
CREATE TABLE `gm_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gm_user
-- ----------------------------
INSERT INTO `gm_user` VALUES ('2', 'student1', '22222', '2');
INSERT INTO `gm_user` VALUES ('3', 'admin', '33333', '3');
INSERT INTO `gm_user` VALUES ('8', 'teacher2', '44444', '1');
INSERT INTO `gm_user` VALUES ('11', 'teacher7', '77777', '1');
INSERT INTO `gm_user` VALUES ('13', 'teacher8', '88888', '1');
INSERT INTO `gm_user` VALUES ('14', 'teacher9', '99999', '1');
INSERT INTO `gm_user` VALUES ('15', 'teacher10', '000000', '1');
