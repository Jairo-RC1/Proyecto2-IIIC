-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.1.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for eventsystem
CREATE DATABASE IF NOT EXISTS `eventsystem` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci */;
USE `eventsystem`;

-- Dumping structure for table eventsystem.events
CREATE TABLE IF NOT EXISTS `events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `description` longtext NOT NULL,
  `date` date NOT NULL,
  `address` varchar(300) NOT NULL DEFAULT '',
  `city` varchar(50) NOT NULL DEFAULT '',
  `postal_code` int(11) NOT NULL DEFAULT 0,
  `price` double NOT NULL DEFAULT 0,
  `room` int(11) NOT NULL DEFAULT 0,
  `place_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `FK_event_place` (`place_id`),
  CONSTRAINT `FK_event_place` FOREIGN KEY (`place_id`) REFERENCES `places` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Dumping data for table eventsystem.events: ~7 rows (approximately)
INSERT INTO `events` (`id`, `name`, `description`, `date`, `address`, `city`, `postal_code`, `price`, `room`, `place_id`) VALUES
	(4, 'Hyatt Ziva Cancun', 'Located on a spectacularly scenic peninsula - surrounded by ocean on three sides - and designed in a tranquil village-like setting, Hyatt Ziva Cancun connects guests to the natural beauty of Cancun\'s coast with several unexpected delights along the way.', '2023-12-10', 'Blvd. Kukulcan, Manzana 51 Lote 7, Cancun 77500 Mexico', 'No se encuentra la ciudad', 0, 0, 0, 3),
	(5, 'Hyatt Ziva Cancun', 'Located on a spectacularly scenic peninsula - surrounded by ocean on three sides - and designed in a tranquil village-like setting, Hyatt Ziva Cancun connects guests to the natural beauty of Cancun\'s coast with several unexpected delights along the way.', '2023-12-10', 'Blvd. Kukulcan, Manzana 51 Lote 7, Cancun 77500 Mexico', 'No se encuentra la ciudad', 0, 0, 0, 3),
	(6, 'Hyatt Ziva Cancun', 'Located on a spectacularly scenic peninsula - surrounded by ocean on three sides - and designed in a tranquil village-like setting, Hyatt Ziva Cancun connects guests to the natural beauty of Cancun\'s coast with several unexpected delights along the way.', '2023-12-10', 'Blvd. Kukulcan, Manzana 51 Lote 7, Cancun 77500 Mexico', 'No se encuentra la ciudad', 0, 0, 0, 3),
	(7, 'Hyatt Ziva Cancun', 'Located on a spectacularly scenic peninsula - surrounded by ocean on three sides - and designed in a tranquil village-like setting, Hyatt Ziva Cancun connects guests to the natural beauty of Cancun\'s coast with several unexpected delights along the way.', '2023-12-10', 'Blvd. Kukulcan, Manzana 51 Lote 7, Cancun 77500 Mexico', 'No se encuentra la ciudad', 0, 0, 0, 3),
	(8, 'Hyatt Ziva Cancun', 'Located on a spectacularly scenic peninsula - surrounded by ocean on three sides - and designed in a tranquil village-like setting, Hyatt Ziva Cancun connects guests to the natural beauty of Cancun\'s coast with several unexpected delights along the way.', '2023-12-10', 'Blvd. Kukulcan, Manzana 51 Lote 7, Cancun 77500 Mexico', 'No se encuentra la ciudad', 0, 0, 0, 3),
	(10, 'Hyatt Ziva Cancun', 'Located on a spectacularly scenic peninsula - surrounded by ocean on three sides - and designed in a tranquil village-like setting, Hyatt Ziva Cancun connects guests to the natural beauty of Cancun\'s coast with several unexpected delights along the way.', '2023-12-11', 'Blvd. Kukulcan, Manzana 51 Lote 7, Cancun 77500 Mexico', 'No se encuentra la ciudad', 0, 0, 0, 3),
	(11, 'Cabinas San Isidro', 'Description not available', '2023-12-11', 'San Isidro, Puntarenas 60101 Costa Rica', 'No se encuentra la ciudad', 0, 0, 0, 6);

