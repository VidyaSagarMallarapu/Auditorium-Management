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

public class User_show_ticket extends HttpServlet {

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
            out.println("    background-color:   #3333ff;");
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
            out.println("    <div>");
            out.println("<div align=\"center\" >");
	   try{

	      String name=request.getParameter("ticket_details");
	      User u=new User();
	      String ar[][]=u.show_ticket(name);
            int find=0,i,lengt=ar.length;
            if(lengt==0)
            {
                out.println("till now you have not booked any ticket !!");
            }
            else
            {
          out.println("<form action=\"User_cancel_ticket\" method=\"POST\">");
            out.println("<table border=\"1\"background=\"1.jpg\"><br><br><br>");
            out.println("<tr>");
			      out.println("<td>   "+"ticket id"+" </td>");
				  out.println("<td>   "+"seat number"+" </td>");
				  out.println("<td>   "+"  time  "+" </td>");
				  out.println("<td>   "+"seat type"+" </td>");
				  out.println("<td>   "+"date"+" </td>");
				  out.println("<td>   "+"price"+" </td>");
				  out.println("<td>   "+"show name"+" </td>");
                  out.println("<td>   "+"click ok to cancel"+" </td>");
				out.println("</tr>");
	      for(i=0;i<lengt;++i)
	      	{
		      		

		      		
			      out.println("<tr>");
			      out.println("<td>   "+ar[i][0]+" </td>");
				  out.println("<td>   "+ar[i][1]+" </td>");
				  out.println("<td>   "+ar[i][2]+" </td>");
				  out.println("<td>   "+ar[i][3]+" </td>");
				  out.println("<td>   "+ar[i][4]+" </td>");
				  out.println("<td>   "+ar[i][5]+" </td>");
				  out.println("<td>   "+ar[i][7]+" </td>");
                  out.println("<td>");
                  out.println("<input type=\"checkbox\" name=\"array\" value=\""+ar[i][0]+"\" >"+"     ");
				  out.println("</td>");
		 	out.println("</tr>");


	      	}
            out.println("    </div>");
            out.println("<button type=\"submit\" name=\"button\" value=\""+name+"\">submit cancel tickets</button>");
       	  out.println("</form>");
             }
            out.println("</body>");
          out.println("</html>");
        
	   
	   }catch(Exception e){
	      //Handle errors for Class.forName
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
