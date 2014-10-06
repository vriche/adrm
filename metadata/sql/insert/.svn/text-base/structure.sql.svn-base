-- MySQL dump 9.10
--
-- Host: localhost    Database: adrm
-- ------------------------------------------------------
-- Server version	4.0.18-nt

--
-- Table structure for table `tb_ad_resource_carrier`
--

CREATE TABLE tb_ad_resource_carrier (
  ad_resource_carrier_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  ad_resource_channel_id bigint(20) default NULL,
  ad_resource_mediaorg_Id bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  enable char(1) default NULL,
  is_build_level char(1) default NULL,
  carrier_name varchar(128) NOT NULL default '',
  ad_resource_carrier_type_id bigint(20) default NULL,
  alias_name varchar(128) default NULL,
  parent_id varchar(32) default NULL,
  node_level int(11) default NULL,
  display_no int(11) default NULL,
  nodePath text,
  memo text,
  PRIMARY KEY  (ad_resource_carrier_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_ad_resource_carrier_type`
--

CREATE TABLE tb_ad_resource_carrier_type (
  ad_resource_carrier_type_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  enable int(11) default NULL,
  name varchar(128) NOT NULL default '',
  parent_id bigint(20) default NULL,
  node_level int(11) default NULL,
  display_no int(11) default NULL,
  nodePath text,
  memo text,
  PRIMARY KEY  (ad_resource_carrier_type_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_ad_resource_channel`
--

CREATE TABLE tb_ad_resource_channel (
  resource_mediaorg_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(128) default NULL,
  value varchar(5) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  enable int(11) default NULL,
  memo text,
  PRIMARY KEY  (resource_mediaorg_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_ad_resource_compages`
--

CREATE TABLE tb_ad_resource_compages (
  ad_resource_compages_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(128) NOT NULL default '',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  memo text,
  enable char(1) NOT NULL default '',
  is_auto_price tinyint(1) NOT NULL default '0',
  PRIMARY KEY  (ad_resource_compages_id),
  UNIQUE KEY name (name)
) TYPE=InnoDB;

--
-- Table structure for table `tb_ad_resource_compages_price_rel`
--

CREATE TABLE tb_ad_resource_compages_price_rel (
  ad_resource_compages_id bigint(20) NOT NULL default '0',
  ad_resource_price_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (ad_resource_compages_id,ad_resource_price_id),
  KEY FKF1CAB3ED5486A068 (ad_resource_price_id),
  KEY FKF1CAB3EDE5F258CC (ad_resource_compages_id),
  CONSTRAINT `FKF1CAB3ED5486A068` FOREIGN KEY (`ad_resource_price_id`) REFERENCES `tb_ad_resource_price` (`ad_resource_price_id`),
  CONSTRAINT `FKF1CAB3EDE5F258CC` FOREIGN KEY (`ad_resource_compages_id`) REFERENCES `tb_ad_resource_compages` (`ad_resource_compages_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_ad_resource_day_info`
--

CREATE TABLE tb_ad_resource_day_info (
  ad_resource_day_info_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  ad_resource_carrier_id varchar(32) default NULL,
  ad_resource_info_id bigint(20) default NULL,
  ad_resource_type int(11) default NULL,
  ad_resource_propertiy_time int(11) default NULL,
  ad_resource_workspan_id bigint(20) default NULL,
  publish_date int(11) NOT NULL default '0',
  ad_resource_specific varchar(32) default NULL,
  total varchar(32) default NULL,
  used varchar(32) default NULL,
  PRIMARY KEY  (ad_resource_day_info_id),
  KEY FKEB43E89752F355CC (ad_resource_workspan_id),
  CONSTRAINT `FKEB43E89752F355CC` FOREIGN KEY (`ad_resource_workspan_id`) REFERENCES `tb_ad_resource_workspan` (`ad_resource_workspan_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_ad_resource_info`
--

CREATE TABLE tb_ad_resource_info (
  ad_resource_info_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  parent_id bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  memo text,
  ad_resource_type int(11) default NULL,
  ad_resource_propertiy_time int(11) default NULL,
  pro_resource_id bigint(20) default NULL,
  pro_resource_memo text,
  display_no int(11) default NULL,
  is_closed char(1) default NULL,
  is_overweight char(1) default NULL,
  is_validate char(1) default NULL,
  is_seralized char(1) default NULL,
  is_manual char(1) default NULL,
  resource_name varchar(32) NOT NULL default '',
  enable char(1) default NULL,
  ad_resource_carrier_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (ad_resource_info_id),
  KEY FKFDBD54D48807288 (ad_resource_carrier_id),
  CONSTRAINT `FKFDBD54D48807288` FOREIGN KEY (`ad_resource_carrier_id`) REFERENCES `tb_ad_resource_carrier` (`ad_resource_carrier_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_ad_resource_mediaorg`
--

CREATE TABLE tb_ad_resource_mediaorg (
  ad_resource_mediaorg_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(128) default NULL,
  value varchar(5) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  enable int(11) default NULL,
  memo text,
  PRIMARY KEY  (ad_resource_mediaorg_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_ad_resource_package_pos_rel`
--

CREATE TABLE tb_ad_resource_package_pos_rel (
  ad_resource_compages_id bigint(20) NOT NULL default '0',
  ad_resource_info_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (ad_resource_compages_id,ad_resource_info_id),
  KEY FK5E59214F8208DCC (ad_resource_info_id),
  KEY FK5E59214FE5F258CC (ad_resource_compages_id),
  CONSTRAINT `FK5E59214F8208DCC` FOREIGN KEY (`ad_resource_info_id`) REFERENCES `tb_ad_resource_info` (`ad_resource_info_id`),
  CONSTRAINT `FK5E59214FE5F258CC` FOREIGN KEY (`ad_resource_compages_id`) REFERENCES `tb_ad_resource_compages` (`ad_resource_compages_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_ad_resource_price`
--

CREATE TABLE tb_ad_resource_price (
  ad_resource_price_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(128) NOT NULL default '',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  ad_resource_type int(11) default NULL,
  ad_resource_price_type bigint(20) default NULL,
  money_type varchar(16) default NULL,
  is_default char(1) default NULL,
  is_use_regular char(1) default NULL,
  memo text,
  PRIMARY KEY  (ad_resource_price_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_ad_resource_price_detail`
--

CREATE TABLE tb_ad_resource_price_detail (
  ad_resource_price_detail_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  length varchar(32) default NULL,
  price double NOT NULL default '0',
  PRIMARY KEY  (ad_resource_price_detail_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_ad_resource_price_detail_rel`
--

CREATE TABLE tb_ad_resource_price_detail_rel (
  ad_resource_price_id bigint(20) NOT NULL default '0',
  ad_resource_price_detail_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (ad_resource_price_id,ad_resource_price_detail_id),
  KEY FKE2F583875486A068 (ad_resource_price_id),
  KEY FKE2F5838727B39651 (ad_resource_price_detail_id),
  CONSTRAINT `FKE2F5838727B39651` FOREIGN KEY (`ad_resource_price_detail_id`) REFERENCES `tb_ad_resource_price_detail` (`ad_resource_price_detail_id`),
  CONSTRAINT `FKE2F583875486A068` FOREIGN KEY (`ad_resource_price_id`) REFERENCES `tb_ad_resource_price` (`ad_resource_price_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_ad_resource_price_regular`
--

CREATE TABLE tb_ad_resource_price_regular (
  ad_resource_price_regular_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  account_obj varchar(32) NOT NULL default '',
  multi_base double NOT NULL default '0',
  multiply double default NULL,
  other_base double NOT NULL default '0',
  regular_expr text,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  memo varchar(128) default NULL,
  PRIMARY KEY  (ad_resource_price_regular_id),
  UNIQUE KEY account_obj (account_obj)
) TYPE=InnoDB;

--
-- Table structure for table `tb_ad_resource_price_rel`
--

CREATE TABLE tb_ad_resource_price_rel (
  ad_resource_info_id bigint(20) NOT NULL default '0',
  ad_resource_price_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (ad_resource_info_id,ad_resource_price_id),
  KEY FKE93043D5486A068 (ad_resource_price_id),
  KEY FKE93043D8208DCC (ad_resource_info_id),
  CONSTRAINT `FKE93043D5486A068` FOREIGN KEY (`ad_resource_price_id`) REFERENCES `tb_ad_resource_price` (`ad_resource_price_id`),
  CONSTRAINT `FKE93043D8208DCC` FOREIGN KEY (`ad_resource_info_id`) REFERENCES `tb_ad_resource_info` (`ad_resource_info_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_ad_resource_price_type`
--

CREATE TABLE tb_ad_resource_price_type (
  ad_resource_price_type_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  price_type_name varchar(128) NOT NULL default '',
  value varchar(5) NOT NULL default '',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  enable char(1) NOT NULL default '',
  memo text,
  PRIMARY KEY  (ad_resource_price_type_id),
  UNIQUE KEY price_type_name (price_type_name),
  UNIQUE KEY value (value)
) TYPE=InnoDB;

--
-- Table structure for table `tb_ad_resource_sort`
--

CREATE TABLE tb_ad_resource_sort (
  ad_resource_sort_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(128) NOT NULL default '',
  value varchar(5) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  enable int(11) default NULL,
  memo text,
  PRIMARY KEY  (ad_resource_sort_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_ad_resource_specific`
--

CREATE TABLE tb_ad_resource_specific (
  ad_resource_specific_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  memo text,
  position char(3) NOT NULL default '',
  name varchar(128) NOT NULL default '',
  over_rate double default NULL,
  PRIMARY KEY  (ad_resource_specific_id),
  UNIQUE KEY position (position),
  UNIQUE KEY name (name)
) TYPE=InnoDB;

--
-- Table structure for table `tb_ad_resource_type`
--

CREATE TABLE tb_ad_resource_type (
  ad_ad_resource_type_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(128) default NULL,
  value varchar(5) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  enable int(11) default NULL,
  memo text,
  PRIMARY KEY  (ad_ad_resource_type_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_ad_resource_workspan`
--

CREATE TABLE tb_ad_resource_workspan (
  ad_resource_workspan_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  memo text,
  ad_resource_carrier_id varchar(32) default NULL,
  ad_resource_info_id bigint(20) default NULL,
  ad_resource_type int(11) default NULL,
  ad_resource_propertiy_time int(11) default NULL,
  broadcast_start_time varchar(255) default NULL,
  begin_date int(11) default NULL,
  end_date int(11) default NULL,
  broadcast_end_time varchar(255) default NULL,
  sun_length varchar(32) default NULL,
  mon_length varchar(32) default NULL,
  tue_length varchar(32) default NULL,
  thi_length varchar(32) default NULL,
  wen_length varchar(32) default NULL,
  fri_length varchar(32) default NULL,
  sat_length varchar(32) default NULL,
  PRIMARY KEY  (ad_resource_workspan_id),
  KEY FK7A4D3B018208DCC (ad_resource_info_id),
  CONSTRAINT `FK7A4D3B018208DCC` FOREIGN KEY (`ad_resource_info_id`) REFERENCES `tb_ad_resource_info` (`ad_resource_info_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_adver_matter`
--

CREATE TABLE tb_adver_matter (
  adver_matter_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(128) NOT NULL default '',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  memo text,
  enable char(1) default NULL,
  edit varchar(128) NOT NULL default '',
  length varchar(32) NOT NULL default '',
  adver_product_brand_id bigint(20) default NULL,
  customer_id bigint(20) NOT NULL default '0',
  adver_matter_type int(11) default NULL,
  tape_code varchar(32) default NULL,
  PRIMARY KEY  (adver_matter_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_adver_matter_type`
--

CREATE TABLE tb_adver_matter_type (
  matter_type_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) default NULL,
  value bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (matter_type_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_adver_product_brand`
--

CREATE TABLE tb_adver_product_brand (
  adver_product_brand_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(128) NOT NULL default '',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  memo text,
  enable char(1) default NULL,
  PRIMARY KEY  (adver_product_brand_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_adver_product_category`
--

CREATE TABLE tb_adver_product_category (
  adver_product_category_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(128) NOT NULL default '',
  parent_id varchar(32) default NULL,
  node_level int(11) default NULL,
  node_path varchar(128) default NULL,
  display_no int(11) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  memo text,
  enable char(1) default NULL,
  PRIMARY KEY  (adver_product_category_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_adver_publish_memo`
--

CREATE TABLE tb_adver_publish_memo (
  adver_publish_memo_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(128) NOT NULL default '',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  value int(11) default NULL,
  PRIMARY KEY  (adver_publish_memo_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_adver_published_info`
--

CREATE TABLE tb_adver_published_info (
  adver_published_info_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  order_day_info_id bigint(20) default NULL,
  link_user_id bigint(20) default NULL,
  customer_id bigint(20) default NULL,
  customer_name varchar(128) default NULL,
  publish_date int(11) default NULL,
  contract_id bigint(20) default NULL,
  order_id bigint(20) default NULL,
  publish_order varchar(32) default NULL,
  ad_resource_info_id bigint(20) default NULL,
  ad_resource_workspan_id bigint(20) default NULL,
  resource_carrier varchar(32) default NULL,
  position varchar(32) default NULL,
  publish_memo_name varchar(32) default NULL,
  link_user varchar(32) default NULL,
  position_des varchar(128) default NULL,
  pro_resource_memo text,
  adver_matter_id bigint(20) default NULL,
  tape_code varchar(32) default NULL,
  matter_name varchar(128) default NULL,
  matter_edit varchar(128) default NULL,
  matter_length varchar(32) default NULL,
  app_position varchar(32) default NULL,
  publish_memo_value int(11) default NULL,
  ad_resource_carrier_id bigint(20) default NULL,
  ad_resource_type bigint(20) default NULL,
  order_code varchar(128) default NULL,
  specific_value varchar(5) default NULL,
  ad_day_times int(11) default NULL,
  ad_content text,
  PRIMARY KEY  (adver_published_info_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_contract`
--

CREATE TABLE tb_contract (
  contract_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  owner bigint(20) default NULL,
  code varchar(32) default NULL,
  sign_user varchar(32) default NULL,
  sign_headship varchar(32) default NULL,
  contract_money_sum double default NULL,
  contract_money_exec double default NULL,
  money_in_sum double default NULL,
  csign_date int(11) default NULL,
  contract_state bigint(20) NOT NULL default '0',
  start_date int(11) default NULL,
  end_date int(11) default NULL,
  contract_type int(11) default NULL,
  notify_days int(11) default NULL,
  is_limit_order char(1) default NULL,
  contract_sort int(11) default NULL,
  user_id bigint(20) default NULL,
  osign_date int(11) default NULL,
  memo text,
  memo_renew text,
  customer_id bigint(20) NOT NULL default '0',
  ownerUser tinyblob,
  PRIMARY KEY  (contract_id),
  KEY FKDF588FC39F77E301 (customer_id),
  CONSTRAINT `FKDF588FC39F77E301` FOREIGN KEY (`customer_id`) REFERENCES `tb_customer_info` (`customer_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_contract_payment`
--

CREATE TABLE tb_contract_payment (
  contract_payment_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  income_purpose_id bigint(20) default NULL,
  pay_number int(11) default NULL,
  pay_date int(11) default NULL,
  contract_id bigint(20) default NULL,
  order_id bigint(20) default NULL,
  money_pay double default NULL,
  money_in double NOT NULL default '0',
  urgency_alert char(1) default NULL,
  memo text,
  customer_id bigint(20) default NULL,
  PRIMARY KEY  (contract_payment_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_contract_target`
--

CREATE TABLE tb_contract_target (
  contract_target_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  resource_carrier_id bigint(20) default NULL,
  contract_id bigint(20) default NULL,
  industry_type_id bigint(20) default NULL,
  target double default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  memo text,
  PRIMARY KEY  (contract_target_id),
  KEY FK32C2D8D4499E681 (contract_id),
  CONSTRAINT `FK32C2D8D4499E681` FOREIGN KEY (`contract_id`) REFERENCES `tb_contract` (`contract_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_contract_target_month`
--

CREATE TABLE tb_contract_target_month (
  contract_target_month_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  month_date int(11) NOT NULL default '0',
  year_date int(11) NOT NULL default '0',
  month_targ double NOT NULL default '0',
  month_real double NOT NULL default '0',
  contract_target_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (contract_target_month_id),
  KEY FK35B5954E9CC185A6 (contract_target_id),
  CONSTRAINT `FK35B5954E9CC185A6` FOREIGN KEY (`contract_target_id`) REFERENCES `tb_contract_target` (`contract_target_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_customer_address`
--

CREATE TABLE tb_customer_address (
  customer_address_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  customer_id bigint(20) default NULL,
  addressType varchar(128) default NULL,
  address varchar(150) default NULL,
  city varchar(50) NOT NULL default '',
  province varchar(100) default NULL,
  country varchar(100) default NULL,
  postal_code varchar(15) NOT NULL default '',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (customer_address_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_customer_agent_info`
--

CREATE TABLE tb_customer_agent_info (
  customer_agent_info_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  customer_category_id bigint(20) NOT NULL default '0',
  enable char(1) NOT NULL default '',
  lowest_rate double NOT NULL default '0',
  ad_resource_sort_id bigint(20) NOT NULL default '0',
  resource_carrier_id bigint(20) NOT NULL default '0',
  customer_agenet_type int(11) default NULL,
  ad_resource_price_type_id bigint(20) default NULL,
  agent_rate double default NULL,
  begin_date int(11) default NULL,
  customer_id bigint(20) default NULL,
  end_date int(11) default NULL,
  customer_industry_type_id bigint(20) default NULL,
  state int(11) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  contract_id bigint(20) default NULL,
  PRIMARY KEY  (customer_agent_info_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_customer_category`
--

CREATE TABLE tb_customer_category (
  customer_category_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  ad_resource_price_type int(11) default NULL,
  category_code varchar(8) NOT NULL default '',
  category_name varchar(128) NOT NULL default '',
  memo text,
  parent_id varchar(32) default NULL,
  tree_level int(11) default NULL,
  display_no int(11) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (customer_category_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_customer_feedback`
--

CREATE TABLE tb_customer_feedback (
  customer_feedback_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  customer_id bigint(20) default NULL,
  feeder varchar(128) default NULL,
  department_id bigint(20) default NULL,
  feed_type int(11) default NULL,
  submit_date int(11) default NULL,
  feed_content varchar(255) NOT NULL default '',
  deal_date int(11) default NULL,
  satisfactory_degree int(11) default NULL,
  memo varchar(128) default NULL,
  PRIMARY KEY  (customer_feedback_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_customer_industry_type`
--

CREATE TABLE tb_customer_industry_type (
  customer_industry_type_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  memo text,
  name varchar(128) NOT NULL default '',
  code varchar(32) default NULL,
  PRIMARY KEY  (customer_industry_type_id),
  UNIQUE KEY name (name)
) TYPE=InnoDB;

--
-- Table structure for table `tb_customer_info`
--

CREATE TABLE tb_customer_info (
  customer_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  account_address varchar(128) default NULL,
  account_bank varchar(128) default NULL,
  account_name varchar(128) default NULL,
  account_number varchar(128) default NULL,
  credit_account int(11) default NULL,
  credit_span int(11) default NULL,
  customer_category_id varchar(32) default NULL,
  customer_type_id bigint(20) default NULL,
  customer_level int(11) default NULL,
  customer_name varchar(128) NOT NULL default '',
  state int(11) default NULL,
  delay_days int(11) default NULL,
  delay_date_unit int(11) default NULL,
  discount_rate double default NULL,
  fax varchar(128) default NULL,
  help_code varchar(16) NOT NULL default '',
  industry_type_id bigint(20) default NULL,
  memo text,
  owner_agent varchar(128) default NULL,
  parent_id varchar(128) NOT NULL default '',
  payment_expire_days int(11) default NULL,
  telephone varchar(128) default NULL,
  web_site text,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (customer_id),
  UNIQUE KEY customer_name (customer_name),
  UNIQUE KEY help_code (help_code)
) TYPE=InnoDB;

--
-- Table structure for table `tb_customer_link_hisotry`
--

CREATE TABLE tb_customer_link_hisotry (
  customer_link_hisotry_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  link_date int(11) default NULL,
  subject varchar(128) NOT NULL default '',
  customer_link_man_id bigint(20) default NULL,
  counterpart_man varchar(128) default NULL,
  memo text,
  customer_id bigint(20) default NULL,
  PRIMARY KEY  (customer_link_hisotry_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_customer_link_man`
--

CREATE TABLE tb_customer_link_man (
  customer_link_man_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  link_man_name varchar(128) NOT NULL default '',
  customer_id bigint(20) default NULL,
  nickle_name varchar(32) default NULL,
  sex int(11) default NULL,
  birthday_year int(11) default NULL,
  birthday_month int(11) default NULL,
  birthday_day int(11) default NULL,
  anni_year int(11) default NULL,
  anni_month int(11) default NULL,
  anni_day int(11) default NULL,
  job_title varchar(32) default NULL,
  company_website varchar(128) default NULL,
  home_country varchar(128) default NULL,
  home_province varchar(32) default NULL,
  home_city varchar(32) default NULL,
  home_scarriert varchar(32) default NULL,
  home_zip varchar(32) default NULL,
  company_country varchar(128) default NULL,
  company_province varchar(32) default NULL,
  company_city varchar(32) default NULL,
  company_scarriert varchar(32) default NULL,
  company_zip varchar(32) default NULL,
  home_tel varchar(128) default NULL,
  office_tel varchar(128) default NULL,
  mobile varchar(128) default NULL,
  favor_email text,
  bak_email text,
  msn text,
  oicq text,
  memo text,
  enable int(11) default NULL,
  is_customer_main int(11) default NULL,
  main_tel varchar(32) default NULL,
  home_page varchar(255) default NULL,
  PRIMARY KEY  (customer_link_man_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_customer_type`
--

CREATE TABLE tb_customer_type (
  customer_type_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  code varchar(128) default NULL,
  memo text,
  name varchar(128) NOT NULL default '',
  PRIMARY KEY  (customer_type_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_customer_user_rel`
--

CREATE TABLE tb_customer_user_rel (
  customer_id bigint(20) NOT NULL default '0',
  user_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (customer_id,user_id),
  KEY FKD00719D5FEE1DB61 (user_id),
  KEY FKD00719D59F77E301 (customer_id),
  CONSTRAINT `FKD00719D59F77E301` FOREIGN KEY (`customer_id`) REFERENCES `tb_customer_info` (`customer_id`),
  CONSTRAINT `FKD00719D5FEE1DB61` FOREIGN KEY (`user_id`) REFERENCES `tb_sys_user` (`id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_income`
--

CREATE TABLE tb_income (
  income_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  income_code varchar(32) default NULL,
  income_date int(11) default NULL,
  customer_id bigint(20) default NULL,
  income_money double default NULL,
  income_mode_id bigint(20) default NULL,
  income_purpose_id bigint(20) default NULL,
  memo varchar(255) default NULL,
  user_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (income_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_income_mode`
--

CREATE TABLE tb_income_mode (
  income_mode_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  name varchar(128) NOT NULL default '',
  value int(11) default NULL,
  PRIMARY KEY  (income_mode_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_income_pull`
--

CREATE TABLE tb_income_pull (
  income_pull_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  income_id bigint(20) default NULL,
  ad_resource_carrier_id bigint(20) default NULL,
  money_pull double default NULL,
  money_in double NOT NULL default '0',
  PRIMARY KEY  (income_pull_id),
  KEY FK23D99ECA505460E1 (income_id),
  CONSTRAINT `FK23D99ECA505460E1` FOREIGN KEY (`income_id`) REFERENCES `tb_income` (`income_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_income_purpose`
--

CREATE TABLE tb_income_purpose (
  income_purpose_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  name varchar(128) NOT NULL default '',
  value int(11) default NULL,
  PRIMARY KEY  (income_purpose_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_income_used`
--

CREATE TABLE tb_income_used (
  income_used_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  income_id bigint(20) default NULL,
  income_pull_id bigint(20) default NULL,
  contract_id bigint(20) default NULL,
  order_id bigint(20) default NULL,
  order_detail_id bigint(20) default NULL,
  order_day_info_id bigint(20) default NULL,
  publish_date int(11) default NULL,
  money_in double NOT NULL default '0',
  payment_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (income_used_id),
  KEY FK23DBDC4235560EA1 (payment_id),
  CONSTRAINT `FK23DBDC4235560EA1` FOREIGN KEY (`payment_id`) REFERENCES `tb_contract_payment` (`contract_payment_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_apply_info`
--

CREATE TABLE tb_oa_apply_info (
  apply_info_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  apply_start int(11) default NULL,
  apply_end int(11) default NULL,
  check_result_id bigint(20) default NULL,
  reason varchar(255) default NULL,
  work_flow_type_id bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (apply_info_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_area_city`
--

CREATE TABLE tb_oa_area_city (
  area_city_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (area_city_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_area_pc`
--

CREATE TABLE tb_oa_area_pc (
  area_pc_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) default NULL,
  area_city_id bigint(20) default NULL,
  ld_code varchar(32) default NULL,
  post_code varchar(32) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (area_pc_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_assets`
--

CREATE TABLE tb_oa_assets (
  assets_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  assets_code varchar(255) default NULL,
  assets_name varchar(32) default NULL,
  assets_state_id bigint(20) default NULL,
  assets_type_id bigint(20) default NULL,
  depreciation varchar(32) default NULL,
  memo varchar(255) default NULL,
  old_value double default NULL,
  provider varchar(128) default NULL,
  purchase_money double default NULL,
  purchase_date varchar(8) default NULL,
  standard varchar(128) default NULL,
  storage varchar(255) default NULL,
  surplus_value double default NULL,
  use_year_fixed int(11) default NULL,
  voucher varchar(32) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (assets_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_assets_product`
--

CREATE TABLE tb_oa_assets_product (
  assets_id bigint(20) NOT NULL default '0',
  product_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (assets_id,product_id),
  KEY FK2019EEAFBEBDD953 (assets_id),
  KEY FK2019EEAF3AD449CF (product_id),
  CONSTRAINT `FK2019EEAF3AD449CF` FOREIGN KEY (`product_id`) REFERENCES `tb_oa_product_info` (`product_id`),
  CONSTRAINT `FK2019EEAFBEBDD953` FOREIGN KEY (`assets_id`) REFERENCES `tb_oa_assets` (`assets_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_assets_state`
--

CREATE TABLE tb_oa_assets_state (
  assets_state_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) default NULL,
  value bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (assets_state_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_assets_type`
--

CREATE TABLE tb_oa_assets_type (
  assets_type_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) default NULL,
  value bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (assets_type_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_business_card`
--

CREATE TABLE tb_oa_business_card (
  business_card_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  birthday_date int(11) default NULL,
  birthday_month int(11) default NULL,
  birthday_year int(11) default NULL,
  business_card_typ_id bigint(20) default NULL,
  first_name varchar(32) default NULL,
  last_name varchar(32) default NULL,
  headship varchar(32) default NULL,
  mob varchar(255) default NULL,
  sex int(11) default NULL,
  tel1 varchar(255) default NULL,
  tel2 varchar(255) default NULL,
  tel3 varchar(255) default NULL,
  work varchar(255) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (business_card_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_business_card_type`
--

CREATE TABLE tb_oa_business_card_type (
  business_card_typ_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) default NULL,
  value bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (business_card_typ_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_calendar_event`
--

CREATE TABLE tb_oa_calendar_event (
  calendar_event_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  content varchar(255) default NULL,
  event_state_id bigint(20) default NULL,
  title varchar(255) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  type int(11) default NULL,
  index_date int(11) default NULL,
  index_time bigint(20) default NULL,
  PRIMARY KEY  (calendar_event_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_document`
--

CREATE TABLE tb_oa_document (
  document_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  document_code varchar(32) default NULL,
  document_catalog_id bigint(20) default NULL,
  document_file_id bigint(20) default NULL,
  memo varchar(255) default NULL,
  title varchar(32) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (document_id),
  KEY FKD9539897909E84CA (document_catalog_id),
  CONSTRAINT `FKD9539897909E84CA` FOREIGN KEY (`document_catalog_id`) REFERENCES `tb_oa_document_catalog` (`document_catalog_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_document_catalog`
--

CREATE TABLE tb_oa_document_catalog (
  document_catalog_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) default NULL,
  display_no bigint(20) default NULL,
  node_level bigint(20) default NULL,
  parent_id varchar(32) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (document_catalog_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_document_catalog_branch`
--

CREATE TABLE tb_oa_document_catalog_branch (
  catalog_id bigint(20) NOT NULL default '0',
  branch_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (catalog_id,branch_id),
  KEY FKA70D9306A32B241 (branch_id),
  KEY FKA70D9301CDD2F26 (catalog_id),
  CONSTRAINT `FKA70D9301CDD2F26` FOREIGN KEY (`catalog_id`) REFERENCES `tb_oa_document_catalog` (`document_catalog_id`),
  CONSTRAINT `FKA70D9306A32B241` FOREIGN KEY (`branch_id`) REFERENCES `tb_sys_branch` (`sys_branch_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_document_catalog_permit`
--

CREATE TABLE tb_oa_document_catalog_permit (
  catalog_id bigint(20) NOT NULL default '0',
  permit_type_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (catalog_id,permit_type_id),
  KEY FK21A537A91CDD2F26 (catalog_id),
  KEY FK21A537A95C0F3416 (permit_type_id),
  CONSTRAINT `FK21A537A91CDD2F26` FOREIGN KEY (`catalog_id`) REFERENCES `tb_oa_document_catalog` (`document_catalog_id`),
  CONSTRAINT `FK21A537A95C0F3416` FOREIGN KEY (`permit_type_id`) REFERENCES `tb_oa_document_catalog_permit_type` (`permit_type_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_document_catalog_permit_type`
--

CREATE TABLE tb_oa_document_catalog_permit_type (
  permit_type_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) default NULL,
  value bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (permit_type_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_document_catalog_role`
--

CREATE TABLE tb_oa_document_catalog_role (
  catalog_id bigint(20) NOT NULL default '0',
  role_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (catalog_id,role_id),
  KEY FK4D4ABF8459B71781 (role_id),
  KEY FK4D4ABF841CDD2F26 (catalog_id),
  CONSTRAINT `FK4D4ABF841CDD2F26` FOREIGN KEY (`catalog_id`) REFERENCES `tb_oa_document_catalog` (`document_catalog_id`),
  CONSTRAINT `FK4D4ABF8459B71781` FOREIGN KEY (`role_id`) REFERENCES `tb_sys_role` (`id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_document_catalog_user`
--

CREATE TABLE tb_oa_document_catalog_user (
  catalog_id bigint(20) NOT NULL default '0',
  user_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (catalog_id,user_id),
  KEY FK4D4C2AD9FEE1DB61 (user_id),
  KEY FK4D4C2AD91CDD2F26 (catalog_id),
  CONSTRAINT `FK4D4C2AD91CDD2F26` FOREIGN KEY (`catalog_id`) REFERENCES `tb_oa_document_catalog` (`document_catalog_id`),
  CONSTRAINT `FK4D4C2AD9FEE1DB61` FOREIGN KEY (`user_id`) REFERENCES `tb_sys_user` (`id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_document_file`
--

CREATE TABLE tb_oa_document_file (
  document_file_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  file_path varchar(255) NOT NULL default '',
  file_name varchar(255) default NULL,
  pic_name varchar(255) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  document_id bigint(20) default NULL,
  PRIMARY KEY  (document_file_id),
  KEY FK6A41DC24EE451813 (document_id),
  CONSTRAINT `FK6A41DC24EE451813` FOREIGN KEY (`document_id`) REFERENCES `tb_oa_document` (`document_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_info`
--

CREATE TABLE tb_oa_info (
  info_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  content text,
  display_times datetime default NULL,
  info_type_id bigint(20) default NULL,
  search_key varchar(32) default NULL,
  title varchar(32) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (info_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_info_type`
--

CREATE TABLE tb_oa_info_type (
  info_type_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) default NULL,
  value bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (info_type_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_product_info`
--

CREATE TABLE tb_oa_product_info (
  product_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  fittings varchar(255) default NULL,
  memo varchar(255) default NULL,
  picture varchar(255) default NULL,
  price double default NULL,
  product_type_id bigint(20) default NULL,
  provider varchar(255) default NULL,
  quantity bigint(20) default NULL,
  stock_date int(11) default NULL,
  stock_user bigint(20) default NULL,
  storage_date int(11) default NULL,
  unit varchar(32) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (product_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_product_type`
--

CREATE TABLE tb_oa_product_type (
  product_type_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) default NULL,
  display_no bigint(20) default NULL,
  node_level bigint(20) default NULL,
  parent_id bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (product_type_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_product_used`
--

CREATE TABLE tb_oa_product_used (
  product_used_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  amends double default NULL,
  attaint bigint(20) default NULL,
  play_return_date datetime default NULL,
  product_id bigint(20) default NULL,
  rel_return_date datetime default NULL,
  return_num bigint(20) default NULL,
  use_date datetime default NULL,
  use_man bigint(20) default NULL,
  use_num bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (product_used_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_scratchpad`
--

CREATE TABLE tb_oa_scratchpad (
  scratchpad_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  content text,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (scratchpad_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_tel_expenses`
--

CREATE TABLE tb_oa_tel_expenses (
  id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  tele_expenses double NOT NULL default '0',
  register_date int(11) NOT NULL default '0',
  branch_id bigint(20) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (id),
  KEY FK91CD4C3B6A32B241 (branch_id),
  CONSTRAINT `FK91CD4C3B6A32B241` FOREIGN KEY (`branch_id`) REFERENCES `tb_sys_branch` (`sys_branch_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_work_flow`
--

CREATE TABLE tb_oa_work_flow (
  work_flow_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(20) default NULL,
  display_no bigint(20) default NULL,
  node_level bigint(20) default NULL,
  parent_id varchar(32) default NULL,
  agree_flow_id bigint(20) default NULL,
  dissent_flow_id bigint(20) default NULL,
  is_first_point char(1) default NULL,
  is_end_point char(1) default NULL,
  move_type_id bigint(20) default NULL,
  work_flow_type_id bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (work_flow_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_work_flow_check`
--

CREATE TABLE tb_oa_work_flow_check (
  work_flow_check_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  check_idea varchar(255) default NULL,
  check_user_id bigint(20) default NULL,
  work_flow_type_id bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  check_state_id bigint(20) default NULL,
  work_flow_id bigint(20) default NULL,
  PRIMARY KEY  (work_flow_check_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_work_flow_check_result`
--

CREATE TABLE tb_oa_work_flow_check_result (
  check_result_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) default NULL,
  value bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (check_result_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_work_flow_check_role`
--

CREATE TABLE tb_oa_work_flow_check_role (
  work_flow_id bigint(20) NOT NULL default '0',
  role_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (work_flow_id,role_id),
  KEY FKCC07ED4C59B71781 (role_id),
  KEY FKCC07ED4CE1B8D2B6 (work_flow_id),
  CONSTRAINT `FKCC07ED4C59B71781` FOREIGN KEY (`role_id`) REFERENCES `tb_sys_role` (`id`),
  CONSTRAINT `FKCC07ED4CE1B8D2B6` FOREIGN KEY (`work_flow_id`) REFERENCES `tb_oa_work_flow` (`work_flow_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_work_flow_check_state`
--

CREATE TABLE tb_oa_work_flow_check_state (
  check_state_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) default NULL,
  value bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (check_state_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_work_flow_check_user`
--

CREATE TABLE tb_oa_work_flow_check_user (
  work_flow_id bigint(20) NOT NULL default '0',
  user_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (work_flow_id,user_id),
  KEY FKCC0958A1FEE1DB61 (user_id),
  KEY FKCC0958A1E1B8D2B6 (work_flow_id),
  CONSTRAINT `FKCC0958A1E1B8D2B6` FOREIGN KEY (`work_flow_id`) REFERENCES `tb_oa_work_flow` (`work_flow_id`),
  CONSTRAINT `FKCC0958A1FEE1DB61` FOREIGN KEY (`user_id`) REFERENCES `tb_sys_user` (`id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_work_flow_comin_user`
--

CREATE TABLE tb_oa_work_flow_comin_user (
  work_flow_id bigint(20) NOT NULL default '0',
  user_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (work_flow_id,user_id),
  KEY FK5B75B603FEE1DB61 (user_id),
  KEY FK5B75B603E1B8D2B6 (work_flow_id),
  CONSTRAINT `FK5B75B603E1B8D2B6` FOREIGN KEY (`work_flow_id`) REFERENCES `tb_oa_work_flow` (`work_flow_id`),
  CONSTRAINT `FK5B75B603FEE1DB61` FOREIGN KEY (`user_id`) REFERENCES `tb_sys_user` (`id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_work_flow_move_type`
--

CREATE TABLE tb_oa_work_flow_move_type (
  move_type_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) default NULL,
  value bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (move_type_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_work_flow_result_apply`
--

CREATE TABLE tb_oa_work_flow_result_apply (
  work_flow_check_id bigint(20) NOT NULL default '0',
  checked int(11) NOT NULL default '0',
  apply_info_id int(11) NOT NULL default '0',
  PRIMARY KEY  (work_flow_check_id,apply_info_id),
  KEY FK4E5150B198592C5 (work_flow_check_id),
  CONSTRAINT `FK4E5150B198592C5` FOREIGN KEY (`work_flow_check_id`) REFERENCES `tb_oa_work_flow_check` (`work_flow_check_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_work_flow_result_contract`
--

CREATE TABLE tb_oa_work_flow_result_contract (
  work_flow_check_id bigint(20) NOT NULL default '0',
  checked int(11) NOT NULL default '0',
  contract_id int(11) NOT NULL default '0',
  PRIMARY KEY  (work_flow_check_id,contract_id),
  KEY FK366D3E55198592C5 (work_flow_check_id),
  CONSTRAINT `FK366D3E55198592C5` FOREIGN KEY (`work_flow_check_id`) REFERENCES `tb_oa_work_flow_check` (`work_flow_check_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_work_flow_result_order`
--

CREATE TABLE tb_oa_work_flow_result_order (
  work_flow_check_id bigint(20) NOT NULL default '0',
  checked int(11) NOT NULL default '0',
  order_id int(11) NOT NULL default '0',
  PRIMARY KEY  (work_flow_check_id,order_id),
  KEY FK5AB18EB198592C5 (work_flow_check_id),
  CONSTRAINT `FK5AB18EB198592C5` FOREIGN KEY (`work_flow_check_id`) REFERENCES `tb_oa_work_flow_check` (`work_flow_check_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_oa_work_flow_type`
--

CREATE TABLE tb_oa_work_flow_type (
  work_flow_type_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  display_no bigint(20) default NULL,
  node_level bigint(20) default NULL,
  parent_id bigint(20) default NULL,
  name varchar(32) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (work_flow_type_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_order`
--

CREATE TABLE tb_order (
  order_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  order_code varchar(32) default NULL,
  relation_code varchar(32) default NULL,
  contract_id bigint(20) default NULL,
  order_category_id varchar(32) default NULL,
  user_id bigint(20) default NULL,
  order_meno text,
  is_ckecked bigint(20) NOT NULL default '0',
  publish_memo text,
  contract_payment_id bigint(20) NOT NULL default '0',
  customer_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (order_id),
  KEY FKFA98EE3D9F77E301 (customer_id),
  CONSTRAINT `FKFA98EE3D9F77E301` FOREIGN KEY (`customer_id`) REFERENCES `tb_customer_info` (`customer_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_order_category`
--

CREATE TABLE tb_order_category (
  order_category_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(128) default NULL,
  parent_id varchar(32) default NULL,
  node_level int(11) default NULL,
  node_path varchar(128) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  value char(2) NOT NULL default '',
  calculate_auto int(11) default NULL,
  displayNo int(11) default NULL,
  PRIMARY KEY  (order_category_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_order_day_info`
--

CREATE TABLE tb_order_day_info (
  order_day_info_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  publish_date int(11) NOT NULL default '0',
  day_rel_income double NOT NULL default '0',
  ad_day_times int(11) NOT NULL default '0',
  is_published int(11) NOT NULL default '0',
  contract_id bigint(20) default NULL,
  order_id bigint(20) default NULL,
  order_detail_id bigint(20) default NULL,
  day_rel_puton double NOT NULL default '0',
  PRIMARY KEY  (order_day_info_id),
  KEY FK65907333E8EA45F0 (order_detail_id),
  KEY FK659073333673B653 (order_id),
  CONSTRAINT `FK659073333673B653` FOREIGN KEY (`order_id`) REFERENCES `tb_order` (`order_id`),
  CONSTRAINT `FK65907333E8EA45F0` FOREIGN KEY (`order_detail_id`) REFERENCES `tb_order_detail` (`order_detail_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_order_detail`
--

CREATE TABLE tb_order_detail (
  order_detail_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  order_id bigint(20) NOT NULL default '0',
  order_category_id varchar(32) default NULL,
  ad_resource_type int(11) default NULL,
  ad_resource_info_id bigint(20) default NULL,
  ad_resource_specific_id bigint(20) default NULL,
  adver_matter_type int(11) default NULL,
  adver_matter_id bigint(20) default NULL,
  matter_length varchar(32) default NULL,
  customer_industry_type_id bigint(20) default NULL,
  publish_memo varchar(32) default NULL,
  ad_resource_price_type bigint(20) NOT NULL default '0',
  sys_price double NOT NULL default '0',
  exec_price double NOT NULL default '0',
  app_rate double NOT NULL default '0',
  favour_rate double NOT NULL default '0',
  money_balance double NOT NULL default '0',
  money_realpay double NOT NULL default '0',
  is_ckecked bigint(20) NOT NULL default '0',
  need_publish int(11) NOT NULL default '0',
  parent_id bigint(20) NOT NULL default '0',
  resource_sort_id bigint(20) default NULL,
  age_rate double NOT NULL default '0',
  compages_id bigint(20) default NULL,
  memo varchar(128) default NULL,
  is_space_adver char(1) default NULL,
  PRIMARY KEY  (order_detail_id),
  KEY FKD4A118933673B653 (order_id),
  CONSTRAINT `FKD4A118933673B653` FOREIGN KEY (`order_id`) REFERENCES `tb_order` (`order_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_order_log`
--

CREATE TABLE tb_order_log (
  order_log_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  order_id bigint(20) default NULL,
  operate_model int(11) default NULL,
  operate_model_function int(11) default NULL,
  operate_type int(11) default NULL,
  link_path text,
  client_ip text,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (order_log_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_published_arrang`
--

CREATE TABLE tb_published_arrang (
  arrange_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  carrier_name varchar(20) default NULL,
  file_path varchar(128) default NULL,
  is_enable char(1) default NULL,
  is_locked char(1) default NULL,
  publish_date int(11) NOT NULL default '0',
  resource_id bigint(20) default NULL,
  resource_meno varchar(128) default NULL,
  resource_name varchar(20) default NULL,
  resource_total_times int(11) default NULL,
  resource_used_times int(11) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  memo text,
  carrier_id bigint(20) default NULL,
  is_arranged char(1) default NULL,
  PRIMARY KEY  (arrange_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_published_arrang_detail`
--

CREATE TABLE tb_published_arrang_detail (
  arrange_detail_id bigint(20) NOT NULL auto_increment,
  publish_sort int(11) default NULL,
  specific_value char(2) default NULL,
  order_day_info_id bigint(20) default NULL,
  customer_name varchar(50) default NULL,
  tape_code varchar(20) default NULL,
  matter_edit varchar(50) default NULL,
  matter_length varchar(10) default NULL,
  matter_name varchar(50) default NULL,
  specific_name varchar(10) default NULL,
  adver_times int(11) default NULL,
  owner_user_name varchar(20) default NULL,
  publish_memo varchar(20) default NULL,
  arrange_id bigint(20) default NULL,
  PRIMARY KEY  (arrange_detail_id),
  KEY FK45750C15574CC2F2 (arrange_id),
  CONSTRAINT `FK45750C15574CC2F2` FOREIGN KEY (`arrange_id`) REFERENCES `tb_published_arrang` (`arrange_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_sys_branch`
--

CREATE TABLE tb_sys_branch (
  sys_branch_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) NOT NULL default '',
  sys_org_id bigint(20) default NULL,
  parent_id varchar(32) default NULL,
  tree_level int(11) default NULL,
  display_no int(11) NOT NULL default '0',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (sys_branch_id),
  KEY FK10DB29C54425F685 (sys_org_id),
  CONSTRAINT `FK10DB29C54425F685` FOREIGN KEY (`sys_org_id`) REFERENCES `tb_sys_org` (`sys_org_id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_sys_event_state`
--

CREATE TABLE tb_sys_event_state (
  enent_state_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) default NULL,
  value bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (enent_state_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_sys_event_type`
--

CREATE TABLE tb_sys_event_type (
  enent_type_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) default NULL,
  value bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (enent_type_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_sys_menu`
--

CREATE TABLE tb_sys_menu (
  sys_menu_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) NOT NULL default '',
  parent_id bigint(20) default NULL,
  tree_level int(11) default NULL,
  display_no int(11) NOT NULL default '0',
  action varchar(50) default NULL,
  alt_image varchar(255) default NULL,
  description varchar(255) default NULL,
  forward varchar(255) default NULL,
  height varchar(255) default NULL,
  image varchar(255) default NULL,
  location varchar(255) default NULL,
  onclick varchar(255) default NULL,
  onmouseout varchar(255) default NULL,
  onmouseover varchar(255) default NULL,
  page_num varchar(255) default NULL,
  roles varchar(255) default NULL,
  target varchar(255) default NULL,
  title varchar(255) default NULL,
  tooltip varchar(255) default NULL,
  width varchar(255) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  is_display char(1) default NULL,
  PRIMARY KEY  (sys_menu_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_sys_org`
--

CREATE TABLE tb_sys_org (
  sys_org_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(255) default NULL,
  bank_code varchar(32) default NULL,
  bank_name varchar(128) default NULL,
  fax varchar(128) default NULL,
  link_man varchar(32) default NULL,
  tel varchar(255) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  address varchar(150) default NULL,
  city varchar(50) NOT NULL default '',
  province varchar(100) default NULL,
  country varchar(100) default NULL,
  postal_code varchar(15) NOT NULL default '',
  report_title varchar(128) default NULL,
  PRIMARY KEY  (sys_org_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_sys_param`
--

CREATE TABLE tb_sys_param (
  id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(128) NOT NULL default '',
  memo text,
  value varchar(128) NOT NULL default '',
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_sys_prompt_mode`
--

CREATE TABLE tb_sys_prompt_mode (
  prompt_mode_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) default NULL,
  value bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (prompt_mode_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_sys_resource`
--

CREATE TABLE tb_sys_resource (
  id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(128) default NULL,
  res_type varchar(128) default NULL,
  res_string text,
  memo text,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_sys_resource_role`
--

CREATE TABLE tb_sys_resource_role (
  resource_id bigint(20) NOT NULL default '0',
  role_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (resource_id,role_id),
  KEY FKE6336C8459B71781 (role_id),
  KEY FKE6336C8490C7DD80 (resource_id),
  CONSTRAINT `FKE6336C8459B71781` FOREIGN KEY (`role_id`) REFERENCES `tb_sys_role` (`id`),
  CONSTRAINT `FKE6336C8490C7DD80` FOREIGN KEY (`resource_id`) REFERENCES `tb_sys_resource` (`id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_sys_role`
--

CREATE TABLE tb_sys_role (
  id bigint(20) NOT NULL auto_increment,
  name varchar(20) default NULL,
  lable varchar(32) default NULL,
  description varchar(64) default NULL,
  PRIMARY KEY  (id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_sys_sequence`
--

CREATE TABLE tb_sys_sequence (
  sequence_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(50) default NULL,
  prefix varchar(50) default NULL,
  start_no bigint(20) default NULL,
  increment_no bigint(20) default NULL,
  format varchar(255) default NULL,
  current_next bigint(20) default NULL,
  current_next_sys bigint(20) default NULL,
  suffix varchar(255) default NULL,
  PRIMARY KEY  (sequence_id)
) TYPE=InnoDB;

--
-- Table structure for table `tb_sys_user`
--

CREATE TABLE tb_sys_user (
  id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  username varchar(50) NOT NULL default '',
  password varchar(255) NOT NULL default '',
  password_hint varchar(255) default NULL,
  first_name varchar(50) NOT NULL default '',
  last_name varchar(50) NOT NULL default '',
  email varchar(255) NOT NULL default '',
  phone_number varchar(255) default NULL,
  website varchar(255) default NULL,
  address varchar(150) default NULL,
  city varchar(50) NOT NULL default '',
  province varchar(100) default NULL,
  country varchar(100) default NULL,
  postal_code varchar(15) NOT NULL default '',
  account_expired char(1) default NULL,
  account_locked char(1) default NULL,
  credentials_expired char(1) default NULL,
  account_enabled char(1) default NULL,
  PRIMARY KEY  (id),
  UNIQUE KEY username (username),
  UNIQUE KEY email (email)
) TYPE=InnoDB;

--
-- Table structure for table `tb_sys_user_branch`
--

CREATE TABLE tb_sys_user_branch (
  branch_id bigint(20) NOT NULL default '0',
  user_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (branch_id,user_id),
  KEY FKA1588653FEE1DB61 (user_id),
  KEY FKA15886536A32B241 (branch_id),
  CONSTRAINT `FKA15886536A32B241` FOREIGN KEY (`branch_id`) REFERENCES `tb_sys_branch` (`sys_branch_id`),
  CONSTRAINT `FKA1588653FEE1DB61` FOREIGN KEY (`user_id`) REFERENCES `tb_sys_user` (`id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_sys_user_carrier_rel`
--

CREATE TABLE tb_sys_user_carrier_rel (
  user_id bigint(20) NOT NULL default '0',
  carrier_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (user_id,carrier_id),
  KEY FKBF7BF0C1FEE1DB61 (user_id),
  KEY FKBF7BF0C1D45F2BD3 (carrier_id),
  CONSTRAINT `FKBF7BF0C1D45F2BD3` FOREIGN KEY (`carrier_id`) REFERENCES `tb_ad_resource_carrier` (`ad_resource_carrier_id`),
  CONSTRAINT `FKBF7BF0C1FEE1DB61` FOREIGN KEY (`user_id`) REFERENCES `tb_sys_user` (`id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_sys_user_rel`
--

CREATE TABLE tb_sys_user_rel (
  parent_user_id bigint(20) NOT NULL default '0',
  user_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (parent_user_id,user_id),
  KEY FK385E7D88E0640CC (parent_user_id),
  KEY FK385E7D88FEE1DB61 (user_id),
  CONSTRAINT `FK385E7D88E0640CC` FOREIGN KEY (`parent_user_id`) REFERENCES `tb_sys_user` (`id`),
  CONSTRAINT `FK385E7D88FEE1DB61` FOREIGN KEY (`user_id`) REFERENCES `tb_sys_user` (`id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_sys_user_role`
--

CREATE TABLE tb_sys_user_role (
  user_id bigint(20) NOT NULL default '0',
  role_id bigint(20) NOT NULL default '0',
  PRIMARY KEY  (user_id,role_id),
  KEY FKD3715967FEE1DB61 (user_id),
  KEY FKD371596759B71781 (role_id),
  CONSTRAINT `FKD371596759B71781` FOREIGN KEY (`role_id`) REFERENCES `tb_sys_role` (`id`),
  CONSTRAINT `FKD3715967FEE1DB61` FOREIGN KEY (`user_id`) REFERENCES `tb_sys_user` (`id`)
) TYPE=InnoDB;

--
-- Table structure for table `tb_sys_user_type`
--

CREATE TABLE tb_sys_user_type (
  sys_user_type_id bigint(20) NOT NULL auto_increment,
  version int(11) NOT NULL default '0',
  name varchar(32) default NULL,
  value bigint(20) default NULL,
  create_by bigint(20) default NULL,
  create_date datetime default NULL,
  modify_by bigint(20) default NULL,
  modify_date datetime default NULL,
  PRIMARY KEY  (sys_user_type_id)
) TYPE=InnoDB;

