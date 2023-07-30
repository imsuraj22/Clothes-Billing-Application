/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcon;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author suraj
 */
public class DbConnection
{
    static Connection con;
    static public Connection getConnection()
    {
        
//        Properties properties = new Properties();
//    properties.setProperty("user", "root");
//    properties.setProperty("password", "milos23");
//    properties.setProperty("useSSL", "false");

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_software?autoReconnect=true&useSSL=false","springstudent","springstudent");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
    }
}