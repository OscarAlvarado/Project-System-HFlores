
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

create table Persona
(
idPersona int auto_increment not null,
Nombres varchar (50) not null,
Apellido_Paterno varchar (50) not null,
Apellido_Materno varchar (50) not null,
direccion character varying(80) not null,
correo character varying(80) null,
numerodoc varchar(80) not null,
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
Numero varchar (7) NOT NULL,
Piso int not null check (Piso > 0),
Precio decimal(10,2) NOT NULL check (Precio > 0),
Baño char(2),
Terma char(2),
Medidas varchar(20),
TV char(2),
estado smallint not null,
constraint PK_idHabitacion primary key (idHabitacion),
constraint FK_idTipo_Habitacion_Habitacion foreign key (idTipoHabitacion) references tipoHabitacion(idTipoHabitacion)
)engine=InnoDB;

/*TABLA NUMEROS TELEFONICOS*/

create table Telefonos
(
  idNumeroTelf int auto_increment not null,
  IdPersona int  not null,  
  descripcion varchar (18) null default 'Datos Por Ingresar',   
  constraint PK_idNumeroTelf primary key (idNumeroTelf),
  constraint FK_persona_numerosTelefonicos foreign key (IdPersona) references Persona(IdPersona)
  
)engine=InnoDB;


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
