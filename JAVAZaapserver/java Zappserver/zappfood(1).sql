-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 28, 2017 at 07:13 पूर्वाह्न
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `zappfood`
--

-- --------------------------------------------------------

--
-- Table structure for table `account_login`
--

CREATE TABLE `account_login` (
  `account_id` int(11) NOT NULL,
  `User_Name` varchar(50) NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account_login`
--

INSERT INTO `account_login` (`account_id`, `User_Name`, `Password`) VALUES
(1, 'account', 'account123');

-- --------------------------------------------------------

--
-- Table structure for table `backup`
--

CREATE TABLE `backup` (
  `Id` int(11) NOT NULL,
  `User_Name` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `backup`
--

INSERT INTO `backup` (`Id`, `User_Name`, `Password`) VALUES
(0, 'backup', 'backup123');

-- --------------------------------------------------------

--
-- Table structure for table `favourite`
--

CREATE TABLE `favourite` (
  `Id` int(10) NOT NULL,
  `Item_name` varchar(50) NOT NULL,
  `Item_price` int(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `table_id` varchar(30) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `favourite`
--

INSERT INTO `favourite` (`Id`, `Item_name`, `Item_price`, `quantity`, `table_id`, `time`, `status`) VALUES
(3, 'Lunch Item', 800, 4, 'table1', '2017-02-20 16:07:36', 0),
(4, 'pork meat', 1750, 7, 'table1', '2017-02-20 16:10:00', 0),
(5, 'Pan cakes', 1540, 7, 'table1', '2017-02-20 16:10:00', 0),
(6, 'Bread and omlet', 1890, 7, 'table1', '2017-02-20 16:10:01', 0),
(7, 'Lunch Item', 1800, 9, 'table1', '2017-02-20 18:16:08', 0),
(8, 'Lunch Item', 4000, 20, 'table1', '2017-02-20 18:17:19', 0),
(9, 'Lunch Item', 800, 4, 'table1', '2017-02-21 01:48:21', 0),
(10, 'chicken biryani', 440, 2, 'table1', '2017-02-21 09:14:15', 0),
(11, 'Mutton biryani', 960, 3, 'table1', '2017-02-21 09:14:15', 0),
(12, 'Pan cakes', 440, 2, 'table1', '2017-02-21 09:16:07', 0),
(13, 'Nachos', 600, 4, 'table1', '2017-02-23 00:50:22', 0),
(14, 'Nachos', 600, 4, 'table1', '2017-02-23 00:50:49', 0),
(15, 'Lunch Item', 600, 3, 'table1', '2017-02-23 00:51:34', 0),
(16, 'Lunch Item', 600, 3, 'table1', '2017-02-23 00:51:45', 0),
(17, 'Lunch Item', 2400, 12, 'table1', '2017-02-23 00:55:12', 0),
(18, 'Nachos', 450, 3, 'table1', '2017-02-23 00:57:20', 0),
(19, 'crosscent', 400, 2, 'table1', '2017-02-23 00:57:20', 0),
(20, 'Nachos', 750, 5, 'table1', '2017-02-23 00:57:54', 0),
(21, 'Nachos', 600, 4, 'table1', '2017-02-23 01:02:20', 0),
(22, 'Nachos', 600, 4, 'table1', '2017-02-23 01:02:22', 0),
(23, 'crosscent', 1000, 5, 'table1', '2017-02-23 01:02:23', 0),
(24, 'Nachos', 750, 5, 'table1', '2017-02-23 01:04:28', 0),
(25, 'Nachos', 750, 5, 'table1', '2017-02-23 01:04:33', 0),
(26, 'Nachos', 600, 4, 'table1', '2017-02-23 01:05:00', 0),
(27, 'Nachos', 600, 4, 'table1', '2017-02-23 01:05:05', 0),
(28, 'Nachos', 1050, 7, 'table1', '2017-02-23 02:30:59', 0),
(29, 'Pan cakes', 3520, 16, 'table1', '2017-02-23 02:30:59', 0),
(30, 'Lunch Item', 800, 4, 'table1', '2017-02-23 02:35:40', 0),
(31, 'Nachos', 750, 5, 'table1', '2017-02-23 02:35:40', 0),
(32, 'Pan cakes', 1100, 5, 'table1', '2017-02-23 02:35:40', 0),
(33, 'Lunch Item', 800, 4, 'table1', '2017-02-23 02:45:46', 0),
(34, 'Nachos', 750, 5, 'table1', '2017-02-23 02:45:47', 0),
(35, 'Pan cakes', 440, 2, 'table1', '2017-02-23 02:45:47', 0),
(36, 'Nachos', 750, 5, 'table1', '2017-02-23 02:47:52', 0),
(37, 'Lunch Item', 800, 4, 'table1', '2017-02-23 02:50:56', 0),
(38, 'Lunch Item', 800, 4, 'table1', '2017-02-23 02:54:10', 0),
(39, 'Lunch Item', 800, 4, 'table1', '2017-02-23 02:58:16', 0),
(40, 'Pan cakes', 1100, 5, 'table1', '2017-02-23 02:59:41', 0),
(41, 'Lunch Item', 800, 4, 'table1', '2017-02-23 03:07:08', 0),
(42, 'Lunch Item', 800, 4, 'table1', '2017-02-23 03:18:31', 0),
(43, 'Nachos', 1650, 11, 'table1', '2017-02-23 03:18:31', 0),
(44, 'crosscent', 800, 4, 'table1', '2017-02-23 04:39:24', 0),
(45, 'crosscent', 800, 4, 'table2', '2017-02-23 07:28:21', 0),
(46, 'Lunch Item', 800, 4, 'table2', '2017-02-23 07:28:21', 0),
(47, 'Nachos', 600, 4, 'table2', '2017-02-23 07:31:34', 0),
(48, 'Nachos', 600, 4, 'table2', '2017-02-24 06:30:01', 0),
(49, 'crosscent', 1200, 6, 'table2', '2017-02-24 06:30:02', 0),
(50, 'Pan cakes', 1540, 7, 'table2', '2017-02-24 06:32:03', 0),
(51, 'Nachos', 750, 5, 'table2', '2017-02-24 06:32:03', 0),
(52, 'Nachos', 600, 4, 'table2', '2017-02-24 06:32:29', 0),
(53, 'Nachos', 600, 4, 'table1', '2017-02-24 18:52:04', 0),
(54, 'Newari Khaja Set', 500, 5, 'table1', '2017-02-24 18:52:09', 0),
(55, 'Nachos', 600, 4, 'table1', '2017-02-25 07:07:49', 0),
(56, 'Pan cakes', 880, 4, 'table1', '2017-02-25 07:07:49', 0),
(57, 'chicken biryani', 880, 4, 'table1', '2017-02-25 07:08:57', 0),
(58, 'chicken biryani', 880, 4, 'table1', '2017-02-25 07:09:00', 0),
(59, 'Nachos', 600, 4, 'table1', '2017-02-25 07:09:36', 0),
(60, 'Pan cakes', 220, 1, 'table1', '2017-02-25 08:04:48', 0),
(61, 'Lunch Item', 800, 4, 'table1', '2017-02-25 08:04:48', 0),
(62, 'Nachos', 300, 2, 'table1', '2017-02-25 08:04:48', 0),
(63, 'Lunch Item', 1000, 5, 'table1', '2017-02-25 08:05:40', 0),
(64, 'chicken biryani', 880, 4, 'table1', '2017-02-25 08:05:40', 0),
(65, 'Nachos', 450, 3, 'table1', '2017-02-25 08:55:05', 0),
(66, 'crosscent', 400, 2, 'table1', '2017-02-25 08:55:06', 0),
(67, 'Lunch Item', 800, 4, 'table1', '2017-02-25 08:55:06', 0);

-- --------------------------------------------------------

--
-- Table structure for table `kitchen`
--

CREATE TABLE `kitchen` (
  `Id` int(10) NOT NULL,
  `Item_name` varchar(50) NOT NULL,
  `Item_price` int(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `table_id` varchar(30) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `kitchen_login`
--

CREATE TABLE `kitchen_login` (
  `kitchen_id` int(11) NOT NULL,
  `User_Name` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kitchen_login`
--

INSERT INTO `kitchen_login` (`kitchen_id`, `User_Name`, `Password`) VALUES
(1, 'chef', 'chef9803');

-- --------------------------------------------------------

--
-- Table structure for table `login_table`
--

CREATE TABLE `login_table` (
  `login_id` int(11) NOT NULL,
  `table_id` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_table`
--

INSERT INTO `login_table` (`login_id`, `table_id`) VALUES
(1, 'table1'),
(2, 'table2'),
(3, 'table3'),
(4, 'table4');

-- --------------------------------------------------------

--
-- Table structure for table `menu_items`
--

CREATE TABLE `menu_items` (
  `Id` int(10) NOT NULL,
  `Menu_Type` varchar(50) NOT NULL,
  `Item_Name` varchar(50) NOT NULL,
  `Item_Price` varchar(50) NOT NULL,
  `Image` varchar(50) NOT NULL,
  `Description` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menu_items`
--

INSERT INTO `menu_items` (`Id`, `Menu_Type`, `Item_Name`, `Item_Price`, `Image`, `Description`) VALUES
(13, 'Khaja Set', 'Newari Khaja Set', '100', '354847.jpg', 'Newari culture food consist of gundhruk,bara,chiura.'),
(14, 'Khaja Set', 'Tass Set', '80', '461535.jpg', 'buff fried'),
(15, 'Khaja Set', 'Bhutan Chiura Set', '80', '118956.jpg', 'Bhutan and Chiura its a newari khaja'),
(16, 'Dry Food', 'Gundhruk Sandheko', '50', '209564.jpg', 'mixed of spicy and gundhruk'),
(17, 'Dry Food', 'Aloo Sandheko', '40', '83562.jpg', 'mixed of spicy and aloo'),
(18, 'Dry Food', 'Bhatmas Sandheko', '50', '249265.jpg', 'mixed of spicy and bhatmas'),
(19, 'Fried', 'Sausage Fried', '40', '874599.jpg', 'sausage fried'),
(20, 'Fried', 'Buff Sukuti Fried', '80', '931318.jpg', 'buff sukuti fried'),
(21, 'Spicy', 'Chicken Chilly', '100', '168811.jpg', 'chicken mixed with chilly,onion.'),
(22, 'Spicy', 'Buff Chilly', '80', '265061.jpg', 'buff with chilly,onion.'),
(24, 'Appetizer', 'Nachos', '150', '502099.jpeg', 'crispy and crunchy'),
(25, 'Appetizer', 'crosscent', '200', '256719.jpeg', 'delicious for mouth'),
(26, 'Beverage', 'somersby', '150', '827941.jpg', 'for thirsty neck'),
(27, 'Beverage', 'somersby', '150', '613882.jpg', 'chillled'),
(28, 'Beverage', 'vodka', '500', '722673.png', 'joy of drinking'),
(29, 'Beverage', 'budweiser', '350', '625201.jpg', 'king of beers'),
(30, 'Appetizer', 'fried meat', '440', '609901.jpeg', 'feels like eating more and more'),
(31, 'Appetizer', 'pork meat', '250', '743275.jpeg', 'vanishes when gets inside '),
(32, 'Fast food', 'Momo', '170', '537886.jpg', 'mouth tempting'),
(33, 'Fast food', 'Pizza', '350', '97782.jpg', 'cheesy'),
(34, 'Fast food', 'chowmein', '140', '749749.jpg', 'spicy'),
(35, 'Appetizer', 'Cream flourished', '350', '368312.jpeg', 'made from butter and cream'),
(36, 'Fast food', 'spagetthi', '200', '260218.jpg', 'mouth watering'),
(37, 'Fast food', 'Burger', '350', '857615.jpg', 'for hungry stomach'),
(38, 'Appetizer', 'butter stakes', '225', '551661.jpeg', 'purified butter'),
(39, 'Deserts', 'Ice cream', '150', '796674.jpg', 'creamy and cold'),
(40, 'Nepali Specialities', 'Newari Khaja Set', '300', '302058.jpg', 'feeds hungry stomach'),
(41, 'Nepali Specialities', 'bara', '140', '674650.jpg', 'touch of newari flavour'),
(42, 'Fast food', 'Pakoda', '60', '389896.jpg', 'red as chilli '),
(43, 'Nepali Specialities', 'Nepali khaja', '300', '672565.jpg', 'fun with family'),
(44, 'Deserts', 'choclate icecream', '170', '142831.jpeg', 'choclaty'),
(45, 'Deserts', 'Vanilla icecream', '150', '395804.jpeg', 'creamy'),
(46, 'Nepali Specialities', 'Thakali khaja set', '300', '289821.jpeg', 'feeds hungry tummy'),
(47, 'Dinner', 'full chicken', '900', '218993.jpeg', 'heavy meal'),
(48, 'Breakfast', 'Pan cakes', '220', '543601.jpeg', 'tasty'),
(49, 'Breakfast', 'Bread and omlet', '270', '223184.jpeg', 'morning munch'),
(50, 'Dinner', 'khana set', '290', '266268.jpeg', 'feeds hungry stomach'),
(51, 'Biryani', 'chicken biryani', '220', '454471.jpeg', 'mouth wavering chicken and rice dish'),
(52, 'Biryani', 'Mutton biryani', '320', '323932.jpeg', 'mutton with rice'),
(53, 'Biryani', 'Egg biryani', '200', '875003.jpeg', 'magic of egg'),
(54, 'Biryani', 'Veg biryani', '180', '188855.jpeg', 'for veggies'),
(55, 'Lunch', 'Lunch Item', '200', '177274.jpg', 'Daal,rice,fish and other');

-- --------------------------------------------------------

--
-- Table structure for table `order_food`
--

CREATE TABLE `order_food` (
  `Id` int(10) NOT NULL,
  `Item_name` varchar(50) NOT NULL,
  `Item_price` int(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `table_id` varchar(30) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Triggers `order_food`
--
DELIMITER $$
CREATE TRIGGER `order_payment` BEFORE DELETE ON `order_food` FOR EACH ROW BEGIN
insert into  payment
	(Item_name,
     Item_price,
     quantity,
     pay_time,
     order_time,
     table_id) 
VALUES(old.Item_name,
       old.Item_price,
       old.quantity,
   		CURRENT_TIMESTAMP,
    	old.time,
        old.table_id); 
  
  END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `Item_name` varchar(30) NOT NULL,
  `Item_price` varchar(30) NOT NULL,
  `quantity` int(11) NOT NULL,
  `pay_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `order_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `table_id` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`Item_name`, `Item_price`, `quantity`, `pay_time`, `order_time`, `table_id`) VALUES
('Lunch Item', '800', 4, '2017-02-23 06:42:32', '2017-02-23 03:18:31', 'table1'),
('Nachos', '1650', 11, '2017-02-23 06:42:32', '2017-02-23 03:18:31', 'table1'),
('crosscent', '800', 4, '2017-02-23 06:42:32', '2017-02-23 04:39:24', 'table1'),
('crosscent', '800', 4, '2017-02-23 07:32:37', '2017-02-23 07:28:20', 'table2'),
('Lunch Item', '800', 4, '2017-02-23 07:32:37', '2017-02-23 07:28:21', 'table2'),
('Nachos', '600', 4, '2017-02-23 07:32:37', '2017-02-23 07:31:34', 'table2'),
('Chicken', '200', 2, '2017-02-24 06:10:40', '2017-02-23 11:53:32', 'table1'),
('Nachos', '600', 4, '2017-02-24 06:30:21', '2017-02-24 06:30:01', 'table2'),
('crosscent', '1200', 6, '2017-02-24 06:30:21', '2017-02-24 06:30:02', 'table2'),
('Pan cakes', '1540', 7, '2017-02-24 06:33:01', '2017-02-24 06:32:03', 'table2'),
('Nachos', '750', 5, '2017-02-24 06:33:01', '2017-02-24 06:32:03', 'table2'),
('Nachos', '600', 4, '2017-02-24 06:33:01', '2017-02-24 06:32:29', 'table2'),
('Nachos', '600', 4, '2017-02-25 06:20:10', '2017-02-24 18:52:04', 'table1'),
('Newari Khaja Set', '500', 5, '2017-02-25 06:20:10', '2017-02-24 18:52:09', 'table1'),
('Nachos', '600', 4, '2017-02-25 07:08:09', '2017-02-25 07:07:49', 'table1'),
('Pan cakes', '880', 4, '2017-02-25 07:08:09', '2017-02-25 07:07:49', 'table1'),
('chicken biryani', '880', 4, '2017-02-25 08:56:00', '2017-02-25 07:08:57', 'table1'),
('chicken biryani', '880', 4, '2017-02-25 08:56:00', '2017-02-25 07:09:00', 'table1'),
('Nachos', '600', 4, '2017-02-25 08:56:00', '2017-02-25 07:09:36', 'table1'),
('Pan cakes', '220', 1, '2017-02-25 08:56:00', '2017-02-25 08:04:48', 'table1'),
('Lunch Item', '800', 4, '2017-02-25 08:56:00', '2017-02-25 08:04:48', 'table1'),
('Nachos', '300', 2, '2017-02-25 08:56:00', '2017-02-25 08:04:48', 'table1'),
('Lunch Item', '1000', 5, '2017-02-25 08:56:00', '2017-02-25 08:05:39', 'table1'),
('chicken biryani', '880', 4, '2017-02-25 08:56:00', '2017-02-25 08:05:40', 'table1'),
('Nachos', '450', 3, '2017-02-25 08:56:00', '2017-02-25 08:55:05', 'table1'),
('crosscent', '400', 2, '2017-02-25 08:56:00', '2017-02-25 08:55:06', 'table1'),
('Lunch Item', '800', 4, '2017-02-25 08:56:00', '2017-02-25 08:55:06', 'table1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account_login`
--
ALTER TABLE `account_login`
  ADD PRIMARY KEY (`account_id`);

--
-- Indexes for table `favourite`
--
ALTER TABLE `favourite`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `kitchen`
--
ALTER TABLE `kitchen`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `kitchen_login`
--
ALTER TABLE `kitchen_login`
  ADD PRIMARY KEY (`kitchen_id`);

--
-- Indexes for table `login_table`
--
ALTER TABLE `login_table`
  ADD PRIMARY KEY (`login_id`),
  ADD UNIQUE KEY `table_id` (`table_id`);

--
-- Indexes for table `menu_items`
--
ALTER TABLE `menu_items`
  ADD UNIQUE KEY `Id` (`Id`);

--
-- Indexes for table `order_food`
--
ALTER TABLE `order_food`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account_login`
--
ALTER TABLE `account_login`
  MODIFY `account_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `favourite`
--
ALTER TABLE `favourite`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;
--
-- AUTO_INCREMENT for table `kitchen`
--
ALTER TABLE `kitchen`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `kitchen_login`
--
ALTER TABLE `kitchen_login`
  MODIFY `kitchen_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `login_table`
--
ALTER TABLE `login_table`
  MODIFY `login_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `menu_items`
--
ALTER TABLE `menu_items`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;
--
-- AUTO_INCREMENT for table `order_food`
--
ALTER TABLE `order_food`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
