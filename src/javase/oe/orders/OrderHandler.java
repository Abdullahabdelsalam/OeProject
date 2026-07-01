/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.oe.orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javase.oe.db.DBConnectionFactory;

/**
 *
 * @author Abdullah
 */
public class OrderHandler {
    // confirm order method
    public static void confirmOrder(Order order){
         Connection conn =  DBConnectionFactory.getConnection();
                
        try {
         String sql = "insert into orders"
                       + " ( ORDER_DATE, ORDER_TOTAL, CUSTOMER_ID)"
                       + " values"
                       + " (?, ?, ?)";
            PreparedStatement pstmt =  conn.prepareStatement(sql);
            // pstmt.setDate :  should use java.sql.Date            but we have java.util.Date
            //   so : we must convert from java.util.Date    to java.sql.Date
            java.sql.Date mySqlDate = new java.sql.Date(order.getOrderDate().getTime());
            pstmt.setDate(1, mySqlDate);
            pstmt.setDouble(2, order.getOrderTotal());
            pstmt.setInt(3, order.getCustomer().getCustomerId());
            
            pstmt.executeUpdate();
            
            
           ArrayList<OrderItem> itemsList =  order.getItemsList();
           for(OrderItem item : itemsList){
            // insert list of items into table order items
            sql = "insert into order_items"
                    + " ( ORDER_ITEM_QTY, ORDER_ID, PRODUCT_ID ) "
                    + " values"
                    + " ( ?, ORDERS_SEQ.currval , ? )";
                   pstmt =  conn.prepareStatement(sql);
                   pstmt.setInt(1, item.getQuantity() );
                   pstmt.setInt(2, item.getProduct().getProductId());
                   
                   pstmt.executeUpdate();
           } 
            
            conn.commit();
            
        } catch (SQLException ex) {
            Logger.getLogger(OrderHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public static void main(String[] args) {
        
                
    }
 }
