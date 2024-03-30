package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewBook extends JFrame
{
    String x[]={"id","bookno","bookname","author","publisher","quantity","issuedbook","date"};
    JButton bt;
    String y[][]=new String[50][8];
    int i=0,j=0;
    JTable t;
    Font f;
    ViewBook()
    {
        super("Book Inforation");
        setLocation(1,1);
        setSize(1000,400);
        
        f=new Font("Arial",Font.BOLD,15);
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String r1="select * from addbook";
            ResultSet rest=obj.stm.executeQuery(r1);
            while(rest.next())
            {
                y[i][j++]=rest.getString("id");
                y[i][j++]=rest.getString("bookno");
                y[i][j++]=rest.getString("bookname");
                y[i][j++]=rest.getString("author");
                y[i][j++]=rest.getString("publisher");
                y[i][j++]=rest.getString("quantity");
                y[i][j++]=rest.getString("issuedbook");
                y[i][j++]=rest.getString("date");
                i++;
                j=0;
            }
            t=new JTable(y,x);
            t.setFont(f);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(t);
        add(sp);
    }
    public static void main(String args[])
    {
        new ViewBook().setVisible(true);
    }
}
