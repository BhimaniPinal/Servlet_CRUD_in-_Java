import java.sql.*;

public class LoginDao
{
    public static boolean validate(String name,String password)
    {  
        boolean status=false;  
        try
        {  
           Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/table","root","");  
      
            PreparedStatement ps=con.prepareStatement("select * from  emp where Name=? and Password=?");  
            ps.setString(1,name);   
            ps.setString(2,password);  
      
            ResultSet rs=ps.executeQuery();  
            status=rs.next();  
          
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return status;  
    }
}
