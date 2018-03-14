/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kirby James Fernandez
 */
public class Stocks 
{
    public static void main (String[] Args) 
    {
        int stocks;
        double stockPrice;
        double commission;
        
        stocks = 2000;
        stockPrice = 19.63;
        commission = 0.02;
      
        System.out.println("David paid for the stock alone: " + stock(stocks, stockPrice));
        System.out.println("The amount of the commission: " + comms(stocks, stockPrice, commission));
        System.out.println("The total amount paid: " + total(stocks, stockPrice, commission));
    } // main
    
    // paid for stock
    public static double stock(int s, double sp)
    {
        return s * sp;
    }
    // amount of commission
    public static double comms(int s, double sp, double c)
    {
        double stock = s * sp;
        return stock * c;
    }
    // total amount paid
    public static double total(int s, double sp, double c)
    {        
        double stocks = s * sp;
        double commission = stocks * c;
        double totalAmount = stocks + commission;
        
        return totalAmount;
    } // main
} // class
