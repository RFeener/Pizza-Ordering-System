package databeans;

import static databeans.PizzaDL.con;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ejb.Stateless;

@Stateless
public class CrustTypeDL
  {

    public static Connection con;

    public CrustTypeDL() throws ClassNotFoundException
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

    public static ResultSet getCrustTypes() throws SQLException, ClassNotFoundException
      {
        String crustSQL = "select * from crusttypes";
        Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet crustRS = s.executeQuery(crustSQL);
        crustRS.first();
        return crustRS;
      }

    public static ResultSet displayCrustbyId(int id) throws SQLException
      {
        String SQL = "select * from crusttypes where crustTypeId = ?;";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setInt(1, id);
        ResultSet RS = ps.executeQuery();
        RS.first();
        return RS;
      }

    public static float getPriceByID(int crustType) throws SQLException
      {
        String SQL = "select price from crusttypes where crustTypeId = ?;";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setInt(1, crustType);
        ResultSet RS = ps.executeQuery();
        RS.first();
        return RS.getFloat("price");
      }
  }
