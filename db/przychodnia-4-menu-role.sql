-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Czas wygenerowania: 25 Wrz 2014, 22:24
-- Wersja serwera: 5.5.8
-- Wersja PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `przychodnia2`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla  `menu_role`
--

CREATE TABLE IF NOT EXISTS `menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `menu_id` (`menu_id`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=21 ;

--
-- Zrzut danych tabeli `menu_role`
--

INSERT INTO `menu_role` (`id`, `menu_id`, `role_id`) VALUES
(7, 1, 1),
(8, 2, 1),
(9, 3, 1),
(10, 4, 1),
(11, 5, 1),
(12, 7, 1),
(13, 1, 2),
(17, 1, 3),
(18, 2, 3),
(19, 3, 3),
(20, 7, 5);

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `menu_role`
--
ALTER TABLE `menu_role`
  ADD CONSTRAINT `menu_role_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `menu_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
