/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendafrailejones.controlador;

import java.util.List;
import tiendafrailejones.modelo.Categoria;
import tiendafrailejones.modelo.consultas.ConsultasCategoria;
import tiendafrailejones.modelo.interfaces.ICategoria;

/**
 *
 * @author admin
 */
public class ControladorCategoria  implements ICategoria{
    
    private ConsultasCategoria consultasCategoria;
    
    public ControladorCategoria(ConsultasCategoria ConsultasCategoria){
        this.consultasCategoria= ConsultasCategoria;
    }

    @Override
    public boolean crear(Categoria categoria) {
       return consultasCategoria.crear(categoria);
    }

    @Override
    public void actualizar(Categoria categoria) {
        consultasCategoria.actualizar(categoria);
    }

    @Override
    public Categoria existePorNombre(String nombre) {
        return consultasCategoria.existePorNombre(nombre);
    }

    @Override
    public List<Categoria> obtenetTodasLasCategorias() {
        return consultasCategoria.obtenetTodasLasCategorias();   
    }
    

    
    
}
