/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : burst-text

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-08-25 17:52:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tab_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `tab_admin_user`;
CREATE TABLE `tab_admin_user` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `user_name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名(后台管理系统用户名)',
  `pass_word` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码(后台管理系统密码)',
  `user_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户ID(和tab_user_info关联)',
  `is_enable` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '1' COMMENT '是否有效(0-无 1-有)',
  `created_date` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='后台管理系统用户名';

-- ----------------------------
-- Table structure for tab_burst_card
-- ----------------------------
DROP TABLE IF EXISTS `tab_burst_card`;
CREATE TABLE `tab_burst_card` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `burst_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '爆文ID',
  `card_up_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '爆文顶部的名片',
  `card_foot_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '爆文底部名片ID',
  `created_date` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='爆文名片关联表';

-- ----------------------------
-- Table structure for tab_burst_text
-- ----------------------------
DROP TABLE IF EXISTS `tab_burst_text`;
CREATE TABLE `tab_burst_text` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `title` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题',
  `user_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '所属用户',
  `short_title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '短标题(用户列表显示)',
  `title_img` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标题图片(用于列表显示的图片,可以多张)',
  `content` varchar(4096) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '内容(html片段)',
  `burst_source` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '爆文来源(来源连接)',
  `burst_type` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '爆文类型(和字典表关联)',
  `burst_ascripte` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '爆文归属(平台\\个人,平台的直接可以显示出来,个人的只有他本人可以看到,但是可以分享)',
  `browse_num` int(11) DEFAULT '0' COMMENT '浏览次数',
  `share_num` int(11) DEFAULT '0' COMMENT '分享次数',
  `is_top` int(1) DEFAULT '0' COMMENT '是否置顶(0-不置顶  1-置顶)',
  `is_enable` int(1) DEFAULT '0' COMMENT '是否可用(0-不可  1-可) 不可用表示不发布  可用表示发布',
  `created_date` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='爆文表(核心表)';

-- ----------------------------
-- Table structure for tab_burst_text_browse_record
-- ----------------------------
DROP TABLE IF EXISTS `tab_burst_text_browse_record`;
CREATE TABLE `tab_burst_text_browse_record` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `burst_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '爆文ID',
  `user_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户ID',
  `is_enable` int(1) DEFAULT '1' COMMENT '是否可用(0-不可  1-可用)',
  `created_date` datetime DEFAULT NULL COMMENT '创建时间(浏览时间)',
  `updated_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='爆文浏览日志';

-- ----------------------------
-- Table structure for tab_burst_text_share_record
-- ----------------------------
DROP TABLE IF EXISTS `tab_burst_text_share_record`;
CREATE TABLE `tab_burst_text_share_record` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `burst_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '爆文ID',
  `user_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分享用户ID',
  `share_img` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分享图片',
  `share_title` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分享标题',
  `share_subtitle` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分享副标题',
  `created_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='爆文分享记录表';

-- ----------------------------
-- Table structure for tab_bus_card_style
-- ----------------------------
DROP TABLE IF EXISTS `tab_bus_card_style`;
CREATE TABLE `tab_bus_card_style` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `style_position` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名片位置(顶部，底部)',
  `card_url` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名片图片链接',
  `is_default` int(1) DEFAULT '0' COMMENT '是否为默认名片(0-非  1-是)',
  `is_enable` int(1) DEFAULT '1' COMMENT '是否有效(0-无 1-有)',
  `created_date` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='名片样式';

-- ----------------------------
-- Table structure for tab_sys_data_type
-- ----------------------------
DROP TABLE IF EXISTS `tab_sys_data_type`;
CREATE TABLE `tab_sys_data_type` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `data_type` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '字典数据类型',
  `describe` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '描述',
  `is_enable` int(1) DEFAULT '1' COMMENT '是否有效(0-无 1-有)',
  `created_date` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='字典类型表';

-- ----------------------------
-- Table structure for tab_sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `tab_sys_dictionary`;
CREATE TABLE `tab_sys_dictionary` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `code` varchar(8) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '编码',
  `name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '名称',
  `seq` int(11) DEFAULT NULL COMMENT '排序',
  `img` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片',
  `data_type` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '数据类型',
  `is_enable` int(1) DEFAULT '1' COMMENT '是否有效(0-无 1-有)',
  `created_date` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='字典表';

-- ----------------------------
-- Table structure for tab_sys_log
-- ----------------------------
DROP TABLE IF EXISTS `tab_sys_log`;
CREATE TABLE `tab_sys_log` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `user_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
  `node` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '客户端操作IP',
  `operate` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '操作(执行的操作)',
  `log_content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '日志内容',
  `method` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '调用的方法(类全限定名+方法名)',
  `log_level` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '日志级别',
  `param` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参数',
  `log_source` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '日志来源(后台管理系统,还是前端)',
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统日志表';

-- ----------------------------
-- Table structure for tab_user_info
-- ----------------------------
DROP TABLE IF EXISTS `tab_user_info`;
CREATE TABLE `tab_user_info` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `user_name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `head_icon` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `bus_code` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '公司编码',
  `position` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '职位',
  `mobile` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `nick_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '来源于微信的昵称',
  `wxqr_code` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信二维码',
  `openid` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信平台用户的openid(可以用于获取用户的基本信息)',
  `unionid` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT 'unionid来区分用户的唯一性(同一个微信开放平台下的不同应用，unionid是相同的)',
  `created_date` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户表';

-- ----------------------------
-- Table structure for tab_user_login_record
-- ----------------------------
DROP TABLE IF EXISTS `tab_user_login_record`;
CREATE TABLE `tab_user_login_record` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `user_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
  `login_date` datetime DEFAULT NULL COMMENT '登录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户登录记录表';

-- ----------------------------
-- Table structure for tab_user_token
-- ----------------------------
DROP TABLE IF EXISTS `tab_user_token`;
CREATE TABLE `tab_user_token` (
  `id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',
  `user_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
  `user_token` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `start_date` datetime DEFAULT NULL COMMENT '生效时间',
  `expired_date` datetime DEFAULT NULL COMMENT '失效时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户登录token时效表';
