USE `hotel_flores_system`;
DROP procedure IF EXISTS `sp_LeeTipoEmpleado`;

DELIMITER $$
USE `hotel_flores_system`$$
CREATE PROCEDURE `sp_LeeTipoEmpleado`()
BEGIN
	SELECT idTipoEmpleado, Categoria, Descripcion FROM tipoempleado;
END$$

DELIMITER ;

/************************************************************************************************************/
USE `hotel_flores_system`;
DROP procedure IF EXISTS `sp_registraTipoEmpleado`;

DELIMITER $$
USE `hotel_flores_system`$$
CREATE PROCEDURE `sp_registraTipoEmpleado`(IN cat varchar(30), IN descrip varchar(160))
BEGIN
	INSERT INTO tipoempleado (Categoria, Descripcion) VALUES (cat, descrip);
END$$

DELIMITER ;

/************************************************************************************************************/
USE `hotel_flores_system`;
DROP procedure IF EXISTS `sp_registraTipoDocumento`;

DELIMITER $$
USE `hotel_flores_system`$$
CREATE PROCEDURE `sp_registraTipoDocumento`(IN nombredoc varchar(80))
BEGIN
	INSERT INTO tipodocumento (nombredoc) VALUES (nombredoc);
END$$

DELIMITER ;

/************************************************************************************************************/
USE `hotel_flores_system`;
DROP procedure IF EXISTS `sp_LeeTipoDocumento`;

DELIMITER $$
USE `hotel_flores_system`$$
CREATE PROCEDURE `sp_LeeTipoDocumento` ()
BEGIN
	SELECT idTipoDoc, nombreDoc FROM tipodocumento;
END
$$

DELIMITER ;

/************************************************************************************************************/
call sp_LeeTipoDocumento;