/**
 *
 * @author Kirby James Fernandez
 * @professor E. Nikjeh
 * @date October 14, 2017
 * @description This Program was created using Java GUI features using JFrame and JTextArea, JButton, and  with three JLabels.
 * @purpose This program serves as a Mortgage calculate that prompts the user in Graphical User Interface.
 * @lab Week 7 Lab Assignment 1
 * @class CS3 Programming in Java
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Conversion extends JFrame implements ActionListener {
    // set Buttons
    JButton calc = new JButton("Calculate");
    JButton res = new JButton("Reset");
    JButton ex = new JButton("Exit");
    
    // set label for loanAmount
    JLabel loanCalc = new JLabel("Enter loan Amount: ");
    JTextArea loanText = new JTextArea(1, 5);
    
    // set label for loan Term
    JLabel loanTermCalc = new JLabel("Enter loan term(in years): ");
    JTextArea loanTermText = new JTextArea(1, 5);
    JLabel loanTermDisplay = new JLabel("Loan Term: ");
    
    // set label for interest rate
    JLabel interestRateCalc = new JLabel("Enter interest rate: ");
    JTextArea interestRateText = new JTextArea(1, 5);
    JLabel interestRateDisplay = new JLabel("Interest rate: ");
    
    JLabel monthlyPaymentDisplay = new JLabel("");
    
    public Conversion()
    {
        super("Mortgage Calculator");
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        setSize(750, 350);
        FlowLayout flow = new FlowLayout();
        Container cont = this.getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cont.setLayout(flow);
        loanText.setEditable(true);
        loanTermText.setEditable(true);
        interestRateText.setEditable(true);
        
        // add for loanAmount
        cont.add(loanCalc);
        cont.add(loanText);
        
        // add for loanTerm
        cont.add(loanTermCalc);
        cont.add(loanTermText);
        cont.add(loanTermDisplay);
        
        // add for interestRate
        cont.add(interestRateCalc);
        cont.add(interestRateText);
        cont.add(interestRateDisplay);
        
        // add monthlyPayment
        cont.add(monthlyPaymentDisplay);
        
        cont.add(calc);
        cont.add(res);
        cont.add(ex);
        
        calc.addActionListener(this);
        res.addActionListener(this);
        ex.addActionListener(this);
        
    }
    
    public static void main(String[] args)
    {
        Conversion conv = new Conversion() {};
        conv.setVisible(true);
    }
   
    public void actionPerformed(ActionEvent e)
        {
            DecimalFormat twoDigits = new DecimalFormat("0.00");
            Object t = e.getSource();
            if(t.equals(calc))
            {
                    /* 
                    MONTHLY PAYMENT FORMULA:
                    double monthlyPayment = (loanAmount*monthlyRate) / 
                                           (1-Math.pow(1+monthlyRate, -termInMonths))
                    */
                    double monthlyPayment = (Double.parseDouble(loanText.getText())
                                            * Double.parseDouble(interestRateText.getText()) / 12 / 100) 
                                            / (1 - Math.pow(1 + Double.parseDouble(interestRateText.getText()) / 12 / 100,  -Double.parseDouble(loanTermText.getText()) * 12));
                    monthlyPaymentDisplay.setText("$" + twoDigits.format((monthlyPayment * 100) / 100));
            }
            else if(t.equals(res))
            {
                    loanCalc.setText("");
                    loanTermCalc.setText("");
                    interestRateCalc.setText("");
            }
            else if(t.equals(ex))
            {
                    this.dispose();
            }
        }
}
