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
 * @purpose This program serves as a Mortgage calculator that prompts the user in Graphical User Interface and using exception handler.
 * @lab Week 14 Assignment 1
 * @class CS3 Programming in Java
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;


public class SequentialFile extends JFrame implements ActionListener{
    //Initialization
    String[] labelList = {"", "", ""};
    double[] termList = {0.0, 0.0, 0.0};
    double[] rateList = {0.0, 0.0, 0.0};
    
    JLabel principalLabel = new JLabel("Enter Loan Amount");
    JTextField principalText = new JTextField(5);
    
    JLabel rateLabel = new JLabel("Enter Rate %");
    JTextField rateText = new JTextField(5);
    
    JLabel termLabel = new JLabel("Enter Term In Years");
    JTextField termText = new JTextField(5);
    
    JLabel displayLabel = new JLabel("The monthly payments are: ");
    JTextArea resultText = new JTextArea(15,40);
    
    JMenuBar jmb = new JMenuBar();
    JMenuItem exit = new JMenuItem("Exit");
    JMenuItem reset = new JMenuItem("Reset");
    JMenuItem calculate = new JMenuItem("Calculate");
    
    JMenu terms = new JMenu("Term and Rates");
    JMenuItem t0;
    JMenuItem t1; 
    JMenuItem t2; 
    
    JScrollPane displayScroll = new JScrollPane(resultText, 
                                                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
                                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    public SequentialFile(){
        // set GUI
        super("Mortgages");
        setSize(520,500);
        Container con = this.getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con.setLayout(new FlowLayout());
        setJMenuBar(jmb);
        
        // fill file
        try
        {
            BufferedReader InFile = new BufferedReader(new FileReader("rates.txt"));
            String InputLine = null;
            int myCount = 0;
            while((InputLine = InFile.readLine()) != null)
            {
                StringTokenizer MyParse = new StringTokenizer(InputLine, ",");
                labelList[myCount] = MyParse.nextToken();
                termList[myCount] = Double.parseDouble(MyParse.nextToken());
                rateList[myCount] = Double.parseDouble(MyParse.nextToken());
                myCount++;
            }
            InFile.close();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error Reading File",
                        "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        t0 = new JMenuItem(labelList[0]);
        t1 = new JMenuItem(labelList[1]);
        t2 = new JMenuItem(labelList[2]);
        
        
        jmb.add(terms);
        terms.add(t0);
        terms.add(t1);
        terms.add(t2);
        jmb.add(calculate);
        jmb.add(reset);
        jmb.add(exit);
                
       
        con.add(principalLabel);
        con.add(principalText);
        con.add(termLabel);
        con.add(termText);
        con.add(rateLabel);
        con.add(rateText);
        con.add(displayLabel);
        con.add(displayScroll);
        
        
        resultText.setEditable(false);
        
        //Add action listeners
        calculate.addActionListener(this);
        exit.addActionListener(this);
        t0.addActionListener(this);
        t1.addActionListener(this);
        t2.addActionListener(this);
        reset.addActionListener(this);
    }
    public static void main(String[] args) {
        SequentialFile SF = new SequentialFile();
        SF.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        Object c = e.getSource();
        
        // menu bar interactions
        if(c.equals(exit)){
            this.dispose();
        }
        else if(c.equals(t0)){
            termText.setText(Double.toString(termList[0]));
            rateText.setText(Double.toString(rateList[0]));
        }
        else if(c.equals(t1)){
            termText.setText(Double.toString(termList[1]));
            rateText.setText(Double.toString(rateList[1]));
        }
        else if(c.equals(t2)){
            termText.setText(Double.toString(termList[2]));
            rateText.setText(Double.toString(rateList[2]));
        }
        else if(c.equals(reset)){
            principalText.setText("");
            termText.setText("");
            rateText.setText("");
            resultText.setText("");
        }
        
        // display the mortgage info
        else if(c.equals(calculate)){

            double term = Double.parseDouble(termText.getText()) * 12;
            double rate = Double.parseDouble(rateText.getText()) / 100 / 12;
            double principle = Double.parseDouble(principalText.getText());
            try {
                calc(term, rate, principle);
            } catch (Exception err) {
                //If there was an invalid input, show an error message with the info
                JOptionPane.showMessageDialog(null, err.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                
            }

        }
        
    }
    
    public void calc(double term, double rate, double principle)
    {
        
        // display info in the box
        resultText.setText("Term\tMonth Payment\tInterest Paid\tPrincipal"
                + " Paid\tLoan balance \n");
        double mpayment = (principle * rate)
                / (1 - Math.pow(rate + 1, -term));
        double balance = principle;
        for (int i = 0; i < term; i++) {
            double cpayment, interestPaid, principalPaid;
            interestPaid = rate * balance;
            cpayment = Math.min(mpayment, balance + interestPaid);

            principalPaid = cpayment - interestPaid;
            balance -= principalPaid;
            resultText.append(i + 1 + "\t$" + Math.round(cpayment * 100)
                    / 100.0 + "\t$" + Math.round(interestPaid * 100) / 100.0
                    + "\t$" + Math.round(principalPaid * 100) / 100.0
                    + "\t$" + Math.round(balance * 100) / 100.0 + "\n");
        }
    }
    
}
