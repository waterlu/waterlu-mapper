CREATE TABLE `test_user` (
  `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `user_name` varchar(16) DEFAULT NULL COMMENT '用户名',
  `user_mobile` varchar(16) DEFAULT NULL COMMENT '用户手机号码',
  `delete_flag` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '删除标记',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `idx_user_mobile` (`user_mobile`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `test_account` (
  `account_uuid` char(32) NOT NULL COMMENT '账户UUID',
  `user_id` bigint(32) NOT NULL COMMENT '用户UUID',
  `account_type` char(10) NOT NULL DEFAULT '21' COMMENT '账户类型',
  `account_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '账户状态',
  `account_amount` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT '账户余额',
  `account_cash_amount` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT '账户可用余额',
  `account_freeze_amount` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT '账户冻结金额',
  `delete_flag` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '删除标记',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`account_uuid`),
  UNIQUE KEY `idx_account_user_uuid` (`user_id`),
  KEY `idx_account_user_type` (`account_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户表';