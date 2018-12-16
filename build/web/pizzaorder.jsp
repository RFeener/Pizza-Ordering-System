
<%@page import="businessobjects.Topping"%>
<%@page import="businessobjects.Size"%>
<%@page import="businessobjects.CrustType"%>
<%@page import="businessobjects.OrderBL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="businessobjects.Pizza"%>
<%@page import="businessobjects.PizzaBL"%>
<%@page import="businessobjects.ToppingBL"%>
<%@page import="businessobjects.CrustTypeBL"%>
<%@page import="databeans.CrustTypeDL"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="businessobjects.SizeBL"%>
<%@page import="javax.ejb.EJB"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Pizza Ordering</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
    </head>

    <body style="background-color: rgb(255, 128, 64);">
        <div id="welcomepage" class="container-fluid row">
            <div class="col-md-2">

            </div>
            <div class="col-md-8">

                <%
                    int orderID = (Integer) session.getAttribute("orderID");
                    String custName = OrderBL.getCustNameByOrderId(orderID);
                    out.println(" <h3 class=\"display-5 text-center\"> Hey " + custName + ", Lets make your Pizza!</h3>");

                %>
                <BR><form action="PO_proc" method="POST">

                    <div class="form-group">
                        <div class="d-flex justify-content-center" style=" padding-left: 10%; " ><BR>
                            <table border="2" style="background-color:white;" class="table table-hover text-centered" >
                                <tr>
                                    <td>

                                        <label class="form-check-label text-center"><b> Size</b><BR></label>
                                            <%                                                ArrayList<Size> SizeAL = SizeBL.getSizes();

                                                for (Size s : SizeAL)
                                                  {
                                                    out.println("<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class=\"form-check-input\" type=\"radio\" name=\"Size\" id=\"Size\" value=\"" + s.getSizeid() + "\" required>" + s.getName() + "\" (" + s.getPrice() + ")");
                                                  }

                                            %>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label class="form-check-label text-center"><b> Crust Type</b><BR> </label>
                                            <%                                                ArrayList<CrustType> CrustAL = CrustTypeBL.getCrustTypes();
                                                for (CrustType ct : CrustAL)
                                                  {
                                                    out.println("<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class=\"form-check-input\" type=\"radio\" name=\"Crust\" id=\"Crust\" value=\"" + ct.getCrustTypeId() + "\" required>" + ct.getName());

                                                  }
                                            %>

                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label class="form-check-label text-center"><b> Topping</b><BR></label>
                                            <%
                                                ArrayList<Topping> toppingAL = ToppingBL.getAvailibleToppings();
                                                for (Topping t : toppingAL)
                                                  {
                                                    out.println("<BR>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class=\"form-check-input\" type=\"checkbox\" name=\"Topping\" id=\"Topping\" value=\"" + t.getToppingId() + "\">" + t.getName() + " ($" + t.getPrice() + ")");
                                                  }

                                            %>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label class="form-check-label text-center"><b> How Many Pizzas?</b><BR></label>

                                        <BR>&nbsp;&nbsp;&nbsp;<input type="radio" name="numPizzas" value="1" checked="checked" />1
                                        <BR>&nbsp;&nbsp;&nbsp;<input type="radio" name="numPizzas" value="2" />2
                                        <BR>&nbsp;&nbsp;&nbsp;<input type="radio" name="numPizzas" value="3" />3
                                        <BR>&nbsp;&nbsp;&nbsp;<input type="radio" name="numPizzas" value="4" />4
                                        <BR>&nbsp;&nbsp;&nbsp;<input type="radio" name="numPizzas" value="5" />5
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-warning">Order My Pizza!</button>
                </form><BR><BR><BR>

            </div><div class="col-md-4">

            </div>
        </div>


    </body>

</html>
