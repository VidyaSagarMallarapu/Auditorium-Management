import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Clerk_Login extends HttpServlet {

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
	   	int g=m.Login("clerk",name,pwd);
      if(g==1)
      {
		

	      String ar[][]=m.Show_details();
	      int i,lengt=ar.length;
	      out.println("<div align=\"center\" style=\"margin-top: 100px;\"><br><br><br>");
      	out.println("<table border=\"1\"background=\"1.jpg\">");

	      
	      out.println("<tr>");
	      out.println("<td>   Show name</td>");
		 	out.println("<td> Show Timing </td>");
		 	out.println("<td> Show date </td>");
		 	out.println("<td> balcony rate </td>");
		 	out.println("<td> ordinary rate </td>");
		 	out.println("<td> enter all expenditures </td>");
		 	out.println("<td> enter to balance sheet</td>");

		 	out.println("</tr>");


	      for(i=0;i<lengt;++i)
	      {
	      		if(ar[i][6].equals("0"))
	      		{
      				out.println("<tr>");
				 	out.println("<td>"+ar[i][5]+"</td>");
				 	out.println("<td>"+ar[i][1]+"</td>");
				 	out.println("<td>"+ar[i][2]+"</td>");
				 	out.println("<td>"+ar[i][3]+"</td>");
				 	out.println("<td>"+ar[i][4]+"</td>");
				 	out.println("<td>");
				 	out.println("<form action=\"Clerk_Balance\" method=\"POST\">");
				 	out.println("<br>enter :  <input type=\"text\" name=\"ex\" size=\"20px\"> <br>");
				    out.println("</td>");
				    out.println("<td>");
					out.println("<button type=\"submit\" name=\"delete\" value=\""+ar[i][0]+"\">submit</button>");
					out.println("</form>");
					out.println("</td>");
				 	out.println("</tr>");
			 	}
		
		}
    
		 	
	      	//out.printf("show id : %-20s show timeing :%-20s how name :%-20s<br>",a1,a2,a3);
			//login page

		
		
	      
		}
	else 
		{
			out.println("<div align=\"center\" >");
			out.println("<h3>access denided</h3>\n");
		}
	      out.println("    </div>");
			out.println("</body>");
          out.println("</html>"); 
	    
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
