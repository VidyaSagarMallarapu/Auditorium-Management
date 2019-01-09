
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;  
import javax.*;
import java.lang.*;
import java.sql.*;
public class User_booking2 extends HttpServlet {


   
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
	   		out.println("<div align=\"center\" ><br><br><br>");
	   try{
	   	
	      String b1[]=request.getParameterValues("array");
	      String b = request.getParameter("button");
	      User u=new User();
	      String[] b3=b.split(" ");
	      String ar[][]=u.seats_booking2(b1,b);
	      int lengt=ar.length;
      		
      		if(ar[0][10].equals("1"))
      		{

      		out.println("Registation failerd due to  seat numbers you entered wrong <br>");

      		}
	      	else if(ar[0][0].equals("1")&&!ar[0][9].equals("0"))
	      	{
	      		out.println("<form action=\"User_booking\" method=\"post\">");
      			out.println("<h3>your amount is not sufficient to book <h3><br>");
     			out.println("<button type=\"submit\" name=\"button\" value=\""+b+"\">re_enter_details</button>");
    			out.println("</form>");
	      	}
	      			
	      	else 
	      	{
	      		

		      	out.println("<table border=\"1\"background=\"1.jpg\">");
	      		out.println("<tr>");
			      out.println("<td>   "+"ticket id"+" </td>");
				  out.println("<td>   "+"seat number"+" </td>");
				  out.println("<td>   "+"  time  "+" </td>");
				  out.println("<td>   "+"seat type"+" </td>");
				  out.println("<td>   "+"date"+" </td>");
				  out.println("<td>   "+"price"+" </td>");
				  out.println("<td>   "+"User name"+" </td>");
				  out.println("<td>   "+"show Name"+" </td>");
				out.println("</tr>");
		
					int i;
		      	for(i=0;i<lengt;++i)
		      	{

		      		
		      		String date=ar[i][5];
		      		String time=ar[i][3];
		      		String type=ar[i][4];
		      		String limit=ar[i][1];
		      		String seatNo=ar[i][2];
		      		String ShowName=ar[i][8];
		      		String rate=ar[i][6];

			      out.println("<tr>");
			      out.println("<td>   "+limit+" </td>");
				  out.println("<td>   "+seatNo+" </td>");
				  out.println("<td>   "+time+" </td>");
				  out.println("<td>   "+type+" </td>");
				  out.println("<td>   "+date+" </td>");
				  out.println("<td>   "+rate+" </td>");
				  out.println("<td>   "+b3[1]+" </td>");
				  out.println("<td>   "+ShowName+" </td>");
		 	out.println("</tr>");


	      	}
	      	
	      	out.println("<h2><br>successfully booked tickets</h2><br><br>");
      	}
	     	out.println("    </div>");
			

          out.println("</html>"); 
	      	
		}
		catch(Exception e){
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

	