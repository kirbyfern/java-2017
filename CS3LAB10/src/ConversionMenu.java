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
 * @description This Program was created using Java GUI features using JFrame and JToolBar, and JButton.
 * @purpose This program serves as a Mortgage calculator that prompts the user in Graphical User Interface then get
 *          a US Dollar from User(JTextField) and convert it to the proper selection from the Menu.
 * @lab Week 10 Lab Assignment 1
 * @class CS3 Programming in Java
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConversionMenu extends JFrame implements ActionListener{

    // Prompt
    JLabel usd = new JLabel("Enter US Dollars: ");
    JTextField usdText = new JTextField(5);
    
    JLabel result = new JLabel("");
    
    // Menu Bars
    JMenuBar jmb = new JMenuBar();
    JMenuItem exit = new JMenuItem("Exit");
    JMenu convert = new JMenu("Convert");
    JMenuItem mex = new JMenuItem("Mexico Peso");
    JMenuItem eur = new JMenuItem("Europe Euro");
    JMenuItem jpn = new JMenuItem("Japan Yen");
    
    double[] Rates = {19.20,.86,114.08};
    
    public ConversionMenu(){
        super("Money Converter");
        setSize(350, 250);
        Container con = this.getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con.setLayout(new FlowLayout());
        setJMenuBar(jmb);
        
        jmb.add(convert);
        convert.add(mex);
        convert.add(eur);
        convert.add(jpn);
        jmb.add(exit);
        
        con.add(usd);
        con.add(usdText);
        con.add(result);
        
        exit.addActionListener(this);
        mex.addActionListener(this);
        eur.addActionListener(this);
        jpn.addActionListener(this);
        
    }
    public static void main(String[] args) {
        ConversionMenu CM = new ConversionMenu();
        CM.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        Object c = e.getSource();
        if(c.equals(exit)){
            this.dispose();
        }
        else if(c.equals(mex)){
            double money = Math.round((Rates[0] *
                                       Double.parseDouble(usdText.getText()))*100)/100.0;
            result.setText("Rate is equivalent to " + money
                           + " Mexican Pesos");
        }
        else if(c.equals(eur)){
            double money = Math.round((Rates[1] *
                                       Double.parseDouble(usdText.getText()))*100)/100.0;
            result.setText("Rate is equivalent to  " + money 
                           + " European Euros");
        }
        else if(c.equals(jpn)){
            double money = Math.round((Rates[2] * 
                                       Double.parseDouble(usdText.getText()))*100)/100.0;
            result.setText("Rate is equivalent to  " + money 
                           + " Japanese Yen");
        }
    }
    
}
