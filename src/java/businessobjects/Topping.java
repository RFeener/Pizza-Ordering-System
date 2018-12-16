package businessobjects;

import javax.ejb.Stateless;

@Stateless
public class Topping
  {

    private int toppingId;
    private String name;
    private double price;
    private String CreateDate;
    private int IsActive;

    public Topping()
      {
      }

    public int getIsActive()
      {
        return IsActive;
      }

    public Topping(int toppingId, String name, double price, String CreateDate, int IsActive)
      {
        this.toppingId = toppingId;
        this.name = name;
        this.price = price;
        this.CreateDate = CreateDate;
        this.IsActive = IsActive;
      }

    public int getToppingId()
      {
        return toppingId;
      }

    public void setToppingId(int toppingId)
      {
        this.toppingId = toppingId;
      }

    public String getName()
      {
        return name;
      }

    public void setName(String name)
      {
        this.name = name;
      }

    public double getPrice()
      {
        return price;
      }

    public void setPrice(double price)
      {
        this.price = price;
      }

    public String getCreateDate()
      {
        return CreateDate;
      }

    public void setCreateDate(String CreateDate)
      {
        this.CreateDate = CreateDate;
      }

    public int isIsActive()
      {
        return IsActive;
      }

    public void setIsActive(int IsActive)
      {
        this.IsActive = IsActive;
      }

  }
