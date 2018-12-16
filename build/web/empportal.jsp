
<%@page import="businessobjects.ToppingBL"%>
<%@page import="businessobjects.Topping"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link type="text/css" id="dark-mode" rel="stylesheet" href=""><style type="text/css" id="dark-mode-custom-style"></style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>Feener's Famous Pizza</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<!-- Bootstrap core CSS -->
<link href="../../css/editor.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="narrow-jumbotron.css" rel="stylesheet">
</head>

<body style="background-color: rgb(255, 128, 64);">
    <div id="welcomepage" class="container-fluid row">
        <div class="col-md-2">
            <h6>Add New Topping Below</h6>
            <form action="addtopping">
                <table>
                    <tr><td> <input type="text" name="name" value="" placeholder="Enter Topping Name: "/></td></tr>
                    <tr><td> <input type="text" name="price" value="" placeholder="Enter Price: "/></td></tr>
                    <tr><td>   <input type="submit" value="Submit Topping"></td></tr>
                </table> </form>
        </div>

        <div class="col-md-8" style="background-color: rgb(255, 255, 255);">
            <div style ="margin-left: 1%;">
                <div class="well well-lg">
                    <h5> Toppings currently set to active</h5>
                    <%                    ArrayList<Topping> AvailibleList = ToppingBL.getAvailibleToppings();
                        for (Topping t : AvailibleList)
                          {
                            out.println("<ul>");
                            out.println("<li>" + t.getName() + " ($" + t.getPrice() + ")</li>");
                            out.println("</ul>");
                          }
                    %>

                </div>

                <div >
                    <div>
                        <h5>Check toppings you wish to disable.(Checked Toppings are Disabled)</h5>
                        <form action="toppingchange_proc" method="POST">
                            <%
                                ArrayList<Topping> disableList = ToppingBL.getToppings();
                                for (Topping t : disableList)
                                  {
                                    int active = t.getIsActive();

                                    if (active == 0)
                                      {
                                        out.println("<BR><input class=\"form-check-input\" type=\"checkbox\" name=\"Topping\" id=\"Topping\" value=\"" + t.getToppingId() + "\" checked>" + t.getName() + " ($" + t.getPrice() + ")");
                                      }
                                    else
                                      {
                                        out.println("<BR><input class=\"form-check-input\" type=\"checkbox\" name=\"Topping\" id=\"Topping\" value=\"" + t.getToppingId() + "\">" + t.getName() + " ($" + t.getPrice() + ")");
                                      }

                                  }

                            %>
                            <BR><input type="submit" value="Assign Disabled Toppings">
                        </form>
                    </div><BR><BR>
                    <div>
                        <h5>Check toppings you wish to enable.(Checked Toppings are Enabled)</h5>
                        <form action="enableTopping_proc" method="POST">
                            <%                        ArrayList<Topping> enableList = ToppingBL.getToppings();
                                for (Topping t : enableList)
                                  {
                                    int active = t.getIsActive();
                                    if (active == 1)
                                      {
                                        out.println("<BR><input class=\"form-check-input\" type=\"checkbox\" name=\"Topping\" id=\"Topping\" value=\"" + t.getToppingId() + "\" checked>" + t.getName() + " ($" + t.getPrice() + ")");
                                      }
                                    else
                                      {
                                        out.println("<BR><input class=\"form-check-input\" type=\"checkbox\" name=\"Topping\" id=\"Topping\" value=\"" + t.getToppingId() + "\">" + t.getName() + " ($" + t.getPrice() + ")");
                                      }
                                  }

                            %>
                            <BR><input type="submit" value="Assign Enabled Toppings">
                        </form>
                        <BR><BR>
                    </div>
                </div>

            </div>
        </div>
        <div class="col-md-2">
            <form action="manageorders.jsp" method="POST">
                <input type="submit" value="Manage Orders">
            </form><BR>

            <form action="showcomplete.jsp" method="POST">
                <input type="submit" value="Completed Orders">
            </form><BR>

            <a href="index.jsp"><input type="button" value="Back"> </a>
        </div>

    </div>


</body>
</html>