

drop database Hotel_Flores_System;

create database Hotel_Flores_System;
use Hotel_Flores_System;

/* TABLA DE ORDEN REPOSICION*/

create table ordenReposicion
(
idOrdenReposicion int auto_increment not null,
Fecha date not null,
constraint PK_idOrdenReposicion primary key(idOrdenReposicion)
)engine=InnoDB;


/*TABLA TIPO DE EMPLEADO*/

create table tipoEmpleado
(
idTipoEmpleado int auto_increment not null,
Categoria varchar(30) not null,
Descripcion varchar (160) null,
constraint PK_idTipoEmpleado primary key (idTipoEmpleado)
)engine=InnoDB;


/*TABLA DE ORDEN DE RECLAMO*/

create table ordenReclamo
(
idOrdenReclamo int auto_increment not null,
FechaReclamo date not null,
FechaDevolucion date not null,
constraint PK_idOrdenReclamo primary key(idOrdenReclamo)
)engine=InnoDB;


/*TABLA DE HABITACION*/

create table tipoHabitacion
(
idTipoHabitacion int auto_increment not null,
Categoria varchar(40) not null,
Descripcion varchar (160) null,
constraint PK_idTipoHabitacion primary key (idTipoHabitacion)
)engine=InnoDB;


/*TABLA DE TIPO DE USUARIO*/

create table tipoUsuario
(
idTipoUsuario int auto_increment not null,
Descripcion varchar (160)not null,
constraint PK_idTipoUsuario primary key (idTipoUsuario)
)engine=InnoDB;


/*TABLA PERMISO */

create table Permiso
(
idPermiso  int auto_increment not null,
Descripcion varchar (50) not null,
Estado boolean not null,
constraint PK_idPermiso primary key (idPermiso)
)engine=InnoDB;


/*TABLA PRODUCTO*/

create table Producto
(
idProducto int auto_increment not null,
NombreProducto character varying(50)not null,
Precio decimal not null check (Precio > 0),
Cantidad int not null check (Cantidad > 0),
Vigencia date,
constraint PK_idProducto primary key (idProducto)
)engine=InnoDB;

/*TABLA TIPO DE DOCUMENTO*/

create table tipoDocumento
(
idTipoDoc int auto_increment not null,
nombreDoc varchar(80) not null,
constraint PK_idTipoDoc primary key (idTipoDoc)

)engine=InnoDB;

/*TABLA PERSONA*/
/*ALERTA! CAMBIO*/
create table Persona
(
idPersona int auto_increment not null,
Nombres varchar (50) not null,
Apellido_Paterno varchar (50) not null,
Apellido_Materno varchar (50) not null,
direccion character varying(80) not null,
correo character varying(80) null,
numerodoc varchar(80) not null, 
telefono varchar (30) null, /*Se quito la tabla telefono y se le agrego como cambo de la tabla persona*/
idTipoDoc int not null,
constraint PK_idPersona primary key (idPersona),
constraint FK_Persona foreign key (idTipoDoc) references tipoDocumento(idTipoDoc)
)engine=InnoDB;


/*TABLA PROVEEDOR*/

create table Proveedor
(
idProveedor int auto_increment not null,
Ruc varchar (12) not null,
RazonSocial character varying (40) not null,
direccion character varying (40) not null,
correo character varying (40) not null,
telefono varchar(20) null,
constraint PK_IdProveedor primary key (idProveedor)
)engine=InnoDB;

/*----------------------------------TABLAS DEBILES-----------------------------*/


/*TABLA DE HABITACION*/

create table Habitacion
(
idHabitacion  int auto_increment NOT NULL,
idTipoHabitacion int not null,
Numero varchar (7) NOT NULL unique,
Piso int not null check (Piso > 0),
Precio decimal NOT NULL check (Precio > 0),
Banio int,
Terma int,
Medidas varchar(20),
TV int,
estado smallint not null,
constraint PK_idHabitacion primary key (idHabitacion),
constraint FK_idTipo_Habitacion_Habitacion foreign key (idTipoHabitacion) references tipoHabitacion(idTipoHabitacion)
)engine=InnoDB;

