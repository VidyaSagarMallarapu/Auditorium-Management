import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.*;
public class Clerk
{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   	static final String DB_URL = "jdbc:mysql://localhost:3306/SAMS";
   	static final String USER = "root";
   	static final String PASS = "dbms";
	public static long date_differ(String dateStart,String dateStop)
				{
					long diffDays=0;
				try{

					//HH converts hour in 24 hours format (0-23), day calculation
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

					Date d1 = null;
					Date d2 = null;

					d1 = format.parse(dateStart);
					d2 = format.parse(dateStop);

					//in milliseconds
					long diff = d2.getTime() - d1.getTime();

					diffDays = diff / (24 * 60 * 60 * 1000);

					
				}
				catch(Exception e)
				{

				}
				return diffDays;
		}

	public void setNumber(String sid)
		{

		try{

		Class.forName("com.mysql.jdbc.Driver");

	   	Connection conn = null;
	   	conn = DriverManager.getConnection(DB_URL,USER,PASS);
      	Statement stmt = null;
      	Statement stmt2 = null;
	    stmt = conn.createStatement();
	    stmt2 = conn.createStatement();
           String sql="select *from `Show` where sid='"+sid+"' and number=1";
           ResultSet re=stmt.executeQuery(sql);
           DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
           Date dateobj = new Date();
       		String dateOn=df.format(dateobj);
           re.next();
           if(date_differ(dateOn,re.getString("date")+" "+re.getString("timings"))<0)
				{
	       String SQL2="update `Show` set number=0 where sid='"+sid+"'";
	       	 int imn1=stmt2.executeUpdate(SQL2);
	       		}
	   }
	   catch(Exception e)
	   {
	   	
	   }
	}
	public static int balance(String name,double price)
      {
      	int y=0;
      	try{
		Class.forName("com.mysql.jdbc.Driver");

	   	Connection conn = null;
	   	conn = DriverManager.getConnection(DB_URL,USER,PASS);
      	Statement stmt = null;
      	Statement stmt2 = null;
      	Statement stmt3 = null;
      	Statement stmt4 = null;
      	Statement stmt5 = null;
      	Statement stmt6 = null;
	    stmt = conn.createStatement();
        stmt2 = conn.createStatement();
        stmt3= conn.createStatement();
        stmt4 = conn.createStatement();
       	stmt5= conn.createStatement();
        stmt6 = conn.createStatement();
        
        	
	       
           String sql1="select sum(price) from ticket where showid='"+name+"';";
	       ResultSet rs1 = stmt.executeQuery(sql1);
	       double sumPrice=0;
	       int imn1;
	       	if(rs1.next())
	       	{
       			y=1;
       		 
	       	 String sql4="delete from ticket where showid='"+name+"'";
	       	 imn1=stmt4.executeUpdate(sql4);
	       	 try{
	       	 sumPrice=Double.parseDouble(rs1.getString("sum(price)"));
	       	 	}
	       	 	catch(Exception sdfs)
	       	 	{
	       	 		sumPrice=0;
	       	 	}
	       	 
	       	}
	       	String sql3="delete from Seat where showid='"+name+"'";
	       	 imn1=stmt3.executeUpdate(sql3);
	      	
	       String sql34="select *from `Show` where sid='"+name+"';";
	       ResultSet rs = stmt2.executeQuery(sql34);
	       String sql341="update `Show` set number=-1 where sid='"+name+"';";
	       imn1=stmt6.executeUpdate(sql341);
	       rs.next();
	      String SQL2="insert into sheet values('"+rs.getString("sid")+"','"+rs.getString("ShowName")+"','"+rs.getString("date")+"','"+sumPrice+"','"+price+"','"+rs.getString("timings")+"','"+(sumPrice-price)+"')";
         imn1=stmt5.executeUpdate(SQL2);
	  }
	  
		
	   catch(Exception e)
	   {
	   	
	   }
	   return y;
	
}
}