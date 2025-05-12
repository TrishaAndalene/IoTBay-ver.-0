<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IoTBay - Sign In</title>

    <!-- Style overloading -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">
    
    <link href="css/Signin.css" rel="stylesheet" type="text/css">

</head>

<!-- later we need to delete the index.jsp -->

<body>

    <section class="login">
        <div class="left-1">
            <div class="left-content">
                <img src="img/company_logo.png" alt="Company Logo">
                <h1>Log in to IoT Bay</h1>
                <br>
                <h3>Don't have an account yet?</h3>
                <button><a href="CustomerRegister.jsp"><h4>Sign up here!</h4></a></button>
            </div>
        </div>

        <div class="right-1">
            <div class="right-content">
                <h1>SIGN IN</h1>

                <form action="CustomerLoginServlet" method="post">
                    <input type="text" name="email" placeholder="Email">
                    <br>
                    <input type="password" name="password" placeholder="Password">
                    <br>
                    <input type="checkbox" name="rememberMe" id="rememberMe" value="Remember">
                    <label for="rememberMe">Remember me</label> <br>
                    <input type="submit" id="signInBtn" value="Sign In">
                </form>

                <!-- line only -->
                <div class="line"><h4>_______</h4></div>
                <h3 id="alternativeLabel">Or sign in with</h3>

                <form action="" method="get" class="alternativeTemplate">
                    <input type="image" src="img/google.svg" alt="google">
                    <input type="image" src="img/apple.svg" alt="apple">
                    <input type="image" src="img/facebook.svg" alt="facebook">
                </form>
                <br>
                <h4 id="alternativeLabel">Forget your password? <a href="#" id="alternativeLink">Click here</a></h4>
            </div>
        </div>
    </section>
</body>
</html>