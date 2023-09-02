/*
 Navicat Premium Data Transfer

 Source Server         : localhost_mysql
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : moments

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 02/09/2023 22:32:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images` (
  `id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片链接',
  `exif` json DEFAULT NULL COMMENT '图片EXIF信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_hide` int DEFAULT '0' COMMENT '是否隐藏',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of images
-- ----------------------------
BEGIN;
INSERT INTO `images` (`id`, `url`, `exif`, `create_time`, `is_hide`) VALUES (1, 'https://gallerys-1305976148.cos.ap-guangzhou.myqcloud.com/moon/moonIMG_6918.JPG', NULL, '2023-08-30 09:38:29', 0);
INSERT INTO `images` (`id`, `url`, `exif`, `create_time`, `is_hide`) VALUES (2, 'https://gallerys-1305976148.cos.ap-guangzhou.myqcloud.com/moon/moonIMG_6918.JPG', '2', '2023-08-30 09:38:32', 0);
INSERT INTO `images` (`id`, `url`, `exif`, `create_time`, `is_hide`) VALUES (3, 'https://gallerys-1305976148.cos.ap-guangzhou.myqcloud.com/2023/8/30/67d620668a3246008a0340de92fd89d2.png', NULL, '2023-08-30 10:55:44', 0);
INSERT INTO `images` (`id`, `url`, `exif`, `create_time`, `is_hide`) VALUES (4, 'https://gallerys-1305976148.cos.ap-guangzhou.myqcloud.com/2023/8/30/27f361653f824e94b5ad5c0a10b8f40c.jpg', NULL, '2023-08-30 10:55:45', 0);
INSERT INTO `images` (`id`, `url`, `exif`, `create_time`, `is_hide`) VALUES (5, 'https://gallerys-1305976148.cos.ap-guangzhou.myqcloud.com/2023/8/30/a12e0d889b714256ac7dc3fab7b7fa7f.jpg', NULL, '2023-08-30 16:16:20', 0);
INSERT INTO `images` (`id`, `url`, `exif`, `create_time`, `is_hide`) VALUES (6, 'https://gallerys-1305976148.cos.ap-guangzhou.myqcloud.com/2023/8/30/20aa4d462da041e69546d56bdf197ba8.jpg', NULL, '2023-08-30 16:49:05', 0);
INSERT INTO `images` (`id`, `url`, `exif`, `create_time`, `is_hide`) VALUES (8, 'https://gallerys-1305976148.cos.ap-guangzhou.myqcloud.com/2023/8/30/57157827f38046e481022e1f307b844c.png', NULL, '2023-08-31 17:42:55', 0);
COMMIT;

-- ----------------------------
-- Table structure for moments
-- ----------------------------
DROP TABLE IF EXISTS `moments`;
CREATE TABLE `moments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题',
  `tags` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `content` text COLLATE utf8mb4_general_ci COMMENT '内容',
  `images` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片列表',
  `start` int DEFAULT '0' COMMENT '点赞量',
  `is_top` int DEFAULT '0' COMMENT '1:置顶 0:不置顶',
  `is_publish` int DEFAULT '1' COMMENT '1:发布 0:不发布',
  `is_delete` int DEFAULT '0' COMMENT '1:删除 0:不删除',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of moments
-- ----------------------------
BEGIN;
INSERT INTO `moments` (`id`, `title`, `tags`, `content`, `images`, `start`, `is_top`, `is_publish`, `is_delete`, `update_time`, `create_time`) VALUES (1, 'yue', '测试,12', '<p><a href=\"http://localhost:5173/\" target=\"\"><span style=\"color: rgb(212, 177, 6);\">#庆余年2#</span></a>什么时候可以看呢？😅asdasd11</p>', '1,2', 2, 1, 1, 0, '2023-08-28 17:02:58', '2023-08-24 14:59:23');
INSERT INTO `moments` (`id`, `title`, `tags`, `content`, `images`, `start`, `is_top`, `is_publish`, `is_delete`, `update_time`, `create_time`) VALUES (2, '3', NULL, '<p>撒打算大撒打算大撒打算大撒打算大撒打算打算的</p>', NULL, 0, 0, 1, 0, '2023-08-28 17:05:44', '2023-08-28 15:07:11');
INSERT INTO `moments` (`id`, `title`, `tags`, `content`, `images`, `start`, `is_top`, `is_publish`, `is_delete`, `update_time`, `create_time`) VALUES (3, '4', NULL, '<p>撒打算大撒打算大撒打算大撒打算大撒打算打算的</p>', NULL, 0, 0, 1, 0, '2023-08-28 17:06:42', '2023-08-28 15:07:11');
INSERT INTO `moments` (`id`, `title`, `tags`, `content`, `images`, `start`, `is_top`, `is_publish`, `is_delete`, `update_time`, `create_time`) VALUES (4, '5', NULL, '<p>撒打算大撒打算大撒打算大撒打算大撒打算打算的</p>', NULL, 0, 0, 1, 0, '2023-08-28 17:06:44', '2023-08-28 15:07:11');
INSERT INTO `moments` (`id`, `title`, `tags`, `content`, `images`, `start`, `is_top`, `is_publish`, `is_delete`, `update_time`, `create_time`) VALUES (48, '2', NULL, '<p>撒打算大撒打算大撒打算大撒打算大撒打算打算的</p>', NULL, 0, 0, 1, 0, '2023-08-28 17:06:45', '2023-08-28 15:07:11');
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
