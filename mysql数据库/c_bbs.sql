/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.6
 Source Server Type    : MySQL
 Source Server Version : 50620
 Source Host           : localhost:3306
 Source Schema         : c_bbs

 Target Server Type    : MySQL
 Target Server Version : 50620
 File Encoding         : 65001

 Date: 09/11/2022 00:39:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_member
-- ----------------------------
DROP TABLE IF EXISTS `base_member`;
CREATE TABLE `base_member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信openid',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录账号',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of base_member
-- ----------------------------
INSERT INTO `base_member` VALUES (67, NULL, '微服汇', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK3JVibuZg8wiaKG9ExyVJJT2R4s398eropw2qU7GhJEwgwNB8Y56GWh4dDHPSYTNcJXgmkvz4809SA/132', NULL, '李正乐', '13511112221', 'test', '123456', '2021-01-15 16:17:34');
INSERT INTO `base_member` VALUES (68, 'o1HEb0bbQgdd1aPNyr2ZXvutSU8U', '清风', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK3JVibuZg8wiaKG9ExyVJJT2R4s398eropw2qU7GhJEwgwNB8Y56GWh4dDHPSYTNcJXgmkvz4809SA/132', '1', '微服汇', '13511112223', NULL, NULL, '2021-03-09 19:48:51');
INSERT INTO `base_member` VALUES (69, NULL, '婷儿', 'http://localhost:10001/img/avatar.png', NULL, '李晓婷', '13511112222', 'user1', '123456', '2022-11-09 00:36:22');
INSERT INTO `base_member` VALUES (70, 'otdgdt5mf08a07Mj7xuqK2y0pkO0', '蜗牛爱逛街', 'https://thirdwx.qlogo.cn/mmopen/vi_32/icibq1lhOZL96BpmeebzvxbBANW3jar4rDrcxs93K3uE3ESANhU50s1FCiawFnkgdxZ2BmH0hFUmShAzdQXRicQnMg/132', '0', NULL, NULL, NULL, NULL, '2022-11-09 00:36:28');

-- ----------------------------
-- Table structure for bbs_category
-- ----------------------------
DROP TABLE IF EXISTS `bbs_category`;
CREATE TABLE `bbs_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `pic_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '分类' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bbs_category
-- ----------------------------
INSERT INTO `bbs_category` VALUES (1, '运动', '', 1, '2021-03-09 18:42:24');
INSERT INTO `bbs_category` VALUES (2, '时尚', '', 2, '2021-03-09 18:42:46');
INSERT INTO `bbs_category` VALUES (3, '搞笑', '', 3, '2021-03-10 18:19:19');

-- ----------------------------
-- Table structure for bbs_collect
-- ----------------------------
DROP TABLE IF EXISTS `bbs_collect`;
CREATE TABLE `bbs_collect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) NULL DEFAULT NULL COMMENT '会员id',
  `topic_id` int(11) NULL DEFAULT NULL COMMENT '话题id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '收藏' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bbs_collect
-- ----------------------------
INSERT INTO `bbs_collect` VALUES (6, 67, 40, '2021-07-27 00:58:03');
INSERT INTO `bbs_collect` VALUES (8, 67, 39, '2021-08-02 08:49:15');
INSERT INTO `bbs_collect` VALUES (9, 67, 37, '2021-08-02 08:49:26');
INSERT INTO `bbs_collect` VALUES (10, 68, 40, '2021-08-06 21:39:24');

-- ----------------------------
-- Table structure for bbs_follow
-- ----------------------------
DROP TABLE IF EXISTS `bbs_follow`;
CREATE TABLE `bbs_follow`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) NULL DEFAULT NULL COMMENT '用户',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '被关注者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '关注时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '关注' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bbs_follow
-- ----------------------------
INSERT INTO `bbs_follow` VALUES (1, 67, 67, '2021-03-31 19:00:41');
INSERT INTO `bbs_follow` VALUES (2, 68, 67, '2021-08-06 21:38:12');

-- ----------------------------
-- Table structure for bbs_like
-- ----------------------------
DROP TABLE IF EXISTS `bbs_like`;
CREATE TABLE `bbs_like`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '会员id',
  `topic_id` int(11) NULL DEFAULT NULL COMMENT '帖子id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '点赞' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bbs_like
-- ----------------------------
INSERT INTO `bbs_like` VALUES (14, 68, 33, '2021-03-10 21:00:47');
INSERT INTO `bbs_like` VALUES (16, 68, 35, '2021-04-08 12:16:45');
INSERT INTO `bbs_like` VALUES (17, 66, 35, '2021-05-07 08:25:05');
INSERT INTO `bbs_like` VALUES (18, 68, 40, '2021-08-06 21:43:33');
INSERT INTO `bbs_like` VALUES (19, 66, 40, '2022-01-13 20:27:43');
INSERT INTO `bbs_like` VALUES (20, 67, 40, '2022-01-13 22:34:45');
INSERT INTO `bbs_like` VALUES (21, 67, 39, '2022-01-13 22:35:29');

