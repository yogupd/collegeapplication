-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 28, 2018 at 11:41 AM
-- Server version: 5.6.38
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `college`
--

-- --------------------------------------------------------

--
-- Table structure for table `attandence`
--

CREATE TABLE `attandence` (
  `studentId` int(10) NOT NULL DEFAULT '0',
  `date` date NOT NULL,
  `courseId` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `branches`
--

CREATE TABLE `branches` (
  `Id` int(2) NOT NULL,
  `name` varchar(22) NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `branches`
--

INSERT INTO `branches` (`Id`, `name`, `address`, `phone`) VALUES
(2, 'Cork Branch', 'Cork Street', 1234);

-- --------------------------------------------------------

--
-- Table structure for table `calender`
--

CREATE TABLE `calender` (
  `courseId` int(2) DEFAULT NULL,
  `name` varchar(55) NOT NULL,
  `detail` varchar(55) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `Id` int(2) NOT NULL DEFAULT '0',
  `name` int(11) NOT NULL,
  `courseYearId` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `courseStudentResult`
--

CREATE TABLE `courseStudentResult` (
  `courseId` int(2) DEFAULT NULL,
  `studentId` int(10) DEFAULT NULL,
  `assignMarks` double(3,1) NOT NULL,
  `examMarks` double(3,1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `courseYear`
--

CREATE TABLE `courseYear` (
  `Id` int(10) NOT NULL DEFAULT '0',
  `name` varchar(55) NOT NULL,
  `fees` double(4,3) NOT NULL,
  `branchId` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `fees`
--

CREATE TABLE `fees` (
  `Id` int(10) NOT NULL,
  `studentId` int(10) DEFAULT NULL,
  `courseYearId` int(2) DEFAULT NULL,
  `feePaid` double(6,2) NOT NULL,
  `feeDue` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `fees`
--

INSERT INTO `fees` (`Id`, `studentId`, `courseYearId`, `feePaid`, `feeDue`) VALUES
(1, 3, 1, 2999.00, 'N'),
(2, 3, 2, 120.00, 'Y');

-- --------------------------------------------------------

--
-- Table structure for table `lecturerCourse`
--

CREATE TABLE `lecturerCourse` (
  `lecturerId` int(6) NOT NULL,
  `courseId` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `lecturerDetail`
--

CREATE TABLE `lecturerDetail` (
  `userId` int(10) NOT NULL DEFAULT '0',
  `qualification` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `studentDetail`
--

CREATE TABLE `studentDetail` (
  `userId` int(10) NOT NULL DEFAULT '0',
  `pastEducation` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(10) NOT NULL,
  `password` varchar(15) NOT NULL,
  `privilegeID` int(2) DEFAULT NULL,
  `branchId` int(2) DEFAULT NULL,
  `name` varchar(22) NOT NULL,
  `lname` varchar(20) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `sex` char(3) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `password`, `privilegeID`, `branchId`, `name`, `lname`, `dob`, `email`, `sex`, `address`) VALUES
(1, '123456', 1, 1, 'SuperAdmin', NULL, '0000-00-00', 'super@vgc.com', '', NULL),
(2, '1234', 2, 1, 'Lecturer', NULL, NULL, 'lecturer@vgc.com', NULL, NULL),
(3, '1234', 3, 1, 'Test Student', NULL, NULL, 'student@vgc.com', NULL, NULL),
(13, 'raju123', 3, 1, 'Raju', 'Upadhaya', '1992-05-06', 'raju@vgc.com', NULL, 'Dublin'),
(14, 'lect123', 2, 1, 'Lecturer', 'Test', '1950-05-01', 'testlect@vgc.com', NULL, 'Dorset College Dublin'),
(15, 'admin123', 1, 1, 'Hero', 'Admin', '2018-05-01', 'adminpower@vgc.com', NULL, 'SuperHero'),
(16, 'prabin', 3, 1, 'pabs', 'Prabin', '2018-05-31', 'pabs@vgc.com', NULL, 'dublin8'),
(17, 'yog123', 2, 1, 'Yog', 'lamic', '2015-05-06', 'yog@vgc.com', NULL, 'kildare');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attandence`
--
ALTER TABLE `attandence`
  ADD PRIMARY KEY (`studentId`);

--
-- Indexes for table `branches`
--
ALTER TABLE `branches`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `courseYear`
--
ALTER TABLE `courseYear`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `fees`
--
ALTER TABLE `fees`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `lecturerDetail`
--
ALTER TABLE `lecturerDetail`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `studentDetail`
--
ALTER TABLE `studentDetail`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `branches`
--
ALTER TABLE `branches`
  MODIFY `Id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `fees`
--
ALTER TABLE `fees`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
