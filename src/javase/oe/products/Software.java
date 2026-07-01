/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.oe.products;

/**
 *
 * @author Abdullah
 */
public class Software extends Product{
 private String license;   

    public Software( int productId, String productName, double productRetailPrice, String productDescription,String license) {
        super(productId, productName, productRetailPrice, productDescription);
        this.license = license;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
 
}
