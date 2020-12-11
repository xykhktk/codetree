CREATE TABLE `code` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code_define` varchar(45) NOT NULL DEFAULT '' COMMENT '代码定义',
  `code_item` varchar(45) NOT NULL COMMENT '代码值',
  `parent_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '父id',
  `is_del` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除,0否1是.',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

INSERT INTO `code` VALUES (1,'habitation','居住地',0,0),(2,'guangxi','广西',1,0),(3,'nanning','南宁',2,0),(4,'guilin','桂林',2,0),(5,'xixiangtang','西乡瑭',3,0),(6,'xxstreet','某某街道',5,0),(7,'guangdong','广东',1,0);