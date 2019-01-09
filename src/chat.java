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
public class chat
{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   	static final String DB_URL = "jdbc:mysql://localhost:3306/SAMS";
   //  Database credentials
   	static final String USER = "root";
   	static final String PASS = "dbms";
   	public String[][] show_chat(String b)
   	{
   		String abc[]=b.split(" ");
   		Connection conn = null;
	   Statement stmt = null;
	   Statement stmt2 = null;
	   Statement stmt3 = null;
	   Statement stmt4 = null;
	   int l=0,i;
   	try{
   		Class.forName("com.mysql.jdbc.Driver");
	      //STEP 3: Open a connection
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      stmt = conn.createStatement();
	      stmt2 = conn.createStatement();
	      stmt3 = conn.createStatement();
	      stmt4 = conn.createStatement();
	      
			String sql="select count(*) from chat where Sale='"+abc[0]+"' and User= '"+abc[1]+"'";
	       ResultSet rs2=stmt3.executeQuery(sql);
	       rs2.next();
	       l=Integer.parseInt(rs2.getString("count(*)"));
	   	   }
	   	   catch(Exception dfdss)
	   	   {

	   	   }
   			String a[][]=new String[l][3];
   			try{
   			String sql2="select * from chat where Sale='"+abc[0]+"' and User= '"+abc[1]+"'";
	       ResultSet rs=stmt4.executeQuery(sql2);
   			for(i=0;i<l;++i)
   			{
   				rs.next();
   				a[i][0]=rs.getString("current");

   				a[i][1]=rs.getString("msg");
               Encrypt en=new Encrypt();
            //a[i][1]=en.decrypt(a[i][1],"hellow world");
   				//a[i][2]=rs.getString("SaleNot");
   			}
   		}
   		catch(Exception EsR)
   		{

   		}
   		return a;
	  }

	public void insert_chat(String b,String msg1)
   	{
   		String abc[]=b.split(" ");
         int who=Integer.parseInt(abc[2]);
   		Connection conn = null;
	   Statement stmt = null;
	   int k=0;
   	try{
   		Class.forName("com.mysql.jdbc.Driver");
	      //STEP 3: Open a connection
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      stmt = conn.createStatement();
	      if(who==1)k=1;
         if(!msg1.equals(""))
         {
            //Encrypt en=new Encrypt();
            //msg1=en.encrypt(msg1,"hellow world");
	       String sql="insert into chat values('"+abc[0]+"','"+abc[1]+"','"+abc[who]+"','"+msg1+"',1)";
	       int j=stmt.executeUpdate(sql);
       }
   		
		}
   		catch(Exception EsR)
   		{
   			
   		}
	}
   	public String[] show_Sales()
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
	       String sql="select count(*) from SalesPerson";
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
   			String sql2="select * from SalesPerson";
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
   public int user_number(String a,String b,String c)
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
          String sql="select count(*) from chat where current='"+a+"' and Sale='"+b+"' and User='"+c+"' and number=1";
          ResultSet rs2=stmt.executeQuery(sql);
          rs2.next();
           l=Integer.parseInt(rs2.getString("count(*)"));

         }
         
         catch(Exception ER)
         {
            //return l;
         }
         return l;
   }
    public int update_number(String a,String b,String c)
      {
         Connection conn = null;
      Statement stmt = null;
      Statement stmt2 = null;
      int l=0;
      try{
         Class.forName("com.mysql.jdbc.Driver");
         //STEP 3: Open a connection
         conn = DriverManager.getConnection(DB_URL,USER,PASS);
         stmt2 = conn.createStatement();
         String sql1="update chat set number=0 where current='"+a+"' and Sale='"+b+"' and User='"+c+"' and number=1";
          int r2=stmt2.executeUpdate(sql1);

         }
         
         catch(Exception ER)
         {
            //return l;
         }
         return l;
   }

}