import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;  
@WebServlet("/EditServlet2")  
public class EdiServlet2 extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
       
       response.setContentType("text/html");  
       PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
        String country=request.getParameter("country");  
        out.println(id);
        
        Emp e=new Emp();  
        e.setId(id);  
        e.setName(name);  
        e.setPassword(password);  
        e.setEmail(email);  
        e.setCountry(country); 
          out.println(name+password);
          
        int status=EmpDao.update(e);  
        if(status>0)
        {  
            out.println("<p>Record update SuccessFully<p>");
            response.sendRedirect("ViewServlet");  
        }
        else
        {  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close(); 
    
    }
}
