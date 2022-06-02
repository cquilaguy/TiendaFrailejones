/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendafrailejones.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import tiendafrailejones.modelo.Conexion;

/**
 *
 * @author anramosr
 */
public class log extends Conexion{
    private static final int loggedUserId = 0;
    private static log singleton = null;

    private log(){}
    
    public static log getInstance(){
        if(singleton == null){
            singleton = new log();
        }
        return singleton;
    }

    public void logData(String Description, String Source) {
        PreparedStatement ps = null;
        Connection connection = getConexion();  
        Timestamp dt = Timestamp.from(Instant.now());

        String sql = "INSERT INTO logData (description, source, user_id, date)"
                + "VALUES (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, Description);
            ps.setString(2, Source);
            ps.setInt(3, loggedUserId);
            ps.setTimestamp(4, dt);
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
}