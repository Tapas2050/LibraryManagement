package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ReturnBook extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JButton bt1,bt2;
    JPanel p1,p2;
    Font f,f1;
    JTextField tf1,tf2;
    ReturnBook()
    {
        super("Return Book");
        setLocation(450,400);
        setSize(500,200);
        
        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,20);
        
        tf1=new JTextField();
        tf2=new JTextField();
        
        l1=new JLabel("Return Book");
        l2=new JLabel("Book NO");
        l3=new JLabel("Student ID");
        
        bt1=new JButton("Confirm");
        bt2=new JButton("Cancel");
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        bt1.setFont(f1);
        bt2.setFont(f1);
        tf1.setFont(f1);
        tf2.setFont(f1);
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.WHITE);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        p1.setBackground(Color.BLUE);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(3,2,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(bt1);
        p2.add(bt2);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
    }
    public void actionPerformed(ActionEvent e)
    {
        String bookno=tf1.getText();
        String studid=tf2.getText();
        
        if(e.getSource()==bt1)
        {
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String s="delete from issuebook where bookno='"+bookno+"' and student_id='"+studid+"'";
                int res=obj.stm.executeUpdate(s);
                if(res==0)
                {
                    JOptionPane.showMessageDialog(null, "Book isn't issued yet");
                    this.setVisible(false);
                }
                else
                {
                    String s1="update addbook set issuedbook=issuedbook-1 where bookno='"+bookno+"'";
                    String s2="update addbook set quantity=quantity+1 where bookno='"+bookno+"'";
                    int a=obj.stm.executeUpdate(s1);
                    int aa=obj.stm.executeUpdate(s2);
                    if(a==1)
                    {
                        if(aa==1)
                        {
                            JOptionPane.showMessageDialog(null, "Your book is successfully updated");
                            this.setVisible(false);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Please!, Fill all the details carefully");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Please!, Fill all the details carefully");
                    }
                }
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }
        if(e.getSource()==bt2)
        {
            JOptionPane.showMessageDialog(null, "Are you sure !");
            this.setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new ReturnBook().setVisible(true);
    }
}