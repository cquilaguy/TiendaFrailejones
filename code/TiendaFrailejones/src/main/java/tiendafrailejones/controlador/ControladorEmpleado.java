package tiendafrailejones.controlador;

import java.util.List;
import tiendafrailejones.modelo.consultas.ConsultasEmpleado;
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

    @Override
    public List<Empleado> obtenetTodosLosEmpleado() {
        return consultasEmpleado.obtenetTodosLosEmpleado();
    }

    @Override
    public List<Empleado> buscar(String parametro) {
        return consultasEmpleado.buscar(parametro);
    }
    
    
    
}
