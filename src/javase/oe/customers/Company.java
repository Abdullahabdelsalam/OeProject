/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.oe.customers;

/**
 *
 * @author Abdullah
 */
public class Company extends Customer {
 private String contact;
 private int discount;

    public Company( int customerId, String customerName, String customerPhone, String customerAddress,String contact, int discount) {
        super(customerId, customerName, customerPhone, customerAddress);
        this.contact = contact;
        this.discount = discount;
        
    }

    public Company(String customerName, String customerPhone, String customerAddress ,String contact) {
        super(customerName, customerPhone, customerAddress);
        this.contact = contact;
    }

    public Company(String contact, int discount) {
        this.contact = contact;
        this.discount = discount;
    }
    
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }


 
    
}
