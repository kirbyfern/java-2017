/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 * @author Kirby James Fernandez
 * 12/9/17
 */
import java.util.Scanner;

public class DemoSquare {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        // intializing the variables
        double height, width, depth;
        // prompt user for data
        System.out.println ("Please enter in the cube's height: ");
        
        height = in.nextDouble();
        
        System.out.println ("Please enter in the cube's width: ");
        
        width = in.nextDouble();
        
        System.out.println ("Please enther the the depth of the cube: "); 
        
        depth = in.nextDouble();
        
        // sending user data to object
        Square sq = new Square (height, width);
        Cube cube = new Cube (height, width, depth);
        //displaying from object
        System.out.println (sq.getDisplay());
        System.out.println (cube.getDisplay()); 
          
    }

}
