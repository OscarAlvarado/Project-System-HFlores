delimiter //
create procedure ListarDatos1(
datos varchar(10))
begin
SELECT
     documentoaquiler.serie,
     reservacionaquiler.FechaRegistro,
     reservacionaquiler.Monto,
     persona.Nombres,
     persona.Apellido_Paterno,
     persona.Apellido_Materno,
     persona.numerodoc
FROM
     `reservacionaquiler` reservacionaquiler INNER JOIN `documentoaquiler` documentoaquiler ON reservacionaquiler.`idReservacionAquiler` = documentoaquiler.`idDocumentoAquiler`
     INNER JOIN `cliente` cliente ON reservacionaquiler.`IdCliente` = cliente.`idPersona`
     INNER JOIN `persona` persona ON cliente.`idPersona` = persona.`idPersona`
where YEAR(reservacionaquiler.FechaRegistro)= datos;
end
//