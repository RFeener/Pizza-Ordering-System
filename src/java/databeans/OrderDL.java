/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databeans;

import businessobjects.Order;
import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Locale;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author School
 */
@Stateless
public class OrderDL
  {

//    @Inject
//    private Order o;
    public static Connection con;

    public OrderDL() throws ClassNotFoundException
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

    public static ArrayList<Order> getPendingOrders() throws SQLException
      {
        String pendingSQL = "SELECT * FROM orders where not orderStatus = 'Complete' ORDER BY placedDateTime DESC";
        PreparedStatement ps = con.prepareStatement(pendingSQL);
        ResultSet OrderRS = ps.executeQuery();
        OrderRS.first();
        ArrayList<Order> PendingList = new ArrayList<>();
        do
          {
            Order o = new Order(OrderRS.getInt(1), OrderRS.getDouble(2), OrderRS.getDate(3), OrderRS.getDate(4), OrderRS.getInt(5), OrderRS.getString(6));
            PendingList.add(o);

          }
        while (OrderRS.next());

        return PendingList;
      }

    public static ArrayList<Order> getCompleteOrders() throws SQLException
      {
        String completeSQL = "SELECT * FROM orders where orderStatus = 'Complete' ORDER BY placedDateTime DESC";
        PreparedStatement ps = con.prepareStatement(completeSQL);
        ResultSet OrderRS = ps.executeQuery();
        OrderRS.first();
        ArrayList<Order> CompleteList = new ArrayList<>();
        do
          {
            Order o = new Order(OrderRS.getInt(1), OrderRS.getDouble(2), OrderRS.getDate(3), OrderRS.getDate(4), OrderRS.getInt(5), OrderRS.getString(6));
            CompleteList.add(o);

          }
        while (OrderRS.next());

        return CompleteList;
      }

    public static int AddOrder(float price, LocalDateTime deliveryTime, LocalDateTime placedTime, int custID, String orderStatus) throws SQLException
      {
        PreparedStatement ps = con.prepareStatement("INSERT INTO `pizzadb`.`orders`(`totalPrice`,`deliveryDateTime`,`placedDateTime`,`customerId`,`orderStatus`)VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

        //Format to string
        //Local date time is yyyy/mm/ddTHH:mm:ss
        //sql accepts the same thing but without the T (its a space)  so it needs to be formatted to enter correctly
        DateTimeFormatter FormattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//Currect Format
        String strDelivery = FormattedDate.format(deliveryTime);//Set delivery to same as placed and will be alters once order is finalized
        String strPlaced = FormattedDate.format(placedTime);

        ps.setFloat(1, price);
        ps.setString(2, strDelivery);
        ps.setString(3, strPlaced);
        ps.setInt(4, custID);
        ps.setString(5, orderStatus);
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        int id = 0;
        if (rs.next())
          {
            id = rs.getInt(1);
          }
        return id;
      }

    public static String getCustNameByOrderId(int orderID) throws SQLException
      {
        PreparedStatement ps = con.prepareStatement("select firstName from customer where customerid in (select customerId from orders where orderId = ?);");
        ps.setInt(1, orderID);
        ResultSet rs = ps.executeQuery();
        rs.first();
        return rs.getString("firstName");

      }

    public static int finalizePickupOrder(int orderID, double total) throws SQLException
      {
        LocalDateTime Deliverydate = LocalDateTime.now();
        Deliverydate.plusHours(1);
        DateTimeFormatter FormattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strDeliveryDate = FormattedDate.format(Deliverydate);

        PreparedStatement updateOrder = con.prepareStatement("UPDATE orders SET totalPrice = ?, deliveryDateTime = ?,orderStatus = ? WHERE orderId = ?;");
        updateOrder.setDouble(1, total);
        updateOrder.setString(2, strDeliveryDate);
        updateOrder.setString(3, "Pickup");
        updateOrder.setInt(4, orderID);
        return updateOrder.executeUpdate();

      }

    public static int finalizeDeliveryOrder(int orderID, double total) throws SQLException
      {
        LocalDateTime Deliverydate = LocalDateTime.now();
        Deliverydate.plusHours(1);
        DateTimeFormatter FormattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strDeliveryDate = FormattedDate.format(Deliverydate);

        PreparedStatement updateOrder = con.prepareStatement("UPDATE orders SET totalPrice = ?, deliveryDateTime = ?,orderStatus = ? WHERE orderId = ?;");
        updateOrder.setDouble(1, total);
        updateOrder.setString(2, strDeliveryDate);
        updateOrder.setString(3, "Delivery");
        updateOrder.setInt(4, orderID);
        return updateOrder.executeUpdate();

      }

    public static int setOrderComplete(int orderid) throws SQLException
      {
        PreparedStatement updateOrder = con.prepareStatement("UPDATE orders SET orderStatus = ? WHERE orderId = ?;");
        updateOrder.setString(1, "Complete");
        updateOrder.setInt(2, orderid);
        return updateOrder.executeUpdate();
      }

  }
