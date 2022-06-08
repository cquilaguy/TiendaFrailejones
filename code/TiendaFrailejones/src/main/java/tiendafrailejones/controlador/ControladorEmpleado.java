package tiendafrailejones.controlador;

import java.util.List;
import tiendafrailejones.modelo.consultas.ConsultasEmpleado;
import tiendafrailejones.modelo.Empleado;
import tiendafrailejones.modelo.interfaces.IEmpleado;
import tiendafrailejones.utils.log;


public class ControladorEmpleado implements IEmpleado{
    
    private ConsultasEmpleado consultasEmpleado;

    public ControladorEmpleado( ConsultasEmpleado consultasEmpleado) {
        this.consultasEmpleado = consultasEmpleado;
    }

    @Override
    public boolean crear(Empleado empleado) {
        log logger = log.getInstance();
        Boolean tmp = consultasEmpleado.crear(empleado);
        if(tmp){
            logger.logData("Se ha creado el empleado: "+empleado.getIdentificacion(), "empleado");
        }
        else {
            logger.logData("Se ha intentado crear el empleado: "+empleado.getIdentificacion(), "empleado");
        }
        return tmp;
    }

    @Override
    public void actualizar(Empleado empleado) {
        log logger = log.getInstance();
        logger.logData("Se ha creado el empleado: "+empleado.getIdentificacion(), "empleado");
        consultasEmpleado.actualizar(empleado);
    }

    @Override
    public void eliminar(Long id) {
        log logger = log.getInstance();
        logger.logData("Se ha creado el empleado: "+id, "empleado");
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
