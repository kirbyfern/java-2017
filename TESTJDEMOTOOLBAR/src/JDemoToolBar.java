/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruh
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JDemoToolBar extends JFrame implements ActionListener {
    BorderLayout bord = new BorderLayout();
    JTextArea edit = new JTextArea(8,30);
    JScrollPane scroll = new JScrollPane(edit, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                                         ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    
    JPanel pane = new JPanel();
    ImageIcon image1 = new ImageIcon("dining.gif");
    ImageIcon image2 = new ImageIcon("mail.gif");
    ImageIcon image3 = new ImageIcon("phone.gif");
    JButton b1 = new JButton("Dining", image1);
    JButton b2 = new JButton("Mail", image2);
    JButton b3 = new JButton("Phone", image3);
    
    JToolBar bar = new JToolBar();
    
    public JDemoToolBar()
    {
        super("Event Handlers Toolbar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bar.add(b1);
        bar.add(b2);
        bar.add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        pane.setLayout(bord);
        pane.add(bar);
        pane.add(scroll);
        pane.add(bar, BorderLayout.NORTH);
        setContentPane(pane);
    }
    
    public static void main(String[] args)
    {
        JFrame tFrame = new JDemoToolBar();
        tFrame.setSize(500, 500);
        tFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
        if(source == b1)
        {
            edit.append("\nOur Event Choices are:\nwith cocktails, dinner, and party favors\n");
        }
        else if(source == b2)
        {
            edit.append("\nOur address is :\nEvent Handlers Incorporated\n8900 U.S. Hwy 14\n"+"Crystal Lake, IL 60014\n");
        }
        else if(source == b3)
        {
            edit.append("\nOur Telephone numbers are :\n1-80-1231-1424-325-325-235-23532\n");
        }
    }
}
