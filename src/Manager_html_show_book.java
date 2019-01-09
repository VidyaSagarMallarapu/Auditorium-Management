
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
public class Manager_html_show_book extends HttpServlet 
  {

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
            out.println("    margin-top:140px;");
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
            out.println("<title>User booking</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("    <div id=\"header\">");
            out.println("    <h1>Student Auditorium Management Software</h1>");
            out.println("    </div>");
    out.println("<div align=\"center\"><br><br><br>");
      out.println("<body >");
      String a1=request.getParameter("sid");
        String a2=request.getParameter("timings");
        String a3=request.getParameter("no_of_balcony_seats");
     
        String a4=request.getParameter("no_of_ordinary_seats");
        String a5=request.getParameter("date");
        String a6=request.getParameter("balcony_rate");
        String a7=request.getParameter("ordinary_rate");
        String a8=request.getParameter("ShowName");
        String username="";//(String) request.getSession().getAttribute("temp");
        Manager m=new Manager();
        if(null !=  request.getSession().getAttribute("temp"))
        {
        	username=(String)(String) request.getSession().getAttribute("temp");
        }
          if (request.getParameterMap().containsKey("sid")) 
            {
            	int temp=-1;
               temp=m.Show_book(a1,a2,a3,a4,a5,a6,a7,a8);
           if(temp==0)
           {

            out.println("<h3 style=\"color:green\">registered show successfully</h3><br> ");
            }
            else
            {
                
             String mm=""+temp;
              request.getSession().setAttribute("temp",mm);
                response.sendRedirect("Manager_html_show_book");
                
            }
        }
        else
        {


             if(username.equals("11"))
            out.println("<p style=\"color:red\">  * enter all fields correctly ");
            out.println("<br>");
         out.println("<form action=\"Manager_html_show_book\" method=\"POST\">");
            out.println(" <input type=\"text\" name=\"sid\" placeholder=\"Show id\" size=\"20px\" >");
            if(username.equals("1"))
            out.println("<p style=\"color:red\"> * enter username without space ");
            if(username.equals("9"))
            out.println(" <p style=\"color:red\"> * showid already exist please try with another ");
            out.println("<br>");
             out.println("<input type=\"text\" name=\"ShowName\" placeholder=\"show name\" size=\"20px\" > ");
            out.println("<br>");
             out.println("<input type=\"text\" name=\"timings\" placeholder=\"time ex:01:00:00\" size=\"20px\" > ");
             if(username.equals("2"))
            out.println("<p style=\"color:red\">  * enter time correctly ");
            out.println("<br>");
             out.println("<input type=\"text\" name=\"no_of_balcony_seats\"  placeholder=\" no_of_balcony_seats\" size=\"20px\" > ");
             if(username.equals("4"))
            out.println("<p style=\"color:red\">  * please enter number for balcony ");
            out.println("<br>");
             out.println("<input type=\"text\" name=\"no_of_ordinary_seats\" placeholder=\"no_of_ordinary_seat \" size=\"20px\" > ");
             if(username.equals("5"))
            out.println(" <p style=\"color:red\"> * please enter number for ordinary");
        out.println("<br>");
             out.println("<input type=\"text\" name=\"date\" placeholder=\"date ex:01/02/2018\" size=\"20px\" >");
             if(username.equals("6"))
            out.println("<p style=\"color:red\">  * please enter Date format correctly ");
        if(username.equals("10"))
            out.println("<p style=\"color:red\"> * please enter date of next days ,not past days ! ");
        out.println("<br>");
             out.println("<input type=\"text\" name=\"balcony_rate\" placeholder=\"balcony ticket rate\" size=\"20px\" >");
             if(username.equals("7"))
            out.println("<p style=\"color:red\">  * please enter correct amount for balcony");
        out.println("<br>");
             out.println("<input type=\"text\" name=\"ordinary_rate\" placeholder=\"ordinary ticket rate\" size=\"20px\" > ");
             if(username.equals("8"))
            out.println(" <p style=\"color:red\"> * please enter correct amount for ordinary");
        out.println("<br><br>");
             out.println("<input style=\"border-radius:15px;width:150px;height:30px;background-color:lightgray\" type=\"submit\" value=\"Register Show\">");
 		out.println("</form>");
        }
        out.println("</div>");
        
    out.println("<div id=\"footer\">");
    out.println("Copyright@SAMS Software");
    out.println("</div>");
out.println("</body>");
out.println("</html>");
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