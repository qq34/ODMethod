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

 Date: 11/12/2019 10:15:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for entrance_name_translate
-- ----------------------------
DROP TABLE IF EXISTS `entrance_name_translate`;
CREATE TABLE `entrance_name_translate`  (
  `gantryID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `entranceName` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`gantryID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of entrance_name_translate
-- ----------------------------
INSERT INTO `entrance_name_translate` VALUES ('mbshb01', 'ZengGuanGaoSu');
INSERT INTO `entrance_name_translate` VALUES ('mbshb02', 'LiChengZhan');
INSERT INTO `entrance_name_translate` VALUES ('mbshb03', 'ZhuCunDongZhan');
INSERT INTO `entrance_name_translate` VALUES ('mbshb04', 'ZhongXinZhan');
INSERT INTO `entrance_name_translate` VALUES ('mbshb05', 'XinHeZhan');
INSERT INTO `entrance_name_translate` VALUES ('mbshn01', 'LiChengZhan');
INSERT INTO `entrance_name_translate` VALUES ('mbshn02', 'ZhuCunDongZhan');
INSERT INTO `entrance_name_translate` VALUES ('mbshn03', 'ZhongXinZhan');
INSERT INTO `entrance_name_translate` VALUES ('mbshn04', 'XinHeZhan');
INSERT INTO `entrance_name_translate` VALUES ('mbshn05', 'YangHeLiJiao');
INSERT INTO `entrance_name_translate` VALUES ('mghd01', 'ChunGangLiJiao');
INSERT INTO `entrance_name_translate` VALUES ('mghd02', 'GuangFoZhaoFengHuangShan');
INSERT INTO `entrance_name_translate` VALUES ('mghd03', 'BaDouLiJiao');
INSERT INTO `entrance_name_translate` VALUES ('mghd04', 'BaDouZhan');
INSERT INTO `entrance_name_translate` VALUES ('mghd05', 'FuShanZhan');
INSERT INTO `entrance_name_translate` VALUES ('mghd06', 'ZhiShiChengZhan');
INSERT INTO `entrance_name_translate` VALUES ('mghd07', 'ZhongXinZhan');
INSERT INTO `entrance_name_translate` VALUES ('mghd08', 'ErLongZhan');
INSERT INTO `entrance_name_translate` VALUES ('mghd09', 'LaPuZhan');
INSERT INTO `entrance_name_translate` VALUES ('mghd10', 'HuangLinXiangLiJiao');
INSERT INTO `entrance_name_translate` VALUES ('mghd11', 'ZhengGuoZhan');
INSERT INTO `entrance_name_translate` VALUES ('mghx01', 'GuangFoZhaoFengHuangShan');
INSERT INTO `entrance_name_translate` VALUES ('mghx02', 'BaDouLiJiao');
INSERT INTO `entrance_name_translate` VALUES ('mghx03', 'BaDouZhan');
INSERT INTO `entrance_name_translate` VALUES ('mghx04', 'FuShanZhan');
INSERT INTO `entrance_name_translate` VALUES ('mghx05', 'ZhiShiChengZhan');
INSERT INTO `entrance_name_translate` VALUES ('mghx06', 'ZhongXinZhan');
INSERT INTO `entrance_name_translate` VALUES ('mghx07', 'ErLongZhan');
INSERT INTO `entrance_name_translate` VALUES ('mghx08', 'LaPuZhan');
INSERT INTO `entrance_name_translate` VALUES ('mghx09', 'HuangLinXiangLiJiao');
INSERT INTO `entrance_name_translate` VALUES ('mghx10', 'ZhengGuoZhan');
INSERT INTO `entrance_name_translate` VALUES ('mghx11', 'GuangHeHuiZhouDuan');
INSERT INTO `entrance_name_translate` VALUES ('mzcb01', 'TaoYuanZhan');
INSERT INTO `entrance_name_translate` VALUES ('mzcb02', 'GuanCunZhan');
INSERT INTO `entrance_name_translate` VALUES ('mzcb03', 'PaiTanZhan');
INSERT INTO `entrance_name_translate` VALUES ('mzcb04', 'HuangLinXiangLiJiao');
INSERT INTO `entrance_name_translate` VALUES ('mzcb05', 'XiaoLouZhan');
INSERT INTO `entrance_name_translate` VALUES ('mzcb06', 'ZhengGuoNanZhan');
INSERT INTO `entrance_name_translate` VALUES ('mzcb07', 'ZengChengZhan');
INSERT INTO `entrance_name_translate` VALUES ('mzcb08', 'CongGuanSenHuiZhou');
INSERT INTO `entrance_name_translate` VALUES ('mzcb09', 'PaiTanZhan');
INSERT INTO `entrance_name_translate` VALUES ('mzcb10', 'ShuangFengZhan');
INSERT INTO `entrance_name_translate` VALUES ('mzcn01', 'WeiDongLiJiao');
INSERT INTO `entrance_name_translate` VALUES ('mzcn02', 'TaoYuanZhan');
INSERT INTO `entrance_name_translate` VALUES ('mzcn03', 'GuanCunZhan');
INSERT INTO `entrance_name_translate` VALUES ('mzcn04', 'PaiTanZhan');
INSERT INTO `entrance_name_translate` VALUES ('mzcn05', 'HuangLinXiangLiJiao');
INSERT INTO `entrance_name_translate` VALUES ('mzcn06', 'XiaoLouZhan');
INSERT INTO `entrance_name_translate` VALUES ('mzcn07', 'ZhengGuoNanZhan');
INSERT INTO `entrance_name_translate` VALUES ('mzcn08', 'ZengChengZhan');
INSERT INTO `entrance_name_translate` VALUES ('mzcn09', 'ShuangFengZhan');
INSERT INTO `entrance_name_translate` VALUES ('mzcn10', 'JieKouLianJieChu');

SET FOREIGN_KEY_CHECKS = 1;
