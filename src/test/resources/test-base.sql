/*
Navicat MySQL Data Transfer

Source Server         : crawl-mysql
Source Server Version : 50724
Source Host           : 192.168.99.100:3307
Source Database       : search_test

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-02-25 11:03:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auth_info
-- ----------------------------
DROP TABLE IF EXISTS `auth_info`;
CREATE TABLE `auth_info` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `credit_code` varchar(20) NOT NULL,
  `file_no` varchar(50) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `office` varchar(50) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for base_info
-- ----------------------------
DROP TABLE IF EXISTS `base_info`;
CREATE TABLE `base_info` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `credit_code` varchar(20) NOT NULL COMMENT '统一社会信用代码/注册号',
  `title` varchar(255) NOT NULL COMMENT '企业名称',
  `legal_rep` varchar(100) DEFAULT NULL COMMENT '法人代表',
  `type` varchar(255) DEFAULT NULL COMMENT '企业类型',
  `reg_cap` varchar(255) DEFAULT NULL COMMENT '注册资本',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `expt_label` varchar(255) DEFAULT NULL COMMENT '失信标签',
  `est_date` date DEFAULT NULL COMMENT '成立日期',
  `start_date` date DEFAULT NULL COMMENT '经营起始',
  `end_date` date DEFAULT NULL COMMENT '经营结束',
  `reg_auth` varchar(255) DEFAULT NULL COMMENT '登记机关',
  `pass_date` date DEFAULT NULL COMMENT '核准日期',
  `address` varchar(255) DEFAULT NULL COMMENT '住所',
  `biz_scope` text COMMENT '经营范围',
  `clear_leader` varchar(255) DEFAULT NULL COMMENT '清算负责人',
  `clear_memebers` varchar(255) DEFAULT NULL COMMENT '清算成员',
  PRIMARY KEY (`id`),
  UNIQUE KEY `credit_code` (`credit_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for black_list
-- ----------------------------
DROP TABLE IF EXISTS `black_list`;
CREATE TABLE `black_list` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `credit_code` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `cause_in` varchar(255) DEFAULT NULL,
  `date_in` date DEFAULT NULL,
  `office_in` varchar(255) DEFAULT NULL,
  `cause_out` varchar(255) DEFAULT NULL,
  `date_out` date DEFAULT NULL,
  `office_out` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for branch
-- ----------------------------
DROP TABLE IF EXISTS `branch`;
CREATE TABLE `branch` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `credit_code` varchar(20) NOT NULL,
  `branch_code` varchar(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `office` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for change_info
-- ----------------------------
DROP TABLE IF EXISTS `change_info`;
CREATE TABLE `change_info` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `credit_code` varchar(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `before_change` varchar(255) DEFAULT NULL,
  `after_change` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for error_log
-- ----------------------------
DROP TABLE IF EXISTS `error_log`;
CREATE TABLE `error_log` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `exception` varchar(255) DEFAULT NULL,
  `callback` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for exception
-- ----------------------------
DROP TABLE IF EXISTS `exception`;
CREATE TABLE `exception` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `credit_code` varchar(255) DEFAULT NULL,
  `cause_in` varchar(255) DEFAULT NULL,
  `date_in` date DEFAULT NULL,
  `office_in` varchar(255) DEFAULT NULL,
  `cause_out` varchar(255) DEFAULT NULL,
  `date_out` date DEFAULT NULL,
  `office_out` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for fire_info
-- ----------------------------
DROP TABLE IF EXISTS `fire_info`;
CREATE TABLE `fire_info` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `credit_code` varchar(20) DEFAULT NULL,
  `file_no` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `content` text,
  `office` varchar(50) DEFAULT NULL,
  `fire_date` date DEFAULT NULL,
  `show_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for investor
-- ----------------------------
DROP TABLE IF EXISTS `investor`;
CREATE TABLE `investor` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `credit_code` varchar(20) NOT NULL,
  `exp_date` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `id_type` varchar(255) DEFAULT NULL,
  `id_num` varchar(20) DEFAULT NULL,
  `sub_all` float(255,4) DEFAULT NULL,
  `act_all` float(255,4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for investor_detail
-- ----------------------------
DROP TABLE IF EXISTS `investor_detail`;
CREATE TABLE `investor_detail` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `investor_id` int(255) NOT NULL,
  `method` varchar(255) DEFAULT NULL,
  `amount` float(255,4) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for main_staff
-- ----------------------------
DROP TABLE IF EXISTS `main_staff`;
CREATE TABLE `main_staff` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `credit_code` varchar(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `position` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mortgage
-- ----------------------------
DROP TABLE IF EXISTS `mortgage`;
CREATE TABLE `mortgage` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `credit_code` varchar(20) NOT NULL,
  `reg_code` varchar(50) DEFAULT NULL,
  `reg_date` date DEFAULT NULL,
  `reg_office` varchar(255) DEFAULT NULL,
  `reg_status` varchar(50) DEFAULT NULL,
  `show_date` date DEFAULT NULL,
  `amount` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `due_start_date` date DEFAULT NULL,
  `due_end_date` date DEFAULT NULL,
  `cancel_date` date DEFAULT NULL,
  `cancel_reason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mortgage_item
-- ----------------------------
DROP TABLE IF EXISTS `mortgage_item`;
CREATE TABLE `mortgage_item` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `mortgage_id` int(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `owner` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for mortgagee
-- ----------------------------
DROP TABLE IF EXISTS `mortgagee`;
CREATE TABLE `mortgagee` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `mortgage_id` int(255) NOT NULL,
  `id_num` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `id_type` varchar(100) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for report_invest
-- ----------------------------
DROP TABLE IF EXISTS `report_invest`;
CREATE TABLE `report_invest` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `report_id` int(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for share_pledge
-- ----------------------------
DROP TABLE IF EXISTS `share_pledge`;
CREATE TABLE `share_pledge` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `credit_code` varchar(20) NOT NULL,
  `reg_code` varchar(50) DEFAULT NULL,
  `out_name` varchar(100) DEFAULT NULL,
  `out_id` varchar(50) DEFAULT NULL,
  `amount` varchar(255) DEFAULT NULL,
  `in_name` varchar(100) DEFAULT NULL,
  `in_id` varchar(50) DEFAULT NULL,
  `reg_date` date DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `show_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for website
-- ----------------------------
DROP TABLE IF EXISTS `website`;
CREATE TABLE `website` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `report_id` int(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for year_report
-- ----------------------------
DROP TABLE IF EXISTS `year_report`;
CREATE TABLE `year_report` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `credit_code` varchar(255) NOT NULL,
  `send_year` varchar(255) DEFAULT NULL,
  `show_date` date DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `zip_code` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `staff_num` varchar(100) DEFAULT NULL,
  `female_num` varchar(100) DEFAULT NULL,
  `holding_status` varchar(100) DEFAULT NULL,
  `if_invest` varchar(20) DEFAULT NULL,
  `if_guarantee` varchar(20) DEFAULT NULL,
  `if_web` varchar(20) DEFAULT NULL,
  `if_share_trans` varchar(20) DEFAULT NULL,
  `com_insure_num` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
