import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;  
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("username");  
    String p=request.getParameter("password");  
    HttpSession sessin=request.getSession();
    sessin.setAttribute("name", n);
    //Cookie ck=new Cookie("username",n);//creating cookie object  
    //response.addCookie(ck);//adding cookie in the response 
    
   if(LoginDao.validate(n, p))
    {  
        HttpSession session=request.getSession();  
        session.setAttribute("name",n);
        RequestDispatcher rd=request.getRequestDispatcher("ViewServlet");  
        rd.forward(request,response); 
    }  
    else
    {  
        out.print("Sorry username or password error");  
        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
        rd.include(request,response);  
    }  
          
    out.close();  
    }  
}


