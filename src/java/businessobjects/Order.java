/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessobjects;

import java.sql.Date;
import javax.ejb.Stateless;

/**
 *
 * @author School
 */
@Stateless
public class Order
  {

    private int orderID;
    private double totalPrice;
    private Date deliveryTime;
    private Date placedTime;
    private int custID;
    private String OrderStatus;

    public Order()
      {
      }

    public Order(int orderID, double totalPrice, Date deliveryTime, Date placedTime, int custID, String OrderStatus)
      {
        this.orderID = orderID;
        this.totalPrice = totalPrice;
        this.deliveryTime = deliveryTime;
        this.placedTime = placedTime;
        this.custID = custID;
        this.OrderStatus = OrderStatus;
      }

    public int getOrderID()
      {
        return orderID;
      }

    public void setOrderID(int orderID)
      {
        this.orderID = orderID;
      }

    public double getTotalPrice()
      {
        return totalPrice;
      }

    public void setTotalPrice(double totalPrice)
      {
        this.totalPrice = totalPrice;
      }

    public Date getDeliveryTime()
      {
        return deliveryTime;
      }

    public void setDeliveryTime(Date deliveryTime)
      {
        this.deliveryTime = deliveryTime;
      }

    public Date getPlacedTime()
      {
        return placedTime;
      }

    public void setPlacedTime(Date placedTime)
      {
        this.placedTime = placedTime;
      }

    public int getCustID()
      {
        return custID;
      }

    public void setCustID(int custID)
      {
        this.custID = custID;
      }

    public String getOrderStatus()
      {
        return OrderStatus;
      }

    public void setOrderStatus(String OrderStatus)
      {
        this.OrderStatus = OrderStatus;
      }

  }
