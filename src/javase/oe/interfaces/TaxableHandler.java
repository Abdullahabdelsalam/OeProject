/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.oe.interfaces;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javase.oe.db.DBConnectionFactory;

/**
 *
 * @author Abdullah
 */
public class TaxableHandler {
    public static int getTaxPct(String taxName){
        Connection conn =  DBConnectionFactory.getConnection();
         int paramValue = -1;
        try {
            String sql = "select PARAM_VALUE"
                    + " from parameters"
                    + " where PARAM_NAME = ?";
            PreparedStatement pstmt  = conn.prepareStatement(sql);
                    pstmt.setString(1, taxName);
                    
                   ResultSet rs = pstmt.executeQuery();
                   while(rs.next()){
                       paramValue = rs.getInt("PARAM_VALUE");
                   }
                    
        } catch (SQLException ex) {
            Logger.getLogger(TaxableHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return paramValue;
    }
    
    // update Tax value 
    public static void updateTaxPct(String taxName, double newTaxValue){
         Connection conn =  DBConnectionFactory.getConnection();
          try {
            String sql = "update parameters"
                    + " set PARAM_VALUE = ?"
                    + " where PARAM_NAME = ?";
            PreparedStatement pstmt  = conn.prepareStatement(sql);
             pstmt.setDouble(1, newTaxValue);
             pstmt.setString(2, taxName);
             
             pstmt.executeUpdate();
             
             conn.commit();
                    
        } catch (SQLException ex) {
            Logger.getLogger(TaxableHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    public static void main(String[] args) {
            /// fet tax vaue 
        //   int paravValue =  getTaxPct("TAX_PCT");
        //   System.out.println("param value = "+paravValue);
        
        
        // update tax value 
        updateTaxPct("TAX_PCT", 35);
    }
    
}
