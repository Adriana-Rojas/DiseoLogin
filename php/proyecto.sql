-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-07-2020 a las 20:22:55
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
  `calculorelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
(4, 'administrador', '6', 'm', 'm');

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
  `calculocarga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprensibilidad`
--

CREATE TABLE `comprensibilidad` (
  `id` int(11) NOT NULL,
  `calculorelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `costoeconomico`
--

CREATE TABLE `costoeconomico` (
  `id` int(11) NOT NULL,
  `efectividadrelativatarea` int(11) NOT NULL,
  `costototal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cumplimientotarea`
--

CREATE TABLE `cumplimientotarea` (
  `id` int(11) NOT NULL,
  `efectividadtarea` int(11) NOT NULL,
  `tiempocompletar` int(11) NOT NULL,
  `calcularrelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `efectividadtarea`
--

CREATE TABLE `efectividadtarea` (
  `id` int(11) NOT NULL,
  `calculoefectividad` int(11) NOT NULL,
  `numerofaltas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eficacia`
--

CREATE TABLE `eficacia` (
  `id` int(11) NOT NULL,
  `terminaciontareas` int(11) NOT NULL,
  `cumpliminentotarea` int(11) NOT NULL,
  `calculoderelevancia` int(11) NOT NULL,
  `extensibilidad` int(11) NOT NULL,
  `reusabilidad` int(11) NOT NULL,
  `escalabilidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `error`
--

CREATE TABLE `error` (
  `id` int(11) NOT NULL,
  `frecuenciaerrores` int(11) NOT NULL,
  `calculorelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escalabilidad`
--

CREATE TABLE `escalabilidad` (
  `id` int(11) NOT NULL,
  `calculorelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `esfuerzo`
--

CREATE TABLE `esfuerzo` (
  `id` int(11) NOT NULL,
  `esfuerzo` int(11) NOT NULL,
  `completartarea` time NOT NULL,
  `calculoesfuerzo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estetica`
--

CREATE TABLE `estetica` (
  `id` int(11) NOT NULL,
  `calculorelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
(2, 'cesar k', 'cesarj', 'cesarevaluador@hotmail.com', 'cesar'),
(3, 'a', 'a', 'a', 'a'),
(4, 'k', '6', 'k', 'k');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `extensibilidad`
--

CREATE TABLE `extensibilidad` (
  `id` int(11) NOT NULL,
  `calculorelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fidelidad`
--

CREATE TABLE `fidelidad` (
  `id` int(11) NOT NULL,
  `calculorelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `frecuenciaerrores`
--

CREATE TABLE `frecuenciaerrores` (
  `id` int(11) NOT NULL,
  `calculorelevancia` int(11) NOT NULL,
  `numeroserrores` int(11) NOT NULL,
  `tiempotarea` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `memorabilidad`
--

CREATE TABLE `memorabilidad` (
  `id` int(11) NOT NULL,
  `comprensibilidad` int(11) NOT NULL,
  `calculorelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permiso`
--

CREATE TABLE `permiso` (
  `id` int(11) NOT NULL,
  `calculorelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productividad`
--

CREATE TABLE `productividad` (
  `id` int(11) NOT NULL,
  `salidausuario` int(11) NOT NULL,
  `calculorelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registrardatosaplicativo`
--

CREATE TABLE `registrardatosaplicativo` (
  `id` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `tipoaplicativo` varchar(60) NOT NULL,
  `subirapk` int(11) NOT NULL,
  `subirmanual` int(11) NOT NULL,
  `usabilidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reusabilidad`
--

CREATE TABLE `reusabilidad` (
  `id` int(11) NOT NULL,
  `calculorelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salidausuario`
--

CREATE TABLE `salidausuario` (
  `id` int(11) NOT NULL,
  `calculorelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `satisfaccion`
--

CREATE TABLE `satisfaccion` (
  `id` int(11) NOT NULL,
  `estetica` int(11) NOT NULL,
  `calculorelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguridad`
--

CREATE TABLE `seguridad` (
  `id` int(11) NOT NULL,
  `permiso` int(11) NOT NULL,
  `error` int(11) NOT NULL,
  `calculoderelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  `calculoderelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiemporespuesta`
--

CREATE TABLE `tiemporespuesta` (
  `id` int(11) NOT NULL,
  `tiempoinicio` time NOT NULL,
  `tiemporespuesta` time NOT NULL,
  `numerodeevaluaciones` int(11) NOT NULL,
  `calculartiemporespuesta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiempotarea`
--

CREATE TABLE `tiempotarea` (
  `id` int(11) NOT NULL,
  `calculotiempo` int(11) NOT NULL,
  `tiempo` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodeaplicacion`
--

CREATE TABLE `tipodeaplicacion` (
  `id` int(11) NOT NULL,
  `tipoaplicativo` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `universabilidad`
--

CREATE TABLE `universabilidad` (
  `id` int(11) NOT NULL,
  `accesibilidad` int(11) NOT NULL,
  `fidelidad` int(11) NOT NULL,
  `calculocarga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usabilidad`
--

CREATE TABLE `usabilidad` (
  `id` int(11) NOT NULL,
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
  `calculorelevancia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `telefono` text NOT NULL,
  `correo` text NOT NULL,
  `contraseña` text NOT NULL,
  `aplicacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `telefono`, `correo`, `contraseña`, `aplicacion`) VALUES
(1, 'adriana Patricia', '3219779439', 'mromero@gmail.com', 'fHa#9rkoJQ^E', 0),
(7, 'John Wilson', 'Rojas', 'john@example.com', '123', 0),
(29, 'cesar jo', 'cesar', 'cesar', 'cesar', 0),
(35, 'Mercedes', 'cesar', 'cesar', 'cesar', 0),
(40, 'cesar López', 'cesar', 'cesar', 'cesar', 0),
(42, 'rojas beltrana rianapatricia', 'rojasbeltranadrianapatricia@gmail.com', 'rojasbeltranadrianapatricia@gmail.com', 'h', 0),
(44, 'Pérez', '698', 'Pérez', 'p', 0);

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
  ADD KEY `usabilidad` (`usabilidad`);

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
  ADD KEY `cargacognitiva` (`cargacognitiva`);

--
-- Indices de la tabla `usosimultaneo`
--
ALTER TABLE `usosimultaneo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `aplicacion` (`aplicacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `accesibilidad`
--
ALTER TABLE `accesibilidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `asignarresportes`
--
ALTER TABLE `asignarresportes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cargacognitiva`
--
ALTER TABLE `cargacognitiva`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `error`
--
ALTER TABLE `error`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estetica`
--
ALTER TABLE `estetica`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `evaluador`
--
ALTER TABLE `evaluador`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `fidelidad`
--
ALTER TABLE `fidelidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `frecuenciaerrores`
--
ALTER TABLE `frecuenciaerrores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `permiso`
--
ALTER TABLE `permiso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `salidausuario`
--
ALTER TABLE `salidausuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `satisfaccion`
--
ALTER TABLE `satisfaccion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `seguridad`
--
ALTER TABLE `seguridad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `universabilidad`
--
ALTER TABLE `universabilidad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usosimultaneo`
--
ALTER TABLE `usosimultaneo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `accesibilidad`
--
ALTER TABLE `accesibilidad`
  ADD CONSTRAINT `accesibilidad_ibfk_1` FOREIGN KEY (`id`) REFERENCES `universabilidad` (`accesibilidad`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `asignarresportes`
--
ALTER TABLE `asignarresportes`
  ADD CONSTRAINT `asignarresportes_ibfk_1` FOREIGN KEY (`evaluador`) REFERENCES `evaluador` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `asignarresportes_ibfk_2` FOREIGN KEY (`administrador`) REFERENCES `administrador` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `bateria`
--
ALTER TABLE `bateria`
  ADD CONSTRAINT `bateria_ibfk_1` FOREIGN KEY (`id`) REFERENCES `recursos` (`bateria`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `calculousabilidad`
--
ALTER TABLE `calculousabilidad`
  ADD CONSTRAINT `calculousabilidad_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usabilidad` (`calcularusabilidad`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `cargacognitiva`
--
ALTER TABLE `cargacognitiva`
  ADD CONSTRAINT `cargacognitiva_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usabilidad` (`cargacognitiva`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `comprensibilidad`
--
ALTER TABLE `comprensibilidad`
  ADD CONSTRAINT `comprensibilidad_ibfk_1` FOREIGN KEY (`id`) REFERENCES `memorabilidad` (`comprensibilidad`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `costoeconomico`
--
ALTER TABLE `costoeconomico`
  ADD CONSTRAINT `costoeconomico_ibfk_1` FOREIGN KEY (`id`) REFERENCES `eficiencia` (`costoeconomico`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `cpu`
--
ALTER TABLE `cpu`
  ADD CONSTRAINT `cpu_ibfk_1` FOREIGN KEY (`id`) REFERENCES `recursos` (`cpu`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `cumplimientotarea`
--
ALTER TABLE `cumplimientotarea`
  ADD CONSTRAINT `cumplimientotarea_ibfk_1` FOREIGN KEY (`id`) REFERENCES `eficacia` (`cumpliminentotarea`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `efectividadtarea`
--
ALTER TABLE `efectividadtarea`
  ADD CONSTRAINT `efectividadtarea_ibfk_1` FOREIGN KEY (`id`) REFERENCES `cumplimientotarea` (`efectividadtarea`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `eficacia`
--
ALTER TABLE `eficacia`
  ADD CONSTRAINT `eficacia_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usabilidad` (`eficacia`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `eficiencia`
--
ALTER TABLE `eficiencia`
  ADD CONSTRAINT `eficiencia_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usabilidad` (`eficiencia`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `error`
--
ALTER TABLE `error`
  ADD CONSTRAINT `error_ibfk_1` FOREIGN KEY (`id`) REFERENCES `seguridad` (`error`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `escalabilidad`
--
ALTER TABLE `escalabilidad`
  ADD CONSTRAINT `escalabilidad_ibfk_1` FOREIGN KEY (`id`) REFERENCES `eficacia` (`escalabilidad`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `esfuerzo`
--
ALTER TABLE `esfuerzo`
  ADD CONSTRAINT `esfuerzo_ibfk_1` FOREIGN KEY (`id`) REFERENCES `eficiencia` (`esfuerzo`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `estetica`
--
ALTER TABLE `estetica`
  ADD CONSTRAINT `estetica_ibfk_1` FOREIGN KEY (`id`) REFERENCES `satisfaccion` (`estetica`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `extensibilidad`
--
ALTER TABLE `extensibilidad`
  ADD CONSTRAINT `extensibilidad_ibfk_1` FOREIGN KEY (`id`) REFERENCES `eficacia` (`extensibilidad`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `fidelidad`
--
ALTER TABLE `fidelidad`
  ADD CONSTRAINT `fidelidad_ibfk_1` FOREIGN KEY (`id`) REFERENCES `universabilidad` (`fidelidad`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `frecuenciaerrores`
--
ALTER TABLE `frecuenciaerrores`
  ADD CONSTRAINT `frecuenciaerrores_ibfk_1` FOREIGN KEY (`id`) REFERENCES `error` (`frecuenciaerrores`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `memorabilidad`
--
ALTER TABLE `memorabilidad`
  ADD CONSTRAINT `memorabilidad_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usabilidad` (`memorabilidad`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `permiso`
--
ALTER TABLE `permiso`
  ADD CONSTRAINT `permiso_ibfk_1` FOREIGN KEY (`id`) REFERENCES `seguridad` (`permiso`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `productividad`
--
ALTER TABLE `productividad`
  ADD CONSTRAINT `productividad_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usabilidad` (`productividad`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `ram`
--
ALTER TABLE `ram`
  ADD CONSTRAINT `ram_ibfk_1` FOREIGN KEY (`id`) REFERENCES `recursos` (`ram`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `recursos`
--
ALTER TABLE `recursos`
  ADD CONSTRAINT `recursos_ibfk_1` FOREIGN KEY (`id`) REFERENCES `eficiencia` (`recursos`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `registrardatosaplicativo`
--
ALTER TABLE `registrardatosaplicativo`
  ADD CONSTRAINT `registrardatosaplicativo_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usuario` (`aplicacion`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `reusabilidad`
--
ALTER TABLE `reusabilidad`
  ADD CONSTRAINT `reusabilidad_ibfk_1` FOREIGN KEY (`id`) REFERENCES `eficacia` (`reusabilidad`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `salidausuario`
--
ALTER TABLE `salidausuario`
  ADD CONSTRAINT `salidausuario_ibfk_1` FOREIGN KEY (`id`) REFERENCES `productividad` (`salidausuario`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `satisfaccion`
--
ALTER TABLE `satisfaccion`
  ADD CONSTRAINT `satisfaccion_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usabilidad` (`satisfaccion`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `seguridad`
--
ALTER TABLE `seguridad`
  ADD CONSTRAINT `seguridad_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usabilidad` (`seguridad`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `subirapk`
--
ALTER TABLE `subirapk`
  ADD CONSTRAINT `subirapk_ibfk_1` FOREIGN KEY (`id`) REFERENCES `registrardatosaplicativo` (`subirapk`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `subirmanual`
--
ALTER TABLE `subirmanual`
  ADD CONSTRAINT `subirmanual_ibfk_1` FOREIGN KEY (`id`) REFERENCES `registrardatosaplicativo` (`subirmanual`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `terminaciontarea`
--
ALTER TABLE `terminaciontarea`
  ADD CONSTRAINT `terminaciontarea_ibfk_1` FOREIGN KEY (`id`) REFERENCES `eficacia` (`terminaciontareas`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `tiemporespuesta`
--
ALTER TABLE `tiemporespuesta`
  ADD CONSTRAINT `tiemporespuesta_ibfk_1` FOREIGN KEY (`id`) REFERENCES `recursos` (`tiemporespuesta`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `tiempotarea`
--
ALTER TABLE `tiempotarea`
  ADD CONSTRAINT `tiempotarea_ibfk_1` FOREIGN KEY (`id`) REFERENCES `cumplimientotarea` (`tiempocompletar`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `universabilidad`
--
ALTER TABLE `universabilidad`
  ADD CONSTRAINT `universabilidad_ibfk_1` FOREIGN KEY (`id`) REFERENCES `usabilidad` (`universabilidad`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `usabilidad`
--
ALTER TABLE `usabilidad`
  ADD CONSTRAINT `usabilidad_ibfk_1` FOREIGN KEY (`id`) REFERENCES `registrardatosaplicativo` (`usabilidad`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `usosimultaneo`
--
ALTER TABLE `usosimultaneo`
  ADD CONSTRAINT `usosimultaneo_ibfk_1` FOREIGN KEY (`id`) REFERENCES `cargacognitiva` (`usosimultaneo`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
