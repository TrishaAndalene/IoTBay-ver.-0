<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>

    <!-- Style overloading -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">

    
    <link href="css/Signup.css" rel="stylesheet" type="text/css">

</head>  

<body>
    <section class="register">
        <div class="left-1">
            <div class="left-content">
                <h1>SIGN UP</h1>

                <form action="CustomerRegisterServlet" class="formTemplate" id="form">
                    <input type="email" name="email" placeholder="Email">

                    <input type="text" name="firstName" placeholder="Given Name">
                    <input type="text" name="lastName" placeholder="Surname">
                    <input type="text" name="phoneNum" placeholder="Phone Number">
                    <input type="password" name="password" placeholder="Password">
                    <input type="submit" id="sign-up" value="Sign Up">
                </form>

                <div class="line"><h4>_______</h4></div>
                <h3 id="alternativeLabel">Or sign up with</h3>

                <form action="" method="get" class="alternativeTemplate">
                    <input type="image" src="img/google.svg" alt="google">
                    <input type="image" src="img/apple.svg" alt="apple">
                    <input type="image" src="img/facebook.svg" alt="facebook">
                </form>

            </div>
        </div>
        <div class="right-1">
            <div class="right-content">
                <img src="img/company_logo.png" alt="Company Logo">
                <h1 style="margin-left: 19vw;">IoTBay</h1>
                <br>
                <h3>Already have an account?</h3>
                <button><a href="/CustomerLogin.jsp"><h4>Sign in</h4></a></button>
            </div>
        </div>
    </section>

</body>
</html>