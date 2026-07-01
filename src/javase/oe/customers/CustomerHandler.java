/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.oe.customers;

import javase.oe.db.DBConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdullah
 */
public class CustomerHandler {
    public static void insertCustomer(Customer customer){
        // 1- call get Connection method from ConnectionFactory class
         Connection conn =  DBConnectionFactory.getConnection();
          try {
        // 2- prepare statement [ sql statement : insert ] 
        String sql = "insert into customers"
                + " ( CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_PHONE,CUSTOMER_TYPE_ID )"
                + " values"
                + " ( ?, ?, ?, 0)";
         PreparedStatement pstmt = conn.prepareStatement(sql);
         
         //3. set parameters if found 
            pstmt.setString(1, customer.getCustomerName());
            pstmt.setString(2, customer.getCustomerAddress());
            pstmt.setString(3, customer.getCustomerPhone());
            
         // 4. execute statement 
            pstmt.executeUpdate();
         
         // 5. commit
            conn.commit();
         
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
         
    }
    
    
    public static void updateCustomer(Customer customer){
         //1 - Connection factory getConnection()
           Connection conn = DBConnectionFactory.getConnection();
          try {  
           // 2prepare statement [ sql ] : update 
            String sql = "Update customers"
                    + " set customer_name = ?,"
                    + " customer_phone = ?,"
                    + " customer_address = ?"
                    + " where customer_id = ?";
       
            PreparedStatement pstmt =  conn.prepareStatement(sql);
            // 3- set parameters 
                pstmt.setString(1, customer.getCustomerName());
                pstmt.setString(2, customer.getCustomerPhone());
                pstmt.setString(3, customer.getCustomerAddress());
                pstmt.setInt(4, customer.getCustomerId());
                      
            // 4- execute     
                pstmt.executeUpdate();
                
                // 5- commit
                conn.commit();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deleteCustomer(int customerId){
        //1 - Connection factory getConnection()
           Connection conn = DBConnectionFactory.getConnection();
          try {  
           // 2prepare statement [ sql ] : update 
            String sql = "delete from customers"
                    + " where customer_id = ?";
       
            PreparedStatement pstmt =  conn.prepareStatement(sql);
            // 3- set parameters 
 
                pstmt.setInt(1, customerId);
                      
            // 4- execute     
                pstmt.executeUpdate();
                
                // 5- commit
                conn.commit();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static ArrayList<Customer> getAllCustomers(){
       Connection conn = DBConnectionFactory.getConnection();
                ArrayList<Customer> myList = new ArrayList();
        try {
            String sql = "select CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_ADDRESS, "
                        + " CUSTOMER_PHONE "
                        + " from customers"
                        + " where customer_type_id = 0";
            PreparedStatement pstmt =  conn.prepareStatement(sql);
                       ResultSet rs =  pstmt.executeQuery();
                        
                     while(rs.next()) {
                        int customerId =  rs.getInt("CUSTOMER_ID");
                      String customerName =  rs.getString("CUSTOMER_NAME");
                     String customerAddress =  rs.getString("CUSTOMER_ADDRESS");
                       String customerPhone =  rs.getString("CUSTOMER_PHONE");
                 Customer customer = new Customer(customerId, customerName, customerPhone, customerAddress);
                       myList.add(customer);
                     } 
                       
                       
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
           return myList;
    }
    
     public static Customer getCustomerById(int customerId){
       Connection conn = DBConnectionFactory.getConnection();
                 Customer customer = null;
        try {
            String sql = "select CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_ADDRESS, "
                        + " CUSTOMER_PHONE "
                        + " from customers"
                        + " where customer_type_id = 0"
                        + " and customer_id = ?";
            PreparedStatement pstmt =  conn.prepareStatement(sql);
                  pstmt.setInt(1, customerId);
                       ResultSet rs =  pstmt.executeQuery();
                        
                     while(rs.next()) {
                      String customerName =  rs.getString("CUSTOMER_NAME");
                     String customerAddress =  rs.getString("CUSTOMER_ADDRESS");
                       String customerPhone =  rs.getString("CUSTOMER_PHONE");
                  customer = new Customer(customerId, customerName, customerPhone, customerAddress);
                      
                     } 
                       
                       
        } catch (SQLException ex) {
            Logger.getLogger(CustomerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
           return customer;
    }
    
    public static void main(String[] args) {
        // test insert 
      //  Customer customer = new Customer("WE Egypt", "1004", "Cairo - Smart Village");
     //  insertCustomer(customer);
        
      // test update 
    //  Customer customer = new Customer(2, "Raya Egypt", "19666", "Alex");
     /// updateCustomer(customer);
        
     //test delete
         //   deleteCustomer(2);
         
         
         
       // Get All cusomters
         /*  ArrayList<Customer> customersList =  getAllCustomers();
            for(Customer customer : customersList){
                System.out.println("customer id = "+customer.getCustomerId());
                System.out.print(", customer Name = "+customer.getCustomerName());
                System.out.print(", customer Phone = "+customer.getCustomerPhone());
                System.out.print(",customer Address = "+customer.getCustomerAddress());
                System.out.println("\n-------");
            }
        */
         
         // Get customer By id =
        Customer customer = getCustomerById(44);
         System.out.println("customer id = "+customer.getCustomerId());
                System.out.print(", customer Name = "+customer.getCustomerName());
                System.out.print(", customer Phone = "+customer.getCustomerPhone());
                System.out.print(",customer Address = "+customer.getCustomerAddress());
    }
    
}
