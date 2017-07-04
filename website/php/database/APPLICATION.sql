CREATE DATABASE IF NOT EXISTS APPLICATION;
USE APPLICATION;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `APPLICATION`
--

-- --------------------------------------------------------

--
-- Table structure for table `APPLICATION`
--

CREATE TABLE IF NOT EXISTS `APPLICATION` (
  `APP_ID` int(11) NOT NULL,
  `APP_NAME` varchar(32) NOT NULL,
  `APP_PACKAGE` varchar(64) NOT NULL,
  `APP_IMAGE` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `VERSION`
--

CREATE TABLE IF NOT EXISTS `VERSION` (
  `ID` int(11) NOT NULL,
  `VERSION` varchar(12) NOT NULL,
  `CODE` int(11) NOT NULL,
  `URL` varchar(64) NOT NULL,
  `COMMENT` varchar(164) NOT NULL,
  `DATE` datetime NOT NULL,
  `APP_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

ALTER TABLE `APPLICATION`
  ADD PRIMARY KEY (`APP_ID`),
  ADD UNIQUE KEY `APP_ID` (`APP_ID`),
  ADD UNIQUE KEY `APP_PACKAGE` (`APP_PACKAGE`);

ALTER TABLE `VERSION`
  ADD PRIMARY KEY (`ID`);


ALTER TABLE `APPLICATION`
  MODIFY `APP_ID` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `VERSION`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
