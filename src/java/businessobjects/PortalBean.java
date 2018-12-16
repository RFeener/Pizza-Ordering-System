/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessobjects;

import java.io.Serializable;
import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.view.ViewScoped;

@Named(value = "portalBean")
@ViewScoped
public class PortalBean implements Serializable
  {

    private String username;
    private String password;

    public String getUsername()
      {
        return username;
      }

    public void setUsername(String username)
      {
        this.username = username;
      }

    public String getPassword()
      {
        return password;
      }

    public void setPassword(String password)
      {
        this.password = password;
      }

    public PortalBean() throws ClassNotFoundException, SQLException
      {

      }

    public String empLogin() throws SQLException
      {
        boolean emplogin = EmployeeBL.EmployeeLogin(username, password);
        if (emplogin)
          {
            return "empportal.jsp";
          }
        else
          {
            return "index.jsp";
          }
      }

  }
