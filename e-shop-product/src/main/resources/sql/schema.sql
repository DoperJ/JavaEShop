CREATE DATABASE IF NOT EXISTS e_shop;

USE e_shop;

#产品
CREATE TABLE IF NOT EXISTS t_product(
  product_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  product_name VARCHAR(255) UNIQUE NOT NULL ,
  abbreviation VARCHAR(255) NULL ,
  details VARCHAR(255) NOT NULL DEFAULT "暂无介绍",
  clicked_times INT(11) NOT NULL DEFAULT 0,
  sale_quantity INT(11) NOT NULL DEFAULT 0,
  photo_url VARCHAR(255) NOT NULL,
  is_hot BOOLEAN NOT NULL DEFAULT FALSE,
  is_new BOOLEAN NOT NULL DEFAULT TRUE,
  on_sale_date TIMESTAMP NOT NULL,
  category_id INT(11) NOT NULL DEFAULT 0, #0 代表无分类
  brand_id INT(11) NOT NULL DEFAULT 0 #0 代表无分类
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

#货品sku
CREATE TABLE IF NOT EXISTS t_sku(
  sku_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  product_id INT(11) NOT NULL,
  photo_url VARCHAR(255) NULL DEFAULT "/img/default.png",
  original_price FLOAT(13) NOT NULL,
  sale_price FLOAT(13) NULL,
  stock_quantity INT(11) NULL DEFAULT 0
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#sku选项
CREATE TABLE IF NOT EXISTS t_sku_choice(
  sku_choice_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  sku_id INT(11) NOT NULL,
  sku_choice VARCHAR(255) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#货品-sku选项对应表
CREATE TABLE IF NOT EXISTS t_sku_and_sku_choice(
  id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  sku_choice_id INT(11) NOT NULL,
  sku_id INT(11) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#sku属性
CREATE TABLE IF NOT EXISTS t_sku_attribute(
  sku_attribute_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  sku_attribute_name VARCHAR(255) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#普通属性
CREATE TABLE IF NOT EXISTS t_attribute(
  attribute_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  attribute_name INT(11) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#属性集
CREATE TABLE IF NOT EXISTS t_attribute_set(
  attribute_set_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  attribute_set_name INT(11) NULL
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#属性集-sku属性对应表
CREATE TABLE IF NOT EXISTS t_sku_attribute_and_attribute_set(
  id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  attribute_set_id INT(11) NOT NULL,
  sku_attribute_id INT(11) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#属性集-属性对应表
CREATE TABLE IF NOT EXISTS t_attribute_and_attribute_set(
  id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  attribute_set_id INT(11) NOT NULL,
  attribute_id INT(11) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;


#分类
CREATE TABLE IF NOT EXISTS t_category(
  category_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  sup_category_id INT(11) DEFAULT -1, #父分类id
  categroy_name VARCHAR(255) NOT NULL,
  preview VARCHAR(255) NULL DEFAULT "无介绍"
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE UNIQUE INDEX t_category_category_name_uindex ON t_category (categroy_name);

#品牌
CREATE TABLE IF NOT EXISTS t_brand(
  brand_id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  brand_name VARCHAR(255) NOT NULL,
  introduction TEXT NULL,
  logo_url VARCHAR(255) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
