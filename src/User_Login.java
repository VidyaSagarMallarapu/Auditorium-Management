import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.*;
import javax.servlet.*;
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class User_Login extends HttpServlet {
   
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name=request.getParameter("uname");
        String pwd=request.getParameter("password");
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
			out.println("#footer {");
			out.println("    background-color:	 #3333ff;");
			out.println("   color:white;");
			out.println("   clear:both;");
			out.println("    text-align:center;");
			out.println("    margin-top:200px;");
			out.println("   padding:5px;");	 	 
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
			
 
        if(name.equals("")||pwd.equals(""))
        {
        	request.setAttribute("message", "error Login");
        	//request.setAttribute("error","Invalid Username/password");
		response.sendRedirect("index5.html");

        }
	   try{
	  		
	      Manager m=new Manager();
	  	  int y=m.Login("User",name,pwd);
	      if(y==1)
	      {
	      	User u=new User();
	      	int verified=u.know_Verified(name);
	      	if(verified==0)
      		{
	      		out.println("<div align=\"center\" >");
				out.println("<h2>Sorry! the SalesPerson not verified you!!<br> ");
			}
			else
			{
        	out.println("<form action=\"User_Login2\" method=\"post\">");
		     out.println("<button type=\"submit\" name=\"book_show\" value=\""+name+"\">book_show</button>");
		    out.println("</form>");
		    out.println("<form action=\"User_show_ticket\" method=\"post\">");
		     out.println("<button type=\"submit\" name=\"ticket_details\" value=\""+name+"\">ticket_details</button>");
		    out.println("</form>");
		    }
		}
	      	//out.printf("show id : %-20s show timeing :%-20s how name :%-20s<br>",a1,a2,a3);
			//login page

		
		
		else 
		{
			out.println("not registerd plase  <a href=\"User_Register.html\">Registation here</a><br> ");

	        

			//registartiinpage
		}
	      out.println("    </div>");
			
	   out.println("    <div id=\"footer\">");
			out.println("    Copyrights @SAMS Software");
			out.println("    </div>"); 
			out.println("</body>");
          out.println("</html>");
        
	      //STEP 6: Clean-up environment
	 
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }/*finally{
	      //finally block used to close resources
	      try{
		 if(stmt!=null)
		    stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
		 if(conn!=null)
		    conn.close();
	      }catch(SQLException se){
		 se.printStackTrace();
	      } *///end finally try  
	   //}//end try
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
