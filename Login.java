
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class Login extends JFrame implements ActionListener{
    JButton login,clear,sup;
    JTextField ct;
    
    JPasswordField pt;
    Login()
    {   
        setLayout(null);
    
        setTitle("WELCOME TO BANK MANAGEMENT");
             ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/Untitled.jpeg"));
             Image i1=i.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
             ImageIcon i2=new ImageIcon(i1);
             JLabel l=new JLabel(i2);
             l.setBounds(70,100,100,100);
             add(l);
             getContentPane().setBackground(Color.WHITE);
            setSize(800,600);
            
            JLabel t=new JLabel("WELCOME TO ATM");
            t.setFont(new Font("Osward",Font.BOLD,38));
            t.setBounds(200,120,500,40);
            add(t);
            JLabel t1=new JLabel("Cardno:");
            t1.setFont(new Font("Osward",Font.BOLD,25));
            t1.setBounds(160,250,200,40);
            add(t1);
            JLabel t2=new JLabel("Pin:");
            t2.setFont(new Font("Osward",Font.BOLD,25));
            t2.setBounds(160,350,200,40);
            add(t2);
             ct=new JTextField();
            ct.setBounds(300,250,300,40);
            add(ct);
             pt=new JPasswordField();
            pt.setBounds(300,350,300,40);
            add(pt);
            login=new JButton("Sign In");
            login.setBounds(260,420,80,40);
            login.addActionListener(this);
            add(login);
            
            clear=new JButton("Clear");
            clear.setBounds(400,420,80,40);
            clear.addActionListener(this);
            add(clear);
           sup=new JButton("sign up");
            sup.setBounds(250,490,250,40);
            sup.addActionListener(this);
            add(sup);
             
             setVisible(true);
            
    }
    public void actionPerformed(ActionEvent e)
    {
         if(e.getSource()==clear)
         {ct.setText("");
          pt.setText("");
         }
         else if(e.getSource()==sup)
         {
         setVisible(false);
         new Signupone().setVisible(true);}
         else if(e.getSource()==login)
         { 
         Connection con = null;
               PreparedStatement ps = null,ps1=null;
               con = connection.connectDB();
               String cn=ct.getText(),pn=pt.getText();
               String q="select * from user where cno='"+cn+"' and pno='"+pn+"'";
           try
           {
               ps = con.prepareStatement(q);
                 ResultSet r= ps.executeQuery();
                 if(r.next())
                 {
                     setVisible(false);
                     new Transactions(cn,pn).setVisible(true);
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null,"Incorrect credentials");
                 }
           }
           catch(Exception ex){}
         }
    }
    public static void main(String args[])
    {
        new Login();
    }
    
}
