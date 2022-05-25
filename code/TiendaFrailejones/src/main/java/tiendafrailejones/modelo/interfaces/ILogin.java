package tiendafrailejones.modelo.interfaces;

import tiendafrailejones.modelo.Login;

public interface ILogin {
    Login existeUsuario(Login login);
    boolean crearLoginParaUsaurio(Login login);
}
