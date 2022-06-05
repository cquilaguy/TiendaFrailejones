/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendafrailejones.modelo.interfaces;

import java.util.List;
import tiendafrailejones.modelo.Cliente;


/**
 *
 * @author admin
 */
public interface ICliente {
    boolean crear(Cliente cliente);
    void actualizar(Cliente cliente);
    void eliminar(Long id);
    Cliente existePorId(Long id); 
    List<Cliente> obtenetTodosLosCliente();
    List<Cliente> buscar(String parametros);
}
