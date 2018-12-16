package databeans;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ejb.Stateless;
import javax.faces.event.PreClearFlashEvent;

@Stateless
public class CustomerDL
  {

    public static Connection con;

    public CustomerDL() throws ClassNotFoundException
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

    public static int AddCustomer(String FN, String LN, String phone, String email, String address, String prov, String post) throws SQLException
      {
        PreparedStatement ps = con.prepareStatement("INSERT INTO customer (firstName,lastName,phoneNumber,email,address,province,postalCode) VALUES(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, FN);
        ps.setString(2, LN);
        ps.setString(3, phone);
        ps.setString(4, email);
        ps.setString(5, address);
        ps.setString(6, prov);
        ps.setString(7, post);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();

        int id = 0;
        if (rs.next())
          {
            id = rs.getInt(1);
          }
        return id;
      }

  }
