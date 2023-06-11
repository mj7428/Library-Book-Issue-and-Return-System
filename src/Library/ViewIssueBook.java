
package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewIssueBook extends JFrame{
    String x[] = {"Id","BookID","Book Name","StudentID","Student Name","Student Contact","Date of Issue"};
    JButton bt;
    String y[][] = new String[20][7];
    int i=0,j=0;
    JTable t;
    Font f,f1;
    
    ViewIssueBook(){
        super("ViewIssueBook Information");
        setLocation(1,1);
        setSize(1000,400);
        
        f = new Font("Arial",Font.BOLD,15);
        
        try{
            ConnectionClass obj= new ConnectionClass();
            String q="Select * from issuebook";
            ResultSet rest = obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++] = rest.getString("id");
                y[i][j++] = rest.getString("bookid");
                y[i][j++] = rest.getString("bookname");
                y[i][j++] = rest.getString("studentid");
                y[i][j++] = rest.getString("studentname");
                y[i][j++] = rest.getString("studentcontact");
                y[i][j++] = rest.getString("date");
                i++;
                j=0;
                
                t=new JTable(y,x);
                t.setFont(f);
            }
        }
        catch(Exception ee){
            ee.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(t);
        add(sp);
    }
   
    public static void main(String[] args){
        new ViewIssueBook().setVisible(true);
    
    }
    
}
