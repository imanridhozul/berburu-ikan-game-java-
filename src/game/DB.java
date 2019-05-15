package game;

import java.sql.*;
import javax.swing.JOptionPane;

import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author L
 */
public class DB {
    private Connection con;
    private Statement st;
    private ResultSet rs; 
    private String sql;        
   public static String nama [] = new String [10];
   public static String skor [] = new String [10];
   int i=0;
    public DB()
    {
       
        try 
        {   //loader
            Class.forName("com.mysql.jdbc.Driver");
            //
            
            //Class.forName("org.sqlite.JDBC");
            //con = DriverManager.getConnection("jdbc:sqlite:D:/Berburu.sqlite");
          
           con = DriverManager.getConnection("jdbc:mysql://localhost/berburu", "root", null);
            System.out.println("Connection successfully created !");
        } 
        catch (ClassNotFoundException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }        
    }    
    
    public void selecAllData(){               
        
        sql = "select * from player order by skor desc limit 0,5";
        
        try 
        {                        
            
           st=con.createStatement();                    
           st.execute(sql);                        
           rs=st.getResultSet();       
            while (rs.next()) {            
                nama[i] = rs.getString("nama");
                skor[i] = rs.getString("skor");
                System.out.println(nama[i]+" "+skor[i]);
                i++;
            }
        } 
        catch (SQLException ex) 
        {            
            JOptionPane.showMessageDialog(null, ex);
        }
                         
    }
    public void insertData(String name, int skor)
    {
        
        try {
            st = con.createStatement();            
            sql = "INSERT INTO player VALUES ('"+name+"', '"+skor+"')";
            System.out.println(sql);
            if( !st.execute(sql) )
            {
                JOptionPane.showMessageDialog(null, "Data Inserted to Database!");
                
            }            
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex);
        }    
    }
}
