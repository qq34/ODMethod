/*
 Navicat Premium Data Transfer

 Source Server         : 111
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : odmethor

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 11/12/2019 10:15:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exit_name_translate
-- ----------------------------
DROP TABLE IF EXISTS `exit_name_translate`;
CREATE TABLE `exit_name_translate`  (
  `gantryID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `exitName` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exit_name_translate
-- ----------------------------
INSERT INTO `exit_name_translate` VALUES ('mghd01', 'GuangFoZhaoFengHuangShan');
INSERT INTO `exit_name_translate` VALUES ('mghd02', 'BaDouLiJiao');
INSERT INTO `exit_name_translate` VALUES ('mghd11', 'GuangHeHuiZhouDuan');
INSERT INTO `exit_name_translate` VALUES ('mghx03', 'BaDouLiJiao');
INSERT INTO `exit_name_translate` VALUES ('mghx01', 'ChunGangLiJiao');
INSERT INTO `exit_name_translate` VALUES ('mbshb05', 'YangHeLiJiao');
INSERT INTO `exit_name_translate` VALUES ('mbshn01', 'GuanSenGaoSu');
INSERT INTO `exit_name_translate` VALUES ('mzcb01', 'WeiDongLiJiao');
INSERT INTO `exit_name_translate` VALUES ('mzcb10', 'JieKouLianJieChu');
INSERT INTO `exit_name_translate` VALUES ('mzcn08', 'CongGuanSenHuiZhou');
INSERT INTO `exit_name_translate` VALUES ('mbdz', 'BaDouZhan');
INSERT INTO `exit_name_translate` VALUES ('mfsz', 'FuShanZhan');
INSERT INTO `exit_name_translate` VALUES ('mzscz', 'ZhiShiChengZhan');
INSERT INTO `exit_name_translate` VALUES ('mzxz', 'ZhongXinZhan');
INSERT INTO `exit_name_translate` VALUES ('melz', 'ErLongZhan');
INSERT INTO `exit_name_translate` VALUES ('mlpz', 'LaPuZhan');
INSERT INTO `exit_name_translate` VALUES ('mzgz', 'ZhengGuoZhan');
INSERT INTO `exit_name_translate` VALUES ('mlcz', 'LiChengZhan');
INSERT INTO `exit_name_translate` VALUES ('mzcdz', 'ZhuCunDongZhan');
INSERT INTO `exit_name_translate` VALUES ('mxhz', 'XinHeZhan');
INSERT INTO `exit_name_translate` VALUES ('mzcz', 'ZengChengZhan');
INSERT INTO `exit_name_translate` VALUES ('mzgnz', 'ZhengGuoNanZhan');
INSERT INTO `exit_name_translate` VALUES ('mxlz', 'XiaoLouZhan');
INSERT INTO `exit_name_translate` VALUES ('mptz', 'PaiTanZhan');
INSERT INTO `exit_name_translate` VALUES ('mgcz', 'GuanCunZhan');
INSERT INTO `exit_name_translate` VALUES ('mtyz', 'TaoYuanZhan');
INSERT INTO `exit_name_translate` VALUES ('msfz', 'ShuangFengZhan');
INSERT INTO `exit_name_translate` VALUES ('mjkz', 'JieKouLianJieChu');

SET FOREIGN_KEY_CHECKS = 1;
