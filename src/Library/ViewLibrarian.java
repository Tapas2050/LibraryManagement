package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewLibrarian extends JFrame
{
    String y[]={"Lid","Name","Password","Email","Contact_Number","Address","City"};
    JButton bt;
    String z[][]=new String[50][7];
    int i=0,j=0;
    JTable t;
    Font f;
    ViewLibrarian()
    {
        super("Librarian Inforation");
        setLocation(1,1);
        setSize(1000,400);
        
        f=new Font("Arial",Font.BOLD,15);
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String v="select * from librarian";
            ResultSet rest=obj.stm.executeQuery(v);
            while(rest.next())
            {
                z[i][j++]=rest.getString("Lid");
                z[i][j++]=rest.getString("Name");
                z[i][j++]=rest.getString("Password");
                z[i][j++]=rest.getString("Email");
                z[i][j++]=rest.getString("Contact_Number");
                z[i][j++]=rest.getString("Address");
                z[i][j++]=rest.getString("City");
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
        new ViewLibrarian().setVisible(true);
    }
}
