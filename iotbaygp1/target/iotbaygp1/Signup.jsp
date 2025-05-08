<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IoTBay - Sign Up</title>

    <!-- Style overloading -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">
    <script src="js/signup_script.js"></script>
    
    <link href="css/Signup.css" rel="stylesheet" type="text/css">

</head>  

<body onload="continuePage(1)">

    <section class="register">
        <div class="left-1">
            <div class="left-content">
                <h1>SIGN UP</h1>

                <form action="Welcome.jsp" class="formTemplate" id="form1">
                    <input type="email" name="emailLogin" id="emailLogin" class="formOne" placeholder="Email">
                    <input type="button" id="signInBtn" value="Sign Up" class="formOne" onclick="continuePage(2)">

                    <input type="text" name="GivenName" id="GivenName" placeholder="Given Name">

                    <input type="text" name="Surname" id="Surname" placeholder="Surname">

                    <input type="button" id="nextBtn" value="Continue" class="formTwo" onclick="continuePage(3)">

                    <input type="text" name="PhoneNumber" id="PhoneNumber" class="formThree" placeholder="Phone Number">

                    <input type="password" name="Password" id="Password" class="formThree" placeholder="Password">
                    
                    <input type="password" name="ConfirmPass" id="ConfirmPass" class="formThree" placeholder="Confirm Password">

                    <input type="submit" id="nextBtn" value="Sign Up" class="formThree">

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
                <button><a href="Login.jsp"><h4>Sign in</h4></a></button>
            </div>
        </div>
    </section>

    <!-- <section class="register" id="page-1">
    
        <div class="left-1">
            <div class="left-content">
                <h1>SIGN UP</h1>

                <form class="formTemplate">
                    <input type="email" name="emailLogin" id="emailLogin" placeholder="Email">
                    <input type="button" id="signInBtn" value="Sign Up" onclick="continuePage(2)">
                </form>

                <div class="line"><h4>_______</h4></div>
                <h3 id="alternativeLabel">Or sign up with</h3>

                <form action="" method="get" class="alternativeTemplate">
                    <input type="image" src="http://localhost:8080/webapp/img/google.svg" alt="google">
                    <input type="image" src="http://localhost:8080/webapp/img/apple.svg" alt="apple">
                    <input type="image" src="http://localhost:8080/webapp/img/facebook.svg" alt="facebook">
                </form>
            </div>
        </div>
        <div class="right-1">
            <div class="right-content">
                <img src="http://localhost:8080/webapp/img/company_logo.png" alt="Company Logo">
                <h1>IoTBay</h1>
                <br>
                <h3>Already have an account?</h3>
                <button><a href="http://localhost:8080/webapp/jsp/Login.jsp"><h4>Sign in</h4></a></button>
            </div>
        </div>
    </section>

    <section class="register" id="page-2">
    
        <div class="left-1">
            <div class="left-content">
                <h1>SIGN UP</h1>

                <form class="formTemplate">
                    <label class="text-label" for="GivenName" id="first">Given name</label>
                    <input type="text" name="GivenName" id="GivenName">

                    <label class="text-label" for="Surname" id="second">Surname</label>
                    <input type="text" name="Surname" id="Surname">

                    <input type="button" id="nextBtn" value="Continue" onclick="continuePage(3)">
                </form>

                <div class="line"><h4>_______</h4></div>
                <h3 id="alternativeLabel">Or sign up with</h3>

                <form action="" method="get" class="alternativeTemplate">
                    <input type="image" src="http://localhost:8080/webapp/img/google.svg" alt="google">
                    <input type="image" src="http://localhost:8080/webapp/img/apple.svg" alt="apple">
                    <input type="image" src="http://localhost:8080/webapp/img/facebook.svg" alt="facebook">
                </form>

            </div>
        </div>
        <div class="right-1">
            <div class="right-content">
                <img src="http://localhost:8080/webapp/img/company_logo.png" alt="Company Logo">
                <h1>IoTBay</h1>
                <br>
                <h3>Already have an account?</h3>
                <button><a href="http://localhost:8080/webapp/jsp/Login.jsp"><h4>Sign in</h4></a></button>
            </div>
        </div>
    </section>

    <section class="register" id="page-3">
    
        <div class="left-1">
            <div class="left-content">
                <h1>SIGN UP</h1>

                <form action="Welcome.jsp" method="post" class="formTemplate">

                    <input type="text" name="GivenNameCon" style="display:none" id="GivenNameCon">

                    <% 
                    System.out.println("----------------------");
                    System.out.println(request.getParameter("GivenName"));
                    %>

                    <input type="text" name="SurnameCon" style="display:none" id="SurnameCon">
                    <input type="email" name="EmailCon" style="display:none" id="EmailCon">

                    <label class="text-label" for="PhoneNumber" id="first">Phone Number</label>
                    <input type="text" name="PhoneNumber" id="PhoneNumber">

                    <label class="text-label" for="Password" id="second">Password</label>
                    <input type="password" name="Password" id="Password">

                    <label class="text-label" for="ConfirmPass" id="last">Confirm Password</label>
                    <input type="password" name="ConfirmPass" id="ConfirmPass">

                    <input type="submit" id="nextBtn" value="Sign Up">
                </form>

                <div class="line"><h4>_______</h4></div>
                <h3 id="alternativeLabel">Or sign up with</h3>

                <form action="" method="get" class="alternativeTemplate">
                    <input type="image" src="http://localhost:8080/webapp/img/google.svg" alt="google">
                    <input type="image" src="http://localhost:8080/webapp/img/apple.svg" alt="apple">
                    <input type="image" src="http://localhost:8080/webapp/img/facebook.svg" alt="facebook">
                </form>

            </div>
        </div>
        <div class="right-1">
            <div class="right-content">
                <img src="http://localhost:8080/webapp/img/company_logo.png" alt="Company Logo">
                <h1>IoTBay</h1>
                <br>
                <h3>Already have an account?</h3>
                <button><a href="http://localhost:8080/webapp/jsp/Login.jsp"><h4>Sign in</h4></a></button>
            </div>
        </div>
    </section> -->
    <!-- Container only form -->
     <!-- <form action="Welcome.jsp" style="display: none">
        <input type="text" name="GivenNameCon" value=<% request.getParameter("GivenName"); %>>
        <input type="text" name="SurnameCon" value=<% request.getParameter("Surname"); %>>
        <input type="email" name="EmailCon" value=<% request.getParameter("emailLogin"); %>>
        <input type="text" name="PhoneNumberCon" value=<% request.getParameter("PhoneNumber"); %>>
        <input type="password" name="PassCon" value=<% request.getParameter("Password"); %>>
     </form> -->
</body>
</html>