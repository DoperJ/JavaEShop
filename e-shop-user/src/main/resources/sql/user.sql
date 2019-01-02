CREATE DATABASE IF NOT EXISTS e_shop;

USE e_shop;

CREATE TABLE IF NOT EXISTS t_user(
  user_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_name VARCHAR(255) UNIQUE NOT NULL COMMENT '用户名称',
  e_mail VARCHAR(255) NOT NULL COMMENT '电子邮箱',
  password VARCHAR(255) NOT NULL COMMENT '使用MD5加密后的密码',
  phone VARCHAR(255) NULL COMMENT '用户默认手机号码',
  salt VARCHAR(255) NOT NULL COMMENT 'salt值',
  head_url VARCHAR(255) NOT NULL COMMENT '头像对应的URL',
  role VARCHAR(255) NOT NULL DEFAULT "ROLE_USER" COMMENT '用户身份'
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS t_address(
  address_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_id INT(11) NOT NULL,
  zip INT NOT NULL COMMENT '邮编',
  province VARCHAR(255) NOT NULL COMMENT '地区表中省份的ID',
  city VARCHAR(255) NOT NULL COMMENT '地区表中城市的ID',
  district VARCHAR(255) NOT NULL COMMENT '地区表中的区ID',
  address VARCHAR(255) NOT NULL COMMENT '具体的地址门牌号',
  phone_num VARCHAR(255) NOT NULL COMMENT '手机号码',
  is_default BOOLEAN NOT NULL COMMENT '是否默认',
  modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间'
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
