/**
 *
 * @author Kirby James Fernandez
 * @professor E. Nikjeh
 * @date October 14, 2017
 * @description This Program was created using Java's GUI features using JFrame and JTextField with two JLabels.
 * @purpose This program converts Fahrenheit Degree to Celsius Degree using the formula c = (5/9.0)(F-32.0)
 * @lab Week 7 Assignment 1
 * @class CS3 Programming in Java
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;import java.text.*;

public abstract class Mortgage extends JFrame implements ActionListener {
    
    // Creating Boxes and Labels
    // Sets Text and Alignment
    JPanel firstRow = new JPanel(new GridLayout(1,3));
    JLabel loanAmountLabel1 = new JLabel("Loan Amount: ", JLabel.LEFT);
    JTextField loanAmountTxt = new JTextField(10);
    
    JPanel secondRow = new JPanel(new GridLayout(1,3));
    JLabel loanTermLabel2 = new JLabel("Loan Term: ", JLabel.LEFT);
    JTextField loanTermTxt = new JTextField(10);
    
    JPanel thirdRow = new JPanel(new GridLayout(1,3));
    JLabel interestRateLabel3 = new JLabel("Interest Rate: ", JLabel.LEFT);
    JTextField interestRateTxt = new JTextField(10);
    
    JPanel fourthRow = new JPanel(new GridLayout(1,3));
    JLabel monthlyPaymentLabel4 = new JLabel("Monthly Payment: ", JLabel.LEFT);
    
    JLabel payment = new JLabel("");
    JPanel button = new JPanel(new FlowLayout(FlowLayout.CENTER));
    
    // Buttons
    JButton calc = new JButton("Calculate");
    JButton reset = new JButton("Calculate");
    JButton exit = new JButton("Calculate");
    
    
    public Mortgage()
    {
        super("Mortgage Calculator");
        setSize(600, 350);
        FlowLayout flow = new FlowLayout();
        Container cont = this.getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cont.setLayout(flow);
        
        cont.add(loanAmountLabel1);
        cont.add(loanAmountTxt);
        cont.add(loanTermLabel2);
        cont.add(loanTermTxt);
        cont.add(interestRateLabel3);
        cont.add(interestRateTxt);
        cont.add(monthlyPaymentLabel4);
        cont.add(payment);
        cont.add(button);
        cont.add(calc);
        cont.add(reset);
        cont.add(exit);
        calc.addActionListener(this);
        reset.addActionListener(this);
        exit.addActionListener(this);
    }
    
    public static void main(String[] args)
    {
        Mortgage mort = new Mortgage()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        };
    }
}
