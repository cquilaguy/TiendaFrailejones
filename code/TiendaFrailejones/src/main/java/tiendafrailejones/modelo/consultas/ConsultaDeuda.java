package tiendafrailejones.modelo.consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tiendafrailejones.modelo.Cliente;
import tiendafrailejones.modelo.Conexion;
import tiendafrailejones.modelo.Deuda;
import tiendafrailejones.modelo.interfaces.IDeuda;

public class ConsultaDeuda extends Conexion implements IDeuda{

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
            ps.setString(5, deuda.getAbonoDeuda());
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

    @Override
    public List<Deuda> obtenerDeudas(Long idUsuario) {
        
       List<Deuda> deudas = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT * FROM gestion_deuda WHERE id_cliente = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, idUsuario);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                
                Deuda deuda = new Deuda();
                deuda.setId(resultSet.getInt("id"));
                deuda.setIdCliente(resultSet.getInt("id_cliente"));
                deuda.setTodalDeuda(resultSet.getBigDecimal("valor_total_productos"));
                deuda.setFecha(resultSet.getString("fecha"));
                deuda.setDescripcion(resultSet.getString("descripcion"));
                deuda.setAbonoDeuda(resultSet.getString("abono_deuda"));
                deudas.add(deuda);
            }
            return deudas;
        } catch (SQLException e) {
            System.err.println(e);
            return deudas;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    
    
}
