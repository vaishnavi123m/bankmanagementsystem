package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;
public class Signuptwo extends JFrame implements ActionListener{
    JRadioButton r1,r2;
    JButton b1,b2;
    String fno,n,db,email;
    Signuptwo(String fn,String n,String db,String email)
    {   setLayout(null);
    fno=fn;
    this.fno=fn;
    this.n=n;
    this.db=db;
    this.email=email;
        JLabel l1=new JLabel("Page2 : Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,30));
        l1.setBounds(160,30,400,40);
        add(l1);
        
        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,24));
        type.setBounds(80,110,200,30);
        add(type);
        
        r1=new JRadioButton("Savings account");
        r1.setFont(new Font("Raleway",Font.BOLD,18));
        r1.setBounds(100,160,200,22);    
        add(r1);
      
        r2=new JRadioButton("Current account");
        r2.setFont(new Font("Raleway",Font.BOLD,18));
        r2.setBounds(350,160,200,22);    
        add(r2);
      
       
        ButtonGroup g=new ButtonGroup();
        g.add(r1);
        g.add(r2);
        
        
        JLabel t=new JLabel("Card Number");
        t.setFont(new Font("Raleway",Font.BOLD,24));
        t.setBounds(80,240,200,30);
        add(t);
        
        JLabel num=new JLabel("XXXX-XXXX-4184");
        num.setFont(new Font("Raleway",Font.BOLD,16));
        num.setBounds(280,240,250,30);
        add(num);
        
        JLabel num1=new JLabel("Your 12 digit cardno");
        num1.setFont(new Font("Raleway",Font.BOLD,10));
        num1.setBounds(80,260,250,30);
        add(num1);
        
        
        JLabel pin=new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,24));
        pin.setBounds(80,320,200,30);
        add(pin);
        
        JLabel pin1=new JLabel("Your 4 digit pin");
        pin1.setFont(new Font("Raleway",Font.BOLD,10));
        pin1.setBounds(80,340,200,30);
        add(pin1);
        
        JLabel pnum=new JLabel("XXXX");
        pnum.setFont(new Font("Raleway",Font.BOLD,16));
        pnum.setBounds(280,320,250,30);
        add(pnum);
        
        
        
        b1=new JButton("Cancel");
        b1.setBounds(200,450,120,40);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Submit");
        b2.setBounds(400,450,120,40);
        b2.addActionListener(this);
        add(b2);
        
      
        
        
        setSize(650,800);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
          if(e.getSource()==b2)
          {
              String act=null;
              if(r1.isSelected()) act="Savings Account";
              else act="Current Account";
               Random r=new Random();
               String cno=""+Math.abs((r.nextLong()%90000000L)+ 504093600000L);
              String pno=""+Math.abs((r.nextLong()%9000L)+1000L);
               Connection con = null;
               PreparedStatement ps = null;
               con = connection.connectDB();
               System.out.println(cno);
               System.out.println("in signup 2 submit");
               
              try{
                  String sql1="insert into user values('"+fno+"','"+n+"','"+db+"','"+email+"','"+act+"','"+cno+"','"+pno+"',0)";
                  
                  ps = con.prepareStatement(sql1);
                  ps.execute();
                 
                JOptionPane.showMessageDialog(null,"Card number:"+cno+"\nPin number:"+pno);
              setVisible(false);
              new Deposit(pno,cno).setVisible(true);
              }
              catch(Exception ex){}
          }
         else
              System.exit(0);
    }
    public static void main(String arg[])
    {
        new Signuptwo("","","","");
    }
}
