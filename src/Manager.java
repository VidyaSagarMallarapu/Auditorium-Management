import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.*;
public class Manager
{

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   	static final String DB_URL = "jdbc:mysql://localhost:3306/SAMS";
   	static final String USER = "root";
   	static final String PASS = "dbms";

	public static boolean TimeFind(String date)
			{
				//01:23PM
				boolean ii=false;
				String a="",b="",c="";
				try{
				if(date.charAt(2)==':'&&date.charAt(5)==':'&&date.length()==8)
				{
					a=a+date.charAt(0)+date.charAt(1);
					b=b+date.charAt(3)+date.charAt(4);
					c=c+date.charAt(6)+date.charAt(7);
					int a1=Integer.parseInt(a);
					int a2=Integer.parseInt(b);
					int a3=Integer.parseInt(c);
					if(a1<25&&a1>=0&&a2>=0&&a2<60&&a3>=0&&a3<60)ii=true;
				}
				return ii;
			}
			catch(Exception ae)
				{
					return false;
				}

			}
	public static boolean DateFind(String date)
			{
				//23/01/2018
				boolean ii=false;
				String a="";
				try{
				if(date.charAt(2)=='/'&&date.charAt(5)=='/'&&date.length()==10)
				{
					a=a+date.charAt(0)+date.charAt(1);
					int i=Integer.parseInt(a);
					if(i<=31)
					{
						a="";
						a=a+date.charAt(3)+date.charAt(4);
						int iii=Integer.parseInt(a);
						if(iii<=12)
							ii=true;
					}
				}
				return ii;
			}
			catch(Exception ae)
				{
					return false;
				}

			}
		public static boolean showidFind(String sid)
			{
				String ar[]=sid.split(" ");
				int len=ar.length;
				if(len==1)return true;
				else return false;
				
			}
	public static boolean NumbOrNot(String pass)
			{
				try
				{
					int i=Integer.parseInt(pass);
					return false;
				}
				catch(NumberFormatException nfe)  
				  {  
				    return true;  
				  }  
			}
			public static boolean DoubleNot(String pass)
			{
				try
				{
					double i=Double.parseDouble(pass);
					return false;
				}
				catch(NumberFormatException nfe)  
				  {  
				    return true;  
				  }  
			}

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
	public String[][] Show_details()
	{
		Connection conn = null;
	   Statement stmt = null;
	   Statement stmt2 = null;
	   int lengt=0,i=0;
	   try{
	   		Class.forName("com.mysql.jdbc.Driver");
	      //STEP 3: Open a connection
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      stmt = conn.createStatement();
	      stmt2 = conn.createStatement();
	      String sql22="select count(*) from `Show`";
	      ResultSet rs12 = stmt.executeQuery(sql22);
	      rs12.next();
	      lengt=Integer.parseInt(rs12.getString("count(*)"));


	  }
	  catch(Exception er)
	  {

	  }

	  String ar[][]=new String[lengt][7];
	  try{
	      String sql2="select * from `Show`";
	      ResultSet rs1 = stmt2.executeQuery(sql2);
	      for(i=0;i<lengt;++i)
	      {
	      	rs1.next();
	      	ar[i][0] = rs1.getString("sid");
	      	ar[i][5] = rs1.getString("ShowName");
		 	ar[i][1] = rs1.getString("timings");
		 	ar[i][2] = rs1.getString("date");
		 	ar[i][3] = rs1.getString("balcony_rate");
		 	ar[i][4] = rs1.getString("ordinary_rate");
		 	ar[i][6]=rs1.getString("number");
		 }
		}
		catch(Exception df)
		{

		}
		return ar;
	 }
	 public String[][] Show_previous_details()
	{
		Connection conn = null;
	   Statement stmt = null;
	   Statement stmt2 = null;
	   int lengt=0,i=0;
	   try{
	   		Class.forName("com.mysql.jdbc.Driver");
	      //STEP 3: Open a connection
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      stmt = conn.createStatement();
	      stmt2 = conn.createStatement();
	      String sql22="select count(*) from sheet";
	      ResultSet rs12 = stmt.executeQuery(sql22);
	      rs12.next();
	      lengt=Integer.parseInt(rs12.getString("count(*)"));


	  }
	  catch(Exception er)
	  {

	  }

	  String ar[][]=new String[lengt][7];
	  try{
	      String sql2="select * from sheet";
	      ResultSet rs1 = stmt2.executeQuery(sql2);
	      for(i=0;i<lengt;++i)
	      {
	      	rs1.next();
	      	ar[i][0] = rs1.getString(1);
	      	ar[i][5] = rs1.getString(2);
		 	ar[i][1] = rs1.getString(3);
		 	ar[i][2] = rs1.getString(4);
		 	ar[i][3] = rs1.getString(5);
		 	ar[i][4] = rs1.getString(6);
		 	ar[i][6] = rs1.getString(7);
		 }
		}
		catch(Exception df)
		{

		}
		return ar;
	 }
	public void Show_delete(String delete)
	{
		Connection conn = null;
	   Statement stmt = null;
	   Statement stmt2 = null;
	   Statement stmt3 = null;
	   Statement stmt4 = null;
	   Statement stmt5 = null;
	   Statement stmt6 = null;
	   Statement stmt7 = null;
	   try{

	   	Class.forName("com.mysql.jdbc.Driver");
	    conn = DriverManager.getConnection(DB_URL,USER,PASS);
	    stmt = conn.createStatement();
	      stmt2 = conn.createStatement();
	      stmt3 = conn.createStatement();
	      stmt4 = conn.createStatement();
	      stmt5 = conn.createStatement();
	      stmt6 = conn.createStatement();
	      stmt7 = conn.createStatement();
	   String sql6="select * from User where username in (select userid from ticket where showid='"+delete+"')";
	      ResultSet rs2 = stmt5.executeQuery(sql6);
	      while(rs2.next())
	      {
	      	      	String b=rs2.getString("username");
	      	String sql4=" select sum(price) from ticket where userid='"+b+"' and showid='"+delete+"'";
		      ResultSet rs = stmt4.executeQuery(sql4);
		      rs.next();
		      String sql41=" select *from User where username='"+b+"'";
		      ResultSet rs22 = stmt6.executeQuery(sql41);
		      rs22.next();
		      double am=Double.parseDouble(rs22.getString("amount"))+Double.parseDouble(rs.getString("sum(price)"));
	String sql5="update User set amount="+am+" where username='"+b+"'";
			      int imn1=stmt7.executeUpdate(sql5);

	      }
	      String sql3="delete from ticket where showid='"+delete+"'";
	      int imn=stmt3.executeUpdate(sql3);
	      String sql1="delete from Seat where showid='"+delete+"'";
	      int i=stmt.executeUpdate(sql1);
	      String sql2="delete from `Show` where sid='"+delete+"'";
	      int ii=stmt2.executeUpdate(sql2);
          

	}
	catch(Exception e)
	{

	}
  }
	public int Show_book(String a1,String a2,String a4,String a5,String a6,String a7,String a8,String a9)
	{
		int temp=0;
		int error=0;
		Connection conn;
		Statement stmt = null;
	   Statement stmt2 = null;
	   Statement stmt3 = null;

	   try{
	   DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
       Date dateobj = new Date();
       String dateOn=df.format(dateobj);
      
	   	if(NumbOrNot(a4)||NumbOrNot(a5)||DoubleNot(a7)||DoubleNot(a8)|| !TimeFind(a2)|| !DateFind(a6)||!showidFind(a1))
        {
        	temp=2;
        }
        else if((date_differ(dateOn,a6+" "+a2))<0)
        {
        	error=10;
    	}
    	else
    	{
    		int a44=Integer.parseInt(a4);
        int a55=Integer.parseInt(a5);
	  	double a77=Double.parseDouble(a7);
	  	double a88=Double.parseDouble(a8);
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");
	      //STEP 3: Open a connection
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      //STEP 4: Execute a query
	      stmt = conn.createStatement();
	      stmt2 = conn.createStatement();
	      String sql1="select * from ShowManger;";
	       ResultSet rs=null;
	       rs=stmt.executeQuery(sql1);
	       rs.next();
	       String first = rs.getString("username");
	       String sql2="select *from `Show` where sid='"+a1+"' ;";
	       ResultSet r1=null;
	       r1=stmt2.executeQuery(sql2);
	       String seating;
	       if(r1.next())
	       {
	       	error=9;
			}
			else if(a9.equals("")||a1.equals("")||a2.equals("")||a4.equals("")||a5.equals("")||a6.equals("")||a7.equals("")||a8.equals(""))error=11;
			else
			{
			String sql3="insert into `Show` values ('"+a1+"','"+a2+"','"+a44+"','"+a55+"','"+first+"','"+a6+"',"+a77+","+a88+",'"+a9+"',1)";	
			int i=stmt2.executeUpdate(sql3);
			int j;
        	for(i=0;i<a44;++i)
        	{
	    		sql3="insert into Seat(id,uid,showid) VALUES ('b"+i+"','"+first+"','"+a1+"')";
	    			//out.println(sql3+"<br>");
	        	j=stmt.executeUpdate(sql3);
        	}
        	for(i=0;i<a55;++i)
        	{
	    		sql3="insert into Seat(id,uid,showid) VALUES ('o"+i+"','"+first+"','"+a1+"')";
	        	j=stmt.executeUpdate(sql3);
        	}
			}
    	}
    	
      if(DoubleNot(a8))error=8;
       if(DoubleNot(a7))error=7;
  		
       if(!DateFind(a6))error=6;
        if(NumbOrNot(a5))error=5;
        if(NumbOrNot(a4))error=4;
       if(!TimeFind(a2))error=2;
       if(!showidFind(a1))error=1;
    	}
    	catch(Exception d)
    	{

    	}

    	return error;
		}
	public int SalesPerson(String username,String password,String name,String uid)
   	{
   		int temp=0;
   	Connection conn = null;
	   Statement stmt = null;
	   Statement stmt2 = null;


   		try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      //STEP 4: Execute a query
	      stmt = conn.createStatement();
	      stmt2 = conn.createStatement();
	      if(username.equals("")||password.equals("")||name.equals(""))
	  	  {
	  	  	temp=0;
	  	  }
	  	  else
	  	  {
	      String SQL="select *from SalesPerson where username='"+username+"'";
	      ResultSet rs2=stmt2.executeQuery(SQL);
	      if(!rs2.next())
	      {
	      String sql1="insert into SalesPerson values('"+username+"','"+password+"','"+name+"','"+uid+"')";
	      int i=stmt.executeUpdate(sql1);
	      temp=1;
	  	  }
	  	  else temp=2;

	      
	      }

	   }
	   catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
	   return temp;
	}
	public int Clerk(String username,String password,String name,String uid)
   	{
   	int temp=0;
   	Connection conn = null;
	   Statement stmt = null;
	   Statement stmt2 = null;


   		try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      //STEP 4: Execute a query
	      stmt = conn.createStatement();
	      stmt2 = conn.createStatement();
	      if(username.equals("")||password.equals("")||name.equals(""))
	  	  {
	  	  	temp=0;
	  	  }
	  	  else
	  	  {
	      String SQL="select *from clerk where username='"+username+"'";
	      ResultSet rs2=stmt2.executeQuery(SQL);
	      if(!rs2.next())
	      {
	      	temp=1;
	      String sql1="insert into clerk values('"+username+"','"+password+"','"+name+"')";
	      int i=stmt.executeUpdate(sql1);
	      
	      
	   	}
	   	else temp=2;
	   }
		}

	   catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
	   return temp;
	}
	public String[] percentage(String a1)
	{
		 Connection conn = null;
	   Statement stmt = null;
	   Statement stmt2 = null;
	   Statement stmt3 = null;
	   Statement stmt4 = null;
	   Statement stmt5 = null;
	   Statement stmt6 = null;
	   String ar[]=new String[7];
	   try
	   {
	   	
	      Class.forName("com.mysql.jdbc.Driver");
	      //STEP 3: Open a connection
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      //STEP 4: Execute a query
	      stmt = conn.createStatement();
	      stmt2 = conn.createStatement();
		  stmt3 = conn.createStatement();
		  stmt4 = conn.createStatement();
		  stmt5 = conn.createStatement();
		  stmt6 = conn.createStatement();
	       String sql2="select *from `Show` where sid='"+a1+"';";
	       ResultSet r1=stmt.executeQuery(sql2);
	       int find=0;
	       
	       
	       if(r1.next())
	       {
	       	ar[6]=r1.getString("ShowName");
	       	String no_of_balcony_seats=r1.getString("no_of_balcony_seats");
	       	String no_of_ordinary_seats=r1.getString("no_of_ordinary_seats");
	       	int b=Integer.parseInt(no_of_balcony_seats);
	       	int o=Integer.parseInt(no_of_ordinary_seats);
	       	String sql3="select count(*) from ticket where showid='"+a1+"' and Type='balcony';";
	       	String sql4="select count(*) from ticket where showid='"+a1+"' and Type='ordinary';";
	       	ResultSet r2=stmt2.executeQuery(sql3);
	       	ResultSet r3=stmt3.executeQuery(sql4);
	        String b1="0";
	        if(r2.next())
	        b1=r2.getString("count(*)");
	    	else
	    		find=0;
	       	String o1="0";
	       	if(r3.next())
	       	o1=r3.getString("count(*)");
	       else find=0;
	       	String sql6="select sum(price) from ticket where showid='"+a1+"' and Type='ordinary'";
	       	String sql5="select sum(price) from ticket where showid='"+a1+"' and Type='balcony'";
	       	ResultSet r22=stmt4.executeQuery(sql5);
	       	ResultSet r33=stmt5.executeQuery(sql6);
	       	double o_price=0,b_price=0;
	       	if(r22.next())
	       	{
	       		String w1=r22.getString("sum(price)");
	       		if(w1!=null)
	       		{
	       			b_price=Double.parseDouble(w1);
	       		}
	       	}
	       	if(r33.next())
	       	{
	       		String w1=r33.getString("sum(price)");
	       		if(w1!=null)
	       		{
	       		o_price=Double.parseDouble(w1);
	       		}
	       	}
	       	ar[0]=""+b1;
	       	ar[1]=""+o1;
	       	ar[2]=""+b_price;
	       	ar[3]=""+o_price;
	       	ar[4]=""+o;
	       	ar[5]=""+b;
	   }
		}
		catch(Exception er)
		{

		}
		return ar;
	}
   	public int Login(String man,String name,String pwd)
   	{
   		int temp=0;
   		Connection conn = null;
	   Statement stmt = null;
   		try{
   			Class.forName("com.mysql.jdbc.Driver");
	      //STEP 3: Open a connection
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      //STEP 4: Execute a query
	      stmt = conn.createStatement();
	      String sql1="select *from `"+man+"` where username='"+name+"' and password='"+pwd+"';";
	       ResultSet rs = stmt.executeQuery(sql1);

			if(rs.next())temp=1;
		}
   		catch (Exception eed) {
   			
   		}
   		return temp;

	}
}