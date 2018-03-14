/**
 *
 * @author Kirby James Fernandez
 * @professor E. Nikjeh
 * @date October 14, 2017
 * @description This Program was created using Java's GUI features using JFrame and JTextField with two JLabels.
 * @purpose This program converts Fahrenheit Degree to Celsius Degree using the formula c = (5/9.0)(F-32.0)
 * @lab Week 7 Lab Assignment 1
 * @class CS3 Programming in Java
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class Conversion extends JFrame implements ActionListener {
    JButton change = new JButton("Change");
    JLabel ask = new JLabel("Enter degree in Fahrenheit: ");
    JTextArea put = new JTextArea(1, 5);
    JLabel firstDisplay = new JLabel("Degree in Celsius: ");
    JLabel secondDisplay = new JLabel("");
    
    public Conversion()
    {
        super("Temperature Conversion");
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        setSize(350, 250);
        FlowLayout flow = new FlowLayout();
        Container cont = this.getContentPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cont.setLayout(flow);
        put.setEditable(true);
        
        cont.add(ask);
        cont.add(put);
        cont.add(firstDisplay);
        cont.add((secondDisplay));
        cont.add(change);
        change.addActionListener(this);
        
    }
    
    public static void main(String[] args)
    {
        Conversion conv = new Conversion();
        conv.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        Object t = e.getSource();
        if(t.equals(change))
        {
            double F = Double.parseDouble(put.getText());
            double c = (5/9.0) * (F-32.0);
         
            secondDisplay.setText((twoDigits.format(c)));
        }
    }
}
