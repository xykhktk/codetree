CREATE TABLE `code` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code_define` varchar(45) NOT NULL DEFAULT '' COMMENT '代码定义',
  `code_item` varchar(45) NOT NULL COMMENT '代码值',
  `parent_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '父id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;