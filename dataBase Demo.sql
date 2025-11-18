CREATE DATABASE `OpenCart_demo`
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE `OpenCart_demo`; 

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE oc_Language ( 
  language_id    INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name           VARCHAR(64) NOT NULL,
  code           VARCHAR(5)  NOT NULL,    
  locale         VARCHAR(255) DEFAULT NULL,
  status         TINYINT(1)  NOT NULL DEFAULT 1,
  sort_order     INT NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS oc_Currency (
  currency_id    INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  title          VARCHAR(32) NOT NULL,
  code           VARCHAR(3)  NOT NULL,     
  symbol_left    VARCHAR(12) DEFAULT NULL,
  symbol_right   VARCHAR(12) DEFAULT NULL,
  decimal_place  TINYINT NOT NULL DEFAULT 2,
  value          DECIMAL(15,8) NOT NULL DEFAULT 1.00000000,
  status         TINYINT(1) NOT NULL DEFAULT 1,
  date_modified  DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS oc_customer (
  customer_id   INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  customer_group_id INT UNSIGNED DEFAULT 1,
  store_id      INT UNSIGNED DEFAULT 0,
  language_id   INT UNSIGNED DEFAULT NULL,
  firstname     VARCHAR(32) NOT NULL,
  lastname      VARCHAR(32) NOT NULL,
  email         VARCHAR(96) NOT NULL UNIQUE,
  telephone     VARCHAR(32) DEFAULT NULL,
  password      VARCHAR(255) DEFAULT NULL,
  salt          VARCHAR(32) DEFAULT NULL,
  newsletter    TINYINT(1) NOT NULL DEFAULT 0,
  address_id    INT UNSIGNED DEFAULT NULL,   
  status        TINYINT(1) NOT NULL DEFAULT 1,
  safe          TINYINT(1) NOT NULL DEFAULT 0,
  ip            VARCHAR(40) DEFAULT NULL,
  date_added    DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  date_modified DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT fk_customer_lang FOREIGN KEY (language_id) REFERENCES oc_language(language_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS oc_address (
  address_id   INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  customer_id  INT UNSIGNED NOT NULL,
  firstname    VARCHAR(32) NOT NULL,
  lastname     VARCHAR(32) NOT NULL,
  company      VARCHAR(40) DEFAULT NULL,
  address_1    VARCHAR(128) NOT NULL,
  address_2    VARCHAR(128) DEFAULT NULL,
  city         VARCHAR(128) NOT NULL,
  postcode     VARCHAR(10) DEFAULT NULL,
  country      VARCHAR(128) DEFAULT NULL,
  zone         VARCHAR(128) DEFAULT NULL,
  custom_field JSON DEFAULT NULL,
  CONSTRAINT fk_address_customer FOREIGN KEY (customer_id) REFERENCES oc_customer(customer_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE oc_customer
  ADD CONSTRAINT fk_customer_default_address
  FOREIGN KEY (address_id) REFERENCES oc_address(address_id)
  ON DELETE SET NULL;

CREATE TABLE IF NOT EXISTS oc_session (
  session_id   VARCHAR(64) PRIMARY KEY,
  data         MEDIUMTEXT,
  expire       INT UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS oc_category (
  category_id  INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  parent_id    INT UNSIGNED NOT NULL DEFAULT 0,
  top          TINYINT(1) NOT NULL DEFAULT 0,
  `column`     INT NOT NULL DEFAULT 1,
  sort_order   INT NOT NULL DEFAULT 0,
  status       TINYINT(1) NOT NULL DEFAULT 1,
  date_added   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  date_modified DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  INDEX idx_parent (parent_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS oc_category_description (
  category_id  INT UNSIGNED NOT NULL,
  language_id  INT UNSIGNED NOT NULL,
  name         VARCHAR(255) NOT NULL,
  description  MEDIUMTEXT,
  meta_title   VARCHAR(255) DEFAULT NULL,
  meta_description VARCHAR(255) DEFAULT NULL,
  meta_keyword VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (category_id, language_id),
  CONSTRAINT fk_catdesc_cat FOREIGN KEY (category_id) REFERENCES oc_category(category_id) ON DELETE CASCADE,
  CONSTRAINT fk_catdesc_lang FOREIGN KEY (language_id) REFERENCES oc_language(language_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS oc_product (
  product_id    INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  model         VARCHAR(64) NOT NULL,
  sku           VARCHAR(64) DEFAULT NULL,
  upc           VARCHAR(12) DEFAULT NULL,
  ean           VARCHAR(14) DEFAULT NULL,
  jan           VARCHAR(13) DEFAULT NULL,
  isbn          VARCHAR(17) DEFAULT NULL,
  mpn           VARCHAR(64) DEFAULT NULL,
  quantity      INT NOT NULL DEFAULT 0,
  stock_status_id INT UNSIGNED DEFAULT 0,
  image         VARCHAR(255) DEFAULT NULL,
  price         DECIMAL(15,4) NOT NULL DEFAULT 0.0000,
  tax_class_id  INT UNSIGNED DEFAULT 0,
  date_available DATE DEFAULT NULL,
  weight        DECIMAL(15,8) DEFAULT 0,
  length        DECIMAL(15,8) DEFAULT 0,
  width         DECIMAL(15,8) DEFAULT 0,
  height        DECIMAL(15,8) DEFAULT 0,
  subtract      TINYINT(1) NOT NULL DEFAULT 1, 
  minimum       INT NOT NULL DEFAULT 1,
  sort_order    INT NOT NULL DEFAULT 0,
  status        TINYINT(1) NOT NULL DEFAULT 1,
  date_added    DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  date_modified DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS oc_product_description (
  product_id   INT UNSIGNED NOT NULL,
  language_id  INT UNSIGNED NOT NULL,
  name         VARCHAR(255) NOT NULL,
  description  MEDIUMTEXT,
  tag          VARCHAR(255) DEFAULT NULL,
  meta_title   VARCHAR(255) DEFAULT NULL,
  meta_description VARCHAR(255) DEFAULT NULL,
  meta_keyword VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (product_id, language_id),
  CONSTRAINT fk_pdesc_prod FOREIGN KEY (product_id) REFERENCES oc_product(product_id) ON DELETE CASCADE,
  CONSTRAINT fk_pdesc_lang FOREIGN KEY (language_id) REFERENCES oc_language(language_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS oc_product_to_category (
  product_id  INT UNSIGNED NOT NULL,
  category_id INT UNSIGNED NOT NULL,
  PRIMARY KEY (product_id, category_id),
  CONSTRAINT fk_ptc_prod FOREIGN KEY (product_id) REFERENCES oc_product(product_id) ON DELETE CASCADE,
  CONSTRAINT fk_ptc_cat FOREIGN KEY (category_id) REFERENCES oc_category(category_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS oc_seo_url (
  seo_url_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  store_id   INT UNSIGNED NOT NULL DEFAULT 0,
  language_id INT UNSIGNED NOT NULL,
  query      VARCHAR(255) NOT NULL,     
  keyword    VARCHAR(255) NOT NULL,     
  CONSTRAINT fk_seo_lang FOREIGN KEY (language_id) REFERENCES oc_language(language_id),
  UNIQUE KEY uq_store_lang_keyword (store_id, language_id, keyword)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS oc_option (
  option_id   INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  type        VARCHAR(32) NOT NULL, 
  sort_order  INT NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS oc_option_description (
  option_id   INT UNSIGNED NOT NULL,
  language_id INT UNSIGNED NOT NULL,
  name        VARCHAR(128) NOT NULL,
  PRIMARY KEY (option_id, language_id),
  CONSTRAINT fk_optdesc_opt FOREIGN KEY (option_id) REFERENCES oc_option(option_id) ON DELETE CASCADE,
  CONSTRAINT fk_optdesc_lang FOREIGN KEY (language_id) REFERENCES oc_language(language_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS oc_option_value (
  option_value_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  option_id       INT UNSIGNED NOT NULL,
  image           VARCHAR(255) DEFAULT NULL,
  sort_order      INT NOT NULL DEFAULT 0,
  CONSTRAINT fk_optval_opt FOREIGN KEY (option_id) REFERENCES oc_option(option_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS oc_option_value_description (
  option_value_id INT UNSIGNED NOT NULL,
  language_id     INT UNSIGNED NOT NULL,
  option_id       INT UNSIGNED NOT NULL,
  name            VARCHAR(128) NOT NULL,
  PRIMARY KEY (option_value_id, language_id),
  CONSTRAINT fk_ovd_optval FOREIGN KEY (option_value_id) REFERENCES oc_option_value(option_value_id) ON DELETE CASCADE,
  CONSTRAINT fk_ovd_lang FOREIGN KEY (language_id) REFERENCES oc_language(language_id),
  CONSTRAINT fk_ovd_opt FOREIGN KEY (option_id) REFERENCES oc_option(option_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS oc_product_option (
  product_option_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  product_id        INT UNSIGNED NOT NULL,
  option_id         INT UNSIGNED NOT NULL,
  required          TINYINT(1) NOT NULL DEFAULT 0,
  CONSTRAINT fk_popt_prod FOREIGN KEY (product_id) REFERENCES oc_product(product_id) ON DELETE CASCADE,
  CONSTRAINT fk_popt_opt FOREIGN KEY (option_id) REFERENCES oc_option(option_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS oc_product_option_value (
  product_option_value_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  product_option_id       INT UNSIGNED NOT NULL,
  product_id              INT UNSIGNED NOT NULL,
  option_id               INT UNSIGNED NOT NULL,
  option_value_id         INT UNSIGNED NOT NULL,
  quantity                INT NOT NULL DEFAULT 0,
  subtract                TINYINT(1) NOT NULL DEFAULT 1,
  price                   DECIMAL(15,4) NOT NULL DEFAULT 0.0000,
  price_prefix            CHAR(1) NOT NULL DEFAULT '+',
  weight                  DECIMAL(15,8) NOT NULL DEFAULT 0,
  weight_prefix           CHAR(1) NOT NULL DEFAULT '+',
  CONSTRAINT fk_pov_popt FOREIGN KEY (product_option_id) REFERENCES oc_product_option(product_option_id) ON DELETE CASCADE,
  CONSTRAINT fk_pov_prod FOREIGN KEY (product_id) REFERENCES oc_product(product_id) ON DELETE CASCADE,
  CONSTRAINT fk_pov_opt FOREIGN KEY (option_id) REFERENCES oc_option(option_id) ON DELETE CASCADE,
  CONSTRAINT fk_pov_optval FOREIGN KEY (option_value_id) REFERENCES oc_option_value(option_value_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS oc_cart (
  cart_id     INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  customer_id INT UNSIGNED DEFAULT NULL,
  session_id  VARCHAR(64) DEFAULT NULL,
  product_id  INT UNSIGNED NOT NULL,
  quantity    INT NOT NULL DEFAULT 1,
  option_data JSON DEFAULT NULL, 
  date_added  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  date_modified DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT fk_cart_customer FOREIGN KEY (customer_id) REFERENCES oc_customer(customer_id) ON DELETE CASCADE,
  CONSTRAINT fk_cart_product FOREIGN KEY (product_id) REFERENCES oc_product(product_id) ON DELETE CASCADE,
  INDEX idx_cart_session (session_id),
  INDEX idx_cart_customer (customer_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS oc_order_status (
  order_status_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  language_id     INT UNSIGNED NOT NULL,
  name            VARCHAR(32) NOT NULL,
  CONSTRAINT fk_ostatus_lang FOREIGN KEY (language_id) REFERENCES oc_language(language_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS oc_order ( 
  order_id         INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  invoice_prefix   VARCHAR(26) DEFAULT 'INV-',
  store_id         INT UNSIGNED NOT NULL DEFAULT 0,
  customer_id      INT UNSIGNED DEFAULT NULL,
  firstname        VARCHAR(32) NOT NULL,
  lastname         VARCHAR(32) NOT NULL,
  email            VARCHAR(96) NOT NULL,
  telephone        VARCHAR(32) DEFAULT NULL,
  payment_method   VARCHAR(128) DEFAULT NULL,
  shipping_method  VARCHAR(128) DEFAULT NULL,
  total            DECIMAL(15,4) NOT NULL DEFAULT 0.0000,
  order_status_id  INT UNSIGNED NOT NULL DEFAULT 0,
  currency_code    VARCHAR(3) DEFAULT 'USD',
  currency_value   DECIMAL(15,8) NOT NULL DEFAULT 1.00000000,
  comment          TEXT,
  date_added       DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  date_modified    DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT fk_order_customer FOREIGN KEY (customer_id) REFERENCES oc_customer(customer_id) ON DELETE SET NULL,
  CONSTRAINT fk_order_status FOREIGN KEY (order_status_id) REFERENCES oc_order_status(order_status_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS oc_order_product (
  order_product_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  order_id         INT UNSIGNED NOT NULL,
  product_id       INT UNSIGNED NOT NULL,
  name             VARCHAR(255) NOT NULL,
  model            VARCHAR(64) DEFAULT NULL,
  quantity         INT NOT NULL DEFAULT 1,
  price            DECIMAL(15,4) NOT NULL DEFAULT 0.0000,
  total            DECIMAL(15,4) NOT NULL DEFAULT 0.0000,
  tax              DECIMAL(15,4) NOT NULL DEFAULT 0.0000,
  CONSTRAINT fk_op_order FOREIGN KEY (order_id) REFERENCES oc_order(order_id) ON DELETE CASCADE,
  CONSTRAINT fk_op_product FOREIGN KEY (product_id) REFERENCES oc_product(product_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS oc_order_option (
  order_option_id  INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  order_id         INT UNSIGNED NOT NULL,
  order_product_id INT UNSIGNED NOT NULL,
  product_option_id INT UNSIGNED DEFAULT NULL,
  name             VARCHAR(255) NOT NULL,
  `value`          VARCHAR(255) NOT NULL,
  CONSTRAINT fk_oo_order FOREIGN KEY (order_id) REFERENCES oc_order(order_id) ON DELETE CASCADE,
  CONSTRAINT fk_oo_op FOREIGN KEY (order_product_id) REFERENCES oc_order_product(order_product_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS oc_order_total (
  order_total_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  order_id       INT UNSIGNED NOT NULL,
  code           VARCHAR(32) NOT NULL,   
  title          VARCHAR(255) NOT NULL,
  `value`        DECIMAL(15,4) NOT NULL DEFAULT 0.0000,
  sort_order     INT NOT NULL DEFAULT 0,
  CONSTRAINT fk_ot_order FOREIGN KEY (order_id) REFERENCES oc_order(order_id) ON DELETE CASCADE,
  INDEX idx_ot_code (code),
  INDEX idx_ot_sort (sort_order)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS oc_order_history (
  order_history_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  order_id         INT UNSIGNED NOT NULL,
  order_status_id  INT UNSIGNED NOT NULL,
  notify           TINYINT(1) NOT NULL DEFAULT 0,
  comment          TEXT,
  date_added       DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_oh_order FOREIGN KEY (order_id) REFERENCES oc_order(order_id) ON DELETE CASCADE,
  CONSTRAINT fk_oh_status FOREIGN KEY (order_status_id) REFERENCES oc_order_status(order_status_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS oc_coupon_history (
  coupon_history_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  coupon_id         INT UNSIGNED DEFAULT NULL,
  order_id          INT UNSIGNED NOT NULL,
  customer_id       INT UNSIGNED DEFAULT NULL,
  amount            DECIMAL(15,4) NOT NULL DEFAULT 0.0000,
  date_added        DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_ch_order FOREIGN KEY (order_id) REFERENCES oc_order(order_id) ON DELETE CASCADE,
  CONSTRAINT fk_ch_customer FOREIGN KEY (customer_id) REFERENCES oc_customer(customer_id) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS oc_review (
  review_id    INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  product_id   INT UNSIGNED NOT NULL,
  customer_id  INT UNSIGNED DEFAULT NULL,
  author       VARCHAR(64) NOT NULL,
  text         TEXT,
  rating       TINYINT NOT NULL DEFAULT 0,
  status       TINYINT(1) NOT NULL DEFAULT 0, 
  date_added   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  date_modified DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT fk_review_product FOREIGN KEY (product_id) REFERENCES oc_product(product_id) ON DELETE CASCADE,
  CONSTRAINT fk_review_customer FOREIGN KEY (customer_id) REFERENCES oc_customer(customer_id) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS oc_return_reason (
  return_reason_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  language_id      INT UNSIGNED NOT NULL,
  name             VARCHAR(128) NOT NULL,
  CONSTRAINT fk_rreason_lang FOREIGN KEY (language_id) REFERENCES oc_language(language_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS oc_return_status (
  return_status_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  language_id      INT UNSIGNED NOT NULL,
  name             VARCHAR(128) NOT NULL,
  CONSTRAINT fk_rstatus_lang FOREIGN KEY (language_id) REFERENCES oc_language(language_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
 
 
CREATE TABLE IF NOT EXISTS oc_return (
  return_id        INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  order_id         INT UNSIGNED NOT NULL,
  product          VARCHAR(255) NOT NULL,
  model            VARCHAR(64) DEFAULT NULL,
  quantity         INT NOT NULL DEFAULT 1,
  opened           TINYINT(1) NOT NULL DEFAULT 0,
  return_reason_id INT UNSIGNED NOT NULL,
  return_status_id INT UNSIGNED NOT NULL DEFAULT 0,
  comment          TEXT,
  date_added       DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  date_modified    DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  CONSTRAINT fk_return_order FOREIGN KEY (order_id) REFERENCES oc_order(order_id) ON DELETE CASCADE,
  CONSTRAINT fk_return_reason FOREIGN KEY (return_reason_id) REFERENCES oc_return_reason(return_reason_id),
  CONSTRAINT fk_return_status FOREIGN KEY (return_status_id) REFERENCES oc_return_status(return_status_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS oc_return_history (
  return_history_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  return_id         INT UNSIGNED NOT NULL,
  return_status_id  INT UNSIGNED NOT NULL,
  notify            TINYINT(1) NOT NULL DEFAULT 0,
  comment           TEXT,
  date_added        DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_rh_return FOREIGN KEY (return_id) REFERENCES oc_return(return_id) ON DELETE CASCADE,
  CONSTRAINT fk_rh_status FOREIGN KEY (return_status_id) REFERENCES oc_return_status(return_status_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO oc_language (name, code, locale, status, sort_order)
VALUES ('English', 'en-gb', 'en_GB.UTF-8,en_GB,en-gb,english', 1, 1)
ON DUPLICATE KEY UPDATE name=VALUES(name);

INSERT INTO oc_language (name, code, locale, status, sort_order)
VALUES ('Arabic (Egypt)', 'ar-eg', 'ar_EG.UTF-8,ar_EG,ar-eg,arabic', 1, 2)
ON DUPLICATE KEY UPDATE name=VALUES(name);

INSERT INTO oc_order_status (language_id, name)
VALUES (1, 'Pending'), (1, 'Processing'), (1, 'Complete')
ON DUPLICATE KEY UPDATE name=VALUES(name);

INSERT INTO oc_return_reason (language_id, name)
VALUES (1, 'Dead on Arrival'), (1, 'Faulty'), (1, 'Unwanted')
ON DUPLICATE KEY UPDATE name=VALUES(name);


INSERT INTO oc_return_status (language_id, name)
VALUES (1, 'Awaiting Products'), (1, 'Complete'), (1, 'Rejected')
ON DUPLICATE KEY UPDATE name=VALUES(name);

INSERT INTO oc_currency (title, code, symbol_left, symbol_right, decimal_place, value, status)
VALUES ('US Dollar', 'USD', '$', '', 2, 1.00000000, 1),
       ('Euro', 'EUR', '€', '', 2, 1.05000000, 1),
       ('Egyptian Pound', 'EGP', '£', '', 2, 48.00000000, 1)
ON DUPLICATE KEY UPDATE title=VALUES(title), value=VALUES(value);




INSERT INTO oc_category (parent_id, top, `column`, sort_order, status) VALUES (0,1,1,0,1);
INSERT INTO oc_category_description (category_id, language_id, name, description)
SELECT c.category_id, 1, 'Phones', 'Phones category'
FROM oc_category c WHERE c.category_id = LAST_INSERT_ID();

INSERT INTO oc_product (model, quantity, price, status, subtract) VALUES ('IPH-14-PRO', 10, 999.9900, 1, 1);
INSERT INTO oc_product_description (product_id, language_id, name, description)
SELECT p.product_id, 1, 'iPhone 14 Pro', 'Demo product'
FROM oc_product p WHERE p.product_id = LAST_INSERT_ID();

INSERT INTO oc_product_to_category (product_id, category_id)
SELECT p.product_id, (SELECT MIN(category_id) FROM oc_category)
FROM oc_product p ORDER BY p.product_id DESC LIMIT 1;



INSERT INTO oc_option (type, sort_order) VALUES ('select', 0);
SET @opt_id = LAST_INSERT_ID();
INSERT INTO oc_option_description (option_id, language_id, name) VALUES (@opt_id, 1, 'Color');

INSERT INTO oc_option_value (option_id, sort_order) VALUES (@opt_id, 0), (@opt_id, 1);
SET @red_id = LAST_INSERT_ID() - 1;
SET @blue_id = LAST_INSERT_ID();

INSERT INTO oc_option_value_description (option_value_id, language_id, option_id, name)
VALUES (@red_id, 1, @opt_id, 'Red'), (@blue_id, 1, @opt_id, 'Blue');

SET @pid = (SELECT MAX(product_id) FROM oc_product);
INSERT INTO oc_product_option (product_id, option_id, required) VALUES (@pid, @opt_id, 1);
SET @popt = LAST_INSERT_ID();

INSERT INTO oc_product_option_value
(product_option_id, product_id, option_id, option_value_id, quantity, subtract, price, price_prefix, weight, weight_prefix)
VALUES
(@popt, @pid, @opt_id, @red_id, 5, 1, 0.0000, '+', 0, '+'),
(@popt, @pid, @opt_id, @blue_id, 5, 1, 0.0000, '+', 0, '+');

SET FOREIGN_KEY_CHECKS = 1;

