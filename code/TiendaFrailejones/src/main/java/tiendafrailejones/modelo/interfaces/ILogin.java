package tiendafrailejones.modelo.interfaces;

import tiendafrailejones.modelo.Login;

public interface ILogin {
    Login existeUsuario(Login login);
    Login existeLoginPorId(Login login);
    boolean crearLoginParaUsaurio(Login login);
    void actualizarLogin(Login login);
}
