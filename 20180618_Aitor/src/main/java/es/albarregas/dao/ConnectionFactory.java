/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Daw2
 */
public class ConnectionFactory {
    static DataSource datasource = null;
    static Connection conexion = null;
    static String DATASOURCE_NAME = "java:comp/env/jdbc/20180618_Aitor";

    public static Connection getConnection() {
        if (conexion == null) {
            Context contextoInicial;
            try {
                contextoInicial = new InitialContext();
                javax.sql.DataSource datasource = (javax.sql.DataSource) contextoInicial.lookup(DATASOURCE_NAME);
                conexion = (Connection) datasource.getConnection();
            } catch (NamingException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return conexion;
    }
    
    public static void closeConnection() {
            try{
                conexion.close();
            } catch (SQLException ex) {
                ex.getStackTrace();
            }
        
    }
}