/*TABLA NUMEROS TELEFONICOS*/



/*TABLA DE DETALLE ORDEN DE RECLAMO*/

create table detalleReclamo
(
idDetalleReclamo int auto_increment not null,
idProducto int not null,
idOrdenReclamo int not null,
Cantidad int not null,
constraint PK_idDetalleOrdenReclamo primary key (idDetalleReclamo),
constraint FK_Producto_detalleOrdenReclamo foreign key (idProducto) references Producto(idProducto),
constraint FK_OrdenReclamo_detalleOrdenReclamo foreign key (idOrdenReclamo) references OrdenReclamo(idOrdenReclamo)
)engine=InnoDB;


/*TABLA DE REPOSICION DE PRODUCTOS*/

create table detalleReposicion
(
idDetalleReposicion int auto_increment not null,
idOrdenReposicion int not null,
idProducto int not null,
cantidad int not null,

constraint PK_DetalleOrdenReposicion primary key (idDetalleReposicion),
constraint FK_producto_detalleOrdenReposicion foreign key (idProducto) references Producto(idProducto),
constraint FK_OrdenesReposicion_detalleOrdenReposicion foreign key(idOrdenReposicion) references ordenReposicion(idOrdenReposicion)
)engine=InnoDB;



/*TABLA DE ORDEN DE COMPRA*/

create table ordenCompra
(
idOrdenCompra int auto_increment not null,
numeroDocuCompra varchar(160) not null,
FechaIngreso date not null,
FechaCompra date not null,
PrecioUnitario decimal not null,
cantidad int not null,
Descuento decimal null,
Subtotal decimal not null,
Total decimal not null,
formaPago varchar(160) not null,
moneda varchar(60) not null,
idProveedor int not null,
idOrdenReposicion int not null,
constraint PK_idOrdenCompra primary key(idOrdenCompra),
constraint FK_OrdenCompra_Reposicion foreign key (idOrdenReposicion) references OrdenReposicion(idOrdenReposicion),
constraint FK_OrdenCompra_Proveedor foreign key (idProveedor) references Proveedor(idProveedor)
)engine=InnoDB;



/*TABLA DE EMPLEADO*/

create table Empleado
(
idPersona int auto_increment not null,
idTipoEmpleado int not null,
sueldo decimal null,
constraint PK_idPersona primary key (idPersona),
constraint FK_Persona_Empleado foreign key (idPersona) references Persona(idPersona),
constraint FK_tipoEmpleado_Empleado foreign key (idTipoEmpleado) references tipoEmpleado(idTipoEmpleado)
)engine=InnoDB;



/*TABLA USUARIO*/

create table Usuario
(
idUsuario int auto_increment not null,
idTipoUsuario int not null,
idEmpleado int not null,
UserName character varying (30) not null unique,
pass character varying (50) not null,
Estado boolean not null,
constraint PK_Usuario primary key (idUsuario),
constraint FK_TipoUsuario_Usuario foreign key (idTipoUsuario) references tipoUsuario(idTipoUsuario),
constraint FK_Empleado_Usuario foreign key (idEmpleado) references Empleado(idPersona)
)engine=InnoDB;


/*TABLA USUARIO PERMISO*/

create table Usuario_Permiso
(
idPermiso int not null,
idUsuario int not null,
Estado boolean not null,
fechaAsignacion date null,
constraint PK_Permiso primary key (idUsuario),
constraint FK_Permiso foreign key (idPermiso) references Permiso(idPermiso),
constraint FK_Usuario foreign key (idUsuario) references Usuario(idUsuario)
)engine=InnoDB;


/*TABLA CLIENTE*/

