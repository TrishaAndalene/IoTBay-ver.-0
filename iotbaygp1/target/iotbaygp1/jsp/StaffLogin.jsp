<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IoT Bay - Staff Login</title>

    <!-- Style overloading -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">
    
    <link rel="stylesheet" href="../css/Stafflogin.css">

</head>

<body>
    <section class="login">
        <div class="left-1">
            <div class="left-content">
                <img src="../img/company_logo.png" alt="Company Logo">
                <h1>IoTBay - Staff Log In</h1>
            </div>
        </div>

        <div class="right-1">
            <div class="right-content">
                <h1>SIGN IN</h1>

                <form action="StaffLanding.jsp" method="post">
                    <input type="text" name="email" placeholder="Staff Email">
                    <br>
                    <input type="password" name="password" placeholder="Password">
                    <br>
                    <input type="submit" id="signInBtn" value="Sign In">
                </form>
                

                <br>
                <h4 id="alternativeLabel">Forget your password? <a href="#" id="alternativeLink">Click here</a></h4>
            </div>
        </div>
    </section>
</body>
</html>