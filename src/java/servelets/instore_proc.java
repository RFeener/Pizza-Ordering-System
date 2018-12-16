/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelets;

import static businessobjects.OrderBL.finalizePickupOrder;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.round;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author School
 */
@WebServlet(name = "instore_proc", urlPatterns =
  {
    "/instore_proc"
  })
public class instore_proc extends HttpServlet
  {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException
      {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
          {
            HttpSession session = request.getSession();
            double total = (Double) session.getAttribute("total");
            total = Math.round(total * 100);
            total = total / 100;
            int orderID = (Integer) session.getAttribute("orderID");
            int updateOrder = finalizePickupOrder(orderID, total);
            if (updateOrder == 1)
              {
                response.sendRedirect("payinstore.jsp");
              }
            else
              {
                System.out.println(updateOrder);
              }

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
            Logger.getLogger(instore_proc.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(instore_proc.class.getName()).log(Level.SEVERE, null, ex);
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