-- Dumping structure for table eventsystem.places
CREATE TABLE IF NOT EXISTS `places` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` varchar(300) NOT NULL,
  `city` varchar(50) NOT NULL,
  `postal_code` int(11) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `tripAdvisor_link` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Dumping data for table eventsystem.places: ~4 rows (approximately)
INSERT INTO `places` (`id`, `name`, `address`, `city`, `postal_code`, `latitude`, `longitude`, `tripAdvisor_link`) VALUES
	(3, 'Hyatt Ziva Cancun', 'Blvd. Kukulcan, Manzana 51 Lote 7, Cancun 77500 Mexico', 'Ciudad no disponible', 0, 21.1356, -86.7419, 'https://www.tripadvisor.com/Hotel_Review-g150807-d152887-Reviews-Hyatt_Ziva_Cancun-Cancun_Yucatan_Peninsula.html?m=66827'),
	(4, 'Hyatt Ziva Cancun', 'Blvd. Kukulcan, Manzana 51 Lote 7, Cancun 77500 Mexico', 'Ciudad no disponible', 0, 21.1356, -86.7419, 'https://www.tripadvisor.com/Hotel_Review-g150807-d152887-Reviews-Hyatt_Ziva_Cancun-Cancun_Yucatan_Peninsula.html?m=66827'),
	(5, 'Hyatt Ziva Cancun', 'Blvd. Kukulcan, Manzana 51 Lote 7, Cancun 77500 Mexico', 'Ciudad no disponible', 0, 21.1356, -86.7419, 'https://www.tripadvisor.com/Hotel_Review-g150807-d152887-Reviews-Hyatt_Ziva_Cancun-Cancun_Yucatan_Peninsula.html?m=66827'),
	(6, 'Cabinas San Isidro', 'San Isidro, Puntarenas 60101 Costa Rica', 'Ciudad no disponible', 0, 9.97664, -84.75829, 'https://www.tripadvisor.com/Hotel_Review-g309287-d300965-Reviews-Cabinas_San_Isidro-Puntarenas_Province_of_Puntarenas.html?m=66827');

-- Dumping structure for table eventsystem.reservations
CREATE TABLE IF NOT EXISTS `reservations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `date` date NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT 0,
  `event_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `FK_reservation_event` (`event_id`),
  CONSTRAINT `FK_reservation_event` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Dumping data for table eventsystem.reservations: ~6 rows (approximately)
INSERT INTO `reservations` (`id`, `user_name`, `date`, `quantity`, `event_id`) VALUES
	(4, 'Jefry', '2023-12-10', 2, 4),
	(5, 'Jefry', '2023-12-10', 2, 4),
	(6, 'Jefry', '2023-12-10', 2, 4),
	(7, 'Jefry', '2023-12-10', 2, 4),
	(8, 'Jefry', '2023-12-11', 3, 4),
	(9, 'Jefry', '2023-12-11', 4, 11);

-- Dumping structure for table eventsystem.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Dumping data for table eventsystem.roles: ~2 rows (approximately)
INSERT INTO `roles` (`id`, `name`) VALUES
	(1, 'Administrador'),
	(2, 'Usuario');

-- Dumping structure for table eventsystem.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_number` int(11) NOT NULL DEFAULT 0,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `last_name` varchar(50) NOT NULL DEFAULT '0',
  `birth_date` date NOT NULL,
  `email` varchar(50) NOT NULL DEFAULT '0',
  `phone_number` int(11) NOT NULL DEFAULT 0,
  `password` varchar(50) NOT NULL DEFAULT '0',
  `rol_id` int(11) DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `FK_rol_id` (`rol_id`) USING BTREE,
  CONSTRAINT `FK_users_roles` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- Dumping data for table eventsystem.users: ~3 rows (approximately)
INSERT INTO `users` (`id`, `id_number`, `name`, `last_name`, `birth_date`, `email`, `phone_number`, `password`, `rol_id`) VALUES
	(1, 208470635, 'Jairo', 'Rodriguez Castro', '2003-11-01', 'jairocastro.jr@gmail.com', 85211316, 'Jairo111', 1),
	(2, 208490745, 'Jefry', 'Morera Espinoza', '2002-11-27', 'jefry@gmail.com', 70854705, 'm0r3r@2002', 1),
	(13, 208360645, 'Jefry', 'Morera Espinoza', '2002-11-27', 'jefry@gmail.com', 70854705, 'jefry1', 2);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
