/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author  Kirby James Fernandez
 * @description Creates an Amortization Table and simply prints out from the console
 */
import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;

public class Amortization 
{
    public static final int MAX = 10;
    public static void main (String[] Args)
    {
        // Declarations and Initializations
        Scanner in = new Scanner(System.in);
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        
        String fullName;
        double monthlyPayment, interestPaid = 0, balanceLeft = 0, interestRate, loanAmount;
        int term;
        
        // Promput User Information and Amortization Details
        System.out.print("Please enter full name: ");
        fullName = in.nextLine();
        System.out.print("Enter principal amount paid: ");
        loanAmount = in.nextDouble();
        System.out.print("Enter rate: ");
        interestRate = in.nextDouble();
        System.out.print("Enter number of years to pay: ");
        term = in.nextInt();
        
        // Print details inputted by the user
        String s = fullName;
        System.out.printf("\nLoan payment information for: %s", s);
        System.out.printf("\nPrincipal payment paid: %.2f", loanAmount);
        System.out.printf("\nInterest rate to be paid: %.2f ", interestRate);
        System.out.printf("\nNumber of years to pay: %d ", term);
        
        // Calculate
        interestRate = (interestRate / 12) / 100;
        term = term * 12;
        monthlyPayment = loanAmount * interestRate / (1.0 - Math.pow(interestRate + 1, -term));
        
        // Amortization Loop
        for (int x = 1; x < MAX; x++) {
            interestPaid = loanAmount * interestRate;
            loanAmount = monthlyPayment - interestPaid; // princPaid
            balanceLeft -= loanAmount; // princ
            
            System.out.print("\n\nDay " + x + ":");
            System.out.println("\nInterest Paid: " + twoDigits.format(interestPaid));
            System.out.println("Loan Amount: " + twoDigits.format(loanAmount));
            System.out.println("Balance Left: " + twoDigits.format(balanceLeft));
        }
          
                 
    } // main
} // class
