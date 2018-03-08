import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;  
@WebServlet("/DeleteServlet") 
public class DeleteServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {      
        response.setContentType("text/html"); 
        PrintWriter out=response.getWriter(); 
        String sname=request.getParameter("username"); 
        out.print(sname);
        
         int status=EmpDao.delete(sname);  
       
         if(status>0)
         {  
            out.print("<p>Record delete successfully!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }
        else
        {  
            out.println("Sorry! unable to delete record");  
        }  
            //    processRequest(request, response);
    }

}
