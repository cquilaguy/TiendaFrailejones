package tiendafrailejones.modelo.interfaces;

import java.util.List;
import tiendafrailejones.modelo.Deuda;

public interface IDeuda {
    boolean crear(Deuda deuda);
    List<Deuda> obtenerDeudas(Long idUsuario);
}
