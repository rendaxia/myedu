/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost
 Source Database       : education

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : utf-8

 Date: 07/17/2018 17:34:40 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qid` int(11) DEFAULT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `address`
-- ----------------------------
BEGIN;
INSERT INTO `address` VALUES ('1', '1', '实训中心', '东软实训中心', '15940471397', '123.43949', '41.70588'), ('2', '1', '艺术中心', '多才艺术中心', '15940471393', '123.40297', '41.73612'), ('3', '1', '恒大名都', '恒大名都', '15940471397', '123.39534', '41.6866');
COMMIT;

-- ----------------------------
--  Table structure for `coupon`
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `qid` int(11) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `get` int(11) DEFAULT NULL,
  `deadline` date DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `coupon`
-- ----------------------------
BEGIN;
INSERT INTO `coupon` VALUES ('2', '1', 'Python', '888', '200', '60', '2018-07-31'), ('3', '1', 'C/C++', '111111', '390', '160', '2018-06-29');
COMMIT;

-- ----------------------------
--  Table structure for `couponrecord`
-- ----------------------------
DROP TABLE IF EXISTS `couponrecord`;
CREATE TABLE `couponrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `gettime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `enterprise`
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
  `qid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `videopath` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `jczs` text,
  PRIMARY KEY (`qid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `enterprise`
-- ----------------------------
BEGIN;
INSERT INTO `enterprise` VALUES ('1', '东软睿道', 'video/intro.mp4', '沈阳东软睿道教育服务有限公司（简称东软睿道）由东软创办，基于东软的产业发展与人才培养实践，提供更加符合IT行业发展需求的人才培养体系和方法学，精准提升大学生和大学后的就业、创业技能，为新经济时代的转型发展提供高质量规模化的人才供给。东软睿道倡导“产业融入教育”的经营理念，将科学的学习方法与先进的信息技术相结合，打造产学研融合式人才培养模式，创新引领工程教育模式，推动中国经济转型发展。', '<p><img src=\"img/enterprise01.jpg\">\r\n<img src=\"img/enterprise02.jpg\">\r\n<img src=\"img/enterprise03.jpg\">\r\n<img src=\"img/enterprise04.jpg\">\n<img src=\"img/enterprise05.jpg\">\n<img src=\"img/enterprise06.jpg\"></p>');
COMMIT;

-- ----------------------------
--  Table structure for `freelisten`
-- ----------------------------
DROP TABLE IF EXISTS `freelisten`;
CREATE TABLE `freelisten` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `fdesc` text,
  `status` varchar(255) DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  `branchid` int(11) DEFAULT NULL,
  `pubtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `freelisten`
-- ----------------------------
BEGIN;
INSERT INTO `freelisten` VALUES ('1', 'java实训课01', '6.jpg', '<p>java实训课01</p>\n			<p>¥0.00</p>\n			<p>简介:java实训课基础班</p>\n			<p><img src=\"img/6.jpg\" style=\"max-width:100%;\"><br></p>\n			<p>体验课id:1</p>\n			<p>分部id:1</p>\n			<p>企业id:1</p>\n			<p>发布时间:2018年7月6日 11:17:58</p>', null, '1', '1', '2018-07-06 11:17:58'), ('2', 'java实训课02', '7.jpg', '<p>java实训课02</p>\n			<p>¥0.00</p>\n			<p>简介:java实训课基础班02</p>\n			<p><img src=\"img/7.jpg\" style=\"max-width:100%;\"><br></p>\n			<p>体验课id:2</p>\n			<p>分部id:2</p>\n			<p>企业id:1</p>\n			<p>发布时间:2018年7月6日 14:55:28</p>', null, '1', '2', '2018-07-06 14:55:28'), ('3', 'java实训课03', '8.jpg', '<p>java实训课03</p>\n			<p>¥0.00</p>\n			<p>简介:java实训课基础班03</p>\n			<p><img src=\"img/8.jpg\" style=\"max-width:100%;\"><br></p>\n			<p>体验课id:3</p>\n			<p>分部id:3</p>\n			<p>企业id:1</p>\n			<p>发布时间:2018年7月5日 15:55:56</p>', null, '1', '3', '2018-07-05 15:55:56');
COMMIT;

-- ----------------------------
--  Table structure for `freelistenbook`
-- ----------------------------
DROP TABLE IF EXISTS `freelistenbook`;
CREATE TABLE `freelistenbook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fid` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `booktime` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `comment` varchar(3000) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `freelistenbook`
-- ----------------------------
BEGIN;
INSERT INTO `freelistenbook` VALUES ('7', '2', '费园园', '15940471397', '2018-05-26 17:54:50', '待处理', '嘻嘻嘻', null), ('8', '1', '哈哈', '123456789', '2018-05-26 17:55:33', '待处理', '弟弟', null), ('9', '1', '哈哈', '123456789', '2018-05-26 17:55:35', '待处理', '弟弟', null), ('10', '1', '信息', '111', '2018-05-26 17:58:17', '待处理', '玩儿玩儿', null), ('11', '3', '', '', '2018-06-15 09:53:39', '待处理', '', 'null'), ('12', '3', '费园园', '15940471397', '2018-06-15 11:39:18', '待处理', '上午课', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk'), ('13', '3', '谢谢', '123', '2018-06-15 12:00:02', '待处理', '谁是', 'null'), ('14', '3', '谢谢', '123', '2018-06-15 12:00:28', '待处理', '谁是', 'null'), ('15', '3', '谢谢', '123', '2018-06-15 12:00:30', '待处理', '谁是', 'null'), ('20', '1', '', '', '2018-06-15 15:14:09', '已处理', '', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk'), ('21', '3', 'xx', '123', '2018-06-19 12:59:15', '已处理', 'xx', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk'), ('22', '2', '费园园', '15940471397', '2018-06-21 18:54:26', '已处理', '明天上午', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk'), ('23', '3', '', '', '2018-06-22 13:29:45', '待处理', '', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk'), ('31', '3', '费园园', '15804049843', '2018-07-01 20:16:27', '待处理', '', 'oC9yV5IbgeaLrGfM8tSLSO8Jmj0c'), ('32', '3', '费园园', '15804049843', '2018-07-01 20:17:25', '待处理', '', 'oC9yV5IbgeaLrGfM8tSLSO8Jmj0c'), ('33', '3', '费园园', '15804049843', '2018-07-01 20:17:41', '待处理', '', 'oC9yV5IbgeaLrGfM8tSLSO8Jmj0c'), ('34', '3', '费园园', '15804049843', '2018-07-05 17:36:28', '待处理', '我爱你', 'oC9yV5IbgeaLrGfM8tSLSO8Jmj0c'), ('35', '3', '费园园', '15804049843', '2018-07-05 17:37:19', '待处理', '我爱你', 'oC9yV5IbgeaLrGfM8tSLSO8Jmj0c'), ('36', '3', '费园园', '15804049843', '2018-07-05 17:37:20', '待处理', '我爱你', 'oC9yV5IbgeaLrGfM8tSLSO8Jmj0c'), ('37', '3', '费园园', '15804049843', '2018-07-05 17:37:21', '待处理', '我爱你', 'oC9yV5IbgeaLrGfM8tSLSO8Jmj0c'), ('42', '3', 'user15804049843', '15804049843', '2018-07-06 11:29:29', '待处理', '爱国', 'user15804049843');
COMMIT;

-- ----------------------------
--  Table structure for `lesson`
-- ----------------------------
DROP TABLE IF EXISTS `lesson`;
CREATE TABLE `lesson` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `lname` varchar(255) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `lprice` double DEFAULT NULL,
  `ldesc` text,
  `category` varchar(255) DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  `pubtime` datetime DEFAULT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `lesson`
-- ----------------------------
BEGIN;
INSERT INTO `lesson` VALUES ('1', '体验课:万圣节抽符', '1.jpg', '299', '<p>万圣节抽符</p>\n	<p>¥299</p>\n	<p>简介:万圣节抽符</p>\n	<p><img src=\"img/1.jpg\" style=\"max-width:100%;\"><br></p>\n	<p>实体课id:1</p>\n	<p>企业id:1</p>\n	<p>发布时间:2018-06-05 10:39:24</p>', 'HTML5', '1', '2018-06-05 10:39:24'), ('2', '体验课:手机天气通', '2.jpg', '199', '<p>手机天气通</p>\n	<p>¥199</p>\n	<p>简介:手机天气通</p>\n	<p><img src=\"img/2.jpg\" style=\"max-width:100%;\"><br></p>\n	<p>实体课id:2</p>\n	<p>企业id:1</p>\n	<p>发布时间:2018-06-04 10:39:29</p>', 'HTML5', '1', '2018-06-04 10:39:29'), ('3', '体验课:微信摇一摇', '3.jpg', '129', '<p>微信摇一摇</p>\n			<p>¥129</p>\n			<p>简介:微信摇一摇</p>\n			<p><img src=\"img/3.jpg\" style=\"max-width:100%;\"><br></p>\n			<p>体验课id:3</p>\n			<p>企业id:1</p>\n			<p>发布时间:2018年6月11日 10:39:33</p>', 'JAVA', '1', '2018-06-11 10:39:33'), ('4', '体验课:音乐盒子', '4.jpg', '100', '<p>音乐盒子</p>\n			<p>¥100</p>\n			<p>简介:音乐盒子</p>\n			<p><img src=\"img/4.jpg\" style=\"max-width:100%;\"><br></p>\n			<p>体验课id:4</p>\n			<p>企业id:1</p>\n			<p>发布时间:2018年6月7日 10:39:37</p>', 'HTML5', '1', '2018-06-07 10:39:37'), ('5', '大数据课程', '5.jpg', '99', '<p>大数据课程</p>\n			<p>¥99</p>\n			<p>简介:大数据课程</p>\n			<p><img src=\"img/5.jpg\" style=\"max-width:100%;\"><br></p>\n			<p>体验课id:5</p>\n			<p>企业id:1</p>\n			<p>发布时间:2018年6月8日 10:39:40</p>', 'C++', '1', '2018-06-08 10:39:40');
COMMIT;

-- ----------------------------
--  Table structure for `lessonbranch`
-- ----------------------------
DROP TABLE IF EXISTS `lessonbranch`;
CREATE TABLE `lessonbranch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lid` int(11) DEFAULT NULL,
  `branchid` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `lessonbranch`
-- ----------------------------
BEGIN;
INSERT INTO `lessonbranch` VALUES ('1', '1', '1'), ('2', '2', '1'), ('4', '4', '2'), ('5', '5', '2'), ('6', '6', '2'), ('7', '7', '3'), ('8', '8', '3'), ('9', '9', '3'), ('10', '10', '3'), ('11', '3', '1');
COMMIT;

-- ----------------------------
--  Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mtitle` varchar(255) DEFAULT NULL,
  `mtime` datetime DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `message`
-- ----------------------------
BEGIN;
INSERT INTO `message` VALUES ('1', '我爱读书', '2018-07-01 13:42:14', '1'), ('2', '无阅读不生活', '2018-06-19 15:49:56', '1');
COMMIT;

-- ----------------------------
--  Table structure for `messageimg`
-- ----------------------------
DROP TABLE IF EXISTS `messageimg`;
CREATE TABLE `messageimg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `messageimg`
-- ----------------------------
BEGIN;
INSERT INTO `messageimg` VALUES ('5', '2', 'sample5.jpg'), ('6', '2', 'sample6.jpg');
COMMIT;

-- ----------------------------
--  Table structure for `messagelike`
-- ----------------------------
DROP TABLE IF EXISTS `messagelike`;
CREATE TABLE `messagelike` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `stime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `messagelike`
-- ----------------------------
BEGIN;
INSERT INTO `messagelike` VALUES ('1', '2', '费园园', '2019-06-21 19:00:12'), ('2', '1', '任庭玉', '2018-07-01 16:02:01'), ('68', '2', 'rty', '2018-07-04 10:19:30'), ('70', '1', 'rty', '2018-07-04 11:50:46'), ('72', '2', 'user15804049843', '2018-07-06 11:47:52'), ('73', '1', 'user15804034590', '2018-07-13 09:23:29'), ('74', '2', 'user15804034590', '2018-07-13 09:23:31'), ('76', '1', 'user15804049843', '2018-07-15 11:26:30');
COMMIT;

-- ----------------------------
--  Table structure for `messagereply`
-- ----------------------------
DROP TABLE IF EXISTS `messagereply`;
CREATE TABLE `messagereply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `stime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `messagereply`
-- ----------------------------
BEGIN;
INSERT INTO `messagereply` VALUES ('64', '2', '我爱你啊', 'user15804049843', '2018-07-06 12:36:00'), ('65', '2', '666', 'user15804049843', '2018-07-06 12:36:08'), ('70', '1', 'Love you', 'user15804034590', '2018-07-13 09:23:59'), ('71', '2', 'Haha', 'user15804034590', '2018-07-13 09:24:20'), ('72', '1', '厉害呀', 'user15804049843', '2018-07-13 10:16:58'), ('73', '2', 'hbbfg', 'user15804034590', '2018-07-13 15:12:59'), ('75', '1', '444', 'user15804049843', '2018-07-15 11:15:21'), ('76', '1', 'efbgbfd', 'user15804049843', '2018-07-15 11:26:33');
COMMIT;

-- ----------------------------
--  Table structure for `refund`
-- ----------------------------
DROP TABLE IF EXISTS `refund`;
CREATE TABLE `refund` (
  `oid` int(11) NOT NULL,
  `refundreason` varchar(3000) DEFAULT NULL,
  `refundtime` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `refund`
-- ----------------------------
BEGIN;
INSERT INTO `refund` VALUES ('43', '', '2018-05-26 12:28:10', null), ('44', '', '2018-05-26 12:29:26', null), ('45', '', '2018-05-26 12:32:20', null), ('46', '做', '2018-05-26 12:40:15', null), ('50', '111', '2018-05-26 14:22:38', '待处理'), ('54', '', '2018-05-26 14:21:51', '待处理'), ('55', '', '2018-05-26 14:20:43', '待处理'), ('63', '', '2018-06-15 11:33:18', '待处理'), ('69', '', '2018-06-19 14:38:27', '待处理'), ('70', '', '2018-06-19 14:37:24', '已处理'), ('71', '', '2018-06-19 16:53:55', '已处理'), ('72', '', '2018-06-21 18:56:55', '已处理');
COMMIT;

-- ----------------------------
--  Table structure for `sorder`
-- ----------------------------
DROP TABLE IF EXISTS `sorder`;
CREATE TABLE `sorder` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `lid` int(11) DEFAULT NULL,
  `openid` varchar(1000) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `cid` varchar(11) DEFAULT NULL,
  `actual` double DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  `transactionid` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `sorder`
-- ----------------------------
BEGIN;
INSERT INTO `sorder` VALUES ('43', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '5', null, '5', '已退款', '2018-05-26 12:27:24', '1', '4200000116201805263247934519', null, null), ('44', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '5', null, '5', '已退款', '2018-05-26 12:27:43', '1', '4200000110201805261060715976', null, null), ('45', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '5', null, '5', '已退款', '2018-05-26 12:31:02', '1', '4200000130201805260683103431', null, null), ('46', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '5', null, '5', '已退款', '2018-05-26 12:39:42', '1', '4200000109201805266997780435', null, null), ('47', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '9', null, '0.11', '待付款', '2018-05-26 13:57:41', '1', null, null, null), ('48', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '2', null, '0.01', '待付款', '2018-05-26 14:03:30', '1', null, null, null), ('49', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '1', null, '0.01', '已付款', '2018-05-26 14:04:54', '1', '4200000110201805264729572488', null, null), ('50', '2', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '2', null, '0.02', '退款中', '2018-05-26 14:05:22', '1', '4200000130201805266329195070', null, null), ('51', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '1', null, '0.43', '待付款', '2018-05-26 14:10:43', '1', null, null, null), ('52', '2', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '2', null, '0.02', '待付款', '2018-05-26 14:10:50', '1', null, null, null), ('53', '4', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '3', null, '0.03', '待付款', '2018-05-26 14:11:35', '1', null, null, null), ('54', '2', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '2', null, '0.02', '退款中', '2018-05-26 14:19:35', '1', '4200000110201805263169394125', null, null), ('55', '4', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '3', null, '0.03', '退款中', '2018-05-26 14:20:15', '1', '4200000138201805262717162733', null, null), ('56', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '1', null, '0.01', '已付款', '2018-06-07 16:46:55', '1', '4200000124201806070328955434', '费园园', '15940471397'), ('57', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '2', null, '0.02', '已付款', '2018-06-07 17:36:42', '1', '4200000126201806078388299831', '哈哈', '123'), ('58', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '100', null, '100.01', '待付款', '2018-06-07 18:38:05', '1', null, '', ''), ('59', '2', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '10', null, '0.02', '待付款', '2018-06-07 18:39:49', '1', null, '', ''), ('63', '1', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk', '1', null, '0.01', '已付款', '2018-06-15 11:31:05', '1', '4200000117201806150052450136', '费园园', '15940471397'), ('64', '1', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk', '1', null, '0.01', '已付款', '2018-06-15 11:31:18', '1', '4200000137201806155057560390', '费园园', ''), ('65', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '10', null, '0.01', '待付款', '2018-06-15 14:03:47', '1', null, '', ''), ('66', '1', 'oC9yV5HNntbgqDyPEg2J0YSY8dC8', '99', null, '99.98', '待付款', '2018-06-15 14:51:50', '1', null, '', ''), ('67', '1', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk', '99', null, '0.01', '已付款', '2018-06-19 13:02:37', '1', null, 'aa', '123'), ('68', '1', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk', '1', null, '0.01', '已付款', '2018-06-19 13:03:49', '1', null, 'www', '123'), ('69', '10', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk', '1', null, '0.01', '退款中', '2018-06-19 14:27:56', '1', '4200000112201806197932997460', '费元', ''), ('70', '6', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk', '1', null, '0.01', '已退款', '2018-06-19 14:36:52', '1', '4200000136201806193206770784', '给', ''), ('71', '6', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk', '1', null, '0.01', '已退款', '2018-06-19 16:53:29', '1', '4200000118201806199959334942', '费园', ''), ('72', '10', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk', '1', null, '0.01', '已退款', '2018-06-21 18:55:55', '1', '4200000133201806213004102392', '费园园', ''), ('73', '10', 'oC9yV5KjYiv_zu6qJ0pm_WlN4LEk', '100', null, '0.01', '待付款', '2018-06-22 09:10:34', '1', null, '费园园', '15940471397'), ('75', '2', '124', '0', '0', '0', '???', '2018-06-25 22:17:17', '1', '0', 'rty', '15804049843'), ('76', '2', '124', '0', '0', '0', '???', '2018-06-25 22:18:15', '1', '0', 'rty', '15804049843'), ('77', '2', '124', '0', '0', '0', '???', '2018-06-26 09:30:27', '1', '0', 'rty', '15804049843'), ('81', '2', '124', '0', '0', '0', '???', '2018-06-26 10:12:26', '1', '0', 'rty', '15804049843'), ('82', '100', '100', '100', '0', '0', '已付款', '2018-06-26 10:14:42', '1', '0', 'rty', '15804049843'), ('83', '2', '124', '0', '0', '0', '???', '2018-06-26 10:16:58', '1', '0', 'rty', '15804049843'), ('87', '2', '124', '0', '0', '0', '???', '2018-06-27 14:57:02', '1', '0', 'rty', '15804049843'), ('88', '2', '124', '0', '0', '0', '???', '2018-06-27 15:01:26', '1', '0', 'rty', '15804049843'), ('89', '1', '1', '1', '0', '0', '已付款', '2018-06-27 15:11:11', '1', '0', '1', '111'), ('90', '1', '1', '1', '0', '0', '已付款', '2018-06-27 15:11:37', '1', '0', '1', '111'), ('91', '2', '124', '0', '0', '0', '???', '2018-06-27 15:11:59', '1', '0', 'rty', '15804049843'), ('92', '2', '124', '0', '0', '0', '???', '2018-06-27 15:13:10', '1', '0', 'rty', '15804049843'), ('93', '2', '124', '0', '0', '0', '???', '2018-06-27 15:14:11', '1', '0', 'rty', '15804049843'), ('94', '2', '124', '0', '0', '0', '???', '2018-06-27 15:20:25', '1', '0', 'rty', '15804049843'), ('95', '2', '124', '0', '0', '0', '???', '2018-06-27 15:30:17', '1', '0', 'rty', '15804049843'), ('96', '2', '124', '0', '0', '0', '???', '2018-06-27 15:34:21', '1', '0', 'rty', '15804049843'), ('97', '2', '124', '0', '0', '0', '???', '2018-06-27 15:35:31', '1', '0', 'rty', '15804049843'), ('98', '2', '124', '0', '0', '0', '???', '2018-06-27 15:36:20', '1', '0', 'rty', '15804049843'), ('99', '2', '124', '0', '0', '0', '???', '2018-06-27 15:39:03', '1', '0', 'rty', '15804049843'), ('100', '2', '124', '0', '0', '0', '???', '2018-06-27 15:49:02', '1', '0', 'rty', '15804049843'), ('101', '2', '124', '0', '0', '0', '已付款', '2018-06-27 16:35:28', '1', '0', 'rty', '15804049843'), ('102', '2', '124', '0', '0', '0', '已付款', '2018-06-27 16:53:32', '1', '0', 'rty', '15804049843'), ('104', '3', 'user15804049843', '50', '0', '0', '退款中', '2018-07-05 21:08:00', '1', '0', 'user15804049843', '15804049843'), ('105', '3', 'user15804049843', '50', '0', '0', '退款中', '2018-07-05 21:11:39', '1', '0', 'user15804049843', '15804049843'), ('106', '3', 'user15804049843', '50', '0', '0', '退款中', '2018-07-06 11:18:20', '1', '0', 'user15804049843', '15804049843'), ('107', '3', 'user15804049843', '50', '0', '0', '退款中', '2018-07-06 14:57:50', '1', '0', 'user15804049843', '15804049843'), ('108', '3', 'user15804049843', '50', '0', '0', '退款中', '2018-07-06 15:14:49', '1', '0', 'user15804049843', '15804049843'), ('109', '3', 'user15804049843', '50', '0', '0', '退款中', '2018-07-06 15:14:53', '1', '0', 'user15804049843', '15804049843'), ('110', '3', 'user15804049843', '50', '0', '0', '退款中', '2018-07-06 15:14:57', '1', '0', 'user15804049843', '15804049843'), ('111', '3', 'user15804049843', '50', '0', '0', '退款中', '2018-07-06 15:17:18', '1', '0', 'user15804049843', '15804049843'), ('112', '3', 'user15804049843', '50', '0', '0', '已付款', '2018-07-06 15:17:21', '1', '0', 'user15804049843', '15804049843'), ('113', '2', 'user15804034590', '50', '0', '0', '退款中', '2018-07-13 09:20:46', '1', '0', 'user15804034590', '15804034590'), ('114', '2', 'user15804034590', '50', '0', '0', '已付款', '2018-07-13 09:20:53', '1', '0', 'user15804034590', '15804034590'), ('115', '2', 'user15804049843', '50', '0', '0', '已付款', '2018-07-13 10:17:40', '1', '0', 'user15804049843', '15804049843'), ('117', '2', 'user15804049843', '50', '0', '0', '已付款', '2018-07-13 11:36:56', '1', '0', 'user15804049843', '15804049843'), ('118', '2', 'user15804049843', '50', '0', '0', '已付款', '2018-07-13 11:36:57', '1', '0', 'user15804049843', '15804049843'), ('120', '2', 'user15804034590', '50', '0', '0', '退款中', '2018-07-13 12:59:59', '1', '0', 'user15804034590', '15804034590'), ('121', '2', 'user15804034590', '50', '0', '0', '已付款', '2018-07-13 13:00:01', '1', '0', 'user15804034590', '15804034590'), ('122', '2', 'user15804034590', '50', '0', '0', '已付款', '2018-07-13 13:00:03', '1', '0', 'user15804034590', '15804034590'), ('123', '2', 'user15804034590', '50', '0', '0', '已付款', '2018-07-13 13:58:48', '1', '0', 'user15804034590', '15804034590'), ('124', '2', 'user15804034590', '50', '0', '0', '已付款', '2018-07-13 13:58:49', '1', '0', 'user15804034590', '15804034590'), ('125', '2', 'user15804034590', '50', '0', '0', '已付款', '2018-07-13 13:58:49', '1', '0', 'user15804034590', '15804034590'), ('126', '1', 'user15804034590', '50', '0', '0', '已付款', '2018-07-13 14:58:07', '1', '0', 'user15804034590', '15804034590'), ('127', '1', 'user15804049843', '50', '0', '0', '已付款', '2018-07-13 15:21:07', '1', '0', 'user15804049843', '15804049843'), ('128', '2', 'user15804049843', '50', '0', '0', '已付款', '2018-07-13 15:48:17', '1', '0', 'user15804049843', '15804049843'), ('129', '2', 'user15804049843', '50', '0', '0', '已付款', '2018-07-13 15:48:18', '1', '0', 'user15804049843', '15804049843'), ('130', '1', 'user15804049843', '50', '0', '0', '已付款', '2018-07-15 09:52:27', '1', '0', 'user15804049843', '15804049843'), ('131', '1', 'user15804049843', '50', '0', '0', '待付款', '2018-07-15 18:28:18', '1', '0', 'user15804049843', '15804049843');
COMMIT;

-- ----------------------------
--  Table structure for `swiper`
-- ----------------------------
DROP TABLE IF EXISTS `swiper`;
CREATE TABLE `swiper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qid` int(11) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `category` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `swiper`
-- ----------------------------
BEGIN;
INSERT INTO `swiper` VALUES ('1', '1', '5c25c194-a9ea-4598-9556-0ad1edf6a78denterprise', 'A'), ('2', '1', '5c25c194-a9ea-4598-9556-0ad1edf6a78denterprise', 'A'), ('3', '1', '5c25c194-a9ea-4598-9556-0ad1edf6a78denterprise', 'A'), ('4', '1', '5c25c194-a9ea-4598-9556-0ad1edf6a78denterprise', 'A');
COMMIT;

-- ----------------------------
--  Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(255) DEFAULT NULL,
  `tphoto` varchar(255) DEFAULT NULL,
  `introduction` varchar(255) DEFAULT NULL,
  `qid` int(11) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `teacher`
-- ----------------------------
BEGIN;
INSERT INTO `teacher` VALUES ('1', '费园园', 'teacher01.jpg', '主要从事HTML5、Java开源领域及Android移动开发，在东软集团担任过6年的软件工程师，2年半的HTML5、JAVA培训讲师，承担过东北大学，北交大等重点高校培训项目。', '1'), ('2', '陈伟', 'teacher02.jpg', '有30多年的软件项目开发经验，有10多年的教学经验，熟悉.NET、C#、F#、C语言、Java等编程语言等，擅长C#、Java语言课程。为Microsoft、Intel、AutoDisk、南京大学、东北大学等学校和企业授过课。', '1'), ('3', '宋波', 'teacher03.jpg', ' 12年开发经验，2年教学经验,精通JAVA、C、C++、C#、PHP等多种编程语言，熟悉ios，android移动平台APP开发，语言功底扎实浑厚，精通数据结构和算法，积累多套软件开发框架。', '1');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `userpassword` varchar(255) NOT NULL,
  `qid` int(11) DEFAULT NULL,
  `jurisdiction` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('任庭玉', '123456', '1', '管理员', '5'), ('zhaojy', '123456', '1', '管理员', '6');
COMMIT;

-- ----------------------------
--  Table structure for `weixin`
-- ----------------------------
DROP TABLE IF EXISTS `weixin`;
CREATE TABLE `weixin` (
  `qid` int(11) NOT NULL,
  `appid` varchar(255) DEFAULT NULL,
  `appsecret` varchar(255) DEFAULT NULL,
  `partner` varchar(255) DEFAULT NULL,
  `partnerkey` varchar(255) DEFAULT NULL,
  `weixinpaycallback` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`qid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
