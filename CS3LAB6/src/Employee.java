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

public class Employee extends Person {
    // Declarations and Initializations
    Scanner in = new Scanner(System.in);
    
    private double numHours;
    private double payRate;
    private double numDays;
    
    public double weeklyPay;
    public double numDaysWork;
    
    // Default
    public Employee()
    {
        super();
    }
    
    // explicit constructor
    public Employee(double nH, double pR, String fName, int a, int ssn)
    {
        super(fName, a, ssn);
        numHours = nH;
    //    numDays = nD;
        payRate = pR;
    }
    
    // Accessors
    public double getNumHours()
    {
        return numHours;
    }
    
    public double getPayRate()
    {
        return payRate;
    }
    
    public double getNumDays()
    {
        return numDays;
    }
    
    // Mutators
    public void setNumDays()
    {
        double nD;
        // Prompt User for number of days worked
        System.out.println("Please enter number of days worked: ");
        nD = in.nextDouble();
        while(0.0 > nD)
        {
            System.out.println("Please enter number of days worked: ");
            nD = in.nextDouble();
        }
        numDays = nD;
    }
   
    public void setNumHours()
    {
        double nH;
        // Prompt User for number of hours worked
        System.out.println("Please enter number of hours worked: ");
        nH = in.nextDouble();
        while(0.0 > nH)
        {
            System.out.println("Please enter number of hours worked: ");
            nH = in.nextDouble();
        }
        numHours = nH;
    }
    
    public void setPayRate()
    {
        double pR;
        // Prompt User for pay rate
        System.out.println("Please enter pay rate: ");
        pR = in.nextDouble();
        while(0.0 > pR)
        {
            System.out.println("Please enter pay rate: ");
            pR = in.nextDouble();
        }
        payRate = pR;
    }
    
    public void weeklyPay()
    {
        double nH;
        double nD;
        double pR; 

        nH = numHours;
        nD = numDays;
        pR = payRate;
        
        weeklyPay = (nH * pR) * nD;
        System.out.println(weeklyPay);
    }
    
    // toString function
    @Override
    public String toString()
    {
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        String s;
        s = super.toString();
        
        s += "\nWeekly Pay: " + twoDigits.format(weeklyPay);
        return s;
    }
   
    // will print the toString member function
    public void printResult()
    {
     System.out.println(this);
    }
    
}
