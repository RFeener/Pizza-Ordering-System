package businessobjects;

import javax.ejb.Stateless;

@Stateless
public class Pizza
  {

    private int PizzaID;
    private int crustType;
    private boolean isFinished;
    private int size;
    private float price;

    public Pizza()
      {
      }

    public Pizza(int PizzaID, int size, boolean isFinished, int crustType, float price)
      {
        this.PizzaID = PizzaID;
        this.crustType = crustType;
        this.isFinished = isFinished;
        this.size = size;
        this.price = price;
      }

    public int getPizzaID()
      {
        return PizzaID;
      }

    public void setPizzaID(int PizzaID)
      {
        this.PizzaID = PizzaID;
      }

    public int getCrustType()
      {
        return crustType;
      }

    public void setCrustType(int crustType)
      {
        this.crustType = crustType;
      }

    public boolean isIsFinished()
      {
        return isFinished;
      }

    public void setIsFinished(boolean isFinished)
      {
        this.isFinished = isFinished;
      }

    public int getSize()
      {
        return size;
      }

    public void setSize(int size)
      {
        this.size = size;
      }

    public float getPrice()
      {
        return price;
      }

    public void setPrice(float price)
      {
        this.price = price;
      }

  }
