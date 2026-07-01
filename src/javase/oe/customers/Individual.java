/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.oe.customers;

/**
 *
 * @author Abdullah
 */
public class Individual extends Customer{
  private String licNumber;  

    public Individual( int customerId, String customerName, String customerPhone, String customerAddress,String licNumber) {
        super(customerId, customerName, customerPhone, customerAddress);
        this.licNumber = licNumber;
    }

    public String getLicNumber() {
        return licNumber;
    }

    public void setLicNumber(String licNumber) {
        this.licNumber = licNumber;
    }

    @Override
    public String toString() {
        return "Individual{" + "licNumber=" + licNumber + '}';
    }

    public Individual(String licNumber, String customerName, String customerPhone, String customerAddress) {
        super(customerName, customerPhone, customerAddress);
        this.licNumber = licNumber;
    }
    
  
}
