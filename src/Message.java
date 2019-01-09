import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import java.util.*;
//import javax.*;
import javax.servlet.*;
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.*;
public class Message extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
	   try{
	   		
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
            out.println("<title>SAMS Software</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("    <div id=\"header\">");
            out.println("    <h1>Student Auditorium Management Software</h1>");
            out.println("    </div>");
            out.println("    <div>");
            String uname=request.getParameter("uname");
            chat c=new chat();

            String a[]=c.show_Sales();
            int l=a.length,i=0;
            if(l==0)out.println("sorry no sales Person exist");
            else
            {
            out.println("<h2>Sales Persons</h2>");
            for(i=0;i<l;++i)
            {
        	 out.println("<form action=\"Message_SalesPerson\" method=\"post\">");
             int ln=c.user_number(a[i],a[i],uname);
             //out.println(a[i]+" "+a[i]+" "+uname+"<br>");
		     out.println("<button type=\"submit\" name=\"Sale\" value=\""+a[i]+" "+uname+" "+"1"+"\">"+a[i]+"</button>"+":"+ln);
		    out.println("</form>");
            out.println("    </div>");
            out.println("</body>");
          out.println("</html>");
            }
	       }
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
