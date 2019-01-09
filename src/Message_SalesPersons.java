import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.*;
import javax.servlet.*;
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Message_SalesPersons extends HttpServlet {
   
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name=request.getParameter("uname");
        String pwd=request.getParameter("password");
        String pwd1=request.getParameter("hello");
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
			out.println("<div align=\"center\" >");
			Manager m=new Manager();
	  	 int y=-1;
	  	 if(request.getParameterMap().containsKey("uname"))
	  	 {
	  	 y=m.Login("SalesPerson",name,pwd);
	  	 if(y==1)
	      {


		   	out.println("<form action=\"Message_SalesPersons\" method=\"post\">");
		     out.println("<button type=\"submit\" name=\"approve\" value=\""+name+"\">Approve users</button>");
		    out.println("</form>");
        	out.println("<form action=\"Message_SalesPersons\" method=\"post\">");
		     out.println("<button type=\"submit\" name=\"hello\" value=\""+name+"\">chat with Users</button>");
		    out.println("</form>");
		   
		    
		}
		else
		{
			out.println("<h2>Sorry! You do not have permission !!<br> ");
		}
	  	}
			if (request.getParameterMap().containsKey("approveClicked")) 
                {
                	SalesPerson ss=new SalesPerson();
                	ss.approve_User2(request.getParameter("approveClicked"));
                	out.println("<h2> Successfully approved the User</h2><br>");
            	}

    	

     if (request.getParameterMap().containsKey("approve")) 
                {
                	String approve=request.getParameter("approve");
                	SalesPerson sn=new SalesPerson();
                	String arr[]=sn.approve_User(approve);
                	int l=arr.length;
                	int i=0;
                	//out.println(approve+"m :"+l+"<br>");
                	if(l==0)
                		out.println("<br><br><h3>No User exist to approve by you !!</h3><br><br>");
                	
                	else
                		out.println("<br><br><h3>click on user to approve then he will be approved !!</h3><br><br>");
                	for(i=0;i<l;++i)
                	{

        		out.println("<form action=\"Message_SalesPersons\" method=\"post\">");
		     	out.println("<button type=\"submit\" name=\"approveClicked\" value=\""+arr[i]+"\">"+arr[i]+"</button>");
		    	out.println("</form>");
                	}

            	}
	    
        try{
        if (request.getParameterMap().containsKey("hello")) 
                {
                	int i;
                    SalesPerson s=new SalesPerson();
                    String ar[]=s.show_User(pwd1);
                    int l=ar.length;
                    chat c=new chat();

                    if(l==0)out.println("No User exist !..<br>");
                    for(i=0;i<l;++i)
		            {
		            		 int ll=c.user_number(ar[i],pwd1,ar[i]);
		            		 //out.println(ar[i]+" "+pwd1+" "+ar[i]+"<br>");
				     	   	 out.println("<form action=\"Message_SalesPerson\" method=\"post\">");
						     out.println("<button type=\"submit\" name=\"Sale\" value=\""+pwd1+" "+ar[i]+" 0\">"+ar[i]+"</button>"+":"+ll);
						    out.println("</form>");
		            }
                }
	   
	  		

		out.println("    </div>");
            
  
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
