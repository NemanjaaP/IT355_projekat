-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 08, 2019 at 01:41 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `it355-projekat`
--

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `CITY_ID` int(11) NOT NULL,
  `NAME` char(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`CITY_ID`, `NAME`) VALUES
(73, 'Smederevo'),
(79, 'Beograd'),
(80, 'New York'),
(84, 'Mladenovac');

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `ITEM_ID` int(11) NOT NULL,
  `PRODUCT_TYPE` int(11) DEFAULT NULL,
  `NAME` char(30) NOT NULL,
  `PRICE` float NOT NULL,
  `DESCRIPTION` text NOT NULL,
  `PHOTO_PATH` char(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`ITEM_ID`, `PRODUCT_TYPE`, `NAME`, `PRICE`, `DESCRIPTION`, `PHOTO_PATH`) VALUES
(54, 2, 'Helly Hansen Alpha 3.0 Jacket', 315, '', '/img/wear1.jpg'),
(55, 3, 'Smith Maze MIPS Helmet', 83, '', '/img/protection3.jpg'),
(56, 2, 'Arc\'teryx Rush Jacket - Men\'s', 245.022, '', '/img/wear2.jpg'),
(57, 2, 'Flylow Baker Bib Pant - Men\'s', 264, '', '/img/wear4.jpg'),
(58, 3, 'Smith Compass Helmet - Women\'s', 84, '', '/img/protection5.jpg\r\n'),
(59, 3, 'Smith I/O Chromapop Goggles', 120, '', '/img/protection2.jpg'),
(60, 1, 'Blizzard Bonafide Ski', 300, '', '/img/skis3.jpg'),
(61, 1, 'Blizzard Rustler 11 Ski', 631, '', '/img/skis2_1.jpg'),
(62, 2, 'Arc\'teryx Voltair 30L Backpack', 1300, '', '/img/wear3.jpg'),
(63, 3, 'Smith Vantage Helmet', 138, '', '/img/protection1.jpg'),
(64, 2, 'Black Diamond Mercury Mitten -', 0, '', '/img/wear7.jpg'),
(65, 3, 'Smith Riot Chromapop Goggles -', 60, '', '/img/protection7.jpg'),
(66, 1, 'Nordica Santa Ana 110 Ski - Wo', 639, '', '/img/skis4.jpg'),
(67, 2, 'Airblaster Classic Ninja Suit', 89, '', '/img/wear8.jpg'),
(68, 2, 'Pow Gloves Stealth GTX Warm Mi', 120, '', '/img/wear5.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `ORDER_ID` int(11) NOT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `ITEMS` char(250) NOT NULL,
  `SUM` float NOT NULL,
  `STATUS_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`ORDER_ID`, `USER_ID`, `ITEMS`, `SUM`, `STATUS_ID`) VALUES
(47, 30, 'Item 0:Blizzard Bonafide Ski, Item 1:Smith I/O Chromapop Goggles,', 420, 1),
(48, 30, 'Item 0:Blizzard Bonafide Ski, Item 1:Smith I/O Chromapop Goggles,', 420, 1),
(49, 30, 'Item 0:Blizzard Bonafide Ski, Item 1:Smith I/O Chromapop Goggles,', 420, 1),
(50, 30, 'Item 0:Blizzard Bonafide Ski, Item 1:Smith I/O Chromapop Goggles,', 420, 1),
(51, 30, 'Item 0:Blizzard Bonafide Ski, Item 1:Smith I/O Chromapop Goggles,', 420, 1),
(52, 30, 'Item 0:Blizzard Bonafide Ski, Item 1:Smith I/O Chromapop Goggles,', 420, 1),
(53, 30, 'Item 0:Blizzard Bonafide Ski, Item 1:Smith I/O Chromapop Goggles,', 420, 1);

-- --------------------------------------------------------

--
-- Table structure for table `product_type`
--

CREATE TABLE `product_type` (
  `TYPE_ID` int(11) NOT NULL,
  `TYPE` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_type`
--

INSERT INTO `product_type` (`TYPE_ID`, `TYPE`) VALUES
(1, 'Skis'),
(2, 'Wear'),
(3, 'Protection');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `STATUS_ID` int(11) NOT NULL,
  `STATUS_NAME` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`STATUS_ID`, `STATUS_NAME`) VALUES
