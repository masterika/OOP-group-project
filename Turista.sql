drop database if exists turista;
create database turista;
use turista;


-- ---
-- Globals
-- ---

-- SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
-- SET FOREIGN_KEY_CHECKS=0;

-- ---
-- Table 'users'
-- 
-- ---

DROP TABLE IF EXISTS `users`;
		
CREATE TABLE `users` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `username` VARCHAR(20) NULL,
  `password` VARCHAR(64) NULL,
  `email` VARCHAR(20) NULL,
  `telephone` VARCHAR(20) NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'user_seller'
-- 
-- ---

DROP TABLE IF EXISTS `user_seller`;
		
CREATE TABLE `user_seller` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `user_id` INTEGER NULL,
  `name` VARCHAR(50) NULL,
  `adress` VARCHAR(50) NULL,  
  `identificator` INTEGER NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'seller_hotel'
-- 
-- ---

DROP TABLE IF EXISTS `seller_hotel`;
		
CREATE TABLE `seller_hotel` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `seller_id` INTEGER NULL,    
  `stars` INTEGER NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'user_client'
-- 
-- ---

DROP TABLE IF EXISTS `user_client`;
		
CREATE TABLE `user_client` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `user_id` INTEGER NULL,
  `name` VARCHAR(30) NULL,
  `surname` VARCHAR(40) NULL,  
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'seller_agency'
-- 
-- ---

DROP TABLE IF EXISTS `seller_agency`;
		
CREATE TABLE `seller_agency` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `seller_id` INTEGER NULL,  
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'hotel_rooms'
-- 
-- ---

DROP TABLE IF EXISTS `hotel_rooms`;
		
CREATE TABLE `hotel_rooms` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `hotel_id` INTEGER NULL,
  `room_type` VARCHAR(20) NULL,
  `price` DECIMAL(10) NULL,
  `gallery_id` INTEGER NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'comment'
-- 
-- ---

DROP TABLE IF EXISTS `comment`;
		
CREATE TABLE `comment` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `text` MEDIUMTEXT NULL, 
  `object` INTEGER NULL, -- 1 for hotels, 2 for agencies, 3 for trips
  `object_id` INTEGER NULL, -- hotelis an agencys id USERS IS CXILIDAN!
  `user_id` INTEGER NULL, -- user id of commenter
  PRIMARY KEY (`id`) -- foreign keybi ar davade jer.
);

-- ---
-- Table 'galleries'
-- 
-- ---

DROP TABLE IF EXISTS `galleries`;
		
CREATE TABLE `galleries` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `room_id` INTEGER NULL,
  `picture_id` INTEGER NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'pictures'
-- 
-- ---

DROP TABLE IF EXISTS `pictures`;
		
CREATE TABLE `pictures` (
  `id` INTEGER NULL ,
  `imagefile` MEDIUMBLOB NULL
);

-- ---
-- Table 'agency_trips'
-- 
-- ---

DROP TABLE IF EXISTS `agency_trips`;
		
CREATE TABLE `agency_trips` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `start_date` date NULL,
  `end_date` date NULL,
  `user_id` INTEGER NULL,
  `trip_type` VARCHAR(20) NULL,  
  `trip_name` VARCHAR(20) NULL,  
  `price` DECIMAL NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'locations'
-- 
-- ---

DROP TABLE IF EXISTS `locations`;
		
CREATE TABLE `locations` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `location_name` VARCHAR(20) NULL,
  `user_id` INTEGER NULL,  -- user_id from users table, corresponding to hotel which is meant in location
  `trip_id` INTEGER NULL,
  `period` INTEGER,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'wishlist'
-- 
-- ---

DROP TABLE IF EXISTS `wishlist`;
		
CREATE TABLE `wishlist` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `object_id` INTEGER NULL,
  `user_id` INTEGER NULL, -- mocemuli clientis shesabamisi user_id
  `type` ENUM('hotel','trip') NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'rating'
-- 
-- ---

DROP TABLE IF EXISTS `rating`;
		
CREATE TABLE `rating` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `object_id` INTEGER NULL, -- razec daaratinges
  `user_id` INTEGER NULL, -- vinc mica ratingi imis user_id
  `type` ENUM('hotel_rating','trip_rating','agency_rating') NOT NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'hotel_rating'
-- 
-- ---

DROP TABLE IF EXISTS `hotel_rating`;
		
