package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewIssuedBook extends JFrame
{
    String y[]={"bookId","bookno","bookname","student_id","student_name","student_contact","date"};
    JButton bt;
    String z[][]=new String[50][7];
    int i=0,j=0;
    JTable t;
    Font f;
    
    ViewIssuedBook()
    {
        super("Issued Book Inforation");
        setLocation(1,1);
        setSize(1000,400);
        
        f=new Font("Arial",Font.BOLD,15);
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String u="select * from issuebook";
            ResultSet rest=obj.stm.executeQuery(u);
            while(rest.next())
            {
                z[i][j++]=rest.getString("bookId");
                z[i][j++]=rest.getString("bookno");
                z[i][j++]=rest.getString("bookname");
                z[i][j++]=rest.getString("student_id");
                z[i][j++]=rest.getString("student_name");
                z[i][j++]=rest.getString("student_contact");
                z[i][j++]=rest.getString("date");
                i++;
                j=0;
            }
            t=new JTable(z,y);
            t.setFont(f);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(t);
        add(sp);
    }
    public static void main(String[] args)
    {
        new ViewIssuedBook().setVisible(true);
    }
}