create table Cliente
(
idPersona int not null,
nacionalidad varchar(80),
referencia varchar(80),
constraint PK_idCliente primary key(idPersona),
constraint FK_Cliente foreign key (idPersona) references Persona(idPersona)
)engine=InnoDB;


/*RESERVA DE HABITACION ALQUILER*/

create table ReservacionAquiler
(
idReservacionAquiler int auto_increment not null,
FechaRegistro date not null,
FechadeSalida date not null,
Hora time not null,
Monto decimal not null check (Monto > 0),
estado smallint not null,
IdCliente int not null,
IdEmpleado int not null,
idHabitacion int not null,

constraint PK_IdReservacionAquiler primary key (idReservacionAquiler),
constraint FK_Habitacion_Reservacion foreign  key (idHabitacion) references Habitacion(idHabitacion),
constraint FK_Cliente_Reservacion foreign  key (idCliente) references Cliente(idPersona),
constraint FK_Empleado_Reservacion foreign  key (IdEmpleado) references Empleado(idPersona)
)engine=InnoDB;


/*TABLA DOCUMENTO DE ALQUILER*/
create table documentoAquiler
(
idDocumentoAquiler int auto_increment  not null,
serie int not null,
numeroDocu int not null,
montoTotal decimal not null,
constraint PK_idDocumentoAquiler primary key (idDocumentoAquiler),
constraint FK_idDocumentoAquiler_Alquiler foreign  key (idDocumentoAquiler) references ReservacionAquiler(IdReservacionAquiler)
)engine=InnoDB;

/*TABLA HOJA DE CONSUMO*/

create table hojaConsumo
(
idHojaConsumo int auto_increment not null,
fecha date not null,
cantidad int not null,
monto decimal not null,
idCliente int not null,
idDocumentoAquiler int not null,
idProducto int not null,

constraint PK_hojaConsumo primary key (idHojaConsumo),
constraint FK_hojaConsumo_producto foreign key (idProducto) references Producto(idProducto),
constraint FK_hojaConsumo_DocumentoAquiler foreign  key (idDocumentoAquiler) references documentoAquiler(idDocumentoAquiler),
constraint FK_hojaConsumo_cliente foreign key (idCliente) references Cliente(idPersona)
)engine=InnoDB;


/*TABLA KARDEX*/

create table Kardex
(
IdKardex int auto_increment not null,
serie int not null,
fecha date not null,
Cantidad int not null,
estado boolean not null,
IdProducto int not null,
constraint PK_Kardes primary key (IdKardex),
constraint FK_kardex_Producto foreign key (IdProducto) references Producto (IdProducto)
)engine=InnoDB;


insert into tipohabitacion values(default,'Normal','habitacion normal'),(default,'Doble','Habitacion Doble'),(default,'Matrimonial','Habitacion Matrimonial');






INSERT INTO `hotel_flores_system`.`Producto` (`NombreProducto`, `Precio`, `Cantidad`, `Vigencia`) VALUES ('galletas oreo', '0.60', '50', '2016-12-12');
INSERT INTO `hotel_flores_system`.`Producto` (`NombreProducto`, `Precio`, `Cantidad`, `Vigencia`) VALUES ('gaseosa Inka Cola', '1.50', '20', '2016-06-07');
INSERT INTO `hotel_flores_system`.`Producto` (`NombreProducto`, `Precio`, `Cantidad`, `Vigencia`) VALUES ('kolino', '4.00', '30', '2015-07-04');
INSERT INTO `hotel_flores_system`.`Producto` (`NombreProducto`, `Precio`, `Cantidad`, `Vigencia`) VALUES ('Papel Higienico SUAVE', '1.00', '40', '2017-04-04');
INSERT INTO `hotel_flores_system`.`Producto` (`NombreProducto`, `Precio`, `Cantidad`, `Vigencia`) VALUES ('Liquido Limpieza', '3.00', '20', '2017-06-07');
INSERT INTO `hotel_flores_system`.`Producto` (`NombreProducto`, `Precio`, `Cantidad`, `Vigencia`) VALUES ('cereales', '0.70', '30', '2016-08-09');
INSERT INTO `hotel_flores_system`.`Producto` (`NombreProducto`, `Precio`, `Cantidad`, `Vigencia`) VALUES ('Pisco A1', '20.00', '15', '2019-12-29');
INSERT INTO `hotel_flores_system`.`Producto` (`NombreProducto`, `Precio`, `Cantidad`, `Vigencia`) VALUES ('Desodorante Rexona', '1.00', '60', '2016-7-27');
INSERT INTO `hotel_flores_system`.`Producto` (`NombreProducto`, `Precio`, `Cantidad`, `Vigencia`) VALUES ('Tijeras', '2.00', '20', '2017-12-12');
INSERT INTO `hotel_flores_system`.`Producto` (`NombreProducto`, `Precio`, `Cantidad`, `Vigencia`) VALUES ('gaseosa Pepsi', '2.00', '20', '2016-06-07');


