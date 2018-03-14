/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kirby James Fernandez
 * @professor E. Nikjeh
 * @date November 18, 2017
 * @description This Program was created using Java GUI features using JFrame and JToolBar, and JButton.
 * @purpose This program serves as a Mortgage calculate that prompts the user in Graphical User Interface.
 * @lab Week 10 Lab Assignment 1
 * @class CS3 Programming in Java
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConversionMenu extends JFrame implements ActionListener
{
    BorderLayout bord = new BorderLayout();
    JTextArea edit = new JTextArea(8,30);
    JScrollPane scroll = new JScrollPane(edit, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                                         ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    
    JMenuBar mb = new JMenuBar();
    
    JMenu conversion = new JMenu("Conversion");
    JMenu exit = new JMenu("Exit");
 
    public ConversionMenu()
    {
        // set GUI 
        super("CONVERSION MENU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());
        
        mb.add(conversion);
        mb.add(exit);
        setJMenuBar(mb);
        
        conversion.addActionListener(this);
        exit.addActionListener(this);
    }
    
    public static void main(String[] args)
    {
        ConversionMenu CM = new ConversionMenu();
        CM.setVisible(true);
    }
    
    public void ActionPerformed(Action Event)
    {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
