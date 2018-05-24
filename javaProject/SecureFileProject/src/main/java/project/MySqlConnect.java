package project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marley
 */
import java.sql.*;
import javax.swing.*;
public class MySqlConnect {
    public static Connection ConnectDB()
    {
         try
        {
            
            //connection to database
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL="jdbc:mysql://localhost:3306/project";
            Connection conn =DriverManager.getConnection(connectionURL,"root","");
            
            return conn;
         
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,e);
           return null;
          
        }
    }
}

