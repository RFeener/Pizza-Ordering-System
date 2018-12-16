package businessobjects;

import javax.ejb.Stateless;

@Stateless
public class CrustType
  {

    private int crustTypeId;
    private String name;
    private double price;

    public CrustType()
      {
      }

    public int getCrustTypeId()
      {
        return crustTypeId;
      }

    public void setCrustTypeId(int crustTypeId)
      {
        this.crustTypeId = crustTypeId;
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

    public CrustType(int crustTypeId, String name, double price)
      {
        this.crustTypeId = crustTypeId;
        this.name = name;
        this.price = price;
      }

  }