/*Insercion de DATOS  --- TIPO DOCUMENTO  */

INSERT INTO `hotel_flores_system`.`tipodocumento` (`nombreDoc`) VALUES ('DNI');
INSERT INTO `hotel_flores_system`.`tipodocumento` (`nombreDoc`) VALUES ('CI');
INSERT INTO `hotel_flores_system`.`tipodocumento` (`nombreDoc`) VALUES ('RG');
INSERT INTO `hotel_flores_system`.`tipodocumento` (`nombreDoc`) VALUES ('CC');
INSERT INTO `hotel_flores_system`.`tipodocumento` (`nombreDoc`) VALUES ('DUI');
INSERT INTO `hotel_flores_system`.`tipodocumento` (`nombreDoc`) VALUES ('DPI');
INSERT INTO `hotel_flores_system`.`tipodocumento` (`nombreDoc`) VALUES ('CURP');
INSERT INTO `hotel_flores_system`.`tipodocumento` (`nombreDoc`) VALUES ('CIE');

/*Insercion de DATOS  --- PERSONA  */

INSERT INTO `hotel_flores_system`.`persona` (`Nombres`, `Apellido_Paterno`, `Apellido_Materno`, `direccion`, `correo`, `numerodoc`, `idTipoDoc`) VALUES ('Juan', 'Ramirez', 'Olazabal', 'Santa Teresa 123', 'juancitoR@hotmail.com', '24553176', '2');
INSERT INTO `hotel_flores_system`.`persona` (`Nombres`, `Apellido_Paterno`, `Apellido_Materno`, `direccion`, `numerodoc`, `idTipoDoc`) VALUES ('Ana', 'Montero', 'Silva', 'Bolognesi 345', '345434', '5');
INSERT INTO `hotel_flores_system`.`persona` (`Nombres`, `Apellido_Paterno`, `Apellido_Materno`, `direccion`, `correo`, `numerodoc`, `idTipoDoc`) VALUES ('Teresa', 'Panta', 'Flores', 'Cristobal Acshi 654', 'TerPanFl@gmail.com', '76567897', '1');
INSERT INTO `hotel_flores_system`.`persona` (`Nombres`, `Apellido_Paterno`, `Apellido_Materno`, `direccion`, `correo`, `numerodoc`, `idTipoDoc`) VALUES ('Pablo', 'Monja', 'Sandoval', 'B.Leguia 235', 'pablojadal@gmail.com', '5456765', '6');
INSERT INTO `hotel_flores_system`.`persona` (`Nombres`, `Apellido_Paterno`, `Apellido_Materno`, `direccion`, `correo`, `numerodoc`, `idTipoDoc`) VALUES ('Pedro', 'Cieza', 'Mesta', 'Av. Tacna 543', 'sagitario2000@hotmail.com', '55456256', '1');
INSERT INTO `hotel_flores_system`.`persona` (`Nombres`, `Apellido_Paterno`, `Apellido_Materno`, `direccion`, `correo`, `numerodoc`, `idTipoDoc`) VALUES ('Nicolas', 'Cajo', 'Siesquen', 'Francisco Bolognesi 105', 'nikicajo29@gmail.com', '56735536', '1');
INSERT INTO `hotel_flores_system`.`persona` (`Nombres`, `Apellido_Paterno`, `Apellido_Materno`, `direccion`, `correo`, `numerodoc`, `idTipoDoc`) VALUES ('Rosa', 'Vasquez', 'Parraguez', 'Santa Rosa 243', 'sparraguez@hotmail.com', '66347637', '3');
INSERT INTO `hotel_flores_system`.`persona` (`Nombres`, `Apellido_Paterno`, `Apellido_Materno`, `direccion`, `correo`, `numerodoc`, `idTipoDoc`) VALUES ('Jairo', 'Sevilla', 'Millones', 'Alfonso Ugarte 657', 'SevillaM@gmail.com', '5647647', '7');
INSERT INTO `hotel_flores_system`.`persona` (`Nombres`, `Apellido_Paterno`, `Apellido_Materno`, `direccion`, `correo`, `numerodoc`, `idTipoDoc`) VALUES ('Ana', 'Jaramillo', 'Cruz', 'Nicanor Carmona 766', 'AnitaJC@hotmail.com', '8657576', '6');
INSERT INTO `hotel_flores_system`.`persona` (`Nombres`, `Apellido_Paterno`, `Apellido_Materno`, `direccion`, `correo`, `numerodoc`, `idTipoDoc`) VALUES ('Oscar', 'Santisteban', 'Medina', 'Union 965', 'Oscar48837@gmail.com', '8768765', '1');

