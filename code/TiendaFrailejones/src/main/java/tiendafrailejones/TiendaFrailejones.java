package tiendafrailejones;

import java.io.IOException;
import tiendafrailejones.utils.AES;
import tiendafrailejones.vista.ui.login;

/**
 *
 * @author alan
 */
public class TiendaFrailejones {

    public static void main(String[] args) throws IOException {

        login login = new login();
        login.setVisible(true);
        
    }
}
