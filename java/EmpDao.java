import java.util.*;  
import java.sql.*;  
  
public class EmpDao {  
  
    public static Connection getConnection()
    {  
        Connection con=null;  
        try
        {            
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/table","root","");  
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }  
        return con;  
    }  
    public static int save(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into emp(Name,Password,Email,Country) values (?,?,?,?)");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getCountry());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }  
          
        return status;  
    }  
    public static int update(Emp e){  
        int status=0;  
        try
        {  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("update emp set Name=?,Password=?,Email=?,Country=? where Id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getCountry());  
            ps.setInt(5,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }  
          
        return status;  
    }  
    public static int delete(String sname){  
        int status=0;  
        try
        {  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from emp where Name=?");  
            ps.setString(1,sname);  
            status=ps.executeUpdate();  
              
            con.close();  
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }        
        return status;  
    }  
     public static Emp getEmployeeById(int id)
     {  
        Emp e=new Emp();    
        try
        {  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from emp where Id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next())
            {  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
            }  
            con.close();  
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }  
        return e;
     
     }
    public static Emp getEmployeeByName(String sname){  
        Emp e=new Emp();    
        try
        {  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from emp where Name=?");  
            ps.setString(1,sname);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next())
            {  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
            }  
            con.close();  
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }  
          
        return e;  
    }  
    public static Emp getEmployee(String s){  
        Emp e=new Emp();
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from emp where Name=?");  
            ps.setString(1, s);
            ResultSet rs=ps.executeQuery();  
            while(rs.next())
            {  
               
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
                
            }  
            con.close();  
        }
        catch(Exception m)
        {
            m.printStackTrace();
        }  
          
        return e;  
    }  
}  