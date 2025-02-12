/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80300
Source Host           : localhost:3306
Source Database       : spring-boot

Target Server Type    : MYSQL
Target Server Version : 80300
File Encoding         : 65001

Date: 2025-02-12 18:44:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `url` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO permission(url,name) VALUES ('/user', 'user:user');
INSERT INTO permission(url,name) VALUES ('/user/add', 'user:add');
INSERT INTO permission(url,name) VALUES ('/user/delete', 'user:delete');