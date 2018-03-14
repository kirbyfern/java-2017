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

public class Driver {
    public static void main(String[] Args)
    {
        // Declarations and Initializations
        Scanner in = new Scanner(System.in);
        int numItems = 0;
        
        System.out.println("Enter how many items: ");
        numItems = in.nextInt();
        if(numItems < 0)
        {
            System.out.println("Invalid, Enter again: ");
            numItems = in.nextInt(); 
        }
        
        Inv invoice[] = new Inv[numItems];

        for(int i = 0; i < numItems; i++)
        {
            invoice[i] = new Inv();
            invoice[i].setName();
            invoice[i].setQuantity();
            invoice[i].setPrice();
            invoice[i].setTotalCost();
            invoice[i].printResult();
        }
    }
}
