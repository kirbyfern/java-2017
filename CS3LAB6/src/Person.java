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

public class Person {
    // Declarations and Initializations
    Scanner in = new Scanner(System.in);
    
    protected String fullName;
    protected int age;
    protected int SSN;
    
    // Default Constructor
    public Person()
    {
        
    }
    
    // Explicit Constructor
    public Person(String fName, int a, int ssn)
    {
        this.fullName = fName;
        this.age = a;
        this.SSN = ssn;
    }
    
    // Accessors
    public String getName()
    {
        return fullName;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public int getSSN()
    {
        return SSN;
    }
    
    // Mutators
    public void setFullName()
    {
        String n;
        // Prompt User Information Details
        System.out.println("\nPlease enter full name: ");
        n = in.nextLine();
        
        fullName = n;
    }
    
    public void setAge()
    {
        int a;
        // Prompt User for age
        System.out.println("\nPlease enter age: ");
        a = in.nextInt();
        while(0.0 > a)
        {
            System.out.println("Please enter age: ");
            a = in.nextInt();
        }
        
        age = a;
    }
    
    public void setSSN()
    {
        int s;
        // Prompt User for ssn
        System.out.println("Please enter social security number: ");
        s = in.nextInt();
        while(0.0 > s)
        {
            System.out.println("Please enter social security number: ");
            s = in.nextInt();
        }
        SSN = s;
    }
}
