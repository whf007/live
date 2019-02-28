USE member;
DROP TABLE IF EXISTS `tm_member_identity`;
CREATE TABLE `tm_member_identity` (
  `member_id` VARCHAR(16) NOT NULL COMMENT '会员ID',
  `identity_id` VARCHAR(64) NOT NULL COMMENT '登录名',
  `identity_type` VARCHAR(1) NOT NULL  COMMENT '登录名类型',
  `pid_id` INT(10) NOT NULL COMMENT '待定',
   partner_id VARCHAR(12) NOT NULL COMMENT '代理方',
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE INDEX `et_member_identity` (`identity_id`,`identity_type`,`pid_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '会员表';

DROP TABLE IF EXISTS `tm_member`;
CREATE TABLE `tm_member` (
  `member_id` VARCHAR(16) NOT NULL COMMENT '会员ID',
  `member_name` VARCHAR(64) NOT NULL COMMENT '登录名',
  `type` TINYINT(1) NOT NULL  COMMENT '1学生，2老师',
  `pid_id` INT(10) NOT NULL COMMENT '用户类型',
  real_name VARCHAR(64) DEFAULT NULL COMMENT'真实姓名',
  cert_no VARCHAR(64) COMMENT '证件号',
  teacher_type VARCHAR(18) COMMENT '教学类型',
  demo VARCHAR(256) COMMENT '个人介绍',
  `status` VARCHAR(4) COMMENT '状态  0 未激活 1可用',
  wechat  VARCHAR(256) COMMENT '微信号',
  alipay VARCHAR(256) COMMENT '支付宝账号',
  lable VARCHAR(256) COMMENT '标签',
  `password` VARCHAR(256) COMMENT '密码',
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`member_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '会员信息表';
DROP TABLE IF EXISTS `tm_course`;
CREATE TABLE `tm_course` (
  `member_id` VARCHAR(16) NOT NULL COMMENT '会员ID',
  `course_id` VARCHAR(64) NOT NULL COMMENT '课程id',
  `course_name` VARCHAR(64) NOT NULL COMMENT '课程名称',
  `course_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '课程时间',
  teacher_type VARCHAR(18) COMMENT '教学类型',
  price DECIMAL(30,12) COMMENT '课程价格',
  demo VARCHAR(256) COMMENT '课程介绍',
  lable VARCHAR(256) COMMENT '标签',
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`course_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '课程表';

DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
  `seq_name` VARCHAR(50) NOT NULL,
  `current_val` INT(11) NOT NULL,
  `increment_val` INT(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`seq_name`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

DROP FUNCTION IF EXISTS `currval`;
DELIMITER ;;
CREATE FUNCTION `currval`(v_seq_name VARCHAR(50)) RETURNS INT(11)
BEGIN
    DECLARE VALUE INTEGER;
    SET VALUE = 0;
    SELECT current_val INTO VALUE FROM sequence WHERE seq_name = v_seq_name;
   RETURN VALUE;
END
;;
DELIMITER ;
DROP FUNCTION IF EXISTS `nextval`;
DELIMITER ;;
CREATE FUNCTION `nextval`(v_seq_name VARCHAR(50)) RETURNS INT(11)
BEGIN
    UPDATE sequence SET current_val = current_val + IF(current_val/2=1,increment_val,FLOOR(1 + RAND()*200))  WHERE seq_name = v_seq_name;
    RETURN currval(v_seq_name);
END
;;
DELIMITER ;

INSERT INTO sequence
 VALUES('t_sequence_member',1000000000,1);




 DROP TABLE IF EXISTS `tm_course_record`;
CREATE TABLE `tm_course_record` (
  `member_id` VARCHAR(16) NOT NULL COMMENT '会员ID',
  `teacher_member_id` VARCHAR(64) NOT NULL COMMENT '老师id',
  `course_id` VARCHAR(64) NOT NULL  COMMENT '课程id',
  `course_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '课程时间',
  `course_name` VARCHAR(64) NOT NULL  COMMENT '课程名称',
  `status` VARCHAR(8) DEFAULT NULL COMMENT '课程状态',
  teacher_type VARCHAR(18) COMMENT '教学类型',
  lable VARCHAR(256) COMMENT '标签',
  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`member_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '会员课程记录表';


DROP TABLE IF EXISTS `sys_permission`;

CREATE TABLE `sys_permission` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `available` BIT(1) DEFAULT NULL,
  `name` VARCHAR(255) DEFAULT NULL,
  `parent_id` BIGINT(20) DEFAULT NULL,
  `parent_ids` VARCHAR(255) DEFAULT NULL,
  `permission` VARCHAR(255) DEFAULT NULL,
  `resource_type` ENUM('menu','button') DEFAULT NULL,
  `url` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_permission` */

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `available` BIT(1) DEFAULT NULL,
  `description` VARCHAR(255) DEFAULT NULL,
  `role` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

/*Table structure for table `sys_role_permission` */

DROP TABLE IF EXISTS `sys_role_permission`;

CREATE TABLE `sys_role_permission` (
  `permission_id` INT(11) NOT NULL,
  `role_id` INT(11) NOT NULL,
  KEY `FK9q28ewrhntqeipl1t04kh1be7` (`role_id`),
  KEY `FKomxrs8a388bknvhjokh440waq` (`permission_id`),
  CONSTRAINT `FKomxrs8a388bknvhjokh440waq` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`id`),
  CONSTRAINT `FK9q28ewrhntqeipl1t04kh1be7` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_permission` */

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `role_id` INT(11) NOT NULL,
  `member_id` VARCHAR(16) NOT NULL,
  KEY `FKgkmyslkrfeyn9ukmolvek8b8f` (`member_id`),
  KEY `FKhh52n8vd4ny9ff4x9fb8v65qx` (`role_id`),
  CONSTRAINT `FKhh52n8vd4ny9ff4x9fb8v65qx` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `FKgkmyslkrfeyn9ukmolvek8b8f` FOREIGN KEY (`member_id`) REFERENCES `tm_member` (`member_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;





