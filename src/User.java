import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.*;
public class User
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
	public static int CheckPassword(String pass)
		{
			int i,numb=0,chr=0,l=pass.length();
			int returnn=0;
			for(i=0;i<l;++i)
			{
				if(Character.isDigit(pass.charAt(i)))numb++;
				else if (Character.isLetter(pass.charAt(i)))chr++;
				if(chr>=3&&numb>=2){returnn=1;break;}
			}
			return returnn;
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
	public static int Register(String a1,String a2,String a3,String a4,String a5)
	{
		Connection conn = null;
	   Statement stmt3=null;
	   Statement stmt4=null;
	   	int lengt=0,i,flag=0;
		try
		{
	      Class.forName("com.mysql.jdbc.Driver");
		  conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      stmt3 = conn.createStatement();
	      stmt4= conn.createStatement();
	      String sql4="select *from User where username='"+a1+"'";
        	String sql5="select *from SalesPerson where username='"+a5+"'";
        	ResultSet rs2=stmt3.executeQuery(sql4);
        	ResultSet rs3=stmt4.executeQuery(sql5);
        	String StringFind,SaleFind;
        	if(a1.equals("")||a2.equals("")||a3.equals("")||a4.equals("")||a5.equals("")||NumbOrNot(a3))
        	{
        		 
        		flag=1;//response.sendRedirect("User_Register.html");
        	}
        	if(flag!=1)
        	{
        	if(!(rs3.next()))
    		{
	    		SaleFind="";
    		}
        	else
        	{
        		SaleFind=rs3.getString("username");
        	}
        	
        	if (!rs2.next()) 
        	{
		    	StringFind="";
			} 
			else 
			{
        	  StringFind=rs2.getString("username");
			}
        	int a33=Integer.parseInt(a3);

	      if(StringFind.equals(""))
	      {
	      	int SalesPersonExist=0;
	      	
	      	
		      if(SaleFind.equals(""))
		      		{
		      		flag=2;//out.println("Invalid Sales Person Id  <a href=\"User_Register.html\">Registation here</a><br> ");	
		      		}
		      	else
		      	{	
	      	String sql2="insert into User VALUES ('"+a1+"','"+a2+"',"+a33+",'"+a4+"','"+a5+"',5000,0)";
        	int ijnd=stmt3.executeUpdate(sql2);
        	flag=3;//out.println("registered successfully<br> ");
        		}
        	}
		else 
		{
			flag=4;//out.println("Invalid Registation (User already exist) <a href=\"User_Register.html\">Registation here</a><br> ");
		}


  		}
  		}
  		catch(Exception defr)
  		{

  		}
  		return flag;
  	}
  public int know_Verified(String username)
   {
   	
   	Connection conn = null;
	   	Statement stmt = null;
      int re=0;
      try{
      Class.forName("com.mysql.jdbc.Driver");
         //STEP 3: Open a connection
         conn = DriverManager.getConnection(DB_URL,USER,PASS);
         stmt = conn.createStatement();
          String sql="select *from User where username='"+username+"'";
          ResultSet rs2=stmt.executeQuery(sql);
          if(rs2.next())
            re=Integer.parseInt(rs2.getString("verified"));
      }
      catch(Exception f)
      {

      }
      return re;



   }
	public static String[][] Login2(String name)
	{
		Connection conn = null;
	   	Statement stmt2 = null;
	   	Statement stmt = null;
	   	int lengt=0,i;
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		 conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      stmt2 = conn.createStatement();
	      stmt = conn.createStatement();
			String sql2="select count(*) from `Show` where number=1";
	      ResultSet rs1 = stmt.executeQuery(sql2);
	      rs1.next();
	      lengt=Integer.parseInt(rs1.getString("count(*)"));
	  	}
	  	catch(Exception asq)
	  	{

	  	}
	  	String ar[][]=new String[lengt][6];
	  	try{
	  	String sql22="select * from `Show` where number=1";
	      ResultSet rs11 = stmt2.executeQuery(sql22);
	      for(i=0;i<lengt;++i)
	      {
	      rs11.next();
	      	ar[i][0] = rs11.getString("sid");
	      	ar[i][5] = rs11.getString("ShowName");
		 	ar[i][1] = rs11.getString("timings");
		 	ar[i][2] = rs11.getString("date");
		 	ar[i][3] = rs11.getString("balcony_rate");
		 	ar[i][4] = rs11.getString("ordinary_rate");

		}
		}
		catch(Exception sd)
		{

		}
		return ar;

	}
	public static String[][] show_ticket(String name)
	{
		Connection conn = null;
	   	Statement stmt = null;
	   	Statement stmt2 = null;
	   	Statement stmt3 = null;

	   	int lengt=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
	   	
	   	conn = DriverManager.getConnection(DB_URL,USER,PASS);
	   	stmt= conn.createStatement();
	   	stmt2= conn.createStatement();
	   	stmt3= conn.createStatement();
			String sql2="select count(*) from ticket where userid ='"+name+"'";
            ResultSet rs2=stmt2.executeQuery(sql2);
            rs2.next();
            lengt=Integer.parseInt(rs2.getString("count(*)"));

        }
        catch(Exception sdf)
        {

        }
        String ar[][]=new String[lengt][8];
        try{
   		
	   
	   int i;
	   
	   
	      
            
        	
            String sql1="select *from ticket where userid='"+name+"'";
	       ResultSet rs = stmt.executeQuery(sql1);
	      for(i=0;i<lengt;++i)
		      	{
		      		
            		rs.next();
            		
		      		String tid="";
		      		String date="";
		      		String time="";
		      		String type="";
		      		String seat_id="";
		      		String showid="";
		      		
		      		tid=rs.getString("tid");
		      		 date=rs.getString("date");
		      		time=rs.getString("timing");
		      		 type=rs.getString("Type");
		      		 seat_id=rs.getString("seat_id");
		      		 showid=rs.getString("showid");
	       			String ShowName=rs.getString("ShowName");
		      		ar[i][0]=tid;
		      		ar[i][1]=seat_id;
		      		ar[i][2]=time;
		      		ar[i][3]=type;
		      		ar[i][4]=date;
		      		ar[i][5]=rs.getString("price");
		      		ar[i][6]=showid;
		      		ar[i][7]=ShowName;
		      	


	      	}
	      	

	      }
	      catch(Exception efd)
	      {

	      }
	      return ar;
	}
 	public static String[][] seats_cancel(String uname,String b[])
   	{
   		
   		String[] b1=b;
	   int i,lengt=b1.length,flag=1;
	   String ar[][]=new String[lengt][6];
	   	Connection conn = null;
      	Statement stmt = null;
	  
	   Statement stmt2 = null;
	   Statement stmt3 = null;
	   Statement stmt4 = null;
	   Statement stmt5 = null;
	   Statement stmt6 = null;
	   Statement stmt7 = null;
	   Statement stmt10 = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");
	      //STEP 3: Open a connection
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	    stmt2 = conn.createStatement();
		stmt = conn.createStatement();
		stmt3 = conn.createStatement();
		stmt4 = conn.createStatement();
		stmt5 = conn.createStatement();
		stmt6 = conn.createStatement();
		stmt7 = conn.createStatement();
		stmt10 = conn.createStatement();
		 DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
       Date dateobj = new Date();
       String dateOn=df.format(dateobj);
       
	   
	   for(i=0;i<lengt;++i)
	   		{
	   			int j=-1;
	   			try{
	   			j=Integer.parseInt(b1[i]);
	   				}
	   				catch(Exception ae)
	   					{
	   						flag=0;
	   					}
   					
					if(flag==0)break;
	   			String sql="select *from ticket where tid="+j+";";
	   			ResultSet rs= stmt.executeQuery(sql);
	   			if(!rs.next())flag=0;
	   			if(flag==0)break;

	   		}
   		if(flag==1)
   		{
   			for(i=0;i<lengt;++i)
	   		{
	   			int j=Integer.parseInt(b1[i]);
   			String sql2="select *from ticket where tid="+j+";";
	   			ResultSet rs2= stmt2.executeQuery(sql2);
	   			rs2.next();
	   			String date=rs2.getString("date");
	   			String timing=rs2.getString("timing");
	   			String showid=rs2.getString("Showid");
       			String ShowName=rs2.getString("ShowName");
	   			String seat_id=rs2.getString("seat_id");
	   			date=date+" "+timing;
	   			ar[i][0]=""+j;
	   			ar[i][1]=""+showid;
	   			ar[i][5]=""+ShowName;
	   			long lo=date_differ(dateOn,date);
	   			double amo=0;
	   			ar[i][2]=""+lo;
	   			if(lo>3)
	   			{
	   					amo=Double.parseDouble(rs2.getString("price"))-5;
   				}
   				if(lo<=3&&lo>0)
   				{
   					if(seat_id.charAt(0)=='b')
   						amo=Double.parseDouble(rs2.getString("price"))-15;
   					if(seat_id.charAt(0)=='o')
   						amo=Double.parseDouble(rs2.getString("price"))-10;
   				}
   				if(lo==0)
   					{
   						amo=Double.parseDouble(rs2.getString("price"));
   						amo=amo/2;
   					}

	   				  String sql41=" select *from User where username='"+uname+"'";
				      ResultSet rs22 = stmt3.executeQuery(sql41);
				      rs22.next();
				      double am=Double.parseDouble(rs22.getString("amount"))+amo;
					  String sql5="update User set amount="+am+" where username='"+uname+"'";
					  int imn1=stmt4.executeUpdate(sql5);
					  String sql6="delete from ticket where tid="+j+";";
				      int imn2=stmt5.executeUpdate(sql6);
				      String sql1="update Seat set register='no' where showid='"+showid+"' and id='"+seat_id+"';";
				      int imn3=stmt6.executeUpdate(sql1);
				      ar[i][3]=""+amo;
				      ar[i][4]=""+am;
	   			}
	   			

   		}
   		else
   		{
   			ar[0][0]="@";
   		}
   		}
		catch(Exception e)
		{

		}

		return ar;

   	}

	public static String[][] seats_booking2(String b1[],String b)
   	{
   	    String[] b3=b.split(" ");
	    String[] array=b1;
      	int i,lengt=array.length;
      	double amount=0,UserAmount=0;
      	char output='0';
      	int find=1;
      	String ar[][]= new String[lengt][11];
      	ar[0][10]="0";
   		String m="";
   		
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
	   Statement stmt7 = null;
	   Statement stmt8 = null;
	   //Statement stmt9 = null;
	  // Statement stmt10 = null;
	      stmt =conn.createStatement();
	      stmt2=conn.createStatement();
	      stmt3=conn.createStatement();
	      stmt4=conn.createStatement();
	      stmt5=conn.createStatement();
	      stmt6=conn.createStatement();
	      stmt7=conn.createStatement();
	      stmt8=conn.createStatement();
	   	  //stmt9=conn.createStatement();
	   	  //stmt10=conn.createStatement();
	      	if(b3[1].equals("Show_Manager"))find=0;
	      	if(find==1)
	      		ar[0][9]="1";
	      	else
	      		ar[0][9]="0";
	      	System.out.println(ar[0][9]+"hai");
	      	if(find==1)
	      	{
	      	String sql55="select *from `User` where username='"+b3[1]+"';";
	      	
		      		ResultSet rs45 = stmt.executeQuery(sql55);
		      		rs45.next();
		      		String UserAmount1=rs45.getString("amount");
		      		UserAmount=Integer.parseInt(UserAmount1);
      		}
	      	for(i=0;i<lengt;++i)
	      	{
	      			String sql44="select *from `Show` where sid='"+b3[0]+"';";
	      			//out.println(sql44+"<br>");
		      		ResultSet rs44 = stmt2.executeQuery(sql44);
		      		rs44.next();
		      		String rate1=rs44.getString("balcony_rate");
		      		String rate2=rs44.getString("ordinary_rate");
		      		String sql55="select *from Seat where register='no' and showid='"+b3[0]+"' and id='"+array[i]+"';";
		      		ResultSet rs444 = stmt3.executeQuery(sql55);
		      		if(!rs444.next())
		      		{
		      			ar[0][10]="1";
		      			break;
		      		}
		      		double rate=(array[i].charAt(0)=='o')?Double.parseDouble(rate2):Double.parseDouble(rate1);
		      		amount=amount+rate;
		      		if(find==1)
		      		{
		      		if(UserAmount <amount)
		      		{
		      			output='1';
		      			
		      			break;
		      		}
		      		}
	      	}
	      	ar[0][0]=""+output;
	      	if(output!='1')
	      	if(i==lengt)
	      	{

	      		if(find==1)
      			{

	      		String y="update `User` set amount="+(UserAmount-amount)+" where username='"+b3[1]+"';";
	      		int jjj=stmt4.executeUpdate(y);
	      		}
	      		for(i=0;i<lengt;++i)
		      	{
		      		String sql3="update `Seat` set register='yes' where id='"+array[i]+"';";
		  		
		      		
		      		int j=stmt5.executeUpdate(sql3);
		      	}
		      	int limit;
		
	
		      	for(i=0;i<lengt;++i)
		      	{

		      		String sql4="select *from ticket  order by tid desc limit 1;";
		      		ResultSet rs3 = stmt6.executeQuery(sql4);
		      		if(!rs3.next())
		      		{
		      			limit=1;
		      		}
		      		else
		      		{
		      			limit=Integer.parseInt(rs3.getString("tid"));
		      			limit++;
		      		}
		      		String sql5="select *from `Show` where sid='"+b3[0]+"';";
		      		ResultSet rs4 = stmt7.executeQuery(sql5);
		      		rs4.next();
		      		String date=rs4.getString("date");
		      		String time=rs4.getString("timings");
		      		String showid=rs4.getString("sid");
		      		String ShowName=rs4.getString("ShowName");
		      		String type;
		      		double rate;
		      		String rate1=rs4.getString("balcony_rate");
		      		String rate2=rs4.getString("ordinary_rate");
		      		rate=(array[i].charAt(0)=='o')?Double.parseDouble(rate2):Double.parseDouble(rate1);
		      		if(find==0)rate=0;
		      		if(array[i].charAt(0)=='o')type="ordinary";
		      		else  type="balcony";
		      		String sql6="insert into ticket values ('"+limit+"','"+array[i]+"','"+time+"','"+type+"','"+date+"',"
		      		+rate+",'"+b3[1]+"','"+b3[0]+"','"+ShowName+"')";
		      		int jj=stmt8.executeUpdate(sql6);
		      		ar[i][0]=""+output;
		      		ar[i][1]=""+limit;
		      		ar[i][2]=""+array[i];
		      		ar[i][3]=""+time;
		      		ar[i][4]=""+type;
		      		ar[i][5]=""+date;
		      		ar[i][6]=""+rate;
		      		ar[i][7]=""+b3[1];
		      		ar[i][8]=""+ShowName;
		      		ar[i][9]=""+'1';
	      	}
      	}
		}
		catch(Exception e)
		{

		}
		return ar;
	}
   	public static String seats_booking(String b)
   	{
   		String m="";
   		try{
   		Class.forName("com.mysql.jdbc.Driver");
	   	Connection conn = null;
	   	conn = DriverManager.getConnection(DB_URL,USER,PASS);
      	Statement stmt = null;
	    stmt = conn.createStatement();

	    String[] b1=b.split(" ");
	      String sql1="select * from `Seat` where register='no' and showid='"+b1[0]+"'";
	      ResultSet rs = stmt.executeQuery(sql1);

	      int i,j=1;
	      
	      	for(i=0;rs.next();++i)
	      	{
	      		//if((i%10)==0&&i!=0)
	      		
	      		String a1 = rs.getString("id");
	      		m=m+a1+" ";
	      		
	      		
			}
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{

		}

		return m;

   	}

	   
      

}