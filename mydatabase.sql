/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : mydatabase

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 12/03/2024 00:19:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country`  (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`country_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES (1, 'china');
INSERT INTO `country` VALUES (2, 'Japan');
INSERT INTO `country` VALUES (3, '123');
INSERT INTO `country` VALUES (4, '321');
INSERT INTO `country` VALUES (5, '789');
INSERT INTO `country` VALUES (6, '564');

-- ----------------------------
-- Table structure for language
-- ----------------------------
DROP TABLE IF EXISTS `language`;
CREATE TABLE `language`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Language` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region`  (
  `region_id` int(11) NOT NULL AUTO_INCREMENT,
  `region_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `country_id` int(11) NOT NULL,
  PRIMARY KEY (`region_id`) USING BTREE,
  INDEX `country_id`(`country_id`) USING BTREE,
  CONSTRAINT `country_id` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of region
-- ----------------------------
INSERT INTO `region` VALUES (1, 'shanghai', 1);
INSERT INTO `region` VALUES (2, 'Tokyo', 2);
INSERT INTO `region` VALUES (3, '333', 3);
INSERT INTO `region` VALUES (4, 'beijing', 1);
INSERT INTO `region` VALUES (5, 'guangzhou', 1);
INSERT INTO `region` VALUES (6, '321', 3);
INSERT INTO `region` VALUES (7, '456', 3);
INSERT INTO `region` VALUES (8, 'string', 3);
INSERT INTO `region` VALUES (9, 'string1', 3);

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `contributor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tool_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `thumbnail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `industry` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `themes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `organizations` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `region` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `language` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for submit
-- ----------------------------
DROP TABLE IF EXISTS `submit`;
CREATE TABLE `submit`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `contributor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tool_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `thumbnail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `industry` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `themes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `organizations` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `region` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `language` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `is_review` int(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of submit
-- ----------------------------
INSERT INTO `submit` VALUES (5, 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', '1', NULL, 0);
INSERT INTO `submit` VALUES (6, '123', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', '0', NULL, NULL);
INSERT INTO `submit` VALUES (7, '2', '4', '2', '5', '0', 'http://localhost:8080/upload/20240229_01074666.png', '3', NULL, '1', '6', '-', '8', '3', '9', '7', '0', NULL, NULL);
INSERT INTO `submit` VALUES (8, '2', '4', '2', '5', '0', 'http://localhost:8080/upload/20240229_01095352.png', '3', NULL, '1', '6', '-', '8', '3', '9', '7', '0', NULL, NULL);
INSERT INTO `submit` VALUES (9, '2', '4', '2', '5', '0', 'http://localhost:8080/upload/20240229_0112385.png', '3', NULL, '1', '6', '-', '8', '3', '9', '7', '0', NULL, NULL);
INSERT INTO `submit` VALUES (10, '231', '231', '231', '231', '312', 'http://localhost:8080/upload/20240229_17541445.jpg', '1', NULL, '456', '213', '897', '789', '321', '456', '546', '0', NULL, NULL);
INSERT INTO `submit` VALUES (11, '231', '231', '231', '231', '312', 'http://localhost:8080/upload/20240229_17592460.jpg', '1', NULL, '456', '213', '897', '789', '321', '456', '546', '0', NULL, NULL);
INSERT INTO `submit` VALUES (12, '32', '23', '12', '3', '312', 'http://localhost:8080/upload/20240229_18141764.jpg', NULL, NULL, '23', '321', '32', '312', '12', '123', '123', '0', NULL, NULL);
INSERT INTO `submit` VALUES (13, '1', '1', '1', '1', '1', 'http://localhost:8080/upload/20240229_1952573.jpg', NULL, NULL, '1', '1', '1', '1', '1', '1', '1', '0', NULL, NULL);
INSERT INTO `submit` VALUES (14, '1', '1', '1', '1', '1', 'http://localhost:8080/upload/20240229_19532560.png', NULL, NULL, '1', '1', '1', '1', '1', '1', '1', '0', NULL, NULL);
INSERT INTO `submit` VALUES (15, '1', '1', '1', '1', '1', 'http://localhost:8080/upload/20240229_19570821.png', NULL, NULL, '1', '1', '1', '1', '1', '1', '1', '0', NULL, NULL);
INSERT INTO `submit` VALUES (16, '1', '1', '1', '1', '1', 'http://localhost:8080/upload/20240229_19592810.png', NULL, NULL, '1', '1', '1', '1', '1', '1', '1', '0', NULL, NULL);
INSERT INTO `submit` VALUES (17, '1', '1', '1', '1', '1', 'http://localhost:8080/upload/20240229_20162741.jpg', 'http://localhost:8080/upload/20240229_20162735.zip', NULL, '1', '1', '1', '1', '1', '1', '1', '0', NULL, NULL);
INSERT INTO `submit` VALUES (18, '1', '1', '1', '1', '1', 'http://localhost:8080/upload/20240229_20244139.jpg', 'http://localhost:8080/upload/20240229_20244138.zip', NULL, '1', '1', '1', '1', '1', '1', '1', '0', NULL, NULL);
INSERT INTO `submit` VALUES (19, '14', '4', '2', '5', '11', '1', '15', NULL, '13', '7', '12', '9', '3', '10', '8', '0', NULL, 0);
INSERT INTO `submit` VALUES (20, 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', '0', NULL, 0);
INSERT INTO `submit` VALUES (21, 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', '0', NULL, 0);
INSERT INTO `submit` VALUES (22, 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', '0', NULL, 0);
INSERT INTO `submit` VALUES (23, 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', '0', NULL, 0);
INSERT INTO `submit` VALUES (29, 'Student', 'This is a test description for the submission page', 'Mohamed Farah', 'fara0263@algonquinlive.com', 'Myself', NULL, 'null', NULL, 'null', 'Test industry', 'all', 'Test organization', 'Canada,United States of America', 'North America', 'English,French', '0', NULL, 0);
INSERT INTO `submit` VALUES (30, 'Student', 'This is a test description for the submission page', 'Mohamed Farah', 'fara0263@algonquinlive.com', 'Myself', 'localhost', 'null', NULL, 'null', 'Test industry', 'all', 'Test organization', 'Canada,United States of America', 'North America', 'English,French', '0', NULL, 0);
INSERT INTO `submit` VALUES (31, 'Student', 'This is a test description for the submission page', 'Mohamed Farah', 'fara0263@algonquinlive.com', 'Myself', 'localhost', 'http://localhost:8080/upload/20240311_15472512.zip', NULL, 'null', 'Test industry', 'all', 'Test organization', 'America', 'North America', 'English,French', '0', NULL, 0);
INSERT INTO `submit` VALUES (32, 'Student', 'This is a test description for the submission page', 'Mohamed Farah', 'fara0263@algonquinlive.com', 'Myself', 'localhost', 'http://localhost:8080/upload/20240311_15512697.zip', 'http://localhost:8080/upload/20240311_15512660.jpg', 'null', 'Test industry', 'all', 'Test organization', 'America', 'North America', 'English,French', '0', NULL, 0);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', 'asd123');
INSERT INTO `users` VALUES (2, 'root', 'asd123');

-- ----------------------------
-- Table structure for users_token
-- ----------------------------
DROP TABLE IF EXISTS `users_token`;
CREATE TABLE `users_token`  (
  `user_id` int(11) NOT NULL,
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `expire_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users_token
-- ----------------------------
INSERT INTO `users_token` VALUES (1, '1cdb24e49829ec83398fdc97a3a71556', '2024-03-02 01:31:25', '2024-03-04 01:31:25');
INSERT INTO `users_token` VALUES (2, '4ee3da7c4eb35e1a57bd65ae09a82df-', '2024-02-06 00:49:36', '2024-02-08 00:49:36');

SET FOREIGN_KEY_CHECKS = 1;
