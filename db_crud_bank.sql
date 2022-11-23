-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 23-11-2022 a las 02:44:02
-- Versión del servidor: 5.7.33
-- Versión de PHP: 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_crud_bank`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `td_debt_user`
--

CREATE TABLE `td_debt_user` (
  `id` bigint(20) NOT NULL,
  `cuotas` int(11) DEFAULT NULL,
  `deuda` float NOT NULL,
  `id_banco` bigint(20) NOT NULL,
  `id_cliente` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Volcado de datos para la tabla `td_debt_user`
--

INSERT INTO `td_debt_user` (`id`, `cuotas`, `deuda`, `id_banco`, `id_cliente`) VALUES
(1, 2, 500, 1, 1),
(2, 1, 200, 2, 1),
(3, 4, 1000, 11, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tm_bank`
--

CREATE TABLE `tm_bank` (
  `id` bigint(20) NOT NULL,
  `nombre_banco` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Volcado de datos para la tabla `tm_bank`
--

INSERT INTO `tm_bank` (`id`, `nombre_banco`) VALUES
(1, 'BANCOLOMBIA'),
(2, 'BANCO DE BOGOTA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tm_cliente`
--

CREATE TABLE `tm_cliente` (
  `id_cliente` int(11) NOT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `apellido` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `email` varchar(150) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Volcado de datos para la tabla `tm_cliente`
--

INSERT INTO `tm_cliente` (`id_cliente`, `nombre`, `apellido`, `email`, `password`) VALUES
(1, 'cristian', 'martinez', 'darkcam08@gmail.com', '123456'),
(2, 'antonio', 'corredor', 'corredor@gmail.com', '123ac');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tm_deuda`
--

CREATE TABLE `tm_deuda` (
  `id_deuda` int(11) NOT NULL,
  `banco` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `deuda` int(11) NOT NULL,
  `cuotas` int(11) NOT NULL,
  `abono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Volcado de datos para la tabla `tm_deuda`
--

INSERT INTO `tm_deuda` (`id_deuda`, `banco`, `deuda`, `cuotas`, `abono`) VALUES
(1, 'BANCOLOMBIA', 15000, 3, 15000),
(2, 'BANCO DE BOGOTA', 500000, 1, 20000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tm_user`
--

CREATE TABLE `tm_user` (
  `id_user` bigint(20) NOT NULL,
  `nombre` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `apellido` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `cedula` int(11) NOT NULL,
  `celular` int(11) NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Volcado de datos para la tabla `tm_user`
--

INSERT INTO `tm_user` (`id_user`, `nombre`, `apellido`, `cedula`, `celular`, `email`, `password`) VALUES
(4, 'Cristian Antonio', 'Martinez Fonseca', 1118549, 310817, 'test@test.com', '$2a$10$ZGN9/XgI4dHeyLzEtmw5CuS400YVKl0gMI7Yez9uTrTMpEdIUBEWq');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `td_debt_user`
--
ALTER TABLE `td_debt_user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_banco` (`id_banco`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indices de la tabla `tm_bank`
--
ALTER TABLE `tm_bank`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tm_cliente`
--
ALTER TABLE `tm_cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `tm_deuda`
--
ALTER TABLE `tm_deuda`
  ADD PRIMARY KEY (`id_deuda`);

--
-- Indices de la tabla `tm_user`
--
ALTER TABLE `tm_user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `td_debt_user`
--
ALTER TABLE `td_debt_user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tm_bank`
--
ALTER TABLE `tm_bank`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `tm_cliente`
--
ALTER TABLE `tm_cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tm_deuda`
--
ALTER TABLE `tm_deuda`
  MODIFY `id_deuda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tm_user`
--
ALTER TABLE `tm_user`
  MODIFY `id_user` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `td_debt_user`
--
ALTER TABLE `td_debt_user`
  ADD CONSTRAINT `td_debt_user_ibfk_1` FOREIGN KEY (`id_banco`) REFERENCES `tm_bank` (`id`),
  ADD CONSTRAINT `td_debt_user_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `tm_cliente` (`id_cliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
