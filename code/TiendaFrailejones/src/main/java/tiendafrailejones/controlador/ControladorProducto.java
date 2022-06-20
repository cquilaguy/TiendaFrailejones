/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendafrailejones.controlador;

import java.util.List;
import tiendafrailejones.modelo.Cliente;
import tiendafrailejones.modelo.Producto;
import tiendafrailejones.modelo.consultas.ConsultaProducto;

import tiendafrailejones.modelo.interfaces.IProducto;

/**
 *
 * @author admin
 */
public class ControladorProducto implements IProducto {
    
    private ConsultaProducto consultasProducto;

    public ControladorProducto(ConsultaProducto consultasProducto) {
        this.consultasProducto = consultasProducto;
    }

    @Override
    public boolean crear(Producto producto, Long id) {
       return this.consultasProducto.crear(producto, id);
    }
    

    @Override
    public void actualizar(Producto producto, Long id) {
        consultasProducto.actualizar(producto, id);
    }

    @Override
    public void eliminar(Long id) {
        consultasProducto.eliminar(id);
    }

    @Override
    public Producto existePorNombre(String nombre, String marca) {
        return this.consultasProducto.existePorNombre(nombre, marca);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return consultasProducto.obtenerTodosLosProductos();
    }
    
    @Override
    public Long obtenerCategoriaIdPorNombre(String nombre){
        return consultasProducto.obtenerCategoriaIdPorNombre(nombre);
    }
    @Override
    public List<String> obtenerTodasLasCategorias(){
        return consultasProducto.obtenerTodasLasCategorias();
    }
    
    
    

    

   
}
