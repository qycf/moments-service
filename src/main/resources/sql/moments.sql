/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : moments

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 26/08/2023 10:22:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for moments
-- ----------------------------
DROP TABLE IF EXISTS `moments`;
CREATE TABLE `moments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题',
  `content` text COLLATE utf8mb4_general_ci COMMENT '内容',
  `start` int DEFAULT '0' COMMENT '点赞量',
  `is_top` int DEFAULT '0' COMMENT '1:置顶 0:不置顶',
  `is_publish` int DEFAULT '1' COMMENT '1:发布 0:不发布',
  `is_delete` int DEFAULT '0' COMMENT '1:删除 0:不删除',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of moments
-- ----------------------------
BEGIN;
INSERT INTO `moments` (`id`, `title`, `content`, `start`, `is_top`, `is_publish`, `is_delete`, `update_time`, `create_time`) VALUES (1, '月亮真美', '<p><a href=\"http://localhost:5173/\"><span style=\"color: rgb(212, 177, 6);\">#庆余年2#</span></a>什么时候可以看呢？😅</p>这是一条动态这是一条动态这是一条动态这是一条动态这是一条动态这是一条动态这是一条动态这是一条动态这是一条动态', 0, 0, 1, 0, '2023-08-24 14:59:21', '2023-08-24 14:59:23');
COMMIT;

-- ----------------------------
-- Table structure for moments_tags
-- ----------------------------
DROP TABLE IF EXISTS `moments_tags`;
CREATE TABLE `moments_tags` (
  `id` int NOT NULL AUTO_INCREMENT,
  `moments_id` int NOT NULL,
  `tags_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of moments_tags
-- ----------------------------
BEGIN;
INSERT INTO `moments_tags` (`id`, `moments_id`, `tags_id`) VALUES (1, 1, 1);
INSERT INTO `moments_tags` (`id`, `moments_id`, `tags_id`) VALUES (2, 1, 2);
INSERT INTO `moments_tags` (`id`, `moments_id`, `tags_id`) VALUES (3, 2, 1);
COMMIT;

-- ----------------------------
-- Table structure for site_config
-- ----------------------------
DROP TABLE IF EXISTS `site_config`;
CREATE TABLE `site_config` (
  `id` int NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '站点标题',
  `avatar` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '站点头像',
  `cover` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '站点特色图',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '站长昵称',
  `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '个性签名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of site_config
-- ----------------------------
BEGIN;
INSERT INTO `site_config` (`id`, `title`, `avatar`, `cover`, `nickname`, `description`) VALUES (1, '如月而至', 'https://gallerys-1305976148.cos.ap-guangzhou.myqcloud.com/qiuyue2525.JPG', 'https://12366.chinatax.gov.cn/znzx/oss/download?oid=ZNZX00-230821165913-16926083539795620623349026986915', 'qiuyue2525', 'show your face');
COMMIT;

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标签名(英文)',
  `color` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '背景颜色(16进制)',
  `text_color` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '文字颜色(16进制)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of tags
-- ----------------------------
BEGIN;
INSERT INTO `tags` (`id`, `name`, `color`, `text_color`) VALUES (1, 'moon', '#3d455a', '#ba433d');
INSERT INTO `tags` (`id`, `name`, `color`, `text_color`) VALUES (2, 'scenery', '#c4a2aa', '#fff');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
