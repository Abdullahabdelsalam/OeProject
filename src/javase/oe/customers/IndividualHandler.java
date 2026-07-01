/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.oe.customers;

import javase.oe.db.DBConnectionFactory;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdullah
 */
public class IndividualHandler {
    public static void insertIndividual(Individual individual){
        Connection conn =DBConnectionFactory.getConnection();
        
        try {
            String sql="insert into customers"
                        +"(CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_PHONE, LIC_NUMBER, CUSTOMER_TYPE_ID)"
                        +"values"
                        +"( ?, ?, ?, ?, 3)";
            
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setString(1, individual.getCustomerName());
            pstmt.setString(2, individual.getCustomerAddress());
            pstmt.setString(3, individual.getCustomerPhone());
            pstmt.setString(4, individual.getLicNumber());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(IndividualHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void updateIndividual(Individual individual){
        Connection conn = DBConnectionFactory.getConnection();
        
        try {
            String sql="update customers"
                    +" set CUSTOMER_NAME = ?"
                    +" CUSTOMER_ADDRESS = ?"
                    +" CUSTOMER_PHONE = ?"
                    +" LIC_NUMBER = ?"
                    +" where CUSTOMER_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, individual.getCustomerName());
            pstmt.setString(2, individual.getCustomerAddress());
            pstmt.setString(3, individual.getCustomerPhone());
            pstmt.setString(4, individual.getLicNumber());
            pstmt.setInt(5, individual.getCustomerId());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(IndividualHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void deleteIndividual(int individual){
        Connection conn = DBConnectionFactory.getConnection();
        
        try {
            String sql=" delete from customers"
                    +" where customer_id =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, individual);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(IndividualHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
//    public static void main(String[] args) {
//        
//    }
}
