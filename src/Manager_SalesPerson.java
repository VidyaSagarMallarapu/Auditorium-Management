import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Manager_SalesPerson extends HttpServlet {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   	static final String DB_URL = "jdbc:mysql://localhost:3306/SAMS";
   //  Database credentials
   	static final String USER = "root";
   	static final String PASS = "dbms";
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String uid=request.getParameter("SalesPerson");
        PrintWriter out = response.getWriter();

	   Manager m=new Manager();
	   int temp=m.SalesPerson(username,password,name,uid);
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
            out.println("<div align=\"center\" >");
	   try{
	      
          if(temp==1)
          out.println("registered Sales Person successfully<br> ");
         else if(temp==2)
            out.println("User already exist !!");
         else out.println("enter the details fully!");
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
