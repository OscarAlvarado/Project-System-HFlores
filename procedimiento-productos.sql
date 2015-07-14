use hotel_flores_system;

delimiter //
create procedure IngresoProductos(
    in _nombre varchar(30)
  , in _precio decimal
  , in _cantidad int
  , in _vigencia date)
  
  begin
      insert into producto(NombreProducto,Precio, Cantidad,vigencia)values(_nombre,_precio,_cantidad,_vigencia);
  end
//;


delimiter //
create procedure listarProductos()
  begin
	 select * from producto;
  end
//;

select * from producto;

delimiter //
create procedure ActualizarProducto(in _id int, in _Nombre varchar(30),in _precio decimal(8,2), in _cantidad int, in _vigencia date)
  begin   
     update producto 
     set nombreproducto=_nombre, Precio=_precio, cantidad=_cantidad,vigencia=_vigencia
     where idProducto = _id;
  end
//;

delimiter //
create procedure EliminarProducto(in _id int)
  begin   
     delete from  producto 
	 where idProducto=_id;
  end
//;

delimiter //
create procedure BuscarXid(in _id int)
  begin   
     select * from producto
     where idProducto=_id;
  end
//;

delimiter //
create procedure BuscarXfecha(in _fecha date)
  begin   
     select * from producto
	 where Vigencia=_fecha;
  end
//;

delimiter //
create procedure EliminarRegistroConsumo(in _id int)
  begin   
     delete from  hojaconsumo 
	 where idHojaConsumo=_id;
  end
//;

delimiter //
create procedure mostrarConsumoCli()
  begin   
      select h.idHojaConsumo,h.fecha,p.idProducto,p.NombreProducto,h.cantidad,h.monto from hojaconsumo h
      inner join Producto p on h.idProducto=p.idProducto;
  end
//