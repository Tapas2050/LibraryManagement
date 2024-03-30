package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class DeleteLibrarian extends JFrame implements ActionListener
{
    String y[]={"Id","Name","Password","Email","Contact_Number","address","City"};
    JButton bt1;
    String z[][]=new String[20][7];
    int i=0,j=0;
    JTable t;
    Font f,f1;
    JTextField tf1;
    JPanel p1;
    JLabel l1;
    
    DeleteLibrarian()
    {
        super("Delete Librariabn");
        setLocation(1,1);
        setSize(1000,400);
        
        f=new Font("Arial",Font.BOLD,15);
        
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String r="select * from librarian";
            ResultSet rest=obj.stm.executeQuery(r);
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
        
        l1=new JLabel("Delete Librarian");
        tf1=new JTextField();
        bt1=new JButton("Delete");
        bt1.addActionListener(this);
        
        l1.setFont(f);
        tf1.setFont(f);
        bt1.setFont(f);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,3,10,10));
        p1.add(l1);
        p1.add(tf1);
        p1.add(bt1);
        
        setLayout(new BorderLayout(10,10));
        add(sp,"Center");
        add(p1,"South");
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            int id=Integer.parseInt(tf1.getText());
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String w="delete from librarian where Lid='"+id+"'";
                int res=obj.stm.executeUpdate(w);
                if(res==1)
                {
                    JOptionPane.showMessageDialog(null, "Your data is successfully deleted");
                    this.setVisible(false);
                    new DeleteLibrarian().setVisible(true);
                }
                else
                {
                     JOptionPane.showMessageDialog(null, "Your data isn't successfully deleted");
                     this.setVisible(false);
                     new DeleteLibrarian().setVisible(true);
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args)
    {
        new DeleteLibrarian().setVisible(true);
    }
}
