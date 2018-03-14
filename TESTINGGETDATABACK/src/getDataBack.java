/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kirby James Fernandez
 */

// import swing packages
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import javax.swing.*;
// import util packages for using string tokenizer
import java.util.*;
import java.io.*;

public class getDataBack extends JFrame implements ActionListener
{
    // set Buttons
    JButton calc = new JButton("Calculate");
    JButton res = new JButton("Reset");
    JButton ex = new JButton("Exit");
    
   // Declaration of variables is from a text file
    String[] rates = {"", "", ""};
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
       
    public getDataBack()
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
        getDataBack mframe = new getDataBack();
        mframe.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
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
    
//        String[] MortList = {"", "", ""};
//        double[] TermList = {0.0, 0.0, 0.0};
//        double[] InterestList = {0.0, 0.0, 0.0};
//        // fill the arrays from a file
//        try 
//        {
//            BufferedReader InFile = new BufferedReader(new FileReader("rates.txt"));
//            String InputLine = null;
//            int MyCount = 0;
//            while ((InputLine = InFile.readLine()) != null) 
//            {
//                StringTokenizer MyParse = new StringTokenizer(InputLine, ",");
//                MortList[MyCount] = MyParse.nextToken();
//                TermList[MyCount] = Double.parseDouble(MyParse.nextToken());
//                InterestList[MyCount] = Double.parseDouble(MyParse.nextToken());
//                MyCount += 1;
//                JOptionPane.showMessageDialog(null, "We read the Line number " + MyCount + " in the file");
//            } // end of while loop
//            InFile.close();
//        } // end of try block
//        catch(Exception ex) 
//        {
//            ex.printStackTrace();
//        } // end of catch block
//        // to see the result
//        for (int i = 0; i < 3; i++)
//        {
//            JOptionPane.showMessageDialog(null, "The Mortgage list is " + MortList[i] + "\nThe Term is " +
//                    TermList[i] + "\nThe Rate is " + InterestList[i]);
//        }
//        System.exit(0);

}
