-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Dec 12, 2018 at 07:06 PM
-- Server version: 5.7.21
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `BD_EZIC`
--

-- --------------------------------------------------------

--
-- Table structure for table `Admin`
--

CREATE TABLE `Admin` (
  `idAdmin` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Puesto` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Asesor`
--

CREATE TABLE `Asesor` (
  `idAsesor` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Puesto` varchar(45) NOT NULL,
  `Emp_Inst` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Documento`
--

CREATE TABLE `Documento` (
  `idDocumento` int(11) NOT NULL,
  `Titulo` varchar(45) NOT NULL,
  `Tipo` varchar(45) NOT NULL,
  `Contenido` longblob NOT NULL,
  `Expediente_idExpediente` int(11) DEFAULT NULL,
  `Estudiante_idEstudiante` int(11) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Estudiante`
--

CREATE TABLE `Estudiante` (
  `idEstudiante` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Carrera` varchar(45) NOT NULL,
  `Expediente_idExpediente` int(11) DEFAULT NULL,
  `Asesor_idAsesor` int(11) DEFAULT NULL,
  `NC` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Evaluacion`
--

CREATE TABLE `Evaluacion` (
  `idEvaluacion` int(11) NOT NULL,
  `Criterios` varchar(45) NOT NULL,
  `Puntaje` decimal(3,0) NOT NULL,
  `Expediente_idExpediente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Expediente`
--

CREATE TABLE `Expediente` (
  `idExpediente` int(11) NOT NULL,
  `Folio` varchar(45) NOT NULL,
  `Nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Login`
--

CREATE TABLE `Login` (
  `idLogin` int(11) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Pass` varchar(45) NOT NULL,
  `Tipo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Login`
--

INSERT INTO `Login` (`idLogin`, `Username`, `Nombre`, `Pass`, `Tipo`) VALUES
(2, 'Chendo', 'Eduardo', '1234C', 'Administrador');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Admin`
--
ALTER TABLE `Admin`
  ADD PRIMARY KEY (`idAdmin`);

--
-- Indexes for table `Asesor`
--
ALTER TABLE `Asesor`
  ADD PRIMARY KEY (`idAsesor`);

--
-- Indexes for table `Documento`
--
ALTER TABLE `Documento`
  ADD PRIMARY KEY (`idDocumento`),
  ADD KEY `fk_Documento_Expediente1_idx` (`Expediente_idExpediente`),
  ADD KEY `fk_Documento_Estudiante1_idx` (`Estudiante_idEstudiante`);

--
-- Indexes for table `Estudiante`
--
ALTER TABLE `Estudiante`
  ADD PRIMARY KEY (`idEstudiante`),
  ADD KEY `fk_Estudiante_Expediente1_idx` (`Expediente_idExpediente`),
  ADD KEY `fk_Estudiante_Asesor1_idx` (`Asesor_idAsesor`);

--
-- Indexes for table `Evaluacion`
--
ALTER TABLE `Evaluacion`
  ADD PRIMARY KEY (`idEvaluacion`),
  ADD KEY `fk_Evaluacion_Expediente1_idx` (`Expediente_idExpediente`);

--
-- Indexes for table `Expediente`
--
ALTER TABLE `Expediente`
  ADD PRIMARY KEY (`idExpediente`);

--
-- Indexes for table `Login`
--
ALTER TABLE `Login`
  ADD PRIMARY KEY (`idLogin`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Admin`
--
ALTER TABLE `Admin`
  MODIFY `idAdmin` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Asesor`
--
ALTER TABLE `Asesor`
  MODIFY `idAsesor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Documento`
--
ALTER TABLE `Documento`
  MODIFY `idDocumento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Estudiante`
--
ALTER TABLE `Estudiante`
  MODIFY `idEstudiante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Evaluacion`
--
ALTER TABLE `Evaluacion`
  MODIFY `idEvaluacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Expediente`
--
ALTER TABLE `Expediente`
  MODIFY `idExpediente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `Login`
--
ALTER TABLE `Login`
  MODIFY `idLogin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Documento`
--
ALTER TABLE `Documento`
  ADD CONSTRAINT `fk_Documento_Estudiante1` FOREIGN KEY (`Estudiante_idEstudiante`) REFERENCES `Estudiante` (`idEstudiante`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Documento_Expediente1` FOREIGN KEY (`Expediente_idExpediente`) REFERENCES `Expediente` (`idExpediente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Estudiante`
--
ALTER TABLE `Estudiante`
  ADD CONSTRAINT `fk_Estudiante_Asesor1` FOREIGN KEY (`Asesor_idAsesor`) REFERENCES `Asesor` (`idAsesor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Estudiante_Expediente1` FOREIGN KEY (`Expediente_idExpediente`) REFERENCES `Expediente` (`idExpediente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Evaluacion`
--
ALTER TABLE `Evaluacion`
  ADD CONSTRAINT `fk_Evaluacion_Expediente1` FOREIGN KEY (`Expediente_idExpediente`) REFERENCES `Expediente` (`idExpediente`) ON DELETE NO ACTION ON UPDATE NO ACTION;