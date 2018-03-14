/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kirby James Fernandez
 * @professor E. Nikjeh
 * @date December 2, 2017
 * @description This Program was created using Java principles
 * @purpose This program reads a file from a previous code output via istream.
 * @lab Week 14 Lab 1
 * @class CS3 Programming in Java
 */

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReadPhoneList extends JFrame
    implements ActionListener
{
    private JLabel title =
      new JLabel("Phone List");
    Font bigFont = new Font("Helvetica", Font.ITALIC, 20);
    private JButton read = new JButton("Read From File");
    private JTextField name = new JTextField(10);
    private JTextField phone = new JTextField(10);
    private JLabel nLabel = new JLabel("Name");
    private JLabel pLabel = new JLabel("Phone number");
    private Container con = getContentPane();
    DataOutputStream ostream;
    DataInputStream istream;

    public ReadPhoneList()
    {
        super("Read Phone List");
        try
        {
            ostream = new 
            DataOutputStream(new 
            FileOutputStream("phoneList.txt"));
        }
        catch(IOException e)
        {
            System.err.println("File not opened");
            System.exit(1);
        }
        setSize(150,250);
        con.setLayout(new FlowLayout());
        title.setFont(bigFont);
        con.add(title);
        con.add(read);
        con.add(nLabel);
        con.add(name);
        con.add(pLabel);
        con.add(phone);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    public void actionPerformed(ActionEvent e1)
    {
        try
        {
            name.setText(istream.readUTF());
            phone.setText(istream.readUTF());
            name.setText("");
            phone.setText("");
        }
        
        catch(IOException e2)
        {
            System.err.println("Error writing file");    
            System.exit(1);
        }
    }
  public static void main(String[] arguments)
  {
   ReadPhoneList RPL = new ReadPhoneList(); 
   RPL.setVisible(true);
  }

} 