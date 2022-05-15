package tiendafrailejones.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private final String nombreBaseDatos = "/tiendafrailejones";
    private final String user = "root";
    private final String password = "";
    private final String puerto = "3306";
    private final String url = "jdbc:mysql://localhost:" + puerto + nombreBaseDatos;
    private Connection connection = null;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(this.url, this.user, this.password);

        } catch (SQLException e) {
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

}
