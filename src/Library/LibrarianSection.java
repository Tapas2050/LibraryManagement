package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class LibrarianSection extends JFrame implements ActionListener
{
    JLabel l1;
    JButton bt1;
    JPanel p1,p2;
    Font f,f1;
    
    
    LibrarianSection()
    {
        super("Librarian Page");
        setLocation(0,0);
        setSize(1500,800);
        
        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,20);
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Library/icon/llp1.jpg"));
        Image img=ic.getImage().getScaledInstance(1500,800,Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        l1=new JLabel(ic1);
        
        JMenuBar m1=new JMenuBar();
        JMenu mn1=new JMenu("Book Info");
        JMenuItem mnt1=new JMenuItem("Add Book");
        JMenuItem mnt2=new JMenuItem("Delete Book");
        
        JMenu mn2=new JMenu("View Info");
        JMenuItem mnt3=new JMenuItem("View Book");
        JMenuItem mnt4=new JMenuItem("View Issued Book");
        
        JMenu mn3=new JMenu("Issue Info");
        JMenuItem mnt5=new JMenuItem("Issue Book");
        
        JMenu mn4=new JMenu("Return");
        JMenuItem mnt6=new JMenuItem("Return Book");
        
        JMenu mn5=new JMenu("Exit");
        JMenuItem mnt7=new JMenuItem("Logout");
        
        mn1.add(mnt1);
        mn1.add(mnt2);
        mn2.add(mnt3);
        mn2.add(mnt4);
        mn3.add(mnt5);
        mn4.add(mnt6);
        mn5.add(mnt7);
        
        m1.add(mn1);
        m1.add(mn2);
        m1.add(mn3);
        m1.add(mn4);
        m1.add(mn5);
        
        mn1.setFont(f);
        mn2.setFont(f);
        mn3.setFont(f);
        mn4.setFont(f);
        mn5.setFont(f);
        
        mnt1.setFont(f1);
        mnt2.setFont(f1);
        mnt3.setFont(f1);
        mnt4.setFont(f1);
        mnt5.setFont(f1);
        mnt6.setFont(f1);
        mnt7.setFont(f1);
        
        mnt1.addActionListener(this);
        mnt2.addActionListener(this);
        mnt3.addActionListener(this);
        mnt4.addActionListener(this);
        mnt5.addActionListener(this);
        mnt6.addActionListener(this);
        mnt7.addActionListener(this);
        
        setJMenuBar(m1);
        add(l1);
    }
    public void actionPerformed(ActionEvent e)
    {
        String comnd=e.getActionCommand();
        if(comnd.equals("Add Book"))
        {
//            System.out.println("add");
            new AddBook().setVisible(true);
        }
        else if(comnd.equals("Delete Book"))
        {
//            System.out.println("deleted");
            new DeleteBook().setVisible(true); 
        }
        else if(comnd.equals("View Book"))
        {
//            System.out.println("view");
            new ViewBook().setVisible(true);
        }
        else if(comnd.equals("View Issued Book"))
        {
//            System.out.println("checked");
            new ViewIssuedBook().setVisible(true);
        }
        else if(comnd.equals("Issue Book"))
        {
//            System.out.println("Issued");
            new IssueBook().setVisible(true);
        }
        else if(comnd.equals("Return Book"))
        {
//            System.out.println("Return");
            new ReturnBook().setVisible(true);
        }
        else if(comnd.equals("Logout"))
        {
            System.exit(0);
        }
    }
    public static void main(String[] args)
    {
        new LibrarianSection().setVisible(true);
    }
}