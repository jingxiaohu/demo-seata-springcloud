/*
Navicat MySQL Data Transfer

Source Server         : 我的本地连接
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : fescardubbo1

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2020-10-20 17:26:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for business_order
-- ----------------------------
DROP TABLE IF EXISTS `business_order`;
CREATE TABLE `business_order` (
  `orderId` varchar(64) NOT NULL COMMENT '主键uuid',
  `orderNo` varchar(32) DEFAULT NULL COMMENT '订单号',
  `orderDetail` varchar(240) DEFAULT NULL COMMENT '订单详情',
  `createTime` varchar(24) DEFAULT NULL COMMENT '创建时间',
  `logicDel` char(1) DEFAULT NULL COMMENT '逻辑删除 Y:删除 N:未删除',
  `remark` varchar(240) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`orderId`),
  UNIQUE KEY `orderNo` (`orderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2194 DEFAULT CHARSET=utf8;
