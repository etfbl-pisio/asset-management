-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.26-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for asset_management
CREATE DATABASE IF NOT EXISTS `asset_management` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `asset_management`;

-- Dumping structure for table asset_management.asset
CREATE TABLE IF NOT EXISTS `asset` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identifier` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(120) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `description` mediumtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `location_id` int(11) NOT NULL,
  `asset_type_id` int(11) NOT NULL,
  `asset_status_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `identifier` (`identifier`),
  KEY `FK_asset_location` (`location_id`),
  KEY `FK_asset_asset_type` (`asset_type_id`),
  KEY `FK_asset_asset_status` (`asset_status_id`),
  CONSTRAINT `FK_asset_asset_status` FOREIGN KEY (`asset_status_id`) REFERENCES `asset_status` (`id`),
  CONSTRAINT `FK_asset_asset_type` FOREIGN KEY (`asset_type_id`) REFERENCES `asset_type` (`id`),
  CONSTRAINT `FK_asset_location` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table asset_management.asset: ~0 rows (approximately)
DELETE FROM `asset`;
/*!40000 ALTER TABLE `asset` DISABLE KEYS */;
INSERT INTO `asset` (`id`, `identifier`, `name`, `description`, `location_id`, `asset_type_id`, `asset_status_id`) VALUES
	(1, 'A01A', 'Dell XPS', NULL, 2, 1, 1),
	(2, 'B21A', 'Stolica Model 21A', 'Dimenzije 40x50', 1, 2, 2);
/*!40000 ALTER TABLE `asset` ENABLE KEYS */;

-- Dumping structure for table asset_management.asset_status
CREATE TABLE IF NOT EXISTS `asset_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(120) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table asset_management.asset_status: ~0 rows (approximately)
DELETE FROM `asset_status`;
/*!40000 ALTER TABLE `asset_status` DISABLE KEYS */;
INSERT INTO `asset_status` (`id`, `name`) VALUES
	(1, 'Ispravan'),
	(2, 'Na popravci'),
	(3, 'Neispravan'),
	(4, 'Otpisan');
/*!40000 ALTER TABLE `asset_status` ENABLE KEYS */;

-- Dumping structure for table asset_management.asset_type
CREATE TABLE IF NOT EXISTS `asset_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(120) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `description` mediumtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table asset_management.asset_type: ~0 rows (approximately)
DELETE FROM `asset_type`;
/*!40000 ALTER TABLE `asset_type` DISABLE KEYS */;
INSERT INTO `asset_type` (`id`, `name`, `description`) VALUES
	(1, 'Računar', NULL),
	(2, 'Stolica', 'Drvena, na preklapanje');
/*!40000 ALTER TABLE `asset_type` ENABLE KEYS */;

-- Dumping structure for table asset_management.location
CREATE TABLE IF NOT EXISTS `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `description` mediumtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `latitude` decimal(8,6) NOT NULL,
  `longitude` decimal(9,6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table asset_management.location: ~0 rows (approximately)
DELETE FROM `location`;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` (`id`, `name`, `description`, `latitude`, `longitude`) VALUES
	(1, 'Glavno Skladište Banja Luka', NULL, 10.000000, 23.000000),
	(2, 'Uprava Banja Luka', 'Pored ETF-a', 10.345100, 10.312330);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
