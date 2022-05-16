package tiendafrailejones.controlador;

import tiendafrailejones.modelo.Login;
import tiendafrailejones.modelo.consultas.ConsultasLogin;
import tiendafrailejones.modelo.interfaces.ILogin;

public class ControladorLogin implements ILogin{

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
        return false;
    }
    
}
