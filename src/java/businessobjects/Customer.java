/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessobjects;

import javax.ejb.Stateless;

/**
 *
 * @author School
 */
@Stateless
public class Customer
  {

    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String address;
    private String province;
    private String postal;

    public Customer()
      {
      }

    public Customer(String firstname, String lastname, String email, String phone, String address, String province, String postal)
      {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.province = province;
        this.postal = postal;
      }

    public String getFirstname()
      {
        return firstname;
      }

    public void setFirstname(String firstname)
      {
        this.firstname = firstname;
      }

    public String getLastname()
      {
        return lastname;
      }

    public void setLastname(String lastname)
      {
        this.lastname = lastname;
      }

    public String getEmail()
      {
        return email;
      }

    public void setEmail(String email)
      {
        this.email = email;
      }

    public String getPhone()
      {
        return phone;
      }

    public void setPhone(String phone)
      {
        this.phone = phone;
      }

    public String getAddress()
      {
        return address;
      }

    public void setAddress(String address)
      {
        this.address = address;
      }

    public String getProvince()
      {
        return province;
      }

    public void setProvince(String province)
      {
        this.province = province;
      }

    public String getPostal()
      {
        return postal;
      }

    public void setPostal(String postal)
      {
        this.postal = postal;
      }

  }
