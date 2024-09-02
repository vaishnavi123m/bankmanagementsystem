package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class Pinchange  extends JFrame implements  ActionListener{
    JPasswordField t1,t2;
    JButton b1,b2;                               
    JLabel l1,l2,l3;
    String pin,cardno;
    Pinchange(String p,String c)
    {pin=p;
    cardno=c;
    setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 700, 650);
        add(l4);
        
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);
        
        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        
        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);
        
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        
        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        
        l1.setBounds(160,150,800,35);
        l4.add(l1);
        
        l2.setBounds(100,200,150,35);
        l4.add(l2);
        
        l3.setBounds(80,250,200,35);
        l4.add(l3);
        
        t1.setBounds(260,200,120,25);
        l4.add(t1);
        
        t2.setBounds(260,250,120,25);
        l4.add(t2);
        
        b1.setBounds(290,290,120,35);
        l4.add(b1);
        
        b2.setBounds(290,340,120,35);
        l4.add(b2);
        
        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String npin = t1.getText();
            String rpin = t2.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(ae.getSource()==b1){
                if (t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (t2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                
                String q1 = "update user set pno = '"+rpin+"' where cno = '"+cardno+"' ";
               

                Connection con = null;
               PreparedStatement ps = null;
               con = connection.connectDB();
               ps = con.prepareStatement(q1);
               ps.executeUpdate();
              
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin,cardno).setVisible(true);
            
            }else if(ae.getSource()==b2){
                new Transactions(pin,cardno).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    public static void main(String arg[])
    {new Pinchange("","").setVisible(true);}
    
    
}
