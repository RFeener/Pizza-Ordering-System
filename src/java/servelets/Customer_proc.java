package servelets;

import businessobjects.CustomerBL;
import businessobjects.OrderBL;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Customer_proc", urlPatterns =
  {
    "/Customer_proc"
  })
public class Customer_proc extends HttpServlet
  {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException
      {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
          {
            String FName = request.getParameter("firstName");
            String LName = request.getParameter("lastName");
            String Phone = request.getParameter("phone");
            String Email = request.getParameter("email");
            String Address = request.getParameter("address");
            String Province = request.getParameter("province");
            String Postal = request.getParameter("postal");

            if (FName.isEmpty() || LName.isEmpty() || Address.isEmpty())
              {
                response.sendRedirect("index.jsp");
              }
            else
              {

                LocalDateTime date = LocalDateTime.now();

                int custID = CustomerBL.AddCustomer(FName, LName, Phone, Email, Address, Province, Postal);
                int orderID = OrderBL.AddOrder(0, date, date, custID, "Pending");
                HttpSession sess = request.getSession();
                sess.setAttribute("orderID", orderID);
                response.sendRedirect("pizzaorder.jsp");
              }
          }
      }

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
            Logger.getLogger(Customer_proc.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Customer_proc.class.getName()).log(Level.SEVERE, null, ex);
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
