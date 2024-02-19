-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 11:43 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `online_portrait_selling_mgt`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `fname` varchar(100) DEFAULT NULL,
  `lname` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `martial_status` varchar(100) DEFAULT NULL,
  `DoB` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`fname`, `lname`, `phone`, `gender`, `martial_status`, `DoB`, `email`, `password`) VALUES
('aline', 'umutesi', '0734565656', 'Female', 'single', '2001', 'alinemutesi@gmail.com', 'aln'),
('murara', 'alex', '0789888999', 'Male', 'maried', '1999', 'alex@gmail.com', 'eerr'),
('', '', '', 'Male', '', '1988', '', ''),
('', '', '', 'Male', '', '1988', '', ''),
('', '', '', 'Male', '', '1988', '', ''),
('', '', '', 'Male', '', '1988', '', ''),
('winner', 'mwezi', '0789898322', 'Female', 'single', '2000', 'winner@gmail.com', '54');

-- --------------------------------------------------------

--
-- Table structure for table `artist`
--

CREATE TABLE `artist` (
  `Artist_id` int(11) NOT NULL,
  `Names` varchar(225) NOT NULL,
  `Age` varchar(10) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Nationality` varchar(200) NOT NULL,
  `Experience` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `artist`
--

INSERT INTO `artist` (`Artist_id`, `Names`, `Age`, `Gender`, `Nationality`, `Experience`) VALUES
(1, 'medy', '34', 'Male', 'rwanda', 'singing'),
(2, 'knowless', '32', 'Female', 'rwanda', 'sing  and write'),
(3, 'karasira', '38', 'Female', 'rwanda', ' write song'),
(4, 'rihanna', '42', 'Female', 'USA', 'best sing');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Customer_id` int(11) NOT NULL,
  `First_name` varchar(225) NOT NULL,
  `Last_name` varchar(200) NOT NULL,
  `Age` varchar(20) NOT NULL,
  `Phone_number` varchar(10) DEFAULT NULL,
  `Creditcard_id` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Customer_id`, `First_name`, `Last_name`, `Age`, `Phone_number`, `Creditcard_id`) VALUES
(1, 'viviane', 'annet', '23', '0789898989', '213'),
(2, 'emmy', 'uwayo', '34', '073433223', '21'),
(3, 'emile', 'jmv', '32', '0722354455', '5467');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `Order_id` int(11) NOT NULL,
  `Customer_id` int(11) DEFAULT NULL,
  `Date_and_time` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`Order_id`, `Customer_id`, `Date_and_time`) VALUES
(1, 2, '2024-03-05'),
(2, 3, '2023-01-08'),
(3, 2, '2022-11-06'),
(4, 3, '2021-10-10');

-- --------------------------------------------------------

--
-- Table structure for table `portrait`
--

CREATE TABLE `portrait` (
  `Portrait_id` int(11) NOT NULL,
  `Artist_id` int(11) DEFAULT NULL,
  `Warehouse_id` int(11) DEFAULT NULL,
  `Portrait_name` varchar(200) NOT NULL,
  `Portrait_cost` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `portrait`
--

INSERT INTO `portrait` (`Portrait_id`, `Artist_id`, `Warehouse_id`, `Portrait_name`, `Portrait_cost`) VALUES
(1, 2, 3, 'shiped', '5000'),
(3, 1, 2, 'tryzzds', '450000'),
(4, 1, 2, 'buying', '100000');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `Transaction_id` int(11) NOT NULL,
  `Order_id` int(11) DEFAULT NULL,
  `Portrait_id` int(11) DEFAULT NULL,
  `Transaction_Date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`Transaction_id`, `Order_id`, `Portrait_id`, `Transaction_Date`) VALUES
(2, 3, 1, '2023-05-03'),
(3, 2, 3, '2023-04-09'),
(4, 1, 4, '2024-12-05');

-- --------------------------------------------------------

--
-- Table structure for table `warehouse`
--

CREATE TABLE `warehouse` (
  `Warehouse_id` int(11) NOT NULL,
  `Order_id` int(11) DEFAULT NULL,
  `Location` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `warehouse`
--

INSERT INTO `warehouse` (`Warehouse_id`, `Order_id`, `Location`) VALUES
(1, 2, 'Kacyiru'),
(2, 3, 'ngarama'),
(3, 2, 'butare'),
(5, 1, 'gisagara');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artist`
--
ALTER TABLE `artist`
  ADD PRIMARY KEY (`Artist_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Customer_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`Order_id`),
  ADD KEY `Customer_id` (`Customer_id`);

--
-- Indexes for table `portrait`
--
ALTER TABLE `portrait`
  ADD PRIMARY KEY (`Portrait_id`),
  ADD KEY `Artist_id` (`Artist_id`),
  ADD KEY `Warehouse_id` (`Warehouse_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`Transaction_id`),
  ADD KEY `Order_id` (`Order_id`),
  ADD KEY `Portrait_id` (`Portrait_id`);

--
-- Indexes for table `warehouse`
--
ALTER TABLE `warehouse`
  ADD PRIMARY KEY (`Warehouse_id`),
  ADD KEY `Order_id` (`Order_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artist`
--
ALTER TABLE `artist`
  MODIFY `Artist_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `Customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `Order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `portrait`
--
ALTER TABLE `portrait`
  MODIFY `Portrait_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `Transaction_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `warehouse`
--
ALTER TABLE `warehouse`
  MODIFY `Warehouse_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`Customer_id`) REFERENCES `customer` (`Customer_id`);

--
-- Constraints for table `portrait`
--
ALTER TABLE `portrait`
  ADD CONSTRAINT `portrait_ibfk_1` FOREIGN KEY (`Artist_id`) REFERENCES `artist` (`Artist_id`),
  ADD CONSTRAINT `portrait_ibfk_2` FOREIGN KEY (`Warehouse_id`) REFERENCES `warehouse` (`Warehouse_id`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`Order_id`) REFERENCES `orders` (`Order_id`),
  ADD CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`Portrait_id`) REFERENCES `portrait` (`Portrait_id`);

--
-- Constraints for table `warehouse`
--
ALTER TABLE `warehouse`
  ADD CONSTRAINT `warehouse_ibfk_1` FOREIGN KEY (`Order_id`) REFERENCES `orders` (`Order_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
