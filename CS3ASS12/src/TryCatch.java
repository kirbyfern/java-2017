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
 * @purpose This program serves as a Mortgage calculate that prompts the user in Graphical User Interface.
 * @lab Week 12 Assignment 1
 * @class CS3 Programming in Java
 */

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class TryCatch extends JFrame implements ActionListener{
    //Initialize all GUI elements
    String[] rates = {"7 year at 5.35%", "15 year at 5.5%", "30 year at 5.75%"};
    JLabel principalLabel = new JLabel("Enter Loan Amount");
    JTextField principal = new JTextField(5);
    JLabel rateLabel = new JLabel("Enter Rate %");
    JTextField rateBox = new JTextField(5);
    JLabel termLabel = new JLabel("Enter Term In Years");
    JTextField termBox = new JTextField(5);
    JLabel display1 = new JLabel("The monthly payments are: ");
    JTextArea result = new JTextArea(15,40);
    JMenuBar jmb = new JMenuBar();
    JMenuItem exit = new JMenuItem("Exit");
    JMenuItem reset = new JMenuItem("Reset");
    JMenuItem calculate = new JMenuItem("Calculate");
    JMenu terms = new JMenu("Term and Rates");
    JMenuItem t0 = new JMenuItem(rates[0]);
    JMenuItem t1 = new JMenuItem(rates[1]);
    JMenuItem t2 = new JMenuItem(rates[2]);
    JScrollPane displayScroll = new JScrollPane(result, 
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    public TryCatch(){
        //Set up the window
        super("Mortgages");
        setSize(520,500);
        Container con = this.getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con.setLayout(new FlowLayout());
        setJMenuBar(jmb);
        
        
        //Add the menu bar
        jmb.add(terms);
        terms.add(t0);
        terms.add(t1);
        terms.add(t2);
        jmb.add(calculate);
        jmb.add(reset);
        jmb.add(exit);
        
        //Add all the GUI elements
        con.add(principalLabel);
        con.add(principal);
        con.add(termLabel);
        con.add(termBox);
        con.add(rateLabel);
        con.add(rateBox);
        con.add(display1);
        con.add(displayScroll);
        
        result.setEditable(false);
        
        //Add action listeners
        calculate.addActionListener(this);
        exit.addActionListener(this);
        t0.addActionListener(this);
        t1.addActionListener(this);
        t2.addActionListener(this);
        reset.addActionListener(this);
    }
    public static void main(String[] args) {
        TryCatch a = new TryCatch();
        a.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        Object c = e.getSource();
        
        //Deal with menu bar interactions
        if(c.equals(exit)){
            this.dispose();
        }
        else if(c.equals(t0)){
            termBox.setText("7");
            rateBox.setText("5.35");
        }
        else if(c.equals(t1)){
            termBox.setText("15");
            rateBox.setText("5.5");
        }
        else if(c.equals(t2)){
            termBox.setText("30");
            rateBox.setText("5.75");
        }
        else if(c.equals(reset)){
            principal.setText("");
            termBox.setText("");
            rateBox.setText("");
            result.setText("");
        }
        
        //Display the mortgage info in the box
        else if(c.equals(calculate)){

            double term = Double.parseDouble(termBox.getText()) * 12;
            double rate = Double.parseDouble(rateBox.getText()) / 100 / 12;
            double principle = Double.parseDouble(principal.getText());
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
            throws Exceptions {
        if(rate > 0.00520833334|| rate < 0.00270833333){
            throw new Exceptions("Invalid Rate");
        }
        else if (term > 40*12 || term < 120){
            throw new Exceptions("Invalid Term");
        }
        else if(principle > 1000000 || principle < 5000){
            throw new Exceptions ("Invalid Principle");
        }
        
        // display info in the box
        result.setText("Term\tMonth Payment\tInterest Paid\tPrincipal"
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
            result.append(i + 1 + "\t$" + Math.round(cpayment * 100)
                    / 100.0 + "\t$" + Math.round(interestPaid * 100) / 100.0
                    + "\t$" + Math.round(principalPaid * 100) / 100.0
                    + "\t$" + Math.round(balance * 100) / 100.0 + "\n");
        }
    }
    
}