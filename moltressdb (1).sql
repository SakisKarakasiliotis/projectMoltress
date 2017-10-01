-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 01 Οκτ 2017 στις 17:39:34
-- Έκδοση διακομιστή: 5.6.26
-- Έκδοση PHP: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `moltressdb`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `articles`
--

CREATE TABLE IF NOT EXISTS `articles` (
  `article_id` int(5) NOT NULL,
  `title` varchar(200) NOT NULL,
  `category` varchar(100) NOT NULL,
  `date` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `articles`
--

INSERT INTO `articles` (`article_id`, `title`, `category`, `date`) VALUES
(1, 'Java Concurrency', 'Java', 0),
(2, 'Hibernate HQL ', 'Hibernate', 0),
(3, 'Spring MVC with Hibernate', 'Spring', 0);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `assets`
--

CREATE TABLE IF NOT EXISTS `assets` (
  `ID` int(11) NOT NULL,
  `URI` varchar(255) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `item_ID` int(11) DEFAULT NULL,
  `description` longtext
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `assets`
--

INSERT INTO `assets` (`ID`, `URI`, `type`, `name`, `item_ID`, `description`) VALUES
(1, 'house-2187170_640.jpg', 'estate', 'house-2187170_640.jpg', 1, NULL),
(2, 'large-home-389271_640.jpg', 'estate', 'large-home-389271_640.jpg', 2, NULL),
(3, 'shutters-669296_640.jpg', 'estate', 'shutters-669296_640.jpg', 3, NULL),
(4, 'architecture-166534_640.jpg', 'estate', 'architecture-166534_640.jpg', 4, NULL);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `availabilities`
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `availabilities`
--

INSERT INTO `availabilities` (`ID`, `start_date`, `end_date`, `estate_ID`, `price`, `allow_smoking`, `allow_pets`, `allow_parties`, `max_persons`, `min_days`, `extra_cost_per_person`) VALUES
(1, '2017-10-01', '2017-10-30', 1, 10, 1, 1, 1, 2, 1, 1),
(2, '2017-10-01', '2017-10-30', 1, 10, 1, 1, 1, 2, 1, 1),
(3, '2017-10-01', '2017-10-30', 2, 10, 1, 1, 1, 2, 1, 1),
(4, '2017-10-01', '2017-10-30', 2, 10, 1, 1, 1, 2, 1, 1),
(5, '2017-10-01', '2017-10-30', 3, 10, 1, 1, 1, 2, 1, 1),
(6, '2017-10-01', '2017-10-30', 3, 10, 1, 1, 1, 2, 1, 1),
(7, '2017-10-01', '2017-10-30', 3, 10, 1, 1, 1, 2, 1, 1),
(8, '2017-10-01', '2017-10-30', 4, 10, 1, 1, 1, 2, 1, 1),
(9, '2017-11-01', '2017-11-30', 4, 10, 1, 1, 1, 2, 1, 1),
(10, NULL, NULL, 24, 123, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `bookings`
--

CREATE TABLE IF NOT EXISTS `bookings` (
  `ID` int(11) NOT NULL,
  `estate_ID` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `visitor_ID` int(11) DEFAULT NULL,
  `total_price` float DEFAULT NULL,
  `persons` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `bookings`
--

INSERT INTO `bookings` (`ID`, `estate_ID`, `start_date`, `end_date`, `visitor_ID`, `total_price`, `persons`) VALUES
(1, 2, '2017-10-10', '2017-10-12', 1, 50, 1),
(2, 1, '2017-10-01', '2017-10-02', NULL, NULL, 2),
(3, 2, '2017-10-25', '2017-10-30', 3, NULL, 2),
(4, 2, '2017-10-01', '2017-10-02', 3, NULL, 2),
(5, 2, '2017-10-20', '2017-10-23', 3, NULL, 2);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `estates`
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `estates`
--

INSERT INTO `estates` (`ID`, `owner_ID`, `size`, `latitude`, `longitude`, `country`, `city`, `type`, `beds`, `rooms`, `bathrooms`, `sitting_room`, `about`, `wifi`, `air_condition`, `heating`, `kitchen`, `parking`, `floor`, `storeys`, `elevator`, `title`) VALUES
(1, 1, 1, NULL, NULL, 'Greece', 'Greece', 'single', 1, 1, 1, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'Room1'),
(2, 2, 1, NULL, NULL, 'Greece', NULL, 'double', 1, 1, 1, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room2'),
(3, 3, 1, NULL, NULL, 'Greece', NULL, 'double', 1, 1, 1, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room3'),
(4, 4, 1, NULL, NULL, 'Greece', NULL, 'Double', 1, 1, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room4'),
(5, 5, 1, NULL, NULL, 'Greece', NULL, 'triple', 1, 1, 1, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room5'),
(6, 6, 1, NULL, NULL, 'Greece', NULL, 'ela', 23, 1, 1, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room6'),
(7, 7, 1, NULL, NULL, 'Greece', NULL, 'edw', 3, 1, 1, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room7'),
(8, 8, 1, NULL, NULL, 'Greece', NULL, 'twra', 4, 1, 1, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room8'),
(9, 9, 1, NULL, NULL, 'Greece', NULL, 'single', 6, 1, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room9'),
(10, 9, 1, NULL, NULL, 'Greece', NULL, 'single', 56, 1, 1, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room9'),
(11, 9, 1, NULL, NULL, 'Greece', NULL, 'single', 7, 1, 1, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room9'),
(12, 9, 1, NULL, NULL, NULL, NULL, 'single', 9, 1, 1, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room9'),
(13, 9, 1, NULL, NULL, NULL, NULL, 'single', 8, 1, 1, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room9'),
(14, 9, 1, NULL, NULL, NULL, NULL, 'singl', 9, 1, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room9'),
(15, 9, 1, NULL, NULL, NULL, NULL, 'e', 9, 1, NULL, 0, NULL, 0, 0, 0, 0, 0, NULL, NULL, 0, 'room9'),
(16, NULL, 10, NULL, NULL, 'INIOXOI', 'INIOXOI', 'INIOXOI', 1, 1, 1, 1, NULL, 1, 1, 1, 1, NULL, 1, 1, 1, 'INIOXOI'),
(17, NULL, 1, NULL, NULL, '111', '111', '1111', 11, 11, 11, 0, NULL, 0, 0, 0, 0, NULL, 1, 1, 0, 'fadasf'),
(18, NULL, 12, NULL, NULL, '1233', '123', '123', 123, 123, 123, 0, NULL, 0, 0, 0, 0, NULL, 123, 123, 0, 'dasfs'),
(19, NULL, 123123, NULL, NULL, '24124124', '12412412', '124241', 12412412, 124124, 124124, 1, NULL, 0, 0, 0, 0, NULL, 4124124, 124124, 0, 'ASF '),
(20, NULL, 12323, NULL, NULL, '124124', '124124', '12412412', 234, 124124, 234, 0, NULL, 0, 0, 0, 0, NULL, 234234, 234234234, 0, 'asdasf'),
(21, NULL, 12323, NULL, NULL, '124124', '124124', '12412412', 234, 124124, 234, 0, NULL, 0, 0, 0, 0, NULL, 234234, 234234234, 0, 'asdasfdfdsfdsf dsf s'),
(22, NULL, 1, NULL, NULL, '11', '1', '11', 1, 11, 1, 1, NULL, 0, 1, 0, 0, NULL, 1, 1, 1, 'asdEF'),
(23, NULL, 123, NULL, NULL, '123', '123', '123', 12, 123, 123, 0, NULL, 1, 0, 0, 0, NULL, 123, 123, 0, 'EFWDFGH DRFAGH'),
(24, NULL, 123, NULL, NULL, '123', '123', '123', 12, 123, 123, 0, NULL, 1, 0, 0, 0, NULL, 123, 123, 0, 'EFWDFGH DRFAGHASD');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `reviews`
--

CREATE TABLE IF NOT EXISTS `reviews` (
  `ID` int(11) NOT NULL,
  `user_ID` int(11) DEFAULT NULL,
  `estate_ID` int(11) DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `description` longtext,
  `booking_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `reviews`
--

INSERT INTO `reviews` (`ID`, `user_ID`, `estate_ID`, `rating`, `description`, `booking_ID`) VALUES
(1, 1, 1, 4.5, 'kjdshkjghah df hgdfjhg gdfajhg dfgh ', 1),
(2, 1, 2, 5, 'g gf sdfh hsdf', 1),
(3, 2, 2, 2, 'dfsgf g sg dfgsg ', 1),
(4, NULL, 1, 5, 'ela mou', 1);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `usergroups`
--

CREATE TABLE IF NOT EXISTS `usergroups` (
  `ID` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` longtext
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `usergroups`
--

INSERT INTO `usergroups` (`ID`, `name`, `description`) VALUES
(1, 'ADMIN', 'DOES EVERYTHING'),
(2, 'OWNER', 'EDITS ESTATES'),
(3, 'VISITOR', 'CAN BOOK');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `users`
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
-- Άδειασμα δεδομένων του πίνακα `users`
--

INSERT INTO `users` (`ID`, `email`, `full_name`, `phone_no`, `user_group_ID`, `password`, `salt`, `username`, `to_be_promoted`) VALUES
(1, 'a@a.gr', 'a@a.gr', '6949257984', 1, '$2a$10$A23.HXgnSpLDySlNi8i1TO/Ux44V.35hOlEZK21ME0lisLypcS8WG', '$2a$10$A23.HXgnSpLDySlNi8i1TO', NULL, NULL),
(2, 'dion.k.karak@gmail.gr', 'Dionisis Karak', '2107719256', 2, '', '$2a$10$uwNROuawpw/A76eudkGpKO', NULL, 1),
(3, 'm@m.gr', 'Markos', '694925', 3, '$2a$10$Ew.Qh7Xj67c3ZYOGkEKDROawKh2EGlCEOeeHqaOEXoG8crMPowKee', '$2a$10$klEkEKJWNJbu6IBn5bNvye', NULL, 1),
(4, 'k@k.gr', 'kimon skretas', '6949257984', 2, '$2a$10$eZLD94djsRpjcnmX.hP66u8IHuPY6M6gdWaD8mg0mKSWRnxMKMuK.', '$2a$10$eZLD94djsRpjcnmX.hP66u', NULL, 0),
(5, 'ma@m.gr', 'Maria Kouratora', '694554', 2, '', '$2a$10$gNky.B8Txoi36Kj9dyTw8u', NULL, 1);

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`article_id`);

--
-- Ευρετήρια για πίνακα `assets`
--
ALTER TABLE `assets`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_UNIQUE` (`ID`);

--
-- Ευρετήρια για πίνακα `availabilities`
--
ALTER TABLE `availabilities`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_UNIQUE` (`ID`);

--
-- Ευρετήρια για πίνακα `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_UNIQUE` (`ID`);

--
-- Ευρετήρια για πίνακα `estates`
--
ALTER TABLE `estates`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_UNIQUE` (`ID`);

--
-- Ευρετήρια για πίνακα `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_UNIQUE` (`ID`);

--
-- Ευρετήρια για πίνακα `usergroups`
--
ALTER TABLE `usergroups`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID_UNIQUE` (`ID`);

--
-- Ευρετήρια για πίνακα `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `GID_UNIQUE` (`ID`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `articles`
--
ALTER TABLE `articles`
  MODIFY `article_id` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT για πίνακα `assets`
--
ALTER TABLE `assets`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT για πίνακα `availabilities`
--
ALTER TABLE `availabilities`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT για πίνακα `bookings`
--
ALTER TABLE `bookings`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT για πίνακα `estates`
--
ALTER TABLE `estates`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT για πίνακα `reviews`
--
ALTER TABLE `reviews`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT για πίνακα `usergroups`
--
ALTER TABLE `usergroups`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT για πίνακα `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
