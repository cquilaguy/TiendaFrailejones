package tiendafrailejones.modelo.consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tiendafrailejones.modelo.Conexion;
import tiendafrailejones.modelo.interfaces.IDeuda;

public class Deuda extends Conexion implements IDeuda{

    @Override
    public boolean crear(tiendafrailejones.modelo.Deuda deuda) {
        PreparedStatement ps = null;
        Connection connection = getConexion();
        String sql = "INSERT INTO gestion_deuda (id_cliente, valor_total_productos, fecha, descripcion, abono_deuda) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, deuda.getIdCliente());
            ps.setBigDecimal(2, deuda.getTodalDeuda());
            ps.setString(3, deuda.getFecha());
            ps.setString(4, deuda.getDescripcion());
            ps.setBigDecimal(5, deuda.getAbonoDeuda());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
}
