import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Manager_Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
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
			

	   
	   try{
	   	Manager m=new Manager();
	   	int g=m.Login("ShowManger",name,pwd);
	   	out.println("<div align=\"center\" ><br><br>");

      if(g==1)
      {
		out.println("<form action=\"Manager_html_show_book\" method=\"POST\">");
		out.println("<input style=\"border-radius:15px;width:150px;height:30px;background-color:lightgray\" type=\"submit\" value=\"book show\">");
		out.println("</form>");

		out.println("<form action=\"Manager_show_details\" method=\"POST\">");
		out.println("<input style=\"border-radius:15px;width:150px;height:30px;background-color:lightgray\" type=\"submit\" value=\"show details\">");
		out.println("</form>");

		out.println("<form action=\"Manager_previous_show_details\" method=\"POST\">");
		out.println("<input style=\"border-radius:15px;width:200px;height:30px;background-color:lightgray\" type=\"submit\" value=\"previous show details\">");
		out.println("</form>");

		out.println("<br><br><br><h2>Sales Person Register</h2>");
		out.println("<form action=\"Manager_SalesPerson\" method=\"POST\">");
		out.println("<input type=\"text\" name=\"username\" placeholder=\"username\" size=\"20px\" > <br>");
		out.println("<input type=\"password\" name=\"password\" placeholder=\"password\" size=\"20px\" > <br>");
		out.println("<input type=\"text\" name=\"name\" placeholder=\"full name\" size=\"20px\" > <br><br>");
		     out.println("<button style=\"color=\"green\"\"type=\"submit\" name=\"SalesPerson\" value=\""+name+"\">Register SalesPerson</button>");
		    out.println("</form>");
	    out.println("<br><br><br><br><h2>Clerk  Register</h2>");
	    out.println("<form action=\"Manager_Clerk\" method=\"POST\">");
	    out.println("<input type=\"text\" name=\"username\" placeholder=\"username\" size=\"20px\" > <br>");
		out.println("<input type=\"password\" name=\"password\" placeholder=\"password\" size=\"20px\" > <br>");
		out.println("<input type=\"text\" name=\"name\" placeholder=\"full name\" size=\"20px\" > <br><br>");
		     out.println("<button type=\"submit\" name=\"Clerk\" value=\""+name+"\">Register Clerk</button>");
		    out.println("</form>");

		}

	else {
			out.println("<div align=\"center\" >");
			out.println("<h2>Sorry! You do not have permission !!<br> ");
		}
		out.println("    </div>");
			
	   out.println("    <div id=\"footer\">");
			out.println("    Copyrights @SAMS Software");
			out.println("    </div>"); 
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
