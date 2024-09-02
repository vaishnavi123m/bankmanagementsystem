/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;
public class Signupone extends JFrame implements ActionListener{
    JTextField nt,dt,et;
    JRadioButton yes,no;
    JComboBox ed;
    long  ra;
     JButton next;
    Signupone()
    {   Random r=new Random();
    ra=Math.abs((r.nextLong()%9000L)+1000L);
    setLayout(null);
        JLabel formno=new JLabel("Application form no "+ra);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel p=new JLabel("Personal details");
        p.setFont(new Font("Raleway",Font.BOLD,30));
        p.setBounds(240,80,600,30);
        add(p);
        
         JLabel n=new JLabel("Name :");
        n.setFont(new Font("Raleway",Font.BOLD,22));
        n.setBounds(130,170,300,20);
        add(n);
        
        nt=new JTextField();
        nt.setBounds(350,170,300,25);
        add(nt);
        
        
        JLabel dob=new JLabel("DOB :");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(130,220,300,20);
        add(dob);
        
        dt=new JTextField();
        dt.setBounds(350,220,300,25);
        add(dt);
        
        
        String education[]={"Non-Graduate","Gradaute","Post graduate","Doctorate","Other"};
        JLabel edu=new JLabel("Education:");
        edu.setFont(new Font("Raleway",Font.BOLD,22));
        edu.setBounds(130,320,300,20);
        add(edu);
        
         ed=new JComboBox(education);
        ed.setBounds(350,320,300,22);
        add(ed);
        
        JLabel se=new JLabel("Senior citizen:");
        se.setFont(new Font("Raleway",Font.BOLD,22));
        se.setBounds(130,370,300,20);
        add(se);
        
        yes=new JRadioButton("Yes");
        yes.setBounds(350,370,50,22);
        add(yes);
        
        no=new JRadioButton("No");
        no.setBounds(450,370,60,22);
        add(no);
        
        
        ButtonGroup senior=new ButtonGroup();
        senior.add(yes);
        senior.add(no);
       
       
        JLabel g=new JLabel("Email :");
        g.setFont(new Font("Raleway",Font.BOLD,22));
        g.setBounds(130,270,600,20);
        add(g);
        
        et=new JTextField();
        et.setBounds(350,270,300,25);
        add(et);
        
        
        next=new JButton("NEXT");
        next.setBounds(250,450,100,30);
        next.addActionListener(this);
         add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        String fno=""+ra,name=nt.getText(),bd=dt.getText(),email=et.getText();
        try
        {
            if(name.equals(""))
                    JOptionPane.showMessageDialog(null,"Name is required");
            else
            {
                
               
                new Signuptwo(fno,name,bd,email).setVisible(true);            }
        }
        catch(Exception e1){}
    }
    public static void main(String arg[])
    {
        new Signupone();
    }
    
}
