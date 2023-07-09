-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 13, 2022 at 12:28 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oopproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `ID` int(50) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Job_Description` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Tel_No` varchar(10) DEFAULT NULL,
  `Username` varchar(50) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  `Confirm_Password` varchar(50) DEFAULT NULL,
  `Admin_Status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`ID`, `Name`, `Job_Description`, `Email`, `Tel_No`, `Username`, `Password`, `Confirm_Password`, `Admin_Status`) VALUES
(1, 'Kavindu Amesh Rankothge', 'Administrator', 'ameshrankothge@gmail.com', '0766367138', 'kavindu', '12345', '12345', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Cus_ID` int(12) NOT NULL,
  `Name` varchar(155) NOT NULL,
  `NIC` varchar(10) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Tel_NO` int(11) NOT NULL,
  `Email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Cus_ID`, `Name`, `NIC`, `Address`, `Tel_NO`, `Email`) VALUES
(4, 'dev', '0123455', 'gampaha', 12345, 'avindi');

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `event_id` int(10) NOT NULL,
  `customer_name` varchar(150) NOT NULL,
  `date` varchar(100) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `budget` varchar(100) DEFAULT NULL,
  `services` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `Pay_id` int(100) NOT NULL,
  `Customer_Name` varchar(50) DEFAULT NULL,
  `Full_Pay` varchar(100) DEFAULT NULL,
  `Advanced_Pay` varchar(100) DEFAULT NULL,
  `Card_No` varchar(100) DEFAULT NULL,
  `Date` varchar(100) DEFAULT NULL,
  `cvv` varchar(10) DEFAULT NULL,
  `Feedback` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Cus_ID`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`event_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`Pay_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `administrator`
--
ALTER TABLE `administrator`
  MODIFY `ID` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `Cus_ID` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `event_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `Pay_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
