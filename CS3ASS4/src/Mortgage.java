/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruh
 */

import java.util.Scanner;
import java.lang.Math;
import java.io.*;
import java.text.DecimalFormat;

public class Mortgage {
    // Declarations and Initializations
    Scanner in = new Scanner(System.in);
    
    // can only be access in this class using accessors
    private double loan;
    private double rate;
    private double term;
    
    // available to all
    public String fullName;
    
    // Default Constructor
    public Mortgage()
    {
        
    }
    // Explicit Constructor
    public Mortgage(double l, double r, double t)
    {
        this.loan = l;
        this.rate = r;
        this.term = t;
    }
    // Accessors
    public double getLoan()
    {
        return loan;
    }
    
    public double getRate()
    {
        return rate;
    }
    
    public double getTerm()
    {
        return term;
    }
    // Mutators
    public void setLoan()
    {
        double tempL = 0;
  
        // Promput User Information and Amortization Details
        System.out.print("Please enter full name: ");
        fullName = in.nextLine();
        
        System.out.print("Enter loan amount: ");
        tempL = in.nextDouble();
        while(tempL <= 0 || tempL < 100000 || tempL > 2000000)
        {
            System.out.print("Enter loan amount: ");
            tempL = in.nextDouble();
        }
        loan = tempL;        
    }
    
    // Set Rate
    public void setRate()
    {
        double tempR = 0;
        
        System.out.print("Enter rate: ");
        tempR = in.nextDouble();
        while(tempR <= 0)
        {
            System.out.print("Enter rate: ");
            tempR = in.nextDouble();
        }
        rate = tempR;
    }
    
    // Set Term
    public void setTerm()
    {
        double tempT = 0;
        
        System.out.print("Enter number of years to pay: ");
        tempT = in.nextInt();
        while(tempT <= 0)
        {
            System.out.print("Enter rate: ");
            tempT = in.nextDouble();
        }       
        term = tempT;
    }
    // Convert Monthly Rate to number of months
    public double monthlyRate()
    {
        return (rate/100.0)/12;
    }
    // Calculates the monthly payment
    public double monthlyPayment()
    {
        return (loan * monthlyRate())/ (1.0 - Math.pow(monthlyRate() + 1, (-term * 12.0)));
    }
    
    public String toString()
    {
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        return "loan is: " + twoDigits.format(loan) + ", rate is: " + twoDigits.format(rate) + ", term is: " + twoDigits.format(term) +", monthly payment is: "
                + twoDigits.format(monthlyPayment());
    }
   
    // will print the toString member function
    public void printResult()
    {
     System.out.println(this);
    }
}
