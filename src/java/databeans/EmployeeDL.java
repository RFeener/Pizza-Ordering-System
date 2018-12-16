package databeans;

import businessobjects.Employee;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ejb.Stateless;

@Stateless
public class EmployeeDL
  {

    public static Connection con;

    public EmployeeDL() throws ClassNotFoundException
      {
        con = GetConnection();
      }

    public static Connection GetConnection() throws ClassNotFoundException
      {
        Class.forName("com.mysql.jdbc.Driver");
        String dbURL = "jdbc:mysql://localhost:3306/pizzadb";
        String dbUser = "root";
        String dbPass = "";
        try
          {
            con = (Connection) DriverManager.getConnection(dbURL, dbUser, dbPass);
            return con;
          }
        catch (SQLException e)
          {
            System.out.println("ERROR");
          }
        return con;
      }

    public static boolean EmployeeLogin(String username, String password) throws SQLException
      {
        PreparedStatement ps = con.prepareStatement("Select username, password from employee where username = ? and password = ?");
        ps.setString(1, username);
        ps.setString(2, password);
        // System.out.println(ps);
        ResultSet rs = ps.executeQuery();
        if (rs.next())
          {
            return true;
          }
        else
          {
            return false;
          }

      }

  }
