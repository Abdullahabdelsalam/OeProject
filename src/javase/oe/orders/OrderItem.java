/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.oe.orders;

import javase.oe.products.Hardware;
import javase.oe.products.Product;

/**
 *
 * @author Abdullah
 */
public class OrderItem {
    private int lineNbr;
    private static int lineNbrStatic = 1;
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        lineNbr = lineNbrStatic;
        lineNbrStatic++;
        this.product = product;
        this.quantity = quantity;
    }

    public int getLineNbr() {
        return lineNbr;
    }

    public void setLineNbr(int lineNbr) {
        this.lineNbr = lineNbr;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    // Extra Methods
    
    public double calcUnitPrice(){
        return product.getProductRetailPrice();
    }
    
    public double calcItemTax(){
        if ( product instanceof Hardware ){
          return ((Hardware)product).getTax( calcUnitPrice() * quantity); // cassting : polymorphism
        }else{
            return 0;
        }
    }
    
    public double calcItemTotal(){
        return calcUnitPrice() * quantity + calcItemTax();
    }
    
}
