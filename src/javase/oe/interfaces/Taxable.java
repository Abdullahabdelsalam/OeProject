/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javase.oe.interfaces;

/**
 *
 * @author Abdullah
 */
public interface Taxable {
    public abstract double getTax(double amount);
//    public static final double TAX_PCT = 10;
    public static final double TAX_PCT = TaxableHandler.getTaxPct("TAX_PCT");
}
