/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kirby James Fernandez
 * @professor Professor Nikjeh
 * @class CS3 (Computer Programming in Java)
 * @description: This program will display an invoice of several items.
 * @date 
 */

import java.util.Scanner;
import java.lang.Math;
import java.io.*;
import java.text.DecimalFormat;

public class Inv
{
    // Declarations and Initializations
    Scanner in = new Scanner(System.in);
    
    // can only be access in this class using accessors
    private String name;
    private double quantity;
    private double price;
    private double totalCost;
    
    // Default Constructor
    public Inv()
    {
        
    }
    
    // Explicit Constructor
    /*
        n = name
        q = quantity
        p = price
        tc = totat cost
    */
    public Inv(String n, double q, double p, double tc)
    {
        this.name = n;
        this.quantity = q;
        this.price = p;
        this.totalCost = tc;
    }

    Inv(int numItems) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Accessors
    public String getName()
    {
        return name;
    }
    
    public double getQuantity()
    {
        return quantity;
    }
    
    public double price()
    {
        return price;
    }
    
    public double getTotalCost()
    {
        return totalCost;
    }
    
    // Mutators
    public void setName()
    {
        String n;
        // Prompt User Information Details
        System.out.println("\nPlease enter full name: ");
        n = in.nextLine();
        
        name = n;
    }
    
    /**
     *
     * @param q
     */
    public void setQuantity()
    {
        double q;
        // Prompt User for quantity
        System.out.println("\nPlease enter quantity: ");
        q = in.nextDouble();
        while(0.0 > q)
        {
            System.out.println("Please enter quantity: ");
            q = in.nextDouble();
        }
        
        quantity = q;
    }
    
    public void setPrice()
    {
        double p;
        // Prompt User for price
        System.out.println("Please enter price: ");
        p = in.nextDouble();
        while(0.0 > p)
        {
            System.out.println("Please enter price: ");
            p = in.nextDouble();
        }
        price = p;
    }
    
    public void setTotalCost()
    {
        double tc;
        // Prompt User for total cost
        totalCost = price * quantity;
        System.out.println("Total cost is: " + totalCost);
    }
    
    // To get the invoice
    public double getInvoice()
    {
        double calcTotal;
        calcTotal = quantity * price;
        return calcTotal;
    }
    
    // To String method
    @Override
    public String toString()
    {
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        return "name is: " + name + ", quantity is: " + twoDigits.format(quantity) + ", price is: " + twoDigits.format(price) +", total cost is: "
                + twoDigits.format(totalCost);
    }
   
    // will print the toString member function
    public void printResult()
    {
     System.out.println(this);
    }
}
