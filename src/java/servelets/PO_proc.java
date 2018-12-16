package servelets;

import businessobjects.CrustTypeBL;
import businessobjects.PizzaBL;
import businessobjects.SizeBL;
import businessobjects.ToppingBL;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PO_proc", urlPatterns =
  {
    "/PO_proc"
  })
public class PO_proc extends HttpServlet
  {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException
      {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
          {
            HttpSession sess = request.getSession();

            int size = Integer.parseInt(request.getParameter("Size"));
            int quantity = Integer.parseInt(request.getParameter("numPizzas"));
            int crustType = Integer.parseInt(request.getParameter("Crust"));
            float sizeprice = SizeBL.getPriceByID(size);
            float crustprice = CrustTypeBL.getPriceByID(crustType);
            float price = (sizeprice + crustprice) * quantity;
            int orderid = (Integer) sess.getAttribute("orderID");

            int pizzaID = PizzaBL.AddPizza(size, quantity, crustType, price, orderid);
            String Topping[] = request.getParameterValues("Topping");
            for (String Top : Topping)
              {
                int topID = Integer.parseInt(Top);
                ToppingBL.addToppingstoMap(pizzaID, topID);
              }
            int numPizzas = Integer.parseInt(request.getParameter("numPizzas"));
            sess.setAttribute("numPizzas", numPizzas);
            response.sendRedirect("orderdetails.jsp");

          }
      }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
      {
        try
          {
            processRequest(request, response);
          }
        catch (SQLException ex)
          {
            Logger.getLogger(PO_proc.class.getName()).log(Level.SEVERE, null, ex);
          }
      }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
      {
        try
          {
            processRequest(request, response);
          }
        catch (SQLException ex)
          {
            Logger.getLogger(PO_proc.class.getName()).log(Level.SEVERE, null, ex);
          }
      }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
      {
        return "Short description";
      }// </editor-fold>

  }
