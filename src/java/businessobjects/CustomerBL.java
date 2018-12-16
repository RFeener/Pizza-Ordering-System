package businessobjects;

import databeans.CustomerDL;
import java.sql.SQLException;
import javax.ejb.Stateless;

@Stateless
public class CustomerBL
  {

    public static int AddCustomer(String FN, String LN, String phone, String email, String address, String prov, String post) throws SQLException
      {
        return CustomerDL.AddCustomer(FN, LN, phone, email, address, prov, post);
      }

  }