/*Insercion de DATOS  --- Cliente  */

INSERT INTO `hotel_flores_system`.`cliente` (`idPersona`, `nacionalidad`, `referencia`) VALUES ('1', 'Bolovia', 'La Paz');
INSERT INTO `hotel_flores_system`.`cliente` (`idPersona`, `nacionalidad`, `referencia`) VALUES ('2', 'El Salvador', 'San Salvador');
INSERT INTO `hotel_flores_system`.`cliente` (`idPersona`, `nacionalidad`, `referencia`) VALUES ('3', 'Peru', 'Huancayo');
INSERT INTO `hotel_flores_system`.`cliente` (`idPersona`, `nacionalidad`, `referencia`) VALUES ('4', 'Guatemala', 'Guatemala');
INSERT INTO `hotel_flores_system`.`cliente` (`idPersona`, `nacionalidad`, `referencia`) VALUES ('5', 'Peru', 'Lima');
INSERT INTO `hotel_flores_system`.`cliente` (`idPersona`, `nacionalidad`, `referencia`) VALUES ('6', 'Peru', 'Lambayeque');
INSERT INTO `hotel_flores_system`.`cliente` (`idPersona`, `nacionalidad`, `referencia`) VALUES ('7', 'Brasil', 'Brasilia');
INSERT INTO `hotel_flores_system`.`cliente` (`idPersona`, `nacionalidad`, `referencia`) VALUES ('8', 'Mexico', 'Guadalajara');
INSERT INTO `hotel_flores_system`.`cliente` (`idPersona`, `nacionalidad`, `referencia`) VALUES ('9', 'Guatemala', 'Guatemala');
INSERT INTO `hotel_flores_system`.`cliente` (`idPersona`, `nacionalidad`, `referencia`) VALUES ('10', 'Peru', 'Cajamarca');

/*Insercion de DATOS  --- TIPO DE HABITACION*/

