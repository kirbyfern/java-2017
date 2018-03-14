/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 */

/**
 *
 * @author Kirby James Fernandez
 * @description This program calculates Joe's stocks paid before and after he sold it. Shows the amount of loss or profit
 * @professor Esmaail Nikjeh
 * @class CS3
 */
import java.text.DecimalFormat;

public class Stocks 
{
    public static void main(String[] Args)
    {
        // Declaration
        // Output in two decimal places
        int stocks;
        double stockPrice, stockSold, commission;
        
        // Initialization
        stocks = 1000;
        stockPrice = 32.87;
        stockSold = 33.92;
        commission = 0.02;
        
        print(stocks, stockPrice, stockSold, commission);
        
    } // main
    
    /*
    LEGEND:
    s = stocks
    sp = stockPrice
    ss = stockSold
    c = commission
    */
    
    public static void print(int stocks, double stockPrice, double stockSold, double commission)
    {
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        System.out.println("----------------------------------------------------------");
        System.out.println("Joe paid for the stock alone: " + twoDigits.format(stock(stocks, stockPrice)));
        System.out.println("The amount of the commission: " + twoDigits.format(comms(stocks, stockPrice, commission)));
        System.out.println("The total amount paid: " + twoDigits.format(total1(stocks, stockPrice, commission)));
        System.out.println("----------------------------------------------------------");
        System.out.println("Joe sold the stock for: " + twoDigits.format(sold(stocks, stockSold)));
        System.out.println("Joe paid his broker for: " + twoDigits.format(commsBroker(stocks, stockSold, commission)));
        System.out.println("The total amount paid: " + twoDigits.format(total2(stocks, stockSold, commission)));
        System.out.println("----------------------------------------------------------");
        System.out.println("The total amount of profit: " + twoDigits.format(profitSold(stocks, stockPrice, stockSold, commission)));
        System.out.println("Joe lost an amount of: " + twoDigits.format(profitLoss(stocks, stockPrice, stockSold, commission)));
        
    }
    
    // 1.)paid for stock
    public static double stock(int s, double sp)
    {
        double total = s * sp;
        return total;
    }
    // 2.)amount of commission
    public static double comms(int s, double sp, double c)
    {
        double stock = s * sp;
        return stock * c;
    }
    // total amount paid 1
    public static double total1(int s, double sp, double c)
    {        
        double stocks = s * sp;
        double commission = stocks * c;
        double totalAmount = stocks + commission;
        
        return totalAmount;
    }
    // 3.)amount of stocks being sold
    public static double sold(int s, double ss)
    {
        return s * ss;
    }
    // 4.)amount of commision paid to the broker
    public static double commsBroker(int s, double ss, double c)
    {
        double stock = s * ss;
        return stock * c;
    }
    // total amount paid 2
    public static double total2(int s, double ss, double c)
    {        
        double stocks = s * ss;
        double commission = stocks * c;
        double totalAmount = stocks - commission;
        
        return totalAmount;
    }
    // 5.)amount of profit that joe made after selling his stocks and payed two percent commission
    public static double profitSold(int s, double sp, double ss, double c)
    {
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        double stock1 = s * sp;
        double stock1Comms = stock1 * c;
        double stockBought = stock1 + stock1Comms;
        double stock2 = s * ss;
        double stock2Comms = stock2 * c;
        double stockSold = stock2 - stock2Comms;
        double total = stockSold - stockBought;
    
        return total;
    }
    // 6.)display the loss and profit of joe
    public static double profitLoss(int s, double sp, double ss, double c)
    {
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        double stock1 = s * sp;
        double stock1Comms = stock1 * c;
        double stockBought = stock1 + stock1Comms;
        double stock2 = s * ss;
        double stock2Comms = stock2 * c;
        double stockSold = stock2 - stock2Comms;
        double total = stockSold - stockBought;
        
        return total;
    } // main
    
} // class
