
-- Crear la base de datos
-- CREATE DATABASE tiendafrailejones;
-- Drop DATABASE tiendafrailejones;
-- Crear un nuevo usuario
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';


-- Asignarle permisos a un usuario
GRANT CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT, REFERENCES, RELOAD on *.* TO 'admin'@'localhost' WITH GRANT OPTION;

-- Usar la base de datos que acabamos de crear
USE tiendafrailejones;

-- PRIMER SPRINT
-- Crear la tabla de empleados
CREATE TABLE empleado(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(200) NOT NULL,
	telefono VARCHAR(200) NOT NULL, 
	identificacion VARCHAR(200) NOT NULL, 
	tipo_Identificacion VARCHAR(200) NOT NULL,
	tipo_usuario VARCHAR(200) NOT NULL
);	

ALTER TABLE empleado 
ADD activo SMALLINT UNSIGNED DEFAULT 1 NOT NULL;

-- Creacion tabla login
CREATE TABLE login(
	id INT AUTO_INCREMENT PRIMARY KEY,
	user VARCHAR(200) NOT NULL,
	password VARCHAR(200) NOT NULL,
	user_type VARCHAR(200) NOT NULL,
	id_usuario VARCHAR(200) NOT NULL
);

-- SEGUNDO SPRINT
CREATE TABLE cliente(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(200) NOT NULL,
	telefono VARCHAR(200) NOT NULL, 
	identificacion VARCHAR(200) NOT NULL, 
	tipo_Identificacion VARCHAR(200) NOT NULL,
	tipo_usuario VARCHAR(200) NOT NULL,
    	direccion VARCHAR(100) NOT NULL
);

/*
CREATE TABLE deuda(
	id INT AUTO_INCREMENT PRIMARY KEY,
	id_cliente INT NOT NULL,
	id_producto INT NOT NULL,
    valor_producto DECIMAL NOT NULL,
    fecha_compra DATE NOT NULL,
    fecha_vencimiento DATE NOT NULL,
    fecha_cancelacion DATE NOT NULL
);*/


-- DROP TABLE deuda
-- DROP TABLE gestion_deuda

CREATE TABLE gestion_deuda(
	id INT AUTO_INCREMENT PRIMARY KEY,
	id_cliente INT NOT NULL,
    valor_total_productos DECIMAL NOT NULL,
    fecha datetime NOT NULL,
	descripcion TEXT NOT NULL,
	abono_deuda CHAR(1) NOT NULL
);



-- TERCER SPRINT
DROP TABLE categoria;
CREATE TABLE categoria(
id INT AUTO_INCREMENT PRIMARY KEY UNIQUE not null,
nombre VARCHAR(200) NOT NULL UNIQUE
);
ALTER TABLE categoria 
ADD descripcion VARCHAR(200);

CREATE TABLE registro(
id_producto VARCHAR(10) NOT NULL,
id_categoria VARCHAR(10) NOT NULL,
fecha_cambio DATETIME
);
DROP TABLE productos;
CREATE TABLE productos(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(200) NOT NULL,
    categoria_id INT,
    nombre_categoria VARCHAR(200) NOT NULL,
    precio_compra INT NOT NULL,
    precio_venta INT NOT NULL,
    fecha_ingreso DATE NOT NULL,
	stock DECIMAL NOT NULL,
    marca VARCHAR(200),
    nombre_proveedor VARCHAR(200) NOT NULL
);
alter table productos ADD activo SMALLINT UNSIGNED DEFAULT 1 NOT NULL;


-- Usuario de prueba
INSERT INTO login (user, password, user_type, id_usuario) 
values('jose@gmail.com', 'AA22', 'EMPLEADO', '1234');

-- Admins
INSERT INTO login (user, password, user_type, id_usuario) 
values('carlos@gmail.com', 'AG2YkrQkSeZz3NQx4IWVxw==', 'ADMINISTRADOR', '12345');

INSERT INTO empleado (nombre, telefono, identificacion, tipo_identificacion, tipo_usuario, activo, correo, usuario) 
values('carlos', '12343543', '12345', 'CÉDULA', 'ADMINISTRADOR', '1', 'carlos@gmail.com', 'carlos');	
-- prueba select
SELECT * FROM login WHERE user = 'jose@gmail.com' AND password = 'AA22';

ALTER TABLE login  
ADD activo SMALLINT UNSIGNED DEFAULT 1 NOT NULL;

ALTER TABLE empleado 
ADD correo VARCHAR(200) NOT NULL;

CREATE TABLE logData(
	id INT AUTO_INCREMENT PRIMARY KEY,
	source varchar(50) not null,
	description varchar(50) not null,
	user_id int not null, 
	date datetime not null
);

ALTER TABLE cliente 
ADD activo SMALLINT UNSIGNED DEFAULT 1 NOT NULL;

select * from productos;
select * from registro;
select * from categoria;

insert into categoria (nombre, descripcion)values('Carnes', 'Todos los productos de origen animal que se denominen carnes');
insert into categoria (nombre, descripcion)values('Carnes', 'Todos los productos de origen animal que se denominen carnes');
Select * from categoria where nombre = 'Carnes';

Select id  from categoria;
Select *  from categoria;
Select * from empleado;
select * from cliente;

UPDATE categoria SET nombre='Bebidaswa' where nombre = 'Bebidas Azucaradas' and descripcion ='Liquidos potables asdas';



Insert into productos(nombre, categoria_id, nombre_categoria, precio_compra, precio_venta, fecha_ingreso, stock, marca, nombre_proveedor)
values('papas', 3, 'paquetes', '2000', '3000', '29-02-22', 3, 'Margarita', 'Sapo');

Insert into productos(nombre, categoria_id, nombre_categoria, precio_compra, precio_venta, fecha_ingreso, stock, marca, nombre_proveedor)
values('huevo', 2, 'nose', '2000', '3000', '27-02-22', 3, '', 'Sapo');

UPDATE productos SET nombre = 'papas de pollo' where ID = 2 and marca = '';

Select * from productos;
SELECT * FROM productos WHERE nombre='asdfghj' AND marca='dfghj';
SELECT * FROM productos WHERE nombre like '%asdfghj%' AND marca like '%dfghj%'; 

select id from categoria where nombre = 'Bebidaswa';
select nombre from categoria where nombre = 'Carnitas';


