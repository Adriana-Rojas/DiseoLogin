-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-08-2020 a las 12:20:34
-- Versión del servidor: 10.4.13-MariaDB
-- Versión de PHP: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `accesibilidad`
--

CREATE TABLE `accesibilidad` (
  `id` int(11) NOT NULL,
  `resolucion` int(11) NOT NULL,
  `lenguaje` int(11) NOT NULL,
  `fuente` int(11) NOT NULL,
  `contraste` int(11) NOT NULL,
  `idioma` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `accesibilidad`
--

INSERT INTO `accesibilidad` (`id`, `resolucion`, `lenguaje`, `fuente`, `contraste`, `idioma`) VALUES
(1, 7, 7, 7, 7, 7),
(2, 10, 10, 10, 10, 10),
(3, 5, 10, 10, 10, 10),
(4, 10, 10, 10, 10, 10),
(5, 10, 10, 10, 10, 10),
(6, 10, 10, 10, 10, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `id` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `telefono` text NOT NULL,
  `correo` text NOT NULL,
  `contraseña` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`id`, `nombre`, `telefono`, `correo`, `contraseña`) VALUES
(2, 'cesar', 'cesar', 'cesar@hotmail.com', 'cesar'),
(4, 'administrador', '6', 'admin', 'admin'),
(5, '', '', '', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignarresportes`
--

CREATE TABLE `asignarresportes` (
  `id` int(11) NOT NULL,
  `evaluador` int(11) NOT NULL,
  `listaaplicaciones` int(11) NOT NULL,
  `administrador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `asignarresportes`
--

INSERT INTO `asignarresportes` (`id`, `evaluador`, `listaaplicaciones`, `administrador`) VALUES
(14, 2, 819, 4),
(15, 4, 826, 4),
(16, 2, 819, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bateria`
--

CREATE TABLE `bateria` (
  `id` int(11) NOT NULL,
  `canticonsumida` int(11) NOT NULL,
  `consumomedbateria` int(11) NOT NULL,
  `calculobateria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `bateria`
--

INSERT INTO `bateria` (`id`, `canticonsumida`, `consumomedbateria`, `calculobateria`) VALUES
(1, 2, 2, 2),
(2, 0, 0, 0),
(3, 3, 3, 10),
(4, 3, 3, 5),
(5, 3, 3, 10),
(6, 3, 3, 10),
(7, 3, 3, 10),
(8, 3, 3, 10),
(9, 3, 3, 10),
(10, 3, 3, 1),
(11, 2, 2, 2),
(12, 2, 2, 2),
(13, 2, 2, 2),
(14, 2, 2, 2),
(15, 2, 2, 2),
(16, 2, 2, 2),
(17, 2, 2, 2),
(18, 2, 2, 2),
(19, 2, 2, 2),
(20, 2, 2, 2),
(21, 2, 2, 2),
(22, 2, 2, 2),
(23, 0, 0, 0),
(24, 3, 3, 10),
(25, 3, 3, 10),
(26, 3, 3, 10),
(27, 3, 3, 10),
(28, 3, 3, 10),
(29, 3, 3, 10),
(30, 3, 3, 10),
(31, 3, 3, 10),
(32, 3, 3, 10),
(33, 3, 3, 10),
(34, 3, 3, 10),
(35, 3, 3, 10),
(36, 3, 3, 10),
(37, 3, 3, 10),
(38, 3, 3, 10),
(39, 3, 3, 10),
(40, 3, 3, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calculousabilidad`
--

CREATE TABLE `calculousabilidad` (
  `id` int(11) NOT NULL,
  `calculousabilidad` int(11) NOT NULL,
  `valorrelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargacognitiva`
--

CREATE TABLE `cargacognitiva` (
  `id` int(11) NOT NULL,
  `usosimultaneo` int(11) NOT NULL,
  `calculoderelevancia` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cargacognitiva`
--

INSERT INTO `cargacognitiva` (`id`, `usosimultaneo`, `calculoderelevancia`) VALUES
(1, 2, 1),
(2, 3, 1),
(3, 4, 0),
(4, 6, 0.970874);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprensibilidad`
--

CREATE TABLE `comprensibilidad` (
  `id` int(11) NOT NULL,
  `rapidez` int(11) NOT NULL,
  `dificultad` int(11) NOT NULL,
  `aprendizaje` int(11) NOT NULL,
  `facilidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `comprensibilidad`
--

INSERT INTO `comprensibilidad` (`id`, `rapidez`, `dificultad`, `aprendizaje`, `facilidad`) VALUES
(1, 3, 3, 3, 3),
(2, 10, 10, 10, 10),
(3, 10, 10, 10, 10),
(4, 10, 9, 10, 10),
(5, 10, 10, 10, 10),
(6, 10, 10, 10, 10),
(7, 10, 10, 10, 10),
(8, 10, 10, 10, 10),
(9, 10, 10, 10, 10),
(10, 10, 10, 10, 10),
(11, 10, 10, 10, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `costoeconomico`
--

CREATE TABLE `costoeconomico` (
  `id` int(11) NOT NULL,
  `efectividadrelativatarea` int(11) NOT NULL,
  `costototal` int(11) NOT NULL,
  `calculocostoeconomico` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `costoeconomico`
--

INSERT INTO `costoeconomico` (`id`, `efectividadrelativatarea`, `costototal`, `calculocostoeconomico`) VALUES
(1, 2, 2, 0),
(2, 0, 0, 0),
(3, 3, 10, 0),
(4, 3, 5, 0),
(5, 3, 10, 0),
(6, 3, 10, 0),
(7, 3, 10, 0),
(8, 3, 10, 0),
(9, 3, 10, 0),
(10, 3, 1, 0),
(11, 2, 2, 0),
(12, 2, 2, 0),
(13, 2, 2, 0),
(14, 2, 2, 0),
(15, 2, 2, 0),
(16, 2, 2, 0),
(17, 2, 2, 0),
(18, 2, 2, 0),
(19, 2, 2, 0),
(20, 2, 2, 0),
(21, 2, 2, 0),
(22, 2, 2, 0),
(23, 0, 0, 0),
(24, 3, 10, 0),
(25, 3, 10, 0),
(26, 3, 10, 0),
(27, 3, 10, 0),
(28, 3, 10, 0),
(29, 3, 10, 0),
(30, 3, 1, 0),
(31, 3, 10, 0),
(32, 3, 10, 0),
(33, 3, 10, 0),
(34, 3, 1, 3),
(35, 3, 1, 3),
(36, 3, 10, 0),
(37, 3, 10, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cpu`
--

CREATE TABLE `cpu` (
  `id` int(11) NOT NULL,
  `consumocpu` int(11) NOT NULL,
  `consumomedcpu` int(11) NOT NULL,
  `consumomaxcpu` int(11) NOT NULL,
  `calculocpu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cpu`
--

INSERT INTO `cpu` (`id`, `consumocpu`, `consumomedcpu`, `consumomaxcpu`, `calculocpu`) VALUES
(1, 2, 2, 2, 2),
(2, 0, 0, 0, 0),
(3, 3, 3, 3, 10),
(4, 3, 3, 3, 5),
(5, 3, 3, 3, 10),
(6, 3, 3, 3, 10),
(7, 3, 3, 3, 10),
(8, 3, 3, 3, 10),
(9, 3, 3, 3, 10),
(10, 3, 3, 3, 1),
(11, 2, 2, 2, 2),
(12, 2, 2, 2, 2),
(13, 2, 2, 2, 2),
(14, 2, 2, 2, 2),
(15, 2, 2, 2, 2),
(16, 2, 2, 2, 2),
(17, 2, 2, 2, 2),
(18, 2, 2, 2, 2),
(19, 2, 2, 2, 2),
(20, 2, 2, 2, 2),
(21, 2, 2, 2, 2),
(22, 2, 2, 2, 2),
(23, 0, 0, 0, 0),
(24, 3, 3, 3, 10),
(25, 3, 3, 3, 10),
(26, 3, 3, 3, 10),
(27, 3, 3, 3, 10),
(28, 3, 3, 3, 10),
(29, 3, 3, 3, 10),
(30, 3, 3, 3, 10),
(31, 3, 3, 3, 10),
(32, 3, 3, 3, 10),
(33, 3, 3, 3, 10),
(34, 3, 3, 3, 10),
(35, 3, 3, 3, 10),
(36, 3, 3, 3, 10),
(37, 3, 3, 3, 10),
(38, 3, 3, 3, 10),
(39, 3, 3, 3, 10),
(40, 3, 3, 3, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cumplimientotarea`
--

CREATE TABLE `cumplimientotarea` (
  `id` int(11) NOT NULL,
  `efectividadtarea` int(11) NOT NULL,
  `tiempocompletar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cumplimientotarea`
--

INSERT INTO `cumplimientotarea` (`id`, `efectividadtarea`, `tiempocompletar`) VALUES
(1, 7, 4),
(2, 8, 5),
(3, 9, 6),
(4, 10, 7),
(5, 11, 8),
(6, 12, 9),
(7, 13, 10),
(8, 14, 11),
(9, 15, 12),
(10, 16, 13),
(11, 17, 14),
(12, 18, 15),
(13, 19, 16),
(14, 20, 17),
(15, 21, 18);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `efectividadtarea`
--

CREATE TABLE `efectividadtarea` (
  `id` int(11) NOT NULL,
  `calculoefectividad` int(11) NOT NULL,
  `numerofaltas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `efectividadtarea`
--

INSERT INTO `efectividadtarea` (`id`, `calculoefectividad`, `numerofaltas`) VALUES
(1, 0, 0),
(2, 7, 8),
(3, 7, 8),
(4, 7, 8),
(5, 9, 10),
(6, 1, 2),
(7, 9, 10),
(8, 9, 10),
(9, 8, 9),
(10, 9, 10),
(11, 9, 10),
(12, 9, 10),
(13, 9, 10),
(14, 9, 10),
(15, 2, 3),
(16, 9, 10),
(17, 9, 10),
(18, 9, 10),
(19, 5, 6),
(20, 9, 10),
(21, 9, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eficacia`
--

CREATE TABLE `eficacia` (
  `id` int(11) NOT NULL,
  `terminaciontareas` int(11) NOT NULL,
  `cumpliminentotarea` int(11) NOT NULL,
  `calculoderelevancia` float NOT NULL,
  `extensibilidad` int(11) NOT NULL,
  `reusabilidad` int(11) NOT NULL,
  `escalabilidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `eficacia`
--

INSERT INTO `eficacia` (`id`, `terminaciontareas`, `cumpliminentotarea`, `calculoderelevancia`, `extensibilidad`, `reusabilidad`, `escalabilidad`) VALUES
(1, 7, 1, 1, 7, 7, 7),
(2, 8, 2, 1, 8, 8, 8),
(3, 9, 3, 1, 9, 9, 9),
(4, 10, 4, 1, 10, 10, 10),
(5, 11, 5, 1, 11, 11, 11),
(6, 12, 6, 0, 12, 12, 12),
(7, 13, 7, 0, 13, 13, 13),
(8, 14, 8, 1, 14, 14, 14),
(9, 15, 9, 0, 15, 15, 15),
(10, 16, 10, 1, 16, 16, 16),
(11, 17, 11, 0.543689, 17, 17, 17),
(12, 18, 12, 0.543689, 18, 18, 18),
(13, 19, 13, 0.456311, 19, 19, 19),
(14, 20, 14, 0.543689, 20, 20, 20),
(15, 21, 15, 0.543689, 21, 21, 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eficiencia`
--

CREATE TABLE `eficiencia` (
  `id` int(11) NOT NULL,
  `recursos` int(11) NOT NULL,
  `esfuerzo` int(11) NOT NULL,
  `costoeconomico` int(11) NOT NULL,
  `calculoderelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `eficiencia`
--

INSERT INTO `eficiencia` (`id`, `recursos`, `esfuerzo`, `costoeconomico`, `calculoderelevancia`) VALUES
(1, 10, 22, 22, 1),
(2, 11, 23, 23, 1),
(3, 12, 24, 24, 1),
(4, 13, 25, 25, 1),
(5, 14, 26, 26, 1),
(6, 15, 27, 27, 1),
(7, 16, 28, 28, 1),
(8, 17, 29, 29, 1),
(9, 18, 30, 30, 1),
(10, 19, 31, 31, 1),
(11, 20, 32, 32, 1),
(12, 21, 33, 33, 1),
(16, 25, 37, 34, 1),
(17, 26, 38, 35, 1),
(18, 27, 39, 36, 1),
(19, 28, 40, 37, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `error`
--

CREATE TABLE `error` (
  `id` int(11) NOT NULL,
  `frecuenciaerrores` int(11) NOT NULL,
  `mensajes` int(11) NOT NULL,
  `prevencion` int(11) NOT NULL,
  `redundancia` int(11) NOT NULL,
  `enlaces` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `error`
--

INSERT INTO `error` (`id`, `frecuenciaerrores`, `mensajes`, `prevencion`, `redundancia`, `enlaces`) VALUES
(1, 1, 7, 7, 7, 7),
(4, 1, 6, 6, 6, 6),
(5, 5, 10, 10, 10, 10),
(6, 6, 10, 6, 10, 10),
(7, 7, 10, 10, 10, 10),
(8, 8, 10, 10, 10, 10),
(9, 9, 10, 10, 10, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escalabilidad`
--

CREATE TABLE `escalabilidad` (
  `id` int(11) NOT NULL,
  `calculoescalabilidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `escalabilidad`
--

INSERT INTO `escalabilidad` (`id`, `calculoescalabilidad`) VALUES
(1, 0),
(2, 9),
(3, 9),
(4, 9),
(5, 10),
(6, 2),
(7, 10),
(8, 10),
(9, 10),
(10, 10),
(11, 10),
(12, 10),
(13, 10),
(14, 10),
(15, 3),
(16, 10),
(17, 10),
(18, 10),
(19, 10),
(20, 10),
(21, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `esfuerzo`
--

CREATE TABLE `esfuerzo` (
  `id` int(11) NOT NULL,
  `esfuerzo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `esfuerzo`
--

INSERT INTO `esfuerzo` (`id`, `esfuerzo`) VALUES
(1, 2),
(2, 0),
(3, 10),
(4, 5),
(5, 10),
(6, 10),
(7, 10),
(8, 10),
(9, 10),
(10, 1),
(11, 2),
(12, 2),
(13, 2),
(14, 2),
(15, 2),
(16, 2),
(17, 2),
(18, 2),
(19, 2),
(20, 2),
(21, 2),
(22, 2),
(23, 0),
(24, 10),
(25, 10),
(26, 10),
(27, 10),
(28, 10),
(29, 10),
(30, 10),
(31, 10),
(32, 10),
(33, 10),
(34, 10),
(35, 10),
(36, 9),
(37, 10),
(38, 10),
(39, 10),
(40, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estetica`
--

CREATE TABLE `estetica` (
  `id` int(11) NOT NULL,
  `estetica_general` int(11) NOT NULL,
  `comodidad_visual` int(11) NOT NULL,
  `informacion` int(11) NOT NULL,
  `iconos` int(11) NOT NULL,
  `eleccion` int(11) NOT NULL,
  `busqueda` int(11) NOT NULL,
  `videos` int(11) NOT NULL,
  `recomendacion` int(11) NOT NULL,
  `calculo_satisfaccion` int(11) NOT NULL,
  `organizacion` int(11) NOT NULL,
  `interfaz` int(11) NOT NULL,
  `gusto` int(11) NOT NULL,
  `herramientas` int(11) NOT NULL,
  `satisfaccion` int(11) NOT NULL,
  `lenguaje` int(11) NOT NULL,
  `sobrecarga` int(11) NOT NULL,
  `interfaz_limpia` int(11) NOT NULL,
  `espacio` int(11) NOT NULL,
  `longitud` int(11) NOT NULL,
  `texto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estetica`
--

INSERT INTO `estetica` (`id`, `estetica_general`, `comodidad_visual`, `informacion`, `iconos`, `eleccion`, `busqueda`, `videos`, `recomendacion`, `calculo_satisfaccion`, `organizacion`, `interfaz`, `gusto`, `herramientas`, `satisfaccion`, `lenguaje`, `sobrecarga`, `interfaz_limpia`, `espacio`, `longitud`, `texto`) VALUES
(1, 5, 5, 5, 5, 5, 5, 5, 5, 27777777, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5),
(2, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10),
(3, 1, 10, 10, 10, 10, 10, 10, 6, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10),
(4, 9, 8, 7, 6, 5, 4, 3, 2, 22, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10),
(5, 4, 10, 10, 10, 10, 10, 10, 10, 37, 5, 7, 8, 8, 6, 7, 8, 8, 7, 4, 1),
(6, 10, 10, 10, 10, 10, 10, 10, 10, 40, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10),
(7, 10, 10, 10, 10, 10, 10, 10, 10, 40, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10),
(8, 10, 10, 10, 10, 10, 10, 10, 10, 40, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evaluador`
--

CREATE TABLE `evaluador` (
  `id` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `telefono` text NOT NULL,
  `correo` text NOT NULL,
  `contraseña` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `evaluador`
--

INSERT INTO `evaluador` (`id`, `nombre`, `telefono`, `correo`, `contraseña`) VALUES
(2, 'cesar k', 'cesarj', 'mercedese', 'cesar'),
(4, 'k', '6', 'evaluador', 'evaluador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `extensibilidad`
--

CREATE TABLE `extensibilidad` (
  `id` int(11) NOT NULL,
  `calculoextensibilidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `extensibilidad`
--

INSERT INTO `extensibilidad` (`id`, `calculoextensibilidad`) VALUES
(1, 0),
(2, 9),
(3, 9),
(4, 9),
(5, 10),
(6, 2),
(7, 10),
(8, 10),
(9, 10),
(10, 10),
(11, 10),
(12, 10),
(13, 10),
(14, 10),
(15, 10),
(16, 10),
(17, 10),
(18, 10),
(19, 10),
(20, 10),
(21, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fidelidad`
--

CREATE TABLE `fidelidad` (
  `id` int(11) NOT NULL,
  `uso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `fidelidad`
--

INSERT INTO `fidelidad` (`id`, `uso`) VALUES
(1, 7),
(2, 10),
(3, 10),
(4, 10),
(5, 10),
(6, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `frecuenciaerrores`
--

CREATE TABLE `frecuenciaerrores` (
  `id` int(11) NOT NULL,
  `calculofrecuenciaerrores` int(11) NOT NULL,
  `numeroserrores` int(11) NOT NULL,
  `tiempotarea` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `frecuenciaerrores`
--

INSERT INTO `frecuenciaerrores` (`id`, `calculofrecuenciaerrores`, `numeroserrores`, `tiempotarea`) VALUES
(1, 7, 7, '00:00:07'),
(2, 7, 7, '00:00:07'),
(3, 0, 0, '00:00:00'),
(4, 1, 6, '00:00:06'),
(5, 1, 10, '00:00:10'),
(6, 1, 10, '00:00:10'),
(7, 1, 10, '00:00:10'),
(8, 1, 10, '00:00:10'),
(9, 1, 10, '00:00:10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `memorabilidad`
--

CREATE TABLE `memorabilidad` (
  `id` int(11) NOT NULL,
  `comprensibilidad` int(11) NOT NULL,
  `calculoderelevancia` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `memorabilidad`
--

INSERT INTO `memorabilidad` (`id`, `comprensibilidad`, `calculoderelevancia`) VALUES
(1, 2, 1),
(2, 3, 1),
(3, 4, 1),
(4, 5, 1),
(5, 6, 1),
(6, 7, 1),
(7, 8, 1),
(8, 9, 0),
(9, 11, 0.776699);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permiso`
--

CREATE TABLE `permiso` (
  `id` int(11) NOT NULL,
  `seguridad` int(11) NOT NULL,
  `playstore` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `permiso`
--

INSERT INTO `permiso` (`id`, `seguridad`, `playstore`) VALUES
(1, 7, 7),
(2, 7, 7),
(3, 0, 0),
(4, 6, 6),
(5, 10, 10),
(6, 10, 10),
(7, 10, 10),
(8, 10, 10),
(9, 10, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productividad`
--

CREATE TABLE `productividad` (
  `id` int(11) NOT NULL,
  `salidausuario` int(11) NOT NULL,
  `calculoderelevancia` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productividad`
--

INSERT INTO `productividad` (`id`, `salidausuario`, `calculoderelevancia`) VALUES
(1, 2, 1),
(2, 3, 1),
(3, 4, 1),
(4, 5, 1),
(5, 6, 1),
(6, 7, 0),
(7, 9, 0.194175);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ram`
--

CREATE TABLE `ram` (
  `id` int(11) NOT NULL,
  `consumoram` int(11) NOT NULL,
  `consumomedram` int(11) NOT NULL,
  `consumomaxram` int(11) NOT NULL,
  `calculoram` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ram`
--

INSERT INTO `ram` (`id`, `consumoram`, `consumomedram`, `consumomaxram`, `calculoram`) VALUES
(1, 1, 1, 1, 1),
(2, 2, 2, 2, 2),
(3, 0, 0, 0, 0),
(4, 3, 3, 3, 10),
(5, 3, 3, 3, 5),
(6, 3, 3, 3, 10),
(7, 3, 3, 3, 10),
(8, 3, 3, 3, 10),
(9, 3, 3, 3, 8),
(10, 3, 3, 3, 10),
(11, 3, 3, 3, 1),
(12, 0, 2, 2, 2),
(13, 0, 3, 2, 2),
(14, 0, 3, 2, 2),
(15, 2, 3, 2, 2),
(16, 2, 3, 2, 2),
(17, 2, 3, 2, 2),
(18, 2, 3, 2, 2),
(19, 2, 3, 2, 2),
(20, 2, 3, 2, 2),
(21, 2, 3, 2, 2),
(22, 2, 3, 2, 2),
(23, 2, 3, 2, 2),
(24, 0, 0, 0, 0),
(25, 3, 3, 3, 10),
(26, 3, 3, 3, 10),
(27, 3, 3, 3, 10),
(28, 3, 3, 3, 10),
(29, 3, 3, 3, 10),
(30, 3, 3, 3, 10),
(31, 3, 3, 3, 10),
(32, 3, 3, 3, 10),
(33, 3, 3, 3, 10),
(34, 3, 3, 3, 10),
(35, 3, 3, 3, 10),
(36, 3, 3, 3, 10),
(37, 3, 3, 3, 10),
(38, 3, 3, 3, 10),
(39, 3, 3, 3, 10),
(40, 3, 3, 3, 10),
(41, 3, 3, 3, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recursos`
--

CREATE TABLE `recursos` (
  `id` int(11) NOT NULL,
  `tiemporespuesta` int(11) NOT NULL,
  `ram` int(11) NOT NULL,
  `cpu` int(11) NOT NULL,
  `bateria` int(11) NOT NULL,
  `calculorecursos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `recursos`
--

INSERT INTO `recursos` (`id`, `tiemporespuesta`, `ram`, `cpu`, `bateria`, `calculorecursos`) VALUES
(1, 1, 1, 1, 1, 1),
(4, 27, 1, 1, 1, 1),
(5, 29, 1, 1, 1, 1),
(6, 31, 1, 1, 1, 1),
(7, 32, 1, 1, 1, 1),
(8, 33, 1, 1, 1, 1),
(9, 34, 22, 21, 21, 1),
(10, 35, 23, 22, 22, 1),
(11, 36, 24, 23, 23, 1),
(12, 37, 25, 24, 24, 1),
(13, 38, 26, 25, 25, 1),
(14, 41, 29, 28, 26, 1),
(15, 39, 27, 26, 27, 1),
(16, 40, 28, 27, 28, 1),
(17, 42, 30, 29, 29, 1),
(18, 43, 31, 30, 30, 1),
(19, 44, 32, 31, 31, 1),
(20, 45, 33, 32, 32, 1),
(21, 46, 34, 33, 33, 1),
(22, 47, 35, 34, 34, 1),
(23, 48, 36, 35, 35, 1),
(24, 49, 37, 36, 36, 1),
(25, 50, 38, 37, 37, 1),
(26, 51, 39, 38, 38, 1),
(27, 52, 40, 39, 39, 1),
(28, 53, 41, 40, 40, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registrardatosaplicativo`
--

CREATE TABLE `registrardatosaplicativo` (
  `id` int(11) NOT NULL,
  `usuario` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `tipoaplicativo` int(60) NOT NULL,
  `subirapk` int(11) NOT NULL,
  `subirmanual` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `registrardatosaplicativo`
--

INSERT INTO `registrardatosaplicativo` (`id`, `usuario`, `nombre`, `tipoaplicativo`, `subirapk`, `subirmanual`) VALUES
(819, 1, 'prueba 2', 3, 3, 3),
(820, 1, 'facebookññ', 3, 3, 3),
(821, 1, 'facebookkj', 3, 3, 3),
(822, 1, 'facebook lo', 3, 3, 3),
(823, 1, 'solo', 15, 3, 3),
(824, 1, 'aplicación', 5, 3, 3),
(825, 1, 'facebookñ', 3, 3, 3),
(826, 1, 'facebookl', 3, 3, 3),
(827, 1, 'isuario', 5, 3, 3),
(828, 44, 'perez', 18, 69, 365);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reusabilidad`
--

CREATE TABLE `reusabilidad` (
  `id` int(11) NOT NULL,
  `calculoreusabilidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reusabilidad`
--

INSERT INTO `reusabilidad` (`id`, `calculoreusabilidad`) VALUES
(1, 0),
(2, 9),
(3, 9),
(4, 9),
(5, 10),
(6, 2),
(7, 10),
(8, 10),
(9, 8),
(10, 10),
(11, 10),
(12, 10),
(13, 10),
(14, 10),
(15, 5),
(16, 10),
(17, 10),
(18, 10),
(19, 4),
(20, 10),
(21, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salidausuario`
--

CREATE TABLE `salidausuario` (
  `id` int(11) NOT NULL,
  `productividad_inexperto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `salidausuario`
--

INSERT INTO `salidausuario` (`id`, `productividad_inexperto`) VALUES
(1, 4),
(2, 10),
(3, 10),
(4, 5),
(5, 10),
(6, 10),
(7, 10),
(8, 10),
(9, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `satisfaccion`
--

CREATE TABLE `satisfaccion` (
  `id` int(11) NOT NULL,
  `estetica` int(11) NOT NULL,
  `calculoderelevancia` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `satisfaccion`
--

INSERT INTO `satisfaccion` (`id`, `estetica`, `calculoderelevancia`) VALUES
(1, 2, 1),
(2, 3, 1),
(3, 4, 1),
(4, 5, 1),
(5, 6, 0),
(6, 8, 4.2233);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguridad`
--

CREATE TABLE `seguridad` (
  `id` int(11) NOT NULL,
  `permiso` int(11) NOT NULL,
  `error` int(11) NOT NULL,
  `calculoderelevancia` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `seguridad`
--

INSERT INTO `seguridad` (`id`, `permiso`, `error`, `calculoderelevancia`) VALUES
(1, 5, 5, 1),
(2, 6, 6, 1),
(3, 7, 7, 0.912621),
(4, 8, 8, 0.912621),
(5, 9, 9, 0.912621);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subirapk`
--

CREATE TABLE `subirapk` (
  `id` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apk` varchar(60) NOT NULL,
  `direccion` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subirmanual`
--

CREATE TABLE `subirmanual` (
  `id` int(11) NOT NULL,
  `nombremanual` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `terminaciontarea`
--

CREATE TABLE `terminaciontarea` (
  `id` int(11) NOT NULL,
  `tareascompletadas` int(11) NOT NULL,
  `totaltareas` int(11) NOT NULL,
  `calculoterminaciontarea` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `terminaciontarea`
--

INSERT INTO `terminaciontarea` (`id`, `tareascompletadas`, `totaltareas`, `calculoterminaciontarea`) VALUES
(1, 0, 0, 0),
(2, 5, 9, 0),
(3, 5, 9, 0),
(4, 5, 9, 0),
(5, 10, 10, 1),
(6, 2, 2, 1),
(7, 10, 10, 1),
(8, 10, 10, 1),
(9, 10, 10, 1),
(10, 10, 10, 1),
(11, 10, 10, 1),
(12, 10, 10, 1),
(13, 5, 10, 0),
(14, 10, 10, 1),
(15, 3, 6, 0),
(16, 10, 10, 1),
(17, 10, 10, 1),
(18, 10, 10, 1),
(19, 3, 7, 0),
(20, 10, 10, 1),
(21, 10, 10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiemporespuesta`
--

CREATE TABLE `tiemporespuesta` (
  `id` int(11) NOT NULL,
  `tiempoinicio` int(11) NOT NULL,
  `tiemporespuesta` int(11) NOT NULL,
  `numerodeevaluaciones` int(11) NOT NULL,
  `calculartiemporespuesta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tiemporespuesta`
--

INSERT INTO `tiemporespuesta` (`id`, `tiempoinicio`, `tiemporespuesta`, `numerodeevaluaciones`, `calculartiemporespuesta`) VALUES
(1, 1, 1, 1, 1),
(2, 2, 2, 2, 2),
(26, 2, 1, 2, 2),
(27, 2, 1, 2, 2),
(28, 2, 1, 2, 2),
(29, 2, 1, 2, 2),
(30, 2, 1, 2, 2),
(31, 2, 1, 2, 2),
(32, 2, 1, 2, 2),
(33, 2, 1, 2, 2),
(34, 2, 2, 2, 2),
(35, 2, 2, 2, 2),
(36, 0, 0, 0, 0),
(37, 10, 3, 3, 10),
(38, 10, 3, 3, 10),
(39, 10, 3, 3, 10),
(40, 10, 3, 3, 10),
(41, 10, 3, 3, 10),
(42, 10, 3, 3, 10),
(43, 10, 3, 3, 10),
(44, 10, 3, 3, 10),
(45, 10, 3, 3, 10),
(46, 10, 3, 3, 10),
(47, 10, 3, 3, 10),
(48, 10, 3, 3, 10),
(49, 10, 3, 3, 10),
(50, 10, 3, 3, 10),
(51, 10, 3, 3, 10),
(52, 10, 3, 3, 10),
(53, 10, 3, 3, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiempotarea`
--

CREATE TABLE `tiempotarea` (
  `id` int(11) NOT NULL,
  `calculotiempo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tiempotarea`
--

INSERT INTO `tiempotarea` (`id`, `calculotiempo`) VALUES
(1, 9),
(2, 1),
(3, 2),
(4, 10),
(5, 10),
(6, 10),
(7, 10),
(8, 10),
(9, 10),
(10, 10),
(11, 10),
(12, 6),
(13, 10),
(14, 10),
(15, 10),
(16, 10),
(17, 10),
(18, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodeaplicacion`
--

CREATE TABLE `tipodeaplicacion` (
  `id` int(11) NOT NULL,
  `tipoaplicativo` varchar(60) NOT NULL,
  `tiempoinicio` int(11) NOT NULL,
  `calculartiemporespuesta` int(11) NOT NULL,
  `calculoram` int(11) NOT NULL,
  `calculocpu` int(11) NOT NULL,
  `calculobateria` int(11) NOT NULL,
  `esfuerzo` int(11) NOT NULL,
  `calculocostoeconomico` int(11) NOT NULL,
  `calculoterminaciontarea` int(11) NOT NULL,
  `calculoefectividad` int(11) NOT NULL,
  `calculotiempo` int(11) NOT NULL,
  `calculoextensibilidad` int(11) NOT NULL,
  `calculoreusabilidad` int(11) NOT NULL,
  `calculoescalabilidad` int(11) NOT NULL,
  `rapidez` int(11) NOT NULL,
  `dificultad` int(11) NOT NULL,
  `aprendizaje` int(11) NOT NULL,
  `facilidad` int(11) NOT NULL,
  `productividad_inexperto` int(11) NOT NULL,
  `estetica_general` int(11) NOT NULL,
  `comodidad_visual` int(11) NOT NULL,
  `informacion` int(11) NOT NULL,
  `iconos` int(11) NOT NULL,
  `eleccion` int(11) NOT NULL,
  `busqueda` int(11) NOT NULL,
  `videos` int(11) NOT NULL,
  `recomendacion` int(11) NOT NULL,
  `calculo_satisfaccion` int(11) NOT NULL,
  `organizacion` int(11) NOT NULL,
  `interfaz` int(11) NOT NULL,
  `gusto` int(11) NOT NULL,
  `herramientas` int(11) NOT NULL,
  `satisfaccion` int(11) NOT NULL,
  `lenguaje` int(11) NOT NULL,
  `sobrecarga` int(11) NOT NULL,
  `interfaz_limpia` int(11) NOT NULL,
  `espacio` int(11) NOT NULL,
  `longitud` int(11) NOT NULL,
  `texto` int(11) NOT NULL,
  `seguridad` int(11) NOT NULL,
  `playstore` int(11) NOT NULL,
  `calculofrecuenciaerrores` int(11) NOT NULL,
  `mensajes` int(11) NOT NULL,
  `prevencion` int(11) NOT NULL,
  `redundancia` int(11) NOT NULL,
  `enlaces` int(11) NOT NULL,
  `resolucion` int(11) NOT NULL,
  `lenguaje_clarol` int(11) NOT NULL,
  `fuente` int(11) NOT NULL,
  `contraste` int(11) NOT NULL,
  `idioma` int(11) NOT NULL,
  `uso` int(11) NOT NULL,
  `multitareas` int(11) NOT NULL,
  `actividad_mental` int(11) NOT NULL,
  `dificultad_tarea` int(11) NOT NULL,
  `actividad_fisica` int(11) NOT NULL,
  `exigencia` int(11) NOT NULL,
  `inseguro` int(11) NOT NULL,
  `sumaTotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipodeaplicacion`
--

INSERT INTO `tipodeaplicacion` (`id`, `tipoaplicativo`, `tiempoinicio`, `calculartiemporespuesta`, `calculoram`, `calculocpu`, `calculobateria`, `esfuerzo`, `calculocostoeconomico`, `calculoterminaciontarea`, `calculoefectividad`, `calculotiempo`, `calculoextensibilidad`, `calculoreusabilidad`, `calculoescalabilidad`, `rapidez`, `dificultad`, `aprendizaje`, `facilidad`, `productividad_inexperto`, `estetica_general`, `comodidad_visual`, `informacion`, `iconos`, `eleccion`, `busqueda`, `videos`, `recomendacion`, `calculo_satisfaccion`, `organizacion`, `interfaz`, `gusto`, `herramientas`, `satisfaccion`, `lenguaje`, `sobrecarga`, `interfaz_limpia`, `espacio`, `longitud`, `texto`, `seguridad`, `playstore`, `calculofrecuenciaerrores`, `mensajes`, `prevencion`, `redundancia`, `enlaces`, `resolucion`, `lenguaje_clarol`, `fuente`, `contraste`, `idioma`, `uso`, `multitareas`, `actividad_mental`, `dificultad_tarea`, `actividad_fisica`, `exigencia`, `inseguro`, `sumaTotal`) VALUES
(3, 'Administración Pública / Institucional', 2, 2, 2, 4, 2, 2, 2, 4, 2, 2, 2, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 2, 1, 4, 4, 4, 2, 4, 4, 4, 2, 4, 2, 2, 8, 4, 4, 8, 4, 2, 4, 8, 2, 8, 8, 4, 4, 4, 2, 4, 4, 2, 4, 4, 206),
(4, 'Banca electrónica', 1, 1, 1, 4, 1, 1, 8, 1, 8, 1, 4, 8, 2, 4, 8, 8, 8, 4, 2, 2, 2, 2, 2, 2, 4, 8, 2, 4, 2, 4, 8, 4, 8, 2, 2, 2, 1, 2, 8, 8, 2, 1, 8, 2, 2, 2, 8, 2, 8, 4, 8, 8, 8, 8, 8, 8, 8, 249),
(5, 'Blog', 4, 4, 4, 2, 4, 2, 1, 8, 2, 4, 4, 2, 8, 8, 2, 2, 2, 8, 4, 4, 4, 4, 4, 4, 2, 4, 8, 2, 4, 4, 4, 8, 2, 2, 4, 4, 2, 4, 4, 4, 4, 1, 2, 4, 4, 4, 4, 4, 2, 1, 2, 2, 2, 2, 2, 2, 2, 201),
(6, 'Comercio electrónico', 4, 4, 4, 4, 4, 2, 4, 4, 4, 4, 8, 2, 2, 4, 8, 8, 8, 2, 4, 4, 4, 4, 4, 4, 4, 8, 4, 2, 4, 4, 2, 4, 4, 2, 4, 4, 2, 8, 4, 4, 8, 4, 8, 4, 8, 4, 4, 8, 4, 4, 4, 8, 1, 1, 8, 2, 8, 256),
(7, 'Comunicación / Noticias', 1, 1, 1, 1, 2, 2, 1, 1, 2, 1, 1, 4, 8, 8, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 2, 8, 2, 2, 4, 4, 8, 2, 8, 2, 4, 4, 2, 8, 2, 8, 1, 1, 4, 2, 2, 4, 4, 8, 1, 4, 4, 4, 4, 2, 4, 4, 4, 201),
(8, 'Corporativo / Empresas', 1, 1, 4, 4, 1, 2, 2, 2, 2, 1, 2, 4, 2, 4, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 2, 4, 1, 2, 4, 2, 4, 8, 4, 2, 4, 4, 1, 4, 4, 4, 4, 4, 8, 4, 4, 4, 2, 4, 8, 4, 8, 4, 4, 2, 2, 2, 4, 192),
(9, 'Descargas', 1, 1, 4, 2, 2, 2, 2, 2, 2, 1, 4, 4, 4, 2, 2, 1, 2, 8, 1, 1, 1, 1, 1, 1, 4, 2, 4, 2, 1, 2, 8, 2, 2, 1, 1, 1, 2, 2, 2, 8, 2, 1, 2, 2, 4, 1, 1, 2, 4, 1, 4, 2, 2, 4, 2, 1, 4, 135),
(10, 'Educativo / Formativo', 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 4, 2, 2, 4, 4, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 8, 4, 2, 2, 2, 2, 4, 1, 4, 2, 1, 4, 4, 4, 2, 4, 4, 2, 2, 2, 2, 2, 2, 4, 4, 4, 154),
(11, 'Entornos colaborativos / Wikis', 2, 2, 2, 4, 4, 2, 2, 2, 4, 2, 4, 2, 4, 8, 2, 2, 2, 8, 2, 2, 2, 2, 2, 2, 2, 4, 1, 2, 2, 8, 2, 4, 4, 2, 2, 2, 1, 4, 8, 2, 2, 2, 2, 2, 4, 2, 4, 4, 8, 1, 8, 2, 4, 1, 4, 2, 8, 180),
(12, 'Foros / Chat', 2, 2, 4, 2, 4, 2, 4, 1, 4, 2, 2, 2, 4, 8, 4, 4, 8, 1, 2, 2, 2, 2, 2, 2, 2, 4, 4, 2, 2, 8, 4, 1, 8, 1, 2, 2, 1, 4, 4, 4, 1, 2, 4, 2, 2, 2, 1, 4, 2, 1, 4, 8, 1, 4, 8, 2, 4, 177),
(13, 'Ocio / Entretenimiento', 2, 2, 2, 2, 8, 2, 4, 1, 4, 2, 4, 8, 4, 4, 8, 2, 4, 8, 1, 1, 1, 1, 1, 1, 4, 8, 2, 1, 1, 8, 4, 4, 8, 1, 1, 2, 2, 2, 4, 8, 1, 1, 4, 1, 2, 2, 1, 2, 4, 1, 8, 4, 2, 2, 8, 1, 8, 189),
(14, 'Personal', 2, 2, 2, 4, 2, 2, 1, 1, 2, 2, 8, 4, 2, 8, 4, 4, 2, 4, 2, 2, 2, 2, 2, 2, 2, 2, 4, 2, 2, 2, 8, 4, 4, 2, 2, 2, 2, 4, 2, 4, 2, 1, 4, 2, 2, 2, 2, 4, 1, 1, 4, 2, 1, 4, 4, 2, 8, 162),
(15, 'Portal de Servicios', 2, 2, 2, 2, 4, 2, 4, 2, 2, 2, 4, 4, 4, 4, 8, 1, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8, 1, 4, 2, 4, 4, 8, 2, 4, 4, 2, 4, 4, 4, 4, 2, 2, 4, 4, 4, 2, 4, 4, 2, 2, 8, 4, 1, 4, 2, 4, 199),
(16, 'Servicios interactivos basados en imágenes', 4, 4, 2, 2, 4, 2, 2, 2, 2, 4, 4, 2, 4, 4, 2, 4, 2, 2, 4, 4, 4, 4, 4, 4, 4, 2, 4, 1, 4, 2, 8, 8, 2, 4, 4, 2, 2, 4, 8, 8, 2, 2, 2, 1, 1, 2, 4, 4, 8, 1, 1, 2, 8, 4, 2, 4, 2, 193),
(17, 'Servicios interactivos no basados en imágenes', 4, 4, 2, 4, 2, 2, 2, 2, 2, 4, 2, 2, 4, 4, 2, 4, 2, 4, 2, 2, 2, 2, 2, 2, 2, 2, 8, 2, 2, 2, 2, 4, 2, 2, 2, 4, 2, 4, 4, 8, 4, 2, 2, 2, 4, 4, 2, 4, 4, 2, 2, 2, 2, 2, 2, 1, 2, 159),
(18, 'Webmail / Correo', 4, 4, 4, 4, 4, 2, 4, 2, 8, 4, 4, 2, 8, 8, 4, 1, 4, 4, 2, 2, 2, 2, 2, 2, 4, 4, 4, 2, 2, 4, 2, 8, 8, 2, 2, 2, 1, 4, 2, 4, 4, 4, 4, 2, 4, 2, 2, 4, 8, 2, 8, 8, 1, 2, 8, 1, 8, 214);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `universabilidad`
--

CREATE TABLE `universabilidad` (
  `id` int(11) NOT NULL,
  `accesibilidad` int(11) NOT NULL,
  `fidelidad` int(11) NOT NULL,
  `calculoderelevancia` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `universabilidad`
--

INSERT INTO `universabilidad` (`id`, `accesibilidad`, `fidelidad`, `calculoderelevancia`) VALUES
(1, 2, 2, 1),
(2, 3, 3, 1),
(3, 4, 4, 0),
(4, 6, 6, 1.45631);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usabilidad`
--

CREATE TABLE `usabilidad` (
  `id` int(11) NOT NULL,
  `aplicativo` int(11) NOT NULL,
  `calcularusabilidad` int(11) NOT NULL,
  `eficiencia` int(11) NOT NULL,
  `eficacia` int(11) NOT NULL,
  `memorabilidad` int(11) NOT NULL,
  `productividad` int(11) NOT NULL,
  `satisfaccion` int(11) NOT NULL,
  `seguridad` int(11) NOT NULL,
  `universabilidad` int(11) NOT NULL,
  `cargacognitiva` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usosimultaneo`
--

CREATE TABLE `usosimultaneo` (
  `id` int(11) NOT NULL,
  `multitareas` int(11) NOT NULL,
  `actividad_mental` int(11) NOT NULL,
  `dificultad_tarea` int(11) NOT NULL,
  `actividad_fisica` int(11) NOT NULL,
  `exigencia` int(11) NOT NULL,
  `inseguro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usosimultaneo`
--

INSERT INTO `usosimultaneo` (`id`, `multitareas`, `actividad_mental`, `dificultad_tarea`, `actividad_fisica`, `exigencia`, `inseguro`) VALUES
(1, 8, 8, 8, 8, 8, 8),
(2, 10, 10, 10, 10, 10, 10),
(3, 10, 5, 10, 10, 10, 10),
(4, 10, 10, 10, 10, 10, 10),
(5, 10, 10, 10, 10, 10, 10),
(6, 10, 10, 10, 10, 10, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `telefono` text NOT NULL,
  `correo` text NOT NULL,
  `contraseña` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `telefono`, `correo`, `contraseña`) VALUES
(1, 'adriana Patricia', '3219779439', 'mromero@gmail.com', 'fHa#9rkoJQ^E'),
(7, 'John Wilson', 'Rojas', 'john@example.com', '123'),
(29, 'cesar jo', 'cesar', 'cesar', 'cesar'),
(42, 'rojas beltrana rianapatricia', 'rojasbeltranadrianapatricia@gmail.com', 'rojasbeltranadrianapatricia@gmail.com', 'h'),
(44, 'usuario', '698', 'usuario', 'usuario');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `accesibilidad`
--
ALTER TABLE `accesibilidad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `asignarresportes`
--
ALTER TABLE `asignarresportes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `evaluador` (`evaluador`),
  ADD KEY `administrador` (`administrador`),
  ADD KEY `listaaplicaciones` (`listaaplicaciones`);

--
-- Indices de la tabla `bateria`
--
ALTER TABLE `bateria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `calculousabilidad`
--
ALTER TABLE `calculousabilidad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cargacognitiva`
--
ALTER TABLE `cargacognitiva`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usosimultaneo` (`usosimultaneo`);

--
-- Indices de la tabla `comprensibilidad`
--
ALTER TABLE `comprensibilidad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `costoeconomico`
--
ALTER TABLE `costoeconomico`
  ADD PRIMARY KEY (`id`),
  ADD KEY `efectividadrelativatarea` (`efectividadrelativatarea`);

--
-- Indices de la tabla `cpu`
--
ALTER TABLE `cpu`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cumplimientotarea`
--
ALTER TABLE `cumplimientotarea`
  ADD PRIMARY KEY (`id`),
  ADD KEY `efectividadtarea` (`efectividadtarea`),
  ADD KEY `tiempocompletar` (`tiempocompletar`);

--
-- Indices de la tabla `efectividadtarea`
--
ALTER TABLE `efectividadtarea`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `eficacia`
--
ALTER TABLE `eficacia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `terminaciontareas` (`terminaciontareas`),
  ADD KEY `cumpliminentotarea` (`cumpliminentotarea`),
  ADD KEY `calculoderelevancia` (`calculoderelevancia`),
  ADD KEY `extensibilidad` (`extensibilidad`),
  ADD KEY `reusabilidad` (`reusabilidad`),
  ADD KEY `escalabilidad` (`escalabilidad`);

--
-- Indices de la tabla `eficiencia`
--
ALTER TABLE `eficiencia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `recursos` (`recursos`),
  ADD KEY `esfuerzo` (`esfuerzo`),
  ADD KEY `costoeconomico` (`costoeconomico`);

--
-- Indices de la tabla `error`
--
ALTER TABLE `error`
  ADD PRIMARY KEY (`id`),
  ADD KEY `frecuenciaerrores` (`frecuenciaerrores`);

--
-- Indices de la tabla `escalabilidad`
--
ALTER TABLE `escalabilidad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `esfuerzo`
--
ALTER TABLE `esfuerzo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `estetica`
--
ALTER TABLE `estetica`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `evaluador`
--
ALTER TABLE `evaluador`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `extensibilidad`
--
ALTER TABLE `extensibilidad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `fidelidad`
--
ALTER TABLE `fidelidad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `frecuenciaerrores`
--
ALTER TABLE `frecuenciaerrores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `memorabilidad`
--
ALTER TABLE `memorabilidad`
  ADD PRIMARY KEY (`id`),
  ADD KEY `comprensibilidad` (`comprensibilidad`);

--
-- Indices de la tabla `permiso`
--
ALTER TABLE `permiso`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productividad`
--
ALTER TABLE `productividad`
  ADD PRIMARY KEY (`id`),
  ADD KEY `salidausuario` (`salidausuario`);

--
-- Indices de la tabla `ram`
--
ALTER TABLE `ram`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `recursos`
--
ALTER TABLE `recursos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tiemporespuesta` (`tiemporespuesta`),
  ADD KEY `ram` (`ram`),
  ADD KEY `cpu` (`cpu`),
  ADD KEY `bateria` (`bateria`);

--
-- Indices de la tabla `registrardatosaplicativo`
--
ALTER TABLE `registrardatosaplicativo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `subirapk` (`subirapk`),
  ADD KEY `subirmanual` (`subirmanual`),
  ADD KEY `tipoaplicativo` (`tipoaplicativo`),
  ADD KEY `usuario` (`usuario`);

--
-- Indices de la tabla `reusabilidad`
--
ALTER TABLE `reusabilidad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `salidausuario`
--
ALTER TABLE `salidausuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `satisfaccion`
--
ALTER TABLE `satisfaccion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `estetica` (`estetica`);

--
-- Indices de la tabla `seguridad`
--
ALTER TABLE `seguridad`
  ADD PRIMARY KEY (`id`),
  ADD KEY `permiso` (`permiso`),
  ADD KEY `error` (`error`);

--
-- Indices de la tabla `subirapk`
--
ALTER TABLE `subirapk`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `subirmanual`
--
ALTER TABLE `subirmanual`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `terminaciontarea`
--
ALTER TABLE `terminaciontarea`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tiemporespuesta`
--
ALTER TABLE `tiemporespuesta`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tiempotarea`
--
ALTER TABLE `tiempotarea`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipodeaplicacion`
--
ALTER TABLE `tipodeaplicacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `universabilidad`
--
ALTER TABLE `universabilidad`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fidelidad` (`fidelidad`),
  ADD KEY `accesibilidad` (`accesibilidad`);

--
-- Indices de la tabla `usabilidad`
--
ALTER TABLE `usabilidad`
  ADD PRIMARY KEY (`id`),
  ADD KEY `calcularusabilidad` (`calcularusabilidad`),
  ADD KEY `eficiencia` (`eficiencia`),
  ADD KEY `eficacia` (`eficacia`),
  ADD KEY `memorabilidad` (`memorabilidad`),
  ADD KEY `productividad` (`productividad`),
  ADD KEY `satisfaccion` (`satisfaccion`),
  ADD KEY `seguridad` (`seguridad`),
  ADD KEY `universabilidad` (`universabilidad`),
  ADD KEY `cargacognitiva` (`cargacognitiva`),
  ADD KEY `aplicativo` (`aplicativo`);

--
-- Indices de la tabla `usosimultaneo`
--
ALTER TABLE `usosimultaneo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `accesibilidad`
--
ALTER TABLE `accesibilidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `asignarresportes`
--
ALTER TABLE `asignarresportes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `bateria`
--
ALTER TABLE `bateria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT de la tabla `calculousabilidad`
--
ALTER TABLE `calculousabilidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cargacognitiva`
--
ALTER TABLE `cargacognitiva`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `comprensibilidad`
--
ALTER TABLE `comprensibilidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `costoeconomico`
--
ALTER TABLE `costoeconomico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT de la tabla `cpu`
--
ALTER TABLE `cpu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT de la tabla `cumplimientotarea`
--
ALTER TABLE `cumplimientotarea`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `efectividadtarea`
--
ALTER TABLE `efectividadtarea`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `eficacia`
--
ALTER TABLE `eficacia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `eficiencia`
--
ALTER TABLE `eficiencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `error`
--
ALTER TABLE `error`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `escalabilidad`
--
ALTER TABLE `escalabilidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `esfuerzo`
--
ALTER TABLE `esfuerzo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT de la tabla `estetica`
--
ALTER TABLE `estetica`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `evaluador`
--
ALTER TABLE `evaluador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `extensibilidad`
--
ALTER TABLE `extensibilidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `fidelidad`
--
ALTER TABLE `fidelidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `frecuenciaerrores`
--
ALTER TABLE `frecuenciaerrores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `memorabilidad`
--
ALTER TABLE `memorabilidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `permiso`
--
ALTER TABLE `permiso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `productividad`
--
ALTER TABLE `productividad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `ram`
--
ALTER TABLE `ram`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT de la tabla `recursos`
--
ALTER TABLE `recursos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `registrardatosaplicativo`
--
ALTER TABLE `registrardatosaplicativo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=829;

--
-- AUTO_INCREMENT de la tabla `reusabilidad`
--
ALTER TABLE `reusabilidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `salidausuario`
--
ALTER TABLE `salidausuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `satisfaccion`
--
ALTER TABLE `satisfaccion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `seguridad`
--
ALTER TABLE `seguridad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `subirapk`
--
ALTER TABLE `subirapk`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `subirmanual`
--
ALTER TABLE `subirmanual`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `terminaciontarea`
--
ALTER TABLE `terminaciontarea`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `tiemporespuesta`
--
ALTER TABLE `tiemporespuesta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT de la tabla `tiempotarea`
--
ALTER TABLE `tiempotarea`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `tipodeaplicacion`
--
ALTER TABLE `tipodeaplicacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `universabilidad`
--
ALTER TABLE `universabilidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usabilidad`
--
ALTER TABLE `usabilidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usosimultaneo`
--
ALTER TABLE `usosimultaneo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignarresportes`
--
ALTER TABLE `asignarresportes`
  ADD CONSTRAINT `asignarresportes_ibfk_1` FOREIGN KEY (`administrador`) REFERENCES `administrador` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `asignarresportes_ibfk_2` FOREIGN KEY (`evaluador`) REFERENCES `evaluador` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `asignarresportes_ibfk_3` FOREIGN KEY (`listaaplicaciones`) REFERENCES `registrardatosaplicativo` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `cargacognitiva`
--
ALTER TABLE `cargacognitiva`
  ADD CONSTRAINT `cargacognitiva_ibfk_1` FOREIGN KEY (`usosimultaneo`) REFERENCES `usosimultaneo` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `cumplimientotarea`
--
ALTER TABLE `cumplimientotarea`
  ADD CONSTRAINT `cumplimientotarea_ibfk_1` FOREIGN KEY (`efectividadtarea`) REFERENCES `efectividadtarea` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `cumplimientotarea_ibfk_2` FOREIGN KEY (`tiempocompletar`) REFERENCES `tiempotarea` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `eficacia`
--
ALTER TABLE `eficacia`
  ADD CONSTRAINT `eficacia_ibfk_1` FOREIGN KEY (`terminaciontareas`) REFERENCES `terminaciontarea` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `eficacia_ibfk_2` FOREIGN KEY (`cumpliminentotarea`) REFERENCES `cumplimientotarea` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `eficacia_ibfk_3` FOREIGN KEY (`extensibilidad`) REFERENCES `extensibilidad` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `eficacia_ibfk_4` FOREIGN KEY (`reusabilidad`) REFERENCES `reusabilidad` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `eficacia_ibfk_5` FOREIGN KEY (`escalabilidad`) REFERENCES `escalabilidad` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `eficiencia`
--
ALTER TABLE `eficiencia`
  ADD CONSTRAINT `eficiencia_ibfk_1` FOREIGN KEY (`recursos`) REFERENCES `recursos` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `eficiencia_ibfk_2` FOREIGN KEY (`esfuerzo`) REFERENCES `esfuerzo` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `eficiencia_ibfk_3` FOREIGN KEY (`costoeconomico`) REFERENCES `costoeconomico` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `error`
--
ALTER TABLE `error`
  ADD CONSTRAINT `error_ibfk_1` FOREIGN KEY (`frecuenciaerrores`) REFERENCES `frecuenciaerrores` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `memorabilidad`
--
ALTER TABLE `memorabilidad`
  ADD CONSTRAINT `memorabilidad_ibfk_1` FOREIGN KEY (`comprensibilidad`) REFERENCES `comprensibilidad` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `productividad`
--
ALTER TABLE `productividad`
  ADD CONSTRAINT `productividad_ibfk_1` FOREIGN KEY (`salidausuario`) REFERENCES `salidausuario` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `recursos`
--
ALTER TABLE `recursos`
  ADD CONSTRAINT `recursos_ibfk_6` FOREIGN KEY (`tiemporespuesta`) REFERENCES `tiemporespuesta` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `recursos_ibfk_7` FOREIGN KEY (`ram`) REFERENCES `ram` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `recursos_ibfk_8` FOREIGN KEY (`cpu`) REFERENCES `cpu` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `recursos_ibfk_9` FOREIGN KEY (`bateria`) REFERENCES `bateria` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `registrardatosaplicativo`
--
ALTER TABLE `registrardatosaplicativo`
  ADD CONSTRAINT `fk_datos_tipo` FOREIGN KEY (`tipoaplicativo`) REFERENCES `tipodeaplicacion` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `registrardatosaplicativo_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `satisfaccion`
--
ALTER TABLE `satisfaccion`
  ADD CONSTRAINT `satisfaccion_ibfk_1` FOREIGN KEY (`estetica`) REFERENCES `estetica` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `seguridad`
--
ALTER TABLE `seguridad`
  ADD CONSTRAINT `seguridad_ibfk_1` FOREIGN KEY (`permiso`) REFERENCES `permiso` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `seguridad_ibfk_2` FOREIGN KEY (`error`) REFERENCES `error` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `universabilidad`
--
ALTER TABLE `universabilidad`
  ADD CONSTRAINT `universabilidad_ibfk_2` FOREIGN KEY (`fidelidad`) REFERENCES `fidelidad` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `universabilidad_ibfk_3` FOREIGN KEY (`accesibilidad`) REFERENCES `accesibilidad` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `usabilidad`
--
ALTER TABLE `usabilidad`
  ADD CONSTRAINT `usabilidad_ibfk_1` FOREIGN KEY (`aplicativo`) REFERENCES `registrardatosaplicativo` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `usabilidad_ibfk_10` FOREIGN KEY (`cargacognitiva`) REFERENCES `cargacognitiva` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `usabilidad_ibfk_2` FOREIGN KEY (`eficiencia`) REFERENCES `eficiencia` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `usabilidad_ibfk_3` FOREIGN KEY (`calcularusabilidad`) REFERENCES `calculousabilidad` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `usabilidad_ibfk_4` FOREIGN KEY (`eficacia`) REFERENCES `eficacia` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `usabilidad_ibfk_5` FOREIGN KEY (`memorabilidad`) REFERENCES `memorabilidad` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `usabilidad_ibfk_6` FOREIGN KEY (`productividad`) REFERENCES `productividad` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `usabilidad_ibfk_7` FOREIGN KEY (`satisfaccion`) REFERENCES `satisfaccion` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `usabilidad_ibfk_8` FOREIGN KEY (`seguridad`) REFERENCES `seguridad` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `usabilidad_ibfk_9` FOREIGN KEY (`universabilidad`) REFERENCES `universabilidad` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
