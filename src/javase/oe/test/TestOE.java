/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javase.oe.test;

import javase.oe.customers.Company;
import javase.oe.orders.Order;
import javase.oe.products.Hardware;
import javase.oe.products.Software;

/**
 *
 * @author Abdullah
 */
public class TestOE {
    public static void main(String[] args) {
     
     // stock products 
         Software softwareOSWin10 = new Software(1, "OS Win 10",200, "OS Ms", "123-12312312");
         Hardware hardwarePrinterXerox = new Hardware(2, "Xerox Printer", 500, "Printers", 3);
         Hardware hardwareCanonScanner = new Hardware(3, "Cannon scanner", 400, "Scanners", 5);
      
      
      
      Company RayaCompany = new Company(101, "Raya", "01012312312", "Cairo", "ahmed omar", 10);
      
      // Create order 
      Order order1001 = new Order(1001, RayaCompany);
      // adding poducts to ther order ( to the cart ) 
      order1001.addProductToCart(hardwarePrinterXerox);
      order1001.addProductToCart(softwareOSWin10);
      order1001.addProductToCart(hardwareCanonScanner);
      order1001.addProductToCart(hardwarePrinterXerox);
      order1001.addProductToCart(hardwarePrinterXerox);
      order1001.addProductToCart(hardwarePrinterXerox, 4);
   // order1001.removeProductFromCart(hardwarePrinterXerox);  // remove 1 qty
   // order1001.removeProductFromCart(hardwarePrinterXerox, 3);  // remove 3 qty
      
      // preview order 
      order1001.previewOrder();
      
//      order1001.confirmOrder(order1001);
      
      
      
      
      
        
        
    }
}
