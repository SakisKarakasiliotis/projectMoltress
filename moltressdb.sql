-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 30, 2017 at 05:30 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `moltressdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `articles`
--

CREATE TABLE IF NOT EXISTS `articles` (
  `article_id` int(5) NOT NULL,
  `title` varchar(200) NOT NULL,
  `category` varchar(100) NOT NULL,
  `date` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articles`
--

INSERT INTO `articles` (`article_id`, `title`, `category`, `date`) VALUES
(1, 'Java Concurrency', 'Java', 0),
(2, 'Hibernate HQL ', 'Hibernate', 0),
(3, 'Spring MVC with Hibernate', 'Spring', 0);

-- --------------------------------------------------------

--
-- Table structure for table `assets`
--

CREATE TABLE IF NOT EXISTS `assets` (
  `ID` int(11) NOT NULL,
  `URI` varchar(255) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `item_ID` int(11) DEFAULT NULL,
  `description` longtext
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `availabilities`
--

CREATE TABLE IF NOT EXISTS `availabilities` (
  `ID` int(11) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `estate_ID` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `allow_smoking` tinyint(1) DEFAULT NULL,
  `allow_pets` tinyint(1) DEFAULT NULL,
  `allow_parties` tinyint(1) DEFAULT NULL,
  `max_persons` int(11) DEFAULT NULL,
  `min_days` int(11) DEFAULT NULL,
  `extra_cost_per_person` float DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `availabilities`
--

INSERT INTO `availabilities` (`ID`, `start_date`, `end_date`, `estate_ID`, `price`, `allow_smoking`, `allow_pets`, `allow_parties`, `max_persons`, `min_days`, `extra_cost_per_person`) VALUES
(1, '2017-10-01', '2017-10-30', 1, 10, 1, 1, 1, 2, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE IF NOT EXISTS `bookings` (
  `ID` int(11) NOT NULL,
  `estate_ID` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `visitor_ID` int(11) DEFAULT NULL,
  `total_price` float DEFAULT NULL,
  `persons` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `estates`
--

CREATE TABLE IF NOT EXISTS `estates` (
  `ID` int(11) NOT NULL,
  `owner_ID` int(11) DEFAULT NULL,
  `size` float DEFAULT NULL,
  `latitude` varchar(45) DEFAULT NULL,
  `longitude` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `beds` int(11) DEFAULT NULL,
  `rooms` int(11) DEFAULT NULL,
  `bathrooms` int(11) DEFAULT NULL,
  `sitting_room` tinyint(1) DEFAULT '0',
  `about` text,
  `wifi` tinyint(1) DEFAULT '0',
  `air_condition` tinyint(1) DEFAULT '0',
  `heating` tinyint(1) DEFAULT '0',
  `kitchen` tinyint(1) DEFAULT '0',
  `parking` tinyint(1) DEFAULT '0',
  `floor` int(11) DEFAULT NULL,
  `storeys` int(11) DEFAULT NULL,
  `elevator` tinyint(1) DEFAULT '0',
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `estates`
--

INSERT INTO `estates` (`ID`, `owner_ID`, `size`, `latitude`, `longitude`, `country`, `city`, `type`, `beds`, `rooms`, `bathrooms`, `sitting_room`, `about`, `wifi`, `air_condition`, `heating`, `kitchen`, `parking`, `floor`, `storeys`, `elevator`, `title`) VALUES
(1, 1, 1, NULL, NULL, 'Greece', 'Greece', NULL, NULL, NULL, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'Room1'),
(2, 2, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room2'),
(3, 3, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room3'),
(4, 4, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room4'),
(5, 5, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room5'),
(6, 6, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room6'),
(7, 7, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room7'),
(8, 8, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room8'),
(9, 9, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room9'),
(10, 9, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room9'),
(11, 9, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room9'),
(12, 9, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room9'),
(13, 9, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room9'),
(14, 9, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room9'),
(15, 9, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room9');

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE IF NOT EXISTS `reviews` (
  `ID` int(11) NOT NULL,
  `user_ID` int(11) DEFAULT NULL,
  `estate_ID` int(11) DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `description` longtext,
  `booking_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `usergroups`
--

CREATE TABLE IF NOT EXISTS `usergroups` (
  `ID` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` longtext
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usergroups`
--

INSERT INTO `usergroups` (`ID`, `name`, `description`) VALUES
(1, 'ADMIN', 'DOES EVERYTHING'),
(2, 'OWNER', 'EDITS ESTATES'),
(3, 'VISITOR', 'CAN BOOK');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `ID` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `phone_no` varchar(10) DEFAULT NULL,
  `user_group_ID` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `to_be_promoted` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `email`, `full_name`, `phone_no`, `user_group_ID`, `password`, `salt`, `username`, `to_be_promoted`) VALUES
(1, 'a@a.gr', 'a@a.gr', '6949257984', 1, '$2a$10$A23.HXgnSpLDySlNi8i1TO/Ux44V.35hOlEZK21ME0lisLypcS8WG', '$2a$10$A23.HXgnSpLDySlNi8i1TO', NULL, NULL),
(2, 'dion.k.karak@gmail.gr', 'Dionisis Karak', '2107719256', 2, '', '$2a$10$uwNROuawpw/A76eudkGpKO', NULL, 1),
(3, 'm@m.gr', 'Markos', '694925', 2, '$2a$10$Ew.Qh7Xj67c3ZYOGkEKDROawKh2EGlCEOeeHqaOEXoG8crMPowKee', '$2a$10$klEkEKJWNJbu6IBn5bNvye', NULL, 1),
(4, 'k@k.gr', 'kimon skretas', '6949257984', 2, '$2a$10$eZLD94djsRpjcnmX.hP66u8IHuPY6M6gdWaD8mg0mKSWRnxMKMuK.', '$2a$10$eZLD94djsRpjcnmX.hP66u', NULL, 0),
(5, 'ma@m.gr', 'Maria Kouratora', '694554', 2, '', '$2a$10$gNky.B8Txoi36Kj9dyTw8u', NULL, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`article_id`);

--
-- Indexes for table `assets`
--
ALTER TABLE `assets`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_UNIQUE` (`ID`);

--
-- Indexes for table `availabilities`
--
ALTER TABLE `availabilities`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_UNIQUE` (`ID`);

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_UNIQUE` (`ID`);

--
-- Indexes for table `estates`
--
ALTER TABLE `estates`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_UNIQUE` (`ID`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_UNIQUE` (`ID`);

--
-- Indexes for table `usergroups`
--
ALTER TABLE `usergroups`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_UNIQUE` (`ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `GID_UNIQUE` (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `articles`
--
ALTER TABLE `articles`
  MODIFY `article_id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `assets`
--
ALTER TABLE `assets`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `availabilities`
--
ALTER TABLE `availabilities`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `estates`
--
ALTER TABLE `estates`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `reviews`
--
ALTER TABLE `reviews`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `usergroups`
--
ALTER TABLE `usergroups`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
