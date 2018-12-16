<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Customer Information</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <!-- Bootstrap core CSS -->
    <link href="../../css/editor.css" rel="stylesheet">
    <link type="text/css" id="dark-mode" rel="stylesheet" href=""><style type="text/css" id="dark-mode-custom-style"></style>
    <!-- Custom styles for this template -->
    <link href="narrow-jumbotron.css" rel="stylesheet">
</head>

<body style="background-color: rgb(255, 128, 64);">
    <div id="CustomerInformation" class="container-fluid row">
        <div class="col-md-3">

        </div>
        <div class="col-md-6">



            <div class="jumbotron align-center" style="background-color: rgb(255, 255, 255);">
                <h3 class="text-center">Enter your Information</h3>
                <form name="CustomerDetail" action="Customer_proc" method="POST">
                    <div class="form-group">
                        First Name <input type="text" id="txtFirstName" name="firstName" class="form-control"  required/><BR>
                    </div>
                    <div class="form-group">
                        Last Name<input type="text" id="txtLastName" name="lastName" class="form-control" required/><BR></div>
                    <div class="form-group">
                        Email Address<input type="text" id="txtEmail" name="email" class="form-control" /><BR></div>
                    <div class="form-group">
                        Phone Number<input type="text" id="txtPhone" name="phone" class="form-control" required/><BR></div>
                    <div class="form-group">
                        Address<input type="text" id="txtAddress" name="address" class="form-control" required/><BR></div>
                    <div class="form-group">
                        Province<select name="province" id="province" class="form-control" >
                            <option> </option>
                            <option value="BC">British Columbia</option>
                            <option value="AB">Alberta</option>
                            <option value="SK">Saskatchewan</option>
                            <option value="MB">Manitoba</option>
                            <option value="ON">Ontario</option>
                            <option value="QC">Quebec</option>
                            <option value="NB">New Brunswick</option>
                            <option value="PE">Prince Edward Island</option>
                            <option value="NS">Nova Scotia</option>
                            <option value="NF">Newfoundland and Labrador</option>
                            <option value="NT">Northwest Territories</option>
                            <option value="NU">Nunavut</option>
                            <option value="YT">Yukon</option>
                        </select><BR></div>
                    <div class="form-group">
                        Postal Code<input type="text" id="txtPostal" name="postal" class="form-control"  /><BR></div>
                    <input type="submit" value="Order Pizza" name="submit" />
                </form>
            </div>
        </div>
        <div class="col-md-3">

        </div>
    </div>
    <footer class="footer">
        <p style="color: rgb(255, 255, 255);">© Company 2017</p>
    </footer>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>


</body>
</html>