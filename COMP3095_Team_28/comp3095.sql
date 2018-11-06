-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 28, 2018 at 07:25 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `comp3095`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `role` varchar(10) DEFAULT 'admin',
  `username` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `TimeStamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `firstname`, `lastname`, `email`, `role`, `username`, `address`, `password`, `salt`, `TimeStamp`) VALUES
(1, '', '', 'admin@domain.ca', NULL, '', '', 'P@ssword1', '', '2018-10-28 17:41:43'),
(2, 'Igor', 'Mori', 'igorKenji.Mori@georgebrown.ca', 'admin', 'igorKenji.Mori@georgebrown.ca', '145 Marlee ave', '12345', '', '2018-10-28 17:26:33'),
(3, 'Farhad', 'Hossain', 'Mdfarhad.hossain@georgebrown.ca', 'admin', 'Mdfarhad.hossain@georgebrown.ca', '2853 Dufferin', '12345', '', '2018-10-28 17:28:17'),
(4, 'Yash', 'Thanki', 'yash.thanki@georgebrown.ca', 'admin', 'yash.thanki@georgebrown.ca', '2365 Bloor Street', '12345', '', '2018-10-28 17:29:19'),
(5, 'Arifur', 'Rahman', 'arifur.rahman@georgebrown.ca', 'admin', 'arifur.rahman@georgebrown.ca', '18 yonge Street', '12345', '', '2018-10-28 17:30:34'),
(22, 'Igor', 'Mori', 'igor@gmail.com', 'client', 'igor@gmail.com', 'Marlee Ave, 811', 'TI6ouDNVX+WK0x1NjYkJeWVGdkbLMJBqoFan6gMJ6NU=', 'WMXg3nC11g0DRiAEgZ3Iv7UTMyCFJd', '2018-10-28 17:58:03'),
(23, 'yash', 'Thanki', 'yash@gmail.com', 'client', 'yash@gmail.com', 'Marlee Ave, 811', '61wXpV9pYE5HcYn6lzy52NGylpzTha0/EB5cVqMsP0A=', '5jpnnisjigRjkJoEjEiqHqrixAm6so', '2018-10-28 18:25:14');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
