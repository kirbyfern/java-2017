/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kirby James Fernandez
 * @professor E. Nikjeh
 * @date October 14, 2017
 * @description This Program was created using Java GUI features using JFrame and JToolBar, and JButton.
 * @purpose This program serves as a Mortgage calculate that prompts the user in Graphical User Interface.
 * @lab Week 9 Lab Assignment 1
 * @class CS3 Programming in Java
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToolBarMajor extends JFrame implements ActionListener {
    BorderLayout bord = new BorderLayout();
    JTextArea edit = new JTextArea(8,30);
    JScrollPane scroll = new JScrollPane(edit, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                                         ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    
    JPanel pane = new JPanel();
    
    JButton major = new JButton("CHOOSE A MAJOR");

    // Button
    JButton major1 = new JButton("Computer Science");
    JButton major2 = new JButton("Business");
    JButton major3 = new JButton("Nursing");
    
    JToolBar bar = new JToolBar();
    
    public ToolBarMajor()
    {
        // set GUI 
        super("CHOOSE A MAJOR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());
        
        //bar.add(major);

        bar.add(major1);
        bar.add(major2);
        bar.add(major3);

        pane.setLayout(bord);
        pane.add(bar);
        pane.add(scroll);
        pane.add(bar, BorderLayout.NORTH);
        setContentPane(pane);
        
        major1.addActionListener(this);
        major2.addActionListener(this);
        major3.addActionListener(this);
    }
    
    public static void main(String[] args)
    {
        ToolBarMajor T = new ToolBarMajor();
        T.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event)
    {
         Object source = event.getSource();
        if(source == major)
        {
            edit.append("\nHere are at least 4 courses in Computer Science:\n"
                        + "\n* Computer Programming in C++"
                        + "\n* Introduction to Data Structures"
                        + "\n* Advanced Programming in C++"
                        + "\n* Advance Data Structures\n");
        }
        else if(source == major1)
        {
            edit.append("\nHere are at least 4 courses in Computer Science:\n"
                        + "\n* Computer Programming in C++"
                        + "\n* Introduction to Data Structures"
                        + "\n* Advanced Programming in C++"
                        + "\n* Advance Data Structures\n");          
        }
        else if(source == major2)
        {
            edit.append("\nHere are at least 4 courses in Business Administration:\n"
                        + "\n* Project Management"
                        + "\n* Entrepreneurship"
                        + "\n* Finance"
                        + "\n* Marketing\n");
        }
        else if(source == major3)
        {
             edit.append("\nHere are at least 4 courses in Nursing:\n"
                        + "\n* Pharmacology & Nursing Care"
                        + "\n* Introduction to Professional Nursing: Lecture Course"
                        + "\n* Introduction to Professional Nursing: Clinical Course"
                        + "\n* Intro to Prof. Nursing: Clin Assessment/Skills/Simulation\n");
        }
    }
}
