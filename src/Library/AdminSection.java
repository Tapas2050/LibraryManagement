package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AdminSection extends JFrame implements ActionListener
{
    JLabel l1;
    JButton bt1;
    JPanel p1,p2;
    Font f,f1;
    
    AdminSection()
    {
        super("Admin Page");
        setLocation(0,0);
        setSize(1500,800);
        
        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,20);
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Library/icon/lal2.jpg"));
        Image img=ic.getImage().getScaledInstance(1500,800,Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        l1=new JLabel(ic1);
        
        JMenuBar m1=new JMenuBar();
        JMenu mn1=new JMenu("Add Info");
        JMenuItem mnt1=new JMenuItem("Add Librarian");
        
        JMenu mn2=new JMenu("View Info");
        JMenuItem mnt2=new JMenuItem("View Librarian");
        
        JMenu mn3=new JMenu("Delete Info");
        JMenuItem mnt3=new JMenuItem("Delete Librarian");
        
        JMenu mn4=new JMenu("Exit");
        JMenuItem mnt4=new JMenuItem("Logout");
        
        mn1.add(mnt1);
        mn2.add(mnt2);
        mn3.add(mnt3);
        mn4.add(mnt4);
        
        m1.add(mn1);
        m1.add(mn2);
        m1.add(mn3);
        m1.add(mn4);
        
        mn1.setFont(f);
        mn2.setFont(f);
        mn3.setFont(f);
        mn4.setFont(f);
        
        mnt1.setFont(f1);
        mnt2.setFont(f1);
        mnt3.setFont(f1);
        mnt4.setFont(f1);
        
        mnt1.addActionListener(this);
        mnt2.addActionListener(this);
        mnt3.addActionListener(this);
        mnt4.addActionListener(this);
        
        setJMenuBar(m1);
        add(l1);
    }
    public void actionPerformed(ActionEvent e)
    {
        String comnd=e.getActionCommand();
        if(comnd.equals("Add Librarian"))
        {
//            System.out.println("add");
            new AddLibrarian().setVisible(true);
        }
        else if(comnd.equals("View Librarian"))
        {
//            System.out.println("view");
            new ViewLibrarian().setVisible(true);
        }
        else if(comnd.equals("Delete Librarian"))
        {
//            System.out.println("delete");
            new DeleteLibrarian().setVisible(true);
        }
        else if(comnd.equals("Logout"))
        {
            System.exit(0);
        }
    }
    public static void main(String[] args)
    {
        new AdminSection().setVisible(true);
    }
}
