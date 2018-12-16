package businessobjects;

import databeans.PizzaDL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.Stateless;

@Stateless
public class PizzaBL
  {

    public static int AddPizza(int sizeID, int TTF, int crust, float prc, int orderid) throws SQLException
      {
        return PizzaDL.AddPizza(sizeID, TTF, crust, prc, orderid);
      }

    public static ArrayList<Pizza> fetchAllPizzas(int orderID) throws SQLException
      {
        return PizzaDL.fetchAllPizzas(orderID);
      }

  }
