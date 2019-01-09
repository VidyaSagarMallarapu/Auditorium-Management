import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.servlet.*;  
import javax.*;
import java.sql.*;

public class User_booking extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name=request.getParameter("uname");
        String pwd=request.getParameter("password");
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
            out.println("#footer {");
            out.println("    background-color:   #3333ff;");
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
            //out.println("<div align=\"center\" >");
	   
	   try{
	      String b = request.getParameter("button");
	      int i=0,j=1,w=0;
	      User u=new User();
	      String k=u.seats_booking(b);
	      String []b1=k.split(" ");
          if(b1.length==0)
            out.println("<h3>All Seats are booked !<h3>");
        else
        {
	      for(i=0;i<b1.length;++i)
	      	{	
	      		if((w%10)==0&&w!=0)
	      			{
	      				out.println("<br><br>");
	      			}
	      		
	      		
			
            out.println("<form action=\"User_booking2\" method=\"post\">");
	      if(b1[i].charAt(0)=='o'&&j==1)
	      {j=0;w=0;out.println("<br><br><br><br>");}

	      		out.println(b1[i]+"<input type=\"checkbox\" name=\"array\" value=\""+b1[i]+"\" >"+"     ");
      		w++;
	      	}
    	 		
            out.println("<br><br><br><br>");
		     out.println("<button type=\"submit\" name=\"button\" value=\""+b+"\">submit details</button>");
        	out.println("</form>");
	     	out.println("    </div>");
            }
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
