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

public class Manager_show_details extends HttpServlet {

   
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
			
        
	   
	   try{

	   	Manager m=new Manager();
	      	//out.printf("show id : %-20s show timeing :%-20s how name :%-20s<br>",a1,a2,a3);

	      String ar[][]=m.Show_details();
	      int i,lengt=ar.length;
	      
	      out.println("<div align=\"center\" >");
      	out.println("<table border=\"1\"background=\"1.jpg\"><br><br><br><br><br>");

	      
	      out.println("<tr>");
	      out.println("<td>   Show name</td>");
		 	out.println("<td> Show Timing </td>");
		 	out.println("<td> Show date </td>");
		 	out.println("<td> balcony rate </td>");
		 	out.println("<td> ordinary rate </td>");
		 	out.println("<td> delete show </td>");
		 	out.println("<td> Book Seats for VIPS</td>");
		  	out.println("<td>");
		 	out.println("percentage of seats booked and price");
		 	out.println("</td>");

		 	out.println("</tr>");

		 	Clerk ck=new Clerk();
		 	for(i=0;i<lengt;++i)
		 	{
	   		ck.setNumber(ar[i][0]);
		 	}

	      for(i=0;i<lengt;++i)
	      {
	      	if(ar[i][6].equals("1"))
	      	{
			 	out.println("<td>"+ar[i][5]+"</td>");
			 	out.println("<td>"+ar[i][1]+"</td>");
			 	out.println("<td>"+ar[i][2]+"</td>");
			 	out.println("<td>"+ar[i][3]+"</td>");
			 	out.println("<td>"+ar[i][4]+"</td>");
			 	out.println("<td>");
			 	out.println("<form action=\"Manager_show_delete\" method=\"POST\">");
				out.println("<button type=\"submit\" name=\"delete\" value=\""+ar[i][0]+"\">delete</button>");
				out.println("</form>");
				out.println("</td>");
				out.println("<td>");
				out.println("<form action=\"User_booking\" method=\"POST\">");
				out.println("<button type=\"submit\" name=\"button\" value=\""+ar[i][0]+" "+"Show_Manager"+"\">book seats</button>");
				out.println("</form>");
				out.println("</td>");
				out.println("<td>");
				out.println("<form action=\"Manager_show_percentage\" method=\"POST\">");
				out.println("<button type=\"submit\" name=\"sid\" value=\""+ar[i][0]+"\">know details</button>");
				out.println("</form>");
				out.println("<td>");
			 	out.println("</tr>");
		 	}
		 
		}out.println("</div>");
    
		 	
	      	//out.printf("show id : %-20s show timeing :%-20s how name :%-20s<br>",a1,a2,a3);
			//login page

		
		//out.println("    <div id=\"footer\">");
		//	out.println("    Copyrights @SAMS Software");
		//	out.println("    </div>"); 
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
		    stmt.close	      }catch(SQLException se2){
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
