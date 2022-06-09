package tiendafrailejones.controlador;

import java.util.List;
import tiendafrailejones.modelo.Cliente;
import tiendafrailejones.modelo.consultas.ConsultasEmpleado;
import tiendafrailejones.modelo.Empleado;
import tiendafrailejones.modelo.consultas.ConsultasCliente;
import tiendafrailejones.modelo.interfaces.ICliente;
import tiendafrailejones.modelo.interfaces.IClienteOrdenar;
import tiendafrailejones.modelo.interfaces.IEmpleado;


public class ControladorCliente implements ICliente, IClienteOrdenar{
    
    private ConsultasCliente consultasCliente;

    public ControladorCliente(ConsultasCliente consultasCliente) {
        this.consultasCliente = consultasCliente;
    }

  
    @Override
    public void eliminar(Long id) {
        consultasCliente.eliminar(id);
    }


    @Override
    public boolean crear(Cliente cliente) {
        return consultasCliente.crear(cliente);
    }

    @Override
    public void actualizar(Cliente cliente) {
        consultasCliente.actualizar(cliente);
    }

    @Override
    public Cliente existePorId(Long id) {
    return consultasCliente.existePorId(id);
    }

    @Override
    public List<Cliente> obtenetTodosLosCliente() {
        return consultasCliente.obtenetTodosLosCliente();
    }

    @Override
    public List<Cliente> buscar(String parametros) {
        return consultasCliente.buscar(parametros);
    }

    @Override
    public List<Cliente> ordenarPorNombreAsc() {
        return consultasCliente.ordenarPorNombreAsc();
    }

    @Override
    public List<Cliente> ordenarPorNombreDesc() {
        return consultasCliente.ordenarPorNombreDesc();
    }
    
    
    
}
