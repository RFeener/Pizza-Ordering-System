/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessobjects;

import databeans.EmployeeDL;
import java.sql.SQLException;
import javax.ejb.Stateless;

/**
 *
 * @author School
 */
@Stateless
public class EmployeeBL
  {

    public static boolean EmployeeLogin(String username, String password) throws SQLException
      {
        return EmployeeDL.EmployeeLogin(username, password);
      }

  }
