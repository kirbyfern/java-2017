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

public class TemperatureConversion {
    public static void main(String[] args) {
        // Declarations
        Scanner in = new Scanner(System.in);
        double fahrenheit = 0;
        double celsius = 0;

        // Prompt the user for input
        System.out.println("Please enter a degrees in Fahrenheit: ");
        
        // Read in 
        fahrenheit = in.nextDouble();
        
        // conversion
        celsius = (fahrenheit - 32)/1.8;
        
        // Output in two decimal places
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        
        // Output conversion
        System.out.println("Fahrenheit to Celsius is: " + twoDigits.format(celsius));
    }
}
