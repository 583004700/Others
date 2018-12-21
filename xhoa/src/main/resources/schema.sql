CREATE TABLE IF NOT EXISTS `xh-oa`.`t_log`(
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键自增长',
  `user_id` INT(11) COMMENT '操作人',
  `op_date` TIMESTAMP NOT NULL COMMENT '操作时间',
  `op_type` VARCHAR(100) NOT NULL COMMENT '操作类型',
  `ip` VARCHAR(16) NOT NULL COMMENT 'ip地址',
  `module` VARCHAR(100) NOT NULL COMMENT '所属模块',
  `note` VARCHAR(1000) COMMENT '备注',
  `class_name` VARCHAR(1000) COMMENT '类名',
  `method_name` VARCHAR(1000) COMMENT '方法名',
  `args` VARCHAR(1000) COMMENT '方法参数',
  `url` VARCHAR(1000) COMMENT 'url地址',
  PRIMARY KEY (`id`),
  FULLTEXT INDEX `idx_op_type` (`op_type`)
) ENGINE=INNODB CHARSET=utf8 COLLATE=utf8_bin;
