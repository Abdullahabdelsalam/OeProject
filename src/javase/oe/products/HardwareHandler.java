/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.oe.products;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javase.oe.db.DBConnectionFactory;

/**
 *
 * @author Abdullah
 */
public class HardwareHandler {
    public static void insertHardware(Hardware hardware){
       Connection conn =  DBConnectionFactory.getConnection();
        try {
       String sql = "insert into products"
               + " (PRODUCT_NAME, PRODUCT_RETAIL_PRICE, PRODUCT_DESC)"
               + " values"
               + " (?, ?, ?)";
            PreparedStatement pstmt =  conn.prepareStatement(sql);
            pstmt.setString(1, hardware.getProductName());
            pstmt.setDouble(2, hardware.getProductRetailPrice());
            pstmt.setString(3, hardware.getProductDescription());
            
            pstmt.executeUpdate();
            
             sql = "insert into hardware"
               + " (HARDWARE_WARRANTY_PRD, PRODUCT_ID)"
               + " values"
               + " ( ?, PRODUCTS_SEQ.CURRVAL)";
             pstmt =  conn.prepareStatement(sql);
             pstmt.setInt(1, hardware.getWarrantyPeriod());
             
             pstmt.executeUpdate();
             conn.commit();
                     
             
        } catch (SQLException ex) {
            Logger.getLogger(HardwareHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateHardware(Hardware hardware){
         Connection conn =  DBConnectionFactory.getConnection();
        try {
         String sql = "UPDATE products"
                 + " set product_name = ?,"
                 + " product_retail_price = ?,"
                 + " product_desc = ?"
                 + " where product_id = ?";
            PreparedStatement pstmt =  conn.prepareStatement(sql);
                    pstmt.setString(1, hardware.getProductName());
                    pstmt.setDouble(2, hardware.getProductRetailPrice());
                    pstmt.setString(3, hardware.getProductDescription());
                    pstmt.setInt(4, hardware.getProductId());
            
                    pstmt.executeUpdate();
                    
                     sql = "UPDATE hardware"
                 + " set HARDWARE_WARRANTY_PRD = ?"
                 + " where product_id = ?";
             pstmt =  conn.prepareStatement(sql);
                    pstmt.setInt(1, hardware.getWarrantyPeriod());
                    pstmt.setInt(2, hardware.getProductId());
                    
                    pstmt.executeUpdate();
                    
                    conn.commit();
            
        } catch (SQLException ex) {
            Logger.getLogger(HardwareHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static void deleteHardware(int productId){
                 Connection conn =  DBConnectionFactory.getConnection();
        try {
                 String sql = "delete from hardware"
                         + " where product_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, productId);
            
                pstmt.executeUpdate();
                
                sql = "delete from products"
                        + " where product_id = ?";
             pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, productId);
                 pstmt.executeUpdate();
                
                 conn.commit();
                
        } catch (SQLException ex) {
            Logger.getLogger(HardwareHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
                 
    }
    
    public static ArrayList<Hardware> getAllHardware(){
        Connection conn =  DBConnectionFactory.getConnection();
                ArrayList<Hardware> hwList = new ArrayList();
        try {
            String sql = "select products.PRODUCT_ID, PRODUCT_NAME,"
                    + " PRODUCT_RETAIL_PRICE, PRODUCT_DESC, HARDWARE_WARRANTY_PRD"
                    + " from products, hardware"
                    + " where products.product_id = hardware.product_id";
            PreparedStatement pstmt =  conn.prepareStatement(sql);
            
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                       int productId =  rs.getInt("PRODUCT_ID");
                      String productName =  rs.getString("PRODUCT_NAME");
                      double productRetailPice = rs.getDouble("PRODUCT_RETAIL_PRICE");
                      String productDesc =  rs.getString("PRODUCT_DESC");
                      int productWarrantyPrd = rs.getInt("HARDWARE_WARRANTY_PRD");
                      
            Hardware hw = new Hardware(productId, productName, productRetailPice, productDesc, productWarrantyPrd);
                      
                      hwList.add(hw);
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(HardwareHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return hwList;
    }
    public static Hardware getHardwareById(int productId){
        Connection conn =  DBConnectionFactory.getConnection();
              Hardware hw=null; 
        try {
            String sql = "select PRODUCT_NAME,"
                    + " PRODUCT_RETAIL_PRICE, PRODUCT_DESC, HARDWARE_WARRANTY_PRD"
                    + " from products, hardware"
                    + " where products.product_id = hardware.product_id"
                    +" and products.product_id =?";
            PreparedStatement pstmt =  conn.prepareStatement(sql);
            pstmt.setInt(1, productId);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                      
                      String productName =  rs.getString("PRODUCT_NAME");
                      double productRetailPice = rs.getDouble("PRODUCT_RETAIL_PRICE");
                      String productDesc =  rs.getString("PRODUCT_DESC");
                      int productWarrantyPrd = rs.getInt("HARDWARE_WARRANTY_PRD");
                      
             hw = new Hardware(productId, productName, productRetailPice, productDesc, productWarrantyPrd);
                      
                     
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(HardwareHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return hw;
    }
    public static void main(String[] args) {
        // test insert 
     //   Hardware hw = new Hardware("Scanner", 3000, "scanners", 4);
      //   insertHardware(hw);
        
        // test update 
       //  Hardware hw = new Hardware(2, "printer Xerox", 750, "Xerox printers", 7);
       //  updateHardware(hw);
         
         // test delete
        // deleteHardware(2);
        
        /// GEt All Hw List 
             /*  ArrayList<Hardware> hwList = getAllHardware();
               for(Hardware hardware : hwList){
                   System.out.print("product id = "+hardware.getProductId());
                   System.out.print(", product name = "+hardware.getProductName());
                   System.out.print(", retail price = "+hardware.getProductRetailPrice());
                   System.out.print(", product desc = "+hardware.getProductDescription());
                   System.out.print(", warranty period = "+hardware.getWarrantyPeriod());
                   System.out.println("\n");
               }*/
        
                Hardware hardware=getHardwareById(3);
               
                   System.out.print("product id = "+hardware.getProductId());
                   System.out.print(", product name = "+hardware.getProductName());
                   System.out.print(", retail price = "+hardware.getProductRetailPrice());
                   System.out.print(", product desc = "+hardware.getProductDescription());
                   System.out.print(", warranty period = "+hardware.getWarrantyPeriod());
                   
               
        
    }
}
