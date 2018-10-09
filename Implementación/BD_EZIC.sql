-- -----------------------------------------------------
-- Table `BD_EZIC`.`Login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BD_EZIC`.`Login` (
  `idLogin` INT NOT NULL AUTO_INCREMENT,
  `Alias` VARCHAR(45) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Contraseña` VARCHAR(45) NOT NULL,
  `Tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idLogin`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_EZIC`.`Estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BD_EZIC`.`Estudiante` (
  `NC` VARCHAR(45) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Carrera` VARCHAR(45) NOT NULL,
  `Login_idLogin` INT NOT NULL,
  `Semestre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`NC`),
  INDEX `fk_Estudiante_Login1_idx` (`Login_idLogin` ASC),
  CONSTRAINT `fk_Estudiante_Login1`
    FOREIGN KEY (`Login_idLogin`)
    REFERENCES `BD_EZIC`.`Login` (`idLogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_EZIC`.`Asesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BD_EZIC`.`Asesor` (
  `idAsesor` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Puesto` VARCHAR(45) NOT NULL,
  `Emp_Inst` VARCHAR(45) NOT NULL,
  `Login_idLogin` INT NOT NULL,
  PRIMARY KEY (`idAsesor`),
  INDEX `fk_Asesor_Login1_idx` (`Login_idLogin` ASC),
  CONSTRAINT `fk_Asesor_Login1`
    FOREIGN KEY (`Login_idLogin`)
    REFERENCES `BD_EZIC`.`Login` (`idLogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_EZIC`.`Admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BD_EZIC`.`Admin` (
  `idAdmin` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Puesto` VARCHAR(45) NOT NULL,
  `Login_idLogin` INT NOT NULL,
  PRIMARY KEY (`idAdmin`),
  INDEX `fk_Admin_Login1_idx` (`Login_idLogin` ASC),
  CONSTRAINT `fk_Admin_Login1`
    FOREIGN KEY (`Login_idLogin`)
    REFERENCES `BD_EZIC`.`Login` (`idLogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_EZIC`.`Expediente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BD_EZIC`.`Expediente` (
  `Folio` VARCHAR(45) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `NC` VARCHAR(45) NOT NULL,
  `Asesor_idAsesor` INT NOT NULL,
  PRIMARY KEY (`Folio`),
  INDEX `fk_Expediente_Estudiante1_idx` (`NC` ASC),
  INDEX `fk_Expediente_Asesor1_idx` (`Asesor_idAsesor` ASC),
  CONSTRAINT `fk_Expediente_Estudiante1`
    FOREIGN KEY (`NC`)
    REFERENCES `BD_EZIC`.`Estudiante` (`NC`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Expediente_Asesor1`
    FOREIGN KEY (`Asesor_idAsesor`)
    REFERENCES `BD_EZIC`.`Asesor` (`idAsesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_EZIC`.`Documento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BD_EZIC`.`Documento` (
  `idDocumento` INT NOT NULL AUTO_INCREMENT,
  `Titulo` VARCHAR(45) NOT NULL,
  `Tipo` VARCHAR(45) NOT NULL,
  `Contenido` BLOB NOT NULL,
  `Folio` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDocumento`),
  INDEX `fk_Documento_Expediente1_idx` (`Folio` ASC),
  CONSTRAINT `fk_Documento_Expediente1`
    FOREIGN KEY (`Folio`)
    REFERENCES `BD_EZIC`.`Expediente` (`Folio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BD_EZIC`.`Evaluacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BD_EZIC`.`Evaluacion` (
  `idEvaluacion` INT NOT NULL AUTO_INCREMENT,
  `Criterios` VARCHAR(45) NOT NULL,
  `Puntaje` DECIMAL(3) NOT NULL,
  `Folio` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEvaluacion`),
  INDEX `fk_Evaluacion_Expediente1_idx` (`Folio` ASC),
  CONSTRAINT `fk_Evaluacion_Expediente1`
    FOREIGN KEY (`Folio`)
    REFERENCES `BD_EZIC`.`Expediente` (`Folio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
