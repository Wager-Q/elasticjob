

DROP TABLE IF EXISTS `edu_edmo_pms_user`;
CREATE TABLE `edu_edmo_pms_user` (
  `id` varchar(32) collate utf8_unicode_ci NOT NULL default '0' COMMENT 'ID',
  `version` int(11) NOT NULL default '0' COMMENT 'version',
  `create_time` timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '创建时间',
  `user_no` varchar(50) collate utf8_unicode_ci NOT NULL COMMENT '用户帐号',
  `user_type` varchar(1) collate utf8_unicode_ci NOT NULL COMMENT '用户类型（1:超级管理员，2:普通管理员，3:用户主帐号，4:用户子帐号）',
  `main_user_id` bigint(50) default '0' COMMENT '主帐号ID',
  `user_pwd` varchar(256) collate utf8_unicode_ci NOT NULL COMMENT '登录密码',
  `user_name` varchar(50) collate utf8_unicode_ci NOT NULL COMMENT '姓名',
  `mobile_no` varchar(15) collate utf8_unicode_ci default NULL COMMENT '手机号',
  `email` varbinary(100) default NULL COMMENT '邮箱',
  `status` int(11) NOT NULL COMMENT '状态(100:可用，101:不可用 )',
  `last_login_time` datetime default NULL COMMENT '最后登录时间',
  `is_changed_pwd` int(11) default NULL COMMENT '是否更改过密码',
  `pwd_error_count` int(11) NOT NULL default '0' COMMENT '连续输错密码次数',
  `pwd_error_time` datetime default NULL COMMENT '最后输错密码时间',
  `remark` varchar(300) collate utf8_unicode_ci default NULL COMMENT '备注',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `AK_Key_2` (`user_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT INTO `edu_edmo_pms_user` VALUES ('1',17,'2017-11-10 18:07:51','admin','1',0,'7c4a8d09ca3762af61e59520943dc26494f8941b','超级管理员','13800138000',NULL,100,'2018-10-08 18:12:27',0,0,'2018-10-08 17:55:24','超级管理员'),('2',1,'2017-11-10 18:31:22','张三','1',0,'7c4a8d09ca3762af61e59520943dc26494f8941b','管理员','15910288586',NULL,100,NULL,0,0,NULL,'管理员'),('3',0,'2017-11-10 18:33:15','李四','1',0,'7c4a8d09ca3762af61e59520943dc26494f8941b','管理员','13800138000',NULL,100,NULL,0,0,NULL,'管理员'),('4',17,'2019-01-20 12:54:40','123','1',0,'7c4a8d09ca3762af61e59520943dc26494f8941b','超级管理员','13800138000',NULL,100,'2018-10-08 18:12:27',0,0,'2018-10-08 17:55:24','超级管理员');