-- ----------------------------
-- Table structure for bbs_reply
-- ----------------------------
DROP TABLE IF EXISTS `bbs_reply`;
CREATE TABLE `bbs_reply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '内容',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '会员id',
  `topic_id` int(11) NULL DEFAULT NULL COMMENT '主贴id',
  `anonymous` tinyint(2) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '跟帖' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bbs_reply
-- ----------------------------
INSERT INTO `bbs_reply` VALUES (7, '你好', 67, 32, 1, '2021-04-10 07:43:40');
INSERT INTO `bbs_reply` VALUES (8, '你好', 67, 35, 1, '2021-05-07 04:13:39');
INSERT INTO `bbs_reply` VALUES (9, '讲的真好', 67, 35, 0, '2021-05-07 09:05:31');
INSERT INTO `bbs_reply` VALUES (10, '技术很到位', 67, 40, 1, '2021-05-26 01:23:08');
INSERT INTO `bbs_reply` VALUES (12, '小程序', 68, 40, 1, '2021-11-02 11:14:45');

-- ----------------------------
-- Table structure for bbs_topic
-- ----------------------------
DROP TABLE IF EXISTS `bbs_topic`;
CREATE TABLE `bbs_topic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '话题',
  `member_id` int(11) NULL DEFAULT NULL COMMENT '会员id',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '状态',
  `category_id` int(11) NULL DEFAULT NULL COMMENT '分类id',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '内容',
  `video_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '视频',
  `anonymous` tinyint(2) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '主贴' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bbs_topic
-- ----------------------------
INSERT INTO `bbs_topic` VALUES (32, '	spring微服务如何做到无损部署更新?', 68, NULL, 1, 'spring微服务如何做到无损部署更新?	spring微服务如何做到无损部署更新?', 'http://localhost:10001/img/video.mp4', 1, '2022-04-06 17:30:13');
INSERT INTO `bbs_topic` VALUES (35, 'springcloud框架讲解', 68, NULL, 1, 'springcloud 来了', NULL, 1, '2022-04-06 18:22:13');
INSERT INTO `bbs_topic` VALUES (36, 'springboot android框架讲解', 68, NULL, 1, 'springboot uinapp 来了', NULL, 0, '2022-05-06 18:22:13');
INSERT INTO `bbs_topic` VALUES (37, 'springboot 小程序框架讲解', 67, NULL, 1, 'springboot uinapp 来了', NULL, 0, '2022-05-06 18:22:13');
INSERT INTO `bbs_topic` VALUES (38, 'springboot vue框架讲解', 67, NULL, 1, 'springboot uinapp 来了', NULL, 0, '2022-11-06 18:22:13');
INSERT INTO `bbs_topic` VALUES (39, 'springboot html框架讲解', 67, NULL, 1, 'springboot uinapp 来了', NULL, 1, '2022-11-07 18:22:13');
INSERT INTO `bbs_topic` VALUES (40, 'springboot uinapp框架讲解', 67, NULL, 1, 'springboot uinapp 来了', NULL, 1, '2022-11-07 18:22:13');

-- ----------------------------
-- Table structure for bbs_topic_pic
-- ----------------------------
DROP TABLE IF EXISTS `bbs_topic_pic`;
CREATE TABLE `bbs_topic_pic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) NULL DEFAULT NULL,
  `pic_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '主贴图片' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bbs_topic_pic
-- ----------------------------
INSERT INTO `bbs_topic_pic` VALUES (45, 33, 'http://localhost:10001/img/goods-2.jpg');
INSERT INTO `bbs_topic_pic` VALUES (46, 34, 'http://localhost:10001/img/goods-1.jpg');
INSERT INTO `bbs_topic_pic` VALUES (47, 35, 'http://localhost:10001/img/goods-1.jpg');
INSERT INTO `bbs_topic_pic` VALUES (48, 35, 'http://localhost:10001/img/goods-2.jpg');
INSERT INTO `bbs_topic_pic` VALUES (49, 36, 'http://localhost:10001/img/goods-1.jpg');
INSERT INTO `bbs_topic_pic` VALUES (50, 37, 'http://localhost:10001/img/goods-1.jpg');
INSERT INTO `bbs_topic_pic` VALUES (51, 38, 'http://localhost:10001/img/goods-1.jpg');
INSERT INTO `bbs_topic_pic` VALUES (52, 39, 'http://localhost:10001/img/goods-1.jpg');
INSERT INTO `bbs_topic_pic` VALUES (53, 39, 'http://localhost:10001/img/goods-2.jpg');
INSERT INTO `bbs_topic_pic` VALUES (54, 40, 'http://localhost:10001/img/goods-1.jpg');
INSERT INTO `bbs_topic_pic` VALUES (55, 40, 'http://localhost:10001/img/goods-2.jpg');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'xxxxxx@qq.com', '13511223344', 1, '2021-08-02 11:11:11');

SET FOREIGN_KEY_CHECKS = 1;
