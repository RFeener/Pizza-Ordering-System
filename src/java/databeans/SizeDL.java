package databeans;

import com.mysql.jdbc.Connection;
import static databeans.CrustTypeDL.con;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ejb.Stateless;

@Stateless
public class SizeDL
  {

    public static Connection con;

    public SizeDL() throws ClassNotFoundException
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

    public static ResultSet getSizes() throws SQLException, ClassNotFoundException
      {
        String sizeSQL = "select * from sizes";
        Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet sizeRS = s.executeQuery(sizeSQL);
        sizeRS.first();
        return sizeRS;
      }

    public static ResultSet displaySizebyId(int id) throws SQLException
      {
        String SQL = "select * from sizes where sizeid = ?;";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setInt(1, id);
        ResultSet RS = ps.executeQuery();
        RS.first();
        return RS;
      }

    public static float getPriceByID(int size) throws SQLException
      {
        String SQL = "select price from sizes where sizeid = ?;";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setInt(1, size);
        ResultSet RS = ps.executeQuery();
        RS.first();
        return RS.getFloat("price");
      }
  }
