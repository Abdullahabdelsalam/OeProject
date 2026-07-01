 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.oe.db;

import java.sql.Connection;
import java .sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdullah
 */
public class DBConnectionFactory {
    private final static String USER = "oe";
    private final static String PASS = "123";
    private final static String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
    
    public static Connection getConnection(){
        Connection conn = null;
        try {
           conn =  DriverManager.getConnection(DB_URL, USER, PASS);
           conn.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static void main(String[] args) {
        getConnection();
        
    }
    
}

