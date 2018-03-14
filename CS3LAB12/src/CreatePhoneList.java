import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CreatePhoneList extends JFrame
    implements ActionListener
{
    private JLabel title =
      new JLabel("Phone List");
    Font bigFont = new Font("Helvetica", Font.ITALIC, 20);
    private JLabel prompt = new JLabel("Enter a friend's name");
    private JTextField name = new JTextField(10);
    private JTextField phone = new JTextField(10);
    private JLabel nLabel = new JLabel("Name");
    private JLabel pLabel = new JLabel("Phone number");
    private JButton enterDataButton =   new JButton("Enter data");
    private Container con = getContentPane();
    DataOutputStream ostream;

    public CreatePhoneList()
    {
        super("Create Phone List");
        try
        {
            ostream = new 
            DataOutputStream(new 
            FileOutputStream("phoneList.txt"));
        }
        catch(IOException e)
        {
            System.err.println("File not opened");
            System.exit(1);
        }
        setSize(150,250);
        con.setLayout(new FlowLayout());
        title.setFont(bigFont);
        con.add(title);
        con.add(prompt);
        con.add(nLabel);
        con.add(name);
        con.add(pLabel);
        con.add(phone);
        con.add(enterDataButton);
        enterDataButton.addActionListener(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    public void actionPerformed(ActionEvent e1)
    {
        try
        {
            ostream.writeUTF(name.getText());
            ostream.writeUTF(phone.getText());
            name.setText("");
            phone.setText("");
        }
        
        catch(IOException e2)
        {
            System.err.println("Error writing file");    
            System.exit(1);
        }
    }
  public static void main(String[] arguments)
  {
   CreatePhoneList cef = new CreatePhoneList(); 
   cef.setVisible(true);
  }

} 