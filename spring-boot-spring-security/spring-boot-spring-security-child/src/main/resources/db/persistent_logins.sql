/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80300
Source Host           : localhost:3306
Source Database       : spring-boot

Target Server Type    : MYSQL
Target Server Version : 80300
File Encoding         : 65001

Date: 2025-02-14 11:18:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `persistent_logins`
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
