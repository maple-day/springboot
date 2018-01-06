/*
Navicat MySQL Data Transfer

Source Server         : locl
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-01-06 09:54:23
*/

SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for `student_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `student_teacher`;
CREATE TABLE `student_teacher` (
  `student_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  PRIMARY KEY (`student_id`,`teacher_id`),
  KEY `FKenbxcu5uho2uli009drevefj1` (`teacher_id`),
  CONSTRAINT `FK7iq16xm3bgblfsc71yplqoc1e` FOREIGN KEY (`student_id`) REFERENCES `t_student` (`id`),
  CONSTRAINT `FKenbxcu5uho2uli009drevefj1` FOREIGN KEY (`teacher_id`) REFERENCES `t_teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_teacher
-- ----------------------------
INSERT INTO `student_teacher` VALUES ('1', '1');
INSERT INTO `student_teacher` VALUES ('1', '2');
INSERT INTO `student_teacher` VALUES ('2', '2');
INSERT INTO `student_teacher` VALUES ('7', '2');
INSERT INTO `student_teacher` VALUES ('1', '3');
INSERT INTO `student_teacher` VALUES ('1', '5');

-- ----------------------------
-- Table structure for `t_student`
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', '学生:1');
INSERT INTO `t_student` VALUES ('2', '学生:2');
INSERT INTO `t_student` VALUES ('3', '学生:3');
INSERT INTO `t_student` VALUES ('4', '学生:4');
INSERT INTO `t_student` VALUES ('5', '学生:5');
INSERT INTO `t_student` VALUES ('6', '学生:6');
INSERT INTO `t_student` VALUES ('7', '学生:7');
INSERT INTO `t_student` VALUES ('8', '学生:8');
INSERT INTO `t_student` VALUES ('9', '学生:9');

-- ----------------------------
-- Table structure for `t_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('1', '老师1');
INSERT INTO `t_teacher` VALUES ('2', '老师2');
INSERT INTO `t_teacher` VALUES ('3', '老师3');
INSERT INTO `t_teacher` VALUES ('4', '老师7');
INSERT INTO `t_teacher` VALUES ('5', '老师5');
INSERT INTO `t_teacher` VALUES ('6', '老师8');
INSERT INTO `t_teacher` VALUES ('7', '老师9');
