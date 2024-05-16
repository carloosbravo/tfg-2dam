-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-05-2024 a las 13:29:53
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cooperup`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `centro`
<<<<<<< HEAD:BBDD/cooperup.sql
--
=======
<<<<<<< Updated upstream:BBDD/coperUP.sql
CREATE database cooperup;
USE cooperup;
>>>>>>> Spring:BBDD/coperUP.sql

=======
--
CREATE DATABASE cooperapp;
use cooperapp;
>>>>>>> Stashed changes:BBDD/cooperup.sql
CREATE TABLE `centro` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `contraseña` varchar(255) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `centro`
--

INSERT INTO `centro` (`id`, `nombre`, `email`, `direccion`, `contraseña`, `telefono`) VALUES
(1, 'Centro1', 'centro1@example.com', 'Dirección Centro 1', 'contraseña1', '123456789'),
(2, 'Centro2', 'centro2@example.com', 'Dirección Centro 2', 'contraseña2', '987654321'),
(3, 'Centro3', 'centro3@example.com', 'Dirección Centro 3', 'contraseña3', '111111111'),
(4, 'Centro4', 'centro4@example.com', 'Dirección Centro 4', 'contraseña4', '222222222'),
(5, 'Centro5', 'centro5@example.com', 'Dirección Centro 5', 'contraseña5', '333333333'),
(6, 'IFP', 'ifp@ifp.com', 'Calle Alcalá', 'contraseñaIFP', '111111111');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `contraseña` varchar(255) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `biografia` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`id`, `nombre`, `email`, `contraseña`, `direccion`, `telefono`, `biografia`) VALUES
(1, 'Empresa1', 'empresa1@example.com', 'contraseña1', 'Dirección Empresa 1', '123456789', 'Biografía Empresa 1'),
(2, 'Empresa2', 'empresa2@example.com', 'contraseña2', 'Dirección Empresa 2', '987654321', 'Biografía Empresa 2'),
(3, 'Empresa3', 'empresa3@example.com', 'contraseña3', 'Dirección Empresa 3', '555555555', 'Biografía Empresa 3'),
(4, 'Empresa4', 'empresa4@example.com', 'contraseña4', 'Dirección Empresa 4', '111111111', 'Biografía Empresa 4'),
(5, 'Empresa5', 'empresa5@example.com', 'contraseña5', 'Dirección Empresa 5', '999999999', 'Biografía Empresa 5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta`
--

CREATE TABLE `oferta` (
  `id` int(11) NOT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `id_practica` int(11) NOT NULL,
  `id_estudiante` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `practica`
--

CREATE TABLE `practica` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `id_empresa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarionormal`
--

CREATE TABLE `usuarionormal` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `contraseña` varchar(255) NOT NULL,
  `cv` text DEFAULT NULL,
  `expediente_academico` text DEFAULT NULL,
  `valoracion_profesorado` varchar(100) DEFAULT NULL,
  `centro_id` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarionormal`
--

INSERT INTO `usuarionormal` (`id`, `nombre`, `email`, `contraseña`, `cv`, `expediente_academico`, `valoracion_profesorado`, `centro_id`, `telefono`) VALUES
(1, 'Usuario1', 'usuario1@example.com', 'contrasena1', 'CV Usuario 1', 'Expediente Usuario 1', 'Buena', 1, NULL),
(2, 'Usuario2', 'usuario2@example.com', 'contraseña2', 'CV Usuario 2', 'Expediente Usuario 2', 'Excelente', 2, NULL),
(3, 'Usuario3', 'usuario3@example.com', 'contraseña3', 'CV Usuario 3', 'Expediente Usuario 3', 'Muy Buena', 3, NULL),
(4, 'Usuario4', 'usuario4@example.com', 'contraseña4', 'CV Usuario 4', 'Expediente Usuario 4', 'Regular', 4, NULL),
(5, 'Usuario5', 'usuario5@example.com', 'contraseña5', 'CV Usuario 5', 'Expediente Usuario 5', 'Muy Mala', 5, NULL),
(6, 'gonzalito', 'gonzalo@example.com', 'contrasena98', 'CV gonza', 'Expediente gonza', 'Malisimo', 2, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `centro`
--
ALTER TABLE `centro`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_practica` (`id_practica`),
  ADD KEY `id_estudiante` (`id_estudiante`);

--
-- Indices de la tabla `practica`
--
ALTER TABLE `practica`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_empresa` (`id_empresa`);

--
-- Indices de la tabla `usuarionormal`
--
ALTER TABLE `usuarionormal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `centro_id` (`centro_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `centro`
--
ALTER TABLE `centro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `practica`
--
ALTER TABLE `practica`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarionormal`
--
ALTER TABLE `usuarionormal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD CONSTRAINT `oferta_ibfk_1` FOREIGN KEY (`id_estudiante`) REFERENCES `usuarionormal` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `oferta_ibfk_2` FOREIGN KEY (`id_practica`) REFERENCES `practica` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `practica`
--
ALTER TABLE `practica`
  ADD CONSTRAINT `practica_ibfk_1` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarionormal`
--
ALTER TABLE `usuarionormal`
  ADD CONSTRAINT `usuarionormal_ibfk_1` FOREIGN KEY (`centro_id`) REFERENCES `centro` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
