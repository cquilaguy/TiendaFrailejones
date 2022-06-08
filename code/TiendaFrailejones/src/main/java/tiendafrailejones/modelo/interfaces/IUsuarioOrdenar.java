package tiendafrailejones.modelo.interfaces;

import java.util.List;
import tiendafrailejones.modelo.Empleado;

public interface IUsuarioOrdenar {
    List<Empleado> ordenarPorNombreAsc(); 
    List<Empleado> ordenarPorNombreDesc(); 
    List<Empleado> soloAdministradores(); 
    List<Empleado> soloEmpleados(); 
}
