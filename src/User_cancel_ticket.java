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
import java.util.Date;
import java.text.*;
public class User_cancel_ticket extends HttpServlet {

		

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            	try{
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
			out.println("<title>User Cancel Tickets</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("    <div id=\"header\">");
			out.println("    <h1>Student Auditorium Management Software</h1>");
			out.println("    </div>");
			out.println("    <div>"); 
        	out.println("<div align=\"center\" >");
	   String uname = request.getParameter("button");
       String b[]= request.getParameterValues("array");
      	User u=new User();
      	String arr[][]=u.seats_cancel(uname,b);
      	int lengt=arr.length,i;
      	if(lengt==0)out.println("<h3>no ticket selected</h3>");
      	for(i=0;i<lengt;++i)
	   		{
	   			
	   		if(arr[0][0].equals("@"))
	   		{
	   			out.println("<h3>You entered ticket ids are wrong <h3><br>");
	   			break;
	   		}
	   		out.println("<h2>ticket id :"+arr[i][0]+" show name  :"+arr[i][5]+"</h2><br>");
	   		out.println("days left :"+arr[i][2]+"<br>");
	   		out.println("for You amount :"+arr[i][3]+"  added  and total amount="+arr[i][4]+"<br>");

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
