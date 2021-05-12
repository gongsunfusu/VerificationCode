/*
Navicat MySQL Data Transfer

Source Server         : test_01
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : a_login_test

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2021-05-12 20:58:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) NOT NULL,
  `file_name` varchar(255) NOT NULL,
  `state` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'gongsunfusu', 'VJolwHxYajwIKxh83IJyxg==', 'c409f983-a61a-4a15-936d-2abe132bbe7b');
INSERT INTO `user` VALUES ('3', 'yangkaizhong', 'rD7IxJg+OnXLOGYnIDaKiA==', '86b31f2b-ac00-4790-b41b-3edb08882be6');
INSERT INTO `user` VALUES ('4', 'luyiweng', 'bH0qJArlh0cMHlVOdZ/Thw==', '41b3a829-eb78-4d6c-8875-242a837857b7');
INSERT INTO `user` VALUES ('5', 'guozepeng', 'r3MN5EmO4UNCqJNDBDeMrw==', '85a38bc0-c0b0-4d41-b3f2-a362f14b430b');
