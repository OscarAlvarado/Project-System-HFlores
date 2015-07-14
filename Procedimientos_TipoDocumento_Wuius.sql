delimiter $
create procedure ActualizarTipoDocumento
(in id int,
in des varchar(60))
BEGIN
	update tipodocumento set nombreDoc=des where idTipoDoc= id;
END$


delimiter $
create procedure registrarTipoDocumento
(in des varchar(60))
begin
	insert into tipodocumento(nombreDoc)
	values(des); 
end $

delimiter $
create procedure eliminarTipoDocumento
(in id int)
begin
    delete from tipodocumento where idTipoDoc=id;

end $

delimiter $
create procedure BuscarTipoDocumento
(in nom int)
begin
    select * from tipodocumento where nombreDoc=nom;
end $
