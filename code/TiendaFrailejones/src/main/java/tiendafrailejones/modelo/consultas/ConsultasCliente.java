package tiendafrailejones.modelo.consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tiendafrailejones.modelo.Cliente;
import tiendafrailejones.modelo.Conexion;
import tiendafrailejones.modelo.Empleado;
import tiendafrailejones.modelo.interfaces.ICliente;
import tiendafrailejones.modelo.interfaces.IEmpleado;

public class ConsultasCliente extends Conexion implements ICliente {

    @Override
    public boolean crear(Cliente cliente) {
        PreparedStatement ps = null;
        Connection connection = getConexion();
        String sql = "INSERT INTO cliente (nombre, telefono, identificacion, tipo_Identificacion, tipo_usuario, direccion )"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getIdentificacion());
            ps.setString(4, cliente.getTipoIdentificacion());
            ps.setString(5, cliente.getTipoUsuario());
            ps.setString(6, cliente.getDireccion());
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
    public void actualizar(Cliente cliente) {
        PreparedStatement ps = null;
        Connection connection = getConexion();
        String sql = "UPDATE cliente SET nombre=?, telefono=?, identificacion=?, tipo_Identificacion=?, tipo_usuario=?, direccion=? "
                + " WHERE id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTelefono());
            ps.setString(3, cliente.getIdentificacion());
            ps.setString(4, cliente.getTipoIdentificacion());
            ps.setString(5, cliente.getTipoUsuario());
            ps.setString(6, cliente.getDireccion());
            ps.setLong(7, cliente.getId());
            
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
        String sql = "UPDATE cliente SET activo = 0 WHERE id = ?";
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
    public Cliente existePorId(Long id) {
        Cliente cliente = new Cliente();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT * FROM cliente WHERE identificacion=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                cliente.setId(resultSet.getLong("id"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setIdentificacion(resultSet.getString("identificacion"));
                cliente.setTipoIdentificacion(resultSet.getString("tipo_Identificacion"));
                cliente.setTipoUsuario(resultSet.getString("tipo_usuario"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setActivo(resultSet.getInt("activo"));
                return cliente;
            }
            return cliente;
        } catch (SQLException e) {
            System.err.println(e);
            return cliente;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public List<Cliente> obtenetTodosLosCliente() {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT * FROM cliente WHERE activo = 1";

        try {
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getLong("id"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setIdentificacion(resultSet.getString("identificacion"));
                cliente.setTipoIdentificacion(resultSet.getString("tipo_Identificacion"));
                cliente.setTipoUsuario(resultSet.getString("tipo_usuario"));
                cliente.setActivo(resultSet.getInt("activo"));
                cliente.setDireccion(resultSet.getString("direccion"));
                clientes.add(cliente);
               
            }
            return clientes;
        } catch (SQLException e) {
            System.err.println(e);
            return clientes;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public List<Cliente> buscar(String parametros) {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT * FROM cliente WHERE nombre = ? OR identificacion = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + parametros + "%");
            ps.setString(2, "%" + parametros + "%");
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getLong("id"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setTelefono(resultSet.getString("telefono"));
                cliente.setIdentificacion(resultSet.getString("identificacion"));
                cliente.setTipoIdentificacion(resultSet.getString("tipo_Identificacion"));
                cliente.setTipoUsuario(resultSet.getString("tipo_usuario"));
                cliente.setActivo(resultSet.getInt("activo"));
                cliente.setDireccion(resultSet.getString("direccion"));
                clientes.add(cliente);
               
            }
            return clientes;
        } catch (SQLException e) {
            System.err.println(e);
            return clientes;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

}
