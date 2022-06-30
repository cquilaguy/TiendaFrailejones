package tiendafrailejones.modelo.consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tiendafrailejones.modelo.Conexion;
import tiendafrailejones.modelo.Empleado;
import tiendafrailejones.modelo.interfaces.IEmpleado;
import tiendafrailejones.modelo.interfaces.IUsuarioOrdenar;

public class ConsultasEmpleado extends Conexion implements IEmpleado, IUsuarioOrdenar {

    @Override
    public boolean crear(Empleado empleado) {
        PreparedStatement ps = null;
        Connection connection = getConexion();
        String sql = "INSERT INTO empleado (nombre, telefono, identificacion, tipo_Identificacion, tipo_usuario, correo, usuario)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getTelefono());
            ps.setString(3, empleado.getIdentificacion());
            ps.setString(4, empleado.getTipoIdentificacion());
            ps.setString(5, empleado.getTipoUsuario());
            ps.setString(6, empleado.getCorreo());
            ps.setString(7, empleado.getUsuario());
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
        String sql = "UPDATE empleado SET nombre=?, telefono=?, identificacion=?, tipo_Identificacion=?, tipo_usuario=?, correo=?, activo=?, usuario=?"
                + " WHERE id=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getTelefono());
            ps.setString(3, empleado.getIdentificacion());
            ps.setString(4, empleado.getTipoIdentificacion());
            ps.setString(5, empleado.getTipoUsuario());
            ps.setString(6, empleado.getCorreo());
            ps.setLong(7, empleado.getActivo());
            ps.setString(8, empleado.getUsuario());
            ps.setLong(9, empleado.getId());
            
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
        String sql = "UPDATE empleado SET activo = 0 WHERE id = ?";
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
                empleado.setCorreo(resultSet.getString("correo"));
                empleado.setActivo(resultSet.getInt("activo"));
                empleado.setUsuario(resultSet.getString("usuario"));
                return empleado;
            }
            return empleado;
        } catch (SQLException e) {
            System.err.println(e);
            return empleado;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public List<Empleado> obtenetTodosLosEmpleado() {
        List<Empleado> empleados = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT * FROM empleado WHERE activo = 1";

        try {
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                
                Empleado empleado = new Empleado();
                empleado.setId(resultSet.getLong("id"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setTelefono(resultSet.getString("telefono"));
                empleado.setIdentificacion(resultSet.getString("identificacion"));
                empleado.setTipoIdentificacion(resultSet.getString("tipo_Identificacion"));
                empleado.setTipoUsuario(resultSet.getString("tipo_usuario"));
                empleado.setActivo(resultSet.getInt("activo"));
                empleado.setCorreo(resultSet.getString("correo"));
                empleado.setUsuario(resultSet.getString("usuario"));
                empleados.add(empleado);
               
            }
            return empleados;
        } catch (SQLException e) {
            System.err.println(e);
            return empleados;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }


    @Override
    public List<Empleado> buscar(String parametro) {
        List<Empleado> empleados = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT * FROM empleado WHERE identificacion like ? OR nombre like ? AND activo = 1";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + parametro + "%");
            ps.setString(2, "%" + parametro + "%");
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                
                Empleado empleado = new Empleado();
                empleado.setId(resultSet.getLong("id"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setTelefono(resultSet.getString("telefono"));
                empleado.setIdentificacion(resultSet.getString("identificacion"));
                empleado.setTipoIdentificacion(resultSet.getString("tipo_Identificacion"));
                empleado.setTipoUsuario(resultSet.getString("tipo_usuario"));
                empleado.setActivo(resultSet.getInt("activo"));
                empleado.setCorreo(resultSet.getString("correo"));
                empleado.setUsuario(resultSet.getString("usuario"));
                empleados.add(empleado);
               
            }
            return empleados;
        } catch (SQLException e) {
            System.err.println(e);
            return empleados;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public List<Empleado> ordenarPorNombreAsc() {
        List<Empleado> empleados = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT * FROM empleado WHERE activo = 1 ORDER BY nombre ASC";

        try {
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                Empleado empleado = new Empleado();
                empleado.setId(resultSet.getLong("id"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setTelefono(resultSet.getString("telefono"));
                empleado.setIdentificacion(resultSet.getString("identificacion"));
                empleado.setTipoIdentificacion(resultSet.getString("tipo_Identificacion"));
                empleado.setTipoUsuario(resultSet.getString("tipo_usuario"));
                empleado.setActivo(resultSet.getInt("activo"));
                empleado.setCorreo(resultSet.getString("correo"));
                empleado.setUsuario(resultSet.getString("usuario"));
                empleados.add(empleado);

            }
            return empleados;
        } catch (SQLException e) {
            System.err.println(e);
            return empleados;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public List<Empleado> ordenarPorNombreDesc() {
        List<Empleado> empleados = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT * FROM empleado WHERE activo = 1 ORDER BY nombre DESC";

        try {
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                Empleado empleado = new Empleado();
                empleado.setId(resultSet.getLong("id"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setTelefono(resultSet.getString("telefono"));
                empleado.setIdentificacion(resultSet.getString("identificacion"));
                empleado.setTipoIdentificacion(resultSet.getString("tipo_Identificacion"));
                empleado.setTipoUsuario(resultSet.getString("tipo_usuario"));
                empleado.setActivo(resultSet.getInt("activo"));
                empleado.setCorreo(resultSet.getString("correo"));
                empleado.setUsuario(resultSet.getString("usuario"));
                empleados.add(empleado);

            }
            return empleados;
        } catch (SQLException e) {
            System.err.println(e);
            return empleados;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public List<Empleado> soloAdministradores() {
        List<Empleado> empleados = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT * FROM empleado WHERE activo = 1 AND tipo_usuario = 'ADMINISTRADOR'";

        try {
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                Empleado empleado = new Empleado();
                empleado.setId(resultSet.getLong("id"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setTelefono(resultSet.getString("telefono"));
                empleado.setIdentificacion(resultSet.getString("identificacion"));
                empleado.setTipoIdentificacion(resultSet.getString("tipo_Identificacion"));
                empleado.setTipoUsuario(resultSet.getString("tipo_usuario"));
                empleado.setActivo(resultSet.getInt("activo"));
                empleado.setCorreo(resultSet.getString("correo"));
                empleado.setUsuario(resultSet.getString("usuario"));
                empleados.add(empleado);

            }
            return empleados;
        } catch (SQLException e) {
            System.err.println(e);
            return empleados;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public List<Empleado> soloEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT * FROM empleado WHERE activo = 1 AND tipo_usuario = 'EMPLEADO'";

        try {
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                Empleado empleado = new Empleado();
                empleado.setId(resultSet.getLong("id"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setTelefono(resultSet.getString("telefono"));
                empleado.setIdentificacion(resultSet.getString("identificacion"));
                empleado.setTipoIdentificacion(resultSet.getString("tipo_Identificacion"));
                empleado.setTipoUsuario(resultSet.getString("tipo_usuario"));
                empleado.setActivo(resultSet.getInt("activo"));
                empleado.setCorreo(resultSet.getString("correo"));
                empleado.setUsuario(resultSet.getString("usuario"));
                empleados.add(empleado);

            }
            return empleados;
        } catch (SQLException e) {
            System.err.println(e);
            return empleados;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

}
