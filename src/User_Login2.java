import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.*;
import javax.servlet.*;
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class User_Login2 extends HttpServlet {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   	static final String DB_URL = "jdbc:mysql://localhost/SAMS";
   //  Database credentials
   	static final String USER = "root";
   	static final String PASS = "dbms";
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();

            out.println("<html>");
			out.println("<style type=\"text/css\">");
			out.println("#header {");
			out.println("    background-color:	 #3333ff;");
			out.println("    color:white;");
			out.println("    text-align:center;");
			out.println("    padding:15px;");
			out.println("}");
			out.println("#section {");
			out.println("    background-color:#6600cc;");
			out.println("    color:white;");
			out.println("    text-align:left;");
			out.println("    padding:0px;");
			out.println("}");
			out.println("#aside");
			out.println("{");
			out.println("   background-color:white;");
			out.println("   margin-right:130px; ");
			out.println("}");
			out.println("</style>");
			out.println("<head>");
			out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
			out.println("<title>Narasimha Kotapuri</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("    <div id=\"header\">");
			out.println("    <h1>Student Auditorium Management Software</h1>");
			out.println("    </div>");
			out.println("<div align=\"center\" >");

	   try{

		

		//out.println("User Name: "+first+" Password: "+last+"<br>");
		 String name=request.getParameter("book_show");
		User u=new User();
		String ar[][]=u.Login2(name);
      	out.println("<table border=\"1\"background=\"1.jpg\">");
      	int i,len=ar.length;
	  
	      out.println("<tr>");
	      out.println("<td>   Show name </td>");
		 	out.println("<td> Show Timing </td>");
		 	out.println("<td> show date </td>");
		 	out.println("<td> balcony_rate </td>");
		 	out.println("<td> ordinary_rate </td>");
		 	out.println("<td> book tickets </td>");
		 	out.println("</tr>");

		 	Clerk ck=new Clerk();
 		for(i=0;i<len;++i)
	      {
	 		ck.setNumber(ar[i][0]);
 			}
 			ar=u.Login2(name);
 			len=ar.length;
	      for(i=0;i<len;++i)
	      {
	      	out.println("<tr>");
		 	out.println("<td>"+ar[i][5]+"</td>");
		 	out.println("<td>"+ar[i][1]+"</td>");
		 	out.println("<td>"+ar[i][2]+"</td>");
		 	out.println("<td>"+ar[i][3]+"</td>");
		 	out.println("<td>"+ar[i][4]+"</td>");
		 	out.println("<td>");
		    
        	out.println("<form action=\"User_booking\" method=\"GET\">");
		     out.println("<button type=\"submit\" name=\"button\" value=\""+ar[i][0]+" "+name+"\">register</button>");
		    out.println("</form>");
		    out.println("</td>");
		    out.println("</tr>");

		}
       
	
	      out.println("</body>");
            out.println("</html>");
        
	   }catch(Exception e){
	      e.printStackTrace();
	   }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
} 
