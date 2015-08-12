<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login</title>

    <!-- Bootstrap Core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/css/sb-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="resources/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <script src="resources/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/js/bootstrap.min.js"></script>
    <style>
        body {
            background-image: url("resources/images/logo/backToSchool.jpg");
            -moz-background-size: cover;
            -webkit-background-size: cover;
            background-size: cover;
            background-position: top center !important;
            background-repeat: no-repeat !important;
            background-attachment: fixed;
        }
    </style>

</head>
<#--class="login-body"-->
<body>

<div class="row login-left-col">
    <div class="col-lg-9 text-center login-left-div"><#--
        <img class="img-rounded" src="resources/images/logo/pencil.png" alt=""><br>
        <a href="http://www.buet.ac.bd/?page_id=71" target="_blank" style="color: #ffffff">www.iscool.com</a>-->
    </div>
    <div class="col-lg-3 text-center">
        <div class="panel-body">
            <form name="loginform" action="auth/authenticateUser.cool" method="post">
                <marquee direction="right"><img class=" fa faa-shake animated" height="50px" width="50px"
                                                src="resources/images/logo/pencil.png" alt=""></marquee>
                <div class="form-group input-group">
                    <span class="input-group-addon">Username</span>
                    <input type="text" name="username" class="form-control" placeholder="Username">
                </div>
                <div class="form-group input-group">
                    <span class="input-group-addon">Password</span>
                    <input type="password" name="password" class="form-control" placeholder="Password">
                </div>
                <div class="form-group text-right">
                    <button type="reset" class="btn btn-primary">Reset</button>
                    <button type="submit" class="btn btn-success">Login</button>
                </div>

            </form>
        </div>
    </div>
    <#--<div class="col-lg-9 text-center login-left-div">
        <h1 class="page-header" style="color: white"></h1>
    </div>-->



<#--<div class="col-lg-1 text-center">

</div>-->
</div>


</body>

</html>
