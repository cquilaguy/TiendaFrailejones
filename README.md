# TiendaFrailejones

Este protecto fue creado con java 11, netbeans 13 y maven como gestor de dependencias.

## Links

- [Mockup](https://app.diagrams.net/#G1bE6y2wGq0QJB1j0UDAFmTSWV94ha4Q_C)
- [Diagramas](https://app.diagrams.net/#G1QWuYUbG6av05ugHKuxVc9KWZesuK825_)


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
