/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80300
Source Host           : localhost:3306
Source Database       : spring-boot

Target Server Type    : MYSQL
Target Server Version : 80300
File Encoding         : 65001

Date: 2025-02-12 12:46:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `no` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `sex` char(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
