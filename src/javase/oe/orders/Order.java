/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.oe.orders;

import java.util.ArrayList;
import java.util.Date;
import javase.oe.customers.Customer;
import javase.oe.products.Product;

/**
 *
 * @author Abdullah
 */
public class Order {
  private int orderId;
  private Customer customer; // Link to 1 customer
  private Date orderDate = new Date() ; // today date
  private double orderTotal;
  private ArrayList<OrderItem> itemsList = new ArrayList(); // link to many order items 

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public ArrayList<OrderItem> getItemsList() {
        return itemsList;
    }

    
    
    public double getOrderTotal() {
        double sum = 0;
        for(OrderItem item : itemsList){
            sum = sum + item.calcItemTotal();
        }
        
        orderTotal = sum;
        return orderTotal;
    }

  
    public void previewOrder(){
     
        System.out.println("This order no .  -------------- " + orderId + " ----------------------");
        System.out.println("Customer NAme = " + customer.getCustomerName());
        System.out.println("Order Date = " + orderDate);
        System.out.println("----------------- Order Items ------------------");
        for (OrderItem item : itemsList) {
        System.out.print(" Line Serial No : " + item.getLineNbr());
            System.out.print(", Product name : " + item.getProduct().getProductName());
            System.out.print(", Quantity : " + item.getQuantity());
            System.out.print(", Unit price : " + item.calcUnitPrice());
            System.out.print(", Item tax : " + item.calcItemTax());
            System.out.print(", Item Total : " + item.calcItemTotal());
            System.out.println("\n-------------------");
        }
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        System.out.println("Order Total = "+this.getOrderTotal());
    }
    
  
    
    public void addProductToCart(Product newProduct){
           addProductToCart(newProduct, 1);
    }



    
    
     public void addProductToCart(Product newProduct, int quantity){
                boolean isFound = false;
            for(OrderItem item : itemsList){
                if(newProduct.getProductId() == item.getProduct().getProductId()){
                   // new product is found in the list : then increasq quantity
                      isFound = true;
                      int currentQty =  item.getQuantity();
                      item.setQuantity(currentQty + quantity);
                }
            }
                
        
        // i want to add newProduct to the itemsList 
        // add item to arraylist - we use add method
        if(isFound == false){ // item was not found in the list 
            OrderItem item = new OrderItem(newProduct, 1);
            itemsList.add(item);
        }
    }

    public void removeProductQuantity(int productId){removeProductQuantity(productId,1);}

    public void removeProductQuantity(int productId, int quantityToRemove) {
        for (OrderItem item : itemsList) {
            if (item.getProduct().getProductId() == productId) {
                int currentQty = item.getQuantity();

                if (quantityToRemove <= 0) {
                    System.out.println("Quantity to remove must be greater than 0.");
                    return;
                }

                if (quantityToRemove < currentQty) {
                    item.setQuantity(currentQty - quantityToRemove);
                    System.out.println("Removed " + quantityToRemove + " from product quantity.");
                } else if (quantityToRemove >= currentQty) {
                    itemsList.remove(item);
                    System.out.println("Removed product completely (quantity became 0).");
                }
                return;
            }
        }

        System.out.println("Product not found in cart.");
    }
    
  
}
