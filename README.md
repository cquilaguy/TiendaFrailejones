# TiendaFrailejones

Este protecto fue creado con java 11, netbeans 13 y maven como gestor de dependencias.

## Instrucciones de uso
1. Ver el script para crear base de datos.
```sql
CREATE DATABASE tiendafrailejones;
```
2. Usar base de datos recien creada.
```sql
USE tiendafrailejones;
```
3. Crear usuario admin
```sql
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'admin';
```

4. Dar permisor al usuario admin
```sql
GRANT CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT, REFERENCES, RELOAD on *.* TO 'admin'@'localhost' WITH GRANT OPTION;
 ```

 5. Crear tablas del sistema
