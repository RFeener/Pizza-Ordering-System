package businessobjects;

import databeans.SizeDL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ejb.Stateless;

@Stateless
public class SizeBL
  {

    public static ArrayList<Size> getSizes() throws SQLException, ClassNotFoundException
      {
        ArrayList<Size> SizeAL = new ArrayList<>();
        ResultSet rs = SizeDL.getSizes();
        rs.first();
        do
          {
            Size size = new Size();
            size.setSizeid(rs.getInt("Sizeid"));
            size.setName(rs.getString("name"));
            size.setPrice(rs.getDouble("price"));
            SizeAL.add(size);
          }
        while (rs.next());
        return SizeAL;

      }

    public static ResultSet displaySizebyId(int id) throws SQLException
      {
        return SizeDL.displaySizebyId(id);
      }

    public static float getPriceByID(int size) throws SQLException
      {
        return SizeDL.getPriceByID(size);
      }
  }
