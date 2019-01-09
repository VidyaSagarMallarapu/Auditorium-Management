import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Manager_show_percentage extends HttpServlet {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   	static final String DB_URL = "jdbc:mysql://localhost:3306/SAMS";
   //  Database credentials
   	static final String USER = "root";
   	static final String PASS = "dbms";
   
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
    
            
        try{
        	String a1=request.getParameter("sid");
        	Manager m=new Manager();
        	String ar[]=m.percentage(a1);
        	int b=Integer.parseInt(ar[5]),o=Integer.parseInt(ar[4]);
       		double b1=Double.parseDouble(ar[0]),o1=Double.parseDouble(ar[1]),b_price=Double.parseDouble(ar[2]),o_price=Double.parseDouble(ar[3]);
	       	
          out.println("<form action=\"Manager_show_details\" method=\"POST\">");       
          out.println("<button type=\"submit\" name=\"button\">go back</button>");
          out.println("</form>");
          out.println("<button onclick=\"window.location.href='index1.html'\">Log out</button>");
          out.println("<div align=\"center\" style=\"margin-top: 100px;\">");
          out.println("<h2 style=\"color:red\"> "+ar[6]+"</h2>");
      		out.println("<table border=\"1\"background=\"1.jpg\">");
      		out.println("<tr>");
      		out.println("<td> percentage of balcony booked </td>");
      		out.println("<td> percentage of ordinary booked </td>");
      		out.println("<td> money got for balcony  </td>");
      		out.println("<td>  money got for ordinary </td>");
      		out.println("</tr>");
      		out.println("<tr>");
      		if(b!=0)
      		out.println("<td> "+((b1/(b*1.0))*100)+" %</td>");
      		else
      		out.println("<td> "+(100 )+" %</td>");
      		if(o!=0)
      		out.println("<td> "+((o1/(o*1.0))*100)+" %</td>");
      		else
      		out.println("<td> "+(100 )+" %</td>");
      		out.println("<td> "+b_price+" </td>");
      		out.println("<td> "+o_price+"</td>");
      		out.println("</tr>");
	       out.println("    </div>");
      
     //out.println("    <div id=\"footer\">");
      //out.println("    Copyrights @SAMS Software");
      //out.println("    </div>"); 
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
