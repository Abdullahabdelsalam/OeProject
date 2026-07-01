/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.oe.customers;

import javase.oe.db.DBConnectionFactory;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdullah
 */
public class CompanyHandler {
    public static void insertCompany (Company company){
        //call connection
       Connection conn= DBConnectionFactory.getConnection();
       //prepare statment
       try {
       String sql="insert into customers"
               +"( CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_PHONE, CUSTOMER_CONTACT, CUSTOMER_DISCOUNT, CUSTOMER_TYPE_ID )"
               +"values"
               +"(?, ?, ?, ?, 10, 1)";
             //set parameters
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, company.getCustomerName());
            pstmt.setString(2, company.getCustomerAddress());
            pstmt.setString(3, company.getCustomerPhone());
            pstmt.setString(4, company.getContact());
            //execute stutment
            pstmt.executeUpdate();
            //commit
            conn.commit();
        
        } catch (SQLException ex) {
            Logger.getLogger(CompanyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updatecompany(Company company){
        //call gat connection 
       Connection conn = DBConnectionFactory.getConnection();
       //prepare statemen
       try {
       String sql ="update customers"
               +" set CUSTOMER_NAME = ?,"
               +" CUSTOMER_ADDRESS =?,"
               +" CUSTOMER_PHONE =?," 
               +" CUSTOMER_CONTACT=?,"
               + " CUSTOMER_DISCOUNT = 10"
               +" where CUSTOMER_ID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, company.getCustomerName());
            pstmt.setString(2, company.getCustomerAddress());
            pstmt.setString(3, company.getCustomerPhone());
            pstmt.setString(4, company.getContact());
            pstmt.setInt(5, company.getCustomerId());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(CompanyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void deletecompany( int companyId){
        //call get connection
        Connection conn = DBConnectionFactory.getConnection();
        //prepare statment
        try {
        String sql ="delete from customers"
                +" where customer_id =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,companyId);
            
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(CompanyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //select all company 
    public static ArrayList<Company> getAllCompany(){
       Connection conn =DBConnectionFactory.getConnection();
       ArrayList <Company> myList = new ArrayList();
        try {
            String sql=" select CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_PHONE, CUSTOMER_CONTACT, "
                      +" CUSTOMER_DISCOUNT "
                      +" from customers "
                      +" where CUSTOMER_TYPE_ID=1 ";
            PreparedStatement pstmt =conn.prepareStatement(sql);
            ResultSet rs =pstmt.executeQuery();
            while (rs.next()){
               int customerId=rs.getInt("CUSTOMER_ID");
               String customerName = rs.getString("CUSTOMER_NAME");
               String coustomerAddress = rs .getString("CUSTOMER_ADDRESS");
               String customerPhone = rs.getString("CUSTOMER_PHONE");
               String customerContanct = rs.getString("CUSTOMER_CONTACT");
               int customerDiscount = rs.getInt("CUSTOMER_DISCOUNT");
               Company company = new Company (customerId, customerName, customerPhone, coustomerAddress, customerContanct, customerDiscount);
               myList.add(company);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompanyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myList;
    }
    public static Company getAllCompanyById(int customerId ){
       Connection conn =DBConnectionFactory.getConnection();
        Company company = null;
        try {
            String sql=" select CUSTOMER_ID, CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_PHONE, CUSTOMER_CONTACT, "
                      +" CUSTOMER_DISCOUNT "
                      +" from customers "
                      +" where CUSTOMER_TYPE_ID=1 "
                      +" and CUSTOMER_ID = ? ";
            PreparedStatement pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1, customerId);
            ResultSet rs =pstmt.executeQuery();
            while (rs.next()){
               String customerName = rs.getString("CUSTOMER_NAME");
               String coustomerAddress = rs .getString("CUSTOMER_ADDRESS");
               String customerPhone = rs.getString("CUSTOMER_PHONE");
               String customerContanct = rs.getString("CUSTOMER_CONTACT");
               int customerDiscount = rs.getInt("CUSTOMER_DISCOUNT");
                company = new Company (customerId, customerName, customerPhone, coustomerAddress, customerContanct, customerDiscount);    
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompanyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
       return company;
    }
    
    public static void main(String[] args) {
        //Company cc = new Company(41,"abdah", "01060225247", "october", "hh",10);
              //updatecompany(cc);
              
              deletecompany(41);
    }
 
}
