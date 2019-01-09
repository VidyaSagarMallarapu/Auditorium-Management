import java.sql.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.*;

public class SalesPerson
{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   	static final String DB_URL = "jdbc:mysql://localhost:3306/SAMS";
   	static final String USER = "root";
   	static final String PASS = "dbms";
   	
	public String[] show_User(String abc)
   	{
   		Connection conn = null;
	   Statement stmt = null;
	   Statement stmt2 = null;
	   int l=0;
   	try{
   		Class.forName("com.mysql.jdbc.Driver");
	      //STEP 3: Open a connection
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      stmt = conn.createStatement();
	      stmt2 = conn.createStatement();
	       String sql="select distinct User from chat where Sale='"+abc+"';";
	       ResultSet rs2=stmt.executeQuery(sql);

	       while(rs2.next())l++;
   		}
   		catch(Exception e)
   		{

   		}
   		String a[]=new String[l];
   		try{
   			int i=0;
   			String sql2="select distinct User from chat where Sale='"+abc+"';";
	       ResultSet rs=stmt2.executeQuery(sql2);
   			for(i=0;i<l;++i)
   			{
   				rs.next();
   				a[i]=rs.getString("User");
   			}
   		}
   		catch(Exception ER)
   		{

   		}
   		return a;
	}
   public String[] approve_User(String abc)
      {
         Connection conn = null;
      Statement stmt = null;
      Statement stmt2 = null;
      int l=0;
      try{
         Class.forName("com.mysql.jdbc.Driver");
         //STEP 3: Open a connection
         conn = DriverManager.getConnection(DB_URL,USER,PASS);
         stmt = conn.createStatement();
         stmt2 = conn.createStatement();
          String sql="select count(*) from  User where uid='"+abc+"' and verified=0";
          ResultSet rs2=stmt.executeQuery(sql);
          rs2.next();
          l=Integer.parseInt(rs2.getString("count(*)"));
       }
         catch(Exception e)
         {

         }
         String a[]=new String[l];
         try{
            int i=0;
            String sql2="select username from User where uid='"+abc+"' and verified=0";
          ResultSet rs=stmt2.executeQuery(sql2);
            for(i=0;i<l;++i)
            {
               rs.next();
               a[i]=rs.getString("username");
            }
         }
         catch(Exception ER)
         {

         }
         return a;
   }
   public void approve_User2(String abc)
      {
         Connection conn = null;
      Statement stmt = null;
           try{

         Class.forName("com.mysql.jdbc.Driver");
         //STEP 3: Open a connection
         conn = DriverManager.getConnection(DB_URL,USER,PASS);
         stmt = conn.createStatement();
          String sql="update User set verified=1 where username='"+abc+"' ";
           int imn3=stmt.executeUpdate(sql);
          
      }
      catch(Exception sf)
      {

      }
   }
   
}