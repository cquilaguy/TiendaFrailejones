                        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendafrailejones.modelo.consultas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tiendafrailejones.modelo.Cliente;
import tiendafrailejones.modelo.Conexion;
import tiendafrailejones.modelo.Empleado;
import tiendafrailejones.modelo.Producto;
import tiendafrailejones.modelo.interfaces.IProducto;

/**
 *
 * @author admin
 */
public class ConsultaProducto extends Conexion implements IProducto{

   
    @Override
    public void actualizar(Producto producto, Long id) {
        java.sql.Date fecha = new java.sql.Date(producto.getFechaIngreso().getTime());
        PreparedStatement ps = null;
        Connection connection = getConexion();
        String sql = "UPDATE productos SET nombre=?, categoria_id=?, nombre_categoria=?, precio_compra=?, precio_venta=?,"
                + " fecha_ingreso=?, stock=?, marca=?, nombre_proveedor=?"
                + " WHERE id=? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setLong(2, id);
            ps.setString(3, producto.getNombreCategoria());
            ps.setLong(4, producto.getPrecioCompra());
            ps.setLong(5, producto.getPrecioVenta());
            ps.setDate(6, fecha);
            ps.setLong(7, producto.getStock());
            ps.setString(8, producto.getMarca());
            ps.setString(9, producto.getNombreProveedor());
            ps.setLong(10, producto.getId());

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
    public Producto existePorNombre(String nombre, String marca) {
        Producto producto = new Producto();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT * FROM productos WHERE nombre like ? AND marca like ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + nombre + "%");
            ps.setString(2, "%" + marca + "%");
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                producto.setId(resultSet.getLong("id"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setIdCategoria(resultSet.getLong("categoria_id"));
                producto.setNombreCategoria(resultSet.getString("nombre_categoria"));
                producto.setPrecioCompra(resultSet.getInt("precio_compra"));
                producto.setPrecioVenta(resultSet.getInt("precio_venta"));
                producto.setFechaIngreso(resultSet.getDate("fecha_ingreso"));
                producto.setStock(resultSet.getInt("stock"));
                producto.setMarca(resultSet.getString("marca"));
                producto.setNombreProveedor(resultSet.getString("nombre_proveedor"));
                producto.setActivo(resultSet.getInt("activo"));
                return producto;
            }
            return producto;
        } catch (SQLException e) {
            System.err.println(e);
            return producto;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }    
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        List<Producto> productos = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT * FROM productos WHERE activo = 1";

        try {
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                Producto producto = new Producto();
                producto.setId(resultSet.getLong("id"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setIdCategoria(resultSet.getLong("categoria_id"));
                producto.setNombreCategoria(resultSet.getString("nombre_categoria"));
                producto.setPrecioCompra(resultSet.getInt("precio_compra"));
                producto.setPrecioVenta(resultSet.getInt("precio_venta"));
                producto.setFechaIngreso(resultSet.getDate("fecha_ingreso"));
                producto.setStock(resultSet.getInt("stock"));
                producto.setMarca(resultSet.getString("marca"));
                producto.setNombreProveedor(resultSet.getString("nombre_proveedor"));
                producto.setActivo(resultSet.getInt("activo"));

                productos.add(producto);
            }
            return productos;
        } catch (SQLException e) {
            System.err.println(e);
            return productos;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    @Override
    public boolean crear(Producto producto, Long id) {
        java.sql.Date fecha = new java.sql.Date(producto.getFechaIngreso().getTime());
        PreparedStatement ps = null;
        Connection connection = getConexion();
        String sql = "INSERT INTO productos (nombre, categoria_id, nombre_categoria, precio_compra, precio_venta, fecha_ingreso, stock, marca, nombre_proveedor) "
                + "VALUES (?, ? ,?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setLong(2, id);
            ps.setString(3, producto.getNombreCategoria());
            ps.setLong(4, producto.getPrecioCompra());
            ps.setLong(5, producto.getPrecioVenta());
            ps.setDate(6, fecha);
            ps.setLong(7, producto.getStock());
            ps.setString(8, producto.getMarca());
            ps.setString(9, producto.getNombreProveedor());
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
    public void eliminar(Long id){
        PreparedStatement ps = null;
        Connection connection = getConexion();
        String sql = "UPDATE productos SET activo = 0 WHERE id = ?";
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
    public Long obtenerCategoriaIdPorNombre(String nombre){
        Long idCategoria = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT id FROM categoria WHERE nombre like  ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + nombre + "%");
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                idCategoria = resultSet.getLong("id");
                System.out.println(idCategoria);
                return idCategoria;
            }
            System.out.println(idCategoria);
            return idCategoria;
        } catch (SQLException e) {
            System.out.println(idCategoria);
            System.err.println(e);
            
            return idCategoria;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }    
    
    }
    @Override
    public List<String> obtenerTodasLasCategorias() {
    List<String> categorias = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        
        try {
            String sql = "select nombre from categoria";
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                
                String cate = resultSet.getString("nombre");
                System.out.print(cate);
                categorias.add(cate);
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
    @Override
        public boolean elementosTablaRegistro(Producto producto, Long id){
       java.sql.Date fecha = new java.sql.Date(producto.getFechaIngreso().getTime());
        PreparedStatement ps = null;
        Connection connection = getConexion();
        String sql = "INSERT INTO registro (id_producto, id_categoria, cantidad_producto, fecha_cambio) "
                + "VALUES (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, producto.getId());
            ps.setLong(2, id );
            ps.setInt(3, producto.getStock() );
            ps.setDate(4, fecha);       
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
        public int obtenerCantidadPorId(Producto producto){
        int cantidadProducto = 0;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT stock FROM productos WHERE id=? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1,producto.getId());
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                cantidadProducto = resultSet.getInt("stock");
                System.out.println(cantidadProducto);
                return cantidadProducto;
            }
            
            return cantidadProducto;
        } catch (SQLException e) {
            
            System.err.println(e);
            
            return cantidadProducto;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }  
        }

        public List<Producto> buscar(String parametros){                                                                            
        List<Producto> productos = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Connection connection = getConexion();
        String sql = "SELECT * FROM productos WHERE nombre like ? OR marca like ? OR nombre_categoria like ? AND activo = 1";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + parametros + "%");
            ps.setString(2, "%" + parametros + "%");
            ps.setString(3, "%" + parametros + "%");
            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                Producto producto = new Producto();
                producto.setId(resultSet.getLong("id"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setIdCategoria(resultSet.getLong("categoria_id"));
                producto.setNombreCategoria(resultSet.getString("nombre_categoria"));
                producto.setPrecioCompra(resultSet.getInt("precio_compra"));
                producto.setPrecioVenta(resultSet.getInt("precio_venta"));
                producto.setFechaIngreso(resultSet.getDate("fecha_ingreso"));
                producto.setStock(resultSet.getInt("stock"));
                producto.setMarca(resultSet.getString("marca"));
                producto.setNombreProveedor(resultSet.getString("nombre_proveedor"));
                producto.setActivo(resultSet.getInt("activo"));

                productos.add(producto);

            }
            return productos;
        } catch (SQLException e) {
            System.err.println(e);
            return productos;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        
        }
    
    
}
