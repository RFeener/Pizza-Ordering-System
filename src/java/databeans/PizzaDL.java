package databeans;

import businessobjects.Pizza;
import com.mysql.jdbc.Connection;
import static databeans.SizeDL.con;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ejb.Stateless;

@Stateless
public class PizzaDL
  {

    public static Connection con;

    public PizzaDL() throws ClassNotFoundException
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

    public static int AddPizza(int sizeID, int TTF, int crust, float prc, int orderid) throws SQLException
      {
        PreparedStatement ps = con.prepareStatement("INSERT INTO `pizza`(`sizeId`, `Quantity`, `crustTypeId`, `price`, `orderId`) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, sizeID);
        ps.setInt(2, TTF);
        ps.setInt(3, crust);
        ps.setFloat(4, prc);
        ps.setInt(5, orderid);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        int id = 0;
        if (rs.next())
          {
            id = rs.getInt(1);
          }
        return id;

      }

    public static ArrayList<Pizza> fetchAllPizzas(int orderID) throws SQLException
      {
        PreparedStatement ps = con.prepareStatement("select * from pizza where orderId = ?");
        ps.setInt(1, orderID);
        ps.executeQuery();
        ResultSet pizzaRS = ps.executeQuery();

        ArrayList<Pizza> PizzaAL = new ArrayList<>();
        pizzaRS.first();
        do
          {
            Pizza p = new Pizza(pizzaRS.getInt(1), pizzaRS.getInt(2), pizzaRS.getBoolean(3), pizzaRS.getInt(4), pizzaRS.getFloat(5));
            PizzaAL.add(p);
          }
        while (pizzaRS.next());
        return PizzaAL;

      }

  }
