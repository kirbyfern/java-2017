/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kirby James Fernandez
 * @professor Professor Nikjeh
 * @class CS3, Computer Programming in Java
 * @date 
 * @description This program calculates the area and perimeter through object oriented programming
 */

public class Driver {
    public static void main (String[] args)
    {
        double width = 3.2;
        double length = 2.1;
        double area;
        double perimeter;
        Rectangle r1 = new Rectangle();
        r1.setWidth(width);
        r1.setLength(length);
        area = r1.getArea(width, length);
        perimeter = r1.getPerim(width, length);
        r1.print(area, perimeter);
    }
}
