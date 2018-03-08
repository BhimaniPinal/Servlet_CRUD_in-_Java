import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;  
@WebServlet("/EditServlet")  

public class EditServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        out.println("<head><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'></head>"); 
        out.print("<body background='p6.jpg' style='background-repeat:no-repeat;background-size:100% 100%' >");
        out.println("</br></br></br></br></br></br></br><h1 style='text-align:center'>Update Employee Detail</h1></br>");  
        
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
          
        Emp e=EmpDao.getEmployeeById(id);  
         
        out.print("<form action='EditServlet2?id="+e.getId()+"' method='post'>");  
        out.print("<table align='center'>");  
      //  out.print("<tr><td><div class='col-md-3 col-md-offset-3'> <label for='name'>ID:</label></div></td><td><div class='col-md-12'><input type='text' class='form-control id=name name='id' value='"+e.getId()+"'></div></td></tr>");
        out.print("<tr><td><div class='col-md-3 col-md-offset-3'> <label for='name'>Name:</label></div></td><td><div class='col-md-12'><input type='text' class='form-control id='name' name='name' value='"+e.getName()+"'></div></td></tr>");
        out.print("<tr><td><div class='col-md-3 col-md-offset-3'> <label for='password'>Password:</label></div></td><td><div class='col-md-12'><input type='password' class='form-control id='password' name='password' value='"+e.getPassword()+"'></div></td></tr>");
        out.print("<tr><td><div class='col-md-3 col-md-offset-3'> <label for='email'>Email:</label></div></td><td><div class='col-md-12'><input type='email' class='form-control id='email' name='email' value='"+e.getEmail()+"'></div></td></tr>");
        out.print("<tr><td><div class='col-md-3 col-md-offset-3'> <label for='country'>Country:</label></div></td><td><div class='col-md-12'><select class='form-control' id='country' name='country' style='width:150px'><option>India</option><option>USA</option><option>UK</option><option>Other</option></select> </div></td></tr>");
        
       /* out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
        out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");  
        out.print("<tr><td>Country:</td><td>");  
        out.print("<select name='country' style='width:150px'>");  
        out.print("<option>India</option>");  
        out.print("<option>USA</option>");  
        out.print("<option>UK</option>");  
        out.print("<option>Other</option>");  
        out.print("</select>");  
        out.print("</td></tr>");*/
        out.print("</table>");  
        out.print("</br><center><input class='btn btn-primary'type='submit' value='Edit & Save'/>");  
        out.print("</form>");  
         out.print("</body>");  
        out.close();}
}

