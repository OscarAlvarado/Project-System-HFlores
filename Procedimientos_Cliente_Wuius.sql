/*Registrar*/

delimiter $
create procedure registrarPersonaCliente
(in nom varchar(30),
in ap_p varchar (50),
in ap_m varchar (50),
in dir varchar (60),
in correo varchar (40),
in numerodoc varchar (60),
in ntelf varchar (30),
in IdtipoDoc int,
in nacionalidad varchar (80),
in referencia varchar (80))
begin
	declare id int;
	insert into persona(Nombres,Apellido_Paterno,Apellido_Materno,direccion,correo,numerodoc,telefono,idTipoDoc)
	values(nom,ap_p,ap_m,dir,correo,numerodoc,ntelf,IdtipoDoc); 
    set id = (select MAX(idPersona) from persona);
	insert into Cliente(idPersona,nacionalidad,referencia)
	values(id,nacionalidad,referencia);
end $

call registrarPersonaCliente ('Marco','Hernandez','Neria','cadiz116','hneria23@gmail.com','76402745','973465319',3,'Perú','Lambayeque');
call registrarPersonaCliente ('Juan', 'Ramirez', 'Olazabal','Miraflores', 'juancitoR@hotmail.com',  '76802060','969591932',  3,'Perú','Lima');

/*Actualizar*/

delimiter $
create procedure ActualizarPersonaCliente
(in id int,
in nom varchar(30),
in ap_p varchar (50),
in ap_m varchar (50),
in dir varchar (60),
in correo varchar (40),
in numdoc varchar (60),
in tel varchar (30),
in Idtipo int,
in nac varchar (80),
in ref varchar (80))
BEGIN
	update persona set Nombres=nom,Apellido_Paterno=ap_p,Apellido_Materno=ap_m,direccion=dir,correo=correo,numerodoc=numdoc, telefono=tel,idTipoDoc=Idtipo where idPersona= id;
	update cliente set nacionalidad=nac, referencia=ref where idPersona=id;
END$
/*Eliminar*/

delimiter $
create procedure eliminarPersonaCliente
(in id int)
begin
    delete from cliente where idPersona=id;
	delete from persona where idPersona=id;
end $

/*Buscar*/
delimiter $
create procedure buscarPersonaCliente
(in nom varchar (50))
begin
	 select p.idPersona,
     p.Nombres,
     p.Apellido_Paterno,
     p.Apellido_Materno,
     p.direccion,
     p.correo,
     tp.idTipoDoc,
     p.numeroDoc,
     p.telefono,
     c.nacionalidad,
     c.referencia
     from persona p
 inner join tipodocumento tp on p.idTipoDoc=tp.idTipoDoc
 inner join cliente c on p.idPersona=c.idPersona
 where p.Nombres=nom;
end $
