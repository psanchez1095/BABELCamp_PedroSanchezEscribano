-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-03-2022 a las 10:02:23
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empresacoches`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coches`
--

CREATE TABLE `coches` (
  `id` int(11) NOT NULL,
  `matricula` varchar(7) DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `numeroKilometros` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `coches`
--

INSERT INTO `coches` (`id`, `matricula`, `marca`, `modelo`, `numeroKilometros`) VALUES
(1, 'QWERTY0', 'SEAT', 'TOLEDO', 15325.5),
(2, 'ASDFGH7', 'SEAT', 'LEON', 65400);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `coches`
--
ALTER TABLE `coches`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `coches`
--
ALTER TABLE `coches`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
