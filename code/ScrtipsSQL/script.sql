
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

CREATE TABLE login(
	id INT AUTO_INCREMENT PRIMARY KEY,
	user VARCHAR(200) NOT NULL,
	password VARCHAR(200) NOT NULL,
	user_type VARCHAR(200) NOT NULL,
	id_usuario VARCHAR(200) NOT NULL
);

-- Usuario de prueba
INSERT INTO login (user, password, user_type, id_usuario) 
values('jose@gmail.com', 'AA22', 'empleado', '1234');

-- Admins
INSERT INTO login (user, password, user_type, id_usuario) 
values('carlos@gmail.com', 'AA22', 'ADMINISTRADOR', '12345');

-- prueba select
SELECT * FROM login WHERE user = 'jose@gmail.com' AND password = 'AA22';