INSERT INTO `hotel_flores_system`.`tipohabitacion` (`Categoria`, `Descripcion`) VALUES ('A1', 'mejor categoria');
INSERT INTO `hotel_flores_system`.`tipohabitacion` (`Categoria`, `Descripcion`) VALUES ('Familiar', 'para familia');
INSERT INTO `hotel_flores_system`.`tipohabitacion` (`Categoria`, `Descripcion`) VALUES ('Matrimonial', 'para parejas');
INSERT INTO `hotel_flores_system`.`tipohabitacion` (`Categoria`, `Descripcion`) VALUES ('Individual', 'para uno solo');

/*Insercion de DATOS  --- HABITACION*/

INSERT INTO `hotel_flores_system`.`habitacion` (`idTipoHabitacion`, `Numero`, `Piso`, `Precio`, `estado`) VALUES ('1', '101', '1', '50', '1');
INSERT INTO `hotel_flores_system`.`habitacion` (`idTipoHabitacion`, `Numero`, `Piso`, `Precio`, `estado`) VALUES ('3', '207', '2', '20', '1');
INSERT INTO `hotel_flores_system`.`habitacion` (`idTipoHabitacion`, `Numero`, `Piso`, `Precio`, `estado`) VALUES ('2', '300', '3', '40', '1');

/*Insercion de DATOS  --- TIPO EMPLEADO*/

INSERT INTO `hotel_flores_system`.`tipoempleado` (`Categoria`, `Descripcion`) VALUES ('Almacen', 'Almacen');
INSERT INTO `hotel_flores_system`.`tipoempleado` (`Categoria`, `Descripcion`) VALUES ('Recepcion', 'Recepcion');

/*Insercion de DATOS  --- EMPLEADO*/
INSERT INTO `hotel_flores_system`.`Empleado` (`idTipoEmpleado`, `sueldo`) VALUES ('1', '1800');
INSERT INTO `hotel_flores_system`.`Empleado` (`idTipoEmpleado`, `sueldo`) VALUES ('2', '2000');



/*Insercion de DATOS  --- RESERVACION DE HABITACION*/

INSERT INTO `hotel_flores_system`.`ReservacionAquiler` (`FechaRegistro`, `FechadeSalida`, `Hora`, `Monto`, `estado`, `IdCliente`, `IdEmpleado`, `idHabitacion`) VALUES ('2014-06-10', '2015-06-15', '8', '30', '1', '1', '1', '1');
INSERT INTO `hotel_flores_system`.`ReservacionAquiler` (`FechaRegistro`, `FechadeSalida`, `Hora`, `Monto`, `estado`, `IdCliente`, `IdEmpleado`, `idHabitacion`) VALUES ('2013-03-06', '2015-10-13', '8:00', '20', '1', '2', '2', '2');
INSERT INTO `hotel_flores_system`.`ReservacionAquiler` (`FechaRegistro`, `FechadeSalida`, `Hora`, `Monto`, `estado`, `IdCliente`, `IdEmpleado`, `idHabitacion`) VALUES ('2012-10-12', '2015-10-14', '8:00', '10', '1', '3', '1', '3');
INSERT INTO `hotel_flores_system`.`ReservacionAquiler` (`FechaRegistro`, `FechadeSalida`, `Hora`, `Monto`, `estado`, `IdCliente`, `IdEmpleado`, `idHabitacion`) VALUES ('2012-09-09', '2015-10-12', '8:00', '50', '1', '4', '2', '1');
INSERT INTO `hotel_flores_system`.`ReservacionAquiler` (`FechaRegistro`, `FechadeSalida`, `Hora`, `Monto`, `estado`, `IdCliente`, `IdEmpleado`, `idHabitacion`) VALUES ('2015-11-05', '2015-10-11', '8:00', '30', '1', '5', '1', '2');
INSERT INTO `hotel_flores_system`.`ReservacionAquiler` (`FechaRegistro`, `FechadeSalida`, `Hora`, `Monto`, `estado`, `IdCliente`, `IdEmpleado`, `idHabitacion`) VALUES ('2013-10-02', '2015-10-12', '8:00', '30', '1', '6', '2', '3');
INSERT INTO `hotel_flores_system`.`ReservacionAquiler` (`FechaRegistro`, `FechadeSalida`, `Hora`, `Monto`, `estado`, `IdCliente`, `IdEmpleado`, `idHabitacion`) VALUES ('2012-12-01', '2015-10-14', '8:00', '40', '1', '7', '1', '1');
INSERT INTO `hotel_flores_system`.`ReservacionAquiler` (`FechaRegistro`, `FechadeSalida`, `Hora`, `Monto`, `estado`, `IdCliente`, `IdEmpleado`, `idHabitacion`) VALUES ('2012-11-07', '2015-10-15', '8:00', '40', '1', '8', '2', '2');
INSERT INTO `hotel_flores_system`.`ReservacionAquiler` (`FechaRegistro`, `FechadeSalida`, `Hora`, `Monto`, `estado`, `IdCliente`, `IdEmpleado`, `idHabitacion`) VALUES ('2015-09-11', '2015-10-15', '8:00', '30', '1', '4', '1', '3');
INSERT INTO `hotel_flores_system`.`ReservacionAquiler` (`FechaRegistro`, `FechadeSalida`, `Hora`, `Monto`, `estado`, `IdCliente`, `IdEmpleado`, `idHabitacion`) VALUES ('2013-10-10', '2015-10-15', '8:00', '20', '1', '1', '2', '1');
INSERT INTO `hotel_flores_system`.`ReservacionAquiler` (`FechaRegistro`, `FechadeSalida`, `Hora`, `Monto`, `estado`, `IdCliente`, `IdEmpleado`, `idHabitacion`) VALUES ('2014-12-11', '2014-10-12', '8:00', '30', '1', '2', '2', '3');



