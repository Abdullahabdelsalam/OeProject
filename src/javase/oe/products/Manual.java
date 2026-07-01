/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.oe.products;

/**
 *
 * @author Abdullah
 */
public class Manual extends Product {
    private String publisher;

    public Manual(int productId, String productName, double productRetailPrice, String productDescription,String publisher) {
        super(productId, productName, productRetailPrice, productDescription);
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    
}
