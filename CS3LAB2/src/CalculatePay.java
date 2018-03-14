/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kirby_fernandez
 */
import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;

public class CalculatePay 
{
    public static final int MAX_DAYS = 30;
    public static void main (String[] Args)
    {
        // Declarations
        Scanner in = new Scanner(System.in);
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        double salary, 
            totalPay = 0.0, 
            penny = 1.0;
        int numDays;
        
        // Prompt the user for days
        System.out.println("Please enter number of days you have worked: ");
        // Read prompt
         numDays = in.nextInt();   
        
        while (numDays < 1) {
            // Outputs a warning message
            System.out.println("Please enter a number greater than 1!");
            // Prompt the user for days
            System.out.println("Please enter number of days you have worked: ");
            // Read prompt
            numDays = in.nextInt();         
        }
        
         			
 	System.out.println("Day        Amount(Dollars)");
 	System.out.println("==========================");
        
        int count = 0;
        // iterate from 1 up to the number of days being inputed and incremented by 1
        for(int i = 1; i <= numDays; i++) {
            count++;
            if (count > 1) {
                penny *= 2;
                salary = penny/100;
                System.out.println(count + " " + twoDigits.format(salary));
            }
            else {
                salary = penny/100;
                System.out.println(count + " " + twoDigits.format(salary));
            }
            totalPay += salary;
        }
        System.out.println("The total pay is: " + totalPay);
    }
}
 