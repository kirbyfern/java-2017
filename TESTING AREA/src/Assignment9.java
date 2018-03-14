/**
 *
 * @author Kirby James Fernandez
 * @professor E. Nikjeh
 * @date October 14, 2017
 * @description This Program was created using Java's GUI features using JFrame and JTextField with two JLabels.
 * @purpose This program 
 * @lab Week 9 Homework 1
 * @class CS3 Programming in Java
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Assignment9 extends JFrame implements ActionListener
{
    
    // Buttons
    JButton calc = new JButton("Calculate");
    JButton res = new JButton("Reset");
    JButton ex = new JButton("Close");
    
    // set array
    String[] rates = {"7 year at 5.35%", "15 year at 5.5%", "30 year at 5.75%"};
    JComboBox loanBox = new JComboBox(rates);
    
    // JLabel
    JLabel principalLabel = new JLabel("Enter Loan Amount");
    JTextArea principal = new JTextArea(1, 5);
    JLabel termLabel = new JLabel("Select the term and length: ");

    JLabel display1 = new JLabel("The monthly payments are: ");
    JTextArea result = new JTextArea(15,40);
    JScrollPane displayScroll = new JScrollPane(result, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    public Assignment9(){
        super("Mortgage Calculator");
        setSize(500,500);
        FlowLayout flow = new FlowLayout();
        Container con = this.getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con.setLayout(flow);
        principal.setEditable(true);
        loanBox.setEditable(false);
        result.setEditable(false);
        
        // prompt user for loan amount
        con.add(principalLabel);
        con.add(principal); // text area
        
        // dropdown menu
        con.add(termLabel);
        // jcombo box
        con.add(loanBox);
        
        con.add(display1);
        con.add(displayScroll);
        
        con.add(calc);
        con.add(res);
        con.add(ex);
        
        calc.addActionListener(this);
        res.addActionListener(this);
        ex.addActionListener(this);
    }
    
    public static void main(String[] args) {
        Assignment9 a = new Assignment9(); 
        a.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        Object t = e.getSource();
        if(t.equals(calc)){
            int term;
            double rate;
            double principle = Double.parseDouble(principal.getText());
            if (loanBox.getSelectedIndex() == 0){
                term = 12 * 7;
                rate = 5.35 / 100 / 12;
            }
            else if(loanBox.getSelectedIndex() == 1){
                term = 15*12;
                rate = 5.5 / 100 / 12;
            }
            else if(loanBox.getSelectedIndex() == 2){
                term = 30*12;
                rate = 5.75 / 100 / 12;
            }
            else{
                result.setText("Invalid selection.");
                return;
            }
            result.setText("Term\tMonth Payment\tInterest Paid\tPrincipal Paid\tLoan balance \n");
            double mpayment = (principle * rate)/ (1 - Math.pow(rate + 1, -term));
            double balance = principle;
            for (int i = 0; i < term; i++){
                double cpayment, interestPaid, principalPaid;
                interestPaid = rate * balance;
                cpayment = Math.min(mpayment , balance + interestPaid);
                
                principalPaid = cpayment - interestPaid;
                balance -= principalPaid;
                result.append(i + 1 + "\t$" + Math.round(cpayment * 100) / 100.0 + 
                            "\t$" + Math.round(interestPaid * 100) / 100.0 + "\t$" + 
                            Math.round(principalPaid * 100) / 100.0 + "\t$" + Math.round(balance * 100) / 100.0 + "\n");
            }
        }
        else if(t.equals(res)){
            principal.setText("");
            result.setText("");
        }
        else if(t.equals(ex)){
            this.dispose();
        }
    }
}
