/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruh
 */

import java.text.DecimalFormat;

public class Rectangle {
    private double width;
    private double length;
    
    /*
    LEGEND:
    ORDER OF DECLARATIONS:
    1. Default Constructor
    2. Public Constructor
    3. Accessors
    4. Mutators
    */
    
    // Default Constructor
    public Rectangle()
    {
        
    }
    
    // Explicit Constructor
    public Rectangle(double interimL, double interimW)
    {
        width = interimL;
        length = interimW;
    }
    
    public double getWidth()
    {
        return width;
    }
    
    public double getLength()
    {
     return length;   
    }
    
    public void setWidth(double interimW)
    {
        width = interimW;
        
    }
    
    public void setLength(double interimL)
    {
        width = interimL;
        
    }
    
    public double getArea(double w, double l)
    {
        return w * l;
    }
    
    public double getPerim(double w, double l)
    {
        return (2.00 * (w + l));
    }
    
    public void print(double ar, double pr)
    {
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        System.out.println("Area:" + twoDigits.format(ar));
        System.out.println("Perimeter:" + twoDigits.format(pr));
    }
}
