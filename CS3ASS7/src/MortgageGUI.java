/**
 *
 * @author Kirby James Fernandez
 * @professor E. Nikjeh
 * @date October 14, 2017
 * @description This Program was created using Java's GUI features using JFrame and JTextField with two JLabels.
 * @purpose This program converts Fahrenheit Degree to Celsius Degree using the formula c = (5/9.0)(F-32.0)
 * @lab Week 7 Assignment 1
 * @class CS3 Programming in Java
 */

//import needed packages
import java.awt.*;
import javax.swing.*;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;import java.text.*;
public class MortgageGUI
{
    public static void main(String[] args)
    {
        // declaration statements
        int  length=30; // 30 year mortgage
        double balance =200000.00;  // amount borrowed
        double rate=5.75;
        double monthly_payment = 0.00;
        double monthly_principal = 0.00;
        double monthly_interest = 0.00;
        
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        double y_rate = (rate /100/12);
        double monthly_payments = balance * ( y_rate / (1 - Math.pow((1+y_rate), -1 * (length*12) ) ));
        y_rate = (rate/100)/12;
        
        System.out.println("\t\tMortgage Payment Formula");
        System.out.println("\t\tBalance own is $200,000");
        System.out.println("\t\tYearly interest rate is 5.75%");
        System.out.println("\t\tThe length of loan is 30 years\n");
        
        // start of loop to calculate interest paid and balance owe
        // print statement as balance increment,as interest increment
        for (int i =1; i <= length * 12; i++) 
        { 
            // months of payment being decrimented start counter
            monthly_interest = (balance*y_rate);
            balance = (balance - monthly_principal);
            monthly_principal  = (monthly_payment - monthly_interest);
            System.out.println(currency.format(balance) + "Balance is $");
            System.out.println("Interest paid is $" + currency.format(monthly_interest));
           try {Thread.sleep(10);} 
           catch (InterruptedException e){}
        }
    }
}