(1, 'Pending'),
(2, 'Received'),
(3, 'Processing'),
(4, 'Shipped'),
(5, 'Canceled');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `USER_ID` int(11) NOT NULL,
  `CITY_ID` int(11) DEFAULT NULL,
  `FIRST_NAME` char(30) NOT NULL,
  `LAST_NAME` char(30) NOT NULL,
  `USERNAME` char(30) NOT NULL,
  `PASSWORD` char(100) NOT NULL,
  `EMAIL` char(30) NOT NULL,
  `enabled` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`USER_ID`, `CITY_ID`, `FIRST_NAME`, `LAST_NAME`, `USERNAME`, `PASSWORD`, `EMAIL`, `enabled`) VALUES
(1, NULL, 'Nemanja', 'Petrovic', 'nemanjapetrovic', '$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K', 'nemanja@petrovic.com', 1),
(23, 73, 'milos', 'mirkovic', 'milossssmirk', '$2a$10$R9rwBfPVIdegYFmUN6R1MOqETByIVT7xtd6oWAFZ0OdCfVECt/Xwa', 'milos@mirkovic', 1),
(26, 73, 'Marko', 'Nikolic', 'markonikoc123', '$2a$10$duqgL6Y6Y34.HYiXcBtmAuAhibHz4fVRit.kfjtHGZ/MpPZPcMF.K', 'markonilkolic@metlab', 1),
(30, 79, 'marko', 'rajevic', 'markorajevic', '$2a$10$Eh1OuO.0jgebKQ3nC0UczOR4Ibw9.L.TPhMwSJdH/JXAxTy1xDgAG', 'marko@rajevic', 1),
(31, 79, 'Milica', 'Milicic', 'milicamilicic', '$2a$10$TzVuDZjZtck69RKaT0/PkOMWif8yx/zxYEu6tLT0iiTN7xdtG1nm6', 'milica@milicic@gmail.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(23, 2),
(26, 2),
(30, 2),
(31, 2);

-- --------------------------------------------------------

--
-- Table structure for table `user_item`
--

CREATE TABLE `user_item` (
  `ITEM_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `QUANTITY` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_item`
--

INSERT INTO `user_item` (`ITEM_ID`, `USER_ID`, `QUANTITY`) VALUES
(61, 1, NULL),
(61, 1, NULL),
(60, 26, NULL),
(60, 30, NULL),
(59, 30, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`CITY_ID`),
  ADD UNIQUE KEY `CITY_PK` (`CITY_ID`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`ITEM_ID`),
  ADD UNIQUE KEY `ITEM_PK` (`ITEM_ID`),
  ADD KEY `PRODUCT_TYPE` (`PRODUCT_TYPE`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`ORDER_ID`),
  ADD UNIQUE KEY `ORDER_PK` (`ORDER_ID`),
  ADD KEY `RELATIONSHIP_4_FK` (`USER_ID`),
  ADD KEY `orders_ibfk_1` (`STATUS_ID`);

--
-- Indexes for table `product_type`
--
ALTER TABLE `product_type`
  ADD PRIMARY KEY (`TYPE_ID`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`STATUS_ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`USER_ID`),
  ADD UNIQUE KEY `USER_PK` (`USER_ID`),
  ADD KEY `RELATIONSHIP_1_FK` (`CITY_ID`);

--
-- Indexes for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FK_ROLE` (`role_id`);

--
-- Indexes for table `user_item`
--
ALTER TABLE `user_item`
  ADD KEY `RELATIONSHIP_5_FK` (`ITEM_ID`),
  ADD KEY `RELATIONSHIP_7_FK` (`USER_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `CITY_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `ITEM_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `ORDER_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `STATUS_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `USER_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `item`
--
ALTER TABLE `item`
  ADD CONSTRAINT `item_ibfk_1` FOREIGN KEY (`PRODUCT_TYPE`) REFERENCES `product_type` (`TYPE_ID`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FK_ORDERS_RELATIONS_USERS` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`STATUS_ID`) REFERENCES `status` (`STATUS_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FK_USERS_RELATIONS_CITY` FOREIGN KEY (`CITY_ID`) REFERENCES `city` (`CITY_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) REFERENCES `users` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user_item`
--
ALTER TABLE `user_item`
  ADD CONSTRAINT `FK_USER_ITE_RELATIONS_ITEM` FOREIGN KEY (`ITEM_ID`) REFERENCES `item` (`ITEM_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_USER_ITE_RELATIONS_USERS` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
