import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet
{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        out.println("<head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'></head>"); 
        out.println("</br></br></br><h1 style='text-align:center'>Employees Details</h1>"); 
        String sname=request.getParameter("username");
        
        Emp e=EmpDao.getEmployee(sname);
        
       out.print("<body background='p4.jpg' style='background-repeat:no-repeat;background-size:100% 100%' bgcolor='tomato'>"); 
       out.print("<form  action='DeleteServlet?username="+e.getName()+"' method='post'>"); 
       out.print("<p style='padding-left: 180px;'><input class='btn btn-primary' type='submit' value='Ddelete Account'/></p>");
       out.print( "</form>");
      
       out.print("<form action='LogoutServlet' method='get'>");
       out.print("<table align='center'>"); 
       out.print("<tr><td><div class='col-md-3 col-md-offset-3'> <label for='name'>ID:</label></div></td><td><div class='col-md-12'><input type='text' class='form-control id=name name='id' value='"+e.getId()+"'></div></td></tr>");
       out.print("<tr><td><div class='col-md-3 col-md-offset-3'> <label for='name'>Name:</label></div></td><td><div class='col-md-12'><input type='text' class='form-control id='name' name='name' value='"+e.getName()+"'></div></td></tr>");
       out.print("<tr><td><div class='col-md-3 col-md-offset-3'> <label for='password'>Password:</label></div></td><td><div class='col-md-12'><input type='password' class='form-control id='password' name='password' value='"+e.getPassword()+"'></div></td></tr>");
       out.print("<tr><td><div class='col-md-3 col-md-offset-3'> <label for='email'>Email:</label></div></td><td><div class='col-md-12'><input type='email' class='form-control id='email' name='email' value='"+e.getEmail()+"'></div></td></tr>");
       out.print("<tr><td><div class='col-md-3 col-md-offset-3'> <label for='country'>Country:</label></div></td><td><div class='col-md-12'><select class='form-control' id='country' name='country' style='width:150px'><option>India</option><option>USA</option><option>UK</option><option>Other</option></select> </div></td></tr>");
       
      /* out.print("<tr><td>Id</td><td><input type='text' name='id' value='"+e.getId()+"'/></td></tr>");  
       out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
       out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>");  
       out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");  
       out.print("<tr><td>Country:</td><td><input type='text' name='email' value='"+e.getCountry()+"'/></td></tr>"); 
       out.print("<tr><td></td><td></td></tr></br>");*/
      
       out.print("</table >");
       out.print("</br><center><input class='btn btn-primary' type='submit' value='Log Out'/></center>");
       out.print( "</form>");
       out.print("</body>");  
       
       //out.print("<a href='DeleteServlet'>"+"<form><input type='submit' value='Delete Account'></form>"+"</a>");
       
       //out.print("<form action='index.html' >");
       // out.print("<input type='submit' value='Log Out'");
       // out.print("</form>");
        out.close();  
        
        
    }
    

   

}
