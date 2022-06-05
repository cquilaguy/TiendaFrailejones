/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendafrailejones.controlador;

import java.util.List;
import tiendafrailejones.modelo.Deuda;
import tiendafrailejones.modelo.consultas.ConsultaDeuda;
import tiendafrailejones.modelo.interfaces.IDeuda;

/**
 *
 * @author alan
 */
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
    
}
