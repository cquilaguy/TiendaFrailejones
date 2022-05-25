package tiendafrailejones.modelo.interfaces;


import java.util.List;
import tiendafrailejones.modelo.Empleado;


public interface IEmpleado {
    
    boolean crear(Empleado empleado);
    void actualizar(Empleado empleado);
    void eliminar(Long id);
    Empleado existePorId(Long id); 
    List<Empleado> obtenetTodosLosEmpleado();
    
}
