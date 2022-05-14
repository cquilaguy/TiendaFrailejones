package tiendafrailejones.controlador;

import tiendafrailejones.modelo.ConsultasEmpleado;
import tiendafrailejones.modelo.Empleado;
import tiendafrailejones.modelo.interfaces.IEmpleado;


public class ControladorEmpleado implements IEmpleado{
    
    private ConsultasEmpleado consultasEmpleado;

    public ControladorEmpleado( ConsultasEmpleado consultasEmpleado) {
        this.consultasEmpleado = consultasEmpleado;
    }

    @Override
    public boolean crear(Empleado empleado) {
        return consultasEmpleado.crear(empleado);
        
    }

    @Override
    public void actualizar(Empleado empleado) {
        consultasEmpleado.actualizar(empleado);
    }

    @Override
    public void eliminar(Long id) {
        consultasEmpleado.eliminar(id);
    }

    @Override
    public Empleado existePorId(Long id) {
        return consultasEmpleado.existePorId(id);
    }
    
    
    
}
