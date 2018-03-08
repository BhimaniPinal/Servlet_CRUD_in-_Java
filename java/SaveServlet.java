
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;

public class SaveServlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();  
        
        Cookie ck[]=request.getCookies();
       // out.print("Hello "+ck[0].getValue());  
        
        String name=request.getParameter("username");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email");  
        String country=request.getParameter("country");  
          
        Emp e=new Emp(); 
        e.setName(name); //set in to the database from html page 
        e.setPassword(password);  
        e.setEmail(email);  
        e.setCountry(country);  
          
        int status=EmpDao.save(e);  
        if(status>0)
        {  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }else
        {  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}  
        
    