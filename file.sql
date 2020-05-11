/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : file

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2019-11-28 22:38:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `attendance`
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '考勤id',
  `fk_userNum` varchar(10) NOT NULL COMMENT '用户编号',
  `lateDay` int(11) NOT NULL DEFAULT '0' COMMENT '迟到天数',
  `absenteeismDay` int(11) NOT NULL DEFAULT '0' COMMENT '旷工天数',
  `overtimeDay` int(11) NOT NULL DEFAULT '0' COMMENT '加班天数',
  PRIMARY KEY (`id`),
  KEY `fk_userNum` (`fk_userNum`),
  CONSTRAINT `fk_userNum` FOREIGN KEY (`fk_userNum`) REFERENCES `user` (`userNum`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES ('1', '168207101', '0', '0', '0');
INSERT INTO `attendance` VALUES ('2', '168207102', '0', '0', '0');
INSERT INTO `attendance` VALUES ('3', '168207103', '0', '0', '0');
INSERT INTO `attendance` VALUES ('4', '168207104', '0', '0', '0');
INSERT INTO `attendance` VALUES ('5', '168207130', '0', '0', '0');
INSERT INTO `attendance` VALUES ('6', '168207105', '0', '0', '0');

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '单位id',
  `departmentName` varchar(255) NOT NULL COMMENT '单位名称',
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `id_2` (`id`),
  KEY `id_3` (`id`),
  KEY `id_4` (`id`),
  KEY `id_5` (`id`,`departmentName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '技术部');
INSERT INTO `department` VALUES ('2', '研发部');
INSERT INTO `department` VALUES ('3', '财务部');
INSERT INTO `department` VALUES ('4', '销售部');
INSERT INTO `department` VALUES ('5', '运营部');

-- ----------------------------
-- Table structure for `position`
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '职位id',
  `positionName` varchar(255) NOT NULL COMMENT '职位名称',
  `number` int(11) NOT NULL COMMENT '在职人数',
  `fk_departmentId` int(11) NOT NULL COMMENT '部门表主键',
  PRIMARY KEY (`id`),
  KEY `fk_departmentId` (`fk_departmentId`),
  CONSTRAINT `fk_departmentId` FOREIGN KEY (`fk_departmentId`) REFERENCES `department` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('1', '技术部经理', '0', '1');
INSERT INTO `position` VALUES ('2', '技术部组长', '0', '1');
INSERT INTO `position` VALUES ('3', '技术部职员', '0', '1');
INSERT INTO `position` VALUES ('4', '研发部经理', '0', '2');
INSERT INTO `position` VALUES ('5', '研发部组长', '0', '2');
INSERT INTO `position` VALUES ('6', '研发部职员', '0', '2');
INSERT INTO `position` VALUES ('7', '财务部经理', '0', '3');
INSERT INTO `position` VALUES ('8', '财务部组长', '0', '3');
INSERT INTO `position` VALUES ('9', '财务部职员', '0', '3');
INSERT INTO `position` VALUES ('10', '销售部经理', '0', '4');
INSERT INTO `position` VALUES ('11', '销售部组长', '0', '4');
INSERT INTO `position` VALUES ('12', '销售部职员', '0', '4');
INSERT INTO `position` VALUES ('13', '运营部经理', '0', '5');
INSERT INTO `position` VALUES ('14', '运营部组长', '0', '5');
INSERT INTO `position` VALUES ('15', '运营部职员', '0', '5');

-- ----------------------------
-- Table structure for `salary`
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '薪资id',
  `basics` decimal(8,2) NOT NULL COMMENT '基础工资',
  `late` decimal(8,2) NOT NULL COMMENT '迟到扣除工资',
  `absenteeism` decimal(8,2) NOT NULL COMMENT '旷工扣除工资',
  `overtime` decimal(8,2) NOT NULL COMMENT '加班奖励工资',
  `reality` decimal(8,2) NOT NULL COMMENT '到手工资',
  `fk_userNum2` varchar(10) NOT NULL COMMENT '用户编号',
  PRIMARY KEY (`id`),
  KEY `fk_userNum2` (`fk_userNum2`),
  CONSTRAINT `fk_userNum2` FOREIGN KEY (`fk_userNum2`) REFERENCES `user` (`userNum`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES ('1', '10000.00', '-50.00', '-200.00', '100.00', '10000.00', '168207101');
INSERT INTO `salary` VALUES ('2', '10000.00', '-50.00', '-200.00', '100.00', '10000.00', '168207102');
INSERT INTO `salary` VALUES ('3', '10000.00', '-50.00', '-200.00', '100.00', '10000.00', '168207103');
INSERT INTO `salary` VALUES ('4', '10000.00', '-50.00', '-200.00', '100.00', '10000.00', '168207104');
INSERT INTO `salary` VALUES ('5', '10000.00', '-50.00', '-200.00', '100.00', '10000.00', '168207105');
INSERT INTO `salary` VALUES ('6', '5000.00', '-50.00', '-200.00', '100.00', '5000.00', '168207105');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `userNum` varchar(10) NOT NULL COMMENT '用户编号',
  `userName` varchar(255) NOT NULL COMMENT '用户姓名',
  `userPassword` varchar(255) NOT NULL COMMENT '用户密码',
  `userSex` varchar(4) NOT NULL COMMENT '用户性别',
  `userBirthday` date NOT NULL COMMENT '出生年月',
  `userTel` varchar(255) DEFAULT NULL COMMENT '用户电话号码',
  `userMail` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
  `userType` int(11) NOT NULL COMMENT '用户类型',
  `fk_positionId` int(11) NOT NULL COMMENT '职位id',
  PRIMARY KEY (`id`),
  KEY `fk_positionId` (`fk_positionId`),
  KEY `userNum` (`userNum`),
  CONSTRAINT `fk_positionId` FOREIGN KEY (`fk_positionid`) REFERENCES `position` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '168207101', '丁秀丽', '123', '女', '2000-10-10', '13577886432', '123@qq.com', '0', '1');
INSERT INTO `user` VALUES ('2', '168207102', '郭金珊', '123', '女', '2019-11-15', '13080987655', '123@qq.com', '1', '4');
INSERT INTO `user` VALUES ('3', '168207103', '吴素婷', '123', '女', '1999-11-02', '15976543456', '123@qq.com', '0', '7');
INSERT INTO `user` VALUES ('4', '168207104', '支春雨', '123', '女', '2014-10-28', '15787800000', '123@qq.com', '0', '10');
INSERT INTO `user` VALUES ('5', '168207130', '邱高强', '123', '男', '1998-07-24', '15179497032', '1015390189@qq.com', '1', '13');
INSERT INTO `user` VALUES ('6', '168207105', '小明', '123', '男', '2010-11-02', '12432543556', '123@qq.com', '0', '2');
INSERT INTO `user` VALUES ('7', '123', '123', '123', '男', '2011-06-24', '12345678900', '12345@163.com', '0', '7');
INSERT INTO `user` VALUES ('8', '111', '晓亮', '123', '女', '2009-09-23', '12345678900', '12345@163.com', '0', '3');
INSERT INTO `user` VALUES ('9', '168207106', '小时', '123', '男', '1989-02-08', '12345678900', '12345@163.com', '2', '4');
INSERT INTO `user` VALUES ('10', '168207107', '新东方', '123', '男', '2019-11-13', '16820710611', '12786@fox.com', '0', '6');
INSERT INTO `user` VALUES ('11', '168207108', '小康', '123', '女', '2019-11-22', '16820710354', '3452@qq.com', '0', '12');
INSERT INTO `user` VALUES ('12', '168207109', '小钱', '123', '女', '2004-08-17', '16854645621', null, '0', '15');
INSERT INTO `user` VALUES ('13', '168207110', '小龙', '123', '女', '1995-08-26', null, null, '0', '6');
INSERT INTO `user` VALUES ('14', '168207111', '成吉思汗', '123', '男', '2033-06-24', null, '234678@163.com', '0', '8');
INSERT INTO `user` VALUES ('15', '168207112', '耀', '123', '女', '2010-05-26', '16820710689', '123423@qq.com', '0', '5');
INSERT INTO `user` VALUES ('16', '168207113', '蔡文姬', '123', '女', '1989-06-18', '16820714575', '12334@123.com', '0', '7');
INSERT INTO `user` VALUES ('17', '168207114', '曹操', '123', '男', '1996-01-01', '16820710612', '3454@34.com', '0', '11');
INSERT INTO `user` VALUES ('18', '168207115', '刘备', '123', '男', '2019-11-15', '16825464573', '6342@163.com', '0', '12');
INSERT INTO `user` VALUES ('19', '168207116', '雅典娜', '123', '女', '2006-10-28', '16820767864', '453986@fox.com', '0', '9');
INSERT INTO `user` VALUES ('20', '168207117', '钢铁侠', '123', '男', '2011-08-04', '12523412423', '241232@163.com', '2', '2');
INSERT INTO `user` VALUES ('21', '168207118', '奥丁', '123', '男', '2100-01-01', '16820764563', '546345@qq.com', '2', '4');
INSERT INTO `user` VALUES ('22', '168207119', '金蝉子', '123', '女', '2010-05-25', '16820711434', '677878@qq.com', '2', '11');
INSERT INTO `user` VALUES ('23', '168207120', '王镜泽', 'zhenxiang', '男', '2011-05-16', '16820713534', '24324@qq.com', '0', '12');
INSERT INTO `user` VALUES (27, '168207122', '武则天', '123456', '女', '1997-10-07', '12345678800', '10111@qq.com', 0, 2);
INSERT INTO `user` VALUES (28, '168207125', '曹操', '123456', '男', '1996-12-18', '12345677777', '17857@qq.com', 0, 5);
INSERT INTO `user` VALUES (29, '111111', '郭小珊', '111111', '男', '1998-12-15', '', '', 1, 5);
INSERT INTO `user` VALUES (30, '168207133', '鲁班七号', '123456', '男', '1997-12-16', '', '', 1, 15);
INSERT INTO `user` VALUES (31, '168207134', '鲁班七号', '123456', '女', '1996-12-19', '', '', 1, 15);
INSERT INTO `user` VALUES (32, '168207137', '鲁班七号', '123456', '女', '1995-12-12', '', '', 1, 14);
