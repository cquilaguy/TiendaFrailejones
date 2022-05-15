
-- Crear la base de datos
CREATE DATABASE tiendafrailejones;

-- Crear un nuevo usuario
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';


-- Asignarle permisos a un usuario
GRANT CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT, REFERENCES, RELOAD on *.* TO 'admin'@'localhost' WITH GRANT OPTION;

-- Usar la base de datos que acabamos de crear
USE tiendafrailejones;

-- Crear la tabla de empleados
CREATE TABLE empleado(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nombre VARCHAR(200) NOT NULL,
	telefono VARCHAR(200) NOT NULL, 
	identificacion VARCHAR(200) NOT NULL, 
	tipo_Identificacion VARCHAR(200) NOT NULL,
	tipo_usuario VARCHAR(200) NOT NULL
);