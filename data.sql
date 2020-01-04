/*
 Navicat Premium Data Transfer

 Source Server         : 111
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : areals

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 11/12/2019 10:10:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for data
-- ----------------------------
DROP TABLE IF EXISTS `data`;
CREATE TABLE `data`  (
  `gantryID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `plate` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `carType` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `carModel` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `fare` int(32) NULL DEFAULT NULL,
  `speed` double(32, 0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of data
-- ----------------------------
INSERT INTO `data` VALUES ('mghd01', '粤12345', '1', '1', '2019-12-10 21:23:09', 1000, 100);
INSERT INTO `data` VALUES ('mghd02', '粤12345', '1', '1', '2019-12-10 21:23:11', 1000, 100);
INSERT INTO `data` VALUES ('mghd03', '粤12345', '1', '1', '2019-12-10 21:23:12', 1000, 100);
INSERT INTO `data` VALUES ('mbdz', '粤12345', '1', '1', '2019-12-10 21:23:13', 1000, 100);
INSERT INTO `data` VALUES ('mghd01', '粤333', '1', '1', '2019-12-11 09:12:10', 1000, 100);

SET FOREIGN_KEY_CHECKS = 1;
