/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruh
 */
public class Driver {
    public static void main(String[] Args)
    {       
        // instantiate a new Mortgage class called E1
        Mortgage E1 = new Mortgage();
        
        // Call the functions to the Mortgage class name E1
        E1.setLoan();
        E1.setRate();
        E1.setTerm();
        E1.printResult();
    }
}
