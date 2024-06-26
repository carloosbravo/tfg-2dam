-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-05-2024 a las 19:43:08
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
-- drop database cooperup;
-- create database cooperup;
use cooperup;
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
(1, 'IFP', 'ifp@example.com', 'Calle Julian Camarillo 3', 'contrasena1', '123456789');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cv`
--

CREATE TABLE `cv` (
  `descripcion` varchar(100) NOT NULL,
  `estudios` varchar(100) NOT NULL,
  `lenguajes` varchar(1000) NOT NULL,
`idiomas` varchar(300) NOT NULL,
  `id_estudiante` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cv`
--

INSERT INTO `cv` (`descripcion`, `estudios`, `lenguajes`, `idiomas`, `id_estudiante`, `id`) VALUES
('Desarrollador con experiencia en aplicaciones web', 'Ingeniería Informática', 'JavaScript, HTML, CSS, Python', 'Inglés, Español', 1, 1),
('Analista de datos con habilidades en big data', 'Estadística', 'R, Python, SQL', 'Inglés, Francés', 2, 2),
('Especialista en marketing digital', 'Marketing', 'SEO, SEM, Google Analytics', 'Inglés, Alemán', 3, 3),
('Diseñador gráfico con un ojo para los detalles', 'Diseño Gráfico', 'Photoshop, Illustrator, InDesign', 'Inglés, Italiano', 4, 4),
('Experto en ciberseguridad con conocimientos avanzados', 'Ciberseguridad', 'Penetration Testing, Firewalls, Network Security', 'Inglés, Chino', 5, 5);


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
(1, 'Tech Innovations', 'info@techinnovations.com', 'tech2024', '123 Tech Lane', '1231231234', 'Leading the future of technology.'),
(2, 'Green Solutions', 'info@greensolutions.com', 'greenEco123', '456 Green Street', '9879879876', 'Providing sustainable solutions for a better planet.'),
(3, 'Health Plus', 'support@healthplus.com', 'healthStrong56', '789 Health Avenue', '5556667777', 'Committed to enhancing healthcare through innovation.');


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

--
-- Volcado de datos para la tabla `oferta`
--

INSERT INTO `oferta` (`id`, `estado`, `id_practica`, `id_estudiante`) VALUES
(1, 1, 1, 1),
(2, 1, 2, 2),
(3, 0, 3, 3),
(4, 1, 4, 4),
(5, 0, 5, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `practica`
--

CREATE TABLE `practica` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `id_empresa` int(11) NOT NULL,
  `titulo` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `practica`
--

INSERT INTO `practica` (`id`, `descripcion`, `id_empresa`, `titulo`) VALUES
(1, 'Práctica en desarrollo web', 1, 'Desarrollo Web'),
(2, 'Práctica en análisis de datos', 1, 'Análisis de Datos'),
(3, 'Práctica en marketing digital', 3, 'Marketing Digital'),
(4, 'Práctica en diseño gráfico', 2, 'Diseño Gráfico'),
(5, 'Práctica en ciberseguridad', 2, 'Ciberseguridad'),
(6, 'Práctica en inteligencia artificial', 3, 'Inteligencia Artificial'),
(7, 'Práctica en gestión de proyectos', 3, 'Gestión de Proyectos'),
(8, 'Práctica en desarrollo apps móviles', 1, 'Desarrollo de Aplicaciones Móviles'),
(9, 'Práctica en soporte técnico', 2, 'Soporte Técnico'),
(10, 'Práctica en consultoría empresarial', 2, 'Consultoría Empresarial');


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarionormal`
--

CREATE TABLE `usuarionormal` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `contraseña` varchar(255) NOT NULL,
  `dni` text DEFAULT NULL,
  `grado` varchar(100) DEFAULT NULL,
  `centro_id` int(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarionormal`
--

INSERT INTO `usuarionormal` (`id`, `nombre`, `email`, `contraseña`, `dni`, `grado`, `centro_id`, `telefono`) VALUES
(1, 'Juan Perez', 'juan@example.com', 'contrasena1', '12345678A', 'Desarrollo de Aplicaciones Multiplataforma', 1, 600123456),
(2, 'Maria Lopez', 'maria.lopez@example.com', 'password456', '87654321B', 'Administración de Sistemas Informáticos en Red', 1, 600654321),
(3, 'Carlos Garcia', 'carlos.garcia@example.com', 'pass789', '11223344C', 'Desarrollo de Aplicaciones Web', 1, 600789123),
(4, 'Ana Fernandez', 'ana.fernandez@example.com', 'mypass321', '44332211D', 'Sistemas Microinformáticos y Redes', 1, 600321789),
(5, 'Luis Martinez', 'luis.martinez@example.com', 'securepass654', '55667788E', 'Ciberseguridad', 1, 600987654);


--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `centro`
--
ALTER TABLE `centro`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cv`
--
ALTER TABLE `cv`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_estudiante` (`id_estudiante`);

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
  
  ALTER TABLE `oferta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `cv`
--
ALTER TABLE `cv`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `practica`
--
ALTER TABLE `practica`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuarionormal`
--
ALTER TABLE `usuarionormal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cv`
--
ALTER TABLE `cv`
  ADD CONSTRAINT `cv_ibfk_1` FOREIGN KEY (`id_estudiante`) REFERENCES `usuarionormal` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

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
