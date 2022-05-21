
-- Crear la base de datos
CREATE DATABASE tiendafrailejones;

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

CREATE TABLE deuda(
	id INT AUTO_INCREMENT PRIMARY KEY,
	id_cliente INT NOT NULL,
	id_producto INT NOT NULL,
    valor_producto DECIMAL NOT NULL,
    fecha_compra DATE NOT NULL,
    fecha_vencimiento DATE NOT NULL,
    fecha_cancelacion DATE NOT NULL
);

-- TERCER SPRINT
CREATE TABLE productos(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(200) NOT NULL,
    categoria_id INT AUTO_INCREMENT,
    nombre_categoria VARCHAR(200) NOT NULL,
    precio_compra INT NOT NULL,
    precio_venta INT NOT NULL,
	stock DECIMAL NOT NULL,
    id_proveedor INT NOT NULL,
    nombre_proveedor VARCHAR(200) NOT NULL
);


-- Usuario de prueba
INSERT INTO login (user, password, user_type, id_usuario) 
values('jose@gmail.com', 'AA22', 'EMPLEADO', '1234');

-- Admins
INSERT INTO login (user, password, user_type, id_usuario) 
values('carlos@gmail.com', 'AA22', 'ADMINISTRADOR', '12345');

-- prueba select
SELECT * FROM login WHERE user = 'jose@gmail.com' AND password = 'AA22';
