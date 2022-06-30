package tiendafrailejones.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tiendafrailejones.modelo.Conexion;
import tiendafrailejones.modelo.Login;
import tiendafrailejones.modelo.consultas.ConsultasLogin;
import tiendafrailejones.modelo.interfaces.ILogin;
import tiendafrailejones.utils.log;;

public class ControladorLogin extends Conexion implements ILogin{

    private ConsultasLogin consultasLogin;

    public ControladorLogin(ConsultasLogin consultasLogin) {
        this.consultasLogin = consultasLogin;
    }
    
    @Override
    public Login existeUsuario(Login login) {
        log logger = log.getInstance();
        Login tmp = consultasLogin.existeUsuario(login);
        if(tmp.getCorreo()==null){
            logger.logData("Se ha intentado acceder como el usuario: "+login.getCorreo(), "login");
        }
        else {
            logger.logData("Usuario ha entrado: "+tmp.getIdUsuario(), "login");
        }
        return tmp;
    }

    @Override
    public boolean crearLoginParaUsaurio(Login login) {
        log logger = log.getInstance();
        boolean res = consultasLogin.crearLoginParaUsaurio(login);
        if(res){
            logger.logData("Se ha creado un nuevo usuario: "+login.getCorreo(), "login");
        }
        else {
            logger.logData("Se ha intentado crear un nuevo usuario: "+login.getCorreo(), "login");
        }
        return res;
    }

    @Override
    public void actualizarLogin(Login login) {
        log logger = log.getInstance();
        logger.logData("Se ha actualizado el usuario: "+login.getCorreo(), "login");
        consultasLogin.actualizarLogin(login);
    }

    @Override
    public Login existeLoginPorId(Login login) {
        return consultasLogin.existeLoginPorId(login);
    }
    
}
