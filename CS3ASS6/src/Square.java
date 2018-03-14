/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kirby James Fernandez
 */
public class Square 
{   
    protected double length, width, surface;
    //setting up the constructor
    public Square (double lngth, double wdth) {
        length = lngth;
        width = wdth;
    }
    
    //setters
    public void setHeight(double lng){
        length = lng ;
    }
    
    public void setWidth(double wdt){
        width=wdt;
    }

    //getters
    public double getHeight(){
        return length;
    }
    
    public double getWidth(){
        return width;
    }

    public double getSurfaceArea(){
        return surface = length *width;
    }

    public String getDisplay()
    { 
        //if else statement to display or not display depending on the Area.
        //since either the area or the permieter is 0 or lower the rectangle can simply not exist
        if (getSurfaceArea()>0)
        {
            return String.format ("The area of one of the cube's sides is " + getSurfaceArea());
        }
        else {
            return String.format ("This cube can not exist.");
        }
    }   
}
