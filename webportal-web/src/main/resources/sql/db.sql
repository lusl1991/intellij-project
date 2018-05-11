-- 用户表
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT '0',
  `account` varchar(15) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '超级管理员', '0', 'admin', '123456');
INSERT INTO `tb_user` VALUES ('4', '系统管理员', '1', 'system', '000124');



-- 菜单表
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `ID` int(12) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `ICON` varchar(255) NOT NULL COMMENT '菜单图标',
  `TITLE` varchar(255) NOT NULL COMMENT '菜单名称',
  `PATH` varchar(255) NOT NULL COMMENT '菜单路径',
  `LEVEL` int(12) NOT NULL COMMENT '菜单等级',
  `ISLEAF` tinyint(1) NOT NULL COMMENT '是否子节点（0：是；1：否）',
  `PARENTID` int(12) NOT NULL DEFAULT '0' COMMENT '父级菜单id（0表示当前菜单为一级菜单）',
  `ORDERID` int(12) NOT NULL COMMENT '排序',
  `ZT` tinyint(1) NOT NULL COMMENT '状态（0：可用；1：不可用）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('1', 'anticon-shop', 'menu.form', '', '1', '1', '0', '1', '0');
INSERT INTO `tb_menu` VALUES ('2', '', 'menu.info', '/shop/info', '2', '0', '1', '2', '0');
INSERT INTO `tb_menu` VALUES ('3', '', 'menu.type', '/shop/type', '2', '0', '1', '3', '0');
INSERT INTO `tb_menu` VALUES ('4', '', 'menu.layout', '/shop/layout', '2', '0', '1', '5', '0');
INSERT INTO `tb_menu` VALUES ('5', '', 'menu.sync', '/shop/sync', '2', '0', '1', '6', '0');
INSERT INTO `tb_menu` VALUES ('6', '', 'menu.async', '/shop/async', '2', '0', '1', '7', '0');
INSERT INTO `tb_menu` VALUES ('7', 'anticon-shopping-cart', 'menu.chart', '', '1', '1', '0', '8', '0');
INSERT INTO `tb_menu` VALUES ('8', 'anticon-shopping-cart', 'menu.order', '/order/profile', '2', '0', '8', '9', '0');
INSERT INTO `tb_menu` VALUES ('9', 'anticon-appstore', 'menu.goods', '', '1', '1', '0', '10', '0');
INSERT INTO `tb_menu` VALUES ('10', 'anticon-appstore', 'menu.goods.property', '', '2', '0', '10', '11', '0');
INSERT INTO `tb_menu` VALUES ('11', 'anticon-appstore', 'menu.goods.classify', '', '2', '1', '10', '12', '0');
INSERT INTO `tb_menu` VALUES ('12', 'anticon-appstore', 'menu.goods.brand', '', '3', '0', '12', '13', '0');
INSERT INTO `tb_menu` VALUES ('13', 'anticon-appstore', 'menu.goods.size', '', '3', '0', '12', '14', '0');
