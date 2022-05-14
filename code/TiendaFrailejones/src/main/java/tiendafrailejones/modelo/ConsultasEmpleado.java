package tiendafrailejones.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tiendafrailejones.modelo.interfaces.IEmpleado;

public class ConsultasEmpleado extends Conexion implements IEmpleado {

    @Override
    public boolean crear(Empleado empleado) {
        PreparedStatement ps = null;
        Connection connection = getConexion();
        String sql = "INSERT INTO empleado (nombre, telefono, identificacion, tipo_Identificacion, tipo_usuario)"
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getTelefono());
            ps.setString(3, empleado.getIdentificacion());
            ps.setString(4, empleado.getTipoIdentificacion());
            ps.setString(5, empleado.getTipoUsuario());
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
    public void actualizar(Empleado empleado) {
        PreparedStatement ps = null;
        Connection connection = getConexion();
        String sql = "UPDATE empleado SET nombre=?, telefono=?, identificacion=?, tipo_Identificacion=?, tipo_usuario=?"
                + "WHERE id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getTelefono());
            ps.setString(3, empleado.getIdentificacion());
            ps.setString(4, empleado.getTipoIdentificacion());
            ps.setString(5, empleado.getTipoUsuario());
            ps.setLong(6, empleado.getId());
            ps.execute();

        } catch (SQLException e) {
            System.err.println(e);

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public void eliminar(Long id) {
        PreparedStatement ps = null;
        Connection connection = getConexion();
        String sql = "DELETE FROM empleado WHERE id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ps.execute();

        } catch (SQLException e) {
            System.err.println(e);

        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public Empleado existePorId(Long id) {
        Empleado empleado = new Empleado();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT * FROM empleado WHERE identificacion=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            resultSet = ps.executeQuery();
            
            if (resultSet.next()) {
                empleado.setId(resultSet.getLong("id"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setTelefono(resultSet.getString("telefono"));
                empleado.setIdentificacion(resultSet.getString("identificacion"));
                empleado.setTipoIdentificacion(resultSet.getString("tipo_Identificacion"));
                empleado.setTipoUsuario(resultSet.getString("tipo_usuario"));
                return empleado;
            }
            return null;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

}
