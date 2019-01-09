import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class User_Reg extends HttpServlet {


   
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
            

	   try{

	      	String a1=request.getParameter("username");
        	String a2=request.getParameter("password2");
        	String a3=request.getParameter("Acc_no");
        	String a4=request.getParameter("name");
        	String a5=request.getParameter("SalesPersonId");
        	User u=new User();
        	int flag=u.Register(a1,a2,a3,a4,a5);
        		if(flag==1)
        		response.sendRedirect("User_Register.html");
        	out.println("<div align=\"center\" >");
        		if(flag==2)
		      		out.println("Invalid Sales Person Id  <a href=\"User_Register.html\">Registation here</a><br> ");	
		      		
			if(flag==3)
            {
            chat c=new chat();
            c.insert_chat(a5+" "+a1+" 1","Hellow sir i had registerd under you sir plase approve me sir !!!.");

        	out.println("registered successfully<br> ");
            }
    		if(flag==4)
			out.println("Invalid Registation (User already exist) <a href=\"User_Register.html\">Registation here</a><br> ");
			
		
	      
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
