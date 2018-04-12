-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 05, 2018 at 06:46 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `toeic`
--

-- --------------------------------------------------------

--
-- Table structure for table `cau_hoi`
--

CREATE TABLE `cau_hoi` (
  `ma_cau_hoi` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `cau_hoi` text COLLATE utf8_unicode_ci NOT NULL,
  `ma_dap_an` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dap_an`
--

CREATE TABLE `dap_an` (
  `ma_dap_an` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ma_cau_hoi` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dap_an` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `diem`
--

CREATE TABLE `diem` (
  `ma_diem` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ma_nguoi_dung` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `diem` double NOT NULL,
  `ngay_lam_bai` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nguoi_dung`
--

CREATE TABLE `nguoi_dung` (
  `ma_nguoi_dung` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ten_dang_nhap` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `mat_khau` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ho_va_ten_lot` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `ten` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `loai_quyen` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nguoi_dung`
--

INSERT INTO `nguoi_dung` (`ma_nguoi_dung`, `ten_dang_nhap`, `mat_khau`, `ho_va_ten_lot`, `ten`, `loai_quyen`) VALUES
('04a2a430-c3d7-45fa-9f47-b4796357454f', 'user', '123', 'Nguyen Van', 'A', 0),
('0b33e7c0-d4ff-4ebb-8757-bd8bd21d8116', 'user2', '123', 'Nguyen Van', 'B', 0),
('29cb1e2d-431f-460a-9aec-b8e9c5f9473c', 'user 3', '123', 'user', '3', 0),
('4e984847-7529-48a6-ac70-4aeb70b29b0c', 'toan', '123', 'Doan Thai', 'Toan', 1),
('9d11892c-5846-4721-bbcc-5a428ec850aa', 'admin', '123', 'Tiêu C?m', 'Thành', 1),
('acda90ab-7bec-4df7-9208-66257d781d9d', 'user3', '123', 'user ', '3', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cau_hoi`
--
ALTER TABLE `cau_hoi`
  ADD PRIMARY KEY (`ma_cau_hoi`),
  ADD KEY `fk_cau_hoi_dap_an` (`ma_dap_an`);

--
-- Indexes for table `dap_an`
--
ALTER TABLE `dap_an`
  ADD PRIMARY KEY (`ma_dap_an`),
  ADD KEY `fk_dap_an_cau_hoi` (`ma_cau_hoi`);

--
-- Indexes for table `diem`
--
ALTER TABLE `diem`
  ADD PRIMARY KEY (`ma_diem`),
  ADD KEY `fk_diem_nguoi_dung` (`ma_nguoi_dung`);

--
-- Indexes for table `nguoi_dung`
--
ALTER TABLE `nguoi_dung`
  ADD PRIMARY KEY (`ma_nguoi_dung`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cau_hoi`
--
ALTER TABLE `cau_hoi`
  ADD CONSTRAINT `fk_cau_hoi_dap_an` FOREIGN KEY (`ma_dap_an`) REFERENCES `dap_an` (`ma_dap_an`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `dap_an`
--
ALTER TABLE `dap_an`
  ADD CONSTRAINT `fk_dap_an_cau_hoi` FOREIGN KEY (`ma_cau_hoi`) REFERENCES `cau_hoi` (`ma_cau_hoi`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `diem`
--
ALTER TABLE `diem`
  ADD CONSTRAINT `fk_diem_nguoi_dung` FOREIGN KEY (`ma_nguoi_dung`) REFERENCES `nguoi_dung` (`ma_nguoi_dung`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
