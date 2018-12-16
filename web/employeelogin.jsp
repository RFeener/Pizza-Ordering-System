<%--
    Document   : employeelogin
    Created on : 26-Nov-2018, 8:05:22 PM
    Author     : School
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Login</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body style="background-color: rgb(255, 128, 64);">
        <div id="welcomepage" class="container-fluid row">
            <div class="col-md-3">

            </div>
            <div class="col-md-6">
                <div class="jumbotron align-center" style="background-color: rgb(255, 255, 255);">
                    <form name="employeelogin" action="portal_proc" method="POST">
                        <div class="form-group">
                            Username<input type="text" id="txtUsername" name="username" class="form-control"  /><BR>
                        </div>
                        <div class="form-group">
                            Password<input type="password" id="txtPassword" name="password" class="form-control"  /><BR>
                        </div>

                        <input type="submit" value="Enter Employee Portal" name="btnLogin" />
                    </form>
                </div>
            </div>
            <div class="col-md-3">
            </div>
        </div>
    </body>
</html>
