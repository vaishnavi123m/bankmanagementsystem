package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Transactions extends JFrame implements ActionListener{
    
     JLabel l1;
    JButton b1,b2,b3,b4,b5;
    String pin,cardno;
    Transactions(String cn,String p)
    {setLayout(null);
    pin=p;
    cardno=cn;
    
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l2=new JLabel(i3);
        l2.setBounds(0,0,700,650);
        add(l2);
                
        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
       
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("PIN CHANGE");
        b4= new JButton("BALANCE ENQUIRY");
        b5 = new JButton("EXIT");
        
        l1.setBounds(125,170,700,35);
        l2.add(l1);
        
        b1.setBounds(70,220,150,25);
        l2.add(b1);
        
        b2.setBounds(250,220,150,25);
        l2.add(b2);
        
        b3.setBounds(70,270,150,25);
        l2.add(b3);
        
        b4.setBounds(250,270,150,25);
        l2.add(b4);
        
        b5.setBounds(170,315,150,25);
        l2.add(b5);
        
        b1.addActionListener(this);
       b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
       
        
        setSize(700,900);
        setLocation(300,0);
        setVisible(true);
   }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){ 
            setVisible(false);
            new Deposit(pin,cardno).setVisible(true);
        }else if(ae.getSource()==b2){ 
            setVisible(false);
            new Withdrawl(pin,cardno).setVisible(true);
        }
       else if(ae.getSource()==b3){ 
            setVisible(false);
            new Pinchange(pin,cardno).setVisible(true);
        }else if(ae.getSource()==b4){ 
            this.setVisible(false);
            new Balanceenquiry(pin,cardno).setVisible(true);
        }else if(ae.getSource()==b5){ 
            System.exit(0);
        }
    }
            
    public static void main(String a[])
    {
        new Transactions("","").setVisible(true);
    }
}
