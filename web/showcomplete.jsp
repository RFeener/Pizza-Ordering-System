
<%@page import="businessobjects.OrderBL"%>
<%@page import="businessobjects.Order"%>
<%@page import="businessobjects.ToppingBL"%>
<%@page import="businessobjects.Topping"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link type="text/css" id="dark-mode" rel="stylesheet" href="">
<style type="text/css" id="dark-mode-custom-style"></style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../../../favicon.ico">

<title>Completed Orders</title>
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

    <div class="container-fluid row">
        <div class="col-sm-2">
            <a href="empportal.jsp"><input type="button" value="Back"> </a>

        </div>
        <div class="col-sm-8" style="background-color: rgb(255, 255, 255);">
            <h3>Current Open Orders</h3>
            <table class="table table-hover" style="background-color: rgb(255, 255, 255);">
                <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>Total Price</th>
                        <th>Delivery Time</th>
                        <th>Placed Time</th>
                        <th>Customer ID</th>
                        <th>Order Status</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        ArrayList<Order> pendingList = OrderBL.getCompleteOrders();
                        for (Order o : pendingList)
                          {
                            out.println("<tr>");
                            out.println("<td>" + o.getOrderID() + "</td>");
                            out.println("<td>" + o.getTotalPrice() + "</td>");
                            out.println("<td>" + o.getDeliveryTime() + "</td>");
                            out.println("<td>" + o.getPlacedTime() + "</td>");
                            out.println("<td>" + o.getCustID() + "</td>");
                            out.println("<td>" + o.getOrderStatus() + "</td>");

                            out.println(" </tr>");

                          }

                    %>

                </tbody>
            </table>


        </div>
        <div class="col-sm-2"></div>
        <div></div>
    </div>




</body>
</html>
