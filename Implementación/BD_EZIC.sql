-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 03-10-2018 a las 08:04:44
-- Versión del servidor: 5.6.38-log
-- Versión de PHP: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de datos: `BD_EZIC`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Admin`
--

CREATE TABLE `Admin` (
  `idAdmin` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Puesto` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Asesor`
--

CREATE TABLE `Asesor` (
  `idAsesor` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Puesto` varchar(45) NOT NULL,
  `Emp_Inst` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Documento`
--

CREATE TABLE `Documento` (
  `idDocumento` int(11) NOT NULL,
  `Titulo` varchar(45) NOT NULL,
  `Tipo` varchar(45) NOT NULL,
  `Contenido` blob NOT NULL,
  `Expediente_idExpediente` int(11) NOT NULL,
  `Estudiante_idEstudiante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Estudiante`
--

CREATE TABLE `Estudiante` (
  `idEstudiante` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Carrera` varchar(45) NOT NULL,
  `Expediente_idExpediente` int(11) NOT NULL,
  `Asesor_idAsesor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Evaluacion`
--

CREATE TABLE `Evaluacion` (
  `idEvaluacion` int(11) NOT NULL,
  `Criterios` varchar(45) NOT NULL,
  `Puntaje` decimal(3,0) NOT NULL,
  `Expediente_idExpediente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Expediente`
--

CREATE TABLE `Expediente` (
  `idExpediente` int(11) NOT NULL,
  `Folio` varchar(45) NOT NULL,
  `Nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Login`
--

CREATE TABLE `Login` (
  `idLogin` int(11) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Pass` varchar(45) NOT NULL,
  `Tipo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `Login`
--

INSERT INTO `Login` (`idLogin`, `Username`, `Nombre`, `Pass`, `Tipo`) VALUES
(1, 'Manzana', 'Luis Angel', '1234', 'Administrador'),
(2, 'Kev', 'Kevin', '12345', 'Administrador'),
(3, 'Chendo', 'Eduardo', '12345', 'Administrador'),
(4, 'Cinthia', 'Cinthia', '1234567', 'Administrador');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Admin`
--
ALTER TABLE `Admin`
  ADD PRIMARY KEY (`idAdmin`);

--
-- Indices de la tabla `Asesor`
--
ALTER TABLE `Asesor`
  ADD PRIMARY KEY (`idAsesor`);

--
-- Indices de la tabla `Documento`
--
ALTER TABLE `Documento`
  ADD PRIMARY KEY (`idDocumento`),
  ADD KEY `fk_Documento_Expediente1_idx` (`Expediente_idExpediente`),
  ADD KEY `fk_Documento_Estudiante1_idx` (`Estudiante_idEstudiante`);

--
-- Indices de la tabla `Estudiante`
--
ALTER TABLE `Estudiante`
  ADD PRIMARY KEY (`idEstudiante`),
  ADD KEY `fk_Estudiante_Expediente1_idx` (`Expediente_idExpediente`),
  ADD KEY `fk_Estudiante_Asesor1_idx` (`Asesor_idAsesor`);

--
-- Indices de la tabla `Evaluacion`
--
ALTER TABLE `Evaluacion`
  ADD PRIMARY KEY (`idEvaluacion`),
  ADD KEY `fk_Evaluacion_Expediente1_idx` (`Expediente_idExpediente`);

--
-- Indices de la tabla `Expediente`
--
ALTER TABLE `Expediente`
  ADD PRIMARY KEY (`idExpediente`);

--
-- Indices de la tabla `Login`
--
ALTER TABLE `Login`
  ADD PRIMARY KEY (`idLogin`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Admin`
--
ALTER TABLE `Admin`
  MODIFY `idAdmin` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Asesor`
--
ALTER TABLE `Asesor`
  MODIFY `idAsesor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Documento`
--
ALTER TABLE `Documento`
  MODIFY `idDocumento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Estudiante`
--
ALTER TABLE `Estudiante`
  MODIFY `idEstudiante` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Evaluacion`
--
ALTER TABLE `Evaluacion`
  MODIFY `idEvaluacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Expediente`
--
ALTER TABLE `Expediente`
  MODIFY `idExpediente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Login`
--
ALTER TABLE `Login`
  MODIFY `idLogin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Documento`
--
ALTER TABLE `Documento`
  ADD CONSTRAINT `fk_Documento_Estudiante1` FOREIGN KEY (`Estudiante_idEstudiante`) REFERENCES `Estudiante` (`idEstudiante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Documento_Expediente1` FOREIGN KEY (`Expediente_idExpediente`) REFERENCES `Expediente` (`idExpediente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `Estudiante`
--
ALTER TABLE `Estudiante`
  ADD CONSTRAINT `fk_Estudiante_Asesor1` FOREIGN KEY (`Asesor_idAsesor`) REFERENCES `Asesor` (`idAsesor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Estudiante_Expediente1` FOREIGN KEY (`Expediente_idExpediente`) REFERENCES `Expediente` (`idExpediente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `Evaluacion`
--
ALTER TABLE `Evaluacion`
  ADD CONSTRAINT `fk_Evaluacion_Expediente1` FOREIGN KEY (`Expediente_idExpediente`) REFERENCES `Expediente` (`idExpediente`) ON DELETE NO ACTION ON UPDATE NO ACTION;
