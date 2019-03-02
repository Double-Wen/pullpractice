/*
 Navicat Premium Data Transfer

 Source Server         : bmatch
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : rm-bp1s8wez9j4hw42oemo.mysql.rds.aliyuncs.com:3306
 Source Schema         : dizi-04

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 02/03/2019 11:47:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for liuwenwen_record
-- ----------------------------
DROP TABLE IF EXISTS `liuwenwen_record`;
CREATE TABLE `liuwenwen_record`  (
  `事件id` int(11) NOT NULL,
  `记账时间` datetime(0) NOT NULL,
  `发生时间` datetime(0) NOT NULL,
  `记账类型` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `账目详情` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `账目备注` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `账户类型` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `变动金额` int(11) NOT NULL COMMENT '考虑到金额为分的整数倍并且不涉及到利息的计算，所以用整型存储',
  `预算余额` int(11) DEFAULT NULL COMMENT '考虑到金额为分的整数倍并且不涉及到利息的计算，所以用整型存储',
  `本月收入` int(11) DEFAULT NULL COMMENT '考虑到金额为分的整数倍并且不涉及到利息的计算，所以用整型存储',
  `本月支出` int(11) DEFAULT NULL COMMENT '考虑到金额为分的整数倍，所以用整型存储并且不涉及到利息的计算',
  PRIMARY KEY (`事件id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
