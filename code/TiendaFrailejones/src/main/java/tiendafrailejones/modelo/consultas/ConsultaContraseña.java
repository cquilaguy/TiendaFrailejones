/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendafrailejones.modelo.consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tiendafrailejones.controlador.ControladorEmpleado;
import tiendafrailejones.modelo.Conexion;
import tiendafrailejones.modelo.Empleado;
import tiendafrailejones.modelo.Login;
import tiendafrailejones.utils.AES;
import tiendafrailejones.utils.TipoDocumentos;

/**
 *
 * @author admin
 */
public class ConsultaContraseña extends Conexion{
    
    private final ConsultasEmpleado consultasEmpleado = new ConsultasEmpleado();
    private final ControladorEmpleado controladorEmpleado = new ControladorEmpleado(consultasEmpleado);
    


    public ConsultaContraseña() {
    }
    
    public Boolean checkPassword(String password, Login login){
        String pass = null;
        Empleado empleado = controladorEmpleado.existePorId(login.getIdUsuario());
        String contrasena = TipoDocumentos.getById(empleado.getTipoIdentificacion()) + empleado.getIdentificacion();

  
        try {
            contrasena = AES.singletonAes().encrypt(contrasena);
            
        } catch (Exception e) {           
        }       

        if(contrasena.equals(password)){
            return true;
        }else{
        return false;
        }
    }
}
