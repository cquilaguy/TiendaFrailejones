/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendafrailejones.modelo.consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tiendafrailejones.modelo.Categoria;
import tiendafrailejones.modelo.Cliente;
import tiendafrailejones.modelo.Conexion;
import tiendafrailejones.modelo.interfaces.ICategoria;

/**
 *
 * @author admin
 */
public class ConsultasCategoria extends Conexion implements ICategoria{

    @Override
    public boolean crear(Categoria categoria) {
        PreparedStatement ps = null;
        Connection connection = getConexion();
        String sql = "INSERT INTO categoria (nombre, descripcion) "
                + "VALUES (?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            
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
    public void actualizar(Categoria categoria) {
        PreparedStatement ps = null;
        Connection connection = getConexion();
        String sql = "UPDATE categoria SET nombre=?, descripcion=? "
                + " WHERE id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            ps.setLong(3, categoria.getId());

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
    public Categoria existePorNombre(String nombre) {
        Categoria categoria = new Categoria();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT * FROM categoria WHERE nombre=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, nombre);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                categoria.setId(resultSet.getLong("id"));
                categoria.setNombre(resultSet.getString("nombre"));
                categoria.setDescripcion(resultSet.getString("descripcion"));
                
                return categoria;
            }
            return categoria;
        } catch (SQLException e) {
            System.err.println(e);
            return categoria;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public List<Categoria> obtenetTodasLasCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT * FROM categoria";

        try {
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                Categoria categoria = new Categoria();
                categoria.setId(resultSet.getLong("id"));
                categoria.setNombre(resultSet.getString("nombre"));
                categoria.setDescripcion(resultSet.getString("descripcion"));

                categorias.add(categoria);
            }
            return categorias;
        } catch (SQLException e) {
            System.err.println(e);
            return categorias;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

 
    
}
