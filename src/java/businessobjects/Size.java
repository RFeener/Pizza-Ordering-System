package businessobjects;

import javax.ejb.Stateless;

@Stateless
public class Size
  {

    private int sizeid;
    private String name;
    private double price;

    public Size()
      {
      }

    public Size(int sizeid, String name, double price)
      {
        this.sizeid = sizeid;
        this.name = name;
        this.price = price;
      }

    public int getSizeid()
      {
        return sizeid;
      }

    public void setSizeid(int sizeid)
      {
        this.sizeid = sizeid;
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

  }
