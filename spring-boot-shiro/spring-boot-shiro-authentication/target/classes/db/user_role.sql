/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 80300
Source Host           : localhost:3306
Source Database       : spring-boot

Target Server Type    : MYSQL
Target Server Version : 80300
File Encoding         : 65001

Date: 2025-02-12 19:16:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `rid` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT into user_role values(1,1);
INSERT into user_role values(2,2);