package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class IssueBook extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton bt1,bt2;
    JPanel p1,p2;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    Choice ch;
    Font f,f1;
    
    IssueBook()
    {
        super("Issue Book");
        setLocation(0,0);
        setSize(650,400);
        
        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,20);
        
        l1=new JLabel("Issue Book");
        l2=new JLabel("Book Id");
        l3=new JLabel("Book No");
        l4=new JLabel("Book Name");
        l5=new JLabel("Student Id");
        l6=new JLabel("Student Name");
        l7=new JLabel("Student Contact");
        l8=new JLabel("Book Quantity");
        
        l1.setForeground(Color.WHITE);
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();
        tf6=new JTextField();
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        
        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        tf6.setFont(f1);
        tf6.setEditable(false);
        tf6.setForeground(Color.RED);
        
        bt1=new JButton("Issue Book");
        bt2=new JButton("Cancel");
        
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        ch=new Choice();
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String r="select id from addbook";
            ResultSet rest=obj.stm.executeQuery(r);
            while(rest.next())
            {
                ch.add(rest.getString("id"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        ch.setFont(f1);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        p1.setBackground(Color.BLUE);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(8,2,10,10));
        p2.add(l2);
        p2.add(ch);
        p2.add(l3);
        p2.add(tf1);
        p2.add(l4);
        p2.add(tf2);
        p2.add(l5);
        p2.add(tf3);
        p2.add(l6);
        p2.add(tf4);
        p2.add(l7);
        p2.add(tf5);
        p2.add(l8);
        p2.add(tf6);
        p2.add(bt1);
        p2.add(bt2);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
        
        ch.addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mouseClicked(MouseEvent arg0)
                    {
                        try
                        {
                            ConnectionClass obj=new ConnectionClass();
                            int id=Integer.parseInt(ch.getSelectedItem());
                            String v1="select * from addbook where id='"+id+"'";
                            ResultSet rest1=obj.stm.executeQuery(v1);
                            while(rest1.next())
                            {
                                tf1.setText(rest1.getString("bookno"));
                                tf2.setText(rest1.getString("bookname"));
                                tf6.setText(rest1.getString("quantity"));
                            }
                        }
                        catch(Exception eex)
                        {
                            eex.printStackTrace();
                        }
                    }
                });
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            int qnt=0;
            int id=Integer.parseInt(ch.getSelectedItem());
            String bookno=tf1.getText();
            String bookname=tf2.getText();
            String studid=tf3.getText();
            String stuname=tf4.getText();
            String stucont=tf5.getText();
            String date=new java.util.Date().toString();
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String r2="select quantity from addbook where id='"+id+"'";
                ResultSet rest=obj.stm.executeQuery(r2);
                while(rest.next())
                {
                        qnt=Integer.parseInt(rest.getString("quantity"));
                }
                if(qnt<=0)
                {
                    JOptionPane.showMessageDialog(null, "Book quantity is less! can't issue");
                    this.setVisible(false);
                }
                else
                {
                    String k="insert into issuebook(bookId,bookno,bookname,student_id,student_name,student_contact,date) values('"+id+"','"+bookno+"','"+bookname+"','"+studid+"','"+stuname+"','"+stucont+"','"+date+"')";
                    String k1="update addbook set issuedbook=issuedbook+1 where id='"+id+"'";
                    String k2="update addbook set quantity=quantity-1 where id='"+id+"'";
                    int a=obj.stm.executeUpdate(k);
                    int aa=obj.stm.executeUpdate(k1);
                    int aaa=obj.stm.executeUpdate(k2);
                    if(a==1)
                    {
                        if(aa==1)
                        {
                            if(aaa==1)
                            {
                                JOptionPane.showMessageDialog(null, "your data is successfully updated");
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
        new IssueBook().setVisible(true);
    }
}
