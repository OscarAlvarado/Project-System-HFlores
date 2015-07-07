#QUERY REGISTRO DE HABITACION
#----------------------------#
use hotel_flores_system;
select * from habitacion;


#Procedimiento listar tipos de habitacion
delimiter //
create procedure sp_listar_tipoHabitacion()
begin
	select * from tipohabitacion;
end//

#Procedimiento registrar tipo de habitacion
drop procedure if exists sp_registrar_tipohabitacion;
delimiter //
create procedure sp_registrar_tipohabitacion(
categ varchar(40),
descrip varchar(160),
out out_value_message int
)
begin
	if(categ = '')then
		set out_value_message = -1;
	else
		insert into tipohabitacion values(default,categ,descrip);
        set out_value_message = 1;
	end if;
end//


#Procedimiento registrar habitacion
#Estados de Habitacion
#1=libre
#2=ocupado
#3=mantenimiento
#4=limpieza
#5=deshabilitada
drop procedure if exists sp_registro_habitacion;
delimiter //
create procedure sp_registro_habitacion(
idTipoHab int,
numhab varchar(7),
piso char(2),
precio decimal(10,2),
baño char(2),
terma char(2),
medidas varchar(20),
tv char(2),
est smallint(6),
out out_value_message int
)
begin
	if(exists(select Numero from habitacion where Numero = numhab))then		
        set out_value_message = -1;
	elseif(precio<=0.0)then
		set out_value_message = 0;
	else
		insert into habitacion values(default,idTipoHab,numhab,piso,precio,baño,terma,medidas,tv,est);
        set out_value_message = 1;
	end if;		
end//


drop procedure sp_Listar_Habitaciones;
delimiter //
create procedure sp_Listar_Habitaciones()
begin
	select th.Categoria,h.Numero,h.Piso,h.Precio,h.Baño,h.Terma,h.Medidas,h.TV
    from habitacion h
		 inner join tipohabitacion th on h.idHabitacion = th.idTipoHabitacion
         where h.estado <> 5;
end //


drop procedure sp_Listar_Habitaciones_Item;
delimiter //
create procedure sp_Listar_Habitaciones_Item()
begin
 select h.idHabitacion, th.Categoria,h.Numero,h.Piso,h.Precio,h.Baño,h.Terma,h.Medidas,h.TV,h.estado
    from habitacion h
   inner join tipohabitacion th on h.idTipoHabitacion = th.idTipoHabitacion
         where h.estado <> 5;
end //


drop procedure sp_Listar_Habitaciones_xTipo;
delimiter //
create procedure sp_Listar_Habitaciones_xTipo(
idTipHab int
)
begin
	select th.Categoria,h.Numero,h.Piso,h.Precio,h.Baño,h.Terma,h.Medidas,h.TV
    from habitacion h
		 inner join tipohabitacion th on h.idTipoHabitacion = th.idTipoHabitacion
         where h.idTipoHabitacion = idTipHab and h.estado <> 5; 
end //

#call sp_Listar_Habitaciones_xTipo(1)

select * from habitacion;
#select * from tipohabitacion
#insertan tipo de habitacion
#insert into tipohabitacion(Categoria,Descripcion) values('Normal','1 Cama, con baño incluido y Tv');


#call sp_registro_habitacion(1, 'H201', 2, 85.00, 'Si', 'No', '15 X 20', 'Si', 1,@msj);
#select @msj as t;
#call sp_Listar_Habitaciones();






