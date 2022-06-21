/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendafrailejones.modelo.interfaces;

import java.util.List;
import tiendafrailejones.modelo.Categoria;

/**
 *
 * @author admin
 */
public interface ICategoria {
    boolean crear(Categoria categoria);
    void actualizar(Categoria categoria);
    Categoria existePorNombre(String Nombre); 
    List<Categoria> obtenetTodasLasCategorias();
    List<Categoria> buscar(String parametros);
}
