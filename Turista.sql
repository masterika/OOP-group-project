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
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'user_hotel'
-- 
-- ---

DROP TABLE IF EXISTS `user_hotel`;
		
CREATE TABLE `user_hotel` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `user_id` INTEGER NULL,
  `hotel_name` VARCHAR(50) NULL,
  `adress` VARCHAR(50) NULL,
  `telephone` VARCHAR(15) NULL,
  `rooms_num` INTEGER NULL,
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
  `telephone` VARCHAR(20) NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'user_agency'
-- 
-- ---

DROP TABLE IF EXISTS `user_agency`;
		
CREATE TABLE `user_agency` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `user_id` INTEGER NULL,
  `agency_name` VARCHAR(30) NULL,
  `adress` VARCHAR(30) NULL,
  `telephone` VARCHAR(20) NULL,
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
  `id` INTEGER NULL AUTO_INCREMENT,
  `imagefile` VARCHAR(64) NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'agency_trips'
-- 
-- ---

DROP TABLE IF EXISTS `agency_trips`;
		
CREATE TABLE `agency_trips` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `agency_id` INTEGER NULL,
  `trip_type` VARCHAR(20) NULL,
  `price` DECIMAL NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'trip_package'
-- 
-- ---

DROP TABLE IF EXISTS `trip_package`;
		
CREATE TABLE `trip_package` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `trip_id` INTEGER NULL,
  `location_id` INTEGER NULL,
  `period` INTEGER,
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
  `hotel_id` INTEGER NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'wishlist'
-- 
-- ---

DROP TABLE IF EXISTS `wishlist`;
		
CREATE TABLE `wishlist` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `item_id` INTEGER NULL,
  `client_id` INTEGER NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Table 'wishlist_items'
-- 
-- ---

DROP TABLE IF EXISTS `wishlist_items`;
		
CREATE TABLE `wishlist_items` (
  `id` INTEGER NULL AUTO_INCREMENT,
  `type` ENUM('Trip','Room') NOT NULL,
  `item_id` INTEGER NULL,
  PRIMARY KEY (`id`)
);

-- ---
-- Foreign Keys 
-- ---

ALTER TABLE `user_hotel` ADD FOREIGN KEY (user_id) REFERENCES `users` (`id`);
ALTER TABLE `user_client` ADD FOREIGN KEY (user_id) REFERENCES `users` (`id`);
ALTER TABLE `user_agency` ADD FOREIGN KEY (user_id) REFERENCES `users` (`id`);
ALTER TABLE `hotel_rooms` ADD FOREIGN KEY (hotel_id) REFERENCES `user_hotel` (`id`);
ALTER TABLE `galleries` ADD FOREIGN KEY (room_id) REFERENCES `hotel_rooms` (`id`);
ALTER TABLE `galleries` ADD FOREIGN KEY (picture_id) REFERENCES `pictures` (`id`);
ALTER TABLE `agency_trips` ADD FOREIGN KEY (agency_id) REFERENCES `user_agency` (`id`);
ALTER TABLE `trip_package` ADD FOREIGN KEY (trip_id) REFERENCES `agency_trips` (`id`);
ALTER TABLE `trip_package` ADD FOREIGN KEY (location_id) REFERENCES `locations` (`id`);
ALTER TABLE `locations` ADD FOREIGN KEY (hotel_id) REFERENCES `user_hotel` (`id`);
ALTER TABLE `wishlist` ADD FOREIGN KEY (item_id) REFERENCES `wishlist_items` (`id`);
ALTER TABLE `wishlist` ADD FOREIGN KEY (client_id) REFERENCES `user_client` (`id`);
ALTER TABLE `wishlist_items` ADD FOREIGN KEY (item_id) REFERENCES `agency_trips` (`id`);
ALTER TABLE `wishlist_items` ADD FOREIGN KEY (item_id) REFERENCES `hotel_rooms` (`id`);

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
-- ALTER TABLE `wishlist_items` ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ---
-- Test Data
-- ---

-- INSERT INTO `users` (`id`,`username`,`password`,`email`) VALUES
-- ('','','','');
-- INSERT INTO `user_hotel` (`id`,`user_id`,`hotel_name`,`adress`,`telephone`,`rooms_num`,`stars`) VALUES
-- ('','','','','','','');
-- INSERT INTO `user_client` (`id`,`user_id`,`name`,`surname`,`telephone`) VALUES
-- ('','','','','');
-- INSERT INTO `user_agency` (`id`,`user_id`,`agency_name`,`adress`,`telephone`) VALUES
-- ('','','','','');
-- INSERT INTO `hotel_rooms` (`id`,`hotel_id`,`room_type`,`price`,`gallery_id`) VALUES
-- ('','','','','');
-- INSERT INTO `galleries` (`id`,`room_id`,`picture_id`) VALUES
-- ('','','');
-- INSERT INTO `pictures` (`id`,`imagefile`) VALUES
-- ('','');
-- INSERT INTO `agency_trips` (`id`,`agency_id`,`trip_type`,`price`) VALUES
-- ('','','','');
-- INSERT INTO `trip_package` (`id`,`trip_id`,`location_id`) VALUES
-- ('','','');
-- INSERT INTO `locations` (`id`,`location_name`,`hotel_id`,`period`) VALUES
-- ('','','','');
-- INSERT INTO `wishlist` (`id`,`item_id`,`client_id`) VALUES
-- ('','','');
-- INSERT INTO `wishlist_items` (`id`,`type`,`item_id`) VALUES
-- ('','','');

