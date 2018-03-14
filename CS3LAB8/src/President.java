/**
 *
 * @author Kirby James Fernandez
 * @professor E. Nikjeh
 * @date October 14, 2017
 * @description This Program was created using Java's GUI features using JFrame and JTextField with two JLabels.
 * @purpose This program shows the name of different Presidents ina form of button and being applied using border layout
 * @lab Week 9 Lab Assignment 1
 * @class CS3 Programming in Java
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class President extends JFrame implements ActionListener
{
    // Change the button's color
    Button colorButton = new Button("Change the color");
    
    // set Buttons for each President
    JButton lincoln = new JButton("Abraham Lincoln");
    JButton regan = new JButton("Ronald Regan");
    JButton carter = new JButton("Jimmy Carter");
    JButton bush = new JButton("George Bush");
    JButton clinton = new JButton("Bill Clinton");
    
    public President()
    {
        // set GUI 
        super("List of Presidents");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());
        
        // add components
        con.add(lincoln, BorderLayout.NORTH);
        con.add(regan, BorderLayout.SOUTH);
        con.add(carter, BorderLayout.EAST);
        con.add(bush, BorderLayout.WEST);
        con.add(clinton, BorderLayout.CENTER);
        
    }
    
    public static void main(String[] args)
    {
        President p = new President();
        p.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        Object t = e.getSource();
        if(t.equals(lincoln)){
            
        }
        else if(t.equals(regan)){
            
        }
        else if(t.equals(carter)){
            
        }
        else if(t.equals(bush)){
            
        }
        else if(t.equals(clinton)){
            
        }
        
    }
}
