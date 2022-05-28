package tiendafrailejones.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tiendafrailejones.modelo.Conexion;
import tiendafrailejones.modelo.Login;
import tiendafrailejones.modelo.consultas.ConsultasLogin;
import tiendafrailejones.modelo.interfaces.ILogin;

public class ControladorLogin extends Conexion implements ILogin{

    private ConsultasLogin consultasLogin;

    public ControladorLogin(ConsultasLogin consultasLogin) {
        this.consultasLogin = consultasLogin;
    }
    
    @Override
    public Login existeUsuario(Login login) {
        return consultasLogin.existeUsuario(login);
    }

    @Override
    public boolean crearLoginParaUsaurio(Login login) {
        return consultasLogin.crearLoginParaUsaurio(login);
    }
    
}
