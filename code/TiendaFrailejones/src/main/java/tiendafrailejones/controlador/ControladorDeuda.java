package tiendafrailejones.controlador;

import java.util.List;
import tiendafrailejones.modelo.Deuda;
import tiendafrailejones.modelo.consultas.ConsultaDeuda;
import tiendafrailejones.modelo.interfaces.IDeuda;


public class ControladorDeuda implements IDeuda{

    public ConsultaDeuda consultaDeuda;

    public ControladorDeuda(ConsultaDeuda consultaDeuda) {
        this.consultaDeuda = consultaDeuda;
    }
    
    @Override
    public boolean crear(Deuda deuda) {
        return consultaDeuda.crear(deuda);
    }

    @Override
    public List<Deuda> obtenerDeudas(Long idUsuario) {
        return consultaDeuda.obtenerDeudas(idUsuario);
    }

    @Override
    public List<Deuda> obtenerDeudasTreintDias(Long idUsuario) {
        return consultaDeuda.obtenerDeudasTreintDias(idUsuario);
    }
    
}
