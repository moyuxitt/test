/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 03/12/2023 15:38:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `emp_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '职员姓名',
  `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别，可选范围[男0，女1]',
  `age` int(255) NULL DEFAULT NULL COMMENT '年龄',
  `dept_name` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '部门名称，可选范围[业务部，后勤部，人事部]',
  `emp_degree_name` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学历',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('019050dc-fafe-0cb3-2d57-16b2c73e5425', '王六', '0', 45, '2', '1');
INSERT INTO `employee` VALUES ('0a3f20cb-0c7b-d03a-4b65-5996431e8f4f', '李五', '0', 58, '0', '0');
INSERT INTO `employee` VALUES ('0d1e566f-542c-d4ae-29af-7ca3741f9866', '王四', '0', 23, '0', '0');
INSERT INTO `employee` VALUES ('11947f3e-2d3b-a75c-e2e9-f00f4bdd4df0', '王五', '1', 33, '0', '0');
INSERT INTO `employee` VALUES ('12ae2733-67d2-4204-513f-0f50522a5120', '赵五', '1', 35, '1', '0');
INSERT INTO `employee` VALUES ('2dd636ec-db80-ba29-0156-7b994b253a36', '张四', '1', 28, '2', '0');
INSERT INTO `employee` VALUES ('310599a4-5f1e-b30f-8dfb-26f72513da22', '赵一', '0', 26, '2', '2');
INSERT INTO `employee` VALUES ('381af488-b5e6-6a5a-b3ef-a98e801d868f', '张一', '0', 25, '0', '1');
INSERT INTO `employee` VALUES ('3b3df6a5-1894-e65d-f619-bf92babef897', '王八', '0', 41, '1', '1');
INSERT INTO `employee` VALUES ('42c79507-b19b-4309-80af-82335658c5fd', '李七', '0', 26, '1', '0');
INSERT INTO `employee` VALUES ('46a5dc3b-8add-05d5-4c31-adf67456e85a', '张九', '1', 33, '0', '0');
INSERT INTO `employee` VALUES ('4ac14a9b-3dd4-2c5c-1d7f-df9dd92fb5a0', '王一', '0', 45, '1', '1');
INSERT INTO `employee` VALUES ('4def7102-4494-0536-f0d0-e0c915e04ee3', '张二', '1', 26, '2', '1');
INSERT INTO `employee` VALUES ('5430f317-ab0f-07b4-83a1-b4d9c37c2f17', '赵三', '1', 21, '2', '2');
INSERT INTO `employee` VALUES ('59956342-762d-1f67-40c6-24054e757a84', '李三', '0', 28, '0', '2');
INSERT INTO `employee` VALUES ('6aeebcf9-86d0-0cb5-52de-42ab0badb827', '李六', '1', 22, '2', '2');
INSERT INTO `employee` VALUES ('6ee7b032-6f64-3783-b93c-48ce461302e2', '李一', '1', 45, '0', '2');
INSERT INTO `employee` VALUES ('714bc243-4169-0d58-1b59-933744879103', '赵二', '0', 20, '1', '1');
INSERT INTO `employee` VALUES ('7331230e-7ecf-09e9-eee1-0dacce0e9f20', '赵六', '0', 24, '0', '2');
INSERT INTO `employee` VALUES ('751ffa1c-1fa6-34d0-335f-52d9ecd22ef6', '张六', '1', 29, '1', '1');
INSERT INTO `employee` VALUES ('77b22f01-5b80-9bf4-869b-133f22226ff4', '王三', '0', 21, '0', '0');
INSERT INTO `employee` VALUES ('868e7292-5a54-b268-66cd-282da0bdec2e', '赵八', '1', 33, '0', '2');
INSERT INTO `employee` VALUES ('8861f9ac-b66c-5e90-2413-2bd9605a05a6', '赵四', '0', 19, '1', '2');
INSERT INTO `employee` VALUES ('8b91da24-6adc-696a-102c-83fc77416a51', '李四', '1', 46, '1', '2');
INSERT INTO `employee` VALUES ('8f30d6ed-b1c0-fc21-0577-86d411fa36e2', '王七', '0', 35, '0', '2');
INSERT INTO `employee` VALUES ('92dc84f4-d206-46be-0124-b48eae5a32da', '李九', '1', 29, '1', '2');
INSERT INTO `employee` VALUES ('9496e1c2-e498-aa9b-e4b1-27d44a674174', '赵七', '0', 29, '0', '0');
INSERT INTO `employee` VALUES ('a426c4f3-9029-b74e-4cd7-e0206f6da468', '赵九', '0', 45, '0', '1');
INSERT INTO `employee` VALUES ('ae595d0f-57be-a155-2720-d94063fe4b7a', '张三', '0', 27, '1', '0');
INSERT INTO `employee` VALUES ('b05f12c8-6738-5157-13ec-231a3550b1c5', '王九', '1', 25, '0', '0');
INSERT INTO `employee` VALUES ('c0f0cca9-ca80-65bc-8fbb-285bd13cd717', '张七', '0', 33, '0', '2');
INSERT INTO `employee` VALUES ('c70448d0-3d97-8936-7c60-8f3121693372', '张五', '0', 29, '1', '0');
INSERT INTO `employee` VALUES ('ced472e3-5f27-3990-0ed3-e068218f4032', '李八', '0', 25, '2', '2');
INSERT INTO `employee` VALUES ('d6840167-1658-2132-d35a-232fe61a2d74', '王二', '1', 21, '0', '1');
INSERT INTO `employee` VALUES ('d82ca348-a5dd-ce6d-b516-385178748739', '李二', '1', 19, '2', '1');
INSERT INTO `employee` VALUES ('d86cee68-21d7-8138-7ce6-a119636db37a', '张八', '0', 32, '0', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `enable` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '是否启用（0：banned，1: normal）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2237d24f7a35ef71990fbd32659eba5c', 'admin', '123456', '2023-11-30 14:27:04', '1');

SET FOREIGN_KEY_CHECKS = 1;
