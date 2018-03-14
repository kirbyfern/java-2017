/**
 *
 * @author Kirby James Fernandez
 * @professor E. Nikjeh
 * @date October 21, 2017
 * @description This Program was created using Java's GUI features using JFrame and JTextField and JLabels.
 * @purpose This program is a GUI Calculator that computes basing from the users loan input and choice of rates
 * @lab Week 9 Homework 1
 * @class CS3 Programming in Java
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class JMortgage extends JFrame implements ActionListener
{       
    // set Buttons
    JButton calc = new JButton("Calculate");
    JButton res = new JButton("Reset");
    JButton ex = new JButton("Exit");
    
    // Declaration of variables
    String[] rates = {"7 year at 5.35%", "15 year at 5.5%", "30 year at 5.75%"};
    // JComboBox
    JComboBox loanBox = new JComboBox(rates);
    
    // set label for Amount of Mortage
    JLabel principal = new JLabel("Enter loan Amount: ");
    JTextArea principalText = new JTextArea(1, 5);
    JLabel chooseLoan = new JLabel("\nSelect a Loan:");
    
    // set display output for monthly payments
    JLabel displayPrincipal = new JLabel("Your monthly payments are: ");
    // Result
    JTextArea result = new JTextArea(10, 35);
    
    JScrollPane displayScroll = new JScrollPane(result, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       
    public JMortgage()
    {
        super("Mortgage Program Calculator");
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        setSize(500,500);
        FlowLayout flow = new FlowLayout();
        Container cont = this.getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cont.setLayout(flow);
        principalText.setEditable(true);
        loanBox.setEditable(false);
        result.setEditable(false);
                
        // add for loanAmount
        cont.add(principal);
        cont.add(principalText);
        
        // select drop down
        cont.add(chooseLoan);
        cont.add(loanBox);
        
        cont.add(displayPrincipal);
        cont.add(displayScroll);
        
        // set Buttons
        cont.add(calc);
        cont.add(res);
        cont.add(ex);
        
        calc.addActionListener(this);
        res.addActionListener(this);
        ex.addActionListener(this);
        
    }
    
    public static void main(String[] args)
    {
        JMortgage mframe = new JMortgage();
        mframe.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        Object t = e.getSource();
        if(t.equals(calc)){
            int term;
            double rate;
            double princ = Double.parseDouble(principal.getText());
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
            double mpayment = (princ * rate)/ (1 - Math.pow(rate + 1, -term));
            double balance = princ;
            for (int i = 0; i < term; i++){
                double cpayment, interestPaid, principalPaid;
                interestPaid = rate * balance;
                cpayment = Math.min(mpayment , balance + interestPaid);
                
                principalPaid = cpayment - interestPaid;
                balance -= principalPaid;
                result.append(i + 1 + "\t$" + Math.round(cpayment * 100) / 100.0 + "\t$" + Math.round(interestPaid * 100) / 100.0 + "\t$" + Math.round(principalPaid * 100) / 100.0 + "\t$" + Math.round(balance * 100) / 100.0 + "\n");
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
