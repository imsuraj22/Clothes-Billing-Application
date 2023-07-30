/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcon;

import gettersetter.Register;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author suraj
 */
public class DbOperations 
{
    public static ResultSet login(String email1, String pass1)
    {
        ResultSet rs=null;
        try
        {
            Connection con=dbcon.DbConnection.getConnection();
            
            PreparedStatement ps=con.prepareStatement("select * from register where email=? and password=?");
            ps.setString(1, email1);
            ps.setString(2, pass1);
            
            rs=ps.executeQuery();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return rs;
    }
    
    public static boolean register(Register reg)
    {
        boolean status=false;
        try
        {
            Connection con=DbConnection.getConnection();
            
            PreparedStatement ps=con.prepareStatement("insert into register (name,email,password,gender,phone_no,module) values(?,?,?,?,?,?)");
            
            ps.setString(1, reg.getName());
            ps.setString(2, reg.getEmail());
            ps.setString(3, reg.getPassword());
            ps.setString(4, reg.getGender());
            ps.setString(5, reg.getPhoneno());
            ps.setString(6, reg.getModule());
            
            int i=ps.executeUpdate();
            if(i>0)
            {
                status=true;
            }
            else
            {
                status=false;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
    
    public static ResultSet showEmployeeDetails()
    {
        ResultSet rs = null;
        try
        {
            Connection con=DbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from register where module='Employee'");
            rs=ps.executeQuery();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return rs;
    }
    public static ResultSet gerSelectedEmployees(int id)
    {
        ResultSet rs = null;
        try
        {
            Connection con=dbcon.DbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from register where reg_id=?");
            ps.setInt(1 , id);
            
            rs=ps.executeQuery();  
        }
        catch(Exception e)
        {
            
        }
        return rs;
    }
    
    public static int updateEmpDetails(int reg_id,Register reg)
    {
        int i = 0;
        try
        {
            Connection con=dbcon.DbConnection.getConnection();
                PreparedStatement ps=con.prepareStatement("update register set name=?, password=?, gender=?, phone_no=? ,email=? where reg_id=?");
            
            ps.setString(1, reg.getName());
            ps.setString(2, reg.getPassword());
            ps.setString(3, reg.getGender());
            ps.setString(4, reg.getPhoneno());
            ps.setString(5, reg.getEmail());
            ps.setInt(6, reg_id);
            
            i=ps.executeUpdate();
        }
        catch(Exception e)
        {
            
        }
        return i;
    }
    
    public static int deleteEmpDetails(String email)
    {
        int i = 0;
        try
        {
            Connection con=dbcon.DbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("delete from register where email=?");
            
            
            ps.setString(1, email);
            
            i=ps.executeUpdate();
        }
        catch(Exception e)
        {
            
        }
        return i;
    }
    
    public static boolean insertImageDetails(FileInputStream fis, String... str)
    {
        boolean status=false;
        try
        {
            Connection con=dbcon.DbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into "+str[2]+"(item_name, item_price, item_category, item_desc,item_image) values(?,?,?,?,?)");
            ps.setString(1, str[0]);
            ps.setString(2, str[1]);
            ps.setString(3, str[2]);
            ps.setString(4, str[3]);
            //ps.setString(5, fid);
            ps.setBinaryStream(5, fis);
            
            int i=ps.executeUpdate();
            if(i>0)
            {
                status=true;
            }
            else
            {
                status=false;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
    
     public static ResultSet getAllItems(String cat)
    {
        ResultSet rs = null;
        try
        {
            Connection con=DbConnection.getConnection();
            
            PreparedStatement ps=con.prepareStatement("select * from "+cat);
            rs=ps.executeQuery();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return rs;
    }
     
     public static ResultSet getItemDetails(int item_id)
    {
        String cat="";
        if(item_id<300){
            cat="men";
        }else if(item_id<600 && item_id>=300){
            cat="woman";
        }else{
            cat="children";
        }
        ResultSet rs = null;
        try
        {
            Connection con=DbConnection.getConnection();
            
            PreparedStatement ps=con.prepareStatement("select * from "+cat+" where item_id=?");
            ps.setInt(1, item_id);
            rs=ps.executeQuery();
        }
        catch(Exception e)
        {
            System.out.println("inside exception");
            System.out.println(e);
        }
        return rs;
    }
    
      public static boolean deleteItem(String cat,String item_id)
    {
        boolean status=false;
        try
        {
            Connection con=DbConnection.getConnection();
            
            PreparedStatement ps=con.prepareStatement("delete from "+cat+" where item_id=?");
            ps.setInt(1, Integer.parseInt(item_id));
            
            int i=ps.executeUpdate();
            if(i>0)
            {
                status=true;
            }
            else
            {
                status=false;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
      
      public static boolean updateItemWithImage(FileInputStream fis, String... str)
    {
        boolean status=false;
        try
        {
            Connection con=DbConnection.getConnection();
            
            PreparedStatement ps=con.prepareStatement("update "+str[3]+" set item_name=?, item_price=?, item_category=?, item_desc=?, item_image=? where item_id=?");
            ps.setString(1, str[1]);
            ps.setString(2, str[2]);
            ps.setString(3, str[3]);
            ps.setString(4, str[4]);
            ps.setBinaryStream(5, fis);
            ps.setString(6, str[0]);
            
            int i=ps.executeUpdate();
            if(i>0)
            {
                status=true;
            }
            else
            {
                status=false;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
      
      public static boolean updateItemWithoutImage(String... str)
    {
        boolean status=false;
        try
        {
            Connection con=DbConnection.getConnection();
            
            PreparedStatement ps=con.prepareStatement("update "+str[3]+" set item_name=?, item_price=?, item_category=?, item_desc=? where item_id=?");
            ps.setString(1, str[1]);
            ps.setString(2, str[2]);
            ps.setString(3, str[3]);
            ps.setString(4, str[4]);
            ps.setString(5, str[0]);
            
            int i=ps.executeUpdate();
            if(i>0)
            {
                status=true;
            }
            else
            {
                status=false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
      
      public static boolean checkPassword(String old_pass, String email)
      {
          boolean status=false;
          try
          {
            Connection con=DbConnection.getConnection();
            
            PreparedStatement ps=con.prepareStatement("select * from register where email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, old_pass);
            
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                status=true;
            }
            else
            {
                status=false;
            }
          }
          catch(Exception e)
          {
              System.out.println(e);
          }
          return status;
      }
      
      public static boolean updatePassword(String new_pass, String email)
      {
          boolean status=false;
          try
          {
            Connection con=DbConnection.getConnection();
            
            PreparedStatement ps=con.prepareStatement("update register set password=? where email=?");
            ps.setString(1, new_pass);
            ps.setString(2, email);
            
            int i=ps.executeUpdate();
            if(i>0)
            {
                status=true;
            }
            else
            {
                status=false;
            }
          }
          catch(Exception e)
          {
              System.out.println(e);
          }
          return status;
      }
      
      public static boolean updateMyProfile(String name, String gender, String phone, String email)
      {
          boolean status=false;
          try
          {
             Connection con=DbConnection.getConnection();
            
            PreparedStatement ps=con.prepareStatement("update register set name=?, gender=?, phone_no=? where email=?");
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, phone);
            ps.setString(4, email);
            
            int i=ps.executeUpdate();
            if(i>0)
            {
                status=true;
            }
            else
            {
                status=false;
            }
            
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
          return status;
      }
      public static boolean insertCustomerdetails(String... str)
      {
          boolean status=false;
          String name1=str[0];
          String email1=str[1];
          String gender1=str[2];
          String phone_no=str[3];
         
          
          try
          {
            Connection con=DbConnection.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into customer (name,email,gender,phone_no) values(?,?,?,?)");
            ps.setString(1, name1);
            ps.setString(2, email1);
            ps.setString(3, gender1);
            ps.setInt(4, Integer.parseInt(phone_no));
           
            
            int i=ps.executeUpdate();
            if(i>0)
            {
              status=true;  
            }
            else
            {
                status=false;
            }
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
          return status;
          
      }
      
      public static ResultSet checkCustomerExists(String phoneno)
      {
          ResultSet rs=null;
          try
          {
            Connection con=DbConnection.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from customer where phone_no=?");
            ps.setInt(1, Integer.parseInt(phoneno));
            
            rs=ps.executeQuery();
          }
          catch(Exception e)
          {
             e.printStackTrace();
          }
          return rs;
      }
      
      public static boolean customerBillingDetails(int customer_phno, String items, String date1, String time1, String emp_email)
    {
        boolean status=false;
        try
        {
            Connection con=dbcon.DbConnection.getConnection();
            
            PreparedStatement ps=con.prepareStatement("insert into customerbilling values(?,?,?,?,?)");
            ps.setInt(1, customer_phno);
            ps.setObject(2, items);
            ps.setString(3, date1);
            ps.setString(4, time1);
            ps.setString(5, emp_email);
            
            int i=ps.executeUpdate();
            if(i>0)
            {
                status=true;
            }
            else
            {
                status=false;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
    }
      public static ResultSet getCustomerShoppingDetails()
      {
          ResultSet rs=null;
          try
          {
              Connection con=dbcon.DbConnection.getConnection();
            
            PreparedStatement ps=con.prepareStatement("select * from customerbilling ");
            //ps.setString(1, phno);
            rs=ps.executeQuery();
             // System.out.println("fetch data successfully");
            
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
          return rs; 
      }
}
