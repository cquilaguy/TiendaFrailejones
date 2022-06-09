
package tiendafrailejones.modelo.interfaces;

import java.util.List;
import tiendafrailejones.modelo.Cliente;


public interface IClienteOrdenar {

    List<Cliente> ordenarPorNombreAsc();
    List<Cliente> ordenarPorNombreDesc();
}
