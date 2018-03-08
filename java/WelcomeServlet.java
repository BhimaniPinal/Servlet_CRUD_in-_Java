import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
         
        Cookie ck[]=request.getCookies();
       // out.print("Hello "+ck[0].getValue());  
        
        String n=request.getParameter("username");  
        Emp e=EmpDao.getEmployeeByName(n);
        
        out.print("<body background='p5.jpg' style='background-repeat:no-repeat;background-size:100% 100%' bgcolor='tomato'>"); 
        out.print("</br></br></br></br></br><h1 style='text-align:center'>Welcome "+n+"</h1>");  
        out.println("</br></br><a href='ViewServlet?username="+n+"'><h3 style='text-align:center'>Profile</h3></a>");
        out.println("<p>"+"      "+"</p><a href='EditServlet?id="+e.getId()+"'><h3 style='text-align:center'>Edit Prifile</h3></a>");
        out.print("</body>");  
        out.close();  
    }
}
