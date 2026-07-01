/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.oe.products;

import javase.oe.interfaces.Taxable;

/**
 *
 * @author Abdullah
 */
public class Hardware extends Product implements Taxable{
    private int warrantyPeriod;

    public Hardware( int productId, String productName, double productRetailPrice, String productDescription,int warrantyPeriod) {
        super(productId, productName, productRetailPrice, productDescription);
        this.warrantyPeriod = warrantyPeriod;
    }
   public Hardware( String productName, double productRetailPrice, String productDescription,int warrantyPeriod) {
        super(productName, productRetailPrice, productDescription);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public double getTax(double amount) {
        return amount * Taxable.TAX_PCT / 100.0;
    }
    
    
}
