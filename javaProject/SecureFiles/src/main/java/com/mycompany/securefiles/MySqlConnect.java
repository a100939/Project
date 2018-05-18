/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.securefiles;
import java.sql.*;
import javax.swing.*;


/**
 *
 * @author Marley
 */
public class MySqlConnect {
   
    public static void main(String[]args){
    {
        
             try
        {
            //connection to database
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL="jdbc:mysql://localhost:3306/project";
            Connection conn =DriverManager.getConnection(connectionURL,"root","");
          
            //create statement
            Statement state = conn.createStatement();
            //execute sql query
            ResultSet rs = state.executeQuery("SELECT * FROM users");
            //return set
            while(rs.next())
            {
                System.out.println(rs.getString("name")+" , "+rs.getString("surname")+" , "+rs.getString("email"));
                
            }
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
    }
    }
}
