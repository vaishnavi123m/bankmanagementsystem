package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    JTextField t1,t2;
    JButton b1,b2;
    String pn,cn;
    JLabel l1,l3;
    Withdrawl(String p,String cn)
    { pn=p;
    this.cn=cn;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
         l3=new JLabel(i3);
        l3.setBounds(0,0,700,650);
        add(l3);
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        b1 = new JButton("Withdraw");
        b2 = new JButton("BACK");
        
        setLayout(null);
        
        l1.setBounds(85,170,400,35);
        l3.add(l1);
        
        t1.setBounds(85,220,320,25);
        l3.add(t1);
        
        b1.setBounds(80,290,120,35);
        l3.add(b1);
        
        b2.setBounds(270,290,120,35);
        l3.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setSize(700,900);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1)
        {
            String amount=t1.getText();
           
            try{
                if(amount.equals("") || amount.equals("0"))
                JOptionPane.showMessageDialog(null,"Please enter amount");
                else
               {  int x=Integer.parseInt(amount);
               Connection con = null;
               PreparedStatement ps = null,ps2=null,ps3=null;
               con = connection.connectDB();
               String s="Withdrawl";
               String sql1="select * from user where cno='"+cn+"'";
               ps = con.prepareStatement(sql1);
               ResultSet r=ps.executeQuery();
               int t = 0;
               
               while(r.next())
               {    
                   t=Integer.parseInt(r.getString("balance"));
               }
               if(x>t)
               {
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    setVisible(false);
               }
                
               else{t=t-x; 
               String sql2="insert into transactions values('"+cn+"','"+s+"','"+x+"')";
               ps = con.prepareStatement(sql2);
               ps.executeUpdate();
               
               String t1=Integer.toString(t);
               String sql3;
                
               sql3 = "update user set balance='"+t1+"' where cno='"+cn+"'";
               ps3= con.prepareStatement(sql3);
               ps3.executeUpdate();
               
               
                JOptionPane.showMessageDialog(null, "Amount Rs."+amount+" Withdrawn  successfully");
               setVisible(false);}
            }}
            catch(Exception e1){}
        }
        else
        {
            setVisible(false);
            new Transactions(pn,cn).setVisible(true);
        }
    }
    public static void main(String a[])
    {
        new Withdrawl("","").setVisible(true);
    }
}
