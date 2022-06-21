/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendafrailejones.modelo.interfaces;

import java.util.List;
import tiendafrailejones.modelo.Cliente;
import tiendafrailejones.modelo.Producto;

/**
 *
 * @author admin
 */
public interface IProducto {
    boolean crear(Producto producto, Long id);
    void actualizar(Producto producto, Long id);
    void eliminar(Long id);
    Producto existePorNombre(String Nombre, String marca);
    Long obtenerCategoriaIdPorNombre(String Nombre);
    boolean elementosTablaRegistro(Producto producto, Long id);
    List<Producto> obtenerTodosLosProductos();
    List<String> obtenerTodasLasCategorias();
    //List<Cliente> buscar(String parametros);
}
