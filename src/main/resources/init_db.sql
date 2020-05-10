CREATE SCHEMA `internet_shop` DEFAULT CHARACTER SET utf8 ;
CREATE TABLE `internet_shop`.`products` (
  `product_id` BIGINT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(225) CHARACTER SET 'utf8' COLLATE 'utf8_general_ci' NOT NULL,
  `product_price` DECIMAL(19,4) UNSIGNED NOT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE INDEX `product_name_UNIQUE` (`product_name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
ALTER TABLE `internet_shop`.`products`
CHANGE COLUMN `product_price` `product_price` DECIMAL(19,2) UNSIGNED NOT NULL ;