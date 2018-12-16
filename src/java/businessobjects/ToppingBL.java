/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessobjects;

import databeans.ToppingDL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author School
 */
@Stateless
public class ToppingBL
  {

    public static void addToppingstoMap(int PizzaID, int ToppingId) throws SQLException
      {
        ToppingDL.addToppingstoMap(PizzaID, ToppingId);
      }

    public static ArrayList<Topping> getAvailibleToppings() throws SQLException, ClassNotFoundException
      {
        ArrayList<Topping> TopAL = new ArrayList<>();
        ResultSet rs = ToppingDL.getAvailibleToppings();
        rs.first();
        do
          {
            Topping t = new Topping();
            t.setToppingId(rs.getInt("toppingId"));
            t.setName(rs.getString("name"));
            t.setPrice(rs.getDouble("price"));
            t.setIsActive(rs.getInt("isActive"));
            TopAL.add(t);
          }
        while (rs.next());
        return TopAL;
      }

    public static ArrayList<Topping> getToppings() throws SQLException, ClassNotFoundException
      {
        ArrayList<Topping> TopAL = new ArrayList<>();
        ResultSet rs = ToppingDL.getToppings();
        rs.first();
        do
          {
            Topping t = new Topping();
            t.setToppingId(rs.getInt("toppingId"));
            t.setName(rs.getString("name"));
            t.setPrice(rs.getDouble("price"));
            t.setIsActive(rs.getInt("isActive"));
            TopAL.add(t);
          }
        while (rs.next());
        return TopAL;
      }

    public static ResultSet getToppingbyId(int id) throws SQLException
      {
        return ToppingDL.getToppingbyId(id);
      }

    public static ResultSet getToppingsbyPizzaId(int PizzaID) throws SQLException
      {
        return ToppingDL.getToppingsbyPizzaId(PizzaID);
      }

    public static int disableToppings(int toppingID) throws SQLException
      {
        return ToppingDL.disableToppings(toppingID);
      }

    public static int enableToppings(int topID) throws SQLException
      {
        return ToppingDL.enableToppings(topID);
      }

    public static void AddTopping(String name, float price) throws SQLException
      {
        ToppingDL.AddTopping(name, price);
      }

  }
