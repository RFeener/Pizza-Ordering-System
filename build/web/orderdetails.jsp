<%@page import="java.text.NumberFormat"%>
<%@page import="businessobjects.ToppingBL"%>
<%@page import="businessobjects.OrderBL"%>
<%@page import="businessobjects.SizeBL"%>
<%@page import="businessobjects.CrustTypeBL"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.ArrayList"%>
<%@page import="businessobjects.PizzaBL"%>
<%@page import="businessobjects.Pizza"%>
<%@page import="businessobjects.Pizza"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Confirmation</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body style="background-color: rgb(255, 128, 64);">
        <div id="welcomepage" class="container-fluid row">

            <div class="col-md-3">

            </div>
            <div class="col-md-6 ">

                <%
                    int orderID = (Integer) session.getAttribute("orderID");
                    int numPizzas = (Integer) session.getAttribute("numPizzas");
                    ArrayList<Pizza> PizzaList = PizzaBL.fetchAllPizzas(orderID);
                    String custName = OrderBL.getCustNameByOrderId(orderID);
                    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
                    double subtotal = 0.0;

                    out.println("<h3 class=\"display-5 text-center\">Alright " + custName + "! Let's confirm your order </h3><BR>");
                    for (Pizza p : PizzaList)
                      {
                        double pizzaPrice = 0.0;
                        ResultSet sizeRS = SizeBL.displaySizebyId(p.getSize());
                        sizeRS.first();
                        out.println("<table border=\"2\" style=\"background-color:white\" class=\"table table-hover text-centered\"><thead><tr>");
                        out.println("<th colspan=\"2\">Order Confirmation</th><th>Price</th></tr></thead><tbody>");
                        out.println("<td>Size: </td>");
                        out.println("<td>" + sizeRS.getString("name") + "</td>");
                        out.println("<td> " + currencyFormat.format(sizeRS.getDouble("price")) + "</td></tr>");
                        pizzaPrice += sizeRS.getDouble("price");
                        ResultSet crustTypeRS = CrustTypeBL.displayCrustbyId(p.getCrustType());
                        crustTypeRS.first();
                        out.println("<tr><td>Crust Type: </td>");
                        out.println("<td>" + crustTypeRS.getString("name") + "</td>");
                        out.println("<td> " + currencyFormat.format(crustTypeRS.getDouble("price")) + "</td></tr>");
                        pizzaPrice += crustTypeRS.getDouble("price");
                        ResultSet toppingRS = ToppingBL.getToppingsbyPizzaId(p.getPizzaID());
                        toppingRS.first();
                        do
                          {
                            out.println("<tr><td>Toppings: </td>");
                            out.println("<td>" + toppingRS.getString("name") + "</td>");
                            String toppingprice = currencyFormat.format(toppingRS.getDouble("price"));
                            out.println("<td> " + toppingprice + "</td></tr>");
                            pizzaPrice += toppingRS.getDouble("price");
                          }
                        while (toppingRS.next());
                        out.println("<tr><td colspan=\"2\" class=\"text-right\"><b>Subtotal: </b></td>");
                        out.println("<td> " + currencyFormat.format(pizzaPrice) + "</td></tr>");
                        if (numPizzas > 1)
                          {
                            out.println("<tr><td colspan=\"2\" class=\"text-right\"><b>Subtotal for " + numPizzas + " Pizzas</b></td>");
                            pizzaPrice += pizzaPrice * numPizzas;
                            out.println("<td> " + currencyFormat.format(pizzaPrice) + "</td></tr>");
                          }
                        subtotal += pizzaPrice;
                        out.println("</table>");
                      }
                    out.println("<table border=\"2\" style=\"background-color:white\" class=\"table table-hover text-centered\">");
                    double total = subtotal * 1.15;
                    HttpSession sess = request.getSession();
                    sess.setAttribute("total", total);

                    out.println("<tr><td colspan=\"2\" class=\"text-right\"><b>Final Total: <b></td>");

                    out.println("<td> " + currencyFormat.format(total) + "</td></tr>");
                    out.println("</table>");

                %>

                <form action="pizzaorder.jsp">
                    <input type="submit" value="Add To Order" name="newPizza" />
                </form>

                <div class="col-md-3">
                    <form action="instore_proc" method="POST">
                        <input type="submit" value="Pickup Instore" name="PickupOrder" />
                    </form>
                    <form action="online_proc" method="POST">
                        <input type="submit" value="Pay for Order Online" name="OrderOnline" />
                    </form>
                </div>
            </div>

        </div>


        <footer class="footer" style="text-align: left;">
            <p style="background-color: rgb(255, 128, 64); color: rgb(255, 255, 255); text-align: left;">© Company 2017</p>
        </footer>
    </body>
</html>
