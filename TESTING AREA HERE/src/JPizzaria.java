/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruh
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JPizzaria extends JFrame implements ItemListener
{
    JLabel companyName = new JLabel("Tower of Pizza Pizzaria");
    JComboBox sizeBox = new JComboBox();
    JLabel sizeList = new JLabel("Size List");
    JComboBox toppingBox = new JComboBox();
    JLabel toppingList = new JLabel("Topping List");
    JTextField totPrice = new JTextField(10);
    
    // Declarations
    int totalPrice = 0;
    int sizeNum, toppingNum;
    int sPrice, tPrice, sumPrice;
    int[] sizePrice = { 0,7,9,11,14 };
    int[] toppingPrice = {0,0,1,2,3,1};
    String output;
    
    public JPizzaria()
    {
        super("Tower of Pizzaria");
        FlowLayout flow = new FlowLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.setLayout(flow);
        
      
        sizeBox.addItem("None");
        sizeBox.addItem("Small");
        sizeBox.addItem("Medium");
        sizeBox.addItem("Large");
        sizeBox.addItem("Extra Large");
        
        toppingBox.addItem("None");
        toppingBox.addItem("Cheese");
        toppingBox.addItem("Sausage");
        toppingBox.addItem("Pepperoni");
        toppingBox.addItem("Green Pepper");
        toppingBox.addItem("Onion");
        
        pane.add(sizeList);
        pane.add(sizeBox);
        sizeBox.addItemListener(this);
        pane.add(toppingList);
        pane.add(toppingBox);
        toppingBox.addItemListener(this);
        pane.add(companyName);
        pane.add(totPrice);
        setContentPane(pane);
    }
    
    public static void main(String[] args)
    {
        JPizzaria pframe = new JPizzaria();
        pframe.setSize(200, 200);
        pframe.setVisible(true);
    }
    
    public void itemStateChanged(ItemEvent list)
    {
        Object source = list.getSource();
        if(source == sizeBox)
        {
            sizeNum = sizeBox.getSelectedIndex();
            sPrice = sizePrice[sizeNum];
            sumPrice = sPrice + tPrice;
            output = "Total Price $" + sumPrice;
            totPrice.setText(output);
        }
        else if(source == toppingBox)
        {
            toppingNum = toppingBox.getSelectedIndex();
            tPrice = toppingPrice[toppingNum];
            sumPrice = sPrice + tPrice;
            output = "Total Price $" + sumPrice;
            totPrice.setText(output);
        }
    }
}
