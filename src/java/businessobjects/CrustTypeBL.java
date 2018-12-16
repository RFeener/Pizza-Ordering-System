package businessobjects;

import databeans.CrustTypeDL;
import databeans.PizzaDL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.Stateless;

@Stateless
public class CrustTypeBL
  {

    public static ArrayList<CrustType> getCrustTypes() throws SQLException, ClassNotFoundException
      {
        ArrayList<CrustType> CrustAL = new ArrayList<>();
        ResultSet rs = CrustTypeDL.getCrustTypes();
        rs.first();
        do
          {
            CrustType ct = new CrustType();
            ct.setCrustTypeId(rs.getInt("CrustTypeId"));
            ct.setName(rs.getString("name"));
            ct.setPrice(rs.getDouble("price"));
            CrustAL.add(ct);
          }
        while (rs.next());
        return CrustAL;
      }

    public static ResultSet displayCrustbyId(int id) throws SQLException
      {
        return CrustTypeDL.displayCrustbyId(id);
      }

    public static float getPriceByID(int crustType) throws SQLException
      {
        return CrustTypeDL.getPriceByID(crustType);
      }

  }
