package businessobjects;

import databeans.OrderDL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.ejb.Stateless;

@Stateless
public class OrderBL
  {

    public static int AddOrder(float price, LocalDateTime deliveryTime, LocalDateTime placedTime, int custID, String orderStatus) throws SQLException
      {
        return OrderDL.AddOrder(price, deliveryTime, placedTime, custID, orderStatus);
      }

    public static String getCustNameByOrderId(int orderID) throws SQLException
      {
        return OrderDL.getCustNameByOrderId(orderID);
      }

    public static int finalizePickupOrder(int orderID, double total) throws SQLException
      {
        return OrderDL.finalizePickupOrder(orderID, total);
      }

    public static int finalizeDeliveryOrder(int orderID, double total) throws SQLException
      {
        return OrderDL.finalizeDeliveryOrder(orderID, total);
      }

    public static ArrayList<Order> getPendingOrders() throws SQLException
      {
        return OrderDL.getPendingOrders();
      }

    public static ArrayList<Order> getCompleteOrders() throws SQLException
      {
        return OrderDL.getCompleteOrders();
      }

    public static int setOrderComplete(int orderid) throws SQLException
      {
        return OrderDL.setOrderComplete(orderid);

      }

  }