CREATE TABLE `hotel_rating` (
  `id` INTEGER NULL AUTO_INCREMENT, 
  `user_id` INTEGER NULL,-- ra hotelzec daaratinges
  `rating` INTEGER NULL, -- ra raitingic mices  
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'agency_rating'
-- 
-- ---

DROP TABLE IF EXISTS `agency_rating`;
		
CREATE TABLE `agency_rating` (
  `id` INTEGER NULL AUTO_INCREMENT,  
  `user_id` INTEGER NULL,-- ra agencic daaratinges
  `rating` INTEGER NULL, -- ra raitingic mices  
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'trip_rating'
-- 
-- ---

DROP TABLE IF EXISTS `trip_rating`;
		
CREATE TABLE `trip_rating` (
  `id` INTEGER NULL AUTO_INCREMENT, 
  `user_id` INTEGER NULL,-- ra tripzec daaratinges
  `rating` INTEGER NULL, -- ra raitingic mices  
  PRIMARY KEY (`id`)
);

-- ---
-- Foreign Keys 
-- ---

ALTER TABLE `user_seller` ADD FOREIGN KEY (user_id) REFERENCES `users` (`id`);
ALTER TABLE `seller_hotel` ADD FOREIGN KEY (seller_id) REFERENCES `user_seller` (`id`);
ALTER TABLE `user_client` ADD FOREIGN KEY (user_id) REFERENCES `users` (`id`);
ALTER TABLE `seller_agency` ADD FOREIGN KEY (seller_id) REFERENCES `user_seller` (`id`);
ALTER TABLE `hotel_rooms` ADD FOREIGN KEY (hotel_id) REFERENCES `seller_hotel` (`id`);
ALTER TABLE `galleries` ADD FOREIGN KEY (room_id) REFERENCES `hotel_rooms` (`id`);
ALTER TABLE `agency_trips` ADD FOREIGN KEY (user_id) REFERENCES `users` (`id`);
ALTER TABLE `locations` ADD FOREIGN KEY (user_id) REFERENCES `users` (`id`);
ALTER TABLE `locations` ADD FOREIGN KEY (trip_id) REFERENCES `agency_trips` (`id`);
ALTER TABLE `wishlist` ADD FOREIGN KEY (user_id) REFERENCES `users` (`id`);

-- ---
-- Table Properties
-- ---

-- ALTER TABLE `users` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `user_hotel` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `user_client` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `user_agency` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `hotel_rooms` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `galleries` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `pictures` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `agency_trips` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `trip_package` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `locations` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
-- ALTER TABLE `wishlist` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ---
-- Test Data
-- ---

-- INSERT INTO `users` (`id`,`username`,`password`,`email`,`telephone`) VALUES
-- ('','','','','');
-- INSERT INTO `user_seller` (`id`,`user_id`,`name`,`adress`,`identificator`) VALUES
-- ('','','','','');
-- INSERT INTO `user_hotel` (`id`,`seller_id`,`stars`) VALUES
-- ('','','');
-- INSERT INTO `user_client` (`id`,`user_id`,`name`,`surname`) VALUES
-- ('','','','');
-- INSERT INTO `user_agency` (`id`,`seller_id`) VALUES
-- ('','');
-- INSERT INTO `hotel_rooms` (`id`,`hotel_id`,`room_type`,`price`,`gallery_id`) VALUES
-- ('','','','','');
-- INSERT INTO `galleries` (`id`,`room_id`,`picture_id`) VALUES
-- ('','','');
-- INSERT INTO `pictures` (`id`,`imagefile`) VALUES
-- ('','');
-- INSERT INTO `agency_trips` (`id`,`start_date`,`end_date`,`user_id`,`trip_type`,`price`) VALUES
-- ('','','','','','');

-- INSERT INTO `locations` (`id`,`location_name`,`hotel_id`,`period`) VALUES
-- ('','','','');
-- INSERT INTO `wishlist` (`id`,`object_id`,`user_id`,`type`) VALUES
-- ('','','','');
-- INSERT INTO `rating` (`id`,`object_id`,`user_id`,`type`) VALUES
-- ('','','','');
-- INSERT INTO `hotel_rating` (`id`,`user_id`,`rating`) VALUES
-- ('','','');
-- INSERT INTO `agency_rating` (`id`,`user_id`,`rating`) VALUES
-- ('','','');
-- INSERT INTO `trip_rating` (`id`,`user_id`,`rating`) VALUES
-- ('','','');

ALTER TABLE `turista`.`users` 
ADD COLUMN `is_approved` INT NULL DEFAULT 1 AFTER `email`;
ALTER TABLE `turista`.`users` 
CHANGE COLUMN `is_approved` `is_banned` INT(11) NULL DEFAULT '1' ;
ALTER TABLE `turista`.`user_seller` 
ADD COLUMN `is_approved` INT NULL DEFAULT 1 AFTER `identificator`;
ALTER TABLE `turista`.`user_seller` 
ADD COLUMN `date` DATE NULL AFTER `is_approved`;

ALTER TABLE `turista`.`comment` 
ADD COLUMN `is_banned` INT NULL DEFAULT 1 AFTER `user_id`;