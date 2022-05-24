CREATE TABLE auditoria(
	id INT AUTO_INCREMENT PRIMARY KEY,
	fecha DATETIME NOT NULL,
	accion VARCHAR(20) NOT NULL,
	tabla VARCHAR(20) NOT NULL
);


CREATE TRIGGER auditoria_empleado 
	AFTER INSERT ON empleado
FOR EACH ROW
BEGIN
	INSERT INTO auditoria (fecha, accion, tabla) values (NOW(), 'INSERT', 'EMPLEADO');
END


CREATE TRIGGER auditoria_empleado_update 
	AFTER UPDATE  ON empleado
FOR EACH ROW
BEGIN
	INSERT INTO auditoria (fecha, accion, tabla) values (NOW(), 'UPDATE', 'EMPLEADO');
END


CREATE TRIGGER auditoria_empleado_delete
	AFTER DELETE  ON empleado
FOR EACH ROW
BEGIN
	INSERT INTO auditoria (fecha, accion, tabla) values (NOW(), 'DELETE', 'EMPLEADO');
END
