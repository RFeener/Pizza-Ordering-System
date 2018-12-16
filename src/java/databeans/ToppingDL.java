package databeans;

import businessobjects.Topping;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ToppingDL
  {

    @Inject
    private Topping t;

    public static Connection con;

    public ToppingDL() throws ClassNotFoundException
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

    public static void AddTopping(String name, float price) throws SQLException
      {
        String addSQL = "INSERT INTO toppings (name, price, createdate, empAddedBy, isActive) VALUES (?,?, CURRENT_TIMESTAMP, '1', '0');";
        PreparedStatement ps = con.prepareStatement(addSQL);
        ps.setString(1, name);
        ps.setFloat(2, price);
        ps.executeUpdate();
      }

    public static void addToppingstoMap(int PizzaID, int ToppingId) throws SQLException
      {
        String SQL = "INSERT INTO pizza_toppings_map (toppingId, pizzaId, pizza_toppings_id) VALUES (?, ?, NULL)";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setInt(1, ToppingId);
        ps.setInt(2, PizzaID);
        ps.executeUpdate();

      }

    public static ResultSet getAvailibleToppings() throws SQLException, ClassNotFoundException
      {
        String Topsql = "select * from toppings where isActive = 1";
        Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet ToppingRS = s.executeQuery(Topsql);
        ToppingRS.first();
        return ToppingRS;
      }

    public static ResultSet getToppings() throws SQLException, ClassNotFoundException
      {
        String Topsql = "select * from toppings";
        Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet ToppingRS = s.executeQuery(Topsql);

        return ToppingRS;
      }

    public static ResultSet getToppingbyId(int id) throws SQLException
      {
        String SQL = "select * from toppings where toppingId = ?;";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setInt(1, id);
        ResultSet RS = ps.executeQuery();
        RS.first();
        return RS;
      }

    public static ResultSet getToppingsbyPizzaId(int PizzaID) throws SQLException
      {
        String SQL = "select * from toppings where toppingId in (select toppingId from pizza_toppings_map where pizzaId = ?);";
        PreparedStatement ps = con.prepareStatement(SQL);
        ps.setInt(1, PizzaID);
        ResultSet RS = ps.executeQuery();
        RS.first();
        return RS;
      }

    public static int disableToppings(int toppingID) throws SQLException
      {
        String sql = "UPDATE toppings SET isActive = '0' WHERE toppingId = ?;";
        PreparedStatement disableTopping = con.prepareStatement(sql);
        disableTopping.setInt(1, toppingID);
        return disableTopping.executeUpdate();

      }

    public static int enableToppings(int topID) throws SQLException
      {
        String sql = "UPDATE toppings SET isActive = '1' WHERE toppingId = ?;";
        PreparedStatement disableTopping = con.prepareStatement(sql);
        disableTopping.setInt(1, topID);
        return disableTopping.executeUpdate();
      }
  }
