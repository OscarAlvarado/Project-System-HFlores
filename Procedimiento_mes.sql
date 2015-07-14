delimiter //
create procedure ListarMes

( dato varchar(50) ,mes varchar(50))

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
where YEAR(reservacionaquiler.FechaRegistro)=dato and MONTH(reservacionaquiler.FechaRegistro)=mes;
end
// 