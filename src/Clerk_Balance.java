import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Clerk_Balance extends HttpServlet 
{
    public static boolean me(String a)
    {
        try
        {
            double df=Double.parseDouble(a);
            return true;
        }
        catch(Exception dd)
        {
            return false;
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String dob=request.getParameter("ex");
        
        String show=request.getParameter("delete");

        boolean find=me(dob);
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
            out.println("<title>Clerk balance</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("    <div id=\"header\">");
            out.println("    <h1>Student Auditorium Management Software</h1>");
            out.println("    </div>");
            out.println("    <div>");
	   try{

	   	if(find==false)
            {
                out.println("<div align=\"center\" >");
                out.println("enter number not String !!");
            }
        else
        {
        double price=Double.parseDouble(dob);
    	Clerk c=new Clerk();
    	int y=c.balance(show,price);
    	if(y==1)out.println("Successfully inserted !<br>");	
    	else out.println("not inserted !<br>");
	      out.println("    </div>");
            
       out.println("    <div id=\"footer\">");
            out.println("    Copyrights @SAMS Software");
            out.println("    </div>"); 
            out.println("</body>");
          out.println("</html>");
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
