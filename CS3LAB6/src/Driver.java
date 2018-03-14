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

public class Driver {
    public static void main(String[] Args)
    {
        // Declarations and Initializations
        Scanner in = new Scanner(System.in);
        int numEmp = 0;
        
        System.out.println("Enter how many employee/s: ");
        numEmp = in.nextInt();
        if(numEmp < 0)
        {
            System.out.println("Invalid, Enter again: ");
            numEmp = in.nextInt(); 
        }
        
        Employee emp[] = new Employee[numEmp];

        for(int i = 0; i < numEmp; i++)
        {
            emp[i] = new Employee();
            emp[i].setFullName();
            emp[i].setAge();
            emp[i].setSSN();
            emp[i].setNumDays();
            emp[i].setNumHours();
            emp[i].setPayRate();
            emp[i].weeklyPay();
            emp[i].printResult();
        }
    }
}
