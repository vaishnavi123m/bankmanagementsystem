package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class Balanceenquiry extends JFrame implements ActionListener{
    
    JButton b1;                              
    JLabel l1;
    String pin,cardno;
     Balanceenquiry(String p,String c)
    {pin=p;
    cardno=c;
    setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 700, 650);
        add(l4);
        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(100, 200, 400, 35);
        l4.add(l1);

        b1.setBounds(170, 333, 150, 35);
        l4.add(b1);
        int balance=0;
        try{String q1="select * from user where cno='"+cardno+"'";
            Connection con = null;
               PreparedStatement ps = null;
               con = connection.connectDB();
               ps = con.prepareStatement(q1);
              
              
               ResultSet rs =ps.executeQuery();
            while (rs.next()) {
             
                
                    balance += Integer.parseInt(rs.getString("balance"));
               
  }
        }catch(Exception e){}
        
        l1.setText("Your Current Account Balance is Rs "+balance);

        b1.addActionListener(this);
        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
}
      public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin,cardno).setVisible(true);
    }
     public static void main(String arg[])
     {
         new Balanceenquiry("","").setVisible(true);
     }
}