/*Insercion de DATOS  --- DOCUMENTO DE ALQUILER*/
INSERT INTO `hotel_flores_system`.`documentoAquiler` (`serie`, `numeroDocu`, `montoTotal`) VALUES ('377552776', '24553176', '30');
INSERT INTO `hotel_flores_system`.`documentoAquiler` (`serie`, `numeroDocu`, `montoTotal`) VALUES ('242476', '345434', '20');
INSERT INTO `hotel_flores_system`.`documentoAquiler` (`serie`, `numeroDocu`, `montoTotal`) VALUES ('3453453', '76567897', '10');
INSERT INTO `hotel_flores_system`.`documentoAquiler` (`serie`, `numeroDocu`, `montoTotal`) VALUES ('45534453', '8768765', '10');
INSERT INTO `hotel_flores_system`.`documentoAquiler` (`serie`, `numeroDocu`, `montoTotal`) VALUES ('345234552', '5647647', '70');

INSERT INTO `hotel_flores_system`.`documentoAquiler` (`serie`, `numeroDocu`, `montoTotal`) VALUES ('3123123', '5647647', '50');
INSERT INTO `hotel_flores_system`.`documentoAquiler` (`serie`, `numeroDocu`, `montoTotal`) VALUES ('3232423', '5647647', '40');
INSERT INTO `hotel_flores_system`.`documentoAquiler` (`serie`, `numeroDocu`, `montoTotal`) VALUES ('2323243', '5647647', '20');
INSERT INTO `hotel_flores_system`.`documentoAquiler` (`serie`, `numeroDocu`, `montoTotal`) VALUES ('2342323', '76402700', '18');
INSERT INTO `hotel_flores_system`.`documentoAquiler` (`serie`, `numeroDocu`, `montoTotal`) VALUES ('1231321', '909123456', '50');


delimiter //
create procedure IngresoProductos(
    in _nombre varchar(30)
  , in _precio decimal
  , in _cantidad int
  , in _vigencia date)
  
  begin
       
       insert into producto(NombreProducto,Precio,Cantidad,vigencia)values(_nombre,_precio,_cantidad,_vigencia);
  end
  
//


