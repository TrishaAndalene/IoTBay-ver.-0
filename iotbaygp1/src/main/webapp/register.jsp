<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Company name - Sign Up</title>

    <!-- Style overloading -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">
    <script src="script.js"></script>
    
    <link rel="stylesheet" href="style.css">

</head>

<!-- later we need to delete the index.jsp -->

<body onload="continuePage(1)">

    <section class="register" id="page-1">
    
        <div class="left-1">
            <div class="left-content">
                <h1>SIGN UP</h1>

                <form action="" method="get" class="formTemplate">
                    <input type="email" name="emailLogin" id="emailLogin" placeholder="Email">
                    <input type="button" id="signInBtn" value="Sign Up" onclick="continuePage(2)">
                </form>

                <div class="line"><h4>_______</h4></div>
                <h3 id="alternativeLabel">Or sign up with</h3>

                <form action="" method="get" class="alternativeTemplate">
                    <input type="image" src="google.svg" alt="google">
                    <input type="image" src="apple.svg" alt="apple">
                    <input type="image" src="facebook.svg" alt="facebook">
                </form>
            </div>
        </div>
        <div class="right-1">
            <div class="right-content">
                <img src="companyLogo.png" alt="Company Logo">
                <h1>Company Name</h1>
                <br>
                <h3>Already have an account?</h3>
                <button><h4>Sign in</h4></button>
            </div>
        </div>
    </section>

    <section class="register" id="page-2">
    
        <div class="left-1">
            <div class="left-content">
                <h1>SIGN UP</h1>

                <form action="" method="get" class="formTemplate">
                    <label class="text-label" for="GivenName" id="first">Given name</label>
                    <input type="text" name="GivenName" id="GivenName">

                    <label class="text-label" for="Surname" id="second">Surname</label>
                    <input type="text" name="Surname" id="Surname">

                    <label class="text-label" for="MiddleName" id="last">Middle name</label>
                    <input type="text" name="MiddleName" id="MiddleName">

                    <input type="button" id="nextBtn" value="Continue" onclick="continuePage(3)">
                </form>

                <div class="line"><h4>_______</h4></div>
                <h3 id="alternativeLabel">Or sign up with</h3>

                <form action="" method="get" class="alternativeTemplate">
                    <input type="image" src="google.svg" alt="google">
                    <input type="image" src="apple.svg" alt="apple">
                    <input type="image" src="facebook.svg" alt="facebook">
                </form>

            </div>
        </div>
        <div class="right-1">
            <div class="right-content">
                <img src="companyLogo.png" alt="Company Logo">
                <h1>Company Name</h1>
                <br>
                <h3>Already have an account?</h3>
                <button><h4>Sign in</h4></button>
            </div>
        </div>
    </section>

    <section class="register" id="page-3">
    
        <div class="left-1">
            <div class="left-content">
                <h1>SIGN UP</h1>

                <form action="" method="get" class="formTemplate">
                    <label class="text-label" for="Username" id="first">Username</label>
                    <input type="text" name="Username" id="GivenName">

                    <label class="text-label" for="Password" id="second">Password</label>
                    <input type="password" name="Password" id="Password">

                    <label class="text-label" for="ConfirmPass" id="last">Confirm Password</label>
                    <input type="password" name="ConfirmPass" id="ConfirmPass">

                    <input type="button" id="nextBtn" value="Sign Up">
                </form>

                <div class="line"><h4>_______</h4></div>
                <h3 id="alternativeLabel">Or sign up with</h3>

                <form action="" method="get" class="alternativeTemplate">
                    <input type="image" src="google.svg" alt="google">
                    <input type="image" src="apple.svg" alt="apple">
                    <input type="image" src="facebook.svg" alt="facebook">
                </form>

            </div>
        </div>
        <div class="right-1">
            <div class="right-content">
                <img src="companyLogo.png" alt="Company Logo">
                <h1>Company Name</h1>
                <br>
                <h3>Already have an account?</h3>
                <button><h4>Sign in</h4></button>
            </div>
        </div>
    </section>
</body>
</html>
