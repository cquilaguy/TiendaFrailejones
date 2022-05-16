/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendafrailejones.modelo.consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tiendafrailejones.modelo.Conexion;
import tiendafrailejones.modelo.Login;
import tiendafrailejones.modelo.interfaces.ILogin;

/**
 *
 * @author alan
 */
public class ConsultasLogin extends Conexion implements ILogin {

    @Override
    public Login existeUsuario(Login login) {
        Login loginUsuario = new Login();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT * FROM login WHERE user=? AND password=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, login.getUser());
            ps.setString(2, login.getPassword());
            resultSet = ps.executeQuery();
            
            if (resultSet.next()) {
                loginUsuario.setId(resultSet.getLong("id"));
                loginUsuario.setUser(resultSet.getString("user"));
                loginUsuario.setPassword(resultSet.getString("password"));
                loginUsuario.setUserType(resultSet.getString("user_type"));
                loginUsuario.setIdUsuario(resultSet.getString("id_usuario"));
            }
            return loginUsuario;
        } catch (SQLException e) {
            System.err.println(e);
            return loginUsuario;
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public boolean crearLoginParaUsaurio(Login login